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
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCustListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlDangerCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlGeneralListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ContainerCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0217 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0217HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0217HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0217Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ChinaBlInfoCondVO chinaBlInfoCondVO = null;
	private ChinaBlInfoVO chinaBlInfoVO = null;
	private ChinaManifestTransmitVO chinaManifestTransmitVO = null;
	private ContainerCondVO containerCondVO = null;

	private ChinaBlGeneralListVO chinaBlGeneralListVO = null;
	private ChinaBlCntrListVO[] chinaBlCntrListVOs = null;
	private ChinaBlCustListVO chinaBlCustlListVO = null;
	private ChinaBlDangerCntrListVO[] chinaBlDangerCntrListVOs = null;

	private String transMode = null;

	/**
	 * @return the blInfoCondVO
	 */
	public ChinaBlInfoCondVO getChinaBlInfoCondVO() {
		return this.chinaBlInfoCondVO;
	}
	/**
	 * @param blInfoCondVO the blInfoCondVO to set
	 */
	public void setChinaBlInfoCondVO(ChinaBlInfoCondVO blInfoCondVO) {
		this.chinaBlInfoCondVO = blInfoCondVO;
	}
	/**
	 * @return the chinaBlInfoVO
	 */
	public ChinaBlInfoVO getChinaBlInfoVO() {
		return this.chinaBlInfoVO;
	}
	/**
	 * @param chinaBlInfoVO the chinaBlInfoVO to set
	 */
	public void setChinaBlInfoVO(ChinaBlInfoVO chinaBlInfoVO) {
		this.chinaBlInfoVO = chinaBlInfoVO;
	}
	/**
	 * @return the chinaManifestTransmitVO
	 */
	public ChinaManifestTransmitVO getChinaManifestTransmitVO() {
		return chinaManifestTransmitVO;
	}
	/**
	 * @param chinaManifestTransmitVO the chinaManifestTransmitVO to set
	 */
	public void setChinaManifestTransmitVO(ChinaManifestTransmitVO chinaManifestTransmitVO) {
		this.chinaManifestTransmitVO = chinaManifestTransmitVO;
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
		ChinaBlCntrListVO[] rtnVOs = null;
		if (this.chinaBlCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(chinaBlCntrListVOs, chinaBlCntrListVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param chinaBlCntrListVOs the chinaBlCntrListVOs to set
	 */
	public void setChinaBlCntrListVOs(ChinaBlCntrListVO[] chinaBlCntrListVOs) {
		if (chinaBlCntrListVOs != null) {
			ChinaBlCntrListVO[] tmpVOs = Arrays.copyOf(chinaBlCntrListVOs, chinaBlCntrListVOs.length);
			this.chinaBlCntrListVOs = tmpVOs;
		}
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
		ChinaBlDangerCntrListVO[] rtnVOs = null;
		if (this.chinaBlDangerCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(chinaBlDangerCntrListVOs, chinaBlDangerCntrListVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param chinaBlDangerCntrListVOs the chinaBlDangerCntrListVOs to set
	 */
	public void setChinaBlDangerCntrListVOs(ChinaBlDangerCntrListVO[] chinaBlDangerCntrListVOs) {
		if (chinaBlDangerCntrListVOs != null) {
			ChinaBlDangerCntrListVO[] tmpVOs = Arrays.copyOf(chinaBlDangerCntrListVOs, chinaBlDangerCntrListVOs.length);
			this.chinaBlDangerCntrListVOs = tmpVOs;
		}
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
