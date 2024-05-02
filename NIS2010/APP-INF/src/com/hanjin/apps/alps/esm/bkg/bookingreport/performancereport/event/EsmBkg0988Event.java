/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0988Event.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.11 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSRReceivingListVO;


/**
 * ESM_BKG_0988 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0988HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0988HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0988Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSRReceivingListVO searchSRReceivingListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSRReceivingListVO[] searchSRReceivingListVOs = null;
	
	private String srNo 	= null;
	
	private String srKndCd 	= null;
	
	private String rcvRmk	= null;

	public EsmBkg0988Event(){}
	
	public void setSearchSRReceivingListVO(SearchSRReceivingListVO searchSRReceivingListVO){
		this. searchSRReceivingListVO = searchSRReceivingListVO;
	}

	public void setSearchSRReceivingListVOS(SearchSRReceivingListVO[] searchSRReceivingListVOs){
		if(searchSRReceivingListVOs != null){
			SearchSRReceivingListVO[] tmpVOs = Arrays.copyOf(searchSRReceivingListVOs, searchSRReceivingListVOs.length);
			this.searchSRReceivingListVOs = tmpVOs;
		}
	}
	
	public void setSrNo(String srNo){
		this.srNo = srNo;
	}
	
	public void setSrKndCd(String srKndCd){
		this.srKndCd = srKndCd;
	}
	
	public void setRcvRmk(String rcvRmk){
		this.rcvRmk = rcvRmk;
	}
	
	public SearchSRReceivingListVO getSearchSRReceivingListVO(){
		return searchSRReceivingListVO;
	}

	public SearchSRReceivingListVO[] getSearchSRReceivingListVOS(){
		SearchSRReceivingListVO[] rtnVOs = null;
		if (this.searchSRReceivingListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSRReceivingListVOs, searchSRReceivingListVOs.length);
		}
		return rtnVOs;
	}
	
	public String getSrNo(){
		return srNo;
	}
	
	public String getSrKndCd(){
		return srKndCd;
	}
	
	public String getRcvRmk(){
		return rcvRmk;
	}

}