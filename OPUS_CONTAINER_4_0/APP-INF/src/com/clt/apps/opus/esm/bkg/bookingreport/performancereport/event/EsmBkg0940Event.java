/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0740Event.java
 *@FileTitle : 0940 I/B DOC Performance Report 정보를 조회합니다.
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

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.InBoundReportInVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0940 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0940HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 김경섭
 * @see ESM_BKG_0940HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmBkg0940Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private InBoundReportInVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private InBoundReportInVO[] infoVOs = null;


	public InBoundReportInVO getInfoVO() {
		return infoVO;
	}


	public void setInfoVO(InBoundReportInVO infoVO) {
		this.infoVO = infoVO;
	}


	public InBoundReportInVO[] getInfoVOs() {
		InBoundReportInVO[] rtnVOs = null;
		if(this.infoVOs != null){
			rtnVOs= Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}


	public void setInfoVOs(InBoundReportInVO[] infoVOs) {
		if(infoVOs != null){
			InBoundReportInVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}


	public EsmBkg0940Event() {
	}

}