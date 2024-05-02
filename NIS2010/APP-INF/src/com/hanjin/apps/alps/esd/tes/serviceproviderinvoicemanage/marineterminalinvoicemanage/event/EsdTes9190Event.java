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
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;
import com.hanjin.syscommon.common.table.TesTmlSoRvisListVO;



/**
 * ESD_TES_919 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_919HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9190Event extends EventSupport {
	
	private TesTmlSoHdrVO 			tesTmlSoHdrVO 		= null;
	private TesTmlSoDtlVO			tesTmlSoDtlVO		= null;
	private TesTmlSoRvisListVO 		tesTmlSoRvisListVO 	= null;
	private TesTmlSoRvisListVO[] 	tesTmlSoRvisListVOs = null;
	
	private TesCommonVO 			tesCommonVo 		= null;
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
	private MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs = null;
	
	//private Collection terminal_invoice_rvis_list = null;
	
	public EsdTes9190Event(){}


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


	/**
	 * @return the tesTmlSoRvisListVOs
	 */
	public TesTmlSoRvisListVO[] getTesTmlSoRvisListVOs() {
		return tesTmlSoRvisListVOs;
	}


	/**
	 * @param tesTmlSoRvisListVOs the tesTmlSoRvisListVOs to set
	 */
	public void setTesTmlSoRvisListVOs(TesTmlSoRvisListVO[] tesTmlSoRvisListVOs) {
		this.tesTmlSoRvisListVOs = tesTmlSoRvisListVOs;
	}


	/**
	 * @return the marineTerminalInvoiceCommonVOs
	 */
	public MarineTerminalInvoiceCommonVO[] getMarineTerminalInvoiceCommonVOs() {
		return marineTerminalInvoiceCommonVOs;
	}


	/**
	 * @param marineTerminalInvoiceCommonVOs the marineTerminalInvoiceCommonVOs to set
	 */
	public void setMarineTerminalInvoiceCommonVOs(
			MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs) {
		this.marineTerminalInvoiceCommonVOs = marineTerminalInvoiceCommonVOs;
	}


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
}
