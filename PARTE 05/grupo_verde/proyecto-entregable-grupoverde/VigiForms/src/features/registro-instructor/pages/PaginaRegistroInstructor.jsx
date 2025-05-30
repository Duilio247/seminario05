import React from 'react'
import {MostrarRegistroInstructor, HistorialDocentes} from '../components'


export const PaginaRegistroInstructor = () => {
  return (
    <>
        <div className='text-3xl text-center my-6'>Pagina registro Instructor</div>

      <div className='flex flex-col mx-30'>
        <HistorialDocentes/>
        <MostrarRegistroInstructor/>
        
      </div>

    </>
  )
}