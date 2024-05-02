/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1187Event.java
*@FileTitle : VERMAS Transmit to Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgListForTmlVermasEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.FwrdRefVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1187 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1187HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_1187HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1187Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgListForTmlVermasEdiInputVO bkgListForTmlVermasEdiInputVO = null;
	private String typeGbn = null;
	private String bracCd = null;

	/** Table Value Object Multi Data 처리 */
	private FwrdRefVvdVO[] fwrdRefVvdVOs = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private CustTpIdVO[] custTpIdVOs = null;

	public EsmBkg1187Event(){}

	public BkgListForTmlVermasEdiInputVO getBkgListForTmlVermasEdiInputVO() {
		return bkgListForTmlVermasEdiInputVO;
	}

	public void setBkgListForTmlVermasEdiInputVO(
			BkgListForTmlVermasEdiInputVO bkgListForTmlVermasEdiInputVO) {
		this.bkgListForTmlVermasEdiInputVO = bkgListForTmlVermasEdiInputVO;
	}

	public FwrdRefVvdVO[] getFwrdRefVvdVOs() {
		FwrdRefVvdVO[] rtnVOs = null;
		if (this.fwrdRefVvdVOs != null) {
			rtnVOs = new FwrdRefVvdVO[fwrdRefVvdVOs.length];
			System.arraycopy(fwrdRefVvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setFwrdRefVvdVOs(FwrdRefVvdVO[] fwrdRefVvdVOs){
		if(fwrdRefVvdVOs != null){
			FwrdRefVvdVO[] tmpVOs = new FwrdRefVvdVO[fwrdRefVvdVOs.length];
			System.arraycopy(fwrdRefVvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fwrdRefVvdVOs = tmpVOs;
		}
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] rtnVOs = null;
		if (this.bkgBlNoVOs != null) {
			rtnVOs = new BkgBlNoVO[bkgBlNoVOs.length];
			System.arraycopy(bkgBlNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs){
		if(bkgBlNoVOs != null){
			BkgBlNoVO[] tmpVOs = new BkgBlNoVO[bkgBlNoVOs.length];
			System.arraycopy(bkgBlNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgBlNoVOs = tmpVOs;
		}
	}

	public String getTypeGbn() {
		return typeGbn;
	}

	public void setTypeGbn(String typeGbn) {
		this.typeGbn = typeGbn;
	}

	public CustTpIdVO[] getCustTpIdVOs() {
		CustTpIdVO[] rtnVOs = null;
		if (this.custTpIdVOs != null) {
			rtnVOs = new CustTpIdVO[custTpIdVOs.length];
			System.arraycopy(custTpIdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setCustTpIdVOs(CustTpIdVO[] custTpIdVOs){
		if(custTpIdVOs != null){
			CustTpIdVO[] tmpVOs = new CustTpIdVO[custTpIdVOs.length];
			System.arraycopy(custTpIdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.custTpIdVOs = tmpVOs;
		}
	}

	public String getBracCd() {
		return bracCd;
	}

	public void setBracCd(String bracCd) {
		this.bracCd = bracCd;
	}

}