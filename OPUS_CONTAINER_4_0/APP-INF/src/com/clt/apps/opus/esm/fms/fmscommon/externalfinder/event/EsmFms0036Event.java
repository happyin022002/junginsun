/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0036Event.java
*@FileTitle : Lane Code Search - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.13 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event;

import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchLaneCodeListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0036HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchLaneCodeListVO searchLaneCodeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchLaneCodeListVO[] searchLaneCodeListVOs = null;

	public EsmFms0036Event(){}
	
	public void setSearchLaneCodeListVO(SearchLaneCodeListVO searchLaneCodeListVO){
		this. searchLaneCodeListVO = searchLaneCodeListVO;
	}

	public void setSearchLaneCodeListVOS(SearchLaneCodeListVO[] searchLaneCodeListVOs){
		if (searchLaneCodeListVOs != null) {
			SearchLaneCodeListVO[] tmpVOs = new SearchLaneCodeListVO[searchLaneCodeListVOs.length];
			System.arraycopy(searchLaneCodeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchLaneCodeListVOs = tmpVOs;
		}
	}

	public SearchLaneCodeListVO getSearchLaneCodeListVO(){
		return searchLaneCodeListVO;
	}

	public SearchLaneCodeListVO[] getSearchLaneCodeListVOS(){
		SearchLaneCodeListVO[] tmpVOs = null;
		if (this.searchLaneCodeListVOs != null) {
			tmpVOs = new SearchLaneCodeListVO[searchLaneCodeListVOs.length];
			System.arraycopy(searchLaneCodeListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}