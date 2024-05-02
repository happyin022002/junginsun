/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsCni0301Event.java
*@FileTitle : DW Claim Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event;

import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CustomDryWetClaimVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchDryWetClaimVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CniDwTrnsVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * CPS_CNI_0301 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CPS_CNI_0301HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see CPS_CNI_0301HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0301Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Com Code Id */
	private String comCdId = "";
	
	/** Com Code */
	private String comCode = "";
	
	/** Com Text */
	private String comText = "";
	
	/** Search Text */
	private String searchText = "";
	
	/** DW Claim No */
	private String dwClmNo = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomDryWetClaimVO customDryWetClaimVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchDryWetClaimVO searchDryWetClaimListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchDryWetClaimVO[] searchDryWetClaimListVOs = null;
    
	private CniDwTrnsVO cniDwTrnsVO = null;
	
	public CpsCni0301Event(){}
	
	public void setCustomDryWetClaimVO(CustomDryWetClaimVO customDryWetClaimVO){
		this. customDryWetClaimVO = customDryWetClaimVO;
	}

	public void setSearchDryWetClaimListVO(SearchDryWetClaimVO searchDryWetClaimListVO){
		this. searchDryWetClaimListVO = searchDryWetClaimListVO;
	}

	public void setSearchDryWetClaimListVOS(SearchDryWetClaimVO[] searchDryWetClaimListVOs){
		this. searchDryWetClaimListVOs = searchDryWetClaimListVOs;
	}
    
	public void setCniDwTrnsVO(CniDwTrnsVO cniDwTrnsVO){
		this.cniDwTrnsVO = cniDwTrnsVO;
	}
	
	public void setComCdId(String comCdId) {
		this.comCdId = comCdId;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public void setComText(String comText) {
		this.comText = comText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
	}

	public CustomDryWetClaimVO getCustomDryWetClaimVO(){
		return customDryWetClaimVO;
	}

	public SearchDryWetClaimVO getSearchDryWetClaimListVO(){
		return searchDryWetClaimListVO;
	}

	public SearchDryWetClaimVO[] getSearchDryWetClaimListVOS(){
		return searchDryWetClaimListVOs;
	}
	
	public CniDwTrnsVO getCniDwTrnsVO(){
		return cniDwTrnsVO;
	}
	
	public String getComCdId() {
		return comCdId;
	}
	
	public String getComCode() {
		return comCode;
	}
	
	public String getComText() {
		return comText;
	}
	
	public String getSearchText() {
		return searchText;
	}
	
	public String getDwClmNo() {
		return dwClmNo;
	}

}