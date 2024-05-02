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
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.vo.SearchSKDLogicListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SceCopSkdLgcVO;


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
	
	private  RequestDataSetBC dataSet = null ;
    private SearchSKDLogicListVO searchSKDLogicListVO = null;
    private SceCopSkdLgcVO[] sceCopSkdLgcVOs = null;    
    /**
     * 생성자
     */
    public EsdSce0024Event(){}

    /**
     * 생성자
     * 
     * @param RequestDataSetBC dataSet
     */
    public EsdSce0024Event(RequestDataSetBC dataSet) {
    	this.dataSet = dataSet ;
    }

    /**
     * Exception No 를 반환한다.
     * 
     * @param cop_expt_no Exception No
     */
    public RequestDataSetBC getDataSet(){
    	return dataSet ;
    }

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
		if(sceCopSkdLgcVOs != null){
			SceCopSkdLgcVO[] tmpVOs = Arrays.copyOf(sceCopSkdLgcVOs, sceCopSkdLgcVOs.length);
			if(tmpVOs != null){
				for(int i=0; i<tmpVOs.length; i++){
					tmpVOs[i].setCreUsrId(usrId);
					tmpVOs[i].setUpdUsrId(usrId);	
				}
			} 
			this.sceCopSkdLgcVOs = tmpVOs;
		}       	
    }
    /**
     * SceCopSkdLgcVO[] 반환
     * @return
     */
    public SceCopSkdLgcVO[] getSceCopSkdLgcVOs(){
    	SceCopSkdLgcVO[] rtnVOs = null;
		if (this.sceCopSkdLgcVOs != null) {
			rtnVOs = Arrays.copyOf(sceCopSkdLgcVOs, sceCopSkdLgcVOs.length);
		}
		return rtnVOs;
    }    
}
