/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0036Event.java
*@FileTitle : EsmMas0036Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.event;

import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.EsmMas0036ComboVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasLaneRgstVO;

/**
 * ESM_MAS_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_BSA_0036HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0036Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	
	/** 단건처리 */
	private MasLaneRgstVO masLaneRgstVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasLaneRgstVO[] masLaneRgstVOs = null;	
	
	/** combo 조건 단건처리 */
	private EsmMas0036ComboVO comboVO = null;		



	/** Constructor */
	public EsmMas0036Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0036Event";
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
	public void setMasLaneRgstVO(MasLaneRgstVO masLaneRgstVO){
		this.masLaneRgstVO = masLaneRgstVO;
	}
	/** ValueObject Getter */
	public MasLaneRgstVO getMasLaneRgstVO(){
		return masLaneRgstVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasLaneRgstVOs(MasLaneRgstVO[] masLaneRgstVOs){
		this.masLaneRgstVOs = masLaneRgstVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasLaneRgstVO[] getMasLaneRgstVOs(){
		return masLaneRgstVOs;
	}
	
	public void setComboVO(EsmMas0036ComboVO comboVO){
		this.comboVO = comboVO;
	}
	public EsmMas0036ComboVO getComboVO(){
		return comboVO;
	}			
			
}
