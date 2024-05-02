/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalInterface301FullDGApprovalBC.java
*@FileTitle : Common Utility in SCG
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.04
*@LastModifier : TOP
*@LastVersion : 1.0
* 2015.09.04 TOP
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.externalinterface301fulldgapproval.basic;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.clt.apps.opus.vop.scg.scgcommon.externalinterface301fulldgapproval.integration.ExternalInterface301FullDGApprovalDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-SCGCommon Business Logic Basic Command implementation<br>
 * - Handling business transactions of OPUS-SCGCommon<br>
 *
 * @author
 * @see SCG_COM_EventResponse,SCGExternalFinderBC
 * @since J2EE 1.4
 */
public class ExternalInterface301FullDGApprovalBCImpl extends BasicCommandSupport implements ExternalInterface301FullDGApprovalBC {

	// Database Access Object
	private transient ExternalInterface301FullDGApprovalDBDAO dbDao = null;

	/**
	 * SCGExternalFinderBCImpl object creation<br>
	 * SCGExternalFinderDBDAO creation<br>
	 */
	public ExternalInterface301FullDGApprovalBCImpl() {
		dbDao = new ExternalInterface301FullDGApprovalDBDAO();
	}

	/**
	 * Sending 301F through EDI <br>
	 * 
	 * @param SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @exception EventException
	 */
	public boolean interfaceSendEDISpecialCargoApproval(SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO, SignOnUserAccount account) throws EventException {

//		GeneralBookingSearchBC 	bookingBC 			= new GeneralBookingSearchBCImpl();
//		Vender301ParamVO 		vender301ParamVO 	= new Vender301ParamVO			();
		
		BookingUtil 			bookingUtil			= new BookingUtil				();
		GeneralEventResponse	eventResponse		= new GeneralEventResponse		();
		
		try{
           
		/** =================================================================================
		 *  Call BKG method for 301 Terminal EDI when DG approved 
		 *  ---------------------------------------------------------------------------------
		 *  2015-08-27 THR requested by BKG
		 *  =================================================================================
		 */

           // VO parameter 설정을 위한 변수 선언
           BkgBlNoVO 	tmpBkgBlNoVO	= new BkgBlNoVO();
           tmpBkgBlNoVO.setBkgNo		(searchScgAprovalAuthCdVO.getBkgNo());          // Booking Number
           
           
   			/** =================================================================================
   			 *  Call BKG method for 301 Vendor EDI when All special cargo approved 
   			 *  ---------------------------------------------------------------------------------
   			 *  2015-12-11 FRI requested by BKG
   			 *  Method Name				: executeBkgReceiptEdi
   			 *  <PARAMETER LIST>
   			 *	1. GeneralEventResponse	eventResponse
   			 *	2. SignOnUserAccount    account
   			 *	3. String               bkgNo
   			 *	4. String               qtyModifyFlag
   			 *	5. String               hisUiNm
   			 *  =================================================================================
   			 */
   	           
   	        bookingUtil.executeBkgReceiptEdi(eventResponse, account, searchScgAprovalAuthCdVO.getBkgNo(), null, "SCG");
   	        

//			Commented by TOP at MAR04
   	        
//   	        log.info("\n\n ================= TOP.TOP.TOP Sent 301F(VENDOR) EDI for All Region ==================\n");

//   	        boolean isTarget301F			= dbDao.checkEffectivenessForEurope301F(searchScgAprovalAuthCdVO);
//   	        log.info("\n\n ================= TOP.TOP.TOP interface301FullDGApproval result ============= isTarget301F for only Europe ["+isTarget301F+"]");
//           
//   	        if(isTarget301F){
//        	   
//        	   /** =====================================================
//        	    *  <CASE 1>
//        	    *  	POL YARD = O/B FULL RETURN CY	
//        	    * 	'BT' ONLY
//        	    *  -----------------------------------------------------
//        	    *  <CASE 2>
//        	    *  	POL YARD <> O/B FULL RETURN CY
//        	    *   EACH 'BT' & 'FC' for different EDI Message(Yard)
//        	    *  ===================================================== 
//        	    */
//        	   String 	ediKind 		= "BT";		// EDI Kind : BT(301F) - BT:BOOKING TERMINAL, FC:FULL CARGO, CN:EMPTY CONTAINER
//        	   String 	autoManualFlg 	= "N";      // Auto/Manual Flag : N(Manual), Y(Auto)
//
//	           // BKG 메소드 호출을 위한 VO Parameter 설정
//        	   vender301ParamVO.setBkgBlNoVO				(tmpBkgBlNoVO	);               // BKG_NO : 필수
//        	   vender301ParamVO.setEdiKind					(ediKind		);               // EDIKind : 필수
//        	   vender301ParamVO.setAutoManualFlg			(autoManualFlg	);               // autoManualFlag : 필수
//
//        	   //vender301ParamVO.setHisUiNm					("SCG_EUR_DG"	); 
//
//        	   
//	           // BKG쪽 Terminal EDI 발송용 BackEnd 메소드 호출
//        	   bookingBC.createTmlBkgReceiptEdiBackEnd		(vender301ParamVO, account);
//        	   
//	           log.info("\n\n ================= TOP.TOP.TOP Sent 301F(VENDOR) EDI for only Europe ==================");
//	           
//	           /** ================================================================================= **/
//	           
//   	        }
   	        			
//        } catch (DAOException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG CGO Detail"}).getMessage(), ex);
   	        
            
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG CGO Detail"}).getMessage(), ex);
		}
		
		return true;
	}

}