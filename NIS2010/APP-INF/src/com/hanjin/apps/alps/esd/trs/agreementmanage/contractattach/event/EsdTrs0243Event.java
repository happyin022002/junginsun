/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdTrs0243Event.java
*@FileTitle : Contract Attach
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : CHOI JONG HYEK
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.vo.SearchContractVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_243 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_243HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI JONG HYEK
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsdTrs0243Event extends EventSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 검색 값
	private String agmtNo =null;
	private String fCtrtMnFlg = null;
	
	private SearchContractVO searchContractVO = null;
	private SearchContractVO[] searchContractVOs = null;

	public String getAgmtNo() {
		return agmtNo;
	}

	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	public String getfCtrtMnFlg() {
		return fCtrtMnFlg;
	}

	public void setfCtrtMnFlg(String fCtrtMnFlg) {
		this.fCtrtMnFlg = fCtrtMnFlg;
	}

	public SearchContractVO getSearchContractVO() {
		return searchContractVO;
	}

	public void setSearchContractVO(SearchContractVO searchContractVO) {
		this.searchContractVO = searchContractVO;
	}

	public SearchContractVO[] getSearchContractVOs() {
		return searchContractVOs;
	}

	public void setSearchContractVOs(SearchContractVO[] searchContractVOs) {
		this.searchContractVOs = searchContractVOs;
	}

	public EsdTrs0243Event(){}
	
	public String getEventName() {
		return "EsdTrs0243Event";
	}

	public String toString() {
		return "EsdTrs0243Event";
	}
	
}

