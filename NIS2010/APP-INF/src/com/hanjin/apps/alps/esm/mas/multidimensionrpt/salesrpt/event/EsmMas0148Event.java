/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0148Event.java
*@FileTitle : BKG Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.11 송호진
* 1.0 Creation
===========================================================
 ' History :
 ' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 디렉토리 변경
 ' 2009.09.15 송호진 ALPS F/W 적용   
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.BKGDetail0148VO;


/**
 * ESM_MAS_0148 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0148HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_MAS_0148HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0148Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BKGDetail0148VO bKGDetail0148VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BKGDetail0148VO[] bKGDetail0148VOs = null;

	private SearchConditionVO searchConditionVO = null;

	public EsmMas0148Event(){}
	
	public void setBKGDetail0148VO(BKGDetail0148VO bKGDetail0148VO){
		this. bKGDetail0148VO = bKGDetail0148VO;
	}

	public void setBKGDetail0148VOS(BKGDetail0148VO[] bKGDetail0148VOs){
		this. bKGDetail0148VOs = bKGDetail0148VOs;
	}

	public BKGDetail0148VO getBKGDetail0148VO(){
		return bKGDetail0148VO;
	}

	public BKGDetail0148VO[] getBKGDetail0148VOS(){
		return bKGDetail0148VOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}