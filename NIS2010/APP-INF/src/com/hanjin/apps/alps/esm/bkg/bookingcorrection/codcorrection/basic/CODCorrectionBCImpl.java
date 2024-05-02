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
* --------------------------------------------------------
* History
* 2012.11.12 조정민 [CHM-201220900] [BKG] [COD Application] Approval RSO 자동지정 (Re-handling port 대륙으로 일치)
* 2012.11.14 조정민 [CHM-201220900] [CHM-201221045] COD Application시 AK, BB 제외로직에 D7 컨테이너 허용 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration.CODCorrectionDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration.CODCorrectionEAIDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrAkInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrDgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodHistoryVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodRsoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodStsInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodStsVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.PrnrCodRcvrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.PrnrCodRqstVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCodCntrVO;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.BkgCodVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
 

/**
 * ALPS-BookingCorrection Business Logic Basic Command implementation<br>
 * - ALPS-BookingCorrection에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0157EventResponse,CODCorrectionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CODCorrectionBCImpl extends BasicCommandSupport implements CODCorrectionBC {

	// Database Access Object
	private transient CODCorrectionDBDAO dbDao = null;
	private transient CODCorrectionEAIDAO dbEaiDao = null;
	/**
	 * CODCorrectionBCImpl 객체 생성<br>
	 * CODCorrectionDBDAO를 생성한다.<br>
	 */
	public CODCorrectionBCImpl() {
		dbDao = new CODCorrectionDBDAO();
		dbEaiDao = new CODCorrectionEAIDAO();
	}
	/**
	 * COD의 요청,승인,거절 등의 이력을 조회한다<br>
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
	 * 해당 bkg으로 bkg_cod의 cod_rqst_seq를 조회한다.<br>
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
	 * cod 요청 정보를 생성하기 위해 booking 정보와 요청/승인 상태도 함께 조회한다.<br>
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
			
			//cod data로 저장된 것만 가져온다.
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
			//email에 포함할 dg info 문구
			List<CodCntrDgInfoVO> dgInfoVOs = null;
			List<CodCntrAkInfoVO> akInfoVOs = null;
			for(int i=0;i<codVO.getCodCntrVO().size();i++){
				if("Y".equals(codVO.getCodCntrVO().get(i).getDcgoFlg())){
					dgInfoVOs = dbDao.searchCodCntrDgInfo(bkgBlNoVO, codRqstSeq);
				}
				if("Y".equals(codVO.getCodCntrVO().get(i).getAwkCgoFlg())){
					akInfoVOs = dbDao.searchCodCntrAkInfo(bkgBlNoVO, codRqstSeq);
					
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
			if(akInfoVOs!=null){
				for(int i=0;i<codVO.getCodCntrVO().size();i++){
					for(int j=0;j<akInfoVOs.size();j++){
						if(codVO.getCodCntrVO().get(i).getCntrNo().equals(akInfoVOs.get(j).getCntrNo())){
							if(codVO.getCodCntrVO().get(i).getAkEmlCtnt()==null || codVO.getCodCntrVO().get(i).getAkEmlCtnt().length()<1){
								codVO.getCodCntrVO().get(i).setAkEmlCtnt(akInfoVOs.get(j).getAwkInfo());
							} else {
								codVO.getCodCntrVO().get(i).setAkEmlCtnt(codVO.getCodCntrVO().get(i).getAkEmlCtnt()+"<BR>"+akInfoVOs.get(j).getAwkInfo());
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
	 * cod 요청에 대한 변경 이력을 조회한다<br>
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
	 * cod 요청 정보를 생성한다.<br>
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
	 * cod 요청 건의 변경 정보를 생성한다.<br>
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
	 * COD 요청 내역을 수정<br>
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
	 * COD 요청 내역을 삭제<br>
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
	 * OPF로 저장된 COD 정보에 대해서 승인을 요청한다.<br>
	 * 
	 * @param  CodVO codVO
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCodApproval(CodVO codVO,BkgBlNoVO bkgBlNoVO, String codRqstSeq,SignOnUserAccount account) throws EventException{
		try {
			//미사용으로 판단됨
			manageCodHistory(bkgBlNoVO,codRqstSeq,account);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * cod 요청의 상태를 변경한다.<br>
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
	 *  OPF에서 COST 저장시나 승인/거절 처리<br>
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
	 * 해당 COD 요청 건에 대해서 승인 상태로 update한다.<br>
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
	 * OPF에서 bkg_no, cod_rqst_seq에 맞는 bkg_cod에 rgn_code를 update한다.<br>
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
	 * (ESM_BKG_156) 해당 Cod Request 건의 rehandling Port를 판단한다..<br>
	 * @author    Ryu DaeYoung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     CodAuthVO codAuthVO
	 * @param     SignOnUserAccount account
	 * @param     String robFlag
	 * @return    CodVO
	 * @exception EventException
	 */
	public CodVO searchRehandlingPort(BkgBlNoVO bkgBlNoVO, CodAuthVO codAuthVO, SignOnUserAccount account, String robFlag) throws EventException{
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
			
			CodRsoVO codRsoVO = dbDao.searchCodRsoRoute(bkgBlNoVO, codRqstSeq, bkgCodVO.getCodRhndPortYdCd(), robFlag);
			if(null==codRsoVO){
				throw new EventException(new ErrorHandler("BKG00982").getMessage());
			}			
			codRsoVO.setRso(dbDao.searchCodRso(bkgBlNoVO, codRqstSeq, bkgCodVO.getCodRhndPortYdCd())); 
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
	 * opf에서 호출시 해당 request 건의 rehandling vvd를 조회한다.<br>
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
	 * 외부 cca feeder 선사의 vvd에 대한 cod 요청일 경우 해당 선사로 request mail을 보낸다.<br>
	 * 
	 * @param String codRqstSeq
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendXterCodRqst(String codRqstSeq, BkgBlNoVO bkgBlNoVO , SignOnUserAccount account )throws EventException{
		try {
			PrnrCodRqstVO prnrCodRqstVO = dbDao.searchPrnrCodRqst(bkgBlNoVO, codRqstSeq);
			
			//HJS이면 전송하지 않음
			if("HJS".equals(prnrCodRqstVO.getCarrierCd())) return;
						
			PrnrCodRcvrVO prnrCodRcvrVO = dbDao.searchPrnrCodRcvr(bkgBlNoVO, codRqstSeq, prnrCodRqstVO.getRhndVvd(), account);
			
			// receiver가 없으면 전송하지 않음
			if(prnrCodRcvrVO==null){ 
				return;
			} else if(prnrCodRcvrVO.getFromEml()==null || "".equals(prnrCodRcvrVO.getFromEml())){
				throw new EventException(new ErrorHandler("BKG02107",new String[]{}).getMessage());
			} else if(prnrCodRcvrVO.getToEml()==null||prnrCodRcvrVO.getToEml().length()<1){
				return;
			}
			
//			List<CodCntrVO>  codCntrVOs = dbDao.searchPrnrCodCntr(bkgBlNoVO, codRqstSeq);
			List<CodCntrVO>  codCntrVOs = dbDao.searchCodCntr(bkgBlNoVO, codRqstSeq, "*");

			//email에 포함할 dg info 문구

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
			dbEaiDao.sendXterCodRqst(prnrCodRqstVO, prnrCodRcvrVO, sndCodCntrVOs);
		
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (EventException ee) {
    		log.error("err " + ee.toString(), ee);
			throw ee;
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * g/w mail로 cod 요청일 경우 mail 내용의 data를 조회한다..<br>
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
	 * cod split시 dest route 정보를 조회한다..<br>
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
	 * Re-Handling Port 변경시에 RSO를 재설정<br> 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @param String rehandlingPort
	 * @return String
	 * @throws EventException
	 */
	public String searchCodRso(BkgBlNoVO bkgBlNoVO, String codRqstSeq, String rehandlingPort) throws EventException{
		BookingUtil util = new BookingUtil();
		MdmYardVO vo = new MdmYardVO();
		String rso = null;
		try {
			vo.setYdCd(rehandlingPort);
			
			if (util.searchYardCode(vo).size() == 0) 
				throw new EventException((String)new ErrorHandler("BKG01078",new String[]{rehandlingPort}).getMessage());
			rso = dbDao.searchCodRso(bkgBlNoVO, codRqstSeq, rehandlingPort);				
			
			
		} catch(EventException ex) { 
			throw ex;
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    	return rso;
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
			String rsoCd = dbDao.searchCodRso(bkgBlNoVO, codRqstSeq, rehandlingPort);
			
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
//			if (codVO.getBkgCodCostVOs() !=null){
//				for(int i=0;i<codVO.getBkgCodCostVOs().length;i++){
//					dbDao.addBkgCodCost(codVO.getBkgCodCostVOs()[i],account);
//				}
//			}
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
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
}