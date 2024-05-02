/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0381Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 박성호
 *@LastVersion : 1.0
 * 2009.05.20 박성호
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrivalNoticeSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0381 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0381HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Chang June
 * @see ESM_BKG_0381HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0381Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ArrNtcSendListVO[] listVOS = null;
	private ArrivalNoticeSearchVO searchVO = null;
	private ArrNtcMrdSearchVO arrNtcMrdSearch = null;
	
	public EsmBkg0381Event() {
	}

	public ArrNtcSendListVO[] getListVOS() {
		return listVOS;
	}

	public void setListVOS(ArrNtcSendListVO[] listVOS) {
		this.listVOS = listVOS;
	}

	public ArrivalNoticeSearchVO getSearchVO() {
		return searchVO;
	}

	public void setSearchVO(ArrivalNoticeSearchVO searchVO) {
		this.searchVO = searchVO;
	}

	public void setArrNtcMrdSearch(ArrNtcMrdSearchVO arrNtcMrdSearch) {
		this.arrNtcMrdSearch = arrNtcMrdSearch;
	}

	public ArrNtcMrdSearchVO getArrNtcMrdSearch() {
		return arrNtcMrdSearch;
	}


	
}