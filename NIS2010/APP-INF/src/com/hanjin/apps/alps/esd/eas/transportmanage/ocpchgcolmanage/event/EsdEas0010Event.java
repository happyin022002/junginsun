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
package com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.event;

import com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.vo.SearchOCPChgListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0010Event ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0010Event extends EventSupport {

	/** JSP에서 넘어온 파라마메터를 저장하는 */
	private SearchOCPChgListVO searchOCPChgListVo = null;
	
	private SearchOCPChgListVO[] searchOCPChgListVos = null;


	/**
     * 생성자<br>
     */
    public EsdEas0010Event() {

    }


	public SearchOCPChgListVO getSearchOCPChgListVo() {
		return searchOCPChgListVo;
	}

	public SearchOCPChgListVO[] getSearchOCPChgListVos() {
		SearchOCPChgListVO[] rtnVOs = null;
		if (this.searchOCPChgListVos != null) {
			rtnVOs = new SearchOCPChgListVO[searchOCPChgListVos.length];
			System.arraycopy(searchOCPChgListVos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}	

	public void setSearchOCPChgListVo( SearchOCPChgListVO oCPChgListVo) {
		searchOCPChgListVo = oCPChgListVo;
	}
	
	public void setSearchOCPChgListVos(SearchOCPChgListVO[] oCPChgListVos){
		if(oCPChgListVos != null){
			SearchOCPChgListVO[] tmpVOs = new SearchOCPChgListVO[oCPChgListVos.length];
			System.arraycopy(oCPChgListVos, 0, tmpVOs, 0, tmpVOs.length);
			this.searchOCPChgListVos = tmpVOs;
		}
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
