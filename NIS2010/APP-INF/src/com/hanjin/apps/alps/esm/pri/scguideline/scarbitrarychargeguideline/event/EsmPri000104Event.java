/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPri000104Event.java
*@FileTitle : Origin/Destination Arbitrary Charge Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.17 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.event;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgArbVO;


/**
 * UI_PRI_0001_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_PRI_0001_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0001_04HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltCdListVO rsltCdListVO = null;		
	
	public RsltCdListVO getRsltCdListVO() {
		return rsltCdListVO;
	}

	public void setRsltCdListVO(RsltCdListVO rsltCdListVO) {
		this.rsltCdListVO = rsltCdListVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgArbVO priSgArbVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgArbVO[] priSgArbVOs = null;

	public EsmPri000104Event(){}
	
	public void setPriSgArbVO(PriSgArbVO priSgArbVO){
		this. priSgArbVO = priSgArbVO;
	}

	public void setPriSgArbVOS(PriSgArbVO[] priSgArbVOs){
		this. priSgArbVOs = priSgArbVOs;
	}

	public PriSgArbVO getPriSgArbVO(){
		return priSgArbVO;
	}

	public PriSgArbVO[] getPriSgArbVOS(){
		return priSgArbVOs;
	}

}