/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0115Event.java
*@FileTitle : StatusInquiryConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailInfoVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0115HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0115Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBDetailListVO searchTPBDetailListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBDetailListVO[] searchTPBDetailListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTPBDetailInfoVO searchTPBDetailInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTPBDetailInfoVO[] searchTPBDetailInfoVOs = null;

	public EsdTpb0115Event(){}
	
	public void setSearchTPBDetailListVO(SearchTPBDetailListVO searchTPBDetailListVO){
		this. searchTPBDetailListVO = searchTPBDetailListVO;
	}

	public void setSearchTPBDetailListVOS(SearchTPBDetailListVO[] searchTPBDetailListVOs){
		if(searchTPBDetailListVOs != null){
			SearchTPBDetailListVO[] tmpVOs = Arrays.copyOf(searchTPBDetailListVOs, searchTPBDetailListVOs.length);
			this.searchTPBDetailListVOs = tmpVOs;
		}
	}

	public SearchTPBDetailListVO getSearchTPBDetailListVO(){
		return searchTPBDetailListVO;
	}

	public SearchTPBDetailListVO[] getSearchTPBDetailListVOS(){
		SearchTPBDetailListVO[] rtnVOs = null;
		if (this.searchTPBDetailListVOs != null) {
			rtnVOs = Arrays.copyOf(searchTPBDetailListVOs, searchTPBDetailListVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSearchTPBDetailInfoVO(SearchTPBDetailInfoVO searchTPBDetailInfoVO){
		this. searchTPBDetailInfoVO = searchTPBDetailInfoVO;
	}

	public void setSearchTPBDetailInfoVOS(SearchTPBDetailInfoVO[] searchTPBDetailInfoVOs){
		if(searchTPBDetailInfoVOs != null){
			SearchTPBDetailInfoVO[] tmpVOs = Arrays.copyOf(searchTPBDetailInfoVOs, searchTPBDetailInfoVOs.length);
			this.searchTPBDetailInfoVOs = tmpVOs;
		}
	}

	public SearchTPBDetailInfoVO getSearchTPBDetailInfoVO(){
		return searchTPBDetailInfoVO;
	}

	public SearchTPBDetailInfoVO[] getSearchTPBDetailInfoVOS(){
		SearchTPBDetailInfoVO[] rtnVOs = null;
		if (this.searchTPBDetailInfoVOs != null) {
			rtnVOs = Arrays.copyOf(searchTPBDetailInfoVOs, searchTPBDetailInfoVOs.length);
		}
		return rtnVOs;
	}

}