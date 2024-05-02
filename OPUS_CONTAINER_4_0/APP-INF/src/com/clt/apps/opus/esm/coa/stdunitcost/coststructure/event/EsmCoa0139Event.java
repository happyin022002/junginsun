/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EsmCoa0139Event.java
*@FileTitle : Feeder Term
*Open Issues :
*@LastModifyDate : 2009-07-24
*@LastModifier : 장영석
*@LastVersion : 1.3
* 2007-05-22 Lee Ho Ik
* 1.0 최초 생성
*Change history :
* 2009.07.24 장영석 New Framework 적용
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0139ListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaTrnsFdrTermVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0139 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0139HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_0139HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0139Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaTrnsFdrTermVO coaTrnsFdrTermVO = null;
	
	private SearchConditionVO searchConditionVO = null;
	/** Table Value Object Multi Data 처리 */
	private CoaTrnsFdrTermVO[] coaTrnsFdrTermVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCostStructure0139ListVO searchCostStructure0139ListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCostStructure0139ListVO[] searchCostStructure0139ListVOs = null;

	public EsmCoa0139Event(){}
	
	public void setCoaTrnsFdrTermVO(CoaTrnsFdrTermVO coaTrnsFdrTermVO){
		this. coaTrnsFdrTermVO = coaTrnsFdrTermVO;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}           
	
	//SJH.20150508.소스품질
	public void setCoaTrnsFdrTermVOS(CoaTrnsFdrTermVO[] coaTrnsFdrTermVOs){
		if(coaTrnsFdrTermVOs != null){
			CoaTrnsFdrTermVO[] tmpVOs = Arrays.copyOf(coaTrnsFdrTermVOs, coaTrnsFdrTermVOs.length);
			this.coaTrnsFdrTermVOs = tmpVOs;
		}
	}

	public void setSearchCostStructure0139ListVO(SearchCostStructure0139ListVO searchCostStructure0139ListVO){
		this. searchCostStructure0139ListVO = searchCostStructure0139ListVO;
	}
	//SJH.20150508.소스품질
	public void setSearchCostStructure0139ListVOS(SearchCostStructure0139ListVO[] searchCostStructure0139ListVOs){
		if(searchCostStructure0139ListVOs != null){
			SearchCostStructure0139ListVO[] tmpVOs = Arrays.copyOf(searchCostStructure0139ListVOs, searchCostStructure0139ListVOs.length);
			this.searchCostStructure0139ListVOs = tmpVOs;
		}
	}

	public CoaTrnsFdrTermVO getCoaTrnsFdrTermVO(){
		return coaTrnsFdrTermVO;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	//SJH.20150508.소스품질
	public CoaTrnsFdrTermVO[] getCoaTrnsFdrTermVOS(){
		CoaTrnsFdrTermVO[] rtnVOs = null;
		if (this.coaTrnsFdrTermVOs != null) {
			rtnVOs = Arrays.copyOf(coaTrnsFdrTermVOs, coaTrnsFdrTermVOs.length);
		}
		return rtnVOs;
	}

	public SearchCostStructure0139ListVO getSearchCostStructure0139ListVO(){
		return searchCostStructure0139ListVO;
	}
	//SJH.20150508.소스품질
	public SearchCostStructure0139ListVO[] getSearchCostStructure0139ListVOS(){
		SearchCostStructure0139ListVO[] rtnVOs = null;
		if (this.searchCostStructure0139ListVOs != null) {
			rtnVOs = Arrays.copyOf(searchCostStructure0139ListVOs, searchCostStructure0139ListVOs.length);
		}
		return rtnVOs;
	}

}