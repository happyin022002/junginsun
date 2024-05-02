/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0337Event.java
*@FileTitle : EsmBkg0337Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMsnCreateVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0337 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0337HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 * 
 * @author 박상훈
 * @see ESM_BKG_0337HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0337Event extends EventSupport {

	private static final long serialVersionUID = 7562149991636194708L;

	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorMsnCreateVO korMrnInfoVO = null;
	
	public EsmBkg0337Event() {}

	/**
	 * @return the korMrnInfoVO
	 */
	public KorMsnCreateVO getKorMrnInfoVO() {
		return korMrnInfoVO;
	}

	/**
	 * @param korMrnInfoVO the korMrnInfoVO to set
	 */
	public void setKorMrnInfoVO(KorMsnCreateVO korMrnInfoVO) {
		this.korMrnInfoVO = korMrnInfoVO;
	}
	
}
