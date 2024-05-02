/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : EesCtm0443Event.java
 * @FileTitle : Cargo Location message
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2016.03.18
 * @LastModifier : 홍성필
 * @LastVersion : 1.0
 * 2016.03.18 홍성필 1.0 Creation
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementHistoryMonitorListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_CTM_0436 에 대한 PDTO(Data Transfer Object including Parameters)
 * - EES_CTM_0436HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 *
 * @author Hong Seong Pill
 * @see EES_CTM_0436HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0436Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public SearchMovementHistoryMonitorListVO[] searchMovementHistoryMonitorListVOs = null;
	
	public EesCtm0436Event(){}

	public SearchMovementHistoryMonitorListVO getSearchMovementHistoryMonitorListVO() {
		return searchMovementHistoryMonitorListVO;
	}

	public void setSearchMovementHistoryMonitorListVO(
			SearchMovementHistoryMonitorListVO searchMovementHistoryMonitorListVO) {
		this.searchMovementHistoryMonitorListVO = searchMovementHistoryMonitorListVO;
	}

	public SearchMovementHistoryMonitorListVO[] getSearchMovementHistoryMonitorListVOs() {
		return searchMovementHistoryMonitorListVOs;
	}

	public void setSearchMovementHistoryMonitorListVOs(
			SearchMovementHistoryMonitorListVO[] searchMovementHistoryMonitorListVOs) {
		this.searchMovementHistoryMonitorListVOs = searchMovementHistoryMonitorListVOs;
	}
		
}
