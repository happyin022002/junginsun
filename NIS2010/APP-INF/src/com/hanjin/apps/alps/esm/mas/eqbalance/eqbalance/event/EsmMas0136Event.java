/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmMas0136Event.java
*@FileTitle : From(POR) RCC For EQ Repo. Contribution
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 박수훈
*@LastVersion : 1.1
* 2007.04.20 임옥영  최초 생성
* 2009.10.08 박수훈  Alps New Framework 적용[0136]
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasCntrRepoRoutEccVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo.SearchEQBalance0136ListVO;


/**
 * ESM_MAS_0136 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0136HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_MAS_0136HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0136Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasCntrRepoRoutEccVO masCntrRepoRoutEccVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasCntrRepoRoutEccVO[] masCntrRepoRoutEccVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEQBalance0136ListVO searchEQBalance0136ListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEQBalance0136ListVO[] searchEQBalance0136ListVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmMas0136Event(){}
	
	public void setMasCntrRepoRoutEccVO(MasCntrRepoRoutEccVO masCntrRepoRoutEccVO){
		this. masCntrRepoRoutEccVO = masCntrRepoRoutEccVO;
	}

	public void setMasCntrRepoRoutEccVOS(MasCntrRepoRoutEccVO[] masCntrRepoRoutEccVOs){
		this. masCntrRepoRoutEccVOs = masCntrRepoRoutEccVOs;
	}

	public void setSearchEQBalance0136ListVO(SearchEQBalance0136ListVO searchEQBalance0136ListVO){
		this. searchEQBalance0136ListVO = searchEQBalance0136ListVO;
	}

	public void setSearchEQBalance0136ListVOS(SearchEQBalance0136ListVO[] searchEQBalance0136ListVOs){
		this. searchEQBalance0136ListVOs = searchEQBalance0136ListVOs;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}	

	public MasCntrRepoRoutEccVO getMasCntrRepoRoutEccVO(){
		return masCntrRepoRoutEccVO;
	}

	public MasCntrRepoRoutEccVO[] getMasCntrRepoRoutEccVOS(){
		return masCntrRepoRoutEccVOs;
	}

	public SearchEQBalance0136ListVO getSearchEQBalance0136ListVO(){
		return searchEQBalance0136ListVO;
	}

	public SearchEQBalance0136ListVO[] getSearchEQBalance0136ListVOS(){
		return searchEQBalance0136ListVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}