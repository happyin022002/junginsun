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
package com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaOtrCommVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0157 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0157HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_0157HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0157Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaOtrCommVO coaOtrCommVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaOtrCommVO[] coaOtrCommVOs = null;

	public EsmCoa0157Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setSearchAgnOtrCommCostListVO(SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO){
		this. searchAgnOtrCommCostListVO = searchAgnOtrCommCostListVO;
	}

	public void setCoaOtrCommVO(CoaOtrCommVO coaOtrCommVO){
		this. coaOtrCommVO = coaOtrCommVO;
	}
	
	//SJH.20150507.소스품질
	public void setCoaOtrCommVOS(CoaOtrCommVO[] coaOtrCommVOs){
		if(coaOtrCommVOs != null){
			CoaOtrCommVO[] tmpVOs = Arrays.copyOf(coaOtrCommVOs, coaOtrCommVOs.length);
			this.coaOtrCommVOs = tmpVOs;
		}
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	public SearchAgnOtrCommCostListVO getSearchAgnOtrCommCostListVO(){
		return searchAgnOtrCommCostListVO;
	}

	public CoaOtrCommVO getCoaOtrCommVO(){
		return coaOtrCommVO;
	}
	
	//SJH.20150507.소스품질
	public CoaOtrCommVO[] getCoaOtrCommVOS(){
		CoaOtrCommVO[] rtnVOs = null;
		if (this.coaOtrCommVOs != null) {
			rtnVOs = Arrays.copyOf(coaOtrCommVOs, coaOtrCommVOs.length);
		}
		return rtnVOs;
	}

}