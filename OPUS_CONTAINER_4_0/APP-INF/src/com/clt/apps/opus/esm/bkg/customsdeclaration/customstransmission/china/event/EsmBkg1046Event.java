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
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.VvdKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_1046HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1046Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private VvdKeyVO vvdKeyVO = null;
	private ChinaBlInfoListVO[] chinaBlInfoListVOs = null;
	private ChinaManifestTransmitVO chinaManifestTransmitVO = null;

	private String transMode = null;
	private String key = null;

	/**
	 * @return the vvdKeyVO
	 */
	public VvdKeyVO getVvdKeyVO() {
		return this.vvdKeyVO;
	}

	/**
	 * @param vvdKeyVO the vvdKeyVO to set
	 */
	public void setVvdKeyVO(VvdKeyVO vvdKeyVO) {
		this.vvdKeyVO = vvdKeyVO;
	}

	/**
	 * @return the chinaBlInfoListVOs
	 */
	public ChinaBlInfoListVO[] getChinaBlInfoListVOs() {
		ChinaBlInfoListVO[] rtnVOs = null;
		if (this.chinaBlInfoListVOs != null) {
			rtnVOs = Arrays.copyOf(this.chinaBlInfoListVOs, this.chinaBlInfoListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param chinaBlInfoListVOs the chinaBlInfoListVOs to set
	 */
	public void setChinaBlInfoListVOs(ChinaBlInfoListVO[] chinaBlInfoListVOs) {
		if (chinaBlInfoListVOs != null) {
			ChinaBlInfoListVO[] tmpVOs = Arrays.copyOf(chinaBlInfoListVOs, chinaBlInfoListVOs.length);
			this.chinaBlInfoListVOs = tmpVOs;
		}
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

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

}
