/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0072Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BDRBookingStatusListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0072 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_00720HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0072HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0072Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BDRBookingStatusListVO infoVO = null;
	
	public BDRBookingStatusListVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(BDRBookingStatusListVO infoVO) {
		this.infoVO = infoVO;
	}

	public BDRBookingStatusListVO[] getInfoVOs() {
		BDRBookingStatusListVO[] rtnVOs = null;
		if(this.infoVOs != null){
			rtnVOs= Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(BDRBookingStatusListVO[] infoVOs) {
		if(infoVOs != null){
			BDRBookingStatusListVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

	/** Table Value Object Multi Data 처리 */
	private BDRBookingStatusListVO[] infoVOs = null;
	
	
	public EsmBkg0072Event(){}
	
	private static final long serialVersionUID = 1L;
	
	
}