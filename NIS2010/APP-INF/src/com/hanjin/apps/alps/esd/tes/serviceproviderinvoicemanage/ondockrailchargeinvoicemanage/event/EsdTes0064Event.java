/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0064Event.java
*@FileTitle : On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-28 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.vo.OndockRailChargeInvoiceCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_0064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0064Event extends EventSupport {

	private TesTmlSoHdrVO 					tesTmlSoHdrVO 		= null;
	private OndockRailChargeInvoiceCommonVO ondockRailChargeInvoiceCommonVO = null;
	
	private TesTmlSoCntrListVO[] 	tesTmlSoCntrListVOs 	= null;
	private TesTmlSoDtlVO[] 		tesTmlSoDtlVOs			= null;
	
	public EsdTes0064Event(){}


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
	 * @return the ondockRailChargeInvoiceCommonVO
	 */
	public OndockRailChargeInvoiceCommonVO getOndockRailChargeInvoiceCommonVO() {
		return ondockRailChargeInvoiceCommonVO;
	}

	/**
	 * @param ondockRailChargeInvoiceCommonVO the ondockRailChargeInvoiceCommonVO to set
	 */
	public void setOndockRailChargeInvoiceCommonVO(
			OndockRailChargeInvoiceCommonVO ondockRailChargeInvoiceCommonVO) {
		this.ondockRailChargeInvoiceCommonVO = ondockRailChargeInvoiceCommonVO;
	}

	
	/** tes_tml_so_cntr_list Table  Value Object */
//	private TerminalInvoceContainer tes_tml_so_cntr_list = null;

	/** tes_tml_so_cntr_lists Multi Action을 위한 Collection */
//	private Collection tes_tml_so_cntr_lists = null;

	/** tes_tml_so_dtl Table  Value Object */
//	private TES_TML_SO_DTL tes_tml_so_dtl = null;

	/** TerminalInvoiceRvisList Table  Value Object */
//	private TerminalInvoiceRvisList tes_tml_so_rvis_list = null;

	/** TerminalInvoiceN3rdPartyIF Table  Value Object */
//	private TerminalInvoiceN3rdPartyIF tes_n3rd_pty_if = null;

	/** tes_tml_so_dtls Multi Action을 위한 Collection */
//	private Collection tes_tml_so_dtls = null;

	/** TerminalInvoiceRvisLists Multi Action을 위한 Collection */
//	private Collection tes_tml_so_rvis_lists = null;

	/** TerminalInvoiceRvisLists Multi Action을 위한 Collection */
//	private Collection temp_rvis_lists = null;

	/** TerminalInvoiceN3rdPartyIF Multi Action을 위한 Collection */
//	private Collection tes_n3rd_pty_ifs = null;

	/** TerminalInvoiceN3rdPartyIF Multi Action을 위한 Collection */
//	private Collection temp_n3rd_pty_ifs = null;

	/** tes_tml_so_hdr Table  Value Object */
//	private TES_TML_SO_HDR tes_tml_so_hdr = null;

	/** tes_tml_so_hdrs Multi Action을 위한 Collection */
//	private Collection tes_tml_so_hdrs = null;

	/** tes_tml_so_pay_dyss Multi Action을 위한 Collection */
//	private HashMap param_map = null;



/*
	public EsdTes0064Event( TerminalInvoceContainer tes_tml_so_cntr_list) {
		this.tes_tml_so_cntr_list = tes_tml_so_cntr_list;
    }

	public EsdTes0064Event(TerminalInvoceContainer tes_tml_so_cntr_list, Collection tes_tml_so_cntr_lists) {
		this.tes_tml_so_cntr_list = tes_tml_so_cntr_list;
		this.tes_tml_so_cntr_lists = tes_tml_so_cntr_lists;
    }

	public EsdTes0064Event(TerminalInvoceContainer tes_tml_so_cntr_list, Collection tes_tml_so_cntr_lists, TES_TML_SO_DTL tes_tml_so_dtl) {
		this.tes_tml_so_cntr_list = tes_tml_so_cntr_list;
		this.tes_tml_so_cntr_lists = tes_tml_so_cntr_lists;
		this.tes_tml_so_dtl = tes_tml_so_dtl;
    }

	public EsdTes0064Event(TerminalInvoceContainer tes_tml_so_cntr_list, Collection tes_tml_so_cntr_lists, TES_TML_SO_DTL tes_tml_so_dtl, Collection tes_tml_so_dtls) {
		this.tes_tml_so_cntr_list = tes_tml_so_cntr_list;
		this.tes_tml_so_cntr_lists = tes_tml_so_cntr_lists;
		this.tes_tml_so_dtl = tes_tml_so_dtl;
		this.tes_tml_so_dtls = tes_tml_so_dtls;
    }

	public EsdTes0064Event(TerminalInvoceContainer tes_tml_so_cntr_list, Collection tes_tml_so_cntr_lists, TES_TML_SO_DTL tes_tml_so_dtl, Collection tes_tml_so_dtls, TES_TML_SO_HDR tes_tml_so_hdr) {
		this.tes_tml_so_cntr_list = tes_tml_so_cntr_list;
		this.tes_tml_so_cntr_lists = tes_tml_so_cntr_lists;
		this.tes_tml_so_dtl = tes_tml_so_dtl;
		this.tes_tml_so_dtls = tes_tml_so_dtls;
		this.tes_tml_so_hdr = tes_tml_so_hdr;
    }

	public EsdTes0064Event(TerminalInvoiceN3rdPartyIF tes_n3rd_pty_if, Collection tes_n3rd_pty_ifs, TerminalInvoceContainer tes_tml_so_cntr_list, Collection tes_tml_so_cntr_lists, TES_TML_SO_DTL tes_tml_so_dtl, Collection tes_tml_so_dtls, TES_TML_SO_HDR tes_tml_so_hdr, Collection tes_tml_so_hdrs) {
		this.tes_n3rd_pty_if = tes_n3rd_pty_if;
		this.tes_n3rd_pty_ifs = tes_n3rd_pty_ifs;
		this.tes_tml_so_cntr_list = tes_tml_so_cntr_list;
		this.tes_tml_so_cntr_lists = tes_tml_so_cntr_lists;
		this.tes_tml_so_dtl = tes_tml_so_dtl;
		this.tes_tml_so_dtls = tes_tml_so_dtls;
		this.tes_tml_so_hdr = tes_tml_so_hdr;
		this.tes_tml_so_hdrs = tes_tml_so_hdrs;
    }

	public EsdTes0064Event(TerminalInvoiceN3rdPartyIF tes_n3rd_pty_if, Collection tes_n3rd_pty_ifs, TerminalInvoceContainer tes_tml_so_cntr_list, Collection tes_tml_so_cntr_lists, TES_TML_SO_DTL tes_tml_so_dtl, Collection tes_tml_so_dtls, TES_TML_SO_HDR tes_tml_so_hdr, Collection tes_tml_so_hdrs, TerminalInvoiceRvisList tes_tml_so_rvis_list) {
		this.tes_n3rd_pty_if = tes_n3rd_pty_if;
		this.tes_n3rd_pty_ifs = tes_n3rd_pty_ifs;
		this.tes_tml_so_cntr_list = tes_tml_so_cntr_list;
		this.tes_tml_so_cntr_lists = tes_tml_so_cntr_lists;
		this.tes_tml_so_dtl = tes_tml_so_dtl;
		this.tes_tml_so_dtls = tes_tml_so_dtls;
		this.tes_tml_so_hdr = tes_tml_so_hdr;
		this.tes_tml_so_hdrs = tes_tml_so_hdrs;
		this.tes_tml_so_rvis_list = tes_tml_so_rvis_list;
    }

	public EsdTes0064Event(TerminalInvoceContainer tes_tml_so_cntr_list,
							Collection tes_tml_so_cntr_lists,
							TES_TML_SO_DTL tes_tml_so_dtl,
							Collection tes_tml_so_dtls,
							TES_TML_SO_HDR tes_tml_so_hdr,
							Collection tes_tml_so_rvis_lists,
							Collection temp_rvis_lists,
							Collection tes_n3rd_pty_ifs,
							Collection temp_n3rd_pty_ifs,
							HashMap param_map) {
		this.tes_tml_so_cntr_list 	= tes_tml_so_cntr_list;
		this.tes_tml_so_cntr_lists 	= tes_tml_so_cntr_lists;
		this.tes_tml_so_dtl 		= tes_tml_so_dtl;
		this.tes_tml_so_dtls 		= tes_tml_so_dtls;
		this.tes_tml_so_hdr 		= tes_tml_so_hdr;
		this.tes_tml_so_rvis_lists 	= tes_tml_so_rvis_lists;
		this.temp_rvis_lists		= temp_rvis_lists;
		this.tes_n3rd_pty_ifs 		= tes_n3rd_pty_ifs;
		this.temp_n3rd_pty_ifs		= temp_n3rd_pty_ifs;
		this.param_map				= param_map;
    }

	public EsdTes0064Event( TerminalInvoceContainer tes_tml_so_cntr_list, TES_TML_SO_DTL tes_tml_so_dtl, TES_TML_SO_HDR tes_tml_so_hdr, TerminalInvoiceRvisList tes_tml_so_rvis_list) {
		this.tes_tml_so_cntr_list 	= tes_tml_so_cntr_list;
		this.tes_tml_so_dtl 		= tes_tml_so_dtl;
		this.tes_tml_so_hdr 		= tes_tml_so_hdr;
		this.tes_tml_so_rvis_list = tes_tml_so_rvis_list;
	}


	public TerminalInvoceContainer getTerminalInvoceContainer(){
		return tes_tml_so_cntr_list;
	}

	public Collection getTerminalInvoceContainers(){
		return tes_tml_so_cntr_lists;
	}

	public TES_TML_SO_DTL getTES_TML_SO_DTL(){
		return tes_tml_so_dtl;
	}

	public TerminalInvoiceRvisList getTerminalInvoiceRvisList(){
		return tes_tml_so_rvis_list;
	}

	public Collection getTerminalInvoiceRvisLists(){
		return tes_tml_so_rvis_lists;
	}

	public Collection getTempRvisLists(){
		return temp_rvis_lists;
	}

	public Collection getTesN3ptyIfs(){
		return tes_n3rd_pty_ifs;
	}

	public Collection getTempN3ptyIfs(){
		return temp_n3rd_pty_ifs;
	}

	public Collection getTES_TML_SO_DTLS(){
		return tes_tml_so_dtls;
	}

	public TES_TML_SO_HDR getTerminalInvoiceHeader(){
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
