/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdEas0006Event.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.event;

import com.clt.apps.opus.esd.eas.transportmanage.vo.SearchMscCheckListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EsdEas0006Event PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0006Event extends EventSupport {

	/** JSP에서 넘어온 파라마메터를 저장하는 dataset  */
	private SearchMscCheckListVO searchMscCheckListVo = null;

	/**
     * 생성자<br>
     */
    public EsdEas0006Event() {
    }

    public SearchMscCheckListVO getSearchMscCheckListVo() {
		return searchMscCheckListVo;
	}

	public void setSearchMscCheckListVo(SearchMscCheckListVO searchMscCheckListVo) {
		this.searchMscCheckListVo = searchMscCheckListVo;
	}

	/**
     * 이벤트 명(EsdEas0006Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0006Event";
    }

    /**
     * 객체 표현 문자열(ESD_EAS_006Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0006Event";
    }


}
