/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0106Event.java
*@FileTitle : (KOR) DOD Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2016-03-17
*@LastModifier : songji
*@LastVersion : 1.0
* 2016-03-17 songji
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODTariffVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0106Event PDTO(Data Transfer Object including Parameters)<br>
 * @author songji
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0106Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String sessionOfcCd = "";
	
	private String selPolContiCd = null;
	private String selPolCntCd = null;
	private String selEffDt = null;
	
	private String newEffDt = null;

	private String ctrlOfcCd = null;
    

	private String ctrlUsrId = null;
    
    private String selCntrTpszCd = null;
	
    public String getSessionOfcCd() {
		return sessionOfcCd;
	}

	public void setSessionOfcCd(String sessionOfcCd) {
		this.sessionOfcCd = sessionOfcCd;
	}
	
	public String getSelCntrTpszCd() {
		return selCntrTpszCd;
	}

	public void setSelCntrTpszCd(String selCntrTpszCd) {
		this.selCntrTpszCd = selCntrTpszCd;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DODTariffVO dODTariffVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DODTariffVO[] dODTariffVOs = null;

	public EsdEas0106Event(){}

	public String getSelPolCntCd() {
		return selPolCntCd;
	}
	public void setSelPolCntCd(String selPolCntCd) {
		this.selPolCntCd = selPolCntCd;
	}
	
	public String getSelPolContiCd() {
		return selPolContiCd;
	}
	public void setSelPolContiCd(String selPolContiCd) {
		this.selPolContiCd = selPolContiCd;
	}

    public String getSelEffDt() {
		return selEffDt;
	}
	public void setSelEffDt(String selEffDt) {
		this.selEffDt = selEffDt;
	}
	
 	public String getNewEffDt() {
		return newEffDt;
	}


	public void setNewEffDt(String newEffDt) {
		this.newEffDt = newEffDt;
	}


	public String getCtrlOfcCd() {
		return ctrlOfcCd;
	}


	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}


	public String getCtrlUsrId() {
		return ctrlUsrId;
	}


	public void setCtrlUsrId(String ctrlUsrId) {
		this.ctrlUsrId = ctrlUsrId;
	}


	public DODTariffVO getDODTariffVO() {
		return dODTariffVO;
	}

	public void setDODTariffVO(DODTariffVO dODTariffVO) {
		this.dODTariffVO = dODTariffVO;
	}

	public DODTariffVO[] getDODTariffVOs() {
		DODTariffVO[] rtnVOs = null;
		if (this.dODTariffVOs != null) {
			rtnVOs = new DODTariffVO[dODTariffVOs.length];
			System.arraycopy(dODTariffVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setDODTariffVOs(DODTariffVO[] dODTariffVOs){
		if(dODTariffVOs != null){
			DODTariffVO[] tmpVOs = new DODTariffVO[dODTariffVOs.length];
			System.arraycopy(dODTariffVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dODTariffVOs = tmpVOs;
		}
	}

}
