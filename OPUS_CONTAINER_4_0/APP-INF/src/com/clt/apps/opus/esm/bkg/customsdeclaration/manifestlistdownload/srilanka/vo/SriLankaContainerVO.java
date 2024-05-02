/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :  SriLankaContainerVO.java
*@FileTitle :  화면에서  정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.04 임재택
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class SriLankaContainerVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	
	private List<SriLankaSearchManifestVpsVO> sriLankaSearchManifestVpsVOs;
	private List<SriLankaSearchEtdDtVO>       sriLankaSearchEtdDtVOs;
	private List<SriLankaSearchVsselNameVO>   sriLankaSearchVsselNameVOs;
	private List<SriLankaSearchRegistNoVO>    sriLankaSearchRegistNoVOs;
	private List<SriLankaSearchResponseVO>    sriLankaSearchResponseVOs;
	private List<SriLankaSearchBlListVO>      sriLankaSearchBlListVOs;
	private List<SriLankaSearchCntrListVO>    sriLankaSearchCntrListVOs;
	private List<SriLankaSearchCntrListTempVO>    sriLankaSearchCntrListTempVOs;
	
	private SriLankaSearchManifestVpsVO sriLankaSearchManifestVpsVO;
	private SriLankaSearchEtdDtVO       sriLankaSearchEtdDtVO;
	private SriLankaSearchVsselNameVO       sriLankaSearchVsselNameVO;
	private SriLankaSearchRegistNoVO       sriLankaSearchRegistNoVO;
	private SriLankaSearchResponseVO       sriLankaSearchResponseVO;
	private SriLankaSearchBlListVO       sriLankaSearchBlListVO;
	 
	public SriLankaContainerVO() {}
	
	public SriLankaSearchManifestVpsVO getSriLankaSearchManifestVpsVO() {
		return sriLankaSearchManifestVpsVO;
	}
	
	public void setSriLankaSearchManifestVpsVO(SriLankaSearchManifestVpsVO sriLankaSearchManifestVpsVO) {
		this.sriLankaSearchManifestVpsVO = sriLankaSearchManifestVpsVO;
	}
	public SriLankaSearchBlListVO getSriLankaSearchBlListVO() {
		return sriLankaSearchBlListVO;
	}
	
	public void setSriLankaSearchBlListVO(SriLankaSearchBlListVO sriLankaSearchBlListVO) {
		this.sriLankaSearchBlListVO = sriLankaSearchBlListVO;
	}
	
	public SriLankaSearchResponseVO getSriLankaSearchResponseVO() {
		return sriLankaSearchResponseVO;
	}
	
	public void setSriLankaSearchResponseVO(SriLankaSearchResponseVO sriLankaSearchResponseVO) {
		this.sriLankaSearchResponseVO = sriLankaSearchResponseVO;
	}
	
	public SriLankaSearchRegistNoVO getSriLankaSearchRegistNoVO() {
		return sriLankaSearchRegistNoVO;
	}
	
	public void setSriLankaSearchRegistNoVO(SriLankaSearchRegistNoVO sriLankaSearchRegistNoVO) {
		this.sriLankaSearchRegistNoVO = sriLankaSearchRegistNoVO;
	}
	
	public SriLankaSearchVsselNameVO getSriLankaSearchVsselNameVO() {
		return sriLankaSearchVsselNameVO;
	}
	
	public void setSriLankaSearchVsselNameVO(SriLankaSearchVsselNameVO sriLankaSearchVsselNameVO) {
		this.sriLankaSearchVsselNameVO = sriLankaSearchVsselNameVO;
	}
	
	public SriLankaSearchEtdDtVO getSriLankaSearchEtdDtVO() {
		return sriLankaSearchEtdDtVO;
	}
	
	public void setSriLankaSearchEtdDtVO(SriLankaSearchEtdDtVO sriLankaSearchEtdDtVO) {
		this.sriLankaSearchEtdDtVO = sriLankaSearchEtdDtVO;
	}
	 
	public List<SriLankaSearchManifestVpsVO> getSriLankaSearchManifestVpsVOs() {
		return sriLankaSearchManifestVpsVOs;
	}
	public List<SriLankaSearchEtdDtVO> getSriLankaSearchEtdDtVOs() {
		return sriLankaSearchEtdDtVOs;
	}
	public List<SriLankaSearchVsselNameVO> getSriLankaSearchVsselNameVOs() {
		return sriLankaSearchVsselNameVOs;
	}	
	public List<SriLankaSearchRegistNoVO> getSriLankaSearchRegistNoVOs() {
		return sriLankaSearchRegistNoVOs;
	}
	public List<SriLankaSearchResponseVO> getSriLankaSearchResponseVOs() {
		return sriLankaSearchResponseVOs;
	}
	public List<SriLankaSearchBlListVO> getSriLankaSearchBlListVOs() {
		return sriLankaSearchBlListVOs;
	}
	public List<SriLankaSearchCntrListVO> getSriLankaSearchCntrListVOs() {
		return sriLankaSearchCntrListVOs;
	}
	
	public List<SriLankaSearchCntrListTempVO> getSriLankaSearchCntrListTempVOs() {
		return sriLankaSearchCntrListTempVOs;
	}
	 
	public void setSriLankaSearchManifestVpsVOs(List<SriLankaSearchManifestVpsVO> sriLankaSearchManifestVpsVOs) {
		this.sriLankaSearchManifestVpsVOs =  sriLankaSearchManifestVpsVOs;
	}
	public void setSriLankaSearchEtdDtVOs(List<SriLankaSearchEtdDtVO> sriLankaSearchEtdDtVOs) {
		this.sriLankaSearchEtdDtVOs =  sriLankaSearchEtdDtVOs;
	}
	public void setSriLankaSearchVsselNameVOs(List<SriLankaSearchVsselNameVO> sriLankaSearchVsselNameVOs) {
		this.sriLankaSearchVsselNameVOs = sriLankaSearchVsselNameVOs;
	}
	public void setSriLankaSearchResponseVOs(List<SriLankaSearchResponseVO> sriLankaSearchResponseVOs) {
		this.sriLankaSearchResponseVOs = sriLankaSearchResponseVOs;
	}
	public void setSriLankaSearchBlListVOs(List<SriLankaSearchBlListVO> sriLankaSearchBlListVOs) {
		this.sriLankaSearchBlListVOs = sriLankaSearchBlListVOs;
	}
	public void setSriLankaSearchRegistNoVOs(List<SriLankaSearchRegistNoVO> sriLankaSearchRegistNoVOs) {
		this.sriLankaSearchRegistNoVOs = sriLankaSearchRegistNoVOs;
	}
	 
	public void setSriLankaSearchCntrListVOs(List<SriLankaSearchCntrListVO> sriLankaSearchCntrListVOs) {
		this.sriLankaSearchCntrListVOs = sriLankaSearchCntrListVOs;
	}
	public void setSriLankaSearchCntrListTempVOs(List<SriLankaSearchCntrListTempVO> sriLankaSearchCntrListTempVOs) {
		this.sriLankaSearchCntrListTempVOs = sriLankaSearchCntrListTempVOs;
	}
	 
}
