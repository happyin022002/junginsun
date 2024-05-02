/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0174Event.java
*@FileTitle : Average U/C(OP fixed/variable cost, SPC CHT Rev/Chraterage)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : Choi In Kyung
*@LastVersion : 1.0
* 2009.11.03 Choi In Kyung
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.vo.AverageRPBVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AverageUCVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0174 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0174HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi In Kyung
 * @see ESM_MAS_0174HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0174Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	/** 단건처리 */
	private AverageRPBVO averageRPBVO = null;	
	
	
	/** 단건처리 */
	private AverageUCVO averageUCVO = null;	
	
	/** Multi Data 처리 - Create/Update/Delete */
	private AverageUCVO[] averageUCVOs = null;
	

	/** Constructor */
	public EsmMas0174Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0174Event";
	}

	
	
	/**
	 * @return the averageRPBVO
	 */
	public AverageRPBVO getAverageRPBVO() {
		return averageRPBVO;
	}

	/**
	 * @param averageRPBVO the averageRPBVO to set
	 */
	public void setAverageRPBVO(AverageRPBVO averageRPBVO) {
		this.averageRPBVO = averageRPBVO;
	}

	/**
	 * @return the searchConditionVO
	 */
	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	/**
	 * @param searchConditionVO the searchConditionVO to set
	 */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

	/**
	 * @return the averageUCVO
	 */
	public AverageUCVO getAverageUCVO() {
		return averageUCVO;
	}

	/**
	 * @param averageUCVO the averageUCVO to set
	 */
	public void setAverageUCVO(AverageUCVO averageUCVO) {
		this.averageUCVO = averageUCVO;
	}

	/**
	 * @return the averageUCVOs
	 */
	public AverageUCVO[] getAverageUCVOs() {
		return averageUCVOs;
	}

	/**
	 * @param averageUCVOs the averageUCVOs to set
	 */
	public void setAverageUCVOs(AverageUCVO[] averageUCVOs) {
		this.averageUCVOs = averageUCVOs;
	}


}
