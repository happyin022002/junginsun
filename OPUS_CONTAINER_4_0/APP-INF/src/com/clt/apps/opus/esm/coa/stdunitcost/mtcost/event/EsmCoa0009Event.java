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
* 2009.08.13 박수훈  New Framework 적용[0009]
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO10;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO11;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO12;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO13;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO14;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO2;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO3;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO4;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO5;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO6;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO7;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO8;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO9;
import com.clt.framework.support.layer.event.EventSupport;


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
	private SearchMTCostListVO2 searchMTCostListVO2 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO3 searchMTCostListVO3 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO4 searchMTCostListVO4 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO5 searchMTCostListVO5 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO6 searchMTCostListVO6 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO7 searchMTCostListVO7 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO8 searchMTCostListVO8 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO9 searchMTCostListVO9 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO10 searchMTCostListVO10 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO11 searchMTCostListVO11 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO12 searchMTCostListVO12 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO13 searchMTCostListVO13 = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMTCostListVO14 searchMTCostListVO14 = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmCoa0009Event(){}
	
	public void setSearchMTCostListVO(SearchMTCostListVO searchMTCostListVO){
		this. searchMTCostListVO = searchMTCostListVO;
	}

	public void setSearchMTCostListVO2(SearchMTCostListVO2 searchMTCostListVO2){
		this. searchMTCostListVO2 = searchMTCostListVO2;
	}

	public void setSearchMTCostListVO3(SearchMTCostListVO3 searchMTCostListVO3){
		this. searchMTCostListVO3 = searchMTCostListVO3;
	}

	public void setSearchMTCostListVO4(SearchMTCostListVO4 searchMTCostListVO4){
		this. searchMTCostListVO4 = searchMTCostListVO4;
	}

	public void setSearchMTCostListVO5(SearchMTCostListVO5 searchMTCostListVO5){
		this. searchMTCostListVO5 = searchMTCostListVO5;
	}

	public void setSearchMTCostListVO6(SearchMTCostListVO6 searchMTCostListVO6){
		this. searchMTCostListVO6 = searchMTCostListVO6;
	}

	public void setSearchMTCostListVO7(SearchMTCostListVO7 searchMTCostListVO7){
		this. searchMTCostListVO7 = searchMTCostListVO7;
	}

	public void setSearchMTCostListVO8(SearchMTCostListVO8 searchMTCostListVO8){
		this. searchMTCostListVO8 = searchMTCostListVO8;
	}

	public void setSearchMTCostListVO9(SearchMTCostListVO9 searchMTCostListVO9){
		this. searchMTCostListVO9 = searchMTCostListVO9;
	}

	public void setSearchMTCostListVO10(SearchMTCostListVO10 searchMTCostListVO10){
		this. searchMTCostListVO10 = searchMTCostListVO10;
	}

	public void setSearchMTCostListVO11(SearchMTCostListVO11 searchMTCostListVO11){
		this. searchMTCostListVO11 = searchMTCostListVO11;
	}

	public void setSearchMTCostListVO12(SearchMTCostListVO12 searchMTCostListVO12){
		this. searchMTCostListVO12 = searchMTCostListVO12;
	}

	public void setSearchMTCostListVO13(SearchMTCostListVO13 searchMTCostListVO13){
		this. searchMTCostListVO13 = searchMTCostListVO13;
	}

	public void setSearchMTCostListVO14(SearchMTCostListVO14 searchMTCostListVO14){
		this. searchMTCostListVO14 = searchMTCostListVO14;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public SearchMTCostListVO getSearchMTCostListVO(){
		return searchMTCostListVO;
	}

	public SearchMTCostListVO2 getSearchMTCostListVO2(){
		return searchMTCostListVO2;
	}

	public SearchMTCostListVO3 getSearchMTCostListVO3(){
		return searchMTCostListVO3;
	}

	public SearchMTCostListVO4 getSearchMTCostListVO4(){
		return searchMTCostListVO4;
	}

	public SearchMTCostListVO5 getSearchMTCostListVO5(){
		return searchMTCostListVO5;
	}

	public SearchMTCostListVO6 getSearchMTCostListVO6(){
		return searchMTCostListVO6;
	}

	public SearchMTCostListVO7 getSearchMTCostListVO7(){
		return searchMTCostListVO7;
	}

	public SearchMTCostListVO8 getSearchMTCostListVO8(){
		return searchMTCostListVO8;
	}

	public SearchMTCostListVO9 getSearchMTCostListVO9(){
		return searchMTCostListVO9;
	}

	public SearchMTCostListVO10 getSearchMTCostListVO10(){
		return searchMTCostListVO10;
	}
	
	public SearchMTCostListVO11 getSearchMTCostListVO11(){
		return searchMTCostListVO11;
	}

	public SearchMTCostListVO12 getSearchMTCostListVO12(){
		return searchMTCostListVO12;
	}

	public SearchMTCostListVO13 getSearchMTCostListVO13(){
		return searchMTCostListVO13;
	}

	public SearchMTCostListVO14 getSearchMTCostListVO14(){
		return searchMTCostListVO14;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}