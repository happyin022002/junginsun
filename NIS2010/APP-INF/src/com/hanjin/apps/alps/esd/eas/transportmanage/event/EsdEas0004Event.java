/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdEas0004Event.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import com.hanjin.apps.alps.esd.eas.transportmanage.vo.ChAuditTroArManageVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0004Event ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0004Event extends EventSupport {

	/** JSP에서 넘어온 파라마메터를 저장하는 dataset  */
	private ChAuditTroArManageVO chAuditTroArManageVo = null;

	/**
     * 생성자<br>
     */
    public EsdEas0004Event() {
    }
    
    public ChAuditTroArManageVO getChAuditTroArManageVo() {
		return chAuditTroArManageVo;
	}

	public void setChAuditTroArManageVo(ChAuditTroArManageVO chAuditTroArManageVo) {
		this.chAuditTroArManageVo = chAuditTroArManageVo;
	}

	/**
     * 이벤트 명(EsdEas0004Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0004Event";
    }

    /**
     * 객체 표현 문자열(EsdEas0004Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0004Event";
    }

}
