/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanTerminalTransmissionBCImpl.java
 *@FileTitle : CustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.03.02
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.29 김승민
 * 1.0 Creation
 *-------------------------------------------------------
 * History
 * 2010.12.14 이수진 [CHM-201007514] Sea-NACCS MFR, CMF01, CMF02 의 Mark 데이터 사이즈 변경 및 제한 요청
 * 2011.01.12 안정선 [CHM-201008075] DOR User ID 조회 및 MFR CY 코드 반영 수정 사항 라이브 반영 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration.JapanTerminalTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgJapanTerminalEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiDgCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanDgCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCheckRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiGroupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.VvdJapanTerminalEdiVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsJpRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpSndLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpSndLogVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;


/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Seung Min
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class JapanTerminalTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient JapanTerminalTransmissionDBDAO dbDao = null;

	/**
	 * JapanTerminalTransmissionBCImpl 객체 생성<br>
	 * JapanCustomsTransmissionDAO를 생성한다.<br>
	 */
	public JapanTerminalTransmissionBCImpl() {
		dbDao = new JapanTerminalTransmissionDBDAO();

	}

	/**
	 * 전송 이벤트 처리<br>
	 * 일본세관 수신 처리.<br>
	 * 
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void receiveJapanTerminalAlpsbkgNaccs(String flatFile, SignOnUserAccount account) throws EventException {

		BkgCstmsJpRcvLogVO bkgCstmsJpRcvLogVO = new BkgCstmsJpRcvLogVO();
		BkgCstmsJpRcvLogDtlVO bkgCstmsJpRcvLogDtlVO = new BkgCstmsJpRcvLogDtlVO();
//		 flatFile ="$$$MSGSTART:SEANACCS            SMLINE              SAT076    UDEV:93573207         \n"+
//		           "{BKGACK  \n"+
//		           "MSG_CD:BKC-REPLY  \n"+
//		           "RSLT_CD:  \n"+
//		           "SCAC_CD:SMLM  \n"+
//		           "BKGNBR:TYOY1069189  \n"+
//		           "}BKGACK ";
		            
//BKC-REPLY

		try {	

			log.error("====== EDI 수신 (SEANACCS) start==");
			log.error(flatFile);
			log.error("====== EDI 수신 (SEANACCS) end====");
			
			StringTokenizer token = new StringTokenizer(flatFile, "\n");
			ArrayList tmpArray = new ArrayList();
			while (token.hasMoreTokens()) {
				tmpArray.add(token.nextToken());
			}

			String rcvDt = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String rcvKeyDatCtnt = "";
			String rcvKeyDatCtnt2 = "";
			String rcvKeyDatCtnt3 = "";
			String rcvKeyDatCtnt4 = "";

			int seqNumber = 0;
			for (int j = 0; j < tmpArray.size(); j++) {
				if (j == 0) {
					String data = tmpArray.get(j).toString();
					//bkgCstmsJpRcvLogVO.setCreUsrId(data.substring(12, 32).trim());
					bkgCstmsJpRcvLogVO.setRcvDt(rcvDt);
					bkgCstmsJpRcvLogVO.setJpSvcCd(data.substring(52, 62).trim());
					
					log.debug("== EDI 수신 ="+data.substring(62, 82).trim());

					String[] jpBatNo = data.substring(62, 82).trim().split(":");
					for(int x=1; x<jpBatNo.length; x++) {
						bkgCstmsJpRcvLogVO.setJpBatNo(jpBatNo[x].trim());
					}

					//bkgCstmsJpRcvLogVO.setJpBatNo(data.substring(67, 82).trim());
					
					//bkgCstmsJpRcvLogDtlVO.setCreUsrId(data.substring(12, 32).trim());
					bkgCstmsJpRcvLogDtlVO.setRcvDt(rcvDt);

					log.debug("== EDI 수신 (SEANACCS) ===="+data);
				}
				
				
				
				
				
				else if (j == 2) {
					String data = tmpArray.get(j).toString();
					
					String[] rcvMsgS1 = data.split(":");
					for(int x=1; x<rcvMsgS1.length; x++) {
						bkgCstmsJpRcvLogVO.setJpMsgTpCd(rcvMsgS1[x].trim());
						bkgCstmsJpRcvLogDtlVO.setJpMsgTpCd(rcvMsgS1[x].trim());
						
						seqNumber = dbDao.searchReceiveLogSeq(bkgCstmsJpRcvLogVO.getJpMsgTpCd(), rcvDt);
						bkgCstmsJpRcvLogVO.setRcvSeq(seqNumber + "");
						bkgCstmsJpRcvLogDtlVO.setRcvSeq(seqNumber + "");						
					}
				}		
				
				else if (j == 3) { //User ID
					String data = tmpArray.get(j).toString();
					
					String[] rcvMsgS5 = data.split(":");
					for(int x=1; x<rcvMsgS5.length; x++) {
						bkgCstmsJpRcvLogVO.setCreUsrId(rcvMsgS5[x].trim());
						bkgCstmsJpRcvLogDtlVO.setCreUsrId(rcvMsgS5[x].trim());						
					}
				}
				
				else if (j == 4) {
					String data = tmpArray.get(j).toString();
					
					String[] rcvMsgS2 = data.split(":");
					for(int x=1; x<rcvMsgS2.length; x++) {
						rcvKeyDatCtnt2 = rcvMsgS2[x].trim();
					}
				}
				else if (j == 5) {
					String data = tmpArray.get(j).toString();
					
					String[] rcvMsgS3 = data.split(":");
					for(int y=1; y<rcvMsgS3.length; y++) {
						rcvKeyDatCtnt3 = rcvMsgS3[y].trim();
					}
				}
			
				else if (j == 6) {
					String data = tmpArray.get(j).toString();

					String[] rcvMsgS4 = data.split(":");
					for(int z=1; z<rcvMsgS4.length; z++) {
						rcvKeyDatCtnt4 = rcvMsgS4[z].trim();
					}					
					bkgCstmsJpRcvLogVO.setBkgNo(rcvKeyDatCtnt4);
					rcvKeyDatCtnt = rcvKeyDatCtnt2+" "+rcvKeyDatCtnt3+rcvKeyDatCtnt4;
					bkgCstmsJpRcvLogVO.setRcvKeyDatCtnt(rcvKeyDatCtnt);
				}
				
			}
			
			//JP_SVC_CD 이 BKGACK 일때 만 저장
			if(bkgCstmsJpRcvLogVO.getJpSvcCd().equals("BKGACK")){
				//Mast Log 저장
				dbDao.addReceiveLog(bkgCstmsJpRcvLogVO);
	
				//Detail Log 저장
				for (int i = 1; i < tmpArray.size(); i++) {
					if (i == 4) {
						bkgCstmsJpRcvLogDtlVO.setRcvDtlSeq((i-1) + "");
						bkgCstmsJpRcvLogDtlVO.setEdiRcvMsg(rcvKeyDatCtnt2);
						dbDao.addReceiveLogDetail(bkgCstmsJpRcvLogDtlVO);					
					}else if (i == 5) {
						bkgCstmsJpRcvLogDtlVO.setRcvDtlSeq((i-1) + "");
						bkgCstmsJpRcvLogDtlVO.setEdiRcvMsg(rcvKeyDatCtnt3);
						dbDao.addReceiveLogDetail(bkgCstmsJpRcvLogDtlVO);					
					}else if (i == 6) {
						bkgCstmsJpRcvLogDtlVO.setRcvDtlSeq((i-1) + "");
						bkgCstmsJpRcvLogDtlVO.setEdiRcvMsg(rcvKeyDatCtnt4);
						dbDao.addReceiveLogDetail(bkgCstmsJpRcvLogDtlVO);					
					}
				}
			}else if (bkgCstmsJpRcvLogVO.getJpSvcCd().equals("SAT076")){
				//Mast Log 저장
				dbDao.addReceiveLog(bkgCstmsJpRcvLogVO);
	
				//Detail Log 저장
				for (int i = 1; i < tmpArray.size(); i++) {
					if (i == 4) {
						bkgCstmsJpRcvLogDtlVO.setRcvDtlSeq((i-1) + "");
						bkgCstmsJpRcvLogDtlVO.setEdiRcvMsg(rcvKeyDatCtnt2);
						dbDao.addReceiveLogDetail(bkgCstmsJpRcvLogDtlVO);					
					}else if (i == 5) {
						bkgCstmsJpRcvLogDtlVO.setRcvDtlSeq((i-1) + "");
						bkgCstmsJpRcvLogDtlVO.setEdiRcvMsg(rcvKeyDatCtnt3);
						dbDao.addReceiveLogDetail(bkgCstmsJpRcvLogDtlVO);					
					}else if (i == 6) {
						bkgCstmsJpRcvLogDtlVO.setRcvDtlSeq((i-1) + "");
						bkgCstmsJpRcvLogDtlVO.setEdiRcvMsg(rcvKeyDatCtnt4);
						dbDao.addReceiveLogDetail(bkgCstmsJpRcvLogDtlVO);					
					}
				}
				
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * chkStrNull
	 * sendTerminalEdi flat file 생성시 NULL 체크를 한다.
	 * 
	 * @param chkStr
	 * @return String
	 */
	public String chkStrNull(String chkStr){
		
		String strRslt="";
		if("".equals(chkStr)||chkStr==null){
			strRslt="";
		}else{
			strRslt=chkStr;
		}
		
		return strRslt;
	}
	
	/**
	 * chkStrLoc
	 * sendTerminalEdi flat file 생성시 Location code 체크를 한다.
	 * 
	 * @param chkStr
	 * @return String
	 * @throws EventException 
	 */
	public String chkStrLoc(String chkStr) throws EventException{
		
		String strRslt="";
		
		if ( !"".equals(chkStr)) {
			
			BookingUtil command = null;
			
			command = new BookingUtil();
			
			BkgHrdCdgCtntListCondVO hrdVO = new BkgHrdCdgCtntListCondVO();
	        hrdVO.setHrdCdgId("NACCS_LOC_CHG");
			hrdVO.setAttrCtnt1(chkStr);
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = command.searchHardCoding(hrdVO);
	
			if(bkgHrdCdgCtntVOs.size() > 0){
				strRslt= bkgHrdCdgCtntVOs.get(0).getAttrCtnt2();
			}else{
				strRslt=chkStr;
			}
		} else {
			strRslt=chkStr;
		}
		return strRslt;
		
	}
	
	/**
	 * Japan Terminal EDI 세관신고 위해 FlatFile을 생성한다.
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param JapanTerminalEdiGroupVO japanTerminalEdiGroupVO
	 * @param SignOnUserAccount account
	 * @param int logSeq
	 * @return String
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public String sendTerminalEdi(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, JapanTerminalEdiGroupVO japanTerminalEdiGroupVO, SignOnUserAccount account, int logSeq) throws EventException{
   
		BookingUtil		bookingUtil		= new BookingUtil();
		StringBuffer realFlatFile = new StringBuffer(); //전송 이력 Detail
		// FLATFILE
		String 			senderId 		= "";
		String 			receiverId 		= "";
		String 			headerType 		= "";
		String 		 	flatFileHeader	= null;
		//String 		 	flatFileRefNo	= null;
		StringBuffer 	flatFile 		= new StringBuffer();
		StringBuffer 	realflatFile 		= new StringBuffer();

		// Container 정보
		@SuppressWarnings("unused")
		BkgTerminalEdiJapanCntrVO 	cntrVO		= null;
		
		BkgTerminalEdiJapanBlVO blVO =  null;
		//Unused Local Variable
		//BkgTerminalEdiJapanRfCgoVO rfVO = null;
		
		BkgTerminalEdiJapanAwkCgoVO awkVO = null;
		
		BkgTerminalEdiJapanDgCgoVO dgVO = null;
		
		List<BkgTerminalEdiDgCgoVO> dgMainList = null; 
		
		List<BkgTerminalEdiDgCgoVO> dgDetailList = null; 
		
		List<BkgTerminalEdiJapanCntrVO> 	bkgTerminalEdiJapanCntrList		= null;
		
		//VvdJapanTerminalEdiVO vvdJpTmlEdiVO = new VvdJapanTerminalEdiVO();

		
		// -- For문 Index -- //
	
		int cntrIdx = 0;
		int dgMainIdx = 0;
		int dgDetailIdx 	= 0;
		
		try
		{	  
			// Body 생성
				log.debug("WONJOO=========================flat file" );
	
					// Header 생성
					senderId = "SMLINE";
					receiverId = "SEANACCS";
					headerType = "BKGINF";
					flatFileHeader = bookingUtil.searchCstmsEdiHeader(senderId, receiverId, headerType);
					flatFile.append(flatFileHeader).append("\n");
					
//					if( blIdx == 0 ){
//						flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("UBIZ1"));//문의할 것 
//					}

					flatFile.append("{HEADER").append("\n");
					flatFile.append("CTRL_CD:")         .append("   ").append("\n");
					if("R".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())){
				    flatFile.append("MSG_CD:")			.append("BKR  ").append("\n"); 
					}else{
					flatFile.append("MSG_CD:")			.append("BKC  ").append("\n");
					}
					flatFile.append("USER_CD:")			.append("1ASLD").append("\n"); //공백 확인
					flatFile.append("USER_NB:")			.append("C0A").append("\n");
					flatFile.append("USER_PW:")			.append("2FHJERGN").append("\n");
					flatFile.append("DATA_INFO:")	    .append("                          ").append("\n");
					flatFile.append("USER_ID:")			.append(account.getUsr_id().replace("_", "").toUpperCase()).append("\n");
					flatFile.append("SRCH_KEY:")	    .append("                                                                                                   ").append("\n");
					flatFile.append("NACCS_CD:")		.append("2").append("\n");
					flatFile.append("}HEADER").append("\n");

						flatFile.append("{MAIN").append("\n");//추가 넣음
						//BkgJapanTerminalEdiVO
//					if("Y".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCngFlg())){//SnaccsTmlEdiStsCngFlg가 Y 인 경우는 JP_BL 의 STS 우선으로 전송 전송이후에는 N으로 resolve 2012.04.17   [CHM-201216534-01]  조원주
						flatFile.append("BRAC:")			.append(dbDao.searchEdiStsCode(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())).append("\n");
//						}else{
//							flatFile.append("BRAC:")			.append(dbDao.searchEdiStsCode(bkgJpTmlEdiVO.getSnaccsTmlEdiStsCngFlg())).append("\n");
//						}
						flatFile.append("SCAC_CD:")			.append("SMLM").append("\n"); 
						
						flatFile.append("BKGNBR:")				.append(bkgTerminalEdiJapanBlVO.getBkgNo()).append("\n");
						
						flatFile.append("VSL_CALL_SIGN:")	.append(bkgTerminalEdiJapanBlVO.getCallSgnNo().length()>0?bkgTerminalEdiJapanBlVO.getCallSgnNo().substring(0, bkgTerminalEdiJapanBlVO.getCallSgnNo().length()).toUpperCase():"").append("\n"); 
						
						if(bkgTerminalEdiJapanBlVO.getCallSgnNo().length()>0){ //MIG 5번 적재예정선박코드CallSign 이 있을 경우 6번은 공란으로 전송
							flatFile.append("VSLNAME:")    .append("").append("\n");
							
						}else{
							flatFile.append("VSLNAME:")		.append(bkgTerminalEdiJapanBlVO.getVslEngNm().length()>0?bkgTerminalEdiJapanBlVO.getVslEngNm().substring(0, bkgTerminalEdiJapanBlVO.getVslEngNm().length()).toUpperCase():"").append("\n");
						
						}
						flatFile.append("VVD:")	                .append(bkgTerminalEdiJapanBlVO.getJpTmlVslNo()).append("\n");//.append(bkgTerminalEdiJapanBlVO.getVslCd()+bkgTerminalEdiJapanBlVO.getSkdVoyNo()+bkgTerminalEdiJapanBlVO.getSkdDirCd()).append("\n");//확인
						flatFile.append("BKG_DT:")			.append("").append("\n");// bkgTerminalEdiJapanBlVO.getBkgCreDt().length()>0?bkgTerminalEdiJapanBlVO.getBkgCreDtYmd():"" 2012.04.25 손영주과장님 공란요청
						flatFile.append("POL_UNLC:")			.append(chkStrLoc(bkgTerminalEdiJapanBlVO.getPolCd())).append("\n");
											
						flatFile.append("POL_YDCD:")				.append( dbDao.searchCYCode(bkgTerminalEdiJapanBlVO.getPolYdCd())).append("\n");//SELECT INTG_CD_VAL_DP_DESC ?
						flatFile.append("POR_UNLC:")				.append(chkStrLoc(bkgTerminalEdiJapanBlVO.getPorCd())).append("\n");					
						flatFile.append("POR_YDCD:")				.append(dbDao.searchCYCode(bkgTerminalEdiJapanBlVO.getPorYdCd())).append("\n");//SELECT INTG_CD_VAL_DP_DESC ?
						
						flatFile.append("OTHR_NTFY:")				.append(dbDao.searchCYCode(chkStrNull(bkgTerminalEdiJapanBlVO.getOtrNtfyYdCd()))).append("\n"); //SELECT INTG_CD_VAL_DP_DESC ?

						flatFile.append("POL_ETD:")				.append(chkStrNull(bkgTerminalEdiJapanBlVO.getEtdDt()).length()>0?bkgTerminalEdiJapanBlVO.getEtdDtYmd():" ").append("\n");//TO_CHAR(ETD_DT,'YYYYMMDD')   
						flatFile.append("POD_UNLC:")				.append(chkStrLoc(dbDao.searchPrePod(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanBlVO.getVslCd(), bkgTerminalEdiJapanBlVO.getSkdVoyNo(), bkgTerminalEdiJapanBlVO.getSkdDirCd()))).append("\n");//고쳐야함
						//flatFile.append("POD_UNLC2:")				.append("").append("\n");
						flatFile.append("DEL_UNLC:")				.append(chkStrLoc(bkgTerminalEdiJapanBlVO.getFnlDestCd())).append("\n");//DEL_CD or LOCATION.LOC_DESC?
						
						flatFile.append("DEL_NAME:")				.append(bkgTerminalEdiJapanBlVO.getFnlDestNm().length()>0?bkgTerminalEdiJapanBlVO.getFnlDestNm().substring(0, bkgTerminalEdiJapanBlVO.getFnlDestNm().length()).toUpperCase():"").append("\n");//????
						flatFile.append("RCVTYP:")				.append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiRcvTermCd()).append("\n");
						flatFile.append("DELTYP:")				.append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiDeTermCd()).append("\n");
						flatFile.append("DEST_UNLC:")				.append("").append("\n");//chkStrLoc(bkgTerminalEdiJapanBlVO.getFnlDestCd())
						flatFile.append("DEST_UNLC_NAME:")				.append("").append("\n");//bkgTerminalEdiJapanBlVO.getFnlDestNm().length()>0?bkgTerminalEdiJapanBlVO.getFnlDestNm().toUpperCase():""
						flatFile.append("TRSH_UNCD:")				.append(chkStrLoc(dbDao.searchTrshUncd(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanBlVO.getPolCd(), bkgTerminalEdiJapanBlVO.getVslCd(), bkgTerminalEdiJapanBlVO.getSkdVoyNo(), bkgTerminalEdiJapanBlVO.getSkdDirCd()))).append("\n");//고쳐야함
						
						flatFile.append("SH_CD1:")				.append(chkStrNull(bkgTerminalEdiJapanBlVO.getShprCustNm()).length()>0?"":bkgTerminalEdiJapanBlVO.getShprCntCd()+bkgTerminalEdiJapanBlVO.getShprCustSeq()).append("\n");
						
						flatFile.append("SHN1:")				.append(bkgTerminalEdiJapanBlVO.getShprCustNm().length()>0?bkgTerminalEdiJapanBlVO.getShprCustNm().toUpperCase():"").append("\n");
						flatFile.append("FF_CD1:")				.append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getFrtFwrdCntCd()+bkgTerminalEdiJapanBlVO.getFrtFwrdCustSeq()).append("\n");
						flatFile.append("FFN1:")				.append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getFrtFwrdCustNm().length()>0?bkgTerminalEdiJapanBlVO.getFrtFwrdCustNm().toUpperCase():"").append("\n");
						flatFile.append("CARGOTYPE:")				.append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiCgoTpCd()).append("\n");
						flatFile.append("CARGO_IND:")				.append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiCgoKndCd()).append("\n");
						flatFile.append("PKG_CD:")				.append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getPckTpCd()).append("\n");
						flatFile.append("CMDD:")				.append(bkgTerminalEdiJapanBlVO.getCmdtNm().length()>0?bkgTerminalEdiJapanBlVO.getCmdtNm().substring(0, bkgTerminalEdiJapanBlVO.getCmdtNm().length()).toUpperCase():"").append("\n");
						flatFile.append("REMARK:")				.append(bkgTerminalEdiJapanBlVO.getXterRmk().length()>0?bkgTerminalEdiJapanBlVO.getXterRmk().substring(0, bkgTerminalEdiJapanBlVO.getXterRmk().length()).toUpperCase():"").append("\n");
						
						cntrVO =  dbDao.searchJapanCntrPKGInfo(bkgTerminalEdiJapanBlVO.getBkgNo());
						
						flatFile.append("PKG:")				.append("").append("\n");//.append(cntrVO.getPckQty()).append("\n");
						flatFile.append("PUNIT:")				.append("").append("\n");//.append(cntrVO.getPckTpCd()).append("\n");
						flatFile.append("WGT:")				.append("").append("\n");//.append(cntrVO.getCntrWgt()).append("\n");
						flatFile.append("WUNIT:")				.append("").append("\n");//.append(cntrVO.getWgtUtCd()).append("\n");
						flatFile.append("MEAS:")				.append("").append("\n");//.append(cntrVO.getMeasQty()).append("\n");
						flatFile.append("MUNIT:")				.append("").append("\n");//.append(cntrVO.getMeasUtCd()).append("\n");
						
						
						bkgTerminalEdiJapanCntrList =  dbDao.searchJapanCntrInfo(bkgTerminalEdiJapanBlVO.getBkgNo());
					for( cntrIdx = 0; cntrIdx < bkgTerminalEdiJapanCntrList.size(); cntrIdx++){
						// (1)Container 정보
						flatFile.append("{CNTR_INFO").append("\n");
						flatFile.append("CNTR_SIZE:")				.append(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()>0?bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(0, 2):"").append("\n"); //
						//group tp code로 가져오기
						if(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length() > 0){
						flatFile.append("CNTR_TYPE:")				.append(dbDao.searchIsoGroupTpCd(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(2, bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()))).append("\n");//.append(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()>0?bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(2, bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()):"").append("\n");
						}else{
							flatFile.append("CNTR_TYPE:")	        .append("");
						}
						if((cntrIdx)==0){
							flatFile.append("CNT:")				        .append(bkgTerminalEdiJapanBlVO.getCntrVolQty1()).append("\n");
						}else if((cntrIdx)==1){
							flatFile.append("CNT:")				        .append(bkgTerminalEdiJapanBlVO.getCntrVolQty2()).append("\n");
						}else if((cntrIdx)==2){
							 flatFile.append("CNT:")				        .append(bkgTerminalEdiJapanBlVO.getCntrVolQty3()).append("\n");
						}else if((cntrIdx)==3){
							 flatFile.append("CNT:")				        .append(bkgTerminalEdiJapanBlVO.getCntrVolQty4()).append("\n");
						}else if((cntrIdx)==4){
							 flatFile.append("CNT:")				        .append(bkgTerminalEdiJapanBlVO.getCntrVolQty5()).append("\n");
						}
						
						//flatFile.append("CNT:")				        .append(chkStrNull(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCount())).append("\n");// 확인
						
						//JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL
						blVO = dbDao.searchJapanCntrStowageInfo(bkgTerminalEdiJapanBlVO.getBkgNo(),bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
						
						flatFile.append("PKUP_NAME:")				.append("").append("\n");
						flatFile.append("STWG_REQ:")				.append(chkStrNull(blVO.getSnaccsTmlEdiStwgCd())).append("\n");
						flatFile.append("STWG_REQ2:")				.append("").append("\n");
						flatFile.append("STWG_REMARK:")				.append(chkStrNull((blVO.getXterRmk()))).append("\n");
						flatFile.append("BLKSTWG:")				.append(blVO.getBlckStwgCd()).append("\n");
						flatFile.append("RD_IND:")				.append(chkStrNull("N".equals(blVO.getDryCgoFlg())?"":"1")).append("\n");
						flatFile.append("MT_IND:")				.append(chkStrNull("N".equals(blVO.getMcntrFlg())?"":"1")).append("\n");
						flatFile.append("SOC_IND:")				.append(chkStrNull("N".equals(blVO.getSocFlg())?"":"1")).append("\n");
						flatFile.append("RF_RRE:")				.append("").append("\n"); //blVO.getEqSubstFlg() 2012.04.25 손영주과장님 공란요청
						
						//JapanTerminalTransmissionDBDAOsearchJapanRFCgoInfoRSQL
						//Unused Local Variable
						//rfVO =dbDao.searchJapanRFCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(),bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
						flatFile.append("TEMP_MAX:")				.append("").append("\n");//rfVO.getCdoTemp()  2012.04.25 손영주과장님 공란요청
						flatFile.append("TEMP:")				.append("").append("\n");//rfVO.getCdoTemp()  2012.04.25 손영주과장님 공란요청
						flatFile.append("TEMP_MIN:")				.append("").append("\n");//rfVO.getCdoTemp()  2012.04.25 손영주과장님 공란요청
						flatFile.append("TEMP_UNIT:")				.append("").append("\n");//rfVO.getClngTpCd()  2012.04.25 손영주과장님 공란요청
						flatFile.append("HUMID:")				.append("").append("\n");//rfVO.getHumidNo()  2012.04.25 손영주과장님 공란요청
						//flatFile.append("VENT:")				.append(rfVO.getCntrVentTpCd()).append("\n"); 
						flatFile.append("VENT:")				.append("").append("\n");//dbDao.searchJapanTmlEdiVentRTO(rfVO.getVentRto())  2012.04.25 손영주과장님 공란요청
						
						//JapanTerminalTransmissionDBDAOsearchJapanAWKCgoInfoRSQL
						
						awkVO= dbDao.searchJapanAWKCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(),bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
						flatFile.append("OVH:")				.append(awkVO.getOvrHgt()).append("\n");
						flatFile.append("OVLW:")				.append(awkVO.getOvrLfLen()).append("\n");
						flatFile.append("OVRW:")				.append(awkVO.getOvrRtLen()).append("\n");
						flatFile.append("OVFR:")				.append(chkStrNull(awkVO.getOvfr())).append("\n");//awkVO.getOvrFwrdLen()+awkVO.getOvrBkwdLen()
						flatFile.append("VOID_SLOT:")				.append(awkVO.getOvrVoidSltQty()).append("\n");
						
						//JapanTerminalTransmissionDBDAOsearchJapanDGInfoRSQL.Query
						dgVO= dbDao.searchJapanDGCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd()); //cntr_tpsz_cd
						flatFile.append("MAR_POLL:")				.append(dgVO.getMrnPolutFlg()).append("\n"); 
						flatFile.append("IMO_LIMIT:")				.append(dgVO.getImdgLmtQtyFlg()).append("\n");

					
						
						// (2)Container Danger Main 정보
						dgMainList =  dbDao.searchJapanDangerMainInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());//cntr_tpsz_cd
						
//						
						//xml문서 총 길이가 부족하면 seanaccs에서 에러난다고 함from 손과장님
						//총 길이를 맞추기 위해서 빈 문자열 찍어주기로 함 5* 10 반복
						for( dgMainIdx = 0; dgMainIdx < 5; dgMainIdx++){
							flatFile.append("{CNTR_DANGER_MAIN").append("\n");
					    	 
							flatFile.append("CLAS:")  	.append(dgMainList.size()==0 ?"":(dgMainList.size()>dgMainIdx?dgMainList.get(dgMainIdx).getImdgClssCd():"")).append("\n");
					    	// (3)Container Danger Detail 정보
							
							boolean bbBlan = false;
							if(dgMainList.size()>dgMainIdx){
								dgDetailList =  dbDao.searchJapanDangerDetailInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd(),dgMainList.get(dgMainIdx).getImdgClssCd()); //cntr_tpsz_cd, imdg_clss_cd
								bbBlan = true;
							}
							else
							{
								bbBlan = false;
							}
//							
							//xml문서 총 길이가 부족하면 seanaccs에서 에러난다고 함from 손과장님
							//총 길이를 맞추기 위해서 빈문자열 찍어줌 5*10 반복
							for( dgDetailIdx = 0; dgDetailIdx < 10; dgDetailIdx++){
								if(bbBlan){
									flatFile.append("{CNTR_DANGER_DETAIL").append("\n");
									flatFile.append("UNBR:")	.append(dgDetailList.size()==0?"":(dgDetailList.size()> dgDetailIdx?dgDetailList.get(dgDetailIdx).getImdgUnNo():"")).append("\n");
									flatFile.append("PKGGRP:")	.append(dgDetailList.size()==0?"":(dgDetailList.size()> dgDetailIdx?dgDetailList.get(dgDetailIdx).getImdgPckGrpCd():"")).append("\n");
									flatFile.append("}CNTR_DANGER_DETAIL").append("\n");
								}else{
									flatFile.append("{CNTR_DANGER_DETAIL").append("\n");
									flatFile.append("UNBR:").append("\n");
									flatFile.append("PKGGRP:").append("\n");
									flatFile.append("}CNTR_DANGER_DETAIL").append("\n");
								}
							}
						
							flatFile.append("}CNTR_DANGER_MAIN").append("\n");
						}//for (cntr danger main end)
						
						flatFile.append("}CNTR_INFO").append("\n");
					}//for (cntr info end)
						
					flatFile.append("}MAIN").append("\n");
					
					
					
					/*Detail log를 쌓기 위한 flat file log 용 start 2012.04.23 */
										
										realflatFile.append(" ").append("\n");//추가 넣음{MAIN
										realflatFile.append(" ").append("\n");
										realflatFile.append(" ").append("\n");
										//BkgJapanTerminalEdiVO
