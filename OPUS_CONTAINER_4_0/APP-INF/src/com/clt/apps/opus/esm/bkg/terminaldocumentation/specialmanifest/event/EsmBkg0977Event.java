/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0977Event.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.31
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0977 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0977HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0977HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0977Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpecialListCondVO specialListCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private SpecialListVO[] specialListVO = null;


	/**
	 * @return the specialListCondVO
	 */
	public SpecialListCondVO getSpecialListCondVO() {
		return specialListCondVO;
	}

	/**
	 * @param specialListCondVO the specialListCondVO to set
	 */
	public void setSpecialListCondVO(SpecialListCondVO specialListCondVO) {
		this.specialListCondVO = specialListCondVO;
	}

	public SpecialListVO[] getSpecialListVO() {
		SpecialListVO[] rtnVOs = null;
		if (this.specialListVO != null) {
			rtnVOs = Arrays.copyOf(specialListVO, specialListVO.length);
		}
		return rtnVOs;
	}

	public void setSpecialListVO(SpecialListVO[] specialListVO) {
		if (specialListVO != null) {
			SpecialListVO[] tmpVOs = Arrays.copyOf(specialListVO, specialListVO.length);
			this.specialListVO = tmpVOs;
		}
	}




}
