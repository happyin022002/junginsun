/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0016Event.java
 *@FileTitle : ManifestListDownload
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0016HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private VesselCondVO vesselCondVO = null;
	private VesselInfoVO[] vesselInfoVOs = null;

	public EsmBkg0016Event() {
	}

	public void setVesselCondVO(VesselCondVO vesselCondVO) {
		this.vesselCondVO = vesselCondVO;
	}

	public void setVesselInfoVOs(VesselInfoVO[] vesselInfoVOs) {
		if (vesselInfoVOs != null)
			this.vesselInfoVOs = Arrays.copyOf(vesselInfoVOs, vesselInfoVOs.length);
	}

	public VesselCondVO getVesselCondVO() {
		return vesselCondVO;
	}

	public VesselInfoVO[] getVesselInfoVOs() {
		VesselInfoVO[] rtnVOs = null;
		if (vesselInfoVOs != null)
			rtnVOs = Arrays.copyOf(vesselInfoVOs, vesselInfoVOs.length);
		return rtnVOs;
	}
}