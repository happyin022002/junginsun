
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

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo;



import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VietnamManifestTransmitVO extends ManifestTransmitVO {

private static final long serialVersionUID = 1L;
	
	private List<VietnamManifestListBlInfoVO> vietnamManifestListBlInfoVOs;
	private List<MalaysiaManifestListCntrInfoVO> malaysiaManifestListCntrInfoVOs;
	private VietnamManifestListCondVO vietnamManifestListCondVO = null;

	public VietnamManifestTransmitVO() {}
	
	public List<VietnamManifestListBlInfoVO> getVietnamManifestListBlInfoVOs() {
		return vietnamManifestListBlInfoVOs;
	}

	public void setVietnamManifestListBlInfoVOs(List<VietnamManifestListBlInfoVO> vietnamManifestListBlInfoVOs) {
		this.vietnamManifestListBlInfoVOs = vietnamManifestListBlInfoVOs;
	}

//	public List<MalaysiaManifestListCntrInfoVO> getMalaysiaManifestListCntrInfoVOs() {
//		return malaysiaManifestListCntrInfoVOs;
//	}

//	public void setMalaysiaManifestListCntrInfoVOs(List<MalaysiaManifestListCntrInfoVO> malaysiaManifestListCntrInfoVOs) {
//		this.malaysiaManifestListCntrInfoVOs = malaysiaManifestListCntrInfoVOs;
//	}

	public VietnamManifestListCondVO getVietnamManifestListCondVO() {
		return vietnamManifestListCondVO;
	}

	public void setVietnamManifestListCondVO(
			VietnamManifestListCondVO vietnamManifestListCondVO) {
		this.vietnamManifestListCondVO = vietnamManifestListCondVO;
	}
}
