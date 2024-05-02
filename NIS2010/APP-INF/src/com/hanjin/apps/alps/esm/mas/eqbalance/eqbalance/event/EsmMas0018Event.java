/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmMas0018Event.java
*@FileTitle : Set Credit Ratio
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 박수훈
*@LastVersion : 1.1
* 2006.11.23 박칠서 최초 생성
* 2009.09.04 박수훈 Alps New Framework 적용[0018]
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasCntrRepoCrVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo.SearchEQBalance0018ListVO;


/**
 * ESM_MAS_0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_MAS_0018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasCntrRepoCrVO masCntrRepoCrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasCntrRepoCrVO[] masCntrRepoCrVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEQBalance0018ListVO searchEQBalance0018ListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEQBalance0018ListVO[] searchEQBalance0018ListVOs = null;
	
	private SearchConditionVO searchConditionVO = null;

	public EsmMas0018Event(){}
	
	public void setMasCntrRepoCrVO(MasCntrRepoCrVO masCntrRepoCrVO){
		this. masCntrRepoCrVO = masCntrRepoCrVO;
	}

	public void setMasCntrRepoCrVOS(MasCntrRepoCrVO[] masCntrRepoCrVOs){
		this. masCntrRepoCrVOs = masCntrRepoCrVOs;
	}

	public void setSearchEQBalance0018ListVO(SearchEQBalance0018ListVO searchEQBalance0018ListVO){
		this. searchEQBalance0018ListVO = searchEQBalance0018ListVO;
	}

	public void setSearchEQBalance0018ListVOS(SearchEQBalance0018ListVO[] searchEQBalance0018ListVOs){
		this. searchEQBalance0018ListVOs = searchEQBalance0018ListVOs;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public MasCntrRepoCrVO getMasCntrRepoCrVO(){
		return masCntrRepoCrVO;
	}

	public MasCntrRepoCrVO[] getMasCntrRepoCrVOS(){
		return masCntrRepoCrVOs;
	}

	public SearchEQBalance0018ListVO getSearchEQBalance0018ListVO(){
		return searchEQBalance0018ListVO;
	}

	public SearchEQBalance0018ListVO[] getSearchEQBalance0018ListVOS(){
		return searchEQBalance0018ListVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}