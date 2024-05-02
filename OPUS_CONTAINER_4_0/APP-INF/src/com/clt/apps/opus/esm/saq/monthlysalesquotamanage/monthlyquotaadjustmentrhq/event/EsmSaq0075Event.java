/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0075Event.java
*@FileTitle : Regional Group Vs Regional Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2007-03-05 byyoo
* 1.0 Creation
* 2008.1.25 : 조회조건 추가 관련 search_sub_trd_cd 추가. Y.S.CHOI
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaRhqVO;


/**
 * ESM_SAQ_0075 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0075HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi.M.C
 * @see ESM_SAQ_0075HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0075Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO conditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonQtaRhqVO saqMonQtaRhqVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonQtaRhqVO[] saqMonQtaRhqVOs = null;

	public EsmSaq0075Event(){}
	
	public void setCondition(QuotaConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public QuotaConditionVO getCondition(){
		return conditionVO;
	}

	public SaqMonQtaRhqVO getSaqMonQtaRhqVO() {
		return saqMonQtaRhqVO;
	}

	public void setSaqMonQtaRhqVO(SaqMonQtaRhqVO saqMonQtaRhqVO) {
		this.saqMonQtaRhqVO = saqMonQtaRhqVO;
	}

	public SaqMonQtaRhqVO[] getSaqMonQtaRhqVOs() {
		SaqMonQtaRhqVO[] rtnVOs = null;
		if (this.saqMonQtaRhqVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonQtaRhqVOs, saqMonQtaRhqVOs.length);
		}
		return rtnVOs;
	}

	public void setSaqMonQtaRhqVOs(SaqMonQtaRhqVO[] saqMonQtaRhqVOs) {
		if(saqMonQtaRhqVOs != null){
			SaqMonQtaRhqVO[] tmpVOs = Arrays.copyOf(saqMonQtaRhqVOs, saqMonQtaRhqVOs.length);
			this.saqMonQtaRhqVOs  = tmpVOs;
		}
	}
}