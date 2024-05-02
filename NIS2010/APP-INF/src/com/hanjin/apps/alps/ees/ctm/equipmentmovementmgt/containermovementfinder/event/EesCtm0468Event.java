/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : EES_CTM_0466.jsp
 * @FileTitle : Terminal e-VGM Received Monitoring
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.07.15 김상현 1.0 Creation.
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchVermasListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_CTM_0466에 대한 PDTO(Data Transfer Object including Parameters)
 *  - EES_CTM_0466HTMLAction에서 작성
 *  - ServiceCommand Layer로 전달하는 PDTO로 사용
 *
 * @author 김상현
 * @see EES_CTM_0466HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCtm0468Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private SearchVermasListVO searchVermasListVO = null;

	/**
	 * @return the searchVermasListVO
	 */
	public SearchVermasListVO getSearchVermasListVO() {
		return searchVermasListVO;
	}

	/**
	 * @param searchVermasListVO the searchVermasListVO to set
	 */
	public void setSearchVermasListVO(SearchVermasListVO searchVermasListVO) {
		this.searchVermasListVO = searchVermasListVO;
	}
}
