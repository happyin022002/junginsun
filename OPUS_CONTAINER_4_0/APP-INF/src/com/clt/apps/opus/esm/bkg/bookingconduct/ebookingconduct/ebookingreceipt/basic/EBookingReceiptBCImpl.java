/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptBCImpl.java
*@FileTitle : e-Booking n SI Process
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.21 전용진
* 1.0 Creation
* ------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [CHM-201005975-01] SEANACCS ACL 변경 요청 (E-BKG&SI & DPCS 관련) - EDI로 들어온 Data가 처리되었는지 Validation 추가 요청
* 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청
* 2011.01.04 김영철 [CHM-201007416-01] E-BKG & SI CM Tab 수정 요청 (구주 24HR Rule 관련)
* 2011.01.11 이일민 [] 1월 6일자 R4J 관련 수정
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0902Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration.EBookingReceiptDBDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration.EBookingReceiptEAIDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterRevMsgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.CodecoEdiForVgmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.DgRiderCntrListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstAkVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstDgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl1VO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl2VO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstMndVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstRfVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiDescVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiDgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiInstrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiRefVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RerouteOfcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RerouteUserIdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RjctSndrRcvrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCmShipmentVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterDgRiderVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterInnerPackageVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherShipVO;
import com.clt.apps.opus.esm.bkg.common.VermasMapping;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgVgmWgtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgXterSrchSetVO;

/**
 * OPUS-EBookingConduct Business Logic Basic Command implementation<br>
 * - OPUS-EBookingConduct business logic handling.<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0228EventResponse,EBookingReceiptBC each DAO class reference
 * @since J2EE 1.4
 */
public class EBookingReceiptBCImpl extends BasicCommandSupport implements EBookingReceiptBC {
 
	// Database Access Object
	private transient EBookingReceiptDBDAO dbDao = null;
	// EAI Access Object
	private transient EBookingReceiptEAIDAO eaiDao = null;

