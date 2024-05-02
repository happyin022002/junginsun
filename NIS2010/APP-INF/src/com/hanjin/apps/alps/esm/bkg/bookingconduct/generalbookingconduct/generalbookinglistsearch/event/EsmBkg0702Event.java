/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0702Event.java
*@FileTitle : Booking Receipt Draft BL EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.17 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0702 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0702HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0702HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0702Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private CustTpIdVO[] custTpIdVOs = null;
	private String typeGbn = null;

	public EsmBkg0702Event(){}

	public BkgListFor301310EdiInputVO getBkgListFor301310EdiInputVO() {
		return bkgListFor301310EdiInputVO;
	}

	public void setBkgListFor301310EdiInputVO(
			BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO) {
		this.bkgListFor301310EdiInputVO = bkgListFor301310EdiInputVO;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}

	public CustTpIdVO[] getCustTpIdVOs() {
		return custTpIdVOs;
	}

	public void setCustTpIdVOs(CustTpIdVO[] custTpIdVOs) {
		this.custTpIdVOs = custTpIdVOs;
	}

	public String getTypeGbn() {
		return typeGbn;
	}

	public void setTypeGbn(String typeGbn) {
		this.typeGbn = typeGbn;
	}

}