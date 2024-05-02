/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsTransmissionBCImpl.java
*@FileTitle : ChinaCustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.25 이수빈
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.06.27 김봉균 [CHM-201111424-01] 중국 24hr manifest 관련 EDI 수신 순서 보완
* 2011.08.08 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.basic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration.ChinaCustomsTransmissionDBDAO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaAckVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCntrListVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCustListVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlDangerCntrListVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlGeneralListVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoCondVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaContainerCondVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaVvdInfoVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSCntrVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSCustVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSDownExcelVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSGRPVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSInfoBLVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSInfoSKDVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.TmlBlVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.TmlCntrVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.TmlVslInfoVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.VvdKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration.RussiaCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaBlInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCMCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCargoTotalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusCntrCargoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaCncusVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiaVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.RussiatransmitBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo.TransKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ContainerCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.RussiaManifestListDetailVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsChnSndLogVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;


/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Subin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RussiaCustomsTransmissionBCImpl  extends CustomsTransmissionBCImpl {
	
	// Database Access Object
	private transient RussiaCustomsTransmissionDBDAO dbDao = null;
	
	/**
	 * ChinaCustomsTransmissionBCImpl 객체 생성<br>
	 * ChinaCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public RussiaCustomsTransmissionBCImpl() {
		dbDao = new RussiaCustomsTransmissionDBDAO();
	}	

	/**
	 * 세관 테이블의 Customer, Container, Commodity(CM) 등의 BL 정보를 조회한다
	 * 
	 * @param BlInfoCondVO blInfoCondVO 
	 * @return BlInfoVO
	 * @exception EventException
	 */
//	public BlInfoVO searchBlInfo(BlInfoCondVO blInfoCondVO) throws EventException {
//		try{
//			// 파라메터 변환
//			ChinaBlInfoCondVO condVO = (ChinaBlInfoCondVO)blInfoCondVO;
//			// 리턴 VO
//			ChinaBlInfoVO blInfoVO = new ChinaBlInfoVO();
//			
//			String blNo 	 = condVO.getBlNo();
//			String transMode = condVO.getTransMode();
//			
//			ChinaBlGeneralListVO 	      chinaBlGeneralListVO     = dbDao.searchBlGeneral(blNo, transMode);
//			List<ChinaBlCustListVO>       chinaBlCustListVOs       = dbDao.searchBlCust(blNo, transMode);
//			List<ChinaBlCntrListVO> 	  chinaBlCntrListVOs 	   = dbDao.searchBlCntr(blNo, transMode);
//			List<ChinaBlDangerCntrListVO> chinaBlDangerCntrListVOs = dbDao.searchBlDangerCntr(blNo, transMode);
//			
//			if(chinaBlGeneralListVO != null) blInfoVO.setChinaBlGeneralListVO(chinaBlGeneralListVO);
//			if(chinaBlCustListVOs.size() > 0) blInfoVO.setChinaBlCustListVO(chinaBlCustListVOs.get(0));
//			blInfoVO.setChinaBlCntrListVOs(chinaBlCntrListVOs);
//			blInfoVO.setChinaBlDangerCntrListVOs(chinaBlDangerCntrListVOs);
//			
//			return (BlInfoVO)blInfoVO;
//			
//        } catch (DAOException de) {
//            log.error("err " + de.toString(), de);
//            throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
//        } catch (Exception e) {
//            log.error("err " + e.toString(), e);
//            throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
//        }
//	}




	/**
	 * 중국 세관 신고를 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO 
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest ( ManifestTransmitVO manifestTransmitVO , SignOnUserAccount account) throws EventException {

		try {
			RussiaCustomsTransmissionBackEndJob russiaBackEndJob = new RussiaCustomsTransmissionBackEndJob();
			russiaBackEndJob.setManifestTransmitVO(manifestTransmitVO, account, dbDao);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String sFlatFile = backEndJobManager.execute(russiaBackEndJob, account.getUsr_id(), "Russia Manifest Transmission");
			return sFlatFile;

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * FlatFile을 CargoDown
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestCargoDown ( ManifestTransmitVO manifestTransmitVO) throws EventException {

		FlatFileAckVO flatFileAckVO = null;		
		RussiaManifestTransmitVO russiaManifestTranmitVO = null;
		RussiaManifestListDetailVO[] russiaManifestListDetailVOs = null;
		String modeType = null;
		String vvd 		= null;
		String pol		= null;
		String polYdcd	= null;
		String pod		= null;
		String podYdcd	= null;
		
		
		// FlatFile 데이터 조회 - 조건 VO
		List<TransKeyVO> transKeyVOs = new ArrayList<TransKeyVO>();
		TransKeyVO transKeyVO = null;
		// FlatFile 저장 버퍼	
		String strFlatFile = null;
		StringBuffer flatFile = new StringBuffer();
		
		try {
			
			russiaManifestTranmitVO  = (RussiaManifestTransmitVO) manifestTransmitVO;
			russiaManifestListDetailVOs 	= russiaManifestTranmitVO.getRussiaManifestListDetailVOs();
			transKeyVO				= russiaManifestTranmitVO.getTransKeyVO();
	
			modeType 	= transKeyVO.getModeType();
			vvd 		= transKeyVO.getVvdCd();
			pol			= transKeyVO.getPolCd();
			polYdcd		= transKeyVO.getPolYdCd();
			pod			= transKeyVO.getPodCd();
			podYdcd		= transKeyVO.getPodYdCd();
			
			// IN 절에 들어갈 bl_no 문자열 담은 VO 리스트 생성
			List<String> blNoList = generateBlNoList(russiaManifestListDetailVOs);
			
			if(blNoList != null){			
				for ( int g=0; g < blNoList.size(); g++ ) {
					transKeyVO = new TransKeyVO();
					transKeyVO.setVvdCd(vvd);
					transKeyVO.setModeType(modeType);
					transKeyVO.setPolCd(pol);
					transKeyVO.setPodCd(pod);
					transKeyVO.setBkgNo(blNoList.get(g));					
					transKeyVOs.add(transKeyVO);
				}				
			} // if

			strFlatFile = makeFlatFileCargoDown(transKeyVOs, transKeyVO);
			flatFile.append(strFlatFile);
			return flatFile.toString();
			
		}
		catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		}

	}

	/**
	 * FlatFile을 생성하여 리턴한다.
	 * 
	 * @param List<TransKeyVO> transKeyVOs 
	 * @param String pol 
	 * @return String
	 * @exception EventException
	 */
	private String makeFlatFileCargoDown( List<TransKeyVO> transKeyVOs, TransKeyVO transKeyVO ) throws EventException {

		// FlatFile 데이터 조회 - 리턴 VO
		RussiaVslInfoVO russiaVslInfoVO = null;
		RussiaCncusVvdVO russiaCncusVvdVO = null;
		                         
		String modeType = null;  
		String vvd 		= null;  
		String polYdcd	= null;  
		String pod		= null;  
		String podYdcd	= null;  
		String blNo = null;
		float totalPckQty = 0;
		float totalActWgt = 0;
		float totalTareWgt = 0;
		
	try {
			modeType 	= transKeyVO.getModeType();       
			vvd 		= transKeyVO.getVvdCd();          
			polYdcd		= transKeyVO.getPolYdCd();        
			pod			= transKeyVO.getPodCd();          
			podYdcd		= transKeyVO.getPodYdCd();        
	
			StringBuffer flatFile = new StringBuffer();

			// 1.VSL/VVD정보 가져오기
			russiaVslInfoVO = dbDao.searchVslInfo ( transKeyVO );
			russiaCncusVvdVO = dbDao.searchCncusVvd ( transKeyVO );

			if ( russiaCncusVvdVO != null) {
				flatFile.append("I. HEADER OF THE FILE:")		.append("\n");
				flatFile.append("Name of carrier:")				.append(russiaCncusVvdVO.getCrrNm()).append("\n");
				flatFile.append("Name of vessel:")				.append(russiaCncusVvdVO.getVslfullname()).append("\n");
				flatFile.append("Voyage number:")		  	    .append(russiaCncusVvdVO.getVslvoy()+russiaCncusVvdVO.getVsldir()).append("\n");
				flatFile.append("Call sign:")					.append(russiaCncusVvdVO.getVslcd()).append("\n");
				flatFile.append("Nationality of the vessel:")	.append(russiaVslInfoVO.getNationNm()).append("\n");
				flatFile.append("Port of Loading:")				.append(russiaCncusVvdVO.getPolname()).append("\n");
				flatFile.append("Port of Discharge:")			.append(russiaCncusVvdVO.getPodname()).append("\n");
				flatFile.append("Date of departure:")			.append(russiaCncusVvdVO.getPolEtd()).append("\n");
				flatFile.append("Name of carrier Agent:")		.append(russiaCncusVvdVO.getCrrNm()).append("\n");
			}
			
			/*==============================================================*/
			/* BL 별 flatFile 데이터 생성										*/
			/*==============================================================*/
			List<RussiatransmitBlListVO> russiatransmitBlListVOs = dbDao.searchRussiaBl(transKeyVOs , transKeyVO );
			
			if(russiatransmitBlListVOs.size() > 0){
				
				
				flatFile.append("\n");
				flatFile.append("II. B/L, Container data:")		.append("\n");

				for ( int j=0; j < russiatransmitBlListVOs.size(); j++ ) {
//					
					blNo = russiatransmitBlListVOs.get(j).getBkgNo();

					totalActWgt += Float.parseFloat(russiatransmitBlListVOs.get(j).getActWgt());
					
					/*********************************/
					/** Flat File 생성 - B/L	Body 	**/
					/*********************************/
					flatFile.append("B/L NUMBER:")  .append(russiatransmitBlListVOs.get(j).getBkgNo()).append("\n");                     
					flatFile.append("S):")	    	.append(russiatransmitBlListVOs.get(j).getSCustNm()).append("\n").append(russiatransmitBlListVOs.get(j).getSCustAddr()).append("\n");
					flatFile.append("C):")	    	.append(russiatransmitBlListVOs.get(j).getCCustNm()).append("\n").append(russiatransmitBlListVOs.get(j).getCCustAddr()).append("\n");
					flatFile.append("N):")	    	.append(russiatransmitBlListVOs.get(j).getNCustNm()).append("\n").append(russiatransmitBlListVOs.get(j).getNCustAddr()).append("\n");
						
					/********************************/
					/** Flat File 생성 - Container **/
					/********************************/
					List<RussiaCncusCntrCargoVO> russiaCncusCntrVOs = dbDao.searchCncusCntrCargo ( blNo );
					String multiCntrSealNo = null;
					
					if(russiaCncusCntrVOs.size() > 0) {
						for ( int k=0; k < russiaCncusCntrVOs.size(); k++ ) {

							multiCntrSealNo = russiaCncusCntrVOs.get(k).getCntrSealNo().replace("@", ",");
							totalPckQty += Float.parseFloat(russiaCncusCntrVOs.get(k).getPckQty());
							totalTareWgt += Float.parseFloat(russiaCncusCntrVOs.get(k).getTareWgt()); //모든 CNTR 
							
							flatFile.append("CONTAINER NUMBER/SEAL NUMBER:") .append(russiaCncusCntrVOs.get(k).getCntrNo()).append("/").append(multiCntrSealNo).append("\n");
							flatFile.append("DESCRIPTION OF GOODS:")    	 .append(russiaCncusCntrVOs.get(k).getPckCmdtDesc()).append("\n").append(russiaCncusCntrVOs.get(k).getCntrCmdtDesc()).append("\n").append(russiaCncusCntrVOs.get(k).getCntrMfGdsDesc()).append("\n");
							flatFile.append("NUMBER OF PACKAGES:")	     	 .append(russiaCncusCntrVOs.get(k).getPckQty()).append("  ").append(russiaCncusCntrVOs.get(k).getPckNm()).append("\n");
							flatFile.append("GROSS WEIGHT OF THE CARGO:")	 .append(russiatransmitBlListVOs.get(j).getActWgt()).append("  ").append(russiatransmitBlListVOs.get(j).getMeasQty()).append("  ").append(russiaCncusCntrVOs.get(k).getTareWgt()).append("\n");
						}
					}
						
				} // for end
			} // if end
			
			
			/*==============================================================*/
			/* SUMMARY INFORMATION*/
			/*==============================================================*/
			List<RussiaCargoTotalVO> cargototal = dbDao.searchCargoTotal(transKeyVOs , transKeyVO );

			if(cargototal.size() > 0){
				flatFile.append("\n");
				flatFile.append("III. SUMMARY INFORMATION")	.append("\n");
				flatFile.append("B/L")						.append("\n");
				flatFile.append("B/L-Simple:")				.append(cargototal.get(0).getSimpleCnt()).append("\n");
				flatFile.append("B/L-Console:")				.append(cargototal.get(0).getConsoleCnt()).append("\n");
				flatFile.append("B/L-Empty:")				.append(cargototal.get(0).getBlEmptyCnt()).append("\n");
				flatFile.append("Total Number of B/L:")		.append(cargototal.get(0).getTotalBlCnt()).append("\n");
				flatFile.append("CONTAINER")				.append("\n");
				flatFile.append("Full-4HC:")				.append(cargototal.get(0).getHc4Cnt()).append("\n");
				flatFile.append("Full-20ST:")				.append(cargototal.get(0).getSt20Cnt()).append("\n");
				flatFile.append("Full-Total:")				.append(cargototal.get(0).getCntrFullCnt()).append("\n");
				flatFile.append("Cntr-Empty:")				.append(cargototal.get(0).getCntrEmptyCnt()).append("\n");
				flatFile.append("Total Number of Container:").append(cargototal.get(0).getTotalCntrCnt()).append("\n");				
				flatFile.append("Total Gross Weight:").append(totalActWgt).append("\n");
				flatFile.append("Total number of Packages:").append(totalPckQty).append("\n");
				flatFile.append("Total Tare Weight:").append(totalTareWgt).append("\n");
			}
				
			return flatFile.toString();
		}
		catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), e);
		}
	}
	
    /**
     *  IN 절에 들어갈 BL_NO 문자열로 생성
     *  IN 절에 데이터가 1000건 이상이면 ORA-1795 오류 발생하므로
     *  1000건씩 컴마로 연결된 문자열을 생성하여 넘긴다.
     *  
	 * @param ChinaBlInfoListVO[] blInfoVOs 
	 * @return List<String>
	 * @exception EventException
     */
	@SuppressWarnings("unchecked")
	private List<String> generateBlNoList(RussiaManifestListDetailVO[] russiaManifestListDetailVOs) throws EventException {
		try{
			List<String> arrString = new ArrayList();  //BKG_NO
			StringBuffer sb = new StringBuffer();
			int bkgCnt = russiaManifestListDetailVOs.length;
			int quotaCnt = bkgCnt / 1000;
			int restCnt = bkgCnt % 1000;
			
			for (int i=1; i<=quotaCnt; i++) {
				sb.delete(0, sb.length());
				for (int j=i*1000-1000; j<i*1000; j++) {	
					if(j == i*1000-1000){
						sb.append("'").append(russiaManifestListDetailVOs[j].getBkgNo()).append("'");
					}else{
						sb.append(",'").append(russiaManifestListDetailVOs[j].getBkgNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}
			
			if(restCnt > 0){
				sb.delete(0, sb.length());
				for (int i=quotaCnt*1000; i<bkgCnt; i++) {	
					if(i == quotaCnt*1000){
						sb.append("'").append(russiaManifestListDetailVOs[i].getBkgNo()).append("'");
					}else{
						sb.append(",'").append(russiaManifestListDetailVOs[i].getBkgNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}    
			
			return arrString;
		}
		catch (Exception e)	{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), e);
		}
	}



	/**
	 * 중국 Terminal 세관 신고를 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO 
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
//	public String transmitTmlManifest ( ManifestTransmitVO manifestTransmitVO , SignOnUserAccount account) throws EventException {
//		ChinaManifestTransmitVO chinaManifestTranmitVO = null;
//		ChinaBlInfoListVO[] chinaBlInfoListVOs = null;
//		String transMode = null;
//		String blType = null;
//		String vvd = null;
//		String pol = null;
//		
//		// FlatFile 데이터 조회 - 조건 VO
//		List<TransKeyVO> transKeyVOs = new ArrayList<TransKeyVO>();
//		TransKeyVO transKeyVO = null;
//		// FlatFile 저장 버퍼	
//		String strFlatFile = null;
//		
//		// BKG_NTC_HIS 로그 저장
//		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
//		BkgNtcHisVO bkgNtcHisVO = null;
//		String ediRefId = null;
//		String sndDate = null;
//		
//		try {
//			chinaManifestTranmitVO  = (ChinaManifestTransmitVO)manifestTransmitVO;
//			chinaBlInfoListVOs 		= chinaManifestTranmitVO.getChinaBlInfoListVOs();
//			transKeyVO				= chinaManifestTranmitVO.getTransKeyVO();
//			transMode 	= transKeyVO.getTransMode();
//			blType 		= transKeyVO.getBlType();
//			vvd			= transKeyVO.getVvd();
//			pol			= transKeyVO.getLocCd();
//			
//			// IN 절에 들어갈 bkg_no 문자열 담은 VO 리스트 생성
//			List<String> bkgNoList = generateBkgNoList(chinaBlInfoListVOs);
//			for ( int g=0; g < bkgNoList.size(); g++ ) {
//				transKeyVO = new TransKeyVO();
//				transKeyVO.setVvd(vvd);
//				transKeyVO.setTransMode(transMode);
//				transKeyVO.setMsgType(blType);
//				transKeyVO.setLocCd(pol);
//				transKeyVO.setBlNo(bkgNoList.get(g));
//				transKeyVO.setOfcCd(account.getOfc_cd());
//				transKeyVO.setUsrId(account.getUsr_id());
//				
//				transKeyVOs.add(transKeyVO);
//			}
//
//			strFlatFile = makeChinaManifestTransmitFlatFile(transKeyVOs, pol, blType);
//			
//			/*==============================================================*/
//			/* Queue 전송													*/
//			/*==============================================================*/
//			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
//			sendFlatFileVO.setFlatFile(strFlatFile);
//			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_VENDOR_301.IBMMQ.QUEUE"));
//			
//			FlatFileAckVO flatFileAckVO = new BookingUtil().sendFlatFile(sendFlatFileVO);
//			
//			if ( flatFileAckVO.getAckStsCd().equals("E") ) {
//				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
//			}
//			
//			/*===============================================================*/
//			/* BL 별 LOG 저장을 위한 VO 리스트                                    	 				 */
//			/*===============================================================*/
//			ediRefId = strFlatFile.substring(62, strFlatFile.indexOf("\n"));
//			sndDate = transKeyVOs.get(0).getSendDate();
//			
//			for(int i=0; i<chinaBlInfoListVOs.length; i++) { 
//				bkgNtcHisVO = new BkgNtcHisVO();
//				bkgNtcHisVO.setBkgNo(chinaBlInfoListVOs[i].getBkgNo());
//				bkgNtcHisVO.setSndDt(sndDate);
//				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
//				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
//				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
//				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
//				bkgNtcHisVO.setNtcViaCd("E");
//				bkgNtcHisVO.setNtcKndCd("TM");
//				bkgNtcHisVOs.add(bkgNtcHisVO);
//			}
//			
//			chinaManifestTranmitVO.setBkgNtcHisVOs(bkgNtcHisVOs);
//			chinaManifestTranmitVO.setEdiRefId(ediRefId);
//			
//			return strFlatFile;
//			
//		}
//		catch (EventException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw ex;
//		}
//		catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
//		}
//	}

	/**
	 * POL 지역 별 FlatFile을 생성하여 리턴한다.
	 * 
	 * @param List<TransKeyVO> transKeyVOs 
	 * @param String pol 
	 * @param String blType 
	 * @return String
	 * @exception EventException
	 */
//	private String makeRussiaManifestTransmitFlatFile( List<TransKeyVO> transKeyVOs, String pol, String blType ) throws EventException {
//
//		// FlatFile 데이터 조회 - 조건 VO
//		TransKeyVO transKeyVO = null;
//		
//		// FlatFile 데이터 조회 - 리턴 VO
//		TmlVslInfoVO tmlVslInfoVO = null;
//		BkgCstmsChnSndLogVO bkgCstmsChnSndLogVO = null;
//		//BkgCstmsChnSndLogBlVO bkgCstmsChnSndLogBlVO = null;
//
//		String vvd 			= null;
//		String transMode 	= null;
//		String msgType 		= null;
//		String ediRefId 	= null;
//		String ofcCd 		= null;
//		String usrId 		= null;
//		String blNo			= null;
//		String bkgNo		= null;
//		String sendDate		= null;
//		
//		try {
//			transKeyVO  = transKeyVOs.get(0);
//			vvd 		= transKeyVO.getVvd();
//			transMode 	= "T";
//			msgType 	= transKeyVO.getMsgType();
//			ofcCd	 	= transKeyVO.getOfcCd();
//			usrId	 	= transKeyVO.getUsrId();
//			
//			/*============================================================== */
//			/* Master Flat Buffer Creation					                 */
//			/*============================================================== */
//			/* Flat	File Header 및 VVD 정보	구성				             	 */
//			/*============================================================== */
//
//			// FlatFile Header를 생성한다.
//			BookingUtil command = new BookingUtil();
//			String header = command.searchCstmsEdiHeader("SMLM", pol, "DPBOLM");
//			StringBuffer flatFile = new StringBuffer();
//			flatFile.append(header).append("\n");
//			
//			ediRefId = header.substring(62);
//			
//			// 1.VSL/VVD정보 가져오기
//			tmlVslInfoVO = dbDao.searchTmlVslInfo ( vvd, blType );
//			transKeyVO.setSendDate(tmlVslInfoVO.getSndDt());
//			sendDate = tmlVslInfoVO.getSndDt();
//
//			if ( tmlVslInfoVO != null) {
//				flatFile.append("MSG_FUNC:")		.append(tmlVslInfoVO.getMsgType())		.append("\n");
//				flatFile.append("SENDDATE:")	    .append(tmlVslInfoVO.getSndDt())        .append("\n");
//				flatFile.append("REF_NO:")	    	.append(ediRefId)        				.append("\n");
//				flatFile.append("VSLCD:")		    .append(tmlVslInfoVO.getVslCd())        .append("\n");
//				flatFile.append("VSLVOY:")		    .append(tmlVslInfoVO.getVslVoy())       .append("\n");
//				flatFile.append("VSLDIR:")		    .append(tmlVslInfoVO.getVslDir())       .append("\n");
//				flatFile.append("CALLSIGN:")		.append(tmlVslInfoVO.getCallSign())     .append("\n");
//				flatFile.append("IMO_NO:")		    .append(tmlVslInfoVO.getImoNo())        .append("\n");
//				flatFile.append("VSLFULLNAME:")		.append(tmlVslInfoVO.getVslFullNm())	.append("\n");
//			}
//
//			/*==============================================================*/
//			/* BL 별 flatFile 데이터 생성										*/
//			/*==============================================================*/
//			List<TmlBlVO> tmlBlVOs = dbDao.searchTmlBlInfo ( transKeyVOs );
//			TmlBlVO tmlBlVO = null;
//			
//			if(tmlBlVOs.size() > 0){
//				
//				for ( int j=0; j < tmlBlVOs.size(); j++ ) {
//					tmlBlVO = tmlBlVOs.get(j);
//					blNo = tmlBlVO.getBlNo();
//					bkgNo = tmlBlVO.getBkgNo();
//
//					/*********************************/
//					/** Flat File 생성 - B/L	Body 	**/
//					/*********************************/
//					flatFile.append("{BL_INFO")			.append("\n");
//						flatFile.append("BL_NO:")		.append(tmlBlVO.getBlNo())    	.append("\n");                     
//						flatFile.append("BL_POL:")	    .append(tmlBlVO.getBlPol())    	.append("\n");
//						flatFile.append("BL_POL_NAME:") .append(tmlBlVO.getBlPolName()) .append("\n");
//						flatFile.append("BL_POD:")	    .append(tmlBlVO.getBlPod())    	.append("\n");
//						flatFile.append("BL_POD_NAME:")	.append(tmlBlVO.getBlPodName()) .append("\n");
//						flatFile.append("BL_DEL:")  	.append(tmlBlVO.getBlDel())    	.append("\n");
//						flatFile.append("BL_DEL_NAME:")	.append(tmlBlVO.getBlDelName()) .append("\n");
//						flatFile.append("SHPR:")	    .append(tmlBlVO.getShpr())    	.append("\n");
//						flatFile.append("CNEE:")		.append(tmlBlVO.getCnee())    	.append("\n");
//						flatFile.append("NTFY:")	    .append(tmlBlVO.getNtfy())    	.append("\n");
//						flatFile.append("CGO_DESC:")	.append(tmlBlVO.getCgoDesc())   .append("\n");
//				
//						
//						/********************************/
//						/** Flat File 생성 - Container **/
//						/********************************/
//						List<TmlCntrVO> tmlCntrVOs = dbDao.searchTmlCntrInfo ( bkgNo );
//						TmlCntrVO tmlCntrVO = null;
//						
//						if(tmlCntrVOs.size() > 0) {
//							for ( int k=0; k < tmlCntrVOs.size(); k++ ) {
//								tmlCntrVO = tmlCntrVOs.get(k);
//								
//								flatFile.append("{CNTR_INFO")     .append("\n");   
//									flatFile.append("CNTR_NO:")   .append(tmlCntrVO.getCntrNo())    .append("\n");
//									flatFile.append("CNTRTYPE:")  .append(tmlCntrVO.getCntrType())	.append("\n");
//									flatFile.append("NETWGT:")    .append(tmlCntrVO.getNetWgt())    .append("\n");
//								flatFile.append("}CNTR_INFO")     .append("\n");  
//							}
//						}
//
//						flatFile.append("}BL_INFO")			.append("\n");
//						
//				} // for end : tmlBlVOs
//			} // if end

			/*===============================================================*/
			/*                     VVD LOG 저장                                 					 */
			/*===============================================================*/
//			bkgCstmsChnSndLogVO = new BkgCstmsChnSndLogVO();
//			bkgCstmsChnSndLogVO.setEdiRefId(ediRefId);
//			bkgCstmsChnSndLogVO.setChnMfSndIndCd(transMode);
//			bkgCstmsChnSndLogVO.setMfSndDt(sendDate);
//			bkgCstmsChnSndLogVO.setMfSndOfcCd(ofcCd);
//			bkgCstmsChnSndLogVO.setMfSndUsrId(usrId);
//			bkgCstmsChnSndLogVO.setTrsmMsgTpId(msgType);
//			bkgCstmsChnSndLogVO.setVslCd(vvd);
//			bkgCstmsChnSndLogVO.setBkgPolCd(pol);
//			bkgCstmsChnSndLogVO.setCreUsrId(usrId);
//			bkgCstmsChnSndLogVO.setUpdUsrId(usrId);
//			dbDao.addSendLogVvd ( bkgCstmsChnSndLogVO, blNo );
//			
//			return flatFile.toString();
//		}
//		catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage(), ex);
//		}
//		catch (Exception e) {
//			log.error("err " + e.toString(), e);
//			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), e);
//		}
//	}

    
	/**
	 * 러시아 세관 신고를 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO 
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
//	public String transmitManifestRU ( ManifestTransmitVO manifestTransmitVO , SignOnUserAccount account) throws EventException {
//
//		try {
//			NewRussiaCustomsTransmissionBackEndJob russiaBackEndJob = new NewRussiaCustomsTransmissionBackEndJob();
//			russiaBackEndJob.setManifestTransmitVO(manifestTransmitVO, account, dbDao);
//			BackEndJobManager backEndJobManager = new BackEndJobManager();
//			String sFlatFile = backEndJobManager.execute(russiaBackEndJob, account.getUsr_id(), "Russia Manifest Transmission");
//
//			return sFlatFile;
//			
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
//		}
//	}

	/**
	 * Inbound Domestic T/S Manifest -
	 * 세관 테이블의 Customer, Container, Commodity(CM) 등의 대상목록 조회
	 *
	 * @param InboundTSInfoBLVO serchCondVO
	 * @return InboundTSInfoGRPVO
	 * @exception EventException
	 */
//	public InboundTSGRPVO searchInboundTSManifest(InboundTSInfoBLVO serchCondVO) throws EventException {
//		try {
//			String bkgNo = serchCondVO.getBkgNo();
//
//			List<InboundTSDownExcelVO> InboundTSDownExcelVOList = new ArrayList<InboundTSDownExcelVO>();
//			InboundTSDownExcelVO inboundTSDownExcelVO = null;
//
//			InboundTSInfoBLVO inboundTSInfoBLVO = dbDao.searchInboundTSInfoBL(bkgNo);
//			InboundTSInfoSKDVO inboundTSInfoSKDVO = dbDao.searchInboundTSInfoSKD(bkgNo);
//			InboundTSCustVO inboundTSCustVO = dbDao.searchInboundTSCust(bkgNo);
//			List<InboundTSCntrVO> inboundTSCntrVOList = dbDao.searchInboundTSCntrList(bkgNo);
//			InboundTSGRPVO inboundTSGRPVO = new InboundTSGRPVO();
//			inboundTSGRPVO.setInboundTSInfoBLVO(inboundTSInfoBLVO);
//			inboundTSGRPVO.setInboundTSInfoSKDVO(inboundTSInfoSKDVO);
//			inboundTSGRPVO.setInboundTSCustVO(inboundTSCustVO);
//			inboundTSGRPVO.setInboundTSCntrVOList(inboundTSCntrVOList);
//
//			List<InboundTSCntrVO> cloneTSCntrVOList = new ArrayList<InboundTSCntrVO>();
//			if (inboundTSCntrVOList.size() > 0) {
//				ObjectCloner.build(inboundTSCntrVOList, cloneTSCntrVOList);
//			} else {
//				// 비어있으면 임시vo 1개를 setting 
//				InboundTSCntrVO tempTSCntrVO = new InboundTSCntrVO();
//				cloneTSCntrVOList.add(tempTSCntrVO);
//			}
//
//			// DownExcel용 Sheet에 Loading할 Data setting
//			for (InboundTSCntrVO inboundTSCntrVO : cloneTSCntrVOList) {
//				inboundTSDownExcelVO = new InboundTSDownExcelVO();
//				if (inboundTSInfoBLVO != null) {
//					inboundTSDownExcelVO.setBkgNo("SMLM" + inboundTSInfoBLVO.getBkgNo().trim());
//					inboundTSDownExcelVO.setPorCd(inboundTSInfoBLVO.getPorCd());
//					inboundTSDownExcelVO.setPolCd(inboundTSInfoBLVO.getPolCd());
//					inboundTSDownExcelVO.setDelCd(inboundTSInfoBLVO.getDelCd().length() > 4 ? inboundTSInfoBLVO.getDelCd().substring(2) : "");
//					inboundTSDownExcelVO.setCmdtNm(inboundTSInfoBLVO.getCmdtNm());
//					inboundTSDownExcelVO.setPckQty(inboundTSInfoBLVO.getPckQty());
//					inboundTSDownExcelVO.setActWgt(inboundTSInfoBLVO.getActWgt());
//					inboundTSDownExcelVO.setMkDesc(inboundTSInfoBLVO.getMkDesc());
//					inboundTSDownExcelVO.setCmdtDesc(inboundTSInfoBLVO.getCmdtDesc());
//					inboundTSDownExcelVO.setMeasQty(inboundTSInfoBLVO.getMeasQty());
//				}
//
//				if (inboundTSInfoSKDVO != null) {
//					inboundTSDownExcelVO.setVpsEtaDt(inboundTSInfoSKDVO.getVpsEtaDt());
//					inboundTSDownExcelVO.setVpsPortCd(inboundTSInfoSKDVO.getVpsPortCd());
//					inboundTSDownExcelVO.setYdCd(inboundTSInfoSKDVO.getYdCd());
//					inboundTSDownExcelVO.setYdNm(inboundTSInfoSKDVO.getYdNm());
//					inboundTSDownExcelVO.setVslEngNm(inboundTSInfoSKDVO.getVslEngNm());
//				}
//
//				if (inboundTSCustVO != null) {
//					inboundTSDownExcelVO.setShpr(inboundTSCustVO.getShprNm().trim() + " " + inboundTSCustVO.getShprAddr().trim());
//					inboundTSDownExcelVO.setCnee(inboundTSCustVO.getCneeNm().trim() + " " + inboundTSCustVO.getCneeAddr().trim());
//					inboundTSDownExcelVO.setNtfy(inboundTSCustVO.getNtfyNm().trim() + " " + inboundTSCustVO.getNtfyAddr().trim());
//				}
//
//				inboundTSDownExcelVO.setCntrWgt(inboundTSCntrVO.getCntrWgt());
//				inboundTSDownExcelVO.setCntrNo(inboundTSCntrVO.getCntrNo());
//				inboundTSDownExcelVO.setCntrMeas(inboundTSCntrVO.getCntrMeas());
//
//				String hjsTpsz = inboundTSCntrVO.getCntrTpszCd();
//				String sipglTpsz = "";
//				if (hjsTpsz.length() > 1) {
//					if ("D2".equals(hjsTpsz)) {
//						sipglTpsz = "20GP";
//					} else if ("D4".equals(hjsTpsz)) {
//						sipglTpsz = "40GP";
//					} else if ("D5".equals(hjsTpsz)) {
//						sipglTpsz = "40HC";
//					} else if ("D7".equals(hjsTpsz)) {
//						sipglTpsz = "45HC";
//					} else if ("R2".equals(hjsTpsz)) {
//						sipglTpsz = "20RF";
//					} else if ("R5".equals(hjsTpsz)) {
//						sipglTpsz = "40RH";
//					} else if ("F2".equals(hjsTpsz)) {
//						sipglTpsz = "20FR";
//					} else if ("A4".equals(hjsTpsz) || "F4".equals(hjsTpsz) || "F5".equals(hjsTpsz)) {
//						sipglTpsz = "40FR";
//					} else if ("O2".equals(hjsTpsz) || "S2".equals(hjsTpsz)) {
//						sipglTpsz = "20OT";
//					} else if ("O4".equals(hjsTpsz)|| "O5".equals(hjsTpsz)) {
//						sipglTpsz = "40OT";
//					} else if ("T2".equals(hjsTpsz)) {
//						sipglTpsz = "20TK";
//					} else {
//						sipglTpsz = hjsTpsz;
//					}
//				} else {
//					sipglTpsz = hjsTpsz;
//				}
//				inboundTSDownExcelVO.setSipglCode(sipglTpsz);
//				inboundTSDownExcelVO.setCmdtHsCd(inboundTSCntrVO.getCmdtHsCd());
//				inboundTSDownExcelVO.setCntrSealNo(inboundTSCntrVO.getCntrSealNo());
//
//				InboundTSDownExcelVOList.add(inboundTSDownExcelVO);
//			}
//			inboundTSGRPVO.setInboundTSDownExcelVOList(InboundTSDownExcelVOList);			
//
//			return inboundTSGRPVO;
//
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
//		} catch (Exception e) {
//			log.error("err " + e.toString(), e);
//			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
//		}
//	}

}
