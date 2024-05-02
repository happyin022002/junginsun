/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0417Event.java
*@FileTitle : EDI Error Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.08.28 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIErrorVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0417 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0417HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang Soo
 * @see EES_CTM_0417HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0417Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEDIErrorVO searchEDIErrorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEDIErrorVO[] searchEDIErrorVOs = null;

	public EesCtm0417Event(){}
	
	public void setSearchEDIErrorVO(SearchEDIErrorVO searchEDIErrorVO){
		this.searchEDIErrorVO = searchEDIErrorVO;
	}

	public void setSearchEDIErrorVOs(SearchEDIErrorVO[] searchEDIErrorVOs){
		if (searchEDIErrorVOs != null) {
			SearchEDIErrorVO[] tmpVOs = new SearchEDIErrorVO[searchEDIErrorVOs.length];
			System.arraycopy(searchEDIErrorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchEDIErrorVOs = tmpVOs;
		}
	}

	public SearchEDIErrorVO getSearchEDIErrorVO(){
		return searchEDIErrorVO;
	}

	public SearchEDIErrorVO[] getSearchEDIErrorVOS(){
		SearchEDIErrorVO[] tmpVOs = null;
		if (this.searchEDIErrorVOs != null) {
			tmpVOs = new SearchEDIErrorVO[searchEDIErrorVOs.length];
			System.arraycopy(searchEDIErrorVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}