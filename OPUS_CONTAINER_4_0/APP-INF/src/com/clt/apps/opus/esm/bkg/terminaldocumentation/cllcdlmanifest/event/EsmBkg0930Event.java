/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0930Event.java
*@FileTitle : ESM_BKG_0930
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllModifyVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0930 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0930HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seung Min
 * @see ESM_BKG_0930HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0930Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorCllModifyVO korCllModifyVO = null;

	/** Table Value Object Multi Data 처리 */
	private KorCllModifyVO[] korCllModifyVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorCllCondVO korCllCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private KorCllCondVO[] korCllCondVOs = null;

	public EsmBkg0930Event(){}

	public void setKorCllModifyVO(KorCllModifyVO korCllModifyVO){
		this. korCllModifyVO = korCllModifyVO;
	}

	public void setKorCllCondVO(KorCllCondVO korCllCondVO){
		this. korCllCondVO = korCllCondVO;
	}

	public KorCllModifyVO getKorCllModifyVO(){
		return korCllModifyVO;
	}

	public KorCllCondVO getKorCllCondVO(){
		return korCllCondVO;
	}

	public KorCllModifyVO[] getKorCllModifyVOS() {
		KorCllModifyVO[] rtnVOs = null;
		if (this.korCllModifyVOs != null) {
			rtnVOs = Arrays.copyOf(korCllModifyVOs, korCllModifyVOs.length);
		}
		return rtnVOs;
	}

	public void setKorCllModifyVOS(KorCllModifyVO[] korCllModifyVOs) {
		if (korCllModifyVOs != null) {
			KorCllModifyVO[] tmpVOs = Arrays.copyOf(korCllModifyVOs, korCllModifyVOs.length);
			this.korCllModifyVOs = tmpVOs;
		}
	}

	public KorCllCondVO[] getKorCllCondVOS() {
		KorCllCondVO[] rtnVOs = null;
		if (this.korCllCondVOs != null) {
			rtnVOs = Arrays.copyOf(korCllCondVOs, korCllCondVOs.length);
		}
		return rtnVOs;
	}

	public void setKorCllCondVOS(KorCllCondVO[] korCllCondVOs) {
		if (korCllCondVOs != null) {
			KorCllCondVO[] tmpVOs = Arrays.copyOf(korCllCondVOs, korCllCondVOs.length);
			this.korCllCondVOs = tmpVOs;
		}
	}


}