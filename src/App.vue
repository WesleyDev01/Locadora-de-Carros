<template>
  <div id="app">

   <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo center">Locadora de Carros</a>
      <ul id="nav-mobile" class="left hide-on-med-and-down">
      </ul>
    </div>
  </nav>
   
    <div class="container">

    <h3>Cadastrar Cliente:</h3>

      <form @submit.prevent="cadastrarCliente">

          <label>CPF</label>
          <input type="text" placeholder="CPF">
          <label>Nome</label>
          <input type="text" placeholder="Nome">
          <label>Endereco</label>
          <input type="text" placeholder="Endereço">

          <button id="botao" class="waves-effect waves-light btn-small">Cadastrar<i class="material-icons left">person_add</i></button>

      </form>

      <h3>Cadastrar Carro:</h3>

      <form @submit.prevent="cadastrarCarro">

          <label>Modelo</label>
          <input type="text" placeholder="Modelo">
          <label>Marca</label>
          <input type="text" placeholder="Marca">
          <label>Valor da diaria</label>
          <input type="text" placeholder="Diaria">
          <label>Placa</label>
          <input type="text" placeholder="Placa">


          <button id="botao" class="waves-effect waves-light btn-small">Cadastrar<i class="material-icons left">directions_car</i></button>

      </form>

      <h3>Efetuar Aluguel:</h3>

      <form @submit.prevent="efetuarAluguel">

          <label>Cpf do Cliente</label>
          <input type="text" placeholder="CPF">
          <label>Data do inicio do aluguel</label>
          <input type="text" placeholder="Data inicial">
          <label>Data do fim do aluguel</label>
          <input type="text" placeholder="Data final">
          <label>Valor final</label>
          <input disabled="disabled" type="text" placeholder="Valor final">

          <button id="botao" class="waves-effect waves-light btn-small">Efetuar<i class="material-icons left">attach_money</i></button>

      </form>

      <h3 id="titulo">Veja nossos carros:</h3>

      <table>

        <thead>

          <tr>
            <th>MARCA</th>
            <th>MODELO</th>
            <th>PLACA</th>
            <th>VALOR DA DIARIA</th>
          </tr>

        </thead>

        <tbody>

          <tr v-for="carro of carros" :key="carro.iid">

            <td>{{ carro.marca }}</td>
            <td>{{ carro.modelo }}</td>
            <td>{{ carro.placa }}</td>
            <td>{{ carro.valorDiaria }}</td>
            <td>
              <button class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>

import Carro from './services/carros'
import Cliente from './services/clientes'
import Aluguel from './services/alugueis'

export default{

    data(){
      return{
        carro: {
          id: "",
          marca: "",
          modelo: "",
          placa: "",
          valorDiaria: "",
          aluguel: ""
        },
        carros: []
      }
    },

    mounted(){
      Carro.listar().then(resposta =>{
        console.log(resposta.data);
        this.carros = resposta.data;
      })
    },

    methods:{
      cadastrarCarro(){
        Carro.cadastrarCarro(this.carro).then(resposta=>{
          this.resposta = resposta;
        })
      },
      cadastrarCliente(){
        Cliente.cadastrarCliente(this.cliente).then(resposta=>{
          this.resposta = resposta;
        })
      },
      efetuarAluguel(){
        Aluguel.efetuarAluguel(this.aluguel).then(resposta=>{
          this.resposta = resposta;
        })
      }
    }
}

</script>

<style>
h3{
  text-align: center;
}

body{
  color: #e35714;
}

#botao{
  border-radius: 15px;
}
</style>
