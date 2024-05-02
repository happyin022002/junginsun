/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0917Event.java
*@FileTitle : EsmBkg0917Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0917 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0917HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 * 
 * @author 박상훈
 * @see ESM_BKG_0917HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0917Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorRcvHistCondVO korRcvHistCondVO = null;
	private KorRcvHistVO[] korRcvHistVOs = null;
	
	public EsmBkg0917Event() {}

	/**
	 * @return the korRcvHistCondVO
	 */
	public KorRcvHistCondVO getKorRcvHistCondVO() {
		return korRcvHistCondVO;
	}

	/**
	 * @param korRcvHistCondVO the korRcvHistCondVO to set
	 */
	public void setKorRcvHistCondVO(KorRcvHistCondVO korRcvHistCondVO) {
		this.korRcvHistCondVO = korRcvHistCondVO;
	}

	/**
	 * @return the korRcvHistVOs
	 */
	public KorRcvHistVO[] getKorRcvHistVOs() {
		return korRcvHistVOs;
	}

	/**
	 * @param korRcvHistVOs the korRcvHistVOs to set
	 */
	public void setKorRcvHistVOs(KorRcvHistVO[] korRcvHistVOs) {
		this.korRcvHistVOs = korRcvHistVOs;
	}

}
