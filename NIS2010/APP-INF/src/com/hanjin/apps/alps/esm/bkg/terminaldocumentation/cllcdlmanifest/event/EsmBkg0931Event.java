/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0931Event.java
*@FileTitle : ESM_BKG_0931
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllModifyVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0931 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0931HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seung Min
 * @see ESM_BKG_0931HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0931Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorCllModifyVO korCllModifyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private KorCllModifyVO[] korCllModifyVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorCllCondVO korCllCondVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private KorCllCondVO[] korCllCondVOs = null;

	public EsmBkg0931Event(){}
	
	public void setKorCllModifyVO(KorCllModifyVO korCllModifyVO){
		this. korCllModifyVO = korCllModifyVO;
	}

	public void setKorCllModifyVOS(KorCllModifyVO[] korCllModifyVOs){
		this. korCllModifyVOs = korCllModifyVOs;
	}

	public void setKorCllCondVO(KorCllCondVO korCllCondVO){
		this. korCllCondVO = korCllCondVO;
	}

	public void setKorCllConVOS(KorCllCondVO[] korCllCondVOs){
		this. korCllCondVOs = korCllCondVOs;
	}

	public KorCllModifyVO getKorCllModifyVO(){
		return korCllModifyVO;
	}

	public KorCllModifyVO[] getKorCllModifyVOS(){
		return korCllModifyVOs;
	}

	public KorCllCondVO getKorCllCondVO(){
		return korCllCondVO;
	}

	public KorCllCondVO[] getKorCllCondVOS(){
		return korCllCondVOs;
	}

}