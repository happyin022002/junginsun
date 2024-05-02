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
package com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.event;

import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaMonMiscRevPreTeuVO;
import java.util.Arrays;									//SJH.20150508.소스품질

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
	private SearchMRIInquiryListVO[] searchMRIInquiryListVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaMonMiscRevPreTeuVO[] coaMonMiscRevPreTeuVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private GetCodeSelectVO getCodeSelectVO = null;

	public EsmCoa0152Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setSearchMRIInquiryListVO(SearchMRIInquiryListVO searchMRIInquiryListVO){
		this. searchMRIInquiryListVO = searchMRIInquiryListVO;
	}
	//SJH.20150508.소스품질
	public void setCoaMonMiscRevPreTeuVOS(CoaMonMiscRevPreTeuVO[] coaMonMiscRevPreTeuVOs){
		if(coaMonMiscRevPreTeuVOs != null){
			CoaMonMiscRevPreTeuVO[] tmpVOs = Arrays.copyOf(coaMonMiscRevPreTeuVOs, coaMonMiscRevPreTeuVOs.length);
			this.coaMonMiscRevPreTeuVOs = tmpVOs;
		}
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	
	public SearchMRIInquiryListVO getSearchMRIInquiryListVO(){
		return searchMRIInquiryListVO;
	}
	//SJH.20150508.소스품질
	public CoaMonMiscRevPreTeuVO[] getCoaMonMiscRevPreTeuVOS(){
		CoaMonMiscRevPreTeuVO[] rtnVOs = null;
		if (this.coaMonMiscRevPreTeuVOs != null) {
			rtnVOs = Arrays.copyOf(coaMonMiscRevPreTeuVOs, coaMonMiscRevPreTeuVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150508.소스품질
	public SearchMRIInquiryListVO[] getSearchMRIInquiryListVOs() {
		SearchMRIInquiryListVO[] rtnVOs = null;
		if (this.searchMRIInquiryListVOs != null) {
			rtnVOs = Arrays.copyOf(searchMRIInquiryListVOs, searchMRIInquiryListVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150508.소스품질
	public void setSearchMRIInquiryListVOs(SearchMRIInquiryListVO[] searchMRIInquiryListVOs){
		if(searchMRIInquiryListVOs != null){
			SearchMRIInquiryListVO[] tmpVOs = Arrays.copyOf(searchMRIInquiryListVOs, searchMRIInquiryListVOs.length);
			this.searchMRIInquiryListVOs = tmpVOs;
		}
	}

	public GetCodeSelectVO getGetCodeSelectVO() {
		return getCodeSelectVO;
	}

	public void setGetCodeSelectVO(GetCodeSelectVO getCodeSelectVO) {
		this.getCodeSelectVO = getCodeSelectVO;
	}

	
	
}