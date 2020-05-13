import { http } from './config'

export default{
    efetuarAluguel:(aluguel)=>{
        return http.post('aluguel', aluguel)
    }
}    