/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb801Event.java
*@FileTitle : manualregister
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchManualRegisterListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchTPBDuplicationListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TPB_801 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_801HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0801HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0801Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Parameter 변수가 필요하면 개발자 작성 start*/
	/** Parameter 변수가 필요하면 개발자 작성 end*/

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchManualRegisterListVO searchManualRegisterListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchManualRegisterListVO[] searchManualRegisterListVOs = null;

	private SearchTPBDuplicationListVO searchTPBDuplicationListVO = null;
	
	private SearchTPBDuplicationListVO[] searchTPBDuplicationListVOs = null;
	
	public EsdTpb0801Event(){}
	
	public void setSearchManualRegisterListVO(SearchManualRegisterListVO searchManualRegisterListVO){
		this. searchManualRegisterListVO = searchManualRegisterListVO;
	}

	public void setSearchManualRegisterListVOS(SearchManualRegisterListVO[] searchManualRegisterListVOs){
		this. searchManualRegisterListVOs = searchManualRegisterListVOs;
	}

	public SearchManualRegisterListVO getSearchManualRegisterListVO(){
		return searchManualRegisterListVO;
	}

	public SearchManualRegisterListVO[] getSearchManualRegisterListVOS(){
		return searchManualRegisterListVOs;
	}

	public SearchTPBDuplicationListVO getSearchTPBDuplicationListVO() {
		return searchTPBDuplicationListVO;
	}

	public void setSearchTPBDuplicationListVO(
			SearchTPBDuplicationListVO searchTPBDuplicationListVO) {
		this.searchTPBDuplicationListVO = searchTPBDuplicationListVO;
	}

	public SearchTPBDuplicationListVO[] getSearchTPBDuplicationListVOs() {
		return searchTPBDuplicationListVOs;
	}

	public void setSearchTPBDuplicationListVOs(
			SearchTPBDuplicationListVO[] searchTPBDuplicationListVOs) {
		this.searchTPBDuplicationListVOs = searchTPBDuplicationListVOs;
	}

}