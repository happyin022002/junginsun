/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0157Event.java
*@FileTitle :  Agent Other Commission Inquiry (PA/RA)
*Open Issues :
*@LastModifyDate : 2009.09.18
*@LastModifier : 장영석
*@LastVersion : 1.1
* Change history :
* 2009.09.18 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.hanjin.syscommon.common.table.MasOtrCommVO;


/**
 * ESM_MAS_0157 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0157HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_MAS_0157HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0157Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasOtrCommVO masOtrCommVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasOtrCommVO[] masOtrCommVOs = null;

	public EsmMas0157Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setSearchAgnOtrCommCostListVO(SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO){
		this. searchAgnOtrCommCostListVO = searchAgnOtrCommCostListVO;
	}

	public void setMasOtrCommVO(MasOtrCommVO masOtrCommVO){
		this. masOtrCommVO = masOtrCommVO;
	}

	public void setMasOtrCommVOS(MasOtrCommVO[] masOtrCommVOs){
		this. masOtrCommVOs = masOtrCommVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	public SearchAgnOtrCommCostListVO getSearchAgnOtrCommCostListVO(){
		return searchAgnOtrCommCostListVO;
	}

	public MasOtrCommVO getMasOtrCommVO(){
		return masOtrCommVO;
	}

	public MasOtrCommVO[] getMasOtrCommVOS(){
		return masOtrCommVOs;
	}

}