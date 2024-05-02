package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

import com.hanjin.framework.support.view.signon.SignOnUserAccount;

public class TariffValueMgtGRPVO {
	private YardChargeVO[] yardChargeVOs = null;
	private YdChgObjVO[] ydChgObjVOs = null;
	private SignOnUserAccount account = null;
	
	public TariffValueMgtGRPVO(){}

	/**
	 * @return the yardChargeVOs
	 */
	public YardChargeVO[] getYardChargeVOs() {
		return yardChargeVOs;
	}

	/**
	 * @param yardChargeVOs the yardChargeVOs to set
	 */
	public void setYardChargeVOs(YardChargeVO[] yardChargeVOs) {
		this.yardChargeVOs = yardChargeVOs;
	}

	/**
	 * @return the ydChgObjVOs
	 */
	public YdChgObjVO[] getYdChgObjVOs() {
		return ydChgObjVOs;
	}

	/**
	 * @param ydChgObjVOs the ydChgObjVOs to set
	 */
	public void setYdChgObjVOs(YdChgObjVO[] ydChgObjVOs) {
		this.ydChgObjVOs = ydChgObjVOs;
	}

	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

}
