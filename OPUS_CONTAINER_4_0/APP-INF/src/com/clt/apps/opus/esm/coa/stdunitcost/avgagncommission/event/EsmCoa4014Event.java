/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0157Event.java
*@FileTitle :  Agent Other Commission Inquiry (PA/RA)
*Open Issues :
*@LastModifyDate : 2009.09.18
*@LastModifier : 장영석
*@LastVersion : 1.1
* Change history :
* 2009.09.18 장영석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.vo.AvgAgencyCommissionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_COA_4014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_4014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_4014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa4014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AvgAgencyCommissionVO avgAgencyCommissionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AvgAgencyCommissionVO[] avgAgencyCommissionVOs = null;

	public EsmCoa4014Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setAvgAgencyCommissionVO(AvgAgencyCommissionVO avgAgencyCommissionVO){
		this.avgAgencyCommissionVO = avgAgencyCommissionVO;
	}

	public void setAvgAgencyCommissionVOS(AvgAgencyCommissionVO[] avgAgencyCommissionVOs){
		if(avgAgencyCommissionVOs != null){
			AvgAgencyCommissionVO[] tmpVOs = Arrays.copyOf(avgAgencyCommissionVOs, avgAgencyCommissionVOs.length);
			this.avgAgencyCommissionVOs = tmpVOs;
		}
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	public AvgAgencyCommissionVO getAvgAgencyCommissionVO(){
		return avgAgencyCommissionVO;
	}
	
	public AvgAgencyCommissionVO[] getAvgAgencyCommissionVOS(){
		AvgAgencyCommissionVO[] rtnVOs = null;
		if (this.avgAgencyCommissionVOs != null) {
			rtnVOs = Arrays.copyOf(avgAgencyCommissionVOs, avgAgencyCommissionVOs.length);
		}
		return rtnVOs;
	}

}