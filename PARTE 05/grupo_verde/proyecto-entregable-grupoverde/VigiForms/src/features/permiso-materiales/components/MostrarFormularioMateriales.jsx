import React, { useEffect } from "react";
import { useForm } from "react-hook-form";
import { postFormData } from "../../../shared/services";
import { Toaster, toast } from "sonner";
import { useIdContext } from "../../../context/IdContext";

export const MostrarFormularioMateriales = () => {
  const URLAPI = "https://formbackend-ndvy.onrender.com/api/permisos-materiales";

  const {
    register,
    handleSubmit,
    setValue,
    formState: { isSubmitting, errors },
    trigger,
  } = useForm();

  const onSubmit = async (data) => {
    const isValid = await trigger();
    if (!isValid) {
      Object.entries(errors).forEach(([fieldName, error]) => {
        toast.error(`${fieldName}: ${error.message}`);
      });
      return;
    }

    try {
      const promise = postFormData(data, URLAPI);
      toast.promise(promise, {
        loading: "Enviando formulario...",
        success: (response) => response.message || "Formulario enviado exitosamente",
        error: (error) =>
          error.response?.data?.message ||
          error.message ||
          "Error al enviar el formulario",
      });
      await promise;
    } catch (error) {
      console.error("Error en el catch:", error);
      toast.error(`Error inesperado: ${error.message}`);
    }
  };

  const { idEncargado } = useIdContext();

  useEffect(() => {
    if (idEncargado) {
      setValue("encargadoId", idEncargado);
    }
  }, [idEncargado, setValue]);

  return (
    <>
      <form
        className="max-w-2xl w-full mx-auto p-4 md:p-6 lg:p-8 bg-white shadow-md rounded"
        onSubmit={handleSubmit(onSubmit)}
      >
        <h1>Se autoriza:</h1>

        <div className="flex flex-col space-y-4">
          {/* Seleccionar motivo */}
          <div>
            <label htmlFor="seleccionar" className="font-semibold block mb-1">
              Seleccionar
            </label>
            <select
              id="seleccionar"
              className="border border-gray-300 rounded px-3 py-2 w-full"
              {...register("selec", { required: "Este campo es requerido" })}
            >
              
              <option value="Ingreso">Ingreso</option>
              <option value="Salida">Salida</option>
            </select>
            {errors.selec && (
              <span className="text-red-500 text-sm">{errors.selec.message}</span>
            )}
          </div>

          {/* Detalles */}
          <div>
            <label htmlFor="detalles" className="font-semibold block mb-1">
              Detalles
            </label>
            <textarea
              id="detalles"
              className="border border-gray-300 rounded px-3 py-2 w-full h-28 resize-none"
              placeholder="Ingresa detalles..."
              {...register("detalles", { required: "Este campo es requerido" })}
            />
            {errors.detalles && (
              <span className="text-red-500 text-sm">{errors.detalles.message}</span>
            )}
          </div>

          {/* Instructor */}
          <div>
            <label htmlFor="instructor" className="font-semibold block mb-1">
              Instructor
            </label>
            <input
              type="text"
              id="instructor"
              placeholder="Ingresa instructor..."
              className="border border-gray-300 rounded px-3 py-2 w-full"
              {...register("instructor", { required: "Este campo es requerido" })}
            />
            {errors.instructor && (
              <span className="text-red-500 text-sm">{errors.instructor.message}</span>
            )}
          </div>

          {/* Participante */}
          <div>
            <label htmlFor="participante" className="font-semibold block mb-1">
              Aprendiz/Participante
            </label>
            <input
              type="text"
              id="participante"
              placeholder="Ingresa aprendiz/participante..."
              className="border border-gray-300 rounded px-3 py-2 w-full"
              {...register("participante", { required: "Este campo es requerido" })}
            />
            {errors.participante && (
              <span className="text-red-500 text-sm">{errors.participante.message}</span>
            )}
          </div>

          {/* Señor */}
          <div>
            <label htmlFor="senor" className="font-semibold block mb-1">
              Señor
            </label>
            <input
              type="text"
              id="senor"
              placeholder="Ingresa señor..."
              className="border border-gray-300 rounded px-3 py-2 w-full"
              {...register("senor", { required: "Este campo es requerido" })}
            />
            {errors.senor && (
              <span className="text-red-500 text-sm">{errors.senor.message}</span>
            )}
          </div>

          {/* Campo oculto encargado */}
          <input type="hidden" {...register("encargadoId")} />
          <div>
            <label htmlFor="encargadoId" className="font-semibold block mb-1">
              Encargado ID
            </label>
            <p className="border px-3 py-2 rounded bg-gray-100 border-gray-300 text-sm">
              {idEncargado || "Cargando..."}
            </p>
            {errors.encargadoId && (
              <span className="text-red-500 text-sm">{errors.encargadoId.message}</span>
            )}
          </div>

          <div className="flex justify-center">
            <button
              type="submit"
              disabled={isSubmitting}
              className="rounded bg-blue-600 hover:bg-blue-700 text-white px-6 py-2 font-semibold shadow-md w-full sm:w-auto"
            >
              {isSubmitting ? "Enviando..." : "Registrar"}
            </button>
          </div>
        </div>
      </form>
      <Toaster />
    </>
  );
};
