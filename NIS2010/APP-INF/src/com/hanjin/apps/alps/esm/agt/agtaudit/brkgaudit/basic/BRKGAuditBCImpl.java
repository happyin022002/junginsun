/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BRKGAuditBCImpl.java
*@FileTitle : Brokerage Maintenance & Approval Management
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-22
*@LastModifier : Jung-Hyung, Kim
*@LastVersion : 1.0
* 2007-01-22 Jung-Hyung, Kim
* 1.0 최초 생성 
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration.BRKGAuditDBDAO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration.BRKGAuditEAIDAO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.AGTBRKGRateInfoVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceDetailForBRKGVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceMasterForBRKGVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailBasicbyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailChargebyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailHistorybyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrint2VO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrintVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoListForPrintVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BrkgCommVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.CmpnCommVO;
import com.hanjin.apps.alps.esm.agt.agtcalculation.AGTCalculationSC;
import com.hanjin.apps.alps.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBC;
import com.hanjin.apps.alps.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBCImpl;
import com.hanjin.apps.alps.esm.agt.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.agt.common.basic.CommonBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;

/**
 * eNIS-AGT Business Logic Basic Command implementation<br>
 * - eNIS-AGT에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Junghyung_kim
 * @see AGTAuditDAO 참조
 * @since J2EE 1.4
 */
public class BRKGAuditBCImpl extends BasicCommandSupport implements BRKGAuditBC {
	
	// Database Access Object
	private transient BRKGAuditDBDAO dbDao = null;
	
	// EAI Interface Object
	private transient BRKGAuditEAIDAO eaiDao = null;

