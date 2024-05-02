/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelManifestListVO.java
*@FileTitle :  화면 정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.16
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.16 김보배
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class IsraelManifestListVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private List<IsraelManifestListBlInfoVO> israelManifestListBlInfoVOs;
	private IsraelManifestListCondVO israelManifestListCondVO = null;

	public IsraelManifestListVO() {}

	public List<IsraelManifestListBlInfoVO> getIsraelManifestListBlInfoVOs() {
		return israelManifestListBlInfoVOs;
	}

	public void setIsraelManifestListBlInfoVOs(List<IsraelManifestListBlInfoVO> israelManifestListBlInfoVOs) {
		this.israelManifestListBlInfoVOs = israelManifestListBlInfoVOs;
	}

	public IsraelManifestListCondVO getIsraelManifestListCondVO() {
		return israelManifestListCondVO;
	}

	public void setIsraelManifestListCondVO(IsraelManifestListCondVO israelManifestListCondVO) {
		this.israelManifestListCondVO = israelManifestListCondVO;
	}

}
