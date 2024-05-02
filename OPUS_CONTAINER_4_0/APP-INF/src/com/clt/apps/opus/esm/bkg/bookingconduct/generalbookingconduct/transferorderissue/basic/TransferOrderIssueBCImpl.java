/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueBCImpl.java
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration.TransferOrderIssueDBDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.AwkSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgEurCntrListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgInfoForTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroActCustExtVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.DgSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurPayerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroChangeVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.QtyInfoForTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.RfSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustDefaultVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroListForCfmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiCancelFrustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.ValidateInlandRouteVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.util.WebKeys;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgEurTroDgSeqVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgTroActCustVO;
import com.clt.syscommon.common.table.BkgTroActRepVO;
import com.clt.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.clt.syscommon.common.table.MdmCustomerVO;

/**
 * OPUS-GeneralBookingConduct Business Logic Basic Command implementation<br>
 * - OPUS- Process Business Logic for GeneralBookingConduct.<br>
 *
 * @author Lee Nam Kyung
 * @see ESM_BKG_0079_02CEventResponse,TransferOrderIssueBC each DAO class  reference
 * @since J2EE 1.4
 */

public class TransferOrderIssueBCImpl extends BasicCommandSupport implements TransferOrderIssueBC {

	// Database Access Object
	private transient TransferOrderIssueDBDAO dbDao = null;

	/**
	 * TransferOrderIssueBCImpl Object Creation<br>
	 * ${DAO}DAO create.<br>
	 */
	public TransferOrderIssueBCImpl() {
		dbDao = new TransferOrderIssueDBDAO();
	}

