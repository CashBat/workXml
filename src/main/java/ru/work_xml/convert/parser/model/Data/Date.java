package main.java.ru.work_xml.convert.parser.model.Data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Date {

	@XmlElement
	private Account acc;
	@XmlElement
	private Fio fio;
	@XmlElement
	private Address adr;
	@XmlElement
	private List<Counter> coun;
	@XmlElement
	private List<Sum> sum;

	public Date() {

	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public Fio getFio() {
		return fio;
	}

	public void setFio(Fio fio) {
		this.fio = fio;
	}

	public Address getAdr() {
		return adr;
	}

	public void setAdr(Address adr) {
		this.adr = adr;
	}

	public List<Counter> getCoun() {

		if (coun == null) {
			coun = new ArrayList<>();
		}
		return coun;

	}

	public List<Sum> getSum() {

		if (sum == null) {
			sum = new ArrayList<>();
		}
		return sum;
	}

}