	/**
	 * BRKGAuditBCImpl 객체 생성<br>
	 * BRKGAuditDBDAO, BRKGAuditEAIDAO를 생성한다.<br>
	 */
	public BRKGAuditBCImpl(){
		dbDao = new BRKGAuditDBDAO();
		eaiDao = new BRKGAuditEAIDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0013 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param BrkgCommVO brkgCommVO
	 * @return List<BrkgCommVO>
	 * @exception EventException
	 */
	public List<BrkgCommVO> searchBRKGCommforAudit(BrkgCommVO brkgCommVO) throws EventException {
		try
		{
			if (5 < brkgCommVO.getBlNos().length())
			{
				brkgCommVO.setBlNos("'"+brkgCommVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}
			return dbDao.searchBRKGCommforAudit(brkgCommVO);
		} catch(DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}


	
	/**
	 * ESM_AGT_0013 화면에서 Brokerage Commission recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param BrkgCommVO[] brkgCommVOs
	 * @exception EventException
	 */
	public void createBRKGCommByRequest(BrkgCommVO[] brkgCommVOs) throws EventException {

		// Commission 계산을 위한 객체 
		BRKGCalcBC brkgCalcBC = new BRKGCalcBCImpl();

		try
		{
			for(int i=0; i<brkgCommVOs.length; i++)
			{
				if ( brkgCommVOs[i].getIbflag().equals("U")){
					log.debug("\n\nBkgNo:"+brkgCommVOs[i].getBkgNo()+"\n\n\n");
					brkgCalcBC.createBRKGComm(brkgCommVOs[i].getBkgNo());
				}
			}
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	
	
	
	
	/**
	 * ESM_AGT_0013 화면에서 Agreement Commission recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse reCalcBRKGComm(Event e) throws EventException {

		// Commission 계산을 위한 객체 
		AGTCalculationSC agtCalSC = null;

		try {

	        agtCalSC = new AGTCalculationSC();
	        agtCalSC.reCalcBRKGComm(e);

	        //agtCalSC.createBRKGComm("SLC53020054","  ");
	        
			return null;

		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_0013 화면에 대한 수정/삭제 이벤트 처리<br>
	 * 
	 * @param BrkgCommVO[] brkgCommVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBRKGCommforAudit(BrkgCommVO[] brkgCommVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		CommonBC cbc = new CommonBCImpl();
		try
		{
			for(int i=0; i<brkgCommVOs.length; i++)
			{
				if ( brkgCommVOs[i].getIbflag().equals("U"))
				{
					String[] cust_cd = cbc.searchCodeList("C", "C", new String[]{brkgCommVOs[i].getFrtFwrdCntSeq()});	//Freight Forwarder Customer Code
					String[] vndr_cd = cbc.searchCodeList("V", "C", new String[]{brkgCommVOs[i].getVndrCntSeq()});		//Vendor Code;
					brkgCommVOs[i].setFrtFwrdCntCd(cust_cd[0].substring(0, 2));
					brkgCommVOs[i].setFrtFwrdSeq(cust_cd[0].substring(2));
					brkgCommVOs[i].setVndrCntCd(vndr_cd[0].substring(0, 2));
					brkgCommVOs[i].setVndrSeq(vndr_cd[0].substring(2));
					
					brkgCommVOs[i].setUpdUsrId(account.getUsr_id());

					if(brkgCommVOs[i].getCommProcStsCd().equals("CE")){
						if(brkgCommVOs[i].getCommProcRsltRsn().equals("Commission Calculation OK!")){
							dbDao.modifyBRKGCommforAuditAgtBrogCommCM(brkgCommVOs[i]);
						}else{
							dbDao.modifyBRKGCommforAuditAgtBrogComm(brkgCommVOs[i]);
						}
					}else{
						dbDao.modifyBRKGCommforAuditAgtBrogCommCM(brkgCommVOs[i]);
					}
					dbDao.modifyBRKGCommforAuditAgtCommBkgInfo(brkgCommVOs[i]);
				}
				else if ( brkgCommVOs[i].getIbflag().equals("D")) 
				{
					dbDao.removeBRKGCommforAuditAgtBrogCommDtl(brkgCommVOs[i]);
					dbDao.removeBRKGCommforAuditAgtBrogChgDtl(brkgCommVOs[i]);
					dbDao.removeBRKGCommforAuditAgtBrogComm(brkgCommVOs[i]);
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
	 * ESM_AGT_0014) Brokerage Commission의 Basic 정보를 조회
	 * @param BRKGCommDetailBasicbyBLVO brkgCommDetailBasicbyBLVO
	 * @return List<BRKGCommDetailBasicbyBLVO>
	 * @exception EventException
	 */
	@Override
    public List<BRKGCommDetailBasicbyBLVO> searchBRKGCommDetailBasicbyBL(BRKGCommDetailBasicbyBLVO brkgCommDetailBasicbyBLVO) throws EventException {
		try{
	    	return dbDao.searchBRKGCommDetailBasicbyBL(brkgCommDetailBasicbyBLVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
    }
	/**
	 * (ESM_AGT_0014) Charge Detail 목록 조회<br>
	 * @param BRKGCommDetailChargebyBLVO brkgCommDetailChargebyBLVO
	 * @return List<BRKGCommDetailChargebyBLVO>
	 * @exception EventException
	 */
	@Override
    public List<BRKGCommDetailChargebyBLVO> searchBRKGCommDetailChargebyBL(BRKGCommDetailChargebyBLVO brkgCommDetailChargebyBLVO) throws EventException {
		try{
	    	return dbDao.searchBRKGCommDetailChargebyBL(brkgCommDetailChargebyBLVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
    }
	/**
	 * (ESM_AGT_0014) Brokerage Commission의 History Detail 목록 조회<br>
	 * @param BRKGCommDetailHistorybyBLVO brkgCommDetailHistorybyBLVO
	 * @return List<BRKGCommDetailHistorybyBLVO>
	 * @exception EventException
	 */
	@Override
    public List<BRKGCommDetailHistorybyBLVO> searchBRKGCommDetailHistorybyBL(BRKGCommDetailHistorybyBLVO brkgCommDetailHistorybyBLVO) throws EventException {
		try{
	    	return dbDao.searchBRKGCommDetailHistorybyBL(brkgCommDetailHistorybyBLVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
    }
	/**
	 * ESM_AGT_0014 화면 요율 정보 조회 이벤트 처리<br>
	 * @param AGTBRKGRateInfoVO agtBRKGRateInfoVO
	 * @return List<AGTBRKGRateInfoVO>
	 * @exception EventException
	 */
	@Override
    public List<AGTBRKGRateInfoVO> searchAGTBRKGRateInfo(AGTBRKGRateInfoVO agtBRKGRateInfoVO) throws EventException {
	    try{
	    	return dbDao.searchAGTBRKGRateInfo(agtBRKGRateInfoVO);
	    }catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
    }
	

	/**
	 * ESM_AGT_0018 화면에 대한 Brokerage Approval & Request 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @return List<APActualInterfaceMasterForBRKGVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceMasterForBRKGVO> searchAPActualInterfaceMasterForBRKG(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO) throws EventException {
		try {

			if (5 < apActualInterfaceMasterForBRKGVO.getBlNos().length())
			{
				apActualInterfaceMasterForBRKGVO.setBlNos("'"+apActualInterfaceMasterForBRKGVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}
			
			return dbDao.searchAPActualInterfaceMasterForBRKG(apActualInterfaceMasterForBRKGVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}


	/**
	 * ESM_AGT_0018 화면에 대한 Brokerage Approval & Request Detail 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO
	 * @return List<APActualInterfaceDetailForBRKGVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceDetailForBRKGVO> searchAPActualInterfaceDetailForBRKG(APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchAPActualInterfaceDetailForBRKGVO(apActualInterfaceDetailForBRKGVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * ESM_AGT_0018 화면에 대한 엑셀저장용 Brokerage Approval & Request 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceVO apActualInterfaceVO
	 * @return List<APActualInterfaceVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceVO> searchAPActualInterfaceMasterDetailDownExcel(APActualInterfaceVO apActualInterfaceVO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchAPActualInterfaceMasterDetailDownExcel(apActualInterfaceVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	

	/**
	 * ESM_AGT_0018 화면에 대한 Brokerage Approval & Request 대상리스트를 취소한다.<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCancelBRKGActualINFtoAP(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO,
			SignOnUserAccount account) throws EventException {
		try
		{
			dbDao.createCancelBRKGActualINFtoAP(apActualInterfaceMasterForBRKGVO, account);
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * ESM_AGT_0018 화면의 Print 이벤트
	 * @param BRKGInfoListForPrintVO brgkInfoListForPrintVO
	 * @return List<BRKGInfoListForPrintVO>
	 * @exception EventException
	 */
	public List<BRKGInfoListForPrintVO> searchBRKGInfoListForPrint(BRKGInfoListForPrintVO brgkInfoListForPrintVO) throws EventException {
		//searchAPActualInterfaceMasterForBRKG(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
		try {
			
			if (5 < brgkInfoListForPrintVO.getBlNos().length())
			{
				brgkInfoListForPrintVO.setBlNos("'"+brgkInfoListForPrintVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}
			
			return dbDao.searchBRKGInfoListForPrint(brgkInfoListForPrintVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	    
    }
    /**
     * ESM_AGT_0018 화면의 CSR Print 이벤트
     * @param BRKGInfoForPrintVO brkgInfoForPrintVO
	 * @return List<BRKGInfoForPrintVO>
	 * @exception EventException
     */
	@Override
	public List<BRKGInfoForPrintVO> searchBRKGInfoForPrint1(BRKGInfoForPrintVO brkgInfoForPrintVO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchBRKGInfoForPrint1(brkgInfoForPrintVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	/**
	 * ESM_AGT_0018 화면의 CSR Print 이벤트
	 * @param BRKGInfoForPrint2VO brkgInfoForPrint2VO
	 * @return List<BRKGInfoForPrint2VO>
	 * @exception EventException
	 */
	@Override
	public List<BRKGInfoForPrint2VO> searchBRKGInfoForPrint2(BRKGInfoForPrint2VO brkgInfoForPrint2VO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchBRKGInfoForPrint2(brkgInfoForPrint2VO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }

	/**
	 * ESM_AGT_0018 화면에 대한 Brokerage Approval & Request 대상리스트를 Interface한다.<br>
	 * @param APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createBRKGActualRequestINFtoAP(
			APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs,
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		
		DBRowSet dRs = null;
		
		try{
			if(actualInterfaceMasterForBRKGVOs.length > 0){
				
				dRs = dbDao.searchAPActualApprovalRequestList(actualInterfaceMasterForBRKGVO);
				
				String fwdr = null;
				String vndr_seq = null;
				String ap_ofc_cd = null;
				if(dRs.getRowCount() > 0){
					while (dRs.next())
					{
					fwdr = dRs.getString("fwdr");
					vndr_seq = dRs.getString("vndr_seq");
					ap_ofc_cd = dRs.getString("ap_ofc_cd");
					log.info("\n fwdr="+fwdr);
					log.info("\n vndr_seq = "+vndr_seq);
					log.info("\n ap_ofc_cd = "+ap_ofc_cd);
					createBRKGActualINFtoAP(actualInterfaceMasterForBRKGVOs, actualInterfaceMasterForBRKGVO, fwdr, vndr_seq, ap_ofc_cd, account);
					}
				}
			}
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * ESM_AGT_0018 화면에 대한 Brokerage Approval & Request 대상리스트를 Interface한다.<br>
	 * @param APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @param String fwdr
	 * @param String vndr_seq
	 * @param String ap_ofc_cd
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 * @exception EventException
	 */
	private void createBRKGActualINFtoAP(
			APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs,
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO, 
			String fwdr, String vndr_seq, String ap_ofc_cd,
			SignOnUserAccount account) throws DAOException, EventException{
		ArrayList csrNoArray = null;
		HashMap dataHash  = null;
		String csrNo = "";
		String vndr  = "";
		String apOfc = "";
		String glDt  = "";
		String aproNm = " ";
		ComAproRqstRoutVO model = null;
		
		boolean isEPRequest = true; //Real:true, Test:false
		
		try {
			log.info("\n actualInterfaceMasterForBRKGVOs.length="+actualInterfaceMasterForBRKGVOs.length);

			////1.AP_INV_HDR에 INSERT하기
			csrNoArray = 
				dbDao.createBRKGCSRHeader(actualInterfaceMasterForBRKGVOs, 
						actualInterfaceMasterForBRKGVO, 
						fwdr, vndr_seq, ap_ofc_cd, account);
			
			////2.AP_INV_DSTR에 INSERT하기
			for(int j=0; j<csrNoArray.size(); j++){
            	dataHash = (HashMap)csrNoArray.get(j);
            	csrNo = (String)dataHash.get("csrNo");
            	fwdr  = (String)dataHash.get("fwdr");
            	vndr  = (String)dataHash.get("vndr");
            	apOfc = (String)dataHash.get("apOfc");
            	glDt  = (String)dataHash.get("glDt");
            	dbDao.createBRKGCSRDistributionOne(actualInterfaceMasterForBRKGVO, fwdr, csrNo, vndr, apOfc, glDt, account);
			}
			// 2007.06.11 추가
			////2.1 AP_INV_IF에 INSERT하기
			for(int j=0; j<csrNoArray.size(); j++){
            	dataHash = (HashMap)csrNoArray.get(j);
            	csrNo = (String)dataHash.get("csrNo");
            	dbDao.createBRKGAPTempTable(csrNo, aproNm);
			}
			
			log.info("\n isEPRequest = "+isEPRequest);
			////3.EP결제 송신하기
			if(isEPRequest){
				//REAL
				for(int j=0; j<csrNoArray.size(); j++){
	            	dataHash = (HashMap)csrNoArray.get(j);
	            	csrNo = (String)dataHash.get("csrNo");
	            	dbDao.createBRKGApprovalRequesttoEPOne(actualInterfaceMasterForBRKGVO, csrNo, account);
				}
				
			}else{
				//TEST
				model = new ComAproRqstRoutVO();
//				ComAproRqstRoutVO[] route = approval.convertApprovalRoute(apActualInterfaceMasterVO.getAproStep());
				model.setAproUsrNm("BRKG_TEST");
//				log.info("n model = "+model);
				for(int j=0; j<csrNoArray.size(); j++){
	            	dataHash = (HashMap)csrNoArray.get(j);
	            	csrNo = (String)dataHash.get("csrNo");
				
	            	transferBRKGActualINFtoAP1("C", csrNo, model);
				}
			}//if(isEPRequest){
			
						
			//4.AP_INV_IF에 INSERT하기
			//dbDao.createBRKGAPTempTable(event, csrNoArray);
			
			//5.AP 인터페이스 실행하기
			//rowSet = dbDao.searchBRKGActualINFtoAP(csrNoArray);
			//if(isSuccess){
			//	eaiHash = eaiDao.transferAtOnceAGT018ToEAIByWS(rowSet);
			//	dbDao.createBRKGAcutalINFFromAPbyMSG(csrNoArray, eaiHash);
			//}else{
				//(테스트용. 삭제 예정!!!)
			//	eaiHash = new HashMap();
			//	eaiHash.put("isSuccess", "Y");
			//}
			//6.AP 인터페이스 실행결과를 AGT_AGN_COMM에 UPDATE하기
			//isSuccess = ((String)eaiHash.get("isSuccess") == "Y"?true:false);
			//dbDao.modifyBRKGInfo(event, isSuccess, csrNoArray);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (EventException ev) {
			log.error("err "+ev.toString(),ev);
			throw new EventException(ev.getMessage());
		}
		
	}

	/**
     * ESM_AGT_018 화면에 대한 인터페이스 이벤트 처리(2) : EP결재 수신 + CSR I/F<br>
     * 
     * @param  String result
     * @param  String csrNo
     * @param  ComAproRqstRoutVO model
     * @return FNS0080003Document[]
     * @throws EventException
     */
	public FNS0080003Document[] transferBRKGActualINFtoAP1(String result,
			String csrNo, ComAproRqstRoutVO model) throws EventException {
		DBRowSet rowSet = null;						//데이터 전송을 위해 DB ResultSet을 구현한 객체		
		String aproNm = "";
		boolean isSuccess = true;	//Real:true, Test:false
		// 2007.06.04 추가
		FNS0080003Document docReq[]		= null;
		
		try {
			aproNm = model.getAproUsrNm();	//최종결재자명
			if(aproNm == null) aproNm = " ";	//최종결재자명 공백처리
			//if(result == null) result = "C";		//flag값이 NULL인 경우, 승인한것으로 간주한다
			
			if(result.equals("R")){	
				//반려시
				dbDao.modifyBRKGApprovalRequesttoEP(csrNo);
				
			}else{	

				////5.AP 인터페이스 실행하기
				log.info("\n isSuccess = "+isSuccess);
				if(isSuccess){
					//REAL
					rowSet = dbDao.searchBRKGActualINFtoAP(csrNo);
					docReq = eaiDao.transferAtOnceAGT018ToEAIByWS(csrNo, rowSet, model); //2007.05.31 modify
				}
				log.info("\n docReq = "+docReq);
			}//if(result.equals("R")){
			
			return docReq;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
     * ESM_AGT_018 화면에 대한 인터페이스 이벤트 처리(2) : EP결재 수신 + CSR I/F<br>
     * 
     * @param  String result
     * @param  String csrNo
     * @param  ComAproRqstRoutVO model
     * @return String
     * @throws EventException
     */
	public String transferBRKGActualINFtoAP2(String result, String csrNo,
			ComAproRqstRoutVO model)
			throws EventException {
//	public String transferBRKGActualINFtoAP2(String result, String csrNo,
//				COM_APRO_RQST_ROUT model, String pgmNo)
//				throws EventException {
		String aproNm = "";
		HashMap eaiHash = new HashMap();
		String title_name = "";
		String usr_jb_tit_nm = "";
		String usr_nm = "";
		boolean isSuccess = true;	//Real:true, Test:false
		
		try {
//			if( doc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray().length > 0 )
//			{
//				hdr_gl_dt = doc.getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray()[0].getHGLDATE();
//			}
			
			aproNm = model.getAproUsrNm();	//최종결재자명
			if(aproNm == null) aproNm = " ";	//최종결재자명 공백처리
			//if(result == null) result = "C";		//flag값이 NULL인 경우, 승인한것으로 간주한다
			
			if(!result.equals("R")){	
				//승인시
				////4.AP_INV_IF에 INSERT하기
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
				
				title_name = usr_jb_tit_nm + "/" + usr_nm;
//				dbDao.modifyApprovalStep(title_name, csrNo, hdr_gl_dt);
				dbDao.modifyApprovalStep(title_name, csrNo);
				
				eaiHash.put("isSuccess", "Y");
				
				//dbDao.createBRKGAcutalINFFromAPbyMSG(csrNo, eaiHash);
				dbDao.createBRKGAcutalINFFromAPbyMSG(csrNo);
				
				////6.AP 인터페이스 실행결과를 AGT_BROG_COMM에 UPDATE하기
//2011.07.07 이정수 R4J				isSuccess = ((String)eaiHash.get("isSuccess") == "Y"?true:false);
				isSuccess = ("Y".equals((String)eaiHash.get("isSuccess")) ?true:false);
				dbDao.modifyBRKGInfo(isSuccess, csrNo);
			}//if(result.equals("R")){
			
			return "";
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
			//e.printStackTrace();
		}
		
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0059 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param CmpnCommVO cmpnCommVO
	 * @return List<CmpnCommVO>
	 * @exception EventException
	 */
	public List<CmpnCommVO> searchBRKGCommSAmericaForAudit(CmpnCommVO cmpnCommVO) throws EventException {
		try
		{
			if (5 < cmpnCommVO.getBlNos().length())
			{
				cmpnCommVO.setBlNos("'"+cmpnCommVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}
			if(cmpnCommVO.getMultiVvd().isEmpty()){
				cmpnCommVO.setMultiVvd(cmpnCommVO.getMultiVvd().replaceAll(" ", "").replaceAll(",", "','"));
			}
			else {
				cmpnCommVO.setMultiVvd("'"+cmpnCommVO.getMultiVvd().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}			
			//log.debug("cmpnCommVO=====================>"+cmpnCommVO.getColumnValues());
			return dbDao.searchBRKGCommSAmericaForAudit(cmpnCommVO);
		} catch(DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_0059 화면에 대한 수정/삭제 이벤트 처리<br>
	 * 
	 * @param CmpnCommVO[] cmpnCommVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBRKGCommSAmericaForAudit(CmpnCommVO[] cmpnCommVOs,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		CommonBC cbc = new CommonBCImpl();
		
		log.debug("cmpnCommVOs[0]==============================>"+cmpnCommVOs[0].getColumnValues());
		
		try
		{
			for(int i=0; i<cmpnCommVOs.length; i++)
			{
				if ( cmpnCommVOs[i].getIbflag().equals("U"))
				{
					String[] cust_cd = cbc.searchCodeList("C", "C", new String[]{cmpnCommVOs[i].getFrtFwrdCntSeq()});	//Freight Forwarder Customer Code
					String[] vndr_cd = cbc.searchCodeList("V", "C", new String[]{cmpnCommVOs[i].getVndrCntSeq()});		//Vendor Code;
					cmpnCommVOs[i].setFrtFwrdCntCd(cust_cd[0].substring(0, 2));
					cmpnCommVOs[i].setFrtFwrdSeq(cust_cd[0].substring(2));
					cmpnCommVOs[i].setVndrCntCd(vndr_cd[0].substring(0, 2));
					cmpnCommVOs[i].setVndrSeq(vndr_cd[0].substring(2));
					
					cmpnCommVOs[i].setUpdUsrId(account.getUsr_id());
					cmpnCommVOs[i].setOfcCd(cmpnCommVOs[0].getOfcCd());

					if(cmpnCommVOs[i].getCommProcStsCd().equals("CE")){
						if(cmpnCommVOs[i].getCommProcRsltRsn().equals("Commission Calculation OK!")){
							dbDao.modifyBRKGCommForAuditAgtCmpnCommCM(cmpnCommVOs[i]);
						}else{
							dbDao.modifyBRKGCommforAuditAgtCmpnComm(cmpnCommVOs[i]);
						}
					}else{
						if(cmpnCommVOs[i].getPayChk().equals("1")){
							//UPDATE 'CS-->AS'
							log.debug("pay check is 1 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!)"+cmpnCommVOs[i].getPayChk());
							
							dbDao.modifyBRKGCommForAuditAgtCmpnCommAS(cmpnCommVOs[i]);
							
						}else{
							if(cmpnCommVOs[i].getCommProcStsCd().equals("AS")){
								//AS-->CA
								dbDao.modifyBRKGCommForAuditAgtCmpnCommCA(cmpnCommVOs[i]);
							}
							dbDao.modifyBRKGCommForAuditAgtCmpnCommCM(cmpnCommVOs[i]);
						}
						//dbDao.modifyBRKGCommForAuditAgtCmpnCommCM(cmpnCommVOs[i]);
					}
					dbDao.modifyBRKGCommforAuditAgtCommCmpnBkgInfo(cmpnCommVOs[i]);
				}
				else if ( cmpnCommVOs[i].getIbflag().equals("D")) 
				{
					log.debug("111111111111111111111111111====>"+cmpnCommVOs[i].getBkgNo());
					log.debug("111111111111111111111111111====>"+cmpnCommVOs[i].getCmpnSeq());
					dbDao.removeBRKGCommforAuditAgtCmpnCommDtl(cmpnCommVOs[i]);
					dbDao.removeBRKGCommforAuditAgtCmpnChgDtl(cmpnCommVOs[i]);
					dbDao.removeBRKGCommforAuditAgtCmpnComm(cmpnCommVOs[i]);
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
	 * ESM_AGT_0059 화면에서 Brokerage Maintenance & Audit for S.America recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param CmpnCommVO[] cmpnCommVOs
	 * @exception EventException
	 */
	public void createBRKGCommSAmericaByRequest(CmpnCommVO[] cmpnCommVOs) throws EventException {

		// Commission 계산을 위한 객체 
		BRKGCalcBC brkgCalcBC = new BRKGCalcBCImpl();

		try
		{
			for(int i=0; i<cmpnCommVOs.length; i++)
			{
				if ( cmpnCommVOs[i].getIbflag().equals("U")){
					log.debug("\n\nBkgNo:"+cmpnCommVOs[i].getBkgNo()+"\n\n\n");
					brkgCalcBC.createBRKGComm(cmpnCommVOs[i].getBkgNo());
				}
			}
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	/**
	 * ESM_AGT_0060 화면에 대한 Brokerage Approval & Request 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @return List<APActualInterfaceMasterForBRKGVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceMasterForBRKGVO> searchAPActualInterfaceMasterSAmericaForBRKG(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO) throws EventException {
		try {

			if (5 < apActualInterfaceMasterForBRKGVO.getBlNos().length())
			{
				apActualInterfaceMasterForBRKGVO.setBlNos("'"+apActualInterfaceMasterForBRKGVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}
			
			return dbDao.searchAPActualInterfaceMasterForCmpnBRKG(apActualInterfaceMasterForBRKGVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * ESM_AGT_0060 화면에 대한 Brokerage Approval & Request Detail 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO
	 * @return List<APActualInterfaceDetailForBRKGVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceDetailForBRKGVO> searchAPActualInterfaceDetailSAmericaForBRKG(APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchAPActualInterfaceDetailSAmericaForBRKGVO(apActualInterfaceDetailForBRKGVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * ESM_AGT_0060 화면에 대한 Brokerage Approval & Request 대상리스트를 Interface한다.<br>
	 * @param APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createBRKGActualRequestSAmericaINFtoAP(
			APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs,
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO,
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		
		DBRowSet dRs = null;
		
		try{
			if(actualInterfaceMasterForBRKGVOs.length > 0){
				
				dRs = dbDao.searchAPActualApprovalRequestSAmericaList(actualInterfaceMasterForBRKGVO);
				
				String fwdr = null;
				String vndr_seq = null;
				String ap_ofc_cd = null;
				if(dRs.getRowCount() > 0){
					while (dRs.next())
					{
					fwdr = dRs.getString("fwdr");
					vndr_seq = dRs.getString("vndr_seq");
					ap_ofc_cd = dRs.getString("ap_ofc_cd");
					log.info("\n fwdr="+fwdr);
					log.info("\n vndr_seq = "+vndr_seq);
					log.info("\n ap_ofc_cd = "+ap_ofc_cd);
					createBRKGActualSAmericaINFtoAP(actualInterfaceMasterForBRKGVOs, actualInterfaceMasterForBRKGVO, fwdr, vndr_seq, ap_ofc_cd, account);
					}
				}
			}
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}	
	/**
	 * ESM_AGT_0018 화면에 대한 Brokerage Approval & Request 대상리스트를 Interface한다.<br>
	 * @param APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @param String fwdr
	 * @param String vndr_seq
	 * @param String ap_ofc_cd
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 * @exception EventException
	 */
	private void createBRKGActualSAmericaINFtoAP(
			APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs,
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO, 
			String fwdr, String vndr_seq, String ap_ofc_cd,
			SignOnUserAccount account) throws DAOException, EventException{
		ArrayList csrNoArray = null;
		HashMap dataHash  = null;
		String csrNo = "";
		String vndr  = "";
		String apOfc = "";
		String glDt  = "";
		String aproNm = " ";
		ComAproRqstRoutVO model = null;
		
		boolean isEPRequest = true; //Real:true, Test:false
		
		try {
			log.info("\n actualInterfaceMasterForBRKGVOs.length="+actualInterfaceMasterForBRKGVOs.length);

			////1.AP_INV_HDR에 INSERT하기
			csrNoArray = 
				dbDao.createBRKGSAmericaCSRHeader(actualInterfaceMasterForBRKGVOs, 
						actualInterfaceMasterForBRKGVO, 
						fwdr, vndr_seq, ap_ofc_cd, account);
			
			////2.AP_INV_DSTR에 INSERT하기
			for(int j=0; j<csrNoArray.size(); j++){
            	dataHash = (HashMap)csrNoArray.get(j);
            	csrNo = (String)dataHash.get("csrNo");
            	fwdr  = (String)dataHash.get("fwdr");
            	vndr  = (String)dataHash.get("vndr");
            	apOfc = (String)dataHash.get("apOfc");
            	glDt  = (String)dataHash.get("glDt");
            	dbDao.createBRKGSAmericaCSRDistributionOne(actualInterfaceMasterForBRKGVO, fwdr, csrNo, vndr, apOfc, glDt, account);
			}
			// 2007.06.11 추가
			////2.1 AP_INV_IF에 INSERT하기
			for(int j=0; j<csrNoArray.size(); j++){
            	dataHash = (HashMap)csrNoArray.get(j);
            	csrNo = (String)dataHash.get("csrNo");
            	dbDao.createBRKGAPTempTable(csrNo, aproNm);
			}
			
			log.info("\n isEPRequest = "+isEPRequest);
			////3.EP결제 송신하기
			if(isEPRequest){
				//REAL
				for(int j=0; j<csrNoArray.size(); j++){
	            	dataHash = (HashMap)csrNoArray.get(j);
	            	csrNo = (String)dataHash.get("csrNo");
	            	dbDao.createBRKGSAmericaApprovalRequesttoEPOne(actualInterfaceMasterForBRKGVO, csrNo, account);
				}
				
			}else{
				//TEST
				model = new ComAproRqstRoutVO();
//				ComAproRqstRoutVO[] route = approval.convertApprovalRoute(apActualInterfaceMasterVO.getAproStep());
				model.setAproUsrNm("BRKG_TEST");
//				log.info("n model = "+model);
				for(int j=0; j<csrNoArray.size(); j++){
	            	dataHash = (HashMap)csrNoArray.get(j);
	            	csrNo = (String)dataHash.get("csrNo");
				
	            	transferBRKGSAmericaActualINFtoAP1("C", csrNo, model);
				}
			}
		
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (EventException ev) {
			log.error("err "+ev.toString(),ev);
			throw new EventException(ev.getMessage());
		}
		
	}
	/**
     * ESM_AGT_0060 화면에 대한 인터페이스 이벤트 처리(2) : EP결재 수신 + CSR I/F<br>
     * 
     * @param  String result
     * @param  String csrNo
     * @param  ComAproRqstRoutVO model
     * @return FNS0080003Document[]
     * @throws EventException
     */
	public FNS0080003Document[] transferBRKGSAmericaActualINFtoAP1(String result,
			String csrNo, ComAproRqstRoutVO model) throws EventException {
		DBRowSet rowSet = null;						//데이터 전송을 위해 DB ResultSet을 구현한 객체		
		String aproNm = "";
		boolean isSuccess = true;	//Real:true, Test:false
		// 2007.06.04 추가
		FNS0080003Document docReq[]		= null;
		
		try {
			aproNm = model.getAproUsrNm();	//최종결재자명
			if(aproNm == null) aproNm = " ";	//최종결재자명 공백처리
			//if(result == null) result = "C";		//flag값이 NULL인 경우, 승인한것으로 간주한다
			
			if(result.equals("R")){	
				//반려시
				dbDao.modifyBRKGSAmericaApprovalRequesttoEP(csrNo);
				
			}else{	

				////5.AP 인터페이스 실행하기
				log.info("\n isSuccess = "+isSuccess);
				if(isSuccess){
					//REAL
					rowSet = dbDao.searchBRKGActualINFtoAP(csrNo);
					docReq = eaiDao.transferAtOnceAGT018ToEAIByWS(csrNo, rowSet, model); //2007.05.31 modify
				}
				log.info("\n docReq = "+docReq);
			}//if(result.equals("R")){
			
			return docReq;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * ESM_AGT_0060 화면에 대한 Brokerage Approval & Request 대상리스트를 취소한다.<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCancelBRKGSAmericaActualINFtoAP(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO,
			SignOnUserAccount account) throws EventException {
		try
		{
			dbDao.createCancelBRKGSAmericaActualINFtoAP(apActualInterfaceMasterForBRKGVO, account);
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * ESM_AGT_0060 화면의 Print 이벤트
	 * @param BRKGInfoListForPrintVO brgkInfoListForPrintVO
	 * @return List<BRKGInfoListForPrintVO>
	 * @exception EventException
	 */
	public List<BRKGInfoListForPrintVO> searchBRKGSAmericaInfoListForPrint(BRKGInfoListForPrintVO brgkInfoListForPrintVO) throws EventException {
		//searchAPActualInterfaceMasterForBRKG(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
		try {
			
			if (5 < brgkInfoListForPrintVO.getBlNos().length())
			{
				brgkInfoListForPrintVO.setBlNos("'"+brgkInfoListForPrintVO.getBlNos().replaceAll(" ", "").replaceAll(",", "','")+"'");
			}
			
			return dbDao.searchBRKGSAmericaInfoListForPrint(brgkInfoListForPrintVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	    
    }
	
	/**
	 * ESM_AGT_0060 화면에 대한 엑셀저장용 Brokerage Approval & Request 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceVO apActualInterfaceVO
	 * @return List<APActualInterfaceVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceVO> searchAPActualInterfaceMasterDetailSAmericaDownExcel(APActualInterfaceVO apActualInterfaceVO) throws EventException {
		try {
//			log.info("\n >>>>>agtAgnCommVO getExpType="+agtAgnCommVO.getExpType());
			return dbDao.searchAPActualInterfaceMasterDetailSAmericaDownExcel(apActualInterfaceVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}