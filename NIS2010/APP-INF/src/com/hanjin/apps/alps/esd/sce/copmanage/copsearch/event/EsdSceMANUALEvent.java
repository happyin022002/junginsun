/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COPManageEvent.java
*@FileTitle : COP
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-25
*@LastModifier : Jongwon Park
*@LastVersion : 1.0
* 2006-09-25 Jongwon Park
* 1.0 ���� ��
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;

import java.util.ArrayList;
import java.util.Collection;

import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * COPManageEvent ���� PDTO(Data Transfer Object including Parameters)<br>
 * - <br>
 * - ServiceCommand Layer <br>
 *
 * @author Jongwon Park
 * @see HTMLAction ��v
 * @since J2EE 1.4
 */
public class EsdSceMANUALEvent extends EventSupport {
	
    ArrayList updateList = null;
	/** Default 생성자
     * @param 
     */
	public EsdSceMANUALEvent(){}


    /**
     * 이벤트 명(COPManageEvent)을 반환
     * 
     * @return COPManageEvent
     */
	public String getEventName() {
		return "EsdSceMANUALEvent";
	}

    /**
     * 객체 표현 문자열(COPManageEvent)을 반환
     * 
     * @return String COPManageEvent
     */
	public String toString() {
		return "EsdSceMANUALEvent";
	}
	
	/**
	 * @return Returns the updateList.
	 */
	public ArrayList getUpdateList() {
		return updateList;
	}

	/**
	 * @param updateList The updateList to set.
	 */
	public void setUpdateList(ArrayList updateList) {
		this.updateList = updateList;
	}
}