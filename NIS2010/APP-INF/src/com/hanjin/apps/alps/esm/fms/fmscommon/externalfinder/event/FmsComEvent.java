/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MnrCommonEvent.java
*@FileTitle : 공통펑션으로 코드값과 디스크립션을 받아온다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박명신 
*@LastVersion : 1.0   
* 2009.05.12 박명신 
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.event;

import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
    
/**
 * FMS_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FMS_COM_HTMLAction 에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE Young Du
 * @see FMS_COM_HTMLAction 참조 
 * @since J2EE 1.4  
 */ 
     
public class FmsComEvent extends EventSupport { 
	private static final long serialVersionUID = 1L;
	
	public FmsComEvent(){} 
	
	/** Table Value Object 조회 조건 */

	//Contract No VO
	private SearchContractNoVO[] searchContractNoVOS = null;
	private SearchContractNoVO searchContractNoVO = null;

	private String sValue;
	
	public SearchContractNoVO[] getSearchContractNoVOS() {
		SearchContractNoVO[] tmpVOs = null;
		if (this.searchContractNoVOS != null) {
			tmpVOs = new SearchContractNoVO[searchContractNoVOS.length];
			System.arraycopy(searchContractNoVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setSearchContractNoVOS(SearchContractNoVO[] searchContractNoVOS) {
		if (searchContractNoVOS != null) {
			SearchContractNoVO[] tmpVOs = new SearchContractNoVO[searchContractNoVOS.length];
			System.arraycopy(searchContractNoVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.searchContractNoVOS = tmpVOs;
		}
	}

	public SearchContractNoVO getSearchContractNoVO() {
		return searchContractNoVO;
	}

	public void setSearchContractNoVO(SearchContractNoVO searchContractNoVO) {
		this.searchContractNoVO = searchContractNoVO;
	}

	public String getsValue() {
		return sValue;
	}

	public void setsValue(String sValue) {
		this.sValue = sValue;
	}

	
}