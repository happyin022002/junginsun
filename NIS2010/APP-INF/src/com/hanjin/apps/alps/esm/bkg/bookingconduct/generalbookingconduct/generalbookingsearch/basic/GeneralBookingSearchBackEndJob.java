/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchBackEndJob.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.17
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.09.17 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcUploadVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CreateCustBkgReceiptEdi Business Logic Basic Command implementation<br>
 * - ALPS-CreateCustBkgReceiptEdi에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author BOBAE KIM
 * @see GeneralBookingSearchBCImpl 클래스 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchBackEndJob  extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -3034414164961318353L;
	private BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO = null;
	private BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs = null;
	private String pgmNo;
	private SignOnUserAccount account = null;

	

	public void setBkgCustAvcNtcSchVO(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) {
		this.bkgCustAvcNtcSchVO = bkgCustAvcNtcSchVO;
	}
	
	public void setBkgCustAvcNtcUploadVOs(BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs) {
		this.bkgCustAvcNtcUploadVOs = bkgCustAvcNtcUploadVOs;
	}
	
	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}


	/**
	 * 화면ID세팅<br>
	 * 
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * BackEndCommand Start<br>
	 * 
	 * @return Object
	 */
	public Object doStart() throws Exception {
		
		GeneralBookingSearchBC command = null;
		if (pgmNo.startsWith("ESM_BKG_0003") ) {
			command = new GeneralBookingSearchBCImpl();
			command.createCustAdvisoryNoticeListByUpload(bkgCustAvcNtcSchVO, bkgCustAvcNtcUploadVOs, account);
		} else if (pgmNo.startsWith("BST_DOWNLOAD") ) {
			command = new GeneralBookingSearchBCImpl();
			command.manageCustAdvisoryNoticeListByBSTDownload(bkgCustAvcNtcSchVO, account);
		}
		
		return null;
	}

	

}
