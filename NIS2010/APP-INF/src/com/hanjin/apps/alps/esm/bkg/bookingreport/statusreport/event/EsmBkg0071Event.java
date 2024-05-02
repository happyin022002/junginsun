/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0071Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchBDRBookingStatusListVO;


/**
 * ESM_BKG_0071 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0071HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0071Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBDRBookingStatusListVO infoVO = null;
	
	public SearchBDRBookingStatusListVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(SearchBDRBookingStatusListVO infoVO) {
		this.infoVO = infoVO;
	}

	public SearchBDRBookingStatusListVO[] getInfoVOs() {
		return infoVOs;
	}

	public void setInfoVOs(SearchBDRBookingStatusListVO[] infoVOs) {
		this.infoVOs = infoVOs;
	}

	/** Table Value Object Multi Data 처리 */
	private SearchBDRBookingStatusListVO[] infoVOs = null;
	
	
	public EsmBkg0071Event(){}
	
	private static final long serialVersionUID = 1L;
	
	
}