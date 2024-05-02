/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_1003Event.java
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

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;


/**
 * ESD_TES_013_1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_013_1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjinjoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes1003Event extends EventSupport {
	
	private TesTmlSoDtlVO 	tesTmlSoDtlVO 	= null;
	private TesTmlSoDtlVO[] tesTmlSoDtlVOs 	= null;
	//private TesTmlSoVvdListVO tesTmlSoVvdListVO	= null;
	
	//private TesCommonVO		tesCommonVO		= null;
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null; 
	
	public EsdTes1003Event(){}

	/**
	 * @return the tesTmlSoDtlVO
	 */
	public TesTmlSoDtlVO getTesTmlSoDtlVO() {
		return tesTmlSoDtlVO;
	}

	/**
	 * @param tesTmlSoDtlVO the tesTmlSoDtlVO to set
	 */
	public void setTesTmlSoDtlVO(TesTmlSoDtlVO tesTmlSoDtlVO) {
		this.tesTmlSoDtlVO = tesTmlSoDtlVO;
	}

	/**
	 * @return the tesTmlSoDtlVOs
	 */
	public TesTmlSoDtlVO[] getTesTmlSoDtlVOs() {
		TesTmlSoDtlVO[] rtnVOs = null;
		if (this.tesTmlSoDtlVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoDtlVOs, tesTmlSoDtlVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoDtlVOs the tesTmlSoDtlVOs to set
	 */
	public void setTesTmlSoDtlVOs(TesTmlSoDtlVO[] tesTmlSoDtlVOs){
		if(tesTmlSoDtlVOs != null){
			TesTmlSoDtlVO[] tmpVOs = Arrays.copyOf(tesTmlSoDtlVOs, tesTmlSoDtlVOs.length);
			this.tesTmlSoDtlVOs = tmpVOs;
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

	/**
	 * @return the tesCommonVO
	 */
//	public TesCommonVO getTesCommonVO() {
//		return tesCommonVO;
//	}
//
//	/**
//	 * @param tesCommonVO the tesCommonVO to set
//	 */
//	public void setTesCommonVO(TesCommonVO tesCommonVO) {
//		this.tesCommonVO = tesCommonVO;
//	}

	/**
	 * @return the tesTmlSoVvdListVO
	 */
//	public TesTmlSoVvdListVO getTesTmlSoVvdListVO() {
//		return tesTmlSoVvdListVO;
//	}
//
//	/**
//	 * @param tesTmlSoVvdListVO the tesTmlSoVvdListVO to set
//	 */
//	public void setTesTmlSoVvdListVO(TesTmlSoVvdListVO tesTmlSoVvdListVO) {
//		this.tesTmlSoVvdListVO = tesTmlSoVvdListVO;
//	}
	
}
