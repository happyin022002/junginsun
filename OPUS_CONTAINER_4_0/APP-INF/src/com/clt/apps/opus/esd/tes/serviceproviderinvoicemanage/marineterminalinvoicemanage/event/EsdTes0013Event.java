/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_013Event.java
*@FileTitle : TerminalInvoiceSummary
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-10-30 kimjinjoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjinjoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0013Event extends EventSupport {
	
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;
	private TesTmlSoDtlVO tesTmlSoDtlVO	= null;
	private TesCommonVO tesCommonVo = null;
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
	
	//DB에 성능LOG 남기기 위해서 필요한 변수들이다.
	private String pageURL = null;			
	private String perfParams = null;
	
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	public TesTmlSoDtlVO getTesTmlSoDtlVO() {
		return tesTmlSoDtlVO;
	}

	public void setTesTmlSoDtlVO(TesTmlSoDtlVO tesTmlSoDtlVO) {
		this.tesTmlSoDtlVO = tesTmlSoDtlVO;
	}
	
	/**
	 * @return the tesCommonVo
	 */
	public TesCommonVO getTesCommonVo() {
		return tesCommonVo;
	}

	/**
	 * @param tesCommonVo the tesCommonVo to set
	 */
	public void setTesCommonVo(TesCommonVO tesCommonVo) {
		this.tesCommonVo = tesCommonVo;
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
	
	/**
	 * @return the pageURL
	 */
	public String getPageURL() {
		return pageURL;
	}

	/**
	 * @param pageURL the pageURL to set
	 */
	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}

	/**
	 * @return the perfParams
	 */
	public String getPerfParams() {
		return perfParams;
	}

	/**
	 * @param perfParams the perfParams to set
	 */
	public void setPerfParams(String perfParams) {
		this.perfParams = perfParams;
	}

}
