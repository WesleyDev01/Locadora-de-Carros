import { http } from './config'

export default{
    listar:() => {
        return http.get('carros')
    },

    cadastrarCarro:(carro)=>{
        return http.post('carro', carro)
    }
}   