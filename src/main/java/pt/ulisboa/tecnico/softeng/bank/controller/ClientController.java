package pt.ulisboa.tecnico.softeng.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.ulisboa.tecnico.softeng.bank.domain.Bank;
import pt.ulisboa.tecnico.softeng.bank.domain.Client;
import pt.ulisboa.tecnico.softeng.bank.dto.ClientDto;
import pt.ulisboa.tecnico.softeng.bank.dto.BankDto;

import pt.ulisboa.tecnico.softeng.bank.exception.BankException;


@Controller
@RequestMapping(value = "/banks/bank/{code}/clients")
public class ClientController {

    private static Logger logger = LoggerFactory.getLogger(ClientController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String clientForm(Model model, @PathVariable String code) {
        logger.info("clientForm");

        Bank bank = Bank.getBankByCode(code);
        ClientDto client = new ClientDto();

        model.addAttribute("client", client);
        model.addAttribute("clients", bank.getClients());
        model.addAttribute("bank", bank);
        model.addAttribute("banks", Bank.banks);
        return "clientView";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String clientSubmit(Model model, @PathVariable String code, @ModelAttribute ClientDto clientDto, @ModelAttribute BankDto bankDto) {
        logger.info("clientSubmit name:{}, age:{}", clientDto.getName(), clientDto.getAge());

        Bank bank = Bank.getBankByCode(code);

        try {
            new Client(bank, code, clientDto.getName(), clientDto.getAge());
        } catch (BankException be) {
            model.addAttribute("error", "Error: it was not possible to create the bank");
            model.addAttribute("bank", bankDto);
            model.addAttribute("banks", Bank.banks);
            return "banksView";
        }

        return "redirect:/banks/bank/"+code+"/clients";
    }

    @RequestMapping(value = "/bank/{code}", method = RequestMethod.GET)
    public String showBank(Model model, @PathVariable String code) {
        logger.info("showBank code:{}", code);

        Bank bank = Bank.getBankByCode(code);

        new Client(bank, "ID01", "Zé", "22");
        new Client(bank, "ID02", "Manel", "44");

        model.addAttribute("bank", bank);
        return "bankView";
    }



}
