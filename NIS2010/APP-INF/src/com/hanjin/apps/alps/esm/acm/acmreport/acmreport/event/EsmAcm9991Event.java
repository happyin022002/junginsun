/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmAcm9991Event.java
*@FileTitle : Estimated Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.20
*@LastModifier : 박다은
*@LastVersion : 1.0
* 2013.05.20 박다은
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.event;

import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.EstimatedPerformanceVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_ACM_9991 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_9991HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author PARK, Da-Eun
 * @see ESM_ACM_9991HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm9991Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EstimatedPerformanceVO estimatedPerformanceVO = null;  

	/** Table Value Object Multi Data 처리 */
	private EstimatedPerformanceVO[] estimatedPerformanceVOs = null;

	public EsmAcm9991Event() {}

	public EstimatedPerformanceVO getEstimatedPerformanceVO() {
		return estimatedPerformanceVO;
	}

	public void setEstimatedPerformanceVO(EstimatedPerformanceVO estimatedPerformanceVO) {
		this.estimatedPerformanceVO = estimatedPerformanceVO;
	}

	public EstimatedPerformanceVO[] getEstimatedPerformanceVOs() {
		return estimatedPerformanceVOs;
	}

	public void setEstimatedPerformanceVOs(EstimatedPerformanceVO[] estimatedPerformanceVOs) {
		this.estimatedPerformanceVOs = estimatedPerformanceVOs;
	}

}