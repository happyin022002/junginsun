/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdEas0010Event.java
*@FileTitle : Drop Off Charge Collection Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-21
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-21 choice
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.event;

import com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.vo.SearchOCPChgListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdEas0010Event ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0010Event extends EventSupport {

	/** JSP에서 넘어온 파라마메터를 저장하는 */
	private SearchOCPChgListVO searchOCPChgListVo = null;


	/**
     * 생성자<br>
     */
    public EsdEas0010Event() {

    }


	public SearchOCPChgListVO getSearchOCPChgListVo() {
		return searchOCPChgListVo;
	}


	public void setSearchOCPChgListVo( SearchOCPChgListVO oCPChgListVo) {
		searchOCPChgListVo = oCPChgListVo;
	}


	/**
     * 이벤트 명(EsdEas0010Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0010Event";
    }

    /**
     * 객체 표현 문자열(EsdEas0010Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0010Event";
    }
}
