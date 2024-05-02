/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0807Event.java
*@FileTitle : RecoveryActivitiManageConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-28
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-10-07 O Wan-Ki 			1.0	 최초 생성
* 2009-09-28 Jong-Geon Byeon	1.1 Renewal Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.vo.SearchRecoveryActivityListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_807 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_807HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0807HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0807Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchRecoveryActivityListVO searchRecoveryActivityListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchRecoveryActivityListVO[] searchRecoveryActivityListVOs = null;

	public EsdTpb0807Event(){}
	
	public void setSearchRecoveryActivityListVO(SearchRecoveryActivityListVO searchRecoveryActivityListVO){
		this. searchRecoveryActivityListVO = searchRecoveryActivityListVO;
	}

	public void setSearchRecoveryActivityListVOS(SearchRecoveryActivityListVO[] searchRecoveryActivityListVOs){
		if(searchRecoveryActivityListVOs != null){
			SearchRecoveryActivityListVO[] tmpVOs = Arrays.copyOf(searchRecoveryActivityListVOs, searchRecoveryActivityListVOs.length);
			this.searchRecoveryActivityListVOs = tmpVOs;
		}
	}

	public SearchRecoveryActivityListVO getSearchRecoveryActivityListVO(){
		return searchRecoveryActivityListVO;
	}

	public SearchRecoveryActivityListVO[] getSearchRecoveryActivityListVOS(){
		SearchRecoveryActivityListVO[] rtnVOs = null;
		if (this.searchRecoveryActivityListVOs != null) {
			rtnVOs = Arrays.copyOf(searchRecoveryActivityListVOs, searchRecoveryActivityListVOs.length);
		}
		return rtnVOs;
	}

}