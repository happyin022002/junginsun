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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;

/**
 * Booking Receipt Notice 에서 Customer에 관련된 EDI 전송에 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sun-Woo, Ryu
 * @see GeneralBookingReceiptBCImpl
 * @since J2EE 1.6
 */
public class SendBkgCustEdiMultiBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = -7147503316917675691L;
	private BkgBlNoVO[] bkgBlNoVO;
	private CustTpIdVO[] custTpIdVO;
	private String typeGbn;
	private SignOnUserAccount account;

	/**
	 * SendBkgCustEdiMultiBackEndJob 생성자<br>
	 * 
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param CustTpIdVO[] custTpIdVO
	 * @param String typeGbn
	 * @param SignOnUserAccount account
	 * @exception Exception
	 */
	public SendBkgCustEdiMultiBackEndJob(BkgBlNoVO[] bkgBlNoVO, CustTpIdVO[] custTpIdVO, String typeGbn, SignOnUserAccount account) throws Exception {
		this.bkgBlNoVO = bkgBlNoVO;
		this.custTpIdVO = custTpIdVO;
		this.typeGbn = typeGbn;
		this.account = account;
	}

	/**
	 * Self Audit 리스트를 조회한다. <br>
	 *  
	 * @return String
	 * @exception Exception
	 */
	public String doStart() throws Exception {
		try {
			return procBackEndJob();
		} catch(Exception e) {
			throw e;
		}
	}

	/**
	 * Self Audit 리스트를 조회한다. <br>
	 *  
	 * @return String
	 */
	private String procBackEndJob() {
		long startTime = System.currentTimeMillis();
		BLIssuanceBC bLIssuanceBC = null;
		BookingHistoryMgtBC histCmd = null;
		DblEdiInVO dblEdiInVO = null;
		DblEdiVO dblEdiVo = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		BkgNtcHisVO bkgNtcHisVO = null;
		GeneralBookingReceiptBC rcpCmd = null;
		String curBkgNo = null;
		try {
			bLIssuanceBC = new BLIssuanceBCImpl();
			rcpCmd = new GeneralBookingReceiptBCImpl();
			if (0 < bkgBlNoVO.length) {
				for (int i=0;i<bkgBlNoVO.length;i++) {
					if (System.currentTimeMillis() - startTime > 570000) {  //9분30초
						return "N";
					}
					if (("ALL".equals(typeGbn) && "BKG Conf.".equals(bkgBlNoVO[i].getDocType())) ||"B".equals(typeGbn)) {
						curBkgNo = bkgBlNoVO[i].getBkgNo();
						this.sendBkgCustEdi(bkgBlNoVO[i], custTpIdVO[i], "N");
					} else if (("ALL".equals(typeGbn) && "Draft B/L".equals(bkgBlNoVO[i].getDocType())) ||"D".equals(typeGbn)) {
						curBkgNo = bkgBlNoVO[i].getBkgNo();
						dblEdiInVO = new DblEdiInVO();
						dblEdiInVO.setBkgNo(bkgBlNoVO[i].getBkgNo());
						dblEdiInVO.setEdiReceiveId(custTpIdVO[i].getRcvId());
			        	if (!"".equals(custTpIdVO[i].getRcvId())) {
			        		dblEdiVo = bLIssuanceBC.createDraftBlEdi(dblEdiInVO, account);
							bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
							// History
							for (int j=0; j<dblEdiVo.getFlatFileAckVOs().size(); j++) {
								bkgNtcHisVO = new BkgNtcHisVO();
								bkgNtcHisVO.setBkgNo(bkgBlNoVO[i].getBkgNo());
								bkgNtcHisVO.setHisSeq(String.valueOf(j+1).toString());
								bkgNtcHisVO.setNtcViaCd("E");
								bkgNtcHisVO.setNtcKndCd("BL");
								bkgNtcHisVO.setEdiId(custTpIdVO[i].getRcvId());
								bkgNtcHisVO.setEsvcGrpCd(custTpIdVO[i].getGroupId());
								bkgNtcHisVO.setFltFileRefNo(dblEdiVo.getFlatFileAckVOs().get(j).getFltFileRefNo());
								bkgNtcHisVO.setBkgNtcSndRsltCd(dblEdiVo.getFlatFileAckVOs().get(j).getAckStsCd());
								bkgNtcHisVO.setSndUsrId(account.getUsr_id());
								bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
								bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
								bkgNtcHisVO.setCreUsrId(account.getUsr_id());
								bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
								bkgNtcHisVOs.add(bkgNtcHisVO);
							}
							if (null!=bkgNtcHisVOs && 0<bkgNtcHisVOs.size()) {
								histCmd = new BookingHistoryMgtBCImpl();
								histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0702");
							}
			    			if (Constants.SAMF_LIST.contains(custTpIdVO[i].getRcvId())) {
								BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
								bkgReferenceVO.setBkgNo(bkgBlNoVO[i].getBkgNo());
								bkgReferenceVO.setBkgRefTpCd("SAMF");						
								bkgReferenceVO.setCustRefNoCtnt(dblEdiVo.getDblEdiSamf());
								rcpCmd.manageRefNo(new BkgReferenceVO[]{bkgReferenceVO}, account, bkgBlNoVO[i]);
							}
			        	}
					}
				}
			}
		} catch(Exception ex) {
			log.error(ex.getMessage()); // 2011.07.14
			return "[Fail] "+curBkgNo+"\n\n-------------------\n"+(ex.getMessage());
		}
		return "Y";
	}

	/**
	 * Customer정보를 Flat File로 생성하여 EDI로 전송한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param CustTpIdVO custTpIdVO
	 * @param String autoManualFlg
	 * @return EventResponse
	 * @exception EventException
	 */
	private void sendBkgCustEdi(BkgBlNoVO bkgBlNoVO, CustTpIdVO custTpIdVO, String autoManualFlg) throws EventException {
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		try {
			if (bkgBlNoVO != null) {
				List<BkgNtcHisVO> bkgNtcHisVOs = command.createCustBkgReceiptEdi(bkgBlNoVO, custTpIdVO, autoManualFlg, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "");
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
	}

}
