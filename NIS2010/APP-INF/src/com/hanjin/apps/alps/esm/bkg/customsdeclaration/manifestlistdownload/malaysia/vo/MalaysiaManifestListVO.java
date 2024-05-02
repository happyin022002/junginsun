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

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class MalaysiaManifestListVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private List<MalaysiaManifestListBlInfoVO> malaysiaManifestListBlInfoVOs;
	private List<MalaysiaManifestListCntrInfoVO> malaysiaManifestListCntrInfoVOs;
	private MalaysiaManifestListCondVO malaysiaManifestListCondVO = null;
	private MalaysiaManifestVslInfoVO malaysiaManifestVslInfoVO = null;

	public MalaysiaManifestVslInfoVO getMalaysiaManifestVslInfoVO() {
		return malaysiaManifestVslInfoVO;
	}

	public void setMalaysiaManifestVslInfoVO(
			MalaysiaManifestVslInfoVO malaysiaManifestVslInfoVO) {
		this.malaysiaManifestVslInfoVO = malaysiaManifestVslInfoVO;
	}

	public MalaysiaManifestListVO() {}

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