	/**
	 * EBookingReceiptBCImpl object creation<br>
	 * EBookingReceiptDBDAO creation.<br>
	 */
	public EBookingReceiptBCImpl() { 
		dbDao = new EBookingReceiptDBDAO();
		eaiDao = new EBookingReceiptEAIDAO();
	}
    /**
	 * continent code retrieve.<br>
     *
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchComboMdmConti() throws EventException {
        try {
            return dbDao.searchComboMdmConti();
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    }
	/**
	 * External Request data insert<br>
	 *
	 * @param String rcvMsg
	 * @return XterRqstNoVO
	 * @exception EventException
	 */
	public XterRqstNoVO receiptXterRqst(String rcvMsg) throws EventException {		
		XterRqstNoVO rqstNoVo = new XterRqstNoVO();
		try {			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("XTER_BKG_RECEIPT");
	        List<BkgHrdCdgCtntVO> hrdCdgList = searchHardCoding(bkgHrdCdgCtntListCondVO);
	        List<BkgHrdCdgCtntVO> hrdTableList = new ArrayList<BkgHrdCdgCtntVO>();
	        List<XterRqstVO> rqstVoList = new ArrayList<XterRqstVO>();

	        boolean isNewTable = true;
	        String[] rcvMsgS = splitString(rcvMsg, '\n');
	        	        
			String[] splitRcvMsg = null;

			String oldTable = "";
			String newTable = "";
			int cnt = 0;

			// insert
			String xterRqstNo = "";
			String xterSndrId = "";
			String ffRefNo = "";
			String xterBkgNo = "";
			String xterSiNo = "";
			// condition
			String xterBiTpCd = "";
			String xterRqstViaCd = "";
			String xterDocTpCd = "";
			//SEANACCS VSL_CD retrieve
			String xterCallSgnNo = "";
			String xterSkdVoyNo = "";
			String xterSkdDirCd = "";
			
			// BKG_XTER_CNTR_MK_DESC
			String bkgXterCntrMkDescFlag = "N";
									 
			for(int i=0;i<rcvMsgS.length;i++) {
				
				rcvMsgS[i] = remove(rcvMsgS[i], '\n');
				rcvMsgS[i] = remove(rcvMsgS[i], '\r');
				
				if(isNull(rcvMsgS[i].trim())){
					continue;
				}				
				if(0==i && rcvMsgS[i].length() > 62){
					ffRefNo = rcvMsgS[i].substring(62);
					continue;
				}
				
				if (isNewTable && "{".equals(rcvMsgS[i].substring(0, 1))) {
					newTable = rcvMsgS[i].substring(1, rcvMsgS[i].length());
					hrdTableList = searchHardCodingTableList(hrdCdgList, newTable);
					isNewTable = false;

//					for(int k=0;k<hrdTableList.size();k++){
//						log.debug(hrdTableList.get(k).getAttrCtnt2() 
//								+":"+ hrdTableList.get(k).getAttrCtnt3() 
//								+":"+ hrdTableList.get(k).getAttrCtnt4());
//					}
					if (!newTable.equals(oldTable)) {
						cnt = 0;
					} else if (newTable.equals(oldTable)) {
						cnt++;
					}

				} else if ("}".equals(rcvMsgS[i].substring(0, 1))) {
					isNewTable = true;
					oldTable = rcvMsgS[i].substring(1, rcvMsgS[i].length());
				}

				// Column, Value 								
				if (rcvMsgS[i].indexOf(":") > 0) {
					splitRcvMsg = splitByToken(rcvMsgS[i], ":");
				}
				
				// Column Mapping
	        	if ( !"{".equals(rcvMsgS[i].substring(0, 1)) && !"}".equals(rcvMsgS[i].substring(0, 1)) ) {
					for (int j=0;j<hrdTableList.size();j++) {
			        	BkgHrdCdgCtntVO hrdCdg = (BkgHrdCdgCtntVO) hrdTableList.get(j);		        		
		        		if (hrdCdg.getAttrCtnt2().equals(splitRcvMsg[0])) {
		        			log.debug("rcvMsgS[i] :"+rcvMsgS[i] + " / splitRcvMsg[0]:" + splitRcvMsg[0] + " / splitRcvMsg[1]:" + splitRcvMsg[1]);
		        			if ( "IB_IE_IND".equals(splitRcvMsg[0]) ) {
		        				if ( "I".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "INT";
		        				else if ( "W".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "WEB";
		        				else if ( "E".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "EDI";
		        				else if ( "C".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "CSM";
		        				else if ( "G".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "GTN";
		        				else if ( "P".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "DSK";
		        				else if ( "D".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "DAK";
		        				else if ( "S".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "SEA";
		        				else if ( "X".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "SIM";
		        				else splitRcvMsg[1] = "EDI";
		        				xterRqstViaCd = splitRcvMsg[1];
		        			} else if ( "IB_TP".equals(splitRcvMsg[0]) ) {
		        				xterBiTpCd = splitRcvMsg[1];
		        			} else if ( "IB_MSG_FLAG".equals(splitRcvMsg[0]) ) {
		        				xterDocTpCd = splitRcvMsg[1];
		        			} else if ( "IB_NO".equals(splitRcvMsg[0]) ) {
		        				xterRqstNo = splitRcvMsg[1];
		        			} else if ( "IB_SI_NO".equals(splitRcvMsg[0]) ) {
		        				xterSiNo = splitRcvMsg[1];
		        			} else if ( "IB_EDI_ID".equals(splitRcvMsg[0]) ) {
		        				xterSndrId = splitRcvMsg[1];
			        			if(xterSndrId.equals("DAKOSY")){
			        				xterRqstViaCd = "DAK";
			        			}
		        			} else if ( "IB_BKG_NO".equals(splitRcvMsg[0]) ) {
		        				xterBkgNo = splitRcvMsg[1];
		        			} else if ( "IB_SKD_VOYAGE_NO".equals(splitRcvMsg[0]) ) {
		        				xterSkdVoyNo = splitRcvMsg[1];
		        			} else if ( "IB_SKD_DIR_CD".equals(splitRcvMsg[0]) ) {
		        				xterSkdDirCd = splitRcvMsg[1];
		        			} else if ( "IB_VSL_CD".equals(splitRcvMsg[0]) ) {
		        				xterCallSgnNo = splitRcvMsg[1];
		        			}		        			

		        			XterRqstVO rqstVo = new XterRqstVO();
		        			rqstVo.setColumnNm(hrdCdg.getAttrCtnt4());
		        			rqstVo.setColumnType(hrdCdg.getAttrCtnt5());
		        			rqstVo.setInputValue(splitRcvMsg[1]);
		        			rqstVo.setSeq( (("N".equals(bkgXterCntrMkDescFlag) && "IBD_DESC".equals(splitRcvMsg[0])) || "IBM_MARK".equals(splitRcvMsg[0]) || "IBEM_MISC".equals(splitRcvMsg[0]))?"0":String.valueOf(cnt) );
		        			rqstVo.setTableNm(hrdCdg.getAttrCtnt3());
		        			rqstVoList.add(rqstVo);
		        		}
		        	}
				} else {
					if ( 15 == rcvMsgS[i].length()) {
						if ( "{I_CM_MARK_DESC".equals(rcvMsgS[i].substring(0, 15)) ) {
							bkgXterCntrMkDescFlag = "Y";
						} else if ( "}I_CM_MARK_DESC".equals(rcvMsgS[i].substring(0, 15)) ) {
							bkgXterCntrMkDescFlag = "N";
						}
					}
				}
			}
			
			//IB_MSG_FLAG가 S 이고 IB_TP이 trim 해서 값이 없으면 -> 'O' 2015.10.05 임재관수석 요청 
			if ("S".equals(xterDocTpCd) && ("".equals(xterBiTpCd.trim()) || xterBiTpCd.trim() == null)) {
				for (int x=0; x < rqstVoList.size(); x++ ) {
					if ("XTER_BL_TP_CD".equals(rqstVoList.get(x).getColumnNm())) {
						rqstVoList.get(x).setInputValue("O");
					}
				}
			}

			rqstNoVo.setRqstNo(xterRqstNo);
			rqstNoVo.setSenderId(xterSndrId);
			if ( !"".equals(xterBkgNo) && xterBkgNo.length() > 13 ) {
				/* NYKS or NYKA 값이 존재하면 해당문자열을 제거 한다. */
				if(xterBkgNo.indexOf("NYKS") > -1 || xterBkgNo.indexOf("NYKA") > -1){
					xterBkgNo = xterBkgNo.substring(4, xterBkgNo.length());
				}
				
				if ( StringUtils.containsNone(xterBkgNo.substring(xterBkgNo.length()-2, xterBkgNo.length()-1), "0123456789") ) {
					xterBkgNo = xterBkgNo.substring(0, xterBkgNo.length()-2);
				}
				
				if ( xterBkgNo.length() > 12 ) {
					xterBkgNo = xterBkgNo.substring(0, 12);
				}
			}
			rqstNoVo.setBkgNo(xterBkgNo);
			//  Columns, Value mapping
			if ( !"E".equals(xterDocTpCd) || "".equals(xterDocTpCd) ) {
				String[][] val_BKG_XTER_RQST_MST = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_RQST_MST");
				val_BKG_XTER_RQST_MST = concateDescValue(val_BKG_XTER_RQST_MST);
				String[][] val_BKG_XTER_RQST_MISC = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_RQST_MISC");
				String[][] val_BKG_XTER_INSTR = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_INSTR");
				String[][] val_BKG_XTER_RQST_CNG = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_RQST_CNG");
				String[][] val_BKG_XTER_CNTR = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_CNTR");
				String[][] val_BKG_XTER_CNTR_SEAL_NO = searchCntrSealNoList(rcvMsgS, hrdCdgList, val_BKG_XTER_CNTR);
				String[][] val_BKG_XTER_CUST = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_CUST");
				String[][] val_BKG_XTER_XPT_LIC_NO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_XPT_LIC_NO");
				String[][] val_BKG_XTER_QTY = searchXterQtyList(rcvMsgS, hrdCdgList);
				String[][] val_BKG_XTER_DG_CGO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_DG_CGO");
				String[][] val_BKG_XTER_AWK_CGO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_AWK_CGO");
				String[][] val_BKG_XTER_RF_CGO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_RF_CGO");
				String[][] val_BKG_XTER_CNTR_MK_DESC = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_CNTR_MK_DESC");
				String[][] val_BKG_XTER_TRO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_TRO");
				String[][] val_BKG_XTER_TRO_DTL = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_TRO_DTL");
				String[][] val_BKG_XTER_AES = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_AES");
				String[][] val_BKG_XTER_TMP_BL_MK_DESC = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_TMP_BL_MK_DESC");
				String[][] val_BKG_XTER_REF = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_REF");
				String[][] val_BKG_XTER_CLUZ = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_CLUZ");
				
					
				String [] gdsDesc = new String[2];
				String [] mkDesc = new String[2];
				String [] newVal = new String[2];
				String vslCd = null;
				BookingUtil bcUtil = new BookingUtil();
				for(int i=0;i<val_BKG_XTER_RQST_MST.length;i++){
					for(int j=0;j<val_BKG_XTER_RQST_MST[i].length;j++){					
						if(val_BKG_XTER_RQST_MST[i][j] != null && val_BKG_XTER_RQST_MST[i][j].length()> 10 
								&& val_BKG_XTER_RQST_MST[i][j].substring(0,10).equals("N_GDS_DESC")){
							gdsDesc = splitByToken(val_BKG_XTER_RQST_MST[i][j], ":");
							val_BKG_XTER_RQST_MST[i][j] = ":";
						} else if(val_BKG_XTER_RQST_MST[i][j] != null && val_BKG_XTER_RQST_MST[i][j].length()> 9 
								&& val_BKG_XTER_RQST_MST[i][j].substring(0,9).equals("N_MK_DESC")){
							mkDesc = splitByToken(val_BKG_XTER_RQST_MST[i][j], ":");
							val_BKG_XTER_RQST_MST[i][j] = ":";
						} else {
							/******************************************************
							 * 2010-07-07 [CHM-201004482] EI 300 UPLOAD를 위한 로직보완
							 ******************************************************/
							if (!"SEANACCS".equals(xterSndrId)) {
								if (val_BKG_XTER_RQST_MST[i][j] != null && val_BKG_XTER_RQST_MST[i][j].indexOf("N_VSL_CD") >= 0 && xterCallSgnNo.length() == 7) {
									newVal = splitByToken(val_BKG_XTER_RQST_MST[i][j], ":");
									vslCd = bcUtil.searchVslCdByLloydNo(xterCallSgnNo, xterSkdVoyNo, xterSkdDirCd);
									if (vslCd == null)
										vslCd = "    ";
									val_BKG_XTER_RQST_MST[i][j] = newVal[0] + ":" + vslCd;
								}
							} else {
//							if( "SEANACCS".equals(xterSndrId) ) {
								if(val_BKG_XTER_RQST_MST[i][j] != null && val_BKG_XTER_RQST_MST[i][j].length()> 8
										&& val_BKG_XTER_RQST_MST[i][j].substring(0,8).equals("N_VSL_CD")){
									newVal = splitByToken(val_BKG_XTER_RQST_MST[i][j], ":");
									vslCd = dbDao.searchXterVslCd(xterCallSgnNo, xterSkdVoyNo, xterSkdDirCd);
									if ( vslCd != null ){
										val_BKG_XTER_RQST_MST[i][j] = newVal[0]+":"+vslCd;
									} else {
										val_BKG_XTER_RQST_MST[i][j] = newVal[0]+":    ";
									}
								} 
							}
						}
					}				
				}
	
				newVal = null;
				for(int i=0;i<val_BKG_XTER_TMP_BL_MK_DESC.length;i++){
					for(int j=0;j<val_BKG_XTER_TMP_BL_MK_DESC[i].length;j++){
						if(val_BKG_XTER_TMP_BL_MK_DESC[i][j] != null  && val_BKG_XTER_TMP_BL_MK_DESC[i][j].length()> 13
								&& val_BKG_XTER_TMP_BL_MK_DESC[i][j].substring(0,13).equals("N_TTL_PCK_LVL")){
							newVal = splitByToken(val_BKG_XTER_TMP_BL_MK_DESC[i][j], ":");
							/* StringUtils.containsNone - 변수, check할 값을 입력 : */
							if ( !StringUtils.containsOnly(newVal[1], "0123456789") ) {
								val_BKG_XTER_TMP_BL_MK_DESC[i][j] = ":";
							}
						}
					}
				}
							
				if ( "".equals(xterBiTpCd) || !"H".equals(replaceNull(xterBiTpCd)) ) {
					rqstNoVo = dbDao.searchXterRqstMstSeq(xterSndrId, xterRqstNo, xterDocTpCd);
				} else if ( "H".equals(replaceNull(xterBiTpCd)) ) {
					// if HBl, rqst_no return
					rqstNoVo.setRqstNo(xterRqstNo);
					rqstNoVo.setSenderId(xterSndrId);
					rqstNoVo.setBkgNo(xterBkgNo);
					rqstNoVo = dbDao.searchXterHblSeq(rqstNoVo, xterRqstViaCd, xterSiNo, xterDocTpCd);
				}
				
				if(rqstNoVo.getRqstSeq().length()>3){
					return null;
				}
				
				rqstNoVo.setRqstNo(xterRqstNo);
				rqstNoVo.setSenderId(xterSndrId);
				rqstNoVo.setBkgNo(xterBkgNo);
				rqstNoVo.setFfRefNo(ffRefNo);
				rqstNoVo.setSiNo(xterSiNo);
				rqstNoVo.setXterBlTpCd(xterBiTpCd);
				rqstNoVo.setDocTpCd(xterDocTpCd);
	
				log.debug("xterRqstViaCd:"+replaceNull(xterRqstViaCd));
				log.debug("xterDocTpCd:"+replaceNull(xterDocTpCd));
				log.debug("xterSndrId:"+replaceNull(xterSndrId));
				log.debug("xterRqstNo:"+replaceNull(xterRqstNo));
				log.debug("xterRqstSeq:"+replaceNull(rqstNoVo.getRqstSeq()));
				log.debug("ffRefNo:"+replaceNull(rqstNoVo.getFfRefNo()));
				log.debug("xterBiTpCd:"+replaceNull(xterBiTpCd));
				log.debug("xterBkgNo:"+replaceNull(rqstNoVo.getBkgNo()));
				
				if ( "H".equals(replaceNull(xterBiTpCd))) {
					if (((isNull(rqstNoVo.getBkgNo())?0:rqstNoVo.getBkgNo().length()) < 11 )) {
						XterRqstNoVO rqstNoTmpVo = new XterRqstNoVO();
						rqstNoTmpVo = dbDao.searchXterBkgNo(rqstNoVo);
						if ( rqstNoTmpVo != null ) {
							rqstNoVo.setBkgNo(rqstNoTmpVo.getBkgNo());
						}
					}
				} else {				
					if ( Integer.parseInt((isNull(rqstNoVo.getRqstSeq()))?"0":rqstNoVo.getRqstSeq()) > 1 
						&& ((isNull(rqstNoVo.getBkgNo())?0:rqstNoVo.getBkgNo().length()) < 11 )) {
		//					&& (isNull(rqstNoVo.getBkgNo()) 
		//							&& rqstNoVo.getBkgNo().length() < 11) ) {
						XterRqstNoVO rqstNoTmpVo = new XterRqstNoVO();
						rqstNoTmpVo = dbDao.searchXterBkgNo(rqstNoVo);
						if ( rqstNoTmpVo != null ) {
							rqstNoVo.setBkgNo(rqstNoTmpVo.getBkgNo());
						}
					}
				}
				
				if ( "GTN".equals(xterRqstViaCd) && "S".equals(xterDocTpCd) ) {
					String[] xterRqstNoHbi = dbDao.searchXterHblCount(rqstNoVo);
					XterRqstNoVO xterHblNo = new XterRqstNoVO();
					xterHblNo.setRqstNo(xterRqstNo);
					xterHblNo.setSenderId(xterSndrId);
	
					for (int i=0;i<xterRqstNoHbi.length;i++) {
						xterHblNo.setRqstSeq(xterRqstNoHbi[i]);
						dbDao.copyBkgXterRqstMst(xterHblNo);
						dbDao.copyBkgXterCust(xterHblNo);
						dbDao.copyBkgXterCntr(xterHblNo);
						dbDao.copyBkgXterCntrSealNo(xterHblNo);
						dbDao.copyBkgXterCntrMkDesc(xterHblNo);
					}
				}
	
				/* ----- Start ----- */
				dbDao.addBkgXterRqstMst(rqstNoVo, val_BKG_XTER_RQST_MST[0]);
				if(val_BKG_XTER_RQST_MISC.length>0)
					dbDao.addBkgXterRqstMisc(rqstNoVo, val_BKG_XTER_RQST_MISC[0]);
				if(val_BKG_XTER_INSTR.length>0)
					dbDao.addBkgXterInstr(rqstNoVo, val_BKG_XTER_INSTR[0]);
				if(val_BKG_XTER_RQST_CNG.length>0)
					dbDao.addBkgXterRqstCng(rqstNoVo, val_BKG_XTER_RQST_CNG[0]);
				for (int i=0;i<val_BKG_XTER_QTY.length;i++)
					dbDao.addBkgXterQty(rqstNoVo, val_BKG_XTER_QTY[i]);
	
				if(val_BKG_XTER_CNTR != null)
					for (int i=0;i<val_BKG_XTER_CNTR.length;i++)
						dbDao.addBkgXterCntr(rqstNoVo, val_BKG_XTER_CNTR[i]);
				
				if(val_BKG_XTER_CNTR_MK_DESC != null)
					for (int i=0;i<val_BKG_XTER_CNTR_MK_DESC.length;i++){
						for (int j=0;j<val_BKG_XTER_CNTR_MK_DESC[i].length;j++){
							log.debug("val_BKG_XTER_CNTR_MK_DESC[i][j]:"+val_BKG_XTER_CNTR_MK_DESC[i][j]);
						}
						for (int j=0;j<val_BKG_XTER_CNTR_MK_DESC[i].length;j++){
							if(val_BKG_XTER_CNTR_MK_DESC[i][j] != null && val_BKG_XTER_CNTR_MK_DESC[i][j].length()>14){
								if(val_BKG_XTER_CNTR_MK_DESC[i][j].substring(0, 13).equals("N_MK_DESC_SEQ")){
									dbDao.addBkgXterCntrMkDesc(rqstNoVo, val_BKG_XTER_CNTR_MK_DESC[i]);
									break;
								}
							}	
						}
					}
					
				if(val_BKG_XTER_CNTR_SEAL_NO != null)
					for (int i=0;i<val_BKG_XTER_CNTR_SEAL_NO.length;i++){
						for(int j=0;j<val_BKG_XTER_CNTR_SEAL_NO[i].length;j++){
							//if be seal no, insert
							if(val_BKG_XTER_CNTR_SEAL_NO[i][j] != null && val_BKG_XTER_CNTR_SEAL_NO[i][j].length()>19){
								if(val_BKG_XTER_CNTR_SEAL_NO[i][j].substring(0, 19).equals("N_XTER_CNTR_SEAL_NO")){
									dbDao.addBkgXterCntrSealNo(rqstNoVo, val_BKG_XTER_CNTR_SEAL_NO[i]);
									break;
								}
							}
						}	
					}
						
				for (int i=0;i<val_BKG_XTER_CUST.length;i++)
					dbDao.addBkgXterCust(rqstNoVo, val_BKG_XTER_CUST[i]);
				for (int i=0;i<val_BKG_XTER_XPT_LIC_NO.length;i++)
					dbDao.addBkgXterXptLicNo(rqstNoVo, val_BKG_XTER_XPT_LIC_NO[i]);
				for (int i=0;i<val_BKG_XTER_DG_CGO.length;i++)
					dbDao.addBkgXterDgCgo(rqstNoVo, val_BKG_XTER_DG_CGO[i]);
				for (int i=0;i<val_BKG_XTER_AWK_CGO.length;i++)
					dbDao.addBkgXterAwkCgo(rqstNoVo, val_BKG_XTER_AWK_CGO[i]);
				for (int i=0;i<val_BKG_XTER_RF_CGO.length;i++)
					dbDao.addBkgXterRfCgo(rqstNoVo, val_BKG_XTER_RF_CGO[i]);
				for (int i=0;i<val_BKG_XTER_TRO.length;i++)
					dbDao.addBkgXterTro(rqstNoVo, val_BKG_XTER_TRO[i]);
				for (int i=0;i<val_BKG_XTER_TRO_DTL.length;i++)
					dbDao.addBkgXterTroDtl(rqstNoVo, val_BKG_XTER_TRO_DTL[i]);
				for (int i=0;i<val_BKG_XTER_AES.length;i++)
					dbDao.addBkgXterAes(rqstNoVo, val_BKG_XTER_AES[i]);
				for (int i=0;i<val_BKG_XTER_TMP_BL_MK_DESC.length;i++)
					dbDao.addBkgXterTmpBlMkDesc(rqstNoVo, val_BKG_XTER_TMP_BL_MK_DESC[i]);
				for (int i=0;i<val_BKG_XTER_REF.length;i++)
					dbDao.addBkgXterRef(rqstNoVo, val_BKG_XTER_REF[i]);
				for (int i=0;i<val_BKG_XTER_CLUZ.length;i++)
					dbDao.addBkgXterCluz(rqstNoVo, val_BKG_XTER_CLUZ[i]);
				/* ----- End ----- */

				dbDao.updateBkgXterXptLicNo(rqstNoVo);

				dbDao.updateBkgXterCustCode(rqstNoVo);
				
				//  handling office, rqst_dt, desc update.
				dbDao.modifyHandlingOfc(rqstNoVo, gdsDesc[1], mkDesc[1]);
				
				rqstNoVo.setSenderId(xterSndrId);
				//  office notice
//				if(!xterSndrId.equalsIgnoreCase("PEGASUS")){
//					sendXterRqstNotice(rqstNoVo);
//				}
				
			} else {
				// ELNO save
				String[][] val_BKG_XTER_XPT_LIC_NO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_XPT_LIC_NO");				

				rqstNoVo = dbDao.searchXterRqstMstSeq(xterSndrId, xterRqstNo, xterDocTpCd);
				rqstNoVo.setRqstNo(xterRqstNo);
				rqstNoVo.setSenderId(xterSndrId);
				rqstNoVo.setBkgNo(xterBkgNo);
				rqstNoVo.setFfRefNo(ffRefNo);
				rqstNoVo.setSiNo(xterSiNo);
				rqstNoVo.setXterBlTpCd(xterBiTpCd);
				rqstNoVo.setDocTpCd(xterDocTpCd);
				
				for (int i=0;i<val_BKG_XTER_XPT_LIC_NO.length;i++)
					dbDao.addBkgXterXptLicNo(rqstNoVo, val_BKG_XTER_XPT_LIC_NO[i]);
				
				dbDao.updateBkgXterXptLicNo(rqstNoVo);
			}	
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
		}
		return rqstNoVo;
	}

	/**
	 * Error massage send by mail.<br>
	 * @param String errStr
	 * @param String flatFileStr
	 */
	public void sendErrLogMail(String errStr, String flatFileStr) {
		log.debug("$$$$$$$$$$$$$$$$$ \nEBookingReceiptBCImpl.sendErrLogMail() START() ");
		List<String> emailInfoList = null;
		try{
			emailInfoList = dbDao.searchSendEmailErrorInfo();
			if(emailInfoList != null){
				log.debug("$$$$$$$$$$$$$$$$$ \nEBookingReceiptBCImpl.sendErrLogMail() size() "+emailInfoList.size());
				log.debug("$$$$$$$$$$$$$$$$$ \nEBookingReceiptBCImpl.sendErrLogMail() errStr "+errStr);
				errStr = dbDao.searchErrMsgForMail(errStr);
				eaiDao.sendErrLogMail(errStr, flatFileStr, emailInfoList);
			}
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
		}
	}
	/**
	 * column and value return<br>
	 *  MQ interface<br>
	 *
	 * @param List<XterRqstVO> rqstVoList
	 * @param List<BkgHrdCdgCtntVO> hrdList
	 * @param String tableNm
	 * @return String[][]
	 * @exception EventException
	 */
	private String[][] searchColVal(List<XterRqstVO> rqstVoList, List<BkgHrdCdgCtntVO> hrdList, String tableNm) throws EventException, DAOException {
		String[][] retVal = null;
        List<XterRqstVO> rqstTabList = null;
		int tmpSeq = 0;
		int saveSeq = 0;
		String oldCol = "";
		String colValue = null;
		String tmpTroAddr = "";
		XterRqstVO rqstTabVo = null;
		try {
	        rqstTabList = new ArrayList<XterRqstVO>();
			for (int i=0;i<rqstVoList.size();i++) {
				XterRqstVO rqstVos = (XterRqstVO) rqstVoList.get(i);
				if ( tableNm.equals(rqstVos.getTableNm()) ) {
					if (Integer.parseInt(rqstVos.getSeq()) > tmpSeq) tmpSeq = Integer.parseInt(rqstVos.getSeq());
					rqstTabList.add(rqstVos);
				}
			}
	
			if (rqstTabList.size() > 0) {
				tmpSeq = tmpSeq + 1;
				retVal = new String[tmpSeq][searchColumnSize(hrdList, tableNm)];
			} else retVal = new String[0][0];
	
			if (rqstTabList != null && rqstTabList.size() > 0) {
	
				int i = 0;
				String oldMkSeq = "";
				for (int j=0;j<((tmpSeq == 0)?1:tmpSeq);j++) {					
					for (int k=0;k<rqstTabList.size();k++) {
						if (k > 0) oldCol = rqstTabList.get(k-1).getColumnNm();
						rqstTabVo = (XterRqstVO) rqstTabList.get(k);
	
						if (Integer.parseInt(rqstTabVo.getSeq()) == j) {
							colValue = rqstTabVo.getInputValue();
							if (rqstTabVo.getColumnNm().length() > 1 && "CNTR_VENT_CD".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 1) colValue = rqstTabVo.getInputValue().substring(0, 1);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "CSTMS_CMDT_CD".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 6) colValue = rqstTabVo.getInputValue().substring(0, 6);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "BKG_NO".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 13) colValue = rqstTabVo.getInputValue().substring(0, 13);
							} else if (rqstTabVo.getColumnNm().length() > 1 && ("VSL_CD".equals(rqstTabVo.getColumnNm()) || "SKD_VOY_NO".equals(rqstTabVo.getColumnNm()))) {
								if (rqstTabVo.getInputValue().length() > 4) colValue = rqstTabVo.getInputValue().substring(0, 4);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "CSTMS_CMDT_CD".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 6) colValue = rqstTabVo.getInputValue().substring(0, 6);
							} else if (rqstTabVo.getColumnNm().length() > 1 && ("POD_CD".equals(rqstTabVo.getColumnNm()) || "DEL_CD".equals(rqstTabVo.getColumnNm()))) {
								if (rqstTabVo.getInputValue().length() > 5) colValue = rqstTabVo.getInputValue().substring(0, 5);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "TWN_SO_NO".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 4) colValue = rqstTabVo.getInputValue().substring(0, 4);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "CNTR_NO".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() < 1) colValue = "No Data";
							} else if (rqstTabVo.getColumnNm().length() > 1 && "MK_SUB_SEQ".equals(rqstTabVo.getColumnNm()) ) {
//								colValue = String.valueOf(j+1);
								colValue = String.valueOf(++i);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "MK_SEQ".equals(rqstTabVo.getColumnNm()) ) {
								if ( j == 0 ) {
									oldMkSeq = colValue.trim();
								} else if ( !(oldMkSeq.trim()).equals(colValue.trim())){
									i = 0;
									oldMkSeq = colValue.trim();
								}
							} else if (rqstTabVo.getColumnNm().length() > 1 && "CNTR_TPSZ_CD".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() < 1) colValue = "ZZ";
							} else if (rqstTabVo.getColumnNm().length() > 1 && "TTL_PCK_QTY".equals(rqstTabVo.getColumnNm())) {
								if ( !StringUtils.containsOnly(colValue, "0123456789.") ) {
									colValue = "0";
								}
							} else if (rqstTabVo.getColumnNm().length() > 1 && "XTER_BKG_RMK1".equals(rqstTabVo.getColumnNm())) {
//								if (rqstTabVo.getInputValue().length() > 1) {
//									if ("@".equals(colValue.substring(colValue.length()-1, colValue.length()))) {
//										colValue = colValue.substring(0, colValue.length()-1).replace("@", "\n");
//									}else{
//										colValue = colValue.replace("@", "\n");										
//									}
//								}
								byte[] befStr = colValue.getBytes();
								if (befStr.length >= 3999) {
									byte[] afStr = new byte[befStr.length];
									System.arraycopy(befStr, 0, afStr, 0, 3999);
									colValue = new String(afStr).trim();
								}									
							} else if (rqstTabVo.getColumnNm().length() > 1 && ("XTER_BKG_RMK2".equals(rqstTabVo.getColumnNm()))) {
								byte[] befStr = colValue.getBytes();
								if (befStr.length >= 3999) {
									byte[] afStr = new byte[befStr.length];
									System.arraycopy(befStr, 0, afStr, 0, 3999);
									colValue = new String(afStr).trim();
								}
							} else if ("BKG_XTER_TRO_DTL".equals(tableNm) && rqstTabVo.getColumnNm().length() > 1 && "EUR_TRO_DOR_ADDR".equals(rqstTabVo.getColumnNm()) && !"EUR_TRO_DOR_ADDR".equals(oldCol)) {
								tmpTroAddr = JSPUtil.getRPAD(colValue, 50, " ");
								colValue = "";
							} else if ("BKG_XTER_TRO_DTL".equals(tableNm) && rqstTabVo.getColumnNm().length() > 1 && "EUR_TRO_DOR_ADDR".equals(rqstTabVo.getColumnNm()) && "EUR_TRO_DOR_ADDR".equals(oldCol)) {
								colValue = tmpTroAddr + colValue;
							}

							log.debug("name:"+rqstTabVo.getColumnNm() + " col:"+colValue + " seq:"+rqstTabVo.getSeq());

							if(rqstTabVo.getColumnNm().length()> 4){							
								if (rqstTabVo.getColumnNm().substring(rqstTabVo.getColumnNm().length() - 3).equals("QTY")
										|| rqstTabVo.getColumnNm().substring(rqstTabVo.getColumnNm().length() - 3).equals("WGT")
										|| rqstTabVo.getColumnNm().equals("CUST_SEQ")){
									if (colValue.replace(",", ".") == null || colValue.replace(",", ".").trim().equals("")) {
										colValue = "0";
									}
									else {
										colValue = "" + Double.parseDouble(colValue.replace(",", "."));
									}
/*									try {							
										colValue = ""+Double.parseDouble(colValue.replace(",", "."));
									} catch (Exception ex){
										colValue = "0";
									}*/
								}
							}
	
							if (!"BKG_NO".equals(rqstTabVo.getColumnNm())) {
								if ( saveSeq > 0 && rqstTabVo.getColumnNm().equals(oldCol) && !"EUR_TRO_DOR_ADDR".equals(oldCol)) {
									retVal[j][saveSeq-1] = retVal[j][saveSeq-1] + "\r\n" + colValue;
								} else {
									retVal[j][saveSeq] = (("DATE".equals(rqstTabVo.getColumnType()))?"D_":"N_")+rqstTabVo.getColumnNm()+":"+colValue;
									saveSeq++;
								}
							}
							
						}
					}
	
					saveSeq = 0;
				}
			}
        } catch (Exception ex) {
        	log.debug(ex.toString());
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return retVal;
	}

	/**
	 * BKG_XTER_QTY table Qty info return<br>
	 *  MQ interface<br>
	 *
	 * @param String[] rcvMsgS
	 * @param List<BkgHrdCdgCtntVO> hrdList
	 * @return String[][]
	 * @exception EventException
	 */
	private String[][] searchXterQtyList(String[] rcvMsgS, List<BkgHrdCdgCtntVO> hrdList) throws EventException {
		String[][] retVal = null;
        List<XterRqstVO> rqstVoList = null;
		ArrayList<String> qtyIdArr = null;
		ArrayList<String> cnrtCd = null;
		String[] splitRcvMsg = null;
		boolean startFlg = false;
		int qtySeq = 0;
		XterRqstVO rqstVo = null;
		HashSet<String> hs = null;
		Iterator<String> it = null;
		XterRqstVO rqstQtyVo = null;
		try {
			retVal = null;
	        rqstVoList = new ArrayList<XterRqstVO>();
			qtyIdArr = new ArrayList<String>();
			cnrtCd = new ArrayList<String>();
			splitRcvMsg = null;
			startFlg = false;
			qtySeq = 0;

			for(int i=1;i<rcvMsgS.length;i++) {
				rcvMsgS[i] = remove(rcvMsgS[i], '\n');
	
				if ( "{I_BKG_QTY".equals(rcvMsgS[i]) ) {
					startFlg = true;
					qtySeq++;
				} else if ( "}I_BKG_QTY".equals(rcvMsgS[i]) ) {
					startFlg = false;
				}
	
				if ( startFlg ) {
					if ( !"{".equals(rcvMsgS[i].substring(0, 1)) && !"}".equals(rcvMsgS[i].substring(0, 1)) ) {
						splitRcvMsg = splitByToken(rcvMsgS[i], ":");
	
	        			rqstVo = new XterRqstVO();
	        			rqstVo.setSeq(String.valueOf(qtySeq-1));
	        			rqstVo.setColumnNm(splitRcvMsg[0]);
	        			rqstVo.setInputValue(splitRcvMsg[1]);
	        			rqstVoList.add(rqstVo);
	
	        			if ( "CNTRTS_CD".equals(splitRcvMsg[0]) ) {
	        				if ( splitRcvMsg[1].length() > 0 ) {
	        					qtyIdArr.add(splitRcvMsg[1]);
	        				} else {
	        					qtyIdArr.add("ZZ");
	        				}
	        					
	        			}
	
					}
				}
			}

			hs = new HashSet<String>(qtyIdArr);
			it = hs.iterator();
			while(it.hasNext()){
				cnrtCd.add(it.next().toString());
			}
	
			retVal = new String[cnrtCd.size()][searchColumnSize(hrdList, "BKG_XTER_QTY")];
	
			double qtySum = 0;
			for(int i=0;i<cnrtCd.size();i++) {
				for(int j=0;j<rqstVoList.size();j++) {
					rqstVo = (XterRqstVO) rqstVoList.get(j);
					if ( "CNTRTS_CD".equals(rqstVo.getColumnNm()) && cnrtCd.get(i).equals(rqstVo.getInputValue()) ) {
						for(int k=0;k<rqstVoList.size();k++) {
							rqstQtyVo = (XterRqstVO) rqstVoList.get(k);
							if ( Integer.parseInt(rqstQtyVo.getSeq()) == Integer.parseInt(rqstVo.getSeq()) && "IBQTY_QTY".equals(rqstQtyVo.getColumnNm()) ) {
								qtySum += Double.parseDouble(rqstQtyVo.getInputValue());
							}
						}
					}
				}
				retVal[i][0] = "N_CNTR_TPSZ_CD:"+cnrtCd.get(i);
				retVal[i][1] = "N_CNTR_QTY:"+String.valueOf(qtySum);
				qtySum = 0;
			}
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return retVal;
	}

	/**
	 * BKG_XTER_CNTR_SEAL_NO table container info retrun<br>
	 *
	 * @param String[] rcvMsgS
	 * @param List<BkgHrdCdgCtntVO> hrdList
	 * @param String[][] cntrList
	 * @return String[][]
	 * @exception EventException
	 */
	private String[][] searchCntrSealNoList(String[] rcvMsgS, List<BkgHrdCdgCtntVO> hrdList, String[][] cntrList) throws EventException {
		String[][] retVal = null;
		String[] splitRcvMsg = null;
		boolean startFlg = false;
		boolean existSealFlg = false;
		int sealSeq = 0;
		int colSeq = 0;
		try {
			retVal = new String[cntrList.length][searchColumnSize(hrdList, "BKG_XTER_CNTR_SEAL_NO")+2];

			for(int i=1;i<rcvMsgS.length;i++) {
				rcvMsgS[i] = remove(rcvMsgS[i], '\n');
				if ( "{I_BKG_CNTR".equals(rcvMsgS[i]) ) {
					for(int j=i;j<rcvMsgS.length;j++){
						if ( "}I_BKG_CNTR".equals(rcvMsgS[j])){
							break;
						}
						if ( !"{".equals(rcvMsgS[j].substring(0, 1)) && !"}".equals(rcvMsgS[j].substring(0, 1)) ) {
							splitRcvMsg = splitByToken(rcvMsgS[j], ":");
							if ( "IBCNTR_SEAL_NO".equals(splitRcvMsg[0]) ) {
								startFlg = true;
								sealSeq++;
								break;
							} else if ( "IBCNTR_SEAL_NO2".equals(splitRcvMsg[0]) ) {
								startFlg = true;
								sealSeq++;
								break;
							} else if ( "IBCNTR_SEAL_NO3".equals(splitRcvMsg[0]) ) {
								startFlg = true;
								sealSeq++;
								break;
							}	
						}					
					}
				} else if ( "}I_BKG_CNTR".equals(rcvMsgS[i]) ) {
					startFlg = false;
					colSeq = 0;
				}
	
				if ( startFlg ) {
					if ( !"{".equals(rcvMsgS[i].substring(0, 1)) && !"}".equals(rcvMsgS[i].substring(0, 1)) ) {
						splitRcvMsg = splitByToken(rcvMsgS[i], ":");
						for (int j=0;j<hrdList.size();j++) {
				        	BkgHrdCdgCtntVO hrdCdg = (BkgHrdCdgCtntVO) hrdList.get(j);
			        		if ( "BKG_XTER_CNTR_SEAL_NO".equals(hrdCdg.getAttrCtnt3()) && hrdCdg.getAttrCtnt2().equals(splitRcvMsg[0]) ) {
			        			retVal[sealSeq-1][colSeq++] = (("DATE".equals(hrdCdg.getAttrCtnt5()))?"D_":"N_")+hrdCdg.getAttrCtnt4()+":"+splitRcvMsg[1];
				        	}
						}
	
						if ( "CNTR_NO".equals(splitRcvMsg[0]) ) {
							retVal[sealSeq-1][colSeq++] = "N_"+splitRcvMsg[0]+":"+splitRcvMsg[1];
						} else if ( "IBCNTR_SEAL_NO".equals(splitRcvMsg[0]) ) {
	//						retVal[sealSeq-1][colSeq++] = "N_CNTR_SEAL_SEQ:1";
							existSealFlg = true;
						} else if ( "IBCNTR_SEAL_NO2".equals(splitRcvMsg[0]) ) {
	//						retVal[sealSeq-1][colSeq++] = "N_CNTR_SEAL_SEQ:2";
							existSealFlg = true;
						} else if ( "IBCNTR_SEAL_NO3".equals(splitRcvMsg[0]) ) {
	//						retVal[sealSeq-1][colSeq++] = "N_CNTR_SEAL_SEQ:3";
							existSealFlg = true;
						}
					}
				}
			}
			log.debug("seal_no exit : " + existSealFlg);
			if (!existSealFlg) retVal = null;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return retVal;
	}

	/**
	 * IBD_DESC, IBM_MARK, IBEM_MISC info combine<br>
	 *
	 * @param String[][] val_BKG_XTER_RQST_MST
	 * @return String[][]
	 * @exception EventException
	 */
	private String[][] concateDescValue(String[][] val_BKG_XTER_RQST_MST) throws EventException {
		String[] splitColVal = null;
		StringBuffer gdsDescMsg = null;
		StringBuffer mkDescMsg = null;
		StringBuffer miscDescMsg = null;
		int gdsDescPosition = 0;
		int mkDescPosition = 0;
		int miscDescPosition = 0;
		try {
			gdsDescMsg = new StringBuffer();
			mkDescMsg = new StringBuffer();
			miscDescMsg = new StringBuffer();
			for (int i=0;i<val_BKG_XTER_RQST_MST.length;i++) {
				for (int j=0;j<val_BKG_XTER_RQST_MST[i].length;j++) {
					if (val_BKG_XTER_RQST_MST[i][j] != null && val_BKG_XTER_RQST_MST[i][j].indexOf(":") > 0) {
						splitColVal = splitByToken(val_BKG_XTER_RQST_MST[i][j], ":");
	

						if ( splitColVal[0].indexOf("GDS_DESC") != -1 ) {
							gdsDescPosition = j;
	
							val_BKG_XTER_RQST_MST[i][j] = ":";
//							log.debug("[i][j]=[" + i + "][" + j + "]");
//							log.debug("splitColVal[0]=[" + splitColVal[0] + "]");
//							log.debug("splitColVal[1]=[" + splitColVal[1] + "]");
//							log.debug("gdsDescMsg=[" + gdsDescMsg + "]");
							gdsDescMsg.append(splitColVal[1]+"\n");
						} else if ( splitColVal[0].indexOf("MK_DESC") != -1 ) {
							mkDescPosition = j;
	
							val_BKG_XTER_RQST_MST[i][j] = ":";
							mkDescMsg.append(splitColVal[1]+"\n");
						} else if ( splitColVal[0].indexOf("MISC_DESC") != -1 ) {
							miscDescPosition = j;
	
							val_BKG_XTER_RQST_MST[i][j] = ":";
							miscDescMsg.append(splitColVal[1]+"\n");
						}
					}
				}
	
				if (!isNull(gdsDescMsg.toString())) val_BKG_XTER_RQST_MST[0][gdsDescPosition] = "N_GDS_DESC:"+gdsDescMsg.toString();
				if (!isNull(mkDescMsg.toString())) val_BKG_XTER_RQST_MST[0][mkDescPosition] = "N_MK_DESC:"+mkDescMsg.toString();
				if (!isNull(miscDescMsg.toString())) val_BKG_XTER_RQST_MST[0][miscDescPosition] = "N_MISC_DESC:"+miscDescMsg.toString();
			}
/*
			for (int i=0;i<val_BKG_XTER_RQST_MST.length;i++) {
				for (int j=0;j<val_BKG_XTER_RQST_MST[i].length;j++) {
					log.debug("COL:"+val_BKG_XTER_RQST_MST[i][j]);
				}
			}
*/
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return val_BKG_XTER_RQST_MST;
	}

	/**
	 * Hard Coding Table List retrieve<br>
	 *  MQ interface<br>
	 *
	 * @param List<BkgHrdCdgCtntVO> hrdList
	 * @param String tableNm
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	private List<BkgHrdCdgCtntVO> searchHardCodingTableList(List<BkgHrdCdgCtntVO> hrdList, String tableNm) throws EventException {
		List<BkgHrdCdgCtntVO> list = null;
//		int startSeq = 0;
		try {
			list = new ArrayList<BkgHrdCdgCtntVO>();
			for (int i=0;i<hrdList.size();i++) {
	        	BkgHrdCdgCtntVO hrdCdg = (BkgHrdCdgCtntVO) hrdList.get(i);
/*	        	if (tableNm.equals(hrdCdg.getAttrCtnt2().substring(1, hrdCdg.getAttrCtnt2().length())) ||
	        		tableNm.equals(hrdCdg.getAttrCtnt2().substring(0, hrdCdg.getAttrCtnt2().length()-1)) ) {
	        		startSeq++;
	        	}

	        	if (startSeq == 1) {
					list.add(hrdCdg);
	        	} else if (startSeq > 1) break;*/
	        	if (tableNm.equals(hrdCdg.getAttrCtnt6())) {
	        		list.add(hrdCdg);
	        	}
			}
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return list;
	}

	/**
	 * Hard Coding Table size retrieve<br>
	 *  MQ interface<br>
	 *
	 * @param List<BkgHrdCdgCtntVO> hrdList
	 * @param String tableNm
	 * @return int
	 * @exception EventException
	 */
	private int searchColumnSize(List<BkgHrdCdgCtntVO> hrdList, String tableNm) throws EventException {
		int retSize = 0;
		try {
			for (int i=0;i<hrdList.size();i++) {
	        	if ( tableNm.equals(((BkgHrdCdgCtntVO) hrdList.get(i)).getAttrCtnt3()) ) {
	        		retSize++;
	        	}
			}
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return retSize;
	}

	/**
	 * Hard Coding info return<br>
	 *  MQ interface<br>
	 *
	 * @param BkgHrdCdgCtntListCondVO hrdCdgCond
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	private List<BkgHrdCdgCtntVO> searchHardCoding(BkgHrdCdgCtntListCondVO hrdCdgCond) throws EventException {
        try {
            BookingUtil bcUtil = null;
            bcUtil = new BookingUtil();
	        hrdCdgCond.setHrdCdgId("XTER_BKG_RECEIPT");
	        return bcUtil.searchHardCoding(hrdCdgCond);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
	    }
	}

	/**
	 * external request search condition retrieve.<br>
	 *
	 * @param String userId
	 * @return List<BkgXterSrchSetVO>
	 * @exception EventException
	 */
	public List<BkgXterSrchSetVO> searchXterSrchSetForList(String userId) throws EventException {
		try {
			return dbDao.searchXterSrchSetForList(userId);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * External Request List retrieve<br>
	 *
	 * @param ExternalRqstListInputVO xterRqstListInputVO
	 * @return List<ExternalRqstListVO>
	 * @exception EventException
	 */
	public List<ExternalRqstListVO> searchXterRqstList(ExternalRqstListInputVO xterRqstListInputVO) throws EventException {
		try {
	        return dbDao.searchXterRqstList(xterRqstListInputVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * External Request status change.<br>
	 *
	 * @param XterRqstNoVO[] xterRqstNoVO
	 * @param String newSts
	 * @param String reInstCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeXterRqstStatus(XterRqstNoVO[] xterRqstNoVO, String newSts, String reInstCd, SignOnUserAccount account) throws EventException{
		String rqstStsCd = null;
		List<XterRqstNoVO> updateVoList = null;
		try {
			updateVoList = new ArrayList<XterRqstNoVO>();
			for ( int i=0; i<xterRqstNoVO.length; i++ ) {
				if ( xterRqstNoVO[i].getIbflag().equals("U")){

					if ( !"N".equals(newSts) ) {
						rqstStsCd = dbDao.searchXterRqstStatus(xterRqstNoVO[i]);
						if ("N".equals(reInstCd)) {
							if ("D".equals(rqstStsCd)) {
								throw new EventException(new ErrorHandler("BKG00471").getMessage());
							} else if ("R".equals(rqstStsCd)) {
								throw new EventException(new ErrorHandler("BKG00473").getMessage());
							}
						}
						if ("D".equals(rqstStsCd)) {
							throw new EventException(new ErrorHandler("BKG00471").getMessage());
						} else if ("R".equals(rqstStsCd)) {
							throw new EventException(new ErrorHandler("BKG00473").getMessage());
						}
						if ("P".equals(newSts) && "P".equals(rqstStsCd)) throw new EventException(new ErrorHandler("BKG00472").getMessage());
					}
					updateVoList.add(xterRqstNoVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.changeXterRqstStatus(account.getUsr_id(), newSts, updateVoList);
			}
		}catch(EventException e){
			throw e;
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * External Request detail info retrieve.<br>
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstBkgVO
	 * @exception EventException
	 */
	public ExternalRqstBkgVO searchXterBkg(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstBkgVO externalRqstBkgVO = null;
		try {
			externalRqstBkgVO = new ExternalRqstBkgVO();
			externalRqstBkgVO.setXterRqstMstVO(dbDao.searchXterBkg(xterRqstNoVO));
			externalRqstBkgVO.setBkgXterQtyVO(dbDao.searchXterQty(xterRqstNoVO));
			externalRqstBkgVO.setXterRqstTabVO(dbDao.searchXterRqstTab(xterRqstNoVO));

        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return externalRqstBkgVO;
	}
	
	/**
	 * retrieve event handling<br>
	 * Find Booking button Click, OPUS Booking info retrieve <br>
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstBkgVO
	 * @exception EventException
	 */
	public ExternalRqstBkgVO searchOpusBkg(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstBkgVO externalRqstBkgVO = null;
		try {
			externalRqstBkgVO = new ExternalRqstBkgVO();
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return externalRqstBkgVO;
	}

	/**
	 * external rqst customer info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCustVO
	 * @exception EventException
	 */
	public ExternalRqstCustVO searchXterCust(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstCustVO externalRqstCustVO = null;
		try {
//			BookingUtil util = new BookingUtil();
			externalRqstCustVO = new ExternalRqstCustVO();
//			externalRqstCustVO.setBlDocCustVO(dbDao.searchXterBlDocCust(xterRqstNoVO));
//			CustEtcVO custEtcVO = dbDao.searchXterBkgCustEtc(xterRqstNoVO);			


//			String frobCode = util.searchFrob(custEtcVO.getBkgVvd(), custEtcVO.getPolCd(), custEtcVO.getPodCd());
//			String frobFlag = "N";
//			if("CA".equals(frobCode) || "AL".equals(frobCode)){
//				frobFlag = "Y";
//			}
//			custEtcVO.setFrobFlag(frobFlag);
//			externalRqstCustVO.setCustEtcVO(custEtcVO);
			externalRqstCustVO.setBkgXterCustVO(dbDao.searchXterCust(xterRqstNoVO));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return externalRqstCustVO;
	}

	/**
	 * external request container info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCntrVO
	 * @exception EventException
	 */
	public ExternalRqstCntrVO searchXterCntr(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstCntrVO externalRqstCntrVO = null;
		try {
			externalRqstCntrVO = new ExternalRqstCntrVO();
			externalRqstCntrVO.setXterCntrVO			(dbDao.searchXterCntr		(xterRqstNoVO));
			externalRqstCntrVO.setBkgXterCntrSealNoVO	(dbDao.searchXterCntrSealNo	(xterRqstNoVO));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstCntrVO;
	}

	/**
	 * external rqst mark & Description info retrieve<br>
	 * BKG_XTER_XPT_LIC_NO, BKG_XTER_AES, BKG_XTER_RQST_MST, BKG_XTER_CNTR retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param String usrOfc
	 * @return ExternalRqstMndVO
	 * @exception EventException
	 */
	public ExternalRqstMndVO searchXterMnd(XterRqstNoVO xterRqstNoVO, String usrOfc) throws EventException {
		ExternalRqstMndVO externalRqstMndVO = null;
		try {
			externalRqstMndVO = new ExternalRqstMndVO();		
			externalRqstMndVO.setXterMndVO(dbDao.searchXterMnd(xterRqstNoVO, usrOfc));
			
			//e-bkg MEXICO,turkey,ISRAEL,LEBANON,BRAZIL,USA,CANADA
			externalRqstMndVO.setXterXptLicVO(dbDao.searchXterXptLicVO(xterRqstNoVO));
			
			externalRqstMndVO.setOpusXptImpLicListVOs(dbDao.searchOpusXptImpLicList(xterRqstNoVO));
			externalRqstMndVO.setKrXptLicNoVOs(dbDao.searchKrXptLicNoList(xterRqstNoVO));
			externalRqstMndVO.setXterCntrPoNoVOs(dbDao.searchXterCntrPoNoList(xterRqstNoVO));
			externalRqstMndVO.setXterPoDtlVOs(dbDao.searchXterPoDtlNoList(xterRqstNoVO));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstMndVO;
	}

	/**
	 * extenal request container manifest info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCmVO
	 * @exception EventException
	 */
	public ExternalRqstCmVO searchXterCm(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstCmVO externalRqstCmVO = null;
		try {
			externalRqstCmVO = new ExternalRqstCmVO();
			externalRqstCmVO.setOpusCmVO(dbDao.searchOpusCm(xterRqstNoVO));
			externalRqstCmVO.setBkgXterCntrMkDescVO(dbDao.searchXterCm(xterRqstNoVO));
			externalRqstCmVO.setBkgDgCgoVOs(dbDao.searchBkgDgCgo(xterRqstNoVO.getBkgNo()));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstCmVO;
	}

	/**
	 * extenal request tro info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstTroVO
	 * @exception EventException
	 */
	public ExternalRqstTroVO searchXterTro(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstTroVO externalRqstTroVO = null;
		try {
			externalRqstTroVO = new ExternalRqstTroVO();
			externalRqstTroVO.setBkgXterTroVO(dbDao.searchXterTro(xterRqstNoVO));
			externalRqstTroVO.setBkgXterTroDtlVO(dbDao.searchXterTroDtl(xterRqstNoVO));
			externalRqstTroVO.setOpusTroMstVO(dbDao.searchOpusTro(xterRqstNoVO));
			externalRqstTroVO.setOpusTroDtlVO(dbDao.searchOpusTroDtl(xterRqstNoVO));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstTroVO;
	}

	/**
	 * external rqst awkward cgo info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstRfVO
	 * @exception EventException
	 */
	public ExternalRqstRfVO searchXterRf(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstRfVO externalRqstRfVO = null;
		try {
			externalRqstRfVO = new ExternalRqstRfVO();
			externalRqstRfVO.setOpusRfVO(dbDao.searchOpusRf(xterRqstNoVO));
			externalRqstRfVO.setBkgXterRfCgoVO(dbDao.searchXterRf(xterRqstNoVO));
			externalRqstRfVO.setOpusCntrTpszVO(dbDao.searchOpusCntrTpSz(xterRqstNoVO.getBkgNo()));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstRfVO;
	}

	/**
	 * external rqst danger cgo info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstDgVO
	 * @exception EventException
	 */
	public ExternalRqstDgVO searchXterDg(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstDgVO externalRqstDgVO = null;
		try {
			externalRqstDgVO = new ExternalRqstDgVO();
			externalRqstDgVO.setOpusDgVO(dbDao.searchOpusDg(xterRqstNoVO));
			externalRqstDgVO.setBkgXterDgCgoVO(dbDao.searchXterDg(xterRqstNoVO));
			externalRqstDgVO.setOpusCntrTpszVO(dbDao.searchOpusCntrTpSz(xterRqstNoVO.getBkgNo()));
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstDgVO;
	}

	/**
	 * retrieve event handling<br>
	 * extenal request의 awkward cargo info retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstAkVO
	 * @exception EventException
	 */
	public ExternalRqstAkVO searchXterAk(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstAkVO externalRqstAkVO = null;
		try {
			externalRqstAkVO = new ExternalRqstAkVO();
			externalRqstAkVO.setOpusAkVO(dbDao.searchOpusAk(xterRqstNoVO));
			externalRqstAkVO.setBkgXterAwkCgoVO(dbDao.searchXterAk(xterRqstNoVO));
			externalRqstAkVO.setOpusCntrTpszVO(dbDao.searchOpusCntrTpSz(xterRqstNoVO.getBkgNo()));
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstAkVO;
	}

	/**
	 * extenal request house b/l retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstHbl1VO
	 * @exception EventException
	 */
	public ExternalRqstHbl1VO searchXterHbl1(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstHbl1VO externalRqstHbl1VO = null;
		try {
			externalRqstHbl1VO = new ExternalRqstHbl1VO();
			externalRqstHbl1VO.setOpusHbl1VO(dbDao.searchOpusHbl1(xterRqstNoVO));
			externalRqstHbl1VO.setXterHbl1VO(dbDao.searchXterHbl1(xterRqstNoVO));
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstHbl1VO;
	}

	/**
	 * extenal request ams file no retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstHbl2VO
	 * @exception EventException
	 */
	public ExternalRqstHbl2VO searchXterHbl2(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstHbl2VO externalRqstHbl2VO = null;
		try {
			externalRqstHbl2VO = new ExternalRqstHbl2VO();
			externalRqstHbl2VO.setBkgUsaCstmsFileNoVO(dbDao.searchOpusHbl2(xterRqstNoVO));
			externalRqstHbl2VO.setXterUsaCstmsFileNoVO(dbDao.searchXterHbl2(xterRqstNoVO));
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstHbl2VO;
	}

	/**
	 * eBKG reject info send email.<br>
	 * @param 	EsmBkg0902Event event
	 * @throws 	EventException
	 */
	public void sendXterRqstRejectEmail(EsmBkg0902Event event) throws EventException{
		try {
			eaiDao.sendXterRqstRejectEmail(event);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
//	public void sendXterRqstRejectEmail(String senderEml, String cntcEml, String rjctRsnRmk, String blPrfShprFlg) throws EventException{
//	try {
//		eaiDao.sendXterRqstRejectEmail(senderEml, cntcEml, rjctRsnRmk, blPrfShprFlg);
//	} catch (DAOException de) {
//        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
//    } catch (Exception ex) {
//        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
//	}
//}

	
	/**
	 * external request reject create.<br>
	 *
	 * @param String rjctRsnRmk
	 * @param String xterRjctRsnCd
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException 
	 */
	public String createXterRqstRejectEdi(String rjctRsnRmk, String xterRjctRsnCd, XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException {
        BookingUtil bcUtil = null;
		String ediHeader = null;
		StringBuffer flatFile = null;
		RjctSndrRcvrVO rjctSndrRcvrVO = null;
		RejectEdiMstVO rejectEdiMstVO = null;
		List<RejectEdiCntrVO> rejectEdiCntrVO = null;
		List<RejectEdiDgVO> rejectEdiDgVO = null;
		List<RejectEdiQtyVO> rejectEdiQtyVO = null;
		List<RejectEdiVvdVO> rejectEdiVvdVO = null;
		List<RejectEdiCustVO> rejectEdiCustVO = null;
		List<RejectEdiDescVO> rejectEdiDescVO = null;
		RejectEdiInstrVO rejectEdiInstrVO = null;
		List<RejectEdiRefVO> rejectEdiRefVO = null;
		RejectEdiCntrVO cntrVO = null;
		RejectEdiDescVO descVO = null;
		RejectEdiDgVO dgVO = null;
		RejectEdiQtyVO qtyVO = null;
		try {
	        bcUtil = new BookingUtil();
			flatFile = new StringBuffer();
			rjctSndrRcvrVO = new RjctSndrRcvrVO();
			rejectEdiMstVO = new RejectEdiMstVO();
			rejectEdiCntrVO = new ArrayList<RejectEdiCntrVO>();
			rejectEdiDgVO = new ArrayList<RejectEdiDgVO>();
			rejectEdiQtyVO = new ArrayList<RejectEdiQtyVO>();
			rejectEdiVvdVO = new ArrayList<RejectEdiVvdVO>();
			rejectEdiCustVO = new ArrayList<RejectEdiCustVO>();
			rejectEdiDescVO = new ArrayList<RejectEdiDescVO>();
			rejectEdiInstrVO = new RejectEdiInstrVO();
			rejectEdiRefVO = new ArrayList<RejectEdiRefVO>();

			dbDao.modifyXterRqstReject(rjctRsnRmk, xterRjctRsnCd, account.getUsr_id(), xterRqstNoVO);
			
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(account.getOfc_cd().substring(0, 3));			

			if (!"WEB".equals(xterRqstNoVO.getSenderId())) {
				String msgType = "";
				if(xterRqstNoVO.getDocTpCd().equals("B")){
					rjctSndrRcvrVO = dbDao.searchRejectEdiHeader(xterRqstNoVO, "CUSTOMER_301_EDI_ID");
					msgType = "301";
				}
				
				if ( rjctSndrRcvrVO != null ) {
					ediHeader = bcUtil.searchEdiHeader(rjctSndrRcvrVO.getSndrId(), rjctSndrRcvrVO.getRcvId(), msgType);
					rejectEdiMstVO = dbDao.searchXterRqstMstForRejectEdi(xterRqstNoVO.getSenderId(), rjctRsnRmk, xterRqstNoVO);
					flatFile.append(ediHeader).append("\n");
					rejectEdiCntrVO = dbDao.searchXterCntrForRejectEdi(xterRqstNoVO);
					rejectEdiDgVO = dbDao.searchXterDgForRejectEdi(xterRqstNoVO);
					rejectEdiQtyVO = dbDao.searchXterQtyForRejectEdi(xterRqstNoVO);
					rejectEdiVvdVO = dbDao.searchXterVvdForRejectEdi(xterRqstNoVO);
					rejectEdiCustVO = dbDao.searchXterCustForRejectEdi(xterRqstNoVO);
					rejectEdiDescVO = dbDao.searchXterDescForRejectEdi(xterRqstNoVO);
					rejectEdiInstrVO = dbDao.searchXterInstrForRejeceEdi(xterRqstNoVO);
					rejectEdiRefVO = dbDao.searchXterRefForRejectEdi(xterRqstNoVO);
					
					if ( rejectEdiMstVO != null ) {
						flatFile.append("BKGNBR:"          ).append(rejectEdiMstVO.getBkgnbr()        ).append("\n");
						flatFile.append("BKG_DT:"          ).append(rejectEdiMstVO.getBkgDt()         ).append("\n");
						flatFile.append("BRAC:"            ).append(rejectEdiMstVO.getBrac()          ).append("\n");
						flatFile.append("BL_NO:"           ).append(rejectEdiMstVO.getBlNo()          ).append("\n");
						flatFile.append("BKG_LANE:"        ).append(rejectEdiMstVO.getBkgLane()       ).append("\n");
						flatFile.append("BV_LANE:"         ).append(rejectEdiMstVO.getBvLane()        ).append("\n");
						flatFile.append("TOVSL:"           ).append(rejectEdiMstVO.getTovsl()         ).append("\n");
						flatFile.append("LOYD:"            ).append(rejectEdiMstVO.getLoyd()          ).append("\n");
						flatFile.append("VSLNAME:"         ).append(rejectEdiMstVO.getVslname()       ).append("\n");
						flatFile.append("VSL_CALL_SIGN:"   ).append(rejectEdiMstVO.getVslCallSign()   ).append("\n");
						flatFile.append("VVD_REF_NO:"      ).append(rejectEdiMstVO.getVvdRefNo()      ).append("\n");
						flatFile.append("TOVOY:"           ).append(rejectEdiMstVO.getTovoy()         ).append("\n");
						flatFile.append("TODIR:"           ).append(rejectEdiMstVO.getTodir()         ).append("\n");
						flatFile.append("VSLLD:"           ).append(rejectEdiMstVO.getVslld()         ).append("\n");
						flatFile.append("VSLD:"            ).append(rejectEdiMstVO.getVsld()          ).append("\n");
						flatFile.append("OLDVSL:"          ).append(rejectEdiMstVO.getOldvsl()        ).append("\n");
						flatFile.append("OLDLOYD:"         ).append(rejectEdiMstVO.getOldloyd()       ).append("\n");
						flatFile.append("OLDVSLNAME:"      ).append(rejectEdiMstVO.getOldvslname()    ).append("\n");
						flatFile.append("OLDVSL_CALL_SIGN:").append(rejectEdiMstVO.getOldvslCallSign()).append("\n");
						flatFile.append("OLDVOY:"          ).append(rejectEdiMstVO.getOldvoy()        ).append("\n");
						flatFile.append("OLDDIR:"          ).append(rejectEdiMstVO.getOlddir()        ).append("\n");
						flatFile.append("TVSL:"            ).append(rejectEdiMstVO.getTvsl()          ).append("\n");
						flatFile.append("TLOYD:"           ).append(rejectEdiMstVO.getTloyd()         ).append("\n");
						flatFile.append("TVSLNAME:"        ).append(rejectEdiMstVO.getTvslname()      ).append("\n");
						flatFile.append("TVSL_CALL_SIGN:"  ).append(rejectEdiMstVO.getTvslCallSign()  ).append("\n");
						flatFile.append("TVOY:"            ).append(rejectEdiMstVO.getTvoy()          ).append("\n");
						flatFile.append("TDIR:"            ).append(rejectEdiMstVO.getTdir()          ).append("\n");
						flatFile.append("POR_NAME:" ).append(rejectEdiMstVO.getName1()   ).append("\n");
						flatFile.append("POR_QUAL:" ).append(rejectEdiMstVO.getQual1()   ).append("\n");
						flatFile.append("POR_PORT:" ).append(rejectEdiMstVO.getPort1()   ).append("\n");
						flatFile.append("POR_UNLC:" ).append(rejectEdiMstVO.getUnlc1()   ).append("\n");
						flatFile.append("POL_NAME:" ).append(rejectEdiMstVO.getName2()   ).append("\n");
						flatFile.append("POL_QUAL:" ).append(rejectEdiMstVO.getQual2()   ).append("\n");
						flatFile.append("POL_PORT:" ).append(rejectEdiMstVO.getPort2()   ).append("\n");
						flatFile.append("POL_UNLC:" ).append(rejectEdiMstVO.getUnlc2()   ).append("\n");
						flatFile.append("POL_ETA:"  ).append(rejectEdiMstVO.getEta2()    ).append("\n");
						flatFile.append("POL_ETD:"  ).append(rejectEdiMstVO.getEtd2()    ).append("\n");
						flatFile.append("POL_ETD_7:").append(rejectEdiMstVO.getEtd4()    ).append("\n");
						flatFile.append("BED:"      ).append(rejectEdiMstVO.getBed3()    ).append("\n");
						flatFile.append("CCT:"      ).append(rejectEdiMstVO.getCct2()    ).append("\n");
						flatFile.append("DCT:"      ).append(rejectEdiMstVO.getVpsCctDt()).append("\n");
						flatFile.append("POD_NAME:" ).append(rejectEdiMstVO.getName3()   ).append("\n");
						flatFile.append("POD_QUAL:" ).append(rejectEdiMstVO.getQual3()   ).append("\n");
						flatFile.append("POD_PORT:" ).append(rejectEdiMstVO.getPort3()   ).append("\n");
						flatFile.append("POD_UNLC:" ).append(rejectEdiMstVO.getUnlc3()   ).append("\n");
						flatFile.append("POD_ETA:"  ).append(rejectEdiMstVO.getEta3()    ).append("\n");
						flatFile.append("POD_ETA_1:").append(rejectEdiMstVO.getEta31()   ).append("\n");
						flatFile.append("POD_ETD:"  ).append(rejectEdiMstVO.getEtd3()    ).append("\n");
						flatFile.append("DEL_NAME:" ).append(rejectEdiMstVO.getName4()   ).append("\n");
						flatFile.append("DEL_QUAL:" ).append(rejectEdiMstVO.getQual4()   ).append("\n");
						flatFile.append("DEL_PORT:" ).append(rejectEdiMstVO.getPort4()   ).append("\n");
						flatFile.append("DEL_UNLC:" ).append(rejectEdiMstVO.getUnlc4()   ).append("\n");
						flatFile.append("DEL_ETA:"  ).append(rejectEdiMstVO.getEta4()    ).append("\n");
						flatFile.append("DEL_ETD:"  ).append(rejectEdiMstVO.getEtd4()    ).append("\n"); 
						flatFile.append("RLY_NAME:" ).append(rejectEdiMstVO.getName5()   ).append("\n");
						flatFile.append("RLY_QUAL:" ).append(rejectEdiMstVO.getQual5()   ).append("\n");
						flatFile.append("RLY_PORT:" ).append(rejectEdiMstVO.getPort5()   ).append("\n");
						flatFile.append("RLY_UNLC:" ).append(rejectEdiMstVO.getUnlc5()   ).append("\n");
						flatFile.append("RLY_ETA:\n"); 
						flatFile.append("RLY_ETD:\n"); 
						flatFile.append("RLY2_NAME:\n");
						flatFile.append("RLY2_QUAL:\n"); 
						flatFile.append("RLY2_PORT:\n"); 
						flatFile.append("RLY2_UNLC:\n");
						flatFile.append("RLY2_ETA:\n");
						flatFile.append("RLY2_ETD:\n"); 
						flatFile.append("FNLDST_NAME:\n"); 
						flatFile.append("FNLDST_QUAL:\n"); 
						flatFile.append("FNLDST_PORT:\n"); 
						flatFile.append("FNLDST_UNLC:\n"); 
						flatFile.append("FNLDST_ETA:\n"); 
						flatFile.append("PUNIT:"          ).append(rejectEdiMstVO.getPunit()         ).append("\n");
						flatFile.append("PKG:"            ).append(rejectEdiMstVO.getPkg()           ).append("\n");
						flatFile.append("WUNIT:"          ).append(rejectEdiMstVO.getWunit()         ).append("\n");
						flatFile.append("WGT:"            ).append(rejectEdiMstVO.getWgt()           ).append("\n");
						flatFile.append("EWUNIT:"         ).append(rejectEdiMstVO.getEwunit()        ).append("\n");
						flatFile.append("EWGT:"           ).append(rejectEdiMstVO.getEwgt()          ).append("\n");
						flatFile.append("MUNIT:"          ).append(rejectEdiMstVO.getMunit()         ).append("\n");
						flatFile.append("MEAS:"           ).append(rejectEdiMstVO.getMeas()          ).append("\n");
						flatFile.append("RDTYP:"          ).append(rejectEdiMstVO.getRdtyp()         ).append("\n");
						flatFile.append("SMOD:"           ).append(rejectEdiMstVO.getSmod()          ).append("\n");
						flatFile.append("TRUCK:"          ).append(rejectEdiMstVO.getTruck()         ).append("\n");
						flatFile.append("REMARK:"         ).append(rejectEdiMstVO.getRemark()        ).append("\n");
						flatFile.append("CMD:"            ).append(rejectEdiMstVO.getCmd()           ).append("\n");
						flatFile.append("CMDD:"           ).append(rejectEdiMstVO.getCmdd()          ).append("\n");
						flatFile.append("EQREL:"          ).append(rejectEdiMstVO.getEqrel()         ).append("\n");
						flatFile.append("LC_NO:\n"); 
						flatFile.append("INV_NO:\n"); 
						flatFile.append("ACI_FILER_NO:\n"); 
						flatFile.append("AMS_FILER_NO:\n");
						flatFile.append("CN_REF_NO:\n"); 
						flatFile.append("EX_LICENCE_NO:\n"); 
						flatFile.append("SHN1:"           ).append(rejectEdiMstVO.getShn1()          ).append("\n");
						flatFile.append("FFN1:"           ).append(rejectEdiMstVO.getFfn1()          ).append("\n");
						flatFile.append("CNE1:"           ).append(rejectEdiMstVO.getCne1()          ).append("\n");
						flatFile.append("SH_CD1:"         ).append(rejectEdiMstVO.getShCd1()         ).append("\n");
						flatFile.append("FF_CD1:"         ).append(rejectEdiMstVO.getFfCd1()         ).append("\n");
						flatFile.append("CN_CD1:"         ).append(rejectEdiMstVO.getCnCd1()         ).append("\n");
						flatFile.append("NTFY_CD:\n"); 
						flatFile.append("ANTFY_CD:\n");
						flatFile.append("3RD_NTFY_CD:\n"); 
						flatFile.append("SHPR1:"          ).append(rejectEdiMstVO.getShpr1()         ).append("\n");
						flatFile.append("SHPR2:"          ).append(rejectEdiMstVO.getShpr2()         ).append("\n");
						flatFile.append("SHPR3:"          ).append(rejectEdiMstVO.getShpr3()         ).append("\n");
						flatFile.append("SHPR4:"          ).append(rejectEdiMstVO.getShpr4()         ).append("\n");
						flatFile.append("SHPR5:"          ).append(rejectEdiMstVO.getShpr5()         ).append("\n");
						flatFile.append("CNEE1:"          ).append(rejectEdiMstVO.getCnee1()         ).append("\n");
						flatFile.append("CNEE2:"          ).append(rejectEdiMstVO.getCnee2()         ).append("\n");
						flatFile.append("CNEE3:"          ).append(rejectEdiMstVO.getCnee3()         ).append("\n");
						flatFile.append("CNEE4:"          ).append(rejectEdiMstVO.getCnee4()         ).append("\n");
						flatFile.append("CNEE5:"          ).append(rejectEdiMstVO.getCnee5()         ).append("\n");
						flatFile.append("FWDR1:\n"); 
						flatFile.append("FWDR2:\n"); 
						flatFile.append("FWDR3:\n"); 
						flatFile.append("FWDR4:\n"); 
						flatFile.append("FWDR5:\n"); 
						flatFile.append("NTFY1:"          ).append(rejectEdiMstVO.getNtfy1()         ).append("\n");
						flatFile.append("NTFY2:"          ).append(rejectEdiMstVO.getNtfy2()         ).append("\n");
						flatFile.append("NTFY3:"          ).append(rejectEdiMstVO.getNtfy3()         ).append("\n");
						flatFile.append("NTFY4:"          ).append(rejectEdiMstVO.getNtfy4()         ).append("\n");
						flatFile.append("NTFY5:"          ).append(rejectEdiMstVO.getNtfy5()         ).append("\n");
						flatFile.append("ANTFY1:\n");
						flatFile.append("ANTFY2:\n"); 
						flatFile.append("ANTFY3:\n"); 
						flatFile.append("ANTFY4:\n"); 
						flatFile.append("ANTFY5:\n");
						flatFile.append("CANCEL_BIT:"     ).append(rejectEdiMstVO.getCancelBit()     ).append("\n");
						flatFile.append("CARGOTYPE:"      ).append(rejectEdiMstVO.getCargotype()     ).append("\n");
						flatFile.append("OB_TRAFFIC_MD:"  ).append(rejectEdiMstVO.getObTrspModCd()   ).append("\n");
						flatFile.append("IB_TRAFFIC_MD:"  ).append(rejectEdiMstVO.getIbTrspModCd()   ).append("\n");					
						flatFile.append("DR_IND:"         ).append(rejectEdiMstVO.getDrInd()         ).append("\n");
						flatFile.append("RF_IND:"         ).append(rejectEdiMstVO.getRfInd()         ).append("\n");
						flatFile.append("AK_IND:"         ).append(rejectEdiMstVO.getAkInd()         ).append("\n");
						flatFile.append("BB_IND:"         ).append(rejectEdiMstVO.getBbInd()         ).append("\n");
						flatFile.append("HD_IND:"         ).append(rejectEdiMstVO.getHdInd()         ).append("\n");
						flatFile.append("UD_IND:"         ).append(rejectEdiMstVO.getUdInd()         ).append("\n");
						flatFile.append("UD_CD:"          ).append(rejectEdiMstVO.getUdCd()          ).append("\n");
						flatFile.append("RD_IND:"         ).append(rejectEdiMstVO.getRdUnd()         ).append("\n");
						flatFile.append("RF_CA:"          ).append(rejectEdiMstVO.getRfCa()          ).append("\n");
						flatFile.append("RF_MA:"          ).append(rejectEdiMstVO.getRfMa()          ).append("\n");
						flatFile.append("SOC_IND:"        ).append(rejectEdiMstVO.getSocInd()        ).append("\n");
						flatFile.append("SALES_OFFICE:"   ).append(rejectEdiMstVO.getSalesOffice()   ).append("\n");
						flatFile.append("SALES_NAME:"     ).append(rejectEdiMstVO.getSalesName()     ).append("\n");
						flatFile.append("BKG_STF:"        ).append(rejectEdiMstVO.getBkgStf()        ).append("\n");
						flatFile.append("BKG_STF_NAME:"   ).append(rejectEdiMstVO.getBkgStfName()    ).append("\n");
						flatFile.append("BKG_STF_TEL:"    ).append(rejectEdiMstVO.getBkgStfTel()     ).append("\n");
						flatFile.append("BKG_STF_FAX:"    ).append(rejectEdiMstVO.getBkgStfFax()     ).append("\n");
						flatFile.append("BKG_CPY_NAME:"   ).append(rejectEdiMstVO.getBkgCpyName()     ).append("\n");
						flatFile.append("CONTACT_NAME:"   ).append(rejectEdiMstVO.getContactName()   ).append("\n");
						flatFile.append("CONTACT_TEL:"    ).append(rejectEdiMstVO.getContactTel()    ).append("\n");
						flatFile.append("BOUND_IND:"      ).append(rejectEdiMstVO.getBoundInd()      ).append("\n");
						flatFile.append("REGIONAL_BKGNBR:").append(rejectEdiMstVO.getRegionalBkgnbr()).append("\n");
						flatFile.append("CUST_REF_NO:"    ).append(rejectEdiMstVO.getCustRefNo()     ).append("\n");
						flatFile.append("REF_VOYAGE:"     ).append(rejectEdiMstVO.getRefVoyage()     ).append("\n");
						flatFile.append("SO_NO:"          ).append(rejectEdiMstVO.getSoNo()          ).append("\n");
						flatFile.append("BLKSTWG:"        ).append(rejectEdiMstVO.getBlkstwg()       ).append("\n");
						flatFile.append("EQPICKDT:"       ).append(rejectEdiMstVO.getEqpickdt()      ).append("\n");
						flatFile.append("EQRTN:"          ).append(rejectEdiMstVO.getEqrtn()         ).append("\n");
						flatFile.append("PUCY_CNT:"       ).append(rejectEdiMstVO.getPucyCnt()       ).append("\n");
						flatFile.append("PUCY_CD:").append(rejectEdiMstVO.getPucyCd()).append("\n");
						flatFile.append("PUCY_NM:"   ).append(rejectEdiMstVO.getPucyNm()   ).append("\n");
						flatFile.append("PUCY_ADDR1:").append(rejectEdiMstVO.getPucyAddr1()).append("\n");
						flatFile.append("PUCY_ADDR2:").append(rejectEdiMstVO.getPucyAddr2()).append("\n");
						flatFile.append("PUCY_ADDR3:").append(rejectEdiMstVO.getPucyAddr3()).append("\n");
						flatFile.append("PUCY_ADDR4:").append(rejectEdiMstVO.getPucyAddr4()).append("\n");
						flatFile.append("PUCY_ADDR5:").append(rejectEdiMstVO.getPucyAddr5()).append("\n");
						flatFile.append("RTCY_CNT:"  ).append(rejectEdiMstVO.getRtcyCnt()  ).append("\n");
						flatFile.append("RTCY_CD:").append(rejectEdiMstVO.getRtcyCd()).append("\n");
						flatFile.append("RTCY_NM:"   ).append(rejectEdiMstVO.getRtcyNm()   ).append("\n");
						flatFile.append("RTCY_ADDR1:").append(rejectEdiMstVO.getRtcyAddr1()).append("\n");
						flatFile.append("RTCY_ADDR2:").append(rejectEdiMstVO.getRtcyAddr2()).append("\n");
						flatFile.append("RTCY_ADDR3:").append(rejectEdiMstVO.getRtcyAddr3()).append("\n");
						flatFile.append("RTCY_ADDR4:").append(rejectEdiMstVO.getRtcyAddr4()).append("\n");
						flatFile.append("RTCY_ADDR5:").append(rejectEdiMstVO.getRtcyAddr5()).append("\n");
						flatFile.append("BL_PO_NO:"  ).append(rejectEdiMstVO.getBlPoNo()   ).append("\n");
						flatFile.append("BL_SI_NO:"  ).append(rejectEdiMstVO.getBlSiNo()   ).append("\n");
						flatFile.append("FRT_TERM:").append(rejectEdiMstVO.getFrtTerm()   ).append("\n");
						flatFile.append("ONBOARD:").append(rejectEdiMstVO.getOnboard()   ).append("\n");
						flatFile.append("BKG_OFC:").append(rejectEdiMstVO.getBkgOfc()    ).append("\n");
						flatFile.append("SC_NO:").append(rejectEdiMstVO.getScNo()      ).append("\n");
						flatFile.append("GROUP_ID:").append(rejectEdiMstVO.getEdiGroupId()).append("\n");
						flatFile.append("BKG_VIA:").append(rejectEdiMstVO.getIbIeInd()   ).append("\n");
						flatFile.append("BKG_CUST_REF_NO:\n"); 
						flatFile.append("BKG_SH_REF_NO:\n"); 
						flatFile.append("BKG_FF_REF_NO:\n"); 
						flatFile.append("SI_CUST_REF_NO:\n"); 
						flatFile.append("SI_SH_REF_NO:\n"); 
						flatFile.append("SI_FF_REF_NO:\n"); 
					} else {
						flatFile.append("BKGNBR:\n");
						flatFile.append("BKG_DT:\n");
						flatFile.append("BRAC:\n");
						flatFile.append("BL_NO:\n");
						flatFile.append("BKG_LANE:\n");
						flatFile.append("BV_LANE:\n");
						flatFile.append("TOVSL:\n");
						flatFile.append("LOYD:\n");
						flatFile.append("VSLNAME:\n");
						flatFile.append("VSL_CALL_SIGN:\n");
						flatFile.append("VVD_REF_NO:\n");
						flatFile.append("TOVOY:\n");
						flatFile.append("TODIR:\n");
						flatFile.append("VSLLD:\n");
						flatFile.append("VSLD:\n");
						flatFile.append("OLDVSL:\n");
						flatFile.append("OLDLOYD:\n");
						flatFile.append("OLDVSLNAME:\n");
						flatFile.append("OLDVSL_CALL_SIGN:\n");
						flatFile.append("OLDVOY:\n");
						flatFile.append("OLDDIR:\n");
						flatFile.append("TVSL:\n");
						flatFile.append("TLOYD:\n");
						flatFile.append("TVSLNAME:\n");
						flatFile.append("TVSL_CALL_SIGN:\n");
						flatFile.append("TVOY:\n");
						flatFile.append("TDIR:\n");
						flatFile.append("POR_NAME:\n");
						flatFile.append("POR_QUAL:\n");
						flatFile.append("POR_PORT:\n");
						flatFile.append("POR_UNLC:\n");
						flatFile.append("POL_NAME:\n");
						flatFile.append("POL_QUAL:\n");
						flatFile.append("POL_PORT:\n");
						flatFile.append("POL_UNLC:\n");
						flatFile.append("POL_ETA:\n");
						flatFile.append("POL_ETD:\n");
						flatFile.append("POL_ETD_7:\n");
						flatFile.append("BED:\n");
						flatFile.append("CCT:\n");
						flatFile.append("DCT:\n");
						flatFile.append("POD_NAME:\n");
						flatFile.append("POD_QUAL:\n");
						flatFile.append("POD_PORT:\n");
						flatFile.append("POD_UNLC:\n");
						flatFile.append("POD_ETA:\n");
						flatFile.append("POD_ETA_1:\n");
						flatFile.append("POD_ETD:\n");
						flatFile.append("DEL_NAME:\n");
						flatFile.append("DEL_QUAL:\n");
						flatFile.append("DEL_PORT:\n");
						flatFile.append("DEL_UNLC:\n");
						flatFile.append("DEL_ETA:\n");
						flatFile.append("RLY_NAME:\n");
						flatFile.append("RLY_QUAL:\n");
						flatFile.append("RLY_PORT:\n");
						flatFile.append("RLY_UNLC:\n");
						flatFile.append("RLY_ETA:\n"); 
						flatFile.append("RLY_ETD:\n"); 
						flatFile.append("RLY2_NAME:\n"); 
						flatFile.append("RLY2_QUAL:\n");
						flatFile.append("RLY2_PORT:\n"); 
						flatFile.append("RLY2_UNLC:\n"); 
						flatFile.append("RLY2_ETA:\n"); 
						flatFile.append("RLY2_ETD:\n"); 
						flatFile.append("FNLDST_NAME:\n"); 
						flatFile.append("FNLDST_QUAL:\n"); 
						flatFile.append("FNLDST_PORT:\n"); 
						flatFile.append("FNLDST_UNLC:\n");
						flatFile.append("FNLDST_ETA:\n"); 
						flatFile.append("PUNIT:\n");
						flatFile.append("PKG:\n");
						flatFile.append("WUNIT:\n");
						flatFile.append("WGT:\n");
						flatFile.append("EWUNIT:\n");
						flatFile.append("EWGT:\n");
						flatFile.append("MUNIT:\n");
						flatFile.append("MEAS:\n");
						flatFile.append("RDTYP:\n");
						flatFile.append("SMOD:\n");
						flatFile.append("TRUCK:\n");
						flatFile.append("REMARK:\n");
						flatFile.append("CMD:\n");
						flatFile.append("CMDD:\n");
						flatFile.append("EQREL:\n");
						flatFile.append("SHN1:\n");
						flatFile.append("FFN1:\n");
						flatFile.append("CNE1:\n");
						flatFile.append("SH_CD1:\n");
						flatFile.append("FF_CD1:\n");
						flatFile.append("CN_CD1:\n");
						flatFile.append("SHPR1:\n");
						flatFile.append("SHPR2:\n");
						flatFile.append("SHPR3:\n");
						flatFile.append("SHPR4:\n");
						flatFile.append("SHPR5:\n");
						flatFile.append("CNEE1:\n");
						flatFile.append("CNEE2:\n");
						flatFile.append("CNEE3:\n");
						flatFile.append("CNEE4:\n");
						flatFile.append("CNEE5:\n");
						flatFile.append("NTFY1:\n");
						flatFile.append("NTFY2:\n");
						flatFile.append("NTFY3:\n");
						flatFile.append("NTFY4:\n");
						flatFile.append("NTFY5:\n");
						flatFile.append("CANCEL_BIT:\n");
						flatFile.append("CARGOTYPE:\n");
						flatFile.append("OB_TRAFFIC_MD:\n");
						flatFile.append("IB_TRAFFIC_MD:\n");
						flatFile.append("DR_IND:\n");
						flatFile.append("RF_IND:\n");
						flatFile.append("AK_IND:\n");
						flatFile.append("BB_IND:\n");
						flatFile.append("HD_IND:\n");
						flatFile.append("UD_IND:\n");
						flatFile.append("UD_CD:\n");
						flatFile.append("RD_IND:\n");
						flatFile.append("RF_CA:\n");
						flatFile.append("RF_MA:\n");
						flatFile.append("SOC_IND:\n");
						flatFile.append("SALES_OFFICE:\n");
						flatFile.append("SALES_NAME:\n");
						flatFile.append("BKG_STF:\n");
						flatFile.append("BKG_STF_NAME:\n");
						flatFile.append("BKG_STF_TEL:\n");
						flatFile.append("BKG_STF_FAX:\n");
						flatFile.append("CONTACT_NAME:\n");
						flatFile.append("CONTACT_TEL:\n");
						flatFile.append("BOUND_IND:\n");
						flatFile.append("REGIONAL_BKGNBR:\n");
						flatFile.append("CUST_REF_NO:\n");
						flatFile.append("REF_VOYAGE:\n");
						flatFile.append("SO_NO:\n");
						flatFile.append("BLKSTWG:\n");
						flatFile.append("EQPICKDT:\n");
						flatFile.append("EQRTN:\n");
						flatFile.append("PUCY_CNT:\n");
						flatFile.append("PUCY_CD:\n");
						flatFile.append("PUCY_NM:\n");
						flatFile.append("PUCY_ADDR1:\n");
						flatFile.append("PUCY_ADDR2:\n");
						flatFile.append("PUCY_ADDR3:\n");
						flatFile.append("PUCY_ADDR4:\n");
						flatFile.append("PUCY_ADDR5:\n");
						flatFile.append("RTCY_CNT:\n");
						flatFile.append("RTCY_CD:\n");
						flatFile.append("RTCY_NM:\n");
						flatFile.append("RTCY_ADDR1:\n");
						flatFile.append("RTCY_ADDR2:\n");
						flatFile.append("RTCY_ADDR3:\n");
						flatFile.append("RTCY_ADDR4:\n");
						flatFile.append("RTCY_ADDR5:\n");
						flatFile.append("BL_PO_NO:\n");
						flatFile.append("BL_SI_NO:\n");
						flatFile.append("FRT_TERM:\n");
						flatFile.append("ONBOARD:\n");
						flatFile.append("BKG_OFC:\n");
						flatFile.append("SC_NO:\n");
						flatFile.append("GROUP_ID:\n");
						flatFile.append("BKG_VIA:\n");
						flatFile.append("BKG_CUST_REF_NO:\n");
						flatFile.append("BKG_SH_REF_NO:\n");
						flatFile.append("BKG_FF_REF_NO:\n");
						flatFile.append("SI_CUST_REF_NO:\n");
						flatFile.append("SI_SH_REF_NO:\n"); 
						flatFile.append("SI_FF_REF_NO:\n"); 
					}
	
					if ( rejectEdiCntrVO.size() > 0 ) {
						for (int i=0;i<rejectEdiCntrVO.size();i++) {
							cntrVO = (RejectEdiCntrVO)rejectEdiCntrVO.get(i);
							flatFile.append("{CNTR_INFO\n");
							flatFile.append("CNTN:"           ).append(cntrVO.getACntrNo()            ).append("\n");
							flatFile.append("CNTT:"           ).append(cntrVO.getACntrTpsz()          ).append("\n");
							flatFile.append("OB_HAUL_TP:"     ).append(cntrVO.getObHlgTpCd()          ).append("\n");
							flatFile.append("IB_HAUL_TP:"     ).append(cntrVO.getIbHlgTpCd()          ).append("\n");
							flatFile.append("SEAL:"           ).append(cntrVO.getASealNo()            ).append("\n");
							flatFile.append("RIND:"           ).append(cntrVO.getACntrRind()          ).append("\n");
							flatFile.append("DIND:"           ).append(cntrVO.getACntrDind()          ).append("\n");
							flatFile.append("AIND:"           ).append(cntrVO.getACntrAind()          ).append("\n");
							flatFile.append("BIND:"           ).append(cntrVO.getACntrBind()          ).append("\n");
							flatFile.append("PKG_QTY:\n");
							flatFile.append("PKG_TP:\n");
							flatFile.append("MEA_QTY:\n");
							flatFile.append("MEA_TP:\n");
							flatFile.append("WGT_QTY:"        ).append(cntrVO.getACntrWgtQty()        ).append("\n");
							flatFile.append("WGT_TP:"         ).append(cntrVO.getACntrWgtTp()         ).append("\n");
							flatFile.append("TEMP:"           ).append(cntrVO.getACntrTemp()          ).append("\n");
							flatFile.append("TUN:"            ).append(cntrVO.getACntrTun()           ).append("\n");
							flatFile.append("TEMP_C:"         ).append(cntrVO.getACntrTempC()         ).append("\n");
							flatFile.append("TUN_C:"          ).append(cntrVO.getACntrTunC()          ).append("\n");
							flatFile.append("RF_VOLTAGE:"     ).append(cntrVO.getACntrRfVoltage()     ).append("\n");
							flatFile.append("VENT:"           ).append(cntrVO.getACntrVent()          ).append("\n");
							flatFile.append("HUMID:"          ).append(cntrVO.getACntrHumid()         ).append("\n");
							flatFile.append("GENSET:"         ).append(cntrVO.getACntrGenset()        ).append("\n");
							flatFile.append("RF_REMARK:"      ).append(cntrVO.getACntrRfRemark()      ).append("\n");
							flatFile.append("RFDRY_IND:"      ).append(cntrVO.getACntrRfdryInd()      ).append("\n");
							flatFile.append("OVF:"            ).append(cntrVO.getACntrOvf()           ).append("\n");
							flatFile.append("OVR:"            ).append(cntrVO.getACntrOvr()           ).append("\n");
							flatFile.append("OVH:"            ).append(cntrVO.getACntrOvh()           ).append("\n");
							flatFile.append("OVLW:"           ).append(cntrVO.getACntrOvlw()          ).append("\n");
							flatFile.append("OVRW:"           ).append(cntrVO.getACntrOvrw()          ).append("\n");
							flatFile.append("OVWGT:"          ).append(cntrVO.getACntrOvwgt()         ).append("\n");
							flatFile.append("VOID_SLOT:"      ).append(cntrVO.getACntrVoidSlot()      ).append("\n");
							flatFile.append("STWG_REQ:"       ).append(cntrVO.getACntrStwgReq()       ).append("\n");
							flatFile.append("TTL_DIM_LEN:"    ).append(cntrVO.getACntrTtlDimLen()     ).append("\n");
							flatFile.append("TTL_DIM_WDT:"    ).append(cntrVO.getACntrTtlDimWdt()     ).append("\n");
							flatFile.append("TTL_DIM_HGT:"    ).append(cntrVO.getACntrTtlDimHgt()     ).append("\n");
							flatFile.append("TRM_TYPE:"       ).append(cntrVO.getACntrTrmType()       ).append("\n");
							flatFile.append("TRM_WEIGHT:"     ).append(cntrVO.getACntrTrmWeight()     ).append("\n");
							flatFile.append("TRM_HAULAGE:"    ).append(cntrVO.getACntrTrmHaulage()    ).append("\n");
							flatFile.append("TRM_HMODE:"      ).append(cntrVO.getACntrTrmHmode()      ).append("\n");
							flatFile.append("TRM_PICKUP_CY:"  ).append(cntrVO.getACntrTrmPickupCy()   ).append("\n");
							flatFile.append("TRM_RETURN_CY:"  ).append(cntrVO.getACntrTrmReturnCy()   ).append("\n");
							flatFile.append("TRM_INSTRUCTION:").append(cntrVO.getACntrTrmInstruction()).append("\n");
							flatFile.append("TRM_TRAN_DT:"    ).append(cntrVO.getACntrTrmTranDt()     ).append("\n");
							flatFile.append("TRM_TRAN_OFFICE:").append(cntrVO.getACntrTrmTranOffice() ).append("\n");
							flatFile.append("TRM_TRAN_NO:"    ).append(cntrVO.getACntrTrmTranNo()     ).append("\n");
							flatFile.append("USR_ID:"         ).append(cntrVO.getACntrUsrId()         ).append("\n");
							flatFile.append("CNTR_RCV_TERM:\n");
							flatFile.append("CNTR_DLV_TERM:\n");
							flatFile.append("{CNTR_TRO_DTL\n");
							flatFile.append("TRD_ADDR:\n");
							flatFile.append("TRD_DOOR_LOC:\n");
							flatFile.append("TRD_DOOR_POSTAL:\n");
							flatFile.append("TRD_DOOR_DT:\n");
							flatFile.append("TRD_PERSON:\n");
							flatFile.append("TRD_TEL:\n");
							flatFile.append("TRD_FAX:\n");
							flatFile.append("TRD_ACTSHIP:\n");
							flatFile.append("TRD_REMARK:\n");
							flatFile.append("}CNTR_TRO_DTL\n");
							flatFile.append("}CNTR_INFO\n");
						}
					}else {
						flatFile.append("{CNTR_INFO\n");
						flatFile.append("CNTN:\n");
						flatFile.append("CNTT:\n");
						flatFile.append("OB_HAUL_TP:\n");
						flatFile.append("IB_HAUL_TP:\n");
						flatFile.append("SEAL:\n");
						flatFile.append("RIND:\n");
						flatFile.append("DIND:\n");
						flatFile.append("AIND:\n");
						flatFile.append("BIND:\n");
						flatFile.append("PKG_QTY:\n");
						flatFile.append("PKG_TP:\n");
						flatFile.append("MEA_QTY:\n");
						flatFile.append("MEA_TP:\n");
						flatFile.append("WGT_QTY:\n");
						flatFile.append("WGT_TP:\n");
						flatFile.append("TEMP:\n");
						flatFile.append("TUN:\n");
						flatFile.append("TEMP_C:\n");
						flatFile.append("TUN_C:\n");
						flatFile.append("RF_VOLTAGE:\n");
						flatFile.append("VENT:\n");
						flatFile.append("HUMID:\n");
						flatFile.append("GENSET:\n");
						flatFile.append("RF_REMARK:\n");
						flatFile.append("RFDRY_IND:\n");
						flatFile.append("OVF:\n");
						flatFile.append("OVR:\n");
						flatFile.append("OVH:\n");
						flatFile.append("OVLW:\n");
						flatFile.append("OVRW:\n");
						flatFile.append("OVWGT:\n");
						flatFile.append("VOID_SLOT:\n");
						flatFile.append("STWG_REQ:\n");
						flatFile.append("TTL_DIM_LEN:\n");
						flatFile.append("TTL_DIM_WDT:\n");
						flatFile.append("TTL_DIM_HGT:\n");
						flatFile.append("TRM_TYPE:\n");
						flatFile.append("TRM_WEIGHT:\n");
						flatFile.append("TRM_HAULAGE:\n");
						flatFile.append("TRM_HMODE:\n");
						flatFile.append("TRM_PICKUP_CY:\n");
						flatFile.append("TRM_RETURN_CY:\n");
						flatFile.append("TRM_INSTRUCTION:\n");
						flatFile.append("TRM_TRAN_DT:\n");
						flatFile.append("TRM_TRAN_OFFICE:\n");
						flatFile.append("TRM_TRAN_NO:\n");
						flatFile.append("USR_ID:\n");
						flatFile.append("CNTR_RCV_TERM:\n");
						flatFile.append("CNTR_DLV_TERM:\n");
						flatFile.append("{CNTR_TRO_DTL\n");
						flatFile.append("TRD_ADDR:\n");
						flatFile.append("TRD_DOOR_LOC:\n");
						flatFile.append("TRD_DOOR_POSTAL:\n");
						flatFile.append("TRD_DOOR_DT:\n");
						flatFile.append("TRD_PERSON:\n");
						flatFile.append("TRD_TEL:\n");
						flatFile.append("TRD_FAX:\n");
						flatFile.append("TRD_ACTSHIP:\n");
						flatFile.append("TRD_REMARK:\n");
						flatFile.append("}CNTR_TRO_DTL\n");
						flatFile.append("}CNTR_INFO\n");
					}
					
					if ( rejectEdiDgVO.size() > 0 ) {
						for (int k=0;k<rejectEdiDgVO.size();k++) {
							dgVO = (RejectEdiDgVO)rejectEdiDgVO.get(k);
							flatFile.append("{CNTR_DANGER\n");
							flatFile.append("UNBR:"      ).append(dgVO.getADgUnbr()     ).append("\n");
							flatFile.append("CLAS:"      ).append(dgVO.getADgClas()     ).append("\n");
							flatFile.append("DESC:"      ).append(dgVO.getADgDesc()     ).append("\n");
							flatFile.append("PHON:"      ).append(dgVO.getADgPhon()     ).append("\n");
							flatFile.append("PAGE:"      ).append(dgVO.getADgPage()     ).append("\n");
							flatFile.append("FPNT:"      ).append(dgVO.getADgFpnt()     ).append("\n");
							flatFile.append("FPUN:"      ).append(dgVO.getADgFpun()     ).append("\n");
							flatFile.append("DG_REMARK:" ).append(dgVO.getADgDgRemark() ).append("\n");
							flatFile.append("EMSNO:"     ).append(dgVO.getADgEmsno()    ).append("\n");
							flatFile.append("PSACLS:"    ).append(dgVO.getADgPsacls()   ).append("\n");
							flatFile.append("PKGGRP:"    ).append(dgVO.getADgPkggrp()   ).append("\n");
							flatFile.append("MFAG1:"     ).append(dgVO.getADgMfag1()    ).append("\n");
							flatFile.append("MFAG2:"     ).append(dgVO.getADgMfag2()    ).append("\n");
							flatFile.append("MAR_POLL:"  ).append(dgVO.getADgMarPoll()  ).append("\n");
							flatFile.append("LABEL_CD:"  ).append(dgVO.getADgLabelCd()  ).append("\n");
							flatFile.append("LABEL_DESC:").append(dgVO.getADgLabelDesc()).append("\n");
							flatFile.append("D_PKG:"     ).append(dgVO.getADgDPkg()     ).append("\n");
							flatFile.append("D_PKGUNIT:" ).append(dgVO.getADgDPkgunit() ).append("\n");
							flatFile.append("NWGT:"      ).append(dgVO.getADgNwgt()     ).append("\n");
							flatFile.append("NWGT_UNIT:" ).append(dgVO.getADgNwgtUnit() ).append("\n");
							flatFile.append("GWGT:"      ).append(dgVO.getADgGwgt()     ).append("\n");
							flatFile.append("GWGT_UNIT:" ).append(dgVO.getADgGwgtUnit() ).append("\n");
							flatFile.append("MEA:"       ).append(dgVO.getADgMea()      ).append("\n");
							flatFile.append("MEA_UNIT:"  ).append(dgVO.getADgMeaUnit()  ).append("\n");
							flatFile.append("HAZ_CONT:"  ).append(dgVO.getADgHazCont()  ).append("\n");
							flatFile.append("STWG:"      ).append(dgVO.getADgStwg()     ).append("\n");
							flatFile.append("LABEL:"     ).append(dgVO.getADgLabel()    ).append("\n");
							flatFile.append("PROPER_SHIP_NAME:\n");
							flatFile.append("CONT_TPSZ:\n");
							flatFile.append("CARGO_SEQ:\n");
							flatFile.append("}CNTR_DANGER\n");
						}
					} else {
						flatFile.append("{CNTR_DANGER\n");
						flatFile.append("UNBR:\n");
						flatFile.append("CLAS:\n");
						flatFile.append("DESC:\n");
						flatFile.append("PHON:\n");
						flatFile.append("PAGE:\n");
						flatFile.append("FPNT:\n");
						flatFile.append("FPUN:\n");
						flatFile.append("DG_REMARK:\n");
						flatFile.append("EMSNO:\n");
						flatFile.append("PSACLS:\n");
						flatFile.append("PKGGRP:\n");
						flatFile.append("MFAG1:\n");
						flatFile.append("MFAG2:\n");
						flatFile.append("MAR_POLL:\n");
						flatFile.append("LABEL_CD:\n");
						flatFile.append("LABEL_DESC:\n");
						flatFile.append("D_PKG:\n");
						flatFile.append("D_PKGUNIT:\n");
						flatFile.append("NWGT:\n");
						flatFile.append("NWGT_UNIT:\n");
						flatFile.append("GWGT:\n");
						flatFile.append("GWGT_UNIT:\n");
						flatFile.append("MEA:\n");
						flatFile.append("MEA_UNIT:\n");
						flatFile.append("HAZ_CONT:\n");
						flatFile.append("STWG:\n");
						flatFile.append("LABEL:\n");
						flatFile.append("PROPER_SHIP_NAME:\n");
						flatFile.append("CONT_TPSZ:\n");
						flatFile.append("CARGO_SEQ:\n");
						flatFile.append("}CNTR_DANGER\n");
					}	
					if ( rejectEdiQtyVO.size() > 0 ) {
						for (int i=0;i<rejectEdiQtyVO.size();i++) {
							qtyVO = (RejectEdiQtyVO)rejectEdiQtyVO.get(i);
							flatFile.append("{BL_CNTR\n");
							flatFile.append("HTYP:").append(qtyVO.getAQtyCntrCd() ).append("\n");
							flatFile.append("ITYP:").append(qtyVO.getAQtyItyp()   ).append("\n");
							flatFile.append("CNT:" ).append(qtyVO.getAQtyBqtyQty()).append("\n");
							flatFile.append("}BL_CNTR\n");
						}
					} else {
						flatFile.append("{BL_CNTR\n");
						flatFile.append("HTYP:\n");
						flatFile.append("ITYP:\n");
						flatFile.append("CNT:\n");
						flatFile.append("}BL_CNTR\n");
						
					}
					if ( rejectEdiVvdVO.size() > 0 ) {
						for (int j=0;j<rejectEdiVvdVO.size();j++) {
							RejectEdiVvdVO vvdVO = (RejectEdiVvdVO)rejectEdiVvdVO.get(j);
							flatFile.append("{BL_VVD\n");
							flatFile.append("VVDCODE:"         ).append(vvdVO.getVvdcode()       ).append("\n");
							flatFile.append("VVDLOYD:"         ).append(vvdVO.getVvdloyd ()      ).append("\n");
							flatFile.append("VVDVSLNAME:"      ).append(vvdVO.getVvdvslname ()   ).append("\n");
							flatFile.append("VVDVSL_CALL_SIGN:").append(vvdVO.getVvdvslCallSign()).append("\n");
							flatFile.append("VVDVOY:"          ).append(vvdVO.getVvdvoy()        ).append("\n");
							flatFile.append("VVDDIR:"          ).append(vvdVO.getVvddir()        ).append("\n");
							flatFile.append("VVDPOLUNLC:"      ).append(vvdVO.getVvdpolunlc()    ).append("\n");
							flatFile.append("VVDPOLNAME:"      ).append(vvdVO.getVvdpolname()    ).append("\n");
							flatFile.append("VVDPODUNLC:"      ).append(vvdVO.getVvdpodunlc()    ).append("\n");
							flatFile.append("VVDPODNAME:"      ).append(vvdVO.getVvdpodname()    ).append("\n");
							flatFile.append("REF1VVDVOY:"      ).append(vvdVO.getRef1vvdvoy()    ).append("\n");
							flatFile.append("VVDPOLETA:").append(vvdVO.getVvdpoleta()).append("\n");
							flatFile.append("VVDPOLETD:").append(vvdVO.getVvdpoletd()).append("\n");
							flatFile.append("VVDPODETA:").append(vvdVO.getVvdpodeta()).append("\n");
							flatFile.append("}BL_VVD\n");
						}
					} else {
						flatFile.append("{BL_VVD\n");
						flatFile.append("VVDCODE:\n");
						flatFile.append("VVDLOYD:\n");
						flatFile.append("VVDVSLNAME:\n");
						flatFile.append("VVDVSL_CALL_SIGN:\n");
						flatFile.append("VVDVOY:\n");
						flatFile.append("VVDDIR:\n");
						flatFile.append("VVDPOLUNLC:\n");
						flatFile.append("VVDPOLNAME:\n");
						flatFile.append("VVDPODUNLC:\n");
						flatFile.append("VVDPODNAME:\n");
						flatFile.append("REF1VVDVOY:\n");
						flatFile.append("VVDPOLETA:\n");
						flatFile.append("VVDPOLETD:\n");
						flatFile.append("VVDPODETA:\n");
						flatFile.append("}BL_VVD\n");
					}
					
					flatFile.append("{PO_INFO\n");
					flatFile.append("PO_BKG:\n");
					flatFile.append("PO_NO:\n");
					flatFile.append("PO_CNTR:\n");
					flatFile.append("PO_SEQ:\n");
					flatFile.append("PO_STOCK_NO:\n");
					flatFile.append("PO_DESC:\n");
					flatFile.append("PO_PKGU:\n");
					flatFile.append("PO_PKG_QTY:\n");
					flatFile.append("PO_WGTU:\n");
					flatFile.append("PO_WGT:\n");
					flatFile.append("PO_MEAU:\n");
					flatFile.append("PO_MEA:\n");
					flatFile.append("}PO_INFO\n");
	
					if ( rejectEdiDescVO.size() > 0 ) {
						for (int l=0;l<rejectEdiDescVO.size();l++) {
							descVO = (RejectEdiDescVO)rejectEdiDescVO.get(l);
							flatFile.append("{DESC\n");
							flatFile.append("DESC:").append(descVO.getBlDesc()).append("\n");
							flatFile.append("}DESC\n");
						}					
					} else {
						flatFile.append("{DESC\n");
						flatFile.append("DESC:\n");
						flatFile.append("}DESC\n");
					}
					
					flatFile.append("{CM_MARK_DESC\n");
					flatFile.append("CMD_SEQ:\n");
					flatFile.append("CMD_CNTR_NO:\n");
					flatFile.append("CMD_HTS_CD:\n");
					flatFile.append("CMD_PKG_CD:\n");
					flatFile.append("CMD_PKG_QTY:\n");
					flatFile.append("CMD_WGT_TP:\n");
					flatFile.append("CMD_WGT_QTY:\n");
					flatFile.append("CMD_MEA_TP:\n");
					flatFile.append("CMD_MEA_QTY:\n");
					flatFile.append("CMD_DESC:\n");
					flatFile.append("CMD_MARK:\n");
					flatFile.append("}CM_MARK_DESC\n");
					
	
					if ( rejectEdiInstrVO != null ) {
						flatFile.append("{I_BKG_INFO\n");
						flatFile.append("IB_EDI_ORG_ID:").append(rejectEdiInstrVO.getIbEdiOrgId()).append("\n");
						flatFile.append("IB_EDI_ID:"    ).append(rejectEdiInstrVO.getIbEdiId()   ).append("\n");
						flatFile.append("IB_POL_CD:"    ).append(rejectEdiInstrVO.getIbPolCd()   ).append("\n");
						flatFile.append("IB_POD_CD:"    ).append(rejectEdiInstrVO.getIbPodCd()   ).append("\n");
						flatFile.append("IB_PICKUP_DT:").append(rejectEdiInstrVO.getMtyPkupDt()).append("\n");
						flatFile.append("IB_ARV_R_DT:"  ).append(rejectEdiInstrVO.getRqstArrDt()  ).append("\n");
						flatFile.append("IB_RCV_TERM:"  ).append(rejectEdiInstrVO.getRcvTermCd()  ).append("\n");
						flatFile.append("IB_DLV_TERM:"  ).append(rejectEdiInstrVO.getDeTermCd()  ).append("\n");
						flatFile.append("CNTRTS_CD:"    ).append(rejectEdiInstrVO.getCntrtsCd()   ).append("\n");
						flatFile.append("IBI_POR_CD:"   ).append(rejectEdiInstrVO.getPorCtnt()    ).append("\n");
						flatFile.append("IBI_POR_CD_TP_CD:"   ).append(rejectEdiInstrVO.getXterPorTpCd()    ).append("\n");
						flatFile.append("IBI_POR_NM:"   ).append(rejectEdiInstrVO.getPorNm  ()    ).append("\n");
						flatFile.append("IBI_POL_CD:"   ).append(rejectEdiInstrVO.getPolCtnt()    ).append("\n");
						flatFile.append("IBI_POL_CD_TP_CD:"   ).append(rejectEdiInstrVO.getXterPolTpCd()    ).append("\n");
						flatFile.append("IBI_POL_NM:"   ).append(rejectEdiInstrVO.getPolNm  ()    ).append("\n");
						flatFile.append("IBI_POD_CD:"   ).append(rejectEdiInstrVO.getPodCtnt()    ).append("\n");
						flatFile.append("IBI_POD_CD_TP_CD:"   ).append(rejectEdiInstrVO.getXterPodTpCd()    ).append("\n");
						flatFile.append("IBI_POD_NM:"   ).append(rejectEdiInstrVO.getPodNm  ()    ).append("\n");
						flatFile.append("IBI_DEL_CD:"   ).append(rejectEdiInstrVO.getDelCtnt()    ).append("\n");
						flatFile.append("IBI_DEL_CD_TP_CD:"   ).append(rejectEdiInstrVO.getXterDelTpCd()    ).append("\n");
						flatFile.append("IBI_DEL_NM:"   ).append(rejectEdiInstrVO.getDelNm  ()    ).append("\n");
						flatFile.append("IBI_TRANS_IND:").append(rejectEdiInstrVO.getTrnsIndCtnt()).append("\n");
						flatFile.append("IBI_PARTNER_MSG_DT:").append(rejectEdiInstrVO.getPrnrMsgDt()).append("\n");
						flatFile.append("IBI_IB_BKG_IND:").append(rejectEdiInstrVO.getXterBkgRqstStsCd()).append("\n");
						flatFile.append("IBI_CUST_REMARK:").append(rejectEdiInstrVO.getXterBkgRmk1()).append("\n");
						flatFile.append("}I_BKG_INFO\n");
					} else {
						flatFile.append("{I_BKG_INFO\n");
						flatFile.append("IB_EDI_ORG_ID:\n");
						flatFile.append("IB_EDI_ID:\n");
						flatFile.append("IB_POL_CD:\n");
						flatFile.append("IB_POD_CD:\n");
						flatFile.append("IB_PICKUP_DT:\n");
						flatFile.append("IB_ARV_R_DT:\n");
						flatFile.append("IB_RCV_TERM:\n");
						flatFile.append("IB_DLV_TERM:\n");
						flatFile.append("CNTRTS_CD:\n");
						flatFile.append("IBI_POR_CD:\n");
						flatFile.append("IBI_POR_CD_TP_CD:\n");
						flatFile.append("IBI_POR_NM:\n");
						flatFile.append("IBI_POL_CD:\n");
						flatFile.append("IBI_POL_CD_TP_CD:\n");
						flatFile.append("IBI_POL_NM:\n");
						flatFile.append("IBI_POD_CD:\n");
						flatFile.append("IBI_POD_CD_TP_CD:\n");
						flatFile.append("IBI_POD_NM:\n");
						flatFile.append("IBI_DEL_CD:\n");
						flatFile.append("IBI_DEL_CD_TP_CD:\n");
						flatFile.append("IBI_DEL_NM:\n");
						flatFile.append("IBI_TRANS_IND:\n");
						flatFile.append("IBI_PARTNER_MSG_DT:\n");
						flatFile.append("IBI_IB_BKG_IND:\n");
						flatFile.append("IBI_CUST_REMARK:\n");
						flatFile.append("}I_BKG_INFO\n");
					}
					
					if ( rejectEdiCustVO.size() > 0 ) {
						for (int k=0;k<rejectEdiCustVO.size();k++) {
							RejectEdiCustVO custVO = (RejectEdiCustVO)rejectEdiCustVO.get(k);
							flatFile.append("{I_BKG_CUST\n");
							flatFile.append("IBCS_TP:"      ).append(custVO.getIbcsTp()     ).append("\n");
							flatFile.append("IBCS_NM1:"     ).append(custVO.getIbcsNm1()    ).append("\n");
							flatFile.append("IBCS_NM2:"     ).append(custVO.getIbcsNm2()    ).append("\n");
							flatFile.append("IBCS_ADDR1:"   ).append(custVO.getIbcsAddr1()  ).append("\n");
							flatFile.append("IBCS_ADDR2:"   ).append(custVO.getIbcsAddr2()  ).append("\n");
							flatFile.append("IBCS_ADDR3:"   ).append(custVO.getIbcsAddr3()  ).append("\n");
							flatFile.append("IBCS_ADDR4:"   ).append(custVO.getIbcsAddr4()  ).append("\n");
							flatFile.append("IBCS_ADDR5:"   ).append(custVO.getIbcsAddr5()  ).append("\n");
							flatFile.append("IBCS_C_NM1:"   ).append(custVO.getIbcsCNm1()   ).append("\n");
							flatFile.append("IBCS_C_NM2:"   ).append(custVO.getIbcsCNm2()   ).append("\n");
							flatFile.append("CNT_CD:"       ).append(custVO.getCntCd()      ).append("\n");
							flatFile.append("CUST_CD:"      ).append(custVO.getCustCd()     ).append("\n");
							flatFile.append("UN_CUST_CD:"      ).append(custVO.getUnLocCd()     ).append("\n");
							flatFile.append("PCC_CUST_CD:"      ).append(custVO.getPrnrCustCd()     ).append("\n");
							flatFile.append("PARTNER_REF_NO:"      ).append(custVO.getPrnrRefNo()     ).append("\n");
							flatFile.append("IBCS_CUST_LOC:").append(custVO.getIbcsCustLoc()).append("\n");
							flatFile.append("IBCS_STREET:"  ).append(custVO.getIbcsStreet() ).append("\n");
							flatFile.append("IBCS_LOC_CD:"  ).append(custVO.getIbcsLocCd()  ).append("\n");
							flatFile.append("IBCS_LOC_NM:"  ).append(custVO.getIbcsLocNm()  ).append("\n");
							flatFile.append("IBCS_ZIP_CD:"  ).append(custVO.getIbcsZipCd()  ).append("\n");
							flatFile.append("IBCS_STATE_CD:"  ).append(custVO.getSteCd()  ).append("\n");
							flatFile.append("IBCS_UNLOC_CD:"  ).append(custVO.getIbcsLocCd()  ).append("\n");
							flatFile.append("IBCS_C_TP:"    ).append(custVO.getIbcsCTp()    ).append("\n");
							flatFile.append("IBCS_C_TEL:"   ).append(custVO.getIbcsCTel()   ).append("\n");
							flatFile.append("IBCS_C_FAX:"   ).append(custVO.getIbcsCFax()   ).append("\n");
							flatFile.append("IBCS_C_EMAIL:" ).append(custVO.getIbcsCEmail() ).append("\n");
							flatFile.append("}I_BKG_CUST\n");
						}
					} else {
						flatFile.append("{I_BKG_CUST\n");
						flatFile.append("IBCS_TP:\n");
						flatFile.append("IBCS_NM1:\n");
						flatFile.append("IBCS_NM2:\n");
						flatFile.append("IBCS_ADDR1:\n");
						flatFile.append("IBCS_ADDR2:\n");
						flatFile.append("IBCS_ADDR3:\n");
						flatFile.append("IBCS_ADDR4:\n");
						flatFile.append("IBCS_ADDR5:\n");
						flatFile.append("IBCS_C_NM1:\n");
						flatFile.append("IBCS_C_NM2:\n");
						flatFile.append("CNT_CD:\n");
						flatFile.append("CUST_CD:\n");
						flatFile.append("UN_CUST_CD:\n");
						flatFile.append("PCC_CUST_CD:\n");
						flatFile.append("PARTNER_REF_NO:\n");
						flatFile.append("IBCS_CUST_LOC:\n");
						flatFile.append("IBCS_STREET:\n");
						flatFile.append("IBCS_LOC_CD:\n");
						flatFile.append("IBCS_LOC_NM:\n");
						flatFile.append("IBCS_ZIP_CD:\n");
						flatFile.append("IBCS_STATE_CD:\n");
						flatFile.append("IBCS_UNLOC_CD:\n");
						flatFile.append("IBCS_C_TP:\n");
						flatFile.append("IBCS_C_TEL:\n");
						flatFile.append("IBCS_C_FAX:\n");
						flatFile.append("IBCS_C_EMAIL:\n");
						flatFile.append("}I_BKG_CUST \n");
					}
					
					flatFile.append("{I_CM_MARK_DESC\n");
					flatFile.append("ICMD_SEQ:\n");
					flatFile.append("ICMD_CNTR_NO:\n");
					flatFile.append("ICMD_HTS_CD:\n");
					flatFile.append("ICMD_PKG_CD:\n");
					flatFile.append("ICMD_PKG_CD_DESC:\n");
					flatFile.append("ICMD_PKG_QTY:\n");
					flatFile.append("ICMD_WGT_TP:\n");
					flatFile.append("ICMD_WGT_QTY:\n");
					flatFile.append("ICMD_NET_WGT_TP:\n");
					flatFile.append("ICMD_NET_WGT_QTY:\n");
					flatFile.append("ICMD_MEA_TP:\n");
					flatFile.append("ICMD_MEA_QTY:\n");
					flatFile.append("ICMD_DESC:\n");
					flatFile.append("ICMD_DESC_DTL:\n");
					flatFile.append("ICMD_MARK:\n");
					flatFile.append("ICMD_OB_HAUL_TP:\n");
					flatFile.append("ICMD_IB_HAUL_TP:\n");
					flatFile.append("}I_CM_MARK_DESC\n");
	
					if ( rejectEdiRefVO.size() > 0 ) {
						for (int l=0;l<rejectEdiRefVO.size();l++) {
							RejectEdiRefVO refVO = (RejectEdiRefVO)rejectEdiRefVO.get(l);
							flatFile.append("{I_BKG_REF\n");
							flatFile.append("IB_REF_CD:"   ).append(refVO.getRefCd()   ).append("\n");
							flatFile.append("IB_REF_DESC:" ).append(refVO.getRefCdDesc()   ).append("\n");
							flatFile.append("IB_REF_NO:"   ).append(refVO.getRefNo()   ).append("\n");
							flatFile.append("}I_BKG_REF\n");
						}					
					} else {
						flatFile.append("{I_BKG_REF\n");
						flatFile.append("IB_REF_CD:\n");
						flatFile.append("IB_REF_DESC:\n");
						flatFile.append("IB_REF_NO:\n");
						flatFile.append("}I_BKG_REF\n");
					}				
					
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					String queueNm = SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER_301.IBMMQ.QUEUE");
					log.debug("QUEUE NAME:"+queueNm);
					sendFlatFileVO.setQueueNm(queueNm);
					FlatFileAckVO flatFileAckVO = bcUtil.sendFlatFile(sendFlatFileVO);
					log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());
					if ( flatFileAckVO.getAckStsCd().equals("E") )
						throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
				
				}
			}

			log.debug("RESULT:"+flatFile.toString());
		}catch(EventException e){
			throw e;
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}
	
	/**
	 * external request Ack Edi Flatfile create.<br> 
	 * (send_OPUSBKG_UBIZCOM_ACK)<br>
	 * @param docTpCd
	 * @param hrdCdgId
	 * @param xterRqstNoVO
	 * @return
	 * @throws EventException
	 */
	public String createXterBkgAckEdi(String docTpCd, String hrdCdgId, XterRqstNoVO xterRqstNoVO) throws EventException {
        BookingUtil bcUtil = null;
		String ackRcv = null;
		String ediSeq = null;
		String resCd = null;
		String flatFile = "";
		List<String> refInfos = null;
		List<String> custInfos = null;
		SendFlatFileVO sendFlatFileVO = null;
		FlatFileAckVO flatFileAckVO = null;
		try {
	        bcUtil = new BookingUtil();

			ackRcv = dbDao.searchXterBkgAckReceiver(xterRqstNoVO.getSenderId(), hrdCdgId);
			if ( !isNull(ackRcv) && "Y".equals(ackRcv) ) {
				//ediSeq = dbDao.searchXterEdiSeqAck();

				ediSeq = ReferenceNumberGeneratorBroker.getKey("BKG","BKG_EDI_SEQ");
				
				if(hrdCdgId.equalsIgnoreCase("XTER_ACK_REJECT")){
					resCd = "Reject";
				}else{
					resCd = "Approve";
				}
				flatFile = dbDao.searchXterBkgAck(docTpCd, xterRqstNoVO, ediSeq, resCd, hrdCdgId);
				refInfos = dbDao.searchXterRefAck(xterRqstNoVO);
				custInfos = dbDao.searchXterCustAck(xterRqstNoVO);
				StringBuffer strBuffer = new StringBuffer();
				if(refInfos != null || custInfos != null) {
					strBuffer.append("\n");
				}
				if(refInfos != null) {
					for(int idx = 0 ; idx < refInfos.size(); idx++) {
						strBuffer.append(refInfos.get(idx)).append("\n");
					}
				}
				if(custInfos != null) {
					for(int idx = 0 ; idx < custInfos.size(); idx++) {
						strBuffer.append(custInfos.get(idx)).append("\n");
					}
				}
				
				flatFile += strBuffer.toString();
				sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile);
				String queueNm = SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_ACK.IBMMQ.QUEUE");
				log.debug("QUEUE NAME:"+queueNm);
				sendFlatFileVO.setQueueNm(queueNm);
				flatFileAckVO = bcUtil.sendFlatFile(sendFlatFileVO);
				log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

				if ( "E".equals(flatFileAckVO.getAckStsCd()) ) {
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
				}
				log.debug("RESULT:"+flatFile);
			}
		}catch(EventException e){
			throw e;
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return flatFile;
	}
   	/**
	 * Char Count<br>
	 *
	 * @param String   src
	 * @param char   c
	 * @return int
	 */
	private int countChar(String src,char c) {
		int count=0;
		if (src!=null) {
			for (int i=0;i<src.length();i++) {
				if (src.charAt(i)==c) {
					count++;
				}
			}
		}
		return count;
	}
   	/**
	 * String split<br>
	 *
	 * @param String   src
	 * @param char   sep
	 * @return String[]
	 */
	private String[] splitString(String src,char sep) {
		String[] dest=null;
		if (src!=null && src.length()>0) {
			int count=countChar(src,sep)+1;
			int startIndex=0;
			int endIndex=0;
			dest=new String[count];
			for (int i=0;i<count;i++) {
				if ((endIndex=src.indexOf(sep,startIndex))<0) {
					endIndex=src.length();
				}
				dest[i]=src.substring(startIndex,endIndex);
				startIndex=endIndex+1;
			}
		}
		return dest;
	}
   	/**
	 * Char remove<br>
	 *
	 * @param String   str
	 * @param char   delim
	 * @return String
	 */
	private String remove(String str, char delim){
		if (str == null || str.length() == 0 || delim == 0 ) {
            return str;
        }
		char[] chars = str.toCharArray();
		StringBuffer buffer = new StringBuffer(str.length());
		int len = chars.length;
		for(int i = 0; i<len ; i++){
			if(chars[i] != delim) buffer.append(chars[i]);
		}
		return buffer.toString();
	}
   	/**
	 * Null replace<br>
	 *
	 * @param String str
	 * @return String
	 */
    private String replaceNull(String str) {
        return (str==null)?"":str;
    }
   	/**
	 * Null check<br>
	 *
	 * @param String str
	 * @return boolean
	 */
    private boolean isNull(String str) {
        return (str==null || str.trim().length()==0 || "null".equals(str));
    }

   	/**
	 * first sep split return<br>
	 *
	 * @param String   str
	 * @param String   sep
	 * @return String[]
	 */
	private String[] splitByToken(String str, String sep) {
        String[] retStr = new String[2];

        int splitNo = str.indexOf(sep);
	    retStr[0] = str.substring(0, splitNo);
	    retStr[1] = str.substring(splitNo+1, str.length());

        return retStr;
    }
	
   	/**
	 * bkg_no, bkg_no_split assign.<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @throws EventException 
	 */
	public void assignBkgNoToXterRqst(XterRqstNoVO rqstNoVo) throws EventException {
		BookingUtil utilBC = null;		
		String xterBkgBlNo = null;
		BkgBlNoVO bkgBlNoVO = null;
		BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = null;
		List<BkgHrdCdgCtntVO> ackReceiver = null;
		String senderId = null;
		StringBuilder flatFileSB = null;
		String flatFile = "";
		SendFlatFileVO sendFlatFileVO = null;
		FlatFileAckVO flatFileAckVO = null;
		utilBC = new BookingUtil();	
		try {
			if(rqstNoVo.getSenderId() == null) return;

/**********************************************************
// 			bkg no auto seq validate. 
//			1. Samsung Booking Request, auto Booking Confirmation document creation
//          2. BumHan Logistics Shipping Instructions(Master,seq1), Booking Number auto creation.
**********************************************************/
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO2 = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO2.setHrdCdgId("XTER_AUTO_BKG_NO");
			bkgHrdCdgCtntListCondVO2.setAttrCtnt1(rqstNoVo.getSenderId());
			bkgHrdCdgCtntListCondVO2.setAttrCtnt2(rqstNoVo.getDocTpCd());
			List<BkgHrdCdgCtntVO> bkgNoAssign = utilBC.searchHardCoding(bkgHrdCdgCtntListCondVO2);
			if(bkgNoAssign.size() > 0){
				if(rqstNoVo.getSenderId().equals("PKEXM010") && !"H".equals(replaceNull(rqstNoVo.getXterBlTpCd())) && rqstNoVo.getRqstSeq().equals("1")){
					log.debug("PKEXM010+master rqst 진행");
//					return rqstNoVo;
				} else if(!rqstNoVo.getSenderId().equals("PKEXM010") ) {
					log.debug("PKEXM010 rqst 진행");
//					return rqstNoVo;
				} else {
					return ;
				}
			} else {
				return ;
			}
			xterBkgBlNo = dbDao.searchXterRqstMstBkgNo(rqstNoVo);
			rqstNoVo.setBkgNo(xterBkgBlNo);
			if (xterBkgBlNo == null ) {					
				bkgBlNoVO = utilBC.manageBkgNumberGeneration("BKG", "SELSC", "SYSTEM");
				rqstNoVo.setBkgNo(bkgBlNoVO.getBkgNo() + "00"); 
			}

			dbDao.assignBkgNoToXterRqst(rqstNoVo);
			

			bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("XTER_AUTO_BKG_RCT");
			bkgHrdCdgCtntListCondVO.setAttrCtnt1(rqstNoVo.getSenderId());
			ackReceiver = utilBC.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			if (ackReceiver.size()==0) return;
			
			if (rqstNoVo.getSenderId().substring(0,4).equals("C1T0")){
				senderId = "C1T0WOCOM1";
			} else if(rqstNoVo.getSenderId().substring(0,5).equals("110AL")){ 
				senderId = "C1T0WCOM1";	
			} else {
				senderId = "COMPANYSHIP";
			}
			
			//flatfile creation
			flatFileSB = new StringBuilder();
			String [] flatFileStr = new String[6];
			flatFileSB.append(utilBC.searchEdiHeader(senderId, rqstNoVo.getSenderId(), "BOKCON") + "\n");
			
			flatFileStr[0] = dbDao.searchXterRqstMstForAck(rqstNoVo);				
			flatFileStr[1] = dbDao.searchXterRqstMiscForAck(rqstNoVo);
			flatFileStr[2] = dbDao.searchXterCustForAck(rqstNoVo);
			flatFileStr[3] = dbDao.searchXterTroForAck(rqstNoVo);
			flatFileStr[4] = dbDao.searchXterTroDtlForAck(rqstNoVo);
			flatFileStr[5] = dbDao.searchXterDescForAck(rqstNoVo);
			
			for(int i = 0; i < 6; i++){
				if(flatFileStr[i] != null){
//					log.debug("flatFileStr[i]:"+flatFileStr[i]);
					flatFileSB.append(flatFileStr[i]);
				}
			}				

			flatFile = flatFileSB.toString();				
			log.debug("FlatFile:" + flatFile);
			
			// auto confirm edi flatfile send
			sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile);
			String queueNm = SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER_301.IBMMQ.QUEUE");
			sendFlatFileVO.setQueueNm(queueNm);
			flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
			log.debug("ACT_STS1:"+flatFileAckVO.getAckStsCd());

			if ( flatFileAckVO.getAckStsCd().equals("E") )
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

			// auto confirm history
			dbDao.modifyAutoBkgRctSend(rqstNoVo);
		}catch(EventException e){
			throw e;
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * bkg_xter_rqst upload history.<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void completeUpload(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException{
		try {
			//in bkg_xter_rqst_mst, upload history
			dbDao.updateXterRqstCfm(rqstNoVO, account);

			dbDao.updateXterShipper(rqstNoVO, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}		
	}
	
	/**
	 * eBkg Customer Code info update<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterCustCustCd(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyXterCustCustCd(rqstNoVO, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * in situation Bkg No auto create, info update in BKG_XTER_RQST_MST<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterBkgNo(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyXterBkgNo(rqstNoVO, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * retrieve event handling<br>
	 * Po No info retrieve <br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return BkgReferenceVO
	 * @exception EventException
	 */
	public BkgReferenceVO searchOpusPoNo(String bkgNo, String cntrNo ) throws EventException {
		BkgReferenceVO bkgReferenceVO = null;
		try {
			bkgReferenceVO = new BkgReferenceVO();
			bkgReferenceVO = dbDao.searchOpusPoNo(bkgNo, cntrNo);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgReferenceVO;
	}
	
	/**
	 * external request condition retrieve<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterInnerPackageVO>
	 * @exception EventException
	 */
	public List<XterInnerPackageVO> searchXterInnerPackage(XterRqstNoVO xterRqstNoVO) throws EventException {
		try {
			return dbDao.searchXterInnerPackage(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Container tVvd CgoTpCd retrieve<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return CntrEtcInfoVO
	 * @exception EventException
	 */
	public CntrEtcInfoVO manageCntrEtcInfo(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.manageCntrEtcInfo(bkgBlNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * B/L ISS retrieve(ESM_BKG_022901)<br>
	 * 
	 * @author 	KimByungKyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	public void searchBlIss(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {

			if("Y".equals(dbDao.searchBlIss(bkgBlNoVO))){
				throw new EventException((String)new ErrorHandler("BKG02058").getMessage());
			}
		} catch (EventException ex) {
			throw ex;		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * Booking No save.<br>
	 *
	 * @param XterRqstNoVO[] xterRqstNoVO
	 * @exception EventException
	 */
	public void changeXterRqstBkgNo(XterRqstNoVO[] xterRqstNoVO) throws EventException{
		List<XterRqstNoVO> updateVoList = null;
		try {
			updateVoList = new ArrayList<XterRqstNoVO>();
			for ( int i=0; i<xterRqstNoVO.length; i++ ) {
				if ( xterRqstNoVO[i].getIbflag().equals("U")){
					updateVoList.add(xterRqstNoVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.changeXterRqstBkgNo(updateVoList);
			}
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EBookingReceipt Seanaccs Validation info retrieve<br>
	 *
	 * @param ExternalRqstListInputVO xterRqstListInputVO
	 * @return XterRqstValidationVO
	 * @exception EventException
	 */
	public XterRqstValidationVO searchXterRqstValidation(ExternalRqstListInputVO xterRqstListInputVO) throws EventException {
		try {
	        return dbDao.searchXterRqstValidation(xterRqstListInputVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * searchMqXlsGroupList info retrieve<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsGroupList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException {
		try {
	        return dbDao.searchMqXlsGroupList(bkgHrdCdgCtntVO);
	    } catch (DAOException de) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * searchMqXlsMappingList info retrieve<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException {
		try {
	        return dbDao.searchMqXlsMappingList(bkgHrdCdgCtntVO);
	    } catch (DAOException de) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * searchMqXmlMappingList info retrieve<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXmlMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException {
		try {
	        return dbDao.searchMqXmlMappingList(bkgHrdCdgCtntVO);
	    } catch (DAOException de) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * opus d/g rider search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchOpusDgRiderList(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		try {
			return dbDao.searchOpusDgRiderList(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * opus d/g rider cntr list search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchOpusDgRiderCntrList(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		String checkBoxString="";
		try {
			List<DgRiderCntrListVO> dgRiderCntrListVOs = dbDao.searchOpusDgRiderCntrList(xterRqstNoVO);
			//화면단에서 컨트롤하기 어려워 컨터이너 데이터 가공처리
			StringBuffer cBoxBuf = new StringBuffer("");

			cBoxBuf.append("<table width='100%' class='grid2' border='0' id= t_table>");
			if(dgRiderCntrListVOs.size() > 0){
				Iterator<DgRiderCntrListVO> list = dgRiderCntrListVOs.iterator();
	        	while(list.hasNext()){
	        		DgRiderCntrListVO dgRiderCntrListVO = (DgRiderCntrListVO)list.next();
	        		cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
	        		cBoxBuf.append("<input type='checkbox' name='t_check'  value='"+dgRiderCntrListVO.getCargoValue()+"'></td>");
	        		cBoxBuf.append("<td width='90%' align='center'>"+dgRiderCntrListVO.getCargoName()+"</td>");
	        		cBoxBuf.append("<input type='hidden' name='t_name' value='"+dgRiderCntrListVO.getCargoName()+"'></tr>");
	        	}
			}else{
				cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
				cBoxBuf.append("no data... </td></tr>");
			}
			cBoxBuf.append("</table>");

        	checkBoxString = cBoxBuf.toString();

        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
		return checkBoxString;	
	}	

	/**
	 * e-svc d/g rider search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchXterDgRiderList(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		try {
			return dbDao.searchXterDgRiderList(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}		
	}	
	
	/**
	 * e-svc d/g rider cntr list search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchXterDgRiderCntrList(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		String checkBoxString="";
		try {
			List<DgRiderCntrListVO> dgRiderCntrListVOs = dbDao.searchXterDgRiderCntrList(xterRqstNoVO);
			//화면단에서 컨트롤하기 어려워 컨터이너 데이터 가공처리
			StringBuffer cBoxBuf = new StringBuffer("");

			cBoxBuf.append("<table width='100%' class='grid2' border='0' id= t_table2>");
			if(dgRiderCntrListVOs.size() > 0){
				Iterator<DgRiderCntrListVO> list = dgRiderCntrListVOs.iterator();
	        	while(list.hasNext()){
	        		DgRiderCntrListVO dgRiderCntrListVO = (DgRiderCntrListVO)list.next();
	        		cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
	        		cBoxBuf.append("<input type='checkbox' name='t_check2'  value='"+dgRiderCntrListVO.getCargoValue()+"' disabled></td>");
	        		cBoxBuf.append("<td width='90%' align='center'>"+dgRiderCntrListVO.getCargoName()+"</td>");
	        		cBoxBuf.append("<input type='hidden' name='t_name2' value='"+dgRiderCntrListVO.getCargoName()+"'></tr>");
	        	}
			}else{
				cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
				cBoxBuf.append("no data... </td></tr>");
			}
			cBoxBuf.append("</table>");

        	checkBoxString = cBoxBuf.toString();

        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
		return checkBoxString;	
	}	
	
	/**
	 * eBkg Customer Name And Addr Over flow info update<br>
	 *
	 * @param XterRqstNoVO rqstNoVO
	 * @param String nmAndAddrOvflwFlg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyNmAndAddrOvflwFlg(XterRqstNoVO rqstNoVO, String nmAndAddrOvflwFlg, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyNmAndAddrOvflwFlg(rqstNoVO, nmAndAddrOvflwFlg, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * String socXml info insert<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @exception EventException
	 */
	public void createBkgXterQtyByXml(XterRqstNoVO rqstNoVo) throws EventException {
		try {
			dbDao.addBkgXterQtyByXml(rqstNoVo);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}

	/**
	 * 
	 * @param rqstNoVo
	 * @param flatFileStr
	 * @return
	 * @throws EventException
	 */
	public String createBkgXterRcvMsg(XterRqstNoVO rqstNoVo, String flatFileStr) throws EventException {
		String msgSeq = "";
		try {
			msgSeq = dbDao.addBkgXterRcvMsg(rqstNoVo, flatFileStr);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return msgSeq;
	}

	/**
	 * eBkg Customer Name And Addr Over flow info update<br>
	 *
	 * @param String msgSeq
	 * @param String sndrId
	 * @param String rqstNo
	 * @param String rqstSeq
	 * @param String upldFlg
	 * @exception EventException
	 */
	public void modifyBkgXterRcvMsg(String msgSeq, String sndrId, String rqstNo, String rqstSeq, String upldFlg) throws EventException {
		try {
			dbDao.updateBkgXterRcvMsg(msgSeq, sndrId, rqstNo, rqstSeq, upldFlg);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * Pegasus XML Monitoring search
	 * 
	 * @param String rcvFromDt
	 * @param String rcvToDt
	 * @param String UpldCd
	 * @param String RqstNo
	 * @param String msgSeq
	 * @param String msgDesc
	 * @return List<BkgXterRevMsgVO>
	 * @throws EventException
	 */
	public List<BkgXterRevMsgVO> searchBkgXterRcvMsgList(String rcvFromDt, String rcvToDt, String upldCd, String rqstNo, String msgSeq, String msgDesc) throws EventException {
		try {
			return dbDao.searchBkgXterRcvMsgList(rcvFromDt, rcvToDt, upldCd, rqstNo, msgSeq, msgDesc);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}		
	}	
	
	/**
	 * Pegasus XML Monitoring search
	 * 
	 * @param BkgXterRevMsgVO bkgXterRevMsgVO
	 * @return BkgXterRevMsgVO
	 * @throws EventException
	 */
	public BkgXterRevMsgVO searchBkgXterRcvMsgView(BkgXterRevMsgVO bkgXterRevMsgVO) throws EventException {
		try {
			return dbDao.searchBkgXterRcvMsgView(bkgXterRevMsgVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}		
	}	
	
	/**
	 * String socXml info insert<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @exception EventException
	 */
	public void modifyBkgXterRqstMst(XterRqstNoVO rqstNoVo) throws EventException {
		try {
			dbDao.updateBkgXterRqstMst(rqstNoVo);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * 
	 * @param unlocCd
	 * @return
	 * @throws EventException
	 */
	public String getUnlocCodeToLocCd(String unlocCd) throws EventException {
		try {
			return dbDao.getUnlocCodeToLocCd(unlocCd);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * 
	 * @param rqstNo
	 * @param rqstSeq
	 * @throws EventException
	 */
	public void ediPegasusBkgXterCntrDelete(String rqstNo, String rqstSeq) throws EventException {
		try {
			dbDao.ediPegasusBkgXterCntrDelete(rqstNo, rqstSeq);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * 
	 * @param xterRqstMstVO
	 * @param account
	 * @throws EventException
	 */
	public void modifyBkgReferenceNo(XterRqstMstVO xterRqstMstVO, SignOnUserAccount account) throws EventException {
		try {
//		FINV - Invoice Ref. No.
			if(dbDao.modifyBkgReferenceNo(xterRqstMstVO.getInvRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "FINV") < 1){
				dbDao.addBkgReference(xterRqstMstVO.getInvRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "FINV");
			}
//		EBRF - BKG Ref. No.
			if(dbDao.modifyBkgReferenceNo(xterRqstMstVO.getBkgRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "EBRF") < 1){
				dbDao.addBkgReference(xterRqstMstVO.getBkgRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "EBRF");
			}
//		EBSH - BKG SH Ref. No.
			if(dbDao.modifyBkgReferenceNo(xterRqstMstVO.getBkgSHRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "EBSH") < 1){
				dbDao.addBkgReference(xterRqstMstVO.getBkgSHRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "EBSH");
			}
//		EBFF - BKG FF Ref. No.
			if(dbDao.modifyBkgReferenceNo(xterRqstMstVO.getBkgFFRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "EBFF") < 1){
				dbDao.addBkgReference(xterRqstMstVO.getBkgFFRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "EBFF");
			}
//		ESRF - S/I Ref. No.
			if(dbDao.modifyBkgReferenceNo(xterRqstMstVO.getSiRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "ESRF") < 1){
				dbDao.addBkgReference(xterRqstMstVO.getSiRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "ESRF");
			}
//		ESSH - S/I SH Ref. No.
			if(dbDao.modifyBkgReferenceNo(xterRqstMstVO.getSiSHRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "ESSH") < 1){
				dbDao.addBkgReference(xterRqstMstVO.getSiSHRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "ESSH");
			}
//		ESFF - S/I FF Ref. No.
			if(dbDao.modifyBkgReferenceNo(xterRqstMstVO.getSiFFRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "ESFF") < 1){
				dbDao.addBkgReference(xterRqstMstVO.getSiFFRefNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "ESFF");
			}
//		RGBK - Regional BKG No.
			if(dbDao.modifyBkgReferenceNo(xterRqstMstVO.getRegBkgNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "RGBK") < 1){
				dbDao.addBkgReference(xterRqstMstVO.getRegBkgNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "RGBK");
			}
//		XMRN - Export MRN No. 
			if(dbDao.modifyBkgReferenceNo(xterRqstMstVO.getExtMrnNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "XMRN") < 1){
				dbDao.addBkgReference(xterRqstMstVO.getExtMrnNo(), account.getUsr_id(), xterRqstMstVO.getBkgNo(), "XMRN");
			}
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param rqstNo
	 * @param rqstSeq
	 * @throws EventException
	 */
	public void ediPegasusBkgXterTroUpdate(String rqstNo, String rqstSeq) throws EventException {
		try {
			dbDao.ediPegasusBkgXterTroUpdate(rqstNo, rqstSeq);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param senderId
	 * @param rqstNo
	 * @param rqstSeq
	 * @throws EventException
	 */
	public void ediPegasusBkgXterDgCgoUpdate(String senderId, String rqstNo, String rqstSeq) throws EventException {
		try {
			dbDao.ediPegasusBkgXterDgCgoUpdate(senderId, rqstNo, rqstSeq);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param XterRqstNoVO rqstNoVo
	 * @throws EventException
	 */
	@Override
	public void sendXterRqstNotice(XterRqstNoVO rqstNoVo) {
		try {
			//  office notice
			String emailAddress[] = dbDao.searchXterRqstNoticeOfc(rqstNoVo);
			String subject = dbDao.sendXterRqstNoticeSubject(rqstNoVo);
			for(int i = 0; i < emailAddress.length; i++){
				eaiDao.sendXterRqstNotice(emailAddress[i], rqstNoVo, subject);
			}
		} catch (DAOException de) {
			log.error(de);
        } catch (Exception ex) {
        	log.error(ex);
		}
	}
	
	/**
	 * OPUS Container Office Setup search
	 * 
	 * @param RerouteOfcVO rerouteOfcVO
	 * @param String usr_id
	 * @return List<RerouteOfcVO>
	 * @throws EventException
	 */
	public List<RerouteOfcVO> searchRerouteOfcCd(RerouteOfcVO rerouteOfcVO, String usr_id) throws EventException {
		try {			
			return dbDao.searchRerouteOfcCd(rerouteOfcVO, usr_id);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}		
	}	
	
	/**
	 * 
	 * @param rqstNoVo
	 */
	public void sendRerouteRqstNotice(XterRqstNoVO rqstNoVo) {
		try {
			String subject = dbDao.sendXterRqstNoticeSubject(rqstNoVo);
			eaiDao.sendXterRqstNotice(rqstNoVo.getNewEmail(), rqstNoVo, subject);
        } catch (Exception ex) {
        	log.error(ex);
		}
	}
	
	/**
	 * office code save.<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param String usr_id
	 * @exception EventException
	 */
	public void changeRerouteRqstOfcCd(XterRqstNoVO rqstNoVo, String usr_id) throws EventException {
		try {
			dbDao.changeRerouteRqstOfcCd(rqstNoVo, usr_id);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * OPUS Container Office Setup search
	 * 
	 * @return List<RerouteUserIdVO>
	 * @throws EventException
	 */
	public List<RerouteUserIdVO> searchRerouteUserId() throws EventException {
		try {			
			return dbDao.searchRerouteUserId();
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}		
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @return
	 * @throws EventException
	 */
	public List<PoOtherShipVO> searchPoNoByShip(String bkgNo) throws EventException {
		try {			
			return dbDao.searchPoNoByShip(bkgNo);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * 
	 * @param xterRqstNoVO
	 * @return
	 * @throws EventException
	 */
	public List<RejectEdiRefVO> searchXterRefForRejectEdi(XterRqstNoVO xterRqstNoVO) throws EventException {
		try {			
			return dbDao.searchXterRefForRejectEdi(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}	
	}

	/**
	 * 
	 * @param xterRqstNoVO
	 * @return
	 * @throws EventException
	 */
	public List<XterCmShipmentVO> searchXterCmShipment(XterRqstNoVO xterRqstNoVO) throws EventException {
		try {			
			return dbDao.searchXterCmShipment(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * VGM update<br>
	 *
	 * @param BkgVgmWgtVO bkgVgmWgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgVgmUpld(BkgVgmWgtVO bkgVgmWgtVO, SignOnUserAccount account) throws EventException {
		
		try {
			dbDao.modifyBkgVgmUpld(bkgVgmWgtVO,account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	/**
	 * VGM update<br>
	 *
	 * @return List<CodecoEdiForVgmVO> list
	 * @exception EventException
	 */
	public List<CodecoEdiForVgmVO> searchCodecoEdiForVgm() throws EventException{
		try {			
			return dbDao.searchCodecoEdiForVgm();
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	
	/**
	 * VGM update from CODECO<br>
	 *
	 * @param CodecoEdiForVgmVO codecoEdiForVgmVO
	 * @exception EventException
	 */
	public void manageVgmInfoFmCodeco(CodecoEdiForVgmVO codecoEdiForVgmVO) throws EventException {
		
		try {
			dbDao.manageVgmInfoFmCodeco(codecoEdiForVgmVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * 
	 * @param msg
	 * @return
	 */
	public String[] getReceiptXterRqstEdiMsgType(String msg) throws EventException {
		String[] msgstart = msg.replaceAll("\\$\\$\\$MSGSTART:", "").split(" ");
		List<String> headers = new ArrayList<String>();
		for (int i = 0; i < msgstart.length; i++) {
			if(msgstart[i].trim().length() > 1) {
				if(msgstart[i].indexOf(":") > -1) msgstart[i] = msgstart[i].split(":")[1];
				headers.add(msgstart[i].trim());
			}
		}
//		headers[0] = msgstart.substring(0, 20).trim();
//		headers[1] = msgstart.substring(20, 40).trim();
//		headers[2] = msgstart.substring(40, 50).trim();
//		headers[3] = msgstart.substring(50, msgstart.length()).trim();
		return headers.toArray(new String[0]);
	}
	
	private final String XTER_VGM_DOC_ID = "I_VERMAS/MSG_REF_NO";
	private final String CNTR_NO = "I_VERMAS/CNTR_INFO/CNTR_NO";
	private final String XTER_SNDR_ID = "XTER_SNDR_ID";
	private final String EDI_NO = "EDI_MSG_PROC_ID";
	private final String XTER_VGM_RQST_SEQ = "XTER_VGM_RQST_SEQ";
	
	/**
	 * 
	 * @param headers
	 * @param msg
	 * @return
	 * @throws EventException
	 */
	public XterRqstNoVO receiptXterRqstVermas(String[] headers, String msg) throws EventException {
		VermasMapping vermas = new VermasMapping();
		XterRqstNoVO rqstNoVo = new XterRqstNoVO();
		String ackRcv = null;
		try {
			ackRcv = dbDao.searchXterBkgAckReceiver(headers[0], "VGM_ACK_RECEIVER");
			LinkedHashMap<String, String> header = vermas.createNodePath("I_VERMAS", vermas.getNodeData("I_VERMAS", msg));
			header.put(XTER_SNDR_ID, headers[0]);
			header.put(EDI_NO, headers[3]);
			rqstNoVo.setRqstNo(header.get(XTER_VGM_DOC_ID));
			
			LinkedHashMap<String, String> refInfo = vermas.createNodePath("I_VERMAS/REF_INFO", vermas.getNodeData("REF_INFO", msg));
			List<String> cntrInfoList = vermas.getNodeDatas("CNTR_INFO", msg);
			for (int i = 0; i < cntrInfoList.size(); i++) {
				/* CNTR_INFO */
				LinkedHashMap<String, String> cntrInfo = vermas.createNodePath("I_VERMAS/CNTR_INFO", cntrInfoList.get(i), new String[]{"CNTR_REF_INFO", "SEAL_INFO", "DOC_INFO", "CUST_INFO"});
				/* MAX SEQ 조회 */
				String xterVgmRqstSeq = dbDao.getReceiptXterVermasSeqMax(header.get(XTER_SNDR_ID), header.get(XTER_VGM_DOC_ID), cntrInfo.get(CNTR_NO));
				header.put(XTER_VGM_RQST_SEQ, xterVgmRqstSeq);
				
				/* BKG_XTER_VGM_RQST 저장 */
				addBkgXterVgmRqst(header, refInfo, cntrInfo);
				
				/* CNTR_REF_INFO */
				List<String> cntrRefInfoList = vermas.getNodeDatas("CNTR_REF_INFO", cntrInfoList.get(i));
				for (int j = 0; j < cntrRefInfoList.size(); j++) {
					LinkedHashMap<String, String> cntrRefInfo = vermas.createNodePath("I_VERMAS/CNTR_INFO/CNTR_REF_INFO", cntrRefInfoList.get(j));
					/* BKG_XTER_VGM_REF_NO 저장 */
					addBkgXterVgmrRefNo(header, cntrInfo, cntrRefInfo);
				}
				
				/* SEAL_INFO */
				List<String> sealIngoList = vermas.getNodeDatas("SEAL_INFO", cntrInfoList.get(i));
				if(sealIngoList != null && sealIngoList.size() > 0){
					LinkedHashMap<String, String> sealIngo = vermas.createNodePath("I_VERMAS/CNTR_INFO/SEAL_INFO", sealIngoList.get(0));
					/* BKG_XTER_VGM_CNTR_SEAL_NO 저장 */
					addBkgXterVgmrCntrSealNo(header, cntrInfo, sealIngo);
				}
//				for (int j = 0; j < sealIngoList.size(); j++) {
//					LinkedHashMap<String, String> sealIngo = vermas.createNodePath("I_VERMAS/CNTR_INFO/SEAL_INFO", sealIngoList.get(j));
//					/* BKG_XTER_VGM_CNTR_SEAL_NO 저장 */
//					addBkgXterVgmrCntrSealNo(header, cntrInfo, sealIngo);
//				}
				
				/* DOC_INFO */
				List<String> docInfoList = vermas.getNodeDatas("DOC_INFO", cntrInfoList.get(i));
				if(docInfoList.size() > 0){
					for (int j = 0; j < docInfoList.size(); j++) {
						LinkedHashMap<String, String> docInfo = vermas.createNodePath("I_VERMAS/CNTR_INFO/DOC_INFO", docInfoList.get(j), new String[]{"CUST_INFO"});
						
						/* CUST_INFO */
						List<String> custTpList = vermas.getNodeDatas("CUST_INFO", docInfoList.get(j));
						for (int k = 0; k < custTpList.size(); k++) {
							LinkedHashMap<String, String> custTp = vermas.createNodePath("I_VERMAS/CNTR_INFO/DOC_INFO/CUST_INFO", custTpList.get(k));
							/* BKG_XTER_VGM_CUST 저장 */
							custTp.putAll(docInfo);
							addBkgXterVgmrCust(header, cntrInfo, custTp);
						}
					}
				}else{
					addBkgXterVgmrCust(header, cntrInfo, null);
				}
			}
			rqstNoVo.setAckRcv(ackRcv);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
		}	
		
		return rqstNoVo;
	}
	
	/**
	 * 
	 * @param header
	 * @param refInfo
	 * @param cntrInfo
	 * @throws EventException
	 */
	private void addBkgXterVgmRqst(LinkedHashMap<String, String> header, LinkedHashMap<String, String> refInfo, LinkedHashMap<String, String> data) throws Exception {
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		VermasMapping vermas = new VermasMapping();
		BkgHrdCdgCtntVO paramVO = new BkgHrdCdgCtntVO();
		paramVO.setHrdCdgId("VERMAS_RECEIPT");
		paramVO.setAttrCtnt3("BKG_XTER_VGM_RQST");
		List<BkgHrdCdgCtntVO> rqstList;
		try {
			rqstList = command.searchMqXmlMappingList(paramVO);
			Map<String, LinkedHashMap<String, String>> vgmData = new HashMap<String, LinkedHashMap<String, String>>();
			vgmData.put("HRADER", header);
			vgmData.put("REF_INFO", refInfo);
			vgmData.put("CNTR_INFO", data);
			LinkedHashMap<String, String> bkgXterVgmDataMap = vermas.createdBkgXterVgmRqst(vgmData, rqstList);
			bkgXterVgmDataMap.put(XTER_SNDR_ID, header.get(XTER_SNDR_ID));
			bkgXterVgmDataMap.put(XTER_VGM_RQST_SEQ, header.get(XTER_VGM_RQST_SEQ));
			bkgXterVgmDataMap.put(EDI_NO, header.get(EDI_NO));
			dbDao.addReceiptXterVermas(bkgXterVgmDataMap, "BKG_XTER_VGM_RQST");
		} catch (DAOException de) {
            throw de;
        } catch (Exception ex) {
            throw ex;
		}
	}
	
	/**
	 * 
	 * @param header
	 * @param cntrInfo
	 * @param data
	 * @throws EventException
	 */
	private void addBkgXterVgmrRefNo(LinkedHashMap<String, String> header, LinkedHashMap<String, String> cntrInfo, LinkedHashMap<String, String> data) throws Exception {
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		VermasMapping vermas = new VermasMapping();
		BkgHrdCdgCtntVO paramVO = new BkgHrdCdgCtntVO();
		paramVO.setHrdCdgId("VERMAS_RECEIPT");
		paramVO.setAttrCtnt3("BKG_XTER_VGM_REF_NO");
		List<BkgHrdCdgCtntVO> rqstList;
		try {
			rqstList = command.searchMqXmlMappingList(paramVO);
			Map<String, LinkedHashMap<String, String>> vgmData = new HashMap<String, LinkedHashMap<String, String>>();
			vgmData.put("CNTR_REF_INFO", data);
			LinkedHashMap<String, String> bkgXterVgmDataMap = vermas.createdBkgXterVgmRqst(vgmData, rqstList);
			bkgXterVgmDataMap.put("XTER_SNDR_ID", header.get(XTER_SNDR_ID));
			bkgXterVgmDataMap.put("XTER_VGM_DOC_ID", header.get(XTER_VGM_DOC_ID));
			bkgXterVgmDataMap.put("CNTR_NO", cntrInfo.get(CNTR_NO));
			bkgXterVgmDataMap.put("XTER_VGM_RQST_SEQ", header.get(XTER_VGM_RQST_SEQ));
			dbDao.addReceiptXterVermas(bkgXterVgmDataMap, "BKG_XTER_VGM_REF_NO");
		} catch (DAOException de) {
            throw de;
        } catch (Exception ex) {
            throw ex;
		}
	}
	
	/**
	 * 
	 * @param header
	 * @param cntrInfo
	 * @param data
	 * @throws EventException
	 */
	private void addBkgXterVgmrCntrSealNo(LinkedHashMap<String, String> header, LinkedHashMap<String, String> cntrInfo, LinkedHashMap<String, String> data) throws Exception {
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		VermasMapping vermas = new VermasMapping();
		BkgHrdCdgCtntVO paramVO = new BkgHrdCdgCtntVO();
		paramVO.setHrdCdgId("VERMAS_RECEIPT");
		paramVO.setAttrCtnt3("BKG_XTER_VGM_CNTR_SEAL_NO");
		List<BkgHrdCdgCtntVO> rqstList;
		try {
			rqstList = command.searchMqXmlMappingList(paramVO);
			Map<String, LinkedHashMap<String, String>> vgmData = new HashMap<String, LinkedHashMap<String, String>>();
			vgmData.put("SEAL_INFO", data);
			LinkedHashMap<String, String> bkgXterVgmDataMap = vermas.createdBkgXterVgmRqst(vgmData, rqstList);
			bkgXterVgmDataMap.put("XTER_SNDR_ID", header.get(XTER_SNDR_ID));
			bkgXterVgmDataMap.put("XTER_VGM_DOC_ID", header.get(XTER_VGM_DOC_ID));
			bkgXterVgmDataMap.put("CNTR_NO", cntrInfo.get(CNTR_NO));
			bkgXterVgmDataMap.put("XTER_VGM_RQST_SEQ", header.get(XTER_VGM_RQST_SEQ));
			dbDao.addReceiptXterVermas(bkgXterVgmDataMap, "BKG_XTER_VGM_CNTR_SEAL_NO");
		} catch (DAOException de) {
            throw de;
        } catch (Exception ex) {
            throw ex;
		}
	}
	
	/**
	 * 
	 * @param header
	 * @param cntrInfo
	 * @param data
	 * @throws EventException
	 */
	private void addBkgXterVgmrCust(LinkedHashMap<String, String> header, LinkedHashMap<String, String> cntrInfo, LinkedHashMap<String, String> data) throws Exception {
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		VermasMapping vermas = new VermasMapping();
		BkgHrdCdgCtntVO paramVO = new BkgHrdCdgCtntVO();
		paramVO.setHrdCdgId("VERMAS_RECEIPT");
		paramVO.setAttrCtnt3("BKG_XTER_VGM_CUST");
		List<BkgHrdCdgCtntVO> rqstList;
		try {
			rqstList = command.searchMqXmlMappingList(paramVO);
			Map<String, LinkedHashMap<String, String>> vgmData = new HashMap<String, LinkedHashMap<String, String>>();
			if(data != null)
				vgmData.put("CUST_INFO", data);
			LinkedHashMap<String, String> bkgXterVgmDataMap = vermas.createdBkgXterVgmRqst(vgmData, rqstList);
			bkgXterVgmDataMap.put("XTER_SNDR_ID", header.get(XTER_SNDR_ID));
			bkgXterVgmDataMap.put("XTER_VGM_DOC_ID", header.get(XTER_VGM_DOC_ID));
			bkgXterVgmDataMap.put("CNTR_NO", cntrInfo.get(CNTR_NO));
			bkgXterVgmDataMap.put("XTER_VGM_RQST_SEQ", header.get(XTER_VGM_RQST_SEQ));
			dbDao.addReceiptXterVermas(bkgXterVgmDataMap, "BKG_XTER_VGM_CUST");
		} catch (DAOException de) {
            throw de;
        } catch (Exception ex) {
            throw ex;
		}
	}
	
	/**
	 * VGM update<br>
	 *
	 * @param BkgVgmWgtVO bkgVgmWgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgXterVgmRqstUpld(BkgVgmWgtVO bkgVgmWgtVO, SignOnUserAccount account) throws EventException {
		
		try {
			dbDao.modifyBkgXterVgmRqstUpld(bkgVgmWgtVO,account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * 
	 * @param senderId
	 * @param rqstNo
	 * @param rqstSeq
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<XterCntrVO> searchXterCntrVgm(String senderId, String rqstNo, String rqstSeq) throws EventException {
		try {
            return dbDao.searchXterCntrVgm(senderId, rqstNo, rqstSeq);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
	}
	
	/**
	 * 
	 * @param xterCntrVO
	 * @throws EventException
	 */
	@Override
	public void manageXterVgm(XterCntrVO xterCntrVO) throws EventException {
		try {
            dbDao.manageXterVgm(xterCntrVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
	}
	
	/**
	 * 
	 * @param xterCntrVO
	 * @return
	 * @throws EventException
	 */
	@Override
	public String selectBkgXterVgm(XterCntrVO xterCntrVO) throws EventException {
		try {
            return dbDao.selectBkgXterVgm(xterCntrVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
	}
	
	/**
	 * 
	 * @param headers
	 * @param rqstNoVo
	 * @return
	 * @throws EventException
	 */
	public String createVermasBkgAckEdi(String[] headers, XterRqstNoVO rqstNoVo) throws EventException {
        BookingUtil utilBC = null;
        SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		try {
			utilBC = new BookingUtil();
			LinkedHashMap<String, String> resTpCd = dbDao.searchCargoSmartValidation(headers[3]);
	        String apkMsgNo = ReferenceNumberGeneratorBroker.getKey("BKG","BKG_EDI_SEQ");
	        String headerFile = dbDao.searChcargoSmartAckHeader(apkMsgNo, "VGM_ACK_RECEIVER", headers[0], rqstNoVo.getRqstNo());
	        String flatFile = dbDao.searChcargoSmartAck(resTpCd, headers[3], headerFile);
			sendFlatFileVO.setFlatFile(flatFile);
			String queueNm = SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_ACK.IBMMQ.QUEUE");
			sendFlatFileVO.setQueueNm(queueNm);
			FlatFileAckVO flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
			if ( "E".equals(flatFileAckVO.getAckStsCd()) ) {
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
			}
			
			dbDao.updateBkgXterVgmRqst(resTpCd, headers[3], headers[0]);
		}catch(EventException e){
			throw e;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return sendFlatFileVO.getFlatFile();
	}
	
	/**
	 * 
	 * @param xterRqstNoVO
	 * @throws EventException
	 */
	public void manageXterVgm(XterRqstNoVO xterRqstNoVO) throws EventException {
		try {
            dbDao.manageXterVgm(xterRqstNoVO);
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
	}
}
