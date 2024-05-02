/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0933Event.java
*@FileTitle : Load Summary by POD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.28 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCondVO;


/**
 * ESM_BKG_0933 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0933HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEUN GMIN KIM
 * @see ESM_BKG_0933HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0933Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorCllCondVO korCllCondVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private KorCllCondVO[] korCllCondVOs = null;

	public EsmBkg0933Event(){}
	
	public void setKorCllCondVO(KorCllCondVO korCllCondVO){
		this. korCllCondVO = korCllCondVO;
	}

	public void setKorCllCondVOS(KorCllCondVO[] korCllCondVOs){
		this. korCllCondVOs = korCllCondVOs;
	}

	public KorCllCondVO getKorCllCondVO(){
		return korCllCondVO;
	}

	public KorCllCondVO[] getKorCllCondVOS(){
		return korCllCondVOs;
	}

}