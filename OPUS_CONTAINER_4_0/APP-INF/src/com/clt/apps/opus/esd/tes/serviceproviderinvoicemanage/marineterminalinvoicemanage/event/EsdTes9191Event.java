/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_919_1Event.java
*@FileTitle : R/H된 Volume Adjustment Inquiry PopUp 화면
*Open Issues :
*Change history :
*@make : 2007-10-30
*@maker : kimjinjoo
*@LastModifyDate : 2009-08-25
*@LastModifier : park chae heung
*@LastVersion : 1.0
* 2007-10-30 kimjinjoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;

/**
 * ESD_TES_919_1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_919_1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9191Event extends EventSupport {
	private TesTmlSoHdrVO		tesTmlSoHdrVO = null;
	private TesTmlSoRvisListVO 	tesTmlSoRvisListVO = null;
	private TesCommonVO 		tesCommonVo = null;
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
	
	public String getEventName() {
		return "EsdTes9191Event";
	}

	public String toString() {
		return "EsdTes9191Event";
	}

	/**
	 * @return the tesTmlSoRvisListVO
	 */
	public TesTmlSoRvisListVO getTesTmlSoRvisListVO() {
		return tesTmlSoRvisListVO;
	}

	/**
	 * @param tesTmlSoRvisListVO the tesTmlSoRvisListVO to set
	 */
	public void setTesTmlSoRvisListVO(TesTmlSoRvisListVO tesTmlSoRvisListVO) {
		this.tesTmlSoRvisListVO = tesTmlSoRvisListVO;
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
	 * @return the tesTmlSoHdrVO
	 */
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	/**
	 * @param tesTmlSoHdrVO the tesTmlSoHdrVO to set
	 */
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}
	
	
	/** param용 HashMap */
/*	private HashMap param_map = null;

	public EsdTes9191Event(){}

	public EsdTes9191Event(HashMap param_map) {
		this.param_map = param_map;
    }

	public HashMap getParams(){
		return param_map;
	}
*/
}
