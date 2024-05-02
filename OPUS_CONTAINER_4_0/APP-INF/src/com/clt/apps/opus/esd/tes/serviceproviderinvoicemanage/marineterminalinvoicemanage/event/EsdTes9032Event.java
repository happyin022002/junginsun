/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes9032Event.java
*@FileTitle : Volume Adjustment PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-15
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-15 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;



/**
 * ESD_TES_9032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9032Event extends EventSupport {
	
	private TesTmlSoCntrListVO  	tesTmlSoCntrListVO 		= null;
	private TesTmlSoCntrListVO[] 	tesTmlSoCntrListVOs 	= null;
	private TesTmlSoHdrVO			tesTmlSoHdrVO 			= null;
	private TesTmlSoDtlVO 			tesTmlSoDtlVO 			= null;	
	private TesCommonVO 			tesCommonVo 			= null;	
	
	private TesTmlSoRvisListVO[]    tesTmlSoRvisListVOs		= null;
	
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO		= null;
	private MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs	= null;
	
	/**
	 * @return the tesTmlSoCntrListVO
	 */
	public TesTmlSoCntrListVO getTesTmlSoCntrListVO() {
		return tesTmlSoCntrListVO;
	}

	/**
	 * @param tesTmlSoCntrListVO the tesTmlSoCntrListVO to set
	 */
	public void setTesTmlSoCntrListVO(TesTmlSoCntrListVO tesTmlSoCntrListVO) {
		this.tesTmlSoCntrListVO = tesTmlSoCntrListVO;
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
	 * @return the tesTmlSoCntrListVOs
	 */
	public TesTmlSoCntrListVO[] getTesTmlSoCntrListVOs() {
		TesTmlSoCntrListVO[] rtnVOs = null;
		if (this.tesTmlSoCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoCntrListVOs the tesTmlSoCntrListVOs to set
	 */
	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs){
		if(tesTmlSoCntrListVOs != null){
			TesTmlSoCntrListVO[] tmpVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
			this.tesTmlSoCntrListVOs = tmpVOs;
		}
	}

	/**
	 * @return the tesTmlSoRvisListVOs
	 */
	public TesTmlSoRvisListVO[] getTesTmlSoRvisListVOs() {
		TesTmlSoRvisListVO[] rtnVOs = null;
		if (this.tesTmlSoRvisListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoRvisListVOs, tesTmlSoRvisListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoRvisListVOs the tesTmlSoRvisListVOs to set
	 */
	public void setTesTmlSoRvisListVOs(TesTmlSoRvisListVO[] tesTmlSoRvisListVOs){
		if(tesTmlSoRvisListVOs != null){
			TesTmlSoRvisListVO[] tmpVOs = Arrays.copyOf(tesTmlSoRvisListVOs, tesTmlSoRvisListVOs.length);
			this.tesTmlSoRvisListVOs = tmpVOs;
		}
	}

	/**
	 * @return the marineTerminalInvoiceCommonVOs
	 */
	public MarineTerminalInvoiceCommonVO[] getMarineTerminalInvoiceCommonVOs() {
		MarineTerminalInvoiceCommonVO[] rtnVOs = null;
		if (this.marineTerminalInvoiceCommonVOs != null) {
			rtnVOs = Arrays.copyOf(marineTerminalInvoiceCommonVOs, marineTerminalInvoiceCommonVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param marineTerminalInvoiceCommonVOs the marineTerminalInvoiceCommonVOs to set
	 */
	public void setMarineTerminalInvoiceCommonVOs(MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs){
		if(marineTerminalInvoiceCommonVOs != null){
			MarineTerminalInvoiceCommonVO[] tmpVOs = Arrays.copyOf(marineTerminalInvoiceCommonVOs, marineTerminalInvoiceCommonVOs.length);
			this.marineTerminalInvoiceCommonVOs = tmpVOs;
		}
	}

	/** param용 HashMap */
	/*	private HashMap param_map = null;

		private TES_TML_SO_CNTR_LIST tes_tml_so_cntr_list = null;

		private Collection tes_tml_so_cntr_lists = null;
		
		private Collection terminal_invoice_rvis_list = null;
		
		public EsdTes9032Event(){}

		public EsdTes9032Event(HashMap param_map) {
			this.param_map = param_map;
	    }

		public EsdTes9032Event(Collection tes_tml_so_cntr_lists, HashMap param_map){
			this.tes_tml_so_cntr_lists = tes_tml_so_cntr_lists;
			this.param_map = param_map;
		}

		public EsdTes9032Event(Collection tes_tml_so_cntr_lists, Collection terminal_invoice_rvis_list, HashMap param_map){
			this.tes_tml_so_cntr_lists = tes_tml_so_cntr_lists;
			this.terminal_invoice_rvis_list = terminal_invoice_rvis_list;
			this.param_map = param_map;
		}

		
		public Collection getTES_TML_SO_CNTR_LISTS(){
			return tes_tml_so_cntr_lists;
		}

		public TES_TML_SO_CNTR_LIST getTES_TML_SO_CNTR_LIST(){
			return tes_tml_so_cntr_list;
		}

		public Collection getTERMINAL_INVOICE_RVIS_LIST(){
			return terminal_invoice_rvis_list;
		}

		public HashMap getParams(){
			return param_map;
		}
	*/	
}
