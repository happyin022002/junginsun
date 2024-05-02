/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmPri0123Event.java
*@FileTitle : MOT/SSE Filing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltMOTFileHeaderVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.SearchMOTFileVO;


/**
 * ESM_PRI_0140 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0140HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_PRI_0140HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchMOTFileVO searchMOTFileVO = null;
	RsltMOTFileHeaderVO[] rsltMOTFileHeaderVOs = null;

	public EsmPri0123Event(){}
	
	public void setSearchMOTFileVO(SearchMOTFileVO searchMOTFileVO){
		this.searchMOTFileVO = searchMOTFileVO;
	}

	public SearchMOTFileVO getSearchMOTFileVO(){
		return searchMOTFileVO;
	}

	public RsltMOTFileHeaderVO[] getRsltMOTFileHeaderVOs() {
		return rsltMOTFileHeaderVOs;
	}

	public void setRsltMOTFileHeaderVOs(RsltMOTFileHeaderVO[] rsltMOTFileHeaderVOs) {
		this.rsltMOTFileHeaderVOs = rsltMOTFileHeaderVOs;
	}


}