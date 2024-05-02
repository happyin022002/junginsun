/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0066Event.java
 *@FileTitle : 0066 B/L Processing Report 정보를 조회합니다.
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.25 김경섭
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocTurnTimeInVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 김경섭
 * @see ESM_BKG_0066HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmBkg0066Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private DocTurnTimeInVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private DocTurnTimeInVO[] infoVOs = null;

	public DocTurnTimeInVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(DocTurnTimeInVO infoVO) {
		this.infoVO = infoVO;
	}

	public DocTurnTimeInVO[] getInfoVOs() {
		DocTurnTimeInVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(DocTurnTimeInVO[] infoVOs){
		if(infoVOs != null){
			DocTurnTimeInVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

	public EsmBkg0066Event() {
	}

}