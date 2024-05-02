/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1205Event.java
*@FileTitle : Payable Charge Audit Result & Payable Amount Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.21
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.03.21 조경완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsInvoiceAuditResultCmmtCrMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsPayableInvoiceCreationINVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ees_cgm_1205 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1205HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHO KYOUNG WAN
 * @see ees_cgm_1205HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1205Event extends EventSupport {
	
	private String agmtOfcCtyCd		= null;
	private String agmtSeq			= null;
	private String agmtVerNo		= null;
	private String costYrmon		= null;
	private String costYrmonSeq		= null;
	
	public String getAgmtOfcCtyCd() {
		return agmtOfcCtyCd;
	}
	
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	public String getAgmtSeq() {
		return agmtSeq;
	}
	
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	public String getAgmtVerNo() {
		return agmtVerNo;
	}
	
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	public String getCostYrmon() {
		return costYrmon;
	}
	
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	public String getCostYrmonSeq() {
		return costYrmonSeq;
	}
	
	public void setCostYrmonSeq(String costYrmonSeq) {
		this.costYrmonSeq = costYrmonSeq;
	}
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리 */
	
	private CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO = null;
	
	private CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVOS = null;
	private CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVO1 = null;
	private CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVO2 = null;
	private CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVO3 = null;
	private CHSCpsInvoiceAuditResultCmmtCrMGTVO[] cHSCpsInvoiceAuditResultCmmtCrMGTVOs = null;
	
	
	public CHSCpsPayableInvoiceCreationINVO getChsCpsPayableInvoiceCreationINVO() {
		return chsCpsPayableInvoiceCreationINVO;
	}
	public void setChsCpsPayableInvoiceCreationINVO(
			CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO) {
		this.chsCpsPayableInvoiceCreationINVO = chsCpsPayableInvoiceCreationINVO;
	}
	public CHSCpsPayableInvoiceCreationINVO[] getChsCpsPayableInvoiceCreationINVOS() {
		return chsCpsPayableInvoiceCreationINVOS;
	}
	public void setChsCpsPayableInvoiceCreationINVOS(
			CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVOS) {
		this.chsCpsPayableInvoiceCreationINVOS = chsCpsPayableInvoiceCreationINVOS;
	}
	public CHSCpsPayableInvoiceCreationINVO[] getChsCpsPayableInvoiceCreationINVO1() {
		return chsCpsPayableInvoiceCreationINVO1;
	}
	public void setChsCpsPayableInvoiceCreationINVO1(
			CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVO1) {
		this.chsCpsPayableInvoiceCreationINVO1 = chsCpsPayableInvoiceCreationINVO1;
	}
	public CHSCpsPayableInvoiceCreationINVO[] getChsCpsPayableInvoiceCreationINVO2() {
		return chsCpsPayableInvoiceCreationINVO2;
	}
	public void setChsCpsPayableInvoiceCreationINVO2(
			CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVO2) {
		this.chsCpsPayableInvoiceCreationINVO2 = chsCpsPayableInvoiceCreationINVO2;
	}
	public CHSCpsPayableInvoiceCreationINVO[] getChsCpsPayableInvoiceCreationINVO3() {
		return chsCpsPayableInvoiceCreationINVO3;
	}
	public void setChsCpsPayableInvoiceCreationINVO3(
			CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVO3) {
		this.chsCpsPayableInvoiceCreationINVO3 = chsCpsPayableInvoiceCreationINVO3;
	}
	
	public CHSConfirmPayableAmountINVO getChsConfirmPayableAmountINVO() {
		return chsConfirmPayableAmountINVO;
	}
	public void setChsConfirmPayableAmountINVO(
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) {
		this.chsConfirmPayableAmountINVO = chsConfirmPayableAmountINVO;
	}
	
	public CHSCpsInvoiceAuditResultCmmtCrMGTVO[] getCHSCpsInvoiceAuditResultCmmtCrMGTVOs() {
		return cHSCpsInvoiceAuditResultCmmtCrMGTVOs;
	}
	public void setCHSCpsInvoiceAuditResultCmmtCrMGTVOs(
			CHSCpsInvoiceAuditResultCmmtCrMGTVO[] cHSCpsInvoiceAuditResultCmmtCrMGTVOs) {
		this.cHSCpsInvoiceAuditResultCmmtCrMGTVOs = cHSCpsInvoiceAuditResultCmmtCrMGTVOs;
	}
}