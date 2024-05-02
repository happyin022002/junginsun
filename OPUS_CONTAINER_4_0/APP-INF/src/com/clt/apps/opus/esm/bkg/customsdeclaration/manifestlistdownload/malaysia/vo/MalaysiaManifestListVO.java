/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MalaysiaContainerVO.java
*@FileTitle :  화면에서  정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.07
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2011.02.07 변종건
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class MalaysiaManifestListVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;

	private MalaysiaManifestListCondVO malaysiaManifestListCondVO = null;
	private List<MalaysiaManifestListBlInfoVO> malaysiaManifestListBlInfoVOList;
	private List<MalaysiaManifestListCntrInfoVO> malaysiaManifestListCntrInfoVOList;

	public MalaysiaManifestListVO() {}

	public MalaysiaManifestListCondVO getMalaysiaManifestListCondVO() {
		return malaysiaManifestListCondVO;
	}

	public void setMalaysiaManifestListCondVO(
			MalaysiaManifestListCondVO malaysiaManifestListCondVO) {
		this.malaysiaManifestListCondVO = malaysiaManifestListCondVO;
	}

	public List<MalaysiaManifestListBlInfoVO> getMalaysiaManifestListBlInfoVOList() {
		return malaysiaManifestListBlInfoVOList;
	}

	public void setMalaysiaManifestListBlInfoVOList(List<MalaysiaManifestListBlInfoVO> malaysiaManifestListBlInfoVOList) {
		this.malaysiaManifestListBlInfoVOList = malaysiaManifestListBlInfoVOList;
	}

	public List<MalaysiaManifestListCntrInfoVO> getMalaysiaManifestListCntrInfoVOList() {
		return malaysiaManifestListCntrInfoVOList;
	}

	public void setMalaysiaManifestListCntrInfoVOList(List<MalaysiaManifestListCntrInfoVO> malaysiaManifestListCntrInfoVOList) {
		this.malaysiaManifestListCntrInfoVOList = malaysiaManifestListCntrInfoVOList;
	}

}
