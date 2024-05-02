/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0102Event.java
*@FileTitle : Compulsory Firm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.26 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Byung Kyu
 * @see ESM_BKG_0102HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0102Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgListForCompFirmInputVO bkgListForCompFirmInputVO = null;
	private BkgListForCompFirmVO bkgListForCompFirmVO = null;

	private String custCntCd = null;
	private String custSeq = null;

	/** Table Value Object Multi Data 처리 */
	private BkgListForCompFirmVO[] bkgListForCompFirmVOs = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private BkgBlNoVO bkgBlNoVO = null;
	private AllocStsVO allocStsVO = null;

	public EsmBkg0102Event(){}

	public void setBkgListForCompFirmInputVO(BkgListForCompFirmInputVO bkgListForCompFirmInputVO){
		this. bkgListForCompFirmInputVO = bkgListForCompFirmInputVO;
	}

	public BkgListForCompFirmInputVO getBkgListForCompFirmInputVO(){
		return bkgListForCompFirmInputVO;
	}

	public void setBkgListForCompFirmVO(BkgListForCompFirmVO bkgListForCompFirmVO){
		this. bkgListForCompFirmVO = bkgListForCompFirmVO;
	}

	public void setBkgListForCompFirmVOs(BkgListForCompFirmVO[] bkgListForCompFirmVOs){
		this. bkgListForCompFirmVOs = bkgListForCompFirmVOs;
	}

	public BkgListForCompFirmVO getBkgListForCompFirmVO(){
		return bkgListForCompFirmVO;
	}

	public BkgListForCompFirmVO[] getBkgListForCompFirmVOs(){
		return bkgListForCompFirmVOs;
	}

	public void setCustCntCd(String custCntCd){
		this.custCntCd = custCntCd;
	}

	public String getCustCntCd(){
		return custCntCd;
	}

	public void setCustSeq(String custSeq){
		this.custSeq = custSeq;
	}

	public String getCustSeq(){
		return custSeq;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs){
		this. bkgBlNoVOs = bkgBlNoVOs;
	}

	public BkgBlNoVO[] getBkgBlNoVOs(){
		return bkgBlNoVOs;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public AllocStsVO getAllocStsVO() {
		return allocStsVO;
	}

	public void setAllocStsVO(AllocStsVO allocStsVO) {
		this.allocStsVO = allocStsVO;
	}
	
}