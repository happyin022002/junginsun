/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmBkg0332Event.java
*@FileTitle : EsmBkg0332Event
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
* 2015.06.30
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDiscCYBondInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0332 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0332HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 * 
 * @author 
 * @see ESM_BKG_0332HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0332Event extends EventSupport {

	private static final long serialVersionUID = 7562149991636194708L;

	// 화면에서 넘어오는 파라메터를 저장하는 객체	
	private KorDiscCYBondInfoVO korDiscCYBondInfoVO = null;
	public EsmBkg0332Event() {}


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
