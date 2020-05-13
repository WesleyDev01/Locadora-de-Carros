import { http } from './config'

export default{
    cadastrarCliente:(cliente)=>{
        return http.post('cliente', cliente)
    }
}   