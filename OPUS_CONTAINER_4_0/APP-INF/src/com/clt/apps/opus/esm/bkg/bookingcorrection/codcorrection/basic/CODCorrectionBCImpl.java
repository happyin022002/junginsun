/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CODCorrectionBCImpl.java
*@FileTitle : COD Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.23 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic;

import java.util.ArrayList;
import java.util.List;



import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration.CODCorrectionDBDAO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration.CODCorrectionEAIDAO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.BkgCODMgtConditionVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.BkgCodInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrDgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodHistoryVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodLastHistoryVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodMailSendVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodRsoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodStsInputVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodStsVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.PrnrCodRcvrVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.PrnrCodRqstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCodCntrVO;
import com.clt.syscommon.common.table.BkgCodCostVO;
import com.clt.syscommon.common.table.BkgCodVO;
import com.clt.syscommon.common.table.BkgCodVvdVO;
 

/**
 * OPUS-BookingCorrection Business Logic Basic Command implementation<br>
 * - OPUS-BookingCorrection business logic handling.<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0157EventResponse,CODCorrectionBC each DAO class reference
 * @since J2EE 1.6
 */
public class CODCorrectionBCImpl extends BasicCommandSupport implements CODCorrectionBC {

	// Database Access Object
	private transient CODCorrectionDBDAO dbDao = null;
	private transient CODCorrectionEAIDAO dbEaiDao = null;
	/**
	 * CODCorrectionBCImpl object creation<br>
	 * CODCorrectionDBDAO를 creation.<br>
	 */
	public CODCorrectionBCImpl() {
		dbDao = new CODCorrectionDBDAO();
		dbEaiDao = new CODCorrectionEAIDAO();
	}
	/**
	 * COD status info retrieve<br>
	 * 
	 * @param CodStsInputVO codStsInputVO
	 * @return List<CodStsVO>
	 * @exception EventException
	 */
	public List<CodStsVO> searchCodStsList(CodStsInputVO codStsInputVO) throws EventException {
		try {
			return dbDao.searchCodStsList(codStsInputVO);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * cod_rqst_seq of bkg_cod retrieve.<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO 
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<BkgComboVO> searchCodRqstSeq(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			if(bkgBlNoVO.getBkgNo().length()>0){
				bkgBlNoVO.setBlNo("");
			}
			return dbDao.searchCodRqstSeq(bkgBlNoVO);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
	/**
	 * booking status info retrieve for create cod request info.<br>
	 *  
	 * @param  String codRqstSeq
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return CodVO
	 * @exception EventException
	 */
	public CodVO searchCodRqst(String codRqstSeq, BkgBlNoVO bkgBlNoVO)throws EventException{
		BookingUtil util = new BookingUtil();
		CodVO codVO = new CodVO();
		try {
			if (bkgBlNoVO.getBkgNo().length()<1){
				bkgBlNoVO=util.searchBkgBlNoVO(bkgBlNoVO);
			} 
			
			//cod data
			bkgBlNoVO.setPctlNo("");
			List<CodEtcVO> codEtcVOs = dbDao.searchBkgCod(bkgBlNoVO, codRqstSeq);
			if(codEtcVOs.size()>0){
				codVO.setCodEtcVO(codEtcVOs); 				
				codVO.setCodCntrVO(dbDao.searchCodCntr(bkgBlNoVO, codRqstSeq, codEtcVOs.get(0).getCodStatus()));
				codVO.setBkgOldCodVvdVO(dbDao.searchCodOldRoute(bkgBlNoVO, codRqstSeq));
				codVO.setBkgNewCodVvdVO(dbDao.searchCodNewRoute(bkgBlNoVO, codRqstSeq));
				codVO.setBkgCodCostVO(dbDao.searchCodCost(bkgBlNoVO , codRqstSeq));
				codVO.setBkgCodCostSumVO(dbDao.searchCodCostSum(bkgBlNoVO, codRqstSeq));
				codVO.setCodLastHistoryVO(dbDao.searchCodLastHistory(bkgBlNoVO, codRqstSeq)); 			
			} else {
				throw new EventException(new ErrorHandler("BKG00095",new String[]{}).getMessage());				
			}
			//email dg info
			List<CodCntrDgInfoVO> dgInfoVOs = null;
			for(int i=0;i<codVO.getCodCntrVO().size();i++){
				if("Y".equals(codVO.getCodCntrVO().get(i).getDcgoFlg())){
					dgInfoVOs = dbDao.searchCodCntrDgInfo(bkgBlNoVO, codRqstSeq);
					break;
				}
			}
			if(dgInfoVOs!=null){
				for(int i=0;i<codVO.getCodCntrVO().size();i++){
					for(int j=0;j<dgInfoVOs.size();j++){
						if(codVO.getCodCntrVO().get(i).getCntrNo().equals(dgInfoVOs.get(j).getCntrNo())){
							if(codVO.getCodCntrVO().get(i).getDgEmlCtnt()==null || codVO.getCodCntrVO().get(i).getDgEmlCtnt().length()<1){
								codVO.getCodCntrVO().get(i).setDgEmlCtnt(dgInfoVOs.get(j).getDgInfo());
							} else {
								codVO.getCodCntrVO().get(i).setDgEmlCtnt(codVO.getCodCntrVO().get(i).getDgEmlCtnt()+"<BR>"+dgInfoVOs.get(j).getDgInfo());
							}
						}
					}					
				}
			}
		} catch (EventException ex) {
			throw ex;		
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return codVO;
	}
	
	/**
	 * cod request history retrieve<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVo
	 * @param  String codRqstSeq
	 * @return List<CodHistoryVO>
	 * @exception EventException
	 */
	public List<CodHistoryVO> searchCodHistory(BkgBlNoVO bkgBlNoVO, String  codRqstSeq) throws EventException{
		try {
			return dbDao.searchCodHistory(bkgBlNoVO,codRqstSeq);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * cod request info create.<br>
     * 
	 * @param  CodVO codVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCodRqst(CodVO codVO,SignOnUserAccount account) throws EventException{
		try {
			 dbDao.addBkgCod(codVO.getBkgCodVO().get(0),account);
			 
			 if (codVO.getBkgOldCodVvdVOs() !=null){
				 for(int iOld=0;iOld<codVO.getBkgOldCodVvdVOs().length;iOld++){
					 dbDao.addBkgCodVvd(codVO.getBkgOldCodVvdVOs()[iOld], null, account);
				 }
			 }
			 if (codVO.getBkgNewCodVvdVOs() !=null){
				 for(int iNew=0;iNew<codVO.getBkgNewCodVvdVOs().length;iNew++){
					 dbDao.addBkgCodVvd(codVO.getBkgNewCodVvdVOs()[iNew], null, account);
				 }				 
			 }			 
			 
			 for(int i=0;i<codVO.getCodCntrVO().size();i++){
				 BkgCodCntrVO bkgCodCntrVO = new BkgCodCntrVO();
				 bkgCodCntrVO.setBkgNo		(codVO.getBkgCodVO().get(0).getBkgNo());
				 bkgCodCntrVO.setCodRqstSeq	(codVO.getBkgCodVO().get(0).getCodRqstSeq());
				 bkgCodCntrVO.setCodSlctFlg	(codVO.getCodCntrVO().get(i).getChk());
				 bkgCodCntrVO.setCntrNo		(codVO.getCodCntrVO().get(i).getCntrNo());
				 bkgCodCntrVO.setCntrStwgNo	(codVO.getCodCntrVO().get(i).getCntrStwgNo());
				 bkgCodCntrVO.setCntrTpszCd	(codVO.getCodCntrVO().get(i).getCntrTpszCd());
				 bkgCodCntrVO.setCntrWgt	(codVO.getCodCntrVO().get(i).getCntrWgt());
				 bkgCodCntrVO.setWgtUtCd	(codVO.getCodCntrVO().get(i).getWgtUtCd());
				 bkgCodCntrVO.setDcgoFlg	(codVO.getCodCntrVO().get(i).getDcgoFlg());
				 bkgCodCntrVO.setRcFlg		(codVO.getCodCntrVO().get(i).getRcFlg());
				 bkgCodCntrVO.setBbCgoFlg	(codVO.getCodCntrVO().get(i).getBbCgoFlg());
				 bkgCodCntrVO.setAwkCgoFlg	(codVO.getCodCntrVO().get(i).getAwkCgoFlg());
				 bkgCodCntrVO.setSocFlg		(codVO.getCodCntrVO().get(i).getSocFlg());
				 
				 dbDao.addBkgCodCntr(bkgCodCntrVO, account);
			 }
			 if (codVO.getBkgCodCostVOs() !=null){
				 for(int i=0;i<codVO.getBkgCodCostVOs().length;i++){
					 dbDao.addBkgCodCost(codVO.getBkgCodCostVOs()[i],account);
				 }
			 }
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * cod request history manage.<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCodHistory(BkgBlNoVO bkgBlNoVO , String codRqstSeq,SignOnUserAccount account) throws EventException{
		try {
			 dbDao.addBkgCodHis(bkgBlNoVO,codRqstSeq,account);			 
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * COD request info modify<br>
     * 
	 * @param  CodVO codVO
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodRqst(CodVO codVO,BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws EventException{
		try {
			String stsCd =dbDao.searchCodRqstSts(bkgBlNoVO,codRqstSeq); 
			String bkgNo =codVO.getBkgCodVO().get(0).getBkgNo();
			log.debug("stsCd:"+stsCd);
			if(stsCd!=null&&stsCd.length()==1){
				if (stsCd.equals("Y")||stsCd.equals("N")||stsCd.equals("C")||stsCd.equals("F")){
					throw new EventException(new ErrorHandler("BKG00746").getUserMessage());
				}
			}
			int insCnt = dbDao.modifyBkgCod(codVO.getBkgCodVO().get(0), account);
			if(insCnt==0){
				createCodRqst(codVO, account);
			} else {
				dbDao.removeBkgCodVvd(bkgBlNoVO, codRqstSeq, null);
				if (codVO.getBkgOldCodVvdVOs()!=null){
					 for(int iOld=0;iOld<codVO.getBkgOldCodVvdVOs().length;iOld++){
						 dbDao.addBkgCodVvd(codVO.getBkgOldCodVvdVOs()[iOld], "", account);
					 }
				}
				if (codVO.getBkgNewCodVvdVOs()!=null){
					 for(int iNew=0;iNew<codVO.getBkgNewCodVvdVOs().length;iNew++){
						 dbDao.addBkgCodVvd(codVO.getBkgNewCodVvdVOs()[iNew], "", account);
					 }			
				}
				dbDao.removeBkgCodCntr(bkgBlNoVO, codRqstSeq);
				for(int i=0;i<codVO.getCodCntrVO().size();i++){
					BkgCodCntrVO bkgCodCntrVO = new BkgCodCntrVO();
					bkgCodCntrVO.setBkgNo		(bkgNo);
					bkgCodCntrVO.setCodRqstSeq	(codRqstSeq);
					bkgCodCntrVO.setCodSlctFlg	(codVO.getCodCntrVO().get(i).getChk());
					bkgCodCntrVO.setCntrNo		(codVO.getCodCntrVO().get(i).getCntrNo());
					bkgCodCntrVO.setCntrStwgNo	(codVO.getCodCntrVO().get(i).getCntrStwgNo());
					bkgCodCntrVO.setCntrTpszCd	(codVO.getCodCntrVO().get(i).getCntrTpszCd());
					bkgCodCntrVO.setCntrWgt		(codVO.getCodCntrVO().get(i).getCntrWgt());
					bkgCodCntrVO.setWgtUtCd		(codVO.getCodCntrVO().get(i).getWgtUtCd());
					bkgCodCntrVO.setDcgoFlg		(codVO.getCodCntrVO().get(i).getDcgoFlg());
					bkgCodCntrVO.setRcFlg		(codVO.getCodCntrVO().get(i).getRcFlg());
					bkgCodCntrVO.setBbCgoFlg	(codVO.getCodCntrVO().get(i).getBbCgoFlg());
					bkgCodCntrVO.setAwkCgoFlg	(codVO.getCodCntrVO().get(i).getAwkCgoFlg());
					bkgCodCntrVO.setSocFlg		(codVO.getCodCntrVO().get(i).getSocFlg());
					dbDao.addBkgCodCntr(bkgCodCntrVO, account);
				}
				if (codVO.getBkgCodCostVOs()!=null){
					dbDao.removeBkgCodCost(bkgBlNoVO, codRqstSeq);
					for(int i=0;i<codVO.getBkgCodCostVOs().length;i++){
						codVO.getBkgCodCostVOs()[i].setBkgNo     (bkgNo);
						codVO.getBkgCodCostVOs()[i].setCodRqstSeq(codRqstSeq);
						codVO.getBkgCodCostVOs()[i].setCostCdRqstSeq((i+1)+"");
						dbDao.addBkgCodCost(codVO.getBkgCodCostVOs()[i],account);
					}
				}
			}
		} catch (EventException ex) {
			throw ex;		
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * COD request info remove<br>
     * 
	 * @param  CodVO codVO
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCodRqst(CodVO codVO,BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws EventException{
		try {
			String stsCd =dbDao.searchCodRqstSts(bkgBlNoVO,codRqstSeq); 
			if (stsCd.equals("Y")||stsCd.equals("N")||stsCd.equals("R")||stsCd.equals("F")){
				throw new EventException(new ErrorHandler("BKG00746").getUserMessage());
			}
			dbDao.removeBkgCodHis(bkgBlNoVO, codRqstSeq);
			dbDao.removeBkgCodCntr(bkgBlNoVO, codRqstSeq);
			dbDao.removeBkgCodCost(bkgBlNoVO, codRqstSeq);
			dbDao.removeBkgCodVvd(bkgBlNoVO, codRqstSeq, null);
			dbDao.removeBkgCod(bkgBlNoVO, codRqstSeq);
			
//			dbDao.addBkgCodHis(bkgBlNoVO,codRqstSeq,account);
		} catch (EventException ex) {
			throw ex;		
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * COD info in saved OPF request approval.<br>
	 * 
	 * @param  CodVO codVO
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodApproval(CodVO codVO,BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws EventException{
		try {
			//no-used
			manageCodHistory(bkgBlNoVO,codRqstSeq,account);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * cod request status modify.<br>
     * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  String codStatusCd
	 * @param  String codRqstRsnCd
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodStatus(BkgBlNoVO bkgBlNoVO, String codRqstSeq,String codStatusCd,String codRqstRsnCd, SignOnUserAccount account) throws EventException{
		try {
			dbDao.modifyCodStatus(bkgBlNoVO, codRqstSeq , codStatusCd, codRqstRsnCd, account); 
			dbDao.addBkgCodHis(bkgBlNoVO,codRqstSeq,account);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 *  approve Cod<br>
     *  
	 * @param  CodAuthVO codAuthVo
	 * @param  BkgCodCostVO[] bkgCodCostVOs
	 * @param  String chgRmk
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveCod(CodAuthVO codAuthVO,BkgCodCostVO[] bkgCodCostVOs,String chgRmk, SignOnUserAccount account) throws EventException{
		try {
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			if (bkgCodCostVOs !=null){
				bkgBlNoVO.setBkgNo(bkgCodCostVOs[0].getBkgNo());
				dbDao.removeBkgCodCost(bkgBlNoVO,bkgCodCostVOs[0].getCodRqstSeq());
				
				for(int i=0;i<bkgCodCostVOs.length;i++){
					if(bkgCodCostVOs[i].getIbflag().equals("I")||bkgCodCostVOs[i].getIbflag().equals("R")||bkgCodCostVOs[i].getIbflag().equals("U")){
					dbDao.addBkgCodCost(bkgCodCostVOs[i], account);
					}
				}
				dbDao.modifyBkgCodTotalCost(bkgCodCostVOs[0],chgRmk, account);
			}
			if (codAuthVO.getBkgNo().length()>0){
				if (codAuthVO.getCodstscd().toUpperCase().equals("Y") ||codAuthVO.getCodstscd().toUpperCase().equals("W")){
					dbDao.confirmCodRqst(codAuthVO, account);
				}else if (codAuthVO.getCodstscd().toUpperCase().equals("N")){
					dbDao.rejectCodRqst(codAuthVO, account);
				}
				bkgBlNoVO.setBkgNo(codAuthVO.getBkgNo());
				dbDao.addBkgCodHis(bkgBlNoVO,codAuthVO.getCodRqstSeq(),account);
			}
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
  
	/**
	 * confirm Cod.<br>
     * 
	 * @param  String codRqstSeq
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmCod (String codRqstSeq, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.modifyCodStatus(bkgBlNoVO, codRqstSeq, "F", "", account);
			dbDao.addBkgCodHis(bkgBlNoVO,codRqstSeq,account);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * Cod Rgn modify.<br>
	 *
	 * @param  BkgCodVO bkgCodVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodRgn(BkgCodVO bkgCodVO,SignOnUserAccount account)throws EventException{
		try {
			dbDao.modifyCodRso(bkgCodVO,account);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * (ESM_BKG_156) Cod Request rehandling Port retrieve.<br>
	 * @author    Ryu DaeYoung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     CodAuthVO codAuthVO
	 * @param     SignOnUserAccount account
	 * @return    CodVO
	 * @exception EventException
	 */
	public CodVO searchRehandlingPort(BkgBlNoVO bkgBlNoVO, CodAuthVO codAuthVO, SignOnUserAccount account) throws EventException{
		try {
			log.debug("bkg_no:"+bkgBlNoVO.getBkgNo()+",pctl_no:"+bkgBlNoVO.getPctlNo()+",cod_rqst_Seq:"+codAuthVO.getCodRqstSeq()+",cod_sts_cd:"+codAuthVO.getCodstscd());
			String codRqstSeq = codAuthVO.getCodRqstSeq();
			
			CodVO    codVO    = new CodVO();
			BkgCodVO bkgCodVO = new BkgCodVO();

			codVO.setCodEtcVO          (dbDao.searchBkgCod(bkgBlNoVO, codRqstSeq));					
			codVO.setBkgOldCodVvdVO    (dbDao.searchCodOldRoute(bkgBlNoVO, codRqstSeq));
			codVO.setBkgNewCodVvdVO    (dbDao.searchCodNewRoute(bkgBlNoVO, codRqstSeq));	
			bkgCodVO.setCodRhndPortYdCd(dbDao.searchRehandlingPort(bkgBlNoVO, codRqstSeq)); 
			
			String rhndVvd  = "X";
			String rhndYdCd = bkgCodVO.getCodRhndPortYdCd(); 
	    	//rehandling vvd
	    	for(int i=0;i<codVO.getBkgNewCodVvdVO().size();i++){
	    		if(codVO.getBkgNewCodVvdVO().get(i).getPodYdCd().equals(rhndYdCd)){
	    			rhndVvd = codVO.getBkgNewCodVvdVO().get(i).getVslCd()
	    					 +codVO.getBkgNewCodVvdVO().get(i).getSkdVoyNo()
	    					 +codVO.getBkgNewCodVvdVO().get(i).getSkdDirCd();
	    			break;
	    		}
	    	}
	    	if("X".equals(rhndVvd)){
		    	for(int i=0;i<codVO.getBkgOldCodVvdVO().size();i++){
		    		if(codVO.getBkgOldCodVvdVO().get(i).getPodYdCd().equals(rhndYdCd)){
		    			rhndVvd = codVO.getBkgOldCodVvdVO().get(i).getVslCd()
		    					 +codVO.getBkgOldCodVvdVO().get(i).getSkdVoyNo()
		    					 +codVO.getBkgOldCodVvdVO().get(i).getSkdDirCd();
		    			break;
		    		}
		    	}
	    	}			
			List<CodCntrVO> codCntrVOs = dbDao.searchStowageCd(bkgBlNoVO, codRqstSeq, rhndVvd, rhndYdCd);
			codVO.setCodCntrVO(codCntrVOs);
			
			CodRsoVO codRsoVO = dbDao.searchCodRso(bkgBlNoVO, codRqstSeq, bkgCodVO.getCodRhndPortYdCd()); 
			if(codRsoVO==null){
				throw new EventException(new ErrorHandler("BKG00982").getMessage());
			}			
			codVO.setCodRsoVO(codRsoVO);			
			
			List<BkgCodVO> bkgCodVOs = new ArrayList<BkgCodVO>();
			bkgCodVOs.add(bkgCodVO);
			codVO.setBkgCodVO(bkgCodVOs);
	    	return codVO;
		} catch (EventException ex) {
			throw ex;		
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Cod request rehandling vvd retrieve.<br>
	 * 
	 * @param String bkgNo
	 * @param String codRqstSeq
	 * @return CodRehandlingInfoVO
	 * @throws EventException
	 */
	public CodRehandlingInfoVO searchRehandlingInfo(String bkgNo, String codRqstSeq)throws EventException{
		try {
			CodRehandlingInfoVO codRehandlingInfoVO = new CodRehandlingInfoVO();
			codRehandlingInfoVO.setCodOldNewRhndPortVvdVO(dbDao.searchRehandlingVvd(bkgNo,codRqstSeq));

			List<CodCntrVO> selectCodCntrVOs = new ArrayList<CodCntrVO>();
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);
			List<CodCntrVO> codCntrVOs = dbDao.searchCodCntr(bkgBlNoVO, codRqstSeq, "R");
			for(int i=0;i<codCntrVOs.size();i++){
				if("Y".equals(codCntrVOs.get(i).getChk())){
					selectCodCntrVOs.add(codCntrVOs.get(i));
				}
			}			
			codRehandlingInfoVO.setCodCntrVOs(selectCodCntrVOs);
	    	return codRehandlingInfoVO;
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Cod request E-mail send .<br>
	 * 
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendXterCodRqst(String codRqstSeq, BkgBlNoVO bkgBlNoVO , SignOnUserAccount account )throws EventException{
		try {
			PrnrCodRqstVO prnrCodRqstVO = dbDao.searchPrnrCodRqst(bkgBlNoVO, codRqstSeq);
			PrnrCodRcvrVO prnrCodRcvrVO = dbDao.searchPrnrCodRcvr(bkgBlNoVO, codRqstSeq, prnrCodRqstVO.getRhndVvd(), account);
			
			// not exist receiver
			if(prnrCodRcvrVO==null){ 
				return;
			} else if(prnrCodRcvrVO.getToEml()==null||prnrCodRcvrVO.getToEml().length()<1){
				return;
			}
			
//			List<CodCntrVO>  codCntrVOs = dbDao.searchPrnrCodCntr(bkgBlNoVO, codRqstSeq);
			List<CodCntrVO>  codCntrVOs = dbDao.searchCodCntr(bkgBlNoVO, codRqstSeq, "*");

			//email dg info

			List<CodCntrVO>  sndCodCntrVOs = new ArrayList<CodCntrVO>();
			for(int i=0;i<codCntrVOs.size();i++){
				if("Y".equals(codCntrVOs.get(i).getChk())){
					sndCodCntrVOs.add(codCntrVOs.get(i));
				}
			}
			
			List<CodCntrDgInfoVO> dgInfoVOs = null;
			for(int i=0;i<sndCodCntrVOs.size();i++){
				if("Y".equals(sndCodCntrVOs.get(i).getDcgoFlg())){
					dgInfoVOs = dbDao.searchCodCntrDgInfo(bkgBlNoVO, codRqstSeq);
					break;
				}
			}
			if(dgInfoVOs!=null){
				for(int i=0;i<sndCodCntrVOs.size();i++){
					for(int j=0;j<sndCodCntrVOs.size();j++){
						if(sndCodCntrVOs.get(i).getCntrNo().equals(dgInfoVOs.get(j).getCntrNo())){
							if(sndCodCntrVOs.get(i).getDgEmlCtnt()==null || sndCodCntrVOs.get(i).getDgEmlCtnt().length()<1){
								sndCodCntrVOs.get(i).setDgEmlCtnt(dgInfoVOs.get(j).getDgInfo());
							} else {
								sndCodCntrVOs.get(i).setDgEmlCtnt(sndCodCntrVOs.get(i).getDgEmlCtnt()+"<BR>"+dgInfoVOs.get(j).getDgInfo());
							}
						}
					}					
				}
			}
			prnrCodRcvrVO.setCcEml(account.getUsr_eml());
//			dbEaiDao.sendXterCodRqst(prnrCodRqstVO, prnrCodRcvrVO, sndCodCntrVOs);
			
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * In situation g/w mail cod request, mail data retrieve..<br>
	 * 
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return PrnrCodRqstVO
	 * @throws EventException
	 */
	public PrnrCodRqstVO searchCodRqstEmlCtnt(String codRqstSeq, BkgBlNoVO bkgBlNoVO , SignOnUserAccount account )throws EventException{
		try{
			return dbDao.searchPrnrCodRqst(bkgBlNoVO, codRqstSeq);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * when cod split, dest route info retrieve..<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @return CodEtcVO
	 * @throws EventException
	 */
	public CodEtcVO searchCodSplitRoute(BkgBlNoVO bkgBlNoVO, String codRqstSeq) throws EventException{
		try {
			List<CodEtcVO> codEtcVO = dbDao.searchBkgCod(bkgBlNoVO, codRqstSeq);
			return codEtcVO.get(0);
			
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}

	/**
	 * Retrieve EMAIL by RSO, LANE <br>
	 * @param BkgCODMgtConditionVO bkgCODMgtConditionVO
	 * @return List<BkgCodInfoVO>
	 * @exception EventException
	 */
	public List<BkgCodInfoVO> searchCODEmailsendList(BkgCODMgtConditionVO bkgCODMgtConditionVO) throws EventException {
		try {
			return dbDao.searchCODEmailsendList(bkgCODMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
	}

	/**
	 * Retrieve NEW,OLD POD CODE of BKG chosen<br>
	 * @param BkgCODMgtConditionVO bkgCODMgtConditionVO
	 * @return List<BkgCodInfoVO>
	 * @exception EventException
	 */
	public List<BkgCodInfoVO> searchCODNewOldPODCd(BkgCODMgtConditionVO bkgCODMgtConditionVO) throws EventException {
		try {
			return dbDao.searchCODNewOldPODCd(bkgCODMgtConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
	}
	
	/**
	 * Retrieve COD Cntr for Email<br>
	 * 
	 * @param String bkgNo
	 * @param String cod_sts_cd
	 * @param String codRqstSeq
	 * @return List<CodVO>
	 * @exception EventException
	 */
	public CodVO searchCODCntrforMail(String bkgNo, String cod_sts_cd, String codRqstSeq) throws EventException{
		CodVO codVO = new CodVO();
		BkgBlNoVO bkgBlNoVO = null;
		try{
			bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);	
			codVO.setCodCntrVO(dbDao.searchCodCntr(bkgBlNoVO, codRqstSeq, cod_sts_cd));
				
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return codVO;
	}
	
	/**
	 * Send email for COD<br>
	 * 
	 * @param CodMailSendVO codMailSendVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendCODEmail(CodMailSendVO codMailSendVO, SignOnUserAccount account) throws EventException{
		try {
			CodVO codVO = null;
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			List<BkgCodVvdVO> bkgCodVvdVOs = null;
			BkgCODMgtConditionVO bkgCODMgtConditionVO = new BkgCODMgtConditionVO();
			StringBuffer oldPol = new StringBuffer();
			StringBuffer oldPod = new StringBuffer();
			StringBuffer newPod = new StringBuffer();
			StringBuffer comSubject = new StringBuffer();
			if("N".equalsIgnoreCase(codMailSendVO.getEdtEmlBtnFlg())){
				// To search BkgCOD
				bkgBlNoVO.setPctlNo("");		
				bkgBlNoVO.setBkgNo(codMailSendVO.getBkgNo());
				List<CodEtcVO> codEtcVOs = dbDao.searchBkgCod(bkgBlNoVO, codMailSendVO.getCodRqstSeq());
				// To find information for mail
				bkgCODMgtConditionVO.setBkgNo(codEtcVOs.get(0).getBkgNo());
				bkgCODMgtConditionVO.setOldPolCd(codEtcVOs.get(0).getOldPolCd());
				bkgCODMgtConditionVO.setOldPodCd(codEtcVOs.get(0).getOldPodCd());
				bkgCODMgtConditionVO.setNewPodCd(codEtcVOs.get(0).getNewPodCd());
				bkgCODMgtConditionVO.setVvd(codEtcVOs.get(0).getNewTvvd());
				List<BkgCodInfoVO> bkgCodInfoVOs = searchCODNewOldPODCd(bkgCODMgtConditionVO);
				bkgCodVvdVOs = dbDao.searchCodNewRoute(bkgBlNoVO, codMailSendVO.getCodRqstSeq());
				bkgCODMgtConditionVO.setRso(codEtcVOs.get(0).getApprovalRso());
				bkgCODMgtConditionVO.setSlanCd(bkgCodVvdVOs.get(0).getSlanCd());
				// Find Recipient
				List<BkgCodInfoVO> bkgCodInfoVOs2 = searchCODEmailsendList(bkgCODMgtConditionVO);
				// Set Mail information
				List<CodLastHistoryVO> codLastHistoryVO = dbDao.searchCodLastHistory(bkgBlNoVO, codMailSendVO.getCodRqstSeq());
				codMailSendVO.setCodRemark(codEtcVOs.get(0).getCodRemark().replace("\n", "<br/>"));
				codMailSendVO.setVslEngNm(bkgCodInfoVOs.get(0).getVslEngNm());
				codMailSendVO.setObCssmVoyNm(bkgCodInfoVOs.get(0).getObCssmVoyNo());
				oldPol.append(codEtcVOs.get(0).getOldPolCd()+"("+bkgCodInfoVOs.get(0).getOldPolFullNm()+")");
				oldPod.append(codEtcVOs.get(0).getOldPodCd()+"("+bkgCodInfoVOs.get(0).getOldPodFullNm()+")");
				newPod.append(codEtcVOs.get(0).getNewPodCd()+"("+bkgCodInfoVOs.get(0).getNewPodFullNm()+")");
				codMailSendVO.setOldPol(oldPol.toString());
				codMailSendVO.setOldPod(oldPod.toString());
				codMailSendVO.setNewPod(newPod.toString());
				codMailSendVO.setComRecipient(bkgCodInfoVOs2.get(0).getPicEml());
				comSubject.append("["+bkgCODMgtConditionVO.getSlanCd()+"] COD Application "+ bkgCodInfoVOs.get(0).getVslEngNm()+" "+bkgCodInfoVOs.get(0).getObCssmVoyNo() + "("+codMailSendVO.getBkgNo()+")");
				if(!"".equalsIgnoreCase(codLastHistoryVO.get(0).getNowRead().substring(2))){
					codMailSendVO.setCodSts(codLastHistoryVO.get(0).getNowRead().substring(2));
					comSubject.append(" - " + codLastHistoryVO.get(0).getNowRead().substring(2));
				}
				codMailSendVO.setComSubject(comSubject.toString());
				codMailSendVO.setCodStsCd(codLastHistoryVO.get(0).getNowRead().substring(2));
				// Set COD CNTR
				codVO = searchCODCntrforMail(codMailSendVO.getBkgNo(), codMailSendVO.getCodStsCd(), codMailSendVO.getCodRqstSeq());
				List<CodCntrVO> list = codVO.getCodCntrVO();
				StringBuffer cntr_content = new StringBuffer();
				for(int i=0; i < list.size(); i++){
					if("N".equalsIgnoreCase(codVO.getCodCntrVO().get(i).getChk())){
						continue;
					}
					cntr_content.append("<tr align=center>");
					cntr_content.append("<td>"+ list.get(i).getCntrNo() +"</td>");
					cntr_content.append("<td>"+ list.get(i).getCntrTpszCd()+" ["+list.get(i).getCntrTpszDesc()+"]" +"</td>");
					cntr_content.append("<td>"+ list.get(i).getCntrWgt() +"</td>");
					cntr_content.append("</tr>");
					codMailSendVO.setCntrList(cntr_content.toString());
				}
			}
			dbEaiDao.sendCODEmail(codMailSendVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	/**
	 * Search email for COD<br>
	 * 
	 * @param CodMailSendVO codMailSendVO
	 * @param SignOnUserAccount account
	 * @return CodMailSendVO
	 * @exception EventException
	 */
	public CodMailSendVO searchCODEmailInfo(CodMailSendVO codMailSendVO, SignOnUserAccount account) throws EventException{
		try {
			CodVO codVO = null;
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			List<BkgCodVvdVO> bkgCodVvdVOs = null;
			BkgCODMgtConditionVO bkgCODMgtConditionVO = new BkgCODMgtConditionVO();
			StringBuffer oldPol = new StringBuffer();
			StringBuffer oldPod = new StringBuffer();
			StringBuffer newPod = new StringBuffer();
			StringBuffer comSubject = new StringBuffer();
			// To search BkgCOD
			bkgBlNoVO.setPctlNo("");		
			bkgBlNoVO.setBkgNo(codMailSendVO.getBkgNo());
			List<CodEtcVO> codEtcVOs = dbDao.searchBkgCod(bkgBlNoVO, codMailSendVO.getCodRqstSeq());
			// To find information for mail
			bkgCODMgtConditionVO.setBkgNo(codEtcVOs.get(0).getBkgNo());
			bkgCODMgtConditionVO.setOldPolCd(codEtcVOs.get(0).getOldPolCd());
			bkgCODMgtConditionVO.setOldPodCd(codEtcVOs.get(0).getOldPodCd());
			bkgCODMgtConditionVO.setNewPodCd(codEtcVOs.get(0).getNewPodCd());
			bkgCODMgtConditionVO.setVvd(codEtcVOs.get(0).getNewTvvd());
			List<BkgCodInfoVO> bkgCodInfoVOs = searchCODNewOldPODCd(bkgCODMgtConditionVO);
			bkgCodVvdVOs = dbDao.searchCodNewRoute(bkgBlNoVO, codMailSendVO.getCodRqstSeq());
			bkgCODMgtConditionVO.setRso(codEtcVOs.get(0).getApprovalRso());
			bkgCODMgtConditionVO.setSlanCd(bkgCodVvdVOs.get(0).getSlanCd());
			// Find Recipient
			List<BkgCodInfoVO> bkgCodInfoVOs2 = searchCODEmailsendList(bkgCODMgtConditionVO);
			// Set Mail information
			List<CodLastHistoryVO> codLastHistoryVO = dbDao.searchCodLastHistory(bkgBlNoVO, codMailSendVO.getCodRqstSeq());
			codMailSendVO.setCodRemark(codEtcVOs.get(0).getCodRemark());
			codMailSendVO.setVslEngNm(bkgCodInfoVOs.get(0).getVslEngNm());
			codMailSendVO.setObCssmVoyNm(bkgCodInfoVOs.get(0).getObCssmVoyNo());
			oldPol.append(codEtcVOs.get(0).getOldPolCd()+"("+bkgCodInfoVOs.get(0).getOldPolFullNm()+")");
			oldPod.append(codEtcVOs.get(0).getOldPodCd()+"("+bkgCodInfoVOs.get(0).getOldPodFullNm()+")");
			newPod.append(codEtcVOs.get(0).getNewPodCd()+"("+bkgCodInfoVOs.get(0).getNewPodFullNm()+")");
			codMailSendVO.setOldPol(oldPol.toString());
			codMailSendVO.setOldPod(oldPod.toString());
			codMailSendVO.setNewPod(newPod.toString());
			if(bkgCodInfoVOs2.size() > 0){
				codMailSendVO.setComRecipient(bkgCodInfoVOs2.get(0).getPicEml());
			}
			comSubject.append("["+bkgCODMgtConditionVO.getSlanCd()+"] COD Application "+ bkgCodInfoVOs.get(0).getVslEngNm()+" "+bkgCodInfoVOs.get(0).getObCssmVoyNo() + "("+codMailSendVO.getBkgNo()+")");
			if(!"".equalsIgnoreCase(codLastHistoryVO.get(0).getNowRead().substring(2))){
				codMailSendVO.setCodSts(codLastHistoryVO.get(0).getNowRead().substring(2));
				comSubject.append(" - " + codLastHistoryVO.get(0).getNowRead().substring(2));
			}
			codMailSendVO.setComSubject(comSubject.toString());
			codMailSendVO.setCodStsCd(codLastHistoryVO.get(0).getNowRead().substring(2));
			// Set COD CNTR
			codVO = searchCODCntrforMail(codMailSendVO.getBkgNo(), codMailSendVO.getCodStsCd(), codMailSendVO.getCodRqstSeq());
			List<CodCntrVO> list = codVO.getCodCntrVO();
			StringBuffer cntr_content = new StringBuffer();
			for(int i=0; i < list.size(); i++){
				if("N".equalsIgnoreCase(codVO.getCodCntrVO().get(i).getChk())){
					continue;
				}
				cntr_content.append("<tr align=center>");
				cntr_content.append("<td>"+ list.get(i).getCntrNo() +"</td>");
				cntr_content.append("<td>"+ list.get(i).getCntrTpszCd()+" ["+list.get(i).getCntrTpszDesc()+"]" +"</td>");
				cntr_content.append("<td>"+ list.get(i).getCntrWgt() +"</td>");
				cntr_content.append("</tr>");
					codMailSendVO.setCntrList(cntr_content.toString());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return codMailSendVO;
	}
	
	/**
	 * SCE COP updateBkgForBkgCod 메서드 호출 대상 여부 및 파라미터를 조회 한다.<br>
	 * POD, DEL 국가가 바뀌었을 때 COP 호출한다.
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return CodEtcVO
	 * @throws EventException
	 */
	public CodEtcVO searchCopForBkgCodParam(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			CodEtcVO codEtcVO = dbDao.searchCopForBkgCodParam(bkgBlNoVO);
			return codEtcVO;
			
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * POD, DEL이 바뀌는 경우 auto C/A를 생성한다<br> 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @param String typeCd
	 * @throws EventException
	 */
	public void manageAutoCod(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String typeCd) throws EventException{
		try {			
			String codRqstSeq = "1";
			List<BkgComboVO> codRqstSeqs = dbDao.searchCodRqstSeq(bkgBlNoVO);			
			if(codRqstSeqs != null && codRqstSeqs.size() > 0){
				codRqstSeq = "" + (Integer.parseInt(codRqstSeqs.get(codRqstSeqs.size() - 1).getVal()) + 1);
			}
				
			// get re handling port
			String rehandlingPort = dbDao.searchRehandlingPort(bkgBlNoVO, "");
			CodRsoVO codRsoVO = dbDao.searchCodRso(bkgBlNoVO, codRqstSeq, rehandlingPort);
			String rsoCd = (codRsoVO == null ? null : codRsoVO.getRso());
			if(typeCd.equals("BK")){				
				typeCd = "AU";
			} else if(typeCd.equals("CA")){
				bkgBlNoVO.setCaFlg("Y");	
				typeCd = "AU";
			}			 

			// insert bkg_cod
			dbDao.addAutoCod(bkgBlNoVO, rsoCd, rehandlingPort, typeCd, account);
			// insert bkg_cod_vvd : old, new를 한 번에 insert
			dbDao.addCodOldNewVvd(bkgBlNoVO, codRqstSeq, typeCd,  account);
			
			List<CodCntrVO> codCntrVOs = dbDao.searchCodCntr(bkgBlNoVO, codRqstSeq, "");
			for(int i = 0; i < codCntrVOs.size(); i++){
				BkgCodCntrVO bkgCodCntrVO = new BkgCodCntrVO();
				bkgCodCntrVO.setBkgNo		(bkgBlNoVO.getBkgNo());
				bkgCodCntrVO.setCodRqstSeq	(codRqstSeq);
				bkgCodCntrVO.setCodSlctFlg 	("Y");
				bkgCodCntrVO.setCntrNo		(codCntrVOs.get(i).getCntrNo());
				bkgCodCntrVO.setCntrStwgNo	(codCntrVOs.get(i).getCntrStwgNo());
				bkgCodCntrVO.setCntrTpszCd	(codCntrVOs.get(i).getCntrTpszCd());
				bkgCodCntrVO.setCntrWgt		(codCntrVOs.get(i).getCntrWgt());
				bkgCodCntrVO.setWgtUtCd		(codCntrVOs.get(i).getWgtUtCd());
				bkgCodCntrVO.setDcgoFlg		(codCntrVOs.get(i).getDcgoFlg());
				bkgCodCntrVO.setRcFlg		(codCntrVOs.get(i).getRcFlg());
				bkgCodCntrVO.setBbCgoFlg	(codCntrVOs.get(i).getBbCgoFlg());
				bkgCodCntrVO.setAwkCgoFlg	(codCntrVOs.get(i).getAwkCgoFlg());
				bkgCodCntrVO.setSocFlg		(codCntrVOs.get(i).getSocFlg());
				 
				dbDao.addBkgCodCntr(bkgCodCntrVO, account);
			}
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
}