/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BRKGAuditBCImpl.java
*@FileTitle : Brokerage Maintenance & Approval Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtApPayInvVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration.BRKGAuditDBDAO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration.BRKGAuditEAIDAO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.AGTBRKGRateInfoVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceDetailForBRKGVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceMasterForBRKGVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailBasicbyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailChargebyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailHistorybyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrint2VO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoListForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BrkgCommVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BrogApPayInvVO;
import com.clt.apps.opus.esm.agt.agtcalculation.AGTCalculationSC;
import com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBCImpl;
import com.clt.apps.opus.esm.agt.common.basic.CommonBC;
import com.clt.apps.opus.esm.agt.common.basic.CommonBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.irep.enis.FNS0080003Document;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;

/**
 * OPUS-AGT Business Logic Basic Command implementation<br>
 * - OPUS-AGT handling Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see AGTAuditDAO 
 * @since J2EE 1.4
 */
public class BRKGAuditBCImpl extends BasicCommandSupport implements BRKGAuditBC {
	
	// Database Access Object
	private transient BRKGAuditDBDAO dbDao = null;
	
	// EAI Interface Object
	private transient BRKGAuditEAIDAO eaiDao = null;

	/**
	 * BRKGAuditBCImpl Object creation<br>
	 * BRKGAuditDBDAO, BRKGAuditEAIDAO creation<br>
	 */
	public BRKGAuditBCImpl(){
		dbDao = new BRKGAuditDBDAO();
		eaiDao = new BRKGAuditEAIDAO();
	}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_0013 retrieve event process<br>
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
	 * ESM_AGT_0013 Brokerage Commission recalculate event process<br>
	 * 
	 * @param BrkgCommVO[] brkgCommVOs
	 * @exception EventException
	 */
	public void createBRKGCommByRequest(BrkgCommVO[] brkgCommVOs) throws EventException {

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
	 * ESM_AGT_0013 Agreement Commission recalculate event process<br>
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
	 * multi event process<br>
	 * ESM_AGT_0013 multi event process<br>
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
	 * ESM_AGT_0014) Brokerage Commission Basic Information retrieve event process
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
	 * (ESM_AGT_0014) Charge Detail Information retrieve event process<br>
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
	 * (ESM_AGT_0014) Brokerage Commission History Detail Information retrieve event process<br>
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
	 * ESM_AGT_0014 rate Information retrieve event process<br>
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
	 * ESM_AGT_0018 Brokerage Approval & Request Information retrieve event process<br>
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
	 * ESM_AGT_0018 Brokerage Approval & Request Detail Information retrieve event process<br>
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
	 * ESM_AGT_0018 Brokerage Approval & Request Information retrieve event process for Excel<br>
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
	 * ESM_AGT_0018 Brokerage Approval & Request Information Cancel event process<br>
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
	 * ESM_AGT_0018 Print event process
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
     * ESM_AGT_0018 CSR Print event process
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
	 * ESM_AGT_0018 CSR Print event process
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
	 * ESM_AGT_0018 Brokerage Approval & Request List Interface event process<br>
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
	 * ESM_AGT_0018 Brokerage Approval & Request List Interface event process<br>
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

			////1.AP_INV_HDR INSERT
			csrNoArray = 
				dbDao.createBRKGCSRHeader(actualInterfaceMasterForBRKGVOs, 
						actualInterfaceMasterForBRKGVO, 
						fwdr, vndr_seq, ap_ofc_cd, account);
			
			////2.AP_INV_DSTR INSERT
			for(int j=0; j<csrNoArray.size(); j++){
            	dataHash = (HashMap)csrNoArray.get(j);
            	csrNo = (String)dataHash.get("csrNo");
            	fwdr  = (String)dataHash.get("fwdr");
            	vndr  = (String)dataHash.get("vndr");
            	apOfc = (String)dataHash.get("apOfc");
            	glDt  = (String)dataHash.get("glDt");
            	//dbDao.createBRKGCSRDistributionOne(actualInterfaceMasterForBRKGVO, fwdr, csrNo, vndr, apOfc, glDt, account);
			}