	/**
	 * (ESM_BKG_0079_02A) europe Tro relation retrieve<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @param     String rtnTroFlg
	 * @param     SignOnUserAccount account
	 * @return    TroVO
	 * @exception EventException
	 */
	public TroVO searchTro(BkgBlNoVO bkgBlNoVO, String boundCd, String rtnTroFlg, SignOnUserAccount account) throws EventException {
		BookingUtil command = new BookingUtil();
		
		try {
			//ContainerVO
			TroVO troVO = new TroVO();
			String troSeq = "";  //fist troSeq value

			//----------------------------
			//1) top : Booking info
			BkgInfoForTroVO bkgInfoForTroVO = dbDao.searchBkgForTro(bkgBlNoVO, boundCd);
			troVO.setBkgInfoForTroVO(bkgInfoForTroVO);

			//retrieve by bl_no,  retrieved bkg_no setting search condition 
			if ("".equals(JSPUtil.getNullNoTrim(bkgBlNoVO.getBkgNo()))) {
				bkgBlNoVO.setBkgNo(bkgInfoForTroVO.getBkgNo());
			}

			// 01. searchBkgBlNoVO
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			BkgBlNoVO schBkgBlNoVO = command.searchBkgBlNoVO(bkgBlNoVO);			
			troVO.setBkgBlNoVO(schBkgBlNoVO);
			
			//----------------------------
			//2) Multi Combo select target list
			String dgSeq  = bkgInfoForTroVO.getDcgoFlg();
			String rfSeq  = bkgInfoForTroVO.getRcFlg();
			String awkSeq = bkgInfoForTroVO.getAwkCgoFlg();

			if ("Y".equals(dgSeq)) {
				List<DgSeqVO> dgSeqVOs = dbDao.searchDgSeq(bkgBlNoVO);
		        troVO.setDgSeqVOs(dgSeqVOs);
			}
			if ("Y".equals(rfSeq)) {
				List<RfSeqVO> rfSeqVOs = dbDao.searchRfSeq(bkgBlNoVO);
		        troVO.setRfSeqVOs(rfSeqVOs);
			}
			if ("Y".equals(awkSeq)) {
				List<AwkSeqVO> awkSeqVOs = dbDao.searchAwkSeq(bkgBlNoVO);
		        troVO.setAwkSeqVOs(awkSeqVOs);
			}

			//----------------------------
			//3) Master Grid: TRO info
			List<TroMstVO> bkgTroVOs = dbDao.searchTro(bkgBlNoVO, rtnTroFlg, boundCd);
			troVO.setBkgTroVOs(bkgTroVOs);

			//----------------------------
			//exception -2) Tro-master : handling check message when tro info  not exist
			if (bkgTroVOs.size() > 0) {
				//Get troseq from first of Tro master list ,send param for dtl searching
				troSeq = bkgTroVOs.get(0).getTroSeq();
			}

			//----------------------------
			//4) Detail Grid: TRODTL info
			List<TroDtlVO> troDtlVOs = dbDao.searchTroDtl(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, account.getUsr_id());
			troVO.setTroDtlVOs(troDtlVOs);

			//----------------------------
			//5) selected spclCgoSeq info by Tro 
		    List<BkgTroSpclCgoSeqVO> bkgTroSpclCgoSeqVOs = dbDao.searchTroSpclCgoSeq(bkgBlNoVO, troSeq);
		    troVO.setBkgTroSpclCgoSeqVOs(bkgTroSpclCgoSeqVOs);

			//----------------------------
			//6) right-top: Sum info
		    List<QtyInfoForTroVO> qtyInfoForTroVOs = dbDao.searchQtyForTro(bkgBlNoVO, boundCd);
		    troVO.setQtyInfoForTroVOs(qtyInfoForTroVOs);

		    String strPorCd = "";
            if (bkgInfoForTroVO != null) {
            	strPorCd = JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorCd());
            }            
            if ( strPorCd.length() >= 2 && "KR".equals(strPorCd.substring(0, 2)) ) {
		    	String rtnTroFlgRtn = "Y";  //2 times  call

				//----------------------------
				//3-2) Master Grid: TRO info
		    	List<TroMstVO> bkgTroVOsrtn = dbDao.searchTro(bkgBlNoVO, rtnTroFlgRtn, boundCd);
				troVO.setBkgTroVOsrtn(bkgTroVOsrtn);

				//----------------------------
				//exception -2) Tro-master :Handling check message when tro info not exist 
				if (bkgTroVOsrtn.size() > 0) {
					//Get troseq from first of Tro master list ,send param for dtl searching
					troSeq = bkgTroVOsrtn.get(0).getTroSeq();
				}

				//----------------------------
				//4-2) Detail Grid: TRODTL info
				List<TroDtlVO> troDtlVOsrtn = dbDao.searchTroDtl(bkgBlNoVO, boundCd, rtnTroFlgRtn, troSeq, account.getUsr_id());
				troVO.setTroDtlVOsrtn(troDtlVOsrtn);
            }
            
            //add. 
            String[] arrCntr = command.searchCntrListByBkg(bkgBlNoVO);
            troVO.setArrCntr(arrCntr); 

			return troVO; 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * (ESM_BKG_0079_02C) europe Tro relation retrieve<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @param     SignOnUserAccount account
	 * @return    EurTroVO
	 * @exception EventException
	 */
	public EurTroVO searchEurTro(BkgBlNoVO bkgBlNoVO, String boundCd, SignOnUserAccount account) throws EventException {
		BookingUtil command = new BookingUtil();
		
		try {
			//ContainerVO 
			EurTroVO troVO  = new EurTroVO(); 
			String   troSeq = "";  //fist troSeq value
			
			//----------------------------
			//1) top : Booking info 
			BkgInfoForTroVO bkgInfoForTroVO = dbDao.searchBkgForTro(bkgBlNoVO, boundCd);
			troVO.setBkgInfoForTroVO(bkgInfoForTroVO); 

			//retrieve by bl_no,  retrieved bkg_no setting search condition 
			if ("".equals(JSPUtil.getNullNoTrim(bkgBlNoVO.getBkgNo()))) {
				bkgBlNoVO.setBkgNo(bkgInfoForTroVO.getBkgNo());
			}
			
			// 01. searchBkgBlNoVO
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			BkgBlNoVO schBkgBlNoVO = command.searchBkgBlNoVO(bkgBlNoVO);			
			troVO.setBkgBlNoVO(schBkgBlNoVO);
			
			
			//----------------------------
			//2) Multi Combo select target list
			String dgSeq  = bkgInfoForTroVO.getDcgoFlg(); 
			String rfSeq  = bkgInfoForTroVO.getRcFlg(); 
			String awkSeq = bkgInfoForTroVO.getAwkCgoFlg(); 
			
			if ("Y".equals(dgSeq)) {
				List<DgSeqVO> dgSeqVOs = dbDao.searchDgSeq(bkgBlNoVO);
		        troVO.setDgSeqVOs(dgSeqVOs);
			}
			if ("Y".equals(rfSeq)) {
				List<RfSeqVO> rfSeqVOs = dbDao.searchRfSeq(bkgBlNoVO);
		        troVO.setRfSeqVOs(rfSeqVOs);
			}
			if ("Y".equals(awkSeq)) {
				List<AwkSeqVO> awkSeqVOs = dbDao.searchAwkSeq(bkgBlNoVO);
		        troVO.setAwkSeqVOs(awkSeqVOs);
			} 

			//----------------------------
			//3) Master Grid: TRO info 
			List<EurTroMstVO> eurTroMstVOs = dbDao.searchEurTro(bkgBlNoVO, "", boundCd);  //null : tro_seq
			troVO.setEurTroMstVOs(eurTroMstVOs); 

			//----------------------------
			//exception -2) Tro-master : Handling check message when tro info not exist 
			if (eurTroMstVOs.size() > 0) {
				//Get troseq from first of Tro master list ,send param for dtl searching
				troSeq = eurTroMstVOs.get(0).getTroSeq(); 
			} 

			//----------------------------
			//4) Detail Grid: TRODTL info
			List<EurTroDtlVO> troDtlVOs = dbDao.searchEurTroDtl(bkgBlNoVO, boundCd, troSeq, account.getUsr_id()); 
			troVO.setEurTroDtlVOs(troDtlVOs); 

			//----------------------------
			//5) selected  spclCgoSeq info by tro. 
		    List<BkgEurTroDgSeqVO> bkgEurTroDgSeqVOs = dbDao.searchEurTroDgSeq(bkgBlNoVO, troSeq, boundCd);  
		    troVO.setBkgEurTroDgSeqVOs(bkgEurTroDgSeqVOs); 

			//----------------------------
			//6) right-top : Sum info
		    List<QtyInfoForTroVO> qtyInfoForTroVOs = dbDao.searchQtyForTro(bkgBlNoVO, boundCd);
		    troVO.setQtyInfoForTroVOs(qtyInfoForTroVOs);
			
			return troVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0079_02A) europe Tro relation save<br>
	 * @author    Lee NamKyung
	 * @param     TroVO troVO
	 * @param     account SignOnUserAccount
	 * @param     String currTroSeq
	 * @return    Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageTro(TroVO troVO, SignOnUserAccount account, String currTroSeq) throws EventException{
		try
		{
			Map<String,Object> responseData = new HashMap<String,Object>();
			String    strErrCode = "";
			BkgBlNoVO bkgBlNoVO  = new BkgBlNoVO();

			//(containerVO)
			String delFlg = troVO.getDelFlg(); 
			
			TroMstVO[]           arrTroMstVO           = null;
			TroDtlVO[]           arrTroDtlVO           = null;
			BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO = null;
			TroMstVO[]           arrTroMstVOrtn        = null;
			TroDtlVO[]           arrTroDtlVOrtn        = null;			
			arrTroMstVO           = troVO.getArrTroMstVO();
			arrTroDtlVO           = troVO.getArrTroDtlVO();
			arrBkgTroSpclCgoSeqVO = troVO.getArrBkgTroSpclCgoSeqVO();
			arrTroMstVOrtn        = troVO.getArrTroMstVOrtn();
			arrTroDtlVOrtn        = troVO.getArrTroDtlVOrtn();

			//1) general
			if (arrTroMstVO != null)
			{
				for ( int i=0; i<arrTroMstVO.length; i++ )
				{
					//=================================>
					//*) BkgBlNoVO setting
					if (i == 0) {
						String bkgNo = arrTroMstVO[i].getBkgNo();
						bkgBlNoVO.setBkgNo(bkgNo);
					}
					//<=================================

/* 
					if ( !("U".equals(arrTroMstVO[i].getIbflag()) || "I".equals(arrTroMstVO[i].getIbflag())) ) {
						continue; 
					} 
*/ 
					
					//----------------------------------
					//1) (cxl_flag = 'Y' : cancel)/I/U processing 
					if ("U".equals(arrTroMstVO[i].getIbflag()))
					{
						
						//Check someone else updated before or not
						if(!dbDao.searchBkgTroUpdate(arrTroMstVO[i], "U")){ //True is OK.
							throw new EventException(new ErrorHandler("BKG01195").getMessage());
						}
						
						if ("Y".equals(arrTroMstVO[i].getCxlFlg()) && "N".equals(arrTroMstVO[i].getCxlFlgOld()))  //cancel process for only new cancel.
						{
							String boundCd   = arrTroMstVO[i].getIoBndCd();
							String rtnTroFlg = arrTroMstVO[i].getRtnTroFlg();
							String troSeq    = arrTroMstVO[i].getTroSeq();
							String updUsrId  = account.getUsr_id();
							dbDao.cancelBkgTro(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, updUsrId);
						} else {
							arrTroMstVO[i].setUpdUsrId(account.getUsr_id());
							dbDao.modifyBkgTro(arrTroMstVO[i]);	
						}
					}
					else if ("I".equals(arrTroMstVO[i].getIbflag()))
					{
						
						if(!dbDao.searchBkgTroUpdate(arrTroMstVO[i], "I")){ 
							throw new EventException(new ErrorHandler("BKG01195").getMessage());
						}
						
						arrTroMstVO[i].setCreUsrId(account.getUsr_id());
						arrTroMstVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addBkgTro(arrTroMstVO[i]);
					}
				}
			}

			if (arrTroDtlVO != null)
			{
				for (int i=0; i<arrTroDtlVO.length; i++)
				{
					String cntrNo = arrTroDtlVO[i].getCntrNo();
					//=================================>
					//*) BkgBlNoVO setting
					if (i == 0) {
						String bkgNo = arrTroDtlVO[i].getBkgNo();
						bkgBlNoVO.setBkgNo(bkgNo);
					}
					//<=================================

					if ( !("U".equals(arrTroDtlVO[i].getIbflag()) || "I".equals(arrTroDtlVO[i].getIbflag())) ) {
						continue;
					} 
					
					//mst check 
					String strCfmFlg_mst    = "";
					String strCfmFlgOld_mst = "";
					if (arrTroMstVO != null) {
						for (int p=0; p<arrTroMstVO.length; p++) {
							if (arrTroDtlVO[i].getTroSeq().equals(arrTroMstVO[p].getTroSeq())) {
								strCfmFlg_mst    = JSPUtil.getNullNoTrim(arrTroMstVO[p].getCfmFlg(),    "N");
								strCfmFlgOld_mst = JSPUtil.getNullNoTrim(arrTroMstVO[p].getCfmFlgOld(), "N");
								break;
							}
						}
					}

					//--------------------------------
					//1) check processing
					if ( !"Y".equals(arrTroDtlVO[i].getCxlFlg()) &&                    //not cancel case , 
					     ("Y".equals(strCfmFlg_mst) && "N".equals(strCfmFlgOld_mst))   //checking new confirm case 
					   )  
					{   
						if (cntrNo.length() == 14) {
							//1-1) Booking Container check exist or not 
							String cntExistYn = dbDao.searchCntrByBkg(cntrNo, bkgBlNoVO);
							if (!"Y".equals(cntExistYn)) {
								strErrCode = "BKG00449";
								throw new EventException(new ErrorHandler(strErrCode, new String[]{cntrNo}).getMessage());
							}

							//1-2)   message separator  retrieve for return
							String resultMsgFlag = dbDao.searchCntrPartial(cntrNo, bkgBlNoVO);
							if ("P".equals(resultMsgFlag)) {
								strErrCode = "BKG00453";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
							else if ("S".equals(resultMsgFlag))
							{
								strErrCode = "BKG00451";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
						}
					}

					//--------------------------------
					//2) I/U/Cancel processing
					if ("U".equals(arrTroDtlVO[i].getIbflag()))
					{

						//Check someone else updated before or not
						if(!dbDao.searchBkgTroDtlUpdate(arrTroDtlVO[i], "U")){ //True is OK.
							throw new EventException(new ErrorHandler("BKG01195").getMessage());
						}
						
						if ("Y".equals(arrTroDtlVO[i].getCxlFlg()) && "N".equals(arrTroDtlVO[i].getCxlFlgOld()))  //cancel process for only new cancel.
						{
							String boundCd   = arrTroDtlVO[i].getIoBndCd();
							String rtnTroFlg = arrTroDtlVO[i].getRtnTroFlg();
							String troSeq    = arrTroDtlVO[i].getTroSeq();
							String troSubSeq = arrTroDtlVO[i].getTroSubSeq();
							String updUsrId  = account.getUsr_id();
							dbDao.cancelBkgTroDtl(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, troSubSeq, updUsrId);
						} else {
							arrTroDtlVO[i].setUpdUsrId(account.getUsr_id());
							dbDao.modifyBkgTroDtl(arrTroDtlVO[i]);
						}
					}
					else if ("I".equals(arrTroDtlVO[i].getIbflag()))
					{
						//Check someone else updated before or not
						if(!dbDao.searchBkgTroDtlUpdate(arrTroDtlVO[i], "I")){ //True is OK.
							throw new EventException(new ErrorHandler("BKG01195").getMessage());
						}

						arrTroDtlVO[i].setCreUsrId(account.getUsr_id());
						arrTroDtlVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addBkgTroDtl(arrTroDtlVO[i]);
					}
				}
			}

				//=================================>
				//*) BkgBlNoVO setting
//				String bkgNo      = arrBkgTroSpclCgoSeqVO[0].getBkgNo();
//				String boundCd    = arrBkgTroSpclCgoSeqVO[0].getIoBndCd();
//				String rtnTroFlg  = arrBkgTroSpclCgoSeqVO[0].getRtnTroFlg();
//				String troSeq     = arrBkgTroSpclCgoSeqVO[0].getTroSeq();
//				bkgBlNoVO.setBkgNo(bkgNo);
				//<=================================

			bkgBlNoVO.setBkgNo(troVO.getBkgNo());

			//--------------------------------
			//1) delete 
			if ("C".equals(delFlg)) {				
				if(!("".equals(currTroSeq))){
					dbDao.removeBkgTroSpclCgoSeq(bkgBlNoVO, troVO.getIoBndCd(), troVO.getRtnTroFlg(), currTroSeq);	
				}
			} else {
				dbDao.removeBkgTroSpclCgoSeq(bkgBlNoVO, troVO.getIoBndCd(), troVO.getRtnTroFlg(), "");	
			}				

			if (arrBkgTroSpclCgoSeqVO != null)
			{
				//--------------------------------
				//1) add(I) 
				for (int i=0; i<arrBkgTroSpclCgoSeqVO.length; i++)
				{
					if ("I".equals(arrBkgTroSpclCgoSeqVO[i].getIbflag()))
					{
						arrBkgTroSpclCgoSeqVO[i].setCreUsrId(account.getUsr_id());
						arrBkgTroSpclCgoSeqVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addBkgTroSpclCgoSeq(arrBkgTroSpclCgoSeqVO[i]);
					}
				}
			}

			//2) rtn_cago
			if (arrTroMstVOrtn != null)
			{
				for ( int i=0; i<arrTroMstVOrtn.length; i++ )
				{
					//=================================>
					//*) BkgBlNoVO setting
					if (i == 0) {
						String bkgNo      = arrTroMstVOrtn[i].getBkgNo();
						bkgBlNoVO.setBkgNo(bkgNo);
					}
					//<=================================

					if ( !("U".equals(arrTroMstVOrtn[i].getIbflag()) || "I".equals(arrTroMstVOrtn[i].getIbflag())) ) {
						continue; 
					}
					
					//----------------------------------
					//1) (cxl_flag = 'Y' : cancel)/I/U processing
					if ("U".equals(arrTroMstVOrtn[i].getIbflag()))
					{
						if ("Y".equals(arrTroMstVOrtn[i].getCxlFlg()) && "N".equals(arrTroMstVOrtn[i].getCxlFlgOld()))  //cancel process for only new cancel.
						{
							String boundCd    = arrTroMstVOrtn[i].getIoBndCd();
							String rtnTroFlg  = "Y";
							String troSeq     = arrTroMstVOrtn[i].getTroSeq();
							String updUsrId   = account.getUsr_id();
							dbDao.cancelBkgTro(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, updUsrId);
						} else {
							arrTroMstVOrtn[i].setUpdUsrId(account.getUsr_id());
							dbDao.modifyBkgTro(arrTroMstVOrtn[i]);
						}
					}
					else if ("I".equals(arrTroMstVOrtn[i].getIbflag()))
					{
						arrTroMstVOrtn[i].setCreUsrId(account.getUsr_id());
						arrTroMstVOrtn[i].setUpdUsrId(account.getUsr_id());
						dbDao.addBkgTro(arrTroMstVOrtn[i]);
					}
				}
			}

			if (arrTroDtlVOrtn != null)
			{
				for (int i=0; i<arrTroDtlVOrtn.length; i++)
				{
					String cntrNo = JSPUtil.getNullNoTrim(arrTroDtlVOrtn[i].getCntrNo());
					//=================================>
					//*) BkgBlNoVO setting
					if (i == 0) {
						String bkgNo = arrTroDtlVOrtn[i].getBkgNo();
						bkgBlNoVO.setBkgNo(bkgNo);
					}
					//<=================================

					//remove for don't reprocessing   
					if ( !("U".equals(arrTroDtlVOrtn[i].getIbflag()) || "I".equals(arrTroDtlVOrtn[i].getIbflag())) ) {
						continue;
					} 
										
					//--------------------------------
					//1) check processing
					if ( !"Y".equals(arrTroDtlVOrtn[i].getCxlFlg()) )   //not cancel case, -> rtn is not exist confirm 
					{					
						if (cntrNo.length() == 14) {
							//1-1) Booking Container check exist or not
							String cntExistYn = dbDao.searchCntrByBkg(cntrNo, bkgBlNoVO);
							if (!"Y".equals(cntExistYn)) {
								strErrCode = "BKG00449";
								throw new EventException(new ErrorHandler(strErrCode, new String[]{cntrNo}).getMessage());
							}
	
							//1-2)  message separator  retrieve for return
							String resultMsgFlag = dbDao.searchCntrPartial(cntrNo, bkgBlNoVO);
							if ("P".equals(resultMsgFlag)) {
								strErrCode = "BKG00453";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
							else if ("S".equals(resultMsgFlag))
							{
								strErrCode = "BKG00451";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
						}
					}

					//--------------------------------
					//2) I/U/Cancel 
					if ("U".equals(arrTroDtlVOrtn[i].getIbflag()))
					{
						if ("Y".equals(arrTroDtlVOrtn[i].getCxlFlg()) && "N".equals(arrTroDtlVOrtn[i].getCxlFlgOld()))  //cancel process for only new cancel.
						{
							String boundCd   = arrTroDtlVOrtn[i].getIoBndCd();
							String rtnTroFlg = "Y";
							String troSeq    = arrTroDtlVOrtn[i].getTroSeq();
							String troSubSeq = arrTroDtlVOrtn[i].getTroSubSeq();
							String updUsrId  = account.getUsr_id();
							dbDao.cancelBkgTroDtl(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, troSubSeq, updUsrId);
						} else {
							arrTroDtlVOrtn[i].setUpdUsrId(account.getUsr_id());
							dbDao.modifyBkgTroDtl(arrTroDtlVOrtn[i]);
						}
					}
					else if ("I".equals(arrTroDtlVOrtn[i].getIbflag()))
					{
						arrTroDtlVOrtn[i].setCreUsrId(account.getUsr_id());
						arrTroDtlVOrtn[i].setUpdUsrId(account.getUsr_id());
						dbDao.addBkgTroDtl(arrTroDtlVOrtn[i]);
					}
				}
			}

			//=============================
			// refresh after QTY retrieve
			String bkgNo   = troVO.getBkgNo();
			String ioBndCd = troVO.getIoBndCd();

			List<QtyInfoForTroVO> qtyInfoForTroVOs = dbDao.searchQtyForTro(bkgBlNoVO, ioBndCd);

			BkgQuantityVO[] arrBkgQuantityVO = new BkgQuantityVO[qtyInfoForTroVOs.size()];
			int nCnt = 0;
			for (Iterator<QtyInfoForTroVO> iter = qtyInfoForTroVOs.iterator(); iter.hasNext(); )
			{
				QtyInfoForTroVO qtyInfoForTroVO = iter.next();

				String cntrTpszCd = qtyInfoForTroVO.getCntrTpszCd();
				String troQty     = qtyInfoForTroVO.getTroQty();

				BkgQuantityVO bkgQuantityVO = new BkgQuantityVO();
				bkgQuantityVO.setIbflag    ("U");
				bkgQuantityVO.setBkgNo     (bkgNo);
				bkgQuantityVO.setCntrTpszCd(cntrTpszCd);
				if ("O".equals(ioBndCd)) {
				    bkgQuantityVO.setObTroQty(troQty);
				} else if ("I".equals(ioBndCd)) {
					bkgQuantityVO.setIbTroQty(troQty);
				}
				arrBkgQuantityVO[nCnt++] = bkgQuantityVO;
			}
			responseData.put(WebKeys.ER_DBROWSETS, arrBkgQuantityVO);

			return responseData;

		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	//<-----------------------------------------(containerVO)

	//(containerVO)---------------------------------------->
	/**
	 * (ESM_BKG_0079_02C) europe Tro relation save<br>
	 * @author    Lee NamKyung
	 * @param     EurTroVO eurTroVO
	 * @param     String bkgNo
	 * @param     String currTroSeq
	 * @param     SignOnUserAccount account
	 * @return    Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageEurTro(EurTroVO eurTroVO, String bkgNo, String currTroSeq, SignOnUserAccount account) throws EventException{
		try
		{
			Map<String,Object> responseData = new HashMap<String,Object>();
			String    strErrCode = "";
			BkgBlNoVO bkgBlNoVO  = new BkgBlNoVO();

			//(containerVO)
			String delFlg = eurTroVO.getDelFlg(); 
			String bound  = eurTroVO.getIoBndCd();
			EurTroMstVO[]        arrEurTroMstVO      = null;
			EurTroDtlVO[]        arrEurTroDtlVO      = null;
			BkgEurTroDgSeqVO[]   arrBkgEurTroDgSeqVO = null;  
			arrEurTroMstVO      = eurTroVO.getArrEurTroMstVO();
			arrEurTroDtlVO      = eurTroVO.getArrEurTroDtlVO();
			arrBkgEurTroDgSeqVO = eurTroVO.getArrBkgEurTroDgSeqVO(); 

			bkgBlNoVO.setBkgNo(bkgNo);

			//1) general
			if (arrEurTroMstVO != null)
			{
				for ( int i=0; i<arrEurTroMstVO.length; i++ )
				{
					//=================================>
					//*) BkgBlNoVO setting
//					if (i == 0) {
////						String bkgNo = arrEurTroMstVO[i].getBkgNo();
//						bkgBlNoVO.setBkgNo(bkgNo);
//					}
					//<=================================

					if ( !("U".equals(arrEurTroMstVO[i].getIbflag()) || "I".equals(arrEurTroMstVO[i].getIbflag())) ) {
						continue; 
					} 
					
					if(arrEurTroMstVO[i].getHlgTpCd() == null || arrEurTroMstVO[i].getHlgTpCd().length()!=1){
						throw new EventException(new ErrorHandler("BKG00404", new String[]{"Haulage", "Haulage"}).getMessage());
					}

					//----------------------------------
					//1) (cxl_flag = 'Y' : cancel)/I/U processing
					String cntrNo = JSPUtil.getNullNoTrim(arrEurTroMstVO[i].getCntrNo());

					//--------------------------------
					//1) check processing
					//CF -> when handling cancel Frustrate 
					if ( !"CF".equals(delFlg) && !"Y".equals(arrEurTroMstVO[i].getCxlFlg()) && cntrNo.length() > 0 )  //check when not cancel  
					{
						//1-1) Booking Container check exist or not
						String cntExistYn = dbDao.searchCntrByBkg(cntrNo, bkgBlNoVO);
						if (!"Y".equals(cntExistYn)) {
							strErrCode = "BKG00449";
							throw new EventException(new ErrorHandler(strErrCode, new String[]{cntrNo}).getMessage());
						}

						//1-2)  message separator  retrieve for return
						String resultMsgFlag = dbDao.searchCntrPartial(cntrNo, bkgBlNoVO);
						if ("P".equals(resultMsgFlag)) {
							strErrCode = "BKG00453";
							responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
						}
						else if ("S".equals(resultMsgFlag))
						{
							strErrCode = "BKG00451";
							responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
						}
					}
					
					if ("U".equals(arrEurTroMstVO[i].getIbflag()))
					{
						arrEurTroMstVO[i].setUpdUsrId(account.getUsr_id());
						log.debug("index:"+i+" AK CGO SEQ===>"+arrEurTroMstVO[i].getAwkCgoSeq());
						dbDao.modifyEurTro(arrEurTroMstVO[i]);
					}
					else if ("I".equals(arrEurTroMstVO[i].getIbflag()))
					{
						log.debug("index:"+i+" AK CGO SEQ===>"+arrEurTroMstVO[i].getAwkCgoSeq());
						arrEurTroMstVO[i].setCreUsrId(account.getUsr_id());
						arrEurTroMstVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addEurTro(arrEurTroMstVO[i]);
					}
				}
			}

			if (arrEurTroDtlVO != null)
			{
				for (int i=0; i<arrEurTroDtlVO.length; i++)
				{
					//=================================>
//					//*) BkgBlNoVO setting
//					if (i == 0) {
////						String bkgNo = arrEurTroDtlVO[i].getBkgNo();
//						bkgBlNoVO.setBkgNo(bkgNo);
//					}
					//<=================================
					
					//remove for don't reprocessing
					if ( !("U".equals(arrEurTroDtlVO[i].getIbflag()) || 
						   "I".equals(arrEurTroDtlVO[i].getIbflag()) || 
						   "D".equals(arrEurTroDtlVO[i].getIbflag()) ) ) {
						continue;
					}  					
					
    				//--------------------------------
					//1) I/U/D processing
					if ("D".equals(arrEurTroDtlVO[i].getIbflag()))
					{
						String boundCd   = arrEurTroDtlVO[i].getIoBndCd();
						String troSeq    = arrEurTroDtlVO[i].getTroSeq();
						String troSubSeq = arrEurTroDtlVO[i].getTroSubSeq();
						dbDao.removeEurTroDtl(bkgBlNoVO, boundCd, troSeq, troSubSeq);
						dbDao.modifyEurTroDtlMltSeq(arrEurTroDtlVO[i]);
					} 
					else if ("U".equals(arrEurTroDtlVO[i].getIbflag()))
					{
						arrEurTroDtlVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.modifyEurTroDtl(arrEurTroDtlVO[i]);
						dbDao.modifyEurTroDtlMltSeq(arrEurTroDtlVO[i]);
					}
					else if ("I".equals(arrEurTroDtlVO[i].getIbflag()))
					{
						arrEurTroDtlVO[i].setCreUsrId(account.getUsr_id());
						arrEurTroDtlVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addEurTroDtl(arrEurTroDtlVO[i]);
						dbDao.modifyEurTroDtlMltSeq(arrEurTroDtlVO[i]);
					}
				}
			}

			if (arrBkgEurTroDgSeqVO != null)
			{
				//=================================>
				//*) BkgBlNoVO setting
//				String bkgNo      = arrBkgEurTroDgSeqVO[0].getBkgNo();
				String boundCd    = arrBkgEurTroDgSeqVO[0].getIoBndCd();
				String troSeq     = arrBkgEurTroDgSeqVO[0].getTroSeq();
//				bkgBlNoVO.setBkgNo(bkgNo);
				//<=================================
				
				//--------------------------------
				//1) delete
				if ("C".equals(delFlg)) {
					dbDao.removeEurTroDgSeq(bkgBlNoVO, boundCd, troSeq, "");	
				} else {
					dbDao.removeEurTroDgSeq(bkgBlNoVO, boundCd, "", "");
				}	

				//--------------------------------
				//1) add(I)
				for (int i=0; i<arrBkgEurTroDgSeqVO.length; i++)
				{
					if ("I".equals(arrBkgEurTroDgSeqVO[i].getIbflag()))
					{
						arrBkgEurTroDgSeqVO[i].setCreUsrId(account.getUsr_id());
						arrBkgEurTroDgSeqVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addEurTroDgSeq(arrBkgEurTroDgSeqVO[i]);
					}
				}
			}else{
//				bkgBlNoVO.setBkgNo(bkgNo);
				
				//1) �뜲�씠�꽣媛� �뾾�쓣�븧 �쟾泥� delete
				if ("C".equals(delFlg)) {
					dbDao.removeEurTroDgSeq(bkgBlNoVO, bound, currTroSeq, "");	
				} else {
					dbDao.removeEurTroDgSeq(bkgBlNoVO, bound, "", "");
				}
			}

			//=============================
			// refresh after QTY retrieve
//			String bkgNo   = eurTroVO.getBkgNo();
			String ioBndCd = eurTroVO.getIoBndCd();

			List<QtyInfoForTroVO> qtyInfoForTroVOs = dbDao.searchQtyForTro(bkgBlNoVO, ioBndCd);

			BkgQuantityVO[] arrBkgQuantityVO = new BkgQuantityVO[qtyInfoForTroVOs.size()];
			int nCnt = 0;
			for (Iterator<QtyInfoForTroVO> iter = qtyInfoForTroVOs.iterator(); iter.hasNext(); )
			{
				QtyInfoForTroVO qtyInfoForTroVO = iter.next();

				String cntrTpszCd = qtyInfoForTroVO.getCntrTpszCd();
				String troQty     = qtyInfoForTroVO.getTroQty();

				BkgQuantityVO bkgQuantityVO = new BkgQuantityVO();
				bkgQuantityVO.setIbflag    ("U");
				bkgQuantityVO.setBkgNo     (bkgNo);
				bkgQuantityVO.setCntrTpszCd(cntrTpszCd);
				if ("O".equals(ioBndCd)) {
				    bkgQuantityVO.setObTroQty(troQty);
				} else if ("I".equals(ioBndCd)) {
					bkgQuantityVO.setIbTroQty(troQty);
				}
				arrBkgQuantityVO[nCnt++] = bkgQuantityVO;
			}
			responseData.put(WebKeys.ER_DBROWSETS, arrBkgQuantityVO);

			return responseData;

		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	//<-----------------------------------------(containerVO)
	
	/**
	 * confirm event processing<br>
	 * confirm when confirm Popup(ESM_BKG_0906) in ESM_BKG_0079_02c screen <br>
	 * @author    Lee NamKyung
	 * @param     TroCfmVO troCfmVO
	 * @param     SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmEurTro(TroCfmVO troCfmVO, SignOnUserAccount account) throws EventException {
		try {
			String payerCntCd = "";
			String payerSeq   = "";
			String partialBkgNo;
			EurPayerVO eurPayerVO = troCfmVO.getEurPayerVO();
			if (eurPayerVO != null) {
				payerCntCd = eurPayerVO.getPayerCntCd();
				payerSeq   = eurPayerVO.getPayerSeq();
			}
			TroListForCfmVO[] arrTroListForCfmVO = troCfmVO.getArrTroListForCfmVO(); 
			for (int i=0; i<arrTroListForCfmVO.length;i++){
				partialBkgNo = "";
				partialBkgNo = dbDao.searchEurTroPartial(arrTroListForCfmVO[i]);
				log.debug("partialBkgNo:"+partialBkgNo);
				if(partialBkgNo !=null && partialBkgNo.length()>0){
					throw new EventException(new ErrorHandler("BKG02027", new String[]{partialBkgNo, arrTroListForCfmVO[i].getCntrNo()}).getMessage());
				}
				arrTroListForCfmVO[i].setPayerCntCd(payerCntCd);
				arrTroListForCfmVO[i].setPayerSeq  (payerSeq);
				arrTroListForCfmVO[i].setUpdUsrId  (account.getUsr_id());
				
				//Update MLT_STOP_SEQ of BKG_EUR_TRO_DTL
				EurTroDtlVO eurTroDtlVO = new EurTroDtlVO();
				eurTroDtlVO.setBkgNo(arrTroListForCfmVO[i].getBkgNo());
				eurTroDtlVO.setIoBndCd(arrTroListForCfmVO[i].getIoBndCd());
				eurTroDtlVO.setTroSeq(arrTroListForCfmVO[i].getTroSeq());
				dbDao.modifyEurTroDtlMltSeq(eurTroDtlVO);
				
				dbDao.confirmEurTro(arrTroListForCfmVO[i]);
			}
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	
	/**
	 * Handling cancel/Frust at ESM_BKG_0703 popup in ESM_BKG_0079_02C<br>
	 * @author    Lee NamKyung
	 * @param     TroMultiCancelFrustVO[] troMultiCancelFrustVOs
	 * @param     SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelFrustEurTro(TroMultiCancelFrustVO[] troMultiCancelFrustVOs, SignOnUserAccount account) throws EventException {
		try {
			if (troMultiCancelFrustVOs != null)
			{
				for (int i=0; i<troMultiCancelFrustVOs.length; i++)
				{
					
					//2011.12.14 validate 異붽� kbj
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO(); 
					String ioBndCd = troMultiCancelFrustVOs[i].getIoBndCd();
					bkgBlNoVO.setBkgNo( troMultiCancelFrustVOs[i].getBkgNo() );
					
					List<TroMultiCancelFrustVO> troList = dbDao.searchEurTroForCancelFrust(ioBndCd, bkgBlNoVO);
					
					//chk-value chage
					String cxlFlgChk    = ( "1".equals(troMultiCancelFrustVOs[i].getCxlFlgChk())    )? "Y":"N";
					String frustrateChk = ( "1".equals(troMultiCancelFrustVOs[i].getFrustrateChk()) )? "Y":"N";
					troMultiCancelFrustVOs[i].setCxlFlgChk   (cxlFlgChk);
					troMultiCancelFrustVOs[i].setFrustrateChk(frustrateChk);
					troMultiCancelFrustVOs[i].setCfmUsrId    (account.getUsr_id());
					troMultiCancelFrustVOs[i].setOfcCd       (account.getOfc_cd());
					troMultiCancelFrustVOs[i].setUpdUsrId    (account.getUsr_id());
					
					//1) Cancel
					if ("Y".equals(troMultiCancelFrustVOs[i].getCxlFlgChk()))
					{
						for(TroMultiCancelFrustVO vo : troList ){
							if( vo.getTroSeq().equals(troMultiCancelFrustVOs[i].getTroSeq()) && vo.getSoFlg().equals("Yes") ) {
								throw new EventException (new ErrorHandler("BKG00094").getMessage() );
							}
						}
						dbDao.cancelEurTro(troMultiCancelFrustVOs[i]);
//						BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
//						bkgBlNoVO.setBkgNo(troMultiCancelFrustVOs[i].getBkgNo());
						bkgBlNoVO.setPctlNo("");
						dbDao.modifyEurTroPctlNo(bkgBlNoVO, troMultiCancelFrustVOs[i].getIoBndCd(), troMultiCancelFrustVOs[i].getTroSeq(), account);
					}
					//2) Frustrate
					if ("Y".equals(troMultiCancelFrustVOs[i].getFrustrateChk()))
					{
						dbDao.frustrateEurTro(troMultiCancelFrustVOs[i]);
					}
				}
			}
		} catch (EventException ex ){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Handling TroCopy at ESM_BKG_0920 popup in ESM_BKG_0079_02C<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO sourceBkg
	 * @param     String boundCd
	 * @param     String sourceTroSeq
	 * @param     BkgBlNoVO[] arrTagetBkgBlNoVO
	 * @param     SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyTro(BkgBlNoVO sourceBkg, String boundCd, String sourceTroSeq, BkgBlNoVO[] arrTagetBkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil command = new BookingUtil();

			if (arrTagetBkgBlNoVO != null)
			{
				for (int i=0; i<arrTagetBkgBlNoVO.length; i++)
				{					
					BkgBlNoVO targetBkg = arrTagetBkgBlNoVO[i];					

					//1) booking status check
					String strStatus = command.searchBkgStatusByBkg(targetBkg);
					if (strStatus == null) {
						throw new EventException(new ErrorHandler("BKG00399").getMessage());
					}
					if ("X".equals(strStatus)) {
						throw new EventException(new ErrorHandler("BKG00384").getMessage());
					}
					
					//2) Check TroSeq exist or not  
					String tBoundCd = "O";
					if (!"".equals(boundCd)) {
						tBoundCd = boundCd; 
					}
					String strExist = dbDao.searchTroExist(tBoundCd, targetBkg);
					strExist = JSPUtil.getNullNoTrim(strExist);
					// Don't exist TRO in same BOUND 
					if (!"".equals(strExist)) {
						throw new EventException(new ErrorHandler("BKG02033").getMessage());
					}
					
					//3) tro Copy
					boundCd = JSPUtil.getNullNoTrim(boundCd);

					targetBkg.setPctlNo("");
					// eur tro copy exist then eur tro copy processing 
					if(dbDao.copyEurTroBySeq(sourceBkg, targetBkg, "", boundCd, account)>0){
						dbDao.copyEurTroDtlBySeq(sourceBkg, targetBkg, "", "", boundCd, account);
						dbDao.modifyEurTroPctlNo(targetBkg, boundCd, "", account);					 
					} else {// not exist then general copy processing
						dbDao.copyTroBySeq(sourceBkg, targetBkg, "", account);
						dbDao.copyTroDtlBySeq(sourceBkg, targetBkg, "", "", account); 
						dbDao.modifyTroPctlNo(targetBkg, "", account);		
					}
				}
			}
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	

/* : confirm 愿��젴濡쒖쭅�떆, �닔�젙�썑 �궗�슜�삁�젙
	/--**
	 * Multi event processing<br>
	 * Multi event processing  for In screen(0079_02C : confirm)<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @param     String troSeq
	 * @param     String newTroStsCd
	 * @exception EventException
	 *--/
	public void changeEurTroStatus(BkgBlNoVO bkgBlNoVO, String boundCd, String troSeq, String newTroStsCd) throws EventException {
		try {
			BookingUtil command = new BookingUtil();
			troSeq = (troSeq==null)? "" : troSeq;

			//1) repeat as cntr count--->
			    String cntrNo = "";  //for..蹂�寃쏀븷 寃�!

				//2-1) searchEurTroStatus
				//String strReturn_1 = dbDao.searchEurTroStatus(boundCd, troSeq, bkgBlNoVO);

				//2-1) searchSoStatus
				command.searchSoStatus(troSeq, cntrNo, bkgBlNoVO);

				//2-2) searchPartialCntrMst
				dbDao.searchPartialCntrMst(bkgBlNoVO, boundCd, cntrNo);
			//<------------------

			//2) searchMdmCust
			if ("F".equals(newTroStsCd)) {
				//command.searchMdmCust(custCntCd, custSeq, "Y");
			}

			//3) modifyEurTroStatus
			//dbDao.modifyEurTroStatus(newTroStsCd, troSeq, boundCd, bkgBlNoVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
*/
	
	/**
	 * (ESM_BKG_0907) Retrieve Container of EurTro<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @return    List<BkgEurCntrListVO>
	 * @exception EventException
	 */
	public List<BkgEurCntrListVO> searchEurTroCntrList(BkgBlNoVO bkgBlNoVO, String boundCd) throws EventException {
		try {
			return dbDao.searchEurTroCntrList(bkgBlNoVO, boundCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0703) cancel/frust processing target retrieve<br>
	 * @author Lee NamKyung
	 * @param  String ioBndCd
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<TroMultiCancelFrustVO>
	 * @exception EventException
	 */
	public List<TroMultiCancelFrustVO> searchEurTroForCancelFrust(String ioBndCd, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchEurTroForCancelFrust(ioBndCd, bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0921) Multi retrieve<br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String cntrNo
	 * @param     String boundCd
	 * @return    List<TroMultiBkgVO>
	 * @exception EventException
	 */
	public List<TroMultiBkgVO> searchMultiBkg(BkgBlNoVO bkgBlNoVO, String cntrNo, String boundCd) throws EventException {
		try {
			return dbDao.searchMultiBkg(bkgBlNoVO, cntrNo, boundCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Retrieve confirm target when confirm popup(ESM_BKG_0906) in ESM_BKG_0079_02c <br>
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String boundCd
	 * @return    TroCfmVO
	 * @exception EventException
	 */
	public TroCfmVO searchEurTroListForCfm(BkgBlNoVO bkgBlNoVO, String boundCd) throws EventException {
		try {
			TroCfmVO troCfmVO = new TroCfmVO();

			if ("I".equals(boundCd)) {
				EurPayerVO eurPayerVO = dbDao.searchEurTroPayer(bkgBlNoVO);
				troCfmVO.setEurPayerVO(eurPayerVO);
			}
			List<TroListForCfmVO> list = dbDao.searchEurTroListForCfm(bkgBlNoVO, boundCd);
			troCfmVO.setTroListForCfmVOs(list);

			return troCfmVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	

	//(containerVO)---------------------------------------->
	/**
	 * (ESM_BKG_0905) TroActCust Dtl I/U/D processing<br>
	 * @author    Lee NamKyung
	 * @param     TroActCustVO troActCustVO
	 * @param     SignOnUserAccount account
	 * @return    String
	 * @exception EventException
	 */
	public String manageTroActCust(TroActCustVO troActCustVO, SignOnUserAccount account) throws EventException{
		try {
			String strErrCode = "";

			//(containerVO)
			BkgTroActRepVO[]  bkgTroActRepVOs  = null;
			BkgTroActCustVO[] bkgTroActCustVOs = null;

			bkgTroActRepVOs  = troActCustVO.getBkgTroActRepVOs();
			bkgTroActCustVOs = troActCustVO.getBkgTroActCustVOs();


			if (bkgTroActRepVOs != null)
			{
				for ( int i=0; i<bkgTroActRepVOs.length; i++ )
				{
					if ( bkgTroActRepVOs[i].getIbflag().equals("I"))
					{
						bkgTroActRepVOs[i].setCreUsrId(account.getUsr_id());
						dbDao.addBkgTroActRep(bkgTroActRepVOs[i]);
					}
					else if ( bkgTroActRepVOs[i].getIbflag().equals("U"))
					{
						bkgTroActRepVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.modifyBkgTroActRep(bkgTroActRepVOs[i]);
					}
					else if ( bkgTroActRepVOs[i].getIbflag().equals("D"))
					{
						//check 濡쒖쭅 異붽�(BKG_TRO_ACT_CUST 媛� 議댁옱�븯�뒗媛�?)
						String existYnTroActCust = dbDao.selectBkgTroActCustExistYn(bkgTroActRepVOs[i].getOfcCd(), bkgTroActRepVOs[i].getTroActRepSeq());
						if ("Y".equals(existYnTroActCust)) {
							strErrCode = "BKG40120";		//You can't delete the E/Q Office because Customer information exists.
							return strErrCode;
						}
						bkgTroActRepVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.removeBkgTroActRep(bkgTroActRepVOs[i]);
					}
				}
			}

			if (bkgTroActCustVOs != null)
			{
			    BookingUtil command = new BookingUtil();
				for ( int i=0; i<bkgTroActCustVOs.length; i++ )
				{
					if ( !bkgTroActCustVOs[i].getIbflag().equals("D") ) 
					{
						//Check Location code exist or not 
						String locCd = JSPUtil.getNull(bkgTroActCustVOs[i].getLocCd());
						if (!"".equals(locCd)) {
//						    String existYn_loc = dbDao.selectLocCdExistYn(locCd);
//							if (!"Y".equals(existYn_loc)) {
//								strErrCode = "BKG00441";
//								return strErrCode;
//							}
						    if(!command.validateLoc(locCd)){
								strErrCode = "BKG00441";
								return strErrCode;
							}
						}
						// Check Zone code exist or not 
						String zoneCd = JSPUtil.getNull(bkgTroActCustVOs[i].getZnCd());
						if (!"".equals(zoneCd)) {
							zoneCd = bkgTroActCustVOs[i].getLocCd()+bkgTroActCustVOs[i].getZnCd();
							bkgTroActCustVOs[i].setZnCd(zoneCd); //2->7digit change
							String existYnZone = dbDao.selectZoneCdExistYn(zoneCd);
							if ("N".equals(existYnZone)) {
								strErrCode = "BKG00441";
								return strErrCode;
							}
						}
					}
					
					if ( bkgTroActCustVOs[i].getIbflag().equals("I"))
					{
						bkgTroActCustVOs[i].setCreUsrId(account.getUsr_id());
						dbDao.addBkgTroActCust(bkgTroActCustVOs[i]);       //same CUST.
					}
					else if ( bkgTroActCustVOs[i].getIbflag().equals("U"))
					{
						bkgTroActCustVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.modifyBkgTroActCust(bkgTroActCustVOs[i]);    //Exist Update for EQ.
					}
					else if ( bkgTroActCustVOs[i].getIbflag().equals("D"))
					{
						dbDao.removeBkgTroActCust(bkgTroActCustVOs[i]);    //same CUST.
					}
				}
			}

			return strErrCode;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	//<-----------------------------------------(containerVO)

	/**
	 * (ESM_BKG_0905) Customer Tab master retrieve<br>
	 * @author    Lee NamKyung
	 * @param     String custCntCd
	 * @param     String custSeq
	 * @param     String custNm
	 * @return    List<MdmCustomerVO>
	 * @exception EventException
	 */
	public List<MdmCustomerVO> searchMdmCustForTro(String custCntCd, String custSeq, String custNm) throws EventException {
		try {
			return dbDao.searchMdmCustForTro(custCntCd, custSeq, custNm);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0905) Customer Tab detail Retrieve<br>
	 * @author    Lee NamKyung
	 * @param     String ofcCd
	 * @param     String cntCd
	 * @param     String custSeq
	 * @return    List<BkgTroActCustVO>
	 * @exception EventException
	 */
	public List<BkgTroActCustVO> searchTroActCustByCust(String ofcCd, String cntCd, String custSeq) throws EventException {
		try {
			return dbDao.searchTroActCustByCust(ofcCd, cntCd, custSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * (ESM_BKG_0905) ActCustRep Master retrieve<br>
	 * @author    Lee NamKyung
	 * @param     String doorLoc
	 * @param     String ofcCd
	 * @param     String custNm
	 * @return    List<BkgTroActRepVO>
	 * @exception EventException
	 */
	public List<BkgTroActRepVO> searchActCustRep(String doorLoc, String ofcCd, String custNm) throws EventException {
		try {
			return dbDao.searchActCustRep(doorLoc, ofcCd, custNm);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0905) TroActCust Eq Dtl retrieve<br>
	 * @author    Lee NamKyung
	 * @param	  String doorLoc
	 * @param     String ofcCd
	 * @param     String troActRepSeq
	 * @return    List<BkgTroActCustExtVO>
	 * @exception EventException
	 */
	public List<BkgTroActCustExtVO> searchTroActCustByEq(String doorLoc, String ofcCd, String troActRepSeq) throws EventException {
		try {
			return dbDao.searchTroActCustByEq(doorLoc, ofcCd, troActRepSeq);  //Exist Select for EQ.
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0905) Vendor Name retrieve<br>
	 * @author    Lee NamKyung
	 * @param     String cntCd
	 * @param     String vndrSeq
	 * @return    String
	 * @exception EventException
	 */
	public String searchVndrName(String cntCd, String vndrSeq) throws EventException {
		try {
			return dbDao.searchVndrName(cntCd, vndrSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00095").getUserMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * (ESM_BKG_0079_02C) Cago weight retrieve by CntrNo<br>
	 * @author    Lee NamKyung
	 * @param     String bkgNo
	 * @param     String cntrNo
	 * @return    String
	 * @exception EventException
	 */
	public String searchBkgCntrWgt(String bkgNo, String cntrNo) throws EventException {
		try {
			return dbDao.searchBkgCntrWgt(bkgNo, cntrNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * (ESM_BKG_0905) Retrieve info for Default value initialize when Open. <br>
	 * @author    Lee NamKyung
	 * @param     String doorLoc
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    TroActCustDefaultVO
	 * @exception EventException
	 */
	public TroActCustDefaultVO searchTroActCustDefault(String doorLoc, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchTroActCustDefault(doorLoc, bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00095").getUserMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 *  BKG_TRO Flag change.(ESM_BKG_0079_01)<br>
	 * @author 	Kim Byung Kyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
     * @exception EventException
     */
    public void unconfirmTro(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
        try {
        	dbDao.unconfirmTro(bkgBlNoVO,  account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  BKG_EUR_TRO Flag change.(ESM_BKG_0079_01)<br>
	 * @author 	Kim Byung Kyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   String boundCd
	 * @param 	SignOnUserAccount account
     * @exception EventException
     */
    public void unconfirmEurTro(BkgBlNoVO bkgBlNoVO, String boundCd, SignOnUserAccount account) throws EventException {
        try {
        	dbDao.unconfirmEurTro(bkgBlNoVO,  boundCd, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
    
    /**
     * tro relation info copy from sourceBkg to targetBkg.<br>
     * 
     * @param String copyModeCd
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectTroVO> selectTroVO
     * @param String troTp
     * @param SignOnUserAccount account
     * @return List<CombineTroNewSeqVO>
     * @exception EventException
     */
    public List<CombineTroNewSeqVO> copyTroByBkg (String copyModeCd, BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, List<SelectTroVO> selectTroVO, String troTp, SignOnUserAccount account) throws EventException{
    	try {
    		if("S".equals(copyModeCd)){	
	    		List<String[]> splitTroSeqs = new ArrayList<String[]>();
	    		for(int i=0;i<targetBkg.length;i++){
					for(int icnt=0;icnt<selectTroVO.size();icnt++){
		    			if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo()) 
		    					&& targetBkg[i].getBkgNo().equals(selectTroVO.get(icnt).getBkg_no())
		    					&& selectTroVO.get(icnt).getTroSeq().length()>0
		    					&& selectTroVO.get(icnt).getSplitNo().length()>0){
		    				String splitTroSeq[] = new String[4];
		    				splitTroSeq[0] = i + ""; //index of targetBkgNo
	    					splitTroSeq[1] = selectTroVO.get(icnt).getTroSeq();//tro_seq of master
		    				splitTroSeq[2] = selectTroVO.get(icnt).getTroSeq();//tro_seq of detail
		    				splitTroSeq[3] = selectTroVO.get(icnt).getTroSubSeq();//tro_sub_seq of detail
			    			splitTroSeqs.add(splitTroSeq);    				
						}
					}
	    		}
	    		int targetBkgSeq = 0;
//	    		String logStr = "\n";
				for(int i=1;i<splitTroSeqs.size();i++){
					for(int j=i-1;j>=0;j--){
		    			if(splitTroSeqs.get(i)[0].equals(splitTroSeqs.get(j)[0])){
		    				if(splitTroSeqs.get(i)[1].equals(splitTroSeqs.get(j)[1])){
		    					splitTroSeqs.get(i)[1] = "X";
		    				}
		    			}						
					}    			
	    		}
//				logStr = "\n";
				for(int i=0;i<splitTroSeqs.size();i++){			
					targetBkgSeq = Integer.parseInt(splitTroSeqs.get(i)[0]);		
//					logStr = logStr + "bkg_no:"+targetBkg[targetBkgSeq].getBkgNo() + ", tro_seq:"+splitTroSeqs.get(i)[1]+", tro_sub_seq:"+splitTroSeqs.get(i)[2]+":"+splitTroSeqs.get(i)[3]+"\n";
				}
//				log.debug("\ntro split order log======================================================================"+logStr);
	    		for(int i=0;i<splitTroSeqs.size();i++){
	    			targetBkgSeq = Integer.parseInt(splitTroSeqs.get(i)[0]);
					if("EUR".equals(troTp)){
						if(!splitTroSeqs.get(i)[1].equals("X")){ // exception continued mst seq
							dbDao.copyEurTroBySeq(sourceBkg, targetBkg[targetBkgSeq], splitTroSeqs.get(i)[1], "O", account);
						}
						dbDao.copyEurTroDtlBySeq(sourceBkg, targetBkg[targetBkgSeq], splitTroSeqs.get(i)[2], splitTroSeqs.get(i)[3], "O", account);
						//spcl cgo seq is not copy
						//dbDao.copyEurTroDgSeqBySeq(sourceBkg, targetBkg[i],selectTroVO.get(icnt).getTroSeq(), "O", account);
					} else {
						if(!splitTroSeqs.get(i)[1].equals("X")){ // exception continued mst seq 
							dbDao.copyTroBySeq(sourceBkg, targetBkg[targetBkgSeq], splitTroSeqs.get(i)[1], account);
						}
						dbDao.copyTroDtlBySeq(sourceBkg, targetBkg[targetBkgSeq], splitTroSeqs.get(i)[2], splitTroSeqs.get(i)[3], account);
						//spcl cgo seq is not copy
						//dbDao.copyTroSpclCgoSeqBySeq(sourceBkg, targetBkg[i], selectTroVO.get(icnt).getTroSeq(), account);
					}
	    		}
	    		
				//delete moved tro
	    		for(int icnt=0;icnt<selectTroVO.size();icnt++){
	    			if(selectTroVO.get(icnt).getBkg_no().equals(sourceBkg.getBkgNo())
							&& selectTroVO.get(icnt).getTroSeq().length()>0
							&& selectTroVO.get(icnt).getSplitNo().length()<1){
log.debug(sourceBkg.getBkgNo()+":"+selectTroVO.get(icnt).getTroSeq()+ ":"+selectTroVO.get(icnt).getTroSubSeq()+",DEL:"+ selectTroVO.get(icnt).getSplitDel());
						if("EUR".equals(troTp)){
							dbDao.removeEurTroDtl(sourceBkg, "O", selectTroVO.get(icnt).getTroSeq(), selectTroVO.get(icnt).getTroSubSeq());
							if(selectTroVO.get(icnt).getSplitDel().equals("Y")){
								dbDao.removeEurTroDgSeq				(sourceBkg, "O", selectTroVO.get(icnt).getTroSeq(), "");
								dbDao.removeEurTro					(sourceBkg, "O", selectTroVO.get(icnt).getTroSeq());
							}
						} else {    						
							dbDao.removeBkgTroDtlBySplit(sourceBkg, "N", selectTroVO.get(icnt).getTroSeq(), selectTroVO.get(icnt).getTroSubSeq());
	    					if(selectTroVO.get(icnt).getSplitDel().equals("Y")){
	        					dbDao.removeBkgTroXterIfBySplit		(sourceBkg, "N", selectTroVO.get(icnt).getTroSeq(), selectTroVO.get(icnt).getTroSubSeq());
								dbDao.removeBkgTroSpclCgoSeqBySplit	(sourceBkg, "N", selectTroVO.get(icnt).getTroSeq());
								dbDao.removeBkgTroBySplit			(sourceBkg, "N", selectTroVO.get(icnt).getTroSeq(), selectTroVO.get(icnt).getTroSubSeq());
							}
						}
					}
				}

	    		// pctl_no restore by null for unconfirm 
	    		for(int i=0;i<targetBkg.length;i++){
					if("EUR".equals(troTp)){
						dbDao.modifyEurTroPctlNo(targetBkg[i], "O", "", account);
					} else {
						dbDao.modifyTroPctlNo(targetBkg[i], "", account);
					}
	    		}
	    		return null;
    		} else if("M".equals(copyModeCd)){
    			// repeat as source bkg count when combine
//    			BookingUtil util = new BookingUtil();
//    			String troLastSeqStr = dbDao.searchTroLastSeq(sourceBkg);
//    			String[] troLastSeq = util.splitByToken(troLastSeqStr, "|");
    			StringBuffer targetBkgNoList = new StringBuffer();
    			targetBkgNoList.append(targetBkg[0].getBkgNo());

    			for(int i=0;i<targetBkg.length;i++){
//    				targetBkgNoList = targetBkgNoList + "|" + targetBkg[i].getBkgNo();
    				targetBkgNoList.append("|").append(targetBkg[i].getBkgNo());
    			}
    			
    			List<CombineTroNewSeqVO> combineTroNewSeqVOs = dbDao.searchCombineTroNewSeq(sourceBkg.getBkgNo(), targetBkgNoList.toString());
    			BkgBlNoVO[] newTargetBkg = new BkgBlNoVO[combineTroNewSeqVOs.size()];
    			for(int i=0;i<combineTroNewSeqVOs.size();i++){
    				newTargetBkg[i] = new BkgBlNoVO();
    				newTargetBkg[i].setBkgNo(combineTroNewSeqVOs.get(i).getOrgBkgNo());
    			}
//    			if(troLastSeq[0].length()>0 && !"0".equals(troLastSeq[0])){
//    				troTp = "GEN";
//    			} else if(troLastSeq[1].length()>0 && !"0".equals(troLastSeq[1])){
//    				troTp = "EUR";    				
//    			}
	    		for(int i=0;i<newTargetBkg.length;i++){
	    			if("GEN".equals(combineTroNewSeqVOs.get(i).getTroTp())){
	    				dbDao.moveBkgTro(combineTroNewSeqVOs.get(i), account);
	    				dbDao.moveBkgTroDtl(combineTroNewSeqVOs.get(i), account);
	    			} else if("EUR".equals(combineTroNewSeqVOs.get(i).getTroTp())){
	    				dbDao.moveBkgEurTro(combineTroNewSeqVOs.get(i), account);
	    				dbDao.moveBkgEurTroDtl(combineTroNewSeqVOs.get(i), account);
	    			}
	    		}
	    		return combineTroNewSeqVOs;
    		}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return null;
    }


    /**
	 * (ESM_BKG_0229_06) eBooking Tro relation save processing<br>
	 * : Include Tro/EurTro
	 * 
	 * @author Lee NamKyung
	 * @param  TroVO troVO
	 * @param  EurTroVO eurTroVO
	 * @param  String isEurFlg
	 * @param  SignOnUserAccount account
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageTroByXter(TroVO troVO, EurTroVO eurTroVO, String isEurFlg, SignOnUserAccount account) throws EventException {
		try{
			Map<String,Object> responseData = new HashMap<String,Object>();
			String    strErrCode = "";
			BkgBlNoVO bkgBlNoVO  = new BkgBlNoVO();

			//(containerVO)
			TroMstVO[] arrTroMstVO = null;
			TroDtlVO[] arrTroDtlVO = null;
			arrTroMstVO = troVO.getArrTroMstVO();
			arrTroDtlVO = troVO.getArrTroDtlVO();
			
			//1) EUR
			if ( "Y".equals(isEurFlg) ) {
				EurTroMstVO[] arrEurTroMstVO = null;
				EurTroDtlVO[] arrEurTroDtlVO = null;	
				arrEurTroMstVO = eurTroVO.getArrEurTroMstVO();
				arrEurTroDtlVO = eurTroVO.getArrEurTroDtlVO();				
//				dbDao.modifyEurTroDtlByXter(arrEurTroDtlVO[0]);
//				dbDao.modifyEurTroByXter(arrEurTroMstVO[0]);
				if (arrEurTroMstVO != null){
					for ( int i=0; i<arrEurTroMstVO.length; i++ ){
						arrEurTroMstVO[i].setHlgTpCd("C");
						arrEurTroMstVO[i].setCreUsrId(account.getUsr_id());
						arrEurTroMstVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addEurTroXter(arrEurTroMstVO[i]);
					}
				}
				if (arrEurTroDtlVO != null){
					for (int i=0; i<arrEurTroDtlVO.length; i++){
						arrEurTroDtlVO[i].setCreUsrId(account.getUsr_id());
						arrEurTroDtlVO[i].setUpdUsrId(account.getUsr_id());
						dbDao.addNewEurTroDtl(arrEurTroDtlVO[i]);
					}
				}
			} else { //2) general
				if (arrTroMstVO != null){
					for (int i=0; i<arrTroMstVO.length; i++){
						if (i == 0) {
							String bkgNo = arrTroMstVO[i].getBkgNo();
							bkgBlNoVO.setBkgNo(bkgNo);
						}
						
// : eBooking�뿉�뒗 mst delete �뾾�쓬.//1) (cxl_flag = 'Y' : 痍⑥냼)/I/U 泥섎━
//						if ("Y".equals(arrTroMstVO[i].getCxlFlg())) {
//							String boundCd   = arrTroMstVO[i].getIoBndCd();
//							String rtnTroFlg = arrTroMstVO[i].getRtnTroFlg();
//							String troSeq    = arrTroMstVO[i].getTroSeq();
//							String updUsrId  = account.getUsr_id();
//							dbDao.cancelBkgTro(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, updUsrId);
//						} else {
						// Don't handling when confirm, cancel(20100406 瑜섎��쁺)
						if("Y".equals(arrTroMstVO[i].getCfmFlg())||"Y".equals(arrTroMstVO[i].getCxlFlg())){
//							return responseData;
							continue;
						} else {
							arrTroMstVO[i].setUpdUsrId(account.getUsr_id());
							int updCnt = dbDao.modifyBkgTroByXter(arrTroMstVO[i]);  //modify : for ebooking
							if(updCnt==0){
								arrTroMstVO[i].setCreUsrId(account.getUsr_id());
								dbDao.addBkgTro(arrTroMstVO[i]);
							}
						}
					}
				}

				if (arrTroDtlVO != null){
					for (int i=0; i<arrTroDtlVO.length; i++){
						String cntrNo = arrTroDtlVO[i].getCntrNo();
						if (i == 0) {
							String bkgNo = arrTroDtlVO[i].getBkgNo();
							bkgBlNoVO.setBkgNo(bkgNo);
						}
						if (cntrNo.length() == 14) {
							//1-1) Check Booking Container exist or not 
							String cntExistYn = dbDao.searchCntrByBkg(cntrNo, bkgBlNoVO);
							if (!"Y".equals(cntExistYn)) {
								strErrCode = "BKG00449";
								throw new EventException(new ErrorHandler(strErrCode, new String[]{cntrNo}).getMessage());
							}

							//1-2) Retrieve message separator for Return
							String resultMsgFlag = dbDao.searchCntrPartial(cntrNo, bkgBlNoVO);
							if ("P".equals(resultMsgFlag)) {
								strErrCode = "BKG00453";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
							else if ("S".equals(resultMsgFlag)) {
								strErrCode = "BKG00451";
								responseData.put(WebKeys.ER_MESSAGE, new ErrorHandler(strErrCode).getUserMessage());
							}
						}

						//2) I/U/D processing 
						if ("Y".equals(arrTroDtlVO[i].getCxlFlg())){
							String boundCd   = arrTroDtlVO[i].getIoBndCd();
							String rtnTroFlg = arrTroDtlVO[i].getRtnTroFlg();
							String troSeq    = arrTroDtlVO[i].getTroSeq();
							String troSubSeq = arrTroDtlVO[i].getTroSubSeq();
							String updUsrId  = account.getUsr_id();
							dbDao.cancelBkgTroDtl(bkgBlNoVO, boundCd, rtnTroFlg, troSeq, troSubSeq, updUsrId);  
						} else {
							if ("U".equals(arrTroDtlVO[i].getIbflag())) {
								arrTroDtlVO[i].setUpdUsrId(account.getUsr_id());
								dbDao.modifyBkgTroDtlByXter(arrTroDtlVO[i]);  //modify : for ebooking		
							} else if ("I".equals(arrTroDtlVO[i].getIbflag())) {
								arrTroDtlVO[i].setCreUsrId(account.getUsr_id());
								arrTroDtlVO[i].setUpdUsrId(account.getUsr_id());
								dbDao.addBkgTroDtl(arrTroDtlVO[i]);
							}
						}
					}
				}
			}

			return responseData;
		} catch (EventException ex) {	
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	//<-----------------------------------------(containerVO)

	/**
	 * Handling when EUR mty release at CTM <br>
	 * @author    RYU DAEYOUNG
	 *
	 * @param EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyEurTroByEmptyRelease(EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO, SignOnUserAccount account) throws EventException{
		String jobDivCd = eurTroMtyRelByCtmVO.getJobDivCd();
		try {
			if ("RECOVERY".equals(jobDivCd)){
				dbDao.unconfirmEurTroByCtm(eurTroMtyRelByCtmVO, account);	
			}else if("RELEASE".equals(jobDivCd)){
				dbDao.confirmEurTroByCtm(eurTroMtyRelByCtmVO, account);
			}else if("REDELIVERY".equals(jobDivCd)){
				dbDao.redeliveEurTroByCfm(eurTroMtyRelByCtmVO, account);
			}		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
     * inland route Validation<br>
     * Checking to change route is registered or not as inland route.<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String BoundCd
	 * @param       String fullCy
	 * @param       String door
	 * @param		String trspModCd
	 * @param		String checkCop
	 * @exception 	EventException
	 */
	public void validateInlaneRoute(BkgBlNoVO bkgBlNoVO, String boundCd, String fullCy, String door,String trspModCd, String checkCop) throws EventException{
		try {
			List<ValidateInlandRouteVO> validateInlandRouteVO = dbDao.validateInlandRoute(bkgBlNoVO, boundCd, fullCy, door, trspModCd, checkCop);
			
			if(validateInlandRouteVO.size()==0){
				String strErrMsg = "("+fullCy+"-"+door+")";				
				throw new EventException(new ErrorHandler("BKG02032", new String[]{strErrMsg}).getMessage());
			}
		} catch (EventException eventEx) {
			throw eventEx;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	
	/**
     * renew pctl_no  in eur tro<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyEurTroPctlNo(BkgBlNoVO bkgBlNoVO, String boundCd, String troSeq, SignOnUserAccount account) throws EventException{
		try {
			dbDao.modifyEurTroPctlNo(bkgBlNoVO, boundCd, troSeq, account);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	/**
     * renew pctl_no in general tro..<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyTroPctlNo(BkgBlNoVO bkgBlNoVO, String troSeq, SignOnUserAccount account) throws EventException{
		try {
			dbDao.modifyTroPctlNo(bkgBlNoVO, troSeq, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * tro relation info copy  from sourceBkg to targetBkg
	 * @param sourceBkg String 
	 * @param targetBkgNoList String[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void copyTroBySplit(String sourceBkg, String[] targetBkgNoList, SignOnUserAccount account) throws EventException {
		try
		{
			if (targetBkgNoList != null)
			{
				for (int i = 0; i < targetBkgNoList.length; i++)
				{
					String targetBkg = targetBkgNoList[i];
					if (!targetBkg.equals(sourceBkg)) {
						dbDao.copyTroBySplit(sourceBkg, targetBkg, account);
						dbDao.copyTroDtlBySplit(sourceBkg, targetBkg, account);
						dbDao.copyTroSpclCgoSeqBySplit(sourceBkg, targetBkg, account);
						dbDao.copyEurTroBySplit(sourceBkg, targetBkg, account);
						dbDao.copyEurTroDtlBySplit(sourceBkg, targetBkg, account);
						dbDao.copyEurTroDgSeqBySplit(sourceBkg, targetBkg, account);
					}
				}
			}
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * cancel sourceBkg.
	 * @param sourceBkg String 
	 * @param targetBkgNoList String[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void cancelTroBySplit(String sourceBkg, String[] targetBkgNoList, SignOnUserAccount account) throws EventException {
		try
		{
			if (targetBkgNoList != null)
			{
				StringBuffer targetBkg = new StringBuffer();
				for (int i = 0; i < targetBkgNoList.length; i++)
				{
					targetBkg.append("'" + targetBkgNoList[i] + "'");
					if (i < targetBkgNoList.length - 1)
						targetBkg.append(",");
				}
				dbDao.cancelBkgTroDtlBySplit(sourceBkg, targetBkg.toString(), account);
				dbDao.cancelBkgTroBySplit(sourceBkg, targetBkg.toString(), account);
				dbDao.cancelEurTroBySplit(sourceBkg, targetBkg.toString(), account);
			}
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * TRO_SUB_SEQ瑜� 議고쉶�븳�떎.<br>
	 * @param     String bkgNo
	 * @param	  String boundCd
	 * @param	  String troSeq
	 * @return List<TroDtlVO>
	 * @exception EventException
	 */
	public List<TroDtlVO> searchEurTroSubSeqList(String bkgNo, String boundCd, String troSeq) throws EventException {
		try {
			return dbDao.searchEurTroSubSeq(bkgNo, boundCd, troSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Minimum TRO_SUB_SEQ瑜� 議고쉶�븳�떎.<br>
	 * @param      String bkgNo
	 * @param	  String boundCd
	 * @param	  String troSeq
	 * @return     String
	 * @exception EventException
	 */
	public String searchMinEurTroSubSeq(String bkgNo, String boundCd, String troSeq) throws EventException {
		try {
			return dbDao.searchMinEurTroSubSeq(bkgNo, boundCd, troSeq);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}

	/**
	 * Retrieve to check the change of key information after confirm at EUR TRO<br>
	 * @param     String bkgNo
	 * @param	  String ioBndCd
	 * @param	  String troSeq
	 * @return    List<EurTroChangeVO>
	 * @exception EventException
	 */
	public List<EurTroChangeVO> searchEurTroChange(String bkgNo, String ioBndCd, String troSeq) throws EventException {
		try {
			return dbDao.searchEurTroChange(bkgNo, ioBndCd, troSeq);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}

}
