/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0094Event.java
*@FileTitle : Multi Prepayments Settlement
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.08
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.08 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0094 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0094HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son, Jin Hwan
 * @see ESM_FMS_0094HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0094Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchPrepaymentSettleListVO condSearchPrepaymentSettleListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchPrepaymentSettleListVO[] condSearchPrepaymentSettleListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchPrepaymentSettleVvdVO[] condSearchPrepaymentSettleVvdVOs = null;
	
	/** Approval Step */
	private String aproStep = "";
	
	/** CSR Date */
	private String slpIssDt = "";
	
	/** Effective Date */
	private String effDt = "";
	
	public EsmFms0094Event(){}
	
	public void setCondSearchPrepaymentSettleListVO(CondSearchPrepaymentSettleListVO condSearchPrepaymentSettleListVO){
		this. condSearchPrepaymentSettleListVO = condSearchPrepaymentSettleListVO;
	}

	public void setCondSearchPrepaymentSettleListVOS(CondSearchPrepaymentSettleListVO[] condSearchPrepaymentSettleListVOs){
		if (condSearchPrepaymentSettleListVOs != null) {
			CondSearchPrepaymentSettleListVO[] tmpVOs = Arrays.copyOf(condSearchPrepaymentSettleListVOs, condSearchPrepaymentSettleListVOs.length);
			this.condSearchPrepaymentSettleListVOs = tmpVOs;
		}
	}

	public void setCondSearchPrepaymentSettleVvdVO(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO){
		this. condSearchPrepaymentSettleVvdVO = condSearchPrepaymentSettleVvdVO;
	}

	public void setCondSearchPrepaymentSettleVvdVOS(CondSearchPrepaymentSettleVvdVO[] condSearchPrepaymentSettleVvdVOs){
		if (condSearchPrepaymentSettleVvdVOs != null) {
			CondSearchPrepaymentSettleVvdVO[] tmpVOs = Arrays.copyOf(condSearchPrepaymentSettleVvdVOs, condSearchPrepaymentSettleVvdVOs.length);
			this.condSearchPrepaymentSettleVvdVOs = tmpVOs;
		}
	}

	public CondSearchPrepaymentSettleListVO getCondSearchPrepaymentSettleListVO(){
		return condSearchPrepaymentSettleListVO;
	}

	public CondSearchPrepaymentSettleListVO[] getCondSearchPrepaymentSettleListVOS(){
		CondSearchPrepaymentSettleListVO[] rtnVOs = null;
		if (this.condSearchPrepaymentSettleListVOs != null) {
			rtnVOs = Arrays.copyOf(condSearchPrepaymentSettleListVOs, condSearchPrepaymentSettleListVOs.length);
		}
		return rtnVOs;
	}

	public CondSearchPrepaymentSettleVvdVO getCondSearchPrepaymentSettleVvdVO(){
		return condSearchPrepaymentSettleVvdVO;
	}

	public CondSearchPrepaymentSettleVvdVO[] getCondSearchPrepaymentSettleVvdVOS(){
		CondSearchPrepaymentSettleVvdVO[] rtnVOs = null;
		if (this.condSearchPrepaymentSettleVvdVOs != null) {
			rtnVOs = Arrays.copyOf(condSearchPrepaymentSettleVvdVOs, condSearchPrepaymentSettleVvdVOs.length);
		}
		return rtnVOs;
	}

	public String getAproStep() {
		return aproStep;
	}

	public void setAproStep(String aproStep) {
		this.aproStep = aproStep;
	}

	public String getSlpIssDt() {
		return slpIssDt;
	}

	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
	}

	public String getEffDt() {
		return effDt;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

}