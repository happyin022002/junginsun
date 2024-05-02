/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0088Event.java
*@FileTitle : Estimate Performance Change Status I
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.10
*@LastModifier : 조병연
*@LastVersion : 1.0
* 2012.01.10 조병연
* 1.0 Creation
* -------------------------------------------------------
* 2012.02.10 조병연[CHM-201215990-01]
* Title : [ALPS JOO] Estimate Performance Change Status II 신규개발 (2012년 1월 2차) 
* 내용 :
* - ALPS JOO 전월 대상항차 Estimate 변동 현황 분석기능 개발 
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIVO;



/**
 * FNS_JOO_0089 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0089HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jo Byeang Yean
 * @see FNS_JOO_0089HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0089Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EstmPerformanceChangeStatusIIRsltVO estmPerformanceChangeStatusIIRsltVO = null;
	private EstmPerformanceChangeStatusIIRsltVO[] estmPerformanceChangeStatusIIRsltVOs = null;

	public FnsJoo0089Event(){}

    /**
     * @return the estmPerformanceChangeStatusIIVO
     */
	public EstmPerformanceChangeStatusIIVO getEstmPerformanceChangeStatusIIVO() {
		return estmPerformanceChangeStatusIIVO;
	}
	public void setEstmPerformanceChangeStatusIIVO(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) {
		this.estmPerformanceChangeStatusIIVO = estmPerformanceChangeStatusIIVO;
	}
	
	/**
     * @return the estmPerformanceChangeStatusIIRsltVO
     */
    public EstmPerformanceChangeStatusIIRsltVO getEstmPerformanceChangeStatusIIRsltVO() {
        return estmPerformanceChangeStatusIIRsltVO;
    }
	public void setEstmPerformanceChangeStatusIIRsltVO(EstmPerformanceChangeStatusIIRsltVO estmPerformanceChangeStatusIIRsltVO){
		this. estmPerformanceChangeStatusIIRsltVO = estmPerformanceChangeStatusIIRsltVO;
	}

    /**
     * @return the estmPerformanceChangeStatusIIRsltVOs
     */
    public EstmPerformanceChangeStatusIIRsltVO[] getEstmPerformanceChangeStatusIIRsltVOs() {
        EstmPerformanceChangeStatusIIRsltVO[] rtnVOs = null;
		if (this.estmPerformanceChangeStatusIIRsltVOs != null) {
			rtnVOs = new EstmPerformanceChangeStatusIIRsltVO[estmPerformanceChangeStatusIIRsltVOs.length];
			System.arraycopy(estmPerformanceChangeStatusIIRsltVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;        
    }
	public void setEstmPerformanceChangeStatusIIRsltVOs(EstmPerformanceChangeStatusIIRsltVO[] estmPerformanceChangeStatusIIRsltVOs){
		if (estmPerformanceChangeStatusIIRsltVOs != null) {
			EstmPerformanceChangeStatusIIRsltVO[] tmpVOs = new EstmPerformanceChangeStatusIIRsltVO[estmPerformanceChangeStatusIIRsltVOs.length];
			System.arraycopy(estmPerformanceChangeStatusIIRsltVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.estmPerformanceChangeStatusIIRsltVOs = tmpVOs;
		}		
	}
}