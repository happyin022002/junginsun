/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0333Event.java
*@FileTitle : EsmBkg0333Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDiscCYBondInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0333 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0333HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 *
 * @author 박상훈
 * @see ESM_BKG_0333HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0333Event extends EventSupport {

	private static final long serialVersionUID = 7562149991636194708L;

	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorDiscCYBondInfoVO korDiscCYBondInfoVO = null;

	public EsmBkg0333Event() {}

	/**
	 * @return the korDiscCYBondInfoVO
	 */
	public KorDiscCYBondInfoVO getKorDiscCYBondInfoVO() {
		return korDiscCYBondInfoVO;
	}

	/**
	 * @param korDiscCYBondInfoVO the korDiscCYBondInfoVO to set
	 */
	public void setKorDiscCYBondInfoVO(KorDiscCYBondInfoVO korDiscCYBondInfoVO) {
		this.korDiscCYBondInfoVO = korDiscCYBondInfoVO;
	}

}
