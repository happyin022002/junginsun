/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AncsCustomsTransmissionBCImpl.java
 *@FileTitle : CustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.10
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.06.10 정재엽
 * 1.0 Creation
 *------------------------------------------------------
 * History
 * 1. 2011.01.11 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
 *    => Ancs FlatFile에 MRN 정보 추가
 * 2011.12.22 김경섭 [CHM-201115203]] [ESM-BKG] Manifest Transmit (CUSCAR) : B/L Inquiry(ESM_BKG_0045) 화면   전송 Flat File 생성시 C/M 정보 매핑 수정 - CM_PKG_CD: PKG_TP_CD >> CM_PKG_TP_CD로 수정
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation.AncsCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsFltFileCusrepVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestTransmitVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAnrBlLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrCntrLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrEdiHisVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrEdiMsgVO;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Min Jeong
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AncsCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient AncsCustomsTransmissionDBDAO dbDao = null;

	/**
	 * AncsCustomsTransmissionBCImpl 객체 생성<br>
	 * AncsCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public AncsCustomsTransmissionBCImpl() {
		dbDao = new AncsCustomsTransmissionDBDAO();
	}
	
	/**
	 * SendLog History
	 * 
	 * @param cstmsSndHisListCondVO
	 * @return List<CstmsSndHisVO>
	 * @throws EventException
	 */
	public List<CstmsSndHisVO> searchCstmsSndHisList(CstmsSndHisListCondVO cstmsSndHisListCondVO) throws EventException {
		try
		{
			return dbDao.searchAncsCstmsSndHisList((AncsCstmsSndHisListCondVO) cstmsSndHisListCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관으로 송수신한 메시지 상세 내역 조회
	 * 
	 * @param cstmsLogDtlCondVO
	 * @return 
	 * @throws EventException
	 */
	public List<CstmsLogDtlVO> searchCstmsLogDtl(CstmsLogDtlCondVO cstmsLogDtlCondVO ) throws EventException {
		try{
			return dbDao.searchAncsCstmsLogDtl((AncsCstmsLogDtlCondVO) cstmsLogDtlCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.
	 * 
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	@Override
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account)
			throws EventException {
		try
		{
			AncsVesselArrivalTransmitVO ancsVsArTranVO = (AncsVesselArrivalTransmitVO)vesselArrivalTransmitVO;
			
			/*
			 * Cancel 전송인 경우 CUSCAR 를 먼저 삭제해야 하므로 메시지를 보내야 하는 로직
			 * Replace 전송인 경우는 변경된 데이터가 있는 지 검색한다.
			 */
			boolean bRtn = false;
			if	( "C".equals( ancsVsArTranVO.getTransflag() ) ){
				bRtn = dbDao.checkIfAcptCuscarExist( ancsVsArTranVO.getVvd().substring(0,4)
						                    , ancsVsArTranVO.getVvd().substring(4,8)
						                    , ancsVsArTranVO.getVvd().substring(8,9) );
				
				if ( bRtn == true )
					throw new EventException( new ErrorHandler("BKG06043" ).getMessage() );
			} 
			
			String sFlatFile = makeCstmsFlatFileCusrep( ancsVsArTranVO.getVvd().substring(0,4)
					                                  , ancsVsArTranVO.getVvd().substring(4,8)
					                                  , ancsVsArTranVO.getVvd().substring(8,9) 
					                                  , ancsVsArTranVO.getTransflag()
					                                  , ancsVsArTranVO.getPod()
					                                  , account);
		
			return sFlatFile;
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 입항 관련 플랫 파일 만들기
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String transFlag
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	private String makeCstmsFlatFileCusrep(String vslCd, String skdVoyNo, String skdDirCd, String transFlag, String pod,SignOnUserAccount account) throws EventException {
		try
		{
			StringBuffer flatFile = new StringBuffer();
			HashMap<String, String> chgListMap = new HashMap<String, String>();
			boolean bBEGIN_PORT = false; 
			boolean bDISCHARGE_IND = false; 
			boolean bBERTH = false; 
			boolean bVESSELNAME = false; 
			boolean bBEGINVESSELFLAG = false; 
			boolean bETA = false; 
			
			//transFlag 를 코드로 변환시켜서 조회 해온다.
			String sTransFlag = "";
			if( "O".equals(transFlag) )
				sTransFlag = "9";
			else if( "R".equals(transFlag) )
				sTransFlag = "5";
			else if( "C".equals(transFlag) )
				sTransFlag = "1";
				
			List<AncsCstmsFltFileCusrepVO> rtnVOs = dbDao.searchAncsCstmsFltFileCusrep(vslCd, skdVoyNo, skdDirCd, sTransFlag);  
			
			/*
			 * Transmission Flag 가 Replace 일때 [시작]
			 * 1. 변환된 데이터가 없을때는 업데이트 하지 않고 예외 처리를 한다.
			 * 2. 변환된 데이터가 있을때는 바뀐 데이터 만 추출하여 전송을 한다.
			 */
			if ( rtnVOs.size() > 0 )
			{
				AncsCstmsFltFileCusrepVO rtnVO = rtnVOs.get(0);
				if( "R".equals( transFlag ) ) {
					List<AncsCstmsManifestVO> list = dbDao.searchAncsCusrepCngList(vslCd, skdVoyNo, skdDirCd, rtnVO.getGdNumber() + rtnVO.getLloydCode());
					for (Iterator<AncsCstmsManifestVO> iterator = list.iterator(); iterator.hasNext();) {
						AncsCstmsManifestVO ancsCstmsManifestVO = iterator.next();
						String sItemDesc = ancsCstmsManifestVO.getItemDesc();
						String sCngFlg   = ancsCstmsManifestVO.getCngFlg();
						if( "Y".equals(sCngFlg)  ){
							chgListMap.put(sItemDesc, sCngFlg);
							
							if( "BEGIN_PORT:".equals(sItemDesc) )
								bBEGIN_PORT = true;
							if( "DISCHARGE_IND:".equals(sItemDesc) )
								bDISCHARGE_IND = true;
							if( "BERTH:".equals(sItemDesc) )
								bBERTH = true;
							if( "VESSELNAME:".equals(sItemDesc) )
								bVESSELNAME = true;
							if( "VESSELFLAG:".equals(sItemDesc) )
								bBEGINVESSELFLAG = true;
							if( "ETA:".equals(sItemDesc) )
								bETA = true;
						}
					}
					if ( chgListMap.size() == 0 ){
						throw new EventException(new ErrorHandler("BKG06044").getMessage());
					}
				} else {
					bBEGIN_PORT    = true; 
					bDISCHARGE_IND = true; 
					bBERTH         = true; 
					bVESSELNAME    = true; 
					bBEGINVESSELFLAG = true; 
					bETA           = true; 
				}
			
			/*
			 * Transmission Flag 가 Replace 일때 [끝]
			 */
			

				
				BookingUtil command = new BookingUtil();
				String receiverId = "DOUANE";
				if("BEZEE".equalsIgnoreCase(pod)) {
					receiverId = "DOUZEE";
				}
				
				String sEdiHeader = command.searchCstmsEdiHeader("HANSHI", receiverId, "CUSREP");
								
				flatFile.append( sEdiHeader ).append("\n")
				        //.append("VVD:").append( rtnVO.getVvd() ).append("\n")
				        .append("GD_NUMBER:") .append( rtnVO.getGdNumber() ) .append("\n")
						.append("LLOYDCODE:") .append( rtnVO.getLloydCode() ).append("\n")                       
						.append("SEQUENCE:")  .append( rtnVO.getSeq() )      .append("\n")
						.append("UPDATE_IND:").append( rtnVO.getUpdateInd() ).append("\n")
						.append("PREV_DOCNO:").append( switchNum( String.valueOf(  rtnVO.getPrevDocno() ), "6" ) ).append("\n");
						
						if( bBEGIN_PORT == true ){
				flatFile.append("{LOC005")       .append("\n")
						.append("BEGIN_PORT:")   .append( rtnVO.getBeginPort() )   .append("\n")
						.append("}LOC005")       .append("\n");                   
						}
						
						if( bDISCHARGE_IND == true || bBERTH == true ){
				flatFile.append("{LOC060")       .append("\n");                
							
							if( bDISCHARGE_IND == true )
				flatFile.append("DISCHARGE_IND:").append( rtnVO.getDischargeInd() ).append("\n");
				
							if( bBERTH == true )
				flatFile.append("BERTH:")        .append( rtnVO.getBerth() )       .append("\n");           
				
				flatFile.append("}LOC060")       .append("\n");                   
						}
						
				flatFile.append("{TDT")          .append("\n")                     
				        .append("VVD:")          .append( rtnVO.getVvd() )         .append("\n");             
						if( bVESSELNAME == true )
				flatFile.append("VESSELNAME:")   .append( rtnVO.getVesselname() )  .append("\n");      
						if( bBEGINVESSELFLAG == true )
				flatFile.append("VESSELFLAG:")   .append( rtnVO.getVesselflag() )  .append("\n");      
						
						if( bETA == true ){
				flatFile.append("{DTM132")       .append("\n");
				flatFile.append("ETA:")          .append( rtnVO.getEta() )         .append("\n");             
				flatFile.append("}DTM132")       .append("\n");                   
						}
				flatFile.append("}TDT");
				
				if(log.isDebugEnabled()){
					log.debug( "***** [Flat Content] *****\n" );
					log.debug( flatFile.toString() );
					log.debug( "\n" );
					log.debug( "\n" );
					log.debug( "\n" );
				}
				
				/*
				 * EDI 연동.
				 */
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_ANRCSRP.IBMMQ.QUEUE"));
				
				FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
				flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
				
				if ( flatFileAckVO.getAckStsCd().equals("E") )
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());			
				
				/*
				 * EDI 이력 테이블에 저장 [ start ]
				 */
				List<BkgCstmsAnrEdiHisVO> bkgCstmsAnrEdiHisVOs = new ArrayList<BkgCstmsAnrEdiHisVO>();
				BkgCstmsAnrEdiHisVO   bkgCstmsAnrEdiHisVO  = new BkgCstmsAnrEdiHisVO();
				List<BkgCstmsAnrEdiMsgVO> bkgCstmsAnrEdiMsgVOs = new ArrayList<BkgCstmsAnrEdiMsgVO>();
				
				
				bkgCstmsAnrEdiHisVO.setMsgTpCd( "R" ); //CUSREP : R
				bkgCstmsAnrEdiHisVO.setAnrDeclNo( rtnVO.getGdNumber() + rtnVO.getLloydCode() );
				bkgCstmsAnrEdiHisVO.setRefSeq( rtnVO.getSeq() );
				bkgCstmsAnrEdiHisVO.setVslCd(vslCd);
				bkgCstmsAnrEdiHisVO.setSkdVoyNo(skdVoyNo);
				bkgCstmsAnrEdiHisVO.setSkdDirCd(skdDirCd);
				bkgCstmsAnrEdiHisVO.setEdiSndStsCd( transFlag ); 
				bkgCstmsAnrEdiHisVO.setEdiSndUsrId( account.getUsr_id() ); 
				bkgCstmsAnrEdiHisVO.setSndOfcCd(account.getOfc_cd());
				bkgCstmsAnrEdiHisVO.setCreUsrId(account.getUsr_id());
				bkgCstmsAnrEdiHisVO.setUpdUsrId(account.getUsr_id());
				
				bkgCstmsAnrEdiHisVOs.add( bkgCstmsAnrEdiHisVO );
				
				String[] sFlatLineArry = flatFile.toString().split("\n");
				String sMsgSeq = rtnVO.getMsgSeq();
				int iMsgSeq = Integer.parseInt(sMsgSeq);
				for (int i = 0; i < sFlatLineArry.length; i++) {
					
					BkgCstmsAnrEdiMsgVO bkgCstmsAnrEdiMsgVO = new BkgCstmsAnrEdiMsgVO();
					bkgCstmsAnrEdiMsgVO.setMsgTpCd  ( "R" );
					bkgCstmsAnrEdiMsgVO.setRcvSndDivCd("S");
					bkgCstmsAnrEdiMsgVO.setAnrDeclNo( rtnVO.getGdNumber() + rtnVO.getLloydCode() );
					bkgCstmsAnrEdiMsgVO.setRefSeq   ( rtnVO.getSeq() );
					bkgCstmsAnrEdiMsgVO.setMsgSeq( String.valueOf(iMsgSeq) );
					bkgCstmsAnrEdiMsgVO.setEdiMsg   ( sFlatLineArry[i] );
					bkgCstmsAnrEdiMsgVO.setCreUsrId ( account.getUsr_id() );
					bkgCstmsAnrEdiMsgVO.setUpdUsrId ( account.getUsr_id() );
					bkgCstmsAnrEdiMsgVOs.add( bkgCstmsAnrEdiMsgVO ) ;
					iMsgSeq ++;
				}
				List<List<BkgCstmsAnrEdiMsgVO>> list = new ArrayList<List<BkgCstmsAnrEdiMsgVO>>();
				list.add(bkgCstmsAnrEdiMsgVOs);
				AncsCstmsManifestVO ancsCstmsManifestVO = new AncsCstmsManifestVO();
				ancsCstmsManifestVO.setBkgCstmsAnrEdiHisVOs(bkgCstmsAnrEdiHisVOs);
				ancsCstmsManifestVO.setBkgCstmsAnrEdiMsgVOss(list);
				
				writeCstmsManifestSendLog( ancsCstmsManifestVO, account, "R" );
			}  else {
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage());
			}
			/*
			 * EDI 이력 테이블에 저장 [ end ]
			 */
			        
			return flatFile.toString();
		}  catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} 
	}
	
	/**
	 * 입력된 숫자를 원하는 크기만큼 앞자리에 "0" 을 채워서 반환하는 메서드.
	 * 
	 * @param String sSource
	 * @param String sLength
	 * @return String
	 * @throws EventException
	 */
	private String switchNum( String sSource, String sLength ) throws EventException {
		
		int iSrcLth = sSource.length() ;
		int iLth    = Integer.parseInt( sLength );
		
		int iDefict = iLth - iSrcLth ;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < iDefict; i++) {
			buffer.append("0");
		}
		buffer.append( sSource );
		
		return buffer.toString();
	}
	
	
	/**
	 * CUSCAR FLATFILE 을 만드는 메서드.
	 * 
	 * @param manifestTransmitVOs
	 * @param account
	 * @return
	 * @throws EventException
	 */
	private ArrayList<String> makeAncsCstmsManifestFlatFile( ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account)
	throws EventException {

		
		ArrayList<String> listFlatFile = null;
		try{			
			/*
			 * BL, CNTR, CMDT 별로 데이터를 구분 한다.
			 */
			if( manifestTransmitVOs != null ){ 
				if( manifestTransmitVOs.length  > 0  ){
					
					String sBlNo   = "first";
					String sCntrNo = "first";
					String sCntrSeq = "first";
					int iCmSeq = 1 ;
					listFlatFile = new ArrayList<String>();
					ArrayList<HashMap<String, String>> listBl = new ArrayList<HashMap<String, String>>();
					ArrayList<HashMap<String, String>> listCntr = new ArrayList<HashMap<String, String>>();
					ArrayList<HashMap<String, String>> listCmdt = new ArrayList<HashMap<String, String>>();
					
					HashMap<String, String> hmCommonInfo = null;
					HashMap<String, String> hmBl = null;
					HashMap<String, String> hmCntr = null;
					HashMap<String, String> hmCmdt = null;
					
					String sNextBlNo = "";
					//String sFlatType = "";
					String sVvd = "";
					String sStatus = "";
					String sLloydCd = "";
					String sSsRefNo = "";
					//String sSequence = "";
					//String sPrevDocno = "";
					AncsManifestTransmitVO ancsCstmsManifestVOTemp = (AncsManifestTransmitVO)manifestTransmitVOs[0];
					int iCommonSeq = Integer.parseInt( ancsCstmsManifestVOTemp.getSequence() );
					
					for (int i = 0; i < manifestTransmitVOs.length; i++) {
						AncsManifestTransmitVO ancsCstmsManifestVO = (AncsManifestTransmitVO)manifestTransmitVOs[i];
						
						String sKind = ancsCstmsManifestVO.getKind();
						if( "O".equals(sKind) )
							sKind = "9";
						else if( "T".equals(sKind) )
							sKind = "5";
						else if( "C".equals(sKind) )
							sKind = "3";
						
						//sFlatType = ancsCstmsManifestVO.getFlatType();
						sVvd     = ancsCstmsManifestVO.getVvd();
						sStatus  = sKind;
						sLloydCd = ancsCstmsManifestVO.getLloydCd();
						sSsRefNo = ancsCstmsManifestVO.getSvcRqstNo();
						//sSequence  = ancsCstmsManifestVO.getSequence();
						//sPrevDocno = ancsCstmsManifestVO.getPrevDocno();
						
						hmCommonInfo = new HashMap<String, String>();
						hmCommonInfo.put("vvd", sVvd);
						hmCommonInfo.put("status", sStatus);
						hmCommonInfo.put("lloyd_cd", sLloydCd);
						hmCommonInfo.put("ss_ref_no", sSsRefNo);
						hmCommonInfo.put("sequence", switchNum( String.valueOf( iCommonSeq ), "6" ) );
						hmCommonInfo.put("prev_docno", switchNum(String.valueOf(  iCommonSeq-1 ), "6" ));
										
						String sCneeAddr = ancsCstmsManifestVO.getCneeAddr().replaceAll("\r\n", " ");
						String sShprAddr = ancsCstmsManifestVO.getShprAddr().replaceAll("\r\n", " ");
						String sNtfyAddr = ancsCstmsManifestVO.getNtfyAddr().replaceAll("\r\n", " ");
						String sNtfyName = ancsCstmsManifestVO.getNtfyName().replaceAll("\r\n", " ");
						
						/*if ( ancsCstmsManifestVOTemp.getFlatType().equals("0063"))
						{
							if( "1".equals(ancsCstmsManifestVO.getS1()) && ! sBlNo.equals(ancsCstmsManifestVO.getBlNo()) ){
								
								//iCommonSeq ++ ;
								
								sBlNo = ancsCstmsManifestVO.getBlNo();
								hmBl = new HashMap<String, String>();
								
								hmBl.put("wgt",       ancsCstmsManifestVO.getActWgt()                );
								hmBl.put("wgt_u",     ancsCstmsManifestVO.getWgtUtCd()               );
								hmBl.put("art_no",    ancsCstmsManifestVO.getVvdSeq()                );
								hmBl.put("bl_no",     ancsCstmsManifestVO.getBlNo()                  );
								hmBl.put("pkg",       ancsCstmsManifestVO.getPckQty()                );
								hmBl.put("pod",       ancsCstmsManifestVO.getPodCd()                 );
								hmBl.put("berth_cd",  ancsCstmsManifestVO.getBrthDesc()              );
								hmBl.put("pol",       ancsCstmsManifestVO.getPolCd()                 );
								hmBl.put("pre",       ancsCstmsManifestVO.getPreRlyPortCd()          );
								hmBl.put("post",      ancsCstmsManifestVO.getPstRlyPortCd()          );
								hmBl.put("por",       ancsCstmsManifestVO.getPorCd()                 );
								hmBl.put("del",       ancsCstmsManifestVO.getDelCd()                 );
								hmBl.put("shpr_name", sShprAddr.substring(0, sShprAddr.indexOf("@@")));
								hmBl.put("shpr_addr", sShprAddr.substring(sShprAddr.indexOf("@@")+2) );
								hmBl.put("cnee_name", sCneeAddr.substring(0, sCneeAddr.indexOf("@@")));
								hmBl.put("cnee_addr", sCneeAddr.substring(sCneeAddr.indexOf("@@")+2) );
								hmBl.put("ntfy_name", sNtfyName                                      );
								hmBl.put("ntfy_addr", sNtfyAddr                                      );
			
								listBl  .add(hmBl);
								
							}
						} else {*/
							if( "1".equals(ancsCstmsManifestVO.getS1()) && "1".equals(ancsCstmsManifestVO.getS3()) && ! sBlNo.equals(ancsCstmsManifestVO.getBlNo()) ){
					
							
								//iCommonSeq ++ ;
								
								sBlNo = ancsCstmsManifestVO.getBlNo();
								hmBl = new HashMap<String, String>();
								
								hmBl.put("wgt",       ancsCstmsManifestVO.getActWgt()                );
								hmBl.put("wgt_u",     ancsCstmsManifestVO.getWgtUtCd()               );
								hmBl.put("art_no",    ancsCstmsManifestVO.getVvdSeq()                );
								hmBl.put("bl_no",     ancsCstmsManifestVO.getBlNo()                  );
								
								hmBl.put("mrn_no",    ancsCstmsManifestVO.getMrnNo()                 );
								
								hmBl.put("pkg",       ancsCstmsManifestVO.getPckQty()                );
								hmBl.put("pod",       ancsCstmsManifestVO.getPodCd()                 );
								hmBl.put("berth_cd",  ancsCstmsManifestVO.getBrthDesc()              );
								hmBl.put("pol",       ancsCstmsManifestVO.getPolCd()                 );
								hmBl.put("pre",       ancsCstmsManifestVO.getPreRlyPortCd()          );
								hmBl.put("post",      ancsCstmsManifestVO.getPstRlyPortCd()          );
								hmBl.put("por",       ancsCstmsManifestVO.getPorCd()                 );
								hmBl.put("del",       ancsCstmsManifestVO.getDelCd()                 );
								hmBl.put("shpr_name", sShprAddr.substring(0, sShprAddr.indexOf("@@")));
								hmBl.put("shpr_addr", sShprAddr.substring(sShprAddr.indexOf("@@")+2) );
								hmBl.put("cnee_name", sCneeAddr.substring(0, sCneeAddr.indexOf("@@")));
								hmBl.put("cnee_addr", sCneeAddr.substring(sCneeAddr.indexOf("@@")+2) );
								hmBl.put("ntfy_name", sNtfyName                                      );
								hmBl.put("ntfy_addr", sNtfyAddr                                      );
			
								listBl  .add(hmBl);
								
							} else {
								sBlNo = ancsCstmsManifestVO.getBlNo();
							}
						//}
						
						if( "1".equals(ancsCstmsManifestVO.getS2()) && !sCntrNo.equals(ancsCstmsManifestVO.getCntrNo()) ){
							sCntrNo = ancsCstmsManifestVO.getCntrNo();
							hmCntr  = new HashMap<String, String>();
							
							hmCntr.put("cntr_no" , ancsCstmsManifestVO.getCntrNo()    );      
							hmCntr.put("cntr_ts" , ancsCstmsManifestVO.getCntrTpszCd());      
							hmCntr.put("cntr_fm" , ancsCstmsManifestVO.getCntrFm()    );     
							hmCntr.put("cntr_wgt", ancsCstmsManifestVO.getCntrWgtQty() );
							hmCntr.put("rd_term" , ancsCstmsManifestVO.getRdTerm()    );
							
							listCntr.add(hmCntr);
							
						}
						
						//sCntrSeq = ancsCstmsManifestVO.getCntrNo() + ancsCstmsManifestVO.getCntrSeq();
						
						
						if( "1".equals(ancsCstmsManifestVO.getS3()) && !sCntrSeq.equals( ancsCstmsManifestVO.getCntrNo() + ancsCstmsManifestVO.getCntrSeq() ) ){
							
							sCntrSeq = ancsCstmsManifestVO.getCntrNo() + ancsCstmsManifestVO.getCntrSeq();
							hmCmdt  = new HashMap<String, String>();
							
							//hmCmdt.put("cm_seq"    , ancsCstmsManifestVO.getCntrSeq()   );
							hmCmdt.put("cm_seq"    , String.valueOf( switchNum( String.valueOf( iCmSeq ), "4" ) )   );
							hmCmdt.put("cm_pkg_no" , ancsCstmsManifestVO.getCmPckQty()  );
							hmCmdt.put("cm_pkg_cd" , ancsCstmsManifestVO.getCmPckTpCd() );
							hmCmdt.put("cm_desc"   , ancsCstmsManifestVO.getCntrMfDesc());
							hmCmdt.put("cm_wgt"    , ancsCstmsManifestVO.getCntrMfWgt() );
							hmCmdt.put("cm_wgt_u"  , ancsCstmsManifestVO.getWgtUtCd()   );
							hmCmdt.put("cm_cntr_no", ancsCstmsManifestVO.getCmCntrNo()  );
							hmCmdt.put("t1_ind"    , ancsCstmsManifestVO.getDeclFlg()   );
							
							listCmdt.add(hmCmdt);
							
							iCmSeq ++ ;
						}
						
						// 다음 데이터의 BLNO 가 다르면 현재까지 저장된 데이터로 플랫파일을 생성한다.
						
						if ( i+1 < manifestTransmitVOs.length){
							AncsManifestTransmitVO ancsManifestTransmitVO = (AncsManifestTransmitVO)manifestTransmitVOs[i+1];
							sNextBlNo = ancsManifestTransmitVO.getBlNo();
						} else if( i+1 == manifestTransmitVOs.length ) {
							sNextBlNo = "end";
						}
					    
						/*
						 * 여러개의 BL 이 들어왔을때 첫번째 BL 에 대한 데이터를 다모은 다음
						 * 아래의 조건문을 시행하도록 하기위해 다음 BL 넘버를 비교한다.
						 */
						if( ! sBlNo.equals(sNextBlNo) ){
							
							/*
							 * 0045 의 플랫파일
							 * -> {BLINFO}{CMDT_1}...{CMDT_N}{CNTR_1}...{CNTR_N}
							 * -> 한개의 플랫파일이 만들어져 함
							 * 
							 * 0063 의 플랫파일
							 * -> {BLINFO_1}{CMDT_1}...{CMDT_N}, {CNTR_1}, {CNTR_2}, ..., {CNTR_N}
							 * -> {BLINFO_2}{CMDT_1}...{CMDT_N}, {CNTR_1}, {CNTR_2}, ..., {CNTR_N}
							 * 
							 * -> 여러개의 플랫파일이 만들어져야함
							 */
	//						if( "0045".equals(sFlatType) ){
								
								listFlatFile.add( makeFlatFileForCuscar(hmCommonInfo, listBl, listCmdt, listCntr ) );
								//hmCommonInfo = new HashMap<String, String>();
								listBl = new ArrayList<HashMap<String, String>>();
								listCmdt = new ArrayList<HashMap<String, String>>();
								listCntr = new ArrayList<HashMap<String, String>>();
								iCommonSeq++;
								iCmSeq = 1;
								
	/*						}else if( "0063".equals(sFlatType) ){
								listFlatFile.add( makeFlatFileForCuscar(hmCommonInfo, listBl, listCmdt, null ) );
								
								for (Iterator<HashMap<String, String>> iterator = listCntr.iterator(); iterator.hasNext();) {
									HashMap<String, String> hmTemp = iterator.next();
									
									List<HashMap<String, String>> listTemp = new ArrayList<HashMap<String,String>>();
									listTemp.add(hmTemp);
									
									listFlatFile.add( makeFlatFileForCuscar(hmCommonInfo, null, null, listTemp ) );
								}
								
								listBl.clear();
								listCmdt.clear();
								listCntr.clear();
								
								iCmSeq = 1;
							}
	*/	
						}
						
						
					}//for end.
					
				}	
			}	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}	
		return listFlatFile;
	}
	
	/**
	 * CusCar 플랫파일을 만드는 메서드.
	 * 
	 * @param HashMap<String, String> hmCommonInfo
	 * @param List<HashMap<String, String>> listBl
	 * @param List<HashMap<String, String>> listCmdt
	 * @param List<HashMap<String, String>> listCntr
	 * @return
	 * @throws EventException
	 */
	private String makeFlatFileForCuscar( HashMap<String, String> hmCommonInfo,  List<HashMap<String, String>> listBl, List<HashMap<String, String>> listCmdt, List<HashMap<String, String>> listCntr  ) throws EventException{
		
		StringBuffer strBufFlat = new StringBuffer();
		
		BookingUtil command = new BookingUtil();
		String receiverId = "DOUANE";
		
		if(listBl != null && listBl.size() > 0 && listBl.get(0) != null ) {
			if("BEZEE".equalsIgnoreCase(listBl.get(0).get("pod"))) {
				receiverId = "DOUZEE";
			} 
		}
		
		String sEdiHeader = command.searchCstmsEdiHeader("HANSHI", receiverId, "CUSCAR");
		strBufFlat.append( sEdiHeader ).append("\n")
				.append("VVD:").append( hmCommonInfo.get("vvd") ).append("\n")
		        .append("STATUS:").append( hmCommonInfo.get("status") ).append("\n")
		        .append("LLOYD_CD:").append( hmCommonInfo.get("lloyd_cd") ).append("\n")
		        .append("SS_REF_NO:").append( hmCommonInfo.get("ss_ref_no") ).append("\n")
		        .append("SEQUENCE:").append( hmCommonInfo.get("sequence") ).append("\n")
		        .append("PREV_DOCNO:").append( hmCommonInfo.get("prev_docno") ).append("\n"); 
		
		if( listBl != null ){ 
		
			for (Iterator<HashMap<String, String>> iterator = listBl.iterator(); iterator.hasNext();) {
				HashMap<String, String> hmBlTemp = (HashMap<String, String>) iterator
						.next();
				
				strBufFlat.append("{BL_INFO").append("\n")
				        .append("WGT:")      .append( hmBlTemp.get("wgt")       ).append("\n")
						.append("WGT_U:")    .append( hmBlTemp.get("wgt_u")     ).append("\n")
						.append("ART_NO:")   .append( hmBlTemp.get("art_no")    ).append("\n")
						.append("BL_NO:")    .append( hmBlTemp.get("bl_no")     ).append("\n")
						
						.append("MRN:")      .append( hmBlTemp.get("mrn_no")    ).append("\n")
						
						.append("PKG:")      .append( hmBlTemp.get("pkg")       ).append("\n")
						.append("POD:")      .append( hmBlTemp.get("pod")       ).append("\n")
						.append("BERTH_CD:") .append( hmBlTemp.get("berth_cd")  ).append("\n")
						.append("POL:")      .append( hmBlTemp.get("pol")       ).append("\n")
						.append("PRE:")      .append( hmBlTemp.get("pre")       ).append("\n")
						.append("POST:")     .append( hmBlTemp.get("post")      ).append("\n")
						.append("POR:")      .append( hmBlTemp.get("por")       ).append("\n")
						.append("DEL:")      .append( hmBlTemp.get("del")       ).append("\n")
						.append("SHPR_NAME:").append( hmBlTemp.get("shpr_name") ).append("\n")
						.append("SHPR_ADDR:").append( hmBlTemp.get("shpr_addr") ).append("\n")
						.append("CNEE_NAME:").append( hmBlTemp.get("cnee_name") ).append("\n")
						.append("CNEE_ADDR:").append( hmBlTemp.get("cnee_addr") ).append("\n")
						.append("NTFY_NAME:").append( hmBlTemp.get("ntfy_name") ).append("\n")
						.append("NTFY_ADDR:").append( hmBlTemp.get("ntfy_addr") ).append("\n")
				        .append("}BL_INFO").append("\n");
				
			}
		}	
		
		if( listCmdt != null ){ 
		
			for (Iterator<HashMap<String, String>> iterator = listCmdt.iterator(); iterator.hasNext();) {
				HashMap<String, String> hmCmdtTemp = (HashMap<String, String>) iterator
						.next();
				
				strBufFlat.append("{CM_INFO").append("\n")
				        .append("CM_SEQ:")    .append( hmCmdtTemp.get("cm_seq")     ).append("\n")
						.append("CM_PKG_NO:") .append( hmCmdtTemp.get("cm_pkg_no")  ).append("\n")
						.append("CM_PKG_CD:") .append( hmCmdtTemp.get("cm_pkg_cd")  ).append("\n")
						.append("CM_DESC:")   .append( hmCmdtTemp.get("cm_desc")    ).append("\n")
						.append("CM_WGT:")    .append( hmCmdtTemp.get("cm_wgt")     ).append("\n")
						.append("CM_WGT_U:")  .append( hmCmdtTemp.get("cm_wgt_u")   ).append("\n")
						.append("CM_CNTR_NO:").append( hmCmdtTemp.get("cm_cntr_no") ).append("\n")
						.append("T1_IND:")    .append( hmCmdtTemp.get("t1_ind")     ).append("\n")
				        .append("}CM_INFO").append("\n");
			}
		}
		
		if( listCntr != null ){ 
		
			for (Iterator<HashMap<String, String>> iterator = listCntr.iterator(); iterator.hasNext();) {
				HashMap<String, String> hmCntrTemp = (HashMap<String, String>) iterator
						.next();
				
				strBufFlat.append("{CNTR_INFO").append("\n")         
				        .append("CNTR_NO:") .append( hmCntrTemp.get("cntr_no")  ).append("\n")
						.append("CNTR_TS:") .append( hmCntrTemp.get("cntr_ts")  ).append("\n")
						.append("CNTR_FM:") .append( hmCntrTemp.get("cntr_fm")  ).append("\n")
						.append("CNTR_WGT:").append( hmCntrTemp.get("cntr_wgt") ).append("\n")
						.append("RD_TERM:") .append( hmCntrTemp.get("rd_term")  ).append("\n")         
				        .append("}CNTR_INFO").append("\n");  
			
			}	
		}	
		
		return strBufFlat.toString();
	}
	
	/**
	 * ANCS 세관에 적하목록 신고를 EDI를 통해 전송한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	@Override
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account)
			throws EventException {
		String sFlatFile = "";
		try{
			
			if( manifestTransmitVOs != null ){
			
				ArrayList<String> listFlatFile = makeAncsCstmsManifestFlatFile( manifestTransmitVOs, account );
				
				/*
				 * EDI 연동.
				 */
				for (Iterator<String> iterator = listFlatFile.iterator(); iterator
						.hasNext();) {
					String sFlatFileTemp = iterator.next();
					
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile( sFlatFileTemp );
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_ANRCSCR.IBMMQ.QUEUE"));
					BookingUtil command = new BookingUtil();
					FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
					flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
					
					if ( flatFileAckVO.getAckStsCd().equals("E") )
						throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
				}
				
				/*
				 * 로그 
				 */
				if( manifestTransmitVOs.length  > 0  ){
					List<BkgCstmsAnrEdiHisVO> bkgCstmsAnrEdiHisVOs = new ArrayList<BkgCstmsAnrEdiHisVO>();
					
					List<List<BkgCstmsAnrEdiMsgVO>> bkgCstmsAnrEdiMsgVOs2 = new ArrayList<List<BkgCstmsAnrEdiMsgVO>>();
					List<BkgCstmsAnrBlLogVO>  bkgCstmsAnrBlLogVOs  = new ArrayList<BkgCstmsAnrBlLogVO>();
					List<BkgCstmsAnrCntrLogVO>  bkgCstmsCntrLogVOs  = new ArrayList<BkgCstmsAnrCntrLogVO>();
					
					AncsManifestTransmitVO ancsManifestTransmitVO = (AncsManifestTransmitVO)manifestTransmitVOs[0];
				
					String sRefSeq = ancsManifestTransmitVO.getSequence();
					int iRefSeq1 = Integer.parseInt(sRefSeq)-1;
					
					/*
					 * 생성된 플랫파일 모두를 저장하기 위해서 데이터 셋에 모든 메시를 담는다.
					 */
					int iRefSeq2 = Integer.parseInt(sRefSeq);
					for (Iterator<String> iterator2 = listFlatFile.iterator(); iterator2.hasNext();) {
							
						String sFlatFile2 =  iterator2.next();
						String[] sFlatLineArry = sFlatFile2.toString().split("\n");
						int iMsgSeq = 1;
						List<BkgCstmsAnrEdiMsgVO> bkgCstmsAnrEdiMsgVOs = new ArrayList<BkgCstmsAnrEdiMsgVO>();
						for (int i = 0; i < sFlatLineArry.length; i++) {
							
							BkgCstmsAnrEdiMsgVO bkgCstmsAnrEdiMsgVO = new BkgCstmsAnrEdiMsgVO();
							bkgCstmsAnrEdiMsgVO.setMsgTpCd  ( ( ancsManifestTransmitVO.getMsgTpCd() == null || ancsManifestTransmitVO.getMsgTpCd().equals("") ) ? " " : ancsManifestTransmitVO.getMsgTpCd() );
							bkgCstmsAnrEdiMsgVO.setRcvSndDivCd("S");
							bkgCstmsAnrEdiMsgVO.setAnrDeclNo( ancsManifestTransmitVO.getAnrDeclNo() );
							bkgCstmsAnrEdiMsgVO.setRefSeq   ( String.valueOf(iRefSeq2) );
							bkgCstmsAnrEdiMsgVO.setMsgSeq   ( String.valueOf(iMsgSeq) );
							
							bkgCstmsAnrEdiMsgVO.setEdiMsg   ( sFlatLineArry[i] );
							bkgCstmsAnrEdiMsgVO.setCreUsrId ( account.getUsr_id() );
							bkgCstmsAnrEdiMsgVO.setUpdUsrId ( account.getUsr_id() );
							bkgCstmsAnrEdiMsgVOs.add( bkgCstmsAnrEdiMsgVO ) ;
							iMsgSeq ++;
						}
						bkgCstmsAnrEdiMsgVOs2.add( bkgCstmsAnrEdiMsgVOs );
						
						iRefSeq2 ++;
					}
					
					String sBlNo   = "012345678901";
					String sCntrNo = "012345678901";
					if( "0063".equals( ancsManifestTransmitVO.getFlatType() ) ){
						
						for (int i = 0; i < manifestTransmitVOs.length; i++) {
							AncsManifestTransmitVO ancsCstmsManifestVO2 = (AncsManifestTransmitVO)manifestTransmitVOs[i];
							
							BkgCstmsAnrEdiHisVO bkgCstmsAnrEdiHisVO = null;
						
							if ( !sBlNo.equals( ancsCstmsManifestVO2.getBlNo() ) ) {
								sBlNo = ancsCstmsManifestVO2.getBlNo();
								iRefSeq1++;
								//BKG_CSTMS_ANR_EDI_HIS TABLE.
								bkgCstmsAnrEdiHisVO = new BkgCstmsAnrEdiHisVO();
								bkgCstmsAnrEdiHisVO.setMsgTpCd( ( ancsManifestTransmitVO.getMsgTpCd() == null || ancsManifestTransmitVO.getMsgTpCd().equals("") ) ? " " : ancsManifestTransmitVO.getMsgTpCd() );
								bkgCstmsAnrEdiHisVO.setAnrDeclNo( ancsManifestTransmitVO.getAnrDeclNo() );
								bkgCstmsAnrEdiHisVO.setRefSeq( String.valueOf( iRefSeq1 ) );
								bkgCstmsAnrEdiHisVO.setVslCd( ancsManifestTransmitVO.getVvd().substring(0, 4) );
								bkgCstmsAnrEdiHisVO.setSkdVoyNo( ancsManifestTransmitVO.getVvd().substring(4, 8) );
								bkgCstmsAnrEdiHisVO.setSkdDirCd( ancsManifestTransmitVO.getVvd().substring(8, 9) );
								bkgCstmsAnrEdiHisVO.setEdiSndStsCd( ancsManifestTransmitVO.getKind() );
								bkgCstmsAnrEdiHisVO.setEdiSndUsrId( account.getUsr_id() );
								bkgCstmsAnrEdiHisVO.setSndOfcCd(account.getOfc_cd());
								bkgCstmsAnrEdiHisVO.setCreUsrId(account.getUsr_id());
								bkgCstmsAnrEdiHisVO.setUpdUsrId(account.getUsr_id());
								
								bkgCstmsAnrEdiHisVOs.add( bkgCstmsAnrEdiHisVO ); 
								
								//BkgCstmsAnrBlLog TABLE.
								BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO = new BkgCstmsAnrBlLogVO();
								bkgCstmsAnrBlLogVO.setAnrDeclNo( ancsCstmsManifestVO2.getAnrDeclNo() );
								bkgCstmsAnrBlLogVO.setRefSeq   ( String.valueOf( iRefSeq1 ) );
								bkgCstmsAnrBlLogVO.setBlNo( ancsCstmsManifestVO2.getBlNo() );
								bkgCstmsAnrBlLogVO.setVslCd( ancsCstmsManifestVO2.getVvd().substring(0, 4) );
								bkgCstmsAnrBlLogVO.setSkdVoyNo( ancsCstmsManifestVO2.getVvd().substring(4, 8) );
								bkgCstmsAnrBlLogVO.setSkdDirCd( ancsCstmsManifestVO2.getVvd().substring(8, 9) );
								bkgCstmsAnrBlLogVO.setBkgNo( ancsCstmsManifestVO2.getBkgNo() );
								bkgCstmsAnrBlLogVO.setEdiRcvStsCd( ancsCstmsManifestVO2.getAnrMsgStsCd() );
								bkgCstmsAnrBlLogVO.setCreUsrId ( account.getUsr_id() );
								bkgCstmsAnrBlLogVO.setUpdUsrId ( account.getUsr_id() );
								bkgCstmsAnrBlLogVOs.add( bkgCstmsAnrBlLogVO ) ;

								
							} 
							if( "1".equals(ancsCstmsManifestVO2.getS2()) && !sCntrNo.equals(ancsCstmsManifestVO2.getCntrNo()) ){
						
								sCntrNo = ancsCstmsManifestVO2.getCntrNo();
								
								//bkgCstmsAnrEdiHisVO = new BkgCstmsAnrEdiHisVO();
								//bkgCstmsAnrEdiHisVO.setMsgTpCd( ( ancsManifestTransmitVO.getMsgTpCd().equals("") || ancsManifestTransmitVO.getMsgTpCd().equals(null) ) ? " " : ancsManifestTransmitVO.getMsgTpCd() );
								//bkgCstmsAnrEdiHisVO.setAnrDeclNo( ancsManifestTransmitVO.getAnrDeclNo() );
								//bkgCstmsAnrEdiHisVO.setRefSeq( String.valueOf( iRefSeq1 ) );
								//bkgCstmsAnrEdiHisVO.setVslCd( ancsManifestTransmitVO.getVvd().substring(0, 4) );
								//bkgCstmsAnrEdiHisVO.setSkdVoyNo( ancsManifestTransmitVO.getVvd().substring(4, 8) );
								//bkgCstmsAnrEdiHisVO.setSkdDirCd( ancsManifestTransmitVO.getVvd().substring(8, 9) );
								//bkgCstmsAnrEdiHisVO.setEdiSndStsCd( ancsManifestTransmitVO.getKind() );
								//bkgCstmsAnrEdiHisVO.setEdiSndUsrId( account.getUsr_id() );
								//bkgCstmsAnrEdiHisVO.setSndOfcCd(account.getOfc_cd());
								//bkgCstmsAnrEdiHisVO.setCreUsrId(account.getUsr_id());
								//bkgCstmsAnrEdiHisVO.setUpdUsrId(account.getUsr_id());
								
								//bkgCstmsAnrEdiHisVOs.add( bkgCstmsAnrEdiHisVO ); 
								
								//BkgCstmsAnrCntrLog TABLE.
								BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO = new BkgCstmsAnrCntrLogVO();
								bkgCstmsAnrCntrLogVO.setAnrDeclNo( ancsCstmsManifestVO2.getAnrDeclNo() );
								bkgCstmsAnrCntrLogVO.setRefSeq   ( String.valueOf( iRefSeq1 ) );
								bkgCstmsAnrCntrLogVO.setCntrNo   ( ancsCstmsManifestVO2.getCmCntrNo() );
								bkgCstmsAnrCntrLogVO.setVslCd    ( ancsCstmsManifestVO2.getVvd().substring(0, 4) );
								bkgCstmsAnrCntrLogVO.setSkdVoyNo ( ancsCstmsManifestVO2.getVvd().substring(4, 8) );
								bkgCstmsAnrCntrLogVO.setSkdDirCd ( ancsCstmsManifestVO2.getVvd().substring(8, 9) );
								bkgCstmsAnrCntrLogVO.setBkgNo    ( ancsCstmsManifestVO2.getBkgNo() );
								bkgCstmsAnrCntrLogVO.setCreUsrId ( account.getUsr_id() );
								bkgCstmsAnrCntrLogVO.setUpdUsrId ( account.getUsr_id() );
								
								bkgCstmsCntrLogVOs.add( bkgCstmsAnrCntrLogVO ) ;
								//iRefSeq1 ++ ;
							}

						}
						
					}else{ // 0045 화면에서 요청시
						iRefSeq1++;
						for (int i = 0; i < manifestTransmitVOs.length; i++) {
							AncsManifestTransmitVO ancsCstmsManifestVO2 = (AncsManifestTransmitVO)manifestTransmitVOs[i];
							
							BkgCstmsAnrEdiHisVO bkgCstmsAnrEdiHisVO = null;
							
							
							if ( !sBlNo.equals( ancsCstmsManifestVO2.getBlNo() ) ) {
								sBlNo = ancsCstmsManifestVO2.getBlNo();
								
								//BKG_CSTMS_ANR_EDI_HIS TABLE.
								bkgCstmsAnrEdiHisVO = new BkgCstmsAnrEdiHisVO();
								bkgCstmsAnrEdiHisVO.setMsgTpCd( ancsManifestTransmitVO.getMsgTpCd() == null || ( ancsManifestTransmitVO.getMsgTpCd().equals("") ) ? " " : ancsManifestTransmitVO.getMsgTpCd() );
								bkgCstmsAnrEdiHisVO.setAnrDeclNo( ancsManifestTransmitVO.getAnrDeclNo() );
								bkgCstmsAnrEdiHisVO.setRefSeq( String.valueOf( iRefSeq1 ) );
								bkgCstmsAnrEdiHisVO.setVslCd( ancsManifestTransmitVO.getVvd().substring(0, 4) );
								bkgCstmsAnrEdiHisVO.setSkdVoyNo( ancsManifestTransmitVO.getVvd().substring(4, 8) );
								bkgCstmsAnrEdiHisVO.setSkdDirCd( ancsManifestTransmitVO.getVvd().substring(8, 9) );
								bkgCstmsAnrEdiHisVO.setEdiSndStsCd( ancsManifestTransmitVO.getKind() );
								bkgCstmsAnrEdiHisVO.setEdiSndUsrId( account.getUsr_id() );
								bkgCstmsAnrEdiHisVO.setSndOfcCd(account.getOfc_cd());
								bkgCstmsAnrEdiHisVO.setCreUsrId(account.getUsr_id());
								bkgCstmsAnrEdiHisVO.setUpdUsrId(account.getUsr_id());
								bkgCstmsAnrEdiHisVOs.add( bkgCstmsAnrEdiHisVO ); 
									
								//BkgCstmsAnrBlLog TABLE.
								if ( "1".equals(ancsCstmsManifestVO2.getS3()) )
								{
									BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO = new BkgCstmsAnrBlLogVO();
									bkgCstmsAnrBlLogVO.setAnrDeclNo( ancsCstmsManifestVO2.getAnrDeclNo() );
									bkgCstmsAnrBlLogVO.setRefSeq   ( String.valueOf( iRefSeq1 ) );
									bkgCstmsAnrBlLogVO.setBlNo( ancsCstmsManifestVO2.getBlNo() );
									bkgCstmsAnrBlLogVO.setVslCd( ancsCstmsManifestVO2.getVvd().substring(0, 4) );
									bkgCstmsAnrBlLogVO.setSkdVoyNo( ancsCstmsManifestVO2.getVvd().substring(4, 8) );
									bkgCstmsAnrBlLogVO.setSkdDirCd( ancsCstmsManifestVO2.getVvd().substring(8, 9) );
									bkgCstmsAnrBlLogVO.setBkgNo( ancsCstmsManifestVO2.getBkgNo() );
									bkgCstmsAnrBlLogVO.setEdiRcvStsCd( ancsCstmsManifestVO2.getAnrMsgStsCd() );
									bkgCstmsAnrBlLogVO.setCreUsrId ( account.getUsr_id() );
									bkgCstmsAnrBlLogVO.setUpdUsrId ( account.getUsr_id() );
									bkgCstmsAnrBlLogVOs.add( bkgCstmsAnrBlLogVO ) ;
								}
								//iRefSeq1 ++ ;
							}
							
							if( "1".equals(ancsCstmsManifestVO2.getS2()) && !sCntrNo.equals(ancsCstmsManifestVO2.getCntrNo()) ){
								sCntrNo = ancsCstmsManifestVO2.getCntrNo();
								
								//BkgCstmsAnrCntrLog TABLE.
								BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO = new BkgCstmsAnrCntrLogVO();
								bkgCstmsAnrCntrLogVO.setAnrDeclNo( ancsCstmsManifestVO2.getAnrDeclNo() );
								bkgCstmsAnrCntrLogVO.setRefSeq   ( String.valueOf( iRefSeq1 ) );
								bkgCstmsAnrCntrLogVO.setCntrNo   ( ancsCstmsManifestVO2.getCmCntrNo() );
								bkgCstmsAnrCntrLogVO.setVslCd    ( ancsCstmsManifestVO2.getVvd().substring(0, 4) );
								bkgCstmsAnrCntrLogVO.setSkdVoyNo ( ancsCstmsManifestVO2.getVvd().substring(4, 8) );
								bkgCstmsAnrCntrLogVO.setSkdDirCd ( ancsCstmsManifestVO2.getVvd().substring(8, 9) );
								bkgCstmsAnrCntrLogVO.setBkgNo    ( ancsCstmsManifestVO2.getBkgNo() );
								bkgCstmsAnrCntrLogVO.setCreUsrId ( account.getUsr_id() );
								bkgCstmsAnrCntrLogVO.setUpdUsrId ( account.getUsr_id() );
								
								bkgCstmsCntrLogVOs.add( bkgCstmsAnrCntrLogVO ) ;
								//iRefSeq1 ++ ;
							}	
						}	
					}
					
					
					AncsCstmsManifestVO ancsCstmsManifestVO = new AncsCstmsManifestVO();
					ancsCstmsManifestVO.setBkgCstmsAnrEdiHisVOs(bkgCstmsAnrEdiHisVOs);
					ancsCstmsManifestVO.setBkgCstmsAnrEdiMsgVOss(bkgCstmsAnrEdiMsgVOs2);
					ancsCstmsManifestVO.setBkgCstmsAnrBlLogVOs(bkgCstmsAnrBlLogVOs);
					ancsCstmsManifestVO.setBkgCstmsAnrCntrLogVOs(bkgCstmsCntrLogVOs);
					
					writeCstmsManifestSendLog( ancsCstmsManifestVO, account, "C" );
						
				}
			}
			return sFlatFile;
			
		} catch (EventException ex) {
			log.error(ex);
			throw ex;
		} catch (Exception ex) {
			log.error(ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ANCS 세관에 적하목록 신고를 EDI를 통해 전송한다.
	 * 
	 * @param CstmsManifestVO[] cstmsManifestVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void transmitManifest2(CstmsManifestVO[] cstmsManifestVOs, SignOnUserAccount account) throws EventException {
		String sFlatFile = "";
		try{
			sFlatFile = makeAncsCstmsManifestFlatFile(cstmsManifestVOs, account);
			/*
			 * EDI 연동.
			 */
			
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile( sFlatFile );
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_ANRCSCR.IBMMQ.QUEUE"));
			BookingUtil command = new BookingUtil();
			FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
			flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
			
			if ( flatFileAckVO.getAckStsCd().equals("E") )
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
			
			/*
			 * 로그 
			 */
			if( cstmsManifestVOs.length  > 0  ){
				List<BkgCstmsAnrEdiHisVO> bkgCstmsAnrEdiHisVOs = new ArrayList<BkgCstmsAnrEdiHisVO>();
				List<BkgCstmsAnrEdiMsgVO> bkgCstmsAnrEdiMsgVOs = new ArrayList<BkgCstmsAnrEdiMsgVO>();
				List<BkgCstmsAnrBlLogVO>  bkgCstmsAnrBlLogVOs  = new ArrayList<BkgCstmsAnrBlLogVO>();
				List<BkgCstmsAnrCntrLogVO>  bkgCstmsCntrLogVOs  = new ArrayList<BkgCstmsAnrCntrLogVO>();
				
				AncsCstmsManifestVO ancsManifestTransmitVO = (AncsCstmsManifestVO)cstmsManifestVOs[0];
								
				//BkgCstmsAnrEdiHis TABLE.
				//데이터는 로우 갯수만큼 가져왔으나 실제 테이블에는 한로우만 저장이 되어야 한다.
				BkgCstmsAnrEdiHisVO bkgCstmsAnrEdiHisVO = new BkgCstmsAnrEdiHisVO();
				bkgCstmsAnrEdiHisVO.setMsgTpCd( ancsManifestTransmitVO.getMsgTpCd() );
				bkgCstmsAnrEdiHisVO.setAnrDeclNo( ancsManifestTransmitVO.getAnrDeclNo() );
				bkgCstmsAnrEdiHisVO.setRefSeq( ancsManifestTransmitVO.getSequence() );
				bkgCstmsAnrEdiHisVO.setVslCd( ancsManifestTransmitVO.getVvd().substring(0, 4) );
				bkgCstmsAnrEdiHisVO.setSkdVoyNo( ancsManifestTransmitVO.getVvd().substring(4, 8) );
				bkgCstmsAnrEdiHisVO.setSkdDirCd( ancsManifestTransmitVO.getVvd().substring(8, 9) );
				bkgCstmsAnrEdiHisVO.setEdiSndStsCd( ancsManifestTransmitVO.getKind() );
				bkgCstmsAnrEdiHisVO.setEdiSndUsrId( account.getUsr_id() );
				bkgCstmsAnrEdiHisVO.setSndOfcCd(account.getOfc_cd());
				bkgCstmsAnrEdiHisVO.setCreUsrId(account.getUsr_id());
				bkgCstmsAnrEdiHisVO.setUpdUsrId(account.getUsr_id());
				bkgCstmsAnrEdiHisVOs.add( bkgCstmsAnrEdiHisVO ); 
				
				//BkgCstmsAnrEdiMsg TABLE.
				//데이터는 로우 갯수만큼 가져왔으나 실제 테이블에는 한로우만 저장이 되어야 한다.
				
				String[] sFlatLineArry = sFlatFile.toString().split("\n");
				String sMsgSeq = ancsManifestTransmitVO.getMsgSeq();
				int iMsgSeq = Integer.parseInt(sMsgSeq);
				for (int i = 0; i < sFlatLineArry.length; i++) {
					
					BkgCstmsAnrEdiMsgVO bkgCstmsAnrEdiMsgVO = new BkgCstmsAnrEdiMsgVO();
					bkgCstmsAnrEdiMsgVO.setMsgTpCd  ( ancsManifestTransmitVO.getMsgTpCd() );
					bkgCstmsAnrEdiMsgVO.setRcvSndDivCd("S");
					bkgCstmsAnrEdiMsgVO.setAnrDeclNo( ancsManifestTransmitVO.getAnrDeclNo() );
					bkgCstmsAnrEdiMsgVO.setRefSeq   ( ancsManifestTransmitVO.getSequence() );
					bkgCstmsAnrEdiMsgVO.setMsgSeq( String.valueOf(iMsgSeq) );
					
					bkgCstmsAnrEdiMsgVO.setEdiMsg   ( sFlatLineArry[i] );
					bkgCstmsAnrEdiMsgVO.setCreUsrId ( account.getUsr_id() );
					bkgCstmsAnrEdiMsgVO.setUpdUsrId ( account.getUsr_id() );
					bkgCstmsAnrEdiMsgVOs.add( bkgCstmsAnrEdiMsgVO ) ;
					iMsgSeq ++;
				}
				
				
				String sBlNo = "012345678901";
				for (int i = 0; i < cstmsManifestVOs.length; i++) {
					AncsCstmsManifestVO ancsCstmsManifestVO2 = (AncsCstmsManifestVO)cstmsManifestVOs[i];
					
					if ( !sBlNo.equals( ancsCstmsManifestVO2.getBlNo() ) ) {
						sBlNo = ancsCstmsManifestVO2.getBlNo();
					
						//BkgCstmsAnrBlLog TABLE.
						BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO = new BkgCstmsAnrBlLogVO();
						bkgCstmsAnrBlLogVO.setAnrDeclNo( ancsCstmsManifestVO2.getAnrDeclNo() );
						bkgCstmsAnrBlLogVO.setRefSeq   ( ancsCstmsManifestVO2.getSequence() );
						bkgCstmsAnrBlLogVO.setBlNo( ancsCstmsManifestVO2.getBlNo() );
						bkgCstmsAnrBlLogVO.setVslCd( ancsCstmsManifestVO2.getVvd().substring(0, 4) );
						bkgCstmsAnrBlLogVO.setSkdVoyNo( ancsCstmsManifestVO2.getVvd().substring(4, 8) );
						bkgCstmsAnrBlLogVO.setSkdDirCd( ancsCstmsManifestVO2.getVvd().substring(8, 9) );
						bkgCstmsAnrBlLogVO.setBkgNo( ancsCstmsManifestVO2.getBkgNo() );
						bkgCstmsAnrBlLogVO.setEdiRcvStsCd( ancsCstmsManifestVO2.getAnrMsgStsCd() );
						bkgCstmsAnrBlLogVO.setCreUsrId ( account.getUsr_id() );
						bkgCstmsAnrBlLogVO.setUpdUsrId ( account.getUsr_id() );
						bkgCstmsAnrBlLogVOs.add( bkgCstmsAnrBlLogVO ) ;
					}
					
					//BkgCstmsAnrCntrLog TABLE.
					BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO = new BkgCstmsAnrCntrLogVO();
					bkgCstmsAnrCntrLogVO.setAnrDeclNo( ancsCstmsManifestVO2.getAnrDeclNo() );
					bkgCstmsAnrCntrLogVO.setRefSeq   ( ancsCstmsManifestVO2.getSequence() );
					bkgCstmsAnrCntrLogVO.setCntrNo   ( ancsCstmsManifestVO2.getCmCntrNo() );
					bkgCstmsAnrCntrLogVO.setVslCd    ( ancsCstmsManifestVO2.getVvd().substring(0, 4) );
					bkgCstmsAnrCntrLogVO.setSkdVoyNo ( ancsCstmsManifestVO2.getVvd().substring(4, 8) );
					bkgCstmsAnrCntrLogVO.setSkdDirCd ( ancsCstmsManifestVO2.getVvd().substring(8, 9) );
					bkgCstmsAnrCntrLogVO.setBkgNo    ( ancsCstmsManifestVO2.getBkgNo() );
					bkgCstmsAnrCntrLogVO.setCreUsrId ( account.getUsr_id() );
					bkgCstmsAnrCntrLogVO.setUpdUsrId ( account.getUsr_id() );
					bkgCstmsCntrLogVOs.add( bkgCstmsAnrCntrLogVO ) ;
					
				}
				AncsCstmsManifestVO ancsCstmsManifestVO = new AncsCstmsManifestVO();
				ancsCstmsManifestVO.setBkgCstmsAnrEdiHisVOs(bkgCstmsAnrEdiHisVOs);
				ancsCstmsManifestVO.setBkgCstmsAnrEdiMsgVOs(bkgCstmsAnrEdiMsgVOs);
				ancsCstmsManifestVO.setBkgCstmsAnrBlLogVOs(bkgCstmsAnrBlLogVOs);
				ancsCstmsManifestVO.setBkgCstmsAnrCntrLogVOs(bkgCstmsCntrLogVOs);
				
				writeCstmsManifestSendLog( ancsCstmsManifestVO, account, "C" );
				
			}	
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
	}

	/**
	 * 세관에 EDI 메시지 송신 후 기록을 남김
	 * 
	 * @param cstmsManifestVO
	 * @param account
	 * @param sMsgTpCd
	 * @throws EventException
	 */
	private void writeCstmsManifestSendLog( CstmsManifestVO cstmsManifestVO, SignOnUserAccount account, String sMsgTpCd ) throws EventException{
		
		try{
			
			AncsCstmsManifestVO ancsCstmsManifestVO = (AncsCstmsManifestVO)cstmsManifestVO;
			
			/*
			 * EDI 이력 테이블에 저장 [ start ]
			 */
			dbDao.addBkgCstmsAnrEdiHis( ancsCstmsManifestVO.getBkgCstmsAnrEdiHisVOs());
			
			List<List<BkgCstmsAnrEdiMsgVO>> list =  ancsCstmsManifestVO.getBkgCstmsAnrEdiMsgVOss();
			for (Iterator<List<BkgCstmsAnrEdiMsgVO>> iterator = list.iterator(); iterator.hasNext();) {
				List<BkgCstmsAnrEdiMsgVO> list2 = iterator.next();
						
				dbDao.addBkgCstmsAnrEdiMsg( list2 );
				//dbDao.addBkgCstmsAnrEdiMsg( ancsCstmsManifestVO.getBkgCstmsAnrEdiMsgVOs());
				
			}
			
			if( "C".equals(sMsgTpCd) && ancsCstmsManifestVO.getBkgCstmsAnrBlLogVOs().size() > 0 )
			dbDao.addBkgCstmsAnrBlLog ( ancsCstmsManifestVO.getBkgCstmsAnrBlLogVOs());
			
			if( "C".equals(sMsgTpCd) )
			dbDao.addBkgCstmsAnrCntrLog( ancsCstmsManifestVO.getBkgCstmsAnrCntrLogVOs());
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 벨기에 세관 전송을 위한 Flat File을 만듬 
	 * 
	 * @param manifestTransmitVOs
	 * @param account
	 * @return
	 * @throws EventException
	 */
	private String makeAncsCstmsManifestFlatFile( CstmsManifestVO[] cstmsManifestVOs, SignOnUserAccount account)
			throws EventException {
		StringBuffer flatFile = new StringBuffer();
		try{			
			if( cstmsManifestVOs.length  > 0  ){
				
				BookingUtil command = new BookingUtil();
				String sEdiHeader = command.searchCstmsEdiHeader("HANSHI", "DOUANE", "CUSCAR");
				flatFile.append( sEdiHeader ).append("\n");
	
				for (int i = 0; i < cstmsManifestVOs.length; i++) {
					AncsCstmsManifestVO ancsCstmsManifestVO = (AncsCstmsManifestVO)cstmsManifestVOs[i];
					
					String sKind = ancsCstmsManifestVO.getKind();
					if( "O".equals(sKind) )
						sKind = "9";
					else if( "T".equals(sKind) )
						sKind = "5";
					else if( "C".equals(sKind) )
						sKind = "3";
					
					String sCneeAddr = ancsCstmsManifestVO.getCneeAddr().replaceAll("\r\n", " ");
					String sShprAddr = ancsCstmsManifestVO.getShprAddr().replaceAll("\r\n", " ");
					String sNtfyAddr = ancsCstmsManifestVO.getNtfyAddr().replaceAll("\r\n", " ");
					String sNtfyName = ancsCstmsManifestVO.getNtfyName().replaceAll("\r\n", " ");
					
			flatFile.append("VVD:").append( ancsCstmsManifestVO.getVvd() ).append("\n")
			        .append("STATUS:").append( sKind ).append("\n")
			        .append("LLOYD_CD:").append( ancsCstmsManifestVO.getLloydCd() ).append("\n")
			        .append("SS_REF_NO:").append( ancsCstmsManifestVO.getSvcRqstNo() ).append("\n")
			        .append("SEQUENCE:").append( ancsCstmsManifestVO.getSequence() ).append("\n")
			        .append("PREV_DOCNO:").append( ancsCstmsManifestVO.getPrevDocno() ).append("\n")
			        .append("{BL_INFO").append("\n")
			        .append("WGT:").append( ancsCstmsManifestVO.getActWgt() ).append("\n")
			        .append("WGT_U:").append( ancsCstmsManifestVO.getWgtUtCd() ).append("\n")
			        .append("ART_NO:").append( ancsCstmsManifestVO.getVvdSeq() ).append("\n")
			        .append("BL_NO:").append( ancsCstmsManifestVO.getBlNo() ).append("\n")			        			        
			        .append("PKG:").append( ancsCstmsManifestVO.getPckQty() ).append("\n")
			        .append("POD:").append( ancsCstmsManifestVO.getPodCd() ).append("\n")
	                .append("BERTH_CD:").append( ancsCstmsManifestVO.getBrthDesc() ).append("\n")
	                .append("POL:").append( ancsCstmsManifestVO.getPolCd() ).append("\n")
	                .append("PRE:").append( ancsCstmsManifestVO.getPreRlyPortCd() ).append("\n")
	                .append("POST:").append( ancsCstmsManifestVO.getPstRlyPortCd() ).append("\n")
	                .append("POR:").append( ancsCstmsManifestVO.getPorCd() ).append("\n")
	                .append("DEL:").append( ancsCstmsManifestVO.getDelCd() ).append("\n")
	                .append("SHPR_NAME:").append( sShprAddr.substring(0, sShprAddr.indexOf("@@")) ).append("\n")
	                .append("SHPR_ADDR:").append( sShprAddr.substring(sShprAddr.indexOf("@@")+2) ).append("\n")
	                .append("CNEE_NAME:").append( sCneeAddr.substring(0, sCneeAddr.indexOf("@@")) ).append("\n")
					.append("CNEE_ADDR:").append( sCneeAddr.substring(sCneeAddr.indexOf("@@")+2) ).append("\n")
	                
	                .append("NTFY_NAME:").append( sNtfyName ).append("\n")
	                .append("NTFY_ADDR:").append( sNtfyAddr ).append("\n")
	                .append("}BL_INFO").append("\n")
	                .append("{CM_INFO").append("\n")
	                .append("CM_SEQ:").append( ancsCstmsManifestVO.getCntrSeq() ).append("\n")
	                .append("CM_PKG_NO:").append( ancsCstmsManifestVO.getPckQty() ).append("\n")
	                .append("CM_PKG_CD:").append( ancsCstmsManifestVO.getPckTpCd() ).append("\n")
	                .append("CM_DESC:").append( ancsCstmsManifestVO.getCntrMfDesc() ).append("\n")
	                .append("CM_WGT:").append( ancsCstmsManifestVO.getCntrMfWgt() ).append("\n")
	                .append("CM_WGT_U:").append( ancsCstmsManifestVO.getWgtUtCd() ).append("\n")
	                .append("CM_CNTR_NO:").append( ancsCstmsManifestVO.getCmCntrNo() ).append("\n")      
	                .append("T1_IND:").append( ancsCstmsManifestVO.getDeclFlg() ).append("\n")      
	                .append("}CM_INFO").append("\n")      
	                .append("{CNTR_INFO").append("\n")         
	                .append("CNTR_NO:").append( ancsCstmsManifestVO.getCntrNo() ).append("\n")         
	                .append("CNTR_TS:").append( ancsCstmsManifestVO.getCntrTpszCd() ).append("\n")         
	                .append("CNTR_FM:").append( ancsCstmsManifestVO.getCntrFm() ).append("\n")         
	                .append("CNTR_WGT:").append( ancsCstmsManifestVO.getCntrMfWgt() ).append("\n")         
	                .append("RD_TERM:").append( ancsCstmsManifestVO.getRdTerm() ).append("\n")         
	                .append("}CNTR_INFO").append("\n");  
							        
				}
			}
		
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	
	
	/**
	 * EDI Inbound 처리 메서드 
	 * 
	 * @param String rcvMsg
	 * @param SignOnUserAccount account
	 * @return RcvMsgVO
	 * @exception EventException
	 */
	@Override
	public RcvMsgVO loadCstmsRcvMsg(String rcvMsg, SignOnUserAccount account) throws EventException {
		
		try{
			
			AncsRcvMsgVO ancsRcvMsgVO = parseRcvMsg(rcvMsg);
			List< BkgCstmsAnrEdiHisVO > bkgCstmsAnrEdiHisVOs = new ArrayList<BkgCstmsAnrEdiHisVO>();
			List< BkgCstmsAnrEdiMsgVO > bkgCstmsAnrEdiMsgVOs = new ArrayList<BkgCstmsAnrEdiMsgVO>();
			
			String[] sFlatFileArry = ancsRcvMsgVO.getSFlatFileArry();
			String sMsgTpCd = "R";
			if( "CUSREP".equals(ancsRcvMsgVO.getMsgId()) )
				sMsgTpCd = "R";
			else
				sMsgTpCd = "C";
			String sUsr_Id = "ESM_BKG_0494";//account.getUsr_id();
			String sRcvStsCd = "A";
			if( "44".equals( ancsRcvMsgVO.getRcvSts() ) )
				sRcvStsCd = "A";
			else
				sRcvStsCd = "E";
			
			/*
			 * EDI 이력 테이블에 저장 [ start ]
			 */
			
			/*
			 * 1.수신된 메시지의 LINE 수 만큼 LOOP 돌며 한 LINE 씩 BKG_CSTMS_ANR_EDI_MSG에 넣기
			 * INSERT INTO BKG_CSTMS_ANR_EDI_MSG
      		 * (MSG_TP_CD, RCV_SND_DIV_CD, ANR_DECL_NO, REF_SEQ, MSG_SEQ, EDI_MSG)
    		 * VALUES
      		 * ('C', 'R', $(DCLR_NO:), $(REF_SEQ:), $(LINE NO), $(LINE TEXT));
			 */
			
			for (int j = 0; j < sFlatFileArry.length; j++) {
				BkgCstmsAnrEdiMsgVO bkgCstmsAnrEdiMsgVO = new BkgCstmsAnrEdiMsgVO();
				bkgCstmsAnrEdiMsgVO.setMsgTpCd  ( sMsgTpCd );
				bkgCstmsAnrEdiMsgVO.setRcvSndDivCd("R");  
				bkgCstmsAnrEdiMsgVO.setAnrDeclNo( ancsRcvMsgVO.getDclrNo() );
				bkgCstmsAnrEdiMsgVO.setRefSeq   ( ancsRcvMsgVO.getRefSeq() );
				bkgCstmsAnrEdiMsgVO.setMsgSeq   ( String.valueOf(j) );
				bkgCstmsAnrEdiMsgVO.setEdiMsg   ( sFlatFileArry[j] );
				bkgCstmsAnrEdiMsgVO.setCreUsrId ( sUsr_Id );
				bkgCstmsAnrEdiMsgVO.setUpdUsrId ( sUsr_Id );
				
				bkgCstmsAnrEdiMsgVOs.add( bkgCstmsAnrEdiMsgVO ) ;
			}
			dbDao.addBkgCstmsAnrEdiMsg( bkgCstmsAnrEdiMsgVOs);
			
			/*
			 * 3. 수신한 $(DCLR_NO:)와 $(REF_SEQ:)로  BKG_CSTMS_ANR_EDI_HIS의 수신 결과 초기화
			 *    UPDATE BKG_CSTMS_ANR_EDI_HIS
			 *       SET EDI_RCV_STS_CD = NULL,
			 *           RCV_DT = SYSDATE,
			 *           ANR_EDI_RTN_ID = $(RCV_STS:),
			 *           MSG_LOC_CD = NULL,
			 *           EDI_MSG_ERR_ID = NULL,
			 *           ERR_DESC = NULL,
			 *           ERR_CTNT = NULL
			 *     WHERE MSG_TP_CD = 'C'
		 	 *       AND ANR_DECL_NO = $(DCLR_NO:)
		 	 *       AND REF_SEQ = $(REF_SEQ:)
			 * 
			 */
			BkgCstmsAnrEdiHisVO bkgCstmsAnrEdiHisVO = new BkgCstmsAnrEdiHisVO();
			bkgCstmsAnrEdiHisVO.setEdiRcvStsCd( sRcvStsCd );
			bkgCstmsAnrEdiHisVO.setAnrEdiRtnId(ancsRcvMsgVO.getRcvSts());
			bkgCstmsAnrEdiHisVO.setUpdUsrId(sUsr_Id);
			bkgCstmsAnrEdiHisVO.setMsgTpCd  (sMsgTpCd);
			bkgCstmsAnrEdiHisVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
			bkgCstmsAnrEdiHisVO.setRefSeq   (ancsRcvMsgVO.getRefSeq());
			
			bkgCstmsAnrEdiHisVOs.add(bkgCstmsAnrEdiHisVO);
			dbDao.modifyBkgCstmsAnrEdiHis( bkgCstmsAnrEdiHisVOs );
			
			/*
			 * 4. 수신 메시지의 $(ERR_DIV:) = "M"인 ERROR 루프가 존재하면, 한번만,
			 *       BKG_CSTMS_ANR_EDI_HIS 업데이트
			 *     UPDATE BKG_CSTMS_ANR_EDI_HIS
			 *        SET MSG_LOC_CD = $(ERR_LOC:),
			 *            EDI_MSG_ERR_ID = $(ERR_CD:),
			 *            ERR_DESC = $(ERR_DESC:),
			 *            ERR_CTNT = $(ERR_DTL:)
			 *      WHERE MSG_TP_CD = 'C'
			 *        AND ANR_DECL_NO = $(DCLR_NO:)
			 *        AND REF_SEQ = $(REF_SEQ:)
			 */
			if( "M".equals( ancsRcvMsgVO.getErrDiv() ) ){
				
				BkgCstmsAnrEdiHisVO bkgCstmsAnrEdiHisVO2 = new BkgCstmsAnrEdiHisVO();
				bkgCstmsAnrEdiHisVO2.setEdiRcvStsCd( sRcvStsCd );
				bkgCstmsAnrEdiHisVO2.setAnrEdiRtnId(ancsRcvMsgVO.getRcvSts());
				bkgCstmsAnrEdiHisVO2.setMsgLocCd(ancsRcvMsgVO.getErrLoc());
				bkgCstmsAnrEdiHisVO2.setEdiMsgErrId(ancsRcvMsgVO.getErrCd());
				bkgCstmsAnrEdiHisVO2.setErrDesc(ancsRcvMsgVO.getErrDesc());
				bkgCstmsAnrEdiHisVO2.setErrCtnt(ancsRcvMsgVO.getErrDtl());
				bkgCstmsAnrEdiHisVO2.setUpdUsrId (sUsr_Id);
				bkgCstmsAnrEdiHisVO2.setMsgTpCd  (sMsgTpCd);
				bkgCstmsAnrEdiHisVO2.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrEdiHisVO2.setRefSeq   (ancsRcvMsgVO.getRefSeq());
				
				bkgCstmsAnrEdiHisVOs.add(bkgCstmsAnrEdiHisVO2);
				dbDao.modifyBkgCstmsAnrEdiHis( bkgCstmsAnrEdiHisVOs );
			}
			

			//BKG_CSTMS_ANR_BL_LOG
			if( "C".equals(sMsgTpCd) ){
				
				/*
				 * 5. 수신한 $(DCLR_NO:)와 $(REF_SEQ:)로 BKG_CSTMS_ANR_BL_LOG의 수신 결과 초기화
				 *     UPDATE BKG_CSTMS_ANR_BL_LOG
				 *        SET EDI_RCV_STS_CD = 'N',
				 *            MSG_LOC_CD = NULL,
				 *            EDI_MSG_ERR_ID = NULL,
				 *            ERR_DESC = NULL,
				 *            ERR_CTNT = NULL
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 */
				List< BkgCstmsAnrBlLogVO > bkgCstmsAnrBlLogVOs = new ArrayList<BkgCstmsAnrBlLogVO>();
				BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO = new BkgCstmsAnrBlLogVO();
				bkgCstmsAnrBlLogVO.setEdiRcvStsCd( "N" );
				sRcvStsCd = "N";
				bkgCstmsAnrBlLogVO.setUpdUsrId(sUsr_Id);
				bkgCstmsAnrBlLogVO.setMsgTpCd  (sMsgTpCd);
				bkgCstmsAnrBlLogVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrBlLogVO.setRefSeq   (ancsRcvMsgVO.getRefSeq());
				
				bkgCstmsAnrBlLogVOs.add(bkgCstmsAnrBlLogVO);
				dbDao.modifyBkgCstmsAnrBlLog( bkgCstmsAnrBlLogVOs );
				
				/*
				 * 6. 수신 메시지의 $(ERR_DIV:) = "B"인 ERROR 루프가 존재하면, 한번만,
				 *       BKG_CSTMS_ANR_BL_LOG 업데이트
				 *     UPDATE BKG_CSTMS_ANR_BL_LOG
				 *        SET EDI_RCV_STS_CD = 'E',
				 *            MSG_LOC_CD = $(ERR_LOC:),
				 *            EDI_MSG_ERR_ID = $(ERR_CD:),
				 *            ERR_DESC = $(ERR_DESC:),
				 *            ERR_CTNT = $(ERR_DTL:)
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 *        AND BL_NO = $(NUMBER:)
				 */
				if( "B".equals( ancsRcvMsgVO.getErrDiv() ) ){
					List< BkgCstmsAnrBlLogVO > bkgCstmsAnrBlLogVOs2 = new ArrayList<BkgCstmsAnrBlLogVO>();
					BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO2 = new BkgCstmsAnrBlLogVO();
					bkgCstmsAnrBlLogVO2.setEdiRcvStsCd( "E" );
					sRcvStsCd = "E" ;
					bkgCstmsAnrBlLogVO2.setMsgLocCd(ancsRcvMsgVO.getErrLoc());
					bkgCstmsAnrBlLogVO2.setEdiMsgErrId(ancsRcvMsgVO.getErrCd());
					bkgCstmsAnrBlLogVO2.setErrDesc(ancsRcvMsgVO.getErrDesc());
					bkgCstmsAnrBlLogVO2.setErrCtnt(ancsRcvMsgVO.getErrDtl());
					bkgCstmsAnrBlLogVO2.setUpdUsrId(sUsr_Id);
					bkgCstmsAnrBlLogVO2.setMsgTpCd  (sMsgTpCd);
					bkgCstmsAnrBlLogVO2.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
					bkgCstmsAnrBlLogVO2.setRefSeq   (ancsRcvMsgVO.getRefSeq());
					
					bkgCstmsAnrBlLogVOs2.add(bkgCstmsAnrBlLogVO2);
					dbDao.modifyBkgCstmsAnrBlLog( bkgCstmsAnrBlLogVOs2 );
					
				}
				
				/*
				 * 7. 수신한 $(RCV_STS:) 및 기존 EDI_RCV_STS_CD에 따라 BKG_CSTMS_ANR_BL_LOG 업데이트
				 *     UPDATE BKG_CSTMS_ANR_BL_LOG
				 *        SET EDI_RCV_STS_CD = CASE WHEN $(RCV_STS:) =  '48' THEN 'E'
				 *                                  WHEN $(RCV_STS:) <> '48'
				 *                                       AND EDI_RCV_STS_CD = 'N' THEN 'A'
				 *                                  ELSE EDI_RCV_STS_CD
				 *                             END
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 */
				List< BkgCstmsAnrBlLogVO > bkgCstmsAnrBlLogVOs3 = new ArrayList<BkgCstmsAnrBlLogVO>();
				BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO3 = new BkgCstmsAnrBlLogVO();
				if( "48".equals( ancsRcvMsgVO.getRcvSts() ) ){
					bkgCstmsAnrBlLogVO3.setEdiRcvStsCd( "E" );
				}else if( !"48".equals( ancsRcvMsgVO.getRcvSts() ) && "N".equals( sRcvStsCd ) ){
					bkgCstmsAnrBlLogVO3.setEdiRcvStsCd( "A" );
				}else{
					bkgCstmsAnrBlLogVO3.setEdiRcvStsCd( sRcvStsCd );
				}
				bkgCstmsAnrBlLogVO3.setMsgLocCd(ancsRcvMsgVO.getErrLoc());
				bkgCstmsAnrBlLogVO3.setEdiMsgErrId(ancsRcvMsgVO.getErrCd());
				bkgCstmsAnrBlLogVO3.setErrDesc(ancsRcvMsgVO.getErrDesc());
				bkgCstmsAnrBlLogVO3.setErrCtnt(ancsRcvMsgVO.getErrDtl());
				bkgCstmsAnrBlLogVO3.setUpdUsrId(sUsr_Id);
				bkgCstmsAnrBlLogVO3.setMsgTpCd  (sMsgTpCd);
				bkgCstmsAnrBlLogVO3.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrBlLogVO3.setRefSeq   (ancsRcvMsgVO.getRefSeq());
				bkgCstmsAnrBlLogVOs3.add(bkgCstmsAnrBlLogVO3);
				dbDao.modifyBkgCstmsAnrBlLog( bkgCstmsAnrBlLogVOs3 );
				
				/*
				 * 10. 수신한 $(DCLR_NO:)와 $(REF_SEQ:)로 BKG_CSTMS_ANR_CNTR_LOG의 수신 결과 초기화
				 *     UPDATE BKG_CSTMS_ANR_CNTR_LOG
				 *        SET EDI_RCV_STS_CD = 'N',
				 *            MSG_LOC_CD = NULL,
				 *            EDI_MSG_ERR_ID = NULL,
				 *            ERR_DESC = NULL,
				 *            ERR_CTNT = NULL
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 */
				List< BkgCstmsAnrCntrLogVO > bkgCstmsAnrCntrLogVOs = new ArrayList<BkgCstmsAnrCntrLogVO>();
				BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO = new BkgCstmsAnrCntrLogVO();
				bkgCstmsAnrCntrLogVO.setEdiRcvStsCd( "N" );
				sRcvStsCd = "N";
				bkgCstmsAnrCntrLogVO.setUpdUsrId(sUsr_Id);
				bkgCstmsAnrCntrLogVO.setMsgTpCd  (sMsgTpCd);
				bkgCstmsAnrCntrLogVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrCntrLogVO.setRefSeq   (ancsRcvMsgVO.getRefSeq());
				bkgCstmsAnrCntrLogVOs.add(bkgCstmsAnrCntrLogVO);
				dbDao.modifyBkgCstmsAnrCntrLog( bkgCstmsAnrCntrLogVOs );
				
				/*
				 * 11. 수신 메시지의 $(ERR_DIV:) = "C"인 ERROR 루프가 존재하면, 존재하는 개수 만큼 LOOP
				 *     UPDATE BKG_CSTMS_ANR_CNTR_LOG
				 *        SET EDI_RCV_STS_CD = 'E',
				 *            MSG_LOC_CD = $(ERR_LOC:),
				 *            EDI_MSG_ERR_ID = $(ERR_CD:),
				 *            ERR_DESC = $(ERR_DESC:),
				 *            ERR_CTNT = $(ERR_DTL:)
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 *        AND CNTR_NO = $(NUMBER:)
				 */
				if( "C".equals( ancsRcvMsgVO.getErrDiv() ) ){
					List< BkgCstmsAnrCntrLogVO > bkgCstmsAnrCntrLogVOs2 = new ArrayList<BkgCstmsAnrCntrLogVO>();
					BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO2 = new BkgCstmsAnrCntrLogVO();
					bkgCstmsAnrCntrLogVO2.setEdiRcvStsCd( "E" );
					sRcvStsCd = "E";
					bkgCstmsAnrCntrLogVO2.setMsgLocCd(ancsRcvMsgVO.getErrLoc());
					bkgCstmsAnrCntrLogVO2.setEdiMsgErrId(ancsRcvMsgVO.getErrCd());
					bkgCstmsAnrCntrLogVO2.setErrDesc(ancsRcvMsgVO.getErrDesc());
					bkgCstmsAnrCntrLogVO2.setErrCtnt(ancsRcvMsgVO.getErrDtl());
					bkgCstmsAnrCntrLogVO2.setUpdUsrId(sUsr_Id);
					bkgCstmsAnrCntrLogVO2.setMsgTpCd  (sMsgTpCd);
					bkgCstmsAnrCntrLogVO2.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
					bkgCstmsAnrCntrLogVO2.setRefSeq   (ancsRcvMsgVO.getRefSeq());
					bkgCstmsAnrCntrLogVOs2.add(bkgCstmsAnrCntrLogVO2);
					dbDao.modifyBkgCstmsAnrCntrLog( bkgCstmsAnrCntrLogVOs2 );
				}	
				
				/*
				 * 12.  수신한 $(RCV_STS:) 및 기존 EDI_RCV_STS_CD에 따라 BKG_CSTMS_ANR_BL_LOG 업데이트
				 *     UPDATE BKG_CSTMS_ANR_BL_CNTR
				 *        SET EDI_RCV_STS_CD = CASE WHEN $(RCV_STS:) =  '48' THEN 'E'
				 *                                  WHEN $(RCV_STS:) <> '48'
				 *                                       AND EDI_RCV_STS_CD = 'N' THEN 'A'
				 *                                  ELSE EDI_RCV_STS_CD
				 *                             END
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 */
				List< BkgCstmsAnrCntrLogVO > bkgCstmsAnrCntrLogVOs3 = new ArrayList<BkgCstmsAnrCntrLogVO>();
				BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO3 = new BkgCstmsAnrCntrLogVO();
				if( "48".equals( ancsRcvMsgVO.getRcvSts() ) ){
					bkgCstmsAnrCntrLogVO3.setEdiRcvStsCd( "E" );
				}else if( !"48".equals( ancsRcvMsgVO.getRcvSts() ) && "N".equals( sRcvStsCd ) ){
					bkgCstmsAnrCntrLogVO3.setEdiRcvStsCd( "A" );
				}else{
					bkgCstmsAnrCntrLogVO3.setEdiRcvStsCd( sRcvStsCd );
				}
				bkgCstmsAnrCntrLogVO3.setMsgLocCd(ancsRcvMsgVO.getErrLoc());
				bkgCstmsAnrCntrLogVO3.setEdiMsgErrId(ancsRcvMsgVO.getErrCd());
				bkgCstmsAnrCntrLogVO3.setErrDesc(ancsRcvMsgVO.getErrDesc());
				bkgCstmsAnrCntrLogVO3.setErrCtnt(ancsRcvMsgVO.getErrDtl());
				bkgCstmsAnrCntrLogVO3.setUpdUsrId(sUsr_Id);
				bkgCstmsAnrCntrLogVO3.setMsgTpCd  (sMsgTpCd);
				bkgCstmsAnrCntrLogVO3.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrCntrLogVO3.setRefSeq   (ancsRcvMsgVO.getRefSeq());
				bkgCstmsAnrCntrLogVOs3.add(bkgCstmsAnrCntrLogVO3);
				dbDao.modifyBkgCstmsAnrCntrLog( bkgCstmsAnrCntrLogVOs3 );
				
			}	
			
			return ancsRcvMsgVO;
			
		} catch (DAOException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getUserMessage());
		
		} catch ( Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}

	}
	
	/**
	 * 수신 FLAT 파일을 파싱하여 Value Object 에 담아서 리턴 하는 메서드.
	 * 
	 * @param sRcvMsg
	 * @return
	 */
	private AncsRcvMsgVO  parseRcvMsg( String sRcvMsg ) throws EventException{
		AncsRcvMsgVO ancsRcvMsgVO = new AncsRcvMsgVO();
		
		try{		
		
			String sTemp = sRcvMsg.replaceAll("\r\n", "\n");
			String[] sFlatLineArry = sTemp.split("\n");
			HashMap<String, String> hmAncsRcvMsg = new HashMap<String, String>();
			
			for (int i = 0; i < sFlatLineArry.length; i++) {
				String[] sTempArry = sFlatLineArry[i].split(":");
				if( sTempArry.length == 2 ){
					hmAncsRcvMsg.put(sTempArry[0].trim(), sTempArry[1]) ;
				} else if( sTempArry.length == 3 ) {
					hmAncsRcvMsg.put(sTempArry[0].trim(), sTempArry[1] + sTempArry[2] ) ;
				}
			}
			ancsRcvMsgVO.setMsgstart( hmAncsRcvMsg.get("$$$MSGSTART") );
			ancsRcvMsgVO.setDclrNo( hmAncsRcvMsg.get("DCLR_NO") );
			ancsRcvMsgVO.setMsgId( hmAncsRcvMsg.get("MSG_ID") );
			ancsRcvMsgVO.setRefSeq( hmAncsRcvMsg.get("REF_SEQ") );
			ancsRcvMsgVO.setRcvSts( hmAncsRcvMsg.get("RCV_STS") );
			
			if ( "48".equals(hmAncsRcvMsg.get("RCV_STS")) ){
			
				ancsRcvMsgVO.setErrDiv( hmAncsRcvMsg.get("ERR_DIV") );
				ancsRcvMsgVO.setNumber( hmAncsRcvMsg.get("NUMBER") );
				ancsRcvMsgVO.setErrLoc( hmAncsRcvMsg.get("ERR_LOC") );
				ancsRcvMsgVO.setErrCd ( hmAncsRcvMsg.get("ERR_CD") );
				ancsRcvMsgVO.setErrDesc( hmAncsRcvMsg.get("ERR_DESC") );
				ancsRcvMsgVO.setErrDtl( hmAncsRcvMsg.get("ERR_DTL") );
			}
			
			ancsRcvMsgVO.setSFlatFileArry(sFlatLineArry);
			
			return ancsRcvMsgVO;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}		
	}
}