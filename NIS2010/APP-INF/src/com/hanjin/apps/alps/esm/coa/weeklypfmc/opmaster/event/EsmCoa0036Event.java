/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0036Event.java
*@FileTitle : EsmCoa0036Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.event;

import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo.EsmCoa0036ComboVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaLaneRgstVO;

/**
 * ESM_COA_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_BSA_0036HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0036Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	
	/** 단건처리 */
	private CoaLaneRgstVO coaLaneRgstVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaLaneRgstVO[] coaLaneRgstVOs = null;	
	
	/** combo 조건 단건처리 */
	private EsmCoa0036ComboVO comboVO = null;		



	/** Constructor */
	public EsmCoa0036Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0036Event";
	}
	
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}	
		
	/** ValueObject Setter */
	public void setCoaLaneRgstVO(CoaLaneRgstVO coaLaneRgstVO){
		this.coaLaneRgstVO = coaLaneRgstVO;
	}
	/** ValueObject Getter */
	public CoaLaneRgstVO getCoaLaneRgstVO(){
		return coaLaneRgstVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaLaneRgstVOs(CoaLaneRgstVO[] coaLaneRgstVOs){
		this.coaLaneRgstVOs = coaLaneRgstVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaLaneRgstVO[] getCoaLaneRgstVOs(){
		return coaLaneRgstVOs;
	}
	
	public void setComboVO(EsmCoa0036ComboVO comboVO){
		this.comboVO = comboVO;
	}
	public EsmCoa0036ComboVO getComboVO(){
		return comboVO;
	}			
			
}
