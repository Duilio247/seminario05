import React from 'react'
import {MostrarFormularioMateriales} from "../components"
import { GenerarPDF } from '../components/GenerarPDF'
import { Historial } from '../components/Historial'

export const PaginaFormularioMateriales = () => {
  return (
    <>
    <div className='text-3xl text-center my-6'>PaginaFormularioMateriales</div>

    <div className='flex flex-col mx-30'>

      <MostrarFormularioMateriales/>
      <GenerarPDF/>
      <Historial/>


    </div>

    </>
    
  )
}
