/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0152Event.java
*@FileTitle : MRI Inquiry
*Open Issues :
*@LastModifyDate : 2009.09.14
*@LastModifier : 장영석
*@LastVersion : 1.1
* Change history :
* 2009.09.14 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mriinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.hanjin.syscommon.common.table.CoaMonMiscRevPreTeuVO;


/**
 * ESM_COA_0152 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0152HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_0152HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0152Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMRIInquiryListVO searchMRIInquiryListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaMonMiscRevPreTeuVO[] coaMonMiscRevPreTeuVOs = null;

	public EsmCoa0152Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setSearchMRIInquiryListVO(SearchMRIInquiryListVO searchMRIInquiryListVO){
		this. searchMRIInquiryListVO = searchMRIInquiryListVO;
	}

	public void setCoaMonMiscRevPreTeuVOS(CoaMonMiscRevPreTeuVO[] coaMonMiscRevPreTeuVOs){
		this. coaMonMiscRevPreTeuVOs = coaMonMiscRevPreTeuVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	
	public SearchMRIInquiryListVO getSearchMRIInquiryListVO(){
		return searchMRIInquiryListVO;
	}

	public CoaMonMiscRevPreTeuVO[] getCoaMonMiscRevPreTeuVOS(){
		return coaMonMiscRevPreTeuVOs;
	}

}