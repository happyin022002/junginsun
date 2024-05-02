/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0139Event.java
*@FileTitle : AccountReceivableInvoiceMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2014.08.27 최도순
* 1.0 Creation
* History
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCEmlVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvArStupOfcVO;


/**
 * FNS_INV_0139 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0139HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0139HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0139Event extends EventSupport {


	private static final long serialVersionUID = 1L;
	
	private String pageType = null;	
	
	private String ofcCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArStupOfcVO invArStupOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArStupOfcVO[] invArStupOfcVOs = null;
	
	private GeneralInvoiceVO genInvVo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private NYCInvoiceVO nYCInvoiceVO = null;
	
	private NYCEmlVO nYCEmlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<NYCInvoiceVO> nYCInvoiceVOs;
	
	/* BackEndJob Key */
	private String backEndJobKey = "";

	public FnsInv0139Event(){}
	
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

	public void setInvArStupOfcVO(InvArStupOfcVO invArStupOfcVO){
		this. invArStupOfcVO = invArStupOfcVO;
	}

	public void setInvArStupOfcVOS(InvArStupOfcVO[] invArStupOfcVOs){
		this. invArStupOfcVOs = invArStupOfcVOs;
	}

	public InvArStupOfcVO getInvArStupOfcVO(){
		return invArStupOfcVO;
	}

	public InvArStupOfcVO[] getInvArStupOfcVOS(){
		return invArStupOfcVOs;
	}

	public GeneralInvoiceVO getGenInvVo() {
		return genInvVo;
	}

	public void setGenInvVo(GeneralInvoiceVO genInvVo) {
		this.genInvVo = genInvVo;
	}
	

	public NYCInvoiceVO getNYCInvoiceVO() {
		return nYCInvoiceVO;
	}

	public void setNYCInvoiceVO(NYCInvoiceVO nYCInvoiceVO) {
		this.nYCInvoiceVO = nYCInvoiceVO;
	}

	public List<NYCInvoiceVO> getNYCInvoiceVOs() {
		return nYCInvoiceVOs;
	}

	public void setNYCInvoiceVOs(List<NYCInvoiceVO> nYCInvoiceVOs) {
		this.nYCInvoiceVOs = nYCInvoiceVOs;
	}


	public NYCEmlVO getNYCEmlVO() {
		return nYCEmlVO;
	}

	public void setNYCEmlVO(NYCEmlVO nYCEmlVO) {
		this.nYCEmlVO = nYCEmlVO;
	}

	/**
	 * @return the backEndJobKey
	 */
	public String getBackEndJobKey() {
		return backEndJobKey;
	}

	/**
	 * @param backEndJobKey the backEndJobKey to set
	 */
	public void setBackEndJobKey(String backEndJobKey) {
		this.backEndJobKey = backEndJobKey;
	}

}