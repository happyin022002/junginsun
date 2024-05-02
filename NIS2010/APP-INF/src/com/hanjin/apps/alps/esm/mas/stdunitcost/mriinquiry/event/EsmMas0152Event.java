/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0152Event.java
*@FileTitle : MRI Inquiry
*Open Issues :
*@LastModifyDate : 2009.09.14
*@LastModifier : 장영석
*@LastVersion : 1.1
* Change history :
* 2009.09.14 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.hanjin.syscommon.common.table.MasMonMiscRevPreTeuVO;


/**
 * ESM_MAS_0152 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0152HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_MAS_0152HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0152Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMRIInquiryListVO searchMRIInquiryListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasMonMiscRevPreTeuVO[] masMonMiscRevPreTeuVOs = null;

	public EsmMas0152Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setSearchMRIInquiryListVO(SearchMRIInquiryListVO searchMRIInquiryListVO){
		this. searchMRIInquiryListVO = searchMRIInquiryListVO;
	}

	public void setMasMonMiscRevPreTeuVOS(MasMonMiscRevPreTeuVO[] masMonMiscRevPreTeuVOs){
		this. masMonMiscRevPreTeuVOs = masMonMiscRevPreTeuVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	
	public SearchMRIInquiryListVO getSearchMRIInquiryListVO(){
		return searchMRIInquiryListVO;
	}

	public MasMonMiscRevPreTeuVO[] getMasMonMiscRevPreTeuVOS(){
		return masMonMiscRevPreTeuVOs;
	}

}