/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0890Event.java
*@FileTitle : Cargo Detail Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.08.18 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;


/**
 * ESM_BKG_0890 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0890HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0890HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0890Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String callTp = null;	
	
	public void setCallTp(String callTp){
		this. callTp = callTp;
	}

	public String getCallTp(){
		return callTp;
	}	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgQtyDtlVO bkgQtyDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgQtyDtlVO[] bkgQtyDtlVOs = null;

	public EsmBkg0890Event(){}
	
	public void setBkgQtyDtlVO(BkgQtyDtlVO bkgQtyDtlVO){
		this. bkgQtyDtlVO = bkgQtyDtlVO;
	}

	public void setBkgQtyDtlVOs(BkgQtyDtlVO[] bkgQtyDtlVOs){
		this. bkgQtyDtlVOs = bkgQtyDtlVOs;
	}

	public BkgQtyDtlVO getBkgQtyDtlVO(){
		return bkgQtyDtlVO;
	}

	public BkgQtyDtlVO[] getBkgQtyDtlVOs(){
		return bkgQtyDtlVOs;
	}

	/* BkgBlNoVO Start  */
	private BkgBlNoVO bkgBlNoVO = null;


	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	/* BkgBlNoVO End  */	
}