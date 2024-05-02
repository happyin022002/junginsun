/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsContainerVO.java
*@FileTitle :  화면에서  정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.19 임재택
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

public class RocsContainerVO extends ManifestListDetailVO {
	private static final long serialVersionUID = 1L;
	
	private List<RocsManifestConfirmationVO> rocsManifestConfirmationVOs;
	private List<RocsSearchPortListVO> rocsSearchPortListVOs;
	private List<RocsSearchInboundBlListVO> rocsSearchInboundBlListVOs;
	private List<RocsSearchBlCountVO> rocsSearchBlCountVOs;
	
	private RocsSearchBlInfoVO rocsSearchBlInfoVO;	
	private RocsBlModificationVO rocsBlModificationVO;	
	private List<RocsSearchCntrListVO> rocsSearchCntrListVOs;
	private List<RocsSearchCargoDetailVO> rocsSearchCargoDetailVOs;
	 
	
	private RocsSearchVslInfoVO rocsSearchVslInfoVO;    
	
	public RocsContainerVO() {}
	
	 
	public List<RocsSearchCntrListVO> getRocsSearchCntrListVOs() {
		return rocsSearchCntrListVOs;
	}
	public List<RocsSearchInboundBlListVO> getRocsSearchInboundBlListVOs() {
		return rocsSearchInboundBlListVOs;
	}
	public List<RocsSearchCargoDetailVO> getRocsSearchCargoDetailVOs() {
		return rocsSearchCargoDetailVOs;
	}
	
	public List<RocsManifestConfirmationVO> getRocsManifestConfirmationVOs() {
		return rocsManifestConfirmationVOs;
	}
	public List<RocsSearchPortListVO> getRocsSearchPortListVOs() {
		return rocsSearchPortListVOs;
	}
	public List<RocsSearchBlCountVO> getRocsSearchBlCountVOs() {
		return rocsSearchBlCountVOs;
	}
	 
	public void setRocsManifestConfirmationVOs(List<RocsManifestConfirmationVO> rocsManifestConfirmationVOs) {
		this.rocsManifestConfirmationVOs =  rocsManifestConfirmationVOs;
	}
	public void setRocsSearchInboundBlListVOs(List<RocsSearchInboundBlListVO> rocsSearchInboundBlListVOs) {
		this.rocsSearchInboundBlListVOs =  rocsSearchInboundBlListVOs;
	}
	public void setRocsSearchPortListVOs(List<RocsSearchPortListVO> rocsSearchPortListVOs) {
		this.rocsSearchPortListVOs = rocsSearchPortListVOs;
	}
	public void setRocsSearchBlCountVOs(List<RocsSearchBlCountVO> rocsSearchBlCountVOs) {
		this.rocsSearchBlCountVOs = rocsSearchBlCountVOs;
	}
	
	 
	
	public void setRocsSearchCntrListVOs(List<RocsSearchCntrListVO> rocsSearchCntrListVOs) {
		this.rocsSearchCntrListVOs = rocsSearchCntrListVOs;
	}
	
	public void setRocsSearchCargoDetailVOs(List<RocsSearchCargoDetailVO> rocsSearchCargoDetailVOs) {
		this.rocsSearchCargoDetailVOs = rocsSearchCargoDetailVOs;
	}
	 
	public RocsSearchVslInfoVO getRocsSearchVslInfoVO() {
		return rocsSearchVslInfoVO;
	}
	
	public RocsBlModificationVO getRocsBlModificationVO() {
		return rocsBlModificationVO;
	}
	
	public void setRocsSearchVslInfoVO(RocsSearchVslInfoVO rocsSearchVslInfoVO) {
		this.rocsSearchVslInfoVO = rocsSearchVslInfoVO;
	}
	public void setRocsBlModificationVO(RocsBlModificationVO rocsBlModificationVO) {
		this.rocsBlModificationVO = rocsBlModificationVO;
	}
	
	public RocsSearchBlInfoVO getRocsSearchBlInfoVO() {
		return rocsSearchBlInfoVO;
	}
	
	public void setRocsSearchBlInfoVO(RocsSearchBlInfoVO rocsSearchBlInfoVO) {
		this.rocsSearchBlInfoVO = rocsSearchBlInfoVO;
	}
	
}
