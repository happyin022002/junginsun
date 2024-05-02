/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0136Event.java
*@FileTitle : Activity - TPB Closing
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.10
*@LastModifier : 손은주
*@LastVersion : 1.0
* 2010.11.10 손은주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByClosingTPBVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0116 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0116HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0116HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0136Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchActivityByClosingTPBVO searchActivityByClosingTPBVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchActivityByClosingTPBVO[] searchActivityByClosingTPBVOs = null;

	public EsdTpb0136Event(){}
	
	public void setSearchActivityByClosingTPBVO(SearchActivityByClosingTPBVO searchActivityByClosingTPBVO){
		this. searchActivityByClosingTPBVO = searchActivityByClosingTPBVO;
	}

	public void setSearchActivityByClosingTPBVOS(SearchActivityByClosingTPBVO[] searchActivityByClosingTPBVOs){
		if(searchActivityByClosingTPBVOs != null){
			SearchActivityByClosingTPBVO[] tmpVOs = Arrays.copyOf(searchActivityByClosingTPBVOs, searchActivityByClosingTPBVOs.length);
			this.searchActivityByClosingTPBVOs = tmpVOs;
		}
	}

	public SearchActivityByClosingTPBVO getSearchActivityByClosingTPBVO(){
		return searchActivityByClosingTPBVO;
	}

	public SearchActivityByClosingTPBVO[] getSearchActivityByClosingTPBVOS(){
		SearchActivityByClosingTPBVO[] rtnVOs = null;
		if (this.searchActivityByClosingTPBVOs != null) {
			rtnVOs = Arrays.copyOf(searchActivityByClosingTPBVOs, searchActivityByClosingTPBVOs.length);
		}
		return rtnVOs;
	}

}