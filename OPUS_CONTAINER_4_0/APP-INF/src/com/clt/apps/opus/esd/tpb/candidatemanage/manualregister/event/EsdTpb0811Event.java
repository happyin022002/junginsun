/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb811Event.java
*@FileTitle : manualregister
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchContainerInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TPB_811 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_811HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0811HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0811Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchContainerInfoVO searchContainerInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchContainerInfoVO[] searchContainerInfoVOs = null;

	public EsdTpb0811Event(){}

	public SearchContainerInfoVO getSearchContainerInfoVO() {
		return searchContainerInfoVO;
	}

	public void setSearchContainerInfoVO(SearchContainerInfoVO searchContainerInfoVO) {
		this.searchContainerInfoVO = searchContainerInfoVO;
	}

	public SearchContainerInfoVO[] getSearchContainerInfoVOs() {
		SearchContainerInfoVO[] rtnVOs = null;
		if (this.searchContainerInfoVOs != null) {
			rtnVOs = Arrays.copyOf(searchContainerInfoVOs, searchContainerInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchContainerInfoVOs(SearchContainerInfoVO[] searchContainerInfoVOs){
		if(searchContainerInfoVOs != null){
			SearchContainerInfoVO[] tmpVOs = Arrays.copyOf(searchContainerInfoVOs, searchContainerInfoVOs.length);
			this.searchContainerInfoVOs = tmpVOs;
		}
	}




}