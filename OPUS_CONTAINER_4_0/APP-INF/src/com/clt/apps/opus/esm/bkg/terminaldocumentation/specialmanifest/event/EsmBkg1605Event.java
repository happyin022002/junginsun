/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0965Event.java
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

import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgHisVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0965 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0965HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0965HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1605Event extends EventSupport {
 
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EurDgHisVO eurDgHisVO = null;
	private EurDgHisVO[] eurDgHisVOs = null;

	public EurDgHisVO getEurDgHisVO() {
		return eurDgHisVO;
	}
	
	public void setEurDgHisVO(EurDgHisVO eurDgHisVO) {
		this.eurDgHisVO = eurDgHisVO;
	}

	public EurDgHisVO[] getEurDgHisVOs() {
		EurDgHisVO[] rtnVOs = null;
		if (this.eurDgHisVOs != null) {
			rtnVOs = Arrays.copyOf(eurDgHisVOs, eurDgHisVOs.length);
		}
		return rtnVOs;
	}

	public void setEurDgHisVOs(EurDgHisVO[] eurDgHisVOs) {
		if (eurDgHisVOs != null) {
			EurDgHisVO[] tmpVOs = Arrays.copyOf(eurDgHisVOs, eurDgHisVOs.length);
			this.eurDgHisVOs = tmpVOs;
		}
	}
	
	
}
