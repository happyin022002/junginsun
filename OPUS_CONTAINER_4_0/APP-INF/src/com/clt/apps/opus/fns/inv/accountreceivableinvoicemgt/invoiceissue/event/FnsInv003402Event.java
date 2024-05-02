/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv003402Event.java
*@FileTitle : Invoice Issue (Email)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.07.06 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmailFaxVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.InvArIssVO;


/**
 * FNS_INV_0034_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0034_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0034_02HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv003402Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String pageType = null;	
	
	private String ofcCd = null;
	
	private PrintInvoiceVO prtInvoiceVo = null;
	
	private InvEmailFaxVO invEmailFaxVo = null;  
	
	private String sendFlag = null;
	
	private String sendFlag2 = null;
	
	private String ifNo = null;
	
	private String issueGubn = null;
	
	private String rdName = null;
	
	private String sendType = null;
	
	private String issueType = null;
	
	private String copyCnt = null;
	
	private String issLehbb = null;
	
	private String logoGb = null;
	
	private String officeCntCd = null;
	
	private List<String> keys = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvIssMainVO issMainVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvIssMainVO[] issMainVOs = null;
	
	private InvArIssVO[] invArIssVOs = null;

	public FnsInv003402Event(){}
	
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
	
	public String getOfficeCntCd() {
		return officeCntCd;
	}

	public void setOfficeCntCd(String officeCntCd) {
		this.officeCntCd = officeCntCd;
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
		if(invArIssVOs != null){
			InvArIssVO[] tmpVOs = new InvArIssVO[invArIssVOs.length];
			System.arraycopy(invArIssVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invArIssVOs = tmpVOs;
		}
	}

	public InvArIssVO[] getInvArIssVOS(){
		InvArIssVO[] rtnVOs = null;
		if (this.invArIssVOs != null) {
			rtnVOs = new InvArIssVO[invArIssVOs.length];
			System.arraycopy(invArIssVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
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
		InvIssMainVO[] rtnVOs = null;
		if (this.issMainVOs != null) {
			rtnVOs = new InvIssMainVO[issMainVOs.length];
			System.arraycopy(issMainVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param issMainVOs the issMainVOs to set
	 */
	public void setIssMainVOs(InvIssMainVO[] issMainVOs){
		if(issMainVOs != null){
			InvIssMainVO[] tmpVOs = new InvIssMainVO[issMainVOs.length];
			System.arraycopy(issMainVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.issMainVOs = tmpVOs;
		}
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
	 * @return the sendType
	 */
	public String getSendType() {
		return sendType;
	}

	/**
	 * @param sendType the sendType to set
	 */
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	/**
	 * @return the issueType
	 */
	public String getIssueType() {
		return issueType;
	}

	/**
	 * @param issueType the issueType to set
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
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

	public String getIssLehbb() {
		return issLehbb;
	}

	public void setIssLehbb(String issLehbb) {
		this.issLehbb = issLehbb;
	}

	public String getLogoGb() {
		return logoGb;
	}

	public void setLogoGb(String logoGb) {
		this.logoGb = logoGb;
	}	
	
	
  
}