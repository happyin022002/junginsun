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
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.vo.ManualReplanInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

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
	private  RequestDataSetBC dataSet = null ;
	private ManualReplanInfoVO manualReplanInfoVO = null;
	private ManualReplanInfoVO[] manualReplanInfoVOs = null;
	private BkgCopManageVO[] bkgCopManageVOs = null;
    /**
     * 생성자
     */
    public EsdSce0115Event(){}

    /**
     * @param dataSet
     */
    public EsdSce0115Event(RequestDataSetBC dataSet) {
    	this.dataSet = dataSet ;
    }

    /**
     * DataSet 를 반환한다.
     *
     * @param dataSet RequestDataSetBC
     */
    public RequestDataSetBC getDataSet(){
    	return dataSet ;
    }

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
    	ManualReplanInfoVO[] rtnVOs = null;
		if (this.manualReplanInfoVOs != null) {
			rtnVOs = Arrays.copyOf(manualReplanInfoVOs, manualReplanInfoVOs.length);
		}
		return rtnVOs;
    }
    public void setManualReplanInfoVOs(ManualReplanInfoVO[] manualReplanInfoVOs){
		if(manualReplanInfoVOs != null){
			ManualReplanInfoVO[] tmpVOs = Arrays.copyOf(manualReplanInfoVOs, manualReplanInfoVOs.length);
			this.manualReplanInfoVOs = tmpVOs;
		}
    }

    public BkgCopManageVO[] getBkgCopManageVOs(){
    	BkgCopManageVO[] rtnVOs = null;
		if (this.bkgCopManageVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCopManageVOs, bkgCopManageVOs.length);
		}
		return rtnVOs;
    }
    public void setBkgCopManageVOs(BkgCopManageVO[] bkgCopManageVOs){
		if(bkgCopManageVOs != null){
			BkgCopManageVO[] tmpVOs = Arrays.copyOf(bkgCopManageVOs, bkgCopManageVOs.length);
			this.bkgCopManageVOs = tmpVOs;
		}
    }                   
}
