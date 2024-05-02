/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0185Event.java
*@FileTitle : EsmMas0185Event
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : SJ KIM
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffWeekListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;

/**
 * ESM_MAS_0185 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0185HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SJ KIM
 * @see ESM_MAS_0185HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0185Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	
	
	/** 단건처리 */
	private SearchPortTariffDetailListVO searchPortTariffDetailListVO = null;
	private SearchPortTariffWeekListVO searchPortTariffWeekListVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs = null;
	private SearchPortTariffWeekListVO[] searchPortTariffWeekListVOs = null;
	
	/** Constructor */
	public EsmMas0185Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0185Event";
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

	/**
	 * @return the searchPortTariffWeekListVO
	 */
	public SearchPortTariffWeekListVO getSearchPortTariffWeekListVO() {
		return searchPortTariffWeekListVO;
	}

	/**
	 * @param searchPortTariffWeekListVO the searchPortTariffWeekListVO to set
	 */
	public void setSearchPortTariffWeekListVO(
			SearchPortTariffWeekListVO searchPortTariffWeekListVO) {
		this.searchPortTariffWeekListVO = searchPortTariffWeekListVO;
	}

	/**
	 * @return the searchPortTariffWeekListVOs
	 */
	public SearchPortTariffWeekListVO[] getSearchPortTariffWeekListVOs() {
		return searchPortTariffWeekListVOs;
	}

	/**
	 * @param searchPortTariffWeekListVOs the searchPortTariffWeekListVOs to set
	 */
	public void setSearchPortTariffWeekListVOs(
			SearchPortTariffWeekListVO[] searchPortTariffWeekListVOs) {
		this.searchPortTariffWeekListVOs = searchPortTariffWeekListVOs;
	}

	/**
	 * @return the comBakEndJbVO
	 */
	public ComBakEndJbVO getComBakEndJbVO() {
		return comBakEndJbVO;
	}

	/**
	 * @param comBakEndJbVO the comBakEndJbVO to set
	 */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO) {
		this.comBakEndJbVO = comBakEndJbVO;
	}
		
	
			
}
