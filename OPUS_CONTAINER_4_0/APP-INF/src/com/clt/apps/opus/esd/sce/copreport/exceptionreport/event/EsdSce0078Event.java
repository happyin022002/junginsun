/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSce0078Event.java
*@FileTitle : Exception Noti Failure Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.07.28 김성일 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.exceptionreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.copreport.exceptionreport.vo.SearchNotifyFailureVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_SCE_0078 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_0078HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sungil Kim
 * @see ESD_SCE_0078HTMLAction 참조
 * @since J2EE 1.6
 */ 

public class EsdSce0078Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchNotifyFailureVO searchNotifyFailureVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchNotifyFailureVO[] searchNotifyFailureVOs = null;
	
	public EsdSce0078Event(){} 
	
	public void setSearchNotifyFailureVO(SearchNotifyFailureVO searchNotifyFailureVO){
		this. searchNotifyFailureVO = searchNotifyFailureVO;
	} 

	public void setSearchNotifyFailureVOS(SearchNotifyFailureVO[] searchNotifyFailureVOs){
		if(searchNotifyFailureVOs != null){
			SearchNotifyFailureVO[] tmpVOs = Arrays.copyOf(searchNotifyFailureVOs, searchNotifyFailureVOs.length);
			this.searchNotifyFailureVOs = tmpVOs;
		}
	}

	public SearchNotifyFailureVO getSearchNotifyFailureVO(){
		return searchNotifyFailureVO;
	}

	public SearchNotifyFailureVO[] getSearchNotifyFailureVOS(){
		SearchNotifyFailureVO[] rtnVOs = null;
		if (this.searchNotifyFailureVOs != null) {
			rtnVOs = Arrays.copyOf(searchNotifyFailureVOs, searchNotifyFailureVOs.length);
		}
		return rtnVOs;
	}

}