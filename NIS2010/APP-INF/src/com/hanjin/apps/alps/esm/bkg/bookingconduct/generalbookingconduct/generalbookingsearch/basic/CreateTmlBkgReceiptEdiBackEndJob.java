/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CreateTmlBkgReceiptEdiBackEnd.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김병규
 *@LastVersion : 0.1
 * 2009.07.29
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
/**
 * ALPS-CreateTmlBkgReceiptEdi Business Logic Basic Command implementation<br>
 * - ALPS-CreateTmlBkgReceiptEdi에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Byung Kyu
 * @see GeneralBookingSearchBCImpl 클래스 참조
 * @since J2EE 1.6
 */
public class CreateTmlBkgReceiptEdiBackEndJob   extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;

	private Vender301ParamVO vender301ParamVO;
	private SignOnUserAccount account;

	public void setVender301ParamVO(Vender301ParamVO vender301ParamVO) {
		this.vender301ParamVO = vender301ParamVO;
	}
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}	
	
	/**
	 * Terminal EDI (EDI301) 전송 업무 시나리오 선행작업<br>
	 * Terminal EDI (EDI301) 전송 업무 시나리오 호출시 관련 내부객체 생성<br>
	 *
	 * @return Object
	 * @exception Exception
	 */	
	public Object doStart() throws Exception {
		GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl(); 
		
		try{
			List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.createTmlBkgReceiptEdi(vender301ParamVO, account);
			if("Y".equals(vender301ParamVO.getAutoManualFlg())){
				for(int i=0;i<bkgNtcHisVOs.size();i++){
					bkgNtcHisVOs.get(i).setSndId("SYSTEM");					
				}
			}
			historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
		}catch(Exception ex){
			throw new EventException(ex.getMessage(),ex);			
		}
		return null;
	}
}
