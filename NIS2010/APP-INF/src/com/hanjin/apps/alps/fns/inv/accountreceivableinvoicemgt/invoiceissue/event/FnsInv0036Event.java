/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0036Event.java
*@FileTitle : (Vietnam) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.29 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEDailyExrateVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see FNS_INV_0036HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private GeneralInvoiceVO generalInvoiceVO = null;
	
	private VIEDailyExrateVO vIEDailyExrateVO = null;
	
	private String eventType = "";
	
	private String pageType = "";
	
	private String eventOfc = "";
	
	public FnsInv0036Event(){}
	
	public void setGeneralInvoiceVO(GeneralInvoiceVO generalInvoiceVO){
		this. generalInvoiceVO = generalInvoiceVO;
	}
	
	public GeneralInvoiceVO getGeneralInvoiceVO(){
		return generalInvoiceVO;
	}
	
	public void setVIEDailyExrateVO(VIEDailyExrateVO vIEDailyExrateVO){
		this. vIEDailyExrateVO = vIEDailyExrateVO;
	}
	
	public VIEDailyExrateVO getVIEDailyExrateVO(){
		return vIEDailyExrateVO;
	}
	
	public void setEventType(String eventType){
		this. eventType = eventType;
	}

	public String getEventType(){
		return eventType;
	}
	
	public void setPageType(String pageType){
		this. pageType = pageType;
	}

	public String getPageType(){
		return pageType;
	}

	public String getEventOfc() {
		return eventOfc;
	}

	public void setEventOfc(String eventOfc) {
		this.eventOfc = eventOfc;
	}
	
}