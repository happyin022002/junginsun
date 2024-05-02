/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM0740001Event.java
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVesselInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM0740001Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Kim Min Jeong
 * @see
 * @since J2EE 1.4
 */
public class ESM0740001Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	private String flatFile;
	private CndCstmsVesselInfoVO cndCstmsVesselInfoVO;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}

	public CndCstmsVesselInfoVO getCndCstmsVesselInfoVO() {
		return cndCstmsVesselInfoVO;
	}

	public void setCndCstmsVesselInfoVO(CndCstmsVesselInfoVO cndCstmsVesselInfoVO) {
		this.cndCstmsVesselInfoVO = cndCstmsVesselInfoVO;
	}
}
