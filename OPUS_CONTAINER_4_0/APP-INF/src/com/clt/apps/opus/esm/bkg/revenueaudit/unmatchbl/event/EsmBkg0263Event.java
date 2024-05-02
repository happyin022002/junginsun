/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0263Event.java
*@FileTitle : Freight & Charge Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.07 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0263 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0263HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_0263HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0263Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UnmatchBLVO unmatchBLVO = null;
	/** Table Value Object Multi Data 처리 */
	public UnmatchBLVO[] unmatchBLVOs = null;
	
	/* set */
	public void setUnmatchBLVO(UnmatchBLVO unmatchBLVO){
		this.unmatchBLVO = unmatchBLVO;
	}
	public void setUnmatchBLVOS(UnmatchBLVO[] unmatchBLVOs){
		this.unmatchBLVOs = unmatchBLVOs;
	}
	
	/* get */
	public UnmatchBLVO getUnmatchBLVO(){
		return unmatchBLVO;
	}
	public UnmatchBLVO[] getUnmatchBLVOS(){
		return unmatchBLVOs;
	}
}