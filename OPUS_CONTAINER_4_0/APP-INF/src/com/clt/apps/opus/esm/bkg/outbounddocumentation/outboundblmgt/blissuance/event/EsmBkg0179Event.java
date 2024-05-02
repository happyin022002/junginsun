
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0179Event.java
*@FileTitle : Container Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : Kim Tae Kyun
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlRemarkVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0179 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0179HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_0179HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0179Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BlRemarkVO blRemarkVO = null;
	/** Table Value Object Multi Data 처리 */
	private BlRemarkVO[] blRemarkVOs = null;
	
//	private BlRemarkVO blRemarkVO = new BlRemarkVO();
	public EsmBkg0179Event() {}

	/**
	 * @return the blRemarkVO
	 */
	public BlRemarkVO getBlRemarkVO() {
		return blRemarkVO;
	}

	/**
	 * @param blRemarkVO the blRemarkVO to set
	 */
	public void setBlRemarkVO(BlRemarkVO blRemarkVO) {
		this.blRemarkVO = blRemarkVO;
	}

	public BlRemarkVO[] getBlRemarkVOs() {
		BlRemarkVO[] rtnVOs = null;
		if (this.blRemarkVOs != null) {
			rtnVOs = Arrays.copyOf(blRemarkVOs, blRemarkVOs.length);
		}
		return rtnVOs;
	}

	public void setBlRemarkVOs(BlRemarkVO[] blRemarkVOs) {
		if (blRemarkVOs != null) {
			BlRemarkVO[] tmpVOs = Arrays.copyOf(blRemarkVOs, blRemarkVOs.length);
			this.blRemarkVOs = tmpVOs;
		}
	}

}
