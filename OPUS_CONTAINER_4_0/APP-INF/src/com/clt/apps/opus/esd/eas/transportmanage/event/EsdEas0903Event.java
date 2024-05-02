/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0903Event.java
*@FileTitle : Route UnMatch List PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.event;

import java.util.Collection;

import com.clt.apps.opus.esd.eas.common.util.RequestDataSet;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0903Event ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0903Event extends EventSupport {

	String bkgNo;
	String soOfcCd;
	
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	public String getBkgNo() {
		return bkgNo;
	}

	public void setSoOfcCd(String soOfcCd) {
		this.soOfcCd = soOfcCd;
	}	
	
    public String getSoOfcCd() {
		return soOfcCd;
	}	
	
	
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
    public EsdEas0903Event() {

    }

    /**
     * 생성자<br>
     *
     * @param dataSet jsp에서 넘어온 parameter를 저장한 data set
     */
    public EsdEas0903Event(RequestDataSet dataSet) {
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
        return "ESD_EAS_0903Event";
    }

    /**
     * 객체 표현 문자열(ESD_EAS_0903Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "ESD_EAS_0903Event";
    }


}
