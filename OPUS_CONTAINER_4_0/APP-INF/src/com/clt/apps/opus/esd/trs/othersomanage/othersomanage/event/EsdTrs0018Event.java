/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_018Event.java
*@FileTitle : Other SO 생성화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0 
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.othersomanage.othersomanage.event;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.vo.ChassisGensetVO;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.clt.apps.opus.esd.trs.othersomanage.othersomanage.vo.OtherSOVO;
import com.clt.apps.opus.esd.trs.othersomanage.othersomanage.vo.OtherSearchVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD_TRS_018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0018Event extends EventSupport {

//	private OtherSOVO otherSOVO = null;

	/** trs_trsp_svc_ords Multi Action을 위한 Collection */
	private Collection trsTrspSvcOrds = null;
	
	/** trs_trsp_svc_ords Multi Action을 위한 Collection */
//	private Collection chassisGensetVO = null;
	
	/** trs_trsp_svc_ords Multi Action을 위한 Collection */
	private Collection mdmCustomerVO = null;
	
	private Collection trsTrspScgDtls = null;
	
	/** trs_trsp_svc_ords Multi Action을 위한 Collection */
//	private Collection otherSOVOs = null;
	
	/** trs_trsp_svc_ords Multi Action을 위한 Collection */
//	private Collection surchargeVO = null;
	
	private TrsTrspSvcOrdVO trsTrspSvcOrdVO = null;
	
	private TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = null;

	private ChassisGensetVO chassisGensetVO = null;
	
	private ChassisGensetVO[] chassisGensetVOs = null;
	
	private SurchargeVO surchargeVO = null;
	
	private SurchargeVO[] surchargeVOs = null;	
	
	private OtherSOVO otherSOVO = null;
	
	private OtherSearchVO otherSearchVO = null;
	
	private OtherSOVO[] otherSOVOs = null;
		
	public OtherSOVO[] getOtherSOVOS() {
		OtherSOVO[] rtnVOs = null;
		if (this.otherSOVOs != null) {
			rtnVOs = Arrays.copyOf(this.otherSOVOs, this.otherSOVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setOtherSOVOS(OtherSOVO[] otherSOVOs) {
		if (otherSOVOs != null) {
			OtherSOVO[] tmpVOs = Arrays.copyOf(otherSOVOs, otherSOVOs.length);
			this.otherSOVOs = tmpVOs;
		} // end if
	}

	/**
	 * @return the otherSearchVO
	 */
	public OtherSearchVO getOtherSearchVO() {
		return otherSearchVO;
	}

	/**
	 * @param otherSearchVO the otherSearchVO to set
	 */
	public void setOtherSearchVO(OtherSearchVO otherSearchVO) {
		this.otherSearchVO = otherSearchVO;
	}

	public void setOtherSOVO(OtherSOVO otherSOVO) {
		this.otherSOVO = otherSOVO;
	}

	public ChassisGensetVO getChassisGensetVO() {
		return chassisGensetVO;
	}

	public void setChassisGensetVO(ChassisGensetVO chassisGensetVO) {
		this.chassisGensetVO = chassisGensetVO;
	}

	public ChassisGensetVO[] getChassisGensetVOS() {
		ChassisGensetVO[] rtnVOs = null;
		if (this.chassisGensetVOs != null) {
			rtnVOs = Arrays.copyOf(this.chassisGensetVOs, this.chassisGensetVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setChassisGensetVOS(ChassisGensetVO[] chassisGensetVOs) {
		if (chassisGensetVOs != null) {
			ChassisGensetVO[] tmpVOs = Arrays.copyOf(chassisGensetVOs, chassisGensetVOs.length);
			this.chassisGensetVOs = tmpVOs;
		} // end if
	}

	public SurchargeVO getSurchargeVO() {
		return surchargeVO;
	}

	public void setSurchargeVO(SurchargeVO surchargeVO) {
		this.surchargeVO = surchargeVO;
	}

	public SurchargeVO[] getSurchargeVOS() {
		SurchargeVO[] rtnVOs = null;
		if (this.surchargeVOs != null) {
			rtnVOs = Arrays.copyOf(this.surchargeVOs, this.surchargeVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setSurchargeVOS(SurchargeVO[] surchargeVOs) {
		if (surchargeVOs != null) {
			SurchargeVO[] tmpVOs = Arrays.copyOf(surchargeVOs, surchargeVOs.length);
			this.surchargeVOs = tmpVOs;
		} // end if
	}

	private HashMap hashParam = new HashMap();

	/** HASHPARAM을 대치할 파라미터 set/get START*/
	
	private String row 				= "";
	private String trspOtrCostMonDt = "";
	private String formUsrOfcCd 	= "";
	private String formCreUsrId 	= "";
	private String trspSoTpCd 		= "";
	private String trspSoStsCd 		= "";
	
	public String getFormCreUsrId() {
		return formCreUsrId;
	}

	public void setFormCreUsrId(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}

	public String getTrspSoTpCd() {
		return trspSoTpCd;
	}

	public void setTrspSoTpCd(String trspSoTpCd) {
		this.trspSoTpCd = trspSoTpCd;
	}

	public String getTrspSoStsCd() {
		return trspSoStsCd;
	}

	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}

	public String getFormUsrOfcCd() {
		return formUsrOfcCd;
	}

	public void setFormUsrOfcCd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}

	public String getTrspOtrCostMonDt() {
		return trspOtrCostMonDt;
	}

	public void setTrspOtrCostMonDt(String trspOtrCostMonDt) {
		this.trspOtrCostMonDt = trspOtrCostMonDt;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	/** HASHPARAM을 대치할 파라미터 set/get END*/

	public TrsTrspSvcOrdVO getTrsTrspSvcOrdVO() {
		return trsTrspSvcOrdVO;
	}

	public void setTrsTrspSvcOrdVO(TrsTrspSvcOrdVO trsTrspSvcOrdVO) {
		this.trsTrspSvcOrdVO = trsTrspSvcOrdVO;
	}

	public EsdTrs0018Event(){}
	
	/**
	 * @param trsTrspSvcOrds
	 */
	public EsdTrs0018Event( Collection trsTrspSvcOrds){
		this.trsTrspSvcOrds = trsTrspSvcOrds;
	}
	
	public Collection getTRS_TRSP_SVC_ORDS(){
		return trsTrspSvcOrds;
	}
	
	public Collection getMDM_CUSTOMER(){
		return mdmCustomerVO;
	}
	
	public Collection getTRS_TRSP_SCG_DTLS(){
		return trsTrspScgDtls;
	}
	
	public String getEventName() {
		return "EsdTrs0018Event";
	}

	public HashMap getHashParam() {
		return hashParam;
	}

	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOS(){
		TrsTrspSvcOrdVO[] rtnVOs = null;
		if (this.trsTrspSvcOrdVOs != null) {
			rtnVOs = Arrays.copyOf(this.trsTrspSvcOrdVOs, this.trsTrspSvcOrdVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsTrspSvcOrdVOS(TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs){
		if (trsTrspSvcOrdVOs != null) {
			TrsTrspSvcOrdVO[] tmpVOs = Arrays.copyOf(trsTrspSvcOrdVOs, trsTrspSvcOrdVOs.length);
			this.trsTrspSvcOrdVOs = tmpVOs;
		} // end if
	}

	public void setMdmCustomer(Collection mdmCustomerVO){
		this.mdmCustomerVO = mdmCustomerVO;
	}

	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}
	
	public void setTRS_TRSP_SCG_DTLS(Collection trsTrspScgDtlsValue){
		this.trsTrspScgDtls = trsTrspScgDtlsValue;
	}

	public String toString() {
		return "EsdTrs0018Event";
	}

}