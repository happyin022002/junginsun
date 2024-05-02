/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderSheetList.java
*@FileTitle : WorkOrderSheetList 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.common.document;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * EXP_PAP_006Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_006EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderSheet {
	/** (Param 객체) */

	private String workOrderFormatTypeCd	= "";
	private String workOrderFormatTypeNm	= "";
	
	private String officeAddress	= "";
	private String officeTel	= "";
	private String officeFax	= "";
	private String officePic	= "";
	private String issueType	= "";
	private	String woIssuedAt		= "";	
	private	String printedAt			= "";	          
	private	String workOrderNo		= "";	               

	private	String spFullNm			= "";
	private	String spAddress			= "";
	private	String spTel					= "";
	private	String spFax				= "";
	private	String spPic				= "";
	private	String spCode				= "";
	private	String frFullNm			= "";
	private	String frAddress			= "";
	private	String frTel					= "";
	private	String frFax				= "";
	private	String frPic				= "";
	private	String frCode				= "";
	private	String viaFullNm   		= "";
	private	String viaAddress     	= "";
	private	String viaTel             	= "";
	private	String viaFax            	= "";
	private	String viaPic            	= "";
	private	String viaCode          	= "";
	private	String toFullNm     	= "";
	private	String toAddress      	= "";
	private	String toTel              	= "";
	private	String toFax              	= "";
	private	String toPic             	= "";
	private	String toCode            = "";
	private	String doorFullNm 		= "";
	private	String doorAddress  	= "";
	private	String doorTel           	= "";
	private	String doorFax          	= "";
	private	String doorPic          	= "";
	private	String doorCode        	= "";

	private	String instruction			= "";	               
	private	String feederVVD			= "";
	private String trspBbndCd			= "";
	private String trspCostDtlModCd = "";
	private String trspCrrModNm		= "";
	private String trspCostDtlModNm = "";	
	private String ibVvdCd			= "";
	private String obVvdCd			= "";
	
	private String maeFlg			= "";
	private String creOfcCd			= "";
	private String creUsrId			= "";
	
	/**
	 * @return door_address을 리턴합니다.
	 */
	public String getDoor_address() {
		return doorAddress;
	}
	/**
	 * @param door_address 설정하려는 door_address입니다.
	 */
	public void setDoor_address(String door_address) {
		this.doorAddress = StringEscapeUtils.escapeXml(door_address);
	}
	/**
	 * @return door_code을 리턴합니다.
	 */
	public String getDoor_code() {
		return doorCode;
	}
	/**
	 * @param door_code 설정하려는 door_code입니다.
	 */
	public void setDoor_code(String door_code) {
		this.doorCode = door_code;
	}
	/**
	 * @return door_fax을 리턴합니다.
	 */
	public String getDoor_fax() {
		return doorFax;
	}
	/**
	 * @param door_fax 설정하려는 door_fax입니다.
	 */
	public void setDoor_fax(String door_fax) {
		this.doorFax = StringEscapeUtils.escapeXml(door_fax);
	}
	/**
	 * @return door_full_nm을 리턴합니다.
	 */
	public String getDoor_full_nm() {
		return doorFullNm;
	}
	/**
	 * @param door_full_nm 설정하려는 door_full_nm입니다.
	 */
	public void setDoor_full_nm(String door_full_nm) {
		this.doorFullNm = StringEscapeUtils.escapeXml(door_full_nm);
	}
	/**
	 * @return door_pic을 리턴합니다.
	 */
	public String getDoor_pic() {
		return doorPic;
	}
	/**
	 * @param door_pic 설정하려는 door_pic입니다.
	 */
	public void setDoor_pic(String door_pic) {
		this.doorPic = StringEscapeUtils.escapeXml(door_pic);
	}
	/**
	 * @return door_tel을 리턴합니다.
	 */
	public String getDoor_tel() {
		return doorTel;
	}
	/**
	 * @param door_tel 설정하려는 door_tel입니다.
	 */
	public void setDoor_tel(String door_tel) {
		this.doorTel = StringEscapeUtils.escapeXml(door_tel);
	}
	/**
	 * @return feederVVD을 리턴합니다.
	 */
	public String getFeederVVD() {
		return feederVVD;
	}
	/**
	 * @param feederVVD 설정하려는 feederVVD입니다.
	 */
	public void setFeederVVD(String feederVVD) {
		this.feederVVD = feederVVD;
	}
	/**
	 * @return fr_address을 리턴합니다.
	 */
	public String getFr_address() {
		return frAddress;
	}
	/**
	 * @param fr_address 설정하려는 fr_address입니다.
	 */
	public void setFr_address(String fr_address) {
		this.frAddress = StringEscapeUtils.escapeXml(fr_address);
	}
	/**
	 * @return fr_code을 리턴합니다.
	 */
	public String getFr_code() {
		return frCode;
	}
	/**
	 * @param fr_code 설정하려는 fr_code입니다.
	 */
	public void setFr_code(String fr_code) {
		this.frCode = fr_code;
	}
	/**
	 * @return fr_fax을 리턴합니다.
	 */
	public String getFr_fax() {
		return frFax;
	}
	/**
	 * @param fr_fax 설정하려는 fr_fax입니다.
	 */
	public void setFr_fax(String fr_fax) {
		this.frFax = StringEscapeUtils.escapeXml(fr_fax);
	}
	/**
	 * @return fr_full_nm을 리턴합니다.
	 */
	public String getFr_full_nm() {
		return frFullNm;
	}
	/**
	 * @param fr_full_nm 설정하려는 fr_full_nm입니다.
	 */
	public void setFr_full_nm(String fr_full_nm) {
		this.frFullNm = StringEscapeUtils.escapeXml(fr_full_nm);
	}
	/**
	 * @return fr_pic을 리턴합니다.
	 */
	public String getFr_pic() {
		return frPic;
	}
	/**
	 * @param fr_pic 설정하려는 fr_pic입니다.
	 */
	public void setFr_pic(String fr_pic) {
		this.frPic = StringEscapeUtils.escapeXml(fr_pic);
	}
	/**
	 * @return fr_tel을 리턴합니다.
	 */
	public String getFr_tel() {
		return frTel;
	}
	/**
	 * @param fr_tel 설정하려는 fr_tel입니다.
	 */
	public void setFr_tel(String fr_tel) {
		this.frTel = StringEscapeUtils.escapeXml(fr_tel);
	}
	/**
	 * @return instruction을 리턴합니다.
	 */
	public String getInstruction() {
		return instruction;
	}
	/**
	 * @param instruction 설정하려는 instruction입니다.
	 */
	public void setInstruction(String instruction) {
		this.instruction = StringEscapeUtils.escapeXml(instruction);
	}
	/**
	 * @return issueType을 리턴합니다.
	 */
	public String getIssueType() {
		return issueType;
	}
	/**
	 * @param issueType 설정하려는 issueType입니다.
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	/**
	 * @return officeAddress을 리턴합니다.
	 */
	public String getOfficeAddress() {
		return officeAddress;
	}
	/**
	 * @param officeAddress 설정하려는 officeAddress입니다.
	 */
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = StringEscapeUtils.escapeXml(officeAddress);
	}
	/**
	 * @return officeFax을 리턴합니다.
	 */
	public String getOfficeFax() {
		return officeFax;
	}
	/**
	 * @param officeFax 설정하려는 officeFax입니다.
	 */
	public void setOfficeFax(String officeFax) {
		this.officeFax = officeFax;
	}
	/**
	 * @return officePic을 리턴합니다.
	 */
	public String getOfficePic() {
		return officePic;
	}
	/**
	 * @param officePic 설정하려는 officePic입니다.
	 */
	public void setOfficePic(String officePic) {
		this.officePic = StringEscapeUtils.escapeXml(officePic);
	}
	/**
	 * @return officeTel을 리턴합니다.
	 */
	public String getOfficeTel() {
		return officeTel;
	}
	/**
	 * @param officeTel 설정하려는 officeTel입니다.
	 */
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	/**
	 * @return printedAt을 리턴합니다.
	 */
	public String getPrintedAt() {
		return printedAt;
	}
	/**
	 * @param printedAt 설정하려는 printedAt입니다.
	 */
	public void setPrintedAt(String printedAt) {
		this.printedAt = printedAt;
	}
	/**
	 * @return sp_address을 리턴합니다.
	 */
	public String getSp_address() {
		return spAddress;
	}
	/**
	 * @param sp_address 설정하려는 sp_address입니다.
	 */
	public void setSp_address(String sp_address) {
		this.spAddress = StringEscapeUtils.escapeXml(sp_address);
	}
	/**
	 * @return sp_code을 리턴합니다.
	 */
	public String getSp_code() {
		return spCode;
	}
	/**
	 * @param sp_code 설정하려는 sp_code입니다.
	 */
	public void setSp_code(String sp_code) {
		this.spCode = sp_code;
	}
	/**
	 * @return sp_fax을 리턴합니다.
	 */
	public String getSp_fax() {
		return spFax;
	}
	/**
	 * @param sp_fax 설정하려는 sp_fax입니다.
	 */
	public void setSp_fax(String sp_fax) {
		this.spFax = StringEscapeUtils.escapeXml(sp_fax);
	}
	/**
	 * @return sp_full_nm을 리턴합니다.
	 */
	public String getSp_full_nm() {
		return spFullNm;
	}
	/**
	 * @param sp_full_nm 설정하려는 sp_full_nm입니다.
	 */
	public void setSp_full_nm(String sp_full_nm) {
		this.spFullNm = StringEscapeUtils.escapeXml(sp_full_nm);
	}
	/**
	 * @return sp_pic을 리턴합니다.
	 */
	public String getSp_pic() {
		return spPic;
	}
	/**
	 * @param sp_pic 설정하려는 sp_pic입니다.
	 */
	public void setSp_pic(String sp_pic) {
		this.spPic = StringEscapeUtils.escapeXml(sp_pic);
	}
	/**
	 * @return sp_tel을 리턴합니다.
	 */
	public String getSp_tel() {
		return spTel;
	}
	/**
	 * @param sp_tel 설정하려는 sp_tel입니다.
	 */
	public void setSp_tel(String sp_tel) {
		this.spTel = StringEscapeUtils.escapeXml(sp_tel);
	}
	/**
	 * @return to_address을 리턴합니다.
	 */
	public String getTo_address() {
		return toAddress;
	}
	/**
	 * @param to_address 설정하려는 to_address입니다.
	 */
	public void setTo_address(String to_address) {
		this.toAddress = StringEscapeUtils.escapeXml(to_address);
	}
	/**
	 * @return to_code을 리턴합니다.
	 */
	public String getTo_code() {
		return toCode;
	}
	/**
	 * @param to_code 설정하려는 to_code입니다.
	 */
	public void setTo_code(String to_code) {
		this.toCode = to_code;
	}
	/**
	 * @return to_fax을 리턴합니다.
	 */
	public String getTo_fax() {
		return toFax;
	}
	/**
	 * @param to_fax 설정하려는 to_fax입니다.
	 */
	public void setTo_fax(String to_fax) {
		this.toFax = StringEscapeUtils.escapeXml(to_fax);
	}
	/**
	 * @return to_full_nm을 리턴합니다.
	 */
	public String getTo_full_nm() {
		return toFullNm;
	}
	/**
	 * @param to_full_nm 설정하려는 to_full_nm입니다.
	 */
	public void setTo_full_nm(String to_full_nm) {
		this.toFullNm = StringEscapeUtils.escapeXml(to_full_nm);
	}
	/**
	 * @return to_pic을 리턴합니다.
	 */
	public String getTo_pic() {
		return toPic;
	}
	/**
	 * @param to_pic 설정하려는 to_pic입니다.
	 */
	public void setTo_pic(String to_pic) {
		this.toPic = StringEscapeUtils.escapeXml(to_pic);
	}
	/**
	 * @return to_tel을 리턴합니다.
	 */
	public String getTo_tel() {
		return toTel;
	}
	/**
	 * @param to_tel 설정하려는 to_tel입니다.
	 */
	public void setTo_tel(String to_tel) {
		this.toTel = StringEscapeUtils.escapeXml(to_tel);
	}
	/**
	 * @return via_address을 리턴합니다.
	 */
	public String getVia_address() {
		return viaAddress;
	}
	/**
	 * @param via_address 설정하려는 via_address입니다.
	 */
	public void setVia_address(String via_address) {
		this.viaAddress = StringEscapeUtils.escapeXml(via_address);
	}
	/**
	 * @return via_code을 리턴합니다.
	 */
	public String getVia_code() {
		return viaCode;
	}
	/**
	 * @param via_code 설정하려는 via_code입니다.
	 */
	public void setVia_code(String via_code) {
		this.viaCode = via_code;
	}
	/**
	 * @return via_fax을 리턴합니다.
	 */
	public String getVia_fax() {
		return viaFax;
	}
	/**
	 * @param via_fax 설정하려는 via_fax입니다.
	 */
	public void setVia_fax(String via_fax) {
		this.viaFax = StringEscapeUtils.escapeXml(via_fax);
	}
	/**
	 * @return via_full_nm을 리턴합니다.
	 */
	public String getVia_full_nm() {
		return viaFullNm;
	}
	/**
	 * @param via_full_nm 설정하려는 via_full_nm입니다.
	 */
	public void setVia_full_nm(String via_full_nm) {
		this.viaFullNm = StringEscapeUtils.escapeXml(via_full_nm);
	}
	/**
	 * @return via_pic을 리턴합니다.
	 */
	public String getVia_pic() {
		return viaPic;
	}
	/**
	 * @param via_pic 설정하려는 via_pic입니다.
	 */
	public void setVia_pic(String via_pic) {
		this.viaPic = StringEscapeUtils.escapeXml(via_pic);
	}
	/**
	 * @return via_tel을 리턴합니다.
	 */
	public String getVia_tel() {
		return viaTel;
	}
	/**
	 * @param via_tel 설정하려는 via_tel입니다.
	 */
	public void setVia_tel(String via_tel) {
		this.viaTel = StringEscapeUtils.escapeXml(via_tel);
	}
	/**
	 * @return woIssuedAt을 리턴합니다.
	 */
	public String getWoIssuedAt() {
		return woIssuedAt;
	}
	/**
	 * @param woIssuedAt 설정하려는 woIssuedAt입니다.
	 */
	public void setWoIssuedAt(String woIssuedAt) {
		this.woIssuedAt = woIssuedAt;
	}
	/**
	 * @return workOrderFormatTypeCd을 리턴합니다.
	 */
	public String getWorkOrderFormatTypeCd() {
		return workOrderFormatTypeCd;
	}
	/**
	 * @param workOrderFormatTypeCd 설정하려는 workOrderFormatTypeCd입니다.
	 */
	public void setWorkOrderFormatTypeCd(String workOrderFormatTypeCd) {
		this.workOrderFormatTypeCd = workOrderFormatTypeCd;
	}
	/**
	 * @return workOrderFormatTypeNm을 리턴합니다.
	 */
	public String getWorkOrderFormatTypeNm() {
		return workOrderFormatTypeNm;
	}
	/**
	 * @param workOrderFormatTypeNm 설정하려는 workOrderFormatTypeNm입니다.
	 */
	public void setWorkOrderFormatTypeNm(String workOrderFormatTypeNm) {
		this.workOrderFormatTypeNm = workOrderFormatTypeNm;
	}
	/**
	 * @return workOrderNo을 리턴합니다.
	 */
	public String getWorkOrderNo() {
		return workOrderNo;
	}
	/**
	 * @param workOrderNo 설정하려는 workOrderNo입니다.
	 */
	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}	
	
	/**
	 * @return trsp_bnd_cd 리턴합니다.
	 */
	public String getBndCode() {
		return trspBbndCd;
	}
	/**
	 * @param trsp_bnd_cd 설정하려는 trsp_bnd_cd입니다.
	 */
	public void setBndCode(String trsp_bnd_cd) {
		this.trspBbndCd = trsp_bnd_cd;
	}	
	
	/**
	 * @return trsp_cost_dtl_mod_cd 리턴합니다.
	 */
	public String getCostDtlModCode() {
		return trspCostDtlModCd;
	}
	/**
	 * @param trsp_cost_dtl_mod_cd 설정하려는 trsp_cost_dtl_mod_cd입니다.
	 */
	public void setCostDtlModCode(String trsp_cost_dtl_mod_cd) {
		this.trspCostDtlModCd = trsp_cost_dtl_mod_cd;
	}	
	
	/**
	 * @return trsp_cost_dtl_mod_nm 리턴합니다.
	 */
	public String getCostDtlModNm() {
		return trspCostDtlModNm;
	}
	/**
	 * @param trsp_cost_dtl_mod_nm 설정하려는 trsp_cost_dtl_mod_nm입니다.
	 */
	public void setCostDtlModNm(String trsp_cost_dtl_mod_nm) {
		this.trspCostDtlModNm = trsp_cost_dtl_mod_nm;
	}	
	
	/**
	 * @return trsp_crr_mod_nm 리턴합니다.
	 */
	public String getCrrModNm() {
		return trspCrrModNm;
	}
	/**
	 * @param trsp_crr_mod_nm 설정하려는 trsp_crr_mod_nm입니다.
	 */
	public void setCrrModNm(String trsp_crr_mod_nm) {
		this.trspCrrModNm = trsp_crr_mod_nm;
	}	
	
	/**
	 * @return ib_vvd_cd 리턴합니다.
	 */
	public String getIbVvdCode() {
		return ibVvdCd;
	}
	/**
	 * @param ib_vvd_cd 설정하려는 ib_vvd_cd입니다.
	 */
	public void setIbVvdCode(String ib_vvd_cd) {
		this.ibVvdCd = ib_vvd_cd;
	}	
	
	/**
	 * @return ob_vvd_cd 리턴합니다.
	 */
	public String getObVvdCode() {
		return obVvdCd;
	}
	/**
	 * @param ob_vvd_cd 설정하려는 ob_vvd_cd입니다.
	 */
	public void setObVvdCode(String ob_vvd_cd) {
		this.obVvdCd = ob_vvd_cd;
	}
	/**
	 * 
	 * @return maeFlg 리턴합니다.
	 */
	public String getMaeFlg() {
		return maeFlg;
	}
	/**
	 * 
	 * @param maeFlg 설정하려는 maeFlg입니다.
	 */
	public void setMaeFlg(String maeFlg) {
		this.maeFlg = maeFlg;
	}
	/**
	 * 
	 * @return creOfcCd 리턴합니다.
	 */
	public String getCreOfcCd() {
		return creOfcCd;
	}
	/**
	 * 
	 * @param creOfcCd 설정하려는 creOfcCd입니다.
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	/**
	 * 
	 * @return creUsrId 리턴합니다.
	 */
	public String getCreUsrId() {
		return creUsrId;
	}
	/**
	 * 
	 * @param creUsrId 설정하려는 creUsrId입니다.
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}	
			
}
