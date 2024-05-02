/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1070Event.java
*@FileTitle : EsmBkg1070Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.11.16 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_1070HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1070Event extends EventSupport 
{

	private static final long serialVersionUID = 1L;
	
	private BlInfoCondVO blInfoCondVO = null;
	private BlInfoVO[] blInfoVOs = null;
	private ManifestTransmitVO manifestTransmitVO = null;
	
	/**
	 * @return the blInfoCondVO
	 */
	public BlInfoCondVO getBlInfoCondVO() {
		return this.blInfoCondVO;
	}
	/**
	 * @param blInfoCondVO the blInfoCondVO to set
	 */
	public void setBlInfoCondVO(BlInfoCondVO blInfoCondVO) {
		this.blInfoCondVO = blInfoCondVO;
	}
	/**
	 * @return the blInfoVOs
	 */
	public BlInfoVO[] getBlInfoVOs() {
		return this.blInfoVOs;
	}
	/**
	 * @param blInfoVOs the blInfoVOs to set
	 */
	public void setBlInfoVOs(BlInfoVO[] blInfoVOs) {
		this.blInfoVOs = blInfoVOs;
	}
	/**
	 * @return the manifestTransmitVO
	 */
	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}
	/**
	 * @param manifestTransmitVO the manifestTransmitVO to set
	 */
	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}
}
