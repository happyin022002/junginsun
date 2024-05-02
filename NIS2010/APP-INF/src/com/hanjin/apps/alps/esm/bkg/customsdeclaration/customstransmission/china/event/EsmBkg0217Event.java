/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0217Event.java
*@FileTitle : EsmBkg0217Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.25 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCustListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlDangerCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlGeneralListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ContainerCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0217 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0217HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0217HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0217Event extends EventSupport 
{

	private static final long serialVersionUID = 1L;
	
	private BlInfoCondVO blInfoCondVO = null;
	private BlInfoVO blInfoVO = null;
	private ManifestTransmitVO manifestTransmitVO = null;
	private ContainerCondVO containerCondVO = null;

	private ChinaBlGeneralListVO chinaBlGeneralListVO = null;
	private ChinaBlCntrListVO[] chinaBlCntrListVOs = null;
	private ChinaBlCustListVO chinaBlCustlListVO = null;
	private ChinaBlDangerCntrListVO[] chinaBlDangerCntrListVOs = null;
	
	private String transMode = null;
	
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
	 * @return the blInfoVO
	 */
	public BlInfoVO getBlInfoVO() {
		return this.blInfoVO;
	}
	/**
	 * @param blInfoVO the blInfoVO to set
	 */
	public void setBlInfoVO(BlInfoVO blInfoVO) {
		this.blInfoVO = blInfoVO;
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
	/**
	 * @return the chinaBlGeneralListVO
	 */
	public ChinaBlGeneralListVO getChinaBlGeneralListVO() {
		return chinaBlGeneralListVO;
	}
	/**
	 * @param chinaBlGeneralListVO the chinaBlGeneralListVO to set
	 */
	public void setChinaBlGeneralListVO(ChinaBlGeneralListVO chinaBlGeneralListVO) {
		this.chinaBlGeneralListVO = chinaBlGeneralListVO;
	}
	/**
	 * @return the chinaBlCntrListVOs
	 */
	public ChinaBlCntrListVO[] getChinaBlCntrListVOs() {
		return chinaBlCntrListVOs;
	}
	/**
	 * @param chinaBlCntrListVOs the chinaBlCntrListVOs to set
	 */
	public void setChinaBlCntrListVOs(ChinaBlCntrListVO[] chinaBlCntrListVOs) {
		this.chinaBlCntrListVOs = chinaBlCntrListVOs;
	}
	/**
	 * @return the chinaBlCustlListVO
	 */
	public ChinaBlCustListVO getChinaBlCustlListVO() {
		return chinaBlCustlListVO;
	}
	/**
	 * @param chinaBlCustlListVO the chinaBlCustlListVO to set
	 */
	public void setChinaBlCustlListVO(ChinaBlCustListVO chinaBlCustlListVO) {
		this.chinaBlCustlListVO = chinaBlCustlListVO;
	}
	/**
	 * @return the chinaBlDangerCntrListVOs
	 */
	public ChinaBlDangerCntrListVO[] getChinaBlDangerCntrListVOs() {
		return chinaBlDangerCntrListVOs;
	}
	/**
	 * @param chinaBlDangerCntrListVOs the chinaBlDangerCntrListVOs to set
	 */
	public void setChinaBlDangerCntrListVOs(
			ChinaBlDangerCntrListVO[] chinaBlDangerCntrListVOs) {
		this.chinaBlDangerCntrListVOs = chinaBlDangerCntrListVOs;
	}
	/**
	 * @return the containerCondVO
	 */
	public ContainerCondVO getContainerCondVO() {
		return containerCondVO;
	}
	/**
	 * @param containerCondVO the containerCondVO to set
	 */
	public void setContainerCondVO(ContainerCondVO containerCondVO) {
		this.containerCondVO = containerCondVO;
	}
	/**
	 * @return the transMode
	 */
	public String getTransMode() {
		return transMode;
	}
	/**
	 * @param transMode the transMode to set
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}

}
