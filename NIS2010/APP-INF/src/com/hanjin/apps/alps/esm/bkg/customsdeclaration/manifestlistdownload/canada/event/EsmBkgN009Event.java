/*=========================================================
 *Copyright(c) 2017 SMLines
 *@FileName : EsmBkgN009Event.java
 *@FileTitle : Canada Export: Vessel Departure Transmit (A6)
 *Open Issues :
 *Change history :
 * 1.0 Creation
 * ------------------------------------------------------
 * History
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_N009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_N009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see ESM_BKG_N009HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EsmBkgN009Event extends EventSupport {

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

	public EsmBkgN009Event() {}

	/** Set Method **/
	public void setVesselArrivalCondVO(VesselArrivalCondVO vesselArrivalCondVO) {
		this.vesselArrivalCondVO = vesselArrivalCondVO;
	}

	public void setVesselArrivalDetailVO(VesselArrivalDetailVO vesselArrivalDetailVO) {
		this.vesselArrivalDetailVO = vesselArrivalDetailVO;
	}

	public void setVesselArrivalDetailVOs(VesselArrivalDetailVO[] vesselArrivalDetailVOs){
		if(vesselArrivalDetailVOs != null){
			VesselArrivalDetailVO[] tmpVOs = Arrays.copyOf(vesselArrivalDetailVOs, vesselArrivalDetailVOs.length);
			this.vesselArrivalDetailVOs = tmpVOs;
		}
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
		if (this.vesselArrivalDetailVOs != null) {
			rtnVOs = Arrays.copyOf(vesselArrivalDetailVOs, vesselArrivalDetailVOs.length);
		}
		return rtnVOs;
	}

	public VesselArrivalVO getVeseelArrivalVO() {
		return vesselArrivalVO;
	}

	public VesselArrivalTransmitVO getVesselArrivalTransmitVO() {
		return vesselArrivalTransmitVO;
	}
}