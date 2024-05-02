/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0358Event.java
*@FileTitle : EsmBkg0358Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorMrnCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0358 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0358HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 *
 * @author 박상훈
 * @see ESM_BKG_0358HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0358Event extends EventSupport {

	private static final long serialVersionUID = 7562149991636194708L;

	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorMrnCondVO korMrnCondVO = null;

	public EsmBkg0358Event() {}

	/**
	 * @return the korMrnCondVO
	 */
	public KorMrnCondVO getKorMrnCondVO() {
		return korMrnCondVO;
	}

	/**
	 * @param korMrnCondVO the korMrnCondVO to set
	 */
	public void setKorMrnCondVO(KorMrnCondVO korMrnCondVO) {
		this.korMrnCondVO = korMrnCondVO;
	}



}
