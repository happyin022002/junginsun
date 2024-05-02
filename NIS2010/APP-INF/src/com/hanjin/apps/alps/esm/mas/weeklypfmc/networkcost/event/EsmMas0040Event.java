/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0040Event.java
*@FileTitle : EsmMas0040Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
* 2011.07.07 이석준 [CHM-201111498-01] PSO와 연계하여 VVD,TERMINAL별로 TARIFF 직접 수정및 PSO I/F 추가
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffListMasVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasPortTrfVO;

/**
 * ESM_MAS_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0040HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0040Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	
	/** 단건처리 */
	private MasPortTrfVO masPortTrfVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasPortTrfVO[] masPortTrfVOs = null;	
    
	/** Multi Data 처리 */
	private SearchPortTariffListVO[] searchPortTariffListVOs = null;
	private SearchPortTariffListMasVO[] searchPortTariffListMasVOs = null;


	/** Constructor */
	public EsmMas0040Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0040Event";
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
	public void setMasPortTrfVO(MasPortTrfVO masPortTrfVO){
		this.masPortTrfVO = masPortTrfVO;
	}
	/** ValueObject Getter */
	public MasPortTrfVO getMasPortTrfVO(){
		return masPortTrfVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasPortTrfVOs(MasPortTrfVO[] masPortTrfVOs){
		this.masPortTrfVOs = masPortTrfVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasPortTrfVO[] getMasPortTrfVOs(){
		return masPortTrfVOs;
	}

	public SearchPortTariffListVO[] getSearchPortTariffListVOs() {
		return searchPortTariffListVOs;
	}

	public void setSearchPortTariffListVOs(
			SearchPortTariffListVO[] searchPortTariffListVOs) {
		this.searchPortTariffListVOs = searchPortTariffListVOs;
	}	

	public SearchPortTariffListMasVO[] getSearchPortTariffListMasVOs() {
		return searchPortTariffListMasVOs;
	}

	public void setSearchPortTariffListMasVOs(
			SearchPortTariffListMasVO[] searchPortTariffListMasVOs) {
		this.searchPortTariffListMasVOs = searchPortTariffListMasVOs;
	}	
	
	
			
}
