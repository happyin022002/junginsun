/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmFms0097Event.java
*@FileTitle : (New)Owner’s Account
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.04.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerAccountVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchNewOwnerAccountListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0097 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0097HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_FMS_0097HTMLAction 참조 
 * @since J2EE 1.4
 */

public class EsmFms0097Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** vvd 항차번호 */
	private String vvd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchOwnerAccountVO condSearchOwnerAccountVO = null;
	private SearchNewOwnerAccountListVO searchNewOwnerAccountListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondSearchOwnerAccountVO[] condSearchOwnerAccountVOs = null;
	private SearchNewOwnerAccountListVO[] searchNewOwnerAccountListVOs = null;
	
	public EsmFms0097Event(){}
	
	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	public void setCondSearchOwnerAccountVO(CondSearchOwnerAccountVO condSearchOwnerAccountVO) {
		this. condSearchOwnerAccountVO = condSearchOwnerAccountVO;
	}

	public void setCondSearchOwnerAccountVOS(CondSearchOwnerAccountVO[] condSearchOwnerAccountVOs){
		if (condSearchOwnerAccountVOs != null) {
			CondSearchOwnerAccountVO[] tmpVOs = Arrays.copyOf(condSearchOwnerAccountVOs, condSearchOwnerAccountVOs.length);
			this.condSearchOwnerAccountVOs = tmpVOs;
		}
	}

	public CondSearchOwnerAccountVO getCondSearchOwnerAccountVO(){
		return condSearchOwnerAccountVO;
	}

	public CondSearchOwnerAccountVO[] getCondSearchOwnerAccountVOS(){
		CondSearchOwnerAccountVO[] rtnVOs = null;
		if (this.condSearchOwnerAccountVOs != null) {
			rtnVOs = Arrays.copyOf(condSearchOwnerAccountVOs, condSearchOwnerAccountVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSearchNewOwnerAccountListVO(SearchNewOwnerAccountListVO searchNewOwnerAccountListVO) {
		this.searchNewOwnerAccountListVO = searchNewOwnerAccountListVO;
	}
	
	public void setSearchNewOwnerAccountListVOS(SearchNewOwnerAccountListVO[] searchNewOwnerAccountListVOs) {
		if (searchNewOwnerAccountListVOs != null) {
			SearchNewOwnerAccountListVO[] sndVOs = Arrays.copyOf(searchNewOwnerAccountListVOs, searchNewOwnerAccountListVOs.length);
			this.searchNewOwnerAccountListVOs = sndVOs;
		}
	}
	
	public SearchNewOwnerAccountListVO getSearchNewOwnerAccountListVO() {
		return searchNewOwnerAccountListVO;
	}
	
	public SearchNewOwnerAccountListVO[] getSearchNewOwnerAccountListVOS() {
		SearchNewOwnerAccountListVO[] rtnVOs = null;
		if(this.searchNewOwnerAccountListVOs != null) {
			rtnVOs = Arrays.copyOf(searchNewOwnerAccountListVOs, searchNewOwnerAccountListVOs.length);
		}
		return rtnVOs;
	}
}