//									if("Y".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCngFlg())){//SnaccsTmlEdiStsCngFlg가 Y 인 경우는 JP_BL 의 STS 우선으로 전송 전송이후에는 N으로 resolve 2012.04.17   [CHM-201216534-01]  조원주
										realflatFile.append(" ").append(dbDao.searchEdiStsCode(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())).append("\n");//BRAC:
//										}else{
//											flatFile.append("BRAC:")			.append(dbDao.searchEdiStsCode(bkgJpTmlEdiVO.getSnaccsTmlEdiStsCngFlg())).append("\n");
//										}
										realflatFile.append(" ").append("SMLM").append("\n"); //SCAC_CD:
										
										realflatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getBkgNo()).append("\n");//BKGNBR:
										
										realflatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getCallSgnNo().length()>0?bkgTerminalEdiJapanBlVO.getCallSgnNo().substring(0, bkgTerminalEdiJapanBlVO.getCallSgnNo().length()).toUpperCase():"").append("\n");//VSL_CALL_SIGN: 
										
										if(bkgTerminalEdiJapanBlVO.getCallSgnNo().length()>0){ //MIG 5번 적재예정선박코드CallSign 이 있을 경우 6번은 공란으로 전송
											realflatFile.append(" ").append("").append("\n");//VSLNAME:
											
										}else{
											realflatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getVslEngNm().length()>0?bkgTerminalEdiJapanBlVO.getVslEngNm().substring(0, bkgTerminalEdiJapanBlVO.getVslEngNm().length()).toUpperCase():"").append("\n");//VSLNAME:
										
										}
										realflatFile.append(" ") .append(bkgTerminalEdiJapanBlVO.getJpTmlVslNo()).append("\n");//확인VVD:
										realflatFile.append(" ") .append("").append("\n");// bkgTerminalEdiJapanBlVO.getBkgCreDt().length()>0?bkgTerminalEdiJapanBlVO.getBkgCreDtYmd():"" 2012.04.25 손영주과장님 공란요청 TO_CHAR(BKG_CRE_DT,'YYYYMMDD')BKG_DT:
										realflatFile.append(" ") .append(chkStrLoc(bkgTerminalEdiJapanBlVO.getPolCd())).append("\n");//POL_UNLC:
															
										realflatFile.append(" ")				.append( dbDao.searchCYCode(bkgTerminalEdiJapanBlVO.getPolYdCd())).append("\n");//SELECT INTG_CD_VAL_DP_DESC ?  POL_YDCD:
										realflatFile.append(" ")				.append(chkStrLoc(bkgTerminalEdiJapanBlVO.getPorCd())).append("\n");	//POR_UNLC:				
										realflatFile.append(" ")				.append(dbDao.searchCYCode(bkgTerminalEdiJapanBlVO.getPorYdCd())).append("\n");//SELECT INTG_CD_VAL_DP_DESC ?POR_YDCD:
										
										realflatFile.append(" ")				.append(dbDao.searchCYCode(chkStrNull(bkgTerminalEdiJapanBlVO.getOtrNtfyYdCd()))).append("\n"); //SELECT INTG_CD_VAL_DP_DESC ? OTHR_NTFY:

										realflatFile.append(" ")				.append(chkStrNull(bkgTerminalEdiJapanBlVO.getEtdDt()).length()>0?bkgTerminalEdiJapanBlVO.getEtdDtYmd():" ").append("\n");//TO_CHAR(ETD_DT,'YYYYMMDD')POL_ETD:   
										realflatFile.append(" ")				.append(chkStrLoc(dbDao.searchPrePod(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanBlVO.getVslCd(), bkgTerminalEdiJapanBlVO.getSkdVoyNo(), bkgTerminalEdiJapanBlVO.getSkdDirCd()))).append("\n");//POD_UNLC:
										//realflatFile.append(" ")				.append("").append("\n");//POD_UNLC2:
										realflatFile.append(" ")				.append(chkStrLoc(bkgTerminalEdiJapanBlVO.getFnlDestCd())).append("\n");//DEL_CD or LOCATION.LOC_DESC? DEL_UNLC:
										realflatFile.append(" ")				.append(bkgTerminalEdiJapanBlVO.getFnlDestNm().length()>0?bkgTerminalEdiJapanBlVO.getFnlDestNm().substring(0, bkgTerminalEdiJapanBlVO.getFnlDestNm().length()).toUpperCase():"").append("\n");//???? DEL_NAME:
										realflatFile.append(" ")				.append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiRcvTermCd()).append("\n");//RCVTYP:
										realflatFile.append(" ")				.append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiDeTermCd()).append("\n");//DELTYP:
										realflatFile.append(" ")				.append("").append("\n");//DEST_UNLC: chkStrLoc(bkgTerminalEdiJapanBlVO.getFnlDestCd())
										realflatFile.append(" ")				.append("").append("\n");//DEST_UNLC_NAME: bkgTerminalEdiJapanBlVO.getFnlDestNm().length()>0?bkgTerminalEdiJapanBlVO.getFnlDestNm().toUpperCase():""
										realflatFile.append(" ")				.append(chkStrLoc(dbDao.searchTrshUncd(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanBlVO.getPolCd(), bkgTerminalEdiJapanBlVO.getVslCd(), bkgTerminalEdiJapanBlVO.getSkdVoyNo(), bkgTerminalEdiJapanBlVO.getSkdDirCd()))).append("\n");//TRSH_UNCD:
										
										realflatFile.append(" ")				.append(chkStrNull(bkgTerminalEdiJapanBlVO.getShprCustNm()).length()>0?"":bkgTerminalEdiJapanBlVO.getShprCntCd()+bkgTerminalEdiJapanBlVO.getShprCustSeq()).append("\n");//SH_CD1:
										
										realflatFile.append(" ")				.append(bkgTerminalEdiJapanBlVO.getShprCustNm().length()>0?bkgTerminalEdiJapanBlVO.getShprCustNm().toUpperCase():"").append("\n");//SHN1:
										realflatFile.append(" ")				.append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getFrtFwrdCntCd()+bkgTerminalEdiJapanBlVO.getFrtFwrdCustSeq()).append("\n");//FF_CD1:
										realflatFile.append(" ")				.append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getFrtFwrdCustNm().length()>0?bkgTerminalEdiJapanBlVO.getFrtFwrdCustNm().toUpperCase():"").append("\n");
										realflatFile.append(" ")				.append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiCgoTpCd()).append("\n");//CARGOTYPE:
										realflatFile.append(" ")				.append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiCgoKndCd()).append("\n");CARGO_IND:
										realflatFile.append(" ")				.append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getPckTpCd()).append("\n");PKG_CD:
										realflatFile.append(" ")				.append(bkgTerminalEdiJapanBlVO.getCmdtNm().length()>0?bkgTerminalEdiJapanBlVO.getCmdtNm().substring(0, bkgTerminalEdiJapanBlVO.getCmdtNm().length()).toUpperCase():"").append("\n");//CMDD:
										realflatFile.append(" ")				.append(bkgTerminalEdiJapanBlVO.getXterRmk().length()>0?bkgTerminalEdiJapanBlVO.getXterRmk().substring(0, bkgTerminalEdiJapanBlVO.getXterRmk().length()).toUpperCase():"").append("\n");//REMARK:
										
										cntrVO =  dbDao.searchJapanCntrPKGInfo(bkgTerminalEdiJapanBlVO.getBkgNo());
										
										realflatFile.append(" ")				.append("").append("\n");//.append(cntrVO.getPckQty()).append("\n");PKG:
										realflatFile.append(" ")				.append("").append("\n");//.append(cntrVO.getPckTpCd()).append("\n");PUNIT:
										realflatFile.append(" ")				.append("").append("\n");//.append(cntrVO.getCntrWgt()).append("\n");WGT:
										realflatFile.append(" ")				.append("").append("\n");//.append(cntrVO.getWgtUtCd()).append("\n");WUNIT:
										realflatFile.append(" ")				.append("").append("\n");//.append(cntrVO.getMeasQty()).append("\n");MEAS:
										realflatFile.append(" ")				.append("").append("\n");//.append(cntrVO.getMeasUtCd()).append("\n");MUNIT:
										
										
										bkgTerminalEdiJapanCntrList =  dbDao.searchJapanCntrInfo(bkgTerminalEdiJapanBlVO.getBkgNo());
									for( cntrIdx = 0; cntrIdx < bkgTerminalEdiJapanCntrList.size(); cntrIdx++){
										// (1)Container 정보
										realflatFile.append(" ").append("\n");//{CNTR_INFO
										realflatFile.append(" ")				.append(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()>0?bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(0, 2):"").append("\n"); //CNTR_SIZE:
										//group tp code로 가져오기
										if(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length() > 0){
										
											realflatFile.append(" ")				.append(dbDao.searchIsoGroupTpCd(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(2, bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()))).append("\n");//.append(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()>0?bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(2, bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()):"").append("\n");CNTR_TYPE:
										
										}else{
											realflatFile.append(" ")             .append("");
										}
															
										if((cntrIdx)==0){
											realflatFile.append(" ")				        .append(bkgTerminalEdiJapanBlVO.getCntrVolQty1()).append("\n");// 확인CNT:
										}else if((cntrIdx)==1){
											realflatFile.append(" ")				        .append(bkgTerminalEdiJapanBlVO.getCntrVolQty2()).append("\n");// 확인CNT:
										}else if((cntrIdx)==2){
											realflatFile.append(" ")				        .append(bkgTerminalEdiJapanBlVO.getCntrVolQty3()).append("\n");// 확인CNT:
										}else if((cntrIdx)==3){
											realflatFile.append(" ")				        .append(bkgTerminalEdiJapanBlVO.getCntrVolQty4()).append("\n");// 확인CNT:
										}else if((cntrIdx)==4){
											realflatFile.append(" ")				        .append(bkgTerminalEdiJapanBlVO.getCntrVolQty5()).append("\n");// 확인CNT:
										}
										
										//flatFile.append("CNT:")				        .append(chkStrNull(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCount())).append("\n");// 확인
										
										//JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL
										blVO = dbDao.searchJapanCntrStowageInfo(bkgTerminalEdiJapanBlVO.getBkgNo(),bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
										
										realflatFile.append(" ")				.append("").append("\n");//PKUP_NAME:
										realflatFile.append(" ")				.append(chkStrNull(blVO.getSnaccsTmlEdiStwgCd())).append("\n");//STWG_REQ:
										realflatFile.append(" ")				.append("").append("\n");//STWG_REQ2:
										realflatFile.append(" ")				.append(chkStrNull((blVO.getXterRmk()))).append("\n");//STWG_REMARK:
										realflatFile.append(" ")				.append(blVO.getBlckStwgCd()).append("\n");//BLKSTWG:
										realflatFile.append(" ")				.append(chkStrNull("N".equals(blVO.getDryCgoFlg())?"":"1")).append("\n");//RD_IND:
										realflatFile.append(" ")				.append(chkStrNull("N".equals(blVO.getMcntrFlg())?"":"1")).append("\n");//MT_IND:
										realflatFile.append(" ")				.append(chkStrNull("N".equals(blVO.getSocFlg())?"":"1")).append("\n");//SOC_IND:
										realflatFile.append(" ")				.append("").append("\n"); //blVO.getEqSubstFlg() 2012.04.25 손영주과장님 공란요청//RF_RRE:
										
										//JapanTerminalTransmissionDBDAOsearchJapanRFCgoInfoRSQL
										//Unused Local Variable
										//rfVO =dbDao.searchJapanRFCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(),bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
										realflatFile.append(" ")				.append("").append("\n");//TEMP_MAX: 2012.04.25 손영주과장님 공란요청//RF_RRE:
										realflatFile.append(" ")				.append("").append("\n");//TEMP: 2012.04.25 손영주과장님 공란요청//RF_RRE:
										realflatFile.append(" ")				.append("").append("\n");//TEMP_MIN: 2012.04.25 손영주과장님 공란요청//RF_RRE:
										realflatFile.append(" ")				.append("").append("\n");//TEMP_UNIT: 2012.04.25 손영주과장님 공란요청//RF_RRE:
										realflatFile.append(" ")				.append("").append("\n");//HUMID: 2012.04.25 손영주과장님 공란요청//RF_RRE:
										//flatFile.append("VENT:")				.append(rfVO.getCntrVentTpCd()).append("\n"); 2012.04.25 손영주과장님 공란요청//RF_RRE:
										realflatFile.append(" ")				.append("").append("\n");//VENT: 2012.04.25 손영주과장님 공란요청//RF_RRE:
										
										//JapanTerminalTransmissionDBDAOsearchJapanAWKCgoInfoRSQL
										
										awkVO= dbDao.searchJapanAWKCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(),bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
										realflatFile.append(" ")				.append(awkVO.getOvrHgt()).append("\n");//OVH:
										realflatFile.append(" ")				.append(awkVO.getOvrLfLen()).append("\n");//OVLW:
										realflatFile.append(" ")				.append(awkVO.getOvrRtLen()).append("\n");//OVRW:
										realflatFile.append(" ")				.append(chkStrNull(awkVO.getOvfr())).append("\n");//awkVO.getOvrFwrdLen()+awkVO.getOvrBkwdLen()//OVFR:
										realflatFile.append(" ")				.append(awkVO.getOvrVoidSltQty()).append("\n");//VOID_SLOT:
										
										//JapanTerminalTransmissionDBDAOsearchJapanDGInfoRSQL.Query
										dgVO= dbDao.searchJapanDGCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd()); //cntr_tpsz_cd
										realflatFile.append(" ")				.append(dgVO.getMrnPolutFlg()).append("\n"); //MAR_POLL:
										realflatFile.append(" ")				.append(dgVO.getImdgLmtQtyFlg()).append("\n");//IMO_LIMIT:

									
										
										// (2)Container Danger Main 정보
										dgMainList =  dbDao.searchJapanDangerMainInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());//cntr_tpsz_cd
										
