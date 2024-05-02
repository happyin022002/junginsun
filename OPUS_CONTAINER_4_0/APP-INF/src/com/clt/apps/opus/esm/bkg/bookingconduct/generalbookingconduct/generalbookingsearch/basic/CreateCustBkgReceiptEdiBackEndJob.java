/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CreateCustBkgReceiptEdiBackEnd.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김병규
 *@LastVersion : 0.1
 * 2009.07.29
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;
/**
 * OPUS-CreateCustBkgReceiptEdi Business Logic Basic Command implementation<br>
 * - OPUS-CreateCustBkgReceiptEdi에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Byung Kyu
 * @see GeneralBookingSearchBCImpl 클래스 참조
 * @since J2EE 1.6
 */
public class CreateCustBkgReceiptEdiBackEndJob  extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -3034414164961318353L;

	private BkgBlNoVO bkgBlNoVO;
	
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	private SignOnUserAccount account;
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}	
	
	/**
	 * Customer EDI (EDI301) 전송 업무 시나리오 선행작업<br>
	 * Customer EDI (EDI301) 전송 업무 시나리오 호출시 관련 내부객체 생성<br>
	 *
	 * @return Object
	 * @exception Exception
	 */	
	public Object doStart() throws Exception {
		GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl(); 
		try{

			List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.createCustBkgReceiptEdi(bkgBlNoVO, null, "Y", account);
			for(int i=0;i<bkgNtcHisVOs.size();i++){
//				bkgNtcHisVOs.get(i).setSndId("SYSTEM");	
				String hisUiNm = getBkgBlNoVO().getHisUiNm() == null ? "" : getBkgBlNoVO().getHisUiNm();
				bkgNtcHisVOs.get(i).setHisUiNm(hisUiNm);
			}
			historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
		}catch(Exception ex){
			throw new EventException(ex.getMessage(),ex);			
		}
		return null;
	}

}
