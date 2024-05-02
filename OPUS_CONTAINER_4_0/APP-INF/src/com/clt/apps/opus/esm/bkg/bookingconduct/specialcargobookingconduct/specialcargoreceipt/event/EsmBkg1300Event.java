/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1300Event.java
*@FileTitle : Hazadous Paties
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.13
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2015.11.13 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgDgCgoInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DeclarantCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCntrVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1300 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1300HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * @author Kim Tae Kyun
 * @see ESM_BKG_1300HTMLAction에서 참조
 * @since J2EE 1.6
 */

public class EsmBkg1300Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgDgCgoInfoVO bkgDgCgoInfoVO = null;
	private DeclarantCustomerInfoVO declarantCustomerInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgDgCgoInfoVO[] bkgDgCgoInfoVOs = null;
	private DeclarantCustomerInfoVO[] declarantCustomerInfoVOs = null;
	private DgCntrVO[] dgCntrVOs = null;
	
	public EsmBkg1300Event(){}

	/**
	 * @return the bkgDgCgoInfoVO
	 */
	public BkgDgCgoInfoVO getBkgDgCgoInfoVO() {
		return bkgDgCgoInfoVO;
	}

	/**
	 * @param bkgDgCgoInfoVO the bkgDgCgoInfoVO to set
	 */
	public void setBkgDgCgoInfoVO(BkgDgCgoInfoVO bkgDgCgoInfoVO) {
		this.bkgDgCgoInfoVO = bkgDgCgoInfoVO;
	}
	
	/**
	 * @return the declarantCustomerInfoVO
	 */
	public DeclarantCustomerInfoVO getDeclarantCustomerInfoVO() {
		return declarantCustomerInfoVO;
	}

	/**
	 * @param declarantCustomerInfoVO the declarantCustomerInfoVO to set
	 */
	public void setDeclarantCustomerInfoVO(DeclarantCustomerInfoVO declarantCustomerInfoVO) {
		this.declarantCustomerInfoVO = declarantCustomerInfoVO;
	}

	/**
	 * @return the bkgDgCgoInfoVOs
	 */
	public BkgDgCgoInfoVO[] getBkgDgCgoInfoVOs() {
		BkgDgCgoInfoVO[] rtnVOs = null;
		if (this.bkgDgCgoInfoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgDgCgoInfoVOs, bkgDgCgoInfoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bkgDgCgoInfoVOs the bkgDgCgoInfoVOs to set
	 */
	public void setBkgDgCgoInfoVOs(BkgDgCgoInfoVO[] bkgDgCgoInfoVOs) {
		if(bkgDgCgoInfoVOs != null){
			BkgDgCgoInfoVO[] tmpVOs = Arrays.copyOf(bkgDgCgoInfoVOs, bkgDgCgoInfoVOs.length);
			this.bkgDgCgoInfoVOs = tmpVOs;
		}
	}

	/**
	 * @return the declarantCustomerInfoVOs
	 */
	public DeclarantCustomerInfoVO[] getDeclarantCustomerInfoVOs() {
		DeclarantCustomerInfoVO[] rtnVOs = null;
		if (this.declarantCustomerInfoVOs != null) {
			rtnVOs = Arrays.copyOf(declarantCustomerInfoVOs, declarantCustomerInfoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param declarantCustomerInfoVOs the declarantCustomerInfoVOs to set
	 */
	public void setDeclarantCustomerInfoVOs(DeclarantCustomerInfoVO[] declarantCustomerInfoVOs) {
		if(declarantCustomerInfoVOs != null){
			DeclarantCustomerInfoVO[] tmpVOs = Arrays.copyOf(declarantCustomerInfoVOs, declarantCustomerInfoVOs.length);
			this.declarantCustomerInfoVOs = tmpVOs;
		}
	}
	
	/**
	 * @return the dgCntrVOs
	 */
	public DgCntrVO[] getDgCntrVOs() {
		DgCntrVO[] rtnVOs = null;
		if (this.dgCntrVOs != null) {
			rtnVOs = Arrays.copyOf(dgCntrVOs, dgCntrVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dgCntrVOs the dgCntrVOs to set
	 */
	public void setDgCntrVOs(DgCntrVO[] dgCntrVOs) {
		if(dgCntrVOs != null){
			DgCntrVO[] tmpVOs = Arrays.copyOf(dgCntrVOs, dgCntrVOs.length);
			this.dgCntrVOs = tmpVOs;
		}
	}
	


}