/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0060Event.java
*@FileTitle : Actual Activity Inquiry 팝업화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-04
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* 2009-11-04 전병석
* 1.2 버전커밋
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;


import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataOptionsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdSce0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0060Event extends EventSupport{
    private static final long serialVersionUID = 1L;
    
    public EsdSce0060Event(){}
    
    private SearchEdiActivityInquiryDataVO searchActivityInquiryDataVo = null;
    
	/**
	 * SearchEdiActivityInquiryDataVO setter 함수
	 * @param  searchActivityInquiryDataVo SearchEdiActivityInquiryDataVO 
	 * @return 
	 * @throws
	 */	
    public void setSearchEdiActivityInquiryDataVO(SearchEdiActivityInquiryDataVO searchActivityInquiryDataVo){
    	this.searchActivityInquiryDataVo = searchActivityInquiryDataVo;
    }
	/**
	 * SearchEdiActivityInquiryDataVO getter 함수
	 * @param  
	 * @return SearchEdiActivityInquiryDataVO
	 * @throws
	 */    
    public SearchEdiActivityInquiryDataVO getSearchEdiActivityInquiryDataVo(){
    	return this.searchActivityInquiryDataVo;
    }
    private SearchEdiActivityInquiryDataOptionsVO searchEdiActivityInquiryDataOptionsVo = null;
	/**
	 * SearchEdiActivityInquiryDataOptionsVO setter 함수
	 * @param  searchEdiActivityInquiryDataOptionsVo SearchEdiActivityInquiryDataOptionsVO 
	 * @return 
	 * @throws
	 */      
    public void setSearchEdiActivityInquiryDataOptionsVO
       (SearchEdiActivityInquiryDataOptionsVO searchEdiActivityInquiryDataOptionsVo){
    	this.searchEdiActivityInquiryDataOptionsVo = searchEdiActivityInquiryDataOptionsVo;
    }
	/**
	 * SearchEdiActivityInquiryDataOptionsVO getter 함수
	 * @param 
	 * @return SearchEdiActivityInquiryDataOptionsVO
	 * @throws
	 */    
    public SearchEdiActivityInquiryDataOptionsVO getSearchEdiActivityInquiryDataOptionsVO(){
    	return this.searchEdiActivityInquiryDataOptionsVo;
    }
    
}
