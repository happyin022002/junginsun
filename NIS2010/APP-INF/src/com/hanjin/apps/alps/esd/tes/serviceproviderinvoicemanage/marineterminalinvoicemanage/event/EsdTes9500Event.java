/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_919Event.java
*@FileTitle : R/H된 Volume Adjustment PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-14
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-14 parkyeonjin
* 1.0 최초 생성
* 2014-06-19 : 박재흥 [CHM-201429999] TES: Cost Code SVXXHC Vol 계산시 TOR data참조 logic
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TES_919 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_919HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9500Event extends EventSupport {
	
	private TesCommonVO 			tesCommonVO 		= null;
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
	
	//private Collection terminal_invoice_rvis_list = null;
	
	public EsdTes9500Event(){}


	/**
	 * @return the tesCommonVo
	 */
	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}

	/**
	 * @param tesCommonVo the tesCommonVo to set
	 */
	public void setTesCommonVO(TesCommonVO tesCommonVO) {
		this.tesCommonVO = tesCommonVO;
	}

	/**
	 * @return the marineTerminalInvoiceCommonVO
	 */
	public MarineTerminalInvoiceCommonVO getMarineTerminalInvoiceCommonVO() {
		return marineTerminalInvoiceCommonVO;
	}

	/**
	 * @param marineTerminalInvoiceCommonVO the marineTerminalInvoiceCommonVO to set
	 */
	public void setMarineTerminalInvoiceCommonVO(
			MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO) {
		this.marineTerminalInvoiceCommonVO = marineTerminalInvoiceCommonVO;
	}

	
}
