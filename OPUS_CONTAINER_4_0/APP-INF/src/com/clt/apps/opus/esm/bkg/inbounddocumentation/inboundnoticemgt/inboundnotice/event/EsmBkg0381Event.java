/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0381Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.05.20 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrivalNoticeSearchVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0381 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0381HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see ESM_BKG_0381HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0381Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private ArrNtcSendListVO listVO = null;
	private ArrNtcSendListVO[] listVOS = null;
	private ArrivalNoticeSearchVO searchVO = null;
	private ArrNtcMrdSearchVO arrNtcMrdSearch = null;
	
	public EsmBkg0381Event() {
	}

//	public ArrNtcSendListVO[] getListVOS() {
//		return listVOS;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public ArrNtcSendListVO[] getListVOS() {
		ArrNtcSendListVO[] tmpVOs = null;
		if (this.listVOS != null) {
			tmpVOs = new ArrNtcSendListVO[listVOS.length];
			System.arraycopy(listVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 

//	public void setListVOS(ArrNtcSendListVO[] listVOS) {
//		this.listVOS = listVOS;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setListVOS(ArrNtcSendListVO[] listVOS) {
		if (listVOS != null) {
			ArrNtcSendListVO[] tmpVOs = new ArrNtcSendListVO[listVOS.length];
			System.arraycopy(listVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.listVOS = tmpVOs;
		}		
	} 
	
	public ArrivalNoticeSearchVO getSearchVO() {
		return searchVO;
	}

	public void setSearchVO(ArrivalNoticeSearchVO searchVO) {
		this.searchVO = searchVO;
	}
	
	public ArrNtcSendListVO getListVO() {
		return listVO;
	}

	public void setListVO(ArrNtcSendListVO listVO) {
		this.listVO = listVO;
	}

	public void setArrNtcMrdSearch(ArrNtcMrdSearchVO arrNtcMrdSearch) {
		this.arrNtcMrdSearch = arrNtcMrdSearch;
	}

	public ArrNtcMrdSearchVO getArrNtcMrdSearch() {
		return arrNtcMrdSearch;
	}


	
}