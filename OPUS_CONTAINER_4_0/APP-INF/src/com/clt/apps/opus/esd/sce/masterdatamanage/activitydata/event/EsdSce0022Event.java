/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0022Event.java
*@FileTitle : Activity Attribute Management
*Open Issues :
*Change history :
*	- UI 변경에 의한 수정
*@LastModifyDate : 2006-11-08
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmActivityVO;


/**
 * EsdSce0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Se-Hoon PARK
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private  RequestDataSetBC dataSet = null ;
    private MdmActivityVO mdmActivityVO = null;
    private MdmActivityVO[] mdmActivityVOs = null;    
    /**
     * 생성자
     */
    public EsdSce0022Event(){}

    /**
     * 생성자
     * 
     * @param RequestDataSetBC dataSet
     */
    public EsdSce0022Event(RequestDataSetBC dataSet) {
    	this.dataSet = dataSet ;
    }

    /**
     * Exception No 를 반환한다.
     * 
     * @return RequestDataSetBC
     */
    public RequestDataSetBC getDataSet(){
    	return dataSet ;
    }

    /**
     * 이벤트 명(EsdSce0022Event)을 반환
     * 
     * @return EsdSce0022Event
     */
    public String getEventName() {
        return "EsdSce0022Event";
    }

    /**
     * 객체 표현 문자열(EsdSce0022Event)을 반환
     * 
     * @return String EsdSce0022Event
     */
    public String toString() {
        return "EsdSce0022Event";
    }
    /**
     * MdmActivityVO 저장
     * @param mdmActivityVO
     */
    public void setMdmActivityVO(MdmActivityVO mdmActivityVO){
    	this.mdmActivityVO = mdmActivityVO;
    }
    /**
     * MdmActivityVO 반환
     * @return
     */
    public MdmActivityVO getMdmActivityVO(){
    	return mdmActivityVO;
    }
    /**
     * MdmActivityVO[] 저장
     * @param mdmActivityVOs
     */
    public void setMdmActivityVOs(MdmActivityVO[] mdmActivityVOs, String usrId){
		if(mdmActivityVOs != null){
			MdmActivityVO[] tmpVOs = Arrays.copyOf(mdmActivityVOs, mdmActivityVOs.length);
			if(tmpVOs != null){
				for(int i=0; i<tmpVOs.length; i++){
					tmpVOs[i].setCreUsrId(usrId);
					tmpVOs[i].setUpdUsrId(usrId);	
				}
			}    
			this.mdmActivityVOs = tmpVOs;
		}   	
    }
    /**
     * MdmActivityVO[] 반환 
     * @return
     */
    public MdmActivityVO[] getMdmActivityVOs(){
    	MdmActivityVO[] rtnVOs = null;
		if (this.mdmActivityVOs != null) {
			rtnVOs = Arrays.copyOf(mdmActivityVOs, mdmActivityVOs.length);
		}
		return rtnVOs;
    }    
}
