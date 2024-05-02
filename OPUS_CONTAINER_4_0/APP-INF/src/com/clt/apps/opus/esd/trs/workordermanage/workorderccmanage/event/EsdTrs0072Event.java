/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0072Event.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 정상기
*@LastVersion : 1.1
* 2007.04.05 정상기
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.12.14  최 선	1.1 [CHM-201007747] W/O CC 상 오류 수정요청
========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.vo.TrsTrspWrkOrdCcEmlVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.vo.TrsTrspWrkOrdCcFaxVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspWrkOrdCcVO;

/**
 * ESD_TRS_0072 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0072HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CheongSangKi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0072Event extends EventSupport {

	/** trs_trsp_wrk_ord_cc Table  Value Object */
	private TrsTrspWrkOrdCcVO 			trsTrspWrkOrdCc 		= null;

	/** trs_trsp_wrk_ord_ccs Multi Action을 위한 Collection */
	private TrsTrspWrkOrdCcVO[]			trsTrspWrkOrdCcs 		= null;

	/** trs_trsp_wrk_ord_cc_fax Table  Value Object */
	private TrsTrspWrkOrdCcFaxVO 		trsTrspWrkOrdCcFax 		= null;

	/** trs_trsp_wrk_ord_cc_faxs Multi Action을 위한 Collection */
	private TrsTrspWrkOrdCcFaxVO[] 		trsTrspWrkOrdCcFaxs 	= null;
	
	/** trs_trsp_wrk_ord_cc_eml Table  Value Object */
	private TrsTrspWrkOrdCcEmlVO 		trsTrspWrkOrdCcEml 	= null;

	/** trs_trsp_wrk_ord_cc_emls Multi Action을 위한 Collection */
	private TrsTrspWrkOrdCcEmlVO[] 		trsTrspWrkOrdCcEmls 	= null;
	
	private String comboSvcProvider			= "";	
	private String controlOfficeCd		= "";
	private String locationCd			= "";
	private String faxEmailIndicator 	= "";
	private String selectedVndrSeq 		= "";
	private String selectedCtrlOfcCd 	= "";
	private String selectedLocCd 		= "";
	private String loginUserOfcCd 		= "";
	private String loginUserId  		= "";

	public EsdTrs0072Event(){}

	/**
	 * @return the trsTrspWrkOrdCc
	 */
	public TrsTrspWrkOrdCcVO getTrsTrspWrkOrdCc() {
		return trsTrspWrkOrdCc;
	}

	/**
	 * @param trsTrspWrkOrdCc the trsTrspWrkOrdCc to set
	 */
	public void setTrsTrspWrkOrdCc(TrsTrspWrkOrdCcVO trsTrspWrkOrdCc) {
		this.trsTrspWrkOrdCc = trsTrspWrkOrdCc;
	}

	/**
	 * @return the trsTrspWrkOrdCcs
	 */
	public TrsTrspWrkOrdCcVO[] getTrsTrspWrkOrdCcs() {
		TrsTrspWrkOrdCcVO[] rtnVOs = null;
		if (this.trsTrspWrkOrdCcs != null) {
			rtnVOs = Arrays.copyOf(this.trsTrspWrkOrdCcs, this.trsTrspWrkOrdCcs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param trsTrspWrkOrdCcs the trsTrspWrkOrdCcs to set
	 */
	public void setTrsTrspWrkOrdCcs(TrsTrspWrkOrdCcVO[] trsTrspWrkOrdCcs) {
		if (trsTrspWrkOrdCcs != null) {
			TrsTrspWrkOrdCcVO[] tmpVOs = Arrays.copyOf(trsTrspWrkOrdCcs, trsTrspWrkOrdCcs.length);
			this.trsTrspWrkOrdCcs = tmpVOs;
		} // end if

	}

	/**
	 * @return the trsTrspWrkOrdCcFax
	 */
	public TrsTrspWrkOrdCcFaxVO getTrsTrspWrkOrdCcFax() {
		return trsTrspWrkOrdCcFax;
	}

	/**
	 * @param trsTrspWrkOrdCcFax the trsTrspWrkOrdCcFax to set
	 */
	public void setTrsTrspWrkOrdCcFax(TrsTrspWrkOrdCcFaxVO trsTrspWrkOrdCcFax) {
		this.trsTrspWrkOrdCcFax = trsTrspWrkOrdCcFax;
	}

	/**
	 * @return the trsTrspWrkOrdCcFaxs
	 */
	public TrsTrspWrkOrdCcFaxVO[] getTrsTrspWrkOrdCcFaxs() {
		TrsTrspWrkOrdCcFaxVO[] rtnVOs = null;
		if (this.trsTrspWrkOrdCcFaxs != null) {
			rtnVOs = Arrays.copyOf(this.trsTrspWrkOrdCcFaxs, this.trsTrspWrkOrdCcFaxs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param trsTrspWrkOrdCcFaxs the trsTrspWrkOrdCcFaxs to set
	 */
	public void setTrsTrspWrkOrdCcFaxs(TrsTrspWrkOrdCcFaxVO[] trsTrspWrkOrdCcFaxs) {
		if (trsTrspWrkOrdCcFaxs != null) {
			TrsTrspWrkOrdCcFaxVO[] tmpVOs = Arrays.copyOf(trsTrspWrkOrdCcFaxs, trsTrspWrkOrdCcFaxs.length);
			this.trsTrspWrkOrdCcFaxs = tmpVOs;
		} // end if

	}

	/**
	 * @return the trsTrspWrkOrdCcEml
	 */
	public TrsTrspWrkOrdCcEmlVO getTrsTrspWrkOrdCcEml() {
		return trsTrspWrkOrdCcEml;
	}

	/**
	 * @param trsTrspWrkOrdCcEml the trsTrspWrkOrdCcEml to set
	 */
	public void setTrsTrspWrkOrdCcEml(TrsTrspWrkOrdCcEmlVO trsTrspWrkOrdCcEml) {
		this.trsTrspWrkOrdCcEml = trsTrspWrkOrdCcEml;
	}

	/**
	 * @return the trsTrspWrkOrdCcEmls
	 */
	public TrsTrspWrkOrdCcEmlVO[] getTrsTrspWrkOrdCcEmls() {
		TrsTrspWrkOrdCcEmlVO[] rtnVOs = null;
		if (this.trsTrspWrkOrdCcEmls != null) {
			rtnVOs = Arrays.copyOf(this.trsTrspWrkOrdCcEmls, this.trsTrspWrkOrdCcEmls.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param trsTrspWrkOrdCcEmls the trsTrspWrkOrdCcEmls to set
	 */
	public void setTrsTrspWrkOrdCcEmls(TrsTrspWrkOrdCcEmlVO[] trsTrspWrkOrdCcEmls) {
		if (trsTrspWrkOrdCcEmls != null) {
			TrsTrspWrkOrdCcEmlVO[] tmpVOs = Arrays.copyOf(trsTrspWrkOrdCcEmls, trsTrspWrkOrdCcEmls.length);
			this.trsTrspWrkOrdCcEmls = tmpVOs;
		} // end if
	}

	/**
	 * @return the vndrSequence
	 */
	public String getComboSvcProvider() {
		return comboSvcProvider;
	}

	/**
	 * @param vndrSequence the vndrSequence to set
	 */
	public void setComboSvcProvider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}

	/**
	 * @return the controlOfficeCd
	 */
	public String getControlOfficeCd() {
		return controlOfficeCd;
	}

	/**
	 * @param controlOfficeCd the controlOfficeCd to set
	 */
	public void setControlOfficeCd(String controlOfficeCd) {
		this.controlOfficeCd = controlOfficeCd;
	}

	/**
	 * @return the locationCd
	 */
	public String getLocationCd() {
		return locationCd;
	}

	/**
	 * @param locationCd the locationCd to set
	 */
	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}

	/**
	 * @return the selectedVndrSeq
	 */
	public String getSelectedVndrSeq() {
		return selectedVndrSeq;
	}

	/**
	 * @param selectedVndrSeq the selectedVndrSeq to set
	 */
	public void setSelectedVndrSeq(String selectedVndrSeq) {
		this.selectedVndrSeq = selectedVndrSeq;
	}

	/**
	 * @return the faxEmailIndicator
	 */
	public String getFaxEmailIndicator() {
		return faxEmailIndicator;
	}

	/**
	 * @param faxEmailIndicator the faxEmailIndicator to set
	 */
	public void setFaxEmailIndicator(String faxEmailIndicator) {
		this.faxEmailIndicator = faxEmailIndicator;
	}

	/**
	 * @return the selectedCtrlOfcCd
	 */
	public String getSelectedCtrlOfcCd() {
		return selectedCtrlOfcCd;
	}

	/**
	 * @param selectedCtrlOfcCd the selectedCtrlOfcCd to set
	 */
	public void setSelectedCtrlOfcCd(String selectedCtrlOfcCd) {
		this.selectedCtrlOfcCd = selectedCtrlOfcCd;
	}

	/**
	 * @return the selectedLocCd
	 */
	public String getSelectedLocCd() {
		return selectedLocCd;
	}

	/**
	 * @param selectedLocCd the selectedLocCd to set
	 */
	public void setSelectedLocCd(String selectedLocCd) {
		this.selectedLocCd = selectedLocCd;
	}

	/**
	 * @return the loginUserOfcCd
	 */
	public String getLoginUserOfcCd() {
		return loginUserOfcCd;
	}

	/**
	 * @param loginUserOfcCd the loginUserOfcCd to set
	 */
	public void setLoginUserOfcCd(String loginUserOfcCd) {
		this.loginUserOfcCd = loginUserOfcCd;
	}

	/**
	 * @return the loginUserId
	 */
	public String getLoginUserId() {
		return loginUserId;
	}

	/**
	 * @param loginUserId the loginUserId to set
	 */
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getEventName() {
		return "EsdTrs0072Event";
	}

	public String toString() {
		return "EsdTrs0072Event";
	}

}
