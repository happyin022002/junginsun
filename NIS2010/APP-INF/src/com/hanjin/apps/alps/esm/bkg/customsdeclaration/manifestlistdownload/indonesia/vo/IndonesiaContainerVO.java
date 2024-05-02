/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndonesiaContainerVO.java
*@FileTitle :  화면에서  정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장지영
*@LastVersion : 1.0
* 2009.09.29 장지영
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class IndonesiaContainerVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private List<IndonesiaSearchManifestListVO> indonesiaSearchManifestListVOs;
	private IndonesiaManifestModificationVO indonesiaManifestModificationVO;    
	 
	
	public IndonesiaContainerVO() {}
	
	 
	public List<IndonesiaSearchManifestListVO> getIndonesiaSearchManifestListVOs() {
		return indonesiaSearchManifestListVOs;
	}
	 
	 
	public void setIndonesiaSearchManifestListVOs(List<IndonesiaSearchManifestListVO> indonesiaSearchManifestListVOs) {
		this.indonesiaSearchManifestListVOs =  indonesiaSearchManifestListVOs;
	}
	
	public IndonesiaManifestModificationVO getIndonesiaManifestModificationVO() {
		return indonesiaManifestModificationVO;
	}
	
	public void setIndonesiaManifestModificationVO(IndonesiaManifestModificationVO indonesiaManifestModificationVO) {
		this.indonesiaManifestModificationVO = indonesiaManifestModificationVO;
	}
	 	 
}
