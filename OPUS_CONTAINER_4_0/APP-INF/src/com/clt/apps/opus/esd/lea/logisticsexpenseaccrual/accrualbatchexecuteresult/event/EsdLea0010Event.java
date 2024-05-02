/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0010Event.java
*@FileTitle : Cost Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.07.31 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;
 
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostCodeListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostTypeCodeComboListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchSubCostTypeCodeComboListVO;
import com.clt.framework.support.layer.event.EventSupport;

 
/**
 * ESD_LEA_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCostCodeListVO searchCostCodeListVO = null;
	
	
	//jsk:start
	private String sCostKind			= null;
	private String sMainCostTypeCode	= null;
	//jsk:end
	
	/** Table Value Object Multi Data 처리 */
	private SearchCostCodeListVO[] searchCostCodeListVOs = null;

	public EsdLea0010Event(){}
	
	public void setSearchCostCodeListVO(SearchCostCodeListVO searchCostCodeListVO){
		this. searchCostCodeListVO = searchCostCodeListVO;
	}

	public void setSearchCostCodeListVOS(SearchCostCodeListVO[] searchCostCodeListVOs){
		this. searchCostCodeListVOs = searchCostCodeListVOs;
	}

	public SearchCostCodeListVO getSearchCostCodeListVO(){
		return searchCostCodeListVO;
	}

	public SearchCostCodeListVO[] getSearchCostCodeListVOS(){
		return searchCostCodeListVOs;
	}
	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCostTypeCodeComboListVO searchCostTypeCodeComboListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCostTypeCodeComboListVO[] searchCostTypeCodeComboListVOs = null;
	
	public void setSearchCostTypeCodeComboListVO(SearchCostTypeCodeComboListVO searchCostTypeCodeComboListVO){
		this. searchCostTypeCodeComboListVO = searchCostTypeCodeComboListVO;
	}

	public void setSearchCostTypeCodeComboListVOS(SearchCostTypeCodeComboListVO[] searchCostTypeCodeComboListVOs){
		this. searchCostTypeCodeComboListVOs = searchCostTypeCodeComboListVOs;
	}

	public SearchCostTypeCodeComboListVO getSearchCostTypeCodeComboListVO(){
		return searchCostTypeCodeComboListVO;
	}

	public SearchCostTypeCodeComboListVO[] getSearchCostTypeCodeComboListVOS(){
		return searchCostTypeCodeComboListVOs;
	}
	
	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSubCostTypeCodeComboListVO searchSubCostTypeCodeComboListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSubCostTypeCodeComboListVO[] searchSubCostTypeCodeComboListVOs = null;
	
	public void setSearchSubCostTypeCodeComboListVO(SearchSubCostTypeCodeComboListVO searchSubCostTypeCodeComboListVO){
		this. searchSubCostTypeCodeComboListVO = searchSubCostTypeCodeComboListVO;
	}

	public void setSearchSubCostTypeCodeComboListVOS(SearchSubCostTypeCodeComboListVO[] searchSubCostTypeCodeComboListVOs){
		this. searchSubCostTypeCodeComboListVOs = searchSubCostTypeCodeComboListVOs;
	}

	public SearchSubCostTypeCodeComboListVO getSearchSubCostTypeCodeComboListVO(){
		return searchSubCostTypeCodeComboListVO;
	}

	public SearchSubCostTypeCodeComboListVO[] getSearchSubCostTypeCodeComboListVOS(){
		return searchSubCostTypeCodeComboListVOs;
	}
	
	
	public void setCostKind(String sCostKind){
		this.sCostKind	= sCostKind;
	}
	public void setMainCostTypeCode(String sMainCostTypeCode){
		this.sMainCostTypeCode	= sMainCostTypeCode;
	}	
	
	public String getCostKind(){
		return this.sCostKind;
	}
	public String getMainCostTypeCode(){
		return this.sMainCostTypeCode;
	}
	

}