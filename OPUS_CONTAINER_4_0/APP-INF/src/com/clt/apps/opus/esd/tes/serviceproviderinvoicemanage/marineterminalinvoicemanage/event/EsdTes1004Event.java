/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes1004Event.java
*@FileTitle : Get Container List Pop Up
*Open Issues : 
*Change history :
*@LastModifyDate : 2009-10-08
*@LastModifier : lee jung hye
*@LastVersion : 1.0
* 2009-10-08 lee jung hye
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesMgstFuelChgVO;

/**
 * EsdTes1004Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_1004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author lee jung hye
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes1004Event extends EventSupport {
	 //TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_MGSET_FUEL_CHG M
	
	private TesMgstFuelChgVO[] tesMgstFuelChgVOs = null;
	
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
	
	public EsdTes1004Event(){}

	/**
	 * @return the tesMgstFuelChgVOs
	 */
	public TesMgstFuelChgVO[] getTesMgstFuelChgVOs() {
		TesMgstFuelChgVO[] rtnVOs = null;
		if (this.tesMgstFuelChgVOs != null) {
			rtnVOs = Arrays.copyOf(tesMgstFuelChgVOs, tesMgstFuelChgVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesMgstFuelChgVOs the tesMgstFuelChgVOs to set
	 */
	public void setTesMgstFuelChgVOs(TesMgstFuelChgVO[] tesMgstFuelChgVOs){
		if(tesMgstFuelChgVOs != null){
			TesMgstFuelChgVO[] tmpVOs = Arrays.copyOf(tesMgstFuelChgVOs, tesMgstFuelChgVOs.length);
			this.tesMgstFuelChgVOs = tmpVOs;
		}
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