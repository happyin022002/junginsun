/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0069Event.java
 *@FileTitle : EsmPri0069Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.13
 *@LastModifier : 김대호
 *@LastVersion : 1.0
 * 2009.08.13 김대호
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListPagingVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * UI_PRI_0069 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0069HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Day-hoh Kim
 * @see ESM_PRI_0069HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0069Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ViewAllRatesListPagingVO viewAllRatesListPagingVO = null;
	private ViewAllRatesListVO viewAllRatesListVO = null;

	public EsmPri0069Event() {
	}

	public ViewAllRatesListPagingVO getViewAllRatesListPagingVO() {
		return viewAllRatesListPagingVO;
	}

	public ViewAllRatesListVO getViewAllRatesListVO() {
		return viewAllRatesListVO;
	}

	public void setViewAllRatesListPagingVO(ViewAllRatesListPagingVO viewAllRatesListPagingVO) {
		this.viewAllRatesListPagingVO = viewAllRatesListPagingVO;
	}

	public void setViewAllRatesListVO(ViewAllRatesListVO viewAllRatesListVO) {
		this.viewAllRatesListVO = viewAllRatesListVO;
	}

}