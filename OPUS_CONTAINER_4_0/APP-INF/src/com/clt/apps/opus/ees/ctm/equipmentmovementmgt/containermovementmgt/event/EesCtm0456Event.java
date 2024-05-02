/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0456Event.java
*@FileTitle : Pre-booked VL/VD Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.09.09 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchPreVLVDListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0456 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0456HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang Soo
 * @see EES_CTM_0456HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0456Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchPreVLVDListVO searchPreVLVDListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchPreVLVDListVO[] searchPreVLVDListVOs = null;

	public EesCtm0456Event(){}
	
	public void setSearchPreVLVDListVO(SearchPreVLVDListVO searchPreVLVDListVO){
		this. searchPreVLVDListVO = searchPreVLVDListVO;
	}

	public void setSearchPreVLVDListVOS(SearchPreVLVDListVO[] searchPreVLVDListVOs){
		if (searchPreVLVDListVOs != null) {
			SearchPreVLVDListVO[] tmpVOs = new SearchPreVLVDListVO[searchPreVLVDListVOs.length];
			System.arraycopy(searchPreVLVDListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchPreVLVDListVOs = tmpVOs;
		}
	}

	public SearchPreVLVDListVO getSearchPreVLVDListVO(){
		return searchPreVLVDListVO;
	}

	public SearchPreVLVDListVO[] getSearchPreVLVDListVOS(){
		SearchPreVLVDListVO[] tmpVOs = null;
		if (this.searchPreVLVDListVOs != null) {
			tmpVOs = new SearchPreVLVDListVO[searchPreVLVDListVOs.length];
			System.arraycopy(searchPreVLVDListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}