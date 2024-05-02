/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarManifestTransmitVO.java
*@FileTitle : MyanmarManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestListCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MyanmarManifestTransmitVO extends ManifestTransmitVO {

private static final long serialVersionUID = 1L;
	
	private List<MyanmarManifestListBlInfoVO> myanmarManifestListBlInfoVOs;
	private List<MyanmarManifestListCntrInfoVO> myanmarManifestListCntrInfoVOs;
	private MyanmarManifestListCondVO myanmarManifestListCondVO = null;

	public MyanmarManifestTransmitVO() {}
	
	public List<MyanmarManifestListBlInfoVO> getMyanmarManifestListBlInfoVOs() {
		return myanmarManifestListBlInfoVOs;
	}

	public void setMyanmarManifestListBlInfoVOs(List<MyanmarManifestListBlInfoVO> myanmarManifestListBlInfoVOs) {
		this.myanmarManifestListBlInfoVOs = myanmarManifestListBlInfoVOs;
	}

	public List<MyanmarManifestListCntrInfoVO> getMyanmarManifestListCntrInfoVOs() {
		return myanmarManifestListCntrInfoVOs;
	}

	public void setMyanmarManifestListCntrInfoVOs(List<MyanmarManifestListCntrInfoVO> myanmarManifestListCntrInfoVOs) {
		this.myanmarManifestListCntrInfoVOs = myanmarManifestListCntrInfoVOs;
	}

	public MyanmarManifestListCondVO getMyanmarManifestListCondVO() {
		return myanmarManifestListCondVO;
	}

	public void setMyanmarManifestListCondVO(
			MyanmarManifestListCondVO myanmarManifestListCondVO) {
		this.myanmarManifestListCondVO = myanmarManifestListCondVO;
	}
}
