/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes0001Event.java
*@FileTitle : Marine Terminal Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-20
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-02-20 kimjinjoo
* 1.0 최초 생성
* 2009-03-12 [R200903110001] : TES_TML_SO_PAY_DYS 테이블 미사용 제거 주석처리 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;
import com.hanjin.syscommon.common.table.TesTmlSoAccmVO;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;
import com.hanjin.syscommon.common.table.TesTmlSoRvisListVO;
import com.hanjin.syscommon.common.table.TesTmlSoVvdListVO;

/**
 * ESD_TES_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0001Event extends EventSupport {
	
	private TesTmlSoAccmVO 		tesTmlSoAccmVO 		= null;
	private TesTmlSoCntrListVO 	tesTmlSoCntrListVO 	= null;
	private TesTmlSoDtlVO 		tesTmlSoDtlVO 		= null;
	private TesTmlSoRvisListVO 	tesTmlSoRvisListVO 	= null;
	private TesN3rdPtyIfVO		tesN3rdPtyIfVO		= null;		
	private TesTmlSoHdrVO 		tesTmlSoHdrVO 		= null; 
	private TesTmlSoVvdListVO	tesTmlSoVvdListVO   = null; 
	
	private TesCommonVO 		tesCommonVo 		= null;	
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
	
    private TesTmlSoAccmVO[] 			tesTmlSoAccmVOs 	= null;
	private TesTmlSoCntrListVO[]		tesTmlSoCntrListVOs = null;
	private TesTmlSoDtlVO[] 			tesTmlSoDtlVOs 		= null;
	private TesTmlSoRvisListVO[] 		tesTmlSoRvisListVOs = null;
	private TesN3rdPtyIfVO[]			tesN3rdPtyIfVOs		= null;
	private TesTmlSoHdrVO[] 			tesTmlSoHdrVOs 		= null;
	private TesTmlSoVvdListVO[]			tesTmlSoVvdListVOs	= null;
	
	private TesCommonVO[] 				tesCommonVos 		= null;	
	private MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs = null;

	private com.hanjin.framework.component.rowset.DBRowSet rowSet = null;

	public EsdTes0001Event(){}
	
	public String getEventName() { 
		return "EsdTes0001Event";
	}

	public String toString() {
		return "EsdTes0001Event";
	}

	public com.hanjin.framework.component.rowset.DBRowSet getRowSet(){
		return rowSet;
	}

	public void setRowSet(com.hanjin.framework.component.rowset.DBRowSet rowSet){
		this.rowSet = rowSet;
	}

	/**
	 * @return the tesTmlSoAccmVO
	 */
	public TesTmlSoAccmVO getTesTmlSoAccmVO() {
		return tesTmlSoAccmVO;
	}

	/**
	 * @param tesTmlSoAccmVO the tesTmlSoAccmVO to set
	 */
	public void setTesTmlSoAccmVO(TesTmlSoAccmVO tesTmlSoAccmVO) {
		this.tesTmlSoAccmVO = tesTmlSoAccmVO;
	}

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
	 * @return the tesN3rdPtyIfVO
	 */
	public TesN3rdPtyIfVO getTesN3rdPtyIfVO() {
		return tesN3rdPtyIfVO;
	}

	/**
	 * @param tesN3rdPtyIfVO the tesN3rdPtyIfVO to set
	 */
	public void setTesN3rdPtyIfVO(TesN3rdPtyIfVO tesN3rdPtyIfVO) {
		this.tesN3rdPtyIfVO = tesN3rdPtyIfVO;
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
	 * @return the tesTmlSoVvdListVO
	 */
	public TesTmlSoVvdListVO getTesTmlSoVvdListVO() {
		return tesTmlSoVvdListVO;
	}

	/**
	 * @param tesTmlSoVvdListVO the tesTmlSoVvdListVO to set
	 */
	public void setTesTmlSoVvdListVO(TesTmlSoVvdListVO tesTmlSoVvdListVO) {
		this.tesTmlSoVvdListVO = tesTmlSoVvdListVO;
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
	 * @return the tesTmlSoAccmVOs
	 */
	public TesTmlSoAccmVO[] getTesTmlSoAccmVOs() {
		return tesTmlSoAccmVOs;
	}

	/**
	 * @param tesTmlSoAccmVOs the tesTmlSoAccmVOs to set
	 */
	public void setTesTmlSoAccmVOs(TesTmlSoAccmVO[] tesTmlSoAccmVOs) {
		this.tesTmlSoAccmVOs = tesTmlSoAccmVOs;
	}

	/**
	 * @return the tesTmlSoCntrListVOs
	 */
	public TesTmlSoCntrListVO[] getTesTmlSoCntrListVOs() {
		return tesTmlSoCntrListVOs;
	}

	/**
	 * @param tesTmlSoCntrListVOs the tesTmlSoCntrListVOs to set
	 */
	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs) {
		this.tesTmlSoCntrListVOs = tesTmlSoCntrListVOs;
	}

	/**
	 * @return the tesTmlSoDtlVOs
	 */
	public TesTmlSoDtlVO[] getTesTmlSoDtlVOs() {
		return tesTmlSoDtlVOs;
	}

	/**
	 * @param tesTmlSoDtlVOs the tesTmlSoDtlVOs to set
	 */
	public void setTesTmlSoDtlVOs(TesTmlSoDtlVO[] tesTmlSoDtlVOs) {
		this.tesTmlSoDtlVOs = tesTmlSoDtlVOs;
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
	 * @return the tesN3rdPtyIfVOs
	 */
	public TesN3rdPtyIfVO[] getTesN3rdPtyIfVOs() {
		return tesN3rdPtyIfVOs;
	}

	/**
	 * @param tesN3rdPtyIfVOs the tesN3rdPtyIfVOs to set
	 */
	public void setTesN3rdPtyIfVOs(TesN3rdPtyIfVO[] tesN3rdPtyIfVOs) {
		this.tesN3rdPtyIfVOs = tesN3rdPtyIfVOs;
	}

	/**
	 * @return the tesTmlSoHdrVOs
	 */
	public TesTmlSoHdrVO[] getTesTmlSoHdrVOs() {
		return tesTmlSoHdrVOs;
	}

	/**
	 * @param tesTmlSoHdrVOs the tesTmlSoHdrVOs to set
	 */
	public void setTesTmlSoHdrVOs(TesTmlSoHdrVO[] tesTmlSoHdrVOs) {
		this.tesTmlSoHdrVOs = tesTmlSoHdrVOs;
	}

	/**
	 * @return the tesTmlSoVvdListVOs
	 */
	public TesTmlSoVvdListVO[] getTesTmlSoVvdListVOs() {
		return tesTmlSoVvdListVOs;
	}

	/**
	 * @param tesTmlSoVvdListVOs the tesTmlSoVvdListVOs to set
	 */
	public void setTesTmlSoVvdListVOs(TesTmlSoVvdListVO[] tesTmlSoVvdListVOs) {
		this.tesTmlSoVvdListVOs = tesTmlSoVvdListVOs;
	}

	/**
	 * @return the tesCommonVos
	 */
	public TesCommonVO[] getTesCommonVos() {
		return tesCommonVos;
	}

	/**
	 * @param tesCommonVos the tesCommonVos to set
	 */
	public void setTesCommonVos(TesCommonVO[] tesCommonVos) {
		this.tesCommonVos = tesCommonVos;
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

	
	/** tes_tml_so_accm Table  Value Object */
//	private TES_TML_SO_ACCM tes_tml_so_accm = null;

	/** tes_tml_so_accms Multi Action을 위한 Collection */
//	private Collection tes_tml_so_accms = null;

	/** tes_tml_so_cntr_list Table  Value Object */
//	private TES_TML_SO_CNTR_LIST tes_tml_so_cntr_list = null;

	/** tes_tml_so_cntr_lists Multi Action을 위한 Collection */
//	private Collection tes_tml_so_cntr_lists = null;

	/** tes_tml_so_dtl Table  Value Object */
//	private TES_TML_SO_DTL tes_tml_so_dtl = null;

	/** tes_tml_so_dtls Multi Action을 위한 Collection */
//	private Collection tes_tml_so_dtls = null;
	
	/** TerminalInvoiceRvisList Table  Value Object */
//	private TerminalInvoiceRvisList terminal_invoice_rvis_list = null;

	/** TerminalInvoiceN3rdPartyIF Table  Value Object */
//	private TerminalInvoiceN3rdPartyIF terminal_invoice_n3pty_list = null;



	/** TerminalInvoiceRvisLists Multi Action을 위한 Collection */
//	private Collection terminal_invoice_rvis_lists = null;

	/** TerminalInvoiceRvisLists Multi Action을 위한 Collection */
//	private Collection temp_rvis_lists = null;

	/** TerminalInvoiceN3rdPartyIF Multi Action을 위한 Collection */
//	private Collection terminal_invoice_n3pty_lists = null;

	/** TerminalInvoiceN3rdPartyIF Multi Action을 위한 Collection */
//	private Collection temp_n3pty_lists = null;

	/** tes_tml_so_hdr Table  Value Object */
	//private TerminalInvoiceHeader tes_tml_so_hdr = null;//삭제하자..
//	private TES_TML_SO_HDR tes_tml_so_hdr = null;

	/** tes_tml_so_hdrs Multi Action을 위한 Collection */
//	private Collection tes_tml_so_hdrs = null;

	/** tes_tml_so_pay_dys Table  Value Object */
	//private TES_TML_SO_PAY_DYS tes_tml_so_pay_dys = null;	// 테이블 미사용 제거 주석처리 ( 2009-03-12 )

	/** tes_tml_so_pay_dyss Multi Action을 위한 Collection */
	//private Collection tes_tml_so_pay_dyss = null;	// 테이블 미사용 제거 주석처리 ( 2009-03-12 )

//	private TerminalInvoiceVVDList terminalInvoiceVVDList = null;

///	private Collection temp_vvd_lists = null;

	/** tes_tml_so_pay_dyss Multi Action을 위한 Collection */
//	private HashMap param_map = null;


}
