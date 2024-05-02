/*=========================================================
**Copyright(c) 2015 CyberLogitec
*@FileName : EsmCoa4007Event.java
*@FileTitle : (CMTX)Route Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.event;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_COA_4007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_4007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_COA_4007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa4007Event extends EventSupport { 
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	/** 단건처리 */
	private CommonCoaRsVO commonCoaRsVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CommonCoaRsVO[] commonCoaRsVOs = null;	
	
	/** String */
	private String fEqTpCd = null;
	
	/** Constructor */
	public EsmCoa4007Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa4007Event"; 
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
	
	/** ValueObject Array Setter - Create/Update/Delete */	//SJH.20150507.소스품질
	public void setCommonCoaRsVOs(CommonCoaRsVO[] commonCoaRsVOs){
		if(commonCoaRsVOs != null){
			CommonCoaRsVO[] tmpVOs = Arrays.copyOf(commonCoaRsVOs, commonCoaRsVOs.length);
			this.commonCoaRsVOs = tmpVOs;
		}
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */	//SJH.20150507.소스품질
	public CommonCoaRsVO[] getCommonCoaRsVOs(){
		CommonCoaRsVO[] rtnVOs = null;
		if (this.commonCoaRsVOs != null) {
			rtnVOs = Arrays.copyOf(commonCoaRsVOs, commonCoaRsVOs.length);
		}
		return rtnVOs;
	}	
	
	/** Setter */
	public void setFEqTpCd(String fEqTpCd){
		this.fEqTpCd = fEqTpCd;
	}
	
	/** Getter */
	public String getFEqTpCd(){
		return fEqTpCd;
	}
}