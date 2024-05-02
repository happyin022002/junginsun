/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1407Event.java
*@FileTitle : Audit by CNTR Qty Discrepancy
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.07 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.ScNoteConversionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1407 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1407HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_1407HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1407Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScNoteConversionVO scNoteConversionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ScNoteConversionVO[] scNoteConversionVOs = null;

	
	public void setScNoteConversionVO(ScNoteConversionVO scNoteConversionVO){
		this. scNoteConversionVO = scNoteConversionVO;
	}

	public void setScNoteConversionVOS(ScNoteConversionVO[] scNoteConversionVOs){
		this. scNoteConversionVOs = scNoteConversionVOs;
	}

	public ScNoteConversionVO getScNoteConversionVO(){
		return scNoteConversionVO;
	}

	public ScNoteConversionVO[] getScNoteConversionVOS(){
		return scNoteConversionVOs;
	}

	/**
	 * @return the ScNoteConversionVOs
	 */
	public ScNoteConversionVO[] getScNoteConversionVOs() {
		return scNoteConversionVOs;
	}

	/**
	 * @param ScNoteConversionVOs the ScNoteConversionVOs to set
	 */
	public void setScNoteConversionVOs(ScNoteConversionVO[] scNoteConversionVOs) {
		this.scNoteConversionVOs = scNoteConversionVOs;
	}
	
}