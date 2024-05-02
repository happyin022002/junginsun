/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_930Event.java
*@FileTitle : Marine Terminal Container List 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-03
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-01-03 kimjinjoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_930 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_930HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjinjoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9300Event extends EventSupport {
	
	
	private TesCommonVO 				tesCommonVO 		= null;	
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
	
	public String getEventName() {
		return "EsdTes9300Event";
	}

	public String toString() {
		return "EsdTes9300Event";
	}
	
	/**
	 * @return the tesCommonVO
	 */
	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}
	/**
	 * @param tesCommonVO the tesCommonVO to set
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
