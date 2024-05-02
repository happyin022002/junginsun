/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0502Event.java
*@FileTitle : TransmitHistory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.08 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransHistVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0502 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0502HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author charves
 * @see ESM_BKG_0502HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0502Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	KorTransHistVO korTransHistVO = null;

	public EsmBkg0502Event() {}

	/**
	 * @return the korTransHistVO
	 */
	public KorTransHistVO getKorTransHistVO() {
		return korTransHistVO;
	}

	/**
	 * @param korTransHistVO the korTransHistVO to set
	 */
	public void setKorTransHistVO(KorTransHistVO korTransHistVO) {
		this.korTransHistVO = korTransHistVO;
	}


}