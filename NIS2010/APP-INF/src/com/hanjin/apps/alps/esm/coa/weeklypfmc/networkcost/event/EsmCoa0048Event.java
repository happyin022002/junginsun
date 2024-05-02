/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmCoa0048Event.java
*@FileTitle : Trunk IPC Internal Pricing
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.10.12 이행지
* 1.0 Creation
 * 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가 
 =========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaInterPrcUtCostVO;


/**
 * ESM_COA_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see ESM_COA_0048HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0048Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaInterPrcUtCostVO coaInterPrcUtCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaInterPrcUtCostVO[] coaInterPrcUtCostVOs = null;

	public EsmCoa0048Event(){}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

	public CoaInterPrcUtCostVO getCoaInterPrcUtCostVO() {
		return coaInterPrcUtCostVO;
	}

	public void setCoaInterPrcUtCostVO(CoaInterPrcUtCostVO coaInterPrcUtCostVO) {
		this.coaInterPrcUtCostVO = coaInterPrcUtCostVO;
	}

	public CoaInterPrcUtCostVO[] getCoaInterPrcUtCostVOs() {
		return coaInterPrcUtCostVOs;
	}

	public void setCoaInterPrcUtCostVOs(CoaInterPrcUtCostVO[] coaInterPrcUtCostVOs) {
		this.coaInterPrcUtCostVOs = coaInterPrcUtCostVOs;
	}
}