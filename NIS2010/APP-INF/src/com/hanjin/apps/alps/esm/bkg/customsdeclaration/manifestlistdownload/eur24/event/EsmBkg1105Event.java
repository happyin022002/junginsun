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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24VesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalNoticeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event.ESM_BKG_0304HTMLAction;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0304 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0304HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0304HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1105Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VesselArrivalCondVO vesselArrivalCondVO = null;
	private Eur24VesselArrivalNoticeDetailVO vesselArrivalDetailVO = null;
	private Eur24VesselArrivalTransmitVO eur24VesselArrivalTransmitVO = null;
	private ManifestListCondVO   manifestListCondVO = null;
	private String rvisN1stClptCd = null;

	/**
	 * @return the rvis_n1st_clpt_cd
	 */		
	public String getRvis_n1st_clpt_cd() {
		return rvisN1stClptCd;
	}
	
	/**
	 * @param rvisN1stClptCd to set
	 */
	public void setRvis_n1st_clpt_cd(String rvisN1stClptCd) {
		this.rvisN1stClptCd = rvisN1stClptCd;
	}

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

	public EsmBkg1105Event(){}

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