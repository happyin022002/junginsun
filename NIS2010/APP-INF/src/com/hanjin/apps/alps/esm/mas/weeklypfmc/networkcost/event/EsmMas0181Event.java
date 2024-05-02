/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0181Event.java
*@FileTitle : EsmMas0181Event
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.06
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2011.07.06 이석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0181 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0181HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE SUK JOON
 * @see ESM_MAS_0181HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0181Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	
	
	/** 단건처리 */
	private SearchPortTariffDetailListVO searchPortTariffDetailListVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs = null;	
	/** Constructor */
	public EsmMas0181Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0181Event";
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

	public SearchPortTariffDetailListVO getSearchPortTariffDetailListVO() {
		return searchPortTariffDetailListVO;
	}

	public void setSearchPortTariffDetailListVO(
			SearchPortTariffDetailListVO searchPortTariffDetailListVO) {
		this.searchPortTariffDetailListVO = searchPortTariffDetailListVO;
	}

	public SearchPortTariffDetailListVO[] getSearchPortTariffDetailListVOs() {
		return searchPortTariffDetailListVOs;
	}

	public void setSearchPortTariffDetailListVOs(
			SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs) {
		this.searchPortTariffDetailListVOs = searchPortTariffDetailListVOs;
	}
		
			
}
