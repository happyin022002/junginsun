/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GhanaContainerVO.java
*@FileTitle : GhanaContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.04.16 김보배 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class GhanaContainerVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private List<GhanaSearchManifestListVO> ghanaSearchManifestListVOs;
	private List<GhanaSearchVesselVO> ghanaSearchVesselVOs;
	
	
	public GhanaContainerVO() {}
	 
	
	public List<GhanaSearchManifestListVO> getGhanaSearchManifestListVOs() {
		return ghanaSearchManifestListVOs;
	}
	public List<GhanaSearchVesselVO> getGhanaSearchVesselVOs() {
		return ghanaSearchVesselVOs;
	}
	 
	 
	public void setGhanaSearchManifestListVOs(List<GhanaSearchManifestListVO> ghanaSearchManifestListVOs) {
		this.ghanaSearchManifestListVOs =  ghanaSearchManifestListVOs;
	}
	public void setGhanaSearchVesselVOs(List<GhanaSearchVesselVO> ghanaSearchVesselVOs) {
		this.ghanaSearchVesselVOs =  ghanaSearchVesselVOs;
	}
	 	 
}
