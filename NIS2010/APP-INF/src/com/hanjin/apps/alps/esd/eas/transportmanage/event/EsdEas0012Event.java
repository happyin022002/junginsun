/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdEas0012Event.java
*@FileTitle : Drop Off Charge Collection Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-21
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-21 choice
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.eas.transportmanage.vo.DOFChgColInqmanageListVO;

/**
 * EsdEas0012Event ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0012Event extends EventSupport {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** JSP에서 넘어온 파라마메터를 저장하는 */
	private DOFChgColInqmanageListVO dOFChgColInqmanageListVo = null;


	/**
     * 생성자<br>
     */
    public EsdEas0012Event() {

    }


	public DOFChgColInqmanageListVO getDOFChgColInqmanageListVo() {
		return dOFChgColInqmanageListVo;
	}


	public void setDOFChgColInqmanageListVo(
			DOFChgColInqmanageListVO chgColInqmanageListVo) {
		dOFChgColInqmanageListVo = chgColInqmanageListVo;
	}


	/**
     * 이벤트 명(EsdEas0012Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0012Event";
    }

    /**
     * 객체 표현 문자열(EsdEas0012Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0012Event";
    }
}
