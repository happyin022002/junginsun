/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0115Event.java
*@FileTitle : Manual Container Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2008-09 Hun-Il Jung
* 1.0 최초 생성
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.vo.ManualReplanInfoVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.BkgCopManageVO;

/**
 * EsdSce0115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hun-Il Jung
 * @see Event 참조
 * @since J2EE 1.4
 */
public class EsdSce0115Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private ManualReplanInfoVO manualReplanInfoVO = null;
	private ManualReplanInfoVO[] manualReplanInfoVOs = null;
	private BkgCopManageVO[] bkgCopManageVOs = null;
    /**
     * 생성자
     */
    public EsdSce0115Event(){}

    /**
     * 이벤트 명(EsdSce0115Event)을 반환
     *
     * @return EsdSce0115Event
     */
    public String getEventName() {
        return "EsdSce0115Event";
    }

    /**
     * 객체 표현 문자열(EsdSce0115Event)을 반환
     *
     * @return String EsdSce0115Event
     */
    public String toString() {
        return "EsdSce0115Event";
    }

    public ManualReplanInfoVO getManualReplanInfoVO(){
    	return manualReplanInfoVO;
    }
    public void setManualReplanInfoVO(ManualReplanInfoVO manualReplanInfoVO){
    	this.manualReplanInfoVO = manualReplanInfoVO;
    }
    public ManualReplanInfoVO[] getManualReplanInfoVOs(){
    	return manualReplanInfoVOs;
    }
    public void setManualReplanInfoVOs(ManualReplanInfoVO[] manualReplanInfoVOs){
    	this.manualReplanInfoVOs = manualReplanInfoVOs;
    }

    public BkgCopManageVO[] getBkgCopManageVOs(){
    	return bkgCopManageVOs;
    }
    public void setBkgCopManageVOs(BkgCopManageVO[] bkgCopManageVOs){
    	this.bkgCopManageVOs = bkgCopManageVOs;
    }                   
}
