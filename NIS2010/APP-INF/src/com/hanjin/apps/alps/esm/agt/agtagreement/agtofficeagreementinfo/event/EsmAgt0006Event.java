/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_AGT_006Event.java
 *@FileTitle : 지역/점소 조회 및 다중 선택(Pop-up)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.02
 *@LastModifier : 추경원
 *@LastVersion : 1.0
 * 2009.09.02 추경원
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event;

import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtGeogOfcVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_AGT_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kyung-won Chu
 * @see ESM_AGT_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private AgtGeogOfcVO agtGeogOfcVO = null;

	/** Table Value Object Multi Data 처리 */
	private AgtGeogOfcVO[] agtGeogOfcVOs = null;

	public EsmAgt0006Event() {
	}

	public void setAgtGeogOfcVO(AgtGeogOfcVO agtGeogOfcVO) {
		this.agtGeogOfcVO = agtGeogOfcVO;
	}

	public void setAgtGeogOfcVOS(AgtGeogOfcVO[] agtGeogOfcVOs) {
		this.agtGeogOfcVOs = agtGeogOfcVOs;
	}

	public AgtGeogOfcVO getAgtGeogOfcVO() {
		return agtGeogOfcVO;
	}

	public AgtGeogOfcVO[] getAgtGeogOfcVOS() {
		return agtGeogOfcVOs;
	}

}