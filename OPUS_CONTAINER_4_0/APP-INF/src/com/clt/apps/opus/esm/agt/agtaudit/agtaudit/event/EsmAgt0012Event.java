/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_012Event.java
*@FileTitle : Agent Commission Deduction Details for B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-01
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-12-01 Junghyung_kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.BkgAgnCommDeductionRatingVO;
import com.clt.apps.opus.esm.agt.common.event.AGTEvent;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtAgnCommVO;

/**
 * ESM_AGT_012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Junghyung_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Agt_Agn_Comm Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnCommVO agtAgnCommVO = null;
	
	/** Agt_Agn_Comm Table Value Object Multi Data 처리 */
	private AgtAgnCommVO[] agtAgnCommVOs = null;
	
	/** DeductionRating Value Object 조회 조건 및 단건 처리  */
	private BkgAgnCommDeductionRatingVO bkgAgnCommDeductionRatingVO = null;
	/** DeductionRating Value Object Multi Data 처리  */
	private BkgAgnCommDeductionRatingVO[] bkgAgnCommDeductionRatingVOs = null;
	
	/**
	 * ESM_AGT_O012Event 생성자
	 */
	public EsmAgt0012Event(){}
	
	
	public AgtAgnCommVO getAgtAgnCommVO() {
    	return agtAgnCommVO;
    }
	public void setAgtAgnCommVO(AgtAgnCommVO agtAgnCommVO) {
    	this.agtAgnCommVO = agtAgnCommVO;
    }
	public AgtAgnCommVO[] getAgtAgnCommVOs() {
    	return agtAgnCommVOs;
    }
	public void setAgtAgnCommVOs(AgtAgnCommVO[] agtAgnCommVOs) {
    	this.agtAgnCommVOs = agtAgnCommVOs;
    }
	public BkgAgnCommDeductionRatingVO getBkgAgnCommDeductionRatingVO() {
    	return bkgAgnCommDeductionRatingVO;
    }
	public void setBkgAgnCommDeductionRatingVO(BkgAgnCommDeductionRatingVO bkgAgnCommDeductionRatingVO) {
    	this.bkgAgnCommDeductionRatingVO = bkgAgnCommDeductionRatingVO;
    }
	public BkgAgnCommDeductionRatingVO[] getBkgAgnCommDeductionRatingVOs() {
    	return bkgAgnCommDeductionRatingVOs;
    }
	public void setBkgAgnCommDeductionRatingVOs(BkgAgnCommDeductionRatingVO[] bkgAgnCommDeductionRatingVOs) {
    	this.bkgAgnCommDeductionRatingVOs = bkgAgnCommDeductionRatingVOs;
    }

}
