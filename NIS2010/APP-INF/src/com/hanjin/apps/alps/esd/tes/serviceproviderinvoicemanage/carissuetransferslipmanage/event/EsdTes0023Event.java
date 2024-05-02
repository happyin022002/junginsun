/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_023Event.java
*@FileTitle : Terminal invoice CSR Creation - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-18
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-18 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0023Event extends EventSupport {
	private TesTmlSoHdrVO 	tesTmlSoHdrVO 	= null;
//	private TesTmlSoHdrVO[] tesTmlSoHdrVOs 	= null;
	
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
//	/**
//	 * @return the tesTmlSoHdrVOs
//	 */
//	public TesTmlSoHdrVO[] getTesTmlSoHdrVOs() {
//		return tesTmlSoHdrVOs;
//	}
//	/**
//	 * @param tesTmlSoHdrVOs the tesTmlSoHdrVOs to set
//	 */
//	public void setTesTmlSoHdrVOs(TesTmlSoHdrVO[] tesTmlSoHdrVOs) {
//		this.tesTmlSoHdrVOs = tesTmlSoHdrVOs;
//	}
//	
	

//	/** tes_tml_so_hdr Table  Value Object */
//	private TES_TML_SO_HDR tes_tml_so_hdr = null;
//	private HashMap param_map = null;
//
//	/** tes_tml_so_hdrs Multi Action을 위한 Collection */
//	private Collection tes_tml_so_hdrs = null;
//
//	public EsdTes0023Event(){}
//
//	public EsdTes0023Event(TES_TML_SO_HDR tes_tml_so_hdr, HashMap param_map) {
//		this.tes_tml_so_hdr = tes_tml_so_hdr;
//		this.param_map = param_map;
//    }
//
//	public EsdTes0023Event(TES_TML_SO_HDR tes_tml_so_hdr, Collection tes_tml_so_hdrs) {
//		this.tes_tml_so_hdr = tes_tml_so_hdr;
//		this.tes_tml_so_hdrs = tes_tml_so_hdrs;
//    }
//
//	public TES_TML_SO_HDR getTES_TML_SO_HDR(){
//		return tes_tml_so_hdr;
//	}
//
//	public Collection getTES_TML_SO_HDRS(){
//		return tes_tml_so_hdrs;
//	}
//	
//    public HashMap getParam_map(){
//        return param_map;
//    }   	
//
//	public String getEventName() {
//		return "ESD_TES_023Event";
//	}
//
//	public String toString() {
//		return "ESD_TES_023Event";
//	}

}
