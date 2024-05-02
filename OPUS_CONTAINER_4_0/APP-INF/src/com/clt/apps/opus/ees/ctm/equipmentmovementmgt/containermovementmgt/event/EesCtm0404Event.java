/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0404Event.java
*@FileTitle : Update of EDI Message (All MSG)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.06.09 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CTM_0404 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CTM_0404HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see EES_CTM_0404HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0404Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEDIMovementListVO searchEDIMovementListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchEDIMovementListVO[] searchEDIMovementListVOs = null;

	public EesCtm0404Event(){}

	public void setSearchEDIMovementListVO(SearchEDIMovementListVO searchEDIMovementListVO){
		this. searchEDIMovementListVO = searchEDIMovementListVO;
	}

	public void setSearchEDIMovementListVOS(SearchEDIMovementListVO[] searchEDIMovementListVOs){
		if (searchEDIMovementListVOs != null) {
			SearchEDIMovementListVO[] tmpVOs = new SearchEDIMovementListVO[searchEDIMovementListVOs.length];
			System.arraycopy(searchEDIMovementListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchEDIMovementListVOs = tmpVOs;
		}
	}

	public SearchEDIMovementListVO getSearchEDIMovementListVO(){
		return searchEDIMovementListVO;
	}

	public SearchEDIMovementListVO[] getSearchEDIMovementListVOS(){
		SearchEDIMovementListVO[] tmpVOs = null;
		if (this.searchEDIMovementListVOs != null) {
			tmpVOs = new SearchEDIMovementListVO[searchEDIMovementListVOs.length];
			System.arraycopy(searchEDIMovementListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}