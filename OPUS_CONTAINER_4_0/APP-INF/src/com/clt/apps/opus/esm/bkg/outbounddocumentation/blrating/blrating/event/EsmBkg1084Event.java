/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1068Event.java
*@FileTitle : TPB Issue Popup
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : KIM TAE KYOUNG
*@LastVersion : 1.0
* 2010.02.12 KIM TAE KYOUNG
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTpbInfoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1084 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1084HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Mi Ok
 * @see ESM_BKG_1084HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1084Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String bkgNo = "";
	
	private String ntcSeq = "";
	
	private SearchTpbInfoVO  searchTpbInfoVO = null;
	
	private SearchTpbInfoVO[] searchTpbInfoVOs = null;
	
		
	public EsmBkg1084Event(){}
	
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param ntcSeq the ntcSeq to set
	 */
	public void setNtcSeq(String ntcSeq) {
		this.ntcSeq = ntcSeq;
	}

	/**
	 * @return the ntcSeq
	 */
	public String getNtcSeq() {
		return ntcSeq;
	}

	/**
	 * @param tpbInfoVO the tpbInfoVO to set
	 */
	public void setSearchTpbInfoVO(SearchTpbInfoVO searchTpbInfoVO) {
		this.searchTpbInfoVO = searchTpbInfoVO;
	}

	/**
	 * @return the tpbInfoVO
	 */
	public SearchTpbInfoVO getSearchTpbInfoVO() {
		return searchTpbInfoVO;
	}

	public SearchTpbInfoVO[] getSearchTpbInfoVOs() {
		SearchTpbInfoVO[] rtnVOs = null;
		if (this.searchTpbInfoVOs != null) {
			rtnVOs = Arrays.copyOf(searchTpbInfoVOs, searchTpbInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchTpbInfoVOs(SearchTpbInfoVO[] searchTpbInfoVOs) {
		if (searchTpbInfoVOs != null) {
			SearchTpbInfoVO[] tmpVOs = Arrays.copyOf(searchTpbInfoVOs, searchTpbInfoVOs.length);
			this.searchTpbInfoVOs = tmpVOs;
		}
	}

}