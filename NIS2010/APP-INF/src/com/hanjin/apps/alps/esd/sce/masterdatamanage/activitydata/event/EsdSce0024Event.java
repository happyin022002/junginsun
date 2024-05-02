/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0024Event.java
*@FileTitle : COP Scheduling Logic Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
* 2009-10-06  : hyun-kyoung oh NIS2010 construction 
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.event;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.vo.SearchSKDLogicListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SceCopSkdLgcVO;


/**
 * EsdSce0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Se-Hoon PARK
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0024Event extends EventSupport {

	private static final long serialVersionUID = -8747884523848481548L;
	
    private SearchSKDLogicListVO searchSKDLogicListVO = null;
    private SceCopSkdLgcVO[] sceCopSkdLgcVOs = null;    
    /**
     * 생성자
     */
    public EsdSce0024Event(){}

    /**
     * 이벤트 명(EsdSce0024Event)을 반환
     * 
     * @return EsdSce0024Event
     */
    public String getEventName() {
        return "EsdSce0024Event";
    }

    /**
     * 객체 표현 문자열(EsdSce0024Event)을 반환
     * 
     * @return String EsdSce0024Event
     */
    public String toString() {
        return "EsdSce0024Event";
    }
    /**
     * SceCopSkdLgcVO 저장
     * @param sceCopSkdLgcVO
     */
    public void setSearchSKDLogicListVO(SearchSKDLogicListVO searchSKDLogicListVO){
    	this.searchSKDLogicListVO = searchSKDLogicListVO;
    }
    /**
     * SceCopSkdLgcVO 반환
     * @return
     */
    public SearchSKDLogicListVO getSearchSKDLogicListVO(){
    	return this.searchSKDLogicListVO;
    }
    /**
     * SceCopSkdLgcVO[] 저장
     * @param sceCopSkdLgcVOs
     */
    public void setSceCopSkdLgcVOs(SceCopSkdLgcVO[] sceCopSkdLgcVOs, String usrId){
    	this.sceCopSkdLgcVOs = sceCopSkdLgcVOs;
		if(sceCopSkdLgcVOs != null){
			for(int i=0; i<sceCopSkdLgcVOs.length; i++){
				sceCopSkdLgcVOs[i].setCreUsrId(usrId);
				sceCopSkdLgcVOs[i].setUpdUsrId(usrId);	
			}
		}        	
    }
    /**
     * SceCopSkdLgcVO[] 반환
     * @return
     */
    public SceCopSkdLgcVO[] getSceCopSkdLgcVOs(){
    	return sceCopSkdLgcVOs;
    }    
}
