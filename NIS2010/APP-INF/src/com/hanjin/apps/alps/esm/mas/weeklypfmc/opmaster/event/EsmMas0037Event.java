/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0037Event.java
*@FileTitle : EsmMas0037Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.event;

import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.event.ESM_MAS_0037HTMLAction;
import com.hanjin.apps.alps.esm.mas.common.vo.CommonMasRsVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.syscommon.common.table.MasVslRgstVO;
import com.hanjin.syscommon.common.table.MasVslSubTrdCapaVO;

/**
 * ESM_MAS_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0037HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0037Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	/** 단건처리 */
	private CommonMasRsVO commonMasRsVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CommonMasRsVO[] commonMasRsVOs = null;

	
	/** 단건처리 */
	private MasVslRgstVO masVslRgstVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasVslRgstVO[] masVslRgstVOs = null;
	

	/** 단건처리 */
	private MasVslSubTrdCapaVO masVslSubTrdCapaVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private MasVslSubTrdCapaVO[] masVslSubTrdCapaVOs = null;	


	/** Constructor */
	public EsmMas0037Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0037Event";
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
	public void setCommonMasRsVO(CommonMasRsVO commonMasRsVO){
		this.commonMasRsVO = commonMasRsVO;
	}
	/** ValueObject Getter */
	public CommonMasRsVO getCommonMasRsVO(){
		return commonMasRsVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCommonMasRsVOs(CommonMasRsVO[] commonMasRsVOs){
		this.commonMasRsVOs = commonMasRsVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CommonMasRsVO[] getCommonMasRsVOs(){
		return commonMasRsVOs;
	}	
	
	
	
	/** ValueObject Setter */
	public void setMasVslRgstVO(MasVslRgstVO masVslRgstVO){
		this.masVslRgstVO = masVslRgstVO;
	}
	/** ValueObject Getter */
	public MasVslRgstVO getMasVslRgstVO(){
		return masVslRgstVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasVslRgstVOs(MasVslRgstVO[] masVslRgstVOs){
		this.masVslRgstVOs = masVslRgstVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasVslRgstVO[] getMasVslRgstVOs(){
		return masVslRgstVOs;
	}	
	
	
	/** ValueObject Setter */
	public void setMasVslSubTrdCapaVO(MasVslSubTrdCapaVO masVslSubTrdCapaVO){
		this.masVslSubTrdCapaVO = masVslSubTrdCapaVO;
	}
	/** ValueObject Getter */
	public MasVslSubTrdCapaVO getMasVslSubTrdCapaVO(){
		return masVslSubTrdCapaVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasVslSubTrdCapaVOs(MasVslSubTrdCapaVO[] masVslSubTrdCapaVOs){
		this.masVslSubTrdCapaVOs = masVslSubTrdCapaVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasVslSubTrdCapaVO[] getMasVslSubTrdCapaVOs(){
		return masVslSubTrdCapaVOs;
	}		
			
}
