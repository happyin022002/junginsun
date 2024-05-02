/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes0017Event.java
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
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjinjoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0017Event extends EventSupport {

	private TesTmlSoHdrVO tesTmlSoHdrVO = null;
	private TesTmlSoDtlVO tesTmlSoDtlVO = null;
	private TesCommonVO tesCommonVo = null;	
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
	private TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
	
	public EsdTes0017Event(){} 
	 
	public String getEventName() { 
		return "EsdTes0017Event";
	}

	public String toString() {
		return "EsdTes0017Event";
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


	
	/** tes_tml_so_hdr Table  Value Object */
//	private TES_TML_SO_HDR tes_tml_so_hdr = null;

	/** tes_tml_so_hdrs Multi Action을 위한 Collection */
//	private Collection tes_tml_so_hdrs = null;

	/** tes_tml_so_hdr Multi Action을 위한 Collection */
//	private HashMap param_map = null;



/*	public EsdTes0017Event(TES_TML_SO_HDR tes_tml_so_hdr) {
		this.tes_tml_so_hdr = tes_tml_so_hdr;
    }

	public EsdTes0017Event(TES_TML_SO_HDR tes_tml_so_hdr, HashMap param_map) {
		this.tes_tml_so_hdr = tes_tml_so_hdr;
		this.param_map= param_map;
    }

	public EsdTes0017Event(TES_TML_SO_HDR tes_tml_so_hdr, Collection tes_tml_so_hdrs) {
		this.tes_tml_so_hdr = tes_tml_so_hdr;
		this.tes_tml_so_hdrs = tes_tml_so_hdrs;
    }

	public EsdTes0017Event(TES_TML_SO_HDR tes_tml_so_hdr, Collection tes_tml_so_hdrs, HashMap param_map) {
		this.tes_tml_so_hdr  = tes_tml_so_hdr;
		this.tes_tml_so_hdrs = tes_tml_so_hdrs;
		this.param_map		 = param_map;
    }

	public TES_TML_SO_HDR getTES_TML_SO_HDR(){
		return tes_tml_so_hdr;
	}

	public Collection getTES_TML_SO_HDRS(){
		return tes_tml_so_hdrs;
	}

	public HashMap getParams(){
		return param_map;
	}
*/

}
