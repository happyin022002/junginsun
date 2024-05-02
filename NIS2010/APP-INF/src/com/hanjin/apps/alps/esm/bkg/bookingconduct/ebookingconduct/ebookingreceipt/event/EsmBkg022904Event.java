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
* 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;


import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsXptImpLicListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BlRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SearchXterPoMdtItmParmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgClauseLockVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExptInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgRefDtlVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;


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
	private AlpsXptImpLicListVO[] alpsXptImpLicListVOs = null;	
    private XptImpLicVO[] idXptImpLicVOs = null;

	private BkgReferenceVO[] poOtherNoBkgVOs = null;
	private BkgReferenceVO[] poOtherCntrVOs = null;
	private BkgRefDtlVO[] poOtherCmVOs = null;
	private BkgRefDtlVO[] poOtherShipVOs	= null;
	private BlRiderVO[] blRiderVOs = null;
	private KrWhfBlExptInfoVO[] krWhfBlExptInfoVOs = null;
	private SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO = null;
	private BkgClauseLockVO[] bkgClauseLockVOs	= null;
	
	public BkgClauseLockVO[] getBkgClauseLockVOs() {		
		BkgClauseLockVO[] rtnVOs = null;
		if (this.bkgClauseLockVOs != null) {
			rtnVOs = Arrays.copyOf(bkgClauseLockVOs, bkgClauseLockVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgClauseLockVOs(BkgClauseLockVO[] bkgClauseLockVOs) {		
		if(bkgClauseLockVOs != null){
			BkgClauseLockVO[] tmpVOs = Arrays.copyOf(bkgClauseLockVOs, bkgClauseLockVOs.length);
			this.bkgClauseLockVOs = tmpVOs;
		}
	}

	public BkgRefDtlVO[] getPoOtherShipVOs() {
		BkgRefDtlVO[] rtnVOs = null;
		if (this.poOtherShipVOs != null) {
			rtnVOs = Arrays.copyOf(poOtherShipVOs, poOtherShipVOs.length);
		}
		return rtnVOs;
	}

	public void setPoOtherShipVOs(BkgRefDtlVO[] poOtherShipVOs){
		if(poOtherShipVOs != null){
			BkgRefDtlVO[] tmpVOs = Arrays.copyOf(poOtherShipVOs, poOtherShipVOs.length);
			this.poOtherShipVOs = tmpVOs;
		}
	}

	public KrWhfBlExptInfoVO[] getKrWhfBlExptInfoVOs() {
		KrWhfBlExptInfoVO[] rtnVOs = null;
		if (this.krWhfBlExptInfoVOs != null) {
			rtnVOs = Arrays.copyOf(krWhfBlExptInfoVOs, krWhfBlExptInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setKrWhfBlExptInfoVOs(KrWhfBlExptInfoVO[] krWhfBlExptInfoVOs){
		if(krWhfBlExptInfoVOs != null){
			KrWhfBlExptInfoVO[] tmpVOs = Arrays.copyOf(krWhfBlExptInfoVOs, krWhfBlExptInfoVOs.length);
			this.krWhfBlExptInfoVOs = tmpVOs;
		}
	}	
	
	public BlRiderVO[] getBlRiderVOs() {
		BlRiderVO[] rtnVOs = null;
		if (this.blRiderVOs != null) {
			rtnVOs = Arrays.copyOf(blRiderVOs, blRiderVOs.length);
		}
		return rtnVOs;
	}

	public void setBlRiderVOs(BlRiderVO[] blRiderVOs){
		if(blRiderVOs != null){
			BlRiderVO[] tmpVOs = Arrays.copyOf(blRiderVOs, blRiderVOs.length);
			this.blRiderVOs = tmpVOs;
		}
	}

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

	public void setMndVOs(MndVO[] mndVOs){
		if(mndVOs != null){
			MndVO[] tmpVOs = Arrays.copyOf(mndVOs, mndVOs.length);
			this.mndVOs = tmpVOs;
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

	public AlpsXptImpLicListVO[] getAlpsXptImpLicListVOs() {
		AlpsXptImpLicListVO[] rtnVOs = null;
		if (this.alpsXptImpLicListVOs != null) {
			rtnVOs = Arrays.copyOf(alpsXptImpLicListVOs, alpsXptImpLicListVOs.length);
		}
		return rtnVOs;
	}

	public void setAlpsXptImpLicListVOs(AlpsXptImpLicListVO[] alpsXptImpLicListVOs){
		if(alpsXptImpLicListVOs != null){
			AlpsXptImpLicListVO[] tmpVOs = Arrays.copyOf(alpsXptImpLicListVOs, alpsXptImpLicListVOs.length);
			this.alpsXptImpLicListVOs = tmpVOs;
		}
	}

	public BkgReferenceVO[] getPoOtherNoBkgVOs() {
		BkgReferenceVO[] rtnVOs = null;
		if (this.poOtherNoBkgVOs != null) {
			rtnVOs = Arrays.copyOf(poOtherNoBkgVOs, poOtherNoBkgVOs.length);
		}
		return rtnVOs;
	}

	public void setPoOtherNoBkgVOs(BkgReferenceVO[] poOtherNoBkgVOs){
		if(poOtherNoBkgVOs != null){
			BkgReferenceVO[] tmpVOs = Arrays.copyOf(poOtherNoBkgVOs, poOtherNoBkgVOs.length);
			this.poOtherNoBkgVOs = tmpVOs;
		}
	}

	public BkgReferenceVO[] getPoOtherCntrVOs() {
		BkgReferenceVO[] rtnVOs = null;
		if (this.poOtherCntrVOs != null) {
			rtnVOs = Arrays.copyOf(poOtherCntrVOs, poOtherCntrVOs.length);
		}
		return rtnVOs;
	}

	public void setPoOtherCntrVOs(BkgReferenceVO[] poOtherCntrVOs){
		if(poOtherCntrVOs != null){
			BkgReferenceVO[] tmpVOs = Arrays.copyOf(poOtherCntrVOs, poOtherCntrVOs.length);
			this.poOtherCntrVOs = tmpVOs;
		}
	}

	public BkgRefDtlVO[] getPoOtherCmVOs() {
		BkgRefDtlVO[] rtnVOs = null;
		if (this.poOtherCmVOs != null) {
			rtnVOs = Arrays.copyOf(poOtherCmVOs, poOtherCmVOs.length);
		}
		return rtnVOs;
	}

	public void setPoOtherCmVOs(BkgRefDtlVO[] poOtherCmVOs){
		if(poOtherCmVOs != null){
			BkgRefDtlVO[] tmpVOs = Arrays.copyOf(poOtherCmVOs, poOtherCmVOs.length);
			this.poOtherCmVOs = tmpVOs;
		}
	}

	public SearchXterPoMdtItmParmVO getSearchXterPoMdtItmParmVO() {
		return searchXterPoMdtItmParmVO;
	}

	public void setSearchXterPoMdtItmParmVO(
			SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO) {
		this.searchXterPoMdtItmParmVO = searchXterPoMdtItmParmVO;
	}

	public XptImpLicVO[] getIdXptImpLicVOs() {
		XptImpLicVO[] rtnVOs = null;
		if (this.idXptImpLicVOs != null) {
			rtnVOs = Arrays.copyOf(idXptImpLicVOs, idXptImpLicVOs.length);
		}
		return rtnVOs;
	}

	public void setIdXptImpLicVOs(XptImpLicVO[] xptImpLicVOs){
		if(xptImpLicVOs != null){
			XptImpLicVO[] tmpVOs = Arrays.copyOf(xptImpLicVOs, xptImpLicVOs.length);
			this.idXptImpLicVOs = tmpVOs;
		}
	}

}