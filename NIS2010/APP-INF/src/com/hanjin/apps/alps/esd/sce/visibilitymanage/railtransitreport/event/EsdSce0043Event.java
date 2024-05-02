/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0043Event.java
*@FileTitle : EsdSce0043Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-11
*@LastModifier : 전병석
*@LastVersion : 1.3
* 2009-08-11 전병석
* 1.3 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * EsdSce043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0043Event extends EventSupport{
	
	public EsdSce0043Event(){}
	
	
	/*VO 조회조건용*/
	private SearchCLMListOptionsVO schClmlOpts = null;
	/**
	 * SearchCLMListOptionsVO setter 함수
	 * @param SearchCLMListOptionsVO schClmlOpts
	 */
	public void setSchClmlOpts(SearchCLMListOptionsVO schClmlOpts){
		this.schClmlOpts  = schClmlOpts;
	}
	/**
	 * SearchCLMListOptionsVO getter 함수
	 * @return SearchCLMListOptionsVO
	 */	
	public SearchCLMListOptionsVO getSchClmlOpts(){
		return schClmlOpts;
	}	

}
