/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0025Event.java
*@FileTitle : Immediate Exit Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.10 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.event;

import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo.SearchParamVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ImmediateExitCreationVO[] immediateExitCreationVOs = null;

	public EesLse0025Event(){}
	
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setImmediateExitCreationVOs(ImmediateExitCreationVO[] immediateExitCreationVOs){
		if (immediateExitCreationVOs != null) {
			ImmediateExitCreationVO[] tmpVOs = new ImmediateExitCreationVO[immediateExitCreationVOs.length];
			System.arraycopy(immediateExitCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.immediateExitCreationVOs = tmpVOs;
		}
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public ImmediateExitCreationVO[] getImmediateExitCreationVOs(){
		ImmediateExitCreationVO[] tmpVOs = null;
		if (this.immediateExitCreationVOs != null) {
			tmpVOs = new ImmediateExitCreationVO[immediateExitCreationVOs.length];
			System.arraycopy(immediateExitCreationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}