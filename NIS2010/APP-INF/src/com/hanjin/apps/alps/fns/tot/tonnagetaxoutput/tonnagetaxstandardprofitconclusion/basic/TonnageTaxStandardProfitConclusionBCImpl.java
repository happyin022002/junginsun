/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionBCImpl.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.01.27 이준범 [CHM-201113807-01]
* 제목 : ALPS 톤세 시스템 기능보완 - T/TAX Recalculation
* 내용 : 1) T/Tax Recalculated 옆에 Lane이 추가 되면 추가된 선박만 재배치 할 수 있게 처리
*       2) T/Tax Recalculated 작업 후, 변경된 내역을 표시해주는 팝업창 또는 화면을 추가하여
*          변경사항 확인할 수 있게 처리
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.basic.TonnageTaxStandardProfitConclusionBC;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration.TonnageTaxStandardProfitConclusionDBDAO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.ErpIfVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.FdrStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.PortStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.StlCfmVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.VvdStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.JbSkdVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TotBsaVO;
import com.hanjin.syscommon.common.table.TotStlCfmVO;
import com.hanjin.syscommon.common.table.TotPortStlAmtVO;
import com.hanjin.syscommon.common.table.TotStlClzVO;
import com.hanjin.syscommon.common.table.TotVvdStlAmtVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-TonnageTaxOutput Business Logic Basic Command implementation<br>
 * - ALPS-TonnageTaxOutput에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0001EventResponse,TonnageTaxStandardProfitConclusionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TonnageTaxStandardProfitConclusionBCImpl extends BasicCommandSupport implements TonnageTaxStandardProfitConclusionBC {

	// Database Access Object
	private transient TonnageTaxStandardProfitConclusionDBDAO dbDao = null;
	/**
	 * TonnageTaxStandardProfitConclusionBCImpl 객체 생성<br>
	 * TonnageTaxStandardProfitConclusionDBDAO 생성한다.<br>
	 */
	public TonnageTaxStandardProfitConclusionBCImpl() {
		dbDao = new TonnageTaxStandardProfitConclusionDBDAO();
		
	}

	/**
	 * ERP I/F Inquiry 최종마감년월을 조회한다. <br>
	 * 
	 * @return List<ErpIfVO>
	 * @exception EventException
	 */
	public List<ErpIfVO> searchMaxCosingYearMm() throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0020 BC 그리드 조회DAO전> :::::::::");
			return dbDao.searchMaxCosingYearMm();
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 월별 선박당 사용율 및 톤세 관련 데이터를 조회한다. <br>
	 * 
	 * @param ErpIfVO erpIfVO
	 * @return List<ErpIfVO>
	 * @exception EventException
	 */
	public List<ErpIfVO> searchTaxableAmountListByERPInterface(ErpIfVO erpIfVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0020 BC 최근날짜 조회DAO전> :::::::::");
			return dbDao.searchTaxableAmountListByERPInterface(erpIfVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * Lane별 NRT/CAPA/BSA Allocation을 조회한다. <br>
	 * 
	 * @param BsaVO bsaVO
	 * @return List<BsaVO>
	 * @exception EventException
	 */
	public List<BsaVO> searchNrtNCapaNBsaListByLane(BsaVO bsaVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0010 BC 조회DAO전> :::::::::");
			return dbDao.searchNrtNCapaNBsaListByLane(bsaVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * (FNS_TOT_0018) POPUP ERP TAX로 I/F 결과를 조회한다. <br>
	 * 
	 * @param TotStlCfmVO totStlCfmVO
	 * @return List<TotStlCfmVO>
	 * @exception EventException
	 */
	public List<TotStlCfmVO> searchTaxableAmountStatusList(TotStlCfmVO totStlCfmVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0019 BC 조회DAO전> :::::::::");
			return dbDao.searchTaxableAmountStatusList(totStlCfmVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 *해당 년월, TRADE의 NRT, USE, DAYS 체크여부를 조회한다. <br>
	 * 
	 * @param StlCfmVO stlCfmVO
	 * @return List<StlCfmVO>
	 * @exception EventException
	 */
	public List<StlCfmVO> searchTaxableAmountConfirmationCheck(StlCfmVO stlCfmVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0011 BC 조회DAO전> :::::::::");
			return dbDao.searchTaxableAmountConfirmationCheck(stlCfmVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 해당 년월, TRADE의 배치처리된 데이터가(TOT_PORT_STL_AMT) 있는지 조회한다. <br>
	 * 
	 * @param TotPortStlAmtVO totPortStlAmtVO
	 * @return List<TotPortStlAmtVO>
	 * @exception EventException
	 */
	public List<TotPortStlAmtVO> searchPortStlAmtCheck(TotPortStlAmtVO totPortStlAmtVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0011 BC 조회DAO전> :::::::::");
			return dbDao.searchPortStlAmtCheck(totPortStlAmtVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	
	/**
	 * 해당 년월, TRADE의 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchTaxableAmountConfirmationList(VvdStlAmtVO vvdStlAmtVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0011 BC 조회DAO전> :::::::::");
			
			return dbDao.searchTaxableAmountConfirmationList(vvdStlAmtVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 체크된 NRT, USE, DAYS 데이터를 TOT_STL_CFM에 저장한다. <br>
	 * 
	 * @param StlCfmVO stlCfmVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void createTaxableAmountConfirmationMark (StlCfmVO stlCfmVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			//log.debug("::CALL::> FNS_TOT_0001 BC >진입 :::::::::");

			    stlCfmVO.setCreUsrId(signOnUserAccount.getUsr_id());
			    
			    if(stlCfmVO.getNrtYn().equals("Y")){
			    	stlCfmVO.setTongItmCd("NRT");
			    	dbDao.addTaxableAmountConfirmationMark(stlCfmVO);
			    }
			    if(stlCfmVO.getUseYn().equals("Y")){
			    	stlCfmVO.setTongItmCd("USE");
			    	dbDao.addTaxableAmountConfirmationMark(stlCfmVO);
			    }
			    if(stlCfmVO.getDayYn().equals("Y")){
			    	stlCfmVO.setTongItmCd("DYS");
			    	dbDao.addTaxableAmountConfirmationMark(stlCfmVO);
			    }
			    
				//log.debug("::CALL::> FNS_TOT_0001 BC >IB_FLAG : I 존재::::::::: : "+insertVoList.get(0).getCtrtStDt());

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}

	/**
	 * FNS_TOT_0012 Popup 상세데이터를 조회한다. <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception EventException
	 */
	public List<PortStlAmtVO> searchTaxableAmountConfirmationDetailListByVVD(PortStlAmtVO portStlAmtVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0012 BC 조회DAO전> :::::::::");
			return dbDao.searchTaxableAmountConfirmationDetailListByVVD(portStlAmtVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 수정된 데이터로 tax 재계산하여 저장한다. <br>
	 * 
	 * @param PortStlAmtVO[] portStlAmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void recalculateTaxableAmountForVoyageDay (PortStlAmtVO[] portStlAmtVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			
			log.debug("::CALL::> FNS_TOT_0012 BC >진입 :::::::::");
			//List<PortStlAmtVO> insertVoList = new ArrayList<PortStlAmtVO>();
			List<PortStlAmtVO> updateVoList = new ArrayList<PortStlAmtVO>();
			//List<PortStlAmtVO> deleteVoList = new ArrayList<PortStlAmtVO>();
			//log.debug("::CALL::> FNS_TOT_0012 BC >진입 2:::::::::"+portStlAmtVO);
			//log.debug("::CALL::> FNS_TOT_0003 BC >진입3:::::::::" +portStlAmtVO.length);
			
			for ( int i=0; i<portStlAmtVOs.length; i++ ) {
			
				if ( portStlAmtVOs[i].getIbflag().equals("U")){
					log.debug("::CALL::> FNS_TOT_0012 BC >IB_FLAG : U :::::::::");
					portStlAmtVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(portStlAmtVOs[i]);
				}
			}
			PortStlAmtVO vo = new PortStlAmtVO();

			if(updateVoList.size() > 0){
				//log.debug("::CALL::> 여기 :::::::::::::::::::::::::::::");
				for(int i = 0; i <updateVoList.size(); i++){
					//log.debug("::CALL::> 여기2 :::::::::::::::::::::::::::::");
					vo = (PortStlAmtVO) updateVoList.get(i);
					//log.debug("::CALL::> FNS_TOT_0012 DAQ > updModels :::::::::"+i);
					
					dbDao.modifyPortStlAmtByRecalculate(vo);
					dbDao.modifyVvdStlAmtByRecalculate(vo);
				}
			}
			
			
		} catch (DAOException ex) {
		//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}

	/**
	 * 수정된 데이터로 tax 재계산하여 저장한다. <br>
	 * 
	 * @param PortStlAmtVO[] portStlAmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void recalculateTaxableAmountForLoadCapa (PortStlAmtVO[] portStlAmtVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			
			log.debug("::CALL::> FNS_TOT_0012 BC >진입 :::::::::");
			//List<PortStlAmtVO> insertVoList = new ArrayList<PortStlAmtVO>();
			List<PortStlAmtVO> updateVoList = new ArrayList<PortStlAmtVO>();
			//List<PortStlAmtVO> deleteVoList = new ArrayList<PortStlAmtVO>();
			//log.debug("::CALL::> FNS_TOT_0012 BC >진입 2:::::::::"+portStlAmtVO);
			//log.debug("::CALL::> FNS_TOT_0003 BC >진입3:::::::::" +portStlAmtVO.length);
			
			for ( int i=0; i<portStlAmtVOs.length; i++ ) {
			
				if ( portStlAmtVOs[i].getIbflag().equals("U")){
					log.debug("::CALL::> FNS_TOT_0012 BC >IB_FLAG : U :::::::::");
					portStlAmtVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(portStlAmtVOs[i]);
				}
			}
			PortStlAmtVO vo = new PortStlAmtVO();

			if(updateVoList.size() > 0){
				//log.debug("::CALL::> 여기 :::::::::::::::::::::::::::::");
				for(int i = 0; i <updateVoList.size(); i++){
					//log.debug("::CALL::> 여기2 :::::::::::::::::::::::::::::");
					vo = (PortStlAmtVO) updateVoList.get(i);
					//log.debug("::CALL::> FNS_TOT_0012 DAQ > updModels :::::::::"+i);
					
					dbDao.modifyPortStlAmtByRecalculateLoadCapa(vo);
				}
				dbDao.modifyVvdStlAmtByRecalculateLoadCapa(vo);
			}
			
			
		} catch (DAOException ex) {
		//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}
	
	/**
	 * VVD 최종년월을 조회한다 <br>
	 * 
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchMaxCosingYearMmByVessel() throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0013 BC 그리드 조회DAO전> :::::::::");
			return dbDao.searchMaxCosingYearMmByVessel();
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 해당 VESSEL, 기간의  Taxable Amount 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchTaxableAmountListByVessel(VvdStlAmtVO vvdStlAmtVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0013 BC 조회DAO전> :::::::::");
			return dbDao.searchTaxableAmountListByVessel(vvdStlAmtVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * SHEET 에 LANE, TRADE, 기간에 해당하는 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchTaxableAmountListByLane(VvdStlAmtVO vvdStlAmtVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0015 BC 조회DAO전> :::::::::");
			return dbDao.searchTaxableAmountListByLane(vvdStlAmtVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 해당년월의 톤세 데이터를 조회한다. <br>
	 * 
	 * @param ErpIfVO erpIfVO
	 * @return List<ErpIfVO>
	 * @exception EventException
	 */
	public List<ErpIfVO> searchTaxableAmountList(ErpIfVO erpIfVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0018 BC 최근날짜 조회DAO전> :::::::::");
			return dbDao.searchTaxableAmountList(erpIfVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 해당년월의 톤세 관련 데이터를 재생성하여 ERP 연동처리한다. <br>
	 * 
	 * @param String stlYrmon
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String createTaxableAmountIF(String stlYrmon, SignOnUserAccount signOnUserAccount) throws EventException{

		try {
			String acctUsrId = signOnUserAccount.getUsr_id();
			// BC 객체 생성
			TonnageCreateTaxableAmountIFBackEndJob command = new TonnageCreateTaxableAmountIFBackEndJob();
			command.setStlYrmon(stlYrmon);
			command.setUsrId(acctUsrId);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String backEndJobKey = backEndJobManager.execute(command, acctUsrId, "ERP I/F");
			return backEndJobKey;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * 해당년월의 톤세 관련 현재상태를 조회한다. <br>
	 * 
	 * @param StlCfmVO stlCfmVO
	 * @return List<StlCfmVO>
	 * @exception EventException
	 */
	public List<StlCfmVO> searchTaxableAmountStatus(StlCfmVO stlCfmVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0018 BC confirm 상태조회> :::::::::");
			return dbDao.searchTaxableAmountStatus(stlCfmVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 해당년도를 마감한다. <br>
	 * 
	 * @param TotStlClzVO totStlClzVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void closeTonnageTaxStlYear (TotStlClzVO totStlClzVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			//log.debug("::CALL::> FNS_TOT_0001 BC >진입 :::::::::");
			    totStlClzVO.setCreUsrId(signOnUserAccount.getUsr_id());
		    	dbDao.createTaxClosingMark (totStlClzVO);

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		}
	}	

	/**
	 * 해당년월, data type, 선박 기준 feeder 데이터를 조회한다. <br>
	 * 
	 * @param FdrStlAmtVO fdrStlAmtVO
	 * @return List<FdrStlAmtVO>
	 * @exception EventException
	 */
	public List<FdrStlAmtVO> searchFeederTaxableAmountListByVessel(FdrStlAmtVO fdrStlAmtVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0018 BC 최근날짜 조회DAO전> :::::::::");
			return dbDao.searchFeederTaxableAmountListByVessel(fdrStlAmtVO);
		}catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT00001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 수정한 선박 기준 feeder데이터를 저장한다. <br>
	 * 
	 * @param FdrStlAmtVO[] fdrStlAmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void modifyFeederTaxableAmountByVessel(FdrStlAmtVO[] fdrStlAmtVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			log.debug("::CALL::> FNS_TOT_0016 BC >진입 :::::::::");
			List<FdrStlAmtVO> updateVoList = new ArrayList<FdrStlAmtVO>();
			log.debug("::::::::::::::::::::::::::::::::::::::::::::");
			for ( int i=0; i<fdrStlAmtVOs.length; i++ ) {
				if ( fdrStlAmtVOs[i].getIbflag().equals("U")){
					log.debug("::CALL::> FNS_TOT_0016 BC >IB_FLAG : U :::::::::");
					fdrStlAmtVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(fdrStlAmtVOs[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				log.debug("::CALL::> FNS_TOT_0016 BC >IB_FLAG : U 존재:::::::::");
				dbDao.modifyFeederTaxableAmountByVessel(updateVoList);
			}			
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}

	/**
	 * 해당년월의 feeder summary 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchFeederTaxableAmountListByMonthly(VvdStlAmtVO vvdStlAmtVO) throws EventException {
		try {
			String vvd_exist_yn = dbDao.searchVvdExistYn(vvdStlAmtVO);
			//log.debug("::CALL::> FNS_TOT_0017 BC 최근날짜 조회DAO전> :::::::::");
			return dbDao.searchFeederTaxableAmountListByMonthly(vvdStlAmtVO, vvd_exist_yn);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * 해당년월의 feeder summary 데이터를 TOT_VVD_STL_AMT로 저장한다. <br>
	 * 
	 * @param VvdStlAmtVO[] vvdStlAmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void createFeederTaxableAmount(VvdStlAmtVO[] vvdStlAmtVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			//log.debug("::CALL::> FNS_TOT_0001 BC >진입 :::::::::");
			List<VvdStlAmtVO> insertVoList = new ArrayList<VvdStlAmtVO>();
			
			for ( int i=0; i<vvdStlAmtVOs.length; i++ ) {
				if ( vvdStlAmtVOs[i].getIbflag().equals("I")){
					//log.debug("::CALL::> FNS_TOT_0001 BC >IB_FLAG : I :::::::::");
					vvdStlAmtVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(vvdStlAmtVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				//log.debug("::CALL::> FNS_TOT_0001 BC >IB_FLAG : I 존재::::::::: : "+insertVoList.get(0).getCtrtStDt());
				dbDao.addsFromFeederTaxToVVDTax(insertVoList);
			}

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * 해당기간의 배치정보를 조회한다. <br>
	 * 
	 * @param JbSkdVO jbSkdVO
	 * @param String hisType
	 * @return List<JbSkdVO>
	 * @exception EventException
	 */
	public List<JbSkdVO> searchNonFeederNFeederTaxBatchHis(JbSkdVO jbSkdVO, String hisType) throws EventException {
		try {
			log.debug("::CALL::> FNS_TOT_0021 batch 상태조회> :::::::::");
			return dbDao.searchNonFeederNFeederTaxBatchHis(jbSkdVO,hisType);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}	

	/**
	 * 해당기간의 배치 history정보를 저장한다. <br>
	 * 
	 * @param String paramStDt
	 * @param String paramEndDt
	 * @param String stDt
	 * @param String jobID
	 * @param String batItmNm
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void createNonFeederNFeederTaxBatch (String paramStDt, String paramEndDt, String stDt, String jobID, String batItmNm, SignOnUserAccount signOnUserAccount) throws EventException{
		log.debug("::CALL::> FNS_TOT_0021 BC >진입 :::::::::");
		try {
			    String usrId = signOnUserAccount.getUsr_id();
				dbDao.addNonFeederNFeederTaxBatch(paramStDt, paramEndDt ,stDt ,jobID, batItmNm,usrId);

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		}
		
	}

	/**
	 * 해당기간의 배치 history정보를 삭제한다. <br>
	 * 
	 * @param String jobID
	 * @exception EventException
	 */
	public void removeNonFeederNFeederTaxBatch (String jobID) throws EventException{
		log.debug("::CALL::> FNS_TOT_0021 BC >진입 :::::::::");
		try {
			   dbDao.removeNonFeederNFeederTaxBatch(jobID);

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		}
		
	}
	
	/**
	 * 변경된(MODIFY FLAG = 'Y') 정보를 재계산하여 저장한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void manageRecalculateBSA (TotBsaVO totBsaVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			log.debug("::CALL::> FNS_TOT_0006 BC manageRecalculateBSA >진입 :::::::::");
			//List<TotBsaVO> insertVoList = new ArrayList<TotBsaVO>();
			List<TotBsaVO> updateVoList = new ArrayList<TotBsaVO>();
			//List<TotBsaVO> deleteVoList = new ArrayList<TotBsaVO>();
			log.debug("::CALL::> FNS_TOT_0006 BC manageRecalculateBSA >진입 2:::::::::"+totBsaVO.getStlYrmon());
			log.debug("::CALL::> FNS_TOT_0006 BC manageRecalculateBSA >진입3:::::::::" );
			// tot_bsa  데이터중  modi_flg가 'Y'인 데이터 조회
			List<TotBsaVO> totBsaModiFlgVOs  = dbDao.searchRecalculateBsaForModiFlg(totBsaVO);

			//조회된 데이터로 recalculate하여 tot_port_stl_amt 테이블에 저장
			for ( int i=0; i<totBsaModiFlgVOs.size(); i++ ) {
				TotBsaVO  tbvo = totBsaModiFlgVOs.get(i);
					log.debug("::CALL::> FNS_TOT_0006 BC >IB_FLAG : U :::::::::");
					tbvo.setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(tbvo);
			}

			
			if ( updateVoList.size() > 0 ) {
				//log.debug("::CALL::> FNS_TOT_0006 BC >IB_FLAG : U 존재:::::::::");
				dbDao.modifyRecalculateBsaByPort(updateVoList);
				log.debug("::CALL::> FNS_TOT_0006 BC >IB_FLAG : U 끝:::::::::");
				
			}
            // recalculate하여 tot_port_stl_amt에 저장된 데이터를 tot_vvd_stl_amt에 vessel단위로 저장
			for ( int i=0; i<totBsaModiFlgVOs.size(); i++ ) {
				TotBsaVO  tbvvdvo = totBsaModiFlgVOs.get(i);
				List<TotVvdStlAmtVO> totVvdStlAmtVO  = dbDao.searchRecalculateBsaForVvd(tbvvdvo);
						
						if(totVvdStlAmtVO.size()>0){
							
							TotVvdStlAmtVO vo = totVvdStlAmtVO.get(0);
							vo.setUpdUsrId(signOnUserAccount.getUsr_id());
							dbDao.modifyRecalculateBsaByVvd(vo);
						}
			}			
			totBsaVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			List<TotBsaVO> totNrtModiFlgVOs  = dbDao.searchRecalculateNrtForModiFlg(totBsaVO);
			if (totNrtModiFlgVOs.size() > 0 ) {
				dbDao.modifyRecalculateNrtByPort(totNrtModiFlgVOs);
				dbDao.modifyRecalculateNrtByVvd(totNrtModiFlgVOs);
			}

			

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}
	
	/**
	 * VESSEL별 NRT 가 기입력된 사항과 상이할때, 톤세 재계산한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void manageRecalculateNrt (TotBsaVO totBsaVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			totBsaVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			List<TotBsaVO> totNrtModiFlgVOs  = dbDao.searchRecalculateNrtForModiFlg(totBsaVO);
			if (totNrtModiFlgVOs.size() > 0 ) {
				dbDao.modifyRecalculateNrtByPort(totNrtModiFlgVOs);
				dbDao.modifyRecalculateNrtByVvd(totNrtModiFlgVOs);
			}
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}	

	/**
	 * 해당년월의 일수가 0이면서, Booking 물량이 있는 데이터를 조회한다. <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception EventException
	 */
	public List<PortStlAmtVO> searchInquiryActVsDays(PortStlAmtVO portStlAmtVO) throws EventException {
		try {
			log.debug("::CALL::> FNS_TOT_0022 BC 최근날짜 조회DAO전> :::::::::");
			return dbDao.searchInquiryActVsDays(portStlAmtVO);
		}catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT00001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 운항스케쥴대비 배치후 누락 port 데이터를 조회한다. <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception EventException
	 */
	public List<PortStlAmtVO> searchExceptedVslPortSkd(PortStlAmtVO portStlAmtVO) throws EventException {
		try {
			log.debug("::CALL::> FNS_TOT_0023 BC  조회DAO전> :::::::::");
			return dbDao.searchExceptedVslPortSkd(portStlAmtVO);
		}catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT00001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * 해당월의 배치정보를 조회한다.
	 * @param JbSkdVO jbSkdVO
	 * @return List<JbSkdVO>
	 * @exception EventException
	 */
	public List<JbSkdVO> searchJbIdList(JbSkdVO jbSkdVO) throws EventException {
		try {
			return dbDao.searchJbIdList(jbSkdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}	
	
	/**
	 * NonFeederPortCalculation 정보를 저장한다. <br>
	 * 
	 * @param String stlYrmon
	 * @param String vslCd
	 * @param String creUsrId
	 * @exception EventException
	 */
	public void createNonFeederPortCalculation (String stlYrmon, String vslCd, String creUsrId) throws EventException{
		try {
				dbDao.addNonFeederPortCalculation(stlYrmon, vslCd, creUsrId);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		}
		
	}
	
	/**
	 * NonFeederVvdCalculation 정보를 저장한다. <br>
	 * 
	 * @param String stlYrmon
	 * @param String vslCd
	 * @param String creUsrId
	 * @exception EventException
	 */
	public void createNonFeederVvdCalculation (String stlYrmon, String vslCd, String creUsrId) throws EventException{
		try {
				dbDao.addNonFeederVvdCalculation(stlYrmon, vslCd ,creUsrId);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		}
		
	}
	
	/**
	 * SHEET에 해당년월의 DETAIL_DOWN 데이터를 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchFeederTaxableAmountListByDetailDown(VvdStlAmtVO vvdStlAmtVO) throws EventException {
		try {
			String vvd_exist_yn = dbDao.searchVvdExistYn(vvdStlAmtVO);
			//log.debug("::CALL::> FNS_TOT_0017 BC 최근날짜 조회DAO전> :::::::::");
			return dbDao.searchFeederTaxableAmountListByDetailDown(vvdStlAmtVO, vvd_exist_yn);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	

	/**
	 * Inquiry VSL Owner/Charter화면의 내용을 조회한다. <br>
	 * 
	 * @param VvdStlAmtVO vvdStlAmtVO
	 * @return List<VvdStlAmtVO>
	 * @exception EventException
	 */
	public List<VvdStlAmtVO> searchInquiryVslOwnerCharterList(VvdStlAmtVO vvdStlAmtVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0030 BC 조회DAO전> :::::::::");
			
			return dbDao.searchInquiryVslOwnerCharterList(vvdStlAmtVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	

	/**
	 * Inquiry VSL Owner/Charter화면의 Popup 상세데이터를 조회한다. <br>
	 * 
	 * @param PortStlAmtVO portStlAmtVO
	 * @return List<PortStlAmtVO>
	 * @exception EventException
	 */
	public List<PortStlAmtVO> searchInquiryVslOwnerCharterDetailList(PortStlAmtVO portStlAmtVO) throws EventException {
		try {
			return dbDao.searchInquiryVslOwnerCharterDetailList(portStlAmtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * 배치 실행 여부 확인 <br>
	 * 
	 * @param String pgmNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isRunningBatch(String pgmNo) throws EventException {
		ScheduleUtil su = new ScheduleUtil();
		
		try {
			return su.isRunning(pgmNo);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
	}	
}	