//										
										//xml문서 총 길이가 부족하면 seanaccs에서 에러난다고 함from 손과장님
										//총 길이를 맞추기 위해서 빈 문자열 찍어주기로 함 5* 10 반복
										for( dgMainIdx = 0; dgMainIdx < 5; dgMainIdx++){
											realflatFile.append(" ").append("\n");//{CNTR_DANGER_MAIN
									    	 
											realflatFile.append(" ")  	.append(dgMainList.size()==0 ?"":(dgMainList.size()>dgMainIdx?dgMainList.get(dgMainIdx).getImdgClssCd():"")).append("\n");//CLAS:
									    	// (3)Container Danger Detail 정보
											
											boolean bbBlan = false;
											if(dgMainList.size()>dgMainIdx){
												dgDetailList =  dbDao.searchJapanDangerDetailInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd(),dgMainList.get(dgMainIdx).getImdgClssCd()); //cntr_tpsz_cd, imdg_clss_cd
												bbBlan = true;
											}
											else
											{
												bbBlan = false;
											}
//											
											//xml문서 총 길이가 부족하면 seanaccs에서 에러난다고 함from 손과장님
											//총 길이를 맞추기 위해서 빈문자열 찍어줌 5*10 반복
											for( dgDetailIdx = 0; dgDetailIdx < 10; dgDetailIdx++){
												if(bbBlan){
													realflatFile.append(" ").append("\n");//{CNTR_DANGER_DETAIL
													realflatFile.append(" ")	.append(dgDetailList.size()==0?"":(dgDetailList.size()> dgDetailIdx?dgDetailList.get(dgDetailIdx).getImdgUnNo():"")).append("\n");
													realflatFile.append(" ")	.append(dgDetailList.size()==0?"":(dgDetailList.size()> dgDetailIdx?dgDetailList.get(dgDetailIdx).getImdgPckGrpCd():"")).append("\n");
													realflatFile.append(" ").append("\n");//}CNTR_DANGER_DETAIL
												}else{
													realflatFile.append(" ").append("\n");
													realflatFile.append(" ").append("\n");//UNBR:
													realflatFile.append(" ").append("\n");//PKGGRP:
													realflatFile.append(" ").append("\n");
												}
											}
										
											realflatFile.append(" ").append("\n");
										}//for (cntr danger main end)
										
										realflatFile.append(" ").append("\n");
									}//for (cntr info end)
										
									realflatFile.append(" ").append("\n");
									
			/*Detail log를 쌓기 위한 flat file log 용 end  2012.04.23 */
				
				log.debug(flatFile);
				
			
				// flatFile MQ로 전송
				ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_TML_JPEDI.IBMMQ.QUEUE");//EDI 전송
				
				
				// send Flat File log VO 셋팅
				BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO(); // send
				BkgCstmsJpSndLogDtlVO bkgCstmsJpSndLogDtlVO = new BkgCstmsJpSndLogDtlVO(); // send
				
				BookingUtil command = new BookingUtil();
				
				String sndDt = command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3));
				//String logSeq = dbDao.searchLogSeq(sndDt);
				//JapanTerminalTransmissionDBDAOsearchSendLogSeqRSQL
				String msgTp="";
				if("R".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())){
				 msgTp = "BKR";
				}else {
				 msgTp = "BKC";
				}
				// 전송로그를 저장한다. (MASTER)
				bkgCstmsJpSndLogVO.setBlNo(bkgTerminalEdiJapanBlVO.getBkgNo());
				bkgCstmsJpSndLogVO.setSndDt(sndDt);
				bkgCstmsJpSndLogVO.setJpSndLogId(msgTp);
				bkgCstmsJpSndLogVO.setOfcCd(account.getOfc_cd());
				bkgCstmsJpSndLogVO.setLogSeq(""+logSeq);
				bkgCstmsJpSndLogVO.setVslCd(bkgTerminalEdiJapanBlVO.getVslCd());
				bkgCstmsJpSndLogVO.setSkdVoyNo(bkgTerminalEdiJapanBlVO.getSkdVoyNo());
				bkgCstmsJpSndLogVO.setSkdDirCd(bkgTerminalEdiJapanBlVO.getSkdDirCd());
				bkgCstmsJpSndLogVO.setPodCd(bkgTerminalEdiJapanBlVO.getPodCd());
				bkgCstmsJpSndLogVO.setLogFlg("N");
				bkgCstmsJpSndLogVO.setLogDt(command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3)));
				bkgCstmsJpSndLogVO.setSndFlg("Y");
				bkgCstmsJpSndLogVO.setCreUsrId(account.getUsr_id());
				bkgCstmsJpSndLogVO.setUpdUsrId(account.getUsr_id());
				bkgCstmsJpSndLogVO.setPolCd(bkgTerminalEdiJapanBlVO.getPolCd());
				bkgCstmsJpSndLogVO.setPorCd(bkgTerminalEdiJapanBlVO.getPorCd());
				bkgCstmsJpSndLogVO.setPolYdCd(bkgTerminalEdiJapanBlVO.getPolYdCd());
				bkgCstmsJpSndLogVO.setPorYdCd(bkgTerminalEdiJapanBlVO.getPorYdCd());
				
				
				if(bkgCstmsJpSndLogVO != null) {
					dbDao.addJapanTerminalSendLog(bkgCstmsJpSndLogVO);
				}
			
				
				//FlatFile을 4000Byte씩 나눈다 - start (100Byte의 여유를 주기 위해 3900Byte로 나눔)
				int divisor = 3900;
				int totLength = flatFile.length();
				int quotient = totLength / divisor;
				int remainder = totLength % divisor;
					
				int loopCnt = 0;
				//int start = 0;
				//int end = 0;
				
				if(remainder > 0) {
//					loopCnt = quotient + 1;
//				} else {
					loopCnt = quotient;
				}
				
				//String[] fFiles = new String[loopCnt];
				
		
				for(int i = 0; i < loopCnt; i++) {
					
//					if(i == loopCnt-1) {
//						end = remainder;
//					} else {
//						end = divisor;
//					}
//					
//					start = i * divisor;
					
					//fFiles[i] = realflatFile.substring(start, start+end);
					//realFlatFile.append(flatFile.toString().replace(flatFile.substring(0, flatFile.indexOf(":")),""));
					
					
					realFlatFile.append(realflatFile.toString().replace("’","'"));
					
					//realFlatFile.append(flatFile.toString().replace(fFiles[i].toString().substring(0,flatFile.indexOf("}HEADER")),""));
					//realFlatFile.append(flatFile.toString().replace(fFiles[i].toString().substring(flatFile.indexOf("}HEADER"),flatFile.indexOf("}HEADER")),""));
					//realFlatFile.append(flatFile.toString().replace(":",""));	
	
					ArrayList tmpArray = new ArrayList();
					StringTokenizer token = new StringTokenizer(realFlatFile.toString().replace("\r\n","\n"), "\n");//.replace("\r\n","\n"), "\n");
					int j = 0;
					
					//String ediSndMsg = dbDao.searchEdiSndMsg(sndDt,msgTp,account.getOfc_cd(), logSeq);
					//Send Log Detail 이력 VO에 세팅
					bkgCstmsJpSndLogDtlVO.setJpSndLogId(msgTp);
					bkgCstmsJpSndLogDtlVO.setMsgSndDt(sndDt);
					bkgCstmsJpSndLogDtlVO.setOfcCd(account.getOfc_cd());
					bkgCstmsJpSndLogDtlVO.setLogSeq(""+logSeq);
					bkgCstmsJpSndLogDtlVO.setSubSeq(i+"");
					//bkgCstmsJpSndLogDtlVO.setEdiSndMsg(ediSndMsg);
					bkgCstmsJpSndLogDtlVO.setCreUsrId(account.getUsr_id());
					bkgCstmsJpSndLogDtlVO.setUpdUsrId(account.getUsr_id());
                     
					while (token.hasMoreTokens()) {
						tmpArray.add(token.nextToken());
						if (j > 1) {
							bkgCstmsJpSndLogDtlVO.setSubSeq(j - 1 + "");
							bkgCstmsJpSndLogDtlVO.setEdiSndMsg(tmpArray.get(j++).toString().replace("'", "''")); //.replace("'", "''")); 
							
							//bkgCstmsJpSndLogDtlVO.setEdiSndMsg(tmpArray.get(j++).toString().replace(tmpArray.get(j++).toString().substring(0, tmpArray.get(j++).toString().indexOf(":")), ""));
							
							
							dbDao.addSendLogDetail(bkgCstmsJpSndLogDtlVO);
						} else {
							j++;
						}
					}


			
					//update JP_BL
					if(bkgCstmsJpSndLogVO != null){
						dbDao.modifyBkgTmlEdiJpBl(bkgCstmsJpSndLogVO, bkgTerminalEdiJapanBlVO.getBkgNo(),bkgTerminalEdiJapanBlVO.getBkgSkdSeq());
					}
					//SnaccsTmlEdiStsCngFlg가 Y 인 경우는 JP_BL 의 STS 우선으로 전송 전송이후에는 N으로 resolve 2012.04.17 [CHM-201216534-01]  조원주
					if("Y".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCngFlg())){
						dbDao.modifySnaccsTmlEdiStsCngFlg(bkgTerminalEdiJapanBlVO.getBkgNo(),bkgTerminalEdiJapanBlVO.getBkgSkdSeq());
					}
					
				}

		
		}catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}
					


	/**
	 * EDI 전송 처리부
	 * @param String flatFile
	 * @param String queueName
	 * @exception EventException
	 */
	private void ediSendMessage(String flatFile, String queueName) throws EventException
	{
		try {					
		  // FlatFile 이 빈 경우 SKIP 처리
			if (flatFile!=null && flatFile.trim().length() > 1) {
			  SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			  sendFlatFileVO.setFlatFile(flatFile);
			  sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueName));
			  BookingUtil utilCommand = new BookingUtil();
			  FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			  if (flatFileAckVO.getAckStsCd().equals("E"))
			  	throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			}
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}
	

