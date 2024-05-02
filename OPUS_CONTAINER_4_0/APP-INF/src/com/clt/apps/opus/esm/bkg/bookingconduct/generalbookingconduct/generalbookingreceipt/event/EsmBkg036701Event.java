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
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoBkgVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;


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
	private BkgRefDtlVO[]	poOtherMrnUcrVOs	= null;//poOtherMrnUcrVOs sheet3
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
		BkgReferenceVO[] tmpVOs = null;
		if (this. poOtherNoBkgVOs != null) {
			tmpVOs = Arrays.copyOf(poOtherNoBkgVOs, poOtherNoBkgVOs .length);
		}
		return tmpVOs;
	}
	/**
	 * @param poOtherNoBkgVOs the poOtherNoBkgVOs to set
	 */
	public void setPoOtherNoBkgVOs(BkgReferenceVO[] poOtherNoBkgVOs) {
		if (poOtherNoBkgVOs != null) {
			BkgReferenceVO[] tmpVOs = Arrays.copyOf(poOtherNoBkgVOs, poOtherNoBkgVOs .length);
			this. poOtherNoBkgVOs = tmpVOs;
		}
	}
	/**
	 * @return the poOtherCntrVOs
	 */
	public BkgReferenceVO[] getPoOtherCntrVOs() {
		BkgReferenceVO[] tmpVOs = null;
		if (this. poOtherCntrVOs != null) {
			tmpVOs = Arrays.copyOf(poOtherCntrVOs, poOtherCntrVOs .length);
		}
		return tmpVOs;
	}
	/**
	 * @param poOtherCntrVOs the poOtherCntrVOs to set
	 */
	public void setPoOtherCntrVOs(BkgReferenceVO[] poOtherCntrVOs) {
		if (poOtherCntrVOs != null) {
			BkgReferenceVO[] tmpVOs = Arrays.copyOf(poOtherCntrVOs, poOtherCntrVOs .length);
			this. poOtherCntrVOs = tmpVOs;
		}
	}
	/**
	 * @return the poOtherCmVOs
	 */
	public BkgRefDtlVO[] getPoOtherCmVOs() {
		BkgRefDtlVO[] tmpVOs = null;
		if (this. poOtherCmVOs != null) {
			tmpVOs = Arrays.copyOf(poOtherCmVOs, poOtherCmVOs .length);
		}
		return tmpVOs;
	}
	/**
	 * @param poOtherCmVOs the poOtherCmVOs to set
	 */
	public void setPoOtherCmVOs(BkgRefDtlVO[] poOtherCmVOs) {
		if (poOtherCmVOs != null) {
			BkgRefDtlVO[] tmpVOs = Arrays.copyOf(poOtherCmVOs, poOtherCmVOs .length);
			this. poOtherCmVOs = tmpVOs;
		}
	}
	/**
	 * @return the poOtherShipVOs
	 */
	public BkgRefDtlVO[] getPoOtherShipVOs() {
		BkgRefDtlVO[] tmpVOs = null;
		if (this. poOtherShipVOs != null) {
			tmpVOs = Arrays.copyOf(poOtherShipVOs, poOtherShipVOs .length);
		}
		return tmpVOs;
	}
	/**
	 * @param poOtherShipVOs the poOtherShipVOs to set
	 */
	public void setPoOtherShipVOs(BkgRefDtlVO[] poOtherShipVOs) {
		if (poOtherShipVOs != null) {
			BkgRefDtlVO[] tmpVOs = Arrays.copyOf(poOtherShipVOs, poOtherShipVOs .length);
			this. poOtherShipVOs = tmpVOs;
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
	/**
	 * @return the poOtherMrnUcrVOs
	 */
	public BkgRefDtlVO[] getPoOtherMrnUcrVOs() {
		BkgRefDtlVO[] tmpVOs = null;
		if (this. poOtherMrnUcrVOs != null) {
			tmpVOs = Arrays.copyOf(poOtherMrnUcrVOs, poOtherMrnUcrVOs .length);
		}
		return tmpVOs;
	}
	/**
	 * @param poOtherMrnUcrVOs the poOtherMrnUcrVOs to set
	 */
	public void setPoOtherMrnUcrVOs(BkgRefDtlVO[] poOtherMrnUcrVOs) {
		if (poOtherMrnUcrVOs != null) {
			BkgRefDtlVO[] tmpVOs = Arrays.copyOf(poOtherMrnUcrVOs, poOtherMrnUcrVOs .length);
			this. poOtherMrnUcrVOs = tmpVOs;
		}
	}

}