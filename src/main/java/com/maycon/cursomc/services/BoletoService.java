package com.maycon.cursomc.services;

import com.maycon.cursomc.domain.Pagamento;
import com.maycon.cursomc.domain.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instant) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(instant);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        pagto.setDataVencimento(cal.getTime());
    }
}
