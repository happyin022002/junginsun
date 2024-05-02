/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0061Event.java
 *@FileTitle : ESM_BKG-0061
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.08
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.27 임재택
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestConfirmationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0440 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG-0061HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author LIM JAE TAEK
 * @see ESM_BKG-0661HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0061Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private RocsManifestListCondVO rocsManifestListCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private RocsManifestListCondVO[] rocsManifestListCondVOs = null;

	private RocsManifestTransmitVO[] rocsManifestTransmitVOs = null;

	private RocsManifestConfirmationVO rocsManifestConfirmationVO = null;

	private RocsManifestConfirmationVO[] rocsManifestConfirmationVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ManifestTransmitVO manifestTransmitVO = null;

	/** Table Value Object Multi Data 처리 */
	private ManifestTransmitVO[] manifestTransmitVOs = null;

	private RocsBlKeyVO[] rocsBlKeyVOs = null;

	private String key = "";

	public EsmBkg0061Event() {
	}

	public void setRocsManifestListCondVO(RocsManifestListCondVO rocsManifestListCondVO) {
		this.rocsManifestListCondVO = rocsManifestListCondVO;
	}

	public void setRocsManifestConfirmationVO(RocsManifestConfirmationVO rocsManifestConfirmationVO) {
		this.rocsManifestConfirmationVO = rocsManifestConfirmationVO;
	}

	public void setRocsManifestListCondVOS(RocsManifestListCondVO[] rocsManifestListCondVOs) {
		if (rocsManifestListCondVOs != null)
			this.rocsManifestListCondVOs = Arrays.copyOf(rocsManifestListCondVOs, rocsManifestListCondVOs.length);
	}

	public void setRocsManifestTransmitVOS(RocsManifestTransmitVO[] rocsManifestTransmitVOs) {
		if (rocsManifestTransmitVOs != null)
			this.rocsManifestTransmitVOs = Arrays.copyOf(rocsManifestTransmitVOs, rocsManifestTransmitVOs.length);
	}

	public void setRocsBlKeyVOS(RocsBlKeyVO[] rocsBlKeyVOs) {
		if (rocsBlKeyVOs != null)
			this.rocsBlKeyVOs = Arrays.copyOf(rocsBlKeyVOs, rocsBlKeyVOs.length);
	}

	public void setRocsManifestConfirmationVOs(RocsManifestConfirmationVO[] rocsManifestConfirmationVOs) {
		if (rocsManifestConfirmationVOs != null)
			this.rocsManifestConfirmationVOs = Arrays.copyOf(rocsManifestConfirmationVOs, rocsManifestConfirmationVOs.length);
	}

	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}

	public void setManifestTransmitVOS(ManifestTransmitVO[] manifestTransmitVOs) {
		if (manifestTransmitVOs != null)
			this.manifestTransmitVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
	}

	public RocsManifestListCondVO getRocsManifestListCondVO() {
		return rocsManifestListCondVO;
	}

	public RocsManifestConfirmationVO getRocsManifestConfirmationVO() {
		return rocsManifestConfirmationVO;
	}

	public RocsManifestConfirmationVO[] getRocsManifestConfirmationVOs() {
		RocsManifestConfirmationVO[] rtnVOs = null;
		if (rocsManifestConfirmationVOs != null)
			rtnVOs = Arrays.copyOf(rocsManifestConfirmationVOs, rocsManifestConfirmationVOs.length);
		return rtnVOs;
	}

	public RocsManifestTransmitVO[] getRocsManifestTransmitVOs() {
		RocsManifestTransmitVO[] rtnVOs = null;
		if (rocsManifestTransmitVOs != null)
			rtnVOs = Arrays.copyOf(rocsManifestTransmitVOs, rocsManifestTransmitVOs.length);
		return rtnVOs;
	}

	public RocsBlKeyVO[] getRocsBlKeyVOs() {
		RocsBlKeyVO[] rtnVOs = null;
		if (rocsBlKeyVOs != null)
			rtnVOs = Arrays.copyOf(rocsBlKeyVOs, rocsBlKeyVOs.length);
		return rtnVOs;
	}

	public RocsManifestListCondVO[] getRocsManifestListCondVOS() {
		RocsManifestListCondVO[] rtnVOs = null;
		if (rocsManifestListCondVOs != null)
			rtnVOs = Arrays.copyOf(rocsManifestListCondVOs, rocsManifestListCondVOs.length);
		return rtnVOs;
	}

	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}

	public ManifestTransmitVO[] getManifestTransmitVOS() {
		ManifestTransmitVO[] rtnVOs = null;
		if (manifestTransmitVOs != null)
			rtnVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
		return rtnVOs;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
