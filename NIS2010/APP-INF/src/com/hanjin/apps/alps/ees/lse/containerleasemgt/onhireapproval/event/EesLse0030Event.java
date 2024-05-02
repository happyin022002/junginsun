/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0030Event.java
*@FileTitle : On Hire Approval Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.15 진준성
* 1.0 Creation
* ***************************************************
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.LseOnhAproVO;


/**
 * ees_lse_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_lse_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see ees_lse_0030HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LseOnhAproVO lseOnhAproVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public LseOnhAproVO[] lseOnhAproVOs = null;
	
    private OnhireApprovalVO onhireApprovalVO = null;
		
    public OnhireApprovalVO[] onhireApprovalVOs = null;
	
	private String lstmcd        = null;
	private String locCd         = null;
	private String onhLocCd      = null;
	private String cntrOnhAuthNo = null;
	private String agmtCtyCd     = null;
	private String agmtSeq       = null;
	private String pkupDueDt     = null;
	private String aproRmk       = null;
	private String tpszCd        = null;
	private String tysz          = null;
	private String reqno         = null;
	private String locTp         = null;
	private String locCod        = null;
	private String eccCd         = null;
	
	public EesLse0030Event(){}
	
	public void setLseOnhAproVO(LseOnhAproVO lseOnhAproVO){
		this.lseOnhAproVO = lseOnhAproVO;
	}
	public void setLseOnhAproVOS(LseOnhAproVO[] lseOnhAproVOs){
		this.lseOnhAproVOs = lseOnhAproVOs;
	}
	public void setLstmcd(String pLstmcd){
		this.lstmcd = pLstmcd;
	}
	public void setOnhLocCd(String pOnhLocCd){
		this.onhLocCd = pOnhLocCd;
	}
	public void setCntrOnhAuthNo(String pCntrOnhAuthNo){
		this.cntrOnhAuthNo = pCntrOnhAuthNo;
	}
	public void setAgmtCtyCd(String agmtCtyCd){
		this.agmtCtyCd = agmtCtyCd;
	}
	public void setAgmtSeq(String agmtSeq){
		this.agmtSeq = agmtSeq;
	}
	public void setOnhireApprovalVO (OnhireApprovalVO onhireApprovalVO){
		this.onhireApprovalVO = onhireApprovalVO;
	}
	public void setOnhireApprovalVOs (OnhireApprovalVO[] onhireApprovalVOs){
		this. onhireApprovalVOs = onhireApprovalVOs;
	}
	public void setPkupDueDt(String pkupDueDt){
		this.pkupDueDt = pkupDueDt;
	}
	public void setAproRmk(String aproRmk){
		this.aproRmk = aproRmk;
	}
	public void setTpszCd(String tpszCd){
		this.tpszCd = tpszCd;
	}
	public void setTysz(String tysz){
		this.tysz = tysz;
	}
	public LseOnhAproVO getLseOnhAproVO(){
		return lseOnhAproVO;
	}
	public LseOnhAproVO[] getLseOnhAproVOS(){
		return lseOnhAproVOs;
	}
	public String getLstmcd(){
		return lstmcd;
	}
	public String getOnhLocCd(){
		return onhLocCd;
	}
	public String getCntrOnhAuthNo(){
		return cntrOnhAuthNo;
	}
	public String getAgmtCtyCd(){
		return agmtCtyCd;
	}
	public String getAgmtSeq(){
		return agmtSeq;
	}
    public OnhireApprovalVO getOnhireApprovalVO(){
		return onhireApprovalVO;
	}
    public OnhireApprovalVO[] getOnhireApprovalVOs(){
		return onhireApprovalVOs;
	}
	public String getPkupDueDt(){
		return pkupDueDt;
	}
	public String getAproRmk(){
		return aproRmk;
	}
	public String getTpszCd(){
		return tpszCd;
	}
	public String getTysz(){
		return tysz;
	}
	public String getLocTp() {
		return locTp;
	}

	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}
	
	public String getLocCod() {
		return locCod;
	}

	public void setLocCod(String locCod) {
		this.locCod = locCod;
	}
	
	public String getEccCd() {
		return eccCd;
	}

	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	public void setLocCd(String locCd){
		this.locCd = locCd;
	}
	public String getLocCd(){
		return locCd;
	}	

	/**
	 * @return the reqno
	 */
	public String getReqno() {
		return reqno;
	}

	/**
	 * @param reqno the reqno to set
	 */
	public void setReqno(String reqno) {
		this.reqno = reqno;
	}
	
}