/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BLDocumentationBLBCImpl.java
 *@FileTitle : Container Information
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
*/

package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusXptImpLicListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;
import com.clt.apps.opus.esm.bkg.common.Constants;
import com.clt.apps.opus.esm.bkg.common.HblSeq;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration.BLDocumentationBLDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlStatusVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmGoodsDescVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.DGCargoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblForMndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblTmpltVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MfNoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MtyCntrCycVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MtyCntrStsVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.WgtPkgMeasVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgBlDocVO;
import com.clt.syscommon.common.table.BkgBlMkDescVO;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCoffTmVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgHblCustVO;
import com.clt.syscommon.common.table.BkgHblVO;
import com.clt.syscommon.common.table.BkgNvoccProfCntrMfVO;
import com.clt.syscommon.common.table.BkgNvoccProfVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmPckTpVO;

/**
 * OPUS-TerminalDocumentation Business Logic Basic Command implementation<br>
 * - OPUS-TerminalDocumentation handling business logic<br>
 * 
 * @author 
 * @see UI_BKG-0079-04EventResponse,BLDocumentationBLBC 
 * @since J2EE 1.4
 */

public class BLDocumentationBLBCImpl extends BasicCommandSupport implements BLDocumentationBLBC { 

    // Database Access Object
    private transient BLDocumentationBLDBDAO dbDao = null;

