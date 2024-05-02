/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_082Event.java
*@FileTitle : USA Actual Customer Code Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-16
*@LastModifier : Kim Jun Ho
*@LastVersion : 1.0 
* 2007-10-16 Kim Jun Ho
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.event;

import java.util.Arrays;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspUsaActCustDtlVO;
import com.clt.syscommon.common.table.TrsTrspUsaActCustVO;


/**
 * ESD_TRS_082 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_082HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jun Ho
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0082Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private String actCustCntCd = null;
	private String actCustBndCd = null;
	private String dorNodCd = null;
	
	private String status = null;
	private String bound = null;
	private String dorLoc = null;
	private String dorNod = null;
	private String inputCustCd = null;
	private String inputCustNm = null;
	private String inputCreOfcCd = null;
	private String selTrspActCustNo = null;

	private String mstDtlIndicator = null;
	private String loginOfcCd = null;
	private String loginUsrId = null;
	private String loginDate = null;

	private TrsTrspUsaActCustVO trsTrspUsaActCustVO = null;
	private TrsTrspUsaActCustVO[] trsTrspUsaActCustVOs = null;
	private TrsTrspUsaActCustDtlVO trsTrspUsaActCustDtlVO = null;
	private TrsTrspUsaActCustDtlVO[] trsTrspUsaActCustDtlVOs = null;

	
	public String getSel_trsp_act_cust_no() {
		return selTrspActCustNo;
	}

	public void setSel_trsp_act_cust_no(String selTrspActCustNo) {
		this.selTrspActCustNo = selTrspActCustNo;
	}
	
	public String getMST_DTL_INDICATOR() {
		return mstDtlIndicator;
	}

	public void setMST_DTL_INDICATOR(String mstDtlIndicator) {
		this.mstDtlIndicator = mstDtlIndicator;
	}

	public String getLogin_ofc_cd() {
		return loginOfcCd;
	}

	public void setLogin_ofc_cd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}

	public String getLogin_usr_id() {
		return loginUsrId;
	}

	public void setLogin_usr_id(String loginUsrId) {
		this.loginUsrId = loginUsrId;
	}

	public String getLogin_date() {
		return loginDate;
	}

	public void setLogin_date(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBound() {
		return bound;
	}

	public void setBound(String bound) {
		this.bound = bound;
	}

	public String getDor_loc() {
		return dorLoc;
	}

	public void setDor_loc(String dorLoc) {
		this.dorLoc = dorLoc;
	}

	public String getDor_nod() {
		return dorNod;
	}

	public void setDor_nod(String dorNod) {
		this.dorNod = dorNod;
	}

	public String getInput_cust_cd() {
		return inputCustCd;
	}

	public void setInput_cust_cd(String inputCustCd) {
		this.inputCustCd = inputCustCd;
	}

	public String getInput_cust_nm() {
		return inputCustNm;
	}

	public void setInput_cust_nm(String inputCustNm) {
		this.inputCustNm = inputCustNm;
	}

	public String getInput_cre_ofc_cd() {
		return inputCreOfcCd;
	}

	public void setInput_cre_ofc_cd(String inputCreOfcCd) {
		this.inputCreOfcCd = inputCreOfcCd;
	}

	public EsdTrs0082Event(){}	

	public String getAct_cust_cnt_cd() {
		return actCustCntCd;
	}

	public void setAct_cust_cnt_cd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}

	public String getAct_cust_bnd_cd() {
		return actCustBndCd;
	}

	public void setAct_cust_bnd_cd(String actCustBndCd) {
		this.actCustBndCd = actCustBndCd;
	}

	public String getDor_nod_cd() {
		return dorNodCd;
	}

	public void setDor_nod_cd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}

	/**
	 * @param trsTrspUsaActCustVO
	 * @param trsTrspUsaActCustDtlVO
	 */
	public EsdTrs0082Event(TrsTrspUsaActCustVO trsTrspUsaActCustVO, TrsTrspUsaActCustDtlVO trsTrspUsaActCustDtlVO) {
		this.trsTrspUsaActCustVO = trsTrspUsaActCustVO;
		this.trsTrspUsaActCustDtlVO = trsTrspUsaActCustDtlVO;
    }
	
	public TrsTrspUsaActCustVO getTrsTrspUsaActCustVO() {
		return trsTrspUsaActCustVO;
	}

	public void setTrsTrspUsaActCustVO(TrsTrspUsaActCustVO trsTrspUsaActCustVO) {
		this.trsTrspUsaActCustVO = trsTrspUsaActCustVO;
	}

	public TrsTrspUsaActCustVO[] getTrsTrspUsaActCustVOs() {
		TrsTrspUsaActCustVO[] rtnVOs = null;
		if (this.trsTrspUsaActCustVOs != null) {
			rtnVOs = Arrays.copyOf(trsTrspUsaActCustVOs, trsTrspUsaActCustVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsTrspUsaActCustVOs(TrsTrspUsaActCustVO[] trsTrspUsaActCustVOs) {
		if (trsTrspUsaActCustVOs != null) {
			TrsTrspUsaActCustVO[] tmpVOs = Arrays.copyOf(trsTrspUsaActCustVOs, trsTrspUsaActCustVOs.length);
			this.trsTrspUsaActCustVOs = tmpVOs;
		} // end if
	}

	public TrsTrspUsaActCustDtlVO getTrsTrspUsaActCustDtlVO() {
		return trsTrspUsaActCustDtlVO;
	}

	public void setTrsTrspUsaActCustDtlVO(
			TrsTrspUsaActCustDtlVO trsTrspUsaActCustDtlVO) {
		this.trsTrspUsaActCustDtlVO = trsTrspUsaActCustDtlVO;
	}

	public TrsTrspUsaActCustDtlVO[] getTrsTrspUsaActCustDtlVOs() {
		TrsTrspUsaActCustDtlVO[] rtnVOs = null;
		if (this.trsTrspUsaActCustDtlVOs != null) {
			rtnVOs = Arrays.copyOf(trsTrspUsaActCustDtlVOs, trsTrspUsaActCustDtlVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsTrspUsaActCustDtlVOs(
			TrsTrspUsaActCustDtlVO[] trsTrspUsaActCustDtlVOs) {
		if (trsTrspUsaActCustDtlVOs != null) {
			TrsTrspUsaActCustDtlVO[] tmpVOs = Arrays.copyOf(trsTrspUsaActCustDtlVOs, trsTrspUsaActCustDtlVOs.length);
			this.trsTrspUsaActCustDtlVOs = tmpVOs;
		} // end if
	}

	public void setTrsTrspUsaActCustDtlVOS(TrsTrspUsaActCustDtlVO[] trsTrspUsaActCustDtlVOs){
		if (trsTrspUsaActCustDtlVOs != null) {
			TrsTrspUsaActCustDtlVO[] tmpVOs = Arrays.copyOf(trsTrspUsaActCustDtlVOs, trsTrspUsaActCustDtlVOs.length);
			this.trsTrspUsaActCustDtlVOs = tmpVOs;
		} // end if
	}
	
	public String getEventName() {
		return "EsdTrs0082Event";
	}

	public String toString() {
		return "EsdTrs0082Event";
	}
	
}
