/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0001Event.java
*@FileTitle : Expense Accrual Batch Main
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.10.05
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.10.05 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.event;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.vo.SearchAccrualBatchPreConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.GlAcclIfVO;
import com.clt.syscommon.common.table.LeaAcclCondItmVO;


/**
 * ESD_LEA_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Confirm Divistion Code */
    private String frmConfirmDiv = null;
    
    /** From Exe Yrmon */
    private String frmExeYrmon = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LeaAcclCondItmVO leaAcclCondItmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LeaAcclCondItmVO[] leaAcclCondItmVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualBatchPreConditionVO searchAccrualBatchPreConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualBatchPreConditionVO[] searchAccrualBatchPreConditionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private GlAcclIfVO glAcclIfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private GlAcclIfVO[] glAcclIfVOs = null;

	public EsdLea0001Event(){}

    public void setFrmConfirmDiv(String frmConfirmDiv) {
        this.frmConfirmDiv = frmConfirmDiv;
    }
    
    public void setFrmExeYrmon(String frmExeYrmon) {
        this.frmExeYrmon = frmExeYrmon;
    }
	
	public void setLeaAcclCondItmVO(LeaAcclCondItmVO leaAcclCondItmVO){
		this. leaAcclCondItmVO = leaAcclCondItmVO;
	}

	public void setLeaAcclCondItmVOS(LeaAcclCondItmVO[] leaAcclCondItmVOs){
		this. leaAcclCondItmVOs = leaAcclCondItmVOs;
	}

	public void setSearchAccrualBatchPreConditionVO(SearchAccrualBatchPreConditionVO searchAccrualBatchPreConditionVO){
		this. searchAccrualBatchPreConditionVO = searchAccrualBatchPreConditionVO;
	}

	public void setSearchAccrualBatchPreConditionVOS(SearchAccrualBatchPreConditionVO[] searchAccrualBatchPreConditionsVO){
		this. searchAccrualBatchPreConditionVOs = searchAccrualBatchPreConditionVOs;
	}

	public void setGlAcclIfVO(GlAcclIfVO glAcclIfVO){
		this. glAcclIfVO = glAcclIfVO;
	}

	public void setGlAcclIfVOS(GlAcclIfVO[] glAcclIfVOs){
		this. glAcclIfVOs = glAcclIfVOs;
	}

	public String getFrmConfirmDiv() {
	    return frmConfirmDiv;
	}
	
	public String getFrmExeYrmon() {
	    return frmExeYrmon;
	}
	
	public LeaAcclCondItmVO getLeaAcclCondItmVO(){
		return leaAcclCondItmVO;
	}

	public LeaAcclCondItmVO[] getLeaAcclCondItmVOS(){
		return leaAcclCondItmVOs;
	}

	public SearchAccrualBatchPreConditionVO getSearchAccrualBatchPreConditionVO(){
		return searchAccrualBatchPreConditionVO;
	}

	public SearchAccrualBatchPreConditionVO[] getSearchAccrualBatchPreConditionVOS(){
		return searchAccrualBatchPreConditionVOs;
	}

	public GlAcclIfVO getGlAcclIfVO(){
		return glAcclIfVO;
	}

	public GlAcclIfVO[] getGlAcclIfVOS(){
		return glAcclIfVOs;
	}

}