//	/**
//	 * BackEndJob을 실행.(CTA)
//	 * 
//	 * @param account
//	 * @param ManifestTransmitVO[] manifestTransmitVOs
//	 * @param String pgmNo
//	 * @return String
//	 * @throws EventException
//	 */
//	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVOs, String pgmNo)  throws EventException{
//
//		JapanTerminalTransmissionBackEndJob backEndJob = new JapanTerminalTransmissionBackEndJob ();
//		backEndJob.setPgmNo(pgmNo);
//		String resultStr = "";
//		
//		if(pgmNo.equals("ESM_BKG_0479")) {//ESM_BKG_1141
//			backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
//			backEndJob.setAccount(account);
//			BackEndJobManager backEndJobManager = new BackEndJobManager();
//			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "Japan EDI Transmit");
//		}
//		
//		return resultStr;
//	}

	/**
	 *  조원주_Sea-NACCS 프로젝트 (20120312)
	 *  Japan batch schedule 조회
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @param SignOnUserAccount account
	 * @return List<VvdJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<VvdJapanTerminalEdiVO> searchVesselListForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO, SignOnUserAccount account) throws EventException {

		try{
			return dbDao.searchVesselListForSchedule(japanTerminalEdiCondVO, account);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 *  조원주_Sea-NACCS 프로젝트 (20120312)
	 *  Japan batch schedule 조회
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @return List<VvdJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<VvdJapanTerminalEdiVO> searchVesselListForBKGRoute(JapanTerminalEdiCondVO japanTerminalEdiCondVO) throws EventException {

		try{
			return dbDao.searchVesselListForBKGRoute(japanTerminalEdiCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 Retrieve 후 수정 SAVE<br>
	 * @param VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs
	 * @param SignOnUserAccount account
	 * @return JapanTerminalEdiCheckRsltVO
	 * @exception EventException
	 */	
	public JapanTerminalEdiCheckRsltVO manageTerminalEdi(VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs,SignOnUserAccount account) throws EventException {
		JapanTerminalEdiCheckRsltVO japanTerminalEdiCheckRsltVO = new JapanTerminalEdiCheckRsltVO();
		//String resultStr = "";
		try {
			//삭제 후 신규, 수정 작업을 한다. 
			for ( int i=0; i<vvdJapanTerminalEdiVOs.length; i++ ) {
				vvdJapanTerminalEdiVOs[i].setUpdUsrId(account.getUsr_id());
				vvdJapanTerminalEdiVOs[i].setCreUsrId(account.getUsr_id());
				
				//배치 스케줄 Update, Insert 시에 BKG Route check하여 Route가 존재하면 저장
				 if ( vvdJapanTerminalEdiVOs[i].getIbflag().equals("U")){
					 String chkFlg = dbDao.searchCheckRoute(vvdJapanTerminalEdiVOs[i]);
					 
					 if("Y".equals(chkFlg)){//Bkg Route가 유효함
						 
						 //VVD_SKD 수정 - CY 코드 변경시에 키값이 변경 되는 것이므로 이미 있던 스케줄은 지우고 업데이트 된 스케줄이등록됨
						 if( !(vvdJapanTerminalEdiVOs[i].getPolYdCd().equals(vvdJapanTerminalEdiVOs[i].getBePolYdCd()))
							|| !(vvdJapanTerminalEdiVOs[i].getPorYdCd().equals(vvdJapanTerminalEdiVOs[i].getBePorYdCd())) )
						 {
							dbDao.removeVesselListBe(vvdJapanTerminalEdiVOs[i]);
							dbDao.removeVesselListJpBlBe(vvdJapanTerminalEdiVOs[i]);
							
							dbDao.addVesselListByBKGRoute(vvdJapanTerminalEdiVOs[i], account);
						 }else{
						 		
							 dbDao.modifyVesselList(vvdJapanTerminalEdiVOs[i], account);
							 if("Y".equals(vvdJapanTerminalEdiVOs[i].getSkdDeltFlg())){
								 dbDao.removeVesselListJpBl(vvdJapanTerminalEdiVOs[i]);
								// dbDao.removeTransmitHistory(vvdJapanTerminalEdiVOs[i]);
							 }else{
								 dbDao.modifyVesselListJpBl(vvdJapanTerminalEdiVOs[i]);//delete flg를 N으로 바꾸었을 시에 JP_BL 테이블에도 적용 시켜준다
							 }
							 //dbDao.modifyVesselListJpBl(vvdJapanTerminalEdiVOs[i], account);//한번 전송된 후 JP_BL 테이블에 voyage no 수정 
							 dbDao.addVslSkdHis(vvdJapanTerminalEdiVOs[i]);
							 japanTerminalEdiCheckRsltVO.setResultStr("Y"); 
						 }
					 }else{
						japanTerminalEdiCheckRsltVO.setResultStr("N");//Bkg Route가 유효하지 않음
					 }
				}else if ( vvdJapanTerminalEdiVOs[i].getIbflag().equals("D")){
					dbDao.removeVesselList(vvdJapanTerminalEdiVOs[i]);
					dbDao.removeVesselListBkgTmlEdiJpCntr(vvdJapanTerminalEdiVOs[i]);
					dbDao.removeVesselListBkgTmlEdiJpDgCgo(vvdJapanTerminalEdiVOs[i]);
					dbDao.removeVesselListBkgTmlEdiJpRfCgo(vvdJapanTerminalEdiVOs[i]);
					dbDao.removeVesselListBkgTmlEdiJpAwkCgo(vvdJapanTerminalEdiVOs[i]);
					dbDao.removeVesselListJpBl(vvdJapanTerminalEdiVOs[i]);
					//dbDao.removeTransmitHistory(vvdJapanTerminalEdiVOs[i]);// 전송이력에서도 숨김
				}else if ( vvdJapanTerminalEdiVOs[i].getIbflag().equals("I")){
					
				 String chkFlg = dbDao.searchCheckRoute(vvdJapanTerminalEdiVOs[i]);
				 String flg = dbDao.searchCheckTableData(vvdJapanTerminalEdiVOs[i]);
					if("Y".equals(chkFlg)){
					   if("Y".equals(flg)){
						   //무결성제약조건 메시지 뿌리기
						   japanTerminalEdiCheckRsltVO.setFlg("Y");
					   }else{
						dbDao.addVesselListByBKGRoute(vvdJapanTerminalEdiVOs[i],account);
						japanTerminalEdiCheckRsltVO.setResultStr("Y");
					   }
					}else{
						japanTerminalEdiCheckRsltVO.setResultStr("N");
					}
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		return japanTerminalEdiCheckRsltVO;
	}
	
	
	/**
	 *  김종옥_Sea-NACCS 프로젝트 (20120312)
	 *  Japan batch schedule 조회
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<BkgJapanTerminalEdiVO> searchBkgInfoForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO, SignOnUserAccount account) throws EventException {

		try{
			return dbDao.searchBkgInfoForSchedule(japanTerminalEdiCondVO, account);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 *  김종옥_Sea-NACCS 프로젝트 (20120312)
	 *  Japan batch schedule 조회
	 * 
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @return List<BkgJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<BkgJapanTerminalEdiVO> searchPartialBkgInfoForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO) throws EventException {

		try{
			return dbDao.searchPartialBkgInfoForSchedule(japanTerminalEdiCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * 판별로직 확인
	 * J<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckColumns(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws EventException {
		try {
			String chk_flg = dbDao.searchCheckColumns(bkgTerminalEdiJapanBlVO);
			return chk_flg;
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * searchNewBkgInfo<br>
	 * 
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @return List<BkgTerminalEdiJapanBlVO>
	 * @exception EventException
	 */
	public List<BkgTerminalEdiJapanBlVO> searchNewBkgInfo(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException {
		try {
			return dbDao.searchNewBkgInfo(vvdJapanTerminalEdiVO);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * searchNewBkgDetailInfo<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return JapanTerminalEdiGroupVO
	 * @exception EventException
	 */
	public JapanTerminalEdiGroupVO searchNewBkgDetailInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws EventException {
		try {
			JapanTerminalEdiGroupVO groupVO = new JapanTerminalEdiGroupVO();
			
			groupVO.setBkgTerminalEdiJapanCntrVOs(dbDao.searchCntrforNewBkgInfo(bkgTerminalEdiJapanBlVO));
			groupVO.setBkgTerminalEdiJapanDgCgoVOs(dbDao.searchDgCgoforNewBkgInfo(bkgTerminalEdiJapanBlVO));
			groupVO.setBkgTerminalEdiJapanAwkCgoVOs(dbDao.searchAwkCgoforNewBkgInfo(bkgTerminalEdiJapanBlVO));
			groupVO.setBkgTerminalEdiJapanRfCgoVOs(dbDao.searchRfCgoforNewBkgInfo(bkgTerminalEdiJapanBlVO));
			
			return groupVO;
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * addNewBkgInfo<br>
	 * 
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param JapanTerminalEdiGroupVO japanTerminalEdiGroupVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String addNewBkgInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, JapanTerminalEdiGroupVO japanTerminalEdiGroupVO, SignOnUserAccount account) throws EventException{
		try {
			String chk_flg = "Y";
			String max_seq = "";
			String chk_seq = "";
			String del_flg = "";
			
			List<BkgTerminalEdiJapanCntrVO> cntrVoList = new ArrayList<BkgTerminalEdiJapanCntrVO>();
			List<BkgTerminalEdiJapanDgCgoVO> dgVoList = new ArrayList<BkgTerminalEdiJapanDgCgoVO>();
			List<BkgTerminalEdiJapanAwkCgoVO> awkVoList = new ArrayList<BkgTerminalEdiJapanAwkCgoVO>();
			List<BkgTerminalEdiJapanRfCgoVO> rfVoList = new ArrayList<BkgTerminalEdiJapanRfCgoVO>();

			//BL
			if(bkgTerminalEdiJapanBlVO != null){
				//Max 값 체크
				max_seq = dbDao.searchNewBkgSeq(bkgTerminalEdiJapanBlVO);
				del_flg = dbDao.searchCntrforNewBkgDelFlg(bkgTerminalEdiJapanBlVO);

				if(max_seq.equals("")){
					dbDao.addNewBkgInfo(bkgTerminalEdiJapanBlVO, account);
				}else{
					dbDao.addNewBkgInfoMax(bkgTerminalEdiJapanBlVO);
					dbDao.updateNewBkgInfo(bkgTerminalEdiJapanBlVO, account);
				}
			}

			if(japanTerminalEdiGroupVO != null){

				cntrVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanCntrVOs();
				dgVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanDgCgoVOs();
				awkVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanAwkCgoVOs();
				rfVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanRfCgoVOs();

				if(cntrVoList.size()>0){
					chk_seq = dbDao.searchCntrforNewBkgSeq(bkgTerminalEdiJapanBlVO);
					if(chk_seq.equals("")){
						dbDao.addCntrforNewBkgInfo(cntrVoList, account);
					}else{
						dbDao.addCntrforNewBkgInfoMax(cntrVoList, max_seq);
						dbDao.deleteCntrforNewBkgInfo(cntrVoList);
						dbDao.addCntrforNewBkgInfo(cntrVoList, account);
					}
				}
				
				if(dgVoList.size()>0){
					if("Y".equals(bkgTerminalEdiJapanBlVO.getDcgoFlg())){				
						chk_seq = dbDao.searchDgCgoforNewBkgSeq(bkgTerminalEdiJapanBlVO);
						if(chk_seq.equals("")){
							dbDao.addDgCgoforNewBkgInfo(dgVoList, account);
						}else{
							dbDao.addDgCgoforNewBkgInfoMax(dgVoList, max_seq);
							dbDao.deleteDgCgoforNewBkgInfo(dgVoList);
							dbDao.addDgCgoforNewBkgInfo(dgVoList, account);
						}
					}
				}

				if(awkVoList.size()>0){
					if("Y".equals(bkgTerminalEdiJapanBlVO.getAwkCgoFlg())){
						
						chk_seq = dbDao.searchAwkCgoforNewBkgSeq(bkgTerminalEdiJapanBlVO);
						if(chk_seq.equals("")){
							dbDao.addAwkCgoforNewBkgInfo(awkVoList, account);
						}else{
							dbDao.addAwkCgoforNewBkgInfoMax(awkVoList, max_seq);
							dbDao.deleteAwkCgoforNewBkgInfo(awkVoList);
							dbDao.addAwkCgoforNewBkgInfo(awkVoList, account);
						}
					}	
				}

				if(rfVoList.size()>0){
					if("Y".equals(bkgTerminalEdiJapanBlVO.getRdCgoFlg())){
						chk_seq = dbDao.searchRfCgoforNewBkgSeq(bkgTerminalEdiJapanBlVO);
						if(chk_seq.equals("")){
							dbDao.addRfCgoforNewBkgInfo(rfVoList, account);
						}else{
							dbDao.addRfCgoforNewBkgInfoMax(rfVoList, max_seq);
							dbDao.deleteRfCgoforNewBkgInfo(rfVoList);
							dbDao.addRfCgoforNewBkgInfo(rfVoList, account);
						}
					}
				}
				
			}	

log.debug("======ock1 chk_flg="+chk_flg);
			
			//변경여부 체크 Y,N
			if("R".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())){
				chk_flg="Y";
			}else if(!"D".equals(del_flg) && !"V".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())){
				chk_flg="Y";
				//삭제 전송 시에 한번만 나가고 다음 부터는 비교로직을 타지 않게 한다.
			}else if(( bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd().equals("D") && bkgTerminalEdiJapanBlVO.getRStsCnt().equals("1")) ){ 
				chk_flg="Y";
			}else{
				if("D".equals(del_flg)){
					chk_flg="N";
				}else{
				chk_flg = dbDao.searchCheckColumns(bkgTerminalEdiJapanBlVO);
log.debug("======ock chk_flg="+chk_flg);
				}
			}
			return chk_flg;
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	
	/**
 * addNewBkgInfo<br>
 * 
 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
 * @param JapanTerminalEdiGroupVO japanTerminalEdiGroupVO
 * @param SignOnUserAccount account
 * @return String
 * @exception EventException
 */
public String addNewBkgInfoVvdChk(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, JapanTerminalEdiGroupVO japanTerminalEdiGroupVO, SignOnUserAccount account) throws EventException{
	try {
		String chk_flg = "Y";
		String max_seq = "";
		String chk_seq = "";
		String del_flg = "";
		
		List<BkgTerminalEdiJapanCntrVO> cntrVoList = new ArrayList<BkgTerminalEdiJapanCntrVO>();
		List<BkgTerminalEdiJapanDgCgoVO> dgVoList = new ArrayList<BkgTerminalEdiJapanDgCgoVO>();
		List<BkgTerminalEdiJapanAwkCgoVO> awkVoList = new ArrayList<BkgTerminalEdiJapanAwkCgoVO>();
		List<BkgTerminalEdiJapanRfCgoVO> rfVoList = new ArrayList<BkgTerminalEdiJapanRfCgoVO>();

		//BL
		if(bkgTerminalEdiJapanBlVO != null){
			//Max 값 체크
			max_seq = dbDao.searchNewBkgSeq(bkgTerminalEdiJapanBlVO);
			del_flg = dbDao.searchCntrforNewBkgDelFlg(bkgTerminalEdiJapanBlVO);

			if(max_seq.equals("")){
				dbDao.addNewBkgInfo(bkgTerminalEdiJapanBlVO, account);
			}else{
				bkgTerminalEdiJapanBlVO.setSnaccsTmlEdiStsCd("D");
				dbDao.addNewBkgInfoMax(bkgTerminalEdiJapanBlVO);
				dbDao.updateNewBkgInfoVvdChk(bkgTerminalEdiJapanBlVO, account);
			}
		}

		if(japanTerminalEdiGroupVO != null){

			cntrVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanCntrVOs();
			dgVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanDgCgoVOs();
			awkVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanAwkCgoVOs();
			rfVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanRfCgoVOs();

			if(cntrVoList.size()>0){
				chk_seq = dbDao.searchCntrforNewBkgSeq(bkgTerminalEdiJapanBlVO);
				if(chk_seq.equals("")){
					dbDao.addCntrforNewBkgInfo(cntrVoList, account);
				}else{
					dbDao.addCntrforNewBkgInfoMax(cntrVoList, max_seq);
					dbDao.deleteCntrforNewBkgInfo(cntrVoList);
					dbDao.addCntrforNewBkgInfo(cntrVoList, account);
				}
			}
			
			if(dgVoList.size()>0){
				if("Y".equals(bkgTerminalEdiJapanBlVO.getDcgoFlg())){				
					chk_seq = dbDao.searchDgCgoforNewBkgSeq(bkgTerminalEdiJapanBlVO);
					if(chk_seq.equals("")){
						dbDao.addDgCgoforNewBkgInfo(dgVoList, account);
					}else{
						dbDao.addDgCgoforNewBkgInfoMax(dgVoList, max_seq);
						dbDao.deleteDgCgoforNewBkgInfo(dgVoList);
						dbDao.addDgCgoforNewBkgInfo(dgVoList, account);
					}
				}
			}

			if(awkVoList.size()>0){
				if("Y".equals(bkgTerminalEdiJapanBlVO.getAwkCgoFlg())){
					
					chk_seq = dbDao.searchAwkCgoforNewBkgSeq(bkgTerminalEdiJapanBlVO);
					if(chk_seq.equals("")){
						dbDao.addAwkCgoforNewBkgInfo(awkVoList, account);
					}else{
						dbDao.addAwkCgoforNewBkgInfoMax(awkVoList, max_seq);
						dbDao.deleteAwkCgoforNewBkgInfo(awkVoList);
						dbDao.addAwkCgoforNewBkgInfo(awkVoList, account);
					}
				}	
			}

			if(rfVoList.size()>0){
				if("Y".equals(bkgTerminalEdiJapanBlVO.getRdCgoFlg())){
					chk_seq = dbDao.searchRfCgoforNewBkgSeq(bkgTerminalEdiJapanBlVO);
					if(chk_seq.equals("")){
						dbDao.addRfCgoforNewBkgInfo(rfVoList, account);
					}else{
						dbDao.addRfCgoforNewBkgInfoMax(rfVoList, max_seq);
						dbDao.deleteRfCgoforNewBkgInfo(rfVoList);
						dbDao.addRfCgoforNewBkgInfo(rfVoList, account);
					}
				}
			}
			
		}	

log.debug("======ock1 chk_flg="+chk_flg);
		
		//변경여부 체크 Y,N
		if("R".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())){
			chk_flg="Y";
		}else if(!"D".equals(del_flg) && !"V".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())){
			chk_flg="Y";
			//삭제 전송 시에 한번만 나가고 다음 부터는 비교로직을 타지 않게 한다.
		}else if(( bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd().equals("D") && bkgTerminalEdiJapanBlVO.getRStsCnt().equals("1")) ){ 
			chk_flg="Y";
		}else{
			if("D".equals(del_flg)){
				chk_flg="N";
			}else{
			chk_flg = dbDao.searchCheckColumns(bkgTerminalEdiJapanBlVO);
log.debug("======ock chk_flg="+chk_flg);
			}
		}
		return chk_flg;
   } catch (Exception ex) {
		throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
	}
}
	
	/**
	 * managePartialBkgInfoForSchedule SAVE<br>
	 * @param BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void managePartialBkgInfoForSchedule(BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs, SignOnUserAccount account) throws EventException {

		try {
			List<BkgJapanTerminalEdiVO> updateVoList = new ArrayList<BkgJapanTerminalEdiVO>();

			for ( int i=0; i<bkgJapanTerminalEdiVOs .length; i++ ) {
				if ( bkgJapanTerminalEdiVOs[i].getIbflag().equals("U")){
					bkgJapanTerminalEdiVOs[i].setUpdUsrId(account.getUsr_id());
					bkgJapanTerminalEdiVOs[i].setEdiSndOfcCd(account.getOfc_cd());					
					updateVoList.add(bkgJapanTerminalEdiVOs[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.updatePartialBkgInfoForSchedule(updateVoList);
			}			

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * searchNewBkgInfo<br>
	 * 
	 * @param String bkgNo
	 * @return BkgTerminalEdiJapanBlVO
	 * @exception EventException
	 */
	public BkgTerminalEdiJapanBlVO searchNewBkgInfoForVvdChk(String bkgNo) throws EventException {
		try {
			return dbDao.searchNewBkgInfoForVvdChk(bkgNo);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
}
