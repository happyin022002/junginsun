/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0250HTMLAction.java
*@FileTitle : Booking History (B/L Data)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.04 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0250 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0250HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0250HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0250Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	//private CntrInfoForEmptyVO cntrInfoForEmptyVO = null;
	private BkgBlNoVO bkgBlNoVO = null;
	private SIWebServiceVO sIWebServiceVO = null; 
	/** Table Value Object Multi Data 처리 */
	//private CntrInfoForEmptyVO[] cntrInfoForEmptyVOs = null;

	public EsmBkg0250Event(){}

	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	
	public SIWebServiceVO getSIWebServiceVO() {
		return sIWebServiceVO;
	}

	public void setSIWebServiceVO(SIWebServiceVO sIWebServiceVO) {
		this.sIWebServiceVO = sIWebServiceVO;
	}
	
}