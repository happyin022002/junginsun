/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoOtherNoVO.java
*@FileTitle : PoOtherNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.09 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.util.List;

import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 및 관련 vo들을 모두 담는 역활을 수행하는 Value Object
 *
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PoOtherNoVO {

	private boolean 			isFirst 			= true; // 최초 조회여부
	private SignOnUserAccount 	account				= null;//사용자 정보
	private PoOtherNoBkgVO		io_poOtherNoBkgVO	= null;//text   = 결과값 및 처리대상 받기

	private List<PoOtherNoBkgVO> o_poOtherNoBkgVOs	= null;//sheet0 = 결과값 List로 리턴받기
	private List<PoOtherCntrVO>	 o_poOtherCntrVOs	= null;//sheet1 = 결과값 List로 리턴받기
	private List<PoOtherCmVO>	 o_poOtherCmVOs		= null;//sheet2 = 결과값 List로 리턴받기
	private List<PoOtherShipVO>	 o_poOtherShipVOs	= null;//sheet3 = 결과값 List로 리턴받기
	private List<PoOtherMrnUcrVO> o_poOtherMrnUcrVOs= null;//sheet4 = 결과값 List로 리턴받기
	private PoOtherMdtItmVO		 o_PoOtherMdtItmVO	= null;//추가개발 (커스텀환경 )

	private BkgReferenceVO[]	 i_poOtherNoBkgVOs	= null;//sheet0 = 처리대상값 배열로 받기
	private BkgReferenceVO[]	 i_poOtherCntrVOs	= null;//sheet1 = 처리대상값 배열로 받기
	private BkgRefDtlVO[]		 i_poOtherCmVOs		= null;//sheet2 = 처리대상값 배열로 받기
	private BkgRefDtlVO[]		 i_poOtherShipVOs	= null;//sheet3 = 처리대상값 배열로 받기
	private BkgRefDtlVO[]		 i_poOtherMrnUcrVOs	= null;//sheet4 = 처리대상값 배열로 받기
	
	private String 				cntrNoDuplicated    = "";//Flag to show whether container no is duplicated or not in BKG_REFERENCE

	/**
	 * @return the isFirst
	 */
	public boolean isFirst() {
		return isFirst;
	}
	/**
	 * @param isFirst the isFirst to set
	 */
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	/**
	 * @return the o_PoOtherMdtItmVO
	 */
	public PoOtherMdtItmVO getO_PoOtherMdtItmVO() {
		return o_PoOtherMdtItmVO;
	}
	/**
	 * @param poOtherMdtItmVO the o_PoOtherMdtItmVO to set
	 */
	public void setO_PoOtherMdtItmVO(PoOtherMdtItmVO poOtherMdtItmVO) {
		o_PoOtherMdtItmVO = poOtherMdtItmVO;
	}
	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	/**
	 * @return the io_poOtherNoBkgVO
	 */
	public PoOtherNoBkgVO getIo_poOtherNoBkgVO() {
		return io_poOtherNoBkgVO;
	}
	/**
	 * @param io_poOtherNoBkgVO the io_poOtherNoBkgVO to set
	 */
	public void setIo_poOtherNoBkgVO(PoOtherNoBkgVO io_poOtherNoBkgVO) {
		this.io_poOtherNoBkgVO = io_poOtherNoBkgVO;
	}
	/**
	 * @return the o_poOtherNoBkgVOs
	 */
	public List<PoOtherNoBkgVO> getO_poOtherNoBkgVOs() {
		return o_poOtherNoBkgVOs;
	}
	/**
	 * @param otherNoBkgVOs the o_poOtherNoBkgVOs to set
	 */
	public void setO_poOtherNoBkgVOs(List<PoOtherNoBkgVO> otherNoBkgVOs) {
		o_poOtherNoBkgVOs = otherNoBkgVOs;
	}
	/**
	 * @return the o_poOtherCntrVOs
	 */
	public List<PoOtherCntrVO> getO_poOtherCntrVOs() {
		return o_poOtherCntrVOs;
	}
	/**
	 * @param otherCntrVOs the o_poOtherCntrVOs to set
	 */
	public void setO_poOtherCntrVOs(List<PoOtherCntrVO> otherCntrVOs) {
		o_poOtherCntrVOs = otherCntrVOs;
	}
	/**
	 * @return the o_poOtherCmVOs
	 */
	public List<PoOtherCmVO> getO_poOtherCmVOs() {
		return o_poOtherCmVOs;
	}
	/**
	 * @param otherCmVOs the o_poOtherCmVOs to set
	 */
	public void setO_poOtherCmVOs(List<PoOtherCmVO> otherCmVOs) {
		o_poOtherCmVOs = otherCmVOs;
	}
	/**
	 * @return the o_poOtherShipVOs
	 */
	public List<PoOtherShipVO> getO_poOtherShipVOs() {
		return o_poOtherShipVOs;
	}
	/**
	 * @param otherShipVOs the o_poOtherShipVOs to set
	 */
	public void setO_poOtherShipVOs(List<PoOtherShipVO> otherShipVOs) {
		o_poOtherShipVOs = otherShipVOs;
	}
	/**
	 * @return the o_poOtherMrnUcrVOs
	 */
	public List<PoOtherMrnUcrVO> getO_poOtherMrnUcrVOs() {
		return o_poOtherMrnUcrVOs;
	}
	/**
	 * @param o_poOtherMrnUcrVOs the o_poOtherMrnUcrVOs to set
	 */
	public void setO_poOtherMrnUcrVOs(List<PoOtherMrnUcrVO> o_poOtherMrnUcrVOs) {
		this.o_poOtherMrnUcrVOs = o_poOtherMrnUcrVOs;
	}
	/**
	 * @return the i_poOtherNoBkgVOs
	 */
	public BkgReferenceVO[] getI_poOtherNoBkgVOs() {
		return i_poOtherNoBkgVOs;
	}
	/**
	 * @param otherNoBkgVOs the i_poOtherNoBkgVOs to set
	 */
	public void setI_poOtherNoBkgVOs(BkgReferenceVO[] otherNoBkgVOs) {
		i_poOtherNoBkgVOs = otherNoBkgVOs;
	}
	/**
	 * @return the i_poOtherCntrVOs
	 */
	public BkgReferenceVO[] getI_poOtherCntrVOs() {
		return i_poOtherCntrVOs;
	}
	/**
	 * @param otherCntrVOs the i_poOtherCntrVOs to set
	 */
	public void setI_poOtherCntrVOs(BkgReferenceVO[] otherCntrVOs) {
		i_poOtherCntrVOs = otherCntrVOs;
	}
	/**
	 * @return the i_poOtherCmVOs
	 */
	public BkgRefDtlVO[] getI_poOtherCmVOs() {
		return i_poOtherCmVOs;
	}
	/**
	 * @param otherCmVOs the i_poOtherCmVOs to set
	 */
	public void setI_poOtherCmVOs(BkgRefDtlVO[] otherCmVOs) {
		i_poOtherCmVOs = otherCmVOs;
	}
	/**
	 * @return the i_poOtherShipVOs
	 */
	public BkgRefDtlVO[] getI_poOtherShipVOs() {
		return i_poOtherShipVOs;
	}
	/**
	 * @param otherShipVOs the i_poOtherShipVOs to set
	 */
	public void setI_poOtherShipVOs(BkgRefDtlVO[] otherShipVOs) {
		i_poOtherShipVOs = otherShipVOs;
	}
	/**
	 * @return the i_poOtherMrnUcrVOs
	 */
	public BkgRefDtlVO[] getI_poOtherMrnUcrVOs() {
		return i_poOtherMrnUcrVOs;
	}
	/**
	 * @param i_poOtherMrnUcrVOs the i_poOtherMrnUcrVOs to set
	 */
	public void setI_poOtherMrnUcrVOs(BkgRefDtlVO[] i_poOtherMrnUcrVOs) {
		this.i_poOtherMrnUcrVOs = i_poOtherMrnUcrVOs;
	}
	
	public String getCntrNoDuplicated() {
		return cntrNoDuplicated;
	}
	public void setCntrNoDuplicated(String cntrNoDuplicated) {
		this.cntrNoDuplicated = cntrNoDuplicated;
	}

	
	
}
