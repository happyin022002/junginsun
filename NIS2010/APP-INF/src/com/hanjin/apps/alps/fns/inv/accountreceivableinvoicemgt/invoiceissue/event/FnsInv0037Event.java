/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0037Event.java
*@FileTitle : (S.China)Invoice Issue (Email)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.09.24 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmailFaxVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvArIssVO;


/**
 * FNS_INV_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String pageType = null;	
	
	private String ofcCd = null;
	
	private PrintInvoiceVO prtInvoiceVo = null;
	
	private InvEmailFaxVO invEmailFaxVo = null;  
	
	private String sendFlag = null;
	
	private String sendFlag2 = null;
	
	private String nameFlag = null;
	
	private String titleFlag = null;
	
	private String ifNo = null;
	
	private String issueGubn = null;
	
	private String rdName = null;
	
	private String copyCnt = null;
	
	private List<String> keys = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvIssMainVO issMainVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvIssMainVO[] issMainVOs = null;
	
	private InvArIssVO[] invArIssVOs = null;

	public FnsInv0037Event(){}
	
	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public PrintInvoiceVO getPrtInvoiceVo() {
		return prtInvoiceVo;
	}

	public void setPrtInvoiceVo(PrintInvoiceVO prtInvoiceVo) {
		this.prtInvoiceVo = prtInvoiceVo;
	}

	public InvEmailFaxVO getInvEmailFaxVo() {
		return invEmailFaxVo;
	}

	public void setInvEmailFaxVo(InvEmailFaxVO invEmailFaxVo) {
		this.invEmailFaxVo = invEmailFaxVo;
	}
	
	public String getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	/**
	 * @return the nameFlag
	 */
	public String getNameFlag() {
		return nameFlag;
	}

	/**
	 * @param nameFlag the nameFlag to set
	 */
	public void setNameFlag(String nameFlag) {
		this.nameFlag = nameFlag;
	}

	/**
	 * @return the titleFlag
	 */
	public String getTitleFlag() {
		return titleFlag;
	}

	/**
	 * @param titleFlag the titleFlag to set
	 */
	public void setTitleFlag(String titleFlag) {
		this.titleFlag = titleFlag;
	}

	/**
	 * @return the ifNo
	 */
	public String getIfNo() {
		return ifNo;
	}

	/**
	 * @param ifNo the ifNo to set
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}

	/**
	 * @return the issueGubn
	 */
	public String getIssueGubn() {
		return issueGubn;
	}

	/**
	 * @param issueGubn the issueGubn to set
	 */
	public void setIssueGubn(String issueGubn) {
		this.issueGubn = issueGubn;
	}	
	
	/**
	 * @return the rdName
	 */
	public String getRdName() {
		return rdName;
	}

	/**
	 * @param rdName the rdName to set
	 */
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}

	public void setInvArIssVOS(InvArIssVO[] invArIssVOs){
		this. invArIssVOs = invArIssVOs;
	}

	public InvArIssVO[] getInvArIssVOS(){
		return invArIssVOs;
	}

	/**
	 * @return the issMain
	 */
	public InvIssMainVO getIssMainVO() {
		return issMainVO;
	}

	/**
	 * @param issMain the issMain to set
	 */
	public void setIssMainVO(InvIssMainVO issMainVO) {
		this.issMainVO = issMainVO;
	}

	/**
	 * @return the issMainVOs
	 */
	public InvIssMainVO[] getIssMainVOs() {
		return issMainVOs;
	}

	/**
	 * @param issMainVOs the issMainVOs to set
	 */
	public void setIssMainVOs(InvIssMainVO[] issMainVOs) {
		this.issMainVOs = issMainVOs;
	}

	/**
	 * @return the keys
	 */
	public List<String> getKeys() {
		return keys;
	}

	/**
	 * @param keys the keys to set
	 */
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	/**
	 * @return the sendFlag2
	 */
	public String getSendFlag2() {
		return sendFlag2;
	}

	/**
	 * @param sendFlag2 the sendFlag2 to set
	 */
	public void setSendFlag2(String sendFlag2) {
		this.sendFlag2 = sendFlag2;
	}

	public String getCopyCnt() {
		return copyCnt;
	}

	public void setCopyCnt(String copyCnt) {
		this.copyCnt = copyCnt;
	}	
	
}