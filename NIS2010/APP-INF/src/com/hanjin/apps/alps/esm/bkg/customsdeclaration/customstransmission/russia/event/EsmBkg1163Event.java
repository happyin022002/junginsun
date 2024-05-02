/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1046Event.java
*@FileTitle : EsmBkg1046Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.25 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1163 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1163HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Shi Kyu Jeong
 * @see ESM_BKG_1163HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1163Event extends EventSupport 
{

	private static final long serialVersionUID = 1L;
	
	private BlInfoCondVO blInfoCondVO = null;
	private BlInfoVO[] blInfoVOs = null;
	private ManifestTransmitVO manifestTransmitVO = null;
	
	private String transMode = null;
	private String key = null;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BlInfoCondVO getBlInfoCondVO() {
		return blInfoCondVO;
	}
	public BlInfoVO[] getBlInfoVOs() {
		return blInfoVOs;
	}
	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}
	public String getTransMode() {
		return transMode;
	}
	public String getKey() {
		return key;
	}
	public void setBlInfoCondVO(BlInfoCondVO blInfoCondVO) {
		this.blInfoCondVO = blInfoCondVO;
	}
	public void setBlInfoVOs(BlInfoVO[] blInfoVOs) {
		this.blInfoVOs = blInfoVOs;
	}
	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	

}
