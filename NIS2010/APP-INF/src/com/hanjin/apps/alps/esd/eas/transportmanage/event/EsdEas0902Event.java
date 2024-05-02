/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0902Event.java
*@FileTitle : Remark Detail 조회/추가/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2008-05-22
*@LastModifier : JeongHo_Lee
*@LastVersion : 1.0
* 2008-05-22 JeongHo_Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import java.util.Collection;
import java.util.HashMap;

import com.hanjin.apps.alps.esd.eas.common.util.RequestDataSet;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0902Event ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0902Event extends EventSupport {

	/** JSP에서 넘어온 파라마메터를 저장하는 dataset  */
	private RequestDataSet dataSet = null;
	private Collection easRoutunmat = null;
	
	/**
	 * ESD_EAS_002Event에서 SCE_COP_HDR 데이터 타입의 매개변수
	 * @param eas_routunmat 
	 */
	public void setROUunmat(Collection eas_routunmat) {
		this.easRoutunmat = eas_routunmat;
	}

	/**
	 * @return Returns eas_routunmat.
	 */

	public Collection getROUunmat() {
		return easRoutunmat;
	}

	/**
     * 생성자<br>
     */
    public EsdEas0902Event() {

    }

    /**
     * 생성자<br>
     *
     * @param dataSet jsp에서 넘어온 parameter를 저장한 data set
     */
    public EsdEas0902Event(RequestDataSet dataSet) {
        this.dataSet = dataSet;
    }

    /**
     * RequestDataSetBC를 리턴
     *
     * @return dataSet String
     */
    public RequestDataSet getDataSet(){
        return dataSet;
    }
    
    /**
     * 이벤트 명(ESD_EAS_0903Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "ESD_EAS_0902Event";
    }

    /**
     * 객체 표현 문자열(ESD_EAS_0903Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "ESD_EAS_0902Event";
    }


}
