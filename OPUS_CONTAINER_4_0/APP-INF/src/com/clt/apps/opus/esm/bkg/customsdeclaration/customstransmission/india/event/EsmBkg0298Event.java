/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0298Event.java
*@FileTitle : EsmBkg0298Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.11 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaTransmitCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaTransmitDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0298 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0298HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0298HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0298Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private IndiaTransmitCondVO indiaTransmitCondVO = null;
	private IndiaTransmitDetailVO indiaTransmitDetailVOs = null;
	
	private ManifestTransmitVO manifestTransmitVO = null;
	
	/**
	 * @return the indiaTransmitCondVO
	 */
	public IndiaTransmitCondVO getIndiaTransmitCondVO() {
		return indiaTransmitCondVO;
	}
	/**
	 * @param indiaTransmitCondVO the indiaTransmitCondVO to set
	 */
	public void setIndiaTransmitCondVO(IndiaTransmitCondVO indiaTransmitCondVO) {
		this.indiaTransmitCondVO = indiaTransmitCondVO;
	}
	/**
	 * @return the indiaTransmitDetailVOs
	 */
	public IndiaTransmitDetailVO getIndiaTransmitDetailVOs() {
		return indiaTransmitDetailVOs;
	}
	/**
	 * @param indiaTransmitDetailVOs the indiaTransmitDetailVOs to set
	 */
	public void setIndiaTransmitDetailVOs(
			IndiaTransmitDetailVO indiaTransmitDetailVOs) {
		this.indiaTransmitDetailVOs = indiaTransmitDetailVOs;
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
