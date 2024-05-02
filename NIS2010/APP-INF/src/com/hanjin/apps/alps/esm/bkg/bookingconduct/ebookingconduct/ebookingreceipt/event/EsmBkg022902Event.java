/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022902Event.java
*@FileTitle : e-Booking & S/I Detail (Customer)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.08 전용진
* 1.0 Creation
* 
 * ------------------------------------------------------
 * HISTORY
 * 2010.11.26 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2013.02.06 이재위 [CHM-201322717-01] IKEA Booking Upload시 Key Data Check 로직 추가요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.OfcChgProcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SearchXterPoMdtItmParmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0229_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_02HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022902Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private XterRqstNoVO xterRqstNoVO= null;
	private BkgBlNoVO bkgBlNoVO = null;
	private BlDocCustVO[] blDocCustVOs = null;
	private BlDocCustVO blDocCustVO = null;
	private CustEtcVO[] custEtcVOs = null;
	private CustEtcVO custEtcVO = null;
	private OfcChgProcVO ofcChgProcVO = null;
	private SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO = null;
	
	public EsmBkg022902Event(){}

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


	public BlDocCustVO[] getBlDocCustVOs() {
		BlDocCustVO[] rtnVOs = null;
		if (this.blDocCustVOs != null) {
			rtnVOs = Arrays.copyOf(blDocCustVOs, blDocCustVOs.length);
		}
		return rtnVOs;
	}

	public void setBlDocCustVOs(BlDocCustVO[] blDocCustVOs){
		if(blDocCustVOs != null){
			BlDocCustVO[] tmpVOs = Arrays.copyOf(blDocCustVOs, blDocCustVOs.length);
			this.blDocCustVOs = tmpVOs;
		}
	}

	public BlDocCustVO getBlDocCustVO() {
		return blDocCustVO;
	}

	public void setBlDocCustVO(BlDocCustVO blDocCustVO) {
		this.blDocCustVO = blDocCustVO;
	}
	
	public SearchXterPoMdtItmParmVO getSearchXterPoMdtItmParmVO() {
		return searchXterPoMdtItmParmVO;
	}
	
	public void setSearchXterPoMdtItmParmVO(SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO) {
		this.searchXterPoMdtItmParmVO = searchXterPoMdtItmParmVO;
	}

	public CustEtcVO[] getCustEtcVOs() {
		CustEtcVO[] rtnVOs = null;
		if (this.custEtcVOs != null) {
			rtnVOs = Arrays.copyOf(custEtcVOs, custEtcVOs.length);
		}
		return rtnVOs;
	}

	public void setCustEtcVOs(CustEtcVO[] custEtcVOs){
		if(custEtcVOs != null){
			CustEtcVO[] tmpVOs = Arrays.copyOf(custEtcVOs, custEtcVOs.length);
			this.custEtcVOs = tmpVOs;
		}
	}

	public CustEtcVO getCustEtcVO() {
		return custEtcVO;
	}

	public void setCustEtcVO(CustEtcVO custEtcVO) {
		this.custEtcVO = custEtcVO;
	}

	public OfcChgProcVO getOfcChgProcVO() {
		return ofcChgProcVO;
	}

	public void setOfcChgProcVO(OfcChgProcVO ofcChgProcVO) {
		this.ofcChgProcVO = ofcChgProcVO;
	}

}
