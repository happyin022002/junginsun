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
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event;

import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeParamVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCommonVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchDefaultDateVO;
import com.clt.framework.support.layer.event.EventSupport;
    
/**
 * MNR_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  MNR_COM_HTMLAction 에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author park myoung sin
 * @see MNR_COM_HTMLAction 참조 
 * @since J2EE 1.4 
 */ 
     
public class FmsComEvent extends EventSupport { 
	private static final long serialVersionUID = 1L;
	
	public FmsComEvent(){} 
	
	/** Table Value Object 조회 조건 */
	//Default Date 조회용
	private SearchDefaultDateVO[] searchDefaultDateVOS = null;

	//Default Date 추가	
	private SearchDefaultDateVO searchDefaultDateVO = null;

	public SearchDefaultDateVO[] getSearchDefaultDateVOS() {
		SearchDefaultDateVO[] tmpVOs = null;
		if (this.searchDefaultDateVOS != null) {
			tmpVOs = new SearchDefaultDateVO[searchDefaultDateVOS.length];
			System.arraycopy(searchDefaultDateVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setSearchDefaultDateVOS(SearchDefaultDateVO[] searchDefaultDateVOS) {
		if (searchDefaultDateVOS != null) {
			SearchDefaultDateVO[] tmpVOs = new SearchDefaultDateVO[searchDefaultDateVOS.length];
			System.arraycopy(searchDefaultDateVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.searchDefaultDateVOS = tmpVOs;
		}
	}

	public SearchDefaultDateVO getSearchDefaultDateVO() {
		return searchDefaultDateVO;
	}

	public void setSearchDefaultDateVO(SearchDefaultDateVO searchDefaultDateVO) {
		this.searchDefaultDateVO = searchDefaultDateVO;
	}	
	
	//Contract No VO
	private SearchContractNoVO[] searchContractNoVOS = null;
	private SearchContractNoVO searchContractNoVO = null;

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
	
	/* Search Contract Info*/
	private SearchContractInfoVO[] searchContractInfoVOS = null;
	private SearchContractInfoVO searchContractInfoVO = null;

	public SearchContractInfoVO[] getSearchContractInfoVOS() {
		SearchContractInfoVO[] tmpVOs = null;
		if (this.searchContractInfoVOS != null) {
			tmpVOs = new SearchContractInfoVO[searchContractInfoVOS.length];
			System.arraycopy(searchContractInfoVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setSearchContractInfoVOS(SearchContractInfoVO[] searchContractInfoVOS) {
		if (searchContractInfoVOS != null) {
			SearchContractInfoVO[] tmpVOs = new SearchContractInfoVO[searchContractInfoVOS.length];
			System.arraycopy(searchContractInfoVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.searchContractInfoVOS = tmpVOs;
		}
	}

	public SearchContractInfoVO getSearchContractInfoVO() {
		return searchContractInfoVO;
	}

	public void setSearchContractInfoVO(SearchContractInfoVO searchContractInfoVO) {
		this.searchContractInfoVO = searchContractInfoVO;
	}
	
	/*Search Tax Type*/
	private FmsCodeInfoVO[] fmsCodeInfoVOS = null;
	private FmsCodeInfoVO fmsCodeInfoVO = null;
	private FmsCodeParamVO fmsCodeParamVO = null;

	public FmsCodeInfoVO[] getFmsCodeInfoVOS() {
		FmsCodeInfoVO[] tmpVOs = null;
		if (this.fmsCodeInfoVOS != null) {
			tmpVOs = new FmsCodeInfoVO[fmsCodeInfoVOS.length];
			System.arraycopy(fmsCodeInfoVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setFmsCodeInfoVOS(FmsCodeInfoVO[] fmsCodeInfoVOS) {
		if (fmsCodeInfoVOS != null) {
			FmsCodeInfoVO[] tmpVOs = new FmsCodeInfoVO[fmsCodeInfoVOS.length];
			System.arraycopy(fmsCodeInfoVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.fmsCodeInfoVOS = tmpVOs;
		}
	}

	public FmsCodeInfoVO getFmsCodeInfoVO() {
		return fmsCodeInfoVO;
	}

	public void setFmsCodeInfoVO(FmsCodeInfoVO fmsCodeInfoVO) {
		this.fmsCodeInfoVO = fmsCodeInfoVO;
	}

	public FmsCodeParamVO getFmsCodeParamVO() {
		return fmsCodeParamVO;
	}

	public void setFmsCodeParamVO(FmsCodeParamVO fmsCodeParamVO) {
		this.fmsCodeParamVO = fmsCodeParamVO;
	}
	//Default Date 추가	
	private FmsCommonVO fmsCommonVO = null;

	public FmsCommonVO getFmsCommonVO() {
		return fmsCommonVO;
	}

	public void setFmsCommonVO(FmsCommonVO fmsCommonVO) {
		this.fmsCommonVO = fmsCommonVO;
	}
	
}