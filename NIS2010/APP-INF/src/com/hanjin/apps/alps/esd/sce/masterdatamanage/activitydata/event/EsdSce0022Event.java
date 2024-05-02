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
* 2009-10-06  : hyun-kyoung oh NIS2010 construction 
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmActivityVO;


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

    private MdmActivityVO mdmActivityVO = null;
    private MdmActivityVO[] mdmActivityVOs = null;    
    /**
     * 생성자
     */
    public EsdSce0022Event(){}

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
    	this.mdmActivityVOs = mdmActivityVOs;
		if(mdmActivityVOs != null){
			for(int i=0; i<mdmActivityVOs.length; i++){
				mdmActivityVOs[i].setCreUsrId(usrId);
				mdmActivityVOs[i].setUpdUsrId(usrId);	
			}
		}    	
    }
    /**
     * MdmActivityVO[] 반환 
     * @return
     */
    public MdmActivityVO[] getMdmActivityVOs(){
    	return mdmActivityVOs;
    }    
}
