/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1030Event.java
*@FileTitle : booking master
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.19 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;


/**
 * ESM_BKG_1030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_1030HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MandatoryItemSetupListVO mandatoryItemSetupListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MandatoryItemSetupListVO[] mandatoryItemSetupListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgMdtItmVO bkgMdtItmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgMdtItmVO[] bkgMdtItmVOs = null;
	
	private String custCd = null;
	
	private String custSeq = null;

	public EsmBkg1030Event(){}
	
	public void setMandatoryItemSetupListVO(MandatoryItemSetupListVO mandatoryItemSetupListVO){
		this. mandatoryItemSetupListVO = mandatoryItemSetupListVO;
	}

	public void setMandatoryItemSetupListVOS(MandatoryItemSetupListVO[] mandatoryItemSetupListVOs){
		this. mandatoryItemSetupListVOs = mandatoryItemSetupListVOs;
	}

	public void setBkgMdtItmVO(BkgMdtItmVO bkgMdtItmVO){
		this. bkgMdtItmVO = bkgMdtItmVO;
	}

	public void setBkgMdtItmVOS(BkgMdtItmVO[] bkgMdtItmVOs){
		this. bkgMdtItmVOs = bkgMdtItmVOs;
	}

	public void setCustCd(String custCd){
		this.custCd = custCd;
	}
	
	public void setCustSeq(String custSeq){
		this.custSeq = custSeq;
	}
	
	public MandatoryItemSetupListVO getMandatoryItemSetupListVO(){
		return mandatoryItemSetupListVO;
	}

	public MandatoryItemSetupListVO[] getMandatoryItemSetupListVOS(){
		return mandatoryItemSetupListVOs;
	}

	public BkgMdtItmVO getBkgMdtItmVO(){
		return bkgMdtItmVO;
	}

	public BkgMdtItmVO[] getBkgMdtItmVOS(){
		return bkgMdtItmVOs;
	}
	
	public String getCustCd(){
		return custCd;
	}
	
	public String getCustSeq(){
		return custSeq;
	}

}