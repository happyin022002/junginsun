/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0061Event.java
*@FileTitle : Inquiry By BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.28 송호진
* 1.0 Creation
===========================================================
' History :
' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 디렉토리 변경   
' 2009.09.15 송호진 ALPS F/W 적용   
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.BkgRpt0061VO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;


/**
 * ESM_MAS_0061 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0061HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_MAS_0061HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0061Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgRpt0061VO bkgRpt0061VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgRpt0061VO[] bkgRpt0061VOs = null;

	private SearchConditionVO searchConditionVO = null;
	
	public EsmMas0061Event(){}
	
	public void setBkgRpt0061VO(BkgRpt0061VO bkgRpt0061VO){
		this. bkgRpt0061VO = bkgRpt0061VO;
	}

	public void setBkgRpt0061VOS(BkgRpt0061VO[] bkgRpt0061VOs){
		this. bkgRpt0061VOs = bkgRpt0061VOs;
	}

	public BkgRpt0061VO getBkgRpt0061VO(){
		return bkgRpt0061VO;
	}

	public BkgRpt0061VO[] getBkgRpt0061VOS(){
		return bkgRpt0061VOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}
}