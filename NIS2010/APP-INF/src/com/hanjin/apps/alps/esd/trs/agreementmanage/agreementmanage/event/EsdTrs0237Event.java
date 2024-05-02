/*=========================================================
 *@FileName : EsdTrs0237Event.java
 *@FileTitle :  Agreement Confirm 권한 등록
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-05-27
 *@LastModifier : 최종혁
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchApprovalMgmtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

public class EsdTrs0237Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private SearchApprovalMgmtVO searchApprovalMgmtVO = null;
	private SearchApprovalMgmtVO[] searchApprovalMgmtVOs = null;
	String FmCfmUsrId  = null;
	String cfmUsrId  = null;

	public SearchApprovalMgmtVO getSearchApprovalMgmtVO() {
		return searchApprovalMgmtVO;
	}
	public void setSearchApprovalMgmtVO(SearchApprovalMgmtVO searchApprovalMgmtVO) {
		this.searchApprovalMgmtVO = searchApprovalMgmtVO;
	}
	public SearchApprovalMgmtVO[] getSearchApprovalMgmtVOs() {
		return searchApprovalMgmtVOs;
	}
	public void setSearchApprovalMgmtVOs(
			SearchApprovalMgmtVO[] searchApprovalMgmtVOs) {
		this.searchApprovalMgmtVOs = searchApprovalMgmtVOs;
	}

	public String getFmCfmUsrId() {
		return FmCfmUsrId;
	}
	public void setFmCfmUsrId(String fmCfmUsrId) {
		FmCfmUsrId = fmCfmUsrId;
	}
	public String getCfmUsrId() {
		return cfmUsrId;
	}
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}


}
