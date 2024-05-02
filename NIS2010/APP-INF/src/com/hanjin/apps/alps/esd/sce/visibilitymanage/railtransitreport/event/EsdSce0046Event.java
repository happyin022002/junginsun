/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0046Event.java
*@FileTitle : Train & Rail Car Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-14
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009-08-14 전병석
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchTRCListOptionsVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * EsdSce046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0046Event extends EventSupport{
	
	public EsdSce0046Event(){}
	
	
	/*VO 조회조건용*/
    private SearchTRCListOptionsVO schTrclOpts = null;
    /** SearchTRCListOptionsVO setter 함수
     * @param SearchTRCListOptionsVO schTrclOpts
     */
    public void setSchTrclOpts (SearchTRCListOptionsVO schTrclOpts){
    	this.schTrclOpts = schTrclOpts;
    }
    /** SearchTRCListOptionsVO getter 함수
     * @return SearchTRCListOptionsVO
     */    
    public SearchTRCListOptionsVO getSchTrclOpts(){
    	return schTrclOpts;
    }

}
