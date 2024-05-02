/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg036701Event.java
*@FileTitle : esm_bkg_0367_01
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.09 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoBkgVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgRefDtlVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;


/**
 * esm_bkg_0367_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0367_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see esm_bkg_0367_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg036701Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoOtherNoBkgVO	poOtherNoBkgVO	= null;//text

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgReferenceVO[]	poOtherNoBkgVOs	= null;//poOtherCntr sheet0
	private BkgReferenceVO[]	poOtherCntrVOs	= null;//poOtherCntr sheet1
	private BkgRefDtlVO[]	poOtherCmVOs	= null;//poOtherCm sheet2
	private BkgRefDtlVO[]	poOtherShipVOs	= null;//poOtherShip sheet3
	private BkgReferenceVO[]	poOtherLoadingCntrVOs	= null;//poOtherLoadingCntr sheet4
	private boolean isFirst = true; // 최초 조회여부

	/**
	 * @return the poOtherNoBkgVO
	 */
	public PoOtherNoBkgVO getPoOtherNoBkgVO() {
		return poOtherNoBkgVO;
	}
	/**
	 * @param poOtherNoBkgVO the poOtherNoBkgVO to set
	 */
	public void setPoOtherNoBkgVO(PoOtherNoBkgVO poOtherNoBkgVO) {
		this.poOtherNoBkgVO = poOtherNoBkgVO;
	}
	/**
	 * @return the poOtherNoBkgVOs
	 */
	public BkgReferenceVO[] getPoOtherNoBkgVOs() {
		BkgReferenceVO[] rtnVOs = null;
		if (this.poOtherNoBkgVOs != null) {
			rtnVOs = new BkgReferenceVO[poOtherNoBkgVOs.length];
			System.arraycopy(poOtherNoBkgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param poOtherNoBkgVOs the poOtherNoBkgVOs to set
	 */
	public void setPoOtherNoBkgVOs(BkgReferenceVO[] poOtherNoBkgVOs){
		if(poOtherNoBkgVOs != null){
			BkgReferenceVO[] tmpVOs = new BkgReferenceVO[poOtherNoBkgVOs.length];
			System.arraycopy(poOtherNoBkgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.poOtherNoBkgVOs = tmpVOs;
		}
	}
	/**
	 * @return the poOtherCntrVOs
	 */
	public BkgReferenceVO[] getPoOtherCntrVOs() {
		BkgReferenceVO[] rtnVOs = null;
		if (this.poOtherCntrVOs != null) {
			rtnVOs = new BkgReferenceVO[poOtherCntrVOs.length];
			System.arraycopy(poOtherCntrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param poOtherCntrVOs the poOtherCntrVOs to set
	 */
	public void setPoOtherCntrVOs(BkgReferenceVO[] poOtherCntrVOs){
		if(poOtherCntrVOs != null){
			BkgReferenceVO[] tmpVOs = new BkgReferenceVO[poOtherCntrVOs.length];
			System.arraycopy(poOtherCntrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.poOtherCntrVOs = tmpVOs;
		}
	}
	
	
	/**
	 * @return the poOtherLoadingCntrVOs
	 */
	public BkgReferenceVO[] getPoOtherLoadingCntrVOs() {
		BkgReferenceVO[] rtnVOs = null;
		if (this.poOtherLoadingCntrVOs != null) {
			rtnVOs = new BkgReferenceVO[poOtherLoadingCntrVOs.length];
			System.arraycopy(poOtherLoadingCntrVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param poOtherLoadingCntrVOs the poOtherLoadingCntrVOs to set
	 */
	public void setPoOtherLoadingCntrVOs(BkgReferenceVO[] poOtherLoadingCntrVOs){
		if(poOtherLoadingCntrVOs != null){
			BkgReferenceVO[] tmpVOs = new BkgReferenceVO[poOtherLoadingCntrVOs.length];
			System.arraycopy(poOtherLoadingCntrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.poOtherLoadingCntrVOs = tmpVOs;
		}
	}
	
	/**
	 * @return the poOtherCmVOs
	 */
	public BkgRefDtlVO[] getPoOtherCmVOs() {
		BkgRefDtlVO[] rtnVOs = null;
		if (this.poOtherCmVOs != null) {
			rtnVOs = new BkgRefDtlVO[poOtherCmVOs.length];
			System.arraycopy(poOtherCmVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param poOtherCmVOs the poOtherCmVOs to set
	 */
	public void setPoOtherCmVOs(BkgRefDtlVO[] poOtherCmVOs){
		if(poOtherCmVOs != null){
			BkgRefDtlVO[] tmpVOs = new BkgRefDtlVO[poOtherCmVOs.length];
			System.arraycopy(poOtherCmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.poOtherCmVOs = tmpVOs;
		}
	}
	/**
	 * @return the poOtherShipVOs
	 */
	public BkgRefDtlVO[] getPoOtherShipVOs() {
		BkgRefDtlVO[] rtnVOs = null;
		if (this.poOtherShipVOs != null) {
			rtnVOs = new BkgRefDtlVO[poOtherShipVOs.length];
			System.arraycopy(poOtherShipVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param poOtherShipVOs the poOtherShipVOs to set
	 */
	public void setPoOtherShipVOs(BkgRefDtlVO[] poOtherShipVOs){
		if(poOtherShipVOs != null){
			BkgRefDtlVO[] tmpVOs = new BkgRefDtlVO[poOtherShipVOs.length];
			System.arraycopy(poOtherShipVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.poOtherShipVOs = tmpVOs;
		}
	}
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






}