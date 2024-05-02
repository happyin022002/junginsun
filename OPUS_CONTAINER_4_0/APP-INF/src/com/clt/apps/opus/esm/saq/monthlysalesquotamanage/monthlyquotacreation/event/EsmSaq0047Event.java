/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0047Event.java
*@FileTitle : Model Execution
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김종호
*@LastVersion : 1.1
* 2006-12-22 byyoo
* 1.0 최초 생성
* 2009.08.24 김종호
* 1.1 Creation (new F/W 전환작업) 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaMdlExeVO;



/**
 * ESM_SAQ_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ho Kim
 * @see ESM_SAQ_0047HTMLAction 참조
 * @since J2EE 1.6
 */


public class EsmSaq0047Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null; //조회 조건용 SAQ 공용 VO 선언
	
	private SaqMonQtaMdlExeVO saqMonQtaMdlExeVO = null; //CUD용 결과 전달 VO 선언 

	public EsmSaq0047Event(){}
	
	// 조회조건,멀티결과용 VO의 게터와 세터 생성
	public SaqMonQtaMdlExeVO getSaqMonQtaMdlExeVO() {
		return saqMonQtaMdlExeVO;
	}

	public void setSaqMonQtaMdlExeVO(SaqMonQtaMdlExeVO saqMonQtaMdlExeVO) {
		this.saqMonQtaMdlExeVO = saqMonQtaMdlExeVO;
	}

	public QuotaConditionVO getQuotaConditionVO() {
		return quotaConditionVO;
	}

	public void setQuotaConditionVO(QuotaConditionVO quotaConditionVO) {
		this.quotaConditionVO = quotaConditionVO;
	}
	



}