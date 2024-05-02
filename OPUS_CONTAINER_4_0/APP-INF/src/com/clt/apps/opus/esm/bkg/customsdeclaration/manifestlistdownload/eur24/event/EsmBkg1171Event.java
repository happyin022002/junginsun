/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0304Event.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.05.04 경종윤
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselFIArrivalNoticeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1171 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1171HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Won Joo Cho
 * @see ESM_BKG_1170HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1171Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private VesselArrivalCondVO vesselArrivalCondVO = null;
	private Eur24VesselFIArrivalNoticeDetailVO vesselArrivalDetailVO = null;
	private Eur24VesselArrivalTransmitVO eur24VesselArrivalTransmitVO = null;
	private ManifestListCondVO manifestListCondVO = null;
	private Eur24VesselFIArrivalNoticeDetailVO[] vesselArrivalDetailVOs = null;

	public EsmBkg1171Event() {
	}

	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	/**
	 * @return the vesselCondVO
	 */
	public VesselArrivalCondVO getVesselArrivalCondVO() {
		return vesselArrivalCondVO;
	}

	/**
	 * @param vesselCondVO
	 *            the vesselCondVO to set
	 */
	public void setVesselArrivalCondVO(VesselArrivalCondVO vesselArrivalCondVO) {
		this.vesselArrivalCondVO = vesselArrivalCondVO;
	}

	/**
	 * @return the vesselArrivalDetailVO
	 */
	public Eur24VesselFIArrivalNoticeDetailVO getVesselArrivalDetailVO() {
		return vesselArrivalDetailVO;
	}

	/**
	 * @param vesselArrivalDetailVO
	 *            the vesselArrivalDetailVO to set
	 */
	public void setVesselArrivalDetailVO(Eur24VesselFIArrivalNoticeDetailVO vesselArrivalDetailVO) {
		this.vesselArrivalDetailVO = vesselArrivalDetailVO;
	}

	/**
	 * @return the vesselArrivalDetailVO
	 */
	public Eur24VesselFIArrivalNoticeDetailVO[] getVesselArrivalDetailVOS() {
		Eur24VesselFIArrivalNoticeDetailVO[] rtnVOs = null;
		if (vesselArrivalDetailVOs != null)
			rtnVOs = Arrays.copyOf(vesselArrivalDetailVOs, vesselArrivalDetailVOs.length);
		return rtnVOs;
	}

	/**
	 * @param vesselArrivalDetailVO
	 *            the vesselArrivalDetailVO to set
	 */
	public void setVesselArrivalDetailVOS(Eur24VesselFIArrivalNoticeDetailVO[] vesselArrivalDetailVOs) {
		if (vesselArrivalDetailVOs != null)
			this.vesselArrivalDetailVOs = Arrays.copyOf(vesselArrivalDetailVOs, vesselArrivalDetailVOs.length);
	}

	/**
	 * @return the eur24VesselArrivalTransmitVO
	 */
	public Eur24VesselArrivalTransmitVO getEur24VesselArrivalTransmitVO() {
		return eur24VesselArrivalTransmitVO;
	}

	/**
	 * @param eur24VesselArrivalTransmitVO
	 *            the eur24VesselArrivalTransmitVO to set
	 */
	public void setEur24VesselArrivalTransmitVO(Eur24VesselArrivalTransmitVO eur24VesselArrivalTransmitVO) {
		this.eur24VesselArrivalTransmitVO = eur24VesselArrivalTransmitVO;
	}

	public ManifestListCondVO getManifestListCondVO() {
		return this.manifestListCondVO;
	}

	// public void
	// setEur24VesselFIArrivalNoticeDetailVOS(Eur24VesselFIArrivalNoticeDetailVO[]
	// vesselArrivalDetailVOs){
	// this. vesselArrivalDetailVOs = vesselArrivalDetailVOs;
	// }
	//
	// public Eur24VesselFIArrivalNoticeDetailVO[]
	// getEur24VesselFIArrivalNoticeDetailVOS(){
	// return vesselArrivalDetailVOs;
	// }
}