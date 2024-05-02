/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_907_2Event.java
*@FileTitle : Volume Adjustment Inquiry PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-30
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-10-30 kimjinjoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;



/**
 * ESD_TES_907_2 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_907_2HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9072Event extends EventSupport {
	private TesTmlSoCntrListVO  tesTmlSoCntrListVO = null;
	private TesTmlSoHdrVO		tesTmlSoHdrVO = null;
	private TesTmlSoDtlVO 		tesTmlSoDtlVO = null;	
	private TesCommonVO 		tesCommonVo = null;
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
		
	public EsdTes9072Event(){}
	
	public String getEventName() {
		return "EsdTes9072Event";
	}
	
	public String toString() {
		return "EsdTes9072Event";
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

	private TES_TML_SO_CNTR_LIST tes_tml_so_cntr_list = null;

	private Collection tes_tml_so_cntr_lists = null;

	public EsdTes9072Event(HashMap param_map) {
		this.param_map = param_map;
    }

	public EsdTes9072Event(Collection tes_tml_so_cntr_lists, HashMap param_map){
		this.tes_tml_so_cntr_lists = tes_tml_so_cntr_lists;
		this.param_map = param_map;
	}

	public Collection getTES_TML_SO_CNTR_LISTS(){
		return tes_tml_so_cntr_lists;
	}

	public TES_TML_SO_CNTR_LIST getTES_TML_SO_CNTR_LIST(){
		return tes_tml_so_cntr_list;
	}

	public HashMap getParams(){
		return param_map;
	}
*/
	
}
