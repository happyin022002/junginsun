/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionBCImpl.java
*@FileTitle : BDR_Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.11 김영출
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.10.29 신자영 [CHM-201006625-01] C/A Exemption 하드코딩 Case추가
* 2010.11.05 신자영 [CHM-201006646-01] C/A Exemption 하드코딩 Case추가건(2)
* 2010.11.16 김영철 [] 메소드 이름은 소문자로 시작한다. (search3thPtyOfcCdCng())
* 2011.03.10 정선용 [CHM-201109321-01] LBP로 인한 C/A 자동면제 요청
* 2011.04.19 이일민 [CHM-201110115] C/A 자동면제 리스트 추가
* 2011.04.26 이일민 [CHM-201110449] DVC C/A 면제조건 추가
* 2011.07.07 이일민 [CHM-201111747] C/A Exemption 항목에 VDT 추가
* 2012.10.15 조정민 [CHM-201111747] Split 01-C/A 항목 추가 요청
* 2012.11.26 조정민 [CHM-201221404] [C/A Exemption] DPS 서차지 변경시 C/A 면제 (POD=NG or GH)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration.BDRCorrectionDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaChargeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaGeneralVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaInfoByBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaListByBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaRsnRmkVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CorrReplanVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CurCaUsrVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCorrectionVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;

