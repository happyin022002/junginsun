/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestTransmitContainerVO.java
*@FileTitle : SEA-NACCS: Manifest Data Download _ B/L List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.18 김승민
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;

public class JapanManifestTransmitContainerVO  extends ManifestTransmitVO{
	private static final long serialVersionUID = 1L;

	private JapanManifestTransmitVO[] japanManifestTransmitVOs;
	private JapanManifestTransmitCondVO  japanManifestTransmitCondVO;
	private JapanManifestTransmitVO japanManifestTransmitVO;

	/**
	 * 생성자
	 * @param
	 * @return
	 */
	public JapanManifestTransmitContainerVO() {}

	public JapanManifestTransmitVO[] getJapanManifestTransmitVOs() {
		return japanManifestTransmitVOs;
	}

	public void setJapanManifestTransmitVOs(JapanManifestTransmitVO[] japanManifestTransmitVOs) {
		this.japanManifestTransmitVOs = japanManifestTransmitVOs;
	}

	public JapanManifestTransmitCondVO getJapanManifestTransmitCondVO() {
		return japanManifestTransmitCondVO;
	}

	public void setJapanManifestTransmitCondVO(JapanManifestTransmitCondVO japanManifestTransmitCondVO) {
		this.japanManifestTransmitCondVO = japanManifestTransmitCondVO;
	}

	public JapanManifestTransmitVO getJapanManifestTransmitVO() {
		return japanManifestTransmitVO;
	}

	public void setJapanManifestTransmitVO(JapanManifestTransmitVO japanManifestTransmitVO) {
		this.japanManifestTransmitVO = japanManifestTransmitVO;
	}
}
