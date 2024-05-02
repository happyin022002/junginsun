/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongContainerVO.java
*@FileTitle :  화면에서  정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.19 임재택
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class HongKongContainerVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private List<HongKongSearchManifestListVO> hongKongSearchManifestListVOs;
	private List<HongKongSearchVesselVO> hongKongSearchVesselVOs;
	 
	
	public HongKongContainerVO() {}
	
	 
	public List<HongKongSearchManifestListVO> getHongKongSearchManifestListVOs() {
		return hongKongSearchManifestListVOs;
	}
	public List<HongKongSearchVesselVO> getHongKongSearchVesselVOs() {
		return hongKongSearchVesselVOs;
	}
	 
	 
	public void setHongKongSearchManifestListVOs(List<HongKongSearchManifestListVO> hongKongSearchManifestListVOs) {
		this.hongKongSearchManifestListVOs =  hongKongSearchManifestListVOs;
	}
	public void setHongKongSearchVesselVOs(List<HongKongSearchVesselVO> hongKongSearchVesselVOs) {
		this.hongKongSearchVesselVOs =  hongKongSearchVesselVOs;
	}
	 	 
}