			////2.1 AP_INV_IF INSERT
			for(int j=0; j<csrNoArray.size(); j++){
            	dataHash = (HashMap)csrNoArray.get(j);
            	csrNo = (String)dataHash.get("csrNo");
            	//dbDao.createBRKGAPTempTable(csrNo, aproNm);
			}
			
			log.info("\n isEPRequest = "+isEPRequest);
			////3.EP Approval transmit
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
			
						
			//4.AP_INV_IF INSERT
			//dbDao.createBRKGAPTempTable(event, csrNoArray);
			
			//5.AP Interface Implement
			//rowSet = dbDao.searchBRKGActualINFtoAP(csrNoArray);
			//if(isSuccess){
			//	eaiHash = eaiDao.transferAtOnceAGT018ToEAIByWS(rowSet);
			//	dbDao.createBRKGAcutalINFFromAPbyMSG(csrNoArray, eaiHash);
			//}else{
			//	eaiHash = new HashMap();
			//	eaiHash.put("isSuccess", "Y");
			//}
			//6.AP Interface result AGT_AGN_COMM UPDATE
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
     * ESM_AGT_018 Interface Event Process : EP Approval receive + CSR I/F<br>
     * 
     * @param  String result
     * @param  String csrNo
     * @param  ComAproRqstRoutVO model
     * @return FNS0080003Document[]
     * @throws EventException
     */
	public FNS0080003Document[] transferBRKGActualINFtoAP1(String result,
			String csrNo, ComAproRqstRoutVO model) throws EventException {
		DBRowSet rowSet = null;						
		String aproNm = "";
		boolean isSuccess = true;	//Real:true, Test:false

		FNS0080003Document docReq[]		= null;
		
		try {
			aproNm = model.getAproUsrNm();	// Final Approval user name
			if(aproNm == null) aproNm = " ";	// null
			
			if(result.equals("R")){	
				//return
				dbDao.modifyBRKGApprovalRequesttoEP(csrNo);
				
			}else{	

				////5.AP interface implement
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
     * ESM_AGT_018 Interface event process : EP Approval receive + CSR I/F<br>
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
			
			aproNm = model.getAproUsrNm();	//Final Approval user name
			if(aproNm == null) aproNm = " ";	//putting NULL to Final Approval user name
			
			if(!result.equals("R")){	
				//Approved
				////4.AP_INV_IF INSERT
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
				
				////6.AP interface result AGT_BROG_COMM UPDATE
				isSuccess = ((String)eaiHash.get("isSuccess") == "Y"?true:false);
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
	 * (ESM_AGT_018) BRKG Commission AP Interface List retrieve event process<br>
	 * 
	 * @param BrogApPayInvVO brogApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchBrogApPayInv(APActualInterfaceMasterForBRKGVO aPActualInterfaceMasterForBRKGVO, String usrId) throws EventException {
		log.debug("\n\n BCim.searchBrogApPayInv \n");
		try {
			return dbDao.searchBrogApPayInv(aPActualInterfaceMasterForBRKGVO, usrId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
		}
	}
	
	/**
	 * (ESM_AGT_018) BRKG Commission AP Interface List retrieve event process<br>
	 * 
	 * @param BrogApPayInvVO brogApPayInvVO, ApPayInvVO apPayInvVO	
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchBrogApPayInvDtl(APActualInterfaceMasterForBRKGVO aPActualInterfaceMasterForBRKGVO) throws EventException { 
		log.debug("\n\n BCim.searchBrogApPayInvDtl \n");
		try {
			return dbDao.searchBrogApPayInvDtl(aPActualInterfaceMasterForBRKGVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
		}
	}
	
	/**
	 * (ESM_AGT_018) Agent Commission commission status code update<br>
	 * 
	 * @param String string , SignOnUserAccount account	
	 * @exception EventException
	 */
	public void modifyBrogCommProcStsCd( ApPayInvVO apPayInvVO) throws EventException {
	log.debug("\n\n BCim.searchAgtApPayInvDtl \n");
	try {
		dbDao.modifyBrogCommProcStsCd(apPayInvVO);
	} catch (DAOException ex) {
		throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
	} catch (Exception ex) {
		throw new EventException(new ErrorHandler("", new String[]{"Invoice Creation"}).getMessage(),ex);
	}
}
	
	
}