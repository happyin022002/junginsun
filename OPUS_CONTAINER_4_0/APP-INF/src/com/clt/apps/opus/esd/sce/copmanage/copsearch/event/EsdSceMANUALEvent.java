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
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.event;

import java.util.ArrayList;

import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * COPManageEvent ���� PDTO(Data Transfer Object including Parameters)<br>
 * - <br>
 * - ServiceCommand Layer <br>
 *
 * @author Jongwon Park
 * @see HTMLAction ��v
 * @since J2EE 1.4
 */
@SuppressWarnings("rawtypes")
public class EsdSceMANUALEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	
    RequestDataSetBC dataSet = null;
    ArrayList updateList = null;
	/** Default 생성자
     * @param 
     */
	public EsdSceMANUALEvent(){}

	/** 
	 * Default 생성자
     * @param RequestDataSetBC dataSet 
     */
	public EsdSceMANUALEvent(RequestDataSetBC dataSet){
		this.dataSet = dataSet;
	}
	
	/**
	 * @param dataSet
	 * @param updateList
	 */
	public EsdSceMANUALEvent(RequestDataSetBC dataSet, ArrayList updateList) {
		this.dataSet = dataSet;
		this.updateList = updateList;
	}

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
	 * @return Returns the dataSet.
	 */
	public RequestDataSetBC getDataSet() {
		return dataSet;
	}

	/**
	 * @param dataSet The dataSet to set.
	 */
	public void setDataSet(RequestDataSetBC dataSet) {
		this.dataSet = dataSet;
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