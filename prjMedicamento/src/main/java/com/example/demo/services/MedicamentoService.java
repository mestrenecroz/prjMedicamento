package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Medicamento;
import com.example.demo.repositories.MedicamentoRepository;

@Service
public class MedicamentoService {
   
   private final MedicamentoRepository medicamentoRepository;
   
   
   @Autowired
   public MedicamentoService(MedicamentoRepository medicamentoRepository) {
    this.medicamentoRepository = medicamentoRepository;
   }
   
   public Medicamento salvarMedicamento(Medicamento medicamento) {
       return medicamentoRepository.save(medicamento);
       
   }
   
   public Medicamento consultarMedicamentoPorId(Long id) {
       return medicamentoRepository.findById(id).orElse(null);
   }
   
   public List<Medicamento> consultarTodosMedicamento(){
       return medicamentoRepository.findAll();
   }
   
   public void excluirMedicamento(Long id) {
       medicamentoRepository.deleteById(id);
   }
   public Medicamento atualizarMedicamento(Long id, Medicamento medicamentoAtualizado) {
       Optional<Medicamento> medicamentoExistente = medicamentoRepository.findById(id);
       if(medicamentoExistente.isPresent()) {
           Medicamento medicamento = medicamentoExistente.get();
           medicamento.setNome(medicamentoAtualizado.getNome());
           medicamento.setBula(medicamentoAtualizado.getBula());
           medicamento.setidFornecedor(medicamentoAtualizado.getidFornecedor());
           medicamento.setdataValidade(medicamentoAtualizado.getdataValidade());
           return medicamentoRepository.save(medicamento);
       }
       else
       {
           return null;
       }
   }
}