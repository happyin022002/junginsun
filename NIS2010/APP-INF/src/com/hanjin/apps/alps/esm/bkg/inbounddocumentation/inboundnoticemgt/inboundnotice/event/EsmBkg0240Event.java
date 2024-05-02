/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0240Event.java
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.05.20 박창준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IntgCustSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RsltCdListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCustTmpltVO;
import com.hanjin.syscommon.common.table.BkgIbCustCntcVO;
import com.hanjin.syscommon.common.table.BkgMdmCrCustVO;
import com.hanjin.syscommon.common.table.BkgTroActCustVO;

/**
 * esm_bkg_0240 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0240HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Chang June
 * @see ESM_BKG_0240HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0240Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCustomerVO mdmCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCustomerVO[] mdmCustomerVOs = null;
	
	private IntgCustSearchVO intgCustSearchVO = null;
	private IntgCustSearchVO[] intgCustSearchVOs = null;
	
	private BkgIbCustCntcVO bkgIbCustCntcVO = null;
	private BkgIbCustCntcVO[] bkgIbCustCntcVOs = null;

	//O/B
	private BkgCustTmpltVO bkgCustTmpltVO = null;
	private BkgCustTmpltVO[] bkgCustTmpltVOs = null;
	
	//Invoice
	private BkgMdmCrCustVO mdmCrCustVO = null;
	private BkgMdmCrCustVO[] mdmCrCustVOs = null;
	
	//TRO
	private BkgTroActCustVO bkgTroActCustVO = null;
	private BkgTroActCustVO[] bkgTroActCustVOs = null;
	
	//코드값
	private RsltCdListVO rsltcdlistvo = null;
	

	public EsmBkg0240Event(){}
	
	public void setMdmCustomerVO(MdmCustomerVO mdmCustomerVO){
		this. mdmCustomerVO = mdmCustomerVO;
	}

	public void setMdmCustomerVOS(MdmCustomerVO[] mdmCustomerVOs){
		this. mdmCustomerVOs = mdmCustomerVOs;
	}

	public MdmCustomerVO getMdmCustomerVO(){
		return mdmCustomerVO;
	}

	public MdmCustomerVO[] getMdmCustomerVOS(){
		return mdmCustomerVOs;
	}
	public MdmCustomerVO[] getMdmCustomerVOs() {
		return mdmCustomerVOs;
	}

	public void setMdmCustomerVOs(MdmCustomerVO[] mdmCustomerVOs) {
		this.mdmCustomerVOs = mdmCustomerVOs;
	}

	public IntgCustSearchVO getIntgCustSearchVO() {
		return intgCustSearchVO;
	}

	public void setIntgCustSearchVO(IntgCustSearchVO intgCustSearchVO) {
		this.intgCustSearchVO = intgCustSearchVO;
	}

	public IntgCustSearchVO[] getIntgCustSearchVOs() {
		return intgCustSearchVOs;
	}

	public void setIntgCustSearchVOs(IntgCustSearchVO[] intgCustSearchVOs) {
		this.intgCustSearchVOs = intgCustSearchVOs;
	}

	public BkgIbCustCntcVO getBkgIbCustCntcVO() {
		return bkgIbCustCntcVO;
	}

	public void setBkgIbCustCntcVO(IntgCustSearchVO intgCustSearchVO) {
		this.intgCustSearchVO = intgCustSearchVO;
	}

	public BkgIbCustCntcVO[] getBkgIbCustCntcVOs() {
		return bkgIbCustCntcVOs;
	}

	public void setBkgIbCustCntcVOs(BkgIbCustCntcVO[] bkgIbCustCntcVOs) {
		this.bkgIbCustCntcVOs = bkgIbCustCntcVOs;
	}
// O/B
	public BkgCustTmpltVO getBkgCustTmpltVO() {
		return bkgCustTmpltVO;
	}

	public void setBkgCustTmpltVO(IntgCustSearchVO intgCustSearchVO) {
		this.intgCustSearchVO = intgCustSearchVO;
	}

	public BkgCustTmpltVO[] getBkgCustTmpltVOs() {
		return bkgCustTmpltVOs;
	}

	public void setBkgCustTmpltVOs(BkgCustTmpltVO[] bkgCustTmpltVOs) {
		this.bkgCustTmpltVOs = bkgCustTmpltVOs;
	}
	//Invoice
	
	public BkgMdmCrCustVO getMdmCrCustVO() {
		return mdmCrCustVO;
	}

	public void setMdmCrCustVO(IntgCustSearchVO vo) {
		this.intgCustSearchVO = vo;
	}

	public BkgMdmCrCustVO[] getMdmCrCustVOs() {
		return mdmCrCustVOs;
	}

	public void setMdmCrCustVOs(BkgMdmCrCustVO[] mdmCrCustVOs) {
		this.mdmCrCustVOs = mdmCrCustVOs;
	}
//TRO
	public void setBkgTroActCustVO(IntgCustSearchVO vo) {
		// TODO Auto-generated method stub
		this.intgCustSearchVO = vo;
		
	}


	public BkgTroActCustVO getBkgTroActCustVO() {
		return bkgTroActCustVO;
	}

	public void setBkgTroActCustVO(BkgTroActCustVO bkgTroActCustVO) {
		this.bkgTroActCustVO = bkgTroActCustVO;
	}

	public BkgTroActCustVO[] getBkgTroActCustVOs() {
		return bkgTroActCustVOs;
	}

	public void setBkgTroActCustVOs(BkgTroActCustVO[] bkgTroActCustVOs) {
		this.bkgTroActCustVOs = bkgTroActCustVOs;
	}

	public RsltCdListVO getRsltcdlistvo() {
		return rsltcdlistvo;
	}

	public void setRsltcdlistvo(RsltCdListVO rsltcdlistvo) {
		this.rsltcdlistvo = rsltcdlistvo;
	}

	
}