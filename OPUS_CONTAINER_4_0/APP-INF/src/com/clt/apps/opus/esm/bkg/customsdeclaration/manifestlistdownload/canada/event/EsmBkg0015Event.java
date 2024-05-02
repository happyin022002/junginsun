/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0015Event.java
 *@FileTitle : CndManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0015HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** BL정보 조회조건 */
	private VesselArrivalCondVO vesselArrivalCondVO = null;
	/** BL정보 단건 */
	private VesselArrivalDetailVO vesselArrivalDetailVO = null;
	/** BL정보 복수 */
	private VesselArrivalDetailVO[] vesselArrivalDetailVOs = null;
	/** Vessel Arrival 정보 */
	private VesselArrivalVO vesselArrivalVO = null;
	/** Vessel Arrival 전송 정보 */
	private VesselArrivalTransmitVO vesselArrivalTransmitVO = null;

	public EsmBkg0015Event() {
	}

	/** Set Method **/
	public void setVesselArrivalCondVO(VesselArrivalCondVO vesselArrivalCondVO) {
		this.vesselArrivalCondVO = vesselArrivalCondVO;
	}

	public void setVesselArrivalDetailVO(VesselArrivalDetailVO vesselArrivalDetailVO) {
		this.vesselArrivalDetailVO = vesselArrivalDetailVO;
	}

	public void setVesselArrivalDetailVOs(VesselArrivalDetailVO[] vesselArrivalDetailVOs) {
		if (vesselArrivalDetailVOs != null)
			this.vesselArrivalDetailVOs = Arrays.copyOf(vesselArrivalDetailVOs, vesselArrivalDetailVOs.length);
	}

	public void setVeseelArrivalVO(VesselArrivalVO vesselArrivalVO) {
		this.vesselArrivalVO = vesselArrivalVO;
	}

	public void setVesselArrivalTransmitVO(VesselArrivalTransmitVO vesselArrivalTransmitVO) {
		this.vesselArrivalTransmitVO = vesselArrivalTransmitVO;
	}

	/** Get Method **/
	public VesselArrivalCondVO getVesselArrivalCondVO() {
		return vesselArrivalCondVO;
	}

	public VesselArrivalDetailVO getVesselArrivalDetailVO() {
		return vesselArrivalDetailVO;
	}

	public VesselArrivalDetailVO[] getVesselArrivalDetailVOs() {
		VesselArrivalDetailVO[] rtnVOs = null;
		if (vesselArrivalDetailVOs != null)
			rtnVOs = Arrays.copyOf(vesselArrivalDetailVOs, vesselArrivalDetailVOs.length);
		return rtnVOs;
	}

	public VesselArrivalVO getVeseelArrivalVO() {
		return vesselArrivalVO;
	}

	public VesselArrivalTransmitVO getVesselArrivalTransmitVO() {
		return vesselArrivalTransmitVO;
	}
}