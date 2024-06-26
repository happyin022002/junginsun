/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1024Event.java
*@FileTitle : VVD Change for partial container booking
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
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_1024HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private PartialBkgInfoVO partialBkgInfoVO = null;
	private VslSkdVO vslSkdVO = null;	
	/** Table Value Object Multi Data 처리 */
	private PartialBkgInfoVO[] partialBkgInfoVOs = null;
	private VslSkdVO[] vslSkdVOs = null;
	
	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this.bkgBlNoVO = bkgBlNoVO;
	}
	
	public void setPartialBkgInfoVO(PartialBkgInfoVO partialBkgInfoVO){
		this. partialBkgInfoVO = partialBkgInfoVO;
	}

	public void setPartialBkgInfoVOs(PartialBkgInfoVO[] partialBkgInfoVOs){
		this.partialBkgInfoVOs = partialBkgInfoVOs;
	}

	public PartialBkgInfoVO getPartialBkgInfoVO(){
		return partialBkgInfoVO;
	}

	public PartialBkgInfoVO[] getPartialBkgInfoVOs(){
		return partialBkgInfoVOs;
	}		
	
	public void setVslSkdVO(VslSkdVO vslSkdVO){
		this. vslSkdVO = vslSkdVO;
	}

	public void setVslSkdVOs(VslSkdVO[] vslSkdVOs){
		this.vslSkdVOs = vslSkdVOs;
	}

	public VslSkdVO getVslSkdVO(){
		return vslSkdVO;
	}

	public VslSkdVO[] getVslSkdVOs(){
		return vslSkdVOs;
	}	
}