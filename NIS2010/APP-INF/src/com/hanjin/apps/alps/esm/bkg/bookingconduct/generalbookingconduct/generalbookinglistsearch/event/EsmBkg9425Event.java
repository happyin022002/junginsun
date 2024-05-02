/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg9425Event.java
*@FileTitle : Empty REPO BKG Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.30 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListInputVO;


/**
 * ESM_BKG_9425 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9425HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_9425HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9425Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EmptyBkgListInputVO emptyBkgListInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EmptyBkgListInputVO[] emptyBkgListInputVOs = null;

	public EsmBkg9425Event(){}
	
	public void setEmptyBkgListInputVO(EmptyBkgListInputVO emptyBkgListInputVO){
		this. emptyBkgListInputVO = emptyBkgListInputVO;
	}

	public void setEmptyBkgListInputVOS(EmptyBkgListInputVO[] emptyBkgListInputVOs){
		this. emptyBkgListInputVOs = emptyBkgListInputVOs;
	}

	public EmptyBkgListInputVO getEmptyBkgListInputVO(){
		return emptyBkgListInputVO;
	}

	public EmptyBkgListInputVO[] getEmptyBkgListInputVOS(){
		return emptyBkgListInputVOs;
	}

}