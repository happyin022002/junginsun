/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmBkg1141Event.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.03
 *@LastModifier :
 *@LastVersion : 1.0
 * 2012.02.03
 * 1.0 Creation
 * 2012.02.02 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import java.util.List;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceVvdInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1153 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1153HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Do Wan
 * @see ESM_BKG_1141HTMLAction 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class EsmBkg1153Event extends EventSupport {

	public EsmBkg1153Event() {}


	private PreAdviceVO preAdviceVO = null;
	private List<PreAdviceVO> preAdviceVOs = null;
	private PreAdviceVvdInfoVO preAdviceVvdInfoVO = null;
	private List<PreAdviceVvdInfoVO> preAdviceVvdInfoVOs = null;


	public PreAdviceVO getPreAdviceVO() {
		return preAdviceVO;
	}
	public void setPreAdviceVO(PreAdviceVO preAdviceVO) {
		this.preAdviceVO = preAdviceVO;
	}

	public List<PreAdviceVO> getPreAdviceVOs() {
		return preAdviceVOs;
	}
	public void setPreAdviceVOs(
			List<PreAdviceVO> preAdviceVOs) {
		this.preAdviceVOs = preAdviceVOs;
	}

	public PreAdviceVvdInfoVO getPreAdviceVvdInfoVO() {
		return preAdviceVvdInfoVO;
	}
	public void setPreAdviceVvdInfoVO(PreAdviceVvdInfoVO preAdviceVvdInfoVO) {
		this.preAdviceVvdInfoVO = preAdviceVvdInfoVO;
	}

	public List<PreAdviceVvdInfoVO> getPreAdviceVvdInfoVOs() {
		return preAdviceVvdInfoVOs;
	}
	public void setPreAdviceVvdInfoVOs(
			List<PreAdviceVvdInfoVO> preAdviceVvdInfoVOs) {
		this.preAdviceVvdInfoVOs = preAdviceVvdInfoVOs;
	}



}