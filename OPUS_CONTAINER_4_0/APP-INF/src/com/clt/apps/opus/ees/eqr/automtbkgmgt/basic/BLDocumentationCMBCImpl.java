/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BLDocumentationCMBCImpl.java
 *@FileTitle : Container No Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.clt.apps.opus.esm.bkg.common.Constants;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration.BLDocumentationCMDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmByCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCntrInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCopyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmDescInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmEtcInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrDetailInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrInfoOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrKrWhfExptVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrMoveOpInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrMstInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrMvmtRtnVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.EdiNotUpdCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MaxCycleBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.PreConfirmBkgVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.RataBkgQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCntrMvmtRtnVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgDgCgoVO;
import com.clt.syscommon.common.table.MstContainerVO;


/**
 * OPUS-OutboundBLMgt Business Logic Basic Command implementation<br>
 * - OPUS-OutboundBLMgt business logic handling<br>
 * 
 * @author
 * @see UI_BKG-0892EventResponse,BLDocumentationCMBC each DAO Class reference
 * @since J2EE 1.4
 */
public class BLDocumentationCMBCImpl extends BasicCommandSupport implements BLDocumentationCMBC { 

    // Database Access Object
    private transient BLDocumentationCMDBDAO dbDao = null;

    /**
     * BLDocumentationCMBCImpl object creation<br>
     * BLDocumentationCMDBDAO creation<br>
     */
    public BLDocumentationCMBCImpl() {
        dbDao = new BLDocumentationCMDBDAO();
    }

