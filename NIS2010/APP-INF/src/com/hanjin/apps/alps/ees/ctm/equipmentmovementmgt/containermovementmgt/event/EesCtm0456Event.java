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
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchPreVLVDListVO;


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
		this. searchPreVLVDListVOs = searchPreVLVDListVOs;
	}

	public SearchPreVLVDListVO getSearchPreVLVDListVO(){
		return searchPreVLVDListVO;
	}

	public SearchPreVLVDListVO[] getSearchPreVLVDListVOS(){
		return searchPreVLVDListVOs;
	}

}