/**
 * NIS2010-BookingCorrection Business Logic Basic Command implementation<br>
 * - NIS2010-BookingCorrection에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Youngchul
 * @see BDR_CorrectionEventResponse,BDRCorrectionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class BDRCorrectionBCImpl extends BasicCommandSupport implements BDRCorrectionBC {

	// Database Access Object
	private transient BDRCorrectionDBDAO dbDao = null;

	/**
	 * BDRCorrectionBCImpl 객체 생성<br>
	 * BDRCorrectionDBDAO를 생성한다.<br>
	 */
	public BDRCorrectionBCImpl() {
		dbDao = new BDRCorrectionDBDAO();
	}    
	
    /**
     * 1) C/A Issue Reason 시, C/A Temp History를 생성<br>
     * 2) C/A complete 시, C/A History를 생성<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  String tempHistCd
     * @param  BkgCorrectionVO bkgCorrectionVO
     * @param  SignOnUserAccount account
     * @return BkgBlNoVO 
     * @exception EventException
     */
    public BkgBlNoVO createTempHist(BkgBlNoVO bkgBlNoVO, String tempHistCd, BkgCorrectionVO bkgCorrectionVO, SignOnUserAccount account) throws EventException {
    	BookingUtil bookingUtil = new BookingUtil();    	
    	    	
    	try 
    	{
    		//01.
    		String strBdrFlg = bookingUtil.searchBdrFlgByBkg(bkgBlNoVO);
    		bkgBlNoVO.setBdrFlg(strBdrFlg); 
//    		if ("N".equals(strBdrFlg)) {
//    			throw new EventException((String)new ErrorHandler("BKG01026").getMessage());  
//    		}
    		   		
    		//02.
    		if ("T".equals(tempHistCd)) 
    		{
    			CurCaUsrVO curCaUsr = dbDao.searchCurCaUsr(bkgBlNoVO);
    			if(curCaUsr != null && !"".equals(curCaUsr.getCorrUsrId())) {
        			throw new EventException((String)new ErrorHandler("BKG00562", new String[]{bkgBlNoVO.getBkgNo(), curCaUsr.getCorrUsrId(), curCaUsr.getCorrOfcCd(), curCaUsr.getCorrDt()}).getMessage());
    			}
    			
    			bkgBlNoVO.setCaNo("TMP0000001");    			
    			BkgCorrectionVO tBkgCorrectionVO = new BkgCorrectionVO();
    			tBkgCorrectionVO.setBkgNo     (bkgBlNoVO.getBkgNo());
    			tBkgCorrectionVO.setCorrNo    (bkgBlNoVO.getCaNo());
    			tBkgCorrectionVO.setCaRsnCd   (bkgCorrectionVO.getCaRsnCd());
    			tBkgCorrectionVO.setBkgCorrRmk(bkgCorrectionVO.getBkgCorrRmk());
    			tBkgCorrectionVO.setRdnNo     (bkgCorrectionVO.getRdnNo());
    			tBkgCorrectionVO.setRvisSeq   (bkgCorrectionVO.getRvisSeq());
    			tBkgCorrectionVO.setRdnAcptFlg(bkgCorrectionVO.getRdnAcptFlg());
    			tBkgCorrectionVO.setUmchSubTpCd(bkgCorrectionVO.getUmchSubTpCd());
    			tBkgCorrectionVO.setCorrOfcCd (account.getOfc_cd());
    			tBkgCorrectionVO.setCorrUsrId (account.getUsr_id());
    			tBkgCorrectionVO.setCreUsrId  (account.getUsr_id());
    			tBkgCorrectionVO.setUpdUsrId  (account.getUsr_id());
    			dbDao.addBkgCorrection(tBkgCorrectionVO);
    		} 
    		else if ("H".equals(tempHistCd)) 
    		{
    			BkgReferenceNoGenerationVO tmpBkgReferenceNoGenerationVO = bookingUtil.manageBkgReferenceNumberGeneration("C/A", account.getOfc_cd(), account.getUsr_id());
    			bkgBlNoVO.setCaNo(tmpBkgReferenceNoGenerationVO.getCaNo());
    			
    			dbDao.copyBkgCorrection(bkgBlNoVO, account);
    		}    		
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	
		return bkgBlNoVO;
    }

    /**
     * 1) c/a 완료후 변경된 data를 비교하여 kind를 계산하여 저장한다.<br>
     * 2) 이 기준으로 실적을 산출하며 exempt 여부를 판단한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void modifyCngItemFlag(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
    	try 
    	{
    		//01. 
   			CurCaUsrVO curCaUsr = dbDao.searchCurCaUsr(bkgBlNoVO);
    		if (curCaUsr != null && !account.getUsr_id().equals(curCaUsr.getCorrUsrId())) {
    			throw new EventException((String)new ErrorHandler("BKG00562", new String[]{bkgBlNoVO.getBkgNo(), curCaUsr.getCorrUsrId(), curCaUsr.getCorrOfcCd(), curCaUsr.getCorrDt()}).getMessage());
    		}
    		
    		/************************************    		
    		/**** 사용않함: oracle package의 function 에서 flag값 모두 조회해 오도록 위와같이 변경함.     		
    		//02. 
    		BkgCorrectionVO bkgCorrectionVO = dbDao.searchCngItemFlag(bkgBlNoVO);  
    		
    		//03. 
    		dbDao.modifyBkgCorrection(bkgCorrectionVO, account);
    		*****/ 

    		BookingUtil util = new BookingUtil();
    		String bkgOfcCd = util.searchBkgOfcByBkg(bkgBlNoVO);
    		
    		//************************************
            //oracle package의 function 에서 flag값 모두 조회해 오도록 위와같이 변경함. -> 원복 
    		//02. 
    		BkgCorrectionVO bkgCorrectionVO = dbDao.searchBkgCorrection(bkgBlNoVO);  
    		
    		//03. 
    		BkgCorrectionVO tempBkgCorrectionVO = dbDao.searchBkgCng(bkgCorrectionVO); 
    		String strRoutCorrFlg    = tempBkgCorrectionVO.getRoutCorrFlg();
    		String strCntrMfModiFlg  = tempBkgCorrectionVO.getRcvdeTermCorrFlg();
    		String strTrnkVslCorrFlg = tempBkgCorrectionVO.getTrnkVslCorrFlg();
    		String strCmdtCorrFlg    = tempBkgCorrectionVO.getCmdtCorrFlg();
    		String strMeasQtyCorrFlg = tempBkgCorrectionVO.getMeasQtyCorrFlg();
    		String strChgTermCorrFlg = tempBkgCorrectionVO.getChgTermCorrFlg();    		
    		String strRatFlg = tempBkgCorrectionVO.getRatFlg();  
    		String strExpnFlg = tempBkgCorrectionVO.getExpnFlg();

    		//04. 
//    		tempBkgCorrectionVO = dbDao.searchCustCng(bkgCorrectionVO);
    		String strCustCorrFlg = tempBkgCorrectionVO.getCustCorrFlg();
    		
    		//05. 
//    		tempBkgCorrectionVO = dbDao.searchRateCng(bkgCorrectionVO);
    		String strRtCorrFlg = tempBkgCorrectionVO.getRtCorrFlg();
    		
    		//06. 
//    		tempBkgCorrectionVO = dbDao.searchQtyCng(bkgCorrectionVO);
    		String strQtyCorrFlg = tempBkgCorrectionVO.getQtyCorrFlg();
    		
    		//07. 
//    		tempBkgCorrectionVO = dbDao.searchVvdCng(bkgCorrectionVO);
    		String strPrpstVslCorrFlg = tempBkgCorrectionVO.getPrpstVslCorrFlg();
  		
    		if ( !"Y".equals(strRoutCorrFlg)    && 
    			 !"Y".equals(strCntrMfModiFlg)  && 
    			 !"Y".equals(strTrnkVslCorrFlg) && 
    			 !"Y".equals(strCmdtCorrFlg)    && 
    			 !"Y".equals(strMeasQtyCorrFlg) && 
    			 !"Y".equals(strChgTermCorrFlg) && 
    			 !"Y".equals(strCustCorrFlg)    && 
    			 !"Y".equals(strRtCorrFlg)      && 
    			 !"Y".equals(strQtyCorrFlg)     && 
    			 !"Y".equals(strPrpstVslCorrFlg) ) 
    		{
    			bkgCorrectionVO.setCaOtrRsnCorrFlg("Y");
    		} else {
        		bkgCorrectionVO.setRoutCorrFlg    (strRoutCorrFlg);
        		bkgCorrectionVO.setCntrMfModiFlg  (strCntrMfModiFlg);
        		bkgCorrectionVO.setTrnkVslCorrFlg (strTrnkVslCorrFlg);
        		bkgCorrectionVO.setCmdtCorrFlg    (strCmdtCorrFlg);
        		bkgCorrectionVO.setMeasQtyCorrFlg (strMeasQtyCorrFlg); 
        		bkgCorrectionVO.setChgTermCorrFlg (strChgTermCorrFlg);    
        		bkgCorrectionVO.setCustCorrFlg    (strCustCorrFlg);
        		bkgCorrectionVO.setRtCorrFlg      (strRtCorrFlg);
        		bkgCorrectionVO.setQtyCorrFlg     (strQtyCorrFlg);
        		bkgCorrectionVO.setPrpstVslCorrFlg(strPrpstVslCorrFlg);
    		}
    		
    		bkgCorrectionVO.setRatFlg(strRatFlg);
    		bkgCorrectionVO.setExpnFlg(strExpnFlg);

    		//[CHM-201538173] C/A reason D 선택시 C/A auto exemption 
    		if(bkgCorrectionVO.getCaRsnCd()!=null && "D".equals(bkgCorrectionVO.getCaRsnCd())){
    			bkgCorrectionVO.setDocPerfExptCd("1");
    		}
    		//CA OFC가 AARBA이고 POD가 DK->DE로 바뀐 케이스면 CA Reason A 및 면제처리 로직 추가
    		//arrPod[0] => CA 전 POD
    		//arrPod[1] => CA 후 POD
			String arrPod[] = new String[2];
			arrPod = dbDao.searchPod(bkgBlNoVO);
			if("DK".equalsIgnoreCase(arrPod[0].substring(0, 2)) 
					&& "DE".equalsIgnoreCase(arrPod[1].substring(0, 2))
					&& "AARBA".equalsIgnoreCase(account.getOfc_cd())){
				bkgCorrectionVO.setDocPerfExptCd("1");
				bkgCorrectionVO.setCaRsnCd("A");
			}
    		
    		//08. 
    		boolean bOftChn = dbDao.searchOftChn(bkgBlNoVO);
    		if (bOftChn) {
    			dbDao.modifyBkgCorrection(bkgCorrectionVO, account);
    		} else {    			
    			if (dbDao.searchWgtMeasCng(bkgBlNoVO)) {
    				bkgCorrectionVO.setDocPerfExptCd("W");
    			} else if (dbDao.searchTrnkCngWhenPreVslExist(bkgBlNoVO)) {
    				bkgCorrectionVO.setDocPerfExptCd("T");
    			} else if (dbDao.searchPstVslCng(bkgBlNoVO)) {
    				bkgCorrectionVO.setDocPerfExptCd("P");    				
    			} else if (dbDao.searchVslSkip(bkgBlNoVO)) {
    				bkgCorrectionVO.setDocPerfExptCd("D");
    			} else if (dbDao.searchCltPayerCng(bkgBlNoVO)) {
    				bkgCorrectionVO.setDocPerfExptCd("3");
    			} else if (dbDao.searchPayTermCng(bkgBlNoVO)) {
    				bkgCorrectionVO.setDocPerfExptCd("A");
    			} else if (dbDao.searchDihCng(bkgBlNoVO)) {
    				bkgCorrectionVO.setDocPerfExptCd("B");
    			} else if (dbDao.searchCneeCdCng(bkgBlNoVO)) {
    				bkgCorrectionVO.setDocPerfExptCd("N");
    			} else if (dbDao.search3thPtyOfcCdCng(bkgBlNoVO)) {
    				bkgCorrectionVO.setDocPerfExptCd("3");
    			} 
    			else {
    				List<String> addChargeList = dbDao.searchAddCharge   (bkgBlNoVO);     				
    				List<String> modChargeList = dbDao.searchModifyCharge(bkgBlNoVO);
    				List<String> delChargeList = dbDao.searchDelCharge   (bkgBlNoVO);
    				
    				boolean bExistAdd = false;
    				boolean bExistDel = false;
    				if (delChargeList != null) {
	    				for(int i=0; i<delChargeList.size(); i++) {
	    					String strTemp = delChargeList.get(i);
	    					if ("CUC".equals(strTemp)) {
	    						bExistDel = true;
	    						break;
	    					}else{
	    						if("DIH".equals(strTemp)&& curCaUsr!=null && curCaUsr.getCorrOfcCd()!=null && "HAMSC".equals(curCaUsr.getCorrOfcCd())){
	    							// TRO confirm 되었는 지 확인	    							
	    							BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
	    							bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
	    							bkgDocProcSkdVO.setBkgDocProcTpCd("TROCFM");
	    							bkgDocProcSkdVO.setDocPerfDeltFlg("N");
	    							bkgDocProcSkdVO = util.searchDocProcSkd(bkgDocProcSkdVO, "N");
	    							if(bkgDocProcSkdVO != null && bkgCorrectionVO != null){
	    								bkgCorrectionVO.setCaRsnCd("R");
	    								bExistDel = true;
	    								break;
	    							}
	    						} 
		    				}
	    				}
    				}
    				if (bExistDel) {
    					bkgCorrectionVO.setDocPerfExptCd("2");
    				} else {
    					bExistAdd = false;
    					if (addChargeList != null) {
	        				for(int i=0; i<addChargeList.size(); i++) {
	        					String strTemp = addChargeList.get(i);
	        					if ( "OBS".equals(strTemp) ||  
	        						 "MCF".equals(strTemp) || 
	        						 "CUC".equals(strTemp) || 
	        						 "DVC".equals(strTemp) || 
	        						 "DIV".equals(strTemp) || 
	        						 "BCC".equals(strTemp) || 
	        						 "DMR".equals(strTemp) || 
	        						 "CFC".equals(strTemp) || 
	        						 "MSC".equals(strTemp) || 
	        						 "DOD".equals(strTemp) || 
	        						 "NSC".equals(strTemp) || 
	        						 "WHC".equals(strTemp) ||
	        						 "LBP".equals(strTemp) ||
	        						 "CTC".equals(strTemp) ||
	        						 "BLR".equals(strTemp) ||
	        						 "DOF".equals(strTemp)) 
	        					{
	        						bExistAdd = true;
	        						break;
	        					}
	        				}
    					}
        				if (bExistAdd) {
        					bkgCorrectionVO.setDocPerfExptCd("1");
        				} else {
//        					String strPodDel = dbDao.searchPodDel(bkgBlNoVO);
//        					String strPod = strPodDel.substring(0, 2);
//        					String strDel = strPodDel.substring(6, 10);
//        					log.debug("^^^^^^^^^strPodDel,strPod,strDel->"+strPodDel+", "+strPod+", "+strDel);
        					
                            BkgRouteVO bkgRouteVO = new BkgRouteVO();
                            BookingUtil bookingUtil = new BookingUtil();
                            bkgRouteVO = bookingUtil.searchBkgRoute(bkgBlNoVO.getBkgNo());
                            String strPolCnt = bkgRouteVO.getPolCd().substring(0, 2);
                            String strPod = bkgRouteVO.getPodCd();
                            String strPodCnt = bkgRouteVO.getPodCd().substring(0, 2);
                            String strDel = bkgRouteVO.getDelCd();
        					
        					boolean bExistCUD = false;
        					if (addChargeList != null) {
        						//기존 C/A Exemption List에 VDT(Vietnam DHF vat Tax) 추가하는 건입니다.
        						//단, OBS(Original B/L Surrender)시에만 exemption 될 수 있도록 부탁드립니다.
        						boolean bExistObs = dbDao.searchObsChg(bkgBlNoVO);
	            				for(int i=0; i<addChargeList.size(); i++) {
	            					String strTemp = addChargeList.get(i);
	            					if ( "IN".equals(strPodCnt) && 
	            					     ("GST".equals(strTemp) || "DTH".equals(strTemp) || "CLN".equals(strTemp)) ) 
	            					{
	            						if ( "GST".equals(strTemp) ) {
	            							bkgCorrectionVO.setDocPerfExptCd("G");
                						} else if ( "DTH".equals(strTemp) || "CLN".equals(strTemp)) {
	            							bkgCorrectionVO.setDocPerfExptCd("H");
                						}
	            						bExistCUD = true;
	            						break;
	            					}
                                    if ( ("NG".equals(strPodCnt) || "GH".equals(strPodCnt))
                                    		&& "DPS".equals(strTemp)) {
                                    	bkgCorrectionVO.setDocPerfExptCd("H");
	            						bExistCUD = true;
	            						break;
                                    }
                                    if ( "IN".equals(strPolCnt) && "OTH".equals(strTemp)) {
                                        bkgCorrectionVO.setDocPerfExptCd("O");
	            						bExistCUD = true;
	            						break;
                                    }
                                    if ( bExistObs && "VDT".equals(strTemp)) {
                                        bkgCorrectionVO.setDocPerfExptCd("1");
	            						bExistCUD = true;
	            						break;
                                    }
                                    if ( "CTC".equals(strTemp)) {
                                        bkgCorrectionVO.setDocPerfExptCd("1");
	            						bExistCUD = true;
	            						break;
                                    }
                                    if ( "BLR".equals(strTemp)) {
                                        bkgCorrectionVO.setDocPerfExptCd("1");
	            						bExistCUD = true;
	            						break;
                                    }
                                    if ( "DOF".equals(strTemp)) {
                                        bkgCorrectionVO.setDocPerfExptCd("1");
	            						bExistCUD = true;
	            						break;
                                    }
                                    if("DHF".equals(strTemp)
                                    		&& ("WRPSC".equals(bkgOfcCd) || "WRPSO".equals(bkgOfcCd) || "GDYSC".equals(bkgOfcCd))){
                                        bkgCorrectionVO.setDocPerfExptCd("C");
	            						bExistCUD = true;
	            						break;
                                    }
                                    //[CHM-201433426] C/A 자동 면제 로직 추가 요청 : GAP S/C 에 한해
                                    if("DIH".equals(strTemp)
                                    		&& ("WRPSC".equals(curCaUsr.getCorrOfcCd()) || "WRPSO".equals(curCaUsr.getCorrOfcCd()) || "GDYSC".equals(curCaUsr.getCorrOfcCd()) || "HANSO".equals(curCaUsr.getCorrOfcCd())
                                    				)){
                                    	String scNo = dbDao.searchScNo(bkgBlNoVO);
                                    	if(scNo != null && scNo.equals("GLO020110")){
                                    		 bkgCorrectionVO.setDocPerfExptCd("1");
     	            						//bExistCUD = true;
     	            						break;
                                    	}
                                    }
	            				}
        					}
            				if (!bExistCUD) {
            					if (modChargeList != null) {
	                				for(int i=0; i<modChargeList.size(); i++) {
	                					String strTemp = modChargeList.get(i);
	                					if ( "IN".equals(strPodCnt) && 
	                					     ("GST".equals(strTemp) || "DTH".equals(strTemp) || "CLN".equals(strTemp)) ) 
	                					{
	                						if ( "GST".equals(strTemp) ) {
    	            							bkgCorrectionVO.setDocPerfExptCd("G");
                    						} else if ( "DTH".equals(strTemp) || "CLN".equals(strTemp)) {
    	            							bkgCorrectionVO.setDocPerfExptCd("H");
                    						}
	                						bExistCUD = true;
	                						break;
	                					}
	                                    if ( ("NG".equals(strPodCnt) || "GH".equals(strPodCnt))
	                                    		&& "DPS".equals(strTemp)) {
	                                    	bkgCorrectionVO.setDocPerfExptCd("H");
		            						bExistCUD = true;
		            						break;
	                                    }
	                					if ( "IN".equals(account.getOfc_cd().substring(0, 2)) &&
	                						 "CLN".equals(strTemp)) {
	                						bkgCorrectionVO.setDocPerfExptCd("H");
	                						bExistCUD = true;
	                						break;
	                					}
                                        if ( "IN".equals(strPolCnt) && "OTH".equals(strTemp)) {
                                            bkgCorrectionVO.setDocPerfExptCd("O");
                                            bExistCUD = true;
                                            break;
                                        }
                                        if ("BCC".equals(strTemp) || "LBP".equals(strTemp)
                                        		||"CTC".equals(strTemp)||"BLR".equals(strTemp)) {
                                            bkgCorrectionVO.setDocPerfExptCd("1");
                                            bExistCUD = true;
                                            break;
                                        }
                                        if("DHF".equals(strTemp)
                                        		&& "WRPSC".equals(bkgOfcCd)){
                                            bkgCorrectionVO.setDocPerfExptCd("C");
    	            						bExistCUD = true;
    	            						break;
                                        }
	                				}
            					}
                				if (!bExistCUD) {
                					if (delChargeList != null) {
	                    				for(int i=0; i<delChargeList.size(); i++) {
	                    					String strTemp = delChargeList.get(i);
	                    					if ( "IN".equals(strPodCnt) && 
	                    					     ("GST".equals(strTemp) || "DTH".equals(strTemp) || "CLN".equals(strTemp)) ) 
	                    					{
	                    						if ( "GST".equals(strTemp) ) {
	    	            							bkgCorrectionVO.setDocPerfExptCd("G");
	                    						} else if ( "DTH".equals(strTemp) || "CLN".equals(strTemp)) {
	    	            							bkgCorrectionVO.setDocPerfExptCd("H");
	                    						}
	                    						bExistCUD = true;
	                    						break;
	                    					}
	                                        if ( ("NG".equals(strPodCnt) || "GH".equals(strPodCnt))
	                                        		&& "DPS".equals(strTemp)) {
	                                        	bkgCorrectionVO.setDocPerfExptCd("H");
	    	            						bExistCUD = true;
	    	            						break;
	                                        }
	                                        if ( "IN".equals(strPolCnt) && "OTH".equals(strTemp)) {
	                                            bkgCorrectionVO.setDocPerfExptCd("O");
	                                            bExistCUD = true;
	                                            break;
	                                        }
	                                        if ("CTC".equals(strTemp)) {
	                                            bkgCorrectionVO.setDocPerfExptCd("1");
	                                            bExistCUD = true;
	                                            break;
	                                        }
	                                        if ("BLR".equals(strTemp)) {
	                                            bkgCorrectionVO.setDocPerfExptCd("1");
	                                            bExistCUD = true;
	                                            break;
	                                        }
	                    				}
                					}
                    				if (!bExistCUD) {
                    					if (delChargeList != null) {
	                        				for(int i=0; i<delChargeList.size(); i++) {
	                        					String strTemp = delChargeList.get(i);
	                        					if ( "DHF".equals(strTemp) && 
	                        					     ("GBBEL".equals(strPod) && "GBBEL".equals(strDel)) ) 
	                        					{
	                        						bkgCorrectionVO.setDocPerfExptCd("C");
	                        						bExistCUD = true;
	                        						break;
	                        					}
	                        				}
                    					}
                    					if (!bExistCUD) {
                    						String chnFlg = dbDao.checkPrnHdnFlg(bkgBlNoVO);
                    						if(chnFlg.equals("Y")){
                    							bkgCorrectionVO.setDocPerfExptCd("1");
                    							bExistCUD = true;                     							
                    						}
                    						if (!bExistCUD) {
                    							chnFlg = dbDao.checkMkAndCmdtDesc(bkgBlNoVO);
                    							if(chnFlg.equals("Y")){
                    								bkgCorrectionVO.setDocPerfExptCd("1");
                    								bExistCUD = true; 
                    							}
                    						}                    						
                    					}                    					
                    				}
                				}
            				}
        				}
    				}
    			}
    			
    			//09. 
    			dbDao.modifyBkgCorrection(bkgCorrectionVO, account);
    		}    		
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * C/A를 진행중인 user가 c/a를 중지한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void cancelCA(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {    	
    	    	
    	try 
    	{
    		//01.
   			CurCaUsrVO curCaUsr = dbDao.searchCurCaUsr(bkgBlNoVO);
    		if (curCaUsr != null && !account.getUsr_id().equals(curCaUsr.getCorrUsrId())) {
    			throw new EventException((String)new ErrorHandler("BKG00562", new String[]{bkgBlNoVO.getBkgNo(), curCaUsr.getCorrUsrId(), curCaUsr.getCorrOfcCd(), curCaUsr.getCorrDt()}).getMessage());
    		}
    		
/* : C/A Cancel시에 TMP0000001를 correction No 체번하여 BKG_CORRECTION TABLE에 ADD하지 않고 그대로 삭제되도록 변경함. 
    		//02. 
    		bkgBlNoVO.setCaNo("TMP0000001");    		
    		//03. 
    		BkgCorrectionVO bkgCorrectionVO = dbDao.searchBkgCorrection(bkgBlNoVO);    		
    		//04. 
    		BkgReferenceNoGenerationVO tmpBkgReferenceNoGenerationVO = bookingUtilBC.manageBkgReferenceNumberGeneration("C/A", account.getOfc_cd(), account.getUsr_id());			
			//05. 
			bkgCorrectionVO.setCorrNo(tmpBkgReferenceNoGenerationVO.getCaNo());
			dbDao.addBkgCorrection(bkgCorrectionVO);
*/ 
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * C/A 중지/완료이므로 해당 C/A의 temp table을 삭제한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @exception EventException
     */
    public void removeCATemp(BkgBlNoVO bkgBlNoVO) throws EventException { 
    	try {
    		BkgBlNoVO removeBkgBlNo = new BkgBlNoVO();
    		removeBkgBlNo.setBkgNo(bkgBlNoVO.getBkgNo());
    		removeBkgBlNo.setCaNo("TMP0000001");
    		dbDao.removeBkgCorrection(removeBkgBlNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * CA Resaon/Remark 정보 수정한다.<br>
     * @author Lee NamKyung 
     * @param  String caIssReasonCd
     * @param  String caRemark
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  String RdnAcptFlg
     * @param  String umchSubTpCd
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void modifyCaReason(String caIssReasonCd, String caRemark, BkgBlNoVO bkgBlNoVO, String rdnAcptFlg, String umchSubTpCd, SignOnUserAccount account) throws EventException { 
    	try {
    		dbDao.modifyCaRsnRmk(caIssReasonCd, caRemark, bkgBlNoVO, rdnAcptFlg, umchSubTpCd, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * CA Resaon/Remark 정보 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @return CaRsnRmkVO 
     * @exception EventException
     */
    public CaRsnRmkVO searchCaRsnRmk(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException { 
    	try {
    		//01. 다른 사람이 C/A 진행 중이면 그대로 중지
   			CurCaUsrVO curCaUsr = dbDao.searchCurCaUsr(bkgBlNoVO);
    		if (curCaUsr != null && !account.getUsr_id().equals(curCaUsr.getCorrUsrId())) {
    			throw new EventException((String)new ErrorHandler("BKG00562", new String[]{bkgBlNoVO.getBkgNo(), curCaUsr.getCorrUsrId(), curCaUsr.getCorrOfcCd(), curCaUsr.getCorrDt()}).getMessage());
    		} 
			
    		return dbDao.searchCaRsnRmk(bkgBlNoVO);
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * bkg별 기본 정보와 C/A 변경 list를 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return CaInfoByBkgVO 
     * @exception EventException
     */
    public CaInfoByBkgVO searchCaInfoByBkg(BkgBlNoVO bkgBlNoVO) throws EventException { 
    	try {
    		CaInfoByBkgVO caInfoByBkgVO = new CaInfoByBkgVO();
    		
    		CaBkgInfoVO         caBkgInfoVO    = dbDao.searchCaBkgInfo  (bkgBlNoVO); 
    		if (caBkgInfoVO != null) {
    			bkgBlNoVO.setBkgNo(caBkgInfoVO.getBkgNo());
    			bkgBlNoVO.setBlNo (caBkgInfoVO.getBlNo());
    			bkgBlNoVO.setCaNo (caBkgInfoVO.getCaNo());
    		}
    		List<CaListByBkgVO> caListByBkgVOs = dbDao.searchCaListByBkg(bkgBlNoVO); 
    		
    		caInfoByBkgVO.setCaBkgInfoVO   (caBkgInfoVO);
    		caInfoByBkgVO.setCaListByBkgVOs(caListByBkgVOs);
    	
    		return caInfoByBkgVO;
    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}	
    }

    /**
     *  C/A 변경 건 별 상세 정보를 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return CaDetailVO 
     * @exception EventException
     */
    public CaDetailVO searchCaDetail(BkgBlNoVO bkgBlNoVO) throws EventException { 
    	try {
    		CaDetailVO caDetailVO = new CaDetailVO();
    		
    		List<CaGeneralVO>   caGeneralVOs = dbDao.searchCaGeneral(bkgBlNoVO); 
    		List<CaChargeVO>    caChargeVOs  = dbDao.searchCaCharge (bkgBlNoVO); 
    		List<CaCustVO>      caCustVOs    = dbDao.searchCaCust   (bkgBlNoVO); 
    		
    		caDetailVO.setCaGeneralVOs(caGeneralVOs);
    		caDetailVO.setCaChargeVOs (caChargeVOs);
    		caDetailVO.setCaCustVOs   (caCustVOs);
    	
    		return caDetailVO;
    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}	
    }
    
    /**
     * c/a이력이 있는지 없는지 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @return String 
     * @exception EventException
     */
    public String add1stCaHist(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException { 
    	String strReturn = "";
    	
    	try {
    		strReturn = dbDao.search1stCaExist(bkgBlNoVO);    		    	
    		if ("N".equals(strReturn)) {
    			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
    			bkgCorrectionVO.setBkgNo    (bkgBlNoVO.getBkgNo());
    			bkgCorrectionVO.setCorrNo   ("0000000001");
    			bkgCorrectionVO.setCorrUsrId(account.getUsr_id());
    			bkgCorrectionVO.setCreUsrId (account.getUsr_id());
    			bkgCorrectionVO.setUpdUsrId (account.getUsr_id());
    			dbDao.addBkgCorrection(bkgCorrectionVO);
    		}
    		
    		return strReturn;
    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     * c/a 완료시 replan할 필요가 있는지 조회한다.<br>
     * @author Ryu Daeyoung
     * @param  BkgBlNoVO bkgBlNoVO
     * @return List<CorrReplanVO>
     * @exception EventException
     */ 
	public List<CorrReplanVO> searchCorrReplan(BkgBlNoVO bkgBlNoVO) throws EventException{
    	try {
    		return dbDao.searchCorrReplan(bkgBlNoVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}	
	}
	
    /**
     * combine/split/cod의 경우 auto c/a temp data를 생성한다..<br>
     * @author Ryu Daeyoung
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  modeCd
     * @param  BkgCorrectionVO bkgCorrectionVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */ 
	public void addAutoCaTemp(BkgBlNoVO bkgBlNoVO, String modeCd, BkgCorrectionVO bkgCorrectionVO, SignOnUserAccount account) throws EventException{
    	try {
    		CurCaUsrVO curCaUsr = dbDao.searchCurCaUsr(bkgBlNoVO);
			if(curCaUsr != null && !"".equals(curCaUsr.getCorrUsrId())) {
    			throw new EventException((String)new ErrorHandler("BKG00562", new String[]{bkgBlNoVO.getBkgNo(), curCaUsr.getCorrUsrId(), curCaUsr.getCorrOfcCd(), curCaUsr.getCorrDt()}).getMessage());
			}
			
			bkgCorrectionVO.setBkgNo     (bkgBlNoVO.getBkgNo());
			bkgCorrectionVO.setCorrNo    ("TMP0000001");
			
			if("COMBINE_MASTER".equals(modeCd)){
				bkgCorrectionVO.setBkgCmbModiFlg("Y");
				bkgCorrectionVO.setQtyCorrFlg("Y");
//				bkgCorrectionVO.setMeasQtyCorrFlg("Y");
			} else if("COMBINE_SOURCE".equals(modeCd)){
				bkgCorrectionVO.setBkgCmbModiFlg("Y");
				bkgCorrectionVO.setQtyCorrFlg("Y");
//				bkgCorrectionVO.setMeasQtyCorrFlg("Y");
				bkgCorrectionVO.setCxlModiFlg("Y");
			} else if("SPLIT_NEW".equals(modeCd)){
				bkgCorrectionVO.setBkgSplitModiFlg("Y");
				bkgCorrectionVO.setQtyCorrFlg("Y");
//				bkgCorrectionVO.setMeasQtyCorrFlg("Y");
				bkgCorrectionVO.setNewBkgCreFlg("Y");
			} else if("SPLIT_MASTER".equals(modeCd)){
				bkgCorrectionVO.setBkgSplitModiFlg("Y");
				bkgCorrectionVO.setQtyCorrFlg("Y");
//				bkgCorrectionVO.setMeasQtyCorrFlg("Y");
			} else if("CA_NEW".equals(modeCd)){
				bkgCorrectionVO.setNewBkgCreFlg("Y");
			}
			
			bkgCorrectionVO.setCorrOfcCd (account.getOfc_cd());
			bkgCorrectionVO.setCorrUsrId (account.getUsr_id());
			bkgCorrectionVO.setCreUsrId  (account.getUsr_id());
			bkgCorrectionVO.setUpdUsrId  (account.getUsr_id());
			dbDao.addBkgCorrection(bkgCorrectionVO); 
		} catch (EventException ex) {
			throw ex;			  		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}	
	}
	
	/**
	 * C/A Report (ESM_BKG_0568) Remark를 수정합니다.<br>
	 * 
	 * @param CaIssueDateInVO[] vos
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyCaIssueRemark(CaIssueDateInVO[] vos, SignOnUserAccount account) throws EventException {
		
		try {
			for (int i = 0; i < vos.length; i++) {
				if (vos[i].getIbflag().equals("U")) {

					vos[i].setUsrId(account.getUsr_id());
					dbDao.modifyCaIssueRemark(vos[i]);
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
     * CA 가 진행 중인지 확인한다.<br>
     * 
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @return boolean 
     * @exception EventException
     */
    public boolean checkCaProcessing(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException { 
    	try {
    		// 다른 사람이 C/A 진행 중이면 그대로 중지
   			CurCaUsrVO curCaUsr = dbDao.searchCurCaUsr(bkgBlNoVO);
    		if (curCaUsr != null && !account.getUsr_id().equals(curCaUsr.getCorrUsrId())) {
    			return false;
    		} 
			
    		return true;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
	
	/**
	 * Last Correction No를 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
     * @return BkgBlNoVO
	 * @throws EventException
	 */
	public BkgBlNoVO searchLstCorrNo(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchLstCorrNo(bkgBlNoVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	

	/**
	 * BKG Correction 을 삭제한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @throws EventException
	 */	
	public void removeCA(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			dbDao.removeBkgCorrection(bkgBlNoVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}		
	}
	
	 /**
     * 진행 중인 CA 정보를 조회한다.<br>
     * 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return BkgCorrectionVO 
     * @exception EventException
     */
	public BkgCorrectionVO searchBkgCorrection(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			BkgCorrectionVO bkgCorrectionVO = dbDao.searchBkgCorrection(bkgBlNoVO);
			if(bkgCorrectionVO.getCaRsnCd().equals("M")){
	    		BkgCorrectionVO tempBkgCorrectionVO = dbDao.searchBkgCng(bkgCorrectionVO); 
	    		bkgCorrectionVO.setRtCorrFlg(tempBkgCorrectionVO.getRtCorrFlg());
	    		bkgCorrectionVO.setChgTermCorrFlg(tempBkgCorrectionVO.getChgTermCorrFlg());
	    		bkgCorrectionVO.setRcvdeTermCorrFlg(tempBkgCorrectionVO.getRcvdeTermCorrFlg());
	    		bkgCorrectionVO.setRoutCorrFlg(tempBkgCorrectionVO.getRoutCorrFlg());
	    		bkgCorrectionVO.setCustCorrFlg(tempBkgCorrectionVO.getCustCorrFlg());
	    		bkgCorrectionVO.setQtyCorrFlg(tempBkgCorrectionVO.getQtyCorrFlg());
	    		bkgCorrectionVO.setMeasQtyCorrFlg(tempBkgCorrectionVO.getMeasQtyCorrFlg());
	    		bkgCorrectionVO.setCmdtCorrFlg(tempBkgCorrectionVO.getCmdtCorrFlg());  		
	    		bkgCorrectionVO.setTrnkVslCorrFlg(tempBkgCorrectionVO.getTrnkVslCorrFlg());
	    		bkgCorrectionVO.setPrpstVslCorrFlg(tempBkgCorrectionVO.getPrpstVslCorrFlg());
	    		bkgCorrectionVO.setRatFlg(tempBkgCorrectionVO.getRatFlg());
	    		bkgCorrectionVO.setExpnFlg(tempBkgCorrectionVO.getExpnFlg());
	    		
	    		if (!"Y".equals(tempBkgCorrectionVO.getRtCorrFlg())      	&& 
	    			!"Y".equals(tempBkgCorrectionVO.getChgTermCorrFlg()) 	&& 
	    			!"Y".equals(tempBkgCorrectionVO.getRcvdeTermCorrFlg())  && 
	       			!"Y".equals(tempBkgCorrectionVO.getRoutCorrFlg())    	&& 
	       			!"Y".equals(tempBkgCorrectionVO.getCustCorrFlg())    	&& 
	       			!"Y".equals(tempBkgCorrectionVO.getQtyCorrFlg())     	&& 
	       			!"Y".equals(tempBkgCorrectionVO.getMeasQtyCorrFlg()) 	&& 
	       			!"Y".equals(tempBkgCorrectionVO.getCmdtCorrFlg())    	&& 
	       			!"Y".equals(tempBkgCorrectionVO.getTrnkVslCorrFlg()) 	&& 
	       			!"Y".equals(tempBkgCorrectionVO.getPrpstVslCorrFlg())) 
	       		{
	       			bkgCorrectionVO.setCaOtrRsnCorrFlg("Y");
	       		} else {
	       			bkgCorrectionVO.setCaOtrRsnCorrFlg("N");
	       		}
			}
    		return bkgCorrectionVO; 
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}				
	}
}