/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0408Event.java
*@FileTitle : Each Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.19 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_ctm_0408 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_ctm_0408HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ees_ctm_0408HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCtm0470Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEdiMsgVO searchEdiMsgVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMovementListByContainerVO searchMovementListByContainerVO = null;
	private SearchDeletedMVMTListVO searchDeletedMVMTListVO = null;
	private SearchDeletedMVMTListVO[] searchDeletedMVMTListVOs = null;
	
	public EesCtm0470Event(){}

	public void setSearchEdiMsgVO(SearchEdiMsgVO searchEdiMsgVO){
		this. searchEdiMsgVO = searchEdiMsgVO;
	}

	public void setSearchMovementListByContainerVO(SearchMovementListByContainerVO searchMovementListByContainerVO){
		this. searchMovementListByContainerVO = searchMovementListByContainerVO;
	}

	public SearchEdiMsgVO getSearchEdiMsgVO(){
		return searchEdiMsgVO;
	}

	public SearchMovementListByContainerVO getSearchMovementListByContainerVO(){
		return searchMovementListByContainerVO;
	}
	
	public SearchDeletedMVMTListVO getSearchDeletedMVMTListVO() {
		return searchDeletedMVMTListVO;
	}

	public void setSearchDeletedMVMTListVO(
			SearchDeletedMVMTListVO searchDeletedMVMTListVO) {
		this.searchDeletedMVMTListVO = searchDeletedMVMTListVO;
	}

	public SearchDeletedMVMTListVO[] getSearchDeletedMVMTListVOs() {
		SearchDeletedMVMTListVO[] tmpVOs = null;
		if (this.searchDeletedMVMTListVOs != null) {
			tmpVOs = new SearchDeletedMVMTListVO[searchDeletedMVMTListVOs.length];
			System.arraycopy(searchDeletedMVMTListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setSearchDeletedMVMTListVOs(
			SearchDeletedMVMTListVO[] searchDeletedMVMTListVOs) {
		if (searchDeletedMVMTListVOs != null) {
			SearchDeletedMVMTListVO[] tmpVOs = new SearchDeletedMVMTListVO[searchDeletedMVMTListVOs.length];
			System.arraycopy(searchDeletedMVMTListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchDeletedMVMTListVOs = tmpVOs;
		}
	}



}