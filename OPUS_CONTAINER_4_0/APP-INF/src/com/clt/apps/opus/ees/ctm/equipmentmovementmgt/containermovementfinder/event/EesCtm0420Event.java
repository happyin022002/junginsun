/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0420Event.java
*@FileTitle : EDI Error Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.09.03 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIResultVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0420 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0420HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang Soo
 * @see EES_CTM_0420HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0420Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEDIResultVO searchEDIResultVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchEDIResultVO[] searchEDIResultVOs = null;

	public EesCtm0420Event(){}

	public void setSearchEDIResultVO(SearchEDIResultVO searchEDIResultVO){
		this.searchEDIResultVO = searchEDIResultVO;
	}

	public void setSearchEDIResultVOs(SearchEDIResultVO[] searchEDIResultVOs){
		if (searchEDIResultVOs != null) {
			SearchEDIResultVO[] tmpVOs = new SearchEDIResultVO[searchEDIResultVOs.length];
			System.arraycopy(searchEDIResultVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchEDIResultVOs = tmpVOs;
		}
	}

	public SearchEDIResultVO getSearchEDIResultVO(){
		return searchEDIResultVO;
	}

	public SearchEDIResultVO[] getSearchEDIResultVOS(){
		SearchEDIResultVO[] tmpVOs = null;
		if (this.searchEDIResultVOs != null) {
			tmpVOs = new SearchEDIResultVO[searchEDIResultVOs.length];
			System.arraycopy(searchEDIResultVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}