/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmCoa0009Event.java
*@FileTitle : EQ Repo Cost (PA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.11.16 임옥영  최초 생성
* 2009.08.13 박수훈  ALPS New Framework 적용[0009]
* 1.0 Creation
* 
* Change history : 
* 2011.07.12 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost2ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost3ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost4ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost5ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost6ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost7ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost8ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost9ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost10ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost11ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost12ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost13ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost14ListVO;


/**
 * ESM_COA_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_COA_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO searchMTCostListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost2ListVO searchMTCost2ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost3ListVO searchMTCost3ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost4ListVO searchMTCost4ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost5ListVO searchMTCost5ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost6ListVO searchMTCost6ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost7ListVO searchMTCost7ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost8ListVO searchMTCost8ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost9ListVO searchMTCost9ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost10ListVO searchMTCost10ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost11ListVO searchMTCost11ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost12ListVO searchMTCost12ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost13ListVO searchMTCost13ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCost14ListVO searchMTCost14ListVO = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;
	
	private String fCostYrmon = "";

	public EsmCoa0009Event(){}
	
	public void setSearchMTCostListVO(SearchMTCostListVO searchMTCostListVO){
		this. searchMTCostListVO = searchMTCostListVO;
	}

	public void setSearchMTCost2ListVO(SearchMTCost2ListVO searchMTCost2ListVO){
		this. searchMTCost2ListVO = searchMTCost2ListVO;
	}

	public void setSearchMTCost3ListVO(SearchMTCost3ListVO searchMTCost3ListVO){
		this. searchMTCost3ListVO = searchMTCost3ListVO;
	}

	public void setSearchMTCost4ListVO(SearchMTCost4ListVO searchMTCost4ListVO){
		this. searchMTCost4ListVO = searchMTCost4ListVO;
	}

	public void setSearchMTCost5ListVO(SearchMTCost5ListVO searchMTCost5ListVO){
		this. searchMTCost5ListVO = searchMTCost5ListVO;
	}

	public void setSearchMTCost6ListVO(SearchMTCost6ListVO searchMTCost6ListVO){
		this. searchMTCost6ListVO = searchMTCost6ListVO;
	}

	public void setSearchMTCost7ListVO(SearchMTCost7ListVO searchMTCost7ListVO){
		this. searchMTCost7ListVO = searchMTCost7ListVO;
	}

	public void setSearchMTCost8ListVO(SearchMTCost8ListVO searchMTCost8ListVO){
		this. searchMTCost8ListVO = searchMTCost8ListVO;
	}

	public void setSearchMTCost9ListVO(SearchMTCost9ListVO searchMTCost9ListVO){
		this. searchMTCost9ListVO = searchMTCost9ListVO;
	}

	public void setSearchMTCost10ListVO(SearchMTCost10ListVO searchMTCost10ListVO){
		this. searchMTCost10ListVO = searchMTCost10ListVO;
	}

	public void setSearchMTCost11ListVO(SearchMTCost11ListVO searchMTCost11ListVO){
		this. searchMTCost11ListVO = searchMTCost11ListVO;
	}

	public void setSearchMTCost12ListVO(SearchMTCost12ListVO searchMTCost12ListVO){
		this. searchMTCost12ListVO = searchMTCost12ListVO;
	}

	public void setSearchMTCost13ListVO(SearchMTCost13ListVO searchMTCost13ListVO){
		this. searchMTCost13ListVO = searchMTCost13ListVO;
	}

	public void setSearchMTCost14ListVO(SearchMTCost14ListVO searchMTCost14ListVO){
		this. searchMTCost14ListVO = searchMTCost14ListVO;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public SearchMTCostListVO getSearchMTCostListVO(){
		return searchMTCostListVO;
	}

	public SearchMTCost2ListVO getSearchMTCost2ListVO(){
		return searchMTCost2ListVO;
	}

	public SearchMTCost3ListVO getSearchMTCost3ListVO(){
		return searchMTCost3ListVO;
	}

	public SearchMTCost4ListVO getSearchMTCost4ListVO(){
		return searchMTCost4ListVO;
	}

	public SearchMTCost5ListVO getSearchMTCost5ListVO(){
		return searchMTCost5ListVO;
	}

	public SearchMTCost6ListVO getSearchMTCost6ListVO(){
		return searchMTCost6ListVO;
	}

	public SearchMTCost7ListVO getSearchMTCost7ListVO(){
		return searchMTCost7ListVO;
	}

	public SearchMTCost8ListVO getSearchMTCost8ListVO(){
		return searchMTCost8ListVO;
	}

	public SearchMTCost9ListVO getSearchMTCost9ListVO(){
		return searchMTCost9ListVO;
	}

	public SearchMTCost10ListVO getSearchMTCost10ListVO(){
		return searchMTCost10ListVO;
	}
	
	public SearchMTCost11ListVO getSearchMTCost11ListVO(){
		return searchMTCost11ListVO;
	}

	public SearchMTCost12ListVO getSearchMTCost12ListVO(){
		return searchMTCost12ListVO;
	}

	public SearchMTCost13ListVO getSearchMTCost13ListVO(){
		return searchMTCost13ListVO;
	}

	public SearchMTCost14ListVO getSearchMTCost14ListVO(){
		return searchMTCost14ListVO;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	/**
	 * @return the fCostYrmon
	 */
	public String getFCostYrmon() {
		return fCostYrmon;
	}

	/**
	 * @param fCostYrmon the fCostYrmon to set
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
	}
	
	

}