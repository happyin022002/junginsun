/* =========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName 		: ESM_MAS_135Event.java
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

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_135 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_MAS_135HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ari
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmMas0078Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 화면의 검색조건 관련 VO */
	private SalesOffiRepoConditionVO searchVO = null;
	
	/**
	 * ESM_MAS_135Event 생성자함수
	 */
	public EsmMas0078Event(){
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
		return "EsmMas0078Event";
	}

	/**
	 *  Event 명을 반환한다.
	 */
	public String toString() {
		return "EsmMas0078Event";
	}
}