/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022904Event.java
*@FileTitle : e-Booking & SI Process Detail(M&D)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.16 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;


import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusXptImpLicListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;


/**
 * ESM_BKG_0229_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_04HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022904Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private XterRqstNoVO xterRqstNoVO= null;
	private BkgBlNoVO bkgBlNoVO = null;
    private MndVO mndVO = null;
    private MndVO[] mndVOs = null;
    private String bkgNo = null;
    private String pckTpCd = null;
	private OpusXptImpLicListVO[] opusXptImpLicListVOs = null;	

	private BkgReferenceVO[] poOtherNoBkgVOs = null;
	private BkgReferenceVO[] poOtherCntrVOs = null;
	private BkgRefDtlVO[] poOtherCmVOs = null;
	private BkgRefDtlVO[]  poOtherShipVOs = null;
	
	public EsmBkg022904Event(){}

	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

    public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	
	public MndVO getMndVO() {
		return mndVO;
	}

	public void setMndVO(MndVO mndVO) {
		this.mndVO = mndVO;
	}

	public MndVO[] getMndVOs() {
		MndVO[] rtnVOs = null;
		if (this.mndVOs != null) {
			rtnVOs = Arrays.copyOf(mndVOs, mndVOs.length);
		}
		return rtnVOs;
	}

	public void setMndVOs(MndVO[] mndVOs) {
		if(mndVOs != null){
			MndVO[] tmpVOs = Arrays.copyOf(mndVOs, mndVOs.length);
			this.mndVOs  = tmpVOs;
		}
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getPckTpCd() {
		return pckTpCd;
	}

	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}

	public OpusXptImpLicListVO[] getOpusXptImpLicListVOs() {
		OpusXptImpLicListVO[] rtnVOs = null;
		if (this.opusXptImpLicListVOs != null) {
			rtnVOs = Arrays.copyOf(opusXptImpLicListVOs, opusXptImpLicListVOs.length);
		}
		return rtnVOs;
	}

	public void setOpusXptImpLicListVOs(OpusXptImpLicListVO[] opusXptImpLicListVOs) {
		if(opusXptImpLicListVOs != null){
			OpusXptImpLicListVO[] tmpVOs = Arrays.copyOf(opusXptImpLicListVOs, opusXptImpLicListVOs.length);
			this.opusXptImpLicListVOs  = tmpVOs;
		}
	}

	public BkgReferenceVO[] getPoOtherNoBkgVOs() {
		BkgReferenceVO[] rtnVOs = null;
		if (this.poOtherNoBkgVOs != null) {
			rtnVOs = Arrays.copyOf(poOtherNoBkgVOs, poOtherNoBkgVOs.length);
		}
		return rtnVOs;
	}

	public void setPoOtherNoBkgVOs(BkgReferenceVO[] poOtherNoBkgVOs) {
		if(poOtherNoBkgVOs != null){
			BkgReferenceVO[] tmpVOs = Arrays.copyOf(poOtherNoBkgVOs, poOtherNoBkgVOs.length);
			this.poOtherNoBkgVOs  = tmpVOs;
		}
	}

	public BkgReferenceVO[] getPoOtherCntrVOs() {
		BkgReferenceVO[] rtnVOs = null;
		if (this.poOtherCntrVOs != null) {
			rtnVOs = Arrays.copyOf(poOtherCntrVOs, poOtherCntrVOs.length);
		}
		return rtnVOs;
	}

	public void setPoOtherCntrVOs(BkgReferenceVO[] poOtherCntrVOs) {
		if(poOtherCntrVOs != null){
			BkgReferenceVO[] tmpVOs = Arrays.copyOf(poOtherCntrVOs, poOtherCntrVOs.length);
			this.poOtherCntrVOs  = tmpVOs;
		}
	}

	public BkgRefDtlVO[] getPoOtherCmVOs() {
		BkgRefDtlVO[] rtnVOs = null;
		if (this.poOtherCmVOs != null) {
			rtnVOs = Arrays.copyOf(poOtherCmVOs, poOtherCmVOs.length);
		}
		return rtnVOs;
	}

	public void setPoOtherCmVOs(BkgRefDtlVO[] poOtherCmVOs) {
		if(poOtherCmVOs != null){
			BkgRefDtlVO[] tmpVOs = Arrays.copyOf(poOtherCmVOs, poOtherCmVOs.length);
			this.poOtherCmVOs  = tmpVOs;
		}
	}

	public BkgRefDtlVO[] getPoOtherShipVOs() {
		BkgRefDtlVO[] rtnVOs = null;
		if (this.poOtherShipVOs != null) {
			rtnVOs = Arrays.copyOf(poOtherShipVOs, poOtherShipVOs.length);
		}
		return rtnVOs;
	}

	public void setPoOtherShipVOs(BkgRefDtlVO[] poOtherShipVOs) {
		if(poOtherShipVOs != null){
			BkgRefDtlVO[] tmpVOs = Arrays.copyOf(poOtherShipVOs, poOtherShipVOs.length);
			this.poOtherShipVOs  = tmpVOs;
		}
	}

}