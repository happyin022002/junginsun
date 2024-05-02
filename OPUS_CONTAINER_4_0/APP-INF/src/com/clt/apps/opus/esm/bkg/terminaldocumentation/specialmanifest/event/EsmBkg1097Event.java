/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1097Event.java
*@FileTitle : EU DG Declare-Feeder Registry Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.03
*@LastModifier :
*@LastVersion : 1.0
* 2010.06.03
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0969 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0969HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0969HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1097Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FeederInfoVO feederInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private FeederInfoVO[] feederInfoVOs = null;

	/**
	 * @return the feederInfoVO
	 */
	public FeederInfoVO getFeederInfoVO() {
		return feederInfoVO;
	}

	/**
	 * @param feederInfoVO the feederInfoVO to set
	 */
	public void setFeederInfoVO(FeederInfoVO feederInfoVO) {
		this.feederInfoVO = feederInfoVO;
	}

	public FeederInfoVO[] getFeederInfoVOs() {
		FeederInfoVO[] rtnVOs = null;
		if (this.feederInfoVOs != null) {
			rtnVOs = Arrays.copyOf(feederInfoVOs, feederInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setFeederInfoVOs(FeederInfoVO[] feederInfoVOs) {
		if (feederInfoVOs != null) {
			FeederInfoVO[] tmpVOs = Arrays.copyOf(feederInfoVOs, feederInfoVOs.length);
			this.feederInfoVOs = tmpVOs;
		}
	}




}
