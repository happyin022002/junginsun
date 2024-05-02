/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0063Event.java
*@FileTitle : VVD Inquiry  팝업화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-22
*@LastModifier : Jun Byoung Suk
*@LastVersion : 1.0
* 2009-09-22 Jun Byoung Suk
* 1.0 최초 생성
* 2009-09-22 전병석
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchVesselSkdOptionsVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * COM_ENS_0B2 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_0B2HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyunsu, Ryu
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0063Event extends EventSupport {
    private static final long serialVersionUID = 1L;
    private SearchVesselSkdOptionsVO schVSlVO = null;
	/**
	 * SearchVesselSkdOptionsVO setter 함수
	 * @param  schVSlVO SearchVesselSkdOptionsVO 
	 * @return 
	 * @throws
	 */     
    public void setSchVSlVO(SearchVesselSkdOptionsVO schVSlVO){
    	this.schVSlVO = schVSlVO;
    }
	/**
	 * SearchVesselSkdOptionsVO getter 함수
	 * @param   
	 * @return SearchVesselSkdOptionsVO
	 * @throws
	 */      
    public SearchVesselSkdOptionsVO getSchVSlVO(){
    	return this.schVSlVO;
    }
	/**
	 *생성자
	 */      
    public EsdSce0063Event(){}
}
