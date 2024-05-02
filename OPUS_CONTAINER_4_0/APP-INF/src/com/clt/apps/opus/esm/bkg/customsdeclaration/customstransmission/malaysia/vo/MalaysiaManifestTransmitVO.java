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

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCondVO;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MalaysiaManifestTransmitVO {

	private MalaysiaManifestListCondVO malaysiaManifestListCondVO = null;
	private MalaysiaManifestListBlInfoVO[] malaysiaManifestListBlInfoVOs;
	private MalaysiaManifestListCntrInfoVO[] malaysiaManifestListCntrInfoVOs;

	public MalaysiaManifestTransmitVO() {}

	public MalaysiaManifestListCondVO getMalaysiaManifestListCondVO() {
		return malaysiaManifestListCondVO;
	}

	public void setMalaysiaManifestListCondVO(MalaysiaManifestListCondVO malaysiaManifestListCondVO) {
		this.malaysiaManifestListCondVO = malaysiaManifestListCondVO;
	}

	public MalaysiaManifestListBlInfoVO[] getMalaysiaManifestListBlInfoVOs() {
		MalaysiaManifestListBlInfoVO[] rtnVOs = null;
		if (this.malaysiaManifestListBlInfoVOs != null) {
			rtnVOs = Arrays.copyOf(malaysiaManifestListBlInfoVOs, malaysiaManifestListBlInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setMalaysiaManifestListBlInfoVOs(MalaysiaManifestListBlInfoVO[] malaysiaManifestListBlInfoVOs) {
		if (malaysiaManifestListBlInfoVOs != null) {
			MalaysiaManifestListBlInfoVO[] tmpVOs = Arrays.copyOf(malaysiaManifestListBlInfoVOs, malaysiaManifestListBlInfoVOs.length);
			this.malaysiaManifestListBlInfoVOs = tmpVOs;
		}
	}

	public MalaysiaManifestListCntrInfoVO[] getMalaysiaManifestListCntrInfoVOs() {
		MalaysiaManifestListCntrInfoVO[] rtnVOs = null;
		if (this.malaysiaManifestListCntrInfoVOs != null) {
			rtnVOs = Arrays.copyOf(malaysiaManifestListCntrInfoVOs, malaysiaManifestListCntrInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setMalaysiaManifestListCntrInfoVOs(MalaysiaManifestListCntrInfoVO[] malaysiaManifestListCntrInfoVOs) {
		if (malaysiaManifestListCntrInfoVOs != null) {
			MalaysiaManifestListCntrInfoVO[] tmpVOs = Arrays.copyOf(malaysiaManifestListCntrInfoVOs, malaysiaManifestListCntrInfoVOs.length);
			this.malaysiaManifestListCntrInfoVOs = tmpVOs;
		}
	}

}
