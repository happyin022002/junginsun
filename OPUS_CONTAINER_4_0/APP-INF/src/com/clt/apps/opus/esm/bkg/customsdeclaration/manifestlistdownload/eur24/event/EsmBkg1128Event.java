/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1128Event.java
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalNoticeDetailVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1104, 1105, 1106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1128HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kae Ki Hoon
 * @see ESM_BKG_0433HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1128Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VesselArrivalCondVO vesselArrivalCondVO = null;
	private Eur24VesselArrivalNoticeDetailVO vesselArrivalDetailVO = null;
	private Eur24VesselArrivalTransmitVO eur24VesselArrivalTransmitVO = null;
	private ManifestListCondVO   manifestListCondVO = null;
	/**
	 * @return the ManifestListCondVO
	 */	
	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}
	
	/**
	 * @param ManifestListCondVO the ManifestListCondVO to set
	 */
	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	public EsmBkg1128Event(){}

	/**
	 * @return the vesselCondVO
	 */
	public VesselArrivalCondVO getVesselArrivalCondVO() {
		return vesselArrivalCondVO;
	}

	/**
	 * @param vesselCondVO the vesselCondVO to set
	 */
	public void setVesselArrivalCondVO(VesselArrivalCondVO vesselArrivalCondVO) {
		this.vesselArrivalCondVO = vesselArrivalCondVO;
	}

	/**
	 * @return the vesselArrivalDetailVO
	 */
	public Eur24VesselArrivalNoticeDetailVO getVesselArrivalDetailVO() {
		return vesselArrivalDetailVO;
	}

	/**
	 * @param vesselArrivalDetailVO the vesselArrivalDetailVO to set
	 */
	public void setVesselArrivalDetailVO(Eur24VesselArrivalNoticeDetailVO vesselArrivalDetailVO) {
		this.vesselArrivalDetailVO = vesselArrivalDetailVO;
	}

	/**
	 * @return the eur24VesselArrivalTransmitVO
	 */
	public Eur24VesselArrivalTransmitVO getEur24VesselArrivalTransmitVO() {
		return eur24VesselArrivalTransmitVO;
	}

	/**
	 * @param eur24VesselArrivalTransmitVO the eur24VesselArrivalTransmitVO to set
	 */
	public void setEur24VesselArrivalTransmitVO(Eur24VesselArrivalTransmitVO eur24VesselArrivalTransmitVO) {
		this.eur24VesselArrivalTransmitVO = eur24VesselArrivalTransmitVO;
	}


}