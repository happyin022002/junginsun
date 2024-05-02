/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MalaysiaManifestTransmitVO.java
*@FileTitle : MalaysiaManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MalaysiaManifestTransmitVO extends ManifestTransmitVO {

private static final long serialVersionUID = 1L;
	
	private List<MalaysiaManifestListBlInfoVO> malaysiaManifestListBlInfoVOs;
	private List<MalaysiaManifestListCntrInfoVO> malaysiaManifestListCntrInfoVOs;
	private MalaysiaManifestListCondVO malaysiaManifestListCondVO = null;

	public MalaysiaManifestTransmitVO() {}
	
	public List<MalaysiaManifestListBlInfoVO> getMalaysiaManifestListBlInfoVOs() {
		return malaysiaManifestListBlInfoVOs;
	}

	public void setMalaysiaManifestListBlInfoVOs(List<MalaysiaManifestListBlInfoVO> malaysiaManifestListBlInfoVOs) {
		this.malaysiaManifestListBlInfoVOs = malaysiaManifestListBlInfoVOs;
	}

	public List<MalaysiaManifestListCntrInfoVO> getMalaysiaManifestListCntrInfoVOs() {
		return malaysiaManifestListCntrInfoVOs;
	}

	public void setMalaysiaManifestListCntrInfoVOs(List<MalaysiaManifestListCntrInfoVO> malaysiaManifestListCntrInfoVOs) {
		this.malaysiaManifestListCntrInfoVOs = malaysiaManifestListCntrInfoVOs;
	}

	public MalaysiaManifestListCondVO getMalaysiaManifestListCondVO() {
		return malaysiaManifestListCondVO;
	}

	public void setMalaysiaManifestListCondVO(
			MalaysiaManifestListCondVO malaysiaManifestListCondVO) {
		this.malaysiaManifestListCondVO = malaysiaManifestListCondVO;
	}
}
