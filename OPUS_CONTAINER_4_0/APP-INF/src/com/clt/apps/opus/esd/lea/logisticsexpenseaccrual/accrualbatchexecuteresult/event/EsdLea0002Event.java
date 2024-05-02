/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdLea0002Event.java
*@FileTitle : Accrual Batch Result by Account Code (Tab1)
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-13
*@LastModifier : Park Yeon Jin
*@LastVersion : 1.0
* 2007-02-13 Park Yeon Jin
* 1.0 최초 생성   
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultAccountListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultManualInputListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
  
   
/**
 * ESD_LEA_002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_LEA_002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Yeon Jin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdLea0002Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String frmExeYrmon		= null;		
	private String frmRevYrmonFrom	= null;	
	private String frmRevYrmonTo	= null;
	private String fAcctTypeA		= null;		
	private String fAcctTypeM		= null;		
	private String fAcctTypeT		= null;		
	
	
	private String frmMailDiv = null;
	private String frmConfirmDiv = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualBatchResultAccountListVO 		searchAccrualBatchResultAccountListVO 		= null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualBatchResultAccountListVO[] 	searchAccrualBatchResultAccountListVOs 		= null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualBatchResultManualInputListVO 	searchAccrualBatchResultManualInputListVO 	= null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualBatchResultManualInputListVO[]	searchAccrualBatchResultManualInputListVOs 	= null;

	public void setSearchAccrualBatchResultAccountListVO(SearchAccrualBatchResultAccountListVO searchAccrualBatchResultAccountListVO){
		this.searchAccrualBatchResultAccountListVO = searchAccrualBatchResultAccountListVO;
	}

	public void setSearchAccrualBatchResultAccountListVOs(SearchAccrualBatchResultAccountListVO[] searchAccrualBatchResultAccountListVOs){
		this.searchAccrualBatchResultAccountListVOs = searchAccrualBatchResultAccountListVOs;
	}

	public SearchAccrualBatchResultAccountListVO getSearchAccrualBatchResultAccountListVO(){
		return searchAccrualBatchResultAccountListVO;
	}

	public SearchAccrualBatchResultAccountListVO[] getSearchAccrualBatchResultAccountListVOs(){
		return searchAccrualBatchResultAccountListVOs;
	}

	public void setSearchAccrualBatchResultManualInputListVO(SearchAccrualBatchResultManualInputListVO searchAccrualBatchResultManualInputListVO){
		this.searchAccrualBatchResultManualInputListVO = searchAccrualBatchResultManualInputListVO;
	}

	public void setSearchAccrualBatchResultManualInputListVOs(SearchAccrualBatchResultManualInputListVO[] searchAccrualBatchResultManualInputListVOs){
		this.searchAccrualBatchResultManualInputListVOs = searchAccrualBatchResultManualInputListVOs;
	}

	public SearchAccrualBatchResultManualInputListVO getSearchAccrualBatchResultManualInputListVO(){
		return searchAccrualBatchResultManualInputListVO;
	}

	public SearchAccrualBatchResultManualInputListVO[] getSearchAccrualBatchResultManualInputListVOs(){
		return searchAccrualBatchResultManualInputListVOs;
	}
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchParameterAccrualEmailSettingVO[] searchParameterAccrualEmailSettingVOs = null;
	public EsdLea0002Event(){}

	////jsk:
	public void setFrmExeYrmon(String frmExeYrmon){
		this.frmExeYrmon	= frmExeYrmon;
	}
	public void setFrmRevYrmonFrom(String frmRevYrmonFrom){
		this.frmRevYrmonFrom	= frmRevYrmonFrom;
	}
	public void setFrmRevYrmonTo(String frmRevYrmonTo){
		this.frmRevYrmonTo	= frmRevYrmonTo;
	}
	public void setFAcctTypeA(String fAcctTypeA){
		this.fAcctTypeA	= fAcctTypeA;
	}
	public void setFAcctTypeM(String fAcctTypeM){
		this.fAcctTypeM	= fAcctTypeM;
	}
	public void setFAcctTypeT(String fAcctTypeT){
		this.fAcctTypeT	= fAcctTypeT;
	}
	
	
	public void setFrmMailDiv(String frmMailDiv){
		this.frmMailDiv	= frmMailDiv;
	}
	
	public void setFrmConfirmDiv(String frmConfirmDiv){
		this.frmConfirmDiv	= frmConfirmDiv;
	}
	
	public String getFrmExeYrmon(){
		return this.frmExeYrmon;
	}
	public String getFrmRevYrmonFrom(){
		return this.frmRevYrmonFrom;
	}
	public String getFrmRevYrmonTo(){
		return this.frmRevYrmonTo;
	}
	public String getFAcctTypeA(){
		return this.fAcctTypeA;
	}
	public String getFAcctTypeM(){
		return this.fAcctTypeM;
	}
	public String getFAcctTypeT(){
		return this.fAcctTypeT;
	}
	
	
	public String getFrmMailDiv(){
		return this.frmMailDiv;
	}
	
	public String getFrmConfirmDiv(){
		return this.frmConfirmDiv;
	}

	public SearchParameterAccrualEmailSettingVO getSearchParameterAccrualEmailSettingVO(){
		return searchParameterAccrualEmailSettingVO;
	}

	public SearchParameterAccrualEmailSettingVO[] getSearchParameterAccrualEmailSettingVOS(){
		return searchParameterAccrualEmailSettingVOs;
	}
	
}
