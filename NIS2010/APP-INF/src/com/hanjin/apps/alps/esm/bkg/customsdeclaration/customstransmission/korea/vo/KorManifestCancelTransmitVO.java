/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorTransCancellCustVO.java
*@FileTitle : KorTransCancellCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorManifestCancelTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;

	private KorTransCancellCustVO korTransCancellCustVO = null;

	public KorTransCancellCustVO getKorTransCancellCustVO() {
		return korTransCancellCustVO;
	}

	public void setKorTransCancellCustVO(KorTransCancellCustVO korTransCancellCustVO) {
		this.korTransCancellCustVO = korTransCancellCustVO;
	}
	
}
