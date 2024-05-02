/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BLDocumentationCMBCImpl.java
 *@FileTitle : Container No Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.24 김영출
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.07 최도순 [CHM-201007310] BKG C/M 화면에 DG SEQ 선택 필드 (구주 24 HR)
 * 2011.01.25 이일민 [CHM-201108410-01] [CSR] Container OC History Table 항목 추가
 * 2011.02.10 이일민 [CHM-201108410-01] [CSR] Container OC History Table 항목 추가 - 조건(bkgNo) 추가
 * 2011.02.10 이일민 [CHM-201108410-01] [CSR] Container OC History Table 항목 추가 - 조건(cntrNo) 추가
 * 2011.02.17 이일민 [CHM-201108410-01] [CSR] Container OC History Table 항목 추가 - modifyCntrHistoryUpdate 함수에 추가
 * 2011.05.16 이일민 [CHM-201110332] ALPS Transshipment 메뉴 오류 수정요청
 * 2012.06.18 조정민 [CHM-201217472] [BKG] BKG/DOC Validation Rule 정리 요청
 * 2012.07.09 전성진 [] booking re-activate 기능 보완, Container cancel 원복처리 추가
 * 2013.01.11 문동선 [CHM-201322322] BKG Creation 화면 C/M tab 상 HS code 관련 Alert message 수정
 * 2013.02.25 김현화 [CHM-201222205] multi ncm code c/a mode 수정
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TmnlRcvIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration.BLDocumentationCMDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgBlActWgtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCopyCntrCmByBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCustShpRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgListForGeneralTmlVermasEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgListForTmlVermasEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmByCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCopyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrDetailInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrInfoOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrMoveOpInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrMstInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CreateBkgBlDocBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.EdiNotUpdCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MaxCycleBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.PreConfirmBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.RataBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ValidateContainerWgtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCntrMfDescDtlVO;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgDgCgoVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.MstContainerVO;

/**
 * ALPS-OutboundBLMgt Business Logic Basic Command implementation<br>
 * - ALPS-OutboundBLMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Youngchul
 * @see UI_BKG-0892EventResponse,BLDocumentationCMBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class BLDocumentationCMBCImpl extends BasicCommandSupport implements BLDocumentationCMBC {

    // Database Access Object
    private transient BLDocumentationCMDBDAO dbDao = null;

    /**
     * BLDocumentationCMBCImpl 객체 생성<br>
     * BLDocumentationCMDBDAO를 생성한다.<br>
     */
    public BLDocumentationCMBCImpl() {
        dbDao = new BLDocumentationCMDBDAO();
    }

    /**
     * T.VVD 및 BKG Offce, POL, POD 를 기준으로 C/M을 Copy 하기 위해 Container 별로 조회한다.<br>
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
     * container seal number 정보를 조회한다.
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
     * 조회 이벤트 처리<br>
     * BLDocumentation화면에 대한 조회 이벤트 처리<br>
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
     * 조회 이벤트 처리<br>
     * BLDocumentation화면에 대한 조회 이벤트 처리<br>
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
     * VVD 및 Container No가 같은 Partial Container Booking중에 Container Confirm 상태가 된 BKG가 있는지 확인한다. -- UI_BKG-0079-04
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
     * container 정보를 조회한다. -- UI_BKG-0172, 
     * BKG CONTAINER, BKG CONTAINER SEAL NUMBER, BKG BOOKING, BKG DOCUMENT PROCESS SCHEDULE, BKG RATE 등
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
     * container 정보를 생성/수정 한다.
     * 
     * @param List<ContainerVO> updateVoList
     * @param String caFlg
     * @exception EventException
     */
    public void manageContainer(List<ContainerVO> updateVoList, String caFlg) throws EventException {
    	BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
    	BookingUtil bookingUtil = new BookingUtil();
       try {
            int len = updateVoList == null ? 0 : updateVoList.size();
            for (int i = 0; i < len; i++) {
                ContainerVO cntrVo = updateVoList.get(i);
                log.debug("***** Manage Container : " + cntrVo.getIbflag() + " - " + cntrVo.getCntrNo());
            	if(dbDao.updateContainer(cntrVo, caFlg) == 0){   
		
            	    dbDao.insertContainer(cntrVo, caFlg);
            	    
            	    if("Y".equals(bookingUtil.searchEffDtDiv(cntrVo.getBkgNo(),"EQ_ID","BKG"))){
                		//EQ ID를 위한 History생성
                		BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
                		docProcSkdVO.setBkgDocProcTpCd("CNTATC");
                		docProcSkdVO.setBkgNo(cntrVo.getBkgNo());
                		docProcSkdVO.setDiffRmk(cntrVo.getCntrNo());
                		docProcSkdVO.setCaFlg(caFlg);
                		docProcSkdVO.setPairFlg("N");
            			SignOnUserAccount account = new SignOnUserAccount();
            			account = new SignOnUserAccount(cntrVo.getCreUsrId() ,"" ,"" ,"" ,""
        												,"" ,"" ,"" ,"" ,""
        												,"" ,"" ,"" ,"" ,""
        												,"" ,"" ,"" ,"", "", "" ,""
    													);
                		histCmd.manageDocProcess(docProcSkdVO, account);
            	    }
                    
            	    /*
            	     * 2017.05.31 iylee 추가
            	     * 
            	     * Attach 하는 Container의 Movement가 TN인 경우
            	     * 
            	     * 1. TN->OP로 Movement 발생시킴.(CTM Call)
            	     * 2. TN Movement 이력 남김.
            	     * 3. OP발생 후 Movement 이력 및 BKG 후처리.
            	     */
            	    
            	    boolean isMvmtTN = false;
            	    if(cntrVo.getCnmvStsCd() != null && !"".equals(cntrVo.getCnmvStsCd())){
            	    	if(cntrVo.getCnmvStsCd().equals("TN")){
            	    		isMvmtTN = true;
            	    	}
            	    }
            	  
            	    ContainerMovementMgtBC cntrMvmtBc = new ContainerMovementMgtBCImpl();
	    			CrossItemVO crossItemVO = cntrMvmtBc.modifyMvmtStsByAtchCntrToBkg(cntrVo.getBkgNo(), cntrVo.getCntrNo(), cntrVo.getCreUsrId());

    	    		if(isMvmtTN && crossItemVO != null){
    	    			
    	    			// TN Movement 이력 남김.
    	    			CusCtmMovementVO cusCtmMovementVO = new CusCtmMovementVO();
	    					cusCtmMovementVO.setBkgNo(cntrVo.getBkgNo());
	    					cusCtmMovementVO.setCntrNo(cntrVo.getCntrNo());
	    					cusCtmMovementVO.setMvmtStsCd("TN");
	    				cusCtmMovementVO.setCreUsrId(cntrVo.getCreUsrId());
	    					cusCtmMovementVO.setUpdUsrId(cntrVo.getUpdUsrId());
	    					cusCtmMovementVO.setCnmvEvntDt(cntrVo.getCgoRcvDt());
	    					addCntrMvmtOcHistory(cusCtmMovementVO, "");
    	    			
    	    			// OP상태의 CTM정보를 Booking쪽 Update
    	    			modifyCntrOp(crossItemVO);

            	    } else {
    	    		
	            	    /*
	            	     * Container Attach 신규 Attach 시 해당 BKG_NO & CNTR_NO에 대해 
	            	     * 기존에 Movement 정보가 기 발생했을 경우 해당 이력정보를 참조해 Cycle 정보를 업데이트 해준다.
	            	     */
            	    	BkgContainerVO mvntCntrVo = dbDao.searchCntrLstMvntInfo(cntrVo.getBkgNo(),cntrVo.getCntrNo());   
	             	    
	            	    if(mvntCntrVo != null){         	    	
	            	    	if( "VD".equals( mvntCntrVo.getCnmvStsCd()) ||
	            	    		"IC".equals( mvntCntrVo.getCnmvStsCd()) ||
	            	    		"EN".equals( mvntCntrVo.getCnmvStsCd()) ||
	            	    		"TN".equals( mvntCntrVo.getCnmvStsCd()) ) {
	                   	  
	            	    		dbDao.modifyCntrMvntSts(mvntCntrVo, caFlg);
	            	    	}
	            	    }
            	    }
                }	
            }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

//    /**
//     * container 정보를 생성/수정 한다.
//     * 
//     * @param List<ContainerVO> updateVoList
//     * @exception EventException
//     */
//    public void manageContainerByXter(List<ContainerVO> updateVoList) throws EventException {
//        try {
//            log.debug("***** updateVoList : " + (updateVoList == null ? 0 : updateVoList.size()));
//            if(updateVoList.size() > 0) {
//                dbDao.manageContainerByXterS(updateVoList);
//            }
//        } catch(DAOException ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        } catch(Exception ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        }
//    }
    
        /**
     * container 정보를 생성/수정 한다. --ESM_BKG_0229_03
     * 
     * @param List<ContainerVO> updateVoList
     * @param String caFlg
     * @exception EventException
     */
    public void manageContainerByXter(List<ContainerVO> updateVoList, String caFlg) throws EventException {
    	BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
    	BookingUtil bookingUtil = new BookingUtil();
        try {
            int len = updateVoList == null ? 0 : updateVoList.size();
            for (int i = 0; i < len; i++) {
                ContainerVO cntrVo = updateVoList.get(i);
                log.debug("***** Manage Container : " + cntrVo.getIbflag() + " - " + cntrVo.getCntrNo());
            	if(dbDao.updateCntrByXter(cntrVo, caFlg) == 0){
            		dbDao.insertCntrByXter(cntrVo, caFlg);
            		
            		if("Y".equals(bookingUtil.searchEffDtDiv(cntrVo.getBkgNo(),"EQ_ID","BKG"))){
                		//EQ ID를 위한 History생성
                		BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
                		docProcSkdVO.setBkgDocProcTpCd("CNTATC");
                		docProcSkdVO.setBkgNo(cntrVo.getBkgNo());
                		docProcSkdVO.setDiffRmk(cntrVo.getCntrNo());
                		docProcSkdVO.setCaFlg(caFlg);
                		docProcSkdVO.setPairFlg("N");
            			SignOnUserAccount account = new SignOnUserAccount();
            			account = new SignOnUserAccount(cntrVo.getCreUsrId() ,"" ,"" ,"" ,""
        												,"" ,"" ,"" ,"" ,""
        												,"" ,"" ,"" ,"" ,""
        												,"" ,"" ,"" ,"", "", "" ,""
    													);
                		histCmd.manageDocProcess(docProcSkdVO, account);
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
     * Container를 다른 booking으로 복사한다. -- UI_BKG-0170, BKG CONTAINER
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
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BLDocumentationBLBC blDoc = new BLDocumentationBLBCImpl();
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
            	String oldDesc = dbDao.searchWpmDescForBl(blNoVO, "N");
                
            	dbDao.copyBkgCntrByCntr(cntrCopyVO, srcCaFlg);
                dbDao.copyBkgCntrSealByCntr(cntrCopyVO, srcCaFlg);
                dbDao.copyCmByCntr(cntrCopyVO, srcCaFlg);
                
                //wpm관련 자동문구 저장
	            blDoc.modifyBlDescByWpm(blNoVO, oldDesc, cntrCopyVO.getCreUsrId());
	            
                if("Y".equals(utilCmd.searchEffDtDiv(cntrCopyVO.getTgtBkgNo(),"EQ_ID","BKG"))){
            		//EQ ID를 위한 History생성
            		BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
            		docProcSkdVO.setBkgDocProcTpCd("CNTATC");
            		docProcSkdVO.setBkgNo(cntrCopyVO.getTgtBkgNo());
            		docProcSkdVO.setDiffRmk(cntrCopyVO.getCntrNo());
            		docProcSkdVO.setCaFlg(srcCaFlg);
            		docProcSkdVO.setPairFlg("N");
        			SignOnUserAccount account = new SignOnUserAccount();
        			account = new SignOnUserAccount(cntrCopyVO.getCreUsrId() ,"" ,"" ,"" ,""
    												,"" ,"" ,"" ,"" ,""
    												,"" ,"" ,"" ,"" ,""
    												,"" ,"" ,"" ,"", "", "" ,""
    												);
            		histCmd.manageDocProcess(docProcSkdVO, account);
                }

            } else {
                throw new EventException(new ErrorHandler("BKG00114", new String[]{tgtBkgNo}).getMessage());
            }
            /*
             * 하나의 Container가 Release됨에 따라.. 
             * 그 Container를 포함하는 Booking의 모든 Container의 상태를 Release 한다.
             */
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
     * container 정보를 다른 booking으로 옮긴다. -- UI_BKG-0170, BKG CONTAINER
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @exception EventException
     */
    public void moveContainer(String bkgNo, String cntrNo, String caFlg) throws EventException {
        try {
        	
        	BLDocumentationBLBC blDoc = new BLDocumentationBLBCImpl();	
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(bkgNo);
			bkgBlNoVO.setCaFlg(caFlg);
        	String oldDesc = dbDao.searchWpmDescForBl(bkgBlNoVO, "N");
        	
            dbDao.removeCntrSealNo(bkgNo, cntrNo, "", caFlg);
            dbDao.removeCmByCntr(bkgNo, cntrNo, caFlg);
            dbDao.removeContainer(bkgNo, cntrNo, caFlg);
            
            //wpm관련 자동문구 저장
            blDoc.modifyBlDescByWpm(bkgBlNoVO, oldDesc, "SYSTEM");
            
            /*
             * 하나의 Container가 Release됨에 따라.. 
             * 그 Container를 포함하는 Booking의 모든 Container의 상태를 Release 한다.
             */
            dbDao.modifyCntrCfmFlgByBkg(bkgNo, "N", caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * container confrim이 가능한지 확인한다.
     * BC 내부 메소드
     * @param CntrEtcInfoVO cntrEtcInfoVO
     * @param ContainerVO[] containerVOs
     * @param String fnlCfmFlg
     * @exception EventException
     */
    public void validateContainerConfirm(CntrEtcInfoVO cntrEtcInfoVO, ContainerVO[] containerVOs, String fnlCfmFlg) throws EventException {
    	
    	BookingUtil utilCmd = new BookingUtil();
        
    	try {
	        int len = containerVOs == null ? 0 : containerVOs.length;
	        for(int i = 0; i < len; i++) {
	            String ibFlag = containerVOs[i].getIbflag();
	            log.debug(">" + containerVOs[i].getCntrNo() + " : ibFlag=" + ibFlag + ", CntrCfmFlg=" + containerVOs[i].getCntrCfmFlg()+ ", fnlCfmFlg=" + fnlCfmFlg);
	            log.debug(">" + containerVOs[i].getCntrNo() + " : getCntrPrtFlg=" + containerVOs[i].getCntrPrtFlg());
	            	            
		    	if("Y".equals(fnlCfmFlg)) {
		            /**
		             * Partial 컨테이너의 경우, 모든 BKG의 Volumn 합이 '1'이 되어야 함 
		             * - updated on 2010.01.18
		             * Grid에서 Partial일 경우 1로 넘어옴
		             */
		            if("1".equals(containerVOs[i].getCntrPrtFlg()) && !"D".equals(ibFlag)){
		                //searchPartialBkg ( bkgNo , cntrNo , caFlag );
		                String rstr = dbDao.searchPartialBkg (containerVOs[i]);
		                if(rstr != null && rstr.length() > 0){
		                    throw new EventException(new ErrorHandler("BKG00706", new String[]{cntrEtcInfoVO.getTVvd() + ".\n     " + rstr}).getMessage());                            
		                }
		            }	            

		            if(!"D".equals(ibFlag)){
		                //이전 cycle의 Container 상태를 조회하여 confirm 여부 결정
		                PreConfirmBkgVO preConfirmBkgVO = dbDao.searchConfirmOthBkg (containerVOs[i].getBkgNo(), containerVOs[i].getCntrNo(), cntrEtcInfoVO.getCorrFlg());
		                log.debug(">searchConfirmOthBkg" + preConfirmBkgVO);
		                if(preConfirmBkgVO != null && "NNNNN".equals(preConfirmBkgVO.getPorStsVvd())){
		                    throw new EventException(new ErrorHandler("BKG08180", new String[]{containerVOs[i].getCntrNo(), preConfirmBkgVO.getPreBkgNo()}).getMessage());                            
		                }
		            }
		            
		            if("I".equals(containerVOs[i].getIbflag()) || "U".equals(containerVOs[i].getIbflag())){
		            	if(null!=containerVOs[i].getPckTpCd().trim() && "" != containerVOs[i].getPckTpCd().trim() && containerVOs[i].getPckTpCd().trim().length()!=0){	
		            		boolean flag = utilCmd.validatePkgType(containerVOs[i].getPckTpCd());
		            		if(!flag){
		            			throw new EventException(new ErrorHandler("BKG08221", new String[]{containerVOs[i].getPckTpCd()}).getMessage());
		            		}
		            	}
		            }
		//            // 해당 BKG의 이미지에 Cargo Sequence가 있는지 확인한다.
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
		//            // EQ Detail of Special Cargo Quantity 정보를 조회한다.
		//            List<BkgQtyDtlVO> qtyDtlVos = dbDao.searchBkgQtyDtl(bkgBlNoVO);
		//            if(qtyDtlVos == null) {
		//                throw new EventException("validateContainer=>searchBkgQtyDtl");
		//            }
		//            // Special 물량을 조회한다.
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
     * container 정보를 저장가능한지 확인한다.
     * BC 내부 메소드
     * @param CntrEtcInfoVO cntrEtcInfoVO
     * @param ContainerVO[] containerVOs
     * @param String fnlCfmFlg
     * @return List<Map<String,Object>>
     * @exception EventException
     */

    public List<Map<String,Object>> validateContainer(CntrEtcInfoVO cntrEtcInfoVO, ContainerVO[] containerVOs, String fnlCfmFlg) throws EventException {
        /*
         * TODO Container 저장하기 전에 Check Validation
         */
    	BookingUtil utilCmd = new BookingUtil();
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
                 * 유효한 컨테이너인지 검증 - updated on 2010.01.14
                 */
                CntrMstInfoVO cntrVO = dbDao.searchMstContainer(containerVOs[i].getCntrNo());
                if(cntrVO == null || cntrVO.getCntrNo() == null){
                    throw new EventException(new ErrorHandler("BKG00173", new String[]{containerVOs[i].getCntrNo()}).getMessage());
                }
                /*
                 * Restuffing Container 에 대하여 모든 Container Attach Validation Skip
                 */
                CntrMstInfoVO cntrRstfVO = dbDao.searchRstfCntr(containerVOs[i].getCntrNo(), containerVOs[i].getCntrNoOld(), containerVOs[i].getBkgNo());
                if(cntrRstfVO != null  && !"".equals(cntrRstfVO.getCntrNo())){
                	//모든 Container Attach Validation Skip
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
//                if("Y".equals(fnlCfmFlg)) {
//                    List<CargoDtlVO> cargoDtlVOs = dbDao.searchCargoQtyDtl ( bkgBlNoVO );
//                }
                }
                if("I".equals(containerVOs[i].getIbflag()) || "U".equals(containerVOs[i].getIbflag())){
	            	if(null!=containerVOs[i].getPckTpCd().trim() && "" != containerVOs[i].getPckTpCd().trim() && containerVOs[i].getPckTpCd().trim().length()!=0){
	            		boolean flag = utilCmd.validatePkgType(containerVOs[i].getPckTpCd());
	            		if(!flag){
	            			throw new EventException(new ErrorHandler("BKG08221", new String[]{containerVOs[i].getPckTpCd()}).getMessage());
	            		}
	            	}
	            	if(!"Y".equalsIgnoreCase(dbDao.checkSocCntr(containerVOs[i].getCntrNo())) && !containerVOs[i].getBbCgoFlg().equals("1")){
		            	//vgm min/max 검사
		            	if(NumberUtils.toDouble(containerVOs[i].getVgmWgt()) > 0 && StringUtils.isNotBlank(containerVOs[i].getVgmWgt()) && StringUtils.isNotBlank(containerVOs[i].getCntrTpszCd()) && StringUtils.isNotBlank(containerVOs[i].getVgmWgtUtCd())){
		            		String vgmUpdFlg = dbDao.checkVGMMinMax(containerVOs[i].getVgmWgt(), containerVOs[i].getCntrTpszCd(), containerVOs[i].getVgmWgtUtCd());
			            	if("MIN".equals(vgmUpdFlg)){
			            		throw new EventException(new ErrorHandler("BKG95099", new String[]{"less","minimum"}).getMessage());
			            	} else if ("MAX".equals(vgmUpdFlg)){
			            		throw new EventException(new ErrorHandler("BKG95099", new String[]{"more","maximum"}).getMessage());
			            	} 
		            	}
		            	
		            	//cntr loadable max 검사
		            	if(NumberUtils.toDouble(containerVOs[i].getCntrWgt()) > 0 && StringUtils.isNotBlank(containerVOs[i].getWgtUtCd())){
		            		String loadMaxFlg = dbDao.checkLoadableMax(containerVOs[i].getCntrWgt(), containerVOs[i].getCntrTpszCd(), containerVOs[i].getWgtUtCd());
		            		if("N".equalsIgnoreCase(loadMaxFlg)){
		            			throw new EventException(new ErrorHandler("BKG95100", new String[]{containerVOs[i].getCntrNo()}).getMessage());
		            		}
		            	}
	            	}
	            	
	            }
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
     * container 정보를 저장가능한지 확인한다.
     * 
     * @param CntrEtcInfoVO bkgEtcInfoVO
     * @param ContainerVO containerVO
     * @exception EventException
     */
    private void validateContainerComm(CntrEtcInfoVO cntrEtcInfoVO, ContainerVO containerVO) throws EventException {
        /* 
         * 1. Special cntr에 cntr no가 없을 경우 없다는 메세지 [BKG00191] 를 출력한다. 
         * 2. 다른 BKG에서 사용하는 Container인지 확인한다 - partial일 경우는 다른 BKG와 같이 사용 가능하다.
         * 3. PCK_TP_CD가  'CC'패턴이 아닐 경우 메세지[BKG00651]를 출력한다.
         */
    	BookingUtil utilCmd = new BookingUtil();
    	
        try {
            // 스페셜(AWK,BB,DG,RF) 타입에 container no가 assign 되어 있는지 확인한다.
            if("Y".equals(containerVO.getAwkCgoFlg()) || "Y".equals(containerVO.getBbCgoFlg()) || "Y".equals(containerVO.getDcgoFlg()) || "Y".equals(containerVO.getRcFlg())){
                if(!dbDao.checkCntrNoAsgnForSpcl(containerVO)) {
                    throw new EventException(new ErrorHandler("BKG00191").getMessage());
                }
            }
            // 동일한 컨테이너를 다른 BKG에서 사용하는지 체크한다.
            if(!"1".equals(containerVO.getCntrPrtFlg())) {
                String tgtBkgNo = dbDao.searchCntrDup(cntrEtcInfoVO, containerVO.getCntrNo());
                if(!"".equals(tgtBkgNo)){
                    throw new EventException(new ErrorHandler("BKG00966", new String[]{containerVO.getCntrNo(), tgtBkgNo}).getMessage());
                } 
            }
            //PCK_TP_CD가  'CC'패턴인지 체크한다.
			if (containerVO.getPckTpCd() != null && containerVO.getPckTpCd().length() > 0) {
				if (!utilCmd.checkStringFormat("CC", containerVO.getPckTpCd())){
					throw new EventException((String) new ErrorHandler("BKG00651", new String[] {"Package Type Code: "+ containerVO.getPckTpCd()}).getMessage());
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
     * container 정보가 추가가능한 container인지 확인한다.
     * 
     * @param CntrEtcInfoVO bkgEtcInfoVO
     * @param ContainerVO containerVO
     * @return Map<String,String>
     * @exception EventException
     */
    private Map<String,Object> validateContainerAttach(CntrEtcInfoVO cntrEtcInfoVO, ContainerVO containerVO) throws EventException {
        /*
         * 1. Booking status 가 Cancel인 경우 Return 한다. [BKG00113] 메세지를 출력한다.
         * 
         * 2 [위치 일치 여부] 'N'으로 설정
         * 3.해당 CNTR의 ECC와 새로 붙이려는 BKG의 POR의 ECC가 같은 경우
         *   [위치 일치 여부]를 'Y'로 설정
         * 
         * 4.1.[위치 일치 여부 = 'Y'] 인 경우
         * 4.1.1. Movement status가 EN 또는 TN인 경우 직전 BKG의 상태가 ID나 MT인 경우 MT로 [Movement Status 변수] 값을 변경한다.
         * 4.1.2. Cycle이 가장 큰 BKG를 조회함
         * 4.1.3. [Movement Status]가 MT 또는 ID 인 경우
         * 해당 CNTR의 마지막 이벤트가 발생한 BKG의 POR의 ECC와 새로 붙이려는 BKG의 POR의 ECC가 
         * 4.1.3.1 같으면 [VVD 체크]로 변수 설정
         * 4.1.3.2 다르면 [VVD 체크 안함]으로 변수 설정
         * 4.1.4. [VVD 체크]가 필요한 경우
         * 해당 CNTR의 마지막 이벤트가 발생한 BKG의 배가 "HJXX","HJYY","HJZZ"인 경우 
         * 해당 CNTR의 마지막 이벤트가 발생한 BKG에서 해당 Container 삭제
         * 
         * 4.2. [위치 일치 여부 = 'N'] 인 경우
         * 4.2.1. 위 쿼리 조회 결과가 없음 OR (old_bkg_no="PSEUDO00001" AND old_trunk_vvd="PSDO9999W")
         * 4.2.1.1. 위조건에 해당하면 [VVD 체크 안함]으로 변수 설정
         * 4.2.1.2. 위조건에 해당하지 않으면 [VVD 체크]로 변수 설정
         * 
         * 5. [Movement Status]가 MT 또는 ID가 아니고  [위치 일치 여부] = Y 인 경우
         * [VVD 체크]로 변수 설정
         * 
         * 
         * 6. dmg_flg = 'Y' 면 [BKG08047] 에러 메시지 표시 후 리턴
         * 7. aciac_div_cd = 'I' 면 [BKG08052] 에러 메시지 표시 후 리턴
         * 
         * 8. Max Cycle >= Cntr Cycle
         * 8.1 [Movement Status] = "ID" OR "MT"
         * 8.1.1 [위치 일치 여부] = "N" AND Max Cycle = "9999" 면 [BKG08046] 에러 메시지 표시 후 리턴
         * 8.1.1.1 [VVD 체크 = Y] 
         * 8.1.1.1.1 Old와 New 의 Cargo Type이 다르고 VVD는 같을 경우 [BKG08042] 에러 메시지 표시 후 리턴
         * 8.1.1.1.2 Old와 New 의 Cargo Type이 같고 VVD는 다를 경우 [BKG08043] 에러 메시지 표시 후 리턴
         * 8.1.1.1.3 Old와 New 의 Cargo Type과 VVD 둘다 다를 경우 [BKG08044] 에러 메시지 표시 후 리턴
         * 8.1.2 Max Cycle = "9999" AND [VVD 체크 = "Y"]
         * 8.1.2.1 Old와 New 의 Cargo Type이 다르고 VVD는 같을 경우 [BKG08042] 에러 메시지 표시 후 리턴
         * 8.1.2.2 Old와 New 의 Cargo Type이 같고 VVD는 다를 경우 [BKG08043] 에러 메시지 표시 후 리턴
         * 8.1.2.3 Old와 New 의 Cargo Type과 VVD 둘다 다를 경우 [BKG08044] 에러 메시지 표시 후 리턴
         * 8.2 [Movement Status] <> "ID" AND "MT"
         * 8.2.1 Old와 New 의 Cargo Type이 다르고 VVD는 같을 경우 [BKG08042] 에러 메시지 표시 후 리턴
         * 8.2.2 Old와 New 의 Cargo Type이 같고 VVD는 다를 경우 [BKG08043] 에러 메시지 표시 후 리턴
         * 8.2.3 Old와 New 의 Cargo Type과 VVD 둘다 다를 경우 [BKG08044] 에러 메시지 표시 후 리턴
         * 
         * 9. 다른 BKG에서 사용하는 Container인지 확인한다 : partial일 경우는 다른 BKG와 같이 사용 가능하다.
         *     Partial 이 아닌 경우 동일한 Container가 assign된 경우 메시지 [BKG00966] 표시 후 리턴
        */
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
//            // 스페셜(AWK,BB,DG,RF) 타입에 container no가 assign 되어 있는지 확인한다.
//            if(!dbDao.checkCntrNoAsgnForSpcl(containerVO)) {
//                throw new EventException(new ErrorHandler("BKG00191").getMessage());
//            }
            // Master Container 조회
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
            String mstMvntStsCd = cntrMstInfoVO.getCnmvStsCd();
            String currAreaGrpId = dbDao.searchLocByBkgPor(cntrEtcInfoVO.getBkgNo());
            boolean isSameLoc = currAreaGrpId.equals(cntrMstInfoVO.getSysAreaGrpId());
            log.debug("[위치 일치 여부] = " +isSameLoc+ " [BKG=" +currAreaGrpId+ ", CNTR=" +cntrMstInfoVO.getSysAreaGrpId()+ "]");
            boolean vvdCheckFlag = false;
            MaxCycleBkgInfoVO cycleBkgInfoVO = null;

            if(isSameLoc) {
                // Movement Status
                String mvmtSts = dbDao.searchPreMvmtSts(containerVO);
                if(("EN".equals(mstMvntStsCd) || "TN".equals(mstMvntStsCd)) && ("ID".equals(mvmtSts) || "MT".equals(mvmtSts))) {
                    mstMvntStsCd = "MT";
                }
                // Cycle이 가장 큰 BKG를 조회
                cycleBkgInfoVO = dbDao.searchMaxCycleBkgBySameEcc(containerVO.getCntrNo());
                if(cycleBkgInfoVO == null) {
                    throw new EventException(new ErrorHandler("BKG00402", new String[]{containerVO.getCntrNo()}).getMessage());
                }
                if("ID".equals(mstMvntStsCd) || "MT".equals(mstMvntStsCd)) {
                    String maxAreaGrpId = dbDao.searchLocByBkgPor(cycleBkgInfoVO.getBkgNo());
                    if(currAreaGrpId.equals(maxAreaGrpId)) {
                        // VVD 체크
                        vvdCheckFlag = true;
                    }
                } else {
                    // VVD 체크
                    vvdCheckFlag = true;
                }
                
                // VVD 체크 True 일때 조회결과 있을 경우 'XX', 'YY', 'ZZ'에 삭제 실행
                log.error("@@@@@@@@@@ CHECK ATTACH CNTR @@@@@@@@@@:" + containerVO.getBkgNo());
                if(cycleBkgInfoVO != null && cycleBkgInfoVO.getVvd() != null) {
	                if(vvdCheckFlag && (cycleBkgInfoVO.getVvd().startsWith("SMXX") || cycleBkgInfoVO.getVvd().startsWith("SMYY") || cycleBkgInfoVO.getVvd().startsWith("SMZZ"))) {
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
                // Cycle이 가장 큰 BKG를 조회
                cycleBkgInfoVO = dbDao.searchMaxCycleBkgByDiffEcc(containerVO.getCntrNo());
                if(cycleBkgInfoVO == null) {
                    vvdCheckFlag = false;
                } else {
                	if(("PSEUDO00001".equals(cycleBkgInfoVO.getBkgNo()) && "PSDO9999W".equals(cycleBkgInfoVO.getVvd()))){
                		vvdCheckFlag = false;
                	}else{
                		vvdCheckFlag = true;
                	}
                }
            }
            log.debug("[VVD 체크 여부] = " +vvdCheckFlag);
            
            int maxCycleNo = 0;
            String cycleBkgCgoTp = "";
            String cycleBkgVvd = "";
            String cycleBkgNo = "";
            
            if(cycleBkgInfoVO != null) {
                maxCycleNo = (cycleBkgInfoVO.getCnmvCycNo() == null || cycleBkgInfoVO.getCnmvCycNo().equals("")) ? 0 : Integer.parseInt(cycleBkgInfoVO.getCnmvCycNo());
                cycleBkgCgoTp = (cycleBkgInfoVO.getBkgCgoTpCd() == null || cycleBkgInfoVO.getBkgCgoTpCd().equals("")) ? "" : cycleBkgInfoVO.getBkgCgoTpCd();
                cycleBkgVvd = (cycleBkgInfoVO.getVvd() == null || cycleBkgInfoVO.getVvd().equals("")) ? "" : cycleBkgInfoVO.getVvd();
                cycleBkgNo = (cycleBkgInfoVO.getBkgNo() == null || cycleBkgInfoVO.getBkgNo().equals("")) ? "" : cycleBkgInfoVO.getBkgNo();
            }

            int mstCycleNo = (cntrMstInfoVO.getCnmvCycNo() == null || cntrMstInfoVO.getCnmvCycNo().equals("")) ? 0 : Integer.parseInt(cntrMstInfoVO.getCnmvCycNo());

            
            log.debug("[MAX Cycle] = " +(maxCycleNo >= mstCycleNo) + " [maxCycleNo=" +maxCycleNo+", mstCycleNo=" +mstCycleNo+ "]");
            if(maxCycleNo >= mstCycleNo){
                if("ID".equals(mstMvntStsCd) || "MT".equals(mstMvntStsCd)){
                    log.debug("8.1 [Movement Status] != 'ID' or 'MT' : mstMvntStsCd=" + mstMvntStsCd);
                    if(!isSameLoc){
                        log.debug("8.1.1 [Movement Status] != 'ID' or 'MT' : isSameEcc=" + isSameLoc);
                        if (maxCycleNo == 9999) {
                            log.debug("8.1.1.1 [Movement Status] != 'ID' or 'MT' : maxCycleNo=" + maxCycleNo);
                            throw new EventException(new ErrorHandler("BKG08046", new String[]{containerVO.getCntrNo(), cycleBkgNo}).getMessage());
                        } else {
                            log.error("8.1.1.2 [Movement Status] != 'ID' or 'MT' : maxCycleNo=" + maxCycleNo);
                            if (vvdCheckFlag) {
                                log.debug("8.1.1.2.1 [Movement Status] != 'ID' or 'MT' : vvdCheckFlag=" + vvdCheckFlag);
                                
                                boolean cgoErr = cycleBkgCgoTp.equals(cntrEtcInfoVO.getBkgCgoTpCd());
                                boolean vvdErr = cycleBkgVvd.equals(cntrEtcInfoVO.getTVvd());
                                log.debug("=========================> cgoErr=" + cgoErr + ", vvdErr=" + vvdErr);
                                if (!cgoErr && vvdErr)      {
                                    throw new EventException(new ErrorHandler("BKG08042", new String[]{containerVO.getCntrNo(), cycleBkgNo, cycleBkgCgoTp}).getMessage());
                                } else if (cgoErr && !vvdErr) {
                                    throw new EventException(new ErrorHandler("BKG08043", new String[]{containerVO.getCntrNo(), cycleBkgNo, cycleBkgVvd}).getMessage());
                                } else if (!cgoErr && !vvdErr) {
                                    throw new EventException(new ErrorHandler("BKG08044", new String[]{containerVO.getCntrNo(), cycleBkgNo, cycleBkgVvd, cycleBkgCgoTp}).getMessage());
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
                            throw new EventException(new ErrorHandler("BKG08042", new String[]{containerVO.getCntrNo(), cycleBkgNo, cycleBkgCgoTp}).getMessage());
                        } else if (cgoErr && !vvdErr) {
                            throw new EventException(new ErrorHandler("BKG08043", new String[]{containerVO.getCntrNo(), cycleBkgNo, cycleBkgVvd}).getMessage());
                        } else if (!cgoErr && !vvdErr) {
                            throw new EventException(new ErrorHandler("BKG08044", new String[]{containerVO.getCntrNo(), cycleBkgNo, cycleBkgVvd, cycleBkgCgoTp}).getMessage());
                        }
                    }       
                    
                }else{	
                	if (vvdCheckFlag) {
	                    log.debug("8.2 [Movement Status] != 'ID' or 'MT' : mstMvntStsCd=" + mstMvntStsCd);                    
	                    boolean cgoErr = cycleBkgCgoTp.equals(cntrEtcInfoVO.getBkgCgoTpCd());
	                    boolean vvdErr = cycleBkgVvd.equals(cntrEtcInfoVO.getTVvd());
	                    log.debug("=========================> cgoErr=" + cgoErr + ", vvdErr=" + vvdErr);
	                    if (!cgoErr && vvdErr)      {
	                        throw new EventException(new ErrorHandler("BKG08042", new String[]{containerVO.getCntrNo(), cycleBkgNo, cycleBkgCgoTp}).getMessage());
	                    } else if (cgoErr && !vvdErr) {
	                        throw new EventException(new ErrorHandler("BKG08043", new String[]{containerVO.getCntrNo(), cycleBkgNo, cycleBkgVvd}).getMessage());
	                    } else if (!cgoErr && !vvdErr) {
	                        throw new EventException(new ErrorHandler("BKG08044", new String[]{containerVO.getCntrNo(), cycleBkgNo, cycleBkgVvd, cycleBkgCgoTp}).getMessage());
	                    }
                	}
                }
            }
            // 동일한 컨테이너를 다른 BKG에서 사용하는지 체크한다.
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
     * container 정보가 삭제가능한 container인지 확인한다.
     * 
     * @param CntrEtcInfoVO bkgEtcInfoVO
     * @param ContainerVO containerVO
     * @exception EventException
     */
    private void validateContainerDetach(CntrEtcInfoVO cntrEtcInfoVO, ContainerVO containerVO) throws EventException {
        /*
         * TODO
         * 
         * 1. Booking status 가 Cancel인 경우 Return 한다. [BKG00113] 메세지를 출력한다.
         * 2. VL 상태일 때 동일한 컨테이너를 다른 BKG에서 사용하는지 체크한다.
         *     다른 BKG에서 사용하지 않을 경우 삭제 불가능
         * 3. SO 여부 체크하여 S/O가 발생되었을 경우 처리불가하다.
         * 
         * 4. Master에서 Conatiner 정보 조회
         * 
         * 5. [위치 일치 여부] 'N'으로 설정
         * 
         * 6.해당 CNTR의 ECC와 새로 붙이려는 BKG의 POR의 ECC가 같은 경우
         *   [위치 일치 여부]를 'Y'로 설정
         * 
         * 7.[위치 일치 여부 = 'Y'] 인 경우
         * 7.1. Cycle이 가장 큰 BKG를 조회함
         * 
         * 7.2. 위 쿼리 조회 결과가 없음 OR (old_bkg_no="PSEUDO00001" AND old_trunk_vvd="PSDO9999W")
         * 7.2.1. 위조건에 해당하면 [VVD 체크 안함]으로 변수 설정
         * 7.2.2. 위조건에 해당하지 않으면 [VVD 체크]로 변수 설정
         * 
         * 8.[위치 일치 여부 = 'N'] 인 경우
         * 8.1 위치가 다른 경우 Max Cycle의 BKG 조회 실행
         * 8.2. 위 쿼리 조회 결과가 없음 OR (old_bkg_no="PSEUDO00001" AND old_trunk_vvd="PSDO9999W")
         * 8.2.1. 위조건에 해당하면 [VVD 체크 안함]으로 변수 설정
         * 8.2.2. 위조건에 해당하지 않으면 [VVD 체크]로 변수 설정
         * 
         * 9. [Movement Status = "VL"] AND [VVD 체크] AND [OLD_VVD와 NEW_VVD 가 같은 경우]
         *   [BKG08053] 메시지 표시 후 리턴
         */
        try {
            BookingUtil utilCmd = new BookingUtil();
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(cntrEtcInfoVO.getBkgNo());
            // bkgBlNoVO.setBkgNoSplit(containerVO.getBkgNoSplit());
            // booking status
            String bkg_sts_cd = utilCmd.searchBkgStatusByBkg(bkgBlNoVO);
            String cntrNo = "";
            
            // OLD가 없을 경우 cntr_no를 old로 처리함
            if(containerVO.getCntrNoOld() == null || "".equals(containerVO.getCntrNoOld())) {
            	cntrNo = containerVO.getCntrNo();
            } else {
            	cntrNo = containerVO.getCntrNoOld();
            }
            if(bkg_sts_cd != null && bkg_sts_cd.equals(Constants.BKG_STATUS_CANCEL)) {
                throw new EventException(new ErrorHandler("BKG00113").getMessage());
            }
            // 해당 BKG에 발행된 S/O가 있는지 확인한다
            String bkg_so_sts = utilCmd.searchSoStatus(null, cntrNo, bkgBlNoVO, null);
            if("Y".equals(bkg_so_sts)) {
                throw new EventException(new ErrorHandler("BKG00094").getMessage());
            }            
            // 동일한 컨테이너를 다른 BKG에서 사용하는지 체크한다.
            if(!"1".equals(containerVO.getCntrPrtFlg()) && "VL".equals(containerVO.getCnmvStsCd())) {
                String tgtBkgNo = dbDao.searchCntrDup(cntrEtcInfoVO, cntrNo);
                if("".equals(tgtBkgNo) || tgtBkgNo == null){
//                    throw new EventException(new ErrorHandler("BKG00966", new String[]{containerVO.getCntrNoOld(), tgtBkgNo}).getMessage());

		            // Master Container 조회
		            CntrMstInfoVO cntrMstInfoVO = dbDao.searchMstContainer(cntrNo);
		            if(cntrMstInfoVO == null) {
		                throw new EventException(new ErrorHandler("BKG00402", new String[]{cntrNo}).getMessage());                
		            }
		            // 
		            String mstMvntStsCd = cntrMstInfoVO.getCnmvStsCd();
		            String currAreaGrpId = dbDao.searchLocByBkgPor(cntrEtcInfoVO.getBkgNo());
		            boolean isSameLoc = currAreaGrpId.equals(cntrMstInfoVO.getSysAreaGrpId());
		            boolean vvdCheckFlag = false;
		            MaxCycleBkgInfoVO cycleBkgInfoVO = null;
//		            log.debug("@@@@@@@@ isSameLoc:"+isSameLoc + " @@@@@@@@ mstMvntStsCd:"+mstMvntStsCd);
		            if(isSameLoc) {
		                // Cycle이 가장 큰 BKG를 조회
		                cycleBkgInfoVO = dbDao.searchMaxCycleBkgBySameEcc(cntrNo);
		                if(cycleBkgInfoVO == null) {
		                    vvdCheckFlag = false;
		                } else if(cycleBkgInfoVO != null && "PSEUDO00001".equals(cycleBkgInfoVO.getBkgNo()) && "PSDO9999W".equals(cycleBkgInfoVO.getVvd())){
		                	vvdCheckFlag = false;
		                }else{
		                    vvdCheckFlag = true;
		                }
		            } else {
		                // Cycle이 가장 큰 BKG를 조회
		                cycleBkgInfoVO = dbDao.searchMaxCycleBkgByDiffEcc(cntrNo);
		                if(cycleBkgInfoVO == null) {
		                    vvdCheckFlag = false;
		                }else if(cycleBkgInfoVO != null && "PSEUDO00001".equals(cycleBkgInfoVO.getBkgNo()) && "PSDO9999W".equals(cycleBkgInfoVO.getVvd())){
		                	vvdCheckFlag = false;
		                }else {
		                    vvdCheckFlag = true;
		                }  
		            }
		            //
//		            log.debug("@@@@@@@@ vvdCheckFlag:"+vvdCheckFlag + " @@@@@@@@ mstMvntStsCd:"+mstMvntStsCd);
		            if("VL".equals(mstMvntStsCd) && vvdCheckFlag){
//		            log.debug("@@@@@@@@ vvd cycle:"+cycleBkgInfoVO.getVvd() + " @@@@@@@@ vvd etc:"+cntrEtcInfoVO.getTVvd());	
		            	if(cycleBkgInfoVO != null){
			            	if(cntrEtcInfoVO.getTVvd().equals(cycleBkgInfoVO.getVvd())){
			                    throw new EventException(new ErrorHandler("BKG08053", new String[]{cntrNo}).getMessage());
			                    
			                }
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
     * Container의 Vol 및 Partial Flag를 업데이트 한다.. UI_BKG-0170
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
            /*
             * 하나의 Container가 Release됨에 따라.. 
             * 그 Container를 포함하는 Booking의 모든 Container의 상태를 Release 한다.
             */
            dbDao.modifyCntrCfmFlgByBkg(bkgNo, "N", cntrCopyVO.getCaFlg());
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * container manifest 정보를 조회한다.-- UI_BKG-0079-07
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
     * container manifest 정보를 저장가능한지 확인한다.
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
            StringBuffer hsCd = new StringBuffer(); 
            for(int i = 0; i < len; i++) {        	
           	
            	if(!"D".equals(vo3.get(i).getIbflag())) {
	                // 1. BookingUtil::validatePkgType ( pkgTpCd )
	                log.debug(" * PckTpCd : " + vo3.get(i).getPckTpCd());
	                log.debug(" * cntrNo : " + vo3.get(i).getCntrNo());
	                // 연속으로 중복된 package code 다시 확인하지 않음(일반적으로 동일한 package code 사용)
	                if(i>0 && !vo3.get(i).getPckTpCd().equals(vo3.get(i-1).getPckTpCd())){
		                boolean flag = utilCmd.validatePkgType(vo3.get(i).getPckTpCd());
		                if(!flag) {
		                	throw new EventException(new ErrorHandler("BKG08221", new String[]{vo3.get(i).getPckTpCd()}).getMessage());
		                }
	            	}
	                // 2. BookingUtil::searchHtsCodeDesc ( htsCd )
	                log.debug(" * HamoTrfCd : " + vo3.get(i).getHamoTrfCd());
	                if(vo3.get(i).getHamoTrfCd() != null && vo3.get(i).getHamoTrfCd().length() > 0) {
	                    String extFlag = utilCmd.checkHtsCodeByCm("T", vo3.get(i).getHamoTrfCd());
	                    if("N".equals(extFlag)) {
	                    	String msg = "\n'"+vo3.get(i).getHamoTrfCd()+"' for container " + vo3.get(i).getCntrNo();
	                        throw new EventException(new ErrorHandler("BKG01050", new String[]{"HTS",msg}).getMessage());
	                    }
	                }
	                // 3. BookingUtil::searchHtsCodeDesc ( hsCd )
	                log.debug(" * CmdtCd : " + vo3.get(i).getCmdtHsCd());
	                if(vo3.get(i).getCmdtHsCd() != null && vo3.get(i).getCmdtHsCd().length() > 0) {
	                	if("IR".equals(vo1.getPodCd().substring(0, 2))){
	                		if(vo3.get(i).getCmdtHsCd().length() != 8){
	                			throw new EventException(new ErrorHandler("BKG95095", new String[]{}).getMessage());
	                		}
	                	}else{
		                    String extFlag = utilCmd.checkHtsCodeByCm("H", vo3.get(i).getCmdtHsCd());
		                    
		                    if("N".equals(extFlag)) {
		                    	hsCd.append("[" + vo3.get(i).getCmdtHsCd() + "]:");
		                    	//throw new EventException(new ErrorHandler("BKG01050", new String[]{"HS"}).getMessage());
		                    }   	
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
	                
	                if("I".equals(vo3.get(i).getIbflag()) || "U".equals(vo3.get(i).getIbflag())){
	                	if(null!=vo3.get(i).getPckTpCd() && "" != vo3.get(i).getPckTpCd()){
		            		boolean flag = utilCmd.validatePkgType(vo3.get(i).getPckTpCd());
		            		if(!flag){ 
		            			throw new EventException(new ErrorHandler("BKG08221", new String[]{vo3.get(i).getPckTpCd()}).getMessage());
		            		}
		            	}
		            }
            	}            	
            }

            if(hsCd.toString() != null && hsCd.toString().length() > 0) {  // [CHM-201322322]
            	String[] hsCdArr = hsCd.toString().split(":");
            	StringBuffer hsCdOutMsg = new StringBuffer();
            	
            	for(int i=0; i<hsCdArr.length; i++){
            		hsCdOutMsg.append(hsCdArr[i]);
            		if(i==3 && hsCdArr.length > 4){
            			hsCdOutMsg.append("[....,]");
            			break;
            		}
            	}
                throw new EventException(new ErrorHandler("BKG95060",new String[]{"HS",hsCdOutMsg.toString()}).getMessage());                
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
     * container manifest 정보를 생성한다. -- UI_BKG-0079-07, UI_BKG-0178, BKG CONTAINER MANIFEST DESCRIPTION
     * @param CmVO cmVO
     * @param SignOnUserAccount account
     * @param String caFlg 
     * @exception EventException
     */
    public void manageCm(CmVO cmVO, SignOnUserAccount account, String caFlg) throws EventException {

//    	BrcsManifestDownloadBCImpl brcsMft = new BrcsManifestDownloadBCImpl();
        CmBkgInfoVO vo1 = cmVO.getCmBkgInfoVO();
        List<CmCntrInfoVO> vo2 = cmVO.getCmCntrInfoVOs();
        List<BkgCntrMfDescVO> vo3 = cmVO.getBkgCntrMfDescVOs();
        
//        List<BrCnpiNcmByCntrModiVO> addBrNcmListVO = new ArrayList<BrCnpiNcmByCntrModiVO>();
//        List<BrCnpiNcmByCntrModiVO> removeBrNcmListVO = new ArrayList<BrCnpiNcmByCntrModiVO>();
        String[] ncmNoArr = null;
        
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
                        dbDao.removeBrCm(vo3.get(i), caFlg); // 브라질 세관신고시 사용되는 품목코드 삭제
                        
//                        if( !"Y".equals(caFlg) ){
//	                        BrCnpiNcmByCntrModiVO inputNcmDtlVO = new BrCnpiNcmByCntrModiVO();
//	                        inputNcmDtlVO.setBlNo(vo1.getBlNo());
//							inputNcmDtlVO.setCntrNo(vo3.get(i).getCntrNo());
//							inputNcmDtlVO.setCntrMfSeq(vo3.get(i).getCntrMfSeq());
//							
//							removeBrNcmListVO.add(inputNcmDtlVO);
//                        }
                    }
                    
                    if(vo3.get(i).getIbflag().equals("I")) {
                        dbDao.addCm(vo3.get(i), caFlg);
                        String cntrMfSeq = dbDao.searchCntrMfSeq(vo3.get(i), caFlg);
                        
//                        if( !"Y".equals(caFlg) ){
//	                        if( !vo3.get(i).getNcmMultiNo().equals("") ){
//	        					ncmNoArr = vo3.get(i).getNcmMultiNo().split(",");
//	        					for( int jdx = 0; jdx < ncmNoArr.length; jdx++ ){
//	        						BrCnpiNcmByCntrModiVO inputNcmDtlVO = new BrCnpiNcmByCntrModiVO();
//	                                inputNcmDtlVO.setBlNo(vo1.getBlNo());
//	        						inputNcmDtlVO.setCntrNo(vo3.get(i).getCntrNo());
//	        						inputNcmDtlVO.setCntrMfSeq(cntrMfSeq);
//	        						inputNcmDtlVO.setMfDtlSeq(Integer.toString(jdx+1));
//	        						inputNcmDtlVO.setNcmNo(ncmNoArr[jdx]);
//	        						inputNcmDtlVO.setUpdUsrId(vo3.get(i).getUpdUsrId());
//	        						
//	        						addBrNcmListVO.add(inputNcmDtlVO);
//	        					}
//	                        }
//                        }
                        
                        if( !vo3.get(i).getNcmMultiNo().equals("") ){
        					ncmNoArr = vo3.get(i).getNcmMultiNo().split(",");
        					for( int jdx = 0; jdx < ncmNoArr.length; jdx++ ){
        						BkgCntrMfDescDtlVO cntrMfDescDtlVO = new BkgCntrMfDescDtlVO();
        						cntrMfDescDtlVO.setBkgNo(vo1.getBkgNo());
        						cntrMfDescDtlVO.setCntrNo(vo3.get(i).getCntrNo());
        						cntrMfDescDtlVO.setCntrMfSeq(cntrMfSeq);
        						cntrMfDescDtlVO.setMfDtlSeq(Integer.toString(jdx+1));
        						cntrMfDescDtlVO.setNcmNo(ncmNoArr[jdx]);
        						cntrMfDescDtlVO.setCreUsrId(vo3.get(i).getCreUsrId());
        						
        						dbDao.addCmDtl(cntrMfDescDtlVO, caFlg);
        					}
                        }
                    }
                    
                    if(vo3.get(i).getIbflag().equals("U")) {
                    	dbDao.modifyCm(vo3.get(i), caFlg);
                        
//                        if( !"Y".equals(caFlg) ){
//	                        if( !vo3.get(i).getNcmMultiNo().equals("") ){
//	        					ncmNoArr = vo3.get(i).getNcmMultiNo().split(",");
//	        					for( int jdx = 0; jdx < ncmNoArr.length; jdx++ ){
//	        						BrCnpiNcmByCntrModiVO inputNcmDtlVO = new BrCnpiNcmByCntrModiVO();
//	                                inputNcmDtlVO.setBlNo(vo1.getBlNo());
//	        						inputNcmDtlVO.setCntrNo(vo3.get(i).getCntrNo());
//	        						inputNcmDtlVO.setCntrMfSeq(vo3.get(i).getCntrMfSeq());
//	        						inputNcmDtlVO.setMfDtlSeq(Integer.toString(jdx+1));
//	        						inputNcmDtlVO.setNcmNo(ncmNoArr[jdx]);
//	        						inputNcmDtlVO.setUpdUsrId(vo3.get(i).getUpdUsrId());
//	        						
//	        						removeBrNcmListVO.add(inputNcmDtlVO);
//	        						addBrNcmListVO.add(inputNcmDtlVO);
//	        					}
//	                        }
//                        }
                        
                        if( !vo3.get(i).getNcmMultiNo().equals("") ){
                        	dbDao.removeBrCm(vo3.get(i), caFlg); // 브라질 세관신고시 사용되는 품목코드 삭제
        					ncmNoArr = vo3.get(i).getNcmMultiNo().split(",");
        					for( int jdx = 0; jdx < ncmNoArr.length; jdx++ ){
        						vo3.get(i).setNcmNo(ncmNoArr[jdx]);
        						BkgCntrMfDescDtlVO cntrMfDescDtlVO = new BkgCntrMfDescDtlVO();
        						cntrMfDescDtlVO.setBkgNo(vo1.getBkgNo());
        						cntrMfDescDtlVO.setCntrNo(vo3.get(i).getCntrNo());
        						cntrMfDescDtlVO.setCntrMfSeq(vo3.get(i).getCntrMfSeq());
        						cntrMfDescDtlVO.setMfDtlSeq(Integer.toString(jdx+1));
        						cntrMfDescDtlVO.setNcmNo(ncmNoArr[jdx]);
        						cntrMfDescDtlVO.setCreUsrId(vo3.get(i).getCreUsrId());
        						
        						dbDao.addCmDtl(cntrMfDescDtlVO, caFlg);
        					}
                        }
                    }
                }
                
//                if( removeBrNcmListVO.size() > 0 ){
//                	brcsMft.manageBrzCntrMfNCMList(removeBrNcmListVO, "D");
//                }
//                
//                if( addBrNcmListVO.size() > 0 ){
//                	brcsMft.manageBrzCntrMfNCMList(addBrNcmListVO, "C");
//                }
                
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
     *  Container의 Term을 Bkg에 맞춰서 변경한다..(ESM_BKG_0079_01) -> modifyBooking<br>
     * @author  KimByungKyu
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
     * Container Seal No 정보를 업데이트 한다.
     * 
     * @param List<BkgCntrSealNoVO> updateSealVoList
     * @param String caFlg
     * @exception EventException
     */
    public void manageCntrSealNo(List<BkgCntrSealNoVO> updateSealVoList, String caFlg) throws EventException {
        try {
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
     * Container Seal No.를 삭제한다. -- UI_BKG-0170, UI_BKG-0079-04
     * 
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
     * ContainerSeal No.를 삭제한다. -- UI_BKG-0170, UI_BKG-0079-04
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
     * Container Manifest Desc. 를 삭제한다. -- UI_BKG-0170, UI_BKG-0079-04
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String caFlg
     * @exception EventException
     */
    public void removeCntrMfDesc(String bkgNo, String cntrNo, String caFlg) throws EventException {
    	
        try {
        	BLDocumentationBLBC blDoc = new BLDocumentationBLBCImpl();	
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(bkgNo);
			bkgBlNoVO.setCaFlg(caFlg);
        	String oldDesc = dbDao.searchWpmDescForBl(bkgBlNoVO, "N");
        	
        	dbDao.removeCmDtlByCntr (bkgNo, cntrNo, caFlg); 
            dbDao.removeCmByCntr(bkgNo, cntrNo, caFlg);
            
            //wpm관련 자동문구 저장
            blDoc.modifyBlDescByWpm(bkgBlNoVO, oldDesc, "SYSTEM");
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Container Manifest Desc. 를 변경한다.
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
     * Container Manifest Desc. 를 변경한다.
     * @param String bkgNo
     * @param String cntrNo
     * @param String cntrNoOld
     * @param String caFlg 
     * @exception EventException
     */
    public void changeCntrSealNo(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException {
        try {
            dbDao.changeCntrSealNo(bkgNo, cntrNo, cntrNoOld, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Container를 추가한다.
     * @param ContainerVO containerVO
     * @param String caFlg 
     * @exception EventException
     */
    public void insertContainer(ContainerVO containerVO, String caFlg) throws EventException {
    	BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
    	BookingUtil bookingUtil = new BookingUtil();
        try {
            dbDao.insertContainer(containerVO, caFlg);
            if("Y".equals(bookingUtil.searchEffDtDiv(containerVO.getBkgNo(),"EQ_ID","BKG"))){
        		//EQ ID를 위한 History생성
        		BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
        		docProcSkdVO.setBkgDocProcTpCd("CNTATC");
        		docProcSkdVO.setBkgNo(containerVO.getBkgNo());
        		docProcSkdVO.setDiffRmk(containerVO.getCntrNo());
        		docProcSkdVO.setOldDiffRmk(containerVO.getCntrNoOld());
        		docProcSkdVO.setCaFlg(caFlg);
        		docProcSkdVO.setPairFlg("N");
    			SignOnUserAccount account = new SignOnUserAccount();
    			account = new SignOnUserAccount(containerVO.getCreUsrId() ,"" ,"" ,"" ,""
    											,"" ,"" ,"" ,"" ,""
    											,"" ,"" ,"" ,"" ,""
    											,"" ,"" ,"" ,"", "", "" ,""
    											);
        		histCmd.modifyBkgDocProcSkdForCntatc(docProcSkdVO, account);
            }

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * container 정보를 수정한다.
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
     * container confirm 정보를 수정한다.
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
     * Container를 삭제한다
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

//    /**
//     * act_wgt와 wgt_ut_cd를 update한다.(ESM_BKG_0079_01) -> modifyBooking<br>
//     * 
//     * @author      KimByungKyu
//     * @param       BkgBlNoVO bkgBlNoVO
//     * @param       String actWgt
//     * @param       String wgtUtCd
//     * @param       String oldPodNodCd
//     * @param       String oldDelNodCd
//     * @param       SignOnUserAccount account
//     * @exception   EventException
//     */
//    public void modifyBlActWgt(BkgBlNoVO bkgBlNoVO, String actWgt, String wgtUtCd, String oldPodNodCd, String oldDelNodCd, SignOnUserAccount account)
//            throws EventException {
//        try {
//            dbDao.modifyBlActWgt(bkgBlNoVO, actWgt, wgtUtCd, oldPodNodCd, oldDelNodCd, account);
//        } catch(DAOException ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        } catch(Exception ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        }
//    }
    
    /**
     * act_wgt와 wgt_ut_cd를 update한다.(ESM_BKG_0079_01) -> modifyBooking<br>
     * 
     * @author      KimByungKyu
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       BkgBlActWgtVO bkgBlActWgtVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void modifyBlActWgt(BkgBlNoVO bkgBlNoVO, BkgBlActWgtVO bkgBlActWgtVO, SignOnUserAccount account)
            throws EventException {
        try {
            dbDao.modifyBlActWgt(bkgBlNoVO, bkgBlActWgtVO, account);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     *  Container를 Cancel한다.(ESM_BKG_0079_01) -> modifyBooking<br>
     *  
     * @author      KimByungKyu
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
     *  Container를 Activate한다.(ESM_BKG_0000_1) -> reactivateBooking<br>
     *  
     * @author      Jeon Sung Jin
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
    
    /**
     * combine/split시에 sourceBkg에서 bkg_cntr, bkg_cntr_seal_no를 읽어서 targetBkg에 insert한다.<br>
     * 
     * @param String copyModeCd
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectCntrVO> selectCntrVO
     * @param SignOnUserAccount account
     * @param String hitchmentYn
     * @exception EventException
     */
//    public void copyCntrCmByBkg(String copyModeCd, BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg,
//            List<SelectCntrVO> selectCntrVO, SignOnUserAccount account, String hitchmentYn) throws EventException {
//        try {
//            BookingUtil utilBC = new BookingUtil();
//            if(copyModeCd.equals("M")) { // Combine일때
//                // Split과 같이 메소드를 사용하므로 Combine시에는 targetBkg가 sourceBkg이고
//                // sourceBkg가 targetbkg의 역할을 함.
//                
//                // targetBkg : master Booking
//                // sourceBkg : cntr를 넘겨주고 cancel 되는 bkg
//            	BkgBlNoVO mstBkg = null;
//            	BkgBlNoVO combineBkg = null;
//                for(int i = 0; i < targetBkg.length; i++) {
//                	mstBkg = sourceBkg;
//                	combineBkg = targetBkg[i];
//                	log.debug("mstBkg:"+mstBkg.getBkgNo()+ ", combineBkg:"+combineBkg.getBkgNo());
//                	
//                    String[] cntrNo = utilBC.searchCntrListByBkg(targetBkg[i]);
//                    for (int j=0;j<cntrNo.length;j++) {
//                        SelectCntrVO tmpCntrVO = new SelectCntrVO();
//                        tmpCntrVO.setCntr_no(cntrNo[j]);
//                        
//                        if ( dbDao.modifyBkgCntrPkcMeasWgt(cntrNo[j], mstBkg, combineBkg, account) == 0 ) {
//                            // sourceBkg의 bkg_container를 targetBkg으로 복사한다
//                            dbDao.copyBkgCntrByBkg(mstBkg, combineBkg, tmpCntrVO, account);
//                        }
//
//                        // sourceBkg에서 bkg_cntr_mf를 읽어서 targetBkg에 insert한다
//                        dbDao.copyCmByBkg(mstBkg, combineBkg, copyModeCd, tmpCntrVO, account);
//                        // sourceBkg에서 bkg_cntr_seal_no를 읽어서 targetBkg에 insert한다
//                        dbDao.copyBkgCntrSealByBKG(mstBkg, combineBkg, tmpCntrVO, account);
//                    }
//
//                    if ("Y".equals(hitchmentYn) ) {
//                        // hitchment일 경우 이전의 por, pol을 update한다.
//                        dbDao.modifyCntrPorPol(mstBkg, combineBkg, account);
//                    }
//                    
//                    //cancel 된 booking의 container에 delete mark update
//                    dbDao.cancelBkgCntr(combineBkg, account);
//                }
//            } else if(copyModeCd.equals("S")) { // Split일때
//                // split 전에 있던 cntr list
//                String[] cntrNo = utilBC.searchCntrListByBkg(sourceBkg);
//                //여러 bkg에 assign된 container를 확인
//                int [] partialCount = new int [cntrNo.length] ;
//                for(int i = 0; i < cntrNo.length; i++){
//                    for(int j = 0; j < selectCntrVO.size(); j++){
//                        if(cntrNo[i].equals(selectCntrVO.get(j).getCntr_no()) 
//                            && selectCntrVO.get(j).getSplitNo().length() > 0){
//                            partialCount[i]++;
//                        }
//                    }
//                }
//                
//                //new bkg으로 cntr을 복사
//                for(int i = 0; i < targetBkg.length; i++) {
//                    if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
//                        for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
//                            // sourceBkg의 bkg_container를 targetBkg으로 복사한다
//                        	log.debug("sourceBkg:"+sourceBkg.getBkgNo()+",targetBkg:"+targetBkg[i].getBkgNo());
//                            if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg[i].getBkgNo())
//                                && selectCntrVO.get(icnt).getSplitNo().length()>1){
//                                dbDao.copyBkgCntrByBkg(targetBkg[i], sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt), account);
//                                // sourceBkg에서 bkg_cntr_mf를 읽어서 targetBkg에 insert한다
//                                dbDao.copyCmByBkg(targetBkg[i], sourceBkg, copyModeCd, (SelectCntrVO) selectCntrVO.get(icnt), account);
//                                // sourceBkg의 bkg_cntr_seal_no를 targetBkg으로 복사한다
//                                dbDao.copyBkgCntrSealByBKG(targetBkg[i], sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt),account);
//                            }
//                        }
//                    }
//                }
//                for(int i=0; i<cntrNo.length;i++){
//                	//partial cntr일 경우
//                	if(partialCount[i]>1){
//                        for(int j=0;j<targetBkg.length;j++) {
//                        	for(int k=0;k<selectCntrVO.size();k++){
//                        		if(selectCntrVO.get(k).getCntr_no().equals(cntrNo[i])
//                        			&& selectCntrVO.get(k).getBkg_no().equals(targetBkg[j].getBkgNo())	
//                                    && selectCntrVO.get(k).getSplitNo().length()>1){
//                                    	log.debug("cntrNo:" +cntrNo[i]+" bkg_no:"+targetBkg[j].getBkgNo() + " select bkg : " + selectCntrVO.get(k).getBkg_no() + " select cntr2 :"+ selectCntrVO.get(k).getCntr_no());
//                        			dbDao.modifyBkgCntrPartialFlg(targetBkg[targetBkg.length - 1], targetBkg[j], cntrNo[i], partialCount[i], account);
//                        		}
//                        	}
//                        }
//                		
//                	}
//                }
//                
//                //원본BkgNo에 대해 Cntr체크 해제시 처리
//                for(int i = 0; i < targetBkg.length; i++) {
//                    if(sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
//                    for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
//                        if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg[i].getBkgNo())
//                          && selectCntrVO.get(icnt).getSplitNo().length()<1){
//                            // 전달받은 cntr No로 bkg_cntr_seal_no 에서 삭제한다
//                            dbDao.removeCntrSealNoAfterSplit(sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt));
//                            // BKG CONTAINER MANIFEST DESCRIPTION 정보를 삭제한다.
//                            dbDao.removeCmByCntr(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
//                            // BKG CONTAINER 테이블에서 Delete Flag를 'Y'로 변경
//                            dbDao.removeContainer(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
//                        }
//                      }
//                   }
//                }                
//            }
//        } catch (DAOException ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        } catch (Exception ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        }
//    }
    
    /**
     * combine/split시에 sourceBkg에서 bkg_cntr, bkg_cntr_seal_no를 읽어서 targetBkg에 insert한다.<br>
     * 
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectCntrVO> selectCntrVO
     * @param BkgCopyCntrCmByBkgVO bkgCopyCntrCmByBkgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyCntrCmByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg,
            List<SelectCntrVO> selectCntrVO, BkgCopyCntrCmByBkgVO bkgCopyCntrCmByBkgVO, SignOnUserAccount account ) throws EventException {
        try {
            BookingUtil utilBC = new BookingUtil();
            BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
            BLDocumentationBLBC blDoc = new BLDocumentationBLBCImpl();	
            if(bkgCopyCntrCmByBkgVO.getCopyModeCd().equals("M")) { // Combine일때
                // Split과 같이 메소드를 사용하므로 Combine시에는 targetBkg가 sourceBkg이고
                // sourceBkg가 targetbkg의 역할을 함.
                
                // targetBkg : master Booking
                // sourceBkg : cntr를 넘겨주고 cancel 되는 bkg
            	BkgBlNoVO mstBkg = null;
            	BkgBlNoVO combineBkg = null;
            	
            	String oldDesc = dbDao.searchWpmDescForBl(sourceBkg, "N");
                for(int i = 0; i < targetBkg.length; i++) {
                	mstBkg = sourceBkg;
                	combineBkg = targetBkg[i];
                	log.debug("mstBkg:"+mstBkg.getBkgNo()+ ", combineBkg:"+combineBkg.getBkgNo());
                	
                    String[] cntrNo = utilBC.searchCntrListByBkg(targetBkg[i]);
                    for (int j=0;j<cntrNo.length;j++) {
                        SelectCntrVO tmpCntrVO = new SelectCntrVO();
                        tmpCntrVO.setCntr_no(cntrNo[j]);
                        
                        if ( dbDao.modifyBkgCntrPkcMeasWgt(cntrNo[j], mstBkg, combineBkg, account) == 0 ) {
                            // sourceBkg의 bkg_container를 targetBkg으로 복사한다
                            dbDao.copyBkgCntrByBkg(mstBkg, combineBkg, tmpCntrVO, account);
                            
                            if("Y".equals(utilBC.searchEffDtDiv(mstBkg.getBkgNo(),"EQ_ID","BKG"))){
                        		//EQ ID를 위한 History생성
                        		BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
                        		docProcSkdVO.setBkgDocProcTpCd("CNTATC");
                        		docProcSkdVO.setBkgNo(mstBkg.getBkgNo());
                        		docProcSkdVO.setDiffRmk(tmpCntrVO.getCntr_no());
                        		docProcSkdVO.setPairFlg("N");
                        		histCmd.manageDocProcess(docProcSkdVO, account);
                            }

                        }

                        // sourceBkg에서 bkg_cntr_mf를 읽어서 targetBkg에 insert한다
                        dbDao.copyCmByBkg(mstBkg, combineBkg, bkgCopyCntrCmByBkgVO.getCopyModeCd(), tmpCntrVO, account);
                        // sourceBkg에서 bkg_cntr_seal_no를 읽어서 targetBkg에 insert한다
                        dbDao.copyBkgCntrSealByBKG(mstBkg, combineBkg, tmpCntrVO, account);
                    }

                    if ("Y".equals(bkgCopyCntrCmByBkgVO.getHitchmentYn()) ) {
                        // hitchment일 경우 이전의 por, pol을 update한다.
                        dbDao.modifyCntrPorPol(mstBkg, combineBkg, account);
                    }
                    
                    //cancel 된 booking의 container에 delete mark update
                    dbDao.cancelBkgCntr(combineBkg, account);
                }
              //wpm관련 자동문구 저장
	            blDoc.modifyBlDescByWpm(sourceBkg, oldDesc, account.getUsr_id());
            } else if(bkgCopyCntrCmByBkgVO.getCopyModeCd().equals("S")) { // Split일때
                // split 전에 있던 cntr list
                String[] cntrNo = utilBC.searchCntrListByBkg(sourceBkg);
                //여러 bkg에 assign된 container를 확인
                int [] partialCount = new int [cntrNo.length] ;
                for(int i = 0; i < cntrNo.length; i++){
                    for(int j = 0; j < selectCntrVO.size(); j++){
                        if(cntrNo[i].equals(selectCntrVO.get(j).getCntr_no()) 
                            && selectCntrVO.get(j).getSplitNo().length() > 0){
                            partialCount[i]++;
                        }
                    }
                }
                
                //new bkg으로 cntr을 복사
                for(int i = 0; i < targetBkg.length; i++) {
                    if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                    	String oldDesc = dbDao.searchWpmDescForBl(sourceBkg, "N");
                    	for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
                            // sourceBkg의 bkg_container를 targetBkg으로 복사한다
                        	log.debug("sourceBkg:"+sourceBkg.getBkgNo()+",targetBkg:"+targetBkg[i].getBkgNo());
                            if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg[i].getBkgNo())
                                && selectCntrVO.get(icnt).getSplitNo().length()>1){
                                dbDao.copyBkgCntrByBkg(targetBkg[i], sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt), account);
                                // sourceBkg에서 bkg_cntr_mf를 읽어서 targetBkg에 insert한다
                                dbDao.copyCmByBkg(targetBkg[i], sourceBkg, bkgCopyCntrCmByBkgVO.getCopyModeCd(), (SelectCntrVO) selectCntrVO.get(icnt), account);
                                // sourceBkg의 bkg_cntr_seal_no를 targetBkg으로 복사한다
                                dbDao.copyBkgCntrSealByBKG(targetBkg[i], sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt),account);
                            
                                if("Y".equals(utilBC.searchEffDtDiv(targetBkg[i].getBkgNo(),"EQ_ID","BKG"))){
                            		//EQ ID를 위한 History생성
                            		BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
                            		docProcSkdVO.setBkgDocProcTpCd("CNTATC");
                            		docProcSkdVO.setBkgNo(targetBkg[i].getBkgNo());
                            		docProcSkdVO.setDiffRmk(selectCntrVO.get(icnt).getCntr_no());
                            		docProcSkdVO.setPairFlg("N");
                            		histCmd.manageDocProcess(docProcSkdVO, account);
                                }
                            }
                        }
                        //wpm관련 자동문구 저장
        	            blDoc.modifyBlDescByWpm(targetBkg[i], oldDesc, account.getUsr_id());
                    }
                    
                }
                for (int i = 0; i < cntrNo.length; i++) {
					// 처음 나오는 BKG에 소수점 이하 나눠지지 않는 부분을 몰아주기 위해 조회함
					String firstCntrFlag = "N";
					BkgBlNoVO firstBkg = null;
					// partial cntr일 경우
					if (partialCount[i] > 1) {
						for (int j = 0; j < targetBkg.length; j++) {
							for (int k = 0; k < selectCntrVO.size(); k++) {
								if (selectCntrVO.get(k).getCntr_no().equals(cntrNo[i])
										&& selectCntrVO.get(k).getBkg_no().equals(targetBkg[j].getBkgNo())
										&& selectCntrVO.get(k).getSplitNo().length() > 1) {
									if ("N".equals(firstCntrFlag)) {
										if (dbDao.searchExistContainer(targetBkg[j].getBkgNo(),cntrNo[i], "N")) {
											firstCntrFlag = "Y";
											firstBkg = targetBkg[j];
										}
									}
									if (null != firstBkg) {
										log.debug("cntrNo:" + cntrNo[i]
												+ " source bkg_no:" + firstBkg
												+ " target bkg : "+ targetBkg[j]
												+ " partialCount :"+ partialCount[i]);
										dbDao.modifyBkgCntrPartialFlg(firstBkg,targetBkg[j], cntrNo[i],partialCount[i], account);
									}
								}
							}
						}
					}
				}                
                //원본BkgNo에 대해 Cntr체크 해제시 처리
                for(int i = 0; i < targetBkg.length; i++) {
                    if(sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                    	String oldDesc = dbDao.searchWpmDescForBl(sourceBkg, "N");
                    for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
                        if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg[i].getBkgNo())
                          && selectCntrVO.get(icnt).getSplitNo().length()<1){
                            // 전달받은 cntr No로 bkg_cntr_seal_no 에서 삭제한다
                            dbDao.removeCntrSealNoAfterSplit(sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt));
                            //NCM정보를 삭제한다. 
                            dbDao.removeCmDtlByCntr(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
                            // BKG CONTAINER MANIFEST DESCRIPTION 정보를 삭제한다.
                            dbDao.removeCmByCntr(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
                            // BKG CONTAINER 테이블에서 Delete Flag를 'Y'로 변경
                            dbDao.removeContainer(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
                        }
                      }
                    //wpm관련 자동문구 저장
    	            blDoc.modifyBlDescByWpm(sourceBkg, oldDesc, account.getUsr_id());
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
			
			BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
			BookingUtil bookingUtil = new BookingUtil();
			BLDocumentationBLBC blDoc = new BLDocumentationBLBCImpl();	
            //new bkg으로 cntr을 복사
            for(int i = 0; i < targetBkg.length; i++) {
                if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                	String oldDesc = dbDao.searchWpmDescForBl(sourceBkg, "N");
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
                        
                            if("Y".equals(bookingUtil.searchEffDtDiv(targetBkg[i].getBkgNo(),"EQ_ID","BKG"))){
                        		//EQ ID를 위한 History생성
                        		BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
                        		docProcSkdVO.setBkgDocProcTpCd("CNTATC");
                        		docProcSkdVO.setBkgNo(targetBkg[i].getBkgNo());
                        		docProcSkdVO.setDiffRmk(selectCntrVO.get(icnt).getCntr_no());
                        		docProcSkdVO.setPairFlg("N");
                        		histCmd.manageDocProcess(docProcSkdVO, account);
                            }

                        }
                    }
                    //wpm관련 자동문구 저장
    	            blDoc.modifyBlDescByWpm(targetBkg[i], oldDesc, account.getUsr_id());
                }
            }
            
            //원본BkgNo에 대해 Cntr체크 해제시 처리
            for(int i = 0; i < targetBkg.length; i++) {
                if(sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                	String oldDesc = dbDao.searchWpmDescForBl(sourceBkg, "N");
                for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
                    if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg[i].getBkgNo())
                      && selectCntrVO.get(icnt).getSplitNo().length()<1){
                        // 전달받은 cntr No로 bkg_cntr_seal_no 에서 삭제한다
                        dbDao.removeCntrSealNoAfterSplit(sourceBkg, (SelectCntrVO) selectCntrVO.get(icnt));
                        //NCM정보를 삭제한다.
                        dbDao.removeCmDtlByCntr(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
                        // BKG CONTAINER MANIFEST DESCRIPTION 정보를 삭제한다.
                        dbDao.removeCmByCntr(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
                        // BKG CONTAINER 테이블에서 Delete Flag를 'Y'로 변경
                        dbDao.removeContainer(sourceBkg.getBkgNo(), selectCntrVO.get(icnt).getCntr_no(), "N");
                    }
                  }
                //wpm관련 자동문구 저장
	            blDoc.modifyBlDescByWpm(sourceBkg, oldDesc, account.getUsr_id());
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
     *  Container의 Bkg_no에 따라 awk_cgo_flg 값을 변경한다..(ESM_BKG_0055)    
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
     *  Container의 Bkg_no에 따라 awk_cgo_flg 값을 변경한다..(ESM_BKG_0055)    
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
     *  Container의 Bkg_no에 따라 awk_cgo_flg 값을 변경한다..(ESM_BKG_0055)    
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
     * container에 해당하는 manifest 정보를 조회한다.-- UI_BKG-0178
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
     * 컨테이너별로 C/M을 입력/수정/삭제한다 -- UI_BKG-0178
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
//            	if(!"Y".equalsIgnoreCase(dbDao.checkSocCntr(cntrCmBkgInfoVOs[i].getCntrNo()))){
//	            	//vgm min/max 검사
//	            	if(NumberUtils.toDouble(containerVOs[i].getVgmWgt()) > 0 && StringUtils.isNotBlank(containerVOs[i].getVgmWgt()) && StringUtils.isNotBlank(containerVOs[i].getCntrTpszCd()) && StringUtils.isNotBlank(containerVOs[i].getVgmWgtUtCd())){
//	            		String vgmUpdFlg = dbDao.checkVGMMinMax(containerVOs[i].getVgmWgt(), containerVOs[i].getCntrTpszCd(), containerVOs[i].getVgmWgtUtCd());
//		            	if("MIN".equals(vgmUpdFlg)){
//		            		throw new EventException(new ErrorHandler("BKG95099", new String[]{"less","minimum"}).getMessage());
//		            	} else if ("MAX".equals(vgmUpdFlg)){
//		            		throw new EventException(new ErrorHandler("BKG95099", new String[]{"more","maximum"}).getMessage());
//		            	} 
//	            	}
//	            	//cntr loadable max 검사
//	            	if(NumberUtils.toDouble(containerVOs[i].getCntrWgt()) > 0 && StringUtils.isNotBlank(containerVOs[i].getWgtUtCd())){
//	            		String loadMaxFlg = dbDao.checkLoadableMax(containerVOs[i].getCntrWgt(), containerVOs[i].getCntrTpszCd(), containerVOs[i].getWgtUtCd());
//	            		if("N".equalsIgnoreCase(loadMaxFlg)){
//	            			throw new EventException(new ErrorHandler("BKG95100", new String[]{containerVOs[i].getCntrNo()}).getMessage());
//	            		}
//	            	}
//            	}
                dbDao.modifyCntrByCm(updateBkgList, caFlg);
            }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * container manifest 정보를 조회한다.-- UI_BKG-0079-07, UI_BKG-0178, BKG CONTAINER MANIFEST DESCRIPTION
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
     * container 정보를 생성한다. 
     * -- UI_BKG-0172, BKG CONTAINER, BKG CONTAINER SEAL NUMBER, BKG BOOKING, BKG DOCUMENT PROCESS SCHEDULE, BKG RATE 등
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
     * Doc Process의 상태를 조회한다.
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
     * Total Package in Word 업데이트 전에, O.B/L Issue 여부를 검색한다.
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
     * BKG Qty와 CNTR의 Qty가 다른 경우 Container Final Confirm을 하면 M&D의 Total Package in Word를 업데이트 한다.(BKG_BL_DOC.TTL_PCK_DESC)
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
     * Partial Container Volume 조정시 관련 같은 VVD에서 같은 Container를 사용하는 BKG No. 및 Vol을 조회한다. -- UI_BKG-1050
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
     * @author KimYoungchul
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
     * Partial Container Volume 조정시 관련 같은 VVD에서 같은 Container를 사용하는 BKG No. 및 Vol을 조회한다. -- UI_BKG-1050
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
     * Container의 Vol 및 Partial Flag를 업데이트 한다.. UI_BKG-0170
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
     * sourceBkg의 bkg_bl_doc을 targetBkg로 복사한다.
     * 
     * @author      KimByungKyu
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
     *  BKG_BL_DOC 저장.(ESM_BKG_0079_01) -> createBooking<br>
     *  
     * @author      KimByungKyu
     * @param       String bkgNo
     * @param       String blMvTpNm
	 * @param       String fnlDestNm 
     * @param       String actWgt
     * @param       String wgtUtCd
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
//    public void createBkgBlDocByBKG(String bkgNo, String blMvTpNm, String fnlDestNm, String actWgt, String wgtUtCd, SignOnUserAccount account) throws EventException {
//        try {
//            dbDao.addBkgBlDoc(bkgNo, blMvTpNm, fnlDestNm, actWgt, wgtUtCd, account.getUsr_id());
//            dbDao.modifyBlByFinalCfm(bkgNo, "N");
//        } catch(DAOException ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        } catch(Exception ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        }
//    }
    
    /**
     *  BKG_BL_DOC 저장.(ESM_BKG_0079_01) -> createBooking<br>
     *  
     * @author      WonJooCho
     * @param       CreateBkgBlDocBkgVO createBkgBlDocBkgVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void createBkgBlDocByBKG(CreateBkgBlDocBkgVO createBkgBlDocBkgVO, SignOnUserAccount account) throws EventException {
        try {
            dbDao.addBkgBlDoc(createBkgBlDocBkgVO, account.getUsr_id());
            dbDao.modifyBlByFinalCfm(createBkgBlDocBkgVO.getBkgNo(), "N");
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * Movement에서 MT Repo. Booking의 경우 VL 상태일 때 Contanier를 삭제하면 Movement Cycle을 9999로 업데이트 한다..
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
     * CTM 에서 호출하는 ContainerMovementMgt 처리<br>
     * Exception 처리를 하면 안된다고 함.<br>
     * - 담당자 : 우경민[EO]
     * @param CrossItemVO item
     * @return boolean
     * @exception EventException
     */
    public boolean modifyCntrOp(CrossItemVO item) throws EventException {
        String errMsg = null;
        boolean isReturn = false;
        EBookingReceiptBCImpl eBookingReceiptBCImpl = new EBookingReceiptBCImpl();
        try {

            if("D".equals(item.getAttchCd())) {
                errMsg = "Movement update error due to COP";
                
                BookingUtil utilCmd = new BookingUtil();
                BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
                bkgBlNoVO.setBkgNo(item.getBkgNo());
                
                //S/O 관련 에러처리
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
	                	// Cntr Mvmt OC History - end
	                    
	                	/* EDI로 CNTR가 BKG 에 Attach 되면서 CNTR Vol 이 1 이상인 경우 Not updated 로 처리 */
	                	String rstr = "";
	                	if(!"".equals(tempVO.getBkgNo()) && !"".equals(tempVO.getCntrNo())){
	                		rstr = dbDao.searchDupCntrAttach(item.getCusCtmMovementVO().getBkgNo(),item.getCusCtmMovementVO().getCntrNo());
	                	}
	                	if("OC".equals(item.getCusCtmMovementVO().getMvmtStsCd()) && null != rstr && !"".equals(rstr)){
	                		isReturn = true;
		                }else{
		                    errMsg = "Movement update error due to booking";
		                    
		                    BookingUtil utilCmd2 = new BookingUtil();
//		                    
		                    BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
		        			bkgHrdCdgCtntListCondVO.setHrdCdgId("VGM_CNTR_MVMT_IF");			
		        			List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = utilCmd2.searchHardCoding(bkgHrdCdgCtntListCondVO);
		        			
		        			String vgmIFFmCTM = "";
		        			if(BkgHrdCdgCtntVOs.size() > 0){
		        				vgmIFFmCTM = BkgHrdCdgCtntVOs.get(0).getAttrCtnt2();// CTM으로 부터 VGM 데이터 IF
		        			}
		        			if("OFF".equals(vgmIFFmCTM)){
		        				dbDao.modifyCntrOp(item.getCusCtmMovementVO(), item.getFindBkgCntr());
		        			}else{
		        				
		        				//VGM 업데이트 조건 Y or N
		        				//3개 다 Y이면 VGM 인터페이스 
		        				/*  vgmUpdFlg1 
		        				 *  1. BKG CNTR에 WGT값과 CTM에서 들어오는 VGM WGT 값을 비교해서 VGM WGT가 크면 Y
		        				 *  2. CNTR WGT가 null이거나 0이면 값이 없다고 판단해 업데이트 처줌 Y
		        				 *  3. BKG CNTR에 이미 VGM 값이 존재하면 N
		        				 *  
		        				 *  vgmUpdFlg2
		        				 *  1. VGM MIN MAX 하드코딩 테이블에 VGM에 해당하는 MIN MAX값 사이에 있어야만 Y
		        				 *  2. SOC일 경우는 min max 로직 적용하지 않음.
		        				 *  
		        				 *  vgmUpdFlg3
		        				 *  1. CTM으로 부터 들어오는 VGM WGT값이 존재하면 Y
		        				 *  2. CTM으로 부터 들어오는 VGM WGT Unit code값이 존재하면 Y
		        				 *  
		        				 *  -참고로 partial cntr의 경우 1개의 cntr이라도 조건에 충족하지 않으면 업데이트 안함.
		        				 *  -OC, VL일 때만 VGM값 넘겨줌
		        				 */
		        				String []bkgArr = dbDao.searchPartialCntrBkg(item.getCusCtmMovementVO().getBkgNo(),item.getCusCtmMovementVO().getCntrNo());
		        				
		        				String vgmUpdateFlg = "N";
            					String vgmInsertFlg = "N";
            					
            					String vgmUpdFlg1 = "Y";
            					
            					//첫 번째 조건은 partial cntr까지 고려. 
		        				if(bkgArr!=null && bkgArr.length>0){
		        					String []vgmUpdFlg1Arr = new String[bkgArr.length];
                    				for(int i=0;i<bkgArr.length;i++){
                    					vgmUpdFlg1Arr[i] = dbDao.searchConditionForVGM(bkgArr[i], item.getCusCtmMovementVO());
                    					if(!"Y".equalsIgnoreCase(vgmUpdFlg1Arr[i])){
                    						vgmUpdFlg1 = "N";
                    						break;
                    					}
                    				}
		        				}
		        				String vgmUpdFlg2 = dbDao.checkVGMMinMax(item.getCusCtmMovementVO().getVgmWgtQty(), item.getCusCtmMovementVO().getCntrTpszCd(), item.getCusCtmMovementVO().getVgmWgtUtCd());
		        				if("Y".equalsIgnoreCase(dbDao.checkSocCntr(item.getCusCtmMovementVO().getCntrNo()))){
		        					vgmUpdFlg2 = "Y";
		        				}
		        				String vgmUpdFlg3 = "N";
		        				if(!"".equals(item.getCusCtmMovementVO().getVgmWgtQty())  
		                    				&& item.getCusCtmMovementVO().getVgmWgtQty() !=null 
		                    				&& !"0".equalsIgnoreCase(item.getCusCtmMovementVO().getVgmWgtQty())
		                    				&& !"".equals(item.getCusCtmMovementVO().getVgmWgtUtCd())
		                    				&& item.getCusCtmMovementVO().getVgmWgtUtCd() !=null){
		        					vgmUpdFlg3 = "Y";
		        				}
            					
            					
            					if("Y".equalsIgnoreCase(vgmUpdFlg1) 
            							&& "Y".equalsIgnoreCase(vgmUpdFlg2) 
            							&& "Y".equalsIgnoreCase(vgmUpdFlg3)){
            						vgmUpdateFlg = "Y";
            					}
            					if("Y".equalsIgnoreCase(vgmUpdFlg2) 
            							&& "Y".equalsIgnoreCase(vgmUpdFlg3)){
            						vgmInsertFlg = "Y";
            					}
			                    dbDao.modifyCntrOp2(item.getCusCtmMovementVO(), item.getFindBkgCntr(), vgmUpdateFlg, vgmInsertFlg);
			                    
			                    //VGM 히스토리
			                    BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
                    			HistoryLineVO historyLineVO = new HistoryLineVO();
                    			
                    			SignOnUserAccount account = new SignOnUserAccount();
                    			account = new SignOnUserAccount("VGM MVMT" ,"" ,"" ,"" ,""
                												,"" ,"" ,"" ,"VGM MVMT" ,""
                												,"VGM MVMT" ,"" ,"" ,"" ,""
                												,"" ,"" ,"" ,"", "", "" ,""
																);
                    			historyLineVO.setCaFlg("N");
            					historyLineVO.setCrntCtnt("VGM Updated from MVMT : "+item.getCusCtmMovementVO().getCntrNo()+
            							"/"+item.getCusCtmMovementVO().getVgmWgtQty()+item.getCusCtmMovementVO().getVgmWgtUtCd()+
            							"/"+item.getCusCtmMovementVO().getVgmMzdTpCd()+
            							"/"+item.getCusCtmMovementVO().getVgmSigCtnt());
//	            					historyLineVO.setCrntCtnt("VGM Updated from MVMT : "+item.getCusCtmMovementVO().getCntrNo()+
//	            							"/"+item.getCusCtmMovementVO().getVgmWgtQty()+item.getCusCtmMovementVO().getVgmWgtUtCd());
            					historyLineVO.setHisCateNm("Container");
            					historyLineVO.setPreCtnt(" ");
            					historyLineVO.setUiId("VGM MVMT");
            					
			                    if(bkgArr!=null && bkgArr.length>0){
                    				for(int i=0;i<bkgArr.length;i++){
		            					historyLineVO.setBkgNo(bkgArr[i]);
		            					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		            					bkgBlNoVO.setBkgNo(bkgArr[i]);
                        				//merge into
    				                    if(("OC".equals(item.getCusCtmMovementVO().getMvmtStsCd()) || "VL".equals(item.getCusCtmMovementVO().getMvmtStsCd())) && item.getFindBkgCntr()==true){
    		                    			if("Y".equalsIgnoreCase(vgmUpdateFlg)){ 
    		                    				histCmd.createBkgHistoryLine(historyLineVO, account);
    		                    				
    		                    				//edi setup된 터미널로 edi 다시 보내줌
    		                    				List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
    		                    				for(TmnlRcvIdVO trvo : dbDao.searchVGMOutboundRcvIdForMVMT(bkgBlNoVO)){
    		                    					String bracCd = "9";
    		                    					bracCd = StringUtils.isNotEmpty(trvo.getBracCd()) ? trvo.getBracCd() : "9";
    		                    					bkgNtcHisVOs.add(eBookingReceiptBCImpl.createTerminalVERMASFlatFile(bkgBlNoVO, trvo.getEdiRcvId(), bracCd));
    		                    					if(bkgNtcHisVOs!=null){
    		                    						if(bkgNtcHisVOs.size()>0){
    		                    							histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
    		                    						}
    		                    					}
    		                    				}
    		                    			}
    				                    }
                    				}
                    			}
			                    //insert
			                    if(("OC".equals(item.getCusCtmMovementVO().getMvmtStsCd()) && item.getFindBkgCntr()==false)){
			                    	if("Y".equalsIgnoreCase(vgmInsertFlg)){ 
			                    		//insert는 partial cntr이 없기에 MVMT에서 들어온 BKG를 그대로 set
			                    		historyLineVO.setBkgNo(item.getCusCtmMovementVO().getBkgNo());
			                    		histCmd.createBkgHistoryLine(historyLineVO, account);
			                    		
			                    		//edi setup된 터미널로 edi 다시 보내줌
			                    		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
			                    		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		            					bkgBlNoVO.setBkgNo(item.getCusCtmMovementVO().getBkgNo());
	                    				for(TmnlRcvIdVO trvo : dbDao.searchVGMOutboundRcvIdForMVMT(bkgBlNoVO)){
	                    					String bracCd = "9";
	                    					bracCd = StringUtils.isNotEmpty(trvo.getBracCd()) ? trvo.getBracCd() : "9";
	                    					bkgNtcHisVOs.add(eBookingReceiptBCImpl.createTerminalVERMASFlatFile(bkgBlNoVO, trvo.getEdiRcvId(), bracCd));
	                    					if(bkgNtcHisVOs!=null){
	                    						if(bkgNtcHisVOs.size()>0){
	                    							histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
	                    						}
	                    					}
	                    				}
			                    	}
			                    }
		        			}
		                    
		                    if((!item.getFindBkgCntr() && "OC".equals(item.getCusCtmMovementVO().getMvmtStsCd()))
		                    		||(!item.getFindBkgCntr() && "OP".equals(item.getCusCtmMovementVO().getMvmtStsCd()))){
		                    	BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		                    	BookingUtil utilCmd = new BookingUtil();
		                    	if("Y".equals(utilCmd.searchEffDtDiv(item.getCusCtmMovementVO().getBkgNo(),"EQ_ID","BKG"))){
			                		//EQ ID를 위한 History생성
			                		BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
			                		docProcSkdVO.setBkgDocProcTpCd("CNTATC");
			                		docProcSkdVO.setBkgNo(item.getCusCtmMovementVO().getBkgNo());
			                		docProcSkdVO.setDiffRmk(item.getCusCtmMovementVO().getCntrNo());
			                		docProcSkdVO.setPairFlg("N");
			            			SignOnUserAccount account = new SignOnUserAccount();
			            			account = new SignOnUserAccount("SYSTEM" ,"" ,"" ,"" ,""
			        												,"" ,"" ,"" ,"SYSTEM" ,""
			        												,"SYSTEM" ,"" ,"" ,"" ,""
			        												,"" ,"" ,"" ,"", "", "" ,""
			    													);
			                		histCmd.manageDocProcess(docProcSkdVO, account);
		                    	}
		                    }
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
		                    				
		                                    BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		                                    bkgBlNoVO.setBkgNo(cntrMoveOpInfoVOs.get(i).getBkgNo());
		                    				bkgBlNoVO.setCaFlg("N");
		                                	String oldDesc = dbDao.searchWpmDescForBl(bkgBlNoVO, "N");

		//                    				dbDao.removeContainer(bkgNo, cntrNo, "N"); 형식 
		                    				log.debug(">>>>>>removeCntrSealNo: " + cntrMoveOpInfoVOs.get(i).getBkgNo() + " - " + cntrMoveOpInfoVOs.get(i).getCntrNo());
		                    				dbDao.removeCntrSealNo(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), "", "N");
		                    				// 2. remove Rate
		//                    				// 3. remove Reference detail
		//                    				// 4. remove Reference
		                    				// 5. remove Manifest
		                    				log.debug(">>>>>>removeCmByCntr: " + cntrMoveOpInfoVOs.get(i).getBkgNo() + " - " + cntrMoveOpInfoVOs.get(i).getCntrNo());
		                    				dbDao.removeCmByCntr(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), "N");
		                    				// 6. remove Container
		                    				log.debug(">>>>>>removeCntr: " + cntrMoveOpInfoVOs.get(i).getBkgNo() + " - " + cntrMoveOpInfoVOs.get(i).getCntrNo());                    				
			                    			dbDao.removeContainer(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), "N");
			                    			
			                    			//wpm관련 자동문구 저장
			                    			BLDocumentationBLBC blDoc = new BLDocumentationBLBCImpl();	
			                	            blDoc.modifyBlDescByWpm(bkgBlNoVO, oldDesc, "SYSTEM");
			                	            
			                    			/* Container detach 시 source bkg history 생성 */
			                    			SignOnUserAccount account = new SignOnUserAccount();
			                    			account = new SignOnUserAccount("SYSTEM" ,"" ,"" ,"" ,""
			                												,"" ,"" ,"" ,"SYSTEM" ,""
			                												,"SYSTEM" ,"" ,"" ,"" ,""
			                												,"" ,"" ,"" ,"", "", "" ,""
																			);
			                    			BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
			                    			HistoryLineVO historyLineVO = null;
			            					historyLineVO = new HistoryLineVO();
			            					historyLineVO.setBkgNo(cntrMoveOpInfoVOs.get(i).getBkgNo());
			            					historyLineVO.setCaFlg("N");
			            					historyLineVO.setCrntCtnt("Detach Container : "+cntrMoveOpInfoVOs.get(i).getCntrNo());
			            					historyLineVO.setHisCateNm("Container");
			            					historyLineVO.setPreCtnt(" ");
			            					historyLineVO.setUiId("SYSTEM");
			            					histCmd.createBkgHistoryLine(historyLineVO, account);
			            					
			                                BkgCopManageBC copMgt = new BkgCopManageBCImpl();
			                                copMgt.detachCntr(cntrMoveOpInfoVOs.get(i).getBkgNo(), cntrMoveOpInfoVOs.get(i).getCntrNo(), item.getCntrPrtFlg());
		                    			}else{
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
		    		                    	
		    		                    	if(dbDao.searchExistContainer(bkgCntrSealNoVO.getBkgNo(),bkgCntrSealNoVO.getCntrNo(), "N") && dbDao.searchCntrSealNoModithCheck(bkgCntrSealNoVO.getBkgNo(),bkgCntrSealNoVO.getCntrNo(), "N")){
		    		                    		dbDao.insertCntrSealNo(bkgCntrSealNoVO, "N");
		    		                    	}  
		    		                    	
		    		                    }
		    	                    }
		                    	}
		                    }
		                    BookingUtil utilCmd = new BookingUtil();
		                    // COP 호출
		                    if("OP".equals(item.getCusCtmMovementVO().getMvmtStsCd())
		                            || "OC".equals(item.getCusCtmMovementVO().getMvmtStsCd())) {
		//                    	log.error("SCE ** BKG_NO : "+item.getBkgNo() + " CNTR_NO : "+ item.getCntrNo() + " / item.getFindBkgCntr() = " + item.getFindBkgCntr());
		                    	
		                    	
		        			    /* COP 호출 문제로 BKG_FUNC_PROC_LOG_PRC 삽입 */
//		                    	BookingUtil utilCmd = new BookingUtil();
		                    	if((!"".equals(item.getBkgNo()) && null != item.getBkgNo()) && (!"".equals(item.getCntrNo()) && null != item.getCntrNo()) && (!"".equals(item.getFindBkgCntr()))){
		        					utilCmd.addBkgLog("BKG_COP_ATTACH4", item.getBkgNo(), item.getCntrNo() + " / "+ item.getFindBkgCntr());
		                    	}
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
            	}
            log.debug("isReturn:::::::::::::::::::" + isReturn);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(errMsg).getMessage());             
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new EventException(new ErrorHandler(errMsg).getMessage());
        }
        return isReturn;
    }
    
    /**
     * CTM 에서 호출하는 Container History Update를 위한 메소드.<br>
     * - 담당자 : 우경민[EO]
     *
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
	 * bkg_container 테이블에 한국 WHF CNTR별 Exception 정보를  update한다.<br>
	 * 
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
     * MstContainer정보 조회
     * 
     * @author KimByungKyu
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
     * @author KimYoungchul
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
     * container manifest 정보를 생성한다. -- UI_BKG_0229_05, BKG CONTAINER MANIFEST DESCRIPTION
     * 
     * @param cmVO
     * @param account
     * @param caFlg 
     * @exception EventException
     */
	public void manageCmByXter(CmVO cmVO, SignOnUserAccount account, String caFlg) throws EventException{
		CmBkgInfoVO cmBkgInfoVO = cmVO.getCmBkgInfoVO();
	    List<BkgCntrMfDescVO> cntrMfDescVOs = cmVO.getBkgCntrMfDescVOs();
	    String cntrMfNo = "";
	    String[] ncmNoArr = null;  
        try {
            /* container manifest */
            if(cntrMfDescVOs != null && cntrMfDescVOs.size() > 0){
                for(int i = 0; i < cntrMfDescVOs.size(); i++) {
                	cntrMfDescVOs.get(i).setBkgNo(cmBkgInfoVO.getBkgNo());
                	cntrMfDescVOs.get(i).setCreUsrId(account.getUsr_id());
                	cntrMfDescVOs.get(i).setUpdUsrId(account.getUsr_id());
                	
                	/* 적화목록 신고번호  조회 */
                	cntrMfNo = dbDao.searchBkgHblByRqstNo(cntrMfDescVOs.get(i));
                	cntrMfDescVOs.get(i).setCntrMfNo(cntrMfNo);
                	
                    if(cntrMfDescVOs.get(i).getIbflag().equals("D")) {
                        dbDao.removeCm(cntrMfDescVOs.get(i), caFlg);
                        dbDao.removeBrCm(cntrMfDescVOs.get(i), caFlg); 
                    } else if(cntrMfDescVOs.get(i).getIbflag().equals("I")) {
                        dbDao.addCm(cntrMfDescVOs.get(i), caFlg);
                        
                        if( !cntrMfDescVOs.get(i).getNcmMultiNo().equals("") ){
        					ncmNoArr = cntrMfDescVOs.get(i).getNcmMultiNo().split(",");
        					for( int jdx = 0; jdx < ncmNoArr.length; jdx++ ){
        						BkgCntrMfDescDtlVO cntrMfDescDtlVO = new BkgCntrMfDescDtlVO();
        						cntrMfDescDtlVO.setBkgNo(cmBkgInfoVO.getBkgNo());
        						cntrMfDescDtlVO.setCntrNo(cntrMfDescVOs.get(i).getCntrNo());
        						cntrMfDescDtlVO.setCntrMfSeq(cntrMfDescVOs.get(i).getCntrMfSeq());
        						cntrMfDescDtlVO.setMfDtlSeq(Integer.toString(jdx+1));
        						cntrMfDescDtlVO.setNcmNo(ncmNoArr[jdx]);
        						cntrMfDescDtlVO.setCreUsrId(cntrMfDescVOs.get(i).getCreUsrId());
        						
        						dbDao.addCmDtl(cntrMfDescDtlVO, caFlg);
        					}
                        } 

                    } else if(cntrMfDescVOs.get(i).getIbflag().equals("U")) {
                        dbDao.modifyCmByXter(cntrMfDescVOs.get(i), caFlg);
                        
                       if( !cntrMfDescVOs.get(i).getNcmMultiNo().equals("") ){
                        	dbDao.removeBrCm(cntrMfDescVOs.get(i), caFlg); // 브라질 세관신고시 사용되는 품목코드 삭제
        					ncmNoArr = cntrMfDescVOs.get(i).getNcmMultiNo().split(",");
        					for( int jdx = 0; jdx < ncmNoArr.length; jdx++ ){
        						cntrMfDescVOs.get(i).setNcmNo(ncmNoArr[jdx]);
        						BkgCntrMfDescDtlVO cntrMfDescDtlVO = new BkgCntrMfDescDtlVO();
        						cntrMfDescDtlVO.setBkgNo(cmBkgInfoVO.getBkgNo());
        						cntrMfDescDtlVO.setCntrNo(cntrMfDescVOs.get(i).getCntrNo());
        						cntrMfDescDtlVO.setCntrMfSeq(cntrMfDescVOs.get(i).getCntrMfSeq());
        						cntrMfDescDtlVO.setMfDtlSeq(Integer.toString(jdx+1));
        						cntrMfDescDtlVO.setNcmNo(ncmNoArr[jdx]);
        						cntrMfDescDtlVO.setCreUsrId(cntrMfDescVOs.get(i).getCreUsrId());
        						
        						dbDao.addCmDtl(cntrMfDescDtlVO, caFlg);
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
     * bkg의 route name을 update한다.
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
     * split 후 cntr별 special cargo flag를 재 계산한다.
     * 
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
     * cntr의 cgo_rcv_dt를 update
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
     * BkgDgCgoVO 모델에 대한 데이타 조회.
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
	 * Cntr Mvmt OC History 저장
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
     * Bangladesh Shipment Detail 에 대한 데이타 조회.
     * 
     * @param BkgCustShpRqstVO bkgCustShpRqstVO
     * @return List<BkgCustShpRqstVO>
     * @exception DAOException
     */
	public List<BkgCustShpRqstVO> searchBkgCustShpRqstList(BkgCustShpRqstVO bkgCustShpRqstVO) throws EventException {
		try {
			return dbDao.searchBkgCustShpRqstList(bkgCustShpRqstVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

    
	 
	 /**
	    * 방글라데시 ODCY로부터의 파일을 일정 형식으로 저장 
	    * 
	    * @param BkgCustShpRqstVO[] bkgCustShpRqstVOs
	    * @param SignOnUserAccount account
	    * @exception DAOException
	    */
		public void manageBkgCustShpRqst(BkgCustShpRqstVO[] bkgCustShpRqstVOs, SignOnUserAccount account) throws EventException, DAOException {
			// 파라메터 객체 변환
			try {			
				// 작업 구분 분할
				for(int i=0; i < bkgCustShpRqstVOs.length; i++) {
					if (bkgCustShpRqstVOs[i].getIbflag().equals("D")) {
						dbDao.removeBkgCustShpRqst(bkgCustShpRqstVOs[i],account);
					}else if (bkgCustShpRqstVOs[i].getIbflag().equals("I")) {
						dbDao.addBkgCustShpRqst(bkgCustShpRqstVOs[i], account);
					}else if (bkgCustShpRqstVOs[i].getIbflag().equals("U")) {
						dbDao.modifyBkgCustShpRqst(bkgCustShpRqstVOs[i],account);

					}
				}
				
			} catch (DAOException de) {
				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
			}
		}
		
		/**
	     * Bangladesh Shipment Detail 에 대한 데이타 조회.
	     * 
	     * @param BkgCustShpRqstVO bkgCustShpRqstVO
	     * @return List<BkgCustShpRqstVO>
	     * @exception DAOException
	     */
		public List<BkgCustShpRqstVO> searchBkgCntrShpRqst(BkgCustShpRqstVO bkgCustShpRqstVO) throws EventException {
			try {
				return dbDao.searchBkgCntrShpRqst(bkgCustShpRqstVO);
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
			}
		}
		
	    /**
	     *   B/L 수정.<br>
	     * @author  LaSangbo
	     * @param   CmBkgInfoVO cmBkgInfoVO
	     * @exception   EventException
	     */
	    public void modifyBlByCntrInfo(CmBkgInfoVO cmBkgInfoVO) throws EventException {
	        try {
	            dbDao.modifyBlByCm(cmBkgInfoVO, "N");
	        } catch(DAOException ex) {
	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	        } catch(Exception ex) {
	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	        }
	    }
	    
	    
		/**
		 * BKG No.로 BDR이 걸렸는지 check
		 * @param String bkgNo
		 * @return String
	     * @throws EventException
	     */
	    public String searchBdrFlgForNewRoute(String bkgNo) throws EventException {
	        String bdrFlg = null;
	        try {
	        	bdrFlg = dbDao.searchBdrFlgForNewRoute(bkgNo);
	        } catch(DAOException ex) {
	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	        } catch(Exception ex) {
	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	        }
	        return bdrFlg;
	    }
	    
	    /**
	     * Container Weight Maximum Payload 내 입력 유도 및 오입력 방지 ESM_BKG_0079_04 
	     * 
	     * @param ContainerVO[] containerVOs
	     * @return String
	     * @exception EventException
	     */
	    public  String validateContainerWgt(ContainerVO[] containerVOs) throws EventException {

	    	String chkFlg = null;
	    	chkFlg = "N";
	    	try {
            	
	        	int len = containerVOs == null ? 0 : containerVOs.length;
	        	
	        	for(int i = 0; i < len; i++) {	                
	        		if(!"D".equals(containerVOs[i].getIbflag())){
	            	List<BkgBlNoVO> splitBkgs = dbDao.searchPartialBkgCntr(containerVOs[i].getBkgNo(), containerVOs[i].getCntrNo() );
	                 //split 된 건에는 적용하지 않는다.
	            	 if(splitBkgs.size() <= 1){
	            		 //double  dAmount = Double.parseDouble(tmpAmount);
	            		 // (0.0d < dAmount && dAmount <= 5.0d) R4J 결함 복구
	            		 //0 < Double.compare(dAmount, 0.0d) && 0 >= Double.compare(dAmount,5.0d)
	            	ValidateContainerWgtVO rsvo = dbDao.validateContainerWgt(containerVOs[i].getCntrNo(), containerVOs[i].getCntrTpszCd());
	                
	                	log.debug(rsvo.getCntrGrsWgt()+" :::::::::::::::::"+rsvo.getCntrTareWgt());
                        
                        double grsWgt = Double.parseDouble(rsvo.getCntrGrsWgt());
                        double tareWgt = Double.parseDouble(rsvo.getCntrTareWgt());
                        //etcdata로 Y js에서 넘기고 메시지 출력
                       
                        if( 0 > Double.compare(grsWgt,Double.parseDouble(containerVOs[i].getCntrWgt())) ||( 0 < Double.compare(tareWgt,Double.parseDouble(containerVOs[i].getCntrWgt())))){
	                		chkFlg = "Y"; 	
	                		break;
	                	} else {
	                		chkFlg = "N";
	                	}
	                 }
	            }
	    	}//for 문 end
	        } catch(DAOException ex) {
	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	        } catch(Exception ex) {
	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	        }
	        return chkFlg;
	    }
	    
	    /**
	     * Container Risk 해당 하는 장비이면 Validation 처리 한다. 
	     * 
	     * @param ContainerVO[] containerVOs
	     * @param String caFlg
	     * @param String rcFlg
		 * @return String
	     * @exception EventException
	     */
	    public String validateCntrRsk(ContainerVO[] containerVOs, String caFlg, String rcFlg) throws EventException{
	    	boolean isFrob = false;
	    	String rskFlg = "N";
	    	try{ 
	    		int len = containerVOs == null ? 0 : containerVOs.length;
	    		 // At Risk에 해당하는 장비이면 validation메시지 팝업(Reefer)
	    		 // 조건: POD = US, POD= CA,  US Frob의 경우
	    		for(int i = 0; i < len; i ++){
//	    			if(!"D".equals(containerVOs[i].getIbflag())){
		    			CntrMstInfoVO cntrMstInfoVO = dbDao.searchMstContainer(containerVOs[i].getCntrNo());
		    			isFrob = dbDao.validateCntrRsk(containerVOs[i].getBkgNo(),containerVOs[i].getCntrNo(),caFlg, rcFlg);
		    			if(isFrob && "Y".equals(cntrMstInfoVO.getCntrRskFlg()) && (0 == cntrMstInfoVO.getCntrTpszCd().indexOf("R"))) {
		    				rskFlg ="Y";           
		    			}
//	    			}
	    		}
	    	} catch(DAOException ex) {
	    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    	} catch(Exception ex) {
	    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    	}
	    	return rskFlg;
	    }
		  
	/**
	 * bkg_container 테이블에 한국 WHF BKG별 Exception 정보를  update한다.<br>
	 * 
	 * @param CntrKrWhfExptVO cntrKrWhfExptVO
	 * @exception EventException
	 */
	public void modifyBkgKrWhfExpt(CntrKrWhfExptVO cntrKrWhfExptVO)throws EventException {
		try {
			dbDao.modifyBkgKrWhfExpt(cntrKrWhfExptVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	

    /**
     * BL body에 찍힐 WPM관련 문구를 생성한다.
     * @param BkgBlNoVO bkgBlNoVO
     * @param String xterFlg
     * @return
     * @throws EventException
     */

    public String searchWpmDescForBl(BkgBlNoVO bkgBlNoVO, String xterFlg) throws EventException {
        String desc = null;
        try {
            desc = dbDao.searchWpmDescForBl(bkgBlNoVO, xterFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return desc;
    }
    
    /**
	 * 처음 받은 EDI에 VGM이 없고 다음에 받은 EDI에 VGM이 있을 경우,
	 * [CHM-201642756] 터미널로 접수된 vermas의 vgm정보를 bkg로 인터페이스할 경우
	 * bkg_container 테이블에 CTM으로 받은 VGM 업데이트 한다.
	 * 단, bkg container에 vgm값이 이미 있으면 업데이트 안함<br>
	 * @param CrossItemVO item
	 * @exception EventException
	 */
	public void updateVGMForOnlyMVMT(CrossItemVO item)throws EventException {
		try {
			ContainerVO containerVO = new ContainerVO();
			containerVO.setBkgNo(item.getCusCtmMovementVO().getBkgNo());
			containerVO.setCntrNo(item.getCusCtmMovementVO().getCntrNo());
			
			String chkMinMax = "Y";
			if(!"Y".equalsIgnoreCase(dbDao.checkSocCntr(item.getCusCtmMovementVO().getCntrNo()))){
            	//vgm min/max 검사
            	if(NumberUtils.toDouble(item.getCusCtmMovementVO().getVgmWgtQty()) > 0 && StringUtils.isNotBlank(item.getCusCtmMovementVO().getVgmWgtQty()) && StringUtils.isNotBlank(item.getCusCtmMovementVO().getCntrTpszCd()) && StringUtils.isNotBlank(item.getCusCtmMovementVO().getVgmWgtUtCd())){
            		chkMinMax = dbDao.checkVGMMinMax(item.getCusCtmMovementVO().getVgmWgtQty(), item.getCusCtmMovementVO().getCntrTpszCd(), item.getCusCtmMovementVO().getVgmWgtUtCd());
            	}
			}
			
			String vgmExistFlg = dbDao.checkBkgVgmExist(containerVO);
			if("N".equalsIgnoreCase(vgmExistFlg) && "Y".equalsIgnoreCase(chkMinMax)){
				dbDao.updateVGMForOnlyMVMT(item);
				
				BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
    			HistoryLineVO historyLineVO = new HistoryLineVO();
    			
				SignOnUserAccount account = new SignOnUserAccount();
    			account = new SignOnUserAccount("VGM MVMT" ,"" ,"" ,"" ,""
												,"" ,"" ,"" ,"VGM MVMT" ,""
												,"VGM MVMT" ,"" ,"" ,"" ,""
												,"" ,"" ,"" ,"", "", "" ,""
												);
    			historyLineVO.setCaFlg("N");
    			historyLineVO.setBkgNo(containerVO.getBkgNo());
				historyLineVO.setCrntCtnt("VGM Updated from MVMT : "+containerVO.getCntrNo()+
						"/"+item.getCusCtmMovementVO().getVgmWgtQty()+item.getCusCtmMovementVO().getVgmWgtUtCd());
//    					historyLineVO.setCrntCtnt("VGM Updated from MVMT : "+item.getCusCtmMovementVO().getCntrNo()+
//    							"/"+item.getCusCtmMovementVO().getVgmWgtQty()+item.getCusCtmMovementVO().getVgmWgtUtCd());
				historyLineVO.setHisCateNm("Container");
				historyLineVO.setPreCtnt(" ");
				historyLineVO.setUiId("VGM MVMT");
				histCmd.createBkgHistoryLine(historyLineVO, account);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * TRS에서 받은 VGM을 BKG로 업데이트 (SPP --> TRS --> BKG)
	 * @param ContainerVO containerVO
	 * @exception EventException
	 */
	public void updateVGMFromTrs(ContainerVO containerVO)throws EventException {
		try {
			EBookingReceiptBC eBookingReceiptBC = new EBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			BookingUtil  bookingUtil            = new BookingUtil(); 
			String vgmExistFlg = dbDao.checkBkgVgmExist(containerVO);
			if("N".equalsIgnoreCase(vgmExistFlg)){
				dbDao.updateVGMFromTrs(containerVO);
				//히스토리 남기기
				BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
    			HistoryLineVO historyLineVO = new HistoryLineVO();
    			
				SignOnUserAccount account = new SignOnUserAccount();
    			account = new SignOnUserAccount("VGM TRS" ,"" ,"" ,"" ,""
												,"" ,"" ,"" ,"VGM TRS" ,""
												,"VGM TRS" ,"" ,"" ,"" ,""
												,"" ,"" ,"" ,"", "", "" ,""
												);
    			historyLineVO.setCaFlg("N");
    			historyLineVO.setBkgNo(containerVO.getBkgNo());
				historyLineVO.setCrntCtnt("VGM Updated from TRS : "+containerVO.getCntrNo()+
						"/"+containerVO.getVgmWgt()+containerVO.getVgmWgtUtCd());
//    					historyLineVO.setCrntCtnt("VGM Updated from MVMT : "+item.getCusCtmMovementVO().getCntrNo()+
//    							"/"+item.getCusCtmMovementVO().getVgmWgtQty()+item.getCusCtmMovementVO().getVgmWgtUtCd());
				historyLineVO.setHisCateNm("Container");
				historyLineVO.setPreCtnt(" ");
				historyLineVO.setUiId("VGM TRS");
				histCmd.createBkgHistoryLine(historyLineVO, account);
				
				
				BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("YDH");			
				List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = bookingUtil.searchHardCoding(bkgHrdCdgCtntListCondVO);
				String ediFlg = "";
				if(BkgHrdCdgCtntVOs.size() > 0){
					ediFlg = BkgHrdCdgCtntVOs.get(0).getAttrCtnt3();
				}
				if("ON".equalsIgnoreCase(ediFlg)){
					//terminal 301보내기
					List<BkgNtcHisVO> bkgNtcHisVOs = null;
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
					bkgBlNoVO.setBkgNo(containerVO.getBkgNo());
					
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
					vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(null);
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("");
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");//Auto
					
					bkgNtcHisVOs = searchBC.createTmlBkgReceiptEdi(vender301ParamVO, account);
	
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
						}
					}
					
					//vgm edi 보내기
					bkgNtcHisVOs = eBookingReceiptBC.createTerminalVERMASEdi(bkgBlNoVO,"");			
					
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
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
     * 같은 Partial Container 를 가진 Booking 조회.
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @return List<BkgContainerVO>
     * @exception EventException
     */
	public List<BkgContainerVO> searchPtlCntrBkg(String bkgNo, String cntrNo) throws EventException {
        try {
        	return dbDao.searchPtlCntrBkg(bkgNo,cntrNo);  

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
	/**
	 * 같은 Partial Container 를 가진 Booking 의 VGM 정보를 update 한다.<br>
	 * 
	 * @author 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String targetBkgNo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int modifyPtlCntrVgmCopy(String bkgNo, String cntrNo, String targetBkgNo, SignOnUserAccount account) throws EventException {
        try {
        	return dbDao.modifyPtlCntrVgmCopy(bkgNo, cntrNo, targetBkgNo, account);

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
	
    /**
     * VGM을 변경한 이력이잇는지 확인
     * @param List<BkgContainerVO> bkgContainerVOs
     * @return String
     * @throws EventException
     */
    public String searchVgmChgHis(List<BkgContainerVO> bkgContainerVOs) throws EventException {
    	
    	String cntrList = "";
        try {           
        	 for (int i = 0; i < bkgContainerVOs.size(); i++) {
        		 String cntrNo = dbDao.searchVgmChgHis(bkgContainerVOs.get(i));
        		 if(!"N".equals(cntrNo)){
        			 cntrList = cntrList + "'" + cntrNo + "',";
        		 }
        	 }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return cntrList;
    }

    /**
	 * VERMAS 멀티 전송을 위한 리스트 조회 (ESM_BKG_1187)<br>
	 * 
	 * @author 
	 * @param BkgListForTmlVermasEdiInputVO bkgListForTmlVermasEdiInputVO
	 * @return List<BkgListForGeneralTmlVermasEdiVO>
	 * @throws EventException
	 */
	public List<BkgListForGeneralTmlVermasEdiVO> searchBkgListForGeneralTmlVermasEdi(BkgListForTmlVermasEdiInputVO bkgListForTmlVermasEdiInputVO) throws EventException{
		try {
			return dbDao.searchBkgListForGeneralTmlVermasEdi(bkgListForTmlVermasEdiInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
}
