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
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrSealNoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author borahoon
 * @see ESM_BKG_1107HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1107Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	public EsmBkg1107Event() {
	}

	private Eur24BlInfoCondVO eur24BlInfoCondVO = null;
	private Eur24VesselArrivalCondVO eur24VesselArrivalCondVO = null;
	private Eur24BlInfoVO eur24BlInfoVO = null;
	private ContainerListCondVO containerListCondVO = null;
	private ContainerListRsltVO[] containerListRsltVOs = null;
	private Eur24BlCntrSealNoListVO[] eur24BlCntrSealNoListVOs = null;
	private String custCntCd = null;
	private String custSeq = null;
	private String custType = null;

	/**
	 * @return the Eur24BlCntrSealNoListVO
	 */
	public Eur24BlCntrSealNoListVO[] getEur24BlCntrSealNoListVOs() {
		Eur24BlCntrSealNoListVO[] rtnVOs = null;
		if (eur24BlCntrSealNoListVOs != null)
			rtnVOs = Arrays.copyOf(eur24BlCntrSealNoListVOs, eur24BlCntrSealNoListVOs.length);
		return rtnVOs;
	}

	/**
	 * @return void
	 */
	public void setEur24BlCntrSealNoListVOs(Eur24BlCntrSealNoListVO[] eur24BlCntrSealNoListVOs) {
		if (eur24BlCntrSealNoListVOs != null)
			this.eur24BlCntrSealNoListVOs = Arrays.copyOf(eur24BlCntrSealNoListVOs, eur24BlCntrSealNoListVOs.length);
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public String getCustType() {
		return custType;
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public void setCustType(String custType) {
		this.custType = custType;
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public ContainerListCondVO getContainerListCondVO() {
		return containerListCondVO;
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public void setContainerListCondVO(ContainerListCondVO containerListCondVO) {
		this.containerListCondVO = containerListCondVO;
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public ContainerListRsltVO[] getContainerListRsltVOs() {
		ContainerListRsltVO[] rtnVOs = null;
		if (containerListRsltVOs != null)
			rtnVOs = Arrays.copyOf(containerListRsltVOs, containerListRsltVOs.length);
		return rtnVOs;
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public void setContainerListRsltVOs(ContainerListRsltVO[] containerListRsltVOs) {
		if (containerListRsltVOs != null)
			this.containerListRsltVOs = Arrays.copyOf(containerListRsltVOs, containerListRsltVOs.length);
	}

	/**
	 * @return the Eur24BlInfoVO
	 */
	public Eur24BlInfoVO getEur24BlInfoVO() {
		return eur24BlInfoVO;
	}

	/**
	 * @return void
	 */
	public void setEur24BlInfoVO(Eur24BlInfoVO eur24BlInfoVO) {
		this.eur24BlInfoVO = eur24BlInfoVO;
	}

	private String transMode = null;

	/**
	 * @return the blInfoCondVO
	 */
	public Eur24BlInfoCondVO getEur24BlInfoCondVO() {
		return eur24BlInfoCondVO;
	}

	/**
	 * @return the blInfoCondVO
	 */
	public void setEur24BlInfoCondVO(Eur24BlInfoCondVO eur24BlInfoCondVO) {
		this.eur24BlInfoCondVO = eur24BlInfoCondVO;
	}

	/**
	 * @return the blInfoCondVO
	 */
	public void setVesselArrivalCondVO(Eur24VesselArrivalCondVO vesselArrivalCondVO) {
		this.eur24VesselArrivalCondVO = vesselArrivalCondVO;
	}

	/**
	 * @return the blInfoCondVO
	 */
	public Eur24VesselArrivalCondVO getEur24VesselArrivalCondVO() {
		return eur24VesselArrivalCondVO;
	}

	/**
	 * @return the blInfoCondVO
	 */
	public String getTransMode() {
		return transMode;
	}

	/**
	 * @return the blInfoCondVO
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}
}