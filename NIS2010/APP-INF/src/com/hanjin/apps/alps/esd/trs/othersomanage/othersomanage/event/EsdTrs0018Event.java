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
* -----------------------------------------------------------------
* History
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경 
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.event;

import java.util.Collection;
import java.util.HashMap;

import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.vo.ChassisGensetVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.vo.OtherSOVO;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.vo.OtherSearchVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** trs_trsp_svc_ords Multi Action을 위한 Collection */
	@SuppressWarnings("unchecked")
	private Collection trsTrspSvcOrds = null;
	
	/** trs_trsp_svc_ords Multi Action을 위한 Collection */
//	private Collection chassisGensetVO = null;
	
	/** trs_trsp_svc_ords Multi Action을 위한 Collection */
	@SuppressWarnings("unchecked")
	private Collection mdmCustomerVO = null;
	
	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unused")
	private OtherSOVO otherSOVO = null;
	
	private OtherSearchVO otherSearchVO = null;
	
	private OtherSOVO[] otherSOVOs = null;
		
	public OtherSOVO[] getOtherSOVOS() {
		return otherSOVOs;
	}

	public void setOtherSOVOS(OtherSOVO[] otherSOVOs) {
		this.otherSOVOs = otherSOVOs;
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
		return chassisGensetVOs;
	}

	public void setChassisGensetVOS(ChassisGensetVO[] chassisGensetVOs) {
		this.chassisGensetVOs = chassisGensetVOs;
	}

	public SurchargeVO getSurchargeVO() {
		return surchargeVO;
	}

	public void setSurchargeVO(SurchargeVO surchargeVO) {
		this.surchargeVO = surchargeVO;
	}

	public SurchargeVO[] getSurchargeVOS() {
		return surchargeVOs;
	}

	public void setSurchargeVOS(SurchargeVO[] surchargeVOs) {
		this.surchargeVOs = surchargeVOs;
	}

	@SuppressWarnings("unchecked")
	private HashMap hashParam = new HashMap();

	/** HASHPARAM을 대치할 파라미터 set/get START*/
	
	private String row 				= "";
	private String trspOtrCostMonDt = "";
	private String formUsrOfcCd 	= "";
	private String formCreUsrId 	= "";
	private String trspSoTpCd 		= "";
	private String trspSoStsCd 		= "";
	private String wo_grs_wgt_meas_ut_cd 		= "";
	
	
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

	/**
	 * @return the wo_grs_wgt_meas_ut_cd
	 */
	public String getWo_grs_wgt_meas_ut_cd() {
		return wo_grs_wgt_meas_ut_cd;
	}

	/**
	 * @param wo_grs_wgt_meas_ut_cd the wo_grs_wgt_meas_ut_cd to set
	 */
	public void setWo_grs_wgt_meas_ut_cd(String wo_grs_wgt_meas_ut_cd) {
		this.wo_grs_wgt_meas_ut_cd = wo_grs_wgt_meas_ut_cd;
	}

	public EsdTrs0018Event(){}
	
	/**
	 * @param trsTrspSvcOrds
	 */
	@SuppressWarnings("unchecked")
	public EsdTrs0018Event( Collection trsTrspSvcOrds){
		this.trsTrspSvcOrds = trsTrspSvcOrds;
	}
	
	@SuppressWarnings("unchecked")
	public Collection getTRS_TRSP_SVC_ORDS(){
		return trsTrspSvcOrds;
	}
	
	@SuppressWarnings("unchecked")
	public Collection getMDM_CUSTOMER(){
		return mdmCustomerVO;
	}
	
	@SuppressWarnings("unchecked")
	public Collection getTRS_TRSP_SCG_DTLS(){
		return trsTrspScgDtls;
	}
	
	public String getEventName() {
		return "EsdTrs0018Event";
	}

	@SuppressWarnings("unchecked")
	public HashMap getHashParam() {
		return hashParam;
	}

	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOS(){
		return trsTrspSvcOrdVOs;
	}

	public void setTrsTrspSvcOrdVOS(TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs){
		this.trsTrspSvcOrdVOs = trsTrspSvcOrdVOs;
	}

	@SuppressWarnings("unchecked")
	public void setMdmCustomer(Collection mdmCustomerVO){
		this.mdmCustomerVO = mdmCustomerVO;
	}

	@SuppressWarnings("unchecked")
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}
	
	@SuppressWarnings("unchecked")
	public void setTRS_TRSP_SCG_DTLS(Collection trsTrspScgDtlsValue){
		this.trsTrspScgDtls = trsTrspScgDtlsValue;
	}

	public String toString() {
		return "EsdTrs0018Event";
	}

}
