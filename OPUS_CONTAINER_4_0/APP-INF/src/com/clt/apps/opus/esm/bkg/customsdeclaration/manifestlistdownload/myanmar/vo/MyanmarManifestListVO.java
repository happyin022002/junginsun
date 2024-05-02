/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MyanmarManifestListVO.java
*@FileTitle :  화면에서  정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.07 
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class MyanmarManifestListVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private List<MyanmarManifestListBlInfoVO> myanmarManifestListBlInfoVOs;
	private MyanmarManifestListCondVO myanmarManifestListCondVO = null;

	public MyanmarManifestListVO() {}

	public List<MyanmarManifestListBlInfoVO> getMyanmarManifestListBlInfoVOs() {
		return myanmarManifestListBlInfoVOs;
	}

	public void setMyanmarManifestListBlInfoVOs(List<MyanmarManifestListBlInfoVO> myanmarManifestListBlInfoVOs) {
		this.myanmarManifestListBlInfoVOs = myanmarManifestListBlInfoVOs;
	}


	public MyanmarManifestListCondVO getMyanmarManifestListCondVO() {
		return myanmarManifestListCondVO;
	}

	public void setMyanmarManifestListCondVO(
			MyanmarManifestListCondVO myanmarManifestListCondVO) {
		this.myanmarManifestListCondVO = myanmarManifestListCondVO;
	}

}