    /**
     * BLDocumentationBLBCImpl objects generate.<br>
     * BLDocumentationBLDBDAO is created.<br>
     */
    public BLDocumentationBLBCImpl() {
        dbDao = new BLDocumentationBLDBDAO();
    }
	/**
	 * BKG_CHG_RT BkgBooking Data Information is changed.<br>
	 * 
	 * @author 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String mcflag
	 * @param String caflag
	 */
	 public void modifyChgRateBkgBlDocMasterCovered(RateMainInfoVO rateMainInfoVO, String mcflag ,String caflag)throws EventException{  
	    try {
	    	 dbDao.modifyChgRateBkgBlDocMasterCovered(rateMainInfoVO, mcflag ,caflag);	    	 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	/**
	* EsmBkg0771Event save events<br>
	* Covered B/L of the Master B/L information is updated to Null<br>
	* @param String bkg_no
	* @param String master_bl_no
	* @param CoveredBlListVO[] coveredBlListVOs
	* @return String
	* @exception EventException
	*/
	public String manageCoveredBl(String bkg_no,String master_bl_no,CoveredBlListVO[] coveredBlListVOs) throws EventException{
		String r_message = "";
		
		try {
            log.debug("=============================================");
            log.debug(" [save]  manageCoveredBl");
            log.debug("=============================================");
			log.debug("[END:: BLDocumentationBLBCImpl == manageCoveredBl  ]==========");
			
			List<CoveredBlListVO> insertVoList = new ArrayList<CoveredBlListVO>();
			List<CoveredBlListVO> updateVoList = new ArrayList<CoveredBlListVO>();
			List<CoveredBlListVO> deletetVoList = new ArrayList<CoveredBlListVO>();
			String bl_no = null;
			
			for (int i = 0; i < coveredBlListVOs.length; i++) {
				//New bl_no
				bl_no = coveredBlListVOs[i].getBlNo();
								
				if (coveredBlListVOs[i].getIbflag().equals("U")) {
					//update  the existing  bl_no, a null value
					coveredBlListVOs[i].setBlCvrdTpCd("");
					coveredBlListVOs[i].setMstCvrdBlNo("");
					coveredBlListVOs[i].setBlNo(coveredBlListVOs[i].getOldBlNo());
					updateVoList.add(coveredBlListVOs[i]);
					
					coveredBlListVOs[i].setIbflag("I");
					coveredBlListVOs[i].setBlNo(bl_no);
				}

				 if (coveredBlListVOs[i].getIbflag().equals("I")) {
					//user input bl_no  = master bl_no  update
					coveredBlListVOs[i].setBlCvrdTpCd("C");
					coveredBlListVOs[i].setMstCvrdBlNo(master_bl_no);					
					insertVoList.add(coveredBlListVOs[i]);
				}
				 
				 if (coveredBlListVOs[i].getIbflag().equals("D")) {			
					coveredBlListVOs[i].setBlCvrdTpCd("");
					coveredBlListVOs[i].setMstCvrdBlNo("");
					coveredBlListVOs[i].setBlNo(coveredBlListVOs[i].getBlNo());
					deletetVoList.add(coveredBlListVOs[i]);
				}
			}
			int db_cnt = 0;
			if (updateVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(updateVoList);
			}
			if (insertVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(insertVoList);
			}
			if (deletetVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(deletetVoList);
			}
			log.debug("* db_cnt : " + db_cnt);

		}catch (DAOException de) 
		{
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} 
		catch (Exception ex) 
		{
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
		log.debug("[END::]==========");
		return r_message; 
	}
		
	/**
	 * 'BkgBooking Data' in the 'BKG_CHG_RT'  is modified<br>
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 */
	 public void modifyChgRateBkgBlDoc(RateMainInfoVO rateMainInfoVO, String caflag)throws EventException{  
	    try {
	    	 dbDao.modifyChgRateBkgBlDoc(rateMainInfoVO,caflag);	    	 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	 /**
     * EsmBkg007909Event Saving events<br>
     * 
     *  'bl issue'  to process <br>
     * @author
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
    public void manageBlIssueFlg(BlIssInfoVO blIssInfoVO) throws EventException{
        try {
            dbDao.manageBlIssueFlg(blIssInfoVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    /**
     * B/L Doc to change the information. -- UI_BKG-0079-09, BKG B/L ISSUE.
     * 
     * @author 
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
	public void modifyBlIssInfoForBlDoc(BlIssInfoVO blIssInfoVO) throws EventException{
        try {
            dbDao.modifyBlIssInfoForBlDoc(blIssInfoVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	
    /**
     * retrieving mark & description .
     * 
     * @param bkgBlNoVO
     * @return MndVO
     * @exception EventException
     */
    public MndVO searchMnd(BkgBlNoVO bkgBlNoVO) throws EventException {
        MndVO mndVO = null;
        try {
            mndVO = dbDao.searchMnd(bkgBlNoVO);
          //2015.03.23 bl_remark로 이동됨            
//            String porCd = mndVO.getPorCd();
//            String polCd = mndVO.getPolCd();
//            String podCd = mndVO.getPodCd();
//            String delCd = mndVO.getDelCd();
//            String cmdtDesc = mndVO.getDgCmdtDesc();

//            if(podCd !=null && podCd.length()> 2 && "BR".equals(podCd.substring(0, 2))){
//                mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_BR, ""));
//            }
//            if(podCd !=null && podCd.length()> 2 && ("UY".equals(podCd.substring(0, 2)) || "AR".equals(podCd.substring(0, 2)))){
//                mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_UY, ""));
//            }
//            if((porCd !=null && porCd.length()> 2 && "MX".equals(porCd.substring(0, 2))) ||
//               (polCd !=null && polCd.length()> 2 && "MX".equals(polCd.substring(0, 2))) ||
//               (podCd !=null && podCd.length()> 2 && "MX".equals(podCd.substring(0, 2))) ||
//               (delCd !=null && delCd.length()> 2 && "MX".equals(delCd.substring(0, 2)))){
//                mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace((cmdtDesc.endsWith(Constants.CMDT_DESC_ATTD_MX)? Constants.CMDT_DESC_ATTD_MX : Constants.CMDT_DESC_ATTD_MX.substring(2)), ""));
//            }
//            if((delCd !=null && !"GTPRQ".equals(delCd.substring(0, 2))) &&
//               (porCd !=null && porCd.length()> 2 && "GT".equals(porCd.substring(0, 2))) ||
//               (polCd !=null && polCd.length()> 2 && "GT".equals(polCd.substring(0, 2))) ||
//               (podCd !=null && podCd.length()> 2 && "GT".equals(podCd.substring(0, 2))) ||
//               (delCd !=null && delCd.length()> 2 && "GT".equals(delCd.substring(0, 2)))){
//                mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_GT, ""));
//            }
//            if((podCd !=null && podCd.length()> 2 && "GR".equals(podCd.substring(0,2))) ||
//               (delCd !=null && delCd.length()> 2 && "GR".equals(delCd.substring(0,2)))){
//            	   mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_GR, ""));
//            }
//            if((podCd !=null && podCd.length()> 2 && "EG".equals(podCd.substring(0,2))) ||
//               (delCd !=null && delCd.length()> 2 && "EG".equals(delCd.substring(0,2)))){
//            		mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_EG, ""));
//            }
            
			// PO No of the Mandatory Item Check
            String rPoOtherMdtItm = dbDao.searchPoMdtItm(bkgBlNoVO);
//            log.debug("rPoOtherMdtItm>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+rPoOtherMdtItm);
//            bkgBlNoVO.setO_PoOtherMdtItmVO(rPoOtherMdtItm);
            mndVO.setRPoOtherMdtItm(rPoOtherMdtItm);
            
            String bkgRefTpCd = dbDao.searchBkgRefTpCd(rPoOtherMdtItm, bkgBlNoVO.getBkgNo());
//            log.debug("bkgRefTpCd>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+bkgRefTpCd);
            mndVO.setBkgRefTpMlCd(bkgRefTpCd);
            
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return mndVO;
    }

    /**
     * mark & description -> storage validation
     * 
     * @param mndVO
     * @exception EventException
     */
    public void validateMnd(MndVO mndVO) throws EventException {
    	BookingUtil utilCmd = new BookingUtil();
        try {
        	if (mndVO.getPckTpCd() != null && ! "".equals(mndVO.getPckTpCd().trim())) {
	            MdmPckTpVO pckTpVO = utilCmd.searchPkgType(mndVO.getPckTpCd());
	            if(pckTpVO == null || pckTpVO.getPckCd() == null) {
	                throw new EventException(new ErrorHandler("BKG00530", new String[]{mndVO.getPckTpCd()}).getMessage());
	            }
        	}
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * MND will correct the information.-- UI_BKG-0079-06
     * Integrated with the eBooking Sea NACCS
     * 
     * @param mndVO
     * @param account
     * @param caFlg
     * @exception EventException
     */
    public void manageMnd(MndVO mndVO, SignOnUserAccount account, String caFlg) throws EventException {
        /* bkgBlDocVO */
        BkgBlDocVO bkgBlDocVO = new BkgBlDocVO();
        bkgBlDocVO.setBkgNo(mndVO.getBkgNo());
        bkgBlDocVO.setTtlPckDesc(mndVO.getTtlPckDesc());
        bkgBlDocVO.setCstmsDesc(mndVO.getCstmsDesc());
        bkgBlDocVO.setPckCmdtDesc(mndVO.getPckCmdtDesc());
        bkgBlDocVO.setCntrCmdtDesc(mndVO.getCntrCmdtDesc());
        bkgBlDocVO.setPckQty(mndVO.getPckQty());
        bkgBlDocVO.setPckTpCd(mndVO.getPckTpCd());
        bkgBlDocVO.setMeasQty(mndVO.getMeasQty());
        bkgBlDocVO.setMeasUtCd(mndVO.getMeasUtCd());
        bkgBlDocVO.setActWgt(mndVO.getActWgt());
        bkgBlDocVO.setWgtUtCd(mndVO.getWgtUtCd());
        bkgBlDocVO.setActWgtPrnFlg(mndVO.getActWgtPrnFlg());
        bkgBlDocVO.setCreUsrId(account.getUsr_id());
        bkgBlDocVO.setUpdUsrId(account.getUsr_id());

//        String porCd = mndVO.getPorCd();
//        String polCd = mndVO.getPolCd();
//        String podCd = mndVO.getPodCd();
//        String delCd = mndVO.getDelCd();
        //String cmdtDesc = WordWarp.wrap(mndVO.getDgCmdtDesc(), 49);
        //String mkDesc = WordWarp.wrap(mndVO.getMkDesc(), 23);
        String cmdtDesc = mndVO.getDgCmdtDesc();
        String mkDesc = mndVO.getMkDesc();

        /* bkgBlMkDescVO */
        BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
        blMkDescVO.setBkgNo(mndVO.getBkgNo());
        blMkDescVO.setMkDesc(mkDesc);
        blMkDescVO.setCmdtDesc(cmdtDesc);
        blMkDescVO.setMkSeq("1");
        blMkDescVO.setCreUsrId(account.getUsr_id());
        blMkDescVO.setUpdUsrId(account.getUsr_id());
        log.debug("\n//////////////////////////////////////////////////\n"+cmdtDesc+"\n//////////////////////////////////////////////////");
//		2015.03.23. bl_remark로 변경됨.
//        /* update on 2009/12/07 */
//        if(podCd !=null && podCd.length()> 2 && "BR".equals(podCd.substring(0, 2))){
//            blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_BR); 
//        }
//        if(podCd !=null && podCd.length()> 2 && ("UY".equals(podCd.substring(0, 2)) || "AR".equals(podCd.substring(0, 2)))){
//            blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_UY);
//        }
//        if((porCd !=null && porCd.length()> 2 && "MX".equals(porCd.substring(0, 2))) ||
//           (polCd !=null && polCd.length()> 2 && "MX".equals(polCd.substring(0, 2))) ||
//           (podCd !=null && podCd.length()> 2 && "MX".equals(podCd.substring(0, 2))) ||
//           (delCd !=null && delCd.length()> 2 && "MX".equals(delCd.substring(0, 2)))){
////            if(cmdtDesc != null && cmdtDesc.length() > 12){
////                StringBuffer buf = new StringBuffer();
////                String[] arr = cmdtDesc.split("\\r\\n");
////                log.debug("# line count : " + (arr.length));
////                if(arr.length > 9){
////                    for(int i=0;i<arr.length;i++){
////                        if(i==9){
////                            buf.append(Constants.CMDT_DESC_ATTD_MX.substring(2));
////                        }
////                        buf.append(arr[i]);
////                        buf.append("\r\n");
////                    }
////                    blMkDescVO.setCmdtDesc(buf.toString());
////                }else{
////                    blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_MX);
////                }
////            }else{
//                blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_MX);
////            }
//        }
//        if((delCd !=null && delCd.length() >= 5 && !"GTPRQ".equals(delCd.substring(0, 2))) &&
//           (porCd !=null && porCd.length() >= 2 && "GT".equals(porCd.substring(0, 2))) ||
//           (polCd !=null && polCd.length() >= 2 && "GT".equals(polCd.substring(0, 2))) ||
//           (podCd !=null && podCd.length() >= 2 && "GT".equals(podCd.substring(0, 2))) ||
//           (delCd !=null && delCd.length() >= 2 && "GT".equals(delCd.substring(0, 2)))){
//            blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_GT);
//        }
//        
//        if((podCd !=null && podCd.length() >= 2 && "GR".equals(podCd.substring(0,2))) ||
//           (delCd !=null && delCd.length() >= 2 && "GR".equals(delCd.substring(0,2)))){
//        	blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_GR);
//        }
//        if((podCd !=null && podCd.length() >= 2 && "EG".equals(podCd.substring(0,2))) ||
//           (delCd !=null && delCd.length() >= 2 && "EG".equals(delCd.substring(0,2)))){
//        	blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_EG);
//        }
                
//        log.debug("\n//////////////////////////////////////////////////\n"+blMkDescVO.getCmdtDesc()+"\n//////////////////////////////////////////////////");
        
        try {
            dbDao.modifyBl(bkgBlDocVO, caFlg);
            //dbDao.manageMnd(blMkDescVO);
            if(dbDao.modifyMnd(blMkDescVO, caFlg) == 0){
                dbDao.addMnd(blMkDescVO, caFlg);
            }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * dangerous cargo  retrieve.
     * @param bkgNo
     * @return List<DGCargoVO>
     * @exception EventException
     */
    public List<DGCargoVO> searchDG(String bkgNo) throws EventException {
        try {
            return dbDao.searchDG(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Package Type code check handling (ESM_BKG_0361_01~06)
     * 
     * @author 
     * @param XptImpLicVO[] xptImpLicVOs
     * @exception EventException
     */
    public void validateExportImportNumber(XptImpLicVO[] xptImpLicVOs) throws EventException {
        BookingUtil utilCmd = new BookingUtil();
        boolean flag = false;
        try {
            // 1. BookingUtil::validatePkgType ( pkgTpCd )
//            log.debug(" * PckTpCd : " + xptImpLicVOs.getPckTpCd());
        	for (int i=0; i < xptImpLicVOs.length; i++) {
        		if (!"D".equals(xptImpLicVOs[i].getIbflag())) {
		            flag = utilCmd.validatePkgType(xptImpLicVOs[i].getPckTpCd());
		            if(!flag) {
		                throw new EventException(new ErrorHandler("BKG01050", new String[]{"Package Type"}).getMessage());
		            }
        		}
        	}

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Export / Import Information search by country (ESM_BKG_0361_01~06)
     * 
     * @author 
     * @param xptImpLicIn
     * @param caFlg
     * @return List<XptImpLicVO>
     * @exception EventException
     */
    public List<XptImpLicVO> searchExportImportNumber(XptImpLicInVO xptImpLicIn, String caFlg) throws EventException {
        try {
            return dbDao.searchExportImportNumber(xptImpLicIn, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Export / Import Information input by country  (ESM_BKG_0361_01~06)
     * 
     * @author 
     * @param xptImpLicVOs
     * @param cntCd
     * @param caFlg
     * @exception EventException
     */
    public void createExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String cntCd, String caFlg) throws EventException {

        try {

            if(xptImpLicVOs.size() > 0) {
                dbDao.createExportImportNumber(xptImpLicVOs, cntCd, caFlg);
            }

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Export / Import Information update by country  (ESM_BKG_0361_01~06)
     * 
     * @author 
     * @param xptImpLicVOs
     * @param cntCd
     * @param caFlg
     * @exception EventException
     */
    public void modifyExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String cntCd, String caFlg) throws EventException {

        try {

            if(xptImpLicVOs.size() > 0) {
                dbDao.modifyExportImportNumber(xptImpLicVOs, cntCd, caFlg);
            }

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Export / Import Information delete by country(ESM_BKG_0361_01~06)
     * 
     * @author 
     * @param List<XptImpLicVO> xptImpLicVOs
     * @param caFlg
     * @exception EventException
     */
    public void removeExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String caFlg) throws EventException {

        try {

            if(xptImpLicVOs.size() > 0) {
                dbDao.removeExportImportNumber(xptImpLicVOs, caFlg);
            }

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * split-> new booking (b / l, cntr, c / m) to set the information.<br>
     * 1. copyBkgBlDocByBkg () will copy bkg_bl_doc table by running, value(pkg, wgt, meas modify)<br>
     * 2. copyMndByBkg () will copy bkg_bl_mk_desc table by running.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param SplitBkgVO splitBkgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyBlDocByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SplitBkgVO splitBkgVO, SignOnUserAccount account) throws EventException {
        try {
            // new Bkg Split
            for(int i = 0; i < targetBkg.length; i++) {
                if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                    // bkg_bl_doc a copy of the table  ('weight', 'package', 'measure' is changed to splitBlInfoVO related properties)
                    dbDao.copyBkgBlDocByBkg(sourceBkg, targetBkg[i], splitBkgVO.getSplitBlInfoVO().get(i), account);
                    // bkg_bl_mk_desc a copy of the table
                    dbDao.copyMndByBkg(sourceBkg, targetBkg[i], account);
                    // bkg_xpt_imp_lic a copy of the table
                    dbDao.copyExportImportNumberByBkg(sourceBkg, targetBkg[i], account);
                }
                if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")
                    && sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())) {
                    dbDao.modifyBkgBlDocAfterSplit(sourceBkg, splitBkgVO.getSplitBlInfoVO().get(0), account);
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * bkg_hbl table sourceBkg -> targetBkg be copied to<br>
     *  cntr_mf_no-> Copy as ORG_CNTR_MF_NO.<br>
     * 
     * @param String copyModeCd
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectCntrVO> selectCntrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyHblByBkg(String copyModeCd, BkgBlNoVO sourceBkg,BkgBlNoVO[] targetBkg, List<SelectCntrVO> selectCntrVO, SignOnUserAccount account) throws EventException {
        try {
            // new Bkg Split
            for(int i = 0; i < targetBkg.length; i++) {
                // selectCntrVO Loop
                if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                        // bkg_hbl table sourceBkg -> targetBkg as copy
                        dbDao.copyHblByBkg(sourceBkg, targetBkg[i], copyModeCd, account);
                        // bkg_hbl_cust table sourceBkg -> targetBkg as copy
                        dbDao.copyHblCustByBkg(sourceBkg, targetBkg[i], account);
                }

            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * retrieve Container Manifest -- UI_BKG-0707
     * 
     * @param bkgNo
     * @return CmGoodsDescVO
     * @exception EventException
     */   
    public CmGoodsDescVO searchGoodsDescByCm(String bkgNo) throws EventException {
        try {
            return dbDao.searchGoodsDescByCm(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * update On-Board Date -- UI_BKG-0726
     * @param grpBlDtListVO
     * @exception EventException
     */
    public void modifyBlObrdDt(GrpBlDtListVO grpBlDtListVO) throws EventException {
        try {
//        	Check Office Code
        	BookingUtil utilCmd = new BookingUtil();
        	MdmOrganizationVO mdmOrganizationVO = utilCmd.searchMdmOrzByOfcCd(grpBlDtListVO.getOblIssOfcCd());
        	if(mdmOrganizationVO == null) {
        		throw new EventException(new ErrorHandler("BKG00905").getMessage());
        	}
        	
            dbDao.modifyBlObrdDt(grpBlDtListVO);
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } 
    }

    /**
     * retrieve  HB/L description -- UI_BKG-0360
     * M&D add HB/L of the information
     * 
     * @param bkgNo
     * @return List<HblForMndVO>
     * @exception EventException
     */
    public List<HblForMndVO> searchHblForMnd(String bkgNo) throws EventException {
        try {
            return dbDao.searchHblForMnd(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } 
    }

    /**
     * HB / L  retrieve a template for the information of the shipper . -- UI_BKG-0399
     * @param shprNm
     * @param cneeNm
     * @param ofcCd
     * @return HblTmpltVO
     * @exception EventException
     */
    public HblTmpltVO searchHblTmplt(String shprNm, String cneeNm, String ofcCd) throws EventException {
        HblTmpltVO hblTmpltVO = new HblTmpltVO();
        try {
            List<BkgNvoccProfVO> bkgNvoccProfVOs = dbDao.searchHblCustTmplt(shprNm, cneeNm, ofcCd);
            List<BkgNvoccProfCntrMfVO> bkgNvoccProfCntrMfVOs = dbDao.searchHblCmTmplt(shprNm, cneeNm, ofcCd);
            
            hblTmpltVO.setBkgNvoccProfVOs(bkgNvoccProfVOs);
            hblTmpltVO.setBkgNvoccProfCntrMfVOs(bkgNvoccProfCntrMfVOs);
            
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return hblTmpltVO;
    }

    /**
     * HB / L  handle a template for the information of the shipper. -- UI_BKG-0399
     * @param hblTmpltVO
     * @param s_usr_id
     * @exception EventException
     */
    public void manageHblTmplt(HblTmpltVO hblTmpltVO, String s_usr_id) throws EventException {
        List<BkgNvoccProfVO> vo1 = hblTmpltVO.getBkgNvoccProfVOs();
        List<BkgNvoccProfCntrMfVO> vo2 = hblTmpltVO.getBkgNvoccProfCntrMfVOs();
        try {
            List<BkgNvoccProfVO> createCustList = new ArrayList<BkgNvoccProfVO>();
            List<BkgNvoccProfVO> modifyCustList = new ArrayList<BkgNvoccProfVO>();
            List<BkgNvoccProfVO> deleteCustList = new ArrayList<BkgNvoccProfVO>();
            int custVoCnt = vo1 == null ? 0 : vo1.size();
            log.debug("BkgNvoccProfVO -------------------------->" + custVoCnt);
            for(int i = 0; i < custVoCnt; i++) {
                log.debug("BkgNvoccProfVO -> " + vo1.get(i).getIbflag() + " : " + vo1.get(i).getProfSeq());
                vo1.get(i).setCreUsrId(s_usr_id);
                vo1.get(i).setUpdUsrId(s_usr_id);
                if("I".equals(vo1.get(i).getIbflag())) {
                    createCustList.add(vo1.get(i));
                } else if("U".equals(vo1.get(i).getIbflag())) {
                    modifyCustList.add(vo1.get(i));
                } else if("D".equals(vo1.get(i).getIbflag())) {
                    deleteCustList.add(vo1.get(i));
                }
            }
             
            List<BkgNvoccProfCntrMfVO> createCmList = new ArrayList<BkgNvoccProfCntrMfVO>();
            List<BkgNvoccProfCntrMfVO> modifyCmList = new ArrayList<BkgNvoccProfCntrMfVO>();
            List<BkgNvoccProfCntrMfVO> deleteCmList = new ArrayList<BkgNvoccProfCntrMfVO>();
            int cmVoCnt = vo2 == null ? 0 : vo2.size();
            log.debug("BkgNvoccProfCntrMfVO -------------------------------->" + cmVoCnt);        
            for(int i = 0; i < cmVoCnt; i++) {
                log.debug("BkgNvoccProfVO -> " + vo2.get(i).getIbflag() + " : " + vo2.get(i).getProfSeq());
                vo2.get(i).setCreUsrId(s_usr_id);
                vo2.get(i).setUpdUsrId(s_usr_id);
                if("I".equals(vo2.get(i).getIbflag())) {
                    createCmList.add(vo2.get(i));
                } else if("U".equals(vo2.get(i).getIbflag())) {
                    modifyCmList.add(vo2.get(i));
                } else if("D".equals(vo2.get(i).getIbflag())) {
                    deleteCmList.add(vo2.get(i));
                }
            }
            

             if(deleteCmList.size() > 0) {
                 dbDao.removeHblCmTmplt(deleteCmList);
             }
             if(deleteCustList.size() > 0) {
                 dbDao.removeHblCustTmplt(deleteCustList);
             }
             
             for(int i=0;i<createCustList.size();i++) {
                 dbDao.createHblCustTmplt(createCustList.get(i));
             }
             for(int i=0;i<modifyCustList.size();i++) {
                 dbDao.modifyHblCustTmplt(modifyCustList.get(i));
             }
             
             for(int i=0;i<createCmList.size();i++) {
                 dbDao.createHblCmTmplt(createCmList.get(i));
             }
             for(int i=0;i<modifyCmList.size();i++) {
                 dbDao.modifyHblCmTmplt(modifyCmList.get(i));
             }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Container Information, B / L to insert or update the information<br>
     * 
     * @author      
     * @param       MtyBookingCreateVO mtyBookingCreateVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void createMtyRepoBlCntr(MtyBookingCreateVO mtyBookingCreateVO, SignOnUserAccount account) throws EventException {
        try {       
            BookingUtil utilBC = new BookingUtil();
            if(mtyBookingCreateVO != null){
                BkgBlNoVO   bkgBlNoVO  = mtyBookingCreateVO.getBkgBlNoVO();
                MtyCntrVO[] mtyCntrVOs = mtyBookingCreateVO.getMtyCntrVOs();
                
                // The presence or absence data
                if(mtyCntrVOs == null){
                    // Failed to save data(No information MtyCntrVO)               
                    throw new EventException((String)new ErrorHandler("BKG00391").getMessage());                        
                }
                if(bkgBlNoVO == null){
                    // Failed to save data(BkgBlNoVO No information)               
                    throw new EventException((String)new ErrorHandler("BKG00391").getMessage());                        
                }               
                String bkgNo = bkgBlNoVO.getBkgNo();
                
                // 010. creation-> addMtyBkgBlDoc()execution -> bkg_bl_doc table insert            
                dbDao.addMtyBkgBlDoc(bkgNo, account);
                // 020. searchMtyBlDesc() result-> string [] array -> new line add  after 4 row            
                String[] blDesc = dbDao.searchMtyBlDesc(bkgBlNoVO);
                String cmdtDesc = "";
                for(int i = 0 ; i < blDesc.length ; i++){
                    if(i < 1){
                        cmdtDesc = blDesc[i];
                    }else{
                        if(i > 1 && i%4 == 1){
                            cmdtDesc = cmdtDesc + "\n" + blDesc[i];
                        }else{
                            cmdtDesc = cmdtDesc + " " + blDesc[i];
                        }
                    }
                }
                // 020 result + new line + "       EMPTY CONTAINER (OPUS Co.)"append -> bkg_bl_mk_desc.cmdt_desc put in
                cmdtDesc = cmdtDesc + "\n" + "       EMPTY CONTAINER (OPUS Co.)";

                /* bkgBlMkDescVO */
                BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
                blMkDescVO.setBkgNo(bkgNo);
                blMkDescVO.setMkDesc("N/A");
                blMkDescVO.setCmdtDesc(cmdtDesc);
                blMkDescVO.setMkSeq("1");
                blMkDescVO.setCreUsrId(account.getUsr_id());
                blMkDescVO.setUpdUsrId(account.getUsr_id());                
                
                // 030. manageMnd()execution -> bkg_bl_mk_desc table insert    
                dbDao.addMnd(blMkDescVO, "N");

                String svrId = utilBC.searchPolSvcByBkgNo(bkgBlNoVO);
                
                log.debug("cntr length: "+mtyCntrVOs.length );
                for(int i = 0 ; i < mtyCntrVOs.length ; i++){
                    MtyCntrStsVO mtyCntrStsVO = dbDao.searchMtyCntrSts(mtyCntrVOs[i].getCntrNo(), "");
                    // 040. searchSocCntrCheck() result-> true -> Message [BKG00948] view-> stop
//                    if(dbDao.searchMtySocCntrCheck(mtyCntrVOs[i].getCntrNo())){
                    if("Y".equals(mtyCntrStsVO.getMtySocCntr())){
                        throw new EventException((String)new ErrorHandler("BKG00948",new String[]{mtyCntrVOs[i].getCntrNo()}).getMessage());    
                    }
                    
                    // 050. searchMtyCntrReserve()result -> Message [BKG00948] view-> stop
                    String cntrBkgNo = dbDao.searchMtyCntrReserve(mtyCntrVOs[i].getCntrNo(), bkgNo, mtyBookingCreateVO.getMtyBookingVO().getPolCd(), mtyBookingCreateVO.getMtyBookingVO().getVslCd()+ mtyBookingCreateVO.getMtyBookingVO().getSkdVoyNo()+ mtyBookingCreateVO.getMtyBookingVO().getSkdDirCd());
                    if(cntrBkgNo != null && cntrBkgNo.length() > 0){
                        throw new EventException((String)new ErrorHandler("BKG00949",new String[]{mtyCntrVOs[i].getCntrNo(),cntrBkgNo}).getMessage());
                    }
                    
                    log.debug("cntr : "+ mtyCntrVOs[i].getCntrNo()+",bkg_no:"+mtyCntrStsVO.getBkgNo());
                    // 060. cnmvStsCd <> "ID" or "MT" -> Message[BKG00951] view-> stop
                    // Setting "VL" in case of not existing bkg_no
                    if("VL".equals(mtyCntrStsVO.getCnmvStsCd()) && mtyCntrStsVO.getBkgNo() != null){
                    	throw new EventException((String)new ErrorHandler("BKG00951",new String[]{mtyCntrVOs[i].getCntrNo(),mtyCntrStsVO.getCnmvStsCd()}).getMessage());                    	
                    }
                    if(!"ID".equals(mtyCntrStsVO.getCnmvStsCd()) && !"MT".equals(mtyCntrStsVO.getCnmvStsCd())){
                        throw new EventException((String)new ErrorHandler("BKG00951",new String[]{mtyCntrVOs[i].getCntrNo(),mtyCntrStsVO.getCnmvStsCd()}).getMessage());
                    }
                    
                    // 070. searchMtyCntrSts() result-> cnmvStsCd, svrId compare svr_id and searchSvrByOfc(login office) result  -> false -> Message [BKG00950] view-> stop
                    // -> svr of the user Office -> svr changes to the  bkg pol 
//                    String svrId = utilBC.searchSvrByOfc(account.getOfc_cd());
                    if(!svrId.equals(mtyCntrStsVO.getSvrId())){
                        throw new EventException((String)new ErrorHandler("BKG00950",new String[]{mtyCntrVOs[i].getCntrNo(),mtyCntrStsVO.getSvrId()}).getMessage());
                    } 
                    
                    // 080. searchMtyCntrSts()result-> aciac_div_cd(active/inactive)<> 'A':ACT -> Message[BKG00952] view-> stop
                    if(!"A".equals(mtyCntrStsVO.getAciacDivCd())){
                        throw new EventException((String)new ErrorHandler("BKG00952",new String[]{mtyCntrVOs[i].getCntrNo()}).getMessage());
                    }
                    // 090. addMtyBkgContainer existing-> bkg_container table insert.
                    BkgContainerVO bkgContainerVO = new BkgContainerVO();
                    bkgContainerVO.setBkgNo(bkgNo);
                    bkgContainerVO.setCntrNo(mtyCntrVOs[i].getCntrNo());
                    bkgContainerVO.setCntrTpszCd(mtyCntrStsVO.getCntrTpszCd());
                    bkgContainerVO.setCnmvStsCd(mtyCntrStsVO.getCnmvStsCd());
                    bkgContainerVO.setCreUsrId(account.getUsr_id());
                    bkgContainerVO.setUpdUsrId(account.getUsr_id());
                    
                    dbDao.addMtyBkgContainer(bkgContainerVO, account);
                }
                
            }else{
                // Failed to save data(No information MtyBookingCreate)                
                throw new EventException(new ErrorHandler("BKG00391").getMessage());
            }
        } catch (EventException ex) {
            throw ex;                   
        } catch (DAOException ex) {
        	log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), e);
        }
    }   

    /**
     * retrieving house bl-- UI_BKG-0366
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return HblVO
     * @exception EventException
     */
    public HblVO searchHbl(BkgBlNoVO bkgBlNoVO) throws EventException {
        HblVO hblVO = new HblVO();
        try {
            HblBkgInfoVO hblBkgInfoVO = dbDao.searchBkgInfoForHbl(bkgBlNoVO);
            hblBkgInfoVO.setHtsFlg(dbDao.searchHTSFlag(bkgBlNoVO));
            hblBkgInfoVO.setCndFlg(dbDao.searchCanadaFlob(bkgBlNoVO));
            List<HblCntrVO> hblCntrVOs = dbDao.searchHblCntrVOs(bkgBlNoVO);
            List<BkgCntrMfDescVO> cntrMfDescVOs = dbDao.searchBkgCntrMfDescVOs(bkgBlNoVO);
            List<HblDtlInfoVO> hblVOs = dbDao.searchHblDtlInfoVOs(bkgBlNoVO);

            hblVO.setHblBkgInfoVO(hblBkgInfoVO);
            hblVO.setHblCntrVOs(hblCntrVOs);
            hblVO.setBkgCntrMfDescVOs(cntrMfDescVOs);
            hblVO.setHblDtlInfoVOs(hblVOs);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return hblVO;
    }

    /**
     * House B/L, B/L Customer, Manifest handling  -- UI_BKG-0366
     * @param HblVO hblVO
     * @param SignOnUserAccount account
     * @param String caFlg
     * @exception EventException
     */
    public void manageHbl(HblVO hblVO, SignOnUserAccount account, String caFlg) throws EventException {
        //HblBkgInfoVO vo1 = hblVO.getHblBkgInfoVO();
        //List<BkgCntrMfDescVO> vo2 = hblVO.getBkgCntrMfDescVOs();
        List<HblDtlInfoVO> vo3 = hblVO.getHblDtlInfoVOs();
        try {
//            /* cm */
//            if(vo2 != null){
//                for(int i = 0; i < vo2.size(); i++) {
//                    log.debug("BkgCntrMfDescVO -> " + vo2.get(i).getCntrMfNo() + " : " + vo2.get(i).getIbflag());
//                    vo2.get(i).setCreUsrId(account.getUsr_id());
//                    vo2.get(i).setUpdUsrId(account.getUsr_id());
//                    if("I".equals(vo2.get(i).getIbflag())) {
//                        //insertCmList.add(vo2.get(i));
//                        dbDao.addCm(vo2.get(i), caFlg);
//                    } else if("U".equals(vo2.get(i).getIbflag())) {
//                        //updateCmList.add(vo2.get(i));
//                        dbDao.modifyCm(vo2.get(i), caFlg);
//                    } else if("D".equals(vo2.get(i).getIbflag())) {
//                        //deleteCmList.add(vo2.get(i));
//                        dbDao.removeCm(vo2.get(i), caFlg);
//                    }
//                }
//            }

            /* hbl */
            if(vo3 != null){
                List<BkgHblVO> updateHblList = new ArrayList<BkgHblVO>();
                List<BkgHblVO> deleteHblList = new ArrayList<BkgHblVO>();
                List<BkgHblCustVO> updateHblCustList = new ArrayList<BkgHblCustVO>();
                List<BkgHblCustVO> deleteHblCustList = new ArrayList<BkgHblCustVO>();
                for(int i = 0; i < vo3.size(); i++) {
                    log.debug("HblDtlInfoVO -> " + vo3.get(i).getHblSeq() + " : " + vo3.get(i).getIbflag());
                    BkgHblVO bkgHblVO = new BkgHblVO();
                    ObjectCloner.build(vo3.get(i), bkgHblVO);
                    bkgHblVO.setCreUsrId(account.getUsr_id());
                    bkgHblVO.setUpdUsrId(account.getUsr_id());
                    
                    BkgHblCustVO bkgHblShprVO = new BkgHblCustVO();
                    bkgHblShprVO.setBkgNo       (vo3.get(i).getBkgNo());
                    bkgHblShprVO.setHblSeq      (vo3.get(i).getHblSeq());
                    bkgHblShprVO.setBkgCustTpCd ("S");
                    bkgHblShprVO.setCustCntCd   ("");
                    bkgHblShprVO.setCustSeq     ("");
                    bkgHblShprVO.setCustNm      (vo3.get(i).getShprNm());
                    bkgHblShprVO.setCustAddr    (vo3.get(i).getShprAddr());
                    bkgHblShprVO.setCtyNm       (vo3.get(i).getShprCtyNm());
                    bkgHblShprVO.setSteCd       (vo3.get(i).getShprSteCd());
                    bkgHblShprVO.setCustCntCd   (vo3.get(i).getShprCntCd());
                    bkgHblShprVO.setCustZipId   (vo3.get(i).getShprZipCd());
                    bkgHblShprVO.setCreUsrId    (account.getUsr_id());
                    bkgHblShprVO.setUpdUsrId    (account.getUsr_id());

                    BkgHblCustVO bkgHblCneeVO = new BkgHblCustVO();
                    bkgHblCneeVO.setBkgNo       (vo3.get(i).getBkgNo());
                    bkgHblCneeVO.setHblSeq      (vo3.get(i).getHblSeq());
                    bkgHblCneeVO.setBkgCustTpCd ("C");
                    bkgHblCneeVO.setCustCntCd   ("");
                    bkgHblCneeVO.setCustSeq     ("");
                    bkgHblCneeVO.setCustNm      (vo3.get(i).getCneeNm());
                    bkgHblCneeVO.setCustAddr    (vo3.get(i).getCneeAddr());
                    bkgHblCneeVO.setCtyNm       (vo3.get(i).getCneeCtyNm());
                    bkgHblCneeVO.setSteCd       (vo3.get(i).getCneeSteCd());
                    bkgHblCneeVO.setCustCntCd   (vo3.get(i).getCneeCntCd());
                    bkgHblCneeVO.setCustZipId   (vo3.get(i).getCneeZipCd());
                    bkgHblCneeVO.setCreUsrId    (account.getUsr_id());
                    bkgHblCneeVO.setUpdUsrId    (account.getUsr_id());

                    BkgHblCustVO bkgHblNotiVO = new BkgHblCustVO();
                    bkgHblNotiVO.setBkgNo       (vo3.get(i).getBkgNo());
                    bkgHblNotiVO.setHblSeq      (vo3.get(i).getHblSeq());
                    bkgHblNotiVO.setBkgCustTpCd ("N");
                    bkgHblNotiVO.setCustCntCd   ("");
                    bkgHblNotiVO.setCustSeq     ("");
                    bkgHblNotiVO.setCustNm      (vo3.get(i).getNotiNm());
                    bkgHblNotiVO.setCustAddr    (vo3.get(i).getNotiAddr());
                    bkgHblNotiVO.setCtyNm       (vo3.get(i).getNotiCtyNm());
                    bkgHblNotiVO.setSteCd       (vo3.get(i).getNotiSteCd());
                    bkgHblNotiVO.setCustCntCd   (vo3.get(i).getNotiCntCd());
                    bkgHblNotiVO.setCustZipId   (vo3.get(i).getNotiZipCd());
                    bkgHblNotiVO.setCreUsrId    (account.getUsr_id());
                    bkgHblNotiVO.setUpdUsrId    (account.getUsr_id());

                    if("I".equals(vo3.get(i).getIbflag())) {
                        updateHblList.add(bkgHblVO);
                        updateHblCustList.add(bkgHblShprVO);
                        updateHblCustList.add(bkgHblCneeVO);
                        updateHblCustList.add(bkgHblNotiVO);
                    } else if("U".equals(vo3.get(i).getIbflag())) {
                        updateHblList.add(bkgHblVO);
                        updateHblCustList.add(bkgHblShprVO);
                        updateHblCustList.add(bkgHblCneeVO);
                        updateHblCustList.add(bkgHblNotiVO);
                    } else if("D".equals(vo3.get(i).getIbflag())) {
                        deleteHblList.add(bkgHblVO);
                        deleteHblCustList.add(bkgHblShprVO);
                    }
                }

                if(deleteHblCustList.size() > 0) {
                    dbDao.removeHblCusts(deleteHblCustList, caFlg);
                }
                if(deleteHblList.size() > 0) {
                    dbDao.removeHbls(deleteHblList, caFlg);
                }
                if(updateHblList.size() > 0) {
                    for(int i=0;i<updateHblList.size();i++){
                        dbDao.manageHbl(updateHblList.get(i), caFlg);
                    }                
                }
                if(updateHblCustList.size() > 0) {
                    for(int i=0;i<updateHblCustList.size();i++){
                        dbDao.manageHblCust(updateHblCustList.get(i), caFlg);
                    }                  
                }
            }
        } catch(DAOException ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * House B / L  information validation check-- UI_BKG-0366
     * @param hblVO
     * @exception EventException
     */
    public void validateHbl(HblVO hblVO) throws EventException {
        BookingUtil utilCmd = new BookingUtil();
        
        List<BkgCntrMfDescVO> vo2 = hblVO.getBkgCntrMfDescVOs();
        List<HblDtlInfoVO> vo3 = hblVO.getHblDtlInfoVOs();
        try {
            if(vo2 != null && vo2.size() > 0) {
                for(int i = 0; i < vo2.size(); i++) {
                    // 1. BookingUtil::validatePkgType ( pkgTpCd )
                    log.debug(" * PckTpCd : " + vo2.get(i).getPckTpCd());
                    boolean flag = utilCmd.validatePkgType(vo2.get(i).getPckTpCd());
                    if(!flag) {
                        throw new EventException(new ErrorHandler("BKG01050", new String[]{"Package Type"}).getMessage());
                    }

//                     2. BookingUtil::searchHtsCodeDesc ( htsCd )
                    log.debug(" * HamoTrfCd : " + vo2.get(i).getHamoTrfCd());
                    if(vo2.get(i).getHamoTrfCd() != null && vo2.get(i).getHamoTrfCd().length() > 0) {
                        String extFlag = utilCmd.checkHtsCodeByCm("T", vo2.get(i).getHamoTrfCd());
                        if("N".equals(extFlag)) {
                            throw new EventException(new ErrorHandler("BKG01050", new String[]{"HTS"}).getMessage());
                        }
                    }
                }
            }
            
            if(vo3 != null && vo3.size() > 0) {
                for(int i = 0; i < vo3.size(); i++) {
                    // dbDao.validateCntSte ( cntCd , steCd );
                    boolean flag = utilCmd.validatePkgType(vo3.get(i).getPckTpCd());
                    if(!flag) {
                        throw new EventException(new ErrorHandler("BKG00530", new String[]{ vo3.get(i).getPckTpCd()}).getMessage());
                    }
          
                    // validateAmsRefNo
                    if(vo3.get(i).getCntrMfNo() != null && vo3.get(i).getCntrMfNo().length() > 0){
                        String amsRefNo = dbDao.validateCntrMfNo(vo3.get(i), "N");
                        log.debug("***** amsRefNo ***** : " + amsRefNo);
//                      if(amsRefNo == null || amsRefNo.length() == 0) {
//                          throw new EventException(new ErrorHandler("BKG00530", new String[]{ vo3.get(i).getHblMfTpCd()}).getMessage());
//                      }
                    }
                    log.debug("check shipper");
        			String shSteCd = vo3.get(i).getShprSteCd();
        			String shCntCd = vo3.get(i).getShprCntCd();
        			
                    //country code validation
        			if(shCntCd.length()>0){
        				MdmCountryVO countryVO = utilCmd.searchCountryCode(shCntCd);
        				if(countryVO == null){
        					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Shipper", shCntCd}).getMessage());
        				}
        			}
        			// State input-> country and state result -> ture or false 
        			if(shCntCd != null && shCntCd.length() > 0 && shSteCd != null && shSteCd.length() > 0){
        				if(utilCmd.searchStateByCountry(shCntCd, shSteCd).size() == 0 ){
        					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{shSteCd, shCntCd}).getMessage());
        				}
        			}
        			
        			log.debug("check consignee");
        			String cnSteCd = vo3.get(i).getCneeSteCd();
        			String cnCntCd = vo3.get(i).getCneeCntCd();
        			
                    //country code validation
        			if(cnCntCd.length()>0){
        				MdmCountryVO countryVO = utilCmd.searchCountryCode(cnCntCd);
        				if(countryVO == null){
        					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Consignee", cnCntCd}).getMessage());
        				}
        			}
        			// State input -> Make sure you enter the country and state rightly
        			if(cnCntCd != null && cnCntCd.length() > 0 && cnSteCd != null && cnSteCd.length() > 0){
        				if(utilCmd.searchStateByCountry(cnCntCd, cnSteCd).size() == 0 ){
        					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{cnSteCd, cnCntCd}).getMessage());
        				}
        			}
        			
                    log.debug("check notify");
        			String nfSteCd = vo3.get(i).getNotiSteCd();
        			String nfCntCd = vo3.get(i).getNotiCntCd();
        			
                    //country code validation
        			if(nfCntCd.length()>0){
        				MdmCountryVO countryVO = utilCmd.searchCountryCode(nfCntCd);
        				if(countryVO == null){
        					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Notify", nfCntCd}).getMessage());
        				}
        			}
        			// State input -> Make sure you enter the country and state rightly
        			if(nfCntCd != null && nfCntCd.length() > 0 && nfSteCd != null && nfSteCd.length() > 0){
        				if(utilCmd.searchStateByCountry(nfCntCd, nfSteCd).size() == 0 ){
        					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{nfSteCd, nfCntCd}).getMessage());
        				}
        			}
                }
            }
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }  
    }

    /**
     * bkg_bl_doc ORG_CNT_NM column update <br>
     * 
     * @author      
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       String orgCntNm
     * @param       SignOnUserAccount account 
	 * @param 		String oldActCustCd
	 * @param 		String newActCustCd
     * @exception   EventException
     */
    public void modifyBkgBlDocByCust(BkgBlNoVO bkgBlNoVO, String orgCntNm, SignOnUserAccount account, String oldActCustCd, String newActCustCd) throws EventException {
    	BookingUtil utilBC = new BookingUtil();     
    	try {       
            dbDao.modifyBkgBlDocByCust(bkgBlNoVO, orgCntNm, account);
            
            if(!oldActCustCd.equals(newActCustCd)){
            	
            	String oldActCustNm = "";
            	String newActCustNm = "";
            	
            	if(!oldActCustCd.equals("") && oldActCustCd.length() == 8){
            		MdmCustVO oldMdmCustVO = utilBC.searchMdmCust(oldActCustCd.substring(0,2), oldActCustCd.substring(2,8), "N");
            		
            		if(oldMdmCustVO != null){
            			oldActCustNm = oldMdmCustVO.getName();
            		}
            	}
            	
            	if(!newActCustCd.equals("") && newActCustCd.length() == 8){
            		MdmCustVO newMdmCustVO = utilBC.searchMdmCust(newActCustCd.substring(0,2), newActCustCd.substring(2,8), "N");
            		
            		if(newMdmCustVO != null){
            			newActCustNm = newMdmCustVO.getName();
            		}
            	}
            	
            	
            	BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
            	
            	blMkDescVO.setBkgNo(bkgBlNoVO.getBkgNo());
            	blMkDescVO.setUpdUsrId(account.getUsr_id());
            	blMkDescVO.setBkgNoSplit(bkgBlNoVO.getCaFlg());
            	int result = dbDao.modifyMndByCust(blMkDescVO, oldActCustCd, newActCustCd, oldActCustNm, newActCustNm);
            	
            	log.debug("result = "+ result);
            	
            	if(result == 0){

                	log.debug("result = "+ result);
                	
            		blMkDescVO.setCreUsrId(account.getUsr_id());
            		blMkDescVO.setCmdtDesc(!newActCustNm.equals("")?"exporter reference :"+newActCustNm:"");
            		dbDao.addMndByCust(blMkDescVO);
            	}
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Manifest File No Validation check -- UI_BKG-0366
     * @param BkgBlNoVO bkgBlNoVO
     * @exception EventException
     */
    public void validateMfNo(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            /*
             * 1. Canada via -> Pass
             * 2. POD 'IN'  from start -> Pass
             * 3. Pre Relay 'IN'from start and  POD 'US','CA','MX' and  filer <> '01'-> true
             * 4. etc filer <> '01'  error
             */
            String cndFlg = dbDao.searchCanadaFlob(bkgBlNoVO);
            log.debug("=====> canada_flob : " + cndFlg);
            if("Y".equals(cndFlg)) return;

            MfNoVO mfNoVO = dbDao.validateMfNo(bkgBlNoVO);
            String pre_rly = mfNoVO.getPreRlyPortCd();
            String pod_cd  = mfNoVO.getPodCd();
            String usa_flg = mfNoVO.getUsaCstmsFileCd();
            String can_flg = mfNoVO.getCndCstmsFileCd();
            log.debug("=====> pre_rly   : " + pre_rly);
            log.debug("=====> pod_cd    : " + pod_cd);
            log.debug("=====> usa_flg   : " + usa_flg);
            log.debug("=====> can_flg   : " + can_flg);
            
            if(pod_cd.startsWith("IN")) return;

            if(pre_rly.startsWith("IN")){
                if(pod_cd.startsWith("US") ||
                   pod_cd.startsWith("CA") ||
                   pod_cd.startsWith("MX")){
                    if(!"1".equals(usa_flg) && !"1".equals(can_flg)){
                        throw new EventException(new ErrorHandler("BKG08032", new String[]{"can_flg=" +can_flg+ ", usa_flg="+usa_flg}).getMessage());
                    } 
                }
            }else{
                if(!"1".equals(usa_flg) && !"1".equals(can_flg)){
                    throw new EventException(new ErrorHandler("BKG08032", new String[]{"can_flg=" +can_flg+ ", usa_flg="+usa_flg}).getMessage());
                }   
            }
        } catch(EventException ex) {
            throw ex;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Nvocc File No modify
     * @param bkgNo
     * @param hblSeq
     * @param nvoccFileNo
     * @param account
     * @param caFlg
     * @exception EventException
     */
    public void modifyNvoccFileNo(String bkgNo, String hblSeq, String nvoccFileNo, SignOnUserAccount account, String caFlg) throws EventException {
        try {
            /* house b/l filer number update */
            dbDao.modifyNvoccFileNo(bkgNo, hblSeq, nvoccFileNo, caFlg);
        } catch (DAOException ex) {
        	log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } 
    }

    /**
     * Max HBL Manifest No Generation
     * @param bkgNo
     * @param blNo
     * @param caFlg
     * @return String
     * @exception EventException
     */
    public String searchMaxMfNo(String bkgNo, String blNo, String caFlg) throws EventException {
        String mfNo = null;
        try {
            // Master B/L No.-> Third place behind  changes to 'H' 
            // Two digits in the order -> 01~99, A1~ZZ, (I,O Exclusion) Are sequentially generated.
            if(blNo == null || blNo.length() < 10){
                throw new EventException(new ErrorHandler("BKG08065").getMessage());
            }
            String maxMfNo = dbDao.searchMaxMfNo(bkgNo, caFlg);
            if(maxMfNo == null || "".equals(maxMfNo)) {
                String tmpHd = blNo.substring(0, blNo.length() - 3);
                log.debug("** searchMaxMfNo : PREFIX : " + tmpHd + ", POSTFIX : ---");
                mfNo = tmpHd + "A01";
            } else {
                String tmpHd = maxMfNo.substring(0, blNo.length() - 3);
                String tmpTl = maxMfNo.substring(blNo.length() - 3);
                log.debug("** searchMaxMfNo : PREFIX : " + tmpHd + ", POSTFIX : " + tmpTl);
                mfNo = tmpHd + HblSeq.getHblSeq(tmpTl);
            }
            
            // Repeat until N
            boolean dupCheck = true;
            while(dupCheck) {
            	if("N".equals(checkMaxMfNoDup(mfNo))) {
            		dupCheck = false;
            	} else {
            		String tmpHd = mfNo.substring(0, mfNo.length() - 3);
                    String tmpTl = mfNo.substring(mfNo.length() - 3);
                    log.debug("** searchMaxMfNo : PREFIX : " + tmpHd + ", POSTFIX : " + tmpTl);
                    mfNo = tmpHd + HblSeq.getHblSeq(tmpTl);
            	}
            }
            
            if(mfNo == null || mfNo.endsWith("null")) {
                throw new EventException(new ErrorHandler("BKG08065").getMessage());
            }
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return mfNo;
    }   
    
    /**
     * Max HBL Manifest No duplicate check.
     * @param mfNo
     * @return String
     * @exception EventException
     */
    public String checkMaxMfNoDup(String mfNo) throws EventException {
    	String maxMfNo = null;
        try {
        	maxMfNo = dbDao.checkMfNoDup(mfNo);            
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return maxMfNo;
    }   

    /**
     * HBL Count update.<br>
     * 
     * @author 
     * @param hblCount
     * @param bkgBlNoVO
     * @param account
     * @exception EventException
     */    
    public void modifyHblCount(int hblCount, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
        try {       
            dbDao.modifyHblCount(hblCount, bkgBlNoVO, account);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }    

    /**
     * will update in the  targetBkg bkg_bl_doc.

     * @author 
     * @param sourceBkg
     * @param targetBkg
     * @param account
     * @exception EventException
     */
    public void combineBlDoc(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException {
        try {

            if ( sourceBkg != null ) {
                WgtPkgMeasVO wgtPkgMeasVO = dbDao.searchPckMeasWgtSi(sourceBkg, targetBkg);

                for (int i=0;i<sourceBkg.length;i++) {
                        dbDao.copyHblByBkg(sourceBkg[i], targetBkg, "M", account);
                        dbDao.copyHblCustByBkg(sourceBkg[i], targetBkg, account);
                }

                dbDao.modifyPkcMeasWgt(wgtPkgMeasVO, targetBkg, account);
            }

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }    

    /**
     * retrieve BlCopyOutVO<br>
     * 
     * @param String bkgNo
     * @return BlCopyOutVO
     * @exception EventException
     */
    public BlCopyOutVO searchForCopyBl(String bkgNo) throws EventException {
        BlCopyOutVO blCopyOutVo = null;
        BookingUtil utilCmd = null;
        BkgBlNoVO bkgBlNoVo = null;
        try {
            blCopyOutVo = dbDao.searchForCopyBl(bkgNo);
            if (null!=blCopyOutVo) {
                bkgBlNoVo = new BkgBlNoVO();
                bkgBlNoVo.setBkgNo(bkgNo);
                utilCmd = new BookingUtil();
                //retrieve bkgStatus 
                blCopyOutVo.setBkgStatus(utilCmd.searchBkgStatusByBkg(bkgBlNoVo));
                //retrieve bdrFlg 
                blCopyOutVo.setBdrFlg(utilCmd.searchBdrFlgByBkg(bkgBlNoVo));
                //retrieve shprCd 
                blCopyOutVo.setShprCd(dbDao.searchShprCd(bkgNo));
            }
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return blCopyOutVo;
    }

    /**
     * retrieve BlCopyInVO<br>
     * 
     * @param BlCopyInVO blCopyInVo
     * @return BlCopyInVO
     * @exception EventException
     */
    public BlCopyInVO searchForCopyBl(BlCopyInVO blCopyInVo) throws EventException {
        BookingUtil utilCmd = null;
        BkgBlNoVO bkgBlNoVo = null;
        String bkgStatus = null;
        BlStatusVO blStatusVO = null;
        try {
            if (null!=blCopyInVo) {
                bkgBlNoVo = new BkgBlNoVO();
                bkgBlNoVo.setBkgNo(blCopyInVo.getCopyBkgNo());
                utilCmd = new BookingUtil();
                //10.searchBkgStatusByBkg
                bkgStatus = utilCmd.searchBkgStatusByBkg(bkgBlNoVo);
                //12.searchBlSts
                blStatusVO = dbDao.searchBlSts(blCopyInVo.getCopyBkgNo());
                if (null==bkgStatus) {
                    blCopyInVo.setResultMsg("BKG No. Not Found");
                } else if ("X".equalsIgnoreCase(bkgStatus)) {
                    blCopyInVo.setResultMsg("BKG Canceled");
                //11.searchBdrFlgByBkg
                } else if ("Y".equalsIgnoreCase(utilCmd.searchBdrFlgByBkg(bkgBlNoVo))) {
                    blCopyInVo.setResultMsg("BDR");
                } else if (null!=blStatusVO && "Y".equalsIgnoreCase(blStatusVO.getOblIssFlg())) {
                    blCopyInVo.setResultMsg("B/L Issued");
                //13.if custFlg='Y'
                } else if ("Y".equalsIgnoreCase(blCopyInVo.getCustFlg())) {
                    //14.searchShprCd
                    if (!blCopyInVo.getShprCd().equalsIgnoreCase(dbDao.searchShprCd(blCopyInVo.getCopyBkgNo()))) {
                        blCopyInVo.setResultMsg("Shipper Code Unmatched");
                    }
                }
            }
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return blCopyInVo;
    }

    /**
     * BL Copy UI Call
     * MND Copy -- UI_BKG-0648
     * @param blCopyInVo
     * @param account
     * @return BlCopyInVO
     * @exception EventException
     */
    public BlCopyInVO copyDocByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws EventException {
        int docUpdCnt = 0;
        int mndUpdCnt = 0;
        try {
            if (null!=blCopyInVo) {
                //21-1.if custFlg='Y' or descFlg='Y'
                if ("Y".equalsIgnoreCase(blCopyInVo.getCustFlg()) || "Y".equalsIgnoreCase(blCopyInVo.getDescFlg())) {
                    //21-2.update blDoc
                    docUpdCnt = dbDao.modifyBlDocByBlCopy(blCopyInVo, account);
                    if (0==docUpdCnt) {
                        blCopyInVo.setResultMsg("BKG NO NOT FOUND");
                    }
                }
                //22.if markFlg='Y' or descFlg='Y'
                if ("Y".equalsIgnoreCase(blCopyInVo.getMarkFlg()) || "Y".equalsIgnoreCase(blCopyInVo.getDescFlg())) {
                    //23.update mnd
                    mndUpdCnt = dbDao.modifyMndByBlCopy(blCopyInVo, account);
                    if (0==mndUpdCnt) {
                        //24.add mnd
                        dbDao.addMndByBlCopy(blCopyInVo, account);
                    }
                }
            }
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return blCopyInVo;
    }

    /**
     * bkg_bl_doc CA (C / A No, C / A User, office, date)  modify<br>
     * 
     * @author 
     * @param bkgBlNoVO
     * @param account
     * @exception EventException
     */
    public void modifyCaStart(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
        try {       
            dbDao.modifyCaStart(bkgBlNoVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    } 
    
    /**
     * 'booking BlDocumantationBC' Copy the relevant table.
     * 
     * @author 
     * @param bkgBlNoVO
     * @param copyTypeCd
     * @exception EventException
     */
    public void createBlCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
        try {
            if ("BKG".equals(copyTypeCd)) {
                //01. 
                dbDao.modifyBlDocCA   (bkgBlNoVO, copyTypeCd);
                //02. 
                dbDao.removeMkDescCA  (bkgBlNoVO, copyTypeCd); 
                //03. 
                dbDao.removeHblCustCA (bkgBlNoVO, copyTypeCd);
                //04.  
                dbDao.removeHblCA     (bkgBlNoVO, copyTypeCd);
                //05. 
                dbDao.removeLicCA     (bkgBlNoVO, copyTypeCd);
                //06. 
                dbDao.removeCntrSealCA(bkgBlNoVO, copyTypeCd);
                //07. 
                dbDao.removeCmCA      (bkgBlNoVO, copyTypeCd);
                //08. 
                dbDao.removeCntrCA    (bkgBlNoVO, copyTypeCd);
            } else {
                //01. 
                dbDao.createBlDocCA(bkgBlNoVO, copyTypeCd);
            }

            //02. 
            dbDao.createMkDescCA  (bkgBlNoVO, copyTypeCd);
            //03. 
            dbDao.createHblCA     (bkgBlNoVO, copyTypeCd);
            //04. 
            dbDao.createHblCustCA (bkgBlNoVO, copyTypeCd);
            //05. 
            dbDao.createLicCA     (bkgBlNoVO, copyTypeCd);
            //06. 
            dbDao.createCntrCA    (bkgBlNoVO, copyTypeCd);
            //07. 
            dbDao.createCmCA      (bkgBlNoVO, copyTypeCd);
            //08. 
            dbDao.createCntrSealCA(bkgBlNoVO, copyTypeCd);
            
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * CA Information:(C/A No, C/A User, office, date) to delete from bkg_bl_doc.<br>
     * 
     * @author 
     * @param bkgBlNoVO
     * @exception EventException
     */ 
    public void modifyCaComplete(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            dbDao.modifyCaComplete(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * BlDocumantationBC will delete the relevant table.
     * 
     * @author      
     * @param       bkgBlNoVO
     * @param       copyTypeCd
     * @exception   EventException
     */
    public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
        try {
            //01. 
            dbDao.removeLicCA     (bkgBlNoVO, copyTypeCd);              
            //02. 
            dbDao.removeMkDescCA  (bkgBlNoVO, copyTypeCd); 
            //03. 
            dbDao.removeCntrSealCA(bkgBlNoVO, copyTypeCd);              
            //04.  
            dbDao.removeCmCA      (bkgBlNoVO, copyTypeCd);              
            //05. 
            dbDao.removeCntrCA    (bkgBlNoVO, copyTypeCd);
            //06. 
            dbDao.removeHblCustCA (bkgBlNoVO, copyTypeCd);
            //07. 
            dbDao.removeHblCA     (bkgBlNoVO, copyTypeCd);
            //08. 
            dbDao.removeBlDocCA   (bkgBlNoVO, copyTypeCd);
            
            //09. 
            dbDao.modifyCaComplete(bkgBlNoVO);
            
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * empty repo Booking split<br>
     * 
     * @author      
     * @param       MtyBookingSplitVO mtyBookingSplitVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void splitMtyRepoBlCntr(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException {
        try {
            MtyCntrVO[] mtyCntrVOs = mtyBookingSplitVO.getMtyCntrVOs();
            String bkgNo    = mtyBookingSplitVO.getBkgBlNoVO().getBkgNo();
            String newBkgNo = mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo();
            
            BkgBlNoVO newBkgBlNoVO = new BkgBlNoVO();
            newBkgBlNoVO.setBkgNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo());
            newBkgBlNoVO.setBlNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBlNo());
            
            // 23. save New Booking Bl Doc 
            dbDao.addMtyBkgBlDoc(newBkgNo, account);
            
            for(int i = 0 ; i < mtyCntrVOs.length ; i++){
                String cntrNo = mtyCntrVOs[i].getCntrNo();
                // ********** 중요 *****************
                //VD로 들어온 경우 VL로 변경한다. 이주현수석님 처리방법
                if("VD".equals(mtyCntrVOs[i].getCnmvStsCd()) ) {
                	mtyCntrVOs[i].setCnmvStsCd("VL");
                }                
                
                if(!"VL".equals(mtyCntrVOs[i].getCnmvStsCd())){
                    throw new EventException((String)new ErrorHandler("BKG00999",new String[]{cntrNo}).getMessage());
                }else{
                    // 17. searchMtyCntrCyc          
                    MtyCntrCycVO mtyCntrCycVO = dbDao.searchMtyCntrCyc(bkgNo, cntrNo);
                    
                    BkgContainerVO bkgContainerVO = new BkgContainerVO();
                    bkgContainerVO.setBkgNo(newBkgNo);
                    bkgContainerVO.setCntrNo(mtyCntrVOs[i].getCntrNo());
                    bkgContainerVO.setCnmvStsCd(mtyCntrCycVO.getCnmvStsCd());   
                    bkgContainerVO.setCreUsrId(account.getUsr_id());
                    bkgContainerVO.setUpdUsrId(account.getUsr_id());                

                    if(mtyCntrCycVO!=null){
                    	bkgContainerVO.setCntrTpszCd(mtyCntrVOs[i].getCntrTpszCd());
                    } else {
                        // 19. searchMtyCntrSts
                        MtyCntrStsVO mtyCntrStsVO = dbDao.searchMtyCntrSts(cntrNo, bkgNo);
                        
                        bkgContainerVO.setMcntrBdlNo(mtyCntrStsVO.getMcntrBdlNo());
                        bkgContainerVO.setCnmvStsCd(mtyCntrStsVO.getCnmvStsCd());   
                    }                   
                    // 20. New Split Booking Container save.
                    dbDao.addMtyBkgContainer(bkgContainerVO, account);   
                    
                    // 21. Original Booking Container delete.
                    dbDao.removeMtyCntr(cntrNo, mtyBookingSplitVO.getBkgBlNoVO());
                }
            }            

            // 24.  searchMtyBlDesc
            String[] newBlDesc = dbDao.searchMtyBlDesc(newBkgBlNoVO);
            String cmdtDesc = "";
            for(int i = 0 ; i < newBlDesc.length ; i++){
                if(i < 1){
                    cmdtDesc = newBlDesc[i];
                }else{
                    if(i > 1 && i%4 == 1){
                        cmdtDesc = cmdtDesc + "\n" + newBlDesc[i];
                    }else{
                        cmdtDesc = cmdtDesc + " " + newBlDesc[i];
                    }
                }
            }
            cmdtDesc = cmdtDesc + "\n" + "       EMPTY CONTAINER (OPUS Co.)";
            
            /* bkgBlMkDescVO */
            BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
            blMkDescVO.setBkgNo(newBkgBlNoVO.getBkgNo());
            blMkDescVO.setMkDesc("N/A");
            blMkDescVO.setCmdtDesc(cmdtDesc);
            blMkDescVO.setMkSeq("1");
            blMkDescVO.setCreUsrId(account.getUsr_id());
            blMkDescVO.setUpdUsrId(account.getUsr_id());                
            
         // 25. addMnd
            dbDao.addMnd(blMkDescVO,"N");
            
            // 27. Original Booking removeMnd
            dbDao.removeMnd(bkgNo);
            
            // 28. 
            String[] orgBlDesc = dbDao.searchMtyBlDesc(mtyBookingSplitVO.getBkgBlNoVO());

            cmdtDesc = "";
            for(int i = 0 ; i < orgBlDesc.length ; i++){
                if(i < 1){
                    cmdtDesc = orgBlDesc[i];
                }else{
                    if(i > 1 && i%4 == 1){
                        cmdtDesc = cmdtDesc + "\n" + orgBlDesc[i];
                    }else{
                        cmdtDesc = cmdtDesc + " " + orgBlDesc[i];
                    }
                }
            }
            cmdtDesc = cmdtDesc + "\n" + "       EMPTY CONTAINER (OPUS Co.)";
            
            /* bkgBlMkDescVO */
            BkgBlMkDescVO blMkDescVO2 = new BkgBlMkDescVO();
            blMkDescVO2.setBkgNo(bkgNo);
            blMkDescVO2.setMkDesc("N/A");
            blMkDescVO2.setCmdtDesc(cmdtDesc);
            blMkDescVO2.setMkSeq("1");
            blMkDescVO2.setCreUsrId(account.getUsr_id());
            blMkDescVO2.setUpdUsrId(account.getUsr_id());               
            // 29. addMnd
            dbDao.addMnd(blMkDescVO2,"N");
        } catch (EventException ex) {
            throw ex;                   
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }           

    /**
     * empty Repo Booking -> container information, B / L information insert, update, delete <br>
     * 
     * @author      
     * @param       RepoBkgForUpdateVO repoBkgForUpdateVO
     * @param		String trunkVvd
     * @param       SignOnUserAccount account
     * @return		List<CusCtmMovementVO>
     * @exception   EventException
     */
    public List<CusCtmMovementVO> manageEmptyCntr(RepoBkgForUpdateVO repoBkgForUpdateVO, String trunkVvd, SignOnUserAccount account) throws EventException {

        String cntrNo = "";
        try {
            BookingUtil utilBC = new BookingUtil();             

            String bkgNo = repoBkgForUpdateVO.getBkgBlNoVO().getBkgNo();
            RepoCntrVO[] repoCntrVOs = repoBkgForUpdateVO.getRepoCntrVOs();
            RepoBkgVO repoBkgVO = repoBkgForUpdateVO.getRepoBkgVO();   
            
            boolean isMasterBkgNo = false;
            String masterBkgNo = "";
            BkgBlNoVO masterBkgBlNoVO = new BkgBlNoVO();
            
            if(bkgNo.length() == 11){
                isMasterBkgNo = true;
                masterBkgNo = bkgNo;
            }else if(bkgNo.length() == 13){
                masterBkgNo = bkgNo.substring(0,11);
                masterBkgBlNoVO.setBkgNo(masterBkgNo);
            }else{
                // searchMtyMasterBkg() Execute             
                masterBkgNo = utilBC.searchSplitMstBkgNo(bkgNo);
                if(masterBkgNo == null || masterBkgNo.length() < 1){
                    isMasterBkgNo = true;
                }else{
                    masterBkgBlNoVO.setBkgNo(masterBkgNo);
                }
            }   
            
            //배치에서는 svrId 필요가 없다.
            //String svrId = utilBC.searchSvrByOfc(account.getOfc_cd());
            
            String [] arrCntrList = utilBC.searchCntrListByBkg(repoBkgForUpdateVO.getBkgBlNoVO());
            //list
            List<String> cntrList = new ArrayList<String>();
            for(int icnt=0;icnt<arrCntrList.length;icnt++){
            	cntrList.add(arrCntrList[icnt]);
            }
            
            boolean isInsertCntr = true;
//            String cntrNo = "";
            String cntrBkgNo = "";
			int cntrIdx = 0;
			int vlCntrCnt = 0;

            MtyCntrStsVO mtyCntrStsVO = null;
            BkgContainerVO bkgContainerVO = null;
            List<CusCtmMovementVO> ctmMvmtVOs = new ArrayList<CusCtmMovementVO>();
            log.debug(">>>>>>>>>>>>>>repoCntrVOs.length:"+repoCntrVOs.length);
            if(repoCntrVOs == null || repoCntrVOs.length==0){
            	return ctmMvmtVOs;
            }
            for(int i = 0 ; i < repoCntrVOs.length ; i++){
                cntrNo = repoCntrVOs[i].getCntrNo() + repoCntrVOs[i].getCntrNoPst();

            	// 32. Check the status of cntr -> searchMtyCntrSts()Execute.
                mtyCntrStsVO = dbDao.searchMtyCntrSts(cntrNo, masterBkgNo);                               

                if("D".equals(repoCntrVOs[i].getIbflag())){
                 	if(isMasterBkgNo){
						if("VL".equals(mtyCntrStsVO.getCnmvStsCd())){
							BkgBlNoVO polBkg = new BkgBlNoVO();
							polBkg.setBkgNo(bkgNo);
							if(mtyCntrStsVO.getSvrId().equals(utilBC.searchPolSvcByBkgNo(polBkg))){
								if("N".equals(mtyCntrStsVO.getPreStsFlg())){
									throw new EventException((String)new ErrorHandler("BKG00951",new String[]{cntrNo,mtyCntrStsVO.getCnmvStsCd()}).getMessage());
								}
							}
	                    }
                	}
                    if(!isMasterBkgNo){
                        // 38. 'origin bkg'  cntr send
                        dbDao.copyMtyCntrToMst(bkgNo, cntrNo, masterBkgBlNoVO, account);
                    }                   
                    // 39. cntr delete
                    dbDao.removeMtyCntr(cntrNo, repoBkgForUpdateVO.getBkgBlNoVO());                                  
                }else{
                    if("Y".equals(mtyCntrStsVO.getMtySocCntr())){
//                      if(dbDao.searchMtySocCntrCheck(cntrNo)){
                        throw new EventException((String)new ErrorHandler("BKG00948",new String[]{cntrNo}).getMessage());   
                    }       
                    if("Y".equals(mtyCntrStsVO.getImdtExtFlg())){
                    	throw new EventException((String)new ErrorHandler("BKG02025",new String[]{cntrNo}).getMessage());
                    }
                    // searchMtyCntrSts()result -> aciac_div_cd(active/inactive) <> 'A':ACT -> message[BKG00952] sow -> stop
                    if(!"A".equals(mtyCntrStsVO.getAciacDivCd())){
                        throw new EventException((String)new ErrorHandler("BKG00952",new String[]{cntrNo}).getMessage());
                    }                   

                	// UPDATE does not apply when
                	if("I".equals(repoCntrVOs[i].getIbflag())){

	                	if(!mtyCntrStsVO.getLocCd().equals(repoBkgVO.getBkgPolCd())){
	                		throw new EventException((String)new ErrorHandler("BKG02024",new String[]{cntrNo}).getMessage());
	                	}                		
	                	// 31. Used to determine whether Booking -> searchMtyCntrReserve()Execution
	                	cntrBkgNo = dbDao.searchMtyCntrReserve(cntrNo, repoBkgVO.getBkgNo(), repoBkgVO.getBkgPolCd(), repoBkgVO.getBkgTrunkVvd());
	                    if(cntrBkgNo != null && cntrBkgNo.length() > 0){
	                    	if(!cntrBkgNo.equals(masterBkgNo)){ 
	                    		throw new EventException((String)new ErrorHandler("BKG00949",new String[]{cntrNo,cntrBkgNo}).getMessage());
	                    	}
	                    }    

                		if(masterBkgNo != null && masterBkgNo.length()>10 && masterBkgNo.equals(cntrBkgNo)){ 
                			if(!"VL".equals(mtyCntrStsVO.getCnmvStsCd())){
		                    	throw new EventException((String)new ErrorHandler("BKG00951",new String[]{cntrNo,mtyCntrStsVO.getCnmvStsCd()}).getMessage());                    	
		                    }
                		} else {       			
		                    if("VL".equals(mtyCntrStsVO.getCnmvStsCd()) && "N".equals(mtyCntrStsVO.getPreStsFlg())){
		                    	throw new EventException((String)new ErrorHandler("BKG00951",new String[]{cntrNo,mtyCntrStsVO.getCnmvStsCd()}).getMessage());                    	
		                    }
		                    // cnmvStsCd = "ID" or cnmvStsCd <>"MT"->  Message[BKG00951] show -> stop
		                    if(!"ID".equals(mtyCntrStsVO.getCnmvStsCd()) && !"MT".equals(mtyCntrStsVO.getCnmvStsCd()) && !"VL".equals(mtyCntrStsVO.getCnmvStsCd()) && !"VL".equals(mtyCntrStsVO.getCnmvStsCd())){
		                        throw new EventException((String)new ErrorHandler("BKG00951",new String[]{cntrNo,mtyCntrStsVO.getCnmvStsCd()}).getMessage());
		                    }
                		}
                		// searchMtyCntrSts() result-> cnmvStsCd, svrId compare svr_id and searchSvrByOfc(login office) result  -> false -> Message [BKG00950] view-> stop
                		// svrId 배치에서는 필요가 없다.
	                    /*if(!svrId.equals(mtyCntrStsVO.getSvrId())){
	                        throw new EventException((String)new ErrorHandler("BKG00950",new String[]{cntrNo,mtyCntrStsVO.getSvrId()}).getMessage());
	                    } */
                	}
                    
                    // if any master BKG: removeMtyCntr()Execution -> master  cntr delete
                    if(!isMasterBkgNo){
                        dbDao.removeMtyCntr(cntrNo, masterBkgBlNoVO);
                    }
                    // addMtyBkgContainer Execution : bkg_container insert 
                    bkgContainerVO = new BkgContainerVO();
                    bkgContainerVO.setBkgNo(bkgNo);
                    bkgContainerVO.setCntrNo(cntrNo);
                    bkgContainerVO.setCntrTpszCd(repoCntrVOs[i].getTpszCd());
                    bkgContainerVO.setCnmvStsCd(mtyCntrStsVO.getCnmvStsCd());
                    bkgContainerVO.setMcntrBdlNo(repoCntrVOs[i].getBdlNo());
                    if("Y".equals(repoCntrVOs[i].getBdlBtmFlg()) || "1".equals(repoCntrVOs[i].getBdlBtmFlg())){
                    	bkgContainerVO.setBdlBtmFlg("Y");
                    }else{
                    	bkgContainerVO.setBdlBtmFlg("N");
                    }
                    bkgContainerVO.setCreUsrId(account.getUsr_id());
                    bkgContainerVO.setUpdUsrId(account.getUsr_id());
                    
                    isInsertCntr = true;
                    
                    cntrIdx = -1;
                    cntrIdx = cntrList.indexOf(cntrNo);
                    if(-1<cntrIdx){
                    	isInsertCntr = false;
                    	cntrList.remove(cntrIdx);
                    }
//                    for(int icnt=0;icnt<cntrList.length;icnt++){
//                    	if(bkgContainerVO.getCntrNo().equals(cntrList[icnt])){
//                    		isInsertCntr = false;
//                    		break;
//                    	}
//                    }
                    
                    if(isInsertCntr){
                    	dbDao.addMtyBkgContainer(bkgContainerVO, account);                    	
                    } else {
                    	dbDao.modifyMtyBkgContainer(bkgContainerVO);
                    }
                    
					if("VL".equals(mtyCntrStsVO.getCnmvStsCd())){
						ctmMvmtVOs.add(vlCntrCnt, new CusCtmMovementVO());
						ctmMvmtVOs.get(vlCntrCnt).setBkgNo(bkgNo);
						ctmMvmtVOs.get(vlCntrCnt).setBlNo(repoBkgForUpdateVO.getBkgBlNoVO().getBlNo());
						ctmMvmtVOs.get(vlCntrCnt).setCntrNo(cntrNo);
						ctmMvmtVOs.get(vlCntrCnt).setMvmtStsCd(mtyCntrStsVO.getCnmvStsCd());
						ctmMvmtVOs.get(vlCntrCnt).setCnmvYr(mtyCntrStsVO.getCnmvYr());
						ctmMvmtVOs.get(vlCntrCnt).setCnmvIdNo(mtyCntrStsVO.getCnmvIdNo());
						ctmMvmtVOs.get(vlCntrCnt).setCrntVslCd(trunkVvd.substring(0, 4));
						ctmMvmtVOs.get(vlCntrCnt).setCrntSkdVoyNo(trunkVvd.substring(4, 8));
						ctmMvmtVOs.get(vlCntrCnt).setCrntSkdDirCd(trunkVvd.substring(8, 9));
						ctmMvmtVOs.get(vlCntrCnt).setTrnkVslCd(trunkVvd.substring(0, 4));
						ctmMvmtVOs.get(vlCntrCnt).setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
						ctmMvmtVOs.get(vlCntrCnt).setTrnkSkdDirCd(trunkVvd.substring(8, 9));
						vlCntrCnt++;
					}
                }
            }
            
            // 40. searchMtyBlDesc() result-> string [] array -> new line add  after 4 row          
            String[] blDesc = dbDao.searchMtyBlDesc(repoBkgForUpdateVO.getBkgBlNoVO());
            String cmdtDesc = "";
            for(int i = 0 ; i < blDesc.length ; i++){
                if(i < 1){
                    cmdtDesc = blDesc[i];
                }else{
                    if(i > 1 && i%4 == 1){
                        cmdtDesc = cmdtDesc + "\n" + blDesc[i];
                    }else{
                        cmdtDesc = cmdtDesc + " " + blDesc[i];
                    }
                }
            }
            // 40 result + new line + "       EMPTY CONTAINER (OPUS Co.)"append -> bkg_bl_mk_desc.cmdt_desc put in
            cmdtDesc = cmdtDesc + "\n" + "       EMPTY CONTAINER (OPUS Co.)";

            /* bkgBlMkDescVO */
            BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
            blMkDescVO.setBkgNo(bkgNo);
            blMkDescVO.setMkDesc("N/A");
            blMkDescVO.setCmdtDesc(cmdtDesc);
            blMkDescVO.setMkSeq("1");
            blMkDescVO.setCreUsrId(account.getUsr_id());
            blMkDescVO.setUpdUsrId(account.getUsr_id());                
            
            // 41. modifyMnd()execution -> bkg_bl_mk_desc table insert    
            dbDao.modifyMnd(blMkDescVO,"N");

            return ctmMvmtVOs;
        } catch (EventException ex) {
            throw ex;                   
        } catch (DAOException ex) {
        	log.error(cntrNo);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
	 * bkg_bl_doc table update.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgClose (BkgCoffTmVO[] bkgCoffTmVOs, SignOnUserAccount account)throws EventException{
		try {
			for ( int i=0; i<bkgCoffTmVOs.length; i++ ) {
				dbDao.modifyBkgCoffTm(bkgCoffTmVOs[i],account);
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
	 * BL DOC modify
	 * 
	 * @param bkgBlDocVO
	 * @throws EventException
	 */
	public void modifyBlDoc(BkgBlDocVO bkgBlDocVO) throws EventException {
		
		try {
			
			dbDao.modifyBlDoc(bkgBlDocVO);
			
		}catch (DAOException de) 
		{
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), de);
		} 
		catch (Exception ex) 
		{
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), ex);
		}
	}
	
    
	/**
	 * Modification event<br>
	 * Indonesian customs modify the target data transmission<br>
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account)
			throws EventException {
		try {
			for (int i = 0; i < manifestModificationVOs.length; i++) {
				if (((IndonesiaManifestModificationVO) manifestModificationVOs[i]).getIbflag().equals("I")) {
					((IndonesiaManifestModificationVO) manifestModificationVOs[i]).setCreUsrId(account.getUsr_id());
					dbDao.addManifest((IndonesiaManifestModificationVO) manifestModificationVOs[i]);
				}
				if (((IndonesiaManifestModificationVO) manifestModificationVOs[i]).getIbflag().equals("U")) {
					((IndonesiaManifestModificationVO) manifestModificationVOs[i]).setUpdUsrId(account.getUsr_id());
					dbDao.modifyManifest((IndonesiaManifestModificationVO) manifestModificationVOs[i], account);
				}
				if (((IndonesiaManifestModificationVO) manifestModificationVOs[i]).getIbflag().equals("D")) {
					dbDao.removeManifest((IndonesiaManifestModificationVO) manifestModificationVOs[i]);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}    

	/**
	 * Vessel Schedule B/L Data Release save. (ESM_BKG_0596)<br>
	 * container BDR handling  .
	 * 
	 * @param String bkgNo
	 * @param String flag
	 * @param String usrId
	 * @exception EventException
	 */	
	public void modifyCntrCFM(String bkgNo, String flag, String usrId) throws EventException {
		
		try {
			dbDao.modifyCntrCFM(bkgNo, flag, usrId);
			//dbDao.modifyBKGBDR(vos[i]);	
		} catch(EventException ex) {
			throw ex;
    
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
     
	}	
	/**
	 * Vessel Schedule B/L Data Release save. (ESM_BKG_0596)<br>
	 * BKG_BL_DOC BDR handling.
	 * 
	 * @param String bkgNo
	 * @param String flag
	 * @param String usrId
	 * @exception EventException
	 */	
	public void modifyBKGBDR(String bkgNo, String flag, String usrId) throws EventException {
		
		try {
			dbDao.modifyBKGBDR(bkgNo, flag, usrId);
		} catch(EventException ex) {
			throw ex;
    
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
     
	}

	/**
     * eBKG -> House B/L, B/L Customer, Manifest To handle. -- UI_BKG-0366
     * @param HblVO hblVO
	 * @param XterRqstNoVO rqstNoVO 
     * @param SignOnUserAccount account
     * @param String caFlg
     * @exception EventException
     */
    public void manageHblByXter(HblVO hblVO, XterRqstNoVO rqstNoVO, SignOnUserAccount account, String caFlg) throws EventException{
        List<HblDtlInfoVO> hblDtlVO = hblVO.getHblDtlInfoVOs();
        try {
            /* hbl */
            if(hblDtlVO != null){
                List<BkgHblVO> updateHblList = new ArrayList<BkgHblVO>();
                List<BkgHblVO> deleteHblList = new ArrayList<BkgHblVO>();
                List<BkgHblCustVO> updateHblCustList = new ArrayList<BkgHblCustVO>();
                List<BkgHblCustVO> deleteHblCustList = new ArrayList<BkgHblCustVO>();
                for(int i = 0; i < hblDtlVO.size(); i++) {
                    BkgHblVO bkgHblVO = new BkgHblVO();
                    ObjectCloner.build(hblDtlVO.get(i), bkgHblVO);
                    bkgHblVO.setXterSiNo(rqstNoVO.getRqstNo());
                    bkgHblVO.setXterSiSeq(rqstNoVO.getRqstSeq());
                    bkgHblVO.setCreUsrId(account.getUsr_id());
                    bkgHblVO.setUpdUsrId(account.getUsr_id());
                    
                    BkgHblCustVO bkgHblShprVO = new BkgHblCustVO();
                    bkgHblShprVO.setBkgNo       (hblDtlVO.get(i).getBkgNo());
                    bkgHblShprVO.setHblSeq      (hblDtlVO.get(i).getHblSeq());
                    bkgHblShprVO.setBkgCustTpCd ("S");
                    bkgHblShprVO.setCustCntCd   ("");
                    bkgHblShprVO.setCustSeq     ("");
                    bkgHblShprVO.setCustNm      (hblDtlVO.get(i).getShprNm());
                    bkgHblShprVO.setCustAddr    (hblDtlVO.get(i).getShprAddr());
                    bkgHblShprVO.setCreUsrId    (account.getUsr_id());
                    bkgHblShprVO.setUpdUsrId    (account.getUsr_id());

                    BkgHblCustVO bkgHblCneeVO = new BkgHblCustVO();
                    bkgHblCneeVO.setBkgNo       (hblDtlVO.get(i).getBkgNo());
                    bkgHblCneeVO.setHblSeq      (hblDtlVO.get(i).getHblSeq());
                    bkgHblCneeVO.setBkgCustTpCd ("C");
                    bkgHblCneeVO.setCustCntCd   ("");
                    bkgHblCneeVO.setCustSeq     ("");
                    bkgHblCneeVO.setCustNm      (hblDtlVO.get(i).getCneeNm());
                    bkgHblCneeVO.setCustAddr    (hblDtlVO.get(i).getCneeAddr());
                    bkgHblCneeVO.setCreUsrId    (account.getUsr_id());
                    bkgHblCneeVO.setUpdUsrId    (account.getUsr_id());

                    BkgHblCustVO bkgHblNotiVO = new BkgHblCustVO();
                    bkgHblNotiVO.setBkgNo       (hblDtlVO.get(i).getBkgNo());
                    bkgHblNotiVO.setHblSeq      (hblDtlVO.get(i).getHblSeq());
                    bkgHblNotiVO.setBkgCustTpCd ("N");
                    bkgHblNotiVO.setCustCntCd   ("");
                    bkgHblNotiVO.setCustSeq     ("");
                    bkgHblNotiVO.setCustNm      (hblDtlVO.get(i).getNotiNm());
                    bkgHblNotiVO.setCustAddr    (hblDtlVO.get(i).getNotiAddr());
                    bkgHblNotiVO.setCreUsrId    (account.getUsr_id());
                    bkgHblNotiVO.setUpdUsrId    (account.getUsr_id());

                    if("I".equals(hblDtlVO.get(i).getIbflag())) {
                        updateHblList.add(bkgHblVO);
                        updateHblCustList.add(bkgHblShprVO);
                        updateHblCustList.add(bkgHblCneeVO);
                        updateHblCustList.add(bkgHblNotiVO);
                    } else if("U".equals(hblDtlVO.get(i).getIbflag())) {
                        updateHblList.add(bkgHblVO);
                        updateHblCustList.add(bkgHblShprVO);
                        updateHblCustList.add(bkgHblCneeVO);
                        updateHblCustList.add(bkgHblNotiVO);
                    } else if("D".equals(hblDtlVO.get(i).getIbflag())) {
                        deleteHblList.add(bkgHblVO);
                        deleteHblCustList.add(bkgHblShprVO);
                    }
                }

                if(deleteHblCustList.size() > 0) {
                    dbDao.removeHblCusts(deleteHblCustList, caFlg);
                }
                if(deleteHblList.size() > 0) {
                    dbDao.removeHbls(deleteHblList, caFlg);
                }
                if(updateHblList.size() > 0) {
                    for(int i=0;i<updateHblList.size();i++){
                        dbDao.manageHblByXter(updateHblList.get(i), caFlg);
                    }                
                }
                if(updateHblCustList.size() > 0) {
                    for(int i=0;i<updateHblCustList.size();i++){
                        dbDao.manageHblCustByXter(updateHblCustList.get(i), caFlg);
                    }                  
                }
            }
        } catch(DAOException ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
	/**
     * eBKG : Export licens handling. -- UI_BKG-0229-04
     * @param BkgBlNoVO bkgBlNoVO
	 * @param OpusXptImpLicListVO[] opusXptImpLicListVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageXptLicByXter(BkgBlNoVO bkgBlNoVO, OpusXptImpLicListVO[] opusXptImpLicListVOs, SignOnUserAccount account) throws EventException{
        try {        	
            dbDao.removeXptLicNoByXter(bkgBlNoVO);
            if(opusXptImpLicListVOs != null && opusXptImpLicListVOs.length>0){
	            for(int i=0;i<opusXptImpLicListVOs.length;i++){
	            	dbDao.addXptLicNoByXter(bkgBlNoVO, opusXptImpLicListVOs[i], account);
	            }
            }
        } catch(DAOException ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
}