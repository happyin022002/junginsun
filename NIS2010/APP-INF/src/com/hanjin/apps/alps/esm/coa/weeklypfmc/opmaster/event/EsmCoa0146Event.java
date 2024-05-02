/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0146Event.java
*@FileTitle : EsmCoa0146Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.event;

import com.hanjin.apps.alps.esm.coa.common.vo.CommonCoaRsVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaVslRgstVO;
import com.hanjin.syscommon.common.table.CoaVslSubTrdCapaVO;


/**
 * ESM_COA_0146 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0146HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0146HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0146Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;
	

	/** 단건처리 */
	private CommonCoaRsVO commonCoaRsVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CommonCoaRsVO[] commonCoaRsVOs = null;
	
	
	/** 단건처리 */
	private CoaVslSubTrdCapaVO coaVslSubTrdCapaVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs = null;	
	
	/** 단건처리 */
	private CoaVslRgstVO coaVslRgstVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaVslRgstVO[] coaVslRgstVOs = null;		
	

	/** Constructor */
	public EsmCoa0146Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0146Event";
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
	public void setCommonCoaRsVO(CommonCoaRsVO commonCoaRsVO){
		this.commonCoaRsVO = commonCoaRsVO;
	}
	/** ValueObject Getter */
	public CommonCoaRsVO getCommonCoaRsVO(){
		return commonCoaRsVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCommonCoaRsVOs(CommonCoaRsVO[] commonCoaRsVOs){
		this.commonCoaRsVOs = commonCoaRsVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CommonCoaRsVO[] getCommonCoaRsVOs(){
		return commonCoaRsVOs;
	}	
	

	
	/** ValueObject Setter */
	public void setCoaVslSubTrdCapaVO(CoaVslSubTrdCapaVO coaVslSubTrdCapaVO){
		this.coaVslSubTrdCapaVO = coaVslSubTrdCapaVO;
	}
	/** ValueObject Getter */
	public CoaVslSubTrdCapaVO getCoaVslSubTrdCapaVO(){
		return coaVslSubTrdCapaVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaVslSubTrdCapaVOs(CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs){
		this.coaVslSubTrdCapaVOs = coaVslSubTrdCapaVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaVslSubTrdCapaVO[] getCoaVslSubTrdCapaVOs(){
		return coaVslSubTrdCapaVOs;
	}	
	
	
	/** ValueObject Setter */
	public void setCoaVslRgstVO(CoaVslRgstVO coaVslRgstVO){
		this.coaVslRgstVO = coaVslRgstVO;
	}
	/** ValueObject Getter */
	public CoaVslRgstVO getCoaVslRgstVO(){
		return coaVslRgstVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaVslRgstVOs(CoaVslRgstVO[] coaVslRgstVOs){
		this.coaVslRgstVOs = coaVslRgstVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaVslRgstVO[] getCoaVslRgstVOs(){
		return coaVslRgstVOs;
	}		
			
}
