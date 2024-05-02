/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0969Event.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier :
*@LastVersion : 1.0
* 2009.05.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListVO;
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
public class EsmBkg0969Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FwdrListCondVO fwdrListCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private FwdrListVO[] fwdrListVO = null;

	/**
	 * @return the fwdrListCondVO
	 */
	public FwdrListCondVO getFwdrListCondVO() {
		return fwdrListCondVO;
	}

	/**
	 * @param fwdrListCondVO the fwdrListCondVO to set
	 */
	public void setFwdrListCondVO(FwdrListCondVO fwdrListCondVO) {
		this.fwdrListCondVO = fwdrListCondVO;
	}

	public FwdrListVO[] getFwdrListVO() {
		FwdrListVO[] rtnVOs = null;
		if (this.fwdrListVO != null) {
			rtnVOs = Arrays.copyOf(fwdrListVO, fwdrListVO.length);
		}
		return rtnVOs;
	}

	public void setFwdrListVO(FwdrListVO[] fwdrListVO) {
		if (fwdrListVO != null) {
			FwdrListVO[] tmpVOs = Arrays.copyOf(fwdrListVO, fwdrListVO.length);
			this.fwdrListVO = tmpVOs;
		}
	}




}
