/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptBCImpl.java
*@FileTitle : BKG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgCloseVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SplitMstBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptEAIDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsChgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BdrSpclVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgForCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgForDstSvcRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CargoDetailVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CmdtVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CopySplitBkgEtcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ExportReferencesVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.FwrdRefVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ManualBookingCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OceanRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherCmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherMdtItmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherMrnUcrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherShipVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PolPodVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PrdRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SearchBkgContainerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ValidateOceanRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VvdAssignVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.XterCustOvflwFlgStatusVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgClzTmVO;
import com.clt.syscommon.common.table.BkgCntcPsonVO;
import com.clt.syscommon.common.table.BkgCustomerVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgRollOvrVO;
import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
/**
 * OPUS-GeneralBookingConduct Business Logic Basic Command implementation<br>
 * - OPUS-GeneralBookingConduct business logic handling<br>
 *
 * @see ESM_BKG_0079_01EventResponse,GeneralBookingReceiptBC each DAO Class reference
 * @author KimByungKyu
 * @since J2EE 1.4
 */

public class GeneralBookingReceiptBCImpl extends BasicCommandSupport implements GeneralBookingReceiptBC { 

	// Database Access Object
	private transient GeneralBookingReceiptDBDAO dbDao = null;
	private transient GeneralBookingReceiptEAIDAO eaiDao = null;
	
	/**
	 * GeneralBookingReceiptBCImpl object creation<br>
	 * GeneralBookingReceiptDBDAO creation<br>
	 */
	public GeneralBookingReceiptBCImpl() {
		dbDao = new GeneralBookingReceiptDBDAO();
		eaiDao = new GeneralBookingReceiptEAIDAO();
	}
	/**
	 * modify BkgBooking Data information at BKG_CHG_RT
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 * @exception EventException
	 */
	 public void modifyChgRateBkgBooking(RateMainInfoVO rateMainInfoVO, String caflag)throws EventException{  

		    try {
		    	 dbDao.modifyChgRateBkgBooking(rateMainInfoVO,caflag);

		    	 BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		    	 bkgBlNoVO.setBkgNo(rateMainInfoVO.getBkgNo());
		    	 bkgBlNoVO.setCaFlg(caflag);
		    	 dbDao.modifyCtrtInfo(bkgBlNoVO);
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
			}
	}
	/**
	 * modify BL TYPE handling<br>
	 * save BL TYPE information of booking
	 * @param String bkgNo
	 * @param String blTpCd
	 * @exception EventException
	 */
	public void modifyBlType(String bkgNo ,String blTpCd) throws EventException{   
	    try {	    	
	    	 dbDao.modifyBlType(bkgNo,blTpCd);	    	 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * retrieve event handling<br>
	 * retrieve Purchase Other Number and other number information
	 * @param PoOtherNoVO rPoOtherNoVO
	 * @return PoOtherNoVO
	 * @exception EventException
	 */
	public PoOtherNoVO searchPoOtherNo(PoOtherNoVO rPoOtherNoVO) throws EventException {
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  searchPoOtherNo START ]]<============================");

		PoOtherNoBkgVO poOtherNoBkgVO = rPoOtherNoVO.getIo_poOtherNoBkgVO();

		try {
			if(rPoOtherNoVO.isFirst()){

				// 1. Search byCntr
				List<PoOtherCntrVO> rPoOtherCntrVOs = dbDao.searchPoNoByCntr(poOtherNoBkgVO);
				rPoOtherNoVO.setO_poOtherCntrVOs(rPoOtherCntrVOs);

				if(rPoOtherCntrVOs.size()>0)
					poOtherNoBkgVO.setCntrNo(rPoOtherCntrVOs.get(0).getCCntrNo());

			}
			// 2. Search byBKG
			List<PoOtherNoBkgVO> rPoOtherNoBkgVOs = dbDao.searchPoNoByBkg(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherNoBkgVOs(rPoOtherNoBkgVOs);
			//3.Search byCM
			List<PoOtherCmVO> rPoOtherCmVOs = dbDao.searchPoNoByCm(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherCmVOs(rPoOtherCmVOs);
			//4.Search byShip
			List<PoOtherShipVO> rPoOtherShipVOs = dbDao.searchPoNoByShip(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherShipVOs(rPoOtherShipVOs);
			//5.PO No.��Mandatory Item
			PoOtherMdtItmVO rPoOtherMdtItm = dbDao.searchPoMdtItm(poOtherNoBkgVO);
			rPoOtherNoVO.setO_PoOtherMdtItmVO(rPoOtherMdtItm);
			//6.Search MRN No, UCR No
			List<PoOtherMrnUcrVO> poOtherMrnUcrVO = dbDao.searchMRNNoUCRNoByBkg(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherMrnUcrVOs(poOtherMrnUcrVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  searchPoOtherNo END ]]<============================");

		return rPoOtherNoVO;
	}

	/**
	 * retrieve event handling<br>
	 * retrieve in order to copy CM information to PO & Other No
	 * @param PoOtherNoVO rPoOtherNoVO
	 * @return PoOtherNoVO
	 * @exception EventException
	 */
	public PoOtherNoVO searchCmForPo(PoOtherNoVO rPoOtherNoVO) throws EventException {
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  searchCmForPo START ]]<============================");

		PoOtherNoBkgVO poOtherNoBkgVO = rPoOtherNoVO.getIo_poOtherNoBkgVO();

		try {

			List<PoOtherCmVO> rPoOtherCmVOs = dbDao.searchCmForPo(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherCmVOs(rPoOtherCmVOs);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  searchPoOtherNo END ]]<============================");

		return rPoOtherNoVO;
	}

	/**
	 * multi event handling<br>
	 * save reference no of booking
	 * create and modify only following types of REFERENCE NUMBER<br>
	 *  . EBRF : BKG Ref # (ext bkg rqst).<br>
	 *  . EBSH : BKG SH Ref # (ext bkg rqst).<br>
	 *  . EBFF : BKG FF Ref # (ext bkg rqst).<br>
	 *  . RGBK : Regional BKG No..<br>
	 *  . ESRF : S/I Ref # (ext rqst).<br>
	 *  . ESSH : S/I SH Ref # (ext rqst).<br>
	 *  . ESFF : S/I FF Ref # (ext rqst).<br>
	 *  . FINV : INV Ref # the relationship between exporters and importers<br>
	 *  .<br>
	 * @param PoOtherNoVO   poOtherNoVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRefNo(PoOtherNoVO poOtherNoVO, String caFlg) throws EventException {
		log.debug(">>>[[ GeneralBookingReceiptBCImpl  manageRefNo START ]]<============================");

		try {

			// 01. validation
			BkgReferenceVO[] poOtherNoBkgVOs 	= poOtherNoVO.getI_poOtherNoBkgVOs();
			BkgReferenceVO[]  poOtherCntrVOs 	= poOtherNoVO.getI_poOtherCntrVOs();
			PoOtherNoBkgVO poOtherNoBkgVO 		= poOtherNoVO.getIo_poOtherNoBkgVO();
			SignOnUserAccount account 			= poOtherNoVO.getAccount();

			String bkgNo      	= poOtherNoBkgVO.getBkgNo();
			String cntrNo		= poOtherNoBkgVO.getCntrNo();

			if( poOtherNoBkgVOs != null ){

				int cnt = poOtherNoBkgVOs.length;

				// 02. business logic
				List<BkgReferenceVO> insertVoList = new ArrayList<BkgReferenceVO>();
				List<BkgReferenceVO> updateVoList = new ArrayList<BkgReferenceVO>();
				List<BkgReferenceVO> deleteVoList = new ArrayList<BkgReferenceVO>();

				for(int i = 0; i < cnt; i++) {
					if(poOtherNoBkgVOs[i].getIbflag().equals("I")) {
						if(poOtherNoBkgVOs[i].getCustRefNoCtnt().length()<1||poOtherNoBkgVOs[i].getCustRefNoCtnt()==null){
							continue;
						}
						poOtherNoBkgVOs[i].setBkgNo(bkgNo);
						poOtherNoBkgVOs[i].setCntrNo(cntrNo);
						poOtherNoBkgVOs[i].setCreUsrId(account.getUsr_id());
						poOtherNoBkgVOs[i].setUpdUsrId(account.getUsr_id());
					    insertVoList.add(poOtherNoBkgVOs[i]);
					} else if(poOtherNoBkgVOs[i].getIbflag().equals("U")) {
						poOtherNoBkgVOs[i].setUpdUsrId(account.getUsr_id());
					    updateVoList.add(poOtherNoBkgVOs[i]);
					} else if(poOtherNoBkgVOs[i].getIbflag().equals("D")) {
					    deleteVoList.add(poOtherNoBkgVOs[i]);
					}			
				 }
			    if(insertVoList.size() > 0) {
				dbDao.addBkgReference(insertVoList, caFlg);
			    }
			    if(updateVoList.size() > 0) {
				dbDao.modifyBkgReference(updateVoList, caFlg);
			    }
			    if(deleteVoList.size() > 0) {
				dbDao.removeBkgReference(deleteVoList, caFlg);
			    }
			}

			if( poOtherCntrVOs != null ){
				//int cnt = poOtherCntrVOs.length;

				// 02. start business logic
				List<BkgReferenceVO> insertVoList = new ArrayList<BkgReferenceVO>();
				List<BkgReferenceVO> updateVoList = new ArrayList<BkgReferenceVO>();
				List<BkgReferenceVO> deleteVoList = new ArrayList<BkgReferenceVO>();

				for(int i = 0; i < poOtherCntrVOs.length; i++) {
					if(poOtherCntrVOs[i].getRefSeq().equals("")) {
						poOtherCntrVOs[i].setBkgNo(bkgNo);
						poOtherCntrVOs[i].setBkgRefTpCd("CTPO");// initial value BKG_REF_TP_CD='CTPO'

						poOtherCntrVOs[i].setCreUsrId(account.getUsr_id());
						poOtherCntrVOs[i].setUpdUsrId(account.getUsr_id());

					    insertVoList.add(poOtherCntrVOs[i]);
					} else if(!poOtherCntrVOs[i].getRefSeq().equals("")) {

						poOtherCntrVOs[i].setUpdUsrId(account.getUsr_id());

					    updateVoList.add(poOtherCntrVOs[i]);
					} else if(poOtherCntrVOs[i].getIbflag().equals("D")) {

					    deleteVoList.add(poOtherCntrVOs[i]);
					}
				 }
			    if(insertVoList.size() > 0) {
				dbDao.addBkgReference(insertVoList, caFlg);
			    }
			    if(updateVoList.size() > 0) {
				dbDao.modifyBkgReference(updateVoList, caFlg);
			    }
			    if(deleteVoList.size() > 0) {
				dbDao.removeBkgReference(deleteVoList, caFlg);
			    }
			}
		} catch(DAOException de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  manageRefNo END ]]<============================");
	}

	/**
	 * multi event handling<br>
	 * save reference detail (HP, COSTCO ) information of booking
	 * @param PoOtherNoVO poOtherNoVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRefDetail(PoOtherNoVO poOtherNoVO, String caFlg) throws EventException {
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  manageRefDetail START ]]<============================");

		try {
			// 01. validation
			BkgRefDtlVO[] poOtherCmVO 		= poOtherNoVO.getI_poOtherCmVOs();
			BkgRefDtlVO[] poOtherShipVO 	= poOtherNoVO.getI_poOtherShipVOs();
			PoOtherNoBkgVO poOtherNoBkgVO 	= poOtherNoVO.getIo_poOtherNoBkgVO();
			SignOnUserAccount account 		= poOtherNoVO.getAccount();

			String bkgNo      	= poOtherNoBkgVO.getBkgNo();
			String bkgNoSplit 	= poOtherNoBkgVO.getBkgNoSplit();
			String cntrNo		= poOtherNoBkgVO.getCntrNo();
			// 02. business logic
			if( poOtherCmVO != null ){
				List<BkgRefDtlVO> poOtherCmVOinsertVoList = new ArrayList<BkgRefDtlVO>();
				List<BkgRefDtlVO> poOtherCmVOupdateVoList = new ArrayList<BkgRefDtlVO>();
				List<BkgRefDtlVO> poOtherCmVOdeleteVoList = new ArrayList<BkgRefDtlVO>();
				int poOtherCmCnt = poOtherCmVO.length;
				for(int i = 0; i < poOtherCmCnt; i++) {
					if(poOtherCmVO[i].getRefSeq().equals("")) {
						log.debug("======>>> PO & Other No��CM�뺣낫瑜�Copy�섍린 �꾪빐   ADD:: "+bkgNo+bkgNoSplit);
						poOtherCmVO[i].setIbflag("I");
					}
					if(poOtherCmVO[i].getIbflag().equals("I")) {
						log.debug("======>>> BC	manageRefDetail poOtherCmVO ADD:: "+bkgNo+bkgNoSplit);
						poOtherCmVO[i].setBkgNo(bkgNo);
						poOtherCmVO[i].setBkgNoSplit(bkgNoSplit);
						poOtherCmVO[i].setCntrNo(cntrNo);

						poOtherCmVO[i].setCreUsrId(account.getUsr_id());
						poOtherCmVO[i].setUpdUsrId(account.getUsr_id());

					    poOtherCmVOinsertVoList.add(poOtherCmVO[i]);
					} else if(poOtherCmVO[i].getIbflag().equals("U")) {
						log.debug("======>>> BC	manageRefDetail poOtherCmVO UPDATE:: "+bkgNo+bkgNoSplit);
						poOtherCmVO[i].setBkgNo(bkgNo);
						poOtherCmVO[i].setBkgNoSplit(bkgNoSplit);
						//poOtherCmVO[i].setRefSeq(refSeq);
						poOtherCmVO[i].setUpdUsrId(account.getUsr_id());

					    poOtherCmVOupdateVoList.add(poOtherCmVO[i]);
					} else if(poOtherCmVO[i].getIbflag().equals("D")) {
						log.debug("======>>> BC	manageRefDetail poOtherCmVO DELETE:: "+bkgNo+bkgNoSplit);
						poOtherCmVO[i].setBkgNo(bkgNo);
						poOtherCmVO[i].setBkgNoSplit(bkgNoSplit);

					    poOtherCmVOdeleteVoList.add(poOtherCmVO[i]);
					}
				}
			    if(poOtherCmVOdeleteVoList.size() > 0) {
			    	dbDao.removeBkgRefDtl(poOtherCmVOdeleteVoList, caFlg);
			    }
			    if(poOtherCmVOupdateVoList.size() > 0) {
			    	dbDao.modifyBkgRefDtl(poOtherCmVOupdateVoList, caFlg);
			    }
		    	if(poOtherCmVOinsertVoList.size() > 0) {
		    		dbDao.addBkgRefDtl(poOtherCmVOinsertVoList, caFlg);
			    }
			}

			if( poOtherShipVO != null){
				List<BkgRefDtlVO> poOtherShipVOinsertVoList = new ArrayList<BkgRefDtlVO>();
				List<BkgRefDtlVO> poOtherShipVOupdateVoList = new ArrayList<BkgRefDtlVO>();
				List<BkgRefDtlVO> poOtherShipVOdeleteVoList = new ArrayList<BkgRefDtlVO>();
				int poOtherShipCnt = poOtherShipVO.length;
				for(int i = 0; i < poOtherShipCnt; i++) {
					if(poOtherShipVO[i].getIbflag().equals("I")) {
						log.debug("======>>> BC	manageRefDetail poOtherShipVO ADD:: "+bkgNo+bkgNoSplit);
						poOtherShipVO[i].setBkgNo(bkgNo);
						poOtherShipVO[i].setBkgNoSplit(bkgNoSplit);
						poOtherShipVO[i].setCntrNo(cntrNo);
						poOtherShipVO[i].setCreUsrId(account.getUsr_id());
						poOtherShipVO[i].setUpdUsrId(account.getUsr_id());
					    poOtherShipVOinsertVoList.add(poOtherShipVO[i]);
					} else if(poOtherShipVO[i].getIbflag().equals("U")) {
						log.debug("======>>> BC	manageRefDetail poOtherShipVOpoOtherShipVO UPDATE:: "+bkgNo+bkgNoSplit);
						poOtherShipVO[i].setBkgNo(bkgNo);
						poOtherShipVO[i].setBkgNoSplit(bkgNoSplit);
						poOtherShipVO[i].setUpdUsrId(account.getUsr_id());
					    poOtherShipVOupdateVoList.add(poOtherShipVO[i]);
					} else if(poOtherShipVO[i].getIbflag().equals("D")) {
						log.debug("======>>> BC	manageRefDetail poOtherShipVO DELETE:: "+bkgNo+bkgNoSplit);
						poOtherShipVO[i].setBkgNo(bkgNo);
						poOtherShipVO[i].setBkgNoSplit(bkgNoSplit);
					    poOtherShipVOdeleteVoList.add(poOtherShipVO[i]);
					}
				}
			    if(poOtherShipVOdeleteVoList.size() > 0) {
			    	dbDao.removeBkgRefDtl(poOtherShipVOdeleteVoList, caFlg);
			    }
			    if(poOtherShipVOupdateVoList.size() > 0) {
			    	dbDao.modifyBkgRefDtl(poOtherShipVOupdateVoList, caFlg);
			    }
		    	if(poOtherShipVOinsertVoList.size() > 0) {
		    		dbDao.addBkgRefDtl(poOtherShipVOinsertVoList, caFlg);
			    }
			}
		} catch(DAOException de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  manageRefDetail END ]]<============================");
	}
	/**
	 * multi event handling<br>
	 * save MRNNo , UCRNo
	 * @param PoOtherNoVO poOtherNoVO
	 * @exception EventException
	 */
	public void manageMRNNoUCRNo(PoOtherNoVO poOtherNoVO) throws EventException{
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  manageMRNNoUCRNo START ]]<============================");

		try {
			BkgRefDtlVO[] poOtherMrnUcrVO	= poOtherNoVO.getI_poOtherMrnUcrVOs();
			SignOnUserAccount account 		= poOtherNoVO.getAccount();
			BkgRefDtlVO   bkgRefVO			= new BkgRefDtlVO();

			// 02. business logic
			if( poOtherMrnUcrVO != null ){
				int poOtherMrnUcrCnt = poOtherMrnUcrVO.length;
				for(int i = 0; i < poOtherMrnUcrCnt; i++) {
					//INSERT
					if(poOtherMrnUcrVO[i].getIbflag().equals("I")){
						dbDao.addMrnUcrNo(poOtherMrnUcrVO[i], account);
					//UPDATE
					}else if(poOtherMrnUcrVO[i].getIbflag().equals("U")){
						dbDao.modifyMrnUcrNo(poOtherMrnUcrVO[i], account);
					//DELETE
					}else if(poOtherMrnUcrVO[i].getIbflag().equals("D")){
						dbDao.removeMrnUcr(poOtherMrnUcrVO[i]);
					}
					if(i==0) bkgRefVO = (BkgRefDtlVO)poOtherMrnUcrVO[i].clone();
				}
				bkgRefVO.setCntrNo("");
				bkgRefVO.setRefNo("");
				//CUST_REF_NO_CTNT 媛믪씠 NULL ���곗씠�곕뒗 ��젣�쒕떎.(遺덊븘�뷀븳 �곗씠��
				dbDao.removeMrnUcr(bkgRefVO);
			}
		} catch(DAOException de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  manageMRNNoUCRNo END ]]<============================");
	}

    /**
     * bkg  cntr_no list retrieve<br>
     * @author 	
     * @param 	BkgBlNoVO bkgBlNoVO
     * @return	List<BkgComboVO>
     * @throws EventException
     */
    public List<BkgComboVO> searchContainerMrnUcr(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchContainerMrnUcr(bkgBlNoVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	/**
	 * manage Reference information<br>
	 * @param BkgReferenceVO[] bkgReferenceVOs
	 * @param SignOnUserAccount account
	 * @param BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void manageRefNo(BkgReferenceVO[] bkgReferenceVOs, SignOnUserAccount account, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			for ( int i=0; i<bkgReferenceVOs.length; i++ ) {
				if ( bkgReferenceVOs[i].getRefSeq() != null && !"".equals(bkgReferenceVOs[i].getRefSeq())){
					bkgReferenceVOs[i].setUpdUsrId(account.getUsr_id());
					bkgReferenceVOs[i].setUpdUsrId(account.getUsr_id());
					if("1".equals(bkgReferenceVOs[i].getCpyDescFlg())){
						bkgReferenceVOs[i].setCpyDescFlg("Y");
					}else{
						bkgReferenceVOs[i].setCpyDescFlg("N");
					}
					dbDao.modifyBkgReference(bkgReferenceVOs[i],bkgBlNoVO);
				}else{
					if(bkgReferenceVOs[i].getCustRefNoCtnt()!=null){
						bkgReferenceVOs[i].setCreUsrId(account.getUsr_id());
						bkgReferenceVOs[i].setUpdUsrId(account.getUsr_id());
						if("1".equals(bkgReferenceVOs[i].getCpyDescFlg())){
							bkgReferenceVOs[i].setCpyDescFlg("Y");
						}else{
							bkgReferenceVOs[i].setCpyDescFlg("N");
						}
						if(!"SAMF".equals(bkgReferenceVOs[i].getBkgRefTpCd()) && dbDao.checkRefTpCd(bkgBlNoVO.getBkgNo(), bkgReferenceVOs[i].getBkgRefTpCd())) {
							throw new EventException((String)new ErrorHandler("BKG02110").getMessage());
						}
						dbDao.addBkgReference(bkgReferenceVOs[i],bkgBlNoVO);
					}
				}
			}
		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 *  manage House B / L corresponding to the SCAC No<br>
	 * @param 	BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs
	 * @param 	SignOnUserAccount account
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
    public void manageNVOFileNumber(BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs, SignOnUserAccount account, BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            List<BkgUsaCstmsFileNoVO> insertVoList = new ArrayList<BkgUsaCstmsFileNoVO>();
            List<BkgUsaCstmsFileNoVO> updateVoList = new ArrayList<BkgUsaCstmsFileNoVO>();
            List<BkgUsaCstmsFileNoVO> deleteVoList = new ArrayList<BkgUsaCstmsFileNoVO>();
            if(bkgUsaCstmsFileNoVOs != null){
                for(int i = 0; i < bkgUsaCstmsFileNoVOs.length; i++) {
                    if(bkgUsaCstmsFileNoVOs[i].getIbflag().equals("I")) {

                    	bkgUsaCstmsFileNoVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());
                    	bkgUsaCstmsFileNoVOs[i].setCreUsrId(account.getUsr_id());
                    	bkgUsaCstmsFileNoVOs[i].setUpdUsrId(account.getUsr_id());

                    	updateVoList.add(bkgUsaCstmsFileNoVOs[i]);

                    } else if(bkgUsaCstmsFileNoVOs[i].getIbflag().equals("U")) {
                    	bkgUsaCstmsFileNoVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());
                    	bkgUsaCstmsFileNoVOs[i].setUpdUsrId(account.getUsr_id());

                        updateVoList.add(bkgUsaCstmsFileNoVOs[i]);
                    } else if(bkgUsaCstmsFileNoVOs[i].getIbflag().equals("D")) {
                    	bkgUsaCstmsFileNoVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());

                        deleteVoList.add(bkgUsaCstmsFileNoVOs[i]);
                    }
                }
                if(deleteVoList.size() > 0) {
                    dbDao.removeNVOFileNo(deleteVoList, bkgBlNoVO);
                }            	
                if(updateVoList.size() > 0) {
                    dbDao.modifyNVOFileNo(updateVoList, bkgBlNoVO);
                }
                //�ъ슜�덊븿 
                if(insertVoList.size() > 0) {
                    dbDao.addNVOFileNo(insertVoList, bkgBlNoVO);
                }
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        }
    }

	/**
	 * Ocean Route retrieve.(ESM_BKG_0092)<br>
	 * @param 	PolPodVvdVO[] polPodVvdVOs
	 * @param   String bkgNo
	 * @return 	OceanRouteVO
	 * @exception EventException
	 */
	public OceanRouteVO searchTsRoute(PolPodVvdVO[] polPodVvdVOs, String bkgNo) throws EventException {
		try {
			OceanRouteVO oceanRouteVO = new OceanRouteVO();
			VslSkdVO vslSkdVO = new VslSkdVO();
			List<VslSkdVO> vslSkdVOs = new ArrayList<VslSkdVO>();
			if(polPodVvdVOs != null && polPodVvdVOs.length > 0){
				// 01. ETA of 1st VVD retrieve
				oceanRouteVO.setN1stEtaDelEtaVO(dbDao.search1stVvdEta(polPodVvdVOs[0], bkgNo));

				// 02. Ocean Route list retrieve
				for(int i = 0 ; i < polPodVvdVOs.length ; i++){
					vslSkdVO = null;
					if(polPodVvdVOs[i].getBkgVvdCd().length()==9){
						vslSkdVO = dbDao.searchLaneEtdEta(polPodVvdVOs[i]);

						if(vslSkdVO == null){
							vslSkdVO = new VslSkdVO();
							vslSkdVO.setSlanCd("");
							vslSkdVO.setPolYdCd("");
							vslSkdVO.setPodYdCd("");
							vslSkdVO.setPolClptIndSeq("");
							vslSkdVO.setPolClptIndSeqList("");
							vslSkdVO.setPodClptIndSeq("");
							vslSkdVO.setPodClptIndSeqList("");
							vslSkdVO.setEta("");
							vslSkdVO.setEtaDay("");
							vslSkdVO.setEtaTime("");
							vslSkdVO.setEtd("");
							vslSkdVO.setEtdDay("");
							vslSkdVO.setEtdTime("");
							
							if(polPodVvdVOs[i].getPolYdCd()!=null && polPodVvdVOs[i].getPolYdCd().length()==2
									&& polPodVvdVOs[i].getPodYdCd()!=null && polPodVvdVOs[i].getPodYdCd().length()==2){
									
								polPodVvdVOs[i].setPolClptIndSeq("");
								polPodVvdVOs[i].setPodClptIndSeq("");
								
								VslSkdVO vslSkdVO2 = dbDao.searchLaneEtdEta(polPodVvdVOs[i]);
								if(vslSkdVO2 != null){
									vslSkdVO.setSlanCd(vslSkdVO2.getSlanCd());
									vslSkdVO.setPolYdCd(vslSkdVO2.getPolYdCd());
									vslSkdVO.setPodYdCd(vslSkdVO2.getPodYdCd());
									vslSkdVO.setPolClptIndSeqList(vslSkdVO2.getPolClptIndSeqList());
									vslSkdVO.setPodClptIndSeqList(vslSkdVO2.getPodClptIndSeqList());
								}
							}
						}
					}
					if(vslSkdVO == null){
						vslSkdVO = new VslSkdVO();
						vslSkdVO.setSlanCd("");

						if(polPodVvdVOs[i].getPolYdCd()!=null && polPodVvdVOs[i].getPolYdCd().length()==2){
							vslSkdVO.setPolYdCd(polPodVvdVOs[i].getPolYdCd());							
						} else {
							vslSkdVO.setPolYdCd("");
						}
						if(polPodVvdVOs[i].getPodYdCd()!=null && polPodVvdVOs[i].getPodYdCd().length()==2){
							vslSkdVO.setPodYdCd(polPodVvdVOs[i].getPodYdCd());							
						} else {
							vslSkdVO.setPodYdCd("");
						}
						vslSkdVO.setPolClptIndSeq("");
						vslSkdVO.setPolClptIndSeqList("");
						vslSkdVO.setPodClptIndSeq("");
						vslSkdVO.setPodClptIndSeqList("");
						vslSkdVO.setEta("");
						vslSkdVO.setEtaDay("");
						vslSkdVO.setEtaTime("");
						vslSkdVO.setEtd("");
						vslSkdVO.setEtdDay("");
						vslSkdVO.setEtdTime("");
					}
					
					vslSkdVO.setPolCd   (polPodVvdVOs[i].getPolCd());
					vslSkdVO.setPodCd   (polPodVvdVOs[i].getPodCd());
					vslSkdVO.setBkgVvdCd(polPodVvdVOs[i].getBkgVvdCd());
					
					vslSkdVOs.add(vslSkdVO); 					
				}
				if(vslSkdVOs.size()==0){
					for(int i = 0 ; i < polPodVvdVOs.length ; i++){
						vslSkdVO = new VslSkdVO();
						vslSkdVO.setPolCd   (polPodVvdVOs[i].getPolCd());
						vslSkdVO.setPolYdCd (polPodVvdVOs[i].getPolYdCd());
						vslSkdVO.setPodCd   (polPodVvdVOs[i].getPodCd());
						vslSkdVO.setPodYdCd (polPodVvdVOs[i].getPodYdCd());
						vslSkdVO.setBkgVvdCd(polPodVvdVOs[i].getBkgVvdCd());
						vslSkdVOs.add(vslSkdVO);
					}
				}
				oceanRouteVO.setVslSkd(vslSkdVOs);
			}else{
				oceanRouteVO.setVslSkdVO(vslSkdVO);
				oceanRouteVO.setVslSkd(vslSkdVOs);
			}

			return oceanRouteVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
	}

	/**
	 * Ocean Route Lane/POL ETD/POD ETA retrieve.(ESM_BKG_0092)<br>
	 * @param 	PolPodVvdVO polPodVvdVO
	 * @return 	VslSkdVO
	 * @exception EventException
	 */
	public VslSkdVO searchLaneEtaEtd(PolPodVvdVO polPodVvdVO) throws EventException {
		try {
			VslSkdVO vslSkdVO = new VslSkdVO();
			vslSkdVO = dbDao.searchLaneEtdEta(polPodVvdVO);
			
			if(vslSkdVO == null){
				vslSkdVO = new VslSkdVO();
				vslSkdVO.setSlanCd("");
				vslSkdVO.setPolYdCd("");
				vslSkdVO.setPodYdCd("");
				vslSkdVO.setPolClptIndSeq("");
				vslSkdVO.setPolClptIndSeqList("");
				vslSkdVO.setPodClptIndSeq("");
				vslSkdVO.setPodClptIndSeqList("");
				vslSkdVO.setEta("");
				vslSkdVO.setEtaDay("");
				vslSkdVO.setEtaTime("");
				vslSkdVO.setEtd("");
				vslSkdVO.setEtdDay("");
				vslSkdVO.setEtdTime("");
				
				if(polPodVvdVO.getPolYdCd()!=null && polPodVvdVO.getPolYdCd().length()==2
						&& polPodVvdVO.getPodYdCd()!=null && polPodVvdVO.getPodYdCd().length()==2){
						
					polPodVvdVO.setPolClptIndSeq("");
					polPodVvdVO.setPodClptIndSeq("");
					
					VslSkdVO vslSkdVO2 = dbDao.searchLaneEtdEta(polPodVvdVO);
					if(vslSkdVO2 != null){
						vslSkdVO.setSlanCd(vslSkdVO2.getSlanCd());
						vslSkdVO.setPolYdCd(vslSkdVO2.getPolYdCd());
						vslSkdVO.setPodYdCd(vslSkdVO2.getPodYdCd());
						vslSkdVO.setPolClptIndSeqList(vslSkdVO2.getPolClptIndSeqList());
						vslSkdVO.setPodClptIndSeqList(vslSkdVO2.getPodClptIndSeqList());
					}
				}
			}

			vslSkdVO.setPolCd   (polPodVvdVO.getPolCd());
			vslSkdVO.setPodCd   (polPodVvdVO.getPodCd());
			vslSkdVO.setBkgVvdCd(polPodVvdVO.getBkgVvdCd());
			
			return vslSkdVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
	}
	
	/**
	 * Ocean Route Lane/POL ETD/POD ETA retrieve.(ESM_BKG_0092)<br>
	 * @param 	PolPodVvdVO[] polPodVvdVOs
	 * @exception EventException
	 */
	public void validateTsRoute(PolPodVvdVO[] polPodVvdVOs) throws EventException {
		try {
			BookingUtil util = new BookingUtil();

			if(polPodVvdVOs != null && polPodVvdVOs.length > 0){
				String vslCd = "";
				String voyNo = "";
				String dirCd = "";
				//String bkgVvdCd = "";
				PolPodVvdVO polPodVvdVO = null;
//				SearchLocationCodeVO searchLocationCodeVO = 	null;
				VskVslPortSkdVO vskVslPortSkdVO = new VskVslPortSkdVO();

				String curPodCd = "";
				String befPodCd = "";
				String befBkgVvdCd = "";
				String curBkgVvdCd = "";
				String curPolCd = "";
				String podClptIndSeq = "";
				String polClptIndSeq = "";
				String etdDt = "";
				String etaDt = "";
//				String befEtaDt = "";
				String befEtdDt = "";
				
				PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
				
				for(int i = 0 ; i < polPodVvdVOs.length ; i++){
					polPodVvdVO = polPodVvdVOs[i];

					curPodCd = polPodVvdVO.getPodCd();
					curPolCd = polPodVvdVO.getPolCd();
					podClptIndSeq = polPodVvdVO.getPodClptIndSeq();
					polClptIndSeq = polPodVvdVO.getPolClptIndSeq();
					curBkgVvdCd = polPodVvdVO.getBkgVvdCd();
					
					if(curPolCd.length()<1) continue;
					
					if(i > 0 && i < polPodVvdVOs.length){
						if(!curPolCd.equals(befPodCd)){
							if(!dbDao.searchTSRouteForEqualPort(curPolCd, befPodCd)){
								throw new EventException((String)new ErrorHandler("BKG01038").getMessage());
							}
						}
					}
					
//					searchLocationCodeVO = utilBC.searchLocationCode(curPolCd);
//					if(searchLocationCodeVO == null || "N".equals(searchLocationCodeVO.getPortInlndCd())){
//						throw new EventException((String)new ErrorHandler("BKG00138").getMessage());
//					}
//					searchLocationCodeVO = utilBC.searchLocationCode(curPodCd);
//					if(searchLocationCodeVO == null || "N".equals(searchLocationCodeVO.getPortInlndCd())){
//						throw new EventException((String)new ErrorHandler("BKG00138").getMessage());
//					}

					//bkgVvdCd = polPodVvdVO.getBkgVvdCd();
					if(isCheckVvdCd(curBkgVvdCd) && curBkgVvdCd.length()==9){
						vslCd = curBkgVvdCd.substring(0,4);
						voyNo = curBkgVvdCd.substring(4,8);
						dirCd = curBkgVvdCd.substring(8,9);

//						if(!utilBC.validateVvd(vslCd, voyNo, dirCd)){
//							throw new EventException((String)new ErrorHandler("BKG00144").getMessage());
//						}
//
//
//						if(!utilBC.searchSvcLaneByLoc(polPodVvdVO.getSlanCd(), curPodCd)){
//							throw new EventException((String)new ErrorHandler("BKG00140",new String[]{polPodVvdVO.getSlanCd()}).getMessage());
//						}
//
//
//						if(!utilBC.validateVvdLoc(vslCd, voyNo, dirCd, curPodCd)){
//							throw new EventException((String)new ErrorHandler("BKG00720", new String[]{curBkgVvdCd, curPolCd, curPodCd}).getMessage());
//						}

						vskVslPortSkdVO = util.searchEtbEtdEta(vslCd, voyNo, dirCd, curPolCd, polClptIndSeq);
						if(vskVslPortSkdVO != null){
							etdDt = vskVslPortSkdVO.getVpsEtdDt();
						} else {
							throw new EventException((String)new ErrorHandler("BKG00720", new String[]{curBkgVvdCd, curPolCd, curPodCd}).getMessage());
						}
						
						vskVslPortSkdVO = util.searchEtbEtdEta(vslCd, voyNo, dirCd, curPodCd, podClptIndSeq);
						if(vskVslPortSkdVO != null){
							etaDt = vskVslPortSkdVO.getVpsEtaDt();
						} else {
							throw new EventException((String)new ErrorHandler("BKG00720", new String[]{curBkgVvdCd, curPolCd, curPodCd}).getMessage());
							
						}
						
						if(!"".equals(befBkgVvdCd) &&  isCheckVvdCd(befBkgVvdCd)){
							log.debug("### BefEtd : " + befEtdDt + "/" + "CurEta : " + etaDt);
							if(i > 0){
								if(befEtdDt != null && befEtdDt.length() > 0 && etaDt != null && etaDt.length() > 0){
									if(daysBetweens(befEtdDt, etaDt) >= 0){
										throw new EventException((String)new ErrorHandler("BKG01037").getMessage());
									}
								}else{
									throw new EventException((String)new ErrorHandler("BKG01037").getMessage());
								}							
							}							
						}
					} else {
						vskVslPortSkdVO.setSlanCd("");
					}
					befPodCd = curPodCd;
					befBkgVvdCd = curBkgVvdCd;
//					befEtaDt = etaDt;
					befEtdDt = etdDt;

					if(i==0){
						prdMainInfoVO.setPol(curPolCd);
						prdMainInfoVO.setPol1(curPolCd);
						prdMainInfoVO.setPod1(curPodCd);
						prdMainInfoVO.setPod(curPodCd);		
						if(vskVslPortSkdVO!=null){
							prdMainInfoVO.setLane1(vskVslPortSkdVO.getSlanCd());
						}
					} else if (i==1){
						prdMainInfoVO.setPol2(curPolCd);
						prdMainInfoVO.setPod2(curPodCd);
						prdMainInfoVO.setPod(curPodCd);		
						if(vskVslPortSkdVO!=null){		
							prdMainInfoVO.setLane2(vskVslPortSkdVO.getSlanCd());
						}
					} else if (i==2){
						prdMainInfoVO.setPol3(curPolCd);
						prdMainInfoVO.setPod3(curPodCd);
						prdMainInfoVO.setPod(curPodCd);		
						if(vskVslPortSkdVO!=null){	
							prdMainInfoVO.setLane3(vskVslPortSkdVO.getSlanCd());	
						}
					} else if (i==3){
						prdMainInfoVO.setPol4(curPolCd);
						prdMainInfoVO.setPod4(curPodCd);
						prdMainInfoVO.setPod(curPodCd);		
						if(vskVslPortSkdVO!=null){
							prdMainInfoVO.setLane4(vskVslPortSkdVO.getSlanCd());	
						}
					}
				}
				if(polPodVvdVOs.length<5){
					// ocean route connection validation
					ValidateOceanRouteVO validateOceanRouteVO = dbDao.validateOceanRoute(prdMainInfoVO);
					int routeCount = Integer.parseInt(validateOceanRouteVO.getRoute());
					
					if(routeCount == 0){
						String strErrMsg = prdMainInfoVO.getPol1()+"-"+prdMainInfoVO.getPod1()+"("+prdMainInfoVO.getLane1()+")";
						if(prdMainInfoVO.getPol2()!=null&&prdMainInfoVO.getPol2().length()>0){
							strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol2()+"-"+prdMainInfoVO.getPod2()+"("+prdMainInfoVO.getLane2()+")";
						}
						if(prdMainInfoVO.getPol3()!=null&&prdMainInfoVO.getPol3().length()>0){
							strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol3()+"-"+prdMainInfoVO.getPod3()+"("+prdMainInfoVO.getLane3()+")";
						}
	
						if(prdMainInfoVO.getPol4()!=null&&prdMainInfoVO.getPol4().length()>0){
							strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol4()+"-"+prdMainInfoVO.getPod4()+"("+prdMainInfoVO.getLane4()+")";
						}
						log.debug(strErrMsg);
						throw new EventException((String)new ErrorHandler("BKG02030", new String[]{strErrMsg}).getMessage());
					}
				}
			}else{
				throw new EventException((String)new ErrorHandler("BKG00380").getMessage());
			}
		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
	}
	/**
	 * The difference between two dates.(ESM_BKG_0092)<br>
	 * @param 	String date1
	 * @param 	String date2
	 * @return		long
	 * @exception Exception
	 */
	private long daysBetweens(String date1, String date2)
	{

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
        try
        {
			c1.setTime(sf.parse(date1));
			c2.setTime(sf.parse(date2));

			long result = (long)(c1.getTime().getTime() - c2.getTime().getTime());
			log.debug("result : " + result);
			return result;

		} catch (Exception e) {
        	log.error(e.getMessage(),e);
			return 0;
		}
	}

	/**
	 * modify Tro quantity(ESM_BKG_0079_02A)<br>
	 * @param  BkgQuantityVO[] arrBkgQuantityVO
	 * @param  String boundCd
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgQtyByTro(BkgQuantityVO[] arrBkgQuantityVO, String boundCd, SignOnUserAccount account) throws EventException {
		try {
			for(int i=0; i<arrBkgQuantityVO.length; i++) {
				if(arrBkgQuantityVO[i].getIbflag().equals("U")) {
					dbDao.modifyBkgQtyByTro(arrBkgQuantityVO[i], boundCd, account);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * update to booking information in case of EU tro confirm(ESM_BKG_0079_02C)<br>
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyEurPkupRtnCy(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			dbDao.modifyEurPkupRtnCy(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * BookingCreation user Default information retrieve.(ESM_BKG_0079_01)<br>
	 * @param 	SignOnUserAccount account
	 * @return 	BkgUsrDfltSetVO
	 * @exception 	EventException
	 */
	public BkgUsrDfltSetVO searchUserBkgDefault(SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchUserBkgDefault(account.getUsr_id());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
	}

	/**
	 * retrieve information as BookingCreation CmdtCd .(ESM_BKG_0079_01)<br>
	 * @param 	String cmdtCd
	 * @return 	CmdtVO
	 * @exception EventException
	 */
	public CmdtVO validatePrecaution(String cmdtCd) throws EventException {
		try {
			return dbDao.searchPrecaution(cmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		}
	}

	/**
	 * save cct information<br>
	 * @param  BkgClzTmVO[] bkgClzTmVOs
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCargoClosingTime(BkgClzTmVO[] bkgClzTmVOs,SignOnUserAccount account) throws EventException {
		try {
			//cargo closing time��
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgClzTmVOs[0].getBkgNo());

			dbDao.addCargoClosingTime(bkgBlNoVO, account);
			dbDao.modifyCargoClosingTimeByReplan(bkgBlNoVO, "", "", account);
			//
			
			for ( int i=0; i<bkgClzTmVOs.length; i++ ) {
				if(bkgClzTmVOs[i].getNtcFlg().equals("0")){ //unchecked
					bkgClzTmVOs[i].setNtcFlg("N");
				}else if(bkgClzTmVOs[i].getNtcFlg().equals("1")){
					bkgClzTmVOs[i].setNtcFlg("Y");
				}
				log.debug("mnl dt:"+bkgClzTmVOs[i].getMnlSetDt());
				log.debug("yd:"+bkgClzTmVOs[i].getClzYdCd());				
				
				bkgClzTmVOs[i].setUpdUsrId(account.getUsr_id());
				dbDao.modifyCargoClosingTime(bkgClzTmVOs[i]);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * BookingCreation information retrieve.(ESM_BKG_0079_01)<br>
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	BookingCreationVO
	 * @exception EventException
	 */
	public BookingCreationVO searchBooking(BkgBlNoVO bkgBlNoVO) throws EventException {
		BookingCreationVO bookingCreationVO = null;
		try {
			BkgBlNoVO schBkgBlNoVO = null;
			BkgBookingInfoVO bkgBookingInfoVO = null;
			List<VslSkdVO> vslSkd = null;
			List<BkgQuantityVO> bkgQuantity = null;
			List<BkgQtyDtlVO> bkgQtyDtl = null;
			BlCustomerInfoVO blCustomerInfoVO = null;
			List<BkgCntcPsonVO> bkgCntcPson = null;
			String filerCd = null;
			String vvdFlag = null;
			String rfaAvailable = "Y";
			String scAvailable = "Y";
			String taaAvailable = "Y";
			String rejectFlag = "N";
			SplitMstBlNoVO splitMstBlNo = new SplitMstBlNoVO();

			BookingUtil utilBC = new BookingUtil();			

			// 01. searchBkgBlNoVO
			schBkgBlNoVO = utilBC.searchBkgBlNoVO(bkgBlNoVO);

			if(schBkgBlNoVO != null){
				// 02. searchBkgBookingInfo(Booking information)
				bkgBookingInfoVO = dbDao.searchBkgBookingInfo(schBkgBlNoVO);

				if(bkgBookingInfoVO != null){
					bookingCreationVO = new BookingCreationVO();

					if("P".equals(bkgBookingInfoVO.getBkgCgoTpCd())){
						// You can not retrieve Empty Reposition BKG Data
						throw new EventException((String)new ErrorHandler("BKG00092").getMessage());
//						bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);
					}else{

						// 03. searchVvdSkdForTsRoute.
						vslSkd = dbDao.searchVvdSkdForTsRoute(schBkgBlNoVO);
						// 04. searchBkgQuantity
						bkgQuantity = dbDao.searchBkgQuantity(schBkgBlNoVO);
						// 05. searchBkgQtyDtl
						bkgQtyDtl = dbDao.searchBkgQtyDtl(schBkgBlNoVO);
						// 06. searchBkgCustomer
						blCustomerInfoVO = dbDao.searchBkgCustomer("B", schBkgBlNoVO);
						// 07. searchBkgCntcPson
						bkgCntcPson = dbDao.searchBkgCntcPson(schBkgBlNoVO);
						// 08. searchVslSkdAvailable
						if(dbDao.searchVslSkdAvailable(schBkgBlNoVO)){
							vvdFlag = "Y";
						}else{
							vvdFlag = "N";
						}
						// 09. searchFrob
						filerCd = utilBC.searchFrob(schBkgBlNoVO.getBkgNo(), bkgBookingInfoVO.getBkgTrunkVvd(), bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgPodCd());

						String rfaNo = bkgBookingInfoVO.getRfaNo();
						if(rfaNo != null && rfaNo.length()>0 && !rfaNo.startsWith("DUM")){
							// 10. searchRfaAvailable
							if(!utilBC.searchRfaAvailable(rfaNo, schBkgBlNoVO)){
								rfaAvailable = "N";
							}
						}
						String scNo = bkgBookingInfoVO.getScNo();
						if(scNo != null && scNo.length()>0 && !scNo.startsWith("DUM")){
							// 11. searchScAvailable
							if(!utilBC.searchScAvailable(scNo, schBkgBlNoVO)){
								scAvailable = "N";
							}
						}
						
						String taaNo = bkgBookingInfoVO.getTaaNo();
						if(taaNo != null && taaNo.length()>0 && !taaNo.startsWith("DUM")){
							// 11. searchScAvailable
							if(!utilBC.searchTaaAvailable(taaNo, schBkgBlNoVO)){
								taaAvailable = "N";
							}
						}

						// 12. searchSpclNotApprove
						rejectFlag = dbDao.searchSpclNotApprove(schBkgBlNoVO);

						// 13. searchBkgSplitNo(change)
						// 14. searchSplitMstBlNo
						if(!"Y".equals(schBkgBlNoVO.getCaFlg())){
							splitMstBlNo = utilBC.searchSplitMstBlNo(schBkgBlNoVO.getBkgNo());
						}

						// 2010-07-30 KMJ ADD
						boolean isRatedFlg = dbDao.searchIsRated(bkgBlNoVO);
						String sRatedFlg = "N";
						if (isRatedFlg == true) sRatedFlg = "Y";
						bkgBookingInfoVO.setIsRatedFlg(sRatedFlg);
						
						bkgBookingInfoVO.setVvdFlag(vvdFlag);
						bkgBookingInfoVO.setFilerCd(filerCd);
						bkgBookingInfoVO.setRfaAvailable(rfaAvailable);
						bkgBookingInfoVO.setScAvailable(scAvailable);
						bkgBookingInfoVO.setTaaAvailable(taaAvailable);
						bkgBookingInfoVO.setRejectFlag(rejectFlag);

						bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);
						bookingCreationVO.setVslSkd(vslSkd);
						bookingCreationVO.setBkgQuantity(bkgQuantity);
						bookingCreationVO.setBkgQtyDtl(bkgQtyDtl);
						bookingCreationVO.setBlCustomerInfoVO(blCustomerInfoVO);
						bookingCreationVO.setBkgCntcPson(bkgCntcPson);
						bookingCreationVO.setSplitMstBlNoVO(splitMstBlNo);
						bookingCreationVO.setBkgBlNoVO(schBkgBlNoVO);
					}
				}else{
					// No data found.
					//throw new EventException((String)new ErrorHandler("BKG00095").getMessage());
				}
			}
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return bookingCreationVO;
	}

	/**
	 * whether you should check on VVD
	 * @param 	String vvd
	 * @return  	boolean
	 * @exception Exception
	 */
	private boolean isCheckVvdCd(String vvd){
		boolean isOk = false;
		try{
			if(vvd != null && vvd.length() > 0){
				if(!vvd.startsWith("COXX") && !vvd.startsWith("COYY") && !vvd.startsWith("COZZ")){
					isOk = true;
				}
			}			
		}catch(Exception e){
        	log.error(e.getMessage(),e);
			isOk = false;
		}
		return isOk;
	}
	
	/**
	 * assess the suitability of input values�뗢�. in case of creation / modifications Booking(ESM_BKG_0079_01)<br>
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @return 	BookingCreationVO
	 * @exception 	EventException
	 */
	public BookingCreationVO validateBookingSave(BookingCreationVO bookingCreationVO, SignOnUserAccount account) throws EventException {
		String bkgNo = "";
		try {
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();

			String infoMsg = "";
			if(bkgBookingInfoVO != null){
				bkgNo = bkgBookingInfoVO.getBkgNo();	
				BkgBlNoVO 				bkgBlNoVO 		= bookingCreationVO.getBkgBlNoVO();
				BlCustomerInfoVO 		blCustomerInfoVO= bookingCreationVO.getBlCustomerInfoVO();
				BkgQuantityVO[] 		bkgQuantityVOs 	= bookingCreationVO.getBkgQuantityVOs();
				VslSkdVO[] 				vslSkdVOs 		= bookingCreationVO.getVslSkdVOs();
				BookingSaveValidationVO saveValidationVO= bookingCreationVO.getBookingSaveValidationVO();
				BookingUtil util = new BookingUtil();

				log.debug("bkgNo : [" + bkgBlNoVO.getBkgNo() + "], blNo : ["+bkgBlNoVO.getBlNo() + "], " + 
						  "CaFlg : [" + bkgBlNoVO.getCaFlg() + "], pctl : ["+bkgBlNoVO.getPctlNo()+"]");
				
				if((bkgBookingInfoVO.getBkgTrunkVvd()== null || bkgBookingInfoVO.getBkgPodCd() == null)
					&& (bkgBlNoVO.getPctlNo()== null ||bkgBlNoVO.getPctlNo().length()<20)){
					throw new EventException((String)new ErrorHandler("BKG00658").getMessage());
				}
//				if("Y".equals(bkgBlNoVO.getCaFlg()) && VslSkdVOs.length>4){
//					saveValidationVO.setRouteModifyFlag("N");
//				}
				
				if(!"Over T/S".equals(bkgBlNoVO.getPctlNo()) && "Y".equals(saveValidationVO.getRouteModifyFlag())){
					PrdRouteVO prdRoute = dbDao.searchBkgRouteFromPrd(bkgBlNoVO);
					bkgBookingInfoVO.setBkgPorCd   (prdRoute.getPorCd());
					bkgBookingInfoVO.setBkgPorYdCd (prdRoute.getPorNodCd());
					bkgBookingInfoVO.setBkgPolCd   (prdRoute.getPolCd());
					bkgBookingInfoVO.setBkgPolYdCd (prdRoute.getPolNodCd());
					bkgBookingInfoVO.setBkgPodCd   (prdRoute.getPodCd());
					bkgBookingInfoVO.setBkgPodYdCd (prdRoute.getPodNodCd());
					bkgBookingInfoVO.setBkgDelCd   (prdRoute.getDelCd());	
					bkgBookingInfoVO.setBkgDelYdCd (prdRoute.getDelNodCd());
					bkgBookingInfoVO.setSlanCd     (prdRoute.getTrnkSlanCd());					
					bkgBookingInfoVO.setBkgTrunkVvd    (prdRoute.getVslCd()+prdRoute.getSkdVoyNo()+prdRoute.getSkdDirCd());
					saveValidationVO.setTrunkVvd(prdRoute.getVslCd()+prdRoute.getSkdVoyNo()+prdRoute.getSkdDirCd());
					if(bookingCreationVO.getOldBkgInfoVO() == null){
						saveValidationVO.setChangeFirstVvd(prdRoute.getFirstVvd());
					} else if(!bookingCreationVO.getOldBkgInfoVO().getFirstVvd().equals(prdRoute.getFirstVvd())){
						saveValidationVO.setChangeFirstVvd(prdRoute.getFirstVvd());
					} else {
						saveValidationVO.setChangeFirstVvd("N");
					}
				} else {
					bkgBookingInfoVO.setSlanCd(util.searchSvcLaneByVvd(bkgBookingInfoVO.getBkgTrunkVvd()));
				}
							
				String oldBkgNo = bkgBookingInfoVO.getOldBkgNo();
				String porCd    = bkgBookingInfoVO.getBkgPorCd();
				String porNodCd = (bkgBookingInfoVO.getBkgPorYdCd().length()==2)?(porCd+bkgBookingInfoVO.getBkgPorYdCd()):bkgBookingInfoVO.getBkgPorYdCd();
				String polCd    = bkgBookingInfoVO.getBkgPolCd();
				String podCd    = bkgBookingInfoVO.getBkgPodCd();
				String delCd    = bkgBookingInfoVO.getBkgDelCd();
				String trunkVvd = bkgBookingInfoVO.getBkgTrunkVvd();
				String laneCd   = bkgBookingInfoVO.getSlanCd();		
				
				String newSpclCgoFlag = "N";
				if(oldBkgNo != null && oldBkgNo.length() > 0){
					if("X".equals(util.searchBkgStatusByBkg(bkgBlNoVO))){
						throw new EventException((String)new ErrorHandler("BKG00433").getMessage());
					}
					
					String dgCgoFlg = (bkgBookingInfoVO.getDcgoFlg().length()<1)?"N":bkgBookingInfoVO.getDcgoFlg();
					String rfCgoFlg = (bkgBookingInfoVO.getRcFlg().length()<1)?"N":bkgBookingInfoVO.getRcFlg();
					String akCgoFlg = (bkgBookingInfoVO.getAwkCgoFlg().length()<1)?"N":bkgBookingInfoVO.getAwkCgoFlg();
					String bbCgoFlg = (bkgBookingInfoVO.getBbCgoFlg().length()<1)?"N":bkgBookingInfoVO.getBbCgoFlg();
					if(!bkgBookingInfoVO.getDcgoFlgOld().equals(dgCgoFlg)||
						!bkgBookingInfoVO.getRcFlgOld().equals(rfCgoFlg)||
						!bkgBookingInfoVO.getAwkCgoFlgOld().equals(akCgoFlg)||
						!bkgBookingInfoVO.getBbCgoFlgOld().equals(bbCgoFlg)){
						newSpclCgoFlag = "Y";						
					}		
				}
				
				log.debug("QtyModifyFlag : " + saveValidationVO.getQtyModifyFlag());
				log.debug("RouteModifyFlag : " + saveValidationVO.getRouteModifyFlag());
				log.debug("NewSpclCgoFlag : " + newSpclCgoFlag);
				log.debug("CloseBkgFlag : " + saveValidationVO.getCloseBkgFlag());
				log.debug("CbfBkgFlag : " + saveValidationVO.getCbfBkgFlag());
				
				if("Y".equals(saveValidationVO.getQtyModifyFlag()) 
					|| "Y".equals(saveValidationVO.getRouteModifyFlag()) 
					|| "Y".equals(newSpclCgoFlag)){
					if(!"Y".equals(bkgBlNoVO.getCaFlg())
							&&!"Y".equals(saveValidationVO.getCaNewCreationFlag())
							&&!"Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
						
						BkgCloseVO bkgCloseVO = util.searchBkgClose(bkgBlNoVO, account.getOfc_cd());
						if(bkgCloseVO != null){
							boolean openMail = false;
							String newVvd = (bkgCloseVO.getNewVvd()  != null)?bkgCloseVO.getNewVvd():"";
							String oldVvd = (bkgCloseVO.getPreVvd()  != null)?bkgCloseVO.getPreVvd():"";
							String newPol = (bkgCloseVO.getNewPolCd()!= null)?bkgCloseVO.getNewPolCd():"";
							String oldPol = (bkgCloseVO.getPrePolCd()!= null)?bkgCloseVO.getPrePolCd():"";
							
							if(newVvd.equals(oldVvd)&&newPol.equals(oldPol)){
								if(bkgBlNoVO.getBkgNo() != null){
									List<BkgQuantityVO> oldBkgQuantity = dbDao.searchBkgQuantity(bkgBlNoVO);
									if("Y".equals(newSpclCgoFlag)){
										openMail = true;
									} else {
										openMail = util.isChangeQty(oldBkgQuantity, bkgQuantityVOs);
									}
								}
							}else{
								openMail = true;
							}
							if(openMail){
								bookingCreationVO.getBookingSaveValidationVO().setCloseBkgFlag("Y");
								String[] strParam = new String[11];
								strParam[0] = bkgBlNoVO.getBkgNo();
//								strParam[1] = bkgCloseVO.getPreVvd();
//								strParam[2] = bkgCloseVO.getPrePolCd();
//								strParam[3] = bkgCloseVO.getPrePodCd();
//								strParam[4] = bkgCloseVO.getOldQtyVol();
								strParam[5] = bkgCloseVO.getCntrList();
								strParam[6] = bkgCloseVO.getNewVvd();
								strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd(); 
								strParam[8] = bkgCloseVO.getNewPodCd();
								String newQtyVol = "";
								for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
									if(i > 0){
										newQtyVol = newQtyVol + "," + bkgQuantityVOs[i].getCntrTpszCd() + " X " + bkgQuantityVOs[i].getOpCntrQty();
									}else{
										newQtyVol = newQtyVol + bkgQuantityVOs[i].getCntrTpszCd() + " X " + bkgQuantityVOs[i].getOpCntrQty();
									}
								}								
								strParam[9] = newQtyVol;
								strParam[10] = bkgCloseVO.getNewCntrList();
								
								saveValidationVO.setCloseBkgMsg(util.makeBkgCloseMsg(strParam, "B"));
								saveValidationVO.setChangeFirstVvd(bkgCloseVO.getCloseVvd());
								return bookingCreationVO;							
							}
						}
					}					
				}
				
				if("Y".equals(saveValidationVO.getQtyModifyFlag())
					|| "Y".equals(saveValidationVO.getRouteModifyFlag())
					|| "Y".equals(newSpclCgoFlag)){
					if(!"Y".equals(bkgBlNoVO.getCaFlg())
							&&!"Y".equals(saveValidationVO.getCaNewCreationFlag())
							&&!"Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
						

						boolean isCbfFinal = false;
						BkgCloseVO bkgCloseVO = util.searchBkgCbf(bkgBlNoVO);
						if(bkgCloseVO != null && bkgCloseVO.getNewVvd() != null && !bkgCloseVO.getNewVvd().trim().equals("")){
							String[] arrCBF  = dbDao.searchCBFBS(bkgCloseVO.getNewVvd().substring(0, 4), bkgCloseVO.getNewVvd().substring(4, 8), bkgCloseVO.getNewVvd().substring(8, 9), bkgCloseVO.getNewYdCdSeq());
							for (int i=0;i<arrCBF.length;i++){
								if("Final".equals(arrCBF[i])){
									isCbfFinal = true;
									break;
								}
							}
						
							if(arrCBF != null && isCbfFinal == true){
								boolean openMail = false;
								String newVvd = (bkgCloseVO.getNewVvd()  != null)?bkgCloseVO.getNewVvd():"";
								String oldVvd = (bkgCloseVO.getPreVvd()  != null)?bkgCloseVO.getPreVvd():"";
								String newPol = (bkgCloseVO.getNewPolCd()!= null)?bkgCloseVO.getNewPolCd():"";
								String oldPol = (bkgCloseVO.getPrePolCd()!= null)?bkgCloseVO.getPrePolCd():"";
								
								if(newVvd.equals(oldVvd)&&newPol.equals(oldPol)){
									if(bkgBlNoVO.getBkgNo() != null){
										List<BkgQuantityVO> oldBkgQuantity = dbDao.searchBkgQuantity(bkgBlNoVO);
										if("Y".equals(newSpclCgoFlag)){
											openMail = true;
										} else {
											openMail = util.isChangeQty(oldBkgQuantity, bkgQuantityVOs);
										}
									}
								}else{
									openMail = true;
								}
								if(openMail){
									bookingCreationVO.getBookingSaveValidationVO().setCbfBkgFlag("Y");
									if ( "Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())) {
										saveValidationVO.setCloseBkgFlag("F");
									}
									String[] strParam = new String[11];
									strParam[0] = bkgBlNoVO.getBkgNo();
	//								strParam[1] = bkgCloseVO.getPreVvd();
	//								strParam[2] = bkgCloseVO.getPrePolCd();
	//								strParam[3] = bkgCloseVO.getPrePodCd();
	//								strParam[4] = bkgCloseVO.getOldQtyVol();
									strParam[5] = bkgCloseVO.getCntrList();
									strParam[6] = bkgCloseVO.getNewVvd();
									strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd(); 
									strParam[8] = bkgCloseVO.getNewPodCd();
									String newQtyVol = "";
									for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
										if(i > 0){
											newQtyVol = newQtyVol + "," + bkgQuantityVOs[i].getCntrTpszCd() + " X " + bkgQuantityVOs[i].getOpCntrQty();
										}else{
											newQtyVol = newQtyVol + bkgQuantityVOs[i].getCntrTpszCd() + " X " + bkgQuantityVOs[i].getOpCntrQty();
										}
									}								
									strParam[9] = newQtyVol;
									strParam[10] = bkgCloseVO.getNewCntrList();
									
									saveValidationVO.setCloseBkgMsg(util.makeBkgCloseMsg(strParam, "B"));
									saveValidationVO.setChangeFirstVvd(bkgCloseVO.getCloseVvd());
									return bookingCreationVO;							
								}
							}
						}
					}					
				}
				saveValidationVO.setCloseBkgFlag("N");
				saveValidationVO.setCbfBkgFlag("N");
				
				saveValidationVO.setTrnkLaneCd(laneCd);
				String scNo  = bkgBookingInfoVO.getScNo();
				String rfaNo = bkgBookingInfoVO.getRfaNo();
//				String taaNo = bkgBookingInfoVO.getTaaNo();
				
				if(trunkVvd == null||trunkVvd.length()!=9){					
					throw new EventException((String)new ErrorHandler("BKG00833").getMessage());
				}

				if(isCheckVvdCd(trunkVvd)){
					if(laneCd == null || laneCd.length() < 1){
						throw new EventException((String)new ErrorHandler("BKG01004").getMessage());
					}
				}					
				
				if(bkgBookingInfoVO.getWgtUtCd() == null || bkgBookingInfoVO.getWgtUtCd().length()==0){
					throw new EventException((String)new ErrorHandler("BKG00766").getMessage());					
				}

				if(bkgBookingInfoVO.getActWgt() == null || bkgBookingInfoVO.getActWgt().length()==0){
					throw new EventException((String)new ErrorHandler("BKG00014").getMessage());
				}
				
				if(!"Y".equals(bkgBlNoVO.getCaFlg())){
					if(oldBkgNo == null || oldBkgNo.length() == 0){
						if(dbDao.searchOfcVsPorConti(porCd, account)){
							throw new EventException((String)new ErrorHandler("BKG00025", new String[]{porCd}).getMessage());
						}
					}
				}
				
				//------------------------customer
				if(blCustomerInfoVO.getSCustCntCd()==null || blCustomerInfoVO.getSCustCntCd().trim().length()<1 
						|| blCustomerInfoVO.getSCustSeq()==null || blCustomerInfoVO.getSCustSeq().trim().length()<1){					
					throw new EventException((String)new ErrorHandler("BKG00008").getMessage());
				}
				
				if("Y".equals(saveValidationVO.getCustomerModifyFlag())){
					String bkgCtrlPtyCustCntCd = bkgBookingInfoVO.getBkgCtrlPtyCustCntCd();
					String bkgCtrlPtyCustSeq = bkgBookingInfoVO.getBkgCtrlPtyCustSeq();
					MdmCustVO mdmCustVO = null;
					if(bkgCtrlPtyCustCntCd != null && bkgCtrlPtyCustCntCd.length() > 0){
						mdmCustVO = util.searchMdmCust(bkgCtrlPtyCustCntCd, bkgCtrlPtyCustSeq, "N");
						if("Y".equals(mdmCustVO.getNmdCustFlg())){
							throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getDeltFlg())){
							throw new EventException((String)new ErrorHandler("BKG00076",new String[]{bkgCtrlPtyCustCntCd+bkgCtrlPtyCustSeq}).getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
							throw new EventException((String)new ErrorHandler("BKG02004",new String[]{bkgCtrlPtyCustCntCd+bkgCtrlPtyCustSeq}).getMessage());
						}						
					}
					
					String sCustCntCd = blCustomerInfoVO.getSCustCntCd();
					String sCustSeq = blCustomerInfoVO.getSCustSeq();
										
					if(sCustCntCd != null && sCustCntCd.length() > 0){
						mdmCustVO = util.searchMdmCust(sCustCntCd, sCustSeq, "N");
						if("Y".equals(mdmCustVO.getNmdCustFlg())){
							throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getDeltFlg())){
							throw new EventException((String)new ErrorHandler("BKG00076",new String[]{sCustCntCd+sCustSeq}).getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
							throw new EventException((String)new ErrorHandler("BKG02004",new String[]{sCustCntCd+sCustSeq}).getMessage());
						}						
					}
					String fCustCntCd = blCustomerInfoVO.getFCustCntCd();
					String fCustSeq = blCustomerInfoVO.getFCustSeq();
					if(fCustCntCd != null && fCustCntCd.length() > 0){
						mdmCustVO = util.searchMdmCust(fCustCntCd, fCustSeq, "N");
						if("Y".equals(mdmCustVO.getNmdCustFlg())){
							throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getDeltFlg())){
							throw new EventException((String)new ErrorHandler("BKG00076",new String[]{fCustCntCd+fCustSeq}).getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
							throw new EventException((String)new ErrorHandler("BKG02004",new String[]{fCustCntCd+fCustSeq}).getMessage());
						}			
					}
					String cCustCntCd = blCustomerInfoVO.getCCustCntCd();
					String cCustSeq = blCustomerInfoVO.getCCustSeq();
					if(cCustCntCd != null && cCustCntCd.length() > 0 && cCustSeq.length() > 0){
						mdmCustVO = util.searchMdmCust(cCustCntCd, cCustSeq, "N");
						if("Y".equals(mdmCustVO.getNmdCustFlg())){
							throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getDeltFlg())){					
							throw new EventException((String)new ErrorHandler("BKG00076",new String[]{cCustCntCd+cCustSeq}).getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
							throw new EventException((String)new ErrorHandler("BKG02004",new String[]{cCustCntCd+cCustSeq}).getMessage());
						}			
					}
				}
				
				//------------------------quantity
				if("Y".equals(saveValidationVO.getQtyModifyFlag())){
					String cntrTpSz = "";
					String eqSubCntrTpSz = "";	
					for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
						cntrTpSz = bkgQuantityVOs[i].getCntrTpszCd();
						if(!"Q2".equals(cntrTpSz) && !"Q4".equals(cntrTpSz)){
							if(!dbDao.searchCntrTpSz(cntrTpSz)){
								throw new EventException((String)new ErrorHandler("BKG00062",new String[]{cntrTpSz}).getMessage());
							}
						}
						eqSubCntrTpSz = bkgQuantityVOs[i].getEqSubstCntrTpszCd();
						if(eqSubCntrTpSz != null && !"".equals(eqSubCntrTpSz) && !"Q2".equals(eqSubCntrTpSz) && !"Q4".equals(eqSubCntrTpSz)){
							if(!dbDao.searchCntrTpSz(eqSubCntrTpSz)){
								throw new EventException((String)new ErrorHandler("BKG00062",new String[]{eqSubCntrTpSz}).getMessage());
							}
						}					
					}
				}
				
				String filerCd  = "";
				String filerLoc = "";
				String usaFilerCd = bkgBookingInfoVO.getUsaCstmsFileCd();
				String canadaFilerCd = bkgBookingInfoVO.getCndCstmsFileCd();
				if(isCheckVvdCd(trunkVvd)){
					if(podCd == null || podCd.length()==0){
						filerLoc = delCd;
					} else {
						filerLoc = podCd;
					}
					filerCd = util.searchFrob(bkgNo, trunkVvd, polCd, filerLoc);
					if (("US".equals(delCd.substring(0,2)) && !"CA".equals((podCd!=null && podCd.length()>=2)?podCd.substring(0,2):""))) {
						if("AL".equals(filerCd)||"US".equals(filerCd)){
							if(usaFilerCd == null || usaFilerCd.trim().length() < 1){
								throw new EventException((String)new ErrorHandler("BKG00283").getMessage());
							}
						} 
					}
					if((null != podCd && podCd.startsWith("US")) || ("US".equals(delCd.substring(0,2)) && !"CA".equals((podCd!=null && podCd.length()>=2)?podCd.substring(0,2):"")) ){
						if(usaFilerCd == null || usaFilerCd.trim().length() < 1){
							throw new EventException((String)new ErrorHandler("BKG00283").getMessage());
						}
					}
					if("US".equals(delCd.substring(0,2))){
//						if("US".equals(filerCd)){
							if(scNo != null && scNo.length() > 0 && !scNo.startsWith("DUM")){
								String scType = dbDao.searchScType(scNo, bkgBlNoVO);
								if("I".equals(scType) && ("1".equals(usaFilerCd) || "2".equals(usaFilerCd))){
									throw new EventException((String)new ErrorHandler("BKG00308").getMessage());
								}
								if("N".equals(scType) && "3".equals(usaFilerCd)){
									throw new EventException((String)new ErrorHandler("BKG00308").getMessage());
								}
							}
//						}
					}
					if("AL".equals(filerCd)||"CA".equals(filerCd)){
						if(canadaFilerCd == null || canadaFilerCd.trim().length() < 1){
							throw new EventException((String)new ErrorHandler("BKG00284").getMessage());
						}else{
							if(!"3".equals(canadaFilerCd)){
								infoMsg = infoMsg + ",BKG00285";
//								throw new EventException((String)new ErrorHandler("BKG00285").getMessage());
							}
						}
					} 
					if((null != podCd && podCd.startsWith("CA")) || "CA".equals(delCd.substring(0,2))){
						if(canadaFilerCd == null || canadaFilerCd.trim().length() < 1){
							throw new EventException((String)new ErrorHandler("BKG00284").getMessage());
						}
					}
				}				
				if(!"Y".equals(bkgBlNoVO.getCaFlg())&&"Y".equals(saveValidationVO.getRouteModifyFlag())){
				    String bdrVvd = dbDao.searchBdrLog(bkgBlNoVO.getPctlNo());
				    if("Y".equals(saveValidationVO.getCaNewCreationFlag())){
				    	if(bdrVvd==null || bdrVvd.length()<9){
				    		throw new EventException((String)new ErrorHandler("BKG00071", new String[]{bdrVvd, "not Released"}).getMessage());
				    	}
				    } else {
						if(bdrVvd!=null && bdrVvd.length()>0){
							throw new EventException((String)new ErrorHandler("BKG00071", new String[]{bdrVvd, "already Released"}).getMessage());
						}
				    }
				}
				// Rachel Estes is requested block this logic 
//				if(bkgBookingInfoVO.getCmdtCd()!="" && Integer.parseInt(bkgBookingInfoVO.getCmdtCd()) < 24){
//					if(dbDao.searchCmdtFak(bkgBookingInfoVO.getCmdtCd(), porCd, delCd)){
//						throw new EventException((String)new ErrorHandler("BKG00307").getMessage());
//					}
//				}

				if(oldBkgNo == null || oldBkgNo.length() == 0){
					if("Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
						if(bkgNo.length()==10){
							bkgNo = bkgNo + "00";
							bkgBookingInfoVO.setBkgNo(bkgNo);
							bookingCreationVO.getBkgBlNoVO().setBkgNo(bkgNo);
						}
						String bkgNoPrefix = "";
						if("China".equals(util.searchChnAgtUse(account.getUsr_id()))){
							bkgNoPrefix = bkgBookingInfoVO.getBkgNo().substring(0, 2);

							if(bkgNo.length()==11){
								if(!dbDao.searchChnAgent(bkgBookingInfoVO.getBkgNo())){
									throw new EventException((String)new ErrorHandler("BKG00074", new String[]{bkgBookingInfoVO.getBkgNo()}).getMessage());
								}								
							} else {
								String bkgNoUseFlg = dbDao.searchChnBkgNoExist(bkgBlNoVO);
								if(bkgNoUseFlg==null||bkgNoUseFlg.length()==0){
									if(!bkgNo.substring(9, 12).equals("M00")){
										throw new EventException((String)new ErrorHandler("BKG00255").getMessage());
									}
								} else if(bkgNoUseFlg.equals("Y")){
									throw new EventException((String)new ErrorHandler("BKG00034",new String[]{bkgNo}).getMessage());								
								}
							}
						} else {
							if(bkgNo.length()==12 && !bkgNo.substring(9, 12).equals("M00")){
								bkgNoPrefix = bkgBookingInfoVO.getBkgNo().substring(0, 2);
							} else {
								bkgNoPrefix = bkgBookingInfoVO.getBkgNo().substring(0, 3);
								if(!bkgNo.substring(9, 12).equals("M00")){
									throw new EventException((String)new ErrorHandler("BKG00255").getMessage());
								}
							}
													
						}
						if(!bkgNoPrefix.equals(account.getOfc_cd().substring(0, bkgNoPrefix.length()))){
							throw new EventException((String)new ErrorHandler("BKG00255").getMessage());
						}
						if(bkgNo.substring(bkgNoPrefix.length()+1, bkgNo.length()).indexOf("I")>0 
							|| bkgNo.substring(bkgNoPrefix.length()+1, bkgNo.length()).indexOf("O")>0){
							throw new EventException((String)new ErrorHandler("BKG00255").getMessage());
						}
					}
				}

				if(bkgBookingInfoVO.getOcpCd() != null && bkgBookingInfoVO.getOcpCd().length() > 0){
					String blMoveTpNm = dbDao.searchOcp(bkgBookingInfoVO.getOcpCd());
					if(blMoveTpNm != null && blMoveTpNm.length() > 0){
						saveValidationVO.setBlMoveTpNm(blMoveTpNm);
					}else{
						throw new EventException((String)new ErrorHandler("BKG00042").getMessage());
					}
				}
				
//				if("M".equals(bkgBookingInfoVO.getRcvTermCd()) == false){ 
//					if("D".equals(bkgBookingInfoVO.getRcvTermCd())){
//						if(!dbDao.searchZone(porCd, porYdCd)){
//							throw new EventException((String)new ErrorHandler("BKG00268", new String[]{porYdCd}).getMessage());
//						}
//					}else{
//						if(!dbDao.searchYard(porCd, porYdCd)){
//							throw new EventException((String)new ErrorHandler("BKG00269", new String[]{porYdCd}).getMessage());
//						}
//					}
//				}
//				if("M".equals(bkgBookingInfoVO.getDeTermCd()) == false){
//					if("D".equals(bkgBookingInfoVO.getDeTermCd())){
//						if(!dbDao.searchZone(delCd, delYdCd)){
//							throw new EventException((String)new ErrorHandler("BKG00268", new String[]{delYdCd}).getMessage());
//						}
//					}else{
//						if(!dbDao.searchYard(delCd, delYdCd)){
//							throw new EventException((String)new ErrorHandler("BKG00269", new String[]{delYdCd}).getMessage());
//						}
//					}
//				}
				
				String mtyPkupYdCd = bkgBookingInfoVO.getMtyPkupYdCd();
				if(mtyPkupYdCd != null && mtyPkupYdCd.length() > 5){
					if(!dbDao.searchYard(mtyPkupYdCd.substring(0,5), mtyPkupYdCd)){
						throw new EventException((String)new ErrorHandler("BKG00037").getMessage());
					}
				}
				String fullRtnYdCd = bkgBookingInfoVO.getFullRtnYdCd();
				if(fullRtnYdCd != null && fullRtnYdCd.length() > 5){
					if(!dbDao.searchYard(fullRtnYdCd.substring(0,5), fullRtnYdCd)){
						throw new EventException((String)new ErrorHandler("BKG00075").getMessage());
					}
				}
				if("PHMNL".equals(podCd)){
					if(polCd.startsWith("KR") || polCd.startsWith("JP") || polCd.startsWith("CN")){
						if(vslSkdVOs != null && vslSkdVOs.length > 0){
							String vvdCd = vslSkdVOs[vslSkdVOs.length-1].getBkgVvdCd();
							if(isCheckVvdCd(vvdCd)){
								if("JIX".equals(util.searchSvcLaneByVvd(vvdCd))){
									infoMsg = infoMsg + ",BKG00087";
								}
							}
						}
					}
				}

				if("Y".equals(saveValidationVO.getRouteModifyFlag())){
					if(oldBkgNo == null || oldBkgNo.length() < 11 
							||!bkgBookingInfoVO.getBkgPodCd().equals(podCd)
							||!bkgBookingInfoVO.getBkgDelCd().equals(delCd)){
						if(dbDao.searchLocVsTerm(delCd, bkgBookingInfoVO.getDeTermCd())){
							throw new EventException((String)new ErrorHandler("BKG00020").getMessage());
						}
					}
				}
				
				if(oldBkgNo != null && oldBkgNo.length() > 0){
					boolean isBKG00087Msg = false;
					if(dbDao.searchUsaCstmsDownload(bkgBlNoVO)){
						if(!trunkVvd.equals(bkgBookingInfoVO.getBkgTrunkVvdOld()) 
								||!podCd.equals(bkgBookingInfoVO.getPodCdOld()) 
								||!delCd.equals(bkgBookingInfoVO.getDelCdOld())){
							infoMsg = infoMsg + ",BKG00087";
							isBKG00087Msg = true;
						}
					}
					isBKG00087Msg=true;
					if(isBKG00087Msg && dbDao.searchHblForCarrierFiling(bkgBlNoVO, usaFilerCd, canadaFilerCd, delCd)){
						infoMsg = infoMsg + ",BKG01006";
					}

					if(dbDao.searchIsRated(bkgBlNoVO)){
						String oldRfaNo = bkgBookingInfoVO.getRfaNoOld();
						String oldScNo  = bkgBookingInfoVO.getScNoOld();
						if(oldRfaNo == null) oldRfaNo = "";
						if(rfaNo    == null) rfaNo    = "";
						if(oldScNo  == null) oldScNo  = "";
						if(scNo     == null) scNo     = "";
						if(!rfaNo.equals(oldRfaNo) || !scNo.equals(oldScNo)){
							throw new EventException((String)new ErrorHandler("BKG00082").getMessage());
						}
						if("Y".equals(saveValidationVO.getQtyModifyFlag())){
							infoMsg = infoMsg + ",BKG02065";
						}
					}
					if(!"Y".equals(bkgBlNoVO.getBdrFlg())){
						if(!bkgBookingInfoVO.getPorCdOld().equals(porCd)
								||!bkgBookingInfoVO.getPolCdOld().equals(polCd)
								||!(bkgBookingInfoVO.getPorCdOld()+bkgBookingInfoVO.getPorYdCdOld()).equals(porNodCd)
								||!bkgBookingInfoVO.getRcvTermCdOld().equals(bkgBookingInfoVO.getRcvTermCd())){					
							if("Y".equals(util.searchSoStatus("", "", bkgBlNoVO, "O"))){
								throw new EventException((String)new ErrorHandler("BKG00094").getMessage());								
							}
							
//							if("Y".equals(util.searchCtmSoStatus(bkgBlNoVO))){
//								throw new EventException((String)new ErrorHandler("BKG00094").getMessage());								
//							}
						}
					}
					saveValidationVO.setTroCfrmFlg("N");
					if(!"Y".equals(bkgBlNoVO.getBdrFlg())){
						if(!bkgBookingInfoVO.getPorCdOld().equals(porCd)
								||!(bkgBookingInfoVO.getPorCdOld()+bkgBookingInfoVO.getPorYdCdOld()).equals(porNodCd)
								||!bkgBookingInfoVO.getRcvTermCdOld().equals(bkgBookingInfoVO.getRcvTermCd())){
							if(dbDao.searchTroCfm(bkgBlNoVO)){
								saveValidationVO.setTroCfrmFlg("Y");
							}
						}
					} 
					
//					if("Y".equals(saveValidationVO.getRouteModifyFlag()) && util.searchSpclApplForChange(bkgBlNoVO)){
//						autoSpclReConfirm = "Y";
//					}

					if("Y".equals(saveValidationVO.getRouteModifyFlag())||"Y".equals(saveValidationVO.getCustomerModifyFlag())){
						if(delCd.startsWith("US")){
							// SHPR
							String sCustCntCd = blCustomerInfoVO.getSCustCntCd();
							String sCustSeq = blCustomerInfoVO.getSCustSeq();
							if(sCustCntCd != null && sCustCntCd.length() > 0){
								if(util.searchPoNoLengthByDtl(sCustCntCd, sCustSeq, scNo, bkgBlNoVO)){
									throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
								}
							}
							String fCustCntCd = blCustomerInfoVO.getFCustCntCd();
							String fCustSeq = blCustomerInfoVO.getFCustSeq();
							// FWDR
							if(fCustCntCd != null && fCustCntCd.length() > 0){
								if(util.searchPoNoLengthByDtl(fCustCntCd, fCustSeq, scNo, bkgBlNoVO)){
									throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
								}
							}
							String cCustCntCd = blCustomerInfoVO.getCCustCntCd();
							String cCustSeq = blCustomerInfoVO.getCCustSeq();
							// CNEE
							if(cCustCntCd != null && cCustCntCd.length() > 0){
								if(util.searchPoNoLengthByDtl(cCustCntCd, cCustSeq, scNo, bkgBlNoVO)){
									throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
								}
							}
						}
					}
				}
				
				if("Y".equals(bkgBookingInfoVO.getDcgoFlg()) || "Y".equals(bkgBookingInfoVO.getRcFlg()) 
					|| "Y".equals(bkgBookingInfoVO.getAwkCgoFlg()) || "Y".equals(bkgBookingInfoVO.getBbCgoFlg())){
					saveValidationVO.setSpclCgoFlg("Y");
				}
				saveValidationVO.setSaveMsg(infoMsg);
				
				bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);
				bookingCreationVO.setBookingSaveValidationVO(saveValidationVO);
				
				return bookingCreationVO;		
			}else{
				// �곗씠����옣 �ㅽ뙣
				throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
			}
		} catch (EventException ex) {
			throw ex;								
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			log.error("\nBKG NO : " + bkgNo + "\nerr"+de.toString(),de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * create Booking(ESM_BKG_0079_01)<br>
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @exception EventException
	 */
	public void createBooking(BookingCreationVO bookingCreationVO, SignOnUserAccount account) throws EventException {
		try {
			BkgBlNoVO 				bkgBlNoVO			= bookingCreationVO.getBkgBlNoVO();
			BookingSaveValidationVO saveValidationVO	= bookingCreationVO.getBookingSaveValidationVO();
			BkgBookingInfoVO 		bkgBookingInfoVO 	= bookingCreationVO.getBkgBookingInfoVO();
			BlCustomerInfoVO 		blCustomerInfoVO 	= bookingCreationVO.getBlCustomerInfoVO();
			VslSkdVO[] 				vslSkdVOs			= bookingCreationVO.getVslSkdVOs();
			BkgQuantityVO[] 		bkgQuantityVOs		= bookingCreationVO.getBkgQuantityVOs();
			BkgQtyDtlVO[] 			bkgQtyDtlVOs		= bookingCreationVO.getBkgQtyDtlVOs();			
			BookingUtil				util				= new BookingUtil(); 
			
			if(bkgBookingInfoVO != null){
				String userId = account.getUsr_id();

				if(dbDao.searchBkgBlNoDup(bkgBlNoVO)){
					throw new EventException((String)new ErrorHandler("BKG00034",new String[]{bkgBlNoVO.getBlNo()}).getMessage());
				}

				if(bkgBlNoVO.getBkgNo().length()==11){
					String isExist = util.searchBkgStatusByBkg(bkgBlNoVO);
					if(isExist != null && !"".equals(isExist)){
						throw new EventException((String)new ErrorHandler("BKG00034",new String[]{bkgBlNoVO.getBlNo()}).getMessage());						
					}
				}
				
				if(!CheckUtilities.isNull(blCustomerInfoVO)){
					if((!CheckUtilities.isNull(blCustomerInfoVO.getSCustCntCd())&& !CheckUtilities.isNull(blCustomerInfoVO.getSCustSeq())) 
							&&( !"".equals(blCustomerInfoVO.getSCustCntCd()) && !"".equals(blCustomerInfoVO.getSCustSeq()))){
						searchDmyCustCnt(blCustomerInfoVO.getSCustCntCd(), blCustomerInfoVO.getSCustSeq());
					}
					if((!CheckUtilities.isNull(blCustomerInfoVO.getFCustCntCd()) && !CheckUtilities.isNull(blCustomerInfoVO.getFCustSeq())) 
							&&(!"".equals(blCustomerInfoVO.getFCustCntCd()) && !"".equals(blCustomerInfoVO.getFCustSeq()))){
						searchDmyCustCnt(blCustomerInfoVO.getFCustCntCd(), blCustomerInfoVO.getFCustSeq());
					}
					if((!CheckUtilities.isNull(blCustomerInfoVO.getCCustCntCd()) && !CheckUtilities.isNull(blCustomerInfoVO.getCCustSeq())) 
							&&(!"".equals(blCustomerInfoVO.getCCustCntCd()) && !"".equals(blCustomerInfoVO.getCCustSeq()))){
						searchDmyCustCnt(blCustomerInfoVO.getCCustCntCd(), blCustomerInfoVO.getCCustSeq());
					}
				}
				
				if((!CheckUtilities.isNull(bkgBookingInfoVO.getBkgCtrlPtyCustCntCd()) && !CheckUtilities.isNull(bkgBookingInfoVO.getBkgCtrlPtyCustSeq())) 
						&&(!"".equals(bkgBookingInfoVO.getBkgCtrlPtyCustCntCd()) && !"".equals(bkgBookingInfoVO.getBkgCtrlPtyCustSeq()))){
					searchDmyCustCnt(bkgBookingInfoVO.getBkgCtrlPtyCustCntCd(), bkgBookingInfoVO.getBkgCtrlPtyCustSeq());
				}
				
				dbDao.addBkgBlNoDup(bkgBlNoVO, account.getUsr_id());
				String porCd        = bkgBookingInfoVO.getBkgPorCd();
				String polCd        = bkgBookingInfoVO.getBkgPolCd();
				String podCd 		= bkgBookingInfoVO.getBkgPodCd();
				String delCd 		= bkgBookingInfoVO.getBkgDelCd();
				String preRlyPortCd = bkgBookingInfoVO.getPreRlyPortCd();
				String pstRlyPortCd = bkgBookingInfoVO.getPstRlyPortCd();
				String skdDirCd     = bkgBookingInfoVO.getBkgTrunkVvd().substring(8,9);
				String trnkLaneCd   = saveValidationVO.getTrnkLaneCd();
				
				bkgBookingInfoVO.setBkgTrunkVvd(saveValidationVO.getTrunkVvd());
				bkgBookingInfoVO.setSlanCd(trnkLaneCd);

				String orgTrnsSvcModCd = dbDao.searchOrgSvcRoute(trnkLaneCd, skdDirCd, porCd, polCd, preRlyPortCd);
				bkgBookingInfoVO.setOrgTrnsSvcModCd(orgTrnsSvcModCd);

				String ocpCd = bkgBookingInfoVO.getOcpCd();
				
				String destTrnsSvcModCd = dbDao.searchDstSvcRoute(trnkLaneCd, skdDirCd, podCd, delCd, pstRlyPortCd, ocpCd);
				bkgBookingInfoVO.setDestTrnsSvcModCd(destTrnsSvcModCd);

				String svcScpCd = dbDao.searchSvcScope(trnkLaneCd, porCd, delCd);
				bkgBookingInfoVO.setSvcScpCd(svcScpCd);

				String revDirCd = dbDao.searchFinDir(trnkLaneCd, skdDirCd, polCd);
				bkgBookingInfoVO.setRevDirCd(revDirCd);
				
				bkgBookingInfoVO.setBkgOfcCd(account.getOfc_cd());
				bkgBookingInfoVO.setCreUsrId(userId);
				bkgBookingInfoVO.setUpdUsrId(userId);
				
				if(vslSkdVOs != null && vslSkdVOs.length > 0){
					bkgBookingInfoVO.setFirstPolCd(vslSkdVOs[0].getPolCd());
					bkgBookingInfoVO.setFirstPolClptIndSeq(vslSkdVOs[0].getPolClptIndSeq());
					bkgBookingInfoVO.setFirstVvdCd(vslSkdVOs[0].getBkgVvdCd());
					bkgBookingInfoVO.setLastPodCd(vslSkdVOs[vslSkdVOs.length-1].getPodCd());
					bkgBookingInfoVO.setLastPodClptIndSeq(vslSkdVOs[vslSkdVOs.length-1].getPodClptIndSeq());
					bkgBookingInfoVO.setLastVvdCd(vslSkdVOs[vslSkdVOs.length-1].getBkgVvdCd());
				}
				bkgBookingInfoVO.setPctlNo(bkgBlNoVO.getPctlNo());
				
				dbDao.addBkgBooking(bkgBookingInfoVO);
				if(bkgBlNoVO.getPctlNo() != null && bkgBlNoVO.getPctlNo().length() > 0 && !"FAIL".equals(bkgBlNoVO.getPctlNo().substring(0, 4))){
					dbDao.modifyBkgRouteFromPrd(bkgBlNoVO, "C");
				}
				
				String bsCode = dbDao.searchBlockStowage(bkgBookingInfoVO);
				bkgBookingInfoVO.setBlckStwgCd(bsCode);	
				
				if(bsCode != null){
					dbDao.modifyBookingBlckStwgCd(bkgBookingInfoVO);
				}
				
				String bkgNo = bkgBookingInfoVO.getBkgNo();
				BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
				bkgCustomerVO.setBkgNo(bkgNo);
				bkgCustomerVO.setCreUsrId(userId);
				bkgCustomerVO.setUpdUsrId(userId);

				bkgCustomerVO.setBkgCustTpCd("S");
				bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getSCustCntCd());
				bkgCustomerVO.setCustSeq(blCustomerInfoVO.getSCustSeq());
				bkgCustomerVO.setCustNm(blCustomerInfoVO.getSCustNm());
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				bkgCustomerVO.setBkgCustTpCd("F");
				bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getFCustCntCd());
				bkgCustomerVO.setCustSeq(blCustomerInfoVO.getFCustSeq());
				bkgCustomerVO.setCustNm(blCustomerInfoVO.getFCustNm());
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				bkgCustomerVO.setBkgCustTpCd("C");
				bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getCCustCntCd());
				bkgCustomerVO.setCustSeq(blCustomerInfoVO.getCCustSeq());
				bkgCustomerVO.setCustNm(blCustomerInfoVO.getCCustNm());
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				bkgCustomerVO.setBkgCustTpCd("N");
				bkgCustomerVO.setCustCntCd("");
				bkgCustomerVO.setCustSeq("");
				bkgCustomerVO.setCustNm("");
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				bkgCustomerVO.setBkgCustTpCd("A");
				bkgCustomerVO.setCustCntCd("");
				bkgCustomerVO.setCustSeq("");
				bkgCustomerVO.setCustNm("");
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				bkgCustomerVO.setBkgCustTpCd("E");
				bkgCustomerVO.setCustCntCd("");
				bkgCustomerVO.setCustSeq("");
				bkgCustomerVO.setCustNm("");
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);

				dbDao.modifyCtrtInfo(bkgBlNoVO);
				
				for(int i = 0 ; i < bkgQuantityVOs.length ; i++){					
					BkgQuantityVO bkgQuantityVO = bkgQuantityVOs[i];
					if(0.0 == Float.parseFloat(bkgQuantityVO.getOpCntrQty())){
						continue;
					}
					bkgQuantityVO.setBkgNo(bkgNo);
					bkgQuantityVO.setFlexHgtFlg(bkgBookingInfoVO.getFlexHgtFlg());
					bkgQuantityVO.setCreUsrId(userId);
					bkgQuantityVO.setUpdUsrId(userId);
					dbDao.addBkgQuantity(bkgQuantityVO, bkgBlNoVO);
				}

				if(bkgQtyDtlVOs != null){
					for(int i = 0 ; i < bkgQtyDtlVOs.length ; i++){
						BkgQtyDtlVO bkgQtyDtlVO = bkgQtyDtlVOs[i];
						if(0.0 == Float.parseFloat(bkgQtyDtlVO.getOpCntrQty())){
							continue;
						}
						if("Y".equals(bkgQtyDtlVO.getAwkCgoFlg()) || "1".equals(bkgQtyDtlVO.getAwkCgoFlg())){
							bkgQtyDtlVO.setAwkCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setAwkCgoFlg("N");
						}
						if("Y".equals(bkgQtyDtlVO.getDcgoFlg()) || "1".equals(bkgQtyDtlVO.getDcgoFlg())){
							bkgQtyDtlVO.setDcgoFlg("Y");
						}else{
							bkgQtyDtlVO.setDcgoFlg("N");
						}									
						if("Y".equals(bkgQtyDtlVO.getRcFlg()) || "1".equals(bkgQtyDtlVO.getRcFlg())){
							bkgQtyDtlVO.setRcFlg("Y");
						}else{
							bkgQtyDtlVO.setRcFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getBbCgoFlg()) || "1".equals(bkgQtyDtlVO.getBbCgoFlg())){
							bkgQtyDtlVO.setBbCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setBbCgoFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getSocFlg()) || "1".equals(bkgQtyDtlVO.getSocFlg())){
							bkgQtyDtlVO.setSocFlg("Y");
						}else{
							bkgQtyDtlVO.setSocFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrSglBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrSglBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrDblBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrDblBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrTplBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrTplBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getDryCgoFlg()) || "1".equals(bkgQtyDtlVO.getDryCgoFlg())){
							bkgQtyDtlVO.setDryCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setDryCgoFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getMerHngrFlg()) || "1".equals(bkgQtyDtlVO.getMerHngrFlg())){
							bkgQtyDtlVO.setMerHngrFlg("Y");
						}else{
							bkgQtyDtlVO.setMerHngrFlg("N");
						}								
						bkgQtyDtlVO.setBkgNo(bkgNo);
						bkgQtyDtlVO.setCreUsrId(userId);
						bkgQtyDtlVO.setUpdUsrId(userId);
						
						dbDao.addBkgQtyDtl(bkgQtyDtlVO, bkgBlNoVO);
					}
				}				
				
				if(bkgBlNoVO.getPctlNo() != null && bkgBlNoVO.getPctlNo().length() > 0 
						&& !"FAIL".equals(bkgBlNoVO.getPctlNo().substring(0, 4))){
					dbDao.addBkgVvdFromPrd(bkgBlNoVO, bkgBookingInfoVO.getBkgTrunkVvd(), account);
				} else {
					if(vslSkdVOs != null && vslSkdVOs.length > 0){
						for(int i = 0 ; i < vslSkdVOs.length ; i++){
							VslSkdVO vslSkdVO =  vslSkdVOs[i];
							BkgVvdVO bkgVvdVO = new BkgVvdVO();
							bkgVvdVO.setBkgNo(bkgNo);
							bkgVvdVO.setVslPrePstCd(vslSkdVO.getVslPrePstCd());
							bkgVvdVO.setVslSeq(vslSkdVO.getVslSeq());
							if(vslSkdVO.getBkgVvdCd() != null && vslSkdVO.getBkgVvdCd().length() == 9){
								bkgVvdVO.setVslCd(vslSkdVO.getBkgVvdCd().substring(0,4));
								bkgVvdVO.setSkdVoyNo(vslSkdVO.getBkgVvdCd().substring(4,8));
								bkgVvdVO.setSkdDirCd(vslSkdVO.getBkgVvdCd().substring(8,9));
							}
							bkgVvdVO.setPolClptIndSeq(vslSkdVO.getPolClptIndSeq());
							bkgVvdVO.setPodClptIndSeq(vslSkdVO.getPodClptIndSeq());
							bkgVvdVO.setPolCd(vslSkdVO.getPolCd());
							if(vslSkdVO.getPolYdCd() != null && vslSkdVO.getPolYdCd().length() > 0){
								bkgVvdVO.setPolYdCd(vslSkdVO.getPolCd()+vslSkdVO.getPolYdCd());	
							}					
							bkgVvdVO.setPodCd(vslSkdVO.getPodCd());
							if(vslSkdVO.getPodYdCd() != null && vslSkdVO.getPodYdCd().length() > 0){
								bkgVvdVO.setPodYdCd(vslSkdVO.getPodCd()+vslSkdVO.getPodYdCd());	
							}									
							bkgVvdVO.setCreUsrId(userId);
							bkgVvdVO.setUpdUsrId(userId);
		
							dbDao.addBkgVvd(bkgVvdVO, bkgBlNoVO);
						}
					}
				}

				//------------------------contract
				String scNo  = bkgBookingInfoVO.getScNo();
				String rfaNo = bkgBookingInfoVO.getRfaNo();
				String taaNo = bkgBookingInfoVO.getTaaNo();
				// 01. searchScAvailable
				if(scNo != null && scNo.trim().length() > 0 && !scNo.startsWith("DUM")){
					if(!util.searchScAvailable(scNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"S/C"}).getMessage());
					}
				}
				// 02. searchRfaAvailable
				if(rfaNo != null && rfaNo.trim().length() > 0	 && !rfaNo.startsWith("DUM")){
					if(!util.searchRfaAvailable(rfaNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"RFA"}).getMessage());
					}
				}
				// 02. searchTaaAvailable
				if(taaNo != null && taaNo.trim().length() > 0	 && !taaNo.startsWith("DUM")){
					if(!util.searchTaaAvailable(taaNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"TAA"}).getMessage());
					}
				}
				
				BkgCntcPsonVO bkgCntcPsonVO = new BkgCntcPsonVO();
				bkgCntcPsonVO.setBkgNo(bkgNo);
				bkgCntcPsonVO.setCreUsrId(userId);
				bkgCntcPsonVO.setUpdUsrId(userId);
					// 12-01. BK
					bkgCntcPsonVO.setBkgCntcPsonTpCd("BK");
					bkgCntcPsonVO.setCntcPsonNm(bkgBookingInfoVO.getBkgCntcPsonNm());
					bkgCntcPsonVO.setCntcPsonEml(bkgBookingInfoVO.getBkgCntcPsonEml());
					bkgCntcPsonVO.setCntcPsonFaxNo(bkgBookingInfoVO.getBkgCntcPsonFaxNo());
					bkgCntcPsonVO.setCntcPsonMphnNo(bkgBookingInfoVO.getBkgCntcPsonMphnNo());
					bkgCntcPsonVO.setCntcPsonPhnNo(bkgBookingInfoVO.getBkgCntcPsonPhnNo());
					dbDao.addBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO);
					// 12-02. SI
					bkgCntcPsonVO.setBkgCntcPsonTpCd("SI");
					bkgCntcPsonVO.setCntcPsonNm(bkgBookingInfoVO.getSiCntcPsonNm());
					bkgCntcPsonVO.setCntcPsonEml(bkgBookingInfoVO.getSiCntcPsonEml());
					bkgCntcPsonVO.setCntcPsonFaxNo(bkgBookingInfoVO.getSiCntcPsonFaxNo());
					bkgCntcPsonVO.setCntcPsonMphnNo(bkgBookingInfoVO.getSiCntcPsonMphnNo());
					bkgCntcPsonVO.setCntcPsonPhnNo(bkgBookingInfoVO.getSiCntcPsonPhnNo());
					dbDao.addBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO);

				if("Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
					dbDao.modifyCntcEmailFromAgent(bkgNo);
				}

				dbDao.addBkgRollOvr(bkgBlNoVO, account);
				if(bkgBookingInfoVO.getFmcNo()!=null && bkgBookingInfoVO.getFmcNo().length()>1){
					BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
					bkgReferenceVO.setBkgNo(bkgNo);
					bkgReferenceVO.setBkgRefTpCd("FMCN");
					bkgReferenceVO.setCpyDescFlg("N");
					bkgReferenceVO.setCustRefNoCtnt(bkgBookingInfoVO.getFmcNo());
					bkgReferenceVO.setUpdUsrId(account.getUsr_id());
					bkgReferenceVO.setCreUsrId(account.getUsr_id());
					
					List<BkgReferenceVO> bkgReferenceVOs = new ArrayList<BkgReferenceVO>();
					bkgReferenceVOs.add(bkgReferenceVO);
					dbDao.addBkgReference(bkgReferenceVOs, bkgBlNoVO.getCaFlg());
				}

				String missingMsg = dbDao.searchMissingData(bkgBookingInfoVO, saveValidationVO);
				if(!"".equals(missingMsg) || missingMsg.length()>0){
					if("TRO volume".equals(missingMsg)){
						throw new EventException((String)new ErrorHandler("BKG02057").getMessage());
					} else {
						throw new EventException((String)new ErrorHandler("BKG06014", new String[]{missingMsg}).getMessage());
					}
				}
			}else{
				throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
			}
		} catch (EventException ex) {
			throw ex;							
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * retrieve Booking information before modification(ESM_BKG_0079_01)<br>
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	OldBkgInfoVO
	 * @exception 	EventException
	 */
    public OldBkgInfoVO searchOldBkgInfo(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchOldBkgInfo(bkgBlNoVO);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

	/**
	 * modify Booking(ESM_BKG_0079_01)<br>
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @return		BookingSaveValidationVO
	 * @exception 	EventException
	 */
	@SuppressWarnings("unchecked")
	public BookingSaveValidationVO modifyBooking(BookingCreationVO bookingCreationVO, SignOnUserAccount account) throws EventException {
		try {
			BkgBlNoVO 		 		bkgBlNoVO 		  	= bookingCreationVO.getBkgBlNoVO();
			BookingSaveValidationVO	saveValidationVO 	= bookingCreationVO.getBookingSaveValidationVO();
			BkgBookingInfoVO 		bkgBookingInfoVO 	= bookingCreationVO.getBkgBookingInfoVO();
			VslSkdVO[] 				vslSkdVOs 			= bookingCreationVO.getVslSkdVOs();
			BlCustomerInfoVO 		blCustomerInfoVO 	= bookingCreationVO.getBlCustomerInfoVO();
			BkgQuantityVO[] 		bkgQuantityVOs 		= bookingCreationVO.getBkgQuantityVOs();
			BkgQtyDtlVO[] 			bkgQtyDtlVOs 		= bookingCreationVO.getBkgQtyDtlVOs();
			OldBkgInfoVO 			oldBkgInfoVO 		= bookingCreationVO.getOldBkgInfoVO();
			BookingUtil				util				= new BookingUtil();
			
			if(bkgBookingInfoVO != null){				
				String userId = account.getUsr_id();
				String bkgNo = bkgBookingInfoVO.getBkgNo();
				bkgBookingInfoVO.setCreUsrId(userId);
				bkgBookingInfoVO.setUpdUsrId(userId);
				
				if(!CheckUtilities.isNull(blCustomerInfoVO)){
					if((!CheckUtilities.isNull(blCustomerInfoVO.getSCustCntCd())&& !CheckUtilities.isNull(blCustomerInfoVO.getSCustSeq())) 
							&&( !"".equals(blCustomerInfoVO.getSCustCntCd()) && !"".equals(blCustomerInfoVO.getSCustSeq()))){
						searchDmyCustCnt(blCustomerInfoVO.getSCustCntCd(), blCustomerInfoVO.getSCustSeq());
					}
					if((!CheckUtilities.isNull(blCustomerInfoVO.getFCustCntCd()) && !CheckUtilities.isNull(blCustomerInfoVO.getFCustSeq())) 
							&&(!"".equals(blCustomerInfoVO.getFCustCntCd()) && !"".equals(blCustomerInfoVO.getFCustSeq()))){
						searchDmyCustCnt(blCustomerInfoVO.getFCustCntCd(), blCustomerInfoVO.getFCustSeq());
					}
					if((!CheckUtilities.isNull(blCustomerInfoVO.getCCustCntCd()) && !CheckUtilities.isNull(blCustomerInfoVO.getCCustSeq())) 
							&&(!"".equals(blCustomerInfoVO.getCCustCntCd()) && !"".equals(blCustomerInfoVO.getCCustSeq()))){
						searchDmyCustCnt(blCustomerInfoVO.getCCustCntCd(), blCustomerInfoVO.getCCustSeq());
					}
				}
				
				if((!CheckUtilities.isNull(bkgBookingInfoVO.getBkgCtrlPtyCustCntCd()) && !CheckUtilities.isNull(bkgBookingInfoVO.getBkgCtrlPtyCustSeq())) 
						&&(!"".equals(bkgBookingInfoVO.getBkgCtrlPtyCustCntCd()) && !"".equals(bkgBookingInfoVO.getBkgCtrlPtyCustSeq()))){
					searchDmyCustCnt(bkgBookingInfoVO.getBkgCtrlPtyCustCntCd(), bkgBookingInfoVO.getBkgCtrlPtyCustSeq());
				}

//				if(dbDao.searchBkgBlNoDup(bkgBlNoVO)){
//					throw new EventException((String)new ErrorHandler("BKG00034",new String[]{bkgBlNoVO.getBlNo()}).getMessage());
//				}
//
				String porCd = bkgBookingInfoVO.getBkgPorCd();
				String polCd = bkgBookingInfoVO.getBkgPolCd();
				String podCd = bkgBookingInfoVO.getBkgPodCd();
				String delCd = bkgBookingInfoVO.getBkgDelCd();
				String preRlyPortCd = bkgBookingInfoVO.getPreRlyPortCd();
				String pstRlyPortCd = bkgBookingInfoVO.getPstRlyPortCd();
				String trnkLaneCd = saveValidationVO.getTrnkLaneCd();
				
				if(bkgBookingInfoVO.getBkgTrunkVvd().length()!=9){
					throw new EventException((String)new ErrorHandler("BKG00658").getMessage());
				}
				String skdDirCd = bkgBookingInfoVO.getBkgTrunkVvd().substring(8,9);
				
				saveValidationVO.setTrunkVvd(bkgBookingInfoVO.getBkgTrunkVvd());				
				bkgBookingInfoVO.setSlanCd(trnkLaneCd);

				bkgBookingInfoVO.setOrgTrnsSvcModCd(dbDao.searchOrgSvcRoute(trnkLaneCd, skdDirCd, porCd, polCd, preRlyPortCd));

				bkgBookingInfoVO.setDestTrnsSvcModCd(dbDao.searchDstSvcRoute(trnkLaneCd, skdDirCd, podCd, delCd, pstRlyPortCd, bkgBookingInfoVO.getOcpCd()));

				if(!"Y".equals(saveValidationVO.getIsRated())){
					bkgBookingInfoVO.setSvcScpCd(dbDao.searchSvcScope(trnkLaneCd, porCd, delCd));
				}				

				bkgBookingInfoVO.setRevDirCd(dbDao.searchFinDir(trnkLaneCd, skdDirCd, polCd));

				bkgBookingInfoVO.setBlckStwgCd(dbDao.searchBlockStowage(bkgBookingInfoVO));

				if(vslSkdVOs != null && vslSkdVOs.length>0){
					bkgBookingInfoVO.setFirstPolCd(vslSkdVOs[0].getPolCd());
					bkgBookingInfoVO.setFirstPolClptIndSeq(vslSkdVOs[0].getPolClptIndSeq());
					bkgBookingInfoVO.setFirstVvdCd(vslSkdVOs[0].getBkgVvdCd());
					bkgBookingInfoVO.setLastPodCd(vslSkdVOs[vslSkdVOs.length-1].getPodCd());
					bkgBookingInfoVO.setLastPodClptIndSeq(vslSkdVOs[vslSkdVOs.length-1].getPodClptIndSeq());
					bkgBookingInfoVO.setLastVvdCd(vslSkdVOs[vslSkdVOs.length-1].getBkgVvdCd());
				}
				bkgBookingInfoVO.setPctlNo(bkgBlNoVO.getPctlNo());
				OldBkgInfoVO oldBkgInfoForPctlNo = dbDao.searchOldBkgInfo(bkgBlNoVO);
//				if("Y".equals(bkgBlNoVO.getCaFlg()) && vslSkdVOs.length>4){
//					
//				}
				dbDao.modifyBkgBooking(bkgBookingInfoVO, bkgBlNoVO);

				if("Y".equals(saveValidationVO.getRouteModifyFlag())||"Y".equals(saveValidationVO.getQtyModifyFlag())){
					if(bkgBlNoVO.getPctlNo() != null && bkgBlNoVO.getPctlNo().length() > 0 
							&& !"FAIL".equals(bkgBlNoVO.getPctlNo().substring(0, 4))
							&& !"Over T/S".equals(bkgBlNoVO.getPctlNo())){
						dbDao.modifyBkgRouteFromPrd(bkgBlNoVO, "U");
					}
				}
					
				if("Y".equals(saveValidationVO.getCustomerModifyFlag())){
					BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
					bkgCustomerVO.setBkgNo(bkgNo);
					bkgCustomerVO.setCreUsrId(userId);
					bkgCustomerVO.setUpdUsrId(userId);
					
					BlCustomerInfoVO oldBlCustomerInfoVO = dbDao.searchBkgCustomer("B", bkgBlNoVO);				
					boolean shFlag = true;
					String sCustCd = blCustomerInfoVO.getSCustCntCd() + blCustomerInfoVO.getSCustSeq();
					String sCustCdOld = oldBlCustomerInfoVO.getSCustCntCd() + oldBlCustomerInfoVO.getSCustSeq();
					
					if(sCustCd != null && sCustCd.length() > 0){
						if(sCustCd.equals(sCustCdOld)) shFlag = false;
					} else {
						if(sCustCdOld == null || sCustCdOld.length() < 1) shFlag = false;
					}
										
					if(shFlag){
						bkgCustomerVO.setBkgCustTpCd("S");
						bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getSCustCntCd());
						bkgCustomerVO.setCustSeq(blCustomerInfoVO.getSCustSeq());
						bkgCustomerVO.setCustNm(blCustomerInfoVO.getSCustNm());
						dbDao.modifyBkgCustCode(bkgCustomerVO, bkgBlNoVO, blCustomerInfoVO.getSCustSubstFlg());					
					}
	
					boolean fwFlag = true;
					String fCustCd = blCustomerInfoVO.getFCustCntCd() + blCustomerInfoVO.getFCustSeq();
					String fCustCdOld = oldBlCustomerInfoVO.getFCustCntCd() + oldBlCustomerInfoVO.getFCustSeq();
					
					if(fCustCd != null && fCustCd.length() > 0){
						if(fCustCd.equals(fCustCdOld)) fwFlag = false;
					}else{
						if(fCustCdOld == null || fCustCdOld.length() < 1) fwFlag = false;
					}
	
					if(fwFlag){
						bkgCustomerVO.setBkgCustTpCd("F");
						bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getFCustCntCd());
						bkgCustomerVO.setCustSeq(blCustomerInfoVO.getFCustSeq());
						bkgCustomerVO.setCustNm(blCustomerInfoVO.getFCustNm());
						dbDao.modifyBkgCustCode(bkgCustomerVO, bkgBlNoVO, blCustomerInfoVO.getFCustSubstFlg());				
					}							
	
					boolean cnFlag = true;
					String cCustCd = blCustomerInfoVO.getCCustCntCd() + blCustomerInfoVO.getCCustSeq();
					String cCustCdOld = oldBlCustomerInfoVO.getCCustCntCd() + oldBlCustomerInfoVO.getCCustSeq();
					
					if(cCustCd != null && cCustCd.length() > 0){
						if(cCustCd.equals(cCustCdOld)) cnFlag = false;
					}else{
						if(cCustCdOld == null || cCustCdOld.length() < 1) cnFlag = false;
					}
					if(cnFlag){
						bkgCustomerVO.setBkgCustTpCd("C");
						bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getCCustCntCd());
						bkgCustomerVO.setCustSeq(blCustomerInfoVO.getCCustSeq());
						bkgCustomerVO.setCustNm(blCustomerInfoVO.getCCustNm());
						dbDao.modifyBkgCustCode(bkgCustomerVO, bkgBlNoVO, blCustomerInfoVO.getCCustSubstFlg());				
					}							
				}
				
				if("Y".equals(saveValidationVO.getContactModifyFlag())){
					BkgCntcPsonVO bkgCntcPsonVO = new BkgCntcPsonVO();
					bkgCntcPsonVO.setBkgNo(bkgNo);
					bkgCntcPsonVO.setCreUsrId(userId);
					bkgCntcPsonVO.setUpdUsrId(userId);
					bkgCntcPsonVO.setBkgCntcPsonTpCd("BK");
					bkgCntcPsonVO.setCntcPsonNm(bkgBookingInfoVO.getBkgCntcPsonNm());
					bkgCntcPsonVO.setCntcPsonEml(bkgBookingInfoVO.getBkgCntcPsonEml());
					bkgCntcPsonVO.setCntcPsonFaxNo(bkgBookingInfoVO.getBkgCntcPsonFaxNo());
					bkgCntcPsonVO.setCntcPsonMphnNo(bkgBookingInfoVO.getBkgCntcPsonMphnNo());
					bkgCntcPsonVO.setCntcPsonPhnNo(bkgBookingInfoVO.getBkgCntcPsonPhnNo());
					if(dbDao.modifyBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO) < 1){
						dbDao.addBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO);
					}
					bkgCntcPsonVO.setBkgCntcPsonTpCd("SI");
					bkgCntcPsonVO.setCntcPsonNm(bkgBookingInfoVO.getSiCntcPsonNm());
					bkgCntcPsonVO.setCntcPsonEml(bkgBookingInfoVO.getSiCntcPsonEml());
					bkgCntcPsonVO.setCntcPsonFaxNo(bkgBookingInfoVO.getSiCntcPsonFaxNo());
					bkgCntcPsonVO.setCntcPsonMphnNo(bkgBookingInfoVO.getSiCntcPsonMphnNo());
					bkgCntcPsonVO.setCntcPsonPhnNo(bkgBookingInfoVO.getSiCntcPsonPhnNo());
					if(dbDao.modifyBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO) < 1){
						dbDao.addBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO);
					}					
				}

				if("Y".equals(saveValidationVO.getRouteModifyFlag())||"Y".equals(saveValidationVO.getQtyModifyFlag())){
					if("Y".equals(saveValidationVO.getRouteModifyFlag())){
						List<VslSkdVO> oldVslSkdVOs = dbDao.searchVvdSkdForTsRoute(bkgBlNoVO);
						if(vslSkdVOs!=null){
							if(oldVslSkdVOs.size() != vslSkdVOs.length){
								saveValidationVO.setChangeVvd("Y");
							}else{
								for(int i = 0 ; i < oldVslSkdVOs.size() ; i++){
									if(!oldVslSkdVOs.get(i).getBkgVvdCd().equals(vslSkdVOs[i].getBkgVvdCd())){
										saveValidationVO.setChangeVvd("Y");
										break;
									}
								}
							}
						} else {
							saveValidationVO.setChangeVvd("Y");
						}
					}
						
	
					if(bkgBlNoVO.getPctlNo() != null && bkgBlNoVO.getPctlNo().length() > 0 
							&& !"FAIL".equals(bkgBlNoVO.getPctlNo().substring(0, 4))
							&& !"Over T/S".equals(bkgBlNoVO.getPctlNo())){
						if(!oldBkgInfoForPctlNo.getPctlNo().equals(bkgBlNoVO.getPctlNo())){
							dbDao.removeBkgVvd(bkgBlNoVO);
							dbDao.addBkgVvdFromPrd(bkgBlNoVO, bkgBookingInfoVO.getBkgTrunkVvd(), account);
						}
					} else {				
						dbDao.removeBkgVvd(bkgBlNoVO);
						if(vslSkdVOs!=null){
							for(int i = 0 ; i < vslSkdVOs.length ; i++){	
								BkgVvdVO bkgVvdVO = new BkgVvdVO();
								bkgVvdVO.setBkgNo(bkgNo);
								bkgVvdVO.setVslPrePstCd(vslSkdVOs[i].getVslPrePstCd());
								bkgVvdVO.setVslSeq(vslSkdVOs[i].getVslSeq());
								if(vslSkdVOs[i].getBkgVvdCd() != null && vslSkdVOs[i].getBkgVvdCd().length() == 9){
									bkgVvdVO.setVslCd(vslSkdVOs[i].getBkgVvdCd().substring(0,4));
									bkgVvdVO.setSkdVoyNo(vslSkdVOs[i].getBkgVvdCd().substring(4,8));
									bkgVvdVO.setSkdDirCd(vslSkdVOs[i].getBkgVvdCd().substring(8,9));
								}
								bkgVvdVO.setPolClptIndSeq(vslSkdVOs[i].getPolClptIndSeq());
								bkgVvdVO.setPodClptIndSeq(vslSkdVOs[i].getPodClptIndSeq());
								bkgVvdVO.setPolCd(vslSkdVOs[i].getPolCd());
								if(vslSkdVOs[i].getPolYdCd() != null && vslSkdVOs[i].getPolYdCd().length() > 0){
									bkgVvdVO.setPolYdCd(vslSkdVOs[i].getPolCd()+vslSkdVOs[i].getPolYdCd());	
								}	
								bkgVvdVO.setPodCd(vslSkdVOs[i].getPodCd());
								if(vslSkdVOs[i].getPodYdCd() != null &&vslSkdVOs[i].getPodYdCd().length() > 0){
									bkgVvdVO.setPodYdCd(vslSkdVOs[i].getPodCd()+vslSkdVOs[i].getPodYdCd());	
								}		
								bkgVvdVO.setCreUsrId(userId);
								bkgVvdVO.setUpdUsrId(userId);
								
								dbDao.addBkgVvd(bkgVvdVO, bkgBlNoVO);
							}
						}
					}
				} else {
					saveValidationVO.setChangeVvd("N");
				}

				dbDao.modifyCtrtInfo(bkgBlNoVO);
				
				String scNo  = bkgBookingInfoVO.getScNo();
				String rfaNo = bkgBookingInfoVO.getRfaNo();
				String taaNo = bkgBookingInfoVO.getTaaNo();
				//------------------------contract
				// 01. searchScAvailable
				if(scNo != null && scNo.trim().length() > 0 && !scNo.startsWith("DUM")){
					if(!util.searchScAvailable(scNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"S/C"}).getMessage());
					}
				}
				// 02. searchRfaAvailable
				if(rfaNo != null && rfaNo.trim().length() > 0	 && !rfaNo.startsWith("DUM")){
					if(!util.searchRfaAvailable(rfaNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"RFA"}).getMessage());
					}
				}
				// 02. searchTaaAvailable
				if(taaNo != null && taaNo.trim().length() > 0	 && !taaNo.startsWith("DUM")){
					if(!util.searchTaaAvailable(taaNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"TAA"}).getMessage());
					}
				}
				
				dbDao.removeBkgQtyDtl(bkgBlNoVO, null);				
				if("Y".equals(saveValidationVO.getQtyModifyFlag())){	
					ArrayList<String> cntrTpSzList = new ArrayList();
					for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
						cntrTpSzList.add(bkgQuantityVOs[i].getCntrTpszCd());
					}
					dbDao.removeBkgQuantity(cntrTpSzList, bkgBlNoVO, "BKG");				
					
					for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
						BkgQuantityVO bkgQuantityVO = bkgQuantityVOs[i];
						if(0.0 == Float.parseFloat(bkgQuantityVO.getOpCntrQty())){
							continue;
						}
						bkgQuantityVO.setBkgNo(bkgNo);
						bkgQuantityVO.setFlexHgtFlg(bkgBookingInfoVO.getFlexHgtFlg());
						bkgQuantityVO.setCreUsrId(userId);
						bkgQuantityVO.setUpdUsrId(userId);
						if(dbDao.modifyBkgQuantity(bkgQuantityVO, bkgBlNoVO) == 0){
							dbDao.addBkgQuantity(bkgQuantityVO, bkgBlNoVO);
						}
					}
				}
				if(bkgQtyDtlVOs != null){
					for(int i = 0 ; i < bkgQtyDtlVOs.length ; i++){
						BkgQtyDtlVO bkgQtyDtlVO = bkgQtyDtlVOs[i];
						if(0.0 == Float.parseFloat(bkgQtyDtlVO.getOpCntrQty())){
							continue;
						}
						if("Y".equals(bkgQtyDtlVO.getAwkCgoFlg()) || "1".equals(bkgQtyDtlVO.getAwkCgoFlg())){
							bkgQtyDtlVO.setAwkCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setAwkCgoFlg("N");
						}
						if("Y".equals(bkgQtyDtlVO.getDcgoFlg()) || "1".equals(bkgQtyDtlVO.getDcgoFlg())){
							bkgQtyDtlVO.setDcgoFlg("Y");
						}else{
							bkgQtyDtlVO.setDcgoFlg("N");
						}			
						
						if("Y".equals(bkgQtyDtlVO.getRcFlg()) || "1".equals(bkgQtyDtlVO.getRcFlg())){
							bkgQtyDtlVO.setRcFlg("Y");
						}else{
							bkgQtyDtlVO.setRcFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getBbCgoFlg()) || "1".equals(bkgQtyDtlVO.getBbCgoFlg())){
							bkgQtyDtlVO.setBbCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setBbCgoFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getSocFlg()) || "1".equals(bkgQtyDtlVO.getSocFlg())){
							bkgQtyDtlVO.setSocFlg("Y");
						}else{
							bkgQtyDtlVO.setSocFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrSglBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrSglBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrDblBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrDblBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrTplBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrTplBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getDryCgoFlg()) || "1".equals(bkgQtyDtlVO.getDryCgoFlg())){
							bkgQtyDtlVO.setDryCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setDryCgoFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getMerHngrFlg()) || "1".equals(bkgQtyDtlVO.getMerHngrFlg())){
							bkgQtyDtlVO.setMerHngrFlg("Y");
						}else{
							bkgQtyDtlVO.setMerHngrFlg("N");
						}								
						bkgQtyDtlVO.setBkgNo(bkgNo);
						bkgQtyDtlVO.setCreUsrId(userId);
						bkgQtyDtlVO.setUpdUsrId(userId);
						
						dbDao.addBkgQtyDtl(bkgQtyDtlVO, bkgBlNoVO);
					}
				} 
				
				if("Y".equals(saveValidationVO.getRouteModifyFlag())){
					String befFirstVvd = oldBkgInfoVO.getFirstVvd();
					String newFirstVvd = saveValidationVO.getChangeFirstVvd();
					if(befFirstVvd!=null && newFirstVvd!=null && befFirstVvd.length() ==9 && newFirstVvd.length() == 9){
						if(!befFirstVvd.equals(newFirstVvd)){
							dbDao.modifyBkgRollOvr(bkgBlNoVO, account);
		
							dbDao.addBkgRollOvr(bkgBlNoVO, account);
							saveValidationVO.setChangeFirstVvd("Y");
						}
					}
				}
				if(bkgBookingInfoVO.getFmcNo()!=null && bkgBookingInfoVO.getFmcNo().length()>1){
					BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
					bkgReferenceVO.setBkgNo(bkgNo);
					bkgReferenceVO.setBkgRefTpCd("FMCN");
					bkgReferenceVO.setCpyDescFlg("N");
					bkgReferenceVO.setCustRefNoCtnt(bkgBookingInfoVO.getFmcNo());
					bkgReferenceVO.setUpdUsrId(account.getUsr_id());
					bkgReferenceVO.setCreUsrId(account.getUsr_id());
					
					List<BkgReferenceVO> bkgReferenceVOs = new ArrayList<BkgReferenceVO>();
					bkgReferenceVOs.add(bkgReferenceVO);
					dbDao.addBkgReference(bkgReferenceVOs, bkgBlNoVO.getCaFlg());
				}
				
				String missingMsg = dbDao.searchMissingData(bkgBookingInfoVO, saveValidationVO);
				if(!"".equals(missingMsg) || missingMsg.length()>0){
					if("TRO volume".equals(missingMsg)){
						throw new EventException((String)new ErrorHandler("BKG02057").getMessage());
					} else {
						throw new EventException((String)new ErrorHandler("BKG06014", new String[]{missingMsg}).getMessage());
					}
				}
				
				//oldBkgInfoForPctlNo
				//oldBkgInfoForPctlNo.getPctlNo().equals(bkgBlNoVO.getPctlNo())
				if(   !oldBkgInfoForPctlNo.getPolCd().equals(polCd) 
				    ||!oldBkgInfoForPctlNo.getPodCd().equals(podCd) 
				    ||!oldBkgInfoForPctlNo.getDelCd().equals(delCd)){
					saveValidationVO.setChangeLoc("Y");
				}else{
					saveValidationVO.setChangeLoc("N");
				}
			}else{
				throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
			}
			return saveValidationVO;
		} catch (EventException ex) {
			throw ex;						
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

    /**
     * modify Booking(ESM_BKG_007901)<br>
     * @param 		BkgBookingVO bkgBookingVO
     * @param 		String caFlg
     * @exception 	EventException
     */
    public void modifyBkgByCm(BkgBookingVO bkgBookingVO, String caFlg) throws EventException {
        try {
            dbDao.modifyBkgByCm(bkgBookingVO, caFlg);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

	/**
	 * modify Booking Staut(ESM_BKG_007901)<br>
	 * @param 		String newStsCd
	 * @param 	  	BkgBlNoVO bkgBlNoVO
	 * @param 		boolean validation	  
	 * @param 		SignOnUserAccount account
	 * @return		boolean
	 * @exception 	EventException
	 */
	public boolean changeBkgStatus(String newStsCd, BkgBlNoVO bkgBlNoVO, boolean validation, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();
			String oldBkgStsCd = utilBC.searchBkgStatusByBkg(bkgBlNoVO);
			
			if("S".equals(oldBkgStsCd)||"X".equals(oldBkgStsCd)){
				return false;
			}
			
			if("F".equals(oldBkgStsCd) && "Y".equals(utilBC.searchBdrFlgByBkg(bkgBlNoVO))){
				return false;
			}
			
			boolean isContinue = true;
//			if(newStsCd.equals(oldBkgStsCd)){
//				isContinue = false;
//			}

			boolean isVl = false;
			// 02. searchMVMTStatus
			if(isContinue){
				String[] mvmtStsCd = utilBC.searchMVMTStatus(bkgBlNoVO, null);
				for(int i = 0 ; i < mvmtStsCd.length ; i++){
					if("VL".equals(mvmtStsCd[i])){
						if(validation){
							throw new EventException((String)new ErrorHandler("BKG00317").getMessage());
						}
						isVl = true;
						break;
					}
				}
			}

			if("F".equals(oldBkgStsCd) && isVl){
				isContinue = false;
			}
			
			String spclFlag = "N";
			String pendingFlag = "N";
			if(isContinue){
				spclFlag = dbDao.searchSpclWaitRsn(bkgBlNoVO);
				if(!"Y".equals(spclFlag)){//spcl���놁쓬
					spclFlag = "N";
				} else {
					if(validation && "F".equals(newStsCd)){
						throw new EventException((String)new ErrorHandler("BKG02064").getMessage());
					}
				}

				if("R".equals(newStsCd)){//<-pending release
					pendingFlag = "N";
				}else{
					if("P".equals(newStsCd) || (!"F".equals(newStsCd) && "Y".equals(dbDao.searchUserHold(bkgBlNoVO)))){
						pendingFlag = "Y";
					}					
				}
//				log.debug("\nold pending flag : " + dbDao.searchUserHold(bkgBlNoVO));

				if("N".equals(spclFlag) && "N".equals(pendingFlag)){
					newStsCd = "F";
				}else{
					newStsCd = "W";
				}
				
				if(!isCheckVvdCd(dbDao.searchTrunkVvdByBkg(bkgBlNoVO))){
					newStsCd = "A";
				}
				
				if("X".equals(oldBkgStsCd)){
					newStsCd = "X";
				}
				
				dbDao.modifyBookingStatus(pendingFlag, spclFlag, newStsCd, bkgBlNoVO, account);
				return true;
			} else {
				return false;
			}
		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * update changed Reference No information
	 * @param 		String bkgNo
	 * @param 	  	String cntrNo
	 * @param 		String cntrNoOld
	 * @param 		String caFlg
	 * @exception 	EventException
	 */
    public void changeReferenceByCntr(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException {
        try {
            dbDao.changeReferenceByCntr(bkgNo, cntrNo, cntrNoOld, caFlg);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

	/**
	 * update changed Reference Detail information
	 * @param 		String bkgNo
	 * @param 	  	String cntrNo
	 * @param 		String cntrNoOld
	 * @param 		String caFlg
	 * @exception 	EventException
	 */
    public void changeReferenceDetailByCntr(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException {
        try {
            dbDao.changeReferenceDetailByCntr(bkgNo, cntrNo, cntrNoOld, caFlg);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

	/**
	 *  delete BKG_CLZ_TM(ESM_BKG_0079_01)<br>
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	String modeCd
     * @exception EventException
     */
    public void removeBkgClzTm(BkgBlNoVO bkgBlNoVO, String modeCd) throws EventException {
        try {
        	dbDao.removeBkgClzTm(bkgBlNoVO, modeCd);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
    
    /**
     * Booking information copies from sourceBkg to targetBkg.
     * using split and cod (ESM_BKG_0099)
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param SplitBkgVO splitBkgVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String copyBookingForSplit (BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SplitBkgVO splitBkgVO, SignOnUserAccount account)throws EventException{
		String splitFlg = "N";
    	try {
    		List<BkgVvdVO> bkgVvdVOList = new ArrayList<BkgVvdVO>();
    		BkgBookingVO bkgBookingVO = new BkgBookingVO();
    		int orginBkgSeq = 0;

			sourceBkg.setCaFlg("N");
    		for(int i=0;i<targetBkg.length;i++){	
				targetBkg[i].setCaFlg("N");
    		}
    		
    		bkgVvdVOList=dbDao.searchBkgVvd(sourceBkg);
        	
			bkgBookingVO = dbDao.searchBkgBookingForSplit((CopySplitBkgEtcVO)splitBkgVO.getCopySplitBkgEtcVO().get(0), sourceBkg ,  account );

//			if (codRqstNo!=null){
//				List<PodDelForCodVO>podDelForCodVO = new ArrayList<PodDelForCodVO>();
//				podDelForCodVO = dbDao.searchPodDelForCodSplit(codRqstNo, sourceBkg);
//				
//				if (podDelForCodVO.size()>0&&1==0){
//					bkgBookingVO.setPodCd   (podDelForCodVO.get(0).getPodCd());
//					bkgBookingVO.setPodNodCd(podDelForCodVO.get(0).getPodYdCd());
//					bkgBookingVO.setDelCd   (podDelForCodVO.get(0).getDelCd());
//					bkgBookingVO.setDelNodCd(podDelForCodVO.get(0).getDelYdCd());
//					bkgBookingVO.setDeTermCd(podDelForCodVO.get(0).getDeTermCd());
//				}
//			}
			
    		for(int i=0;i<targetBkg.length;i++){	
    			if (!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
    				if(dbDao.searchBkgBlNoDup(targetBkg[i])){
    					throw new EventException((String)new ErrorHandler("BKG00034",new String[]{targetBkg[i].getBlNo()}).getMessage());
    				}
    				dbDao.addBkgBlNoDup(targetBkg[i], account.getUsr_id());
    			}
    			bkgBookingVO.setBkgNo(targetBkg[i].getBkgNo());
    			bkgBookingVO.setBlNo(targetBkg[i].getBkgNo());
    			bkgBookingVO.setVslCd(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd().substring(0,4));
    			bkgBookingVO.setSkdVoyNo(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd().substring(4,8));
    			bkgBookingVO.setSkdDirCd(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd().substring(8,9));
    			
    			if (sourceBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(i).getBkgNo())){
    				orginBkgSeq = i;
    			}
    			if (!sourceBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(i).getBkgNo())){
    		    	if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){ // "memo"
    		    		bkgBookingVO.setBlNoTp("9");
    		    		bkgBookingVO.setAdvShtgCd(splitBkgVO.getSplitBlInfoVO().get(i).getAdvshtgcd());
    		    	}
    				dbDao.addBkgBookingForCopySplit(bkgBookingVO);
    				
        			dbDao.copyBkgCustomerByBkg(sourceBkg, targetBkg[i], account);

	    			for(int idx = 0; idx < bkgVvdVOList.size() ; idx++){
	    				BkgVvdVO bkgVvdVO =  (BkgVvdVO)bkgVvdVOList.get(idx);
						bkgVvdVO.setBkgNo(targetBkg[i].getBkgNo());
						dbDao.addBkgVvd(bkgVvdVO, targetBkg[i]);						
					}

    				dbDao.modifyCtrtInfo(targetBkg[i]);
    				
	    			dbDao.copyBkgCntcPsonByBkg(sourceBkg, targetBkg[i], account);
	    			dbDao.copyNVOFileNoByBkg(sourceBkg, targetBkg[i], account);
	    			
    				dbDao.copySplitCopyRefByBkg(sourceBkg, targetBkg[i], account);
    				
	    			for(int icnt=0;icnt<splitBkgVO.getSelectCntrVO().size();icnt++){
	    				if (splitBkgVO.getSelectCntrVO().get(icnt).getSplitNo().length()>0
	    				    && splitBkgVO.getSelectCntrVO().get(icnt).getCntr_no().length()>1
	    					&& !sourceBkg.getBkgNo().equals(splitBkgVO.getSelectCntrVO().get(icnt).getBkg_no())){

		    				dbDao.copyBkgRefDtlByBkg(splitBkgVO.getSelectCntrVO().get(icnt).getCntr_no(), sourceBkg, targetBkg[i], account);
	    				}
	    			}
	    			dbDao.addBkgRollOvr(targetBkg[i], account);
    			}
    		}

			if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")){ // "Customer"
				int i = orginBkgSeq; 
				
				if (sourceBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(i).getBkgNo())){ 
					SplitBlInfoVO splitBlInfoVO=(SplitBlInfoVO)splitBkgVO.getSplitBlInfoVO().get(i);
					CopySplitBkgEtcVO copySplitBkgEtcVO=(CopySplitBkgEtcVO)splitBkgVO.getCopySplitBkgEtcVO().get(0);
					dbDao.modifyBkgbookingAfterSplit(splitBlInfoVO,copySplitBkgEtcVO, sourceBkg,account );					

	    			for(int icnt=0;icnt<splitBkgVO.getSelectCntrVO().size();icnt++){
	    				if (splitBkgVO.getSelectCntrVO().get(icnt).getSplitNo().length()<1 && splitBkgVO.getSelectCntrVO().get(icnt).getBkg_no().equals(sourceBkg.getBkgNo())){ 
		    				dbDao.removeBkgRefAfterSplit(splitBkgVO.getSelectCntrVO().get(icnt).getCntr_no(), sourceBkg);
	
		    				dbDao.removeBkgRefDtlAfterSplit(splitBkgVO.getSelectCntrVO().get(icnt).getCntr_no(), sourceBkg);
	    				}
	    			}
				}
    		}
			// �대떦 Booking��DRY Cargo �몄� �꾨땶吏�� 泥댄겕�쒕떎.
			splitFlg = dbDao.checkBkgQtyDtlSplit(sourceBkg.getBkgNo());

			for(int i=0;i<splitBkgVO.getSplitQtyVO().size();i++){
				int targetBkgSeq = i%splitBkgVO.getSplitBlInfoVO().size();
    			splitBkgVO.getSplitQtyVO().get(i).setSplitNo(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo());
    			splitBkgVO.getSplitQtyVO().get(i).setSplitNo(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo());
    			double iQty =(splitBkgVO.getSplitQtyVO().get(i).getOpCntrQty()==null)? 0:Double.parseDouble(splitBkgVO.getSplitQtyVO().get(i).getOpCntrQty());
				if (!sourceBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo())
					&& iQty>0){ 
					BkgQuantityVO bkgQuantityVO = new BkgQuantityVO();
					bkgQuantityVO.setBkgNo(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo());
					bkgQuantityVO.setCntrTpszCd(splitBkgVO.getSplitQtyVO().get(i).getCntrTpszCd());
					bkgQuantityVO.setOpCntrQty(splitBkgVO.getSplitQtyVO().get(i).getOpCntrQty());
					bkgQuantityVO.setCreUsrId(account.getUsr_id());
					bkgQuantityVO.setUpdUsrId(account.getUsr_id()); 
					bkgQuantityVO.setActCntrQty("0");
					bkgQuantityVO.setDcgoQty("0");
					bkgQuantityVO.setAwkCgoQty("0");
					bkgQuantityVO.setRcQty("0");
					bkgQuantityVO.setBbCgoQty("0");
					bkgQuantityVO.setSocQty("0");
					bkgQuantityVO.setEqSubstCgoQty("0");
					bkgQuantityVO.setMerHngrQty("0");
					bkgQuantityVO.setCrrHngrQty("0");
					bkgQuantityVO.setCrrHngrSglBarQty("0");
					bkgQuantityVO.setCrrHngrDblBarQty("0");
					bkgQuantityVO.setCrrHngrTplBarQty("0");
					bkgQuantityVO.setOrgCntrQty("0");
					bkgQuantityVO.setDestCntrQty("0");
					bkgQuantityVO.setObTroQty("0");
					bkgQuantityVO.setIbTroQty("0");
					bkgQuantityVO.setFlexHgtFlg("N");
					
					dbDao.addBkgQuantity(bkgQuantityVO, targetBkg[targetBkgSeq]);
					
					if("Y".equals(splitFlg)){
						dbDao.copyBkgQtyDtlForSplit(sourceBkg, targetBkg[targetBkgSeq], splitBkgVO.getSplitQtyVO().get(i).getCntrTpszCd(), account);
						dbDao.modifyBkgQtyDtl(bkgQuantityVO, targetBkg[targetBkgSeq]);
					}
					
					
				} else {    		
		    		if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")){ // "Customer"
		    			int orgBkg = orginBkgSeq;     			
						BkgQuantityVO bkgQuantityVO = new BkgQuantityVO();
						bkgQuantityVO.setBkgNo(targetBkg[orgBkg].getBkgNo());
						bkgQuantityVO.setCntrTpszCd(splitBkgVO.getSplitQtyVO().get(i).getCntrTpszCd());
						bkgQuantityVO.setOpCntrQty(splitBkgVO.getSplitQtyVO().get(i).getOpCntrQty());
						bkgQuantityVO.setCreUsrId(account.getUsr_id());
						bkgQuantityVO.setUpdUsrId(account.getUsr_id()); 
						if (sourceBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo())){ 
							ArrayList<String> cntrTpSzList=new ArrayList<String>();
							cntrTpSzList.add(splitBkgVO.getSplitQtyVO().get(i).getCntrTpszCd());

							dbDao.modifyBkgQuantity(bkgQuantityVO, sourceBkg);
							
							dbDao.modifyBkgQtyDtl(bkgQuantityVO, sourceBkg);
							
						}
		    		}
				}
			}
	         //delete quantity in case of OP_CNTR_QTY = 0
            dbDao.removeBkgQtyDtlZero(sourceBkg.getBkgNo());
            dbDao.removeBkgQtyZero(sourceBkg.getBkgNo());

	    	if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){ // "memo"
				dbDao.modifyMemoSplit(sourceBkg, account);
	    	}
		} catch (EventException ex) {
			throw ex;		
        } catch (DAOException de) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    	return splitFlg;
    }
    
    
     

	/**
	 * Cancel Booking(ESM_BKG_007901)<br>
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBooking(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil util = new BookingUtil();

			//throw new EventException((String)new ErrorHandler("PRD00014").getMessage());

//			if(!account.getOfc_cd().equals(util.searchBkgOfcByBkg(bkgBlNoVO))){
//				throw new EventException((String)new ErrorHandler("BKG00875").getMessage());
//			}				

			if("Y".equals(dbDao.searchBlIss(bkgBlNoVO))){
				throw new EventException((String)new ErrorHandler("BKG02019").getMessage());
			}
			if("Y".equals(util.searchSoStatus("", "", bkgBlNoVO, null))){
				throw new EventException((String)new ErrorHandler("BKG00094").getMessage());								
			}
			
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){
				String[] mvmtStsCd = util.searchMVMTStatus(bkgBlNoVO, null);
				for(int i = 0 ; i < mvmtStsCd.length ; i++){
					if("VL".equals(mvmtStsCd[i])){
						throw new EventException((String)new ErrorHandler("BKG00317").getMessage());
					}
				}

				if("Y".equals(dbDao.searchSpclApprove(bkgBlNoVO))){
					throw new EventException((String)new ErrorHandler("BKG00316").getMessage());
				}

//				if("Y".equals(dbDao.searchUserHold(bkgBlNoVO))){
//					throw new EventException((String)new ErrorHandler("BKG00318").getMessage());
//				}
			}
			
			dbDao.modifyBookingStatus("N", "N", "X", bkgBlNoVO, account);
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
	 * modify special cgo qty(ESM_BKG_0055)<br>
	 * @param SpclQtyVO spclQtyVO
	 * @param String caFlg 
	 * @exception EventException
	 */	
	public void modifyAwkQty(SpclQtyVO spclQtyVO, String caFlg) throws EventException {
		try {				
			dbDao.modifyAwkQty(spclQtyVO, caFlg);
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}  
	/**
	 * modify special cgo qty(ESM_BKG_0055)<br>
	 * @param SpclVO spclVO
	 * @param String caFlg 
	 * @exception EventException
	 */		
	public void modifyBkgBySpcl(SpclVO spclVO, String caFlg) throws EventException {
		try {				
			dbDao.modifyBkgSpclFlg(spclVO.getBkgNo(), spclVO.getSpclTp(), caFlg);
			dbDao.modifySpclQty(spclVO.getBkgNo(), spclVO.getCntrTpszCd(), spclVO.getSpclTp(), spclVO.getCntrVolQty(), caFlg);
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}  

	/**
	 * modify Booking information(ESM_BKG_0029)<br>
	 * @param 		String xterRqstViaCd
	 * @param       String saveModeCd
	 * @param 		String autoNotification
	 * @param       XterRqstNoVO xterRqstNoVO
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBkgByXter(String xterRqstViaCd, String saveModeCd, String autoNotification, XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyXterRqstInfo (xterRqstNoVO , saveModeCd , autoNotification, xterRqstViaCd, account);

//			for(int i = 1 ; i <= 3 ; i++){
//				if(dbDao.modifyXterReference(xterRqstNoVO, xterRqstNoVO.getDocTpCd(), i, account.getUsr_id()) == 0){
//					dbDao.addXterReference(xterRqstNoVO, xterRqstNoVO.getDocTpCd(), i, account.getUsr_id());
//				}
//			}
//		} catch (EventException ex){
//			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * create update Booking information about Empty Repo Booking<br>
	 * @param 		MtyBookingCreateVO mtyBookingCreateVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void createMtyRepoBooking(MtyBookingCreateVO mtyBookingCreateVO, SignOnUserAccount account) throws EventException {
		try {		
			BookingUtil utilBC = new BookingUtil();
			if(mtyBookingCreateVO != null){
				MtyBookingVO mtyBookingVO = mtyBookingCreateVO.getMtyBookingVO();
				BkgBlNoVO bkgBlNoVO = mtyBookingCreateVO.getBkgBlNoVO();
				MtyVvdVO[] mtyVvdVOs = mtyBookingCreateVO.getMtyVvdVOs();
				MtyQtyVO[] mtyQtyVOs = mtyBookingCreateVO.getMtyQtyVOs();				
				
				if(mtyBookingVO == null){
					throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
				}				
				if(bkgBlNoVO == null){
					throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
				}				
				if(mtyVvdVOs == null || mtyVvdVOs.length < 1){
					throw new EventException((String)new ErrorHandler("BKG00391").getMessage());						
				}	
				if(mtyQtyVOs == null || mtyQtyVOs.length < 1){
					throw new EventException((String)new ErrorHandler("BKG00391").getMessage());						
				}
				for(int i = 0 ; i < mtyVvdVOs.length ; i++){
					if("XXXXX".equals(mtyVvdVOs[i].getPolYdCd().substring(0,5))){
						mtyBookingVO.setPodCd("XXXXX");
						mtyBookingVO.setPodYdCd("XXXXXXX");
						break;
					}
				}
				String bkgNo = bkgBlNoVO.getBkgNo();
				dbDao.addMtyBkgBooking(bkgNo, mtyBookingVO, account);
				
				dbDao.addMtyBkgCust(bkgNo, account);
				for(int i = 0 ; i < mtyQtyVOs.length ; i++){
					dbDao.addMtyBkgQty(mtyQtyVOs[i], bkgNo, account);
				}				
				for(int i = 0 ; i < mtyVvdVOs.length ; i++){
					mtyVvdVOs[i].setPolCd(mtyVvdVOs[i].getPolYdCd().substring(0, 5));
					mtyVvdVOs[i].setPodCd(mtyVvdVOs[i].getPodYdCd().substring(0, 5));
					
					
					if(!utilBC.validateVvd(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd())){
						throw new EventException((String)new ErrorHandler("BKG00944").getMessage());
					}
					if(utilBC.searchEtbEtdEta(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd(), mtyVvdVOs[i].getPolCd(), mtyVvdVOs[i].getPolClptIndSeq()) == null){
						throw new EventException((String)new ErrorHandler("BKG00078",new String[]{mtyVvdVOs[i].getPolCd()}).getMessage());	
					}
					if(mtyVvdVOs[i].getPodCd().equals("XXXXXXX")){
						if(utilBC.searchEtbEtdEta(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd(), mtyVvdVOs[i].getPodCd(), mtyVvdVOs[i].getPodClptIndSeq()) == null){
							throw new EventException((String)new ErrorHandler("BKG00945",new String[]{mtyVvdVOs[i].getPodCd()}).getMessage());	
						}
					}
					if("T".equals(mtyVvdVOs[i].getVslPrePstCd())){
						dbDao.modifyTrunkVvd(mtyVvdVOs[i].getVslCd()+mtyVvdVOs[i].getSkdVoyNo()+mtyVvdVOs[i].getSkdDirCd(), bkgBlNoVO, account);
					}
					BkgVvdVO bkgVvdVO = new BkgVvdVO();
					bkgVvdVO.setBkgNo(bkgNo);
					bkgVvdVO.setVslPrePstCd(mtyVvdVOs[i].getVslPrePstCd());
					bkgVvdVO.setVslSeq(mtyVvdVOs[i].getVslSeq());
					bkgVvdVO.setVslCd(mtyVvdVOs[i].getVslCd());
					bkgVvdVO.setSkdVoyNo(mtyVvdVOs[i].getSkdVoyNo());
					bkgVvdVO.setSkdDirCd(mtyVvdVOs[i].getSkdDirCd());
					bkgVvdVO.setPolClptIndSeq(mtyVvdVOs[i].getPolClptIndSeq());
					bkgVvdVO.setPodClptIndSeq(mtyVvdVOs[i].getPodClptIndSeq());
					bkgVvdVO.setPolCd(mtyVvdVOs[i].getPolYdCd().substring(0, 5));
					bkgVvdVO.setPolYdCd(mtyVvdVOs[i].getPolYdCd());
					bkgVvdVO.setPodCd(mtyVvdVOs[i].getPodYdCd().substring(0, 5));
					bkgVvdVO.setPodYdCd(mtyVvdVOs[i].getPodYdCd());
					bkgVvdVO.setCreUsrId(account.getUsr_id());
					bkgVvdVO.setUpdUsrId(account.getUsr_id());

					dbDao.addBkgVvd(bkgVvdVO, bkgBlNoVO);					
				}				

			}else{
				throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
			}
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * retrieve Customer Information in case of Booking Creation(ESM_BKG_007905)<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		BlCustomerVO
	 * @exception 	EventException
	 */
	public BlCustomerVO searchBlDocCust(BkgBlNoVO bkgBlNoVO) throws EventException {
		BlCustomerVO blCustomerVO = null;
		try {
			BookingUtil utilBC = new BookingUtil();
			
			BkgBlNoVO schBkgBlNoVO = utilBC.searchBkgBlNoVO(bkgBlNoVO);
			
			if(schBkgBlNoVO != null){
				blCustomerVO = new BlCustomerVO();
				
				BlDocCustVO blDocCustVO = dbDao.searchBlDocCust(schBkgBlNoVO);
				
				CustEtcVO custEtcVO = dbDao.searchBkgCustEtc(schBkgBlNoVO);
				if(!"Y".equals(schBkgBlNoVO.getCaFlg())){
					SplitMstBlNoVO splitMstBlNoVO = utilBC.searchSplitMstBlNo(schBkgBlNoVO.getBkgNo());
					
					blCustomerVO.setSplitMstBlNoVO(splitMstBlNoVO);
				}			
				blDocCustVO.getShCustCntCd();//.getShCntSeq();
				String frobCode = utilBC.searchFrob(schBkgBlNoVO.getBkgNo(), custEtcVO.getBkgVvd(), custEtcVO.getPolCd(), custEtcVO.getPodCd());
				String frobFlag = "N";
				if("CA".equals(frobCode) || "AL".equals(frobCode)){
					frobFlag = "Y";
				}
				custEtcVO.setFrobFlag(frobFlag);
				custEtcVO.setNlFlag(utilBC.searchNlFlagByBkg(schBkgBlNoVO));
				
				blCustomerVO.setBlDocCustVO(blDocCustVO);
				blCustomerVO.setCustEtcVO(custEtcVO);
				blCustomerVO.setBkgBlNoVO(schBkgBlNoVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return blCustomerVO;
	}
	

	/**
	 * checking Validation in case of Customer Information(ESM_BKG_007905)<br>
	 * @param 		BlCustomerVO blCustomerVO
	 * @return			String[]
	 * @exception 	EventException
	 */
	@SuppressWarnings("unchecked")
	public String[] validateBlDocCust(BlCustomerVO blCustomerVO) throws EventException {
		String[] rtnArr = null;
		try {
			List alertList = new ArrayList();		
			BookingUtil utilBC = new BookingUtil();			
			
			BkgBlNoVO bkgBlNoVO = blCustomerVO.getBkgBlNoVO();
			BlDocCustVO blDocCustVO = blCustomerVO.getBlDocCustVO();
			CustEtcVO custEtcVO = blCustomerVO.getCustEtcVO();			

			if(blDocCustVO.getShCustCntCd()==null || blDocCustVO.getShCustCntCd().length()<1
					||blDocCustVO.getShCustSeq()==null || blDocCustVO.getShCustSeq().length()<1){					
				throw new EventException((String)new ErrorHandler("BKG00008").getMessage());
			}
			
			String alertMsg = "";
			MdmCustVO mdmCustVO = null;
			String shCustCntCd = blDocCustVO.getShCustCntCd();
			String shCustSeq = blDocCustVO.getShCustSeq();					
			if(shCustCntCd != null && shCustCntCd.length() > 0 && shCustSeq != null && shCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(shCustCntCd, shCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{shCustCntCd, shCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{shCustCntCd, shCustSeq}).getMessage());
				}			
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{shCustCntCd+shCustSeq}).getMessage());
				}			
				alertMsg = utilBC.searchAlertCust(shCustCntCd, shCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}
			}

			if(blDocCustVO.getShCstmsDeclCntCd().length()==2){
				MdmCountryVO countryVO = utilBC.searchCountryCode(blDocCustVO.getShCstmsDeclCntCd());
				if(countryVO == null){
					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Shipper", blDocCustVO.getShCstmsDeclCntCd()}).getMessage());
				}
			}
			
			String cnCustCntCd = blDocCustVO.getCnCustCntCd();
			String cnCustSeq = blDocCustVO.getCnCustSeq();
			if(cnCustCntCd != null && cnCustCntCd.length() > 0 && cnCustSeq != null && cnCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(cnCustCntCd, cnCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{cnCustCntCd, cnCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{cnCustCntCd, cnCustSeq}).getMessage());
				}		
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{cnCustCntCd+cnCustSeq}).getMessage());
				}			
				alertMsg = utilBC.searchAlertCust(cnCustCntCd, cnCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}				
			}			
			
			if(blDocCustVO.getCnCstmsDeclCntCd().length()==2){
				MdmCountryVO countryVO = utilBC.searchCountryCode(blDocCustVO.getCnCstmsDeclCntCd());
				if(countryVO == null){
					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Consignee", blDocCustVO.getCnCstmsDeclCntCd()}).getMessage());
				}
			}
			
			String nfCustCntCd = blDocCustVO.getNfCustCntCd();
			String nfCustSeq = blDocCustVO.getNfCustSeq();
			if(nfCustCntCd != null && nfCustCntCd.length() > 0 && nfCustSeq != null && nfCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(nfCustCntCd, nfCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{nfCustCntCd, nfCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{nfCustCntCd, nfCustSeq}).getMessage());
				}				
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{nfCustCntCd+nfCustSeq}).getMessage());
				}			
				alertMsg = utilBC.searchAlertCust(nfCustCntCd, nfCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}						
			}				
			
			if(blDocCustVO.getNfCstmsDeclCntCd().length()==2){
				MdmCountryVO countryVO = utilBC.searchCountryCode(blDocCustVO.getNfCstmsDeclCntCd());
				if(countryVO == null){
					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Notify", blDocCustVO.getNfCstmsDeclCntCd()}).getMessage());
				}
			}
			
			String ffCustCntCd = blDocCustVO.getFfCustCntCd();
			String ffCustSeq = blDocCustVO.getFfCustSeq();
			if(ffCustCntCd != null && ffCustCntCd.length() > 0 && ffCustSeq != null && ffCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(ffCustCntCd, ffCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{ffCustCntCd, ffCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{ffCustCntCd, ffCustSeq}).getMessage());
				}							
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{ffCustCntCd+ffCustSeq}).getMessage());
				}							
				alertMsg = utilBC.searchAlertCust(ffCustCntCd, ffCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}						
			}					
			String anCustCntCd = blDocCustVO.getAnCustCntCd();
			String anCustSeq = blDocCustVO.getAnCustSeq();
			if(anCustCntCd != null && anCustCntCd.length() > 0 && anCustSeq != null && anCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(anCustCntCd, anCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{anCustCntCd, anCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{anCustCntCd, anCustSeq}).getMessage());
				}							
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{anCustCntCd+anCustSeq}).getMessage());
				}							
				alertMsg = utilBC.searchAlertCust(anCustCntCd, anCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}						
			}				
			String exCustCntCd = blDocCustVO.getExCustCntCd();
			String exCustSeq = blDocCustVO.getExCustSeq();
			if(exCustCntCd != null && exCustCntCd.length() > 0 && exCustSeq != null && exCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(exCustCntCd, exCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{exCustCntCd, exCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{exCustCntCd, exCustSeq}).getMessage());
				}			
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{exCustCntCd+exCustSeq}).getMessage());
				}							
				alertMsg = utilBC.searchAlertCust(exCustCntCd, exCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}					
			}					
			
			String shSteCd = blDocCustVO.getShCustSteCd();
			String shCstmsDeclCntCd = blDocCustVO.getShCstmsDeclCntCd();
			if(shCstmsDeclCntCd != null && shCstmsDeclCntCd.length() > 0 && shSteCd != null && shSteCd.length() > 0){
				if(!dbDao.searchCntVsState(shCstmsDeclCntCd, shSteCd)){
					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{shSteCd, shCstmsDeclCntCd}).getMessage());
				}
			}
			String cnSteCd = blDocCustVO.getCnCustSteCd();
			String cnCstmsDeclCntCd = blDocCustVO.getCnCstmsDeclCntCd();
			if(cnCstmsDeclCntCd != null && cnCstmsDeclCntCd.length() > 0 && cnSteCd != null && cnSteCd.length() > 0){
				if(!dbDao.searchCntVsState(cnCstmsDeclCntCd, cnSteCd)){
					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{cnSteCd, cnCstmsDeclCntCd}).getMessage());
				}
			}	
			String nfSteCd = blDocCustVO.getNfCustSteCd();
			String nfCstmsDeclCntCd = blDocCustVO.getNfCstmsDeclCntCd();
			if(nfCstmsDeclCntCd != null && nfCstmsDeclCntCd.length() > 0 && nfSteCd != null && nfSteCd.length() > 0){
				if(!dbDao.searchCntVsState(nfCstmsDeclCntCd, nfSteCd)){
					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{nfSteCd, nfCstmsDeclCntCd}).getMessage());
				}
			}				
			
			if(custEtcVO.getPodCd().startsWith("US")){
				if(shCustCntCd != null && shCustCntCd.length() > 0 && shCustSeq != null && shCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(shCustCntCd, shCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}
				if(cnCustCntCd != null && cnCustCntCd.length() > 0 && cnCustSeq != null && cnCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(cnCustCntCd, cnCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}
				if(nfCustCntCd != null && nfCustCntCd.length() > 0 && nfCustSeq != null && nfCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(nfCustCntCd, nfCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}
				if(ffCustCntCd != null && ffCustCntCd.length() > 0 && ffCustSeq != null && ffCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(ffCustCntCd, ffCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}
				if(anCustCntCd != null && anCustCntCd.length() > 0 && anCustSeq != null && anCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(anCustCntCd, anCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}
				if(exCustCntCd != null && exCustCntCd.length() > 0 && exCustSeq != null && exCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(exCustCntCd, exCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}				
			}

			// for roterdam
//			if("Y".equals(utilBC.searchNlFlagByBkg(bkgBlNoVO))){
//				if(blDocCustVO.getShEoriNo()==null || blDocCustVO.getShEoriNo().length()==0){
//					if((blDocCustVO.getShCustCtyNm()==null || blDocCustVO.getShCustCtyNm().length()==0)
//						|| (blDocCustVO.getShCustZipId()==null || blDocCustVO.getShCustZipId().length()==0)
//						|| (blDocCustVO.getShCstmsDeclCntCd()==null || blDocCustVO.getShCstmsDeclCntCd().length()==0)
//						|| (blDocCustVO.getShEurCstmsStNm()==null || blDocCustVO.getShEurCstmsStNm().length()==0)){
//						throw new EventException((String)new ErrorHandler("BKG02063", new String[]{"Shipper"}).getMessage());
//					}
//				}
//
//				if(!"Y".equals(custEtcVO.getCustToOrdFlg())){
//					if(blDocCustVO.getCnEoriNo()==null || blDocCustVO.getCnEoriNo().length()==0){
//						if((blDocCustVO.getCnCustCtyNm()==null || blDocCustVO.getCnCustCtyNm().length()==0)
//							|| (blDocCustVO.getCnCustZipId()==null || blDocCustVO.getCnCustZipId().length()==0)
//							|| (blDocCustVO.getCnCstmsDeclCntCd()==null || blDocCustVO.getCnCstmsDeclCntCd().length()==0)
//							|| (blDocCustVO.getCnEurCstmsStNm()==null || blDocCustVO.getCnEurCstmsStNm().length()==0)){
//							throw new EventException((String)new ErrorHandler("BKG02063", new String[]{"Consignee"}).getMessage());
//						}
//					}
//				} else {
//					if(blDocCustVO.getNfEoriNo()==null || blDocCustVO.getNfEoriNo().length()==0){
//						if((blDocCustVO.getNfCustCtyNm()==null || blDocCustVO.getNfCustCtyNm().length()==0)
//							|| (blDocCustVO.getNfCustZipId()==null || blDocCustVO.getNfCustZipId().length()==0)
//							|| (blDocCustVO.getNfCstmsDeclCntCd()==null || blDocCustVO.getNfCstmsDeclCntCd().length()==0)
//							|| (blDocCustVO.getNfEurCstmsStNm()==null || blDocCustVO.getNfEurCstmsStNm().length()==0)){
//							throw new EventException((String)new ErrorHandler("BKG02063", new String[]{"Notify"}).getMessage());
//						}
//					}
//				}
//			}
			
			if(alertList != null && alertList.size() > 0){
				rtnArr = new String[alertList.size()];
				for(int i = 0 ; i < alertList.size() ; i++){
					rtnArr[i] = (String)alertList.get(i);
				}
			}
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return rtnArr;
	}	

	/**
	 * modify shipper information(ESM_BKG_007905)<br>
	 * @param 		BlCustomerVO blCustomerVO
	 * @param 		String bkgFlg
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBlDocCust(BlCustomerVO blCustomerVO, String bkgFlg, SignOnUserAccount account) throws EventException {
		try {			
			BkgBlNoVO bkgBlNoVO = blCustomerVO.getBkgBlNoVO();
			BlDocCustVO blDocCustVO = blCustomerVO.getBlDocCustVO();
			CustEtcVO custEtcVO = blCustomerVO.getCustEtcVO();		
			
			String bkgNo = bkgBlNoVO.getBkgNo();

			BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
			bkgCustomerVO.setBkgNo(bkgNo);
			bkgCustomerVO.setCreUsrId(account.getUsr_id());
			bkgCustomerVO.setUpdUsrId(account.getUsr_id());
			
			if(!CheckUtilities.isNull(blDocCustVO) ){
				if((!CheckUtilities.isNull(blDocCustVO.getShCustCntCd()) &&!CheckUtilities.isNull(blDocCustVO.getShCustSeq())) 
						&&( !"".equals(blDocCustVO.getShCustCntCd()) && !"".equals(blDocCustVO.getShCustSeq()))){
					searchDmyCustCnt(blDocCustVO.getShCustCntCd(), blDocCustVO.getShCustSeq());
				}
				if( (!CheckUtilities.isNull(blDocCustVO.getFfCustCntCd()) && !CheckUtilities.isNull(blDocCustVO.getFfCustSeq())) 
						&&(!"".equals(blDocCustVO.getFfCustCntCd()) && !"".equals(blDocCustVO.getFfCustSeq()))){
					searchDmyCustCnt(blDocCustVO.getFfCustCntCd(), blDocCustVO.getFfCustSeq());
				}
				if( (!CheckUtilities.isNull(blDocCustVO.getCnCustCntCd()) && !CheckUtilities.isNull(blDocCustVO.getCnCustSeq())) 
						&&(!"".equals(blDocCustVO.getCnCustCntCd()) && !"".equals(blDocCustVO.getCnCustSeq()))){
					searchDmyCustCnt(blDocCustVO.getCnCustCntCd(), blDocCustVO.getCnCustSeq());
				}
				if( (!CheckUtilities.isNull(blDocCustVO.getNfCustCntCd()) && !CheckUtilities.isNull(blDocCustVO.getNfCustSeq())) 
						&&(!"".equals(blDocCustVO.getNfCustCntCd()) && !"".equals(blDocCustVO.getNfCustSeq()))){
					searchDmyCustCnt(blDocCustVO.getNfCustCntCd(), blDocCustVO.getNfCustSeq());
				}
				if( (!CheckUtilities.isNull(blDocCustVO.getAnCustCntCd()) && !CheckUtilities.isNull(blDocCustVO.getAnCustSeq())) 
						&&(!"".equals(blDocCustVO.getAnCustCntCd()) && !"".equals(blDocCustVO.getAnCustSeq()))){
					searchDmyCustCnt(blDocCustVO.getAnCustCntCd(), blDocCustVO.getAnCustSeq());
				}
				if( (!CheckUtilities.isNull(blDocCustVO.getExCustCntCd()) && !CheckUtilities.isNull(blDocCustVO.getExCustSeq())) 
						&&(!"".equals(blDocCustVO.getExCustCntCd()) && !"".equals(blDocCustVO.getExCustSeq()))){
					searchDmyCustCnt(blDocCustVO.getExCustCntCd(), blDocCustVO.getExCustSeq());
				}
			}
		
			bkgCustomerVO.setBkgCustTpCd("S");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getShCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getShCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getShCustNm());
			bkgCustomerVO.setCustAddr(blDocCustVO.getShCustAddr());
			bkgCustomerVO.setCustCtyNm(blDocCustVO.getShCustCtyNm());
			bkgCustomerVO.setCustSteCd(blDocCustVO.getShCustSteCd());
			bkgCustomerVO.setCstmsDeclCntCd(blDocCustVO.getShCstmsDeclCntCd());
			bkgCustomerVO.setCustZipId(blDocCustVO.getShCustZipId());
			bkgCustomerVO.setCustFaxNo("");
			bkgCustomerVO.setCustEml("");
			bkgCustomerVO.setCustTpCd(blDocCustVO.getShCustTp());
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getShAddrPrnFlg());
			bkgCustomerVO.setEurCstmsStNm(blDocCustVO.getShEurCstmsStNm());
			bkgCustomerVO.setEoriNo(blDocCustVO.getShEoriNo());
			
			dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO);			
			bkgCustomerVO.setBkgCustTpCd("C");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getCnCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getCnCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getCnCustNm());
			bkgCustomerVO.setCustAddr(blDocCustVO.getCnCustAddr());
			bkgCustomerVO.setCustCtyNm(blDocCustVO.getCnCustCtyNm());
			bkgCustomerVO.setCustSteCd(blDocCustVO.getCnCustSteCd());
			bkgCustomerVO.setCstmsDeclCntCd(blDocCustVO.getCnCstmsDeclCntCd());
			bkgCustomerVO.setCustZipId(blDocCustVO.getCnCustZipId());
			bkgCustomerVO.setCustFaxNo(blDocCustVO.getCnCustFaxNo());
			bkgCustomerVO.setCustEml(blDocCustVO.getCnCustEml());
			bkgCustomerVO.setCustTpCd(blDocCustVO.getCnCustTp());
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getCnAddrPrnFlg());	
			bkgCustomerVO.setEurCstmsStNm(blDocCustVO.getCnEurCstmsStNm());
			bkgCustomerVO.setEoriNo(blDocCustVO.getCnEoriNo());		
			
			dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO);
			bkgCustomerVO.setBkgCustTpCd("N");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getNfCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getNfCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getNfCustNm());
			bkgCustomerVO.setCustAddr(blDocCustVO.getNfCustAddr());
			bkgCustomerVO.setCustCtyNm(blDocCustVO.getNfCustCtyNm());
			bkgCustomerVO.setCustSteCd(blDocCustVO.getNfCustSteCd());
			bkgCustomerVO.setCstmsDeclCntCd(blDocCustVO.getNfCstmsDeclCntCd());
			bkgCustomerVO.setCustZipId(blDocCustVO.getNfCustZipId());
			bkgCustomerVO.setCustFaxNo(blDocCustVO.getNfCustFaxNo());
			bkgCustomerVO.setCustEml(blDocCustVO.getNfCustEml());
			bkgCustomerVO.setCustTpCd(blDocCustVO.getNfCustTp());
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getNfAddrPrnFlg());	
			bkgCustomerVO.setEurCstmsStNm(blDocCustVO.getNfEurCstmsStNm());
			bkgCustomerVO.setEoriNo(blDocCustVO.getNfEoriNo());		
			
			if(dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO) < 1){
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
			}		
			bkgCustomerVO.setBkgCustTpCd("F");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getFfCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getFfCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getFfCustNm());
			bkgCustomerVO.setCustAddr("");
			bkgCustomerVO.setCustCtyNm("");
			bkgCustomerVO.setCustSteCd("");
			bkgCustomerVO.setCstmsDeclCntCd("");
			bkgCustomerVO.setCustZipId("");
			bkgCustomerVO.setCustFaxNo("");
			bkgCustomerVO.setCustEml("");
			bkgCustomerVO.setCustTpCd("");
			bkgCustomerVO.setEurCstmsStNm("");
			bkgCustomerVO.setEoriNo("");
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getFfAddrPrnFlg());		
			
			if(dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO) < 1){
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
			}	
			bkgCustomerVO.setBkgCustTpCd("A");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getAnCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getAnCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getAnCustNm());
			bkgCustomerVO.setCustAddr("");
			bkgCustomerVO.setCustCtyNm("");
			bkgCustomerVO.setCustSteCd("");
			bkgCustomerVO.setCstmsDeclCntCd("");
			bkgCustomerVO.setCustZipId("");
			bkgCustomerVO.setCustFaxNo(blDocCustVO.getAnCustFaxNo());
			bkgCustomerVO.setCustEml(blDocCustVO.getAnCustEml());
			bkgCustomerVO.setCustTpCd(blDocCustVO.getAnCustTp());
			bkgCustomerVO.setEurCstmsStNm("");
			bkgCustomerVO.setEoriNo("");
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getAnAddrPrnFlg());		
			
			if(dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO) < 1){
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
			}	
			bkgCustomerVO.setBkgCustTpCd("E");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getExCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getExCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getExCustNm());
			bkgCustomerVO.setCustAddr("");
			bkgCustomerVO.setCustCtyNm("");
			bkgCustomerVO.setCustSteCd("");
			bkgCustomerVO.setCstmsDeclCntCd("");
			bkgCustomerVO.setCustZipId("");
			bkgCustomerVO.setCustFaxNo("");
			bkgCustomerVO.setCustEml("");
			bkgCustomerVO.setCustTpCd("");
			bkgCustomerVO.setEurCstmsStNm("");
			bkgCustomerVO.setEoriNo("");
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getExAddrPrnFlg());		
			
			if(dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO) < 1){
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
			}			
			
			BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
			bkgReferenceVO.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgReferenceVO.setCreUsrId(account.getUsr_id());
			bkgReferenceVO.setUpdUsrId(account.getUsr_id());
			
			if("E".equals(bkgFlg)){
				bkgCustomerVO.setBkgCustTpCd("B");
//				if(blDocCustVO.getExCustCntCd() != null){
//					if(blDocCustVO.getExCustCntCd().length() > 2){
//						bkgCustomerVO.setCustCntCd(blDocCustVO.getBrCustCntCd().substring(0,2));
//						bkgCustomerVO.setCustSeq(blDocCustVO.getBrCustCntCd().substring(2));
//					}
//				}
				bkgCustomerVO.setCustNm(blDocCustVO.getBrCustNm());
				bkgCustomerVO.setCustAddr(blDocCustVO.getBrCustAddr());
				bkgCustomerVO.setCustCtyNm("");
				bkgCustomerVO.setCustSteCd("");
				bkgCustomerVO.setCstmsDeclCntCd("");
				bkgCustomerVO.setCustZipId("");
				bkgCustomerVO.setCustFaxNo("");
				bkgCustomerVO.setCustEml("");
				bkgCustomerVO.setCustTpCd("");
				bkgCustomerVO.setAddrPrnFlg("");		
				
				if(dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO) < 1){
					dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				}			
				if(blDocCustVO.getBrCustCntCd()!= null ||blDocCustVO.getBrCustCntCd().length() > 0){
					bkgReferenceVO.setBkgRefTpCd("BRKN");
					bkgReferenceVO.setCustRefNoCtnt(blDocCustVO.getBrCustCntCd());
					
					if(dbDao.modifyBkgReference(bkgReferenceVO, bkgBlNoVO) < 1){
						dbDao.addBkgReference(bkgReferenceVO, bkgBlNoVO);
					}
				}
			}			
			
			custEtcVO.setBkgNo(bkgNo);
			dbDao.modifyBkgBookingByCust(custEtcVO, bkgBlNoVO, account);
			
			dbDao.modifyCtrtInfo(bkgBlNoVO);
			
			bkgReferenceVO.setBkgRefTpCd("FFNO");
			bkgReferenceVO.setCustRefNoCtnt(custEtcVO.getFfRefNo());
			
			if(dbDao.modifyBkgReference(bkgReferenceVO, bkgBlNoVO) < 1){
				dbDao.addBkgReference(bkgReferenceVO, bkgBlNoVO);
			}
			bkgReferenceVO.setBkgRefTpCd("FMCN");
			bkgReferenceVO.setCustRefNoCtnt(custEtcVO.getFmcCd());
			
			if(dbDao.modifyBkgReference(bkgReferenceVO, bkgBlNoVO) < 1){
				dbDao.addBkgReference(bkgReferenceVO, bkgBlNoVO);
			}				

		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * modify saved Inbound Notify information from ANCS, ROCS(ESM_BKG_0045, 0442)<br>
	 * @param 		String bkgNo
	 * @param 		String notifyNm
	 * @param 		String notifyAddr
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyIbCustNmAddr(String bkgNo, String notifyNm, String notifyAddr, SignOnUserAccount account) throws EventException {
		try {
			
			//BkgBlNoVO bkgBlNoVO = blCustomerVO.getBkgBlNoVO();
			//BlDocCustVO blDocCustVO = blCustomerVO.getBlDocCustVO();	

			BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
			bkgCustomerVO.setBkgNo(bkgNo);
			bkgCustomerVO.setCreUsrId(account.getUsr_id());
			bkgCustomerVO.setUpdUsrId(account.getUsr_id());	

			bkgCustomerVO.setCustNm(notifyNm);
			bkgCustomerVO.setCustAddr(notifyAddr);
			
			dbDao.modifyIbCustNmAddr(bkgCustomerVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Cargo Detail Information retrieve.<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return			CargoDetailVO
	 * @exception 	EventException
	 */
	public CargoDetailVO searchCargoDetail(BkgBlNoVO bkgBlNoVO) throws EventException {
		CargoDetailVO cargoDetailVO = new CargoDetailVO();
		try {
			cargoDetailVO.setBkgQtyDtl(dbDao.searchBkgQtyDtl(bkgBlNoVO));
			cargoDetailVO.setBkgQuantity(dbDao.searchBkgQuantity(bkgBlNoVO));
			cargoDetailVO.setCargoDtlEtcVO(dbDao.searchCargoDtlEtc(bkgBlNoVO));			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return cargoDetailVO;
	}	


	/**
	 * save BkgQtyDtl information<br>
	 * @param 		BkgQtyDtlVO[] bkgQtyDtlVOs
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void manageBkgQtyDtl(BkgQtyDtlVO[] bkgQtyDtlVOs, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeBkgQtyDtl(bkgBlNoVO, null);
			
			if(bkgQtyDtlVOs != null){
				for(int i = 0 ; i < bkgQtyDtlVOs.length ; i++){
					BkgQtyDtlVO bkgQtyDtlVO = bkgQtyDtlVOs[i];
					if("Y".equals(bkgQtyDtlVO.getAwkCgoFlg()) || "1".equals(bkgQtyDtlVO.getAwkCgoFlg())){
						bkgQtyDtlVO.setAwkCgoFlg("Y");
					}else{
						bkgQtyDtlVO.setAwkCgoFlg("N");
					}
					if("Y".equals(bkgQtyDtlVO.getDcgoFlg()) || "1".equals(bkgQtyDtlVO.getDcgoFlg())){
						bkgQtyDtlVO.setDcgoFlg("Y");
					}else{
						bkgQtyDtlVO.setDcgoFlg("N");
					}			
					
					if("Y".equals(bkgQtyDtlVO.getRcFlg()) || "1".equals(bkgQtyDtlVO.getRcFlg())){
						bkgQtyDtlVO.setRcFlg("Y");
					}else{
						bkgQtyDtlVO.setRcFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getBbCgoFlg()) || "1".equals(bkgQtyDtlVO.getBbCgoFlg())){
						bkgQtyDtlVO.setBbCgoFlg("Y");
					}else{
						bkgQtyDtlVO.setBbCgoFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getSocFlg()) || "1".equals(bkgQtyDtlVO.getSocFlg())){
						bkgQtyDtlVO.setSocFlg("Y");
					}else{
						bkgQtyDtlVO.setSocFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg())){
						bkgQtyDtlVO.setCrrHngrSglBarUseFlg("Y");
					}else{
						bkgQtyDtlVO.setCrrHngrSglBarUseFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg())){
						bkgQtyDtlVO.setCrrHngrDblBarUseFlg("Y");
					}else{
						bkgQtyDtlVO.setCrrHngrDblBarUseFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg())){
						bkgQtyDtlVO.setCrrHngrTplBarUseFlg("Y");
					}else{
						bkgQtyDtlVO.setCrrHngrTplBarUseFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getDryCgoFlg()) || "1".equals(bkgQtyDtlVO.getDryCgoFlg())){
						bkgQtyDtlVO.setDryCgoFlg("Y");
					}else{
						bkgQtyDtlVO.setDryCgoFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getMerHngrFlg()) || "1".equals(bkgQtyDtlVO.getMerHngrFlg())){
						bkgQtyDtlVO.setMerHngrFlg("Y");
					}else{
						bkgQtyDtlVO.setMerHngrFlg("N");
					}								
					bkgQtyDtlVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgQtyDtlVO.setCreUsrId(account.getUsr_id());
					bkgQtyDtlVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBkgQtyDtl(bkgQtyDtlVO, bkgBlNoVO);
				}
			}		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * update t/vvd, pod, pod_node, del, del_node from bkg_cod to bkg_booking
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgBlNoVO codBkg 
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBookingFromCod (BkgBlNoVO bkgBlNoVO, BkgBlNoVO codBkg, String codRqstSeq, SignOnUserAccount account ) throws EventException{
		try {
			if(bkgBlNoVO.getPctlNo()==null){
				dbDao.removeBkgVvd(bkgBlNoVO);
				dbDao.modifyBkgVvdFromCod(codRqstSeq, bkgBlNoVO, account);
				dbDao.modifyBkgBookingFromCod(codRqstSeq, bkgBlNoVO, account);
			} else {
				log.debug("bkg_no:"+bkgBlNoVO.getBkgNo()+",pctl_no:"+bkgBlNoVO.getPctlNo());
				dbDao.modifyBkgRouteFromPrd(bkgBlNoVO, "U");
				dbDao.removeBkgVvd(bkgBlNoVO);
				dbDao.addBkgVvdFromPrd(bkgBlNoVO, dbDao.searchTrunkVvdByBkg(bkgBlNoVO), account);				  
			}

			BkgForDstSvcRouteVO bkgForDstSvcRouteVO =dbDao.searchBkgForDstSvcRoute(bkgBlNoVO);
			String dstSvcRouteCd=dbDao.searchDstSvcRoute( bkgForDstSvcRouteVO.getPodCd(), bkgForDstSvcRouteVO.getDelCd(),bkgForDstSvcRouteVO.getPreRlyPortCd(),
			                   bkgForDstSvcRouteVO.getSkdDirCd(), bkgForDstSvcRouteVO.getSlanCd() , bkgForDstSvcRouteVO.getOcpCd());
			dbDao.modifyDstSvcRoute(dstSvcRouteCd, bkgBlNoVO, codBkg, codRqstSeq);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * 1. Combine from Qty and Qty Dtl to Master Bkg<br>
	 * 2. Combine from bkg_reference to Master Bkg<br>
	 * @param BkgBlNoVO[] sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String hitchmentYn
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void combineQty(BkgBlNoVO[] sourceBkg , BkgBlNoVO targetBkg, String hitchmentYn ,SignOnUserAccount account) throws EventException{
		try {
			List<BkgQuantityVO> bkgQuantityVOs = null;
			List<BkgQtyDtlVO> bkgQtyDtlVOs = null;

			if ( sourceBkg != null ) {
				bkgQuantityVOs = dbDao.combineBkgQty(sourceBkg, targetBkg);
				bkgQtyDtlVOs = dbDao.combineBkgQtyDtl(sourceBkg, targetBkg);

				dbDao.removeBkgQtyDtl(targetBkg, null);
				dbDao.removeBkgQuantity(null, targetBkg, "BKG");

				if ( bkgQuantityVOs != null ) {
					for(int i = 0 ; i < bkgQuantityVOs.size() ; i++){
						BkgQuantityVO bkgQuantityVO = bkgQuantityVOs.get(i);
						bkgQuantityVO.setCreUsrId(account.getUsr_id());
						bkgQuantityVO.setUpdUsrId(account.getUsr_id());
						dbDao.addBkgQuantity(bkgQuantityVO, targetBkg);
					}
				}

				if( bkgQtyDtlVOs != null ){
					for(int j = 0 ; j < bkgQtyDtlVOs.size() ; j++){
						BkgQtyDtlVO bkgQtyDtlVO = bkgQtyDtlVOs.get(j);
						bkgQtyDtlVO.setCreUsrId(account.getUsr_id());
						bkgQtyDtlVO.setUpdUsrId(account.getUsr_id());

						dbDao.addBkgQtyDtl(bkgQtyDtlVO, targetBkg);
					}
				}				

				copyBkgRefByBkg("M", sourceBkg, targetBkg , null, account);

				dbDao.modifyBkgBookingAfterCombine(targetBkg, sourceBkg, account);
				
				for (int i=0;i<sourceBkg.length;i++) {
					dbDao.modifyBookingStatus("N","N", "X", sourceBkg[i], account);
					dbDao.modifyToBkgNo(targetBkg, sourceBkg[i], hitchmentYn, account);
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * copy from bkg_referenece of Source Bkg to Target Bkg
	 * @param String copyModeCd
	 * @param BkgBlNoVO[] sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String[] cntrNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyBkgRefByBkg(String copyModeCd, BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg , String[] cntrNo, SignOnUserAccount account) throws EventException{
		try {
			BookingUtil utilBC = new BookingUtil();

			if ( sourceBkg != null ) {
				for (int i=0;i<sourceBkg.length;i++) {
					if ( "M".equals(copyModeCd) ) {
						cntrNo = utilBC.searchCntrListByBkg(sourceBkg[i]);
					}
					for (int j=0;j<cntrNo.length;j++) {
						dbDao.copyBkgRefByBkg(cntrNo[j], sourceBkg[i], targetBkg, account);
	    				dbDao.copyBkgRefDtlByBkg(cntrNo[j], sourceBkg[i], targetBkg, account);
					}
					dbDao.copyNVOFileNoByBkg(sourceBkg[i], targetBkg, account);
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

    /**
     * copy from bkg_referenece of Bkg to Target Bkg
     * @param 		cntrCopyVO
	 * @exception 	EventException
     */
    public void copyBkgRefByCntr(CntrCopyVO cntrCopyVO) throws EventException {
        try {
            dbDao.copyBkgRefByCntr(cntrCopyVO);
            dbDao.copyBkgRefDtlByCntr(cntrCopyVO);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * delete bkg_referenece, bkg_ref_dtl of Bkg by cntr
     * @param 		String bkgNo
     * @param 		String cntrNo
     * @param 		String seq
	 * @exception 	EventException
     */
    public void removeBkgRefByCntr(String bkgNo, String cntrNo, String seq) throws EventException{
        try {
            dbDao.removeBkgRefByCntr(bkgNo, cntrNo, seq);
            dbDao.removeBkgRefDtlByCntr(bkgNo, cntrNo, seq);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * delete bkg_referenece of Bkg by cntr
     * @param 		String bkgNo
     * @param 		String cntrNo
     * @param 		String caFlg
	 * @exception 	EventException
     */
    public void removeReferenceByCntr(String bkgNo, String cntrNo, String caFlg) throws EventException {
        try {
            dbDao.removeBkgRefByCntr(bkgNo, cntrNo, caFlg);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * delete bkg_ref_dtl of Bkg by cntr
     * @param 		String bkgNo
     * @param 		String cntrNo
     * @param 		String caFlg
	 * @exception 	EventException
     */
    public void removeReferenceDetailByCntr(String bkgNo, String cntrNo, String caFlg) throws EventException {
        try {
            dbDao.removeBkgRefDtlByCntr(bkgNo, cntrNo, caFlg);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

	/**
	 * copy customer information from original bkg
	 * @param BlCopyInVO blCopyInVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyCustByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws EventException {
		try {
			  dbDao.copyCustByBlCopy(blCopyInVo, account);
			  dbDao.copyBkgByBlCopy(blCopyInVo, account);
			  dbDao.copyRefByBlCopy(blCopyInVo, account);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * retrieve reference data in order to modify route of Booking using Partial container
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		PartialBkgVO
	 * @exception 	EventException
	 */
	public PartialBkgVO searchPartialCntrBkg(BkgBlNoVO bkgBlNoVO) throws EventException {
		PartialBkgVO partialBkgVO = new PartialBkgVO();
		try {
			List<String> bkgNoList = dbDao.searchPartialCntrBkgList(bkgBlNoVO.getBkgNo());
			List<String> cntrNoList = dbDao.searchPartialCntrListByBkgList(bkgNoList);
			DBRowSet partialBkgCntrRS = dbDao.searchPartialRelatedBkgCntr(bkgNoList, cntrNoList);
			
			List<PartialBkgInfoVO> partialBkgInfo = new ArrayList<PartialBkgInfoVO>(); 
			if(bkgNoList != null && bkgNoList.size() > 0){
				for(int i = 0 ; i < bkgNoList.size() ; i++){
					if(!bkgNoList.get(i).equals(bkgBlNoVO.getBkgNo())){
						partialBkgInfo.add(dbDao.searchPartialCntrBkgInfo(bkgNoList.get(i)));	
					}					
				}
			}
			partialBkgVO.setCntrNoList(cntrNoList);
			partialBkgVO.setPartialBkgCntrRS(partialBkgCntrRS);
			partialBkgVO.setPartialBkgInfo(partialBkgInfo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return partialBkgVO;
	}	

	/**
	 * update orgin, dest route of Booking<br>
	 * @param 		PartialBkgInfoVO partialBkgInfoVO
	 * @param 		VslSkdVO[] vslSkdVOs
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBkgRouteForPartialBkg(PartialBkgInfoVO partialBkgInfoVO, VslSkdVO[] vslSkdVOs, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();

			String trnkLaneCd = utilBC.searchSvcLaneByVvd(partialBkgInfoVO.getBkgTrunkVvd());
			
			if(bkgBlNoVO.getPctlNo()!= null){
				dbDao.modifyBkgRouteFromPrd(bkgBlNoVO, "U");
				
				dbDao.removeBkgVvd(bkgBlNoVO);
				dbDao.addBkgVvdFromPrd(bkgBlNoVO, null, account);
			} else {				
				// 16. removeBkgVvd
				dbDao.removeBkgVvd(bkgBlNoVO);		

				// 15. modifyTrnkVvdLane
				dbDao.modifyTrnkVvdLane(partialBkgInfoVO.getBkgTrunkVvd(), trnkLaneCd, partialBkgInfoVO.getPreRlyPortCd(), partialBkgInfoVO.getPstRlyPortCd(), bkgBlNoVO, account);
				
				// 17. addBkgVvd
				for(int i = 0 ; i < vslSkdVOs.length ; i++){
					BkgVvdVO bkgVvdVO = new BkgVvdVO();
					bkgVvdVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgVvdVO.setVslPrePstCd(vslSkdVOs[i].getVslPrePstCd());
					bkgVvdVO.setVslSeq(vslSkdVOs[i].getVslSeq());
					if(vslSkdVOs[i].getBkgVvdCd() != null && vslSkdVOs[i].getBkgVvdCd().length() == 9){
						bkgVvdVO.setVslCd(vslSkdVOs[i].getBkgVvdCd().substring(0,4));
						bkgVvdVO.setSkdVoyNo(vslSkdVOs[i].getBkgVvdCd().substring(4,8));
						bkgVvdVO.setSkdDirCd(vslSkdVOs[i].getBkgVvdCd().substring(8,9));
					}
					bkgVvdVO.setPolClptIndSeq(vslSkdVOs[i].getPolClptIndSeq());
					bkgVvdVO.setPodClptIndSeq(vslSkdVOs[i].getPodClptIndSeq());
					bkgVvdVO.setPolCd(vslSkdVOs[i].getPolCd());
					if(vslSkdVOs[i].getPolYdCd() != null && vslSkdVOs[i].getPolYdCd().length() > 0){
						bkgVvdVO.setPolYdCd(vslSkdVOs[i].getPolCd()+vslSkdVOs[i].getPolYdCd());	
					}	
					bkgVvdVO.setPodCd(vslSkdVOs[i].getPodCd());
					if(vslSkdVOs[i].getPodYdCd() != null &&vslSkdVOs[i].getPodYdCd().length() > 0){
						bkgVvdVO.setPodYdCd(vslSkdVOs[i].getPodCd()+vslSkdVOs[i].getPodYdCd());	
					}		
					bkgVvdVO.setCreUsrId(account.getUsr_id());
					bkgVvdVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBkgVvd(bkgVvdVO, bkgBlNoVO);										
				}
			}			
			
			log.debug(" ***** BC : " + partialBkgInfoVO.getBkgNo() + "/" +  partialBkgInfoVO.getRcvTermCd() + "/" + partialBkgInfoVO.getOrg());
			if("Y".equals(partialBkgInfoVO.getOrg())){
				String orgSvcMode =  dbDao.searchOrgSvcRoute(trnkLaneCd, partialBkgInfoVO.getBkgTrunkVvd().substring(8,9), partialBkgInfoVO.getPorCd(), partialBkgInfoVO.getPolCd(), partialBkgInfoVO.getPreRlyPortCd());
				partialBkgInfoVO.setOrgTrnsSvcModCd(orgSvcMode);
				
				dbDao.modifyOrgRouteForPartialBkg(partialBkgInfoVO, account);
			}
			
			if("Y".equals(partialBkgInfoVO.getDest())){
				String destSvcMode = dbDao.searchDstSvcRoute(trnkLaneCd, partialBkgInfoVO.getBkgTrunkVvd().substring(8,9), partialBkgInfoVO.getPodCd(), partialBkgInfoVO.getDelCd(), partialBkgInfoVO.getPstRlyPortCd(), partialBkgInfoVO.getOcpCd());
				partialBkgInfoVO.setDestTrnsSvcModCd(destSvcMode);
				
				dbDao.modifyDestRouteForPartialBkg(partialBkgInfoVO, account);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * copy relevant table of booking for C/A<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void createBookingCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			if ("BKG".equals(copyTypeCd)) {
				//01. 
				dbDao.modifyBkgCA     (bkgBlNoVO, copyTypeCd);
				//02. 
				dbDao.removeCustCA    (bkgBlNoVO, copyTypeCd);
				//03. 
				dbDao.removeQtyDtlCA  (bkgBlNoVO, copyTypeCd);
				//04.  
				dbDao.removeQtyCA     (bkgBlNoVO, copyTypeCd);
				//05. 
				dbDao.removeRefCA     (bkgBlNoVO, copyTypeCd);
				//06. 
				dbDao.removeRefDtlCA  (bkgBlNoVO, copyTypeCd);
				//07. 
				dbDao.removeVvdCA     (bkgBlNoVO, copyTypeCd);
				//08. 
				dbDao.removeCntcPsonCA(bkgBlNoVO, copyTypeCd);
				//09. 
				dbDao.removeNVOFilerCA(bkgBlNoVO, copyTypeCd);
			} else {
				//01. 
				dbDao.createBkgCA(bkgBlNoVO, copyTypeCd);
			}

			//02. 
			dbDao.createCustCA     (bkgBlNoVO, copyTypeCd);		
			//03. 
			dbDao.createQtyCA      (bkgBlNoVO, copyTypeCd);
			//04. 
			dbDao.createQtyDtlCA   (bkgBlNoVO, copyTypeCd);
			//05. 
			dbDao.createRefCA      (bkgBlNoVO, copyTypeCd);
			//06. 
			dbDao.createRefDtlCA   (bkgBlNoVO, copyTypeCd);
			//07. 
			dbDao.createVvdCA      (bkgBlNoVO, copyTypeCd);
			//08. 
			dbDao.createCntcPsonCA (bkgBlNoVO, copyTypeCd);
			//09. 
			dbDao.createNVOFileNoCA(bkgBlNoVO, copyTypeCd);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * delete relevant table of booking for C/A
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			//01. 
			dbDao.removeCntcPsonCA(bkgBlNoVO, copyTypeCd);				
			//02. 
			dbDao.removeCustCA    (bkgBlNoVO, copyTypeCd);
			//03. 
			dbDao.removeRefDtlCA  (bkgBlNoVO, copyTypeCd);				
			//04.  
			dbDao.removeRefCA     (bkgBlNoVO, copyTypeCd);				
			//05. 
			dbDao.removeQtyDtlCA  (bkgBlNoVO, copyTypeCd);
			//06. 
			dbDao.removeQtyCA     (bkgBlNoVO, copyTypeCd);
			//07. 
			dbDao.removeVvdCA     (bkgBlNoVO, copyTypeCd);
			//08. 
			dbDao.removeNVOFilerCA(bkgBlNoVO, copyTypeCd);
			//09. 
			dbDao.removeBkgCA     (bkgBlNoVO, copyTypeCd);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * retrieve data of original booking for copying booking
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return			BookingCopyVO
	 * @exception 	EventException
	 */
	public BookingCopyVO searchBkgForCopy(BkgBlNoVO bkgBlNoVO) throws EventException {
		BookingCopyVO bookingCopyVO = new BookingCopyVO();
		try {
			BkgForCopyVO bkgForCopyVO = dbDao.searchBkgForCopy(bkgBlNoVO);
			BlCustomerInfoVO blCustomerInfoVO = dbDao.searchBkgCustomer("B", bkgBlNoVO);
			List<VslSkdVO> vslSkdVOs = dbDao.searchVvdSkdForTsRoute(bkgBlNoVO);
			
			List<VslSkdVO> rtnVslSkdVOs = new ArrayList<VslSkdVO>();
			for(int i = 0 ; i < vslSkdVOs.size() ; i++){
				PolPodVvdVO polPodVvdVO = new PolPodVvdVO();
				polPodVvdVO.setPolCd		(vslSkdVOs.get(i).getPolCd());
				polPodVvdVO.setPolYdCd		(vslSkdVOs.get(i).getPolYdCd());
				polPodVvdVO.setPolClptIndSeq(vslSkdVOs.get(i).getPolClptIndSeq());
				polPodVvdVO.setPodCd		(vslSkdVOs.get(i).getPodCd());
				polPodVvdVO.setPodYdCd		(vslSkdVOs.get(i).getPodYdCd());
				polPodVvdVO.setPodClptIndSeq(vslSkdVOs.get(i).getPodClptIndSeq());
				polPodVvdVO.setBkgVvdCd(vslSkdVOs.get(i).getBkgVvdCd());
				
				VslSkdVO vslSkdVO = dbDao.searchLaneEtdEta(polPodVvdVO);

//				if(vslSkdVO == null){
//					vslSkd.get(i).setEtd(vslSkdVO.getEtd());
//					vslSkd.get(i).setEtdDay(vslSkdVO.getEtdDay());
//					vslSkd.get(i).setEtdTime(vslSkdVO.getEtdTime());					
//					vslSkd.get(i).setEta(vslSkdVO.getEta());
//					vslSkd.get(i).setEtaDay(vslSkdVO.getEtaDay());
//					vslSkd.get(i).setEtaTime(vslSkdVO.getEtaTime());
//				}

				if(vslSkdVO == null){
					vslSkdVO = new VslSkdVO();
				}
				vslSkdVO.setPodCd(polPodVvdVO.getPodCd());
				vslSkdVO.setPolCd(polPodVvdVO.getPolCd());
				vslSkdVO.setBkgVvdCd(polPodVvdVO.getBkgVvdCd());
//				vslSkdVO.setVslPrePstCd(polPodVvdVOs[i].getVslPrePstCd());

				rtnVslSkdVOs.add(vslSkdVO);
			}			
			
			bookingCopyVO.setBkgForCopyVO(bkgForCopyVO);
			bookingCopyVO.setBlCustomerInfoVO(blCustomerInfoVO);
			bookingCopyVO.setVslSkd(rtnVslSkdVOs);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return bookingCopyVO;
	}	
	
	/**
	 * create data of new booking as inspect and combine data of original booking
	 * @param 		BookingCopyVO bookingCopyVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void validateBkgCopy(BookingCopyVO bookingCopyVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();
//			if(dbDao.searchOfcVsBkgOfc(bookingCopyVO.getBkgBlNoVO(), account)){
//				throw new EventException((String)new ErrorHandler("BKG02009").getMessage());
//			}
			
			VslSkdVO[] vslSkdVOs = bookingCopyVO.getVslSkdVOs();
			for(int i = 0 ; i < vslSkdVOs.length ; i++){
				BkgVvdVO bkgVvdVO = new BkgVvdVO();
				
				if(vslSkdVOs[i].getBkgVvdCd() != null && vslSkdVOs[i].getBkgVvdCd().length() == 9){
					bkgVvdVO.setVslCd(vslSkdVOs[i].getBkgVvdCd().substring(0,4));
					bkgVvdVO.setSkdVoyNo(vslSkdVOs[i].getBkgVvdCd().substring(4,8));
					bkgVvdVO.setSkdDirCd(vslSkdVOs[i].getBkgVvdCd().substring(8,9));
				}
				bkgVvdVO.setPolCd(vslSkdVOs[i].getPolCd());
				bkgVvdVO.setPodCd(vslSkdVOs[i].getPodCd());

				if(utilBC.searchVvdBdr(bkgVvdVO)){
					throw new EventException((String)new ErrorHandler("BKG00071", new String[]{vslSkdVOs[i].getBkgVvdCd()}).getMessage());
				}				
			}
		} catch (EventException ex) {
			throw ex;					
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * retrieve booking data status for manual booking copy
	 * @param ManualBookingCopyVO[] manualBookingCopyVOs
	 * @param String bkgNo
	 * @return ManualBookingCopyVO[] manualBookingStsVOs
	 * @exception EventException
	 */
	public ManualBookingCopyVO[] searchManualBookingStatus(ManualBookingCopyVO[] manualBookingCopyVOs, String bkgNo) throws EventException {

		ManualBookingCopyVO[] manualBookingStsVOs = new ManualBookingCopyVO[manualBookingCopyVOs.length];

		try {
			for(int i = 0 ; i < manualBookingCopyVOs.length ; i++){
				manualBookingStsVOs[i] = dbDao.searchManualBookingStatus(manualBookingCopyVOs[i].getMnlBkgNo(),bkgNo);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return manualBookingStsVOs;
	}	
 
	
	/**
	 * copy Booking<br>
	 * @param 		BookingCopyVO bookingCopyVO
	 * @param 		BkgBlNoVO sourceBkg
	 * @param 		BkgBlNoVO targetBkg
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void copyBooking(BookingCopyVO bookingCopyVO, BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException {
		try {
			BkgForCopyVO bkgForCopyVO = bookingCopyVO.getBkgForCopyVO();
			
			if(dbDao.searchBkgBlNoDup(targetBkg)){
				throw new EventException((String)new ErrorHandler("BKG00034",new String[]{targetBkg.getBlNo()}).getMessage());
			}			
			
			BkgBookingVO bkgBookingVO = dbDao.searchBkgBookingForCopy(bkgForCopyVO, account);
			
			bkgBookingVO.setBkgNo(targetBkg.getBkgNo());
			bkgBookingVO.setBlNo(targetBkg.getBkgNo());
			bkgBookingVO.setScNo(bkgForCopyVO.getScNo());
			bkgBookingVO.setRfaNo(bkgForCopyVO.getRfaNo());			
			bkgBookingVO.setPctlNo(targetBkg.getPctlNo());
			bkgBookingVO.setBkgCtrlPtyCustCntCd(bkgForCopyVO.getBkgCtrlPtyCustCntCd());	
			bkgBookingVO.setBkgCtrlPtyCustSeq(bkgForCopyVO.getBkgCtrlPtyCustSeq());	
			
		    String bdrVvd = dbDao.searchBdrLog(targetBkg.getPctlNo());
	    	if(bdrVvd!=null && bdrVvd.length()>0){
				throw new EventException((String)new ErrorHandler("BKG00071", new String[]{bdrVvd, "already Released"}).getMessage());
			}
	    	
			dbDao.addBkgBookingForCopySplit(bkgBookingVO);
			if(targetBkg.getPctlNo() != null && targetBkg.getPctlNo().length() > 0 
					&& !"FAIL".equals(targetBkg.getPctlNo().substring(0, 4))){
				dbDao.modifyBkgRouteFromPrd(targetBkg, "C");
			}
			
//			dbDao.copyBkgCustomerByBkg(sourceBkg, targetBkg, account);
			BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
			BlCustomerInfoVO schCustVO = dbDao.searchBkgCustomer("", sourceBkg);
			bkgCustomerVO.setBkgNo(targetBkg.getBkgNo());
			bkgCustomerVO.setUpdUsrId(account.getUsr_id());
			bkgCustomerVO.setCreUsrId(account.getUsr_id());
			bkgCustomerVO.setBkgCustTpCd("S");
			bkgCustomerVO.setCustCntCd(schCustVO.getSCustCntCd());
			bkgCustomerVO.setCustSeq(schCustVO.getSCustSeq());
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);
			bkgCustomerVO.setBkgCustTpCd("F");
			bkgCustomerVO.setCustCntCd(schCustVO.getFCustCntCd());
			bkgCustomerVO.setCustSeq(schCustVO.getFCustSeq());
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);
			bkgCustomerVO.setBkgCustTpCd("C");
			bkgCustomerVO.setCustCntCd("");
			bkgCustomerVO.setCustSeq("");
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);
			bkgCustomerVO.setBkgCustTpCd("N");
			bkgCustomerVO.setCustCntCd("");
			bkgCustomerVO.setCustSeq("");
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);
			bkgCustomerVO.setBkgCustTpCd("A");
			bkgCustomerVO.setCustCntCd("");
			bkgCustomerVO.setCustSeq("");
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);
			bkgCustomerVO.setBkgCustTpCd("E");
			bkgCustomerVO.setCustCntCd("");
			bkgCustomerVO.setCustSeq("");
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);

			dbDao.modifyCtrtInfo(targetBkg);
			
			String targetTVvd = dbDao.searchTrunkVvdByBkg(targetBkg);

			if(targetBkg.getPctlNo() != null && targetBkg.getPctlNo().length() > 0 
					&& !"FAIL".equals(targetBkg.getPctlNo().substring(0, 4))){
//				dbDao.addBkgVvdFromPrd(targetBkg, bkgBookingVO.getVslCd() + bkgBookingVO.getSkdVoyNo() + bkgBookingVO.getSkdDirCd(), account);
				dbDao.addBkgVvdFromPrd(targetBkg, targetTVvd, account);
			} else {							
				VslSkdVO[] vslSkdVOs = bookingCopyVO.getVslSkdVOs();
				for(int i = 0 ; i < vslSkdVOs.length ; i++){
					BkgVvdVO bkgVvdVO = new BkgVvdVO();
					bkgVvdVO.setBkgNo(targetBkg.getBkgNo());
					bkgVvdVO.setVslPrePstCd(vslSkdVOs[i].getVslPrePstCd());
					bkgVvdVO.setVslSeq(vslSkdVOs[i].getVslSeq());
					if(vslSkdVOs[i].getBkgVvdCd() != null && vslSkdVOs[i].getBkgVvdCd().length() == 9){
						bkgVvdVO.setVslCd(vslSkdVOs[i].getBkgVvdCd().substring(0,4));
						bkgVvdVO.setSkdVoyNo(vslSkdVOs[i].getBkgVvdCd().substring(4,8));
						bkgVvdVO.setSkdDirCd(vslSkdVOs[i].getBkgVvdCd().substring(8,9));
					}
					bkgVvdVO.setPolClptIndSeq(vslSkdVOs[i].getPolClptIndSeq());
					bkgVvdVO.setPodClptIndSeq(vslSkdVOs[i].getPodClptIndSeq());
					bkgVvdVO.setPolCd(vslSkdVOs[i].getPolCd());
					if(vslSkdVOs[i].getPolYdCd() != null && vslSkdVOs[i].getPolYdCd().length() > 0){
						bkgVvdVO.setPolYdCd(vslSkdVOs[i].getPolCd()+vslSkdVOs[i].getPolYdCd());	
					}	
					bkgVvdVO.setPodCd(vslSkdVOs[i].getPodCd());
					if(vslSkdVOs[i].getPodYdCd() != null &&vslSkdVOs[i].getPodYdCd().length() > 0){
						bkgVvdVO.setPodYdCd(vslSkdVOs[i].getPodCd()+vslSkdVOs[i].getPodYdCd());	
					}		
					bkgVvdVO.setCreUsrId(account.getUsr_id());
					bkgVvdVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBkgVvd(bkgVvdVO, targetBkg);
				}			
			}
			List<BkgQuantityVO> bkgQuantity = dbDao.searchBkgQuantityForCopy(bkgForCopyVO);
			for(int i = 0 ; i < bkgQuantity.size() ; i++){
				BkgQuantityVO bkgQuantityVO = bkgQuantity.get(i);
				bkgQuantityVO.setBkgNo(targetBkg.getBkgNo());
				bkgQuantityVO.setCreUsrId(account.getUsr_id());
				bkgQuantityVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBkgQuantity(bkgQuantityVO, targetBkg);
			}			
			
			List<BkgQtyDtlVO> bkgQtyDtl = dbDao.searchBkgQtyDtlForCopy(bkgForCopyVO);
			for(int i = 0 ; i < bkgQtyDtl.size() ; i++){
				BkgQtyDtlVO bkgQtyDtlVO = bkgQtyDtl.get(i);
				bkgQtyDtlVO.setBkgNo(targetBkg.getBkgNo());
				bkgQtyDtlVO.setCreUsrId(account.getUsr_id());
				bkgQtyDtlVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addBkgQtyDtl(bkgQtyDtlVO, targetBkg);
			}	
			
			dbDao.copyBkgCntcPsonByBkg(sourceBkg, targetBkg, account);
			
			dbDao.addBkgRollOvr(targetBkg, account);
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * split empty repo Booking<br>
	 * @param 		MtyBookingSplitVO mtyBookingSplitVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void splitMtyRepoBooking(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();			
			
			String mtySplitAvalCd = dbDao.searchMtyRepoBkgSts(mtyBookingSplitVO.getBkgBlNoVO());
			if(!"S".equals(mtyBookingSplitVO.getMtyBookingVO().getMtySplitAvalCd()) && ("C".equals(mtySplitAvalCd) || "Z".equals(mtySplitAvalCd) || "W".equals(mtySplitAvalCd))){
				throw new EventException((String)new ErrorHandler("BKG01000", new String[]{mtyBookingSplitVO.getBkgBlNoVO().getBkgNo()}).getMessage());
			}
			
			if("S".equals(mtyBookingSplitVO.getMtyBookingVO().getMtySplitAvalCd())){
				mtyBookingSplitVO.getMtyBookingVO().setMtySplitAvalCd(mtySplitAvalCd);
			}
			BkgBlNoVO newBkgBlNoVO = new BkgBlNoVO();
			newBkgBlNoVO.setBkgNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo());
			newBkgBlNoVO.setBlNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBlNo());

			if(dbDao.searchBkgBlNoDup(newBkgBlNoVO)){
				throw new EventException((String)new ErrorHandler("BKG00034",new String[]{newBkgBlNoVO.getBlNo()}).getMessage());
			}			
			
			dbDao.addBkgBlNoDup(newBkgBlNoVO, account.getUsr_id());
			
			dbDao.addNewSplitMtyRepoBkg(mtyBookingSplitVO.getBkgBlNoVO(), mtyBookingSplitVO.getMtyBookingVO(), mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo(), account);

			dbDao.copyBkgCustomerByBkg(mtyBookingSplitVO.getBkgBlNoVO(), newBkgBlNoVO, account);
			
			dbDao.modifyMtyRepoMstBkg(mtyBookingSplitVO.getBkgBlNoVO().getBkgNo(), account);

			MtyVvdVO[] mtyVvdVOs = mtyBookingSplitVO.getMtyVvdVOs();
			
			for(int i = 0 ; i < mtyVvdVOs.length ; i++){
				mtyVvdVOs[i].setPolCd(mtyVvdVOs[i].getPolYdCd().substring(0, 5));
				mtyVvdVOs[i].setPodCd(mtyVvdVOs[i].getPodYdCd().substring(0, 5));
				
				if(!utilBC.validateVvd(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd())){
					throw new EventException((String)new ErrorHandler("BKG00944").getMessage());
				}
				if(utilBC.searchEtbEtdEta(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd(), mtyVvdVOs[i].getPolCd(), mtyVvdVOs[i].getPolClptIndSeq()) == null){
					throw new EventException((String)new ErrorHandler("BKG00078",new String[]{mtyVvdVOs[i].getPolCd()}).getMessage());	
				}
				if(mtyVvdVOs[i].getPodCd().equals("XXXXXXX")){
					if(utilBC.searchEtbEtdEta(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd(), mtyVvdVOs[i].getPodCd(), mtyVvdVOs[i].getPodClptIndSeq()) == null){
						throw new EventException((String)new ErrorHandler("BKG00945",new String[]{mtyVvdVOs[i].getPodCd()}).getMessage());	
					}
				}
				if("T".equals(mtyVvdVOs[i].getVslPrePstCd())){
					dbDao.modifyTrunkVvd(mtyVvdVOs[i].getVslCd()+mtyVvdVOs[i].getSkdVoyNo()+mtyVvdVOs[i].getSkdDirCd(), newBkgBlNoVO, account);
				}
				BkgVvdVO bkgVvdVO = new BkgVvdVO();
				bkgVvdVO.setBkgNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo());
				bkgVvdVO.setVslPrePstCd(mtyVvdVOs[i].getVslPrePstCd());
				bkgVvdVO.setVslSeq(mtyVvdVOs[i].getVslSeq());
				bkgVvdVO.setVslCd(mtyVvdVOs[i].getVslCd());
				bkgVvdVO.setSkdVoyNo(mtyVvdVOs[i].getSkdVoyNo());
				bkgVvdVO.setSkdDirCd(mtyVvdVOs[i].getSkdDirCd());
				bkgVvdVO.setPolClptIndSeq(mtyVvdVOs[i].getPolClptIndSeq());
				bkgVvdVO.setPodClptIndSeq(mtyVvdVOs[i].getPodClptIndSeq());
				bkgVvdVO.setPolCd(mtyVvdVOs[i].getPolYdCd().substring(0, 5));
				bkgVvdVO.setPolYdCd(mtyVvdVOs[i].getPolYdCd());
				bkgVvdVO.setPodCd(mtyVvdVOs[i].getPodYdCd().substring(0, 5));
				bkgVvdVO.setPodYdCd(mtyVvdVOs[i].getPodYdCd());
				bkgVvdVO.setCreUsrId(account.getUsr_id());
				bkgVvdVO.setUpdUsrId(account.getUsr_id());

				dbDao.addBkgVvd(bkgVvdVO, newBkgBlNoVO);					
			}					
		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * complete split of empty repo booking<br>
	 * @param 		MtyBookingSplitVO mtyBookingSplitVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void completeMtyRepoBkgSplit(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();			
			
			String[] cntrArr = utilBC.searchCntrListByBkg(mtyBookingSplitVO.getBkgBlNoVO());
			boolean haveCntr = false;
			if(cntrArr.length>0){
				for(int i=0;i<cntrArr.length;i++){
					if(cntrArr[i]!=null && cntrArr[i].length()>9) haveCntr = true;
				}
			}
			if(haveCntr){
				dbDao.modifyBookingStatus("N", "N", "F", mtyBookingSplitVO.getBkgBlNoVO(), account);
			} else {
				dbDao.cancelMtyBkg(mtyBookingSplitVO.getBkgBlNoVO(), account);
			}
			dbDao.removeBkgQtyDtl(mtyBookingSplitVO.getBkgBlNoVO(), "");
			dbDao.removeBkgQuantity(null, mtyBookingSplitVO.getBkgBlNoVO(), "BKG");
			
			dbDao.addMtyBkgQtyFromCntr(mtyBookingSplitVO.getBkgBlNoVO(), account);

			BkgBlNoVO newBkgBlNoVO = new BkgBlNoVO();
			newBkgBlNoVO.setBkgNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo());
			newBkgBlNoVO.setBlNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBlNo());			

			dbDao.addMtyBkgQtyFromCntr(newBkgBlNoVO, account);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * Cancel Empty Booking<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void cancelMtyBkg(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeBkgQtyDtl(bkgBlNoVO, "");
			dbDao.removeBkgQuantity(null, bkgBlNoVO, "BKG");
			dbDao.cancelMtyBkg(bkgBlNoVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * update from vsk_vsl_port_skd-side modifications to bkg_vvd 
	 * @param 		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs
	 * @param 		SignOnUserAccount account
	 * @throws 		EventException
	 */
	public void modifyBkgVvdForVslSkdCng(List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs, SignOnUserAccount account)throws EventException{
		try {
			for(int icnt=0;icnt<vslSkdCngUpdateVOs.size();icnt++){
				VslSkdCngUpdateVO vslSkdCngUpdateVO = vslSkdCngUpdateVOs.get(icnt);
				if(vslSkdCngUpdateVO.getVvd() == null || vslSkdCngUpdateVO.getVvd().length() != 9){
					throw new EventException((String)new ErrorHandler("BKG00007").getMessage());
				}			
				
				if(vslSkdCngUpdateVO.getPortCd() == null || vslSkdCngUpdateVO.getPortCd().length() != 5){
					throw new EventException((String)new ErrorHandler("BKG00424").getMessage());
				}			
				if(vslSkdCngUpdateVO.getNewClptIndSeq() == null || vslSkdCngUpdateVO.getOldClptIndSeq() == null){
					if(vslSkdCngUpdateVO.getNewYdCd() == null || vslSkdCngUpdateVO.getOldYdCd() == null){
						throw new EventException((String)new ErrorHandler("BKG00841").getMessage());
					}
				}

				dbDao.modifyBkgRouteForVslSkdCng(vslSkdCngUpdateVO, account);
	            dbDao.modifyPolForVslSkdCng(vslSkdCngUpdateVO, account);
				dbDao.modifyPodForVslSkdCng(vslSkdCngUpdateVO, account);
			}

		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * create/update Booking information about Empty Repo Booking
	 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyMtyRepoBkg(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();	
//			RepoCntrVO[] repoCntrVOs = repoBkgForUpdateVO.getRepoCntrVOs();
//			if(repoCntrVOs.length > 800){
//				throw new EventException((String)new ErrorHandler("BKG00947").getMessage());
//			}
			BkgBlNoVO bkgBlNoVO = repoBkgForUpdateVO.getBkgBlNoVO();
			if(!"P".equals(utilBC.searchBkgCgoTp(bkgBlNoVO))){
				throw new EventException((String)new ErrorHandler("BKG00946").getMessage());
			}
			
			dbDao.modifyMtyBkgBooking(repoBkgForUpdateVO.getRepoBkgVO(), account);		

		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}		
	
	/**
	 * complete to save Container information of empty repo booking
	 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
	 * @param 		SignOnUserAccount account
	 * @return		List<BkgQuantityVO>
	 * @exception 	EventException
	 */
	public List<BkgQuantityVO> completeModifyMtyRepoBkg(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();
			List<BkgQuantityVO> bkgQtyVO = null;
		
			String bkgNo = repoBkgForUpdateVO.getBkgBlNoVO().getBkgNo();
			String masterBkgNo = "";
			BkgBlNoVO masterBkgBlNoVO = new BkgBlNoVO();
			boolean isMasterBkgNo = false;
			if(bkgNo.length() == 11){
				isMasterBkgNo = true;
			}else if(bkgNo.length() == 13){
				masterBkgNo = bkgNo.substring(0,11);
				masterBkgBlNoVO.setBkgNo(masterBkgNo);
			}else{
				masterBkgNo = utilBC.searchSplitMstBkgNo(bkgNo);
				if(masterBkgNo == null || masterBkgNo.length() < 1){
					isMasterBkgNo = true;
				}else{
					masterBkgBlNoVO.setBkgNo(masterBkgNo);
				}
			}			

			String[] cntrArr = utilBC.searchCntrListByBkg(repoBkgForUpdateVO.getBkgBlNoVO());
			String[] mstCntrArr = utilBC.searchCntrListByBkg(masterBkgBlNoVO);

			if(cntrArr.length> 0 || mstCntrArr.length>0){
				dbDao.removeBkgQtyDtl(repoBkgForUpdateVO.getBkgBlNoVO(), null);
				dbDao.removeBkgQuantity(null, repoBkgForUpdateVO.getBkgBlNoVO(), "BKG");
				
				dbDao.addMtyBkgQtyFromCntr(repoBkgForUpdateVO.getBkgBlNoVO(), account);
			}
			
			bkgQtyVO = dbDao.searchBkgQuantity(repoBkgForUpdateVO.getBkgBlNoVO());
			if(!isMasterBkgNo){ 
				dbDao.removeBkgQtyDtl(masterBkgBlNoVO, null);
				dbDao.removeBkgQuantity(null, masterBkgBlNoVO, "BKG");				
				dbDao.addMtyBkgQtyFromCntr(masterBkgBlNoVO, account);
				
				boolean haveCntr = false;
				if(mstCntrArr.length>0){
					for(int i=0;i<mstCntrArr.length;i++){
						if(mstCntrArr[i]!=null && mstCntrArr[i].length()>9) haveCntr = true;
					}
				}
				if(haveCntr){
					dbDao.modifyBookingStatus("N", "N", "F", masterBkgBlNoVO, account);	
				} else {
					dbDao.cancelMtyBkg(masterBkgBlNoVO, account);	
				}
				
				String[] cntrNoArr =  utilBC.searchCntrListByBkg(repoBkgForUpdateVO.getBkgBlNoVO());
				
				haveCntr = false;
				if(cntrNoArr.length>0){
					for(int i=0;i<cntrNoArr.length;i++){
						if(cntrNoArr[i]!=null && cntrNoArr[i].length()>9) haveCntr = true;
					}
				}
				if(haveCntr == false){
					dbDao.cancelMtyBkg(repoBkgForUpdateVO.getBkgBlNoVO(), account);
				}				
			} else {


			}
			
			return bkgQtyVO;		
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * modify forwarder code and vsl reference information by Booking in Malaysia(ESM_BKG_0616)
	 * @param FwrdRefVvdVO[] fwrdRefVvdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageMyFwrdRefVvd(FwrdRefVvdVO[] fwrdRefVvdVO, SignOnUserAccount account) throws EventException {
		try {
			if (fwrdRefVvdVO != null) {
				for (int i=0;i<fwrdRefVvdVO.length;i++) {
					if(!"Y".equals(dbDao.searchMyFwrdRefCd(fwrdRefVvdVO[i]))){
						throw new EventException(new ErrorHandler("BKG00651", new String[]{"Forwarder("+fwrdRefVvdVO[i].getMyFwrdRefCd()+")"}).getMessage());
					}
					dbDao.modifyMyFwrdRefVvd(fwrdRefVvdVO[i], account);
				}
			}
		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}  

	/**
	 * modify spcl flag of bkg_booking from modified data after split, combine
	 * @param 		BkgBlNoVO[] bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifySpclFlag(BkgBlNoVO[] bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try{
			for(int i=0;i<bkgBlNoVO.length;i++){
				dbDao.modifySpclFlag(bkgBlNoVO[i], account);	
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * modify only Ocean Route of Booking
	 * @param VvdAssignVO vvdAssignVO
	 * @param SignOnUserAccount account
	 * @return BdrSpclVO
	 * @exception EventException
	 */
	public BdrSpclVO modifyOceanRoute(VvdAssignVO vvdAssignVO, SignOnUserAccount account)throws EventException {
		try{
			BookingUtil utilBC = new BookingUtil();
			BdrSpclVO bdrSpclVO = new BdrSpclVO();
			
			if(vvdAssignVO.getVvdPortAssinVOs()!=null){
				if(vvdAssignVO.getBkgBlNoVO().getPctlNo() == null ||"FAIL".equals(vvdAssignVO.getBkgBlNoVO().getPctlNo().substring(0, 4))){
					throw new EventException((String)new ErrorHandler("BKG00309").getMessage());
				}				
			}
			
			if (vvdAssignVO.getBkgBlNoVO().getPctlNo().equals("")){
				dbDao.modifyBkgVvdForAssign(vvdAssignVO.getBkgBlNoVO(),vvdAssignVO.getOldNewVvdVO().getOldvvd(),vvdAssignVO.getOldNewVvdVO().getNewvvd(),account);
			}else{
				dbDao.modifyBkgRouteFromPrd(vvdAssignVO.getBkgBlNoVO(), "U");
				
				dbDao.removeBkgVvd(vvdAssignVO.getBkgBlNoVO());
				dbDao.addBkgVvdFromPrd(vvdAssignVO.getBkgBlNoVO(), null, account);
			}

			if(vvdAssignVO.getOldNewVvdVO()!=null){
				dbDao.modifyNewVvdOopCd(vvdAssignVO.getBkgBlNoVO(), vvdAssignVO.getOldNewVvdVO(), account);
			}

			if (dbDao.searchHasSpcl(vvdAssignVO.getBkgBlNoVO())){
				bdrSpclVO.setSpclcgoflag("Y");
			}else{
				bdrSpclVO.setSpclcgoflag("N");
			}
			String sBdrFlg=utilBC.searchBdrFlgByBkg(vvdAssignVO.getBkgBlNoVO());
			bdrSpclVO.setBdrflag(sBdrFlg);
			return bdrSpclVO;
		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * modify to force the status of Booking<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void compFirm(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)throws EventException {
		try {
			dbDao.modifyBookingStatus("N", "N", "F", bkgBlNoVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

    /**
     * save entered information from COD at C/A in progress
     * @param BkgBlNoVO bkgBlNoVO
     * @param String codRqstSeq
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyTempHistForCOD (BkgBlNoVO bkgBlNoVO, String codRqstSeq, SignOnUserAccount account) throws EventException{
    	try {
    		bkgBlNoVO.setCaNo("TMP0000001");
    		dbDao.removeBkgVvdHis(bkgBlNoVO);
    		dbDao.addBkgVvdHisFromCod(bkgBlNoVO, codRqstSeq, account);
    		dbDao.modifyBkgBkgHisFromCod(bkgBlNoVO, codRqstSeq, account);
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
    	}
    }
    
    /**
     * save entered VoidQty at SpecialCargo
     * @param String bkgNo
     * @param String ovrVoidSltQty
     * @param  String caFlg
     * @exception EventException
     */
    public void modifyBbVoidQty (String bkgNo, String ovrVoidSltQty, String caFlg) throws EventException{
    	try {
    		
    		dbDao.modifyBbVoidQty(bkgNo,  ovrVoidSltQty, caFlg);
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
    	}
    }
    
	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * Customer Code Validation Unmatch update<br>
	 * @param CustCdEvaluationVO[] custCdVal
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void modifyCustCdValInfo(CustCdEvaluationVO[] custCdVal, SignOnUserAccount account) throws EventException {
		try {
			
			List<CustCdEvaluationVO> custCdEvaluations = new ArrayList<CustCdEvaluationVO>();
			for (int i= 0; i < custCdVal.length; i ++) {
				custCdVal[i].setUsrId(account.getUsr_id());  // val_usr_id
				custCdVal[i].setOfcCd(account.getOfc_cd());  // val_office_cd
				custCdEvaluations.add(custCdVal[i]);
			}

			dbDao.modifyCustCdValInfo(custCdEvaluations);			
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
    }
    /**
     * Modify Arrival Notice records
     * @param ArrNtcCustListVO[] arrNtcCustListVOS
     * @throws EventException
     */
    public void modifyArrNtcCustChgFlg ( ArrNtcCustListVO[] arrNtcCustListVOS)throws EventException {
    	try {
    		for (int i = 0; i < arrNtcCustListVOS.length; i++) {
				ArrNtcCustListVO arrNtcCustListVO = arrNtcCustListVOS[i];
				//BkgArrNtcDtlVO bkgArrNtcDtlVO = new BkgArrNtcDtlVO(); 
				dbDao.modifyArrNtcChgDpFlg(arrNtcCustListVO);
    		}

						
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
    }
	/**
     * UI_BKG-1054 Customer Code Validation<br>
     * Matched information Customer Code Validation changes Unmatch
	 * @param String bkgNo
	 * @param String bkgCustTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCustCdValInfo(String bkgNo, String bkgCustTpCd, SignOnUserAccount account) throws EventException {
		try {
			
			dbDao.removeCustCdValInfo(bkgNo, bkgCustTpCd, account.getUsr_id());

        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * UI-BKG-1054 Customer Code Validation<br>
	 * modify match about matching information  after comparing Booking Customer and MDM.<br>
	 * @param ArrNtcSearchVO arrNtcSearch retrieve condition
	 * @throws EventException
	 */
	public void modifyBkgCustValInfo(ArrNtcSearchVO arrNtcSearch ) throws EventException {
		try {
			
			dbDao.modifyBkgCustValInfo(arrNtcSearch);

        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Inbound - Remove Customer Code Validation<br>
	 * removde Customer Code Validation as Booking unit<br>
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void cancelCustCdVal(String bkgNo) throws EventException {
		try {
			dbDao.cancelCustCdVal(bkgNo);

        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}

    
	/**
	 * Inbound - UI-BKG-0941 - Customer Code Error Report Confirm<br>
	 * Code Validation result revaluation<br>
	 * @param ArrNtcCustCodeErrListVO[] custCodeErrLists
	 * @throws EventException
	 */
	public void confirmCustCdErrReport(ArrNtcCustCodeErrListVO[] custCodeErrLists ) throws EventException {
		try {
			
//			List<ArrNtcCustCodeErrListVO> arrNtcCustCodeErrList = new ArrayList<ArrNtcCustCodeErrListVO>();
//			for (int i= 0; i < custCodeErrLists.length; i ++) {
//				arrNtcCustCodeErrList.add(custCodeErrLists[i]);
//			}
//
			dbDao.confirmCustCdErrReport(custCodeErrLists);

        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}

	/**
     * ocean route Validation<br>
     * Want to change the route is registered as an ocean route to make sure that.
	 * @param 		PrdMainInfoVO prdMainInfoVO
	 * @exception 	EventException
	 */
	public void validateOceanRoute(PrdMainInfoVO prdMainInfoVO) throws EventException{
		try {
			ValidateOceanRouteVO validateOceanRouteVO = dbDao.validateOceanRoute(prdMainInfoVO);
			int copCount   = Integer.parseInt(validateOceanRouteVO.getCopCount());
			int routeCount = Integer.parseInt(validateOceanRouteVO.getRoute());
			
			if(routeCount == 0 || routeCount > 1){
				String strErrMsg = prdMainInfoVO.getPor()+"-"+prdMainInfoVO.getPol1()+"-("+prdMainInfoVO.getLane1()+")-"+prdMainInfoVO.getPod1();
				if(prdMainInfoVO.getPol2()!=null&&prdMainInfoVO.getPol2().length()>0){
					strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol2()+"-("+prdMainInfoVO.getLane2()+")"+prdMainInfoVO.getPod2();
				}
				if(prdMainInfoVO.getPol3()!=null&&prdMainInfoVO.getPol3().length()>0){
					strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol3()+"-("+prdMainInfoVO.getLane3()+")-"+prdMainInfoVO.getPod3();
				}

				if(prdMainInfoVO.getPol4()!=null&&prdMainInfoVO.getPol4().length()>0){
					strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol4()+"-("+prdMainInfoVO.getLane4()+")-"+prdMainInfoVO.getPod4();
				}
				strErrMsg = strErrMsg + "-" + prdMainInfoVO.getDel();
				log.debug(strErrMsg);
				throw new EventException((String)new ErrorHandler("BKG02030", new String[]{strErrMsg}).getMessage());
			}
			
			if(copCount == 0){
				throw new EventException((String)new ErrorHandler("BKG02031", new String[]{prdMainInfoVO.getBkgNo()}).getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	/**
     * create cargo Closing Time<br>
     * @param BkgBlNoVO bkgBlNoVO
     * @param String fromDt
     * @param String toDt
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCargoClosingTime(BkgBlNoVO bkgBlNoVO, String fromDt, String toDt, SignOnUserAccount account) throws EventException{
		try{
			dbDao.addCargoClosingTime(bkgBlNoVO, account);
			dbDao.modifyCargoClosingTimeByReplan(bkgBlNoVO, fromDt, toDt, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
     * retrieve bkg_quantity for calculating rail receiving time
     * @param BkgBlNoVO bkgBlNoVO
     * @return PrdQtyInfoVO[]
	 * @exception EventException
	 */
	public PrdQtyInfoVO[] searchBkgQtyForRailTime(BkgBlNoVO bkgBlNoVO) throws EventException{
		try{
			List<BkgQuantityVO> bkgQuantityVOs = dbDao.searchBkgQuantity(bkgBlNoVO);
			PrdQtyInfoVO[] prdQtyInfo 	= new PrdQtyInfoVO[bkgQuantityVOs.size()];
			
			for(int i = 0 ; i < bkgQuantityVOs.size() ; i++){	
				prdQtyInfo[i] = new PrdQtyInfoVO();				
				prdQtyInfo[i].setCTpsz(bkgQuantityVOs.get(i).getCntrTpszCd());
				prdQtyInfo[i].setCQty(bkgQuantityVOs.get(i).getOpCntrQty());				
			}
			return prdQtyInfo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		
	}
    /**
     * SVC_SCP_CD瑜�議고쉶�쒕떎.
     * @param String trnkLaneCd
     * @param String porCd
     * @param String delCd
     * @return String
     */
    public String searchSvcScope(String trnkLaneCd, String porCd, String delCd) throws EventException {
		try {
			return dbDao.searchSvcScope(trnkLaneCd, porCd, delCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex); 
		}
	}

	/**
     * trunk vvd among typed vvd is calculated based on the coa voyage.<br>
     * @param PolPodVvdVO[] polPodVvdVOs
     * @return String
	 * @exception EventException
	 */
	public String searchTrnkVvdByRlane(PolPodVvdVO[] polPodVvdVOs) throws EventException{
		try{
			return dbDao.searchTrnkVvdByRlane(polPodVvdVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	/**
     * retrieve whether c/a tmp deletes
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
     * @throws EventException
     */
	public String searchCaTmp(BkgBlNoVO bkgBlNoVO)throws EventException{
		try{
			return dbDao.searchCaTmp(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
     * retrieve P/O no at eBkg
     * @param BkgBlNoVO bkgBlNoVO
     * @return PoOtherNoVO
     * @throws EventException
     */
	public PoOtherNoVO searchPoOtherNoByXter(BkgBlNoVO bkgBlNoVO) throws EventException{
		PoOtherNoVO rPoOtherNoVO = new PoOtherNoVO(); 
		try {
			PoOtherNoBkgVO poOtherNoBkgVO = new PoOtherNoBkgVO();
			poOtherNoBkgVO.setBkgNo(bkgBlNoVO.getBkgNo());
			
			// 1. Search byCntr
			rPoOtherNoVO.setO_poOtherCntrVOs(dbDao.searchPoNoByCntr(poOtherNoBkgVO));

			if(rPoOtherNoVO.getO_poOtherCntrVOs().size()>0){
				poOtherNoBkgVO.setCntrNo(rPoOtherNoVO.getO_poOtherCntrVOs().get(0).getCCntrNo());
			}
			
			// 2. Search byBKG
			List<PoOtherNoBkgVO> rPoOtherNoBkgVOs = dbDao.searchPoNoByBkg(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherNoBkgVOs(rPoOtherNoBkgVOs);
			//3.Search byCM
			List<PoOtherCmVO> rPoOtherCmVOs = dbDao.searchPoNoByCm(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherCmVOs(rPoOtherCmVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}
		return rPoOtherNoVO;
	}


	/**
     * retrieve CBF in case of split at booking split screen
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
	 * @param SignOnUserAccount account
     * @throws EventException
     */
	public String searchCbfFlag(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException{
		String cbfFlag = "N";
		BookingUtil             util        = new BookingUtil();
		
		try {			
				boolean isCbfFinal = false;
				BkgCloseVO bkgCloseVO = util.searchBkgCbf(bkgBlNoVO);
				if(bkgCloseVO != null && bkgCloseVO.getNewVvd() != null && !bkgCloseVO.getNewVvd().trim().equals("")){
					String[] arrCBF  = dbDao.searchCBFBS(bkgCloseVO.getNewVvd().substring(0, 4), bkgCloseVO.getNewVvd().substring(4, 8), bkgCloseVO.getNewVvd().substring(8, 9), bkgCloseVO.getNewYdCdSeq());
					for (int i=0;i<arrCBF.length;i++){
						if("Final".equals(arrCBF[i])){
							isCbfFinal = true;
							break;
						}
					}
				
					if(arrCBF != null && isCbfFinal == true){
						cbfFlag = "Y";
					} else {
						cbfFlag = "N";
					}
				}
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}
		return cbfFlag;
	}

	/**
     * modify cargo Closing Time<br>
     * @param BkgClzTmVO bkgClzTmVO
	 * @exception EventException
	 */
	public void modifyCargoClosingTime(BkgClzTmVO bkgClzTmVO) throws EventException{
		try{
			dbDao.modifyCargoClosingTime(bkgClzTmVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	/**
	 * ESM_BKG_0702 : customer click <br>
	 * transmit Customer information Flat File as EDI
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param CustTpIdVO[] custTpIdVO
	 * @param String typeGbn
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String sendBkgCustEdiMulti(BkgBlNoVO[] bkgBlNoVO, CustTpIdVO[] custTpIdVO, String typeGbn, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = null;
		SendBkgCustEdiMultiBackEndJob backEndJob = null;
		String jobID = null;
		try {
			backEndJobManager = new BackEndJobManager();
			backEndJob = new SendBkgCustEdiMultiBackEndJob(bkgBlNoVO, custTpIdVO, typeGbn, account);
			jobID = backEndJobManager.execute(backEndJob, account.getUsr_id(), "SendBkgCustEdiMultiBackEndJob");
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return jobID;
	}

	/**
	 * transmission as Customer EDI, BackEndJob result confirmation<br>
	 * @param String key
	 * @return String
	 * @throws EventException
	 */
	public String searchSendBkgCustEdiMulti(String key) throws EventException {
		String result = null;
		try {
			result = eaiDao.searchSendBkgCustEdiMulti(key);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return result;
	}

	/**
	 * BKG_Quantity �뺣낫瑜�議고쉶�쒕떎.
	 * @param bkgBlNoVO
	 * @return List<BkgQuantityVO>
	 * @throws EventException
	 */
	public List<BkgQuantityVO> searchBkgQuantity(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchBkgQuantity(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	
	/**
	 * SI_FLG 瑜�議고쉶�쒕떎.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSiFlg(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchSiFlg(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * Allocation Status瑜�manage�쒕떎.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param SignOnUserAccount account
	 * @param String docTpCd
	 * @return AllocStsChgVO
	 * @throws EventException
	 */
	public AllocStsChgVO manageAlocStatus(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String docTpCd) throws EventException{
		List<AllocStsVO> allocStsVOs = new ArrayList<AllocStsVO>();
		try {
			BookingUtil util = new BookingUtil();
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("BKG_VALIDATION");			
			List<BkgHrdCdgCtntVO> alocStatusSwitch = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			AllocStsChgVO allocStsChgVO = new AllocStsChgVO();
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			
			String alocPopFlg = "N";
			String firmMsgFlg = "N";
			allocStsChgVO.setAlocPopFlg(alocPopFlg);
			allocStsChgVO.setFirmMsgFlg(firmMsgFlg);
			
			if(alocStatusSwitch.size() > 0){
				for(int i = 0; i < alocStatusSwitch.size(); i++){
					if("ALLOC_PROCESS".equals(alocStatusSwitch.get(i).getAttrCtnt1())
							&& "OFF".equals(alocStatusSwitch.get(i).getAttrCtnt2())){
						//return "N";
						allocStsChgVO.setAlocPopFlg("N");
						return allocStsChgVO;
					}
				}
			}
			if(!dbDao.checkEtdForAloc(bkgBlNoVO)){
				//return "N";
				allocStsChgVO.setAlocPopFlg("N");
				return allocStsChgVO;
			}
			
			// PKGSC User 媛�SI ���뚯뿉��Standby BKG Process �곸슜 ����
//			if(docTpCd != null && ("S".equals(docTpCd))||"U".equals(docTpCd)||"B".equals(docTpCd)){ // 0229_01 �먯꽌 �몄텧
			if(docTpCd != null && !"".equals(docTpCd)){ // 0229_01 �먯꽌 �몄텧
				if(("S".equals(docTpCd)||"U".equals(docTpCd)) && "PKGSC".equals(account.getOfc_cd())){
					allocStsChgVO.setAlocPopFlg("N");
					return allocStsChgVO;
				}
			}else{ //0079_01, 0079_05, 0079_08
				String siFlg = dbDao.searchSiFlg(bkgBlNoVO);
				if(siFlg != null && "Y".equals(siFlg) && "PKGSC".equals(account.getOfc_cd())){
					allocStsChgVO.setAlocPopFlg("N");
					return allocStsChgVO;
				}
			}
			
			String mixRsnFlg = "N";
			String manualExistFlg = "N";
			String autoExistFlg = "N";
			
			//trunk lane 
			AllocStsVO allocStsVO = dbDao.searchAllocStsByTrunkLane(bkgBlNoVO);
			if(allocStsVO != null){
				allocStsVOs.add(allocStsVO);
				if("M".equals(allocStsVO.getAlocSvcCd())){
					manualExistFlg = "Y";
				} else if("A".equals(allocStsVO.getAlocSvcCd())){
					autoExistFlg = "Y";
				}
			}
			//t/s
			allocStsVO = dbDao.searchAllocStsByTransshipment(bkgBlNoVO);
			if(allocStsVO != null){
				allocStsVOs.add(allocStsVO);
				if("M".equals(allocStsVO.getAlocSvcCd())){
					manualExistFlg = "Y";
				} else if("A".equals(allocStsVO.getAlocSvcCd())){
					autoExistFlg = "Y";
				}
			}			
			//equipment
			if(allocStsVOs.size() >= 2 && manualExistFlg.equals("Y")){ 
				mixRsnFlg = "Y";
			} else {
				allocStsVO = dbDao.searchAllocStsByEquipment(bkgBlNoVO);
				if(allocStsVO != null){
					allocStsVOs.add(allocStsVO);
					if("M".equals(allocStsVO.getAlocSvcCd())){
						manualExistFlg = "Y";
					} else if("A".equals(allocStsVO.getAlocSvcCd())){
						autoExistFlg = "Y";
					}
				}			
			}					
			//commodity
			if(allocStsVOs.size() >= 2 && manualExistFlg.equals("Y")){
				mixRsnFlg = "Y";
			} else {
				allocStsVO = dbDao.searchAllocStsByCommodity(bkgBlNoVO);
				if(allocStsVO != null){
					allocStsVOs.add(allocStsVO);
					if("M".equals(allocStsVO.getAlocSvcCd())){
						manualExistFlg = "Y";
					} else if("A".equals(allocStsVO.getAlocSvcCd())){
						autoExistFlg = "Y";
					}
				}			
			}			
			//customer
			if(allocStsVOs.size() >= 2 && manualExistFlg.equals("Y")){
				mixRsnFlg = "Y";
			} else {
				allocStsVO = dbDao.searchAllocStsByCustomer(bkgBlNoVO);
				if(allocStsVO != null){
					allocStsVOs.add(allocStsVO);
					if("M".equals(allocStsVO.getAlocSvcCd())){
						manualExistFlg = "Y";
					} else if("A".equals(allocStsVO.getAlocSvcCd())){
						autoExistFlg = "Y";
					}
				}			
			}

			if(allocStsVOs.size() >= 2){
				mixRsnFlg = "Y";
			}
			
			if(allocStsVOs.size() > 0){
				allocStsVO = allocStsVOs.get(0);
			}			
			if(allocStsVO != null){
				if(mixRsnFlg.equals("Y")){
					allocStsVO.setBkgAlocTpCd("X");
				}
				if("Y".equals(manualExistFlg)){
					alocPopFlg = "Y";					
				}
				if("Y".equals(manualExistFlg)){
					allocStsVO.setAlocSvcCd("M");
				} else {
					allocStsVO.setAlocSvcCd("A");
				}
			}
			
			String oriAlocStsCd = dbDao.searchAlocStsCdByBkgNo(bkgBlNoVO);
			int updCnt = dbDao.modifyAllocStatus(bkgBlNoVO, (allocStsVO != null)?allocStsVO:null, account);
			
			List<BkgCntcPsonVO> bkgCntcPsonVOs = dbDao.searchBkgCntcPson(bkgBlNoVO);
			String rcvrEml = "";
			for(int i = 0; i < bkgCntcPsonVOs.size(); i++){
				if(bkgCntcPsonVOs.get(i).getBkgCntcPsonTpCd().equals("BK")){
					rcvrEml = bkgCntcPsonVOs.get(i).getCntcPsonEml();
				}
			}	
			// Standby Notice
			if( allocStsVO != null && allocStsVO.getAlocStsCd()!=null && "S".equals(allocStsVO.getAlocStsCd()) && "N".equals(alocPopFlg)
					&& ( oriAlocStsCd==null || "".equals(oriAlocStsCd) || oriAlocStsCd.equals("F") ) ){			
				// popUp �덈쑉硫댁꽌 ""->S, F->S ����Stanby Notice 諛쒖넚
				if(rcvrEml != null && rcvrEml.length() > 0){
					String custRefNoCtnt = dbDao.searchCustRefNoCtnt(bkgBlNoVO, "EBRF");
					bkgNtcHisVOs = eaiDao.sendStandByNotice(bkgBlNoVO, rcvrEml, account, custRefNoCtnt);
					allocStsChgVO.setBkgNtcHisVOs(bkgNtcHisVOs);
				}
				allocStsChgVO.setNtcKndCd("SB");
			}
			// Booking Reciept Notice
			else if((oriAlocStsCd!=null && oriAlocStsCd.equals("S") && (allocStsVO==null ||(allocStsVO.getAlocStsCd()!=null && allocStsVO.getAlocStsCd().equals("F"))))){
//				// S->F ����Booking Reciept Notice 諛쒖넚
//				// rcvrEml ��媛��덉쑝硫�SC �먯꽌 Booking Reciept Notice 諛쒖넚
//				if(rcvrEml != null && rcvrEml.length() > 0){
//					allocStsChgVO.setRcvrEml(rcvrEml);
//				}
				firmMsgFlg = "Y";// Reciep Notice ��떊 硫붿떆吏�蹂댁뿬以�
				allocStsChgVO.setNtcKndCd("BK");// SC �먯꽌 Customer301, Vendor301
			}		
			
			log.debug("mixRsnFlg:"+mixRsnFlg+" alocPopFlg:"+alocPopFlg
					+" autoExistFlg:"+autoExistFlg+" manualExistFlg:"+manualExistFlg+" updCnt:"+updCnt);
			
			if(oriAlocStsCd != null){
				allocStsChgVO.setOriAlocStsCd(oriAlocStsCd);
			}else{
				allocStsChgVO.setOriAlocStsCd("");
			}
			if(allocStsVO!=null && allocStsVO.getAlocStsCd()!=null ){
				allocStsChgVO.setAlocStsCd(allocStsVO.getAlocStsCd());
			}else{
				allocStsChgVO.setAlocStsCd("F");
			}
			
			allocStsChgVO.setAlocPopFlg(alocPopFlg);
			allocStsChgVO.setFirmMsgFlg(firmMsgFlg);
			return allocStsChgVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}		
	
	/**
	 * EXPORT REFERENCES瑜�議고쉶�쒕떎.
	 * @param ExportReferencesVO exportReferencesVO
	 * @return List<ExportReferencesVO>
	 * @exception EventException
	 */
	public List<ExportReferencesVO> searchExportReferencesByBkg(ExportReferencesVO exportReferencesVO) throws EventException {

		try {
			// 1. Search byBKG
			return dbDao.searchExportReferencesByBkg(exportReferencesVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}
	}
	
	/**
	 * EXPORT REFERENCES瑜�議고쉶�쒕떎.(BY CNTR)
	 * @param ExportReferencesVO exportReferencesVO
	 * @return List<ExportReferencesVO>
	 * @exception EventException
	 */
	public List<ExportReferencesVO> searchExportReferencesByCntr(ExportReferencesVO exportReferencesVO) throws EventException {

		try {
			// 1. Search byCNTR
			return dbDao.searchExportReferencesByCntr(exportReferencesVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}
	}	
	/**
	 * roll over �뺣낫瑜�update<br>
	 * 
	 * @author 		
	 * @param 	  BkgRollOvrVO[] bkgRollOvrVOs
	 * @exception EventException
	 */
	public void manageBkgRollOver(BkgRollOvrVO[] bkgRollOvrVOs)throws EventException{
		try {
			  for(int i=0;i<bkgRollOvrVOs.length;i++){
				  if (bkgRollOvrVOs[i].getIbflag().equals("U")){
//					  log.error(bkgRollOvrVOs[i]);
					  dbDao.modifyBkgRollOvrRsn(bkgRollOvrVOs[i]);
				  }
			  }
			  
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
     * return booking vvd information.<br>
     * @param BkgBlNoVO bkgBlNoVO
     * @return List<BkgVvdVO>
	 * @exception EventException
	 */
	public List<BkgVvdVO> searchBkgVvd(BkgBlNoVO bkgBlNoVO) throws EventException{
		try{
			return dbDao.searchBkgVvd(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * VSL_SEQ瑜�議고쉶�쒕떎.
	 * @param bkgNo
	 * @param vvdCd
	 * @return
	 * @throws EventException
	 */
	public List<BkgVvdVO> searchVslSeqList(String bkgNo, String vvdCd) throws EventException{
		try{
			return dbDao.searchVslSeqList(bkgNo, vvdCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * eBooking S/I�먯꽌 BKG�쇰줈 �낅줈�쒕맂 Customer Name & Address��Overlfow �щ�瑜�議고쉶�쒕떎.
	 *
	 * @param XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO
	 * @return XterCustOvflwFlgStatusVO
	 * @exception DAOException
	 */
	public XterCustOvflwFlgStatusVO searchXterCustOvrLenFlgStatus(XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO) throws EventException {
		try {
			return dbDao.searchXterCustOvrLenFlgStatus(xterCustOvflwFlgStatusVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}
	}
	
	/**
	 * Booking cutomer tab�먯꽌 cleared��customer �뺣낫瑜��낅뜲�댄듃 �쒕떎.
	 *
	 * @param XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO
	 * @param String[] custTpcd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterCustOverFlowStatus(XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO, String[] custTpcd, SignOnUserAccount account) throws EventException{
		try{
			String xterRqstNo = xterCustOvflwFlgStatusVO.getXterRqstNo();
			String xterRqstSeq = xterCustOvflwFlgStatusVO.getXterRqstSeq();
			for(int i = 0 ; i < custTpcd.length; i++){
				dbDao.modifyXterCustOverFlowStatus(xterRqstNo, xterRqstSeq, custTpcd[i], account.getUsr_id());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * 
	 * @param bkgNo
	 * @return
	 * @throws EventException
	 */
	public List<SearchBkgContainerVO> searchBkgContainerNo(String bkgNo) throws EventException{
		try {
			return dbDao.searchBkgContainerNo(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
     * Change booking status 'F' when Reactivate
     * 
     * @author      KOUNGIL MOON
     * @param       String bkgNo
     * @exception   EventException
     */
    public void reactBkgStatus(String bkgNo) throws EventException {
    	try {       
            dbDao.reactBkgStatus(bkgNo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
	 * Check Dummy customer list from Hard coding table
	 * @param String custCntCd
	 * @param String custSeq
	 * @throws EventException
	 */
	public void searchDmyCustCnt (String custCntCd, String custSeq) throws EventException {
		
		try {
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			BookingUtil util = new BookingUtil();
			
			bkgHrdCdgCtntListCondVO.setHrdCdgId("BKG_DMY_CUST");
			bkgHrdCdgCtntListCondVO.setAttrCtnt1(custCntCd);
			bkgHrdCdgCtntListCondVO.setAttrCtnt2(custSeq);
			
			List<BkgHrdCdgCtntVO> list = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			if(list.size() > 0){
				throw new EventException((String)new ErrorHandler("BKG00076", new String[]{custCntCd+custSeq+" "}).getMessage());
			}
		} catch (EventException ex) {
			throw ex;								
		} catch (Exception de) {
		        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
}
