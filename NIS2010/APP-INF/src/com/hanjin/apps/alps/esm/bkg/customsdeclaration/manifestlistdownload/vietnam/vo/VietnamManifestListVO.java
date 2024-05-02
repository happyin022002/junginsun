/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VietnamManifestListVO.java
*@FileTitle :  화면에서  정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.07 
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class VietnamManifestListVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private List<VietnamManifestListBlInfoVO> vietnamManifestListBlInfoVOs;
	private VietnamManifestListCondVO vietnamManifestListCondVO = null;
	private List<VietnamManifestListSecondBlInfoVO> vietnamManifestListSecondBlInfoVOs;

	public VietnamManifestListVO() {}

	public List<VietnamManifestListBlInfoVO> getVietnamManifestListBlInfoVOs() {
		return vietnamManifestListBlInfoVOs;
	}

	public void setVietnamManifestListBlInfoVOs(List<VietnamManifestListBlInfoVO> vietnamManifestListBlInfoVOs) {
		this.vietnamManifestListBlInfoVOs = vietnamManifestListBlInfoVOs;
	}
	
	public List<VietnamManifestListSecondBlInfoVO> getVietnamManifestListSecondBlInfoVOs() {
		return vietnamManifestListSecondBlInfoVOs;
	}

	public void setVietnamManifestListSecondBlInfoVOs(List<VietnamManifestListSecondBlInfoVO> vietnamManifestListSecondBlInfoVOs) {
		this.vietnamManifestListSecondBlInfoVOs = vietnamManifestListSecondBlInfoVOs;
	}



	public VietnamManifestListCondVO getVietnamManifestListCondVO() {
		return vietnamManifestListCondVO;
	}

	public void setVietnamManifestListCondVO(
			VietnamManifestListCondVO vietnamManifestListCondVO) {
		this.vietnamManifestListCondVO = vietnamManifestListCondVO;
	}

}
