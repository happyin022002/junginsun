/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BcmCcd2003Event.java
*@FileTitle : BCM_CCD_2003
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.SearchMdmHistoryListVO;


/**
 * BCM_CCD_2003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_2003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_2003HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class BcmCcd2003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMdmHistoryListVO searchMdmHistoryListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchMdmHistoryListVO[] searchMdmHistoryListVOs = null;

	public BcmCcd2003Event(){}
	
	public void setSearchMdmHistoryListVO(SearchMdmHistoryListVO searchMdmHistoryListVO){
		this. searchMdmHistoryListVO = searchMdmHistoryListVO;
	}

	public void setSearchMdmHistoryListVOS(SearchMdmHistoryListVO[] searchMdmHistoryListVOs){
		if(searchMdmHistoryListVOs != null){
			SearchMdmHistoryListVO[] tmpVOs = java.util.Arrays.copyOf(searchMdmHistoryListVOs, searchMdmHistoryListVOs.length);
			this.searchMdmHistoryListVOs = tmpVOs;
		}
	}

	public SearchMdmHistoryListVO getSearchMdmHistoryListVO(){
		return searchMdmHistoryListVO;
	}

	public SearchMdmHistoryListVO[] getSearchMdmHistoryListVOS(){
		SearchMdmHistoryListVO[] rtnVOs = null;
		if (this.searchMdmHistoryListVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(searchMdmHistoryListVOs, searchMdmHistoryListVOs.length);
		}
		return rtnVOs;
	}

}