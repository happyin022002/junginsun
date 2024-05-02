/* =========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName 		: ESM_COA_135Event.java
 *@FileTitle 		: STP Income Inquiry
 *Open Issues 		:
 *Change history 	:
 *@LastModifyDate	: 2007-04-06
 *@LastModifier 	: Ari
 *@LastVersion 	: 1.0
 * 2007-04-06 Ari
 * 1.0 최초 생성
===========================================================
' History :
' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 디렉토리 변경   
* 2009.09.29 김기식   New FrameWork 적용 
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_COA_035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_COA_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ari
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmCoa0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 화면의 검색조건 관련 VO */
	private SalesOffiRepoConditionVO searchVO = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	/**
	 * ESM_COA_135Event 생성자함수
	 */
	public EsmCoa0035Event(){
		//
	}
	
	public void setSalesOffiRepoConditionVO(SalesOffiRepoConditionVO VO){
		this. searchVO = VO;
	}
	
	public SalesOffiRepoConditionVO getSalesOffiRepoConditionVO(){
		return searchVO;
	}

	/**
	 *  Event 명을 반환한다.
	 */
	public String getEventName() {
		return "EsmCoa0035Event";
	}

	/**
	 *  Event 명을 반환한다.
	 */
	public String toString() {
		return "EsmCoa0035Event";
	}
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}	
}