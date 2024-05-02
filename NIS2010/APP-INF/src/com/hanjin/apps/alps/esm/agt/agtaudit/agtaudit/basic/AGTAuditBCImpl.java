/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTAuditBCImpl.java
*@FileTitle : Agent Commission Audit Management Service Command
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.06 이호진
* 2010.10.22 박성진 [자체수정] [EAS-AGT] Audit 작업을 할 경우 중복문제 해결
* 2010.10.22 박성진 [자체수정] [EAS-AGT] Approval 시 Booking No 체크 오류 메시지 수정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration.AGTAuditDBDAO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration.AGTAuditEAIDAO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrint2VO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrintVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AGTVVDRateVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceDetailVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceMasterVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgentActualINFtoAPCheckVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgtCommBasicInformationVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgtCommListVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgtRptItmInfoMstDtlVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.BkgAgnCommDeductionRatingVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.BkgAgtChgDdctVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionDtrbVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionHdrVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.DeductionChargeVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.GrsNetCDVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.InterfaceCancelVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.basic.BRKGAuditBC;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.basic.BRKGAuditBCImpl;
import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBC;
import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBCImpl;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.AgtAgnCommDtlVO;
import com.hanjin.syscommon.common.table.AgtAgnCommVO;
import com.hanjin.syscommon.common.table.AgtCommBkgInfoVO;
import com.hanjin.syscommon.common.table.AgtRptItmInfoDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.ComAproCsrDtlVO;
import com.hanjin.syscommon.common.table.ComAproRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;


/**
 * ALPS-AGTAudit Business Logic Basic Command implementation<br>
 * - ALPS-AGTAudit에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Ho Jin
 * @see EsmAgt0016EventResponse,AGTAuditBC 각 DAO 클래스 참조 
 * @since J2EE 1.6
 */
public class AGTAuditBCImpl extends BasicCommandSupport implements AGTAuditBC {

	// Database Access Object
	private transient AGTAuditDBDAO dbDao = null;
	
	// EAI Interface Object
	private transient AGTAuditEAIDAO eaiDao = null;

	/**
	 * AGTAuditBCImpl 객체 생성<br>
	 * AGTAuditDBDAO를 생성한다.<br>
	 */
	public AGTAuditBCImpl() {
		dbDao = new AGTAuditDBDAO();
		eaiDao = new AGTAuditEAIDAO();
	}
	/**
	 * (ESM_AGT_0010) Agent Commission Maintenance & Request의 정보를 조회한다.<br>
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchAGTCommForRequest(AgtCommListVO agtCommListVO) throws EventException {
		try
		{
			if (5 < agtCommListVO.getBlNos().length())
			{
				agtCommListVO.setBlNos("'"+agtCommListVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}

			return dbDao.searchAGTCommForRequest(agtCommListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * (ESM_AGT_0010) Agent Commission Maintenance & Request의 정보를 조회한다.<br>
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @return DBRowSet
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet modifyAGTCommForRequest(AgtCommListVO[] agtCommListVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try
		{
			List<AgtAgnCommVO> bkgCreDtList =(List)dbDao.searchLocalDate(agtCommListVOs[0]);
			if (0 < bkgCreDtList.size())
			{
				if(bkgCreDtList.get(0).getBkgCreDt().equals("")){
					//[$s] does not exist!, Please check up Again!
					throw new DAOException((new ErrorHandler("AGT00027", new String[]{"LOCAL DATE"})).getMessage());
				}
			}
			else
			{
				//[$s] does not exist!, Please check up Again!
				throw new DAOException((new ErrorHandler("AGT00027", new String[]{"LOCAL DATE"})).getMessage());
			}
				
			for(int i=0; i<agtCommListVOs.length; i++)
			{
				if ( agtCommListVOs[i].getIbflag().equals("U")){
					AgtAgnCommVO updParamVO = new AgtAgnCommVO();
					AgtAgnCommVO rsltForUpdVO = new AgtAgnCommVO();
					List<AgtAgnCommVO> list = new ArrayList<AgtAgnCommVO>();
					updParamVO.setArOfcCd(agtCommListVOs[i].getArOfcCd());
					updParamVO.setAgnCd(agtCommListVOs[i].getAgnCd());
					updParamVO.setUpdUsrId(account.getUsr_id());
					updParamVO.setAcRqstUsrId(account.getUsr_id());
					updParamVO.setAcRqstUsrEml(account.getUsr_eml());
					updParamVO.setBkgNo(agtCommListVOs[i].getBkgNo());
					updParamVO.setIoBndCd(agtCommListVOs[i].getIoBndCd());
					updParamVO.setAcSeq(agtCommListVOs[i].getAcSeq());
					list = (List)dbDao.searchModifyAGTCommForRequest(updParamVO);
					if ( 0 < list.size() )
					{
						rsltForUpdVO = list.get(0);
						if(rsltForUpdVO.getDlyXchRt().equals("0") && rsltForUpdVO.getXchRtAplyLvl().equals("3")&&!rsltForUpdVO.getCurrCd().equals("USD")){
							//VVD Exchange Rate does not exist! [$s]
							throw new DAOException((new ErrorHandler("AGT00027", new String[]{rsltForUpdVO.getCommVslCd()+rsltForUpdVO.getCommSkdVoyNo()+rsltForUpdVO.getCommSkdDirCd()+"]["+rsltForUpdVO.getSvcSpcCd()+"]["+rsltForUpdVO.getIoBndCd()+"]["+rsltForUpdVO.getCommOccrInfoCd()+"]["+rsltForUpdVO.getArOfcCd()+"]["+rsltForUpdVO.getCurrCd()})).getMessage());
						}
						if(rsltForUpdVO.getVvdXchRt().equals("0") && rsltForUpdVO.getXchRtAplyLvl().equals("1")&&!rsltForUpdVO.getCurrCd().equals("USD")){
							//Daily Exchange Rate does not exist! [$s]
							throw new DAOException((new ErrorHandler("AGT00018", new String[]{rsltForUpdVO.getCommVslCd()+rsltForUpdVO.getCommSkdVoyNo()+rsltForUpdVO.getCommSkdDirCd()+"]["+rsltForUpdVO.getSvcSpcCd()+"]["+rsltForUpdVO.getIoBndCd()+"]["+rsltForUpdVO.getCommOccrInfoCd()+"]["+rsltForUpdVO.getArOfcCd()+"]["+rsltForUpdVO.getCurrCd()})).getMessage());
						}
						//BKG_CRE_DT가 NULL이거나 2007-05-07이전인 경우는 REQUEST 할 수 없다.
						if ( "".equals(rsltForUpdVO.getBkgCreDt()) || rsltForUpdVO.getBkgCreDt() == null){
							//[$s] does not exist!, Please check up Again!
							throw new DAOException((new ErrorHandler("AGT00027", new String[]{"[BKG:" + rsltForUpdVO.getBkgNo() + "]Booking creation date(" + rsltForUpdVO.getBkgCreDt() + ") does less than 2007-05-07 or "})).getMessage());
						}
						//BKG_CRE_DT가 NULL이거나 2007-05-07이전인 경우는 REQUEST 할 수 없다.
						if( Integer.parseInt(rsltForUpdVO.getBkgCreDt()) < 20070507){
							//[$s] does not exist!, Please check up Again!
							throw new DAOException((new ErrorHandler("AGT00027", new String[]{"[BKG:" + rsltForUpdVO.getBkgNo() + "]Booking creation date(" + rsltForUpdVO.getBkgCreDt() + ") does less than 2007-05-07 or "})).getMessage());
						}
						dbDao.modifyAGTCommForRequestDtl(rsltForUpdVO);
						dbDao.modifyAGTCommForRequest(rsltForUpdVO);
					}
				}
			}
			// 범한EDI I/F 전송용 SELECT
			return null;
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	/**
	 * ex.Rate/Local Amount 재계산 이벤트 처리<br>
	 * ESM_AGT_010 화면에 대한 ex.Rate/Local Amount 재계산 이벤트 처리<br>
	 * 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void modifyAGTCommExRateByRequest(AgtCommListVO[] agtCommListVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		List<AgtAgnCommVO> list = null;
		try
		{
			for(int i=0; i<agtCommListVOs.length; i++)
			{
				if ( agtCommListVOs[i].getIbflag().equals("U")){
					AgtAgnCommVO updParamVO = new AgtAgnCommVO();
					AgtAgnCommVO agtCommListVO = new AgtAgnCommVO();
					updParamVO.setArOfcCd(agtCommListVOs[i].getArOfcCd());
					updParamVO.setAgnCd(agtCommListVOs[i].getAgnCd());
					updParamVO.setUpdUsrId(account.getUsr_id());
					updParamVO.setAcRqstUsrId(account.getUsr_id());
					updParamVO.setAcRqstUsrEml(account.getUsr_eml());
					updParamVO.setBkgNo(agtCommListVOs[i].getBkgNo());
					updParamVO.setIoBndCd(agtCommListVOs[i].getIoBndCd());
					updParamVO.setAcSeq(agtCommListVOs[i].getAcSeq());

					list = (List)dbDao.searchModifyAGTCommExRateByRequest(updParamVO);
					if ( 0 < list.size() )
					{
						agtCommListVO = list.get(0);
						dbDao.modifyAGTCommExRateByRequest(agtCommListVO);
						dbDao.modifyAGTCommExRateByRequestDtl(agtCommListVO);
						
					}
				}
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	
	/**
	 * ESM_AGT_0010 화면에서 Agreement Commission recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @exception EventException
	 */
	public void createAGTCommByRequest(AgtCommListVO[] agtCommListVOs) throws EventException {

		// Commission 계산을 위한 객체 
		AGTCalcBC agtCalcBC = new AGTCalcBCImpl();

		try
		{
			for(int i=0; i<agtCommListVOs.length; i++)
			{
				if ( agtCommListVOs[i].getIbflag().equals("U")){
					agtCalcBC.createAGTComm(agtCommListVOs[i].getBkgNo());
				}
			}
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}


	/**
	 * ESM_AGT_0011 화면 대한 Calculation History 정보<br>
	 * 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @exception EventException
	 */
	@Override
    public List<AgtAgnCommVO> searchAGTCommCalculationHistory(AgtAgnCommVO agtAgnCommVO) throws EventException {
		try{
			return dbDao.searchAGTCommCalculationHistory(agtAgnCommVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
    }
	/**
	 * ESM_AGT_0011 화면 대한 Commission Detail Amount 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @exception EventException
	 */
	@Override
    public List<AgtAgnCommVO> searchAGTCommCommissionDetailAmount(AgtAgnCommVO agtAgnCommVO) throws EventException {
		try{
			return dbDao.searchAGTCommCommissionDetailAmount(agtAgnCommVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0011 화면 대한 Basic Information 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtCommBasicInformationVO>
	 * @exception EventException
	 */
	@Override
    public List<AgtCommBasicInformationVO> searchAGTCommBasicInformation(AgtAgnCommVO agtAgnCommVO) throws EventException {
		try{
			return dbDao.searchAGTCommBasicInformation(agtAgnCommVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0011 화면 대한 TP/SZ QTY 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgQuantityVO>
	 * @exception EventException
	 */
	@Override
    public List<BkgQuantityVO> searchAGTCommDetailTypeSizeQty(AgtAgnCommVO agtAgnCommVO) throws EventException {
		try{
			return dbDao.searchAGTCommDetailTypeSizeQty(agtAgnCommVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0012 화면 대한 Rating 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @exception EventException
	 */
	@Override
    public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionRating(AgtAgnCommVO agtAgnCommVO) throws EventException {
	    try{
	    	return dbDao.searchAGTCommDeductionRating(agtAgnCommVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0012 화면 대한 Total 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @exception EventException
	 */
	@Override
    public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionTotal(AgtAgnCommVO agtAgnCommVO) throws EventException {
	    try{
	    	return dbDao.searchAGTCommDeductionTotal(agtAgnCommVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0012 화면 대한 Total info 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @exception EventException
	 */
	@Override
    public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionTotalInfo(AgtAgnCommVO agtAgnCommVO) throws EventException{
	    try{
	    	return dbDao.searchAGTCommDeductionTotalInfo(agtAgnCommVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0012 화면 대한 Deducted Charge 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgtChgDdctVO>
	 * @exception EventException
	 */
	@Override
    public List<BkgAgtChgDdctVO> searchAGTCommDeductionCharge(AgtAgnCommVO agtAgnCommVO) throws EventException {
		try{
	    	return dbDao.searchAGTCommDeductionCharge(agtAgnCommVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0012 화면 대한 Deducted Transportation Cost 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<DeductionChargeVO>
	 * @exception EventException
	 */
	@Override
    public List<DeductionChargeVO> searchAGTCommDeductionTrspCost(AgtAgnCommVO agtAgnCommVO) throws EventException {
		try{
	    	return dbDao.searchAGTCommDeductionTrspCost(agtAgnCommVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0012 화면 대한 Gross / Net, Net Ocean Revenue 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<GrsNetCDVO>
	 * @exception EventException
	 */
	@Override
    public List<GrsNetCDVO> searchAGTCommGrsNetCD(AgtAgnCommVO agtAgnCommVO) throws EventException {
		try{
	    	return dbDao.searchAGTCommGrsNetCD(agtAgnCommVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * (ESM_AGT_0016) Other Commission Approval의 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @exception EventException
	 */
	public List<AgtAgnCommVO> searchOtherCommforApproval(AgtAgnCommVO agtAgnCommVO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchOtherCommforApproval(agtAgnCommVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * (ESM_AGT_0016) Other Commission Approval의 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void multiOtherCommforApproval(AgtAgnCommVO[] agtAgnCommVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub

		List<AgtAgnCommVO> updateVoList = new ArrayList<AgtAgnCommVO>();

		try{ 
			
			for(int i=0; i<agtAgnCommVOs.length; i++){
				log.info("\n   <<<<idflag>>>>>>>"+agtAgnCommVOs[i].getIbflag());
									
				if ( agtAgnCommVOs[i].getIbflag().equals("U")){
					String comm_proc_sts_cd = "RM";
					String comm_proc_sts_rsn = "OTHER COMMISSION MODIFY!";
					String comm_stnd_cost_cd = agtAgnCommVOs[i].getCommStndCostCd();
					String otr_comm_acct_ctnt = agtAgnCommVOs[i].getOtrCommAcctCtnt();
					String vvd = agtAgnCommVOs[i].getVvd();
					String act_comm_amt = agtAgnCommVOs[i].getActCommAmt();
					String act_if_comm_amt = agtAgnCommVOs[i].getActCommAmt();
					String act_locl_comm_amt = agtAgnCommVOs[i].getActLoclCommAmt();
					String act_if_locl_comm_amt = agtAgnCommVOs[i].getActLoclCommAmt();
					String curr_cd = agtAgnCommVOs[i].getCurrCd();
					String mon_xch_rt = agtAgnCommVOs[i].getMonXchRt();
					String aply_dt = agtAgnCommVOs[i].getAplyDt();
					String upd_usr_id = account.getUsr_id();
					String bkg_no = agtAgnCommVOs[i].getBkgNo();
					String agn_cd = agtAgnCommVOs[i].getAgnCd();
					String io_bnd_cd = agtAgnCommVOs[i].getIoBndCd();
					String ac_tp_cd = agtAgnCommVOs[i].getAcTpCd();
					String ac_seq = agtAgnCommVOs[i].getAcSeq();
					String comm_yrmon = agtAgnCommVOs[i].getCommYrmon();				
					
					agtAgnCommVOs[i].setCommProcStsCd(comm_proc_sts_cd);
					agtAgnCommVOs[i].setCommProcStsRsn(comm_proc_sts_rsn);
					agtAgnCommVOs[i].setCommStndCostCd(comm_stnd_cost_cd);
					agtAgnCommVOs[i].setOtrCommAcctCtnt(otr_comm_acct_ctnt);
					agtAgnCommVOs[i].setCommVslCd(vvd);
					agtAgnCommVOs[i].setCommSkdVoyNo(vvd);
					agtAgnCommVOs[i].setCommSkdDirCd(vvd);
					agtAgnCommVOs[i].setCommRevDirCd(vvd);
					agtAgnCommVOs[i].setActCommAmt(act_comm_amt);
					agtAgnCommVOs[i].setActIfCommAmt(act_if_comm_amt);
					agtAgnCommVOs[i].setActLoclCommAmt(act_locl_comm_amt);
					agtAgnCommVOs[i].setActIfLoclCommAmt(act_if_locl_comm_amt);
					agtAgnCommVOs[i].setCurrCd(curr_cd);
					agtAgnCommVOs[i].setMonXchRt(mon_xch_rt);
					agtAgnCommVOs[i].setAplyDt(aply_dt);								
					agtAgnCommVOs[i].setUpdUsrId(upd_usr_id);
					agtAgnCommVOs[i].setBkgNo(bkg_no);
					agtAgnCommVOs[i].setAgnCd(agn_cd);
					agtAgnCommVOs[i].setIoBndCd(io_bnd_cd);
					agtAgnCommVOs[i].setAcTpCd(ac_tp_cd);
					agtAgnCommVOs[i].setAcSeq(ac_seq);
					agtAgnCommVOs[i].setCommYrmon(comm_yrmon);				
					
					updateVoList.add(agtAgnCommVOs[i]);
				}
			}
			log.info("<<<<<<size " + updateVoList.size());

			if(updateVoList.size() > 0){
				dbDao.modifymultiOtherCommforApproval(updateVoList);
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	/**
	 * (ESM_AGT_0016) Other Commission Approval의 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param AgtAgnCommDtlVO[] agtAgnCommDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void multiOtherCommforApprovalDtl(AgtAgnCommVO[] agtAgnCommVOs, AgtAgnCommDtlVO[] agtAgnCommDtlVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		
		List<AgtAgnCommDtlVO> updateVoList = new ArrayList<AgtAgnCommDtlVO>();

		try{
			for(int i=0; i<agtAgnCommVOs.length; i++){
				if ( agtAgnCommVOs[i].getIbflag().equals("U")){
					
					String act_comm_amt = agtAgnCommVOs[i].getActCommAmt();
					String act_locl_comm_amt = agtAgnCommVOs[i].getActLoclCommAmt();
					String bkg_no = agtAgnCommVOs[i].getBkgNo();
					String agn_cd = agtAgnCommVOs[i].getAgnCd();
					String io_bnd_cd = "O";
					String ac_tp_cd = "T";
					String cntr_tpsz_cd = "BX";
					String ac_seq = agtAgnCommVOs[i].getAcSeq();
					
//					log.info("\n  <<act_comm_amt02   =="+act_comm_amt);
					
					agtAgnCommDtlVOs[i].setActUsdCommAmt(act_comm_amt);
					agtAgnCommDtlVOs[i].setActLoclCommAmt(act_locl_comm_amt);
					agtAgnCommDtlVOs[i].setBkgNo(bkg_no);
					agtAgnCommDtlVOs[i].setAgnCd(agn_cd);
					agtAgnCommDtlVOs[i].setIoBndCd(io_bnd_cd);
					agtAgnCommDtlVOs[i].setAcTpCd(ac_tp_cd);
					agtAgnCommDtlVOs[i].setAcSeq(ac_seq);
					agtAgnCommDtlVOs[i].setCntrTpszCd(cntr_tpsz_cd);				
					
					updateVoList.add(agtAgnCommDtlVOs[i]);
				}
			}
			log.info("<<<<<<size " + updateVoList.size());
		
			if(updateVoList.size() > 0){
				dbDao.multiOtherCommforApprovalDtl(updateVoList);
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	/**
	 * (ESM_AGT_0016) Other Commission Approval의 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void multiOtherCommforApprovalReject(AgtAgnCommVO[] agtAgnCommVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub

		List<AgtAgnCommVO> updateVoList = new ArrayList<AgtAgnCommVO>();
		
		try{
			for(int i=0; i<agtAgnCommVOs.length; i++){
				if ( agtAgnCommVOs[i].getIbflag().equals("U")){
					String comm_proc_sts_cd = "CA";
					String comm_proc_sts_rsn = "Request Reject!";
					String comm_stnd_cost_cd = agtAgnCommVOs[i].getCommStndCostCd();
					String otr_comm_acct_ctnt = agtAgnCommVOs[i].getOtrCommAcctCtnt();
					String vvd = agtAgnCommVOs[i].getVvd();
					String act_comm_amt = agtAgnCommVOs[i].getActCommAmt();
					String act_if_comm_amt = agtAgnCommVOs[i].getActCommAmt();
					String act_locl_comm_amt = agtAgnCommVOs[i].getActLoclCommAmt();
					String act_if_locl_comm_amt = agtAgnCommVOs[i].getActLoclCommAmt();
					String curr_cd = agtAgnCommVOs[i].getCurrCd();
					String mon_xch_rt = agtAgnCommVOs[i].getMonXchRt();
					String aply_dt = agtAgnCommVOs[i].getAplyDt();
					String upd_usr_id = account.getUsr_id();
					String bkg_no = agtAgnCommVOs[i].getBkgNo();
					String agn_cd = agtAgnCommVOs[i].getAgnCd();
					String io_bnd_cd = agtAgnCommVOs[i].getIoBndCd();
					String ac_tp_cd = agtAgnCommVOs[i].getAcTpCd();
					String ac_seq = agtAgnCommVOs[i].getAcSeq();
					String comm_yrmon = agtAgnCommVOs[i].getCommYrmon();

					agtAgnCommVOs[i].setCommProcStsCd(comm_proc_sts_cd);
					agtAgnCommVOs[i].setCommProcStsRsn(comm_proc_sts_rsn);
					agtAgnCommVOs[i].setCommStndCostCd(comm_stnd_cost_cd);
					agtAgnCommVOs[i].setOtrCommAcctCtnt(otr_comm_acct_ctnt);
					agtAgnCommVOs[i].setCommVslCd(vvd);
					agtAgnCommVOs[i].setCommSkdVoyNo(vvd);
					agtAgnCommVOs[i].setCommSkdDirCd(vvd);
					agtAgnCommVOs[i].setCommRevDirCd(vvd);
					agtAgnCommVOs[i].setActCommAmt(act_comm_amt);
					agtAgnCommVOs[i].setActIfCommAmt(act_if_comm_amt);
					agtAgnCommVOs[i].setActLoclCommAmt(act_locl_comm_amt);
					agtAgnCommVOs[i].setActIfLoclCommAmt(act_if_locl_comm_amt);
					agtAgnCommVOs[i].setCurrCd(curr_cd);
					agtAgnCommVOs[i].setMonXchRt(mon_xch_rt);
					agtAgnCommVOs[i].setAplyDt(aply_dt);								
					agtAgnCommVOs[i].setUpdUsrId(upd_usr_id);
					agtAgnCommVOs[i].setBkgNo(bkg_no);
					agtAgnCommVOs[i].setAgnCd(agn_cd);
					agtAgnCommVOs[i].setIoBndCd(io_bnd_cd);
					agtAgnCommVOs[i].setAcTpCd(ac_tp_cd);
					agtAgnCommVOs[i].setAcSeq(ac_seq);
					agtAgnCommVOs[i].setCommYrmon(comm_yrmon);				
					
					updateVoList.add(agtAgnCommVOs[i]);
				}
			}
			log.info("<<<<<<size " + updateVoList.size());
			if(updateVoList.size() > 0){
				dbDao.modifymultiOtherCommforApprovalReject(updateVoList);
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * (ESM_AGT_0016) Other Commission Approval의 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiOtherCommforApprovalCancel(AgtAgnCommVO[] agtAgnCommVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		List<AgtAgnCommVO> updateVoList = new ArrayList<AgtAgnCommVO>();

		try{
			for(int i=0; i<agtAgnCommVOs.length; i++){
				if ( agtAgnCommVOs[i].getIbflag().equals("U")){
					String comm_proc_sts_cd = "RM";
					String comm_proc_sts_rsn = "Approval Cancel!";
					String comm_stnd_cost_cd = agtAgnCommVOs[i].getCommStndCostCd();
					String otr_comm_acct_ctnt = agtAgnCommVOs[i].getOtrCommAcctCtnt();
					String vvd = agtAgnCommVOs[i].getVvd();
					String act_comm_amt = agtAgnCommVOs[i].getActCommAmt();
					String act_if_comm_amt = agtAgnCommVOs[i].getActCommAmt();
					String act_locl_comm_amt = agtAgnCommVOs[i].getActLoclCommAmt();
					String act_if_locl_comm_amt = agtAgnCommVOs[i].getActLoclCommAmt();
					String curr_cd = agtAgnCommVOs[i].getCurrCd();
					String mon_xch_rt = agtAgnCommVOs[i].getMonXchRt();
					String aply_dt = agtAgnCommVOs[i].getAplyDt();
					String upd_usr_id = account.getUsr_id();
					String bkg_no = agtAgnCommVOs[i].getBkgNo();
					String agn_cd = agtAgnCommVOs[i].getAgnCd();
					String io_bnd_cd = agtAgnCommVOs[i].getIoBndCd();
					String ac_tp_cd = agtAgnCommVOs[i].getAcTpCd();
					String ac_seq = agtAgnCommVOs[i].getAcSeq();
					String comm_yrmon = agtAgnCommVOs[i].getCommYrmon();

					agtAgnCommVOs[i].setCommProcStsCd(comm_proc_sts_cd);
					agtAgnCommVOs[i].setCommProcStsRsn(comm_proc_sts_rsn);
					agtAgnCommVOs[i].setCommStndCostCd(comm_stnd_cost_cd);
					agtAgnCommVOs[i].setOtrCommAcctCtnt(otr_comm_acct_ctnt);
					agtAgnCommVOs[i].setCommVslCd(vvd);
					agtAgnCommVOs[i].setCommSkdVoyNo(vvd);
					agtAgnCommVOs[i].setCommSkdDirCd(vvd);
					agtAgnCommVOs[i].setCommRevDirCd(vvd);
					agtAgnCommVOs[i].setActCommAmt(act_comm_amt);
					agtAgnCommVOs[i].setActIfCommAmt(act_if_comm_amt);
					agtAgnCommVOs[i].setActLoclCommAmt(act_locl_comm_amt);
					agtAgnCommVOs[i].setActIfLoclCommAmt(act_if_locl_comm_amt);
					agtAgnCommVOs[i].setCurrCd(curr_cd);
					agtAgnCommVOs[i].setMonXchRt(mon_xch_rt);
					agtAgnCommVOs[i].setAplyDt(aply_dt);								
					agtAgnCommVOs[i].setUpdUsrId(upd_usr_id);
					agtAgnCommVOs[i].setBkgNo(bkg_no);
					agtAgnCommVOs[i].setAgnCd(agn_cd);
					agtAgnCommVOs[i].setIoBndCd(io_bnd_cd);
					agtAgnCommVOs[i].setAcTpCd(ac_tp_cd);
					agtAgnCommVOs[i].setAcSeq(ac_seq);
					agtAgnCommVOs[i].setCommYrmon(comm_yrmon);				
					
					updateVoList.add(agtAgnCommVOs[i]);
				}
			}
			log.info("<<<<<<size " + updateVoList.size());
			
			if(updateVoList.size() > 0){
				dbDao.modifymultiOtherCommforApprovalCancel(updateVoList);
			}

		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * (ESM_AGT_0017) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @return List<APActualInterfaceMasterVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceMasterVO> searchAPActualInterfaceMaster(APActualInterfaceMasterVO apActualInterfaceMasterVO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchAPActualInterfaceMaster(apActualInterfaceMasterVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}


	/**
	 * (ESM_AGT_0017) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceDetailVO apActualInterfaceDetailVO
	 * @return List<APActualInterfaceDetailVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceDetailVO> searchAPActualInterfaceDetail(APActualInterfaceDetailVO apActualInterfaceDetailVO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchAPActualInterfaceDetail(apActualInterfaceDetailVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * (ESM_AGT_0017) Agent Commission AP Interface 대상리스트를 Interface한다.<br>
	 * 
	 * @param APActualInterfaceMasterVO[] apActualInterfaceMasterVOs
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAgentActualINFtoAP(APActualInterfaceMasterVO[] apActualInterfaceMasterVOs, APActualInterfaceMasterVO apActualInterfaceMasterVO, SignOnUserAccount account) throws EventException {
			// TODO Auto-generated method stub
			AgentActualINFtoAPCheckVO agentActualINFtoAPCheckVO = new AgentActualINFtoAPCheckVO();
			AgentActualINFtoAPCheckVO aPCheckVO = new AgentActualINFtoAPCheckVO();
			AgentActualINFtoAPCheckVO aPApproVO = new AgentActualINFtoAPCheckVO();
			String comAprNos = "";
			boolean bkgStsACd = true;
			boolean bkgStsXCd = true;
			try
			{
				log.debug("\n apActualInterfaceMasterVOs.length="+apActualInterfaceMasterVOs.length);
				for(int i=0; i<apActualInterfaceMasterVOs.length; i++)
				{
					apActualInterfaceMasterVOs[i].setExpType(apActualInterfaceMasterVO.getExpType());
					apActualInterfaceMasterVOs[i].setIfOption(apActualInterfaceMasterVO.getIfOption());
					
					//CHM-201113085 - Error message 변경 요청(AGT00092추가)
					//There is(are) canceled booking(s)  in Audit No ['$s']. Please exclude canceled booking(s).
					bkgStsXCd = dbDao.selectBKGStatusXCd(apActualInterfaceMasterVOs[i]);
					if(bkgStsXCd==false){
						throw new DAOException((new ErrorHandler("AGT00092", new String[]{apActualInterfaceMasterVOs[i].getCommAproNo()})).getMessage());
					}
					
					bkgStsACd = dbDao.selectBKGStatus(apActualInterfaceMasterVOs[i]);
					if(bkgStsACd==false){
						throw new DAOException((new ErrorHandler("AGT00090", new String[]{"A","A"})).getMessage());
					}
										if ( 0 != i ){comAprNos= comAprNos + ",";}
					comAprNos = comAprNos + "'" + apActualInterfaceMasterVOs[i].getCommAproNo() + "'";
				}
				log.debug("\n comAprNos = "+comAprNos);
				log.debug("\n apActualInterfaceMasterVO.toString() = "+apActualInterfaceMasterVO.toString());
				agentActualINFtoAPCheckVO.setAsaNo(apActualInterfaceMasterVO.getAsaNo());
				agentActualINFtoAPCheckVO.setInvDt(apActualInterfaceMasterVO.getInvDt());
				agentActualINFtoAPCheckVO.setArOfcCd(apActualInterfaceMasterVO.getArOfcCd());
				agentActualINFtoAPCheckVO.setAgnCd(apActualInterfaceMasterVO.getAgnCd());
				agentActualINFtoAPCheckVO.setInvTaxRt(apActualInterfaceMasterVO.getInvTaxRt());
				agentActualINFtoAPCheckVO.setUpdUsrId(account.getUsr_id());
				agentActualINFtoAPCheckVO.setCreUsrId(account.getUsr_id());
				agentActualINFtoAPCheckVO.setCreUsrNm(account.getUsr_nm());
				agentActualINFtoAPCheckVO.setCreUsrEml(account.getUsr_eml());
				agentActualINFtoAPCheckVO.setComAprNos(comAprNos);
				dbDao.modifyAGTCommBkgInfoRevVVD(agentActualINFtoAPCheckVO);
				aPCheckVO = dbDao.selectAgentActualINFtoAP(agentActualINFtoAPCheckVO);
				aPCheckVO.setCreUsrNm(account.getUsr_nm());
	            aPCheckVO.setCreUsrEml(account.getUsr_eml());
	            aPCheckVO.setSRevChg(apActualInterfaceMasterVO.getSRevChg());
				log.info("\n aPCheckVO 1 ="+aPCheckVO);
	            ////0.CHECK ASA CURR_CD vs INVOICE CURR_CD, EFF_DT vs ASA_FROM_TO_DT 
	        	if(apActualInterfaceMasterVO.getAsaNo().length() > 1){
		        	
		        	//ASA_CURR_CD vs INVOICE_CURR_CD Check
					for(int i=0; i<apActualInterfaceMasterVOs.length; i++)
					{

		        		if(!apActualInterfaceMasterVOs[i].getCurrCd().equals(aPCheckVO.getAsaCurrCd())){
			            	//ASA Currency Code vs Invoice Currency Code does not match! Please check up ASA Info!
			            	throw new DAOException((new ErrorHandler("AGT00074")).getMessage());
			            }
		        	}
		        	
		        	//EFF_DT vs ASA_FROM_TO_DT Check
		        	if(aPCheckVO.getAsaCnt() =="0"){
		            	//ASA From~To Date vs Effective Date does not match! Please check up ASA Info!
		            	throw new DAOException((new ErrorHandler("AGT00075")).getMessage());
		        	}
		        		        	
		        	//인터페이스시 ASA NO 변경(OFC + YMM + SEQU ==> OFC + SEQU + YMM)
		            //asaNo  = asaNo.substring(0,3) + asaNo.substring(6) + asaNo.substring(3,6);
		        	aPCheckVO.setAsaNo(aPCheckVO.getAsaNo().substring(0,3) + aPCheckVO.getAsaNo().substring(6) + aPCheckVO.getAsaNo().substring(3,6));
	            }
	        	if(aPCheckVO.getLocalDt() == "" || aPCheckVO.getLocalDt().length() < 6){
	            	//[$s] does not exist!, Please check up Again!
	            	throw new DAOException((new ErrorHandler("AGT00027", new String[]{"LOCAL DATE"})).getMessage());
	            }
				if(aPCheckVO.getErrBkgCreDt() != null && aPCheckVO.getErrBkgCreDt() != ""){
					//[$s] does not exist!, Please check up Again!
                	throw new DAOException((new ErrorHandler("AGT00027", new String[]{"[" + aPCheckVO.getErrBkgNo() + "]Booking creation date is earlier than 2007-05-07 or "})).getMessage());
				}
			    //CHECK
			    if(aPCheckVO.getFincRgnCd() == null || aPCheckVO.getFincRgnCd() == ""){
			    	//[Region Code] does not exist!, Please check up Again!
			    	throw new DAOException((new ErrorHandler("AGT00027", new String[]{"Region Code"})).getMessage());
			    }

			    //CHECK
			    if(aPCheckVO.getCoaIntrCmpyCd() == null && aPCheckVO.getCoaIntrCmpyCd() == ""){
			    	//[Center Code] does not exist!, Please check up Again!
			    	throw new DAOException((new ErrorHandler("AGT00027", new String[]{"Center Code"})).getMessage());
			    }
			    
//			    if(vvdCd == null || vvdCd == "") {
//			    	this.processProcedure(bkgNo, bkgNoSplit);
//			    }	
			    
			    
	            if(aPCheckVO.getErrVvdBkgNo() != null && aPCheckVO.getErrVvdBkgNo() != "") {
					//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
//2011.07.07 이정수 R4J         	if(aPCheckVO.getErrVvd().equals(null) || aPCheckVO.getErrVvd().equals("")){
	            	if(aPCheckVO.getErrVvd() == null || "".equals(aPCheckVO.getErrVvd())){	
	            		aPCheckVO.setErrVvd("does not exist!");
	            	}
					throw new DAOException((new ErrorHandler("AGT00030", new String[]{ aPCheckVO.getErrVvd() + ", BKG_NO : "+aPCheckVO.getErrVvdBkgNo()})).getMessage());
	            }
	            log.info("\n aPCheckVO 2 ="+aPCheckVO);
	            log.info("\n aPCheckVO.getVndrSeq()="+aPCheckVO.getVndrSeq());
	            log.info("\n aPCheckVO.getf()=="+aPCheckVO.getCoaIntrCmpyCd());
	            log.info("\n aPCheckVO.getFincRgnCd()=="+aPCheckVO.getFincRgnCd());
	            log.info("\n aPCheckVO.getApCtrCd()=="+aPCheckVO.getApCtrCd());
	            log.info("\n aPCheckVO.getArHdQtrOfcCd()=="+aPCheckVO.getArHdQtrOfcCd());
	            log.info("\n aPCheckVO.getAsaCnt()=="+aPCheckVO.getAsaCnt());
	            log.info("\n aPCheckVO.getAsaNo()=="+aPCheckVO.getAsaNo());
	            
	            aPCheckVO.setComAprNos(comAprNos);
				dbDao.createAGTCSRHeaderAddApCsrNo(aPCheckVO);
				dbDao.createAGTCSRHeaderAgtAgnComm(aPCheckVO);
				dbDao.createAGTCSRHeaderAgtAgnCommDtl(aPCheckVO);
				dbDao.createAGTCSRHeaderApInvHdr(aPCheckVO);
				dbDao.createAGTCSRHeaderApInvDtrb(aPCheckVO);
				dbDao.createAGTCSRHeaderApInvDtrbUpdate(aPCheckVO);
//				dbDao.createAGTCSRHeaderApInvIf(aPCheckVO);
				
				aPApproVO = dbDao.createAGTCSRHeaderApInvHdrSelect(aPCheckVO);
//
//	            ////결재선 등록
//	            // COM_APRO_RQST_HDR
				ComAproRqstHdrVO header = new ComAproRqstHdrVO();
				ApprovalUtil approval =  new ApprovalUtil();
				header.setSubSysCd("AGT");
				header.setAproKndCd("CSR");		
				header.setRqstOfcCd(account.getOfc_cd());
				header.setRqstOfcNm(account.getOfc_eng_nm());
				header.setRqstUsrJbTitNm("");
				header.setRqstUsrId(account.getUsr_id());
				header.setRqstUsrNm(account.getUsr_nm());
				header.setCreUsrId(aPApproVO.getCreUsrId());
				
				// COM_APRO_RQST_ROUT
				//String apro_step = ApprovalUtil.getApprovalRoute("SELHO", "AGT");
				ComAproRqstRoutVO[] route = approval.convertApprovalRoute(apActualInterfaceMasterVO.getAproStep());
				
				//String apoNm = route[route.length-1].toString();
				
				// COM_APRO_CSR_DTL
				ComAproCsrDtlVO csr = new ComAproCsrDtlVO();
				csr.setCsrNo(aPApproVO.getCsrNo());
				csr.setCostOfcCd(aPApproVO.getTjOfcCd());
				csr.setInvKnt(aPApproVO.getDtrbCnt());
				csr.setVndrSeq(aPApproVO.getVndrNo());
				csr.setPayDueDt(aPApproVO.getInvTermDt());
				csr.setCurrCd(aPApproVO.getCsrCurrCd());
				csr.setAproTtlAmt(aPApproVO.getCsrAmt());
				csr.setCreUsrId(aPApproVO.getCreUsrId());
				log.info("\n csr="+csr);
				// 결재 등록
				approval.saveCsrApro(header, route, csr);
				dbDao.createAGTCSRHeaderAgtAgnComm2(aPCheckVO);
				dbDao.createAGTCSRHeaderApInvHdrUpdate(aPCheckVO);

				
				
			}catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);
			} catch (Exception ex) {
				//log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);
			}
			
		}

	/**
	 * (ESM_AGT_0017) Agent Commission AP Interface 대상리스트를 Interface한다.<br>
	 * 
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCancelAgentActualINFtoAP(APActualInterfaceMasterVO apActualInterfaceMasterVO,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub

		String errMsg = null;
		try
		{
			if (dbDao.searchApInvHdrIfFlg(apActualInterfaceMasterVO)){
            	//[$s]CSR No does not cancel! Because interface status is success!
				errMsg = apActualInterfaceMasterVO.getCsrNo();
				log.info("\n errMsg="+errMsg);
		    	throw new DAOException((new ErrorHandler("AGT00067", new String[]{apActualInterfaceMasterVO.getCsrNo()})).getMessage());
			}
			List<InterfaceCancelVO> interfaceCancelVOs = dbDao.searchCancelAgentActualINFList(apActualInterfaceMasterVO);
			for(int j=0; j<interfaceCancelVOs.size(); j++)
			{
				if (dbDao.searchCancelAgentActualINFAfterINF(interfaceCancelVOs.get(j)))
				{
					InterfaceCancelVO beforeActualINF = dbDao.searchBeforeActualINF(interfaceCancelVOs.get(j));
					beforeActualINF.setUpdUsrId(account.getUsr_id());
					
					InterfaceCancelVO beforeCanceledAcSeq = dbDao.searchBeforeCanceledAcSeq(interfaceCancelVOs.get(j));
					
					if ( null != beforeCanceledAcSeq )
					{
						dbDao.removeBeforeCanceledAcSeqDtl(beforeCanceledAcSeq);
						dbDao.removeBeforeCanceledAcSeq(beforeCanceledAcSeq);
						
					}
					dbDao.createBeforeActualINF(beforeActualINF);
					dbDao.modifyInterfaceCanceledFirst(interfaceCancelVOs.get(j));
					dbDao.modifyInterfaceCanceledDtl(interfaceCancelVOs.get(j));
					dbDao.modifyInterfaceCanceledMst(interfaceCancelVOs.get(j));
				}
				else
				{
					
					//dbDao.modifyInterfaceCanceledMst(interfaceCancelVOs.get(j));
					dbDao.modifyInterfaceCanceled(interfaceCancelVOs.get(j),account.getUsr_id());
					
					dbDao.removeBeforeCanceledDtl(interfaceCancelVOs.get(j));
					dbDao.removeBeforeCanceled(interfaceCancelVOs.get(j));
					
					//dbDao.modifyInterfaceCanceled(interfaceCancelVOs.get(j));
					//dbDao.modifyInterfaceCanceledDtl(interfaceCancelVOs.get(j));
					
				}
			}
		}catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			log.info("\n errMsg="+errMsg);
			throw new EventException(ex.getMessage(),ex);
			//throw new EventException((new ErrorHandler("AGT00067", new String[]{errMsg})).getMessage());
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	
	/**
     * ESM_AGT_017 화면에 대한 AP Interface 이벤트 처리(1) : EP결재 수신 + CSR I/F<br>
     * 
     * @param String result
     * @param String csrNo
     * @param ComAproRqstRoutVO model
     * @return FNS0080003Document[] 
     * @throws EventException
     */
	public FNS0080003Document[] transferAgentActualINFtoAP1(String result, String csrNo, ComAproRqstRoutVO model) throws EventException{
    	DBRowSet rowSet = null;		//데이터 전송을 위해 DB ResultSet을 구현한 객체		
		
		String aproNm = "";
		String module = "";
		AgentActualINFtoAPCheckVO aPApproVO = new AgentActualINFtoAPCheckVO();
		
		// 2007.06.04 추가
		FNS0080003Document[] docReq		= null;
		
		try {
			
			aproNm = model.getAproUsrId();	//최종결재자명
			if(aproNm == null) aproNm = " ";	//최종결재자명 공백처리
			if(result == null) result = "C";		//flag값이 NULL인 경우, 승인한것으로 간주한다.
			
			
			////업무구분(AGT/BRKG/FAC)을 위한 CSR정보 조회
			aPApproVO.setCsrNo(csrNo);
			
			aPApproVO = dbDao.searchAGTCSRInfo(aPApproVO);	
			module = aPApproVO.getSrcCtnt();
			log.info("\n ....... aPApproVO >>>>> [" + aPApproVO.toString()+ "]");
			
			log.error(".......");
			log.error("....... flag   >>>>> [" + result + "]");
			log.error("....... csrNo  >>>>> [" + csrNo  + "]");
			log.error("....... Name   >>>>> [" + aproNm + "]");
			log.error("....... module >>>>> [" + module + "]");
			log.error(".......");
			
			log.info(".......");
			log.info("....... flag   >>>>> [" + result + "]");
			log.info("....... csrNo  >>>>> [" + csrNo  + "]");
			log.info("....... Name   >>>>> [" + aproNm + "]");
			log.info("\n ....... module >>>>> [" + module + "]");
			log.info(".......");
			
			
			////업무구분별 분기처리
			
			if(module.equals("COMMISSION")){
				
				if(result.equals("R")){	
					//반려시
					dbDao.modifyAGTApprovalRequesttoEP(aPApproVO);					
				}else{						
					////5.AP 인터페이스 실행하기
					log.info("\n transferAgentActualINFtoAP1 Start");
					rowSet = dbDao.searchAgentActualINFtoAP(aPApproVO);
					log.info("\n rowSet="+rowSet.toString());
//					log.info("\n csrNo="+csrNo+",/n rowSet="+rowSet.toString()+",/n model="+model);
//					log.info("\n HDR_COA_INTER_CO_CD==="+rowSet.getString("HDR_COA_INTER_CO_CD"));
					docReq = eaiDao.transferAtOnceAGT017ToEAIByWS(csrNo, rowSet, model); //2007.05.31 modify
					log.info("\n docReq="+docReq.toString());
				}//if(result.equals("R")){	
				
			}else{
				
				BRKGAuditBC brkgCommand = new BRKGAuditBCImpl();
				docReq = brkgCommand.transferBRKGActualINFtoAP1(result, csrNo, model);
				
			}//if(commFlag.equals("COMMISSION")){
				
			return docReq;
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	
	/**
     * ESM_AGT_017 화면에 대한 AP Interface 이벤트 처리(1) : EP결재 수신 + CSR I/F 승인건에 대한 처리<br>
     * 
     * @param  String result
     * @param  String csrNo
     * @param  ComAproRqstRoutVO model
     * @return String
     * @throws EventException
     */
	public String transferAgentActualINFtoAP2(String result, String csrNo, ComAproRqstRoutVO model) throws EventException{

		String approStep = "";
		String usr_jb_tit_nm = "";
		String usr_nm = "";
		AgentActualINFtoAPCheckVO aPApproVO = new AgentActualINFtoAPCheckVO();

		try {
			
			////업무구분(AGT/BRKG/FAC)을 위한 CSR정보 조회
			aPApproVO.setCsrNo(csrNo);
			aPApproVO = dbDao.searchAGTCSRInfo(aPApproVO);
			////업무구분별 분기처리
			if(aPApproVO.getSrcCtnt().equals("COMMISSION")){
				if(!result.equals("R")){
					
					//승인시
					////AP_INV_IF에 최종사용자 UPDATE
					if(model.getAproUsrJbTitNm() == null){
						usr_jb_tit_nm = "";
					}else{
						usr_jb_tit_nm = model.getAproUsrJbTitNm();
					}
					
					if(model.getAproUsrNm() == null){
						usr_nm = "";
					}else{
						usr_nm = model.getAproUsrNm();
					}
					approStep = usr_jb_tit_nm + "/" + usr_nm;
					
					aPApproVO.setAproStep(approStep);
					
					dbDao.modifyApprovalStep(aPApproVO);
					
					////AP 인터페이스 실행결과를 AGT_AGN_COMM에 UPDATE하기
					dbDao.modifyAGTCommInfo(aPApproVO);
					
				}//if(result.equals("R")){	
				
			}else{
				
				BRKGAuditBC brkgCommand = new BRKGAuditBCImpl();
				brkgCommand.transferBRKGActualINFtoAP2(result, csrNo, model);
				
			}//if(commFlag.equals("COMMISSION")){
				
			return "";
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
     * ESM_AGT_017 화면에 대한 AP Interface 이벤트 처리(1) : EP결재 수신 + CSR I/F 승인건에 대한 처리<br>
     * 
     * @param  AGTCommInfoForPrintVO agtCommInfoForPrintVO
     * @return List<AGTCommInfoForPrintVO>
     * @throws EventException
     */
    public List<AGTCommInfoForPrintVO> searchAGTCommInfoForPrint1(AGTCommInfoForPrintVO agtCommInfoForPrintVO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchAGTCommInfoForPrint1(agtCommInfoForPrintVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
    /**
     * ESM_AGT_017 화면에 대한 AP Interface 이벤트 처리(1) : EP결재 수신 + CSR I/F 승인건에 대한 처리<br>
     * 
     * @param  AGTCommInfoForPrint2VO agtCommInfoForPrint2VO
     * @return List<AGTCommInfoForPrint2VO>
     * @throws EventException
     */
	@Override
    public List<AGTCommInfoForPrint2VO> searchAGTCommInfoForPrint2(AGTCommInfoForPrint2VO agtCommInfoForPrint2VO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchAGTCommInfoForPrint2(agtCommInfoForPrint2VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }

	/**
	 * (ESM_AGT_0036) Agent Commission Approval No 를 생성한다.<br>
	 * @param  AgtAgnCommVO agtAgnCommVO
     * @return List<AgtAgnCommVO>
     * @throws EventException
	 */
	@Override
	public List<AgtAgnCommVO> searchAGTCommApprovalNo(AgtAgnCommVO agtAgnCommVO)
			throws EventException {
		try {
			log.info("\n agtAgnCommVO="+agtAgnCommVO.getAgnCd());
			return dbDao.searchAGTCommApprovalNo(agtAgnCommVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * (ESM_AGT_0036) Agent Commission Approval 조회 한다.<br>
	 * @param  AgtAgnCommVO agtAgnCommVO
     * @return List<AgtAgnCommVO>
     * @throws EventException
	 */
	@Override
	public List<AgtAgnCommVO> searchAGTCommTobeApproved(AgtAgnCommVO agtAgnCommVO) throws EventException {
		try{
			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			log.info("\n >>>>>agtAgnCommVO getArrVal="+agtAgnCommVO.getArrVal());
			log.info("\n agtAgnCommVO="+agtAgnCommVO);
			return dbDao.searchAGTCommTobeApproved(agtAgnCommVO);
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * (ESM_AGT_0036) Agent Commission Approval 를 Confirm 한다.<br>
	 * @param  AgtAgnCommVO[] agtAgnCommVOS
     * @param  SignOnUserAccount account
     * @throws EventException
	 */
	@Override
    public void modifyAGTCommTobeApproved(AgtAgnCommVO[] agtAgnCommVOS, SignOnUserAccount account) throws EventException {
	    // TODO Auto-generated method stub
		String localDt			= "";
		String strApproCnt		= "";
		StringBuffer sbBkgNos	= new StringBuffer();

		AgtAgnCommVO agtAgnCommVO = new AgtAgnCommVO();
		int upCnt = 0;
		try
		{
			localDt = dbDao.searchAGTAuditDBDAOAGTCommTobeApprovedChkLocalDt(agtAgnCommVOS[0]); 
//2011.07.07 이정수 R4J			if (localDt == "" || localDt == null || localDt.length() < 8)
			if ( "".equals(localDt) || localDt == null || localDt.length() < 8)	
			{
				//[$s] does not exist!, Please check up Again!
				throw new DAOException((new ErrorHandler("AGT00027", new String[]{"LOCAL DATE"})).getMessage());
			}
			localDt = dbDao.searchAGTAuditDBDAOAGTCommTobeApprovedGetLocalDt(agtAgnCommVOS[0]); 
//2011.07.07 이정수 R4J			if (localDt == "" || localDt == null || localDt.length() < 8)
			if ("".equals(localDt)  || localDt == null || localDt.length() < 8)
			{
				//[$s] does not exist!, Please check up Again!
				throw new DAOException((new ErrorHandler("AGT00027", new String[]{"LOCAL DATE"})).getMessage());
			}
			strApproCnt = dbDao.searchAGTAuditDBDAOAGTCommTobeCheckApprovalNo(agtAgnCommVOS[0]);
			if (!"0".equals(strApproCnt))
			{
				throw new DAOException((new ErrorHandler("AGT00073", new String[]{agtAgnCommVOS[0].getAproNo()})).getMessage());
			}

			agtAgnCommVO.setAcAproDt(localDt);
			agtAgnCommVO.setCommAproNo(agtAgnCommVOS[0].getAproNo());
			agtAgnCommVO.setAcAproUsrId(account.getUsr_id());
			agtAgnCommVO.setUpdUsrId(account.getUsr_id());
			agtAgnCommVO.setSAproNo(agtAgnCommVOS[0].getSAproNo());
			agtAgnCommVO.setScnId(agtAgnCommVOS[0].getScnId());
			agtAgnCommVO.setExpType(agtAgnCommVOS[0].getExpType());
			agtAgnCommVO.setArOfcCd(agtAgnCommVOS[0].getArOfcCd());

			for(int k=0; k<agtAgnCommVOS.length; k++)
			{
				if (k == 0)
				{
					sbBkgNos.append("               SELECT '" + agtAgnCommVOS[k].getBkgNo()+ "' AS BKG_NO, ");
					sbBkgNos.append("'" + agtAgnCommVOS[k].getAgnCd()+ "' AS AGN_CD, ");
					sbBkgNos.append("'" + agtAgnCommVOS[k].getIoBndCd()+ "' AS IO_BND_CD, ");
					sbBkgNos.append("'" + agtAgnCommVOS[k].getAcSeq()+ "' AS AC_SEQ FROM DUAL\n");
				}
				sbBkgNos.append("            UNION ALL\n");
				sbBkgNos.append("               SELECT '" + agtAgnCommVOS[k].getBkgNo()+ "' AS BKG_NO, ");
				sbBkgNos.append("'" + agtAgnCommVOS[k].getAgnCd()+ "' AS AGN_CD, ");
				sbBkgNos.append("'" + agtAgnCommVOS[k].getIoBndCd()+ "' AS IO_BND_CD, ");
				sbBkgNos.append("'" + agtAgnCommVOS[k].getAcSeq()+ "' AS AC_SEQ FROM DUAL\n");
			}
			agtAgnCommVO.setBkgNo(sbBkgNos.toString());

			if(agtAgnCommVO.getBkgNo() != ""){
				upCnt = dbDao.modifyAGTCommTobeApproved(agtAgnCommVO);
			}
			
			
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
    }
	/**
	 * (ESM_AGT_0017) Agent Commission Approval 를 Confirm 한다.<br>
     * @param  String csr_no
     * @throws EventException
	 */
	@Override
    public void modifyAGTCommIFBack(String csr_no) throws EventException {
	    // TODO Auto-generated method stub
		log.info("\n >>>>modifyAGTCommApprovedBack Start");
		try{
			
			dbDao.modifyAGTCommIFBack(csr_no);
			dbDao.modifyAGTCommIFBackAP(csr_no);
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		log.info("\n >>>>modifyAGTCommApprovedBack End");
		
    }
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param AgtCommBkgInfoVO agtCommBkgInfoVO
	 * @return List<AgtCommBkgInfoVO>
	 * @exception EventException
	 */
	public List<AgtCommBkgInfoVO> searchAGTCommforReportbyCustomizedOption(AgtCommBkgInfoVO agtCommBkgInfoVO) throws EventException {
		try {
			String colNm = "";
			String groupByCalse = "";
			colNm = "|" + agtCommBkgInfoVO.getColNm() + "|";
			if( -1 < colNm.indexOf("|bl_no|") )
				groupByCalse = "INF.BL_NO";

			if( -1 < colNm.indexOf("|bkg_no|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"AGN.BKG_NO";

			if( -1 < colNm.indexOf("|io_bnd_cd|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"AGN.IO_BND_CD";

			if( -1 < colNm.indexOf("|comm_vvd|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"CONCAT (CONCAT (AGN.COMM_VSL_CD, AGN.COMM_SKD_VOY_NO), AGN.COMM_SKD_DIR_CD)";

			if( -1 < colNm.indexOf("|sail_arr_dt|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"AGN.SAIL_ARR_DT";

			if( -1 < colNm.indexOf("|por_cd|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"INF.BKG_POR_CD";

			if( -1 < colNm.indexOf("|pol_cd|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"INF.BKG_POL_CD";

			if( -1 < colNm.indexOf("|pod_cd|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"INF.BKG_POD_CD";

			if( -1 < colNm.indexOf("|del_cd|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"INF.BKG_DEL_CD";
			
			if( -1 < colNm.indexOf("|trd_cd|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"INF.TRD_CD";
			
			if( -1 < colNm.indexOf("|rlane_cd|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"INF.RLANE_CD";
			
			if( -1 < colNm.indexOf("|dir_cd|") )
				groupByCalse = groupByCalse + ("".equals(groupByCalse)?"":", ")+"AGN.COMM_SKD_DIR_CD";
			
			agtCommBkgInfoVO.setColNm(groupByCalse);
			if (5 < agtCommBkgInfoVO.getBlNo().length())
			{
				agtCommBkgInfoVO.setBlNo("'"+agtCommBkgInfoVO.getBlNo().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}
			return dbDao.searchAGTCommforReportbyCustomizedOption(agtCommBkgInfoVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param AgtRptItmInfoDtlVO agtRptItmInfoDtlVO
	 * @return List<AgtRptItmInfoDtlVO>
	 * @exception EventException
	 */
	public List<AgtRptItmInfoDtlVO> searchRptItem(AgtRptItmInfoDtlVO agtRptItmInfoDtlVO) throws EventException {
		try {
			
			List<AgtRptItmInfoDtlVO> list = dbDao.searchRptItem(agtRptItmInfoDtlVO);
			AgtRptItmInfoDtlVO rptItm = new AgtRptItmInfoDtlVO();
			String rptItmDesc = "";
			String rptItmColNm = "";
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					if(i<list.size()-1){
						rptItmDesc = rptItmDesc + list.get(i).getRptItmDesc()+"|";
						rptItmColNm = rptItmColNm + list.get(i).getRptItmColNm()+"|";
					}else{
						rptItmDesc = rptItmDesc + list.get(i).getRptItmDesc();
						rptItmColNm = rptItmColNm + list.get(i).getRptItmColNm();
					}
				}
				rptItm.setRptItmDesc(rptItmDesc);
				rptItm.setRptItmColNm(rptItmColNm.toLowerCase());
				list.set(0, rptItm);
			}
			return list;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * ESM_AGT_0016 화면에 대한 승인취소 이벤트 처리<br>
	 * 
	 * @param DBRowSet dRs
	 * @exception EventException
	 */
	public void sendChnPantoEDIIF(DBRowSet dRs) throws EventException{
		
		try {
			eaiDao.transferChnPantoEDIIF(dRs); 
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/** (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchAGTCommForAudit(AgtCommListVO agtCommListVO) throws EventException {
		try
		{
			if (5 < agtCommListVO.getBlNos().length())
			{
				agtCommListVO.setBlNos("'"+agtCommListVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}

			return dbDao.searchAGTCommForAudit(agtCommListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 수정 한다.<br> 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyAGTCommForAudit(AgtCommListVO[] agtCommListVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try
		{
			for(int i=0; i<agtCommListVOs.length; i++)
			{
				if ( agtCommListVOs[i].getIbflag().equals("U")){
					agtCommListVOs[i].setUpdUsrId(account.getUsr_id());
					agtCommListVOs[i].setCreUsrId(account.getUsr_id());

					dbDao.modifyAGTCommForAuditAgtAgnComm(agtCommListVOs[i]);
					dbDao.removeAGTCommForAuditAgtAgnCommDtl(agtCommListVOs[i]);
					dbDao.createAGTCommForAuditAgtAgnCommDtl(agtCommListVOs[i]);
//					dbDao.modifymultiOtherCommForRequestAgtAgnCommDtl(agtCommListVOs[i]);
//					dbDao.modifymultiOtherCommForRequestAgtCommBkgInfo(agtCommListVOs[i]);
				}
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	
	/**
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 수정 한다.<br> 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyCancelAGTCommForAudit(AgtCommListVO[] agtCommListVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try
		{
			for(int i=0; i<agtCommListVOs.length; i++)
			{	
				if ( agtCommListVOs[i].getIbflag().equals("U")){
					agtCommListVOs[i].setUpdUsrId(account.getUsr_id());
					agtCommListVOs[i].setStsCd(agtCommListVOs[0].getStsCd());
					dbDao.modifyCancelAGTCommForAudit(agtCommListVOs[i]);
				}
				
			}
			
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}


	/**
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 수정 한다.<br> 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyRejectAGTCommForAudit(AgtCommListVO[] agtCommListVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try
		{
			for(int i=0; i<agtCommListVOs.length; i++)
			{
				if ( agtCommListVOs[i].getIbflag().equals("U")){
					agtCommListVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyRejectAGTCommForAudit(agtCommListVOs[i]);
				}
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	/**
	 * ESM_AGT_0041 화면에서 기본 컬럼 정보를 조회<br>
	 * @param  AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO
     * @param  SignOnUserAccount account
     * @return List<AgtRptItmInfoMstDtlVO>
     * @throws EventException
	 */
	@Override
    public List<AgtRptItmInfoMstDtlVO> searchAGTDimensionReportbyMultiOption(AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO, SignOnUserAccount account) throws EventException {
	    try{
	    	agtRptItmInfoMstDtlVO.setCreUsrId("SYSTEM");
	    	log.info("\n <<<<a1>>>>");
	    	return dbDao.searchAGTDimensionReportbyMultiOption(agtRptItmInfoMstDtlVO);
	    }catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0041 화면에서 RPT Form 선택시 컬럼 정보를 조회<br>
	 * @param  AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO
     * @param  SignOnUserAccount account
     * @return List<AgtRptItmInfoMstDtlVO>
     * @throws EventException
	 */
	public List<AgtRptItmInfoMstDtlVO> searchAGTDimensionReportbyMultiOption1(AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO, SignOnUserAccount account) throws EventException {
	    try{
	    	agtRptItmInfoMstDtlVO.setCreUsrId(account.getUsr_id());
	    	log.info("\n <SlctItmFomNum>="+agtRptItmInfoMstDtlVO.getSlctItmFomNum());
	    	log.info("\n <SlctItmFomSeq>="+agtRptItmInfoMstDtlVO.getSlctItmFomSeq());
	    	return dbDao.searchAGTDimensionReportbyMultiOption1(agtRptItmInfoMstDtlVO);
	    }catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0041 화면에서 maxSeq 조회, Save, Delete
	 * @param  AgtRptItmInfoMstDtlVO[] agtRptItmInfoMstDtlVOS
     * @param  AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO
     * @param  SignOnUserAccount account
     * @throws EventException
	 */
	@Override
    public void multiAGTDimensionReportbyMultiOption(AgtRptItmInfoMstDtlVO[] agtRptItmInfoMstDtlVOS, AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO, SignOnUserAccount account) throws EventException {
		List<AgtRptItmInfoMstDtlVO> verifyList = new ArrayList<AgtRptItmInfoMstDtlVO>();

		try{
			agtRptItmInfoMstDtlVO.setCreUsrId(account.getUsr_id());
			if(agtRptItmInfoMstDtlVO.getSaveFlag().equals("I") && agtRptItmInfoMstDtlVO.getSaveYn().equals("Y")){
				log.info("\n  <<agtRptItmInfoMstDtlVOS[0].getTxtGroup()>>"+agtRptItmInfoMstDtlVO.getTxtGroup());
				if(agtRptItmInfoMstDtlVOS[0].getTxtGroup().length() <= 0){						
					verifyList = dbDao.searchAGTDimensionReportbyMultiOptionMaxSeq(agtRptItmInfoMstDtlVO);
					AgtRptItmInfoMstDtlVO maxSeq = (AgtRptItmInfoMstDtlVO)verifyList.get(0);
					log.info("\n  <<maxSeq>>"+maxSeq.getSlctItmFomSeq());
					agtRptItmInfoMstDtlVO.setSlctItmFomSeq(maxSeq.getSlctItmFomSeq());
				}else{
					agtRptItmInfoMstDtlVO.setCreUsrId(account.getUsr_id());
					log.info("\n <<<curusrid>>>"+agtRptItmInfoMstDtlVO.getCreUsrId());
					log.info("\n <<<SlctItmFomSeq>>>"+agtRptItmInfoMstDtlVO.getSlctItmFomSeq());
					dbDao.deleteAGTAuditDBDAODimensionReportbyMultiOptionMst(agtRptItmInfoMstDtlVO);
					dbDao.deleteAGTAuditDBDAODimensionReportbyMultiOptionDtl(agtRptItmInfoMstDtlVO);
				}
				agtRptItmInfoMstDtlVO.setSlctItmFomDesc(agtRptItmInfoMstDtlVO.getSaveName());
				agtRptItmInfoMstDtlVO.setRptUsrId(account.getUsr_id());
				agtRptItmInfoMstDtlVO.setUpdUsrId(account.getUsr_id());
				dbDao.createAGTAuditDBDAODimensionReportbyMultiOptionMst(agtRptItmInfoMstDtlVO);
				log.info("\n  <<<agtRptItmInfoMstDtlVOS.length>>="+agtRptItmInfoMstDtlVOS.length);
				for(int i=0; i<agtRptItmInfoMstDtlVOS.length; i++){
					agtRptItmInfoMstDtlVOS[i].setCreUsrId(account.getUsr_id());
					agtRptItmInfoMstDtlVOS[i].setRptUsrId(account.getUsr_id());
					agtRptItmInfoMstDtlVOS[i].setUpdUsrId(account.getUsr_id());
					agtRptItmInfoMstDtlVOS[i].setSlctItmFomSeq(agtRptItmInfoMstDtlVO.getSlctItmFomSeq());
					dbDao.createAGTAuditDBDAODimensionReportbyMultiOptionDtl(agtRptItmInfoMstDtlVOS[i]);
					
				}
			}else if(agtRptItmInfoMstDtlVO.getSaveFlag().equals("D")){
				agtRptItmInfoMstDtlVO.setIbflag(agtRptItmInfoMstDtlVO.getSaveFlag());
				if(agtRptItmInfoMstDtlVOS[0].getTxtGroup().length() > 0){	
					agtRptItmInfoMstDtlVO.setCreUsrId(account.getUsr_id());
					log.info("\n <<<curusrid>>>"+agtRptItmInfoMstDtlVO.getCreUsrId());
					log.info("\n <<<SlctItmFomSeq>>>"+agtRptItmInfoMstDtlVO.getSlctItmFomSeq());
					dbDao.deleteAGTAuditDBDAODimensionReportbyMultiOptionMst(agtRptItmInfoMstDtlVO);
					dbDao.deleteAGTAuditDBDAODimensionReportbyMultiOptionDtl(agtRptItmInfoMstDtlVO);
				}
			}
			
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	    
    }
	/**
	 * (ESM_AGT_0042) Other Commission Request의 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @exception EventException
	 */
	public List<AgtAgnCommVO> searchOtherCommForRequest(AgtAgnCommVO agtAgnCommVO) throws EventException {
		try
		{
			return dbDao.searchOtherCommForRequest(agtAgnCommVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public void modifyOtherCommForRequest(AgtAgnCommVO[] agtAgnCommVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try
		{
			for(int i=0; i<agtAgnCommVOs.length; i++)
			{
				if ( agtAgnCommVOs[i].getIbflag().equals("U")){
					agtAgnCommVOs[i].setUpdUsrId(account.getUsr_id());
					agtAgnCommVOs[i].setAcRqstUsrId(account.getUsr_id());
					agtAgnCommVOs[i].setAcRqstUsrEml(account.getUsr_eml());

					dbDao.modifyOtherCommForRequest(agtAgnCommVOs[i]);
				}
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 정보를 추가,수정, 삭제한다.<br> 
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommForRequest(AgtAgnCommVO[] agtAgnCommVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		String yrmon = agtAgnCommVOs[0].getCommYrmon();
		try
		{
			for(int i=0; i<agtAgnCommVOs.length; i++)
			{
				agtAgnCommVOs[i].setCommYrmon(yrmon);
				
				if ( agtAgnCommVOs[i].getIbflag().equals("U")){
					agtAgnCommVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifymultiOtherCommForRequestAgtAgnComm(agtAgnCommVOs[i]);
					dbDao.modifymultiOtherCommForRequestAgtAgnCommDtl(agtAgnCommVOs[i]);
					dbDao.modifymultiOtherCommForRequestAgtCommBkgInfo(agtAgnCommVOs[i]);
				}
				else if ( agtAgnCommVOs[i].getIbflag().equals("D")){
					agtAgnCommVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.removemultiOtherCommForRequestAgtAgnComm(agtAgnCommVOs[i]);
					dbDao.removemultiOtherCommForRequestAgtAgnCommDtl(agtAgnCommVOs[i]);
					dbDao.removemultiOtherCommForRequestAgtCommBkgInfo(agtAgnCommVOs[i]);
				}
				else if ( agtAgnCommVOs[i].getIbflag().equals("I"))
				{	
					List verifyList = (List) dbDao.searchMultiOtherCommForRequest(agtAgnCommVOs[i]);
					if ( verifyList.size() < 1){
						//[$s] does not exist!, Please check up Again!
						throw new DAOException((new ErrorHandler("AGT00027", new String[]{"Office Code(" + agtAgnCommVOs[i].getOfcCd() + ")"})).getMessage());
					}
					AgtAgnCommVO verifyVO = (AgtAgnCommVO)verifyList.get(0);
					if ( !"Y".equalsIgnoreCase(verifyVO.getVvdChkYn())){
						//VVD Code does not exist in VVD Code from AR Revenue And VVD Level from MDM Account.
						throw new DAOException((new ErrorHandler("AGT00028")).getMessage());
					}
					agtAgnCommVOs[i].setUpdUsrId(account.getUsr_id());
					agtAgnCommVOs[i].setCreUsrId(account.getUsr_id());
					agtAgnCommVOs[i].setBkgNo(verifyVO.getBkgNo());

					dbDao.addmultiOtherCommForRequestAgtCommBkgInfo(agtAgnCommVOs[i]);
					dbDao.addmultiOtherCommForRequestAgtAgnComm(agtAgnCommVOs[i]);
					dbDao.addmultiOtherCommForRequestAgtAgnCommDtl(agtAgnCommVOs[i]);
//					dbDao.addmultiOtherCommForRequestAgtCommBkgInfo(agtAgnCommVOs[i]);
				}
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	/**
	 * ESM_AGT_0043 화면 조회
	 * @param  CSRDetailforCommissionHdrVO csrDetailforCommissionHdrVO
     * @return List<CSRDetailforCommissionHdrVO>
     * @throws EventException
	 */
	@Override
    public List<CSRDetailforCommissionHdrVO> searchCSRDetailforCommissionHdr(CSRDetailforCommissionHdrVO csrDetailforCommissionHdrVO) throws EventException {
		try
		{
			return dbDao.searchCSRDetailforCommissionHdr(csrDetailforCommissionHdrVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0043 화면 조회
	 * @param  CSRDetailforCommissionDtrbVO csrDetailforCommissionDtrbVO
     * @return List<CSRDetailforCommissionDtrbVO>
     * @throws EventException
	 */
	@Override
    public List<CSRDetailforCommissionDtrbVO> searchCSRDetailforCommissionDtrb(CSRDetailforCommissionDtrbVO csrDetailforCommissionDtrbVO) throws EventException {
		try
		{
			return dbDao.searchCSRDetailforCommissionDtrb(csrDetailforCommissionDtrbVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	
	/**
	 * (ESM_AGT_0051) Other Commission Approval의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchBKGList(AgtCommListVO agtCommListVO) throws EventException {
		try
		{
			if (5 < agtCommListVO.getBlNos().length())
			{
				agtCommListVO.setBlNos("'"+agtCommListVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}

			return dbDao.searchBKGList(agtCommListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}


	/**
	 * (ESM_AGT_0051) Other Commission Approval의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchAGTCommList(AgtCommListVO agtCommListVO) throws EventException {
		try
		{
			return dbDao.searchAGTCommList(agtCommListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * (ESM_AGT_0036) Agent Commission Approval No 를 생성한다.<br>
	 * @param  AGTVVDRateVO agtVVDRateVO
     * @return List<AGTVVDRateVO>
     * @throws EventException
	 */
	public List<AGTVVDRateVO> searchVVDRateList(AGTVVDRateVO agtVVDRateVO) throws EventException {
		//int cnt = 0;
		try {
			//cnt    = dbDao.totalVVDRate(agtVVDRateVO);
            //rowSet = dbDao.searchVVDRateList(e);
            //rowSet.setMaxRows(cnt);
			return dbDao.searchVVDRateList(agtVVDRateVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
}