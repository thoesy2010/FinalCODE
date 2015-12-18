package ch.makery.address.model;

import domain.RateDomainModel;
import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;

public class Rate extends RateDomainModel {

	double pmt;
	double r, n, p, y;
	double f = 0;
	// r - rate
	// n - num of periods
	// y - pmt per period
	// p - future value
	// t - type (true=pmt at end of period, false=pmt at begining of period)

	public double getPayment(int NumberOfPayments) {
		// FinalExam
		// Normally this kind of method would be in a BLL, but alas...

		// Figure out payment based on:
		// Interest rate
		// PV
		// FV (make FV = 0, unless you want a balloon payment
		// Compounding = True
		// Number of Payments (passed in)
		n = NumberOfPayments;
		p = FinanceLib.pv(r, n, y, f, false);

		pmt = FinanceLib.pmt(r, n, p, f, false);

		return pmt;
	}

	public double getMortgage(int income, int expense) {
		double mortgage = income * 0.36;
		if (mortgage >= (income + expense) * 0.28) {
			mortgage = (income + expense) * 0.28;
		}

		return mortgage;
	}

}
