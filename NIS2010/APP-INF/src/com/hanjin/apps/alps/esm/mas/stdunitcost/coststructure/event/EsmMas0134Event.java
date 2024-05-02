/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0134HTMLAction.java
*@FileTitle : Revenue Exception Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-04
*@LastModifier : Je Ryang Yoo
*@LastVersion : 
*  2015-02-04 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.RevExpChargeVO;

/**
 * ESM_MAS_0134 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0134HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author OK-YOUNG IM
 * @see ESM_MAS_0134HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0134Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private RevExpChargeVO revExpChargeVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private RevExpChargeVO[] revExpChargeVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	/** Constructor */
	public EsmMas0134Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0134Event";
	}

	public RevExpChargeVO getRevExpChargeVO() {
		return revExpChargeVO;
	}

	public void setRevExpChargeVO(RevExpChargeVO revExpChargeVO) {
		this.revExpChargeVO = revExpChargeVO;
	}

	
	public RevExpChargeVO[] getRevExpChargeVOs() {
		return revExpChargeVOs;
	}

	public void setRevExpChargeVOs(RevExpChargeVO[] revExpChargeVOs) {
		this.revExpChargeVOs = revExpChargeVOs;
	}
		
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}
		
}