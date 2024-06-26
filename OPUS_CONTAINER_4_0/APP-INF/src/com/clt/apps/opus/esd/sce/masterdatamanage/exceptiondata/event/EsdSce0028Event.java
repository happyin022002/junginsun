/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_EsdSce0028Event.java
*@FileTitle : Exception Notification Subscriber Registration 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-31 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptNotSubInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EsdSce0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seong-mun Kang
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdSce0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
    
    /**
     * 생성자
     */
    public EsdSce0028Event(){}

    /**
     * 생성자
     * 
     * @param cop_expt_no Exception No
     */
    
    private SearchExptSubReqInfoVO reqInfo = null;
    private SearchExptSubReqListVO reqList = null;
    private SearchExptNotSubInfoVO[] exptNotSubs = null;

	public SearchExptSubReqInfoVO getReqInfo() {
		return reqInfo;
	}
	public void setReqInfo(SearchExptSubReqInfoVO reqInfo) {
		this.reqInfo = reqInfo;
	}
	public SearchExptSubReqListVO getReqList() {
		return reqList;
	}
	public void setReqList(SearchExptSubReqListVO reqList) {
		this.reqList = reqList;
	}
	public SearchExptNotSubInfoVO[] getExptNotSubs() {
		SearchExptNotSubInfoVO[] rtnVOs = null;
		if (this.exptNotSubs != null) {
			rtnVOs = Arrays.copyOf(exptNotSubs, exptNotSubs.length);
		}
		return rtnVOs;
	}
	public void setExptNotSubs(SearchExptNotSubInfoVO[] exptNotSubs) {
		if(exptNotSubs != null){
			SearchExptNotSubInfoVO[] tmpVOs = Arrays.copyOf(exptNotSubs, exptNotSubs.length);
			this.exptNotSubs = tmpVOs;
		}
	}    
    
}