    /**
     * retrieve each Container in order to copy C/M based on T.VVD, BKG Office, POL, POD<br>
     * 
     * @param String vvd
     * @param String ofcCd
     * @param String pol
     * @param String pod
     * @param String cfmYn
     * @return List<CmCopyVO>
     * @exception EventException
     */
    public List<CmCopyVO> searchCntrListByVvd(String vvd, String ofcCd, String pol, String pod, String cfmYn) throws EventException {

        try {
            if(vvd == null) {
                throw new EventException("BKG00115");
            }
            if(vvd.length() != 9) {
                throw new EventException("BKG00780");
            }
            return dbDao.searchCntrListByVvd(vvd, ofcCd, pol, pod, cfmYn);
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * container seal number information retrieve
     * @param BkgBlNoVO bkgBlNoVO
     * @return List<BkgBlNoVO>
     * @exception EventException
     */
    public List<BkgBlNoVO> searchMultiSeal(BkgBlNoVO bkgBlNoVO) throws EventException {
        // try {
        // dbDao.searchMultiSeal(bkgBlNoVO);
        // } catch (DAOException ex) {
        // throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        // }
        return null;//
    }

    /**
     * retrieve event handling<br>
     * BLDocumentation screen retrieve event handling<br>
     * 
     * @param String bkgNo
     * @return List<EdiNotUpdCntrVO>
     * @exception EventException
     */
    public List<EdiNotUpdCntrVO> searchNotUpdCntr(String bkgNo) throws EventException {
        try {
            return dbDao.searchNotUpdCntr(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * retrieve event handling<br>
     * BLDocumentation screen retrieve event handling<br>
     * 
     * @param String cntrNo
     * @return CntrDetailInfoVO
     * @exception EventException
     */
    public CntrDetailInfoVO searchCntrDtlInfo(String cntrNo) throws EventException {
        try {
            return dbDao.searchCntrDtlInfo(cntrNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * confirm BKG of Container Confirm status among Partial Container Booking as same VVD and Container No -- UI_BKG-0079-04
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @return String
     * @exception EventException
     */
    public String searchPartialConfirm(String bkgNo, String cntrNo) throws EventException{
        try {
            return dbDao.searchPartialConfirm(bkgNo, cntrNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * container information retrieve -- UI_BKG-0172, 
     * BKG CONTAINER, BKG CONTAINER SEAL NUMBER, BKG BOOKING, BKG DOCUMENT PROCESS SCHEDULE, BKG RATE etc.
     * @param String bkgNo
     * @param String caFlg
     * @return CntrInfoOutVO
     * @exception EventException
     */
    public CntrInfoOutVO searchContainer(String bkgNo, String caFlg) throws EventException {

        CntrInfoOutVO cntrInfoOutVO = new CntrInfoOutVO();
        try {
            CntrEtcInfoVO etcInfoVO = dbDao.searchEtcInfoForCntr(bkgNo, caFlg);
            List<EdiNotUpdCntrVO> list = dbDao.searchNotUpdCntr(bkgNo);
            if(list !=null && list.size() > 0){
                etcInfoVO.setNotUpdatedFlg("Y");
            }
            
            cntrInfoOutVO.setCntrEtcInfo(etcInfoVO);
            cntrInfoOutVO.setCntrTpszQtys(dbDao.searchQtyForCntrByTpsz(bkgNo, caFlg));
            cntrInfoOutVO.setCntrPkgWgts(dbDao.searchPkgForCntr(bkgNo, caFlg));
            cntrInfoOutVO.setCntrs(dbDao.searchContainer(bkgNo, caFlg));
            cntrInfoOutVO.setCntrSealNos(dbDao.searchSealNo(bkgNo, null, caFlg));
            cntrInfoOutVO.setRataBkgQtys(dbDao.searchBkgCntrVol(bkgNo, caFlg));

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return cntrInfoOutVO;
    }

    /**
     * create/modify container information
     * @param List<ContainerVO> updateVoList
     * @param String caFlg
     * @exception EventException
     */
    public void manageContainer(List<ContainerVO> updateVoList, String caFlg) throws EventException {
        try {
            int len = updateVoList == null ? 0 : updateVoList.size();
            for (int i = 0; i < len; i++) {
                ContainerVO cntrVo = updateVoList.get(i);
                log.debug("***** Manage Container : " + cntrVo.getIbflag() + " - " + cntrVo.getCntrNo());
                if(dbDao.updateContainer(cntrVo, caFlg) == 0){
                    dbDao.insertContainer(cntrVo, caFlg);
                }
            }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * create/modify container information
     * @param List<ContainerVO> updateVoList
     * @exception EventException
     */
    public void manageContainerByXter(List<ContainerVO> updateVoList) throws EventException {
        try {
            log.debug("***** updateVoList : " + (updateVoList == null ? 0 : updateVoList.size()));
            if(updateVoList!=null && updateVoList.size() > 0) {
                dbDao.manageContainerByXterS(updateVoList);
            }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * Container is copied to another booking. -- UI_BKG-0170, BKG CONTAINER
     * 
     * @param CntrCopyVO cntrCopyVO
     * @exception EventException
     */
    public void copyContainer(CntrCopyVO cntrCopyVO) throws EventException {
        // check Origin Booking No.
        String srcBkgNo = cntrCopyVO.getSrcBkgNo();
        String tgtBkgNo = cntrCopyVO.getTgtBkgNo();
        String originFlg = cntrCopyVO.getOriginFlg();
        log.debug("##########> Source Booking : " + srcBkgNo);
        log.debug("##########> Target Booking : " + tgtBkgNo);
        log.debug("##########> Origin Flag    : " + originFlg);

        BookingUtil utilCmd = new BookingUtil();

        // for check status
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        BkgBlNoVO blNoVO = null;
        try {
            // check Source Booking Status
            bkgBlNoIN.setBkgNo(srcBkgNo);
            bkgBlNoIN.setCaUsrId(cntrCopyVO.getCreUsrId());
            blNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(blNoVO == null || blNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{tgtBkgNo}).getMessage());
            }
            String srcStsCd = blNoVO.getBkgStsCd();
            String srcCaFlg = blNoVO.getCaFlg();            
            log.debug("##########> BKG_STATUS : " + srcBkgNo + " - " + srcStsCd);
            if("X".equals(srcStsCd)) {
                throw new EventException(new ErrorHandler("BKG00113", new String[]{srcBkgNo}).getMessage());
            }
            // check Target Booking Status
            bkgBlNoIN.setBkgNo(tgtBkgNo);
            bkgBlNoIN.setCaUsrId(cntrCopyVO.getCreUsrId());
            blNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(blNoVO == null || blNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{tgtBkgNo}).getMessage());
            }
            String tgtStsCd = blNoVO.getBkgStsCd();
            String tgtCaFlg = blNoVO.getCaFlg();
            log.debug("##########> BKG_STATUS : " + tgtBkgNo + " - " + tgtStsCd);
            if("X".equals(tgtStsCd)) {
                throw new EventException(new ErrorHandler("BKG00113", new String[]{tgtBkgNo}).getMessage());
            }
            log.debug("##########> BKG_CA_FLAG : " + tgtBkgNo + " - " + tgtCaFlg);
            if("Y".equals(tgtCaFlg)) {
                throw new EventException(new ErrorHandler("BKG08036", new String[]{tgtBkgNo}).getMessage());
            }
            //
            String nCntrNo = dbDao.searchCntrDupByCntr(cntrCopyVO);
            log.debug("##########> BKG_CNTR_NO: " + tgtBkgNo + " - " + nCntrNo);
            if(nCntrNo != null && nCntrNo.length() > 0){
                throw new EventException(new ErrorHandler("BKG00965", new String[]{nCntrNo, tgtBkgNo}).getMessage());
            }
            // check Booking Route
            boolean flag = dbDao.checkRouteForMoveCntr(cntrCopyVO.getSrcBkgNo(), tgtBkgNo);
            if(flag) {
                dbDao.copyBkgCntrByCntr(cntrCopyVO, srcCaFlg);
                dbDao.copyBkgCntrSealByCntr(cntrCopyVO, srcCaFlg);
                dbDao.copyCmByCntr(cntrCopyVO, srcCaFlg);
            } else {
                throw new EventException(new ErrorHandler("BKG00114", new String[]{tgtBkgNo}).getMessage());
            }
            dbDao.modifyCntrCfmFlgByBkg(tgtBkgNo, "N", "N");
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Container information is moved to another booking. -- UI_BKG-0170, BKG CONTAINER
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @exception EventException
     */
    public void moveContainer(String bkgNo, String cntrNo, String caFlg) throws EventException {
        try {
            dbDao.removeCntrSealNo(bkgNo, cntrNo, "", caFlg);
            dbDao.removeCmByCntr(bkgNo, cntrNo, caFlg);
            dbDao.removeContainer(bkgNo, cntrNo, caFlg);
            dbDao.modifyCntrCfmFlgByBkg(bkgNo, "N", caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Make sure your container confrim possible.
     * method in BC 
     * @param CntrEtcInfoVO cntrEtcInfoVO
     * @param ContainerVO[] containerVOs
     * @param String fnlCfmFlg
     * @exception EventException
     */
    public void validateContainerConfirm(CntrEtcInfoVO cntrEtcInfoVO, ContainerVO[] containerVOs, String fnlCfmFlg) throws EventException {
        try {
	        int len = containerVOs == null ? 0 : containerVOs.length;
	        for(int i = 0; i < len; i++) {
	            String ibFlag = containerVOs[i].getIbflag();
	            log.debug(">" + containerVOs[i].getCntrNo() + " : ibFlag=" + ibFlag + ", CntrCfmFlg=" + containerVOs[i].getCntrCfmFlg()+ ", fnlCfmFlg=" + fnlCfmFlg);
	            log.debug(">" + containerVOs[i].getCntrNo() + " : getCntrPrtFlg=" + containerVOs[i].getCntrPrtFlg());
	            	            
		    	if("Y".equals(fnlCfmFlg)) {
		            if("1".equals(containerVOs[i].getCntrPrtFlg()) && !"D".equals(ibFlag)){
		                //searchPartialBkg ( bkgNo , cntrNo , caFlag );
		                String rstr = dbDao.searchPartialBkg (containerVOs[i]);
		                if(rstr != null && rstr.length() > 0){
		                    throw new EventException(new ErrorHandler("BKG00706", new String[]{cntrEtcInfoVO.getTVvd() + ".\n     " + rstr}).getMessage());                            
		                }
		            }	            

		            if(!"D".equals(ibFlag)){
		                PreConfirmBkgVO preConfirmBkgVO = dbDao.searchConfirmOthBkg (containerVOs[i].getBkgNo(), containerVOs[i].getCntrNo(), cntrEtcInfoVO.getCorrFlg());
		                log.debug(">searchConfirmOthBkg" + preConfirmBkgVO);
		                if(preConfirmBkgVO != null && "NNNNN".equals(preConfirmBkgVO.getPorStsVvd())){
		                    throw new EventException(new ErrorHandler("BKG08180", new String[]{containerVOs[i].getCntrNo(), preConfirmBkgVO.getPreBkgNo()}).getMessage());                            
		                }
		            }
		//            if("1".equals(containerVOs[i].getDcgoFlg())){
		//                String asignImg = dbDao.checkCntrNoAsgnForImage(containerVOs[i]);
		//                if(Integer.parseInt(asignImg) < 0) {
		//                    throw new EventException("validateContainer=>checkCntrNoAsgnForImage");
		//                }
		//            }
		//            // Cargo Quanatity
		//            BkgQuantityVO quantityVO = dbDao.searchBkgQty(bkgBlNoVO);
		//            if(quantityVO == null) {
		//                throw new EventException("validateContainer=>searchBkgQty");
		//            }
		//            List<BkgQtyDtlVO> qtyDtlVos = dbDao.searchBkgQtyDtl(bkgBlNoVO);
		//            if(qtyDtlVos == null) {
		//                throw new EventException("validateContainer=>searchBkgQtyDtl");
		//            }
		//            List<CntrTpszQtyVO> tpszQtyVos = dbDao.searchSpclQty(containerVOs[i].getBkgNo());
		//            if(tpszQtyVos == null || tpszQtyVos.size() == 0) {
		//                throw new EventException("validateContainer=>searchSpclQty");
		//            }
		        }
	        }// end of FOR
	    } catch(EventException ex) {
	        throw ex;
	//    } catch(DAOException ex) {
	//        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch(Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
    }
    
    /**
     * Make sure your container information can save
     * method in BC
     * @param CntrEtcInfoVO cntrEtcInfoVO
     * @param ContainerVO[] containerVOs
     * @param String fnlCfmFlg
     * @return List<Map<String,Object>>
     * @exception EventException
     */
    public List<Map<String,Object>> validateContainer(CntrEtcInfoVO cntrEtcInfoVO, ContainerVO[] containerVOs, String fnlCfmFlg) throws EventException {
        /*
         * TODO Check Validation before save Container
         */
    	Map<String,Object> retMap = null;
    	List<Map<String,Object>> copCallList = null;
        try {
            // GeneralBookingReceiptBC receiptCmd = new GeneralBookingReceiptBCImpl();
            // BookingUtil utilCmd = new BookingUtil();

            //BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            //bkgBlNoVO.setBkgNo(cntrEtcInfoVO.getBkgNo());
            // bkgBlNoVO.setBkgNoSplit(containerVOs[i].getBkgNoSplit());

        	copCallList = new ArrayList<Map<String,Object>>();
            int len = containerVOs == null ? 0 : containerVOs.length;
            for(int i = 0; i < len; i++) {
                String ibFlag = containerVOs[i].getIbflag();
                log.debug(">" + containerVOs[i].getCntrNo() + " : ibFlag=" + ibFlag + ", CntrCfmFlg=" + containerVOs[i].getCntrCfmFlg());
                
                /**
                 * checking Container validation
                 */
                CntrMstInfoVO cntrVO = dbDao.searchMstContainer(containerVOs[i].getCntrNo());
                if(cntrVO == null || cntrVO.getCntrNo() == null){
                    throw new EventException(new ErrorHandler("BKG00173", new String[]{containerVOs[i].getCntrNo()}).getMessage());
                }                
                
                /*
                 * Container Attach Validation Skip
                 */
                CntrMstInfoVO cntrRstfVO = dbDao.searchRstfCntr(containerVOs[i].getCntrNo(), containerVOs[i].getCntrNoOld(), containerVOs[i].getBkgNo());
                if(cntrRstfVO != null  && !"".equals(cntrRstfVO.getCntrNo())){
                	// Container Attach Validation Skip
                	log.debug("***** restuffing *********");
                }else{
					if(null != containerVOs[i].getCntrNoOld() && !"".equals(containerVOs[i].getCntrNoOld()) 
							&& !containerVOs[i].getCntrNo().equals(containerVOs[i].getCntrNoOld())) {
						ibFlag = "M";
					}
	//				log.debug("\n\n\n $$$$ ibFlag:" + ibFlag + " old cntr:" +containerVOs[i].getCntrNoOld() + "$$$");
	                if("I".equals(ibFlag) || "M".equals(ibFlag) || "U".equals(ibFlag)) {
	                    this.validateContainerComm(cntrEtcInfoVO, containerVOs[i]);
	                }
	                if("I".equals(ibFlag) || "M".equals(ibFlag)) {
	                    retMap = this.validateContainerAttach(cntrEtcInfoVO, containerVOs[i]);
	                    if (null!=retMap) {
	                    	copCallList.add(retMap);
	                    }
	                }
	                if("D".equals(ibFlag) || "M".equals(ibFlag)) {
	                    this.validateContainerDetach(cntrEtcInfoVO, containerVOs[i]);
	                }
            }
                
//                if("Y".equals(fnlCfmFlg)) {
//                    List<CargoDtlVO> cargoDtlVOs = dbDao.searchCargoQtyDtl ( bkgBlNoVO );
//                }
            }// end of FOR
        } catch(EventException ex) {
            throw ex;
//        } catch(DAOException ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return copCallList;
    }

    /**
     * Make sure your container information can save
     * 
     * @param CntrEtcInfoVO bkgEtcInfoVO
     * @param ContainerVO containerVO
     * @exception EventException
     */
    private void validateContainerComm(CntrEtcInfoVO cntrEtcInfoVO, ContainerVO containerVO) throws EventException {
        try {
            if("Y".equals(containerVO.getAwkCgoFlg()) || "Y".equals(containerVO.getBbCgoFlg()) || "Y".equals(containerVO.getDcgoFlg()) || "Y".equals(containerVO.getRcFlg())){
                if(!dbDao.checkCntrNoAsgnForSpcl(containerVO)) {
                    throw new EventException(new ErrorHandler("BKG00191").getMessage());
                }
            }
            if(!"1".equals(containerVO.getCntrPrtFlg())) {
                String tgtBkgNo = dbDao.searchCntrDup(cntrEtcInfoVO, containerVO.getCntrNo());
                if(!"".equals(tgtBkgNo)){
                    throw new EventException(new ErrorHandler("BKG00966", new String[]{containerVO.getCntrNo(), tgtBkgNo}).getMessage());
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
     * Make sure your container information can add
     * @param CntrEtcInfoVO bkgEtcInfoVO
     * @param ContainerVO containerVO
     * @return Map<String,String>
     * @exception EventException
     */
    private Map<String,Object> validateContainerAttach(CntrEtcInfoVO cntrEtcInfoVO, ContainerVO containerVO) throws EventException {
        Map<String,Object> retMap = null;
        try {
            BookingUtil utilCmd = new BookingUtil();
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(cntrEtcInfoVO.getBkgNo());
            // bkgBlNoVO.setBkgNoSplit(containerVO.getBkgNoSplit());
            // booking status
            String bkg_sts_cd = utilCmd.searchBkgStatusByBkg(bkgBlNoVO);
            if(bkg_sts_cd != null && bkg_sts_cd.equals(Constants.BKG_STATUS_CANCEL)) {
                throw new EventException(new ErrorHandler("BKG00113").getMessage());
            }
//            if(!dbDao.checkCntrNoAsgnForSpcl(containerVO)) {
//                throw new EventException(new ErrorHandler("BKG00191").getMessage());
//            }
            // Master Container retrieve
            CntrMstInfoVO cntrMstInfoVO = dbDao.searchMstContainer(containerVO.getCntrNo());
            if(cntrMstInfoVO.getCntrNo() == null) {
                throw new EventException(new ErrorHandler("BKG00402", new String[]{containerVO.getCntrNo()}).getMessage());
            }
            if("Y".equals(cntrMstInfoVO.getDmgFlg())){
                throw new EventException(new ErrorHandler("BKG08047", new String[]{containerVO.getCntrNo()}).getMessage());
            }
            if("I".equals(cntrMstInfoVO.getAciacDivCd())){
                throw new EventException(new ErrorHandler("BKG08052", new String[]{containerVO.getCntrNo()}).getMessage());
            }
            if("Y".equals(cntrMstInfoVO.getImdtExtFlg())){
            	throw new EventException(new ErrorHandler("BKG95061", new String[]{containerVO.getCntrNo()}).getMessage());
            }
            // 
            String mstMvntStsCd = cntrMstInfoVO.getCnmvStsCd();
            String currAreaGrpId = dbDao.searchLocByBkgPor(cntrEtcInfoVO.getBkgNo());
            boolean isSameLoc = currAreaGrpId.equals(cntrMstInfoVO.getSysAreaGrpId());
            log.debug("[위치 일치 여부] = " +isSameLoc+ " [BKG=" +currAreaGrpId+ ", CNTR=" +cntrMstInfoVO.getSysAreaGrpId()+ "]");
            boolean vvdCheckFlag = false;
            MaxCycleBkgInfoVO cycleBkgInfoVO = new MaxCycleBkgInfoVO();

            if(isSameLoc) {
                // Movement Status
                String mvmtSts = dbDao.searchPreMvmtSts(containerVO);
                if(("EN".equals(mstMvntStsCd) || "TN".equals(mstMvntStsCd)) && ("ID".equals(mvmtSts) || "MT".equals(mvmtSts))) {
                    mstMvntStsCd = "MT";
                }
                cycleBkgInfoVO = dbDao.searchMaxCycleBkgBySameEcc(containerVO.getCntrNo());
                if(cycleBkgInfoVO == null) {
                    throw new EventException(new ErrorHandler("BKG00402", new String[]{containerVO.getCntrNo()}).getMessage());
                }
                if("ID".equals(mstMvntStsCd) || "MT".equals(mstMvntStsCd)) {
                    String maxAreaGrpId = dbDao.searchLocByBkgPor(cycleBkgInfoVO.getBkgNo());
                    if(currAreaGrpId.equals(maxAreaGrpId)) {
                        // VVD check
                        vvdCheckFlag = true;
                    }
                } else {
                    // VVD check
                    vvdCheckFlag = true;
                }
                
                log.error("@@@@@@@@@@ CHECK ATTACH CNTR @@@@@@@@@@:" + containerVO.getBkgNo());
                if(cycleBkgInfoVO.getVvd() != null) {
	                if(vvdCheckFlag && (cycleBkgInfoVO.getVvd().startsWith("COXX") || cycleBkgInfoVO.getVvd().startsWith("COYY") || cycleBkgInfoVO.getVvd().startsWith("COZZ"))) {
	                    log.debug("delete cntr : "+cycleBkgInfoVO.getBkgNo() + " vvd:" + cycleBkgInfoVO.getVvd());
	                    dbDao.removeCmByCntr(cycleBkgInfoVO.getBkgNo(), containerVO.getCntrNo(), "N");
	                    dbDao.removeCntrSealNo(cycleBkgInfoVO.getBkgNo(), containerVO.getCntrNo(), "", "N");
	                    retMap = dbDao.removeContainer(cycleBkgInfoVO.getBkgNo(), containerVO.getCntrNo(), "N");
	                    if (null!=retMap) {
	                    	retMap.put("cntrPrtFlg",containerVO.getCntrPrtFlg());
	                    	retMap.put("containerVO",containerVO);
	                    }
	                	log.debug("delete ok!");
	                    vvdCheckFlag = false;
	                }
                }
            } else {
                cycleBkgInfoVO = dbDao.searchMaxCycleBkgByDiffEcc(containerVO.getCntrNo());
                if(("PSEUDO00001".equals(cycleBkgInfoVO.getBkgNo()) && "PSDO9999W".equals(cycleBkgInfoVO.getVvd()))) {
                    vvdCheckFlag = false;
                } else {
                    // VVD check
                    vvdCheckFlag = true;
                }
            }
            log.debug("[VVD 체크 여부] = " +vvdCheckFlag);
            
            int maxCycleNo = (cycleBkgInfoVO.getCnmvCycNo() == null || cycleBkgInfoVO.getCnmvCycNo().equals("")) ? 0 : Integer.parseInt(cycleBkgInfoVO.getCnmvCycNo());
            int mstCycleNo = (cntrMstInfoVO.getCnmvCycNo() == null || cntrMstInfoVO.getCnmvCycNo().equals("")) ? 0 : Integer.parseInt(cntrMstInfoVO.getCnmvCycNo());
            String cycleBkgCgoTp = (cycleBkgInfoVO.getBkgCgoTpCd() == null || cycleBkgInfoVO.getBkgCgoTpCd().equals("")) ? "" : cycleBkgInfoVO.getBkgCgoTpCd();
            String cycleBkgVvd = (cycleBkgInfoVO.getVvd() == null || cycleBkgInfoVO.getVvd().equals("")) ? "" : cycleBkgInfoVO.getVvd();
            
            log.debug("[MAX Cycle] = " +(maxCycleNo >= mstCycleNo) + " [maxCycleNo=" +maxCycleNo+", mstCycleNo=" +mstCycleNo+ "]");
            if(maxCycleNo >= mstCycleNo){
                if("ID".equals(mstMvntStsCd) || "MT".equals(mstMvntStsCd)){
                    log.debug("8.1 [Movement Status] != 'ID' or 'MT' : mstMvntStsCd=" + mstMvntStsCd);
                    if(!isSameLoc){
                        log.debug("8.1.1 [Movement Status] != 'ID' or 'MT' : isSameEcc=" + isSameLoc);
                        if (maxCycleNo == 9999) {
                            log.debug("8.1.1.1 [Movement Status] != 'ID' or 'MT' : maxCycleNo=" + maxCycleNo);
                            throw new EventException(new ErrorHandler("BKG08046", new String[]{containerVO.getCntrNo(), cycleBkgInfoVO.getBkgNo()}).getMessage());
                        } else {
                            log.error("8.1.1.2 [Movement Status] != 'ID' or 'MT' : maxCycleNo=" + maxCycleNo);
                            if (vvdCheckFlag) {
                                log.debug("8.1.1.2.1 [Movement Status] != 'ID' or 'MT' : vvdCheckFlag=" + vvdCheckFlag);
                                
                                boolean cgoErr = cycleBkgCgoTp.equals(cntrEtcInfoVO.getBkgCgoTpCd());
                                boolean vvdErr = cycleBkgVvd.equals(cntrEtcInfoVO.getTVvd());
                                log.debug("=========================> cgoErr=" + cgoErr + ", vvdErr=" + vvdErr);
                                if (!cgoErr && vvdErr)      {
                                    throw new EventException(new ErrorHandler("BKG08042", new String[]{containerVO.getCntrNo(), cycleBkgInfoVO.getBkgNo(), cycleBkgInfoVO.getBkgCgoTpCd()}).getMessage());
                                } else if (cgoErr && !vvdErr) {
                                    throw new EventException(new ErrorHandler("BKG08043", new String[]{containerVO.getCntrNo(), cycleBkgInfoVO.getBkgNo(), cycleBkgInfoVO.getVvd()}).getMessage());
                                } else if (!cgoErr && !vvdErr) {
                                    throw new EventException(new ErrorHandler("BKG08044", new String[]{containerVO.getCntrNo(), cycleBkgInfoVO.getBkgNo(), cycleBkgInfoVO.getVvd(), cycleBkgInfoVO.getBkgCgoTpCd()}).getMessage());
                                }
                            }
                        } 
                    }
                    
                    if (maxCycleNo == 9999 && vvdCheckFlag) {
                        log.debug("8.1.1 [Movement Status] != 'ID' or 'MT' : maxCycleNo=" + maxCycleNo + ", vvdCheckFlag=" + vvdCheckFlag);
                        boolean cgoErr = cycleBkgCgoTp.equals(cntrEtcInfoVO.getBkgCgoTpCd());
                        boolean vvdErr = cycleBkgVvd.equals(cntrEtcInfoVO.getTVvd());
                        log.debug("=========================> cgoErr=" + cgoErr + ", vvdErr=" + vvdErr);
                        if (!cgoErr && vvdErr)      {
                            throw new EventException(new ErrorHandler("BKG08042", new String[]{containerVO.getCntrNo(), cycleBkgInfoVO.getBkgNo(), cycleBkgInfoVO.getBkgCgoTpCd()}).getMessage());
                        } else if (cgoErr && !vvdErr) {
                            throw new EventException(new ErrorHandler("BKG08043", new String[]{containerVO.getCntrNo(), cycleBkgInfoVO.getBkgNo(), cycleBkgInfoVO.getVvd()}).getMessage());
                        } else if (!cgoErr && !vvdErr) {
                            throw new EventException(new ErrorHandler("BKG08044", new String[]{containerVO.getCntrNo(), cycleBkgInfoVO.getBkgNo(), cycleBkgInfoVO.getVvd(), cycleBkgInfoVO.getBkgCgoTpCd()}).getMessage());
                        }
                    }       
                    
                }else{	
                	if (vvdCheckFlag) {
	                    log.debug("8.2 [Movement Status] != 'ID' or 'MT' : mstMvntStsCd=" + mstMvntStsCd);                    
	                    boolean cgoErr = cycleBkgCgoTp.equals(cntrEtcInfoVO.getBkgCgoTpCd());
	                    boolean vvdErr = cycleBkgVvd.equals(cntrEtcInfoVO.getTVvd());
	                    log.debug("=========================> cgoErr=" + cgoErr + ", vvdErr=" + vvdErr);
	                    if (!cgoErr && vvdErr)      {
	                        throw new EventException(new ErrorHandler("BKG08042", new String[]{containerVO.getCntrNo(), cycleBkgInfoVO.getBkgNo(), cycleBkgInfoVO.getBkgCgoTpCd()}).getMessage());
	                    } else if (cgoErr && !vvdErr) {
	                        throw new EventException(new ErrorHandler("BKG08043", new String[]{containerVO.getCntrNo(), cycleBkgInfoVO.getBkgNo(), cycleBkgInfoVO.getVvd()}).getMessage());
	                    } else if (!cgoErr && !vvdErr) {
	                        throw new EventException(new ErrorHandler("BKG08044", new String[]{containerVO.getCntrNo(), cycleBkgInfoVO.getBkgNo(), cycleBkgInfoVO.getVvd(), cycleBkgInfoVO.getBkgCgoTpCd()}).getMessage());
	                    }
                	}
                }
            }
            // whether same Container is used at other BKG
            if(!"1".equals(containerVO.getCntrPrtFlg())) {
                String tgtBkgNo = dbDao.searchCntrDup(cntrEtcInfoVO, containerVO.getCntrNo());
                if(!"".equals(tgtBkgNo)){
                    throw new EventException(new ErrorHandler("BKG00966", new String[]{containerVO.getCntrNo(), tgtBkgNo}).getMessage());
                }
            }
            log.debug("Attach Valid OK!!!!");
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return retMap;
    }

    /**
     * Make sure your container information can delete
     * @param CntrEtcInfoVO bkgEtcInfoVO
     * @param ContainerVO containerVO
     * @exception EventException
     */
    private void validateContainerDetach(CntrEtcInfoVO cntrEtcInfoVO, ContainerVO containerVO) throws EventException {
        try {
            BookingUtil utilCmd = new BookingUtil();
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(cntrEtcInfoVO.getBkgNo());
            // bkgBlNoVO.setBkgNoSplit(containerVO.getBkgNoSplit());
            // booking status
            String bkg_sts_cd = utilCmd.searchBkgStatusByBkg(bkgBlNoVO);
            String cntrNo = "";
            
            if(containerVO.getCntrNoOld() == null || "".equals(containerVO.getCntrNoOld())) {
            	cntrNo = containerVO.getCntrNo();
            } else {
            	cntrNo = containerVO.getCntrNoOld();
            }
            if(bkg_sts_cd != null && bkg_sts_cd.equals(Constants.BKG_STATUS_CANCEL)) {
                throw new EventException(new ErrorHandler("BKG00113").getMessage());
            }
            String bkg_so_sts = utilCmd.searchSoStatus(null, cntrNo, bkgBlNoVO, "O");
            if("Y".equals(bkg_so_sts)) {
                throw new EventException(new ErrorHandler("BKG00094").getMessage());
            }            
            // whether same Container is used at other BKG
            if(!"1".equals(containerVO.getCntrPrtFlg()) && "VL".equals(containerVO.getCnmvStsCd())) {
                String tgtBkgNo = dbDao.searchCntrDup(cntrEtcInfoVO, cntrNo);
                if("".equals(tgtBkgNo) || tgtBkgNo == null){
//                    throw new EventException(new ErrorHandler("BKG00966", new String[]{containerVO.getCntrNoOld(), tgtBkgNo}).getMessage());

		            // Master Container retrieve
		            CntrMstInfoVO cntrMstInfoVO = dbDao.searchMstContainer(cntrNo);
		            if(cntrMstInfoVO == null) {
		                throw new EventException(new ErrorHandler("BKG00402", new String[]{cntrNo}).getMessage());                
		            }
		            // 
		            String mstMvntStsCd = cntrMstInfoVO.getCnmvStsCd();
		            String currAreaGrpId = dbDao.searchLocByBkgPor(cntrEtcInfoVO.getBkgNo());
		            boolean isSameLoc = currAreaGrpId.equals(cntrMstInfoVO.getSysAreaGrpId());
		            boolean vvdCheckFlag = false;
		            MaxCycleBkgInfoVO cycleBkgInfoVO = new MaxCycleBkgInfoVO();
//		            log.debug("@@@@@@@@ isSameLoc:"+isSameLoc + " @@@@@@@@ mstMvntStsCd:"+mstMvntStsCd);
		            if(isSameLoc) {
		                cycleBkgInfoVO = dbDao.searchMaxCycleBkgBySameEcc(cntrNo);
		                if("PSEUDO00001".equals(cycleBkgInfoVO.getBkgNo()) && "PSDO9999W".equals(cycleBkgInfoVO.getVvd())) {
		                    vvdCheckFlag = false;
		                } else {
		                    vvdCheckFlag = true;
		                }
		            } else {
		                cycleBkgInfoVO = dbDao.searchMaxCycleBkgByDiffEcc(cntrNo);
		                if("PSEUDO00001".equals(cycleBkgInfoVO.getBkgNo()) && "PSDO9999W".equals(cycleBkgInfoVO.getVvd())) {
		                    vvdCheckFlag = false;
		                } else {
		                    vvdCheckFlag = true;
		                }
		            }
		            //
//		            log.debug("@@@@@@@@ vvdCheckFlag:"+vvdCheckFlag + " @@@@@@@@ mstMvntStsCd:"+mstMvntStsCd);
		            if("VL".equals(mstMvntStsCd) && vvdCheckFlag){
//		            log.debug("@@@@@@@@ vvd cycle:"+cycleBkgInfoVO.getVvd() + " @@@@@@@@ vvd etc:"+cntrEtcInfoVO.getTVvd());	
		                if(cntrEtcInfoVO.getTVvd().equals(cycleBkgInfoVO.getVvd())){
		                    throw new EventException(new ErrorHandler("BKG08053", new String[]{cntrNo}).getMessage());
		                    
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
     * update Vol of Container and Partial Flag. UI_BKG-0170
     * @param CntrCopyVO cntrCopyVO
     * @exception EventException
     */
    public void modifyCntrVol(CntrCopyVO cntrCopyVO) throws EventException{
        // check Origin Booking No.
        String bkgNo = cntrCopyVO.getSrcBkgNo();
        String cngrNo = cntrCopyVO.getCntrNo();
        String cntrVol = cntrCopyVO.getTgtCntrVol();
        try {
            dbDao.modifyCntrVolByCopy(bkgNo, cngrNo, cntrVol);
            dbDao.modifyCntrCfmFlgByBkg(bkgNo, "N", cntrCopyVO.getCaFlg());
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * container manifest information retrieve.-- UI_BKG-0079-07
     * @param String bkgNo
     * @param String caFlg 
     * @return CmVO
     * @exception EventException
     */
    public CmVO searchCm(String bkgNo, String caFlg) throws EventException {
        CmVO cmVO = new CmVO();
        try {
            CmBkgInfoVO cmInfoVO = dbDao.searchCmBkgInfo(bkgNo, caFlg);
            String htsFlg = dbDao.searchHTSFlag(bkgNo, caFlg);
            cmInfoVO.setHtsFlg(htsFlg);
            
            List<CmCntrInfoVO> cmCntrInfoVOs = dbDao.searchCmCntrInfo(bkgNo, caFlg);
            // List<BkgCntrSealNoVO> cntrSealNoVOs = dbDao.searchSealNo(bkgNo, caFlg);
            List<BkgCntrMfDescVO> cntrMfDescVOs = dbDao.searchCmDetailInfo(bkgNo, caFlg);
            //2010-12-08
            List<BkgDgCgoVO> bkgDgCgoVOs = dbDao.searchBkgDgCgo(bkgNo);

            cmVO.setCmBkgInfoVO(cmInfoVO);
            cmVO.setCmCntrInfoVOs(cmCntrInfoVOs);
            // cmVO.setCntrSealNoVOs(cntrSealNoVOs);
            cmVO.setCntrMfDescVOs(cntrMfDescVOs);
            cmVO.setBkgDgCgoVOs(bkgDgCgoVOs);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return cmVO;
    }

    /**
     * Make sure your container manifest information can save
     * @param CmVO cmVO
     * @exception EventException
     */
    public void validateCm(CmVO cmVO) throws EventException {
        // TODO Auto-generated method stub
        BookingUtil utilCmd = new BookingUtil();

        CmBkgInfoVO vo1 = cmVO.getCmBkgInfoVO();
        // List<CmCntrInfoVO> vo2 = cmVO.getCmCntrInfoVOs();
        List<BkgCntrMfDescVO> vo3 = cmVO.getBkgCntrMfDescVOs();
        try {

            int len = (vo3 == null) ? 0 : vo3.size();
            for(int i = 0; i < len; i++) {
            	if(!"D".equals(vo3.get(i).getIbflag())) {
	                // 1. BookingUtil::validatePkgType ( pkgTpCd )
	                log.debug(" * PckTpCd : " + vo3.get(i).getPckTpCd());
	                log.debug(" * cntrNo : " + vo3.get(i).getCntrNo());
	                if(i>0 && !vo3.get(i).getPckTpCd().equals(vo3.get(i-1).getPckTpCd())){
		                boolean flag = utilCmd.validatePkgType(vo3.get(i).getPckTpCd());
		                if(!flag) {
		                    throw new EventException(new ErrorHandler("BKG01050", new String[]{"Package Type"}).getMessage());
		                }
	            	}
	                // 2. BookingUtil::searchHtsCodeDesc ( htsCd )
	                log.debug(" * HamoTrfCd : " + vo3.get(i).getHamoTrfCd());
	                if(vo3.get(i).getHamoTrfCd() != null && vo3.get(i).getHamoTrfCd().length() > 0) {
	                    String extHtsFlag = utilCmd.checkHtsCodeByCm("T", vo3.get(i).getHamoTrfCd());
	                    if("N".equals(extHtsFlag)) {
	                        throw new EventException(new ErrorHandler("BKG01050", new String[]{"HTS"}).getMessage());
	                    }
	                }
	                // 3. BookingUtil::searchHtsCodeDesc ( hsCd )
	                log.debug(" * CmdtCd : " + vo3.get(i).getCmdtHsCd());
	                if(vo3.get(i).getCmdtHsCd() != null && vo3.get(i).getCmdtHsCd().length() > 0) {
	                    String extHsFlag = utilCmd.checkHtsCodeByCm("H", vo3.get(i).getCmdtHsCd());
	                    if("N".equals(extHsFlag)) {
	                        throw new EventException(new ErrorHandler("BKG01050", new String[]{"HS"}).getMessage());
	                    }
	                }
	                
	                // 4. BLDocumentationCMDBDAO::searchNcmCodeDesc ( ncmCd )
	                log.debug(" * NcmNo : " + vo3.get(i).getNcmNo());
	                if(vo3.get(i).getNcmNo() != null && vo3.get(i).getNcmNo().length() > 0) {
	                    String ncmDesc = utilCmd.searchNcmCodeDesc(vo3.get(i).getNcmNo());
	                    if(ncmDesc == null) {
	                        throw new EventException(new ErrorHandler("BKG01050", new String[]{"NCM"}).getMessage());
	                    }
	                }       
	                        
	                // 5. BLDocumentationCMDBDAO::searchCntrMfNo ( bkgNo,  cntrMfNo)
	                log.debug(" * CntrMfNo : " + vo3.get(i).getCntrMfNo() + " * getCorrFlg : " + vo1.getCorrFlg());
	                if(vo3.get(i).getCntrMfNo() != null && vo3.get(i).getCntrMfNo().length() > 0 && !"SELF".equals(vo3.get(i).getCntrMfNo())) {
	                    String hblSeq = dbDao.searchCntrMfNo(vo1.getBkgNo(), vo3.get(i).getCntrMfNo(), vo1.getCorrFlg());
	                    if(hblSeq == null) {
	                        throw new EventException(new ErrorHandler("BKG01050", new String[]{"Manifest File No."}).getMessage());
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
     * container manifest information creation -- UI_BKG-0079-07, UI_BKG-0178, BKG CONTAINER MANIFEST DESCRIPTION
     * @param CmVO cmVO
     * @param SignOnUserAccount account
     * @param String caFlg 
     * @exception EventException
     */
    public void manageCm(CmVO cmVO, SignOnUserAccount account, String caFlg) throws EventException {

        CmBkgInfoVO vo1 = cmVO.getCmBkgInfoVO();
        List<CmCntrInfoVO> vo2 = cmVO.getCmCntrInfoVOs();
        List<BkgCntrMfDescVO> vo3 = cmVO.getBkgCntrMfDescVOs();
        log.debug(" * CmBkgInfoVO : " + vo1.getBkgNo());
//        log.debug(" * CmCntrInfoVOs : " + vo2.size());
        log.debug(" * BkgCntrMfDescVOs : " + vo3.size());
        
        try {

            /* container manifest */
            if(vo3 != null && vo3.size() > 0){
                for(int i = 0; i < vo3.size(); i++) {
                    log.debug("BkgCntrMfDescVO -> " + vo3.get(i).getCntrNo() + " : " + vo3.get(i).getIbflag());
                    vo3.get(i).setBkgNo(vo1.getBkgNo());
                    vo3.get(i).setCreUsrId(account.getUsr_id());
                    vo3.get(i).setUpdUsrId(account.getUsr_id());
                    if(vo3.get(i).getIbflag().equals("D")) {
                        dbDao.removeCm(vo3.get(i), caFlg);
                    }
                }
                for(int i = 0; i < vo3.size(); i++) {
                    log.debug("BkgCntrMfDescVO -> " + vo3.get(i).getCntrNo() + " : " + vo3.get(i).getIbflag());
                    vo3.get(i).setBkgNo(vo1.getBkgNo());
                    vo3.get(i).setCreUsrId(account.getUsr_id());
                    vo3.get(i).setUpdUsrId(account.getUsr_id());
                    if(vo3.get(i).getIbflag().equals("I")) {
                        dbDao.addCm(vo3.get(i), caFlg);
                    }
                }
                for(int i = 0; i < vo3.size(); i++) {
                    log.debug("BkgCntrMfDescVO -> " + vo3.get(i).getCntrNo() + " : " + vo3.get(i).getIbflag());
                    vo3.get(i).setBkgNo(vo1.getBkgNo());
                    vo3.get(i).setCreUsrId(account.getUsr_id());
                    vo3.get(i).setUpdUsrId(account.getUsr_id());
                    if(vo3.get(i).getIbflag().equals("U")) {
                        dbDao.modifyCm(vo3.get(i), caFlg);
                    }
                }
            }
            /* container */
            if(vo2 != null && vo2.size() > 0){
                //List<CmCntrInfoVO> insertCntrList = new ArrayList<CmCntrInfoVO>();
                List<CmCntrInfoVO> updateCntrList = new ArrayList<CmCntrInfoVO>();
                //List<CmCntrInfoVO> deleteCntrList = new ArrayList<CmCntrInfoVO>();
                for(int i = 0; i < vo2.size(); i++) {
                    log.debug("CmCntrInfoVO -> " + vo2.get(i).getCntrNo() + " : " + vo2.get(i).getIbflag());
                    log.debug("CmCntrInfoVO -> MfCfmFlg : " + vo2.get(i).getMfCfmFlg());
                    vo2.get(i).setBkgNo(vo1.getBkgNo());
                    vo2.get(i).setCreUsrId(account.getUsr_id());
                    vo2.get(i).setUpdUsrId(account.getUsr_id());
                    if(vo2.get(i).getIbflag().equals("U")) {
                        updateCntrList.add(vo2.get(i));
                    }
                }
                if(updateCntrList.size() > 0) {
                    dbDao.modifyCntrByCm(updateCntrList, caFlg);
                }
            }
            /* booking */
            dbDao.modifyBlByCm(vo1, caFlg);

        } catch(DAOException ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     *  change Term of Container according to Bkg(ESM_BKG_0079_01) -> modifyBooking<br>
     * @param   BkgContainerVO bkgContainerVO
	 * @param 		BkgBlNoVO bkgBlNoVO
     * @exception   EventException
     */
    public void modifyCntrRDTerm(BkgContainerVO bkgContainerVO, BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            dbDao.modifyCntrRDTerm(bkgContainerVO, bkgBlNoVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * update Container Seal No information
     * 
     * @param List<BkgCntrSealNoVO> updateSealVoList
     * @param String caFlg
     * @exception EventException
     */
    public void manageCntrSealNo(List<BkgCntrSealNoVO> updateSealVoList, String caFlg) throws EventException {
        try {
            // insert seal no
//            if(updateSealVoList.size() > 0) {
//                dbDao.manageCntrSealNos(updateSealVoList);
//            }
            int len = updateSealVoList == null ? 0 : updateSealVoList.size();
            for (int i = 0; i < len; i++) {
                BkgCntrSealNoVO sealNoVO = updateSealVoList.get(i);
                log.debug("***** Seal No. : " + sealNoVO.getIbflag() + " - " + sealNoVO.getCntrNo());
                if(dbDao.updateCntrSealNo(sealNoVO, caFlg) == 0){
                	if(dbDao.searchExistContainer(sealNoVO.getBkgNo(),sealNoVO.getCntrNo(), caFlg)){
               		 dbDao.insertCntrSealNo(sealNoVO, caFlg);
                	}  
                }
            }            
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * delete Container Seal No.-- UI_BKG-0170, UI_BKG-0079-04
     * @param String bkgNo
     * @param String cntrNo
     * @param String cntr_seal_seq
     * @param String caFlg
     * @exception EventException
     */
    public void removeCntrSealNo(String bkgNo, String cntrNo, String cntr_seal_seq, String caFlg) throws EventException {
        try {
            dbDao.removeCntrSealNo(bkgNo, cntrNo, cntr_seal_seq, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * delete Container Seal No. -- UI_BKG-0170, UI_BKG-0079-04
     * 
     * @param List<BkgCntrSealNoVO> deleteSealVoList
     * @param String caFlg 
     * @exception EventException
     */    
    public void removeCntrSealNo(List<BkgCntrSealNoVO> deleteSealVoList, String caFlg) throws EventException {
        try {
            //dbDao.removeCntrSealNos(deleteSealVoList, caFlg);
            for (int i = 0; i < deleteSealVoList.size(); i++) {
                BkgCntrSealNoVO bkgCntrSealNoVO = deleteSealVoList.get(i);
                dbDao.removeCntrSealNo(bkgCntrSealNoVO.getBkgNo(), bkgCntrSealNoVO.getCntrNo(), bkgCntrSealNoVO.getCntrSealSeq(), caFlg);
            }            
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * delete Container Manifest Desc. -- UI_BKG-0170, UI_BKG-0079-04
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @exception EventException
     */
    public void removeCntrMfDesc(String bkgNo, String cntrNo, String caFlg) throws EventException {
        try {
            dbDao.removeCmByCntr(bkgNo, cntrNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * change Container Manifest Desc.
     * @param String bkgNo
     * @param String cntrNo
     * @param String cntrNoOld
     * @param String caFlg 
     * @exception EventException
     */
    public void changeCntrMfDesc(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException {
        try {
            dbDao.changeCntrMfDesc(bkgNo, cntrNo, cntrNoOld, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * insert Container
     * @param ContainerVO containerVO
     * @param String caFlg 
     * @exception EventException
     */
    public void insertContainer(ContainerVO containerVO, String caFlg) throws EventException {
        try {
            dbDao.insertContainer(containerVO, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * modify container information
     * 
     * @param ContainerVO containerVO
     * @param String caFlg
     * @exception EventException
     */
    public void modifyContainer(ContainerVO containerVO, String caFlg) throws EventException {
        try {
            dbDao.updateContainer(containerVO, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }    

    /**
     * modify container confirm information
     * 
     * @param String bkgNo
     * @param String cfmFlg
     * @param String caFlg
     * @exception EventException
     */
    public void modifyCntrCfmFlg(String bkgNo, String cfmFlg, String caFlg) throws EventException {
        try {
            dbDao.modifyCntrCfmFlgByBkg(bkgNo, cfmFlg, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * delete Container
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg 
     * @exception EventException
     */
    public void removeContainer(String bkgNo, String cntrNo, String caFlg) throws EventException {
        try {
            dbDao.removeContainer(bkgNo, cntrNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * update act_wgt and wgt_ut_cd.(ESM_BKG_0079_01) -> modifyBooking<br>
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       String actWgt
     * @param       String wgtUtCd
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void modifyBlActWgt(BkgBlNoVO bkgBlNoVO, String actWgt, String wgtUtCd, SignOnUserAccount account)
            throws EventException {
        try {
            dbDao.modifyBlActWgt(bkgBlNoVO, actWgt, wgtUtCd, account);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     *  Cancel Container.(ESM_BKG_0079_01) -> modifyBooking<br>
     *  
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void cancelBkgCntr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
        try {
            dbDao.cancelBkgCntr(bkgBlNoVO, account);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * insert to targetBkg after reading at bkg_cntr, bkg_cntr_seal_no of sourceBkg when combine/split
     * @param String[] copyMdHcmtArr
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectCntrVO> selectCntrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyCntrCmByBkg(String[] copyMdHcmtArr, BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg,
            List<SelectCntrVO> selectCntrVO, SignOnUserAccount account) throws EventException {
        try {
            BookingUtil utilBC = new BookingUtil();
            String copyModeCd = copyMdHcmtArr[0];
            String hitchmentYn = copyMdHcmtArr[1];
            
            if(copyModeCd.equals("M")) { // Combine
                
            	BkgBlNoVO mstBkg = null;
            	BkgBlNoVO combineBkg = null;
                for(int i = 0; i < targetBkg.length; i++) {
                	mstBkg = sourceBkg;
                	combineBkg = targetBkg[i];
                	log.debug("mstBkg:"+mstBkg.getBkgNo()+ ", combineBkg:"+combineBkg.getBkgNo());
                	
                    String[] cntrNo = utilBC.searchCntrListByBkg(targetBkg[i]);
                    for (int j=0;j<cntrNo.length;j++) {
                        SelectCntrVO tmpCntrVO = new SelectCntrVO();
                        tmpCntrVO.setCntr_no(cntrNo[j]);
                        
                        if ( dbDao.modifyBkgCntrPkcMeasWgt(cntrNo[j], mstBkg, combineBkg, account) == 0 ) {
                            dbDao.copyBkgCntrByBkg(mstBkg, combineBkg, tmpCntrVO, account);
                        }

                        dbDao.copyCmByBkg(mstBkg, combineBkg, copyModeCd, tmpCntrVO, account);
                        dbDao.copyBkgCntrSealByBKG(mstBkg, combineBkg, tmpCntrVO, account);
                    }

                    if ("Y".equals(hitchmentYn) ) {
                        dbDao.modifyCntrPorPol(mstBkg, combineBkg, account);
                    }
                    
                    dbDao.cancelBkgCntr(combineBkg, account);
                }
            } else if(copyModeCd.equals("S")) { // Split
                String[] cntrNo = utilBC.searchCntrListByBkg(sourceBkg);
                int [] partialCount = new int [cntrNo.length] ;
                for(int i = 0; i < cntrNo.length; i++){
                    for(int j = 0; j < selectCntrVO.size(); j++){
                        if(cntrNo[i].equals(selectCntrVO.get(j).getCntr_no()) 
                            && selectCntrVO.get(j).getSplitNo().length() > 0){
                            partialCount[i]++;
                        }
                    }
                }
                
                for(int i = 0; i < targetBkg.length; i++) {
                    if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                        for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
                        	log.debug("sourceBkg:"+sourceBkg.getBkgNo()+",targetBkg:"+targetBkg[i].getBkgNo());
                            if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg[i].getBkgNo())
                                && selectCntrVO.get(icnt).getSplitNo().length()>1){
                                dbDao.copyBkgCntrByBkg(targetBkg[i], sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt), account);
                                dbDao.copyCmByBkg(targetBkg[i], sourceBkg, copyModeCd, (SelectCntrVO) selectCntrVO.get(icnt), account);
                                dbDao.copyBkgCntrSealByBKG(targetBkg[i], sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt),account);
                            }
                        }
                    }
                }
                for(int i=0; i<cntrNo.length;i++){
                	//partial cntr
                	if(partialCount[i]>1){
                        for(int j=0;j<targetBkg.length;j++) {
                        	for(int k=0;k<selectCntrVO.size();k++){
                        		if(selectCntrVO.get(k).getCntr_no().equals(cntrNo[i])
                        			&& selectCntrVO.get(k).getBkg_no().equals(targetBkg[j].getBkgNo())	
                                    && selectCntrVO.get(k).getSplitNo().length()>1){
                                    	log.debug("cntrNo:" +cntrNo[i]+" bkg_no:"+targetBkg[j].getBkgNo() + " select bkg : " + selectCntrVO.get(k).getBkg_no() + " select cntr2 :"+ selectCntrVO.get(k).getCntr_no());
                        			dbDao.modifyBkgCntrPartialFlg(targetBkg[targetBkg.length - 1], targetBkg[j], cntrNo[i], partialCount[i], account);
                        		}
                        	}
                        }
                		
                	}
                }
                
                for(int i = 0; i < targetBkg.length; i++) {
                    if(sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                    for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
                        if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg[i].getBkgNo())
                          && selectCntrVO.get(icnt).getSplitNo().length()<1){
                            dbDao.removeCntrSealNoAfterSplit(sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt));
                            dbDao.removeCmByCntr(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
                            dbDao.removeContainer(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
                        }
                      }
                   }
                }                
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     *  change awk_cgo_flg value according to Bkg_no of Container(ESM_BKG_0055)
     *  
     * @param   String bkgNo 
     * @param   String spclTp 
     * @param   String cntrNo
     * @param   String caFlg
     * @return	int
     * @exception   EventException
     */ 
    public int modifyCntrFlgBySpcl(String bkgNo, String spclTp, String cntrNo, String caFlg) throws EventException {
        int updCnt = 0;
    	try {
            updCnt = dbDao.modifyCntrFlgBySpcl(bkgNo, spclTp, cntrNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return updCnt;
    }
    
    /**
     *  change awk_cgo_flg value according to Bkg_no of Container(ESM_BKG_0055)
     * @param   String bkgNo 
     * @param   String spclTp 
     * @param   String cntrNo
     * @param   String caFlg
     * @exception   EventException
     */
    public void modifyCntrFlgBySpcl2(String bkgNo, String spclTp, String cntrNo, String caFlg) throws EventException {
        try {
            dbDao.modifyCntrFlgBySpcl2(bkgNo, spclTp, cntrNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     *  change awk_cgo_flg value according to Bkg_no of Container(ESM_BKG_0055)    
     * @param   String bkgNo 
     * @param   String caFlg 
     * @exception   EventException
     */
    public void modifyCntrFlgBySpcl3(String bkgNo, String caFlg) throws EventException {
        try {
            dbDao.modifyCntrFlgBySpcl3(bkgNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * retrieve manifest information corresponding to container-- UI_BKG-0178
     * @param String cntrNo
     * @param String vvd
     * @return CmByCntrVO
     * @exception EventException
     */
    public CmByCntrVO searchCmByCntr(String cntrNo, String vvd) throws EventException {
        CmByCntrVO cmVO = new CmByCntrVO();
        try {
            CntrCmEtcInfoVO cntrCmEtcInfoVO = dbDao.searchCmEtcInfoByCntr(cntrNo, vvd);
            List<CntrCmBkgInfoVO> cntrCmBkgInfoVOs = dbDao.searchCmBkgInfoByCntr(cntrNo, vvd);
            List<CntrCmDescInfoVO> cntrCmDescInfoVOs = dbDao.searchCmDescInfoByCntr(cntrNo, vvd);

            cmVO.setCntrCmEtcInfoVO(cntrCmEtcInfoVO);
            cmVO.setCntrCmBkgInfoVOs(cntrCmBkgInfoVOs);
            cmVO.setCntrCmDescInfoVOs(cntrCmDescInfoVOs);
            
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return cmVO;
    }

    /**
     * insert/modify/delete C/M by Container -- UI_BKG-0178
     * 
     * @param CmByCntrVO cmVO
     * @param SignOnUserAccount account
     * @param String caFlg 
     * @exception EventException
     */
    public void manageCmByCntr(CmByCntrVO cmVO, SignOnUserAccount account, String caFlg) throws EventException {
        //CntrCmEtcInfoVO cmEtcInfoVO = cmVO.getCntrCmEtcInfoVO();
        List<CntrCmBkgInfoVO> cntrCmBkgInfoVOs = cmVO.getCntrCmBkgInfoVOs();
        List<CntrCmDescInfoVO> cntrCmDescInfoVOs = cmVO.getCntrCmDescInfoVOs();
        
        try {
            int mfCnt = cntrCmDescInfoVOs == null ? 0 : cntrCmDescInfoVOs.size();
            log.debug("mfCnt ========> " + mfCnt);
             List<BkgCntrMfDescVO> insertCmList = new ArrayList<BkgCntrMfDescVO>();
             List<BkgCntrMfDescVO> updateCmList = new ArrayList<BkgCntrMfDescVO>();
             List<BkgCntrMfDescVO> deleteCmList = new ArrayList<BkgCntrMfDescVO>();
            for(int i = 0; i < mfCnt; i++) {
                CntrCmDescInfoVO cntrCmDescInfoVO = cntrCmDescInfoVOs.get(i);
                BkgCntrMfDescVO bkgCntrMfDescVO = new BkgCntrMfDescVO(); 
                log.debug("CmDescInfoVO    -> " + cntrCmDescInfoVO.getBkgNo() + " : " + cntrCmDescInfoVO.getCntrNo() + " : " + cntrCmDescInfoVO.getIbflag());                
                //ConvertUtils.hashMapToVO(cntrCmDescInfoVO.getColumnValues(), bkgCntrMfDescVO);
                ObjectCloner.build(cntrCmDescInfoVO, bkgCntrMfDescVO);
                log.debug("BkgCntrMfDescVO -> " + bkgCntrMfDescVO.getBkgNo() + " : " + bkgCntrMfDescVO.getCntrNo() + " : " + bkgCntrMfDescVO.getIbflag());                
                bkgCntrMfDescVO.setCreUsrId(account.getUsr_id());
                bkgCntrMfDescVO.setUpdUsrId(account.getUsr_id());
                if("I".equals(bkgCntrMfDescVO.getIbflag())) {
                    insertCmList.add(bkgCntrMfDescVO);
                }
                if("U".equals(bkgCntrMfDescVO.getIbflag())) {
                    updateCmList.add(bkgCntrMfDescVO);
                }    
                if("D".equals(bkgCntrMfDescVO.getIbflag())) {
                    deleteCmList.add(bkgCntrMfDescVO);
                }                
            } 
            if(deleteCmList.size() > 0) {
                for(int i = 0; i < deleteCmList.size(); i++) {
                    dbDao.removeCm(deleteCmList.get(i), caFlg);
                }
            }
            if(updateCmList.size() > 0) {
                for(int i = 0; i < updateCmList.size(); i++) {
                    dbDao.modifyCm(updateCmList.get(i), caFlg);
                }
            }             
            if(insertCmList.size() > 0) {
                for(int i = 0; i < insertCmList.size(); i++) {
                    dbDao.addCm(insertCmList.get(i), caFlg);
                }
            }            
            
            int bkgCnt = cntrCmBkgInfoVOs == null ? 0 : cntrCmBkgInfoVOs.size();
            log.debug("bkgCnt ========> " + bkgCnt);
            List<CmCntrInfoVO> updateBkgList = new ArrayList<CmCntrInfoVO>(bkgCnt);
            for(int i = 0; i < bkgCnt; i++) {
                if("U".equals(cntrCmBkgInfoVOs.get(i).getIbflag())) {
                    //ConvertUtils.hashMapToVO(cntrCmBkgInfoVOs.get(i).getColumnValues(), cmCntrInfoVO);
                    CntrCmBkgInfoVO cmBkgInfoVO = cntrCmBkgInfoVOs.get(i);
                    CmCntrInfoVO cmCntrInfoVO = new CmCntrInfoVO(); 
                    log.debug("CmDescInfoVO    -> " + cmBkgInfoVO.getBkgNo() + " : " + cmBkgInfoVO.getCntrNo() + " : " + cmBkgInfoVO.getIbflag());                
                    //ConvertUtils.hashMapToVO(cntrCmDescInfoVO.getColumnValues(), bkgCntrMfDescVO);
                    ObjectCloner.build(cmBkgInfoVO, cmCntrInfoVO);
                    log.debug("BkgCntrMfDescVO -> " + cmCntrInfoVO.getBkgNo() + " : " + cmCntrInfoVO.getCntrNo() + " : " + cmCntrInfoVO.getIbflag());                
                    
                    cmCntrInfoVO.setCreUsrId(account.getUsr_id());
                    cmCntrInfoVO.setUpdUsrId(account.getUsr_id());
                    updateBkgList.add(cmCntrInfoVO);
                }
            }
            if(updateBkgList.size()>0){
                dbDao.modifyCntrByCm(updateBkgList, caFlg);
            }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * container manifest information retrieve -- UI_BKG-0079-07, UI_BKG-0178, BKG CONTAINER MANIFEST DESCRIPTION
     * 
     * @param String bkgNo
     * @param String caFlg
     * @return List<BkgCntrMfDescVO>
     * @exception EventException
     */
    public List<BkgCntrMfDescVO> searchCntrMfDesc(String bkgNo, String caFlg) throws EventException {
        try {
            return dbDao.searchCmDetailInfo(bkgNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * container information creation
     * -- UI_BKG-0172, BKG CONTAINER, BKG CONTAINER SEAL NUMBER, BKG BOOKING, BKG DOCUMENT PROCESS SCHEDULE, BKG RATE etc.
     * @param ContainerVO[] containerVOs
     * @param BkgCntrSealNoVO[] bkgCntrSealNoVOs
     * @param String usrId
     * @exception EventException
     */
    public void manageCntrByXter(ContainerVO[] containerVOs, BkgCntrSealNoVO[] bkgCntrSealNoVOs, String usrId) throws EventException {
        try {
            /* SealNo */
            List<BkgCntrSealNoVO> updateSealVoList = new ArrayList<BkgCntrSealNoVO>();
            List<BkgCntrSealNoVO> deleteSealVoList = new ArrayList<BkgCntrSealNoVO>();
            int sealLen = bkgCntrSealNoVOs == null ? 0 : bkgCntrSealNoVOs.length;
            for(int i = 0; i < sealLen; i++) {
                String ibflag = bkgCntrSealNoVOs[i].getIbflag();
                log.debug(":::::>" + bkgCntrSealNoVOs[i].getCntrNo() + "::" + bkgCntrSealNoVOs[i].getCntrSealNo()
                        + "::" + ibflag);
                bkgCntrSealNoVOs[i].setCreUsrId(usrId);
                bkgCntrSealNoVOs[i].setUpdUsrId(usrId);
                if("D".equals(bkgCntrSealNoVOs[i].getIbflag())) {
                    deleteSealVoList.add(bkgCntrSealNoVOs[i]);
                } else {
                    updateSealVoList.add(bkgCntrSealNoVOs[i]);
                }
            }

            /* Container */
            //List<ContainerVO> insertVoList = new ArrayList<ContainerVO>();
            List<ContainerVO> updateVoList = new ArrayList<ContainerVO>();
            List<ContainerVO> deleteVoList = new ArrayList<ContainerVO>();
            List<ContainerVO> changeVoList = new ArrayList<ContainerVO>();
            int cntrLen = containerVOs == null ? 0 : containerVOs.length;
            for(int i = 0; i < cntrLen; i++) {
                // ContainerVO containerVO = containerVOs[i];
                String ibflag = containerVOs[i].getIbflag();
                log.debug(":::::>" + containerVOs[i].getCntrNo() + "::" + ibflag);
                containerVOs[i].setCreUsrId(usrId);
                containerVOs[i].setUpdUsrId(usrId);
                if("I".equals(ibflag)) {
                    log.debug("*** container insertVoList : " + containerVOs[i].getCntrNo());
                    // insertVoList.add(containerVOs[i]);
                    updateVoList.add(containerVOs[i]);
                } else if("U".equals(ibflag)) {
                    if(containerVOs[i].getCntrNo().equals(containerVOs[i].getCntrNoOld())) {
                        log.debug("*** container updateVoList : " + containerVOs[i].getCntrNo());
                        updateVoList.add(containerVOs[i]);
                    } else {
                        log.debug("*** container changeVoList : " + containerVOs[i].getCntrNo());
                        changeVoList.add(containerVOs[i]);
                    }
                } else if("D".equals(ibflag)) {
                    log.debug("*** container deleteVoList : " + containerVOs[i].getCntrNo());
                    deleteVoList.add(containerVOs[i]);
                }
            }

            /* SealNo Delete */
            if(deleteSealVoList.size() > 0) {
                removeCntrSealNo(deleteSealVoList, "N");
            }
//        } catch(DAOException ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * retrieve status of Doc Process
     * 
     * @param String tgtBkgNo
     * @param String caFlg
     * @return String
     * @exception EventException
     */
    public String searchDocProcessByCntr(String tgtBkgNo, String caFlg) throws EventException {
        String proc_tp = null;
        try {
            proc_tp = dbDao.searchDocProcessByCntr(tgtBkgNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return "CNTCFM".equals(proc_tp) ? "Y" : "N";
    }

    /**
     * retrieve OB / L Issue before Total Package in Word update
     *
     * @author KimYoungchul
     * @param bkgNo
     * @param caFlg
     * @return String
     * @exception EventException
     */
    public String searchBlIssFlg(String bkgNo, String caFlg) throws EventException{
        try {
            return dbDao.searchBlIssFlg(bkgNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * if BKG Qty and CNTR Qty is the other cases, Total Package in Word of the M&D will update when you have Container Final Confirm.(BKG_BL_DOC.TTL_PCK_DESC)
     * 
     * @param String bkgNo
     * @param String caFlg 
     * @exception EventException
     */
    public void modifyBlByFinalCfm(String bkgNo, String caFlg) throws EventException{
        try {
            dbDao.modifyBlByFinalCfm(bkgNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * retrieve BKG No. and Vol that is using same VVD and Container when Partial Container Volume adjusts -- UI_BKG-1050
     * @param String bkgNo
     * @param String cntrNo
     * @return List<CntrAdjVolVO>
     * @exception EventException
     */
    public List<CntrAdjVolVO> searchCntrAdjVol(String bkgNo, String cntrNo) throws EventException {
        try {
            return dbDao.searchCntrAdjVol(bkgNo, cntrNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * Search Container Count.
     *
     * @param bkgNo
     * @param caFlg
     * @return String
     * @exception EventException
     */
    public String searchCntrKnt(String bkgNo, String caFlg) throws EventException{
        try {
            return dbDao.searchCntrKnt(bkgNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
   
    /**
     * retrieve BKG No. and Vol that is using same VVD and Container when Partial Container Volume adjusts -- UI_BKG-1050
     * 
     * @param bkgNo
     * @param caFlg
     * @return List<RataBkgQtyVO>
     * @exception EventException
     */
    public List<RataBkgQtyVO> searchBkgCntrVol(String bkgNo, String caFlg) throws EventException {
        try {
            return dbDao.searchBkgCntrVol(bkgNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * update Vol of Container and Partial Flag. UI_BKG-0170
     * 
     * @param CntrAdjVolVO cntrAdjVolVO 
     * @param String caFlg
     * @exception EventException
     */
    public void modifyCntrVol(CntrAdjVolVO cntrAdjVolVO, String caFlg) throws EventException{
        try {
            dbDao.modifyCntrVol(cntrAdjVolVO, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
//    public void modifyCntrVol(List<CntrAdjVolVO> updateAdjVoList) throws EventException{
//        try {
//            int len = updateAdjVoList == null ? 0 : updateAdjVoList.size();
//            for(int i=0;i<len;i++){
//                CntrAdjVolVO cntrAdjVolVO = updateAdjVoList.get(i);
//                dbDao.modifyBkgCntrVol(cntrAdjVolVO);
//            }
//        } catch(DAOException ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        } catch (Exception ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        }
//    }
    
    
    /**
     * copy from bkg_bl_doc of sourceBkg to targetBkg
     * @param       String trnkVslCd
     * @param       String preVslCd
     * @param       BkgBlNoVO sourceBkg
     * @param       BkgBlNoVO targetBkg
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void copyBkgBlDoc( String trnkVslCd , String preVslCd , BkgBlNoVO sourceBkg , BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException {
        try {
            dbDao.copyBkgBlDoc(trnkVslCd, preVslCd, sourceBkg, targetBkg, account);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }    

    /**
     *  save BKG_BL_DOC.(ESM_BKG_0079_01) -> createBooking<br>
     * @param       String bkgNo
     * @param       String blMvTpNm
	 * @param       BkgBookingInfoVO bkgBookingInfoVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void createBkgBlDocByBKG(String bkgNo, String blMvTpNm, BkgBookingInfoVO bkgBookingInfoVO, SignOnUserAccount account) throws EventException{
        try {
            dbDao.addBkgBlDoc(bkgNo, blMvTpNm, bkgBookingInfoVO.getFnlDestNm(), bkgBookingInfoVO.getActWgt(), bkgBookingInfoVO.getWgtUtCd(), account.getUsr_id());
			
            //2015.03.04 Stop to update TTL_PCK_DESC at new entry
            //dbDao.modifyBlByFinalCfm(bkgNo, "N");
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * Movement Cycle is updated as 9999, if you delete Container when MT Repo. Booking at Movement is VL status.
     *  
     * @param String bkgNo
     * @param String cntrNo
     * @param String cnmvCycNo
     * @param String cnmvDtTm
     * @exception EventException
     */
    public void modifyCycleByCtm(String bkgNo, String cntrNo, String cnmvCycNo, String cnmvDtTm) throws EventException{
        try {
            dbDao.modifyCycleByCtm(bkgNo, cntrNo, cnmvCycNo, cnmvDtTm);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * handling ContainerMovementMgt at calling from CTM
     * @param CrossItemVO item
     * @return boolean
     * @exception EventException
     */
//    public boolean modifyCntrOp(CrossItemVO item) throws EventException {
//        String errMsg = null;
//        boolean isReturn = false;
//        try {
//            if("D".equals(item.getAttchCd())) {
//                errMsg = "Movement update error due to COP";
//                
//                BookingUtil utilCmd = new BookingUtil();
//                BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
//                bkgBlNoVO.setBkgNo(item.getBkgNo());
//                
//                //S/O error handling
//                String bkg_so_sts = utilCmd.searchSoStatus(null, item.getCusCtmMovementVO().getCntrNo(), bkgBlNoVO, "O");
//                if("Y".equals(bkg_so_sts)) {
//                	errMsg = "Service order should be cancelled first.";
//                    throw new EventException(new ErrorHandler(errMsg).getMessage());
//                }
//                
//                // BkgCopManageBC::attachCntr ( bkgNo , cntrNo , flgPartial )
//                BkgCopManageBC copMgt = new BkgCopManageBCImpl();
//                copMgt.detachCntr(item.getBkgNo(), item.getCusCtmMovementVO().getCntrNo(), item.getCntrPrtFlg());
//            } else {
//                if(item.getMstBkgCntrOpUpdate()) {
//                	// Cntr Mvmt OC History - start
//                	item.getCusCtmMovementVO().setCreUsrId("SYSTEM");
//                	item.getCusCtmMovementVO().setUpdUsrId("SYSTEM");
//                	CusCtmMovementVO tempVO = item.getCusCtmMovementVO();
//                	if (!"".equals(tempVO.getBkgNo()) && !"".equals(tempVO.getCntrNo())) {
//	                	String fndBkgCntr =  item.getFindBkgCntr() ? "1" : "0";
//	                	this.addCntrMvmtOcHistory(tempVO, fndBkgCntr);
//                	}
//                	// Cntr Mvmt OC History - end
//
//                    errMsg = "Movement update error due to booking";
//                    dbDao.modifyCntrOp(item.getCusCtmMovementVO(), item.getFindBkgCntr());
//                    //modify crd
//                    dbDao.modifyCrd(item.getCusCtmMovementVO().getBkgNo(), item.getCusCtmMovementVO().getCntrNo());
//                    //insert seal no
//                    log.debug("item.getCusCtmMovementVO().getMvmtStsCd()=>" + item.getCusCtmMovementVO().getMvmtStsCd());
//                    if("OC".equals(item.getCusCtmMovementVO().getMvmtStsCd())){
//                    	//Add OP delete logic  
//                    	List<CntrMoveOpInfoVO> cntrMoveOpInfoVOs = dbDao.searchPreCycleCntrInfo(item.getCusCtmMovementVO());
//                    	if(cntrMoveOpInfoVOs.size() > 0 ){
//                    		for (int i = 0; i < cntrMoveOpInfoVOs.size(); i++){
//                    			if(!"Y".equals(cntrMoveOpInfoVOs.get(i).getCfmFlg())){
////                    				dbDao.removeContainer(bkgNo, cntrNo, "N"); form
//                    				log.debug(">>>>>>removeCntrSealNo: " + cntrMoveOpInfoVOs.get(i).getBkgNo() + " - " + cntrMoveOpInfoVOs.get(i).getCntrNo());
//                    				dbDao.removeCntrSealNo(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), "", "N");
//                    				// 2. remove Rate
////                    				// 3. remove Reference detail
////                    				// 4. remove Reference
//                    				// 5. remove Manifest
//                    				log.debug(">>>>>>removeCmByCntr: " + cntrMoveOpInfoVOs.get(i).getBkgNo() + " - " + cntrMoveOpInfoVOs.get(i).getCntrNo());
//                    				dbDao.removeCmByCntr(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), "N");
//                    				// 6. remove Container
//                    				log.debug(">>>>>>removeCntr: " + cntrMoveOpInfoVOs.get(i).getBkgNo() + " - " + cntrMoveOpInfoVOs.get(i).getCntrNo());                    				
//	                    			dbDao.removeContainer(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), "N");
//
//	                                BkgCopManageBC copMgt = new BkgCopManageBCImpl();
//	                                copMgt.detachCntr(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), item.getCntrPrtFlg());
//                    			}else{
//                    				isReturn = true;
//                    			}
//                    		}
//                    	}
//                    	if(null != item.getCusCtmMovementVO().getMvmtInpTpCd() && !"SPP".equals(item.getCusCtmMovementVO().getMvmtInpTpCd())){
//                    		log.debug("item.getCusCtmMovementVO().getMvmtInpTpCd()==>"+item.getCusCtmMovementVO().getMvmtInpTpCd());
//                        	if(null != item.getCusCtmMovementVO().getMvmtStsCd() && !"".equals(item.getCusCtmMovementVO().getCntrSealNo())) {
//    		                    if(dbDao.searchSealNo(item.getCusCtmMovementVO().getBkgNo(), item.getCusCtmMovementVO().getCntrNo(), "N").size() == 0){
//    		                    	BkgCntrSealNoVO bkgCntrSealNoVO = new BkgCntrSealNoVO();
//    		                    	bkgCntrSealNoVO.setBkgNo(item.getCusCtmMovementVO().getBkgNo());
//    		                    	bkgCntrSealNoVO.setCntrNo(item.getCusCtmMovementVO().getCntrNo());
//    		                    	bkgCntrSealNoVO.setCntrSealNo(item.getCusCtmMovementVO().getCntrSealNo());
//    		                    	bkgCntrSealNoVO.setPrnFlg("1");
//    		                    	bkgCntrSealNoVO.setCreUsrId(item.getCusCtmMovementVO().getCreUsrId());
//    		                    	
//    		                    	dbDao.insertCntrSealNo(bkgCntrSealNoVO, "N");
//    		                    }
//    	                    }
//                    	}
//                    }
//                    // calling COP 
//                    if("OP".equals(item.getCusCtmMovementVO().getMvmtStsCd())
//                            || "OC".equals(item.getCusCtmMovementVO().getMvmtStsCd())) {
////                    	log.error("SCE ** BKG_NO : "+item.getBkgNo() + " CNTR_NO : "+ item.getCntrNo() + " / item.getFindBkgCntr() = " + item.getFindBkgCntr());
//                        errMsg = "Movement update error due to COP";
//                        if(!item.getFindBkgCntr()) {
//                            // BkgCopManageBC::attachCntr ( bkgNo , cntrNo , flgPartial )
//                            BkgCopManageBC copMgt = new BkgCopManageBCImpl();
//                            copMgt.attachCntr(item.getCusCtmMovementVO().getBkgNo(), item.getCusCtmMovementVO()
//                                    .getCntrNo(), item.getCntrPrtFlg());
//                        }
//                    }
//                }
//            }
//            log.debug("isReturn:::::::::::::::::::" + isReturn);
//        } catch(DAOException ex) {
//            throw new EventException(new ErrorHandler(errMsg).getMessage());             
//        } catch(Exception ex) {
//            // log.error(ex.getMessage(), ex);
//            throw new EventException(new ErrorHandler(errMsg).getMessage());
//        }
//        return isReturn;
//    }
    
    /**
     * handling ContainerMovementMgt at calling from CTM
     * @param CrossItemVO item
     * @return BkgCntrMvmtRtnVO
     * @exception EventException
     */
    public BkgCntrMvmtRtnVO modifyCntrOp(CrossItemVO item) throws EventException {
        String errMsg = null;
        boolean isReturn = false;
        BkgCntrMvmtRtnVO bkgCntrMvmtRtnVO = new BkgCntrMvmtRtnVO();
        bkgCntrMvmtRtnVO.setReturnFlag("N");
        CntrMvmtRtnVO cntrMvmtRtnVO = new CntrMvmtRtnVO();
        try {
            if("D".equals(item.getAttchCd())) {
                errMsg = "Movement update error due to COP";
                
                BookingUtil utilCmd = new BookingUtil();
                BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
                bkgBlNoVO.setBkgNo(item.getBkgNo());
                
                //S/O error handling
                String bkg_so_sts = utilCmd.searchSoStatus(null, item.getCusCtmMovementVO().getCntrNo(), bkgBlNoVO, "O");
                if("Y".equals(bkg_so_sts)) {
                	errMsg = "Service order should be cancelled first.";
                    throw new EventException(new ErrorHandler(errMsg).getMessage());
                }
                
                // BkgCopManageBC::attachCntr ( bkgNo , cntrNo , flgPartial )
                BkgCopManageBC copMgt = new BkgCopManageBCImpl();
                copMgt.detachCntr(item.getBkgNo(), item.getCusCtmMovementVO().getCntrNo(), item.getCntrPrtFlg());
            } else {
            	if(item.getMstBkgCntrOpUpdate()) {
                	// Cntr Mvmt OC History - start
                	item.getCusCtmMovementVO().setCreUsrId("SYSTEM");
                	item.getCusCtmMovementVO().setUpdUsrId("SYSTEM");
                	CusCtmMovementVO tempVO = item.getCusCtmMovementVO();
                	if (!"".equals(tempVO.getBkgNo()) && !"".equals(tempVO.getCntrNo())) {
	                	String fndBkgCntr =  item.getFindBkgCntr() ? "1" : "0";
	                	this.addCntrMvmtOcHistory(tempVO, fndBkgCntr);
                	}
                	if("OP".equals(item.getCusCtmMovementVO().getMvmtStsCd()) || "OC".equals(item.getCusCtmMovementVO().getMvmtStsCd()) || "VL".equals(item.getCusCtmMovementVO().getMvmtStsCd())){
                		cntrMvmtRtnVO = dbDao.searchBkgCntrMvmtRtn(item.getCusCtmMovementVO(), item.getFindBkgCntr());
                		if( null != cntrMvmtRtnVO && null != cntrMvmtRtnVO.getBkgNo() && !"".equals(cntrMvmtRtnVO.getBkgNo())){
                			bkgCntrMvmtRtnVO.setReturnFlag("Y");
                			if(!"".equals(cntrMvmtRtnVO.getErrMsgCd()) && null != cntrMvmtRtnVO.getErrMsgCd()){
                				bkgCntrMvmtRtnVO.setReturnMessage(new ErrorHandler(cntrMvmtRtnVO.getErrMsgCd(), new String[]{item.getCusCtmMovementVO().getCntrNo(), cntrMvmtRtnVO.getBkgNo()}).getUserMessage());
                			}else{
                				bkgCntrMvmtRtnVO.setReturnMessage(new ErrorHandler("BKG00966", new String[]{item.getCusCtmMovementVO().getCntrNo(), cntrMvmtRtnVO.getBkgNo()}).getUserMessage());
                			}
                		}
                	}
                	// Cntr Mvmt OC History - end
                	
                			errMsg = "Movement update error due to booking";
                            dbDao.modifyCntrOp(item.getCusCtmMovementVO(), item.getFindBkgCntr());
                            //modify crd
                            dbDao.modifyCrd(item.getCusCtmMovementVO().getBkgNo(), item.getCusCtmMovementVO().getCntrNo());
                            //insert seal no
                            log.debug("item.getCusCtmMovementVO().getMvmtStsCd()=>" + item.getCusCtmMovementVO().getMvmtStsCd());
                            if("OC".equals(item.getCusCtmMovementVO().getMvmtStsCd())){
                            	//Add OP delete logic  
                            	List<CntrMoveOpInfoVO> cntrMoveOpInfoVOs = dbDao.searchPreCycleCntrInfo(item.getCusCtmMovementVO());
                            	if(cntrMoveOpInfoVOs.size() > 0 ){
                            		for (int i = 0; i < cntrMoveOpInfoVOs.size(); i++){
                            			if(!"Y".equals(cntrMoveOpInfoVOs.get(i).getCfmFlg())){
//                            				dbDao.removeContainer(bkgNo, cntrNo, "N"); form
                            				log.debug(">>>>>>removeCntrSealNo: " + cntrMoveOpInfoVOs.get(i).getBkgNo() + " - " + cntrMoveOpInfoVOs.get(i).getCntrNo());
                            				dbDao.removeCntrSealNo(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), "", "N");
                            				// 2. remove Rate
//                            				// 3. remove Reference detail
//                            				// 4. remove Reference
                            				// 5. remove Manifest
                            				log.debug(">>>>>>removeCmByCntr: " + cntrMoveOpInfoVOs.get(i).getBkgNo() + " - " + cntrMoveOpInfoVOs.get(i).getCntrNo());
                            				dbDao.removeCmByCntr(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), "N");
                            				// 6. remove Container
                            				log.debug(">>>>>>removeCntr: " + cntrMoveOpInfoVOs.get(i).getBkgNo() + " - " + cntrMoveOpInfoVOs.get(i).getCntrNo());                    				
        	                    			dbDao.removeContainer(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), "N");

        	                                BkgCopManageBC copMgt = new BkgCopManageBCImpl();
        	                                copMgt.detachCntr(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), item.getCntrPrtFlg());
                            			}else{
                            				bkgCntrMvmtRtnVO.setReturnFlag("Y");
                            				isReturn = true;
                            			}
                            		}
                            	}
                            	if(null != item.getCusCtmMovementVO().getMvmtInpTpCd() && !"SPP".equals(item.getCusCtmMovementVO().getMvmtInpTpCd())){
                            		log.debug("item.getCusCtmMovementVO().getMvmtInpTpCd()==>"+item.getCusCtmMovementVO().getMvmtInpTpCd());
                                	if(null != item.getCusCtmMovementVO().getMvmtStsCd() && !"".equals(item.getCusCtmMovementVO().getCntrSealNo())) {
            		                    if(dbDao.searchSealNo(item.getCusCtmMovementVO().getBkgNo(), item.getCusCtmMovementVO().getCntrNo(), "N").size() == 0){
            		                    	BkgCntrSealNoVO bkgCntrSealNoVO = new BkgCntrSealNoVO();
            		                    	bkgCntrSealNoVO.setBkgNo(item.getCusCtmMovementVO().getBkgNo());
            		                    	bkgCntrSealNoVO.setCntrNo(item.getCusCtmMovementVO().getCntrNo());
            		                    	bkgCntrSealNoVO.setCntrSealNo(item.getCusCtmMovementVO().getCntrSealNo());
            		                    	bkgCntrSealNoVO.setPrnFlg("1");
            		                    	bkgCntrSealNoVO.setCreUsrId(item.getCusCtmMovementVO().getCreUsrId());
            		                    	
            		                    	dbDao.insertCntrSealNo(bkgCntrSealNoVO, "N");
            		                    }
            	                    }
                            	}
                            }
                            // calling COP 
                            if("OP".equals(item.getCusCtmMovementVO().getMvmtStsCd())
                                    || "OC".equals(item.getCusCtmMovementVO().getMvmtStsCd())) {
//                            	log.error("SCE ** BKG_NO : "+item.getBkgNo() + " CNTR_NO : "+ item.getCntrNo() + " / item.getFindBkgCntr() = " + item.getFindBkgCntr());
                                errMsg = "Movement update error due to COP";
                                if(!item.getFindBkgCntr()) {
                                    // BkgCopManageBC::attachCntr ( bkgNo , cntrNo , flgPartial )
                                    BkgCopManageBC copMgt = new BkgCopManageBCImpl();
                                    copMgt.attachCntr(item.getCusCtmMovementVO().getBkgNo(), item.getCusCtmMovementVO()
                                            .getCntrNo(), item.getCntrPrtFlg());
                                }
                            }
                		}
                	}
//                }
            log.debug("isReturn:::::::::::::::::::" + isReturn);
            log.debug("isReturn:::::::::::::::::::" + bkgCntrMvmtRtnVO.getReturnFlag());
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(errMsg).getMessage());             
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new EventException(new ErrorHandler(errMsg).getMessage());
        }
        return bkgCntrMvmtRtnVO;
    }
    
    /**
     * method for Container History Update at calling from CTM
     * @param CusCtmMovementVO vo 
     * @param String delFlg
     * @exception EventException
     */
   public void modifyCntrHistoryUpdate(CusCtmMovementVO vo, String delFlg) throws EventException {
        try {
            dbDao.modifyCntrHistoryUpdate(vo, delFlg);
        	// Cntr Mvmt OC History - start
            vo.setCreUsrId("SYSTEM");
            vo.setUpdUsrId("SYSTEM");
        	CusCtmMovementVO tempVO = vo;
        	if (!"".equals(tempVO.getBkgNo()) && !"".equals(tempVO.getCntrNo())) {
            	this.addCntrMvmtOcHistory(tempVO, "1");
        	}
        	// Cntr Mvmt OC History - end
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

   /**
    * manage CmByHbl
    * 
    * @param HblVO hblVO
    * @param SignOnUserAccount account
    * @param String caFlg
    * @exception EventException
    */
   public void manageCmByHbl(HblVO hblVO, SignOnUserAccount account, String caFlg) throws EventException{
       List<BkgCntrMfDescVO> vo2 = hblVO.getBkgCntrMfDescVOs();
       List<HblDtlInfoVO> vo3 = hblVO.getHblDtlInfoVOs();
       try {
           /* cm */
           if(vo2 != null){
               for(int i = 0; i < vo2.size(); i++) {
                   log.debug("BkgCntrMfDescVO -> " + vo2.get(i).getCntrMfNo() + " : " + vo2.get(i).getIbflag());
                   vo2.get(i).setCreUsrId(account.getUsr_id());
                   vo2.get(i).setUpdUsrId(account.getUsr_id());
                   if("I".equals(vo2.get(i).getIbflag())) {
                       //insertCmList.add(vo2.get(i));
                       dbDao.addCm(vo2.get(i), caFlg);
                   } else if("U".equals(vo2.get(i).getIbflag())) {
                       //updateCmList.add(vo2.get(i));
                       dbDao.modifyCm(vo2.get(i), caFlg);
                   } else if("D".equals(vo2.get(i).getIbflag())) {
                       //deleteCmList.add(vo2.get(i));
                       dbDao.removeCm(vo2.get(i), caFlg);
                   }
               }
           }
           
           /* Container Manifest No. Update by HBL Delete */
           if(vo3 != null) {
        	   for(int i = 0; i < vo3.size(); i++) {
        		   log.debug("HblDtlInfoVOs : bkg no:" + vo3.get(i).getBkgNo() + " cntr mf no " + vo3.get(i).getCntrMfNo());
        		   if("D".equals(vo3.get(i).getIbflag())) {
        			   dbDao.removeCntrMfNo(vo3.get(i), caFlg);
        		   }
        	   }
           }
       } catch(DAOException ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       }
   }
 
	/**
	 * update Exception information by KOREA WHF CNTR at bkg_container table
	 * @param List<CntrKrWhfExptVO> cntrKrWhfExptVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCntrKrWhfExpt (List<CntrKrWhfExptVO> cntrKrWhfExptVOs, SignOnUserAccount account)throws EventException {
		try {
			if (cntrKrWhfExptVOs.size() > 0) {
				dbDao.modifyCntrKrWhfExpt(cntrKrWhfExptVOs);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
    /**
     * MstContainer information retrieve
     * 
     * @param cntrNo
     * @return MstContainerVO
     * @exception EventException
     */
    public MstContainerVO searchMstCntrForMst(String cntrNo) throws EventException {
    	try{
    		return dbDao.searchMstCntrForMst(cntrNo);
        } catch (DAOException ex) {
         throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
         throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    

    /**
     * Update C/M by container wgt./meas. unit
     * 
     * @param bkgNo
     * @param bkgWgtUtCd
     * @param bkgMeasUtCd
     * @param account
     * @param caFlg
     * @exception EventException
     */
    public void modiftyCmUnitByCntr(String bkgNo, String bkgWgtUtCd, String bkgMeasUtCd, SignOnUserAccount account, String caFlg) throws EventException{
        try{
            dbDao.modiftyCmUnitByCntr(bkgNo, bkgWgtUtCd, bkgMeasUtCd, account.getUsr_id(), caFlg);
        } catch (DAOException ex) {
         throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
         throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * container manifest information creation. -- UI_BKG_0229_05, BKG CONTAINER MANIFEST DESCRIPTION
     * 
     * @param cmVO
     * @param account
     * @param caFlg 
     * @exception EventException
     */
	public void manageCmByXter(CmVO cmVO, SignOnUserAccount account, String caFlg) throws EventException{
		CmBkgInfoVO cmBkgInfoVO = cmVO.getCmBkgInfoVO();
	    List<BkgCntrMfDescVO> cntrMfDescVOs = cmVO.getBkgCntrMfDescVOs();
	        
        try {
            /* container manifest */
            if(cntrMfDescVOs != null && cntrMfDescVOs.size() > 0){
                for(int i = 0; i < cntrMfDescVOs.size(); i++) {
                	cntrMfDescVOs.get(i).setBkgNo(cmBkgInfoVO.getBkgNo());
                	cntrMfDescVOs.get(i).setCreUsrId(account.getUsr_id());
                	cntrMfDescVOs.get(i).setUpdUsrId(account.getUsr_id());
                    if(cntrMfDescVOs.get(i).getIbflag().equals("D")) {
                        dbDao.removeCm(cntrMfDescVOs.get(i), caFlg);
                    } else if(cntrMfDescVOs.get(i).getIbflag().equals("I")) {
                        dbDao.addCm(cntrMfDescVOs.get(i), caFlg);
                    } else if(cntrMfDescVOs.get(i).getIbflag().equals("U")) {
                        dbDao.modifyCmByXter(cntrMfDescVOs.get(i), caFlg);
                    }                    
                }
            }
	    } catch (DAOException ex) {
		   throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       	} catch (Exception ex) {
    	   throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       	}
	}
	
	/**
     * update route name of bkg
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param BkgBookingInfoVO bkgBookingInfoVO 
     * @param account
     * @exception EventException
     */
	public void modifyBkgRouteNm(BkgBlNoVO bkgBlNoVO, BkgBookingInfoVO bkgBookingInfoVO, SignOnUserAccount account) throws EventException{
        try {
            dbDao.modifyBkgRouteNm(bkgBlNoVO, bkgBookingInfoVO, account);
	    } catch (DAOException ex) {
		   throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       	} catch (Exception ex) {
    	   throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       	}
	}
	
	/**
     * Re-calculate special cargo flag by cntr after split
     * @param BkgBlNoVO[] targetBkg
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyCntrSpclFlag(BkgBlNoVO[] targetBkg, SignOnUserAccount account) throws EventException{
        try {
			for(int i=0;i<targetBkg.length;i++){
				dbDao.modifyCntrSpclFlag(targetBkg[i], account);	
			}
	    } catch (DAOException ex) {
		   throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       	} catch (Exception ex) {
    	   throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       	}
	}

	/**
     * update cgo_rcv_dt of cntr
     * 
     * @param ContainerVO[] containerVOs
     * @param String caFlg
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void modifyCrdDt(ContainerVO[] containerVOs, String caFlg, SignOnUserAccount account) throws EventException {
        try {
        	if (null!=containerVOs && 0<containerVOs.length) {
				for (int i=0; i<containerVOs.length; i++) {
					dbDao.modifyCrdDt(containerVOs[i], caFlg, account);	
				}
        	}
	    } catch (DAOException ex) {
		   throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       	} catch (Exception ex) {
    	   throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       	}
	}
	
	/**
     * retrieve data about BkgDgCgoVO model
     * 
     * @param String bkgNo
     * @return List<BkgDgCgoVO>
     * @exception EventException
     */
	public List<BkgDgCgoVO> searchBkgDgCgo( String bkgNo ) throws EventException {
		try {
			 return dbDao.searchBkgDgCgo(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	/**
	 * Cntr Mvmt OC History save
	 * 
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param String fndBkgCntr
	 * @exception EventException
	 */
	public void addCntrMvmtOcHistory(CusCtmMovementVO cusCtmMovementVO, String fndBkgCntr) throws EventException {
		try {
			dbDao.addCntrMvmtHis(cusCtmMovementVO, fndBkgCntr);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * modifyCntrFlgByRfCgo<br>
	 *  
	 * @param RfCgoApplVO rfCgoApplVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyCntrFlgByRfCgo(RfCgoApplVO rfCgoApplVO, String caFlg) throws EventException {
		try {
			dbDao.modifyCntrFlgByRfCgo(rfCgoApplVO, caFlg);	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
     * multi split시에 sourceBkg에서 bkg_cntr, bkg_cntr_seal_no를 읽어서 targetBkg에 insert한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectCntrVO> orgSelectCntrVO
     * @param List<SelectCntrVO> selectCntrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void copyCntrCmByBkgMulti(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg,
			List<SelectCntrVO> orgSelectCntrVO, List<SelectCntrVO> selectCntrVO,
			SignOnUserAccount account) throws EventException{
		try {
            //new bkg으로 cntr을 복사
            for(int i = 0; i < targetBkg.length; i++) {
                if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                    for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
                        // sourceBkg의 bkg_container를 targetBkg으로 복사한다
                    	log.debug("sourceBkg:"+sourceBkg.getBkgNo()+",targetBkg:"+targetBkg[i].getBkgNo());
                        if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg[i].getBkgNo())
                            && selectCntrVO.get(icnt).getSplitNo().length()>1){
                            dbDao.copyBkgCntrByBkg(targetBkg[i], sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt), account);
                            // sourceBkg에서 bkg_cntr_mf를 읽어서 targetBkg에 insert한다
                            dbDao.copyCmByBkg(targetBkg[i], sourceBkg, "S", (SelectCntrVO) selectCntrVO.get(icnt), account);
                            // sourceBkg의 bkg_cntr_seal_no를 targetBkg으로 복사한다
                            dbDao.copyBkgCntrSealByBKG(targetBkg[i], sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt),account);
                        }
                    }
                }
            }
            
            //원본BkgNo에 대해 Cntr체크 해제시 처리
            for(int i = 0; i < targetBkg.length; i++) {
                if(sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
                    if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg[i].getBkgNo())
                      && selectCntrVO.get(icnt).getSplitNo().length()<1){
                        // 전달받은 cntr No로 bkg_cntr_seal_no 에서 삭제한다
                        dbDao.removeCntrSealNoAfterSplit(sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt));
                        // BKG CONTAINER MANIFEST DESCRIPTION 정보를 삭제한다.
                        dbDao.removeCmByCntr(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
                        // BKG CONTAINER 테이블에서 Delete Flag를 'Y'로 변경
                        dbDao.removeContainer(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
                    }
                  }
               }
            }        

            // source bkg의 cntr list
            BookingUtil utilBC = new BookingUtil();
            String[] cntrNo = utilBC.searchCntrListByBkg(sourceBkg);

            for (int i = 0; i < cntrNo.length; i++) {
	            List<BkgBlNoVO> splitBkgs = dbDao.searchPartialBkgByCntr(sourceBkg, cntrNo[i]);
	            if(splitBkgs.size() > 1){
	            	BkgContainerVO bkgContainerVO = dbDao.searchPartialVol(sourceBkg, cntrNo[i]);
	            	for(int j = 0; j < splitBkgs.size(); j++){
	            		if(!sourceBkg.getBkgNo().equals(splitBkgs.get(j).getBkgNo())){
	            			dbDao.modifyBkgCntrPartialFlgMulti(sourceBkg, splitBkgs.get(j), bkgContainerVO, splitBkgs.size(), account);
	            		}
	            	}
	            	dbDao.modifyBkgCntrPartialMstVol(sourceBkg, bkgContainerVO, account);
            	}	
            }
//			String firstCntrFlag = "N";
//			BkgBlNoVO firstBkg = null;
//			int[] partialCnt = new int[cntrNo.length];
//			
//				firstCntrFlag = "N";
//				firstBkg = null;
//				partialCnt[i] = 0;
//				for(int j = 0;j < selectCntrVO.size(); j++) {
//					if (selectCntrVO.get(j).getCntr_no().equals(cntrNo[i])
//							&& selectCntrVO.get(j).getSplitNo().length() > 1) {
//						partialCnt[i]++;
//					}
//				}
//				// partial cntr일 경우
//				for (int j = 0; j < targetBkg.length; j++) {
//					if (partialCnt[i] > 1) {
//						for (int k = 0; k < selectCntrVO.size(); k++) {
//							if (selectCntrVO.get(k).getCntr_no().equals(cntrNo[i])
//									&& selectCntrVO.get(k).getBkg_no().equals(targetBkg[j].getBkgNo())
//									&& selectCntrVO.get(k).getSplitNo().length() > 1) {
//								if ("N".equals(firstCntrFlag)) {
//									if (dbDao.searchExistContainer(targetBkg[j].getBkgNo(), cntrNo[i], "N")) {
//										firstCntrFlag = "Y";
//										firstBkg = targetBkg[j];
//									}
//								}
//								if (null != firstBkg) {
//									log.debug("cntrNo:" + cntrNo[i]
//											+ " source bkg_no:" + firstBkg
//											+ " target bkg : "+ targetBkg[j]);
//									dbDao.modifyBkgCntrPartialFlgMulti(firstBkg, targetBkg[j], cntrNo[i], partialCnt[j], account);
//								}
//							}
//						}
//					}
//				}
//			}                    
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	/**
     *  Reactivate Container(ESM_BKG_0000_1) -> reactivateBooking
     *  
     * @author      KYOUNG IL MOON
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void activateBkgCntr(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
        try {
            dbDao.activateBkgCntr(bkgBlNoVO, account);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
}