/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0029Event.java
*@FileTitle : On Hire Approval creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.09 진준성
* 1.0 Creation
* ******************************************************
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.LseOnhAproVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;

/**
 * EES_LSE_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0029HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LseOnhAproVO lseOnhAproVO = null;
	private OnhireApprovalVO onhireApprovalVO = null;
	/** Table Value Object Multi Data 처리 */
	public LseOnhAproVO[] lseOnhAproVOs = null;
	public OnhireApprovalVO[] onhireApprovalVOs = null;
	private String locCd     = null;
	private String leaseTerm = null;
	private String pkupDueDt = null;
	private String aproRmk   = null;
	private String tpszCd    = null;
	private String reqno     = null;
	private String agmtSeq   = null;
	private String agmtCtyCd = "HHO";
	private String locTp     = null;
	private String locCod    = null;
	private String eccCd     = null;
	
	public EesLse0029Event(){}
	
	public void setLseOnhAproVO(LseOnhAproVO lseOnhAproVO){
		this. lseOnhAproVO = lseOnhAproVO;
	}

	public void setLseOnhAproVOS(LseOnhAproVO[] lseOnhAproVOs){
		this. lseOnhAproVOs = lseOnhAproVOs;
	}	
	public void setOnhireApprovalVOs (OnhireApprovalVO[] onhireApprovalVOs){
		this. onhireApprovalVOs = onhireApprovalVOs;
	}
	
	public void setOnhireApprovalVO (OnhireApprovalVO onhireApprovalVO){
		this. onhireApprovalVO = onhireApprovalVO;
	}
	
	public void setLocCd(String locCd){
		this.locCd = locCd;
	}
	
	public void setLeaseTerm(String leaseTerm){
		this.leaseTerm = leaseTerm;
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
	
	public LseOnhAproVO getLseOnhAproVO(){
		return lseOnhAproVO;
	}

	public LseOnhAproVO[] getLseOnhAproVOS(){
		return lseOnhAproVOs;
	}

	public OnhireApprovalVO[] getOnhireApprovalVOs(){
		return onhireApprovalVOs;
	}
	
	public OnhireApprovalVO getOnhireApprovalVO(){
		return onhireApprovalVO;
	}
	
	public String getLocCd(){
		return locCd;
	}
	
	public String getLeaseTerm(){
		return leaseTerm;
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

	public String getAgmtSeq() {
		return agmtSeq;
	}

	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	public String getAgmtCtyCd() {
		return agmtCtyCd;
	}

	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
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