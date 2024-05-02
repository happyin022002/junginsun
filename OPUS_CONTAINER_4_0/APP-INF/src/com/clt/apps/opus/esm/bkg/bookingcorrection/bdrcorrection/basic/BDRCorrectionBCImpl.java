/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BDRCorrectionBCImpl.java
 *@FileTitle : BDR_Correction
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration.BDRCorrectionDBDAO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaChargeVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaCustVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaDetailVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaGeneralVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaInfoByBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaListByBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaRsnRmkVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CorrReplanVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CurCaUsrVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCorrectionVO;

/**
 * OPUS-BookingCorrection Business Logic Basic Command implementation<br>
 * - OPUS-BookingCorrection handling business transaction.<br>
 *
 * @author
 * @see BDR_CorrectionEventResponse,BDRCorrectionBC
 * @since J2EE 1.4
 */

public class BDRCorrectionBCImpl extends BasicCommandSupport implements BDRCorrectionBC {

	// Database Access Object
	private transient BDRCorrectionDBDAO dbDao = null;

	/**
	 * BDRCorrectionBCImpl object creation.<br>
	 * BDRCorrectionDBDAO object creation.<br>
	 */
	public BDRCorrectionBCImpl() {
		dbDao = new BDRCorrectionDBDAO();
	}    
	
    /**
     * 1) create C/A Temp History when C/A Issue Reason<br>
     * 2) create C/A History when C/A complete<br>
     * 
     * @author  
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
    		if ("N".equals(strBdrFlg)) {
    			throw new EventException((String)new ErrorHandler("BKG01026").getMessage());  
    		}
    		   		
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
     * 1-1) complete C/A.<br>
     * 1-2) comparing change data and calculate kind.<br>
     * 1-3) save.<br>
     * 2) Judging exempt or not from this results.<br>
     
     * @author  
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
    		
	    		
    		//************************************
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
	        						 "BCC".equals(strTemp) || 
	        						 "DMR".equals(strTemp) || 
	        						 "CFC".equals(strTemp) || 
	        						 "MSC".equals(strTemp) || 
	        						 "DOD".equals(strTemp) || 
	        						 "NSC".equals(strTemp) || 
	        						 "WHC".equals(strTemp) ) 
	        					{
	        						bExistAdd = true;
	        						break;
	        					}
	        				}
    					}
        				if (bExistAdd) {
        					bkgCorrectionVO.setDocPerfExptCd("1");
        				} else {
        					String strPodDel = dbDao.searchPodDel(bkgBlNoVO);
        					String strPod = strPodDel.substring(0, 2);
        					String strDel = strPodDel.substring(6, 10);
        					log.debug("^^^^^^^^^strPodDel,strPod,strDel->"+strPodDel+", "+strPod+", "+strDel);
        					
        					
        					boolean bExistCUD = false;
        					if (addChargeList != null) {
	            				for(int i=0; i<addChargeList.size(); i++) {
	            					String strTemp = addChargeList.get(i);
	            					if ( "IN".equals(strPod) && 
	            					     ("GST".equals(strTemp) || "DTH".equals(strTemp)) ) 
	            					{
	            						if ( "GST".equals(strTemp) ) {
	            							bkgCorrectionVO.setDocPerfExptCd("G");
                						} else if ( "DTH".equals(strTemp) ) {
	            							bkgCorrectionVO.setDocPerfExptCd("H");
                						}
	            						bExistCUD = true;
	            						break;
	            					}
	            				}
        					}
            				if (!bExistCUD) {
            					if (modChargeList != null) {
	                				for(int i=0; i<modChargeList.size(); i++) {
	                					String strTemp = modChargeList.get(i);
	                					if ( "IN".equals(strPod) && 
	                					     ("GST".equals(strTemp) || "DTH".equals(strTemp)) ) 
	                					{
	                						if ( "GST".equals(strTemp) ) {
    	            							bkgCorrectionVO.setDocPerfExptCd("G");
                    						} else if ( "DTH".equals(strTemp) ) {
    	            							bkgCorrectionVO.setDocPerfExptCd("H");
                    						}
	                						bExistCUD = true;
	                						break;
	                					}
	                					if ( "IN".equals(account.getOfc_cd().substring(0, 2)) &&
	                						 "CLN".equals(strTemp)) {
	                						bkgCorrectionVO.setDocPerfExptCd("H");
	                						bExistCUD = true;
	                						break;
	                					}
	                				}
            					}
                				if (!bExistCUD) {
                					if (delChargeList != null) {
	                    				for(int i=0; i<delChargeList.size(); i++) {
	                    					String strTemp = delChargeList.get(i);
	                    					if ( "IN".equals(strPod) && 
	                    					     ("GST".equals(strTemp) || "DTH".equals(strTemp)) ) 
	                    					{
	                    						if ( "GST".equals(strTemp) ) {
	    	            							bkgCorrectionVO.setDocPerfExptCd("G");
	                    						} else if ( "DTH".equals(strTemp) ) {
	    	            							bkgCorrectionVO.setDocPerfExptCd("H");
	                    						}
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
     * cancel C/A by user of processing C/A.<br>
     * 
     * @author  
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
    		
/* : Delete TMP0000001 in case of C/A Cancel. 
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
     * delete temp table because C/A was Stop or Complete.<br>
     * 
     * @author  
     * @param  BkgBlNoVO bkgBlNoVO
     * @exception EventException
     */
    public void removeCATemp(BkgBlNoVO bkgBlNoVO) throws EventException { 
    	try {
    		dbDao.removeBkgCorrection(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * CA Resaon/Remark Info modify.<br>
     * 
     * @author  
     * @param  String caIssReasonCd
     * @param  String caRemark
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  String RdnAcptFlg
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void modifyCaReason(String caIssReasonCd, String caRemark, BkgBlNoVO bkgBlNoVO, String rdnAcptFlg, SignOnUserAccount account) throws EventException { 
    	try {
    		dbDao.modifyCaRsnRmk(caIssReasonCd, caRemark, bkgBlNoVO, rdnAcptFlg, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * CA Resaon/Remark Info retrieve.<br>
     * 
     * @author  
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @return CaRsnRmkVO 
     * @exception EventException
     */
    public CaRsnRmkVO searchCaRsnRmk(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException { 
    	try {
    		//01. stop when processing C/A by other
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
     * retrieving BKG Info and C/A change list.<br>
     * 
     * @author  
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
     * retrieving detail info by C/A change.<br>
     * 
     * @author  
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
     * checking C/A history.<br>
     * 
     * @author  
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
     * checking need to re-plan. when C/A had complete.<br>
     *  
     * @author 
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
     * create auto C/A temp data in case of combine/split/cod.<br>
     * 
     * @author 
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
	 * C/A Report (ESM_BKG_0568) Remark modify.<br>
	 * 
	 * @author
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
	
}