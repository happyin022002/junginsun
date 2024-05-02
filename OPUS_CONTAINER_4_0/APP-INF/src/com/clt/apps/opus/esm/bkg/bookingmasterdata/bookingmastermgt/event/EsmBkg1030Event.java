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
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.clt.framework.support.layer.event.EventSupport;


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

//	public void setMandatoryItemSetupListVOS(MandatoryItemSetupListVO[] mandatoryItemSetupListVOs){
//		this. mandatoryItemSetupListVOs = mandatoryItemSetupListVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setMandatoryItemSetupListVOS(MandatoryItemSetupListVO[] mandatoryItemSetupListVOs){
		if (mandatoryItemSetupListVOs != null) {
			MandatoryItemSetupListVO[] tmpVOs = new MandatoryItemSetupListVO[mandatoryItemSetupListVOs.length];
			System.arraycopy(mandatoryItemSetupListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mandatoryItemSetupListVOs = tmpVOs;
		}		
	}		
	
	public void setBkgMdtItmVO(BkgMdtItmVO bkgMdtItmVO){
		this. bkgMdtItmVO = bkgMdtItmVO;
	}

//	public void setBkgMdtItmVOS(BkgMdtItmVO[] bkgMdtItmVOs){
//		this. bkgMdtItmVOs = bkgMdtItmVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgMdtItmVOS(BkgMdtItmVO[] bkgMdtItmVOs){
		if (bkgMdtItmVOs != null) {
			BkgMdtItmVO[] tmpVOs = new BkgMdtItmVO[bkgMdtItmVOs.length];
			System.arraycopy(bkgMdtItmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgMdtItmVOs = tmpVOs;
		}		
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

//	public MandatoryItemSetupListVO[] getMandatoryItemSetupListVOS(){
//		return mandatoryItemSetupListVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public MandatoryItemSetupListVO[] getMandatoryItemSetupListVOS(){
		MandatoryItemSetupListVO[] tmpVOs = null;
		if (this.mandatoryItemSetupListVOs != null) {
			tmpVOs = new MandatoryItemSetupListVO[mandatoryItemSetupListVOs.length];
			System.arraycopy(mandatoryItemSetupListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	

	public BkgMdtItmVO getBkgMdtItmVO(){
		return bkgMdtItmVO;
	}

//	public BkgMdtItmVO[] getBkgMdtItmVOS(){
//		return bkgMdtItmVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgMdtItmVO[] getBkgMdtItmVOS(){
		BkgMdtItmVO[] tmpVOs = null;
		if (this.bkgMdtItmVOs != null) {
			tmpVOs = new BkgMdtItmVO[bkgMdtItmVOs.length];
			System.arraycopy(bkgMdtItmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}			
	
	public String getCustCd(){
		return custCd;
	}
	
	public String getCustSeq(){
		return custSeq;
	}

}