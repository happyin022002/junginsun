/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0415Event.java
*@FileTitle : Deleted CNTR MVMT History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.13 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_ctm_0415 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_ctm_0415HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ees_ctm_0415HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCtm0415Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchDeletedMVMTListVO searchDeletedMVMTListVO = null;

	public EesCtm0415Event(){}

	public void setSearchDeletedMVMTListVO(SearchDeletedMVMTListVO searchDeletedMVMTListVO){
		this. searchDeletedMVMTListVO = searchDeletedMVMTListVO;
	}

	public SearchDeletedMVMTListVO getSearchDeletedMVMTListVO(){
		return searchDeletedMVMTListVO;
	}

}