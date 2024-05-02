/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0029Event.java
*@FileTitle : EsmCoa0029Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
*=========================================================
* History 
* 2011.06.02 최성민 [CHM-201111115-01] Split 02-Split 03-ALPS Error 처리 요청  - ComBakEndJbVO 추가
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.MultiCoaMonVvdVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaMonVvdVO;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;

/**
 * ESM_COA_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0029HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0029Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private WeeklyCMCommonVO mWeeklyCMCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private WeeklyCMCommonVO[] mWeeklyCMCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	
	
	/** 단건처리 */
	private CoaMonVvdVO mCoaMonVvdVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaMonVvdVO[] mCoaMonVvdVOs = null;	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	

	/** Multi Data 처리 - Create/Update/Delete */
	private MultiCoaMonVvdVO[] multiCoaMonVvdVOs = null;	

	

	/** Constructor */
	public EsmCoa0029Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0029Event";
	}

	/** ValueObject Setter */
	public void setWeeklyCMCommonVO(WeeklyCMCommonVO weeklyCMCommonVO){
		this.mWeeklyCMCommonVO = weeklyCMCommonVO;
	}
	/** ValueObject Getter */
	public WeeklyCMCommonVO getWeeklyCMCommonVO(){
		return mWeeklyCMCommonVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setWeeklyCMCommonVOs(WeeklyCMCommonVO[] weeklyCMCommonVOs){
		mWeeklyCMCommonVOs = weeklyCMCommonVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public WeeklyCMCommonVO[] getWeeklyCMCommonVOs(){
		return mWeeklyCMCommonVOs;
	}	

	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}		
	
	
	/** ValueObject Setter */
	public void setCoaMonVvdVO(CoaMonVvdVO coaMonVvdVO){
		this.mCoaMonVvdVO = coaMonVvdVO;
	}
	/** ValueObject Getter */
	public CoaMonVvdVO getCoaMonVvdVO(){
		return mCoaMonVvdVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaMonVvdVOs(CoaMonVvdVO[] coaMonVvdVOs){
		mCoaMonVvdVOs = coaMonVvdVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaMonVvdVO[] getCoaMonVvdVOs(){
		return mCoaMonVvdVOs;
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

	/**
	 * @return the multiCoaMonVvdVOs
	 */
	public MultiCoaMonVvdVO[] getMultiCoaMonVvdVOs() {
		return multiCoaMonVvdVOs;
	}

	/**
	 * @param multiCoaMonVvdVOs the multiCoaMonVvdVOs to set
	 */
	public void setMultiCoaMonVvdVOs(MultiCoaMonVvdVO[] multiCoaMonVvdVOs) {
		this.multiCoaMonVvdVOs = multiCoaMonVvdVOs;
	}	
		
	
	
}
