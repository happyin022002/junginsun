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
* 2012.01.10 조병연[CHM-201215460-01]
* Title : [ALPS JOO] Estimate Performance Change Status I 신규개발 (2011년 12월 4차)
* 내용 :
* 매월 결산 후 "공동운항 선복 용/대선료 실적 현황" 보고 시, 전월 대상항차의 Estimate 변동 현황 분석을 위해 
* 첨부와 같이 신규개발을 요청 드립니다.
* (동일한 대상 기간의 추정실적 Data를 비교하여 변동 건을 포착/분석하는 기능)

* - 기대효과 1 : 기존의 Excel 수작업 업무를 시스템화함으로써 업무 편의성 및 효율성 제고
* - 기대효과 2 : Initial Estimate(ALPS BSA 모듈의 Data) 뿐 아니라 Adjusted Estimate
*   (ALPS JOO 모듈의 추정실적 생성 메뉴에서 User가 Manual로 조정한 Data)까지 자동으로 비교함으로써 변동 현황 
*   분석의 다각화 가능
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusVO;



/**
 * FNS_JOO_0088 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0088HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jo Byeang Yean
 * @see FNS_JOO_0088HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0088Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EstmPerformanceChangeStatusRsltVO estmPerformanceChangeStatusRsltVO = null;
	private EstmPerformanceChangeStatusRsltVO[] estmPerformanceChangeStatusRsltVOs = null;

	public FnsJoo0088Event(){}

    /**
     * @return the estmPerformanceChangeStatusVO
     */
	public EstmPerformanceChangeStatusVO getEstmPerformanceChangeStatusVO() {
		return estmPerformanceChangeStatusVO;
	}
	public void setEstmPerformanceChangeStatusVO(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) {
		this.estmPerformanceChangeStatusVO = estmPerformanceChangeStatusVO;
	}
	
	/**
     * @return the estmPerformanceChangeStatusRsltVO
     */
    public EstmPerformanceChangeStatusRsltVO getEstmPerformanceChangeStatusRsltVO() {
        return estmPerformanceChangeStatusRsltVO;
    }
	public void setEstmPerformanceChangeStatusRsltVO(EstmPerformanceChangeStatusRsltVO estmPerformanceChangeStatusRsltVO){
		this. estmPerformanceChangeStatusRsltVO = estmPerformanceChangeStatusRsltVO;
	}

    /**
     * @return the estmPerformanceChangeStatusRsltVOs
     */
    public EstmPerformanceChangeStatusRsltVO[] getEstmPerformanceChangeStatusRsltVOs() {
        EstmPerformanceChangeStatusRsltVO[] rtnVOs = null;
		if (this.estmPerformanceChangeStatusRsltVOs != null) {
			rtnVOs = new EstmPerformanceChangeStatusRsltVO[estmPerformanceChangeStatusRsltVOs.length];
			System.arraycopy(estmPerformanceChangeStatusRsltVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;        
    }
	public void setEstmPerformanceChangeStatusRsltVOs(EstmPerformanceChangeStatusRsltVO[] estmPerformanceChangeStatusRsltVOs){
		if (estmPerformanceChangeStatusRsltVOs != null) {
			EstmPerformanceChangeStatusRsltVO[] tmpVOs = new EstmPerformanceChangeStatusRsltVO[estmPerformanceChangeStatusRsltVOs.length];
			System.arraycopy(estmPerformanceChangeStatusRsltVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.estmPerformanceChangeStatusRsltVOs = tmpVOs;
		}		
	}

}