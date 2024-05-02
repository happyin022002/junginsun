/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0062Event.java
*@FileTitle : Inquiry By Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.08 송호진
* 1.0 Creation
===========================================================
' History :
' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 디렉토리 변경   
' 2009.09.15 송호진 ALPS F/W 적용   
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.InqByLane0062VO;


/**
 * ESM_MAS_0062 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0062HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_MAS_0062HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0062Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InqByLane0062VO inqByLane0062VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InqByLane0062VO[] inqByLane0062VOs = null;

	private SearchConditionVO searchConditionVO = null;
	
	public EsmMas0062Event(){}
	
	public void setInqByLane0062VO(InqByLane0062VO inqByLane0062VO){
		this. inqByLane0062VO = inqByLane0062VO;
	}

	public void setInqByLane0062VOS(InqByLane0062VO[] inqByLane0062VOs){
		this. inqByLane0062VOs = inqByLane0062VOs;
	}

	public InqByLane0062VO getInqByLane0062VO(){
		return inqByLane0062VO;
	}

	public InqByLane0062VO[] getInqByLane0062VOS(){
		return inqByLane0062VOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}
}