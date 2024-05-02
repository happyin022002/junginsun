/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0371Event.java
*@FileTitle : EsmBkg0371Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.06.23 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnMsnCreateCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0371 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0371HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son Yun Seuk
 * @see ESM_BKG_0371HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0371Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private KorMrnCreateInfoVO 	 		korMrnCreateInfoVO = null;
	private KorMrnCreateInfoVO[] 	 	korMrnCreateInfoVOs = null;
	private KorMrnCreateInfoCondVO 		korMrnCreateInfoCondVO = null;
	private KorMrnCreateInfoCondVO[] 	korMrnCreateInfoCondVOs = null;
	private KorMrnMsnCreateCondVO[]    korMrnMsnCreateCondVOs = null;

	/**
	 * @return the korMrnMsnCreateCondVOs
	 */
	public KorMrnMsnCreateCondVO[] getKorMrnMsnCreateCondVOs() {
		KorMrnMsnCreateCondVO[] rtnVOs = null;
		if (this.korMrnMsnCreateCondVOs != null) {
			rtnVOs = Arrays.copyOf(korMrnMsnCreateCondVOs, korMrnMsnCreateCondVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param korMrnMsnCreateCondVOs the korMrnMsnCreateCondVOs to set
	 */
	public void setKorMrnMsnCreateCondVOs(KorMrnMsnCreateCondVO[] korMrnMsnCreateCondVOs) {
		if (korMrnMsnCreateCondVOs != null) {
			KorMrnMsnCreateCondVO[] tmpVOs = Arrays.copyOf(korMrnMsnCreateCondVOs, korMrnMsnCreateCondVOs.length);
			this.korMrnMsnCreateCondVOs = tmpVOs;
		}
	}

	/**
	 * @return the korMrnCreateInfoVO
	 */
	public KorMrnCreateInfoVO getKorMrnCreateInfoVO() {
		return korMrnCreateInfoVO;
	}

	/**
	 * @return the korMrnCreateInfoVOs
	 */
	public KorMrnCreateInfoVO[] getKorMrnCreateInfoVOs() {
		KorMrnCreateInfoVO[] rtnVOs = null;
		if (this.korMrnCreateInfoVOs != null) {
			rtnVOs = Arrays.copyOf(korMrnCreateInfoVOs, korMrnCreateInfoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param korMrnCreateInfoVO the korMrnCreateInfoVO to set
	 */
	public void setKorMrnCreateInfoVO(KorMrnCreateInfoVO korMrnCreateInfoVO) {
		this.korMrnCreateInfoVO = korMrnCreateInfoVO;
	}

	/**
	 * @param korMrnCreateInfoVOs the korMrnCreateInfoVOs to set
	 */
	public void setKorMrnCreateInfoVOs(KorMrnCreateInfoVO[] korMrnCreateInfoVOs) {
		if (korMrnCreateInfoVOs != null) {
			KorMrnCreateInfoVO[] tmpVOs = Arrays.copyOf(korMrnCreateInfoVOs, korMrnCreateInfoVOs.length);
			this.korMrnCreateInfoVOs = tmpVOs;
		}
	}

	/**
	 * @return the korMrnCreateInfoCondVO
	 */
	public KorMrnCreateInfoCondVO getKorMrnCreateInfoCondVO() {
		return korMrnCreateInfoCondVO;
	}

	/**
	 * @param korMrnCreateInfoCondVO the korMrnCreateInfoCondVO to set
	 */
	public void setKorMrnCreateInfoCondVO(KorMrnCreateInfoCondVO korMrnCreateInfoCondVO) {
		this.korMrnCreateInfoCondVO = korMrnCreateInfoCondVO;
	}

	/**
	 * @return the korMrnCreateInfoCondVOs
	 */
	public KorMrnCreateInfoCondVO[] getKorMrnCreateInfoCondVOs() {
		KorMrnCreateInfoCondVO[] rtnVOs = null;
		if (this.korMrnCreateInfoCondVOs != null) {
			rtnVOs = Arrays.copyOf(korMrnCreateInfoCondVOs, korMrnCreateInfoCondVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param korMrnCreateInfoCondVOs the korMrnCreateInfoCondVOs to set
	 */
	public void setKorMrnCreateInfoCondVOs(KorMrnCreateInfoCondVO[] korMrnCreateInfoCondVOs) {
		if (korMrnCreateInfoCondVOs != null) {
			KorMrnCreateInfoCondVO[] tmpVOs = Arrays.copyOf(korMrnCreateInfoCondVOs, korMrnCreateInfoCondVOs.length);
			this.korMrnCreateInfoCondVOs = tmpVOs;
		}
	}

}
