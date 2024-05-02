/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0068Event.java
*@FileTitle : On-dock Rail Charge Container List 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-13
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-12-13 kimjinjoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_0068 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0068HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjinjoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0068Event extends EventSupport {
	
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;
	

	public String getEventName() {
		return "EsdTes0068Event";
	}

	public String toString() {
		return "EsdTes0068Event";
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
	

	/** tes_tml_so_hdr Table  Value Object */
//	private TES_TML_SO_HDR tes_tml_so_hdr = null;

	/** tes_tml_so_hdrs Multi Action을 위한 Collection */
//	private Collection tes_tml_so_hdrs = null;
/*
	public EsdTes0068Event(){}

	public EsdTes0068Event(TES_TML_SO_HDR tes_tml_so_hdr) {
		this.tes_tml_so_hdr = tes_tml_so_hdr;
    }

	public EsdTes0068Event(TES_TML_SO_HDR tes_tml_so_hdr, Collection tes_tml_so_hdrs) {
		this.tes_tml_so_hdr = tes_tml_so_hdr;
		this.tes_tml_so_hdrs = tes_tml_so_hdrs;
    }

	public TES_TML_SO_HDR getTES_TML_SO_HDR(){
		return tes_tml_so_hdr;
	}

	public Collection getTES_TML_SO_HDRS(){
		return tes_tml_so_hdrs;
	}
*/
}
