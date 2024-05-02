
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamManifestTransmitVO.java
*@FileTitle : VietnamManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier :
*@LastVersion : 1.0
* 2012.02.07
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListCondVO;
import com.clt.framework.component.common.AbstractValueObject;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VietnamManifestTransmitVO {

	private VietnamManifestListCondVO vietnamManifestListCondVO = null;
	private VietnamManifestListBlInfoVO[] vietnamManifestListBlInfoVOs = null;


	public VietnamManifestTransmitVO() {}


	public VietnamManifestListCondVO getVietnamManifestListCondVO() {
		return vietnamManifestListCondVO;
	}

	public void setVietnamManifestListCondVO(VietnamManifestListCondVO vietnamManifestListCondVO) {
		this.vietnamManifestListCondVO = vietnamManifestListCondVO;
	}

	public VietnamManifestListBlInfoVO[] getVietnamManifestListBlInfoVOs() {
		VietnamManifestListBlInfoVO[] rtnVOs = null;
		if (this.vietnamManifestListBlInfoVOs != null) {
			rtnVOs = Arrays.copyOf(vietnamManifestListBlInfoVOs, vietnamManifestListBlInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setVietnamManifestListBlInfoVOs(VietnamManifestListBlInfoVO[] vietnamManifestListBlInfoVOs) {
		if (vietnamManifestListBlInfoVOs != null) {
			VietnamManifestListBlInfoVO[] tmpVOs = Arrays.copyOf(vietnamManifestListBlInfoVOs, vietnamManifestListBlInfoVOs.length);
			this.vietnamManifestListBlInfoVOs = tmpVOs;
		}
	}

}
