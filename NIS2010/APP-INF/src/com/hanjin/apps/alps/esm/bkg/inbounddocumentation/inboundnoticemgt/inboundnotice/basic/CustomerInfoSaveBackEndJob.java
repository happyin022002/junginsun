/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SendBkgCustEdiMultiBackEndJob.java
*@FileTitle : Charge Filtering
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.19
* 1.0 Creation
* ======================================================================
* History
* 2011.05.27 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.05.31 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.06.01 이일민 소스품질 결함 수정
* 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration business logic handling.<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class CustomerInfoSaveBackEndJob extends BackEndCommandSupport {
 private static final long serialVersionUID = -3034414164961318353L;
 private ArrNtcCustListVO[] arrNtcCustListVOS = null;
 private String pgmNo;
 private SignOnUserAccount account = null;
 /**
  * 0127 setting screen data to be downloaded.<br>
  * 
  * @param ManifestTransmitVO manifestTransmitVO
  */
 public void setArrNtcCustListVOs(ArrNtcCustListVO[] arrNtcCustListVOS){
		if(arrNtcCustListVOS != null){
			ArrNtcCustListVO[] tmpVOs = new ArrNtcCustListVO[arrNtcCustListVOS.length];
			System.arraycopy(arrNtcCustListVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.arrNtcCustListVOS = tmpVOs;
		}
 }
 
 /**
  * @param account the account to set
  */
 public void setAccount(SignOnUserAccount account) {
  this.account = account;
 }

 /**
  * Setting the screen ID<br>
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
 public String doStart() throws Exception {
  
	 ArrivalNoticeBC command = null;
  command = new ArrivalNoticeBCImpl();
//  return command.transmitManifest(manifestTransmitVOs, account);
	 
   command.modifyArrNtcCustList(arrNtcCustListVOS, account);
   
   GeneralBookingReceiptBC cmd1 = new GeneralBookingReceiptBCImpl();
   cmd1.modifyArrNtcCustChgFlg(arrNtcCustListVOS);
   
  return "Y";
 }
}
