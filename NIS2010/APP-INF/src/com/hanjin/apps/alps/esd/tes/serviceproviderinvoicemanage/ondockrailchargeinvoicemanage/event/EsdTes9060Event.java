/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_906Event.java
*@FileTitle : Marine Terminal Strorage - total amount popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-11-16 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_906 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_906HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9060Event extends EventSupport {
	
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;

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
	

//	/** tes_tml_so_hdr Table  Value Object */
//	private TES_TML_SO_HDR tes_tml_so_hdr = null;
//
//	/** param용 HashMap */
//	private HashMap param_map = null;
//	
//	public EsdTes9060Event(){}
//
//	public EsdTes9060Event(TES_TML_SO_HDR tes_tml_so_hdr) {
//		this.tes_tml_so_hdr = tes_tml_so_hdr;
//    }
//
//	public EsdTes9060Event(TES_TML_SO_HDR tes_tml_so_hdr, HashMap param_map) {
//		this.tes_tml_so_hdr = tes_tml_so_hdr;
//		this.param_map = param_map;
//    }
//
//	public TES_TML_SO_HDR getTES_TML_SO_HDR(){
//		return tes_tml_so_hdr;
//	}
//
//	public HashMap getParams(){
//		return param_map;
//	}
//	
//	public String getEventName() {
//		return "ESD_TES_906Event";
//	}
//
//	public String toString() {
//		return "ESD_TES_906Event";
//	}

}
