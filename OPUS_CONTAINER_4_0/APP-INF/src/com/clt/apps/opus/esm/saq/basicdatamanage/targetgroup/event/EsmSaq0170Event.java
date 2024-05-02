/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0170Event.java
*@FileTitle      : Year/Month Set for Cost Management
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchCostManagement0170ListVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ModelConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqCostApplBseVO;


/**
 * ESM_SAQ_0170 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0170HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ho Kim
 * @see ESM_SAQ_0170HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0170Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	// COMMAND01 및 SEARCHLIST01 시작
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCostManagement0170ListVO searchCostManagementListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCostManagement0170ListVO[] searchCostManagementListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqCostApplBseVO saqCostApplBseVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqCostApplBseVO[] saqCostApplBseVOs = null;
	// COMMAND01 및 SEARCHLIST01 끝
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqCostApplBseVO saqCostApplBseCopyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqCostApplBseVO[] saqCostApplBseCopyVOs = null;
	// COMMAND02 및 SEARCHLIST02 끝
	
	
	private String bseYr = null;
	private String bseQtrCd = null;
	
	public String getBseYr() {
		return bseYr;
	}


	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}


	public String getBseQtrCd() {
		return bseQtrCd;
	}


	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}


	public EsmSaq0170Event(){};
	
	
	/**
	 * @param bseYr
	 * @param bseQtrCd
	 */
	public EsmSaq0170Event(String bseYr, String bseQtrCd){
		this.bseYr = bseYr;
		this.bseQtrCd = bseQtrCd;
	};
	
	
	// COMMAND01 및 SEARCHLIST01 시작
	public void setSearchCostManagementListVO(SearchCostManagement0170ListVO searchCostManagementListVO){
		this. searchCostManagementListVO = searchCostManagementListVO;
	}

	public void setSearchCostManagementListVOS(SearchCostManagement0170ListVO[] searchCostManagementListVOs){
		if(searchCostManagementListVOs != null){
			SearchCostManagement0170ListVO[] tmpVOs = Arrays.copyOf(searchCostManagementListVOs, searchCostManagementListVOs.length);
			this.searchCostManagementListVOs  = tmpVOs;
		}
	}

	public void setSaqCostApplBseVO(SaqCostApplBseVO saqCostApplBseVO){
		this. saqCostApplBseVO = saqCostApplBseVO;
	}

	public void setSaqCostApplBseVOS(SaqCostApplBseVO[] saqCostApplBseVOs){
		if(saqCostApplBseVOs != null){
			SaqCostApplBseVO[] tmpVOs = Arrays.copyOf(saqCostApplBseVOs, saqCostApplBseVOs.length);
			this.saqCostApplBseVOs  = tmpVOs;
		}
	}

	public SearchCostManagement0170ListVO getSearchCostManagementListVO(){
		return searchCostManagementListVO;
	}

	public SearchCostManagement0170ListVO[] getSearchCostManagementListVOS(){
		SearchCostManagement0170ListVO[] rtnVOs = null;
		if (this.searchCostManagementListVOs != null) {
			rtnVOs = Arrays.copyOf(searchCostManagementListVOs, searchCostManagementListVOs.length);
		}
		return rtnVOs;
	}

	public SaqCostApplBseVO getSaqCostApplBseVO(){
		return saqCostApplBseVO;
	}

	public SaqCostApplBseVO[] getSaqCostApplBseVOS(){
		SaqCostApplBseVO[] rtnVOs = null;
		if (this.saqCostApplBseVOs != null) {
			rtnVOs = Arrays.copyOf(saqCostApplBseVOs, saqCostApplBseVOs.length);
		}
		return rtnVOs;
	}
	// COMMAND01 및 SEARCHLIST01 끝

	
	// COMMAND02 및 SEARCHLIST02 시작
	

	public void setSaqCostApplBseCopyVO(SaqCostApplBseVO saqCostApplBseCopyVO){
		this. saqCostApplBseCopyVO = saqCostApplBseCopyVO;
	}

	public void setSaqCostApplBseCopyVOS(SaqCostApplBseVO[] saqCostApplBseCopyVOs){
		if(saqCostApplBseCopyVOs != null){
			SaqCostApplBseVO[] tmpVOs = Arrays.copyOf(saqCostApplBseCopyVOs, saqCostApplBseCopyVOs.length);
			this.saqCostApplBseCopyVOs  = tmpVOs;
		}
	}

	public SaqCostApplBseVO getSaqCostApplBseCopyVO(){
		return saqCostApplBseCopyVO;
	}

	public SaqCostApplBseVO[] getSaqCostApplBseCopyVOS(){
		SaqCostApplBseVO[] rtnVOs = null;
		if (this.saqCostApplBseCopyVOs != null) {
			rtnVOs = Arrays.copyOf(saqCostApplBseCopyVOs, saqCostApplBseCopyVOs.length);
		}
		return rtnVOs;
	}
	// COMMAND02 및 SEARCHLIST02 끝
}