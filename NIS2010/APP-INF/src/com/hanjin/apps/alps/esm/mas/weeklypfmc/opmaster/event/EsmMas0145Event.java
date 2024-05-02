/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0145Event.java
*@FileTitle : EsmMas0145Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasLaneTpHisVO;

/**
 * ESM_MAS_0145 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0145HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0145HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0145Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	


	
	/** 단건처리 */
	private MasLaneTpHisVO masLaneTpHisVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasLaneTpHisVO[] masLaneTpHisVOs = null;	
	

	/** Constructor */
	public EsmMas0145Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0145Event";
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
	public void setMasLaneTpHisVO(MasLaneTpHisVO masLaneTpHisVO){
		this.masLaneTpHisVO = masLaneTpHisVO;
	}
	/** ValueObject Getter */
	public MasLaneTpHisVO getMasLaneTpHisVO(){
		return masLaneTpHisVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasLaneTpHisVOs(MasLaneTpHisVO[] masLaneTpHisVOs){
		this.masLaneTpHisVOs = masLaneTpHisVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasLaneTpHisVO[] getMasLaneTpHisVOs(){
		return masLaneTpHisVOs;
	}			
}
