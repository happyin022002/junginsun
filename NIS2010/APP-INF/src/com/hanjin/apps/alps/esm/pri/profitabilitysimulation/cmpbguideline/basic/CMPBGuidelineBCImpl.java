/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineBCImpl.java
*@FileTitle : CMPB Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.30 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration.CMPBGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.CmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltCmpbGuidelineReportVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltCmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltOriDestLocationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineAmtVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineBaseListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineCmdtVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineRoutPntVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineRoutViaVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineServiceLaneVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineSvcLaneVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltRepCmdtAndCmdtVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCmpbGlineAmtVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineBseVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineCmdtVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineCustVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineRoutPntVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineRoutViaVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineSvcLaneVO;

/**
 * NIS2010-ProfitabilitySimulation Business Logic Basic Command implementation<br>
 * - NIS2010-ProfitabilitySimulation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6001EventResponse,CMPBGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CMPBGuidelineBCImpl extends BasicCommandSupport implements CMPBGuidelineBC {

	// Database Access Object
	private transient CMPBGuidelineDBDAO dbDao = null;
	
	// Copy 시 겹치는 gline_seq
//	private int glineSeq = -1;

	/**
	 * CMPBGuidelineBCImpl 객체 생성<br>
	 * CMPBGuidelineDBDAO를 생성한다.<br>
	 */
	public CMPBGuidelineBCImpl() {
		dbDao = new CMPBGuidelineDBDAO();
	}
	
	/**
	 * Copy 시 겹치는 gline_seq<br>
	 */
//	public int getGlineSeq() {
//		return glineSeq;
//	}
	
	/**
	 * CMPB Guideline- SVC Lane(ESM_PRI_6039) 을 조회한다.<br>
	 * 
	 * @param priCmpbGlineBseVO PriCmpbGlineBseVO
	 * @return List<RsltPriCmpbGlineServiceLaneVO>
	 * @exception EventException
	 */
	public List<RsltPriCmpbGlineServiceLaneVO> searchServiceLaneList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException {
		try {
			return dbDao.searchServiceLaneList(priCmpbGlineBseVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 * CMPB Guideline Inquiry(ESM_PRI_6003)을 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO 
	 * @return List<RsltCmpbGuidelineReportVO>
	 * @exception EventException
	 */
	public List<RsltCmpbGuidelineReportVO> searchCmpbGuidelineReportList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws EventException {
		try {
			return dbDao.searchCmpbGuidelineReportList(rsltCmpbGuidelineVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 * CMPB Guideline Inquiry(ESM_PRI_6003) OFFICE COMBO 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO 
	 * @return List<PriCmpbGlineMnVO>
	 * @exception EventException
	 */
	public List<PriCmpbGlineMnVO> searchReportCreationOfficeList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws EventException {
		try {
			return dbDao.searchReportCreationOfficeList(rsltCmpbGuidelineVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 * CMPB Guideline Creation 메인 화면을 조회한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO 
	 * @return CmpbGuidelineVO
	 * @exception EventException
	 */
	public CmpbGuidelineVO searchCmpbGuidelineMain(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO) throws EventException {
		try {
			//컨테이너 vo
			CmpbGuidelineVO cmpbGuidelineVO = new CmpbGuidelineVO();
			//header List
			List<RsltDurationCreationOfficeVO> rsltDurationCreationOfficeVOList 	= new ArrayList<RsltDurationCreationOfficeVO>();
			
			rsltDurationCreationOfficeVOList 		= dbDao.searchCmpbGuidelineHdr(rsltDurationCreationOfficeVO);
			cmpbGuidelineVO.setRsltDurationCreationOfficeVOList(rsltDurationCreationOfficeVOList);
		
			return cmpbGuidelineVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 * CMPB Guideline Creation Route List를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return CmpbGuidelineVO
	 * @exception EventException
	 */
	public CmpbGuidelineVO searchCmpbGuidelineRouteList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException {
		try {
			//컨테이너 vo
			CmpbGuidelineVO cmpbGuidelineVO = new CmpbGuidelineVO();
			//base List
			List<RsltPriCmpbGlineBaseListVO> rsltPriCmpbGlineBaseList 	= new ArrayList<RsltPriCmpbGlineBaseListVO>();
			
			rsltPriCmpbGlineBaseList 		= dbDao.searchCmpbGuidelineBaseList(priCmpbGlineBseVO);
			cmpbGuidelineVO.setRsltPriCmpbGlineBaseList(rsltPriCmpbGlineBaseList);
		
			return cmpbGuidelineVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 * CMPB Guideline Creation Rate 관련 정보를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return CmpbGuidelineVO
	 * @exception EventException
	 */
	public CmpbGuidelineVO searchCmpbGuidelineRateList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException {
		try {
			//컨테이너 vo
			CmpbGuidelineVO cmpbGuidelineVO = new CmpbGuidelineVO();
			//detail List
			List<RsltPriCmpbGlineSvcLaneVO> priCmpbGlineSvcLaneVOList 			= new ArrayList<RsltPriCmpbGlineSvcLaneVO>();
			List<RsltPriCmpbGlineCmdtVO> priCmpbGlineCmdtVOList 				= new ArrayList<RsltPriCmpbGlineCmdtVO>();
			List<RsltPriCmpbGlineRoutPntVO> priOrgCmpbGlineRoutPntVOList 		= new ArrayList<RsltPriCmpbGlineRoutPntVO>();
			List<RsltPriCmpbGlineRoutViaVO> priOrgCmpbGlineRoutViaVOList 		= new ArrayList<RsltPriCmpbGlineRoutViaVO>();
			List<RsltPriCmpbGlineRoutViaVO> priDestCmpbGlineRoutViaVOList 		= new ArrayList<RsltPriCmpbGlineRoutViaVO>();
			List<RsltPriCmpbGlineRoutPntVO> priDestCmpbGlineRoutPntVOList 		= new ArrayList<RsltPriCmpbGlineRoutPntVO>();
			List<RsltPriCmpbGlineAmtVO> priCmpbGlineAmtVOList 					= new ArrayList<RsltPriCmpbGlineAmtVO>();
			
				
			priCmpbGlineSvcLaneVOList 		= dbDao.searchCmpbGuidelineServiceLane(priCmpbGlineBseVO);
			priCmpbGlineCmdtVOList 			= dbDao.searchCmpbGuidelineCommodity(priCmpbGlineBseVO);
			priOrgCmpbGlineRoutPntVOList 	= dbDao.searchCmpbGuidelineOrgRoutePoint(priCmpbGlineBseVO);
			priOrgCmpbGlineRoutViaVOList 	= dbDao.searchCmpbGuidelineOrgRouteVia(priCmpbGlineBseVO);
			priDestCmpbGlineRoutViaVOList 	= dbDao.searchCmpbGuidelineDestRouteVia(priCmpbGlineBseVO);
			priDestCmpbGlineRoutPntVOList 	= dbDao.searchCmpbGuidelineDestRoutePoint(priCmpbGlineBseVO);
			priCmpbGlineAmtVOList 			= dbDao.searchCmpbGuidelineAmount(priCmpbGlineBseVO);
			
			cmpbGuidelineVO.setPriCmpbGlineAmtVOList(priCmpbGlineAmtVOList);
			cmpbGuidelineVO.setPriCmpbGlineSvcLaneVOList(priCmpbGlineSvcLaneVOList);
			cmpbGuidelineVO.setPriCmpbGlineCmdtVOList(priCmpbGlineCmdtVOList);
			cmpbGuidelineVO.setPriOrgCmpbGlineRoutPntVOList(priOrgCmpbGlineRoutPntVOList);
			cmpbGuidelineVO.setPriOrgCmpbGlineRoutViaVOList(priOrgCmpbGlineRoutViaVOList);
			cmpbGuidelineVO.setPriDestCmpbGlineRoutViaVOList(priDestCmpbGlineRoutViaVOList);
			cmpbGuidelineVO.setPriDestCmpbGlineRoutPntVOList(priDestCmpbGlineRoutPntVOList);
			
			
			return cmpbGuidelineVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 * CMPB Guideline Creation 듀레이션 콤보 List를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return CmpbGuidelineVO
	 * @exception EventException
	 */
	public CmpbGuidelineVO searchDurationCreationOfficeList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException {
		try {
			//컨테이너 vo
			CmpbGuidelineVO cmpbGuidelineVO = new CmpbGuidelineVO();
			//header List
			List<RsltDurationCreationOfficeVO> rsltDurationCreationOfficeVOList 	= new ArrayList<RsltDurationCreationOfficeVO>();
			
			rsltDurationCreationOfficeVOList 		= dbDao.searchDurationCreationOfficeList(priCmpbGlineBseVO);
			cmpbGuidelineVO.setRsltDurationCreationOfficeVOList(rsltDurationCreationOfficeVOList);
		
			return cmpbGuidelineVO;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	
	/**
	 * CMPB Guideline Creation Route Base 관련 정보를 저장한다.<br>
	 * 
	 * @param CmpbGuidelineVO cmpbGuidelineVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageBaseCmpbGuideline(CmpbGuidelineVO cmpbGuidelineVO, SignOnUserAccount account) throws EventException {
		try {
			
			//vo
//			PriCmpbGlineMnVO priCmpbGlineMnVO 	  = cmpbGuidelineVO.getPriCmpbGlineMnVO();
//			PriCmpbGlineCustVO priCmpbGlineCustVO = cmpbGuidelineVO.getPriCmpbGlineCustVO();
			PriCmpbGlineBseVO priCmpbGlineBseVO   = cmpbGuidelineVO.getPriCmpbGlineBseVO();
//			RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO = cmpbGuidelineVO.getRsltDurationCreationOfficeVO();
			
			
			
			PriCmpbGlineBseVO[] priCmpbGlineBseVOs 				= cmpbGuidelineVO.getPriCmpbGlineBseVOs();
			PriCmpbGlineSvcLaneVO[] priCmpbGlineSvcLaneVOs 		= cmpbGuidelineVO.getPriCmpbGlineSvcLaneVOs();
			PriCmpbGlineCmdtVO[] priCmpbGlineCmdtVOs 			= cmpbGuidelineVO.getPriCmpbGlineCmdtVOs();
			PriCmpbGlineRoutPntVO[] priCmpbGlineOrgRoutPntVOs 	= cmpbGuidelineVO.getPriCmpbGlineOrgRoutPntVOs();
			PriCmpbGlineRoutPntVO[] priCmpbGlineDestRoutPntVOs 	= cmpbGuidelineVO.getPriCmpbGlineDestRoutPntVOs();
			PriCmpbGlineRoutViaVO[] priCmpbGlineOrgRoutViaVOs 	= cmpbGuidelineVO.getPriCmpbGlineOrgRoutViaVOs();
			PriCmpbGlineRoutViaVO[] priCmpbGlineDestRoutViaVOs 	= cmpbGuidelineVO.getPriCmpbGlineDestRoutViaVOs();
			PriCmpbGlineAmtVO[] priCmpbGlineAmtVOs 				= cmpbGuidelineVO.getPriCmpbGlineAmtVOs();
			
			
			
			//base
			List<PriCmpbGlineBseVO> insertVoBaseList = new ArrayList<PriCmpbGlineBseVO>();
			List<PriCmpbGlineBseVO> updateVoBaseList = new ArrayList<PriCmpbGlineBseVO>();
			List<PriCmpbGlineBseVO> deleteVoBaseList = new ArrayList<PriCmpbGlineBseVO>();
			//SvcLane
			List<PriCmpbGlineSvcLaneVO> insertSvcLaneVoList = new ArrayList<PriCmpbGlineSvcLaneVO>();
			List<PriCmpbGlineSvcLaneVO> updateSvcLaneVoList = new ArrayList<PriCmpbGlineSvcLaneVO>();
			List<PriCmpbGlineSvcLaneVO> deleteSvcLaneVoList = new ArrayList<PriCmpbGlineSvcLaneVO>();
			//Cmdt
			List<PriCmpbGlineCmdtVO> insertCmdtVoList = new ArrayList<PriCmpbGlineCmdtVO>();
			List<PriCmpbGlineCmdtVO> updateCmdtVoList = new ArrayList<PriCmpbGlineCmdtVO>();
			List<PriCmpbGlineCmdtVO> deleteCmdtVoList = new ArrayList<PriCmpbGlineCmdtVO>();
			//OrgRoutPnt
			List<PriCmpbGlineRoutPntVO> insertOrgRoutPntVoList = new ArrayList<PriCmpbGlineRoutPntVO>();
			List<PriCmpbGlineRoutPntVO> updateOrgRoutPntVoList = new ArrayList<PriCmpbGlineRoutPntVO>();
			List<PriCmpbGlineRoutPntVO> deleteOrgRoutPntVoList = new ArrayList<PriCmpbGlineRoutPntVO>();
			//OrgRoutVia
			List<PriCmpbGlineRoutViaVO> insertOrgRoutViaVoList = new ArrayList<PriCmpbGlineRoutViaVO>();
			List<PriCmpbGlineRoutViaVO> updateOrgRoutViaVoList = new ArrayList<PriCmpbGlineRoutViaVO>();
			List<PriCmpbGlineRoutViaVO> deleteOrgRoutViaVoList = new ArrayList<PriCmpbGlineRoutViaVO>();
			//DestRoutPnt
			List<PriCmpbGlineRoutPntVO> insertDestRoutPntVoList = new ArrayList<PriCmpbGlineRoutPntVO>();
			List<PriCmpbGlineRoutPntVO> updateDestRoutPntVoList = new ArrayList<PriCmpbGlineRoutPntVO>();
			List<PriCmpbGlineRoutPntVO> deleteDestRoutPntVoList = new ArrayList<PriCmpbGlineRoutPntVO>();
			//DestRoutVia
			List<PriCmpbGlineRoutViaVO> insertDestRoutViaVoList = new ArrayList<PriCmpbGlineRoutViaVO>();
			List<PriCmpbGlineRoutViaVO> updateDestRoutViaVoList = new ArrayList<PriCmpbGlineRoutViaVO>();
			List<PriCmpbGlineRoutViaVO> deleteDestRoutViaVoList = new ArrayList<PriCmpbGlineRoutViaVO>();
			//Amt
			List<PriCmpbGlineAmtVO> insertAmtVoList = new ArrayList<PriCmpbGlineAmtVO>();
			List<PriCmpbGlineAmtVO> updateAmtVoList = new ArrayList<PriCmpbGlineAmtVO>();
			List<PriCmpbGlineAmtVO> deleteAmtVoList = new ArrayList<PriCmpbGlineAmtVO>();
			
			boolean isDelete = false;
			
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
//			//헤더 시퀀스
//			int glineSeq = 1;
//			
//			//헤더
//			if(priCmpbGlineMnVO != null) {
//				//입력이면 max seq를 조회한 후 등록
//				if(priCmpbGlineBseVO.getGlineSeq() == null || "".equals(priCmpbGlineBseVO.getGlineSeq()) ) {
//					
//					/////////////////////////////기간체크///////////////////////////////////////////////
//					int chk = dbDao.checkDuration(rsltDurationCreationOfficeVO);
//					
//					if (chk > 0) {
//						throw new Exception("입력하신 기간과 중복된 기간의 자료가 이미 존재합니다.");
//					}
//					/////////////////////////////기간체크///////////////////////////////////////////////
//					
//					
//					//Main 
//					glineSeq = dbDao.searchCmpbGuidelineMaxGlineSeq(priCmpbGlineMnVO);
//					//seq setting
//					//priCmpbGlineBseVO.setGlineSeq(String.valueOf(glineSeq));
//					
//					priCmpbGlineMnVO.setGlineSeq(String.valueOf(glineSeq));
//					priCmpbGlineMnVO.setCreUsrId(account.getUsr_id());
//					priCmpbGlineMnVO.setUpdUsrId(account.getUsr_id());
//					dbDao.addCmpbGuidelineMain(priCmpbGlineMnVO);
//					
//					//Customer
//					priCmpbGlineCustVO.setGlineSeq(String.valueOf(glineSeq));
//					priCmpbGlineCustVO.setCreUsrId(account.getUsr_id());
//					priCmpbGlineCustVO.setUpdUsrId(account.getUsr_id());
//					dbDao.addCmpbGuidelineCustomer(priCmpbGlineCustVO);
//					
//					
//				}
//				//수정
//				else {
//					
//					/////////////////////////////기간체크///////////////////////////////////////////////
//					int chk = dbDao.checkDuration(rsltDurationCreationOfficeVO);
//					
//					if (chk > 0) {
//						throw new Exception("입력하신 기간과 중복된 기간의 자료가 이미 존재합니다.");
//					}
//					/////////////////////////////기간체크///////////////////////////////////////////////
//					
//					glineSeq = Integer.parseInt(priCmpbGlineMnVO.getGlineSeq());
//					
//					//Main 
//					priCmpbGlineMnVO.setCreUsrId(account.getUsr_id());
//					priCmpbGlineMnVO.setUpdUsrId(account.getUsr_id());
//					dbDao.modifyCmpbGuidelineMain(priCmpbGlineMnVO);
//					
//					//Customer
//					priCmpbGlineCustVO.setCreUsrId(account.getUsr_id());
//					priCmpbGlineCustVO.setUpdUsrId(account.getUsr_id());
//					dbDao.modifyCmpbGuidelineCustomer(priCmpbGlineCustVO);
//				}
//				
//			}
			
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			
			
			////////////////////////////base / detail 저장/////////////////////////////////////	
			//int base_seq = 1;
			
			//base 
			for (int i = 0; priCmpbGlineBseVOs != null && i < priCmpbGlineBseVOs.length; i++) {
				
				if ( priCmpbGlineBseVOs[i].getIbflag().equals("I")){
					
//					priCmpbGlineBseVOs[i].setGlineSeq(String.valueOf(glineSeq));
					//priSgBlplVOs[i].setBlplSeq(String.valueOf(blplSeq+i));
					
					priCmpbGlineBseVOs[i].setCreUsrId(account.getUsr_id());
					priCmpbGlineBseVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertVoBaseList.add(priCmpbGlineBseVOs[i]);
					
				} else if ( priCmpbGlineBseVOs[i].getIbflag().equals("U")){
					priCmpbGlineBseVOs[i].setCreUsrId(account.getUsr_id());
					priCmpbGlineBseVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoBaseList.add(priCmpbGlineBseVOs[i]);
				} else if ( priCmpbGlineBseVOs[i].getIbflag().equals("D")){
					//base별  삭제
					removeCmpbGuidelineByBase(priCmpbGlineBseVOs[i]); 
					//이미 삭제 했으므로 null 세팅
					priCmpbGlineSvcLaneVOs 		= null;    
					priCmpbGlineCmdtVOs 		= null;
					priCmpbGlineOrgRoutPntVOs 	= null;
					priCmpbGlineDestRoutPntVOs 	= null;
					priCmpbGlineOrgRoutViaVOs 	= null;
					priCmpbGlineDestRoutViaVOs 	= null;
					priCmpbGlineAmtVOs 			= null;
					
					isDelete = true;
				}
				
			}
			
			
			if(!isDelete && (priCmpbGlineSvcLaneVOs == null || priCmpbGlineSvcLaneVOs.length == 0)) {
				dbDao.removeCmpbGuidelineServiceLane(priCmpbGlineBseVO);
			}
			//svc lane
			for (int i = 0; priCmpbGlineSvcLaneVOs != null && i < priCmpbGlineSvcLaneVOs.length; i++) {
			
//				if ( priCmpbGlineSvcLaneVOs[i].getIbflag().equals("I")){
//					
//					priCmpbGlineSvcLaneVOs[i].setGlineSeq(String.valueOf(glineSeq));
//					//priSgBlplVOs[i].setBlplSeq(String.valueOf(blplSeq+i));
//					
//					priCmpbGlineSvcLaneVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineSvcLaneVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertSvcLaneVoList.add(priCmpbGlineSvcLaneVOs[i]);
//					
//				} else if ( priCmpbGlineSvcLaneVOs[i].getIbflag().equals("U")){
//					priCmpbGlineSvcLaneVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineSvcLaneVOs[i].setUpdUsrId(account.getUsr_id());
//					updateSvcLaneVoList.add(priCmpbGlineSvcLaneVOs[i]);
//				} else if ( priCmpbGlineSvcLaneVOs[i].getIbflag().equals("D")){
//					deleteSvcLaneVoList.add(priCmpbGlineSvcLaneVOs[i]);
//				}
				
				//base seq 별로 모두 삭제 후 입력
//				if(i==0 && priCmpbGlineBseVO.getGlineSeq() != null) dbDao.removeCmpbGuidelineServiceLane(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineServiceLane(priCmpbGlineBseVO);
				
//				priCmpbGlineSvcLaneVOs[i].setGlineSeq(String.valueOf(glineSeq));
				priCmpbGlineSvcLaneVOs[i].setCreUsrId(account.getUsr_id());
				priCmpbGlineSvcLaneVOs[i].setUpdUsrId(account.getUsr_id());
				
				insertSvcLaneVoList.add(priCmpbGlineSvcLaneVOs[i]);
				
			}
			
			
			if(!isDelete && (priCmpbGlineCmdtVOs == null || priCmpbGlineCmdtVOs.length == 0)) {
				dbDao.removeCmpbGuidelineCommodity(priCmpbGlineBseVO);
			}
			//Cmdt
			for (int i = 0; priCmpbGlineCmdtVOs != null && i < priCmpbGlineCmdtVOs.length; i++) {
			
//				if ( priCmpbGlineCmdtVOs[i].getIbflag().equals("I")){
//					
//					priCmpbGlineCmdtVOs[i].setGlineSeq(String.valueOf(glineSeq));
//					//priSgBlplVOs[i].setBlplSeq(String.valueOf(blplSeq+i));
//					
//					priCmpbGlineCmdtVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineCmdtVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertCmdtVoList.add(priCmpbGlineCmdtVOs[i]);
//					
//				} else if ( priCmpbGlineCmdtVOs[i].getIbflag().equals("U")){
//					priCmpbGlineCmdtVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineCmdtVOs[i].setUpdUsrId(account.getUsr_id());
//					updateCmdtVoList.add(priCmpbGlineCmdtVOs[i]);
//				} else if ( priCmpbGlineCmdtVOs[i].getIbflag().equals("D")){
//					deleteCmdtVoList.add(priCmpbGlineCmdtVOs[i]);
//				}
				
				
				//base seq 별로 모두 삭제 후 입력
//				if(i==0 && priCmpbGlineBseVO.getGlineSeq() != null) dbDao.removeCmpbGuidelineCommodity(priCmpbGlineBseVO);
				
				dbDao.removeCmpbGuidelineCommodity(priCmpbGlineBseVO);
				
//				priCmpbGlineCmdtVOs[i].setGlineSeq(String.valueOf(glineSeq));
				priCmpbGlineCmdtVOs[i].setCreUsrId(account.getUsr_id());
				priCmpbGlineCmdtVOs[i].setUpdUsrId(account.getUsr_id());
				
				insertCmdtVoList.add(priCmpbGlineCmdtVOs[i]);
				
			} 
			
			
			
			if(!isDelete && (priCmpbGlineOrgRoutPntVOs == null || priCmpbGlineOrgRoutPntVOs.length == 0)) {
				dbDao.removeCmpbGuidelineOrgRoutePoint(priCmpbGlineBseVO);
			}
			//OrgRoutPnt
			for (int i = 0; priCmpbGlineOrgRoutPntVOs != null && i < priCmpbGlineOrgRoutPntVOs.length; i++) {
			
//				if ( priCmpbGlineOrgRoutPntVOs[i].getIbflag().equals("I")){
//					
//					priCmpbGlineOrgRoutPntVOs[i].setGlineSeq(String.valueOf(glineSeq));
//					//priSgBlplVOs[i].setBlplSeq(String.valueOf(blplSeq+i));
//					
//					priCmpbGlineOrgRoutPntVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineOrgRoutPntVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertOrgRoutPntVoList.add(priCmpbGlineOrgRoutPntVOs[i]);
//					
//				} else if ( priCmpbGlineOrgRoutPntVOs[i].getIbflag().equals("U")){
//					priCmpbGlineOrgRoutPntVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineOrgRoutPntVOs[i].setUpdUsrId(account.getUsr_id());
//					updateOrgRoutPntVoList.add(priCmpbGlineOrgRoutPntVOs[i]);
//				} else if ( priCmpbGlineOrgRoutPntVOs[i].getIbflag().equals("D")){
//					deleteOrgRoutPntVoList.add(priCmpbGlineOrgRoutPntVOs[i]);
//				}
				
				
				//base seq 별로 모두 삭제 후 입력
//				if(i==0 && priCmpbGlineBseVO.getGlineSeq() != null) dbDao.removeCmpbGuidelineOrgRoutePoint(priCmpbGlineBseVO);
				
				dbDao.removeCmpbGuidelineOrgRoutePoint(priCmpbGlineBseVO);
				
//				priCmpbGlineOrgRoutPntVOs[i].setGlineSeq(String.valueOf(glineSeq));
				priCmpbGlineOrgRoutPntVOs[i].setCreUsrId(account.getUsr_id());
				priCmpbGlineOrgRoutPntVOs[i].setUpdUsrId(account.getUsr_id());
				
				insertOrgRoutPntVoList.add(priCmpbGlineOrgRoutPntVOs[i]);
				
			}
			
			
			
			if(!isDelete && (priCmpbGlineDestRoutPntVOs == null || priCmpbGlineDestRoutPntVOs.length == 0)) {
				dbDao.removeCmpbGuidelineDestRoutePoint(priCmpbGlineBseVO);
			}
			//DestRoutPnt
			for (int i = 0; priCmpbGlineDestRoutPntVOs != null && i < priCmpbGlineDestRoutPntVOs.length; i++) {
			
//				if ( priCmpbGlineDestRoutPntVOs[i].getIbflag().equals("I")){
//					
//					priCmpbGlineDestRoutPntVOs[i].setGlineSeq(String.valueOf(glineSeq));
//					//priSgBlplVOs[i].setBlplSeq(String.valueOf(blplSeq+i));
//					
//					priCmpbGlineDestRoutPntVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineDestRoutPntVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertDestRoutPntVoList.add(priCmpbGlineDestRoutPntVOs[i]);
//					
//				} else if ( priCmpbGlineDestRoutPntVOs[i].getIbflag().equals("U")){
//					priCmpbGlineDestRoutPntVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineDestRoutPntVOs[i].setUpdUsrId(account.getUsr_id());
//					updateDestRoutPntVoList.add(priCmpbGlineDestRoutPntVOs[i]);
//				} else if ( priCmpbGlineDestRoutPntVOs[i].getIbflag().equals("D")){
//					deleteDestRoutPntVoList.add(priCmpbGlineDestRoutPntVOs[i]);
//				}
				
				
				//base seq 별로 모두 삭제 후 입력
//				if(i==0 && priCmpbGlineBseVO.getGlineSeq() != null) dbDao.removeCmpbGuidelineDestRoutePoint(priCmpbGlineBseVO);
				
				dbDao.removeCmpbGuidelineDestRoutePoint(priCmpbGlineBseVO);
				
//				priCmpbGlineDestRoutPntVOs[i].setGlineSeq(String.valueOf(glineSeq));
				priCmpbGlineDestRoutPntVOs[i].setCreUsrId(account.getUsr_id());
				priCmpbGlineDestRoutPntVOs[i].setUpdUsrId(account.getUsr_id());
				
				insertDestRoutPntVoList.add(priCmpbGlineDestRoutPntVOs[i]);
				
			}
			
			
			
			if(!isDelete && (priCmpbGlineOrgRoutViaVOs == null || priCmpbGlineOrgRoutViaVOs.length == 0)) {
				dbDao.removeCmpbGuidelineOrgRouteVia(priCmpbGlineBseVO);
			}
			//OrgRoutVia
			for (int i = 0; priCmpbGlineOrgRoutViaVOs != null && i < priCmpbGlineOrgRoutViaVOs.length; i++) {
			
//				if ( priCmpbGlineOrgRoutViaVOs[i].getIbflag().equals("I")){
//					
//					priCmpbGlineOrgRoutViaVOs[i].setGlineSeq(String.valueOf(glineSeq));
//					//priSgBlplVOs[i].setBlplSeq(String.valueOf(blplSeq+i));
//					
//					priCmpbGlineOrgRoutViaVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineOrgRoutViaVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertOrgRoutViaVoList.add(priCmpbGlineOrgRoutViaVOs[i]);
//					
//				} else if ( priCmpbGlineOrgRoutViaVOs[i].getIbflag().equals("U")){
//					priCmpbGlineOrgRoutViaVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineOrgRoutViaVOs[i].setUpdUsrId(account.getUsr_id());
//					updateOrgRoutViaVoList.add(priCmpbGlineOrgRoutViaVOs[i]);
//				} else if ( priCmpbGlineOrgRoutViaVOs[i].getIbflag().equals("D")){
//					deleteOrgRoutViaVoList.add(priCmpbGlineOrgRoutViaVOs[i]);
//				}
				
				
				//base seq 별로 모두 삭제 후 입력
//				if(i==0 && priCmpbGlineBseVO.getGlineSeq() != null) dbDao.removeCmpbGuidelineOrgRouteVia(priCmpbGlineBseVO);
				
				dbDao.removeCmpbGuidelineOrgRouteVia(priCmpbGlineBseVO);
				
//				priCmpbGlineOrgRoutViaVOs[i].setGlineSeq(String.valueOf(glineSeq));
				priCmpbGlineOrgRoutViaVOs[i].setCreUsrId(account.getUsr_id());
				priCmpbGlineOrgRoutViaVOs[i].setUpdUsrId(account.getUsr_id());
				
				insertOrgRoutViaVoList.add(priCmpbGlineOrgRoutViaVOs[i]);
				
			}
			
			
			
			if(!isDelete && (priCmpbGlineDestRoutViaVOs == null || priCmpbGlineDestRoutViaVOs.length == 0)) {
				dbDao.removeCmpbGuidelineDestRouteVia(priCmpbGlineBseVO);
			}
			//DestRoutVia
			for (int i = 0; priCmpbGlineDestRoutViaVOs != null && i < priCmpbGlineDestRoutViaVOs.length; i++) {
			
//				if ( priCmpbGlineDestRoutViaVOs[i].getIbflag().equals("I")){
//					
//					priCmpbGlineDestRoutViaVOs[i].setGlineSeq(String.valueOf(glineSeq));
//					//priSgBlplVOs[i].setBlplSeq(String.valueOf(blplSeq+i));
//					
//					priCmpbGlineDestRoutViaVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineDestRoutViaVOs[i].setUpdUsrId(account.getUsr_id());
//					
//					insertDestRoutViaVoList.add(priCmpbGlineDestRoutViaVOs[i]);
//					
//				} else if ( priCmpbGlineDestRoutViaVOs[i].getIbflag().equals("U")){
//					priCmpbGlineDestRoutViaVOs[i].setCreUsrId(account.getUsr_id());
//					priCmpbGlineDestRoutViaVOs[i].setUpdUsrId(account.getUsr_id());
//					updateDestRoutViaVoList.add(priCmpbGlineDestRoutViaVOs[i]);
//				} else if ( priCmpbGlineDestRoutViaVOs[i].getIbflag().equals("D")){
//					deleteDestRoutViaVoList.add(priCmpbGlineDestRoutViaVOs[i]);
//				}
				
				
				//base seq 별로 모두 삭제 후 입력
//				if(i==0 && priCmpbGlineBseVO.getGlineSeq() != null) dbDao.removeCmpbGuidelineDestRouteVia(priCmpbGlineBseVO);
				
				dbDao.removeCmpbGuidelineDestRouteVia(priCmpbGlineBseVO);
				
//				priCmpbGlineDestRoutViaVOs[i].setGlineSeq(String.valueOf(glineSeq));
				priCmpbGlineDestRoutViaVOs[i].setCreUsrId(account.getUsr_id());
				priCmpbGlineDestRoutViaVOs[i].setUpdUsrId(account.getUsr_id());
				
				insertDestRoutViaVoList.add(priCmpbGlineDestRoutViaVOs[i]);
				
			}
			
			int cmpbSeq = dbDao.searchCmpbGuidelineMaxCmpbSeq(priCmpbGlineBseVO);
			
			
//			if(priCmpbGlineAmtVOs == null || priCmpbGlineAmtVOs.length == 0) {
//				dbDao.removeCmpbGuidelineAmount(priCmpbGlineBseVO);
//			}
			//Amt
			for (int i = 0; priCmpbGlineAmtVOs != null && i < priCmpbGlineAmtVOs.length; i++) {
			
				if ( priCmpbGlineAmtVOs[i].getIbflag().equals("I")){
					
					priCmpbGlineAmtVOs[i].setCmpbSeq(String.valueOf(cmpbSeq+i));
					priCmpbGlineAmtVOs[i].setCreUsrId(account.getUsr_id());
					priCmpbGlineAmtVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertAmtVoList.add(priCmpbGlineAmtVOs[i]);
					
				} else if ( priCmpbGlineAmtVOs[i].getIbflag().equals("U")){
					priCmpbGlineAmtVOs[i].setCreUsrId(account.getUsr_id());
					priCmpbGlineAmtVOs[i].setUpdUsrId(account.getUsr_id());
					updateAmtVoList.add(priCmpbGlineAmtVOs[i]);
				} else if ( priCmpbGlineAmtVOs[i].getIbflag().equals("D")){
					deleteAmtVoList.add(priCmpbGlineAmtVOs[i]);
				}
				
				
//				//base seq 별로 모두 삭제 후 입력
////				if(i==0 && priCmpbGlineBseVO.getGlineSeq() != null) dbDao.removeCmpbGuidelineAmount(priCmpbGlineBseVO);
//				
//				dbDao.removeCmpbGuidelineAmount(priCmpbGlineBseVO);
//				
////				priCmpbGlineAmtVOs[i].setGlineSeq(String.valueOf(glineSeq));
//				priCmpbGlineAmtVOs[i].setCreUsrId(account.getUsr_id());
//				priCmpbGlineAmtVOs[i].setUpdUsrId(account.getUsr_id());
//				
//				insertAmtVoList.add(priCmpbGlineAmtVOs[i]);
				
			}
			
			
			if (deleteSvcLaneVoList.size() > 0) {
				dbDao.removeCmpbGuidelineServiceLaneS(deleteSvcLaneVoList);
			}
			if (deleteCmdtVoList.size() > 0) {
				dbDao.removeCmpbGuidelineCommodityS(deleteCmdtVoList);
			}
			if (deleteOrgRoutPntVoList.size() > 0) {
				dbDao.removeCmpbGuidelineRouetPointS(deleteOrgRoutPntVoList);
			}
			if (deleteDestRoutPntVoList.size() > 0) {
				dbDao.removeCmpbGuidelineRouetPointS(deleteDestRoutPntVoList);
			}
			if (deleteOrgRoutViaVoList.size() > 0) {
				dbDao.removeCmpbGuidelineRouteViaS(deleteOrgRoutViaVoList);
			}
			if (deleteDestRoutViaVoList.size() > 0) {
				dbDao.removeCmpbGuidelineRouteViaS(deleteDestRoutViaVoList);
			}
			if (deleteAmtVoList.size() > 0) {
				dbDao.removeCmpbGuidelineAmountS(deleteAmtVoList);
			}
			if (deleteVoBaseList.size() > 0) {
				dbDao.modifyCmpbGuidelineBaseS(deleteVoBaseList);
			}
			
			
			if (insertVoBaseList.size() > 0) {
				dbDao.addCmpbGuidelineBaseS(insertVoBaseList);
			}
			if (insertSvcLaneVoList.size() > 0) {
				dbDao.addCmpbGuidelineServiceLaneS(insertSvcLaneVoList);
			}
			if (insertCmdtVoList.size() > 0) {
				dbDao.addCmpbGuidelineCommodityS(insertCmdtVoList);
			}
			if (insertOrgRoutPntVoList.size() > 0) {
				dbDao.addCmpbGuidelineRouetPointS(insertOrgRoutPntVoList);
			}
			if (insertDestRoutPntVoList.size() > 0) {
				dbDao.addCmpbGuidelineRouetPointS(insertDestRoutPntVoList);
			}
			if (insertOrgRoutViaVoList.size() > 0) {
				dbDao.addCmpbGuidelineRouteViaS(insertOrgRoutViaVoList);
			}
			if (insertDestRoutViaVoList.size() > 0) {
				dbDao.addCmpbGuidelineRouteViaS(insertDestRoutViaVoList);
			}
			if (insertAmtVoList.size() > 0) {
				dbDao.addCmpbGuidelineAmountS(insertAmtVoList);
			}
			
			
			if (updateVoBaseList.size() > 0) {
				dbDao.modifyCmpbGuidelineBaseS(updateVoBaseList);
			}
			if (updateSvcLaneVoList.size() > 0) {
				dbDao.modifyCmpbGuidelineServiceLaneS(updateSvcLaneVoList);
			}
			if (updateCmdtVoList.size() > 0) {
				dbDao.modifyCmpbGuidelineCommodityS(updateCmdtVoList);
			}
			if (updateOrgRoutPntVoList.size() > 0) {
				dbDao.modifyCmpbGuidelineRoutePointS(updateOrgRoutPntVoList);
			}
			if (updateDestRoutPntVoList.size() > 0) {
				dbDao.modifyCmpbGuidelineRoutePointS(updateDestRoutPntVoList);
			}
			if (updateOrgRoutViaVoList.size() > 0) {
				dbDao.modifyCmpbGuidelineRouteViaS(updateOrgRoutViaVoList);
			}
			if (updateDestRoutViaVoList.size() > 0) {
				dbDao.modifyCmpbGuidelineRouteViaS(updateDestRoutViaVoList);
			}
			if (updateAmtVoList.size() > 0) {
				dbDao.modifyCmpbGuidelineAmountS(updateAmtVoList);
			}

			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	
	/**
	 * CMPB Guideline Creation 메인 관련 정보를 저장한다.<br>
	 * 
	 * @param cmpbGuidelineVO CmpbGuidelineVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMainCmpbGuideline(CmpbGuidelineVO cmpbGuidelineVO, SignOnUserAccount account) throws EventException {
		try {
			
			//vo
			PriCmpbGlineMnVO priCmpbGlineMnVO 	  = cmpbGuidelineVO.getPriCmpbGlineMnVO();
			PriCmpbGlineCustVO priCmpbGlineCustVO = cmpbGuidelineVO.getPriCmpbGlineCustVO();
			RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO = cmpbGuidelineVO.getRsltDurationCreationOfficeVO();
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			//헤더 시퀀스
			int glineSeq = 1;
			
			//헤더
			if(priCmpbGlineMnVO != null) {
				//입력이면 max seq를 조회한 후 등록
				if(priCmpbGlineMnVO.getGlineSeq() == null || "".equals(priCmpbGlineMnVO.getGlineSeq()) ) {
					
					/////////////////////////////기간체크///////////////////////////////////////////////
					int chk = dbDao.searchCheckDuration(rsltDurationCreationOfficeVO);
					
					if (chk > 0) {
						throw new EventException(new ErrorHandler("PRI08018").getMessage());
					}
					/////////////////////////////기간체크///////////////////////////////////////////////
					
					
					//Main 
					glineSeq = dbDao.searchCmpbGuidelineMaxGlineSeq(priCmpbGlineMnVO);
					//seq setting
					//priCmpbGlineBseVO.setGlineSeq(String.valueOf(glineSeq));
					
					priCmpbGlineMnVO.setGlineSeq(String.valueOf(glineSeq));
					priCmpbGlineMnVO.setCreUsrId(account.getUsr_id());
					priCmpbGlineMnVO.setUpdUsrId(account.getUsr_id());
					dbDao.addCmpbGuidelineMain(priCmpbGlineMnVO);
					
					//Customer
					priCmpbGlineCustVO.setGlineSeq(String.valueOf(glineSeq));
					priCmpbGlineCustVO.setCreUsrId(account.getUsr_id());
					priCmpbGlineCustVO.setUpdUsrId(account.getUsr_id());
					dbDao.addCmpbGuidelineCustomer(priCmpbGlineCustVO);
					
					
				}
				//수정
				else {
					
					/////////////////////////////기간체크///////////////////////////////////////////////
					int chk = dbDao.searchCheckDuration(rsltDurationCreationOfficeVO);
					
					if (chk > 0) {
						throw new EventException(new ErrorHandler("PRI08018").getMessage());
					}
					/////////////////////////////기간체크///////////////////////////////////////////////
					
					glineSeq = Integer.parseInt(priCmpbGlineMnVO.getGlineSeq());
					
					//Main 
					priCmpbGlineMnVO.setCreUsrId(account.getUsr_id());
					priCmpbGlineMnVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyCmpbGuidelineMain(priCmpbGlineMnVO);
					
					//Customer
					priCmpbGlineCustVO.setCreUsrId(account.getUsr_id());
					priCmpbGlineCustVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyCmpbGuidelineCustomer(priCmpbGlineCustVO);
				}
				
			}
			
			////////////////////////////헤더 저장/////////////////////////////////////////////
			
			
		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}	
		
	}
	
	
	
	/**
	 * CMPB Guideline Creation  RATE 관련 테이블 저장한다.<br>
	 * 
	 * @param CmpbGuidelineVO cmpbGuidelineVO 
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageRateCmpbGuideline(CmpbGuidelineVO cmpbGuidelineVO, SignOnUserAccount account) throws EventException {
		try {
			
			PriCmpbGlineBseVO priCmpbGlineBseVO   = cmpbGuidelineVO.getPriCmpbGlineBseVO();
			PriCmpbGlineAmtVO[] priCmpbGlineAmtVOs 	= cmpbGuidelineVO.getPriCmpbGlineAmtVOs();
			
			
			//Amt
			List<PriCmpbGlineAmtVO> insertAmtVoList = new ArrayList<PriCmpbGlineAmtVO>();
			List<PriCmpbGlineAmtVO> updateAmtVoList = new ArrayList<PriCmpbGlineAmtVO>();
			List<PriCmpbGlineAmtVO> deleteAmtVoList = new ArrayList<PriCmpbGlineAmtVO>();
			
			//CMPB 시퀀스
			int cmpbSeq = dbDao.searchCmpbGuidelineMaxCmpbSeq(priCmpbGlineBseVO);
			
			//Amt
			for (int i = 0; priCmpbGlineAmtVOs != null && i < priCmpbGlineAmtVOs.length; i++) {
				
				if ( priCmpbGlineAmtVOs[i].getIbflag().equals("I")){
					
					priCmpbGlineAmtVOs[i].setCmpbSeq(String.valueOf(cmpbSeq+i));
					priCmpbGlineAmtVOs[i].setCreUsrId(account.getUsr_id());
					priCmpbGlineAmtVOs[i].setUpdUsrId(account.getUsr_id());
					
					insertAmtVoList.add(priCmpbGlineAmtVOs[i]);
					
				} else if ( priCmpbGlineAmtVOs[i].getIbflag().equals("U")){
					priCmpbGlineAmtVOs[i].setCreUsrId(account.getUsr_id());
					priCmpbGlineAmtVOs[i].setUpdUsrId(account.getUsr_id());
					updateAmtVoList.add(priCmpbGlineAmtVOs[i]);
				} else if ( priCmpbGlineAmtVOs[i].getIbflag().equals("D")){
					deleteAmtVoList.add(priCmpbGlineAmtVOs[i]);
				}
				
			}
			
			if (deleteAmtVoList.size() > 0) {
				dbDao.removeCmpbGuidelineAmountS(deleteAmtVoList);
			}
			if (insertAmtVoList.size() > 0) {
				dbDao.addCmpbGuidelineAmountS(insertAmtVoList);
			}
			if (updateAmtVoList.size() > 0) {
				dbDao.modifyCmpbGuidelineAmountS(updateAmtVoList);
			}
			
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	
	/**
	 * CMPB Guideline Creation 전체를 삭제한다<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @exception EventException
	 */
	public void removeCmpbGuideline(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException{
		try {
			
			PriCmpbGlineMnVO priCmpbGlineMnVO = new PriCmpbGlineMnVO();
			
			priCmpbGlineMnVO.setSvcScpCd(priCmpbGlineBseVO.getSvcScpCd());
			priCmpbGlineMnVO.setCreOfcCd(priCmpbGlineBseVO.getCreOfcCd());
			priCmpbGlineMnVO.setGlineSeq(priCmpbGlineBseVO.getGlineSeq());
			//base seq delete
			priCmpbGlineBseVO.setBseSeq("");
			
			//헤더 별 모든 데이터를 삭제한다
			if(priCmpbGlineBseVO != null) {
				
				dbDao.removeCmpbGuidelineServiceLane(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineCommodity(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineRoutePoint(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineRouteVia(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineAmount(priCmpbGlineBseVO);
				
//				dbDao.removeCmpbGroupLocationDetail(priCmpbGlineBseVO);
//				dbDao.removeCmpbGroupLocation(priCmpbGlineBseVO);
//				dbDao.removeCmpbGroupCommodityDetail(priCmpbGlineBseVO);
//				dbDao.removeCmpbGroupCommodity(priCmpbGlineBseVO);
				
				dbDao.removeCmpbGuidelineBase(priCmpbGlineMnVO);
				dbDao.removeCmpbGuidelineCustomer(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineMain(priCmpbGlineMnVO);
				
			}	
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	/**
	 * CMPB Guideline Creation Base SEQ 별 삭제한다.<br>
	 * 
	 * @param priCmpbGlineBseVO PriCmpbGlineBseVO
	 * @exception EventException
	 */
	public void removeCmpbGuidelineByBase(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException{
		try {
			
			//base 별 모든 데이터를 삭제한다
			if(priCmpbGlineBseVO != null) {
				
				dbDao.removeCmpbGuidelineServiceLane(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineCommodity(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineRoutePoint(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineRouteVia(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineAmount(priCmpbGlineBseVO);
				dbDao.removeCmpbGuidelineBase(priCmpbGlineBseVO);
				
			}	
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 * 사용자가 Guideline을 컨폼한다<br>
	 * 
	 * @param priCmpbGlineMnVO PriCmpbGlineMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmCmpbGuideline(PriCmpbGlineMnVO priCmpbGlineMnVO, SignOnUserAccount account) throws EventException{
		try {
			priCmpbGlineMnVO.setCfmFlg("Y");
			priCmpbGlineMnVO.setCfmUsrId(account.getUsr_id());
			priCmpbGlineMnVO.setCreUsrId(account.getUsr_id());
			priCmpbGlineMnVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyConfirmCmpbGuideline(priCmpbGlineMnVO);
			//mapping 테이블 delete
//			dbDao.removeCmpbGuidelineMapg(priCmpbGlineMnVO);
			//mapping 테이블 insert
			dbDao.addCmpbGuidelineMapg(priCmpbGlineMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	/**
	 * 사용자가 Guideline을 컨폼 cancel한다<br>
	 * 
	 * @param priCmpbGlineMnVO PriCmpbGlineMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmCancelCmpbGuideline(PriCmpbGlineMnVO priCmpbGlineMnVO, SignOnUserAccount account) throws EventException{
		try {
			priCmpbGlineMnVO.setCfmFlg("N");
			priCmpbGlineMnVO.setCfmUsrId(account.getUsr_id());
			priCmpbGlineMnVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyConfirmCmpbGuideline(priCmpbGlineMnVO);
			//mapping 테이블 delete
			dbDao.removeCmpbGuidelineMapg(priCmpbGlineMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	
	/**
	 * 헤더 별 copy 등록한다<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyCmpbGuideline(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO, SignOnUserAccount account) throws EventException{
		try {
			
			/////////////////////////////기간체크///////////////////////////////////////////////
			int seq = -1;
			//Duration check
			seq = dbDao.searchCheckDurationAddCopy(rsltDurationCreationOfficeVO);
			
			if (seq != -1) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}
			/////////////////////////////기간체크///////////////////////////////////////////////
			
			
			//헤더 별 모든 데이터를 복사 후 등록한다
			//gline_seq를 SC에서 미리 조회하여 세팅
			if(rsltDurationCreationOfficeVO != null) {
				
				rsltDurationCreationOfficeVO.setCreUsrId(account.getUsr_id());
				rsltDurationCreationOfficeVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyCmpbGuidelineMain(rsltDurationCreationOfficeVO);
				dbDao.addCopyCmpbGuidelineCustomer(rsltDurationCreationOfficeVO);
				dbDao.addCopyCmpbGuidelineBase(rsltDurationCreationOfficeVO);
				dbDao.addCopyCmpbGuidelineServiceLane(rsltDurationCreationOfficeVO);
				dbDao.addCopyCmpbGuidelineCommodity(rsltDurationCreationOfficeVO);
				dbDao.addCopyCmpbGuidelineRoutePoint(rsltDurationCreationOfficeVO);
				dbDao.addCopyCmpbGuidelineRouteVia(rsltDurationCreationOfficeVO);
				dbDao.addCopyCmpbGuidelineAmount(rsltDurationCreationOfficeVO);
				
			}	
			
		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}		

	}
	
	
	
	/**
	 * Max Gline_seq를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineMnVO priCmpbGlineMnVO 
	 * @return int
	 * @exception EventException
	 */
	public int searchCmpbGuidelineMaxGlineSeq(PriCmpbGlineMnVO priCmpbGlineMnVO) throws EventException{
		try {

			int seq = dbDao.searchCmpbGuidelineMaxGlineSeq(priCmpbGlineMnVO);
			return seq;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 *  CMPB Guideline EXCEL DOWN(ESM_PRI_6001)을 조회한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO 
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO) throws EventException {
		try {
			return dbDao.searchRateListVerticalExcel(rsltDurationCreationOfficeVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 * CMPB Guideline LOAD EXCEL(ESM_PRI_6001)을 저장한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @param rsltRtListVerticalExcelVOs RsltRtListVerticalExcelVO[]
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void uploadRateExcelVertical(PriCmpbGlineBseVO priCmpbGlineBseVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) 
	throws EventException {
		
		List<PriCmpbGlineBseVO> bseVoList = new ArrayList<PriCmpbGlineBseVO>();
		List<PriCmpbGlineSvcLaneVO> svcLaneVoList = new ArrayList<PriCmpbGlineSvcLaneVO>();
		List<PriCmpbGlineCmdtVO> cmdtVoList = new ArrayList<PriCmpbGlineCmdtVO>();
		List<PriCmpbGlineRoutPntVO> pntVoList = new ArrayList<PriCmpbGlineRoutPntVO>();
		List<PriCmpbGlineRoutViaVO> viaVoList = new ArrayList<PriCmpbGlineRoutViaVO>();
		List<PriCmpbGlineAmtVO> amtVoList = new ArrayList<PriCmpbGlineAmtVO>();
		
		try {
			int nextBseSeq = dbDao.searchCmpbGuidelineMaxBaseSeq(priCmpbGlineBseVO);
			nextBseSeq = nextBseSeq-1;
			
//			int nextSvcLaneSeq = 0;
			int nextCmdtSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;
			
			String strSvcScpCd = priCmpbGlineBseVO.getSvcScpCd();
			String strCreOfcCd = priCmpbGlineBseVO.getCreOfcCd();
			String strGlineSeq = priCmpbGlineBseVO.getGlineSeq();
			String strPrsCustTpCd = priCmpbGlineBseVO.getPrsCustTpCd();
			
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();
			
			
			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				RsltRtListVerticalExcelVO row = rsltRtListVerticalExcelVOs[i];
				
				String strRoutDpSeq = row.getRoutDpSeq();
				
				String strVslSlanCd = row.getVslSlanCd();
				String strCmdtCd = row.getPrcCmdtDefCd();
				
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				
				String strPerTypeCd = row.getRatUtCd();
				String strCgoTypeCd = row.getPrcCgoTpCd();
				String strRateAmt = row.getCmpbAmt();
				
				String strMqcRngFmQty = row.getMqcRngFmQty();
				String strMqcRngToQty = row.getMqcRngToQty();
				
				
				
				//bse
				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					
					nextBseSeq++;
					
					PriCmpbGlineBseVO bse = new PriCmpbGlineBseVO();
					bse.setSvcScpCd(strSvcScpCd);
					bse.setCreOfcCd(strCreOfcCd);
					bse.setGlineSeq(strGlineSeq);
					bse.setPrsCustTpCd(strPrsCustTpCd);
					bse.setBseSeq(String.valueOf(nextBseSeq));
					bse.setCreUsrId(strCreUsrId);
					bse.setUpdUsrId(strUpdUsrId);
					
//					bseVoList.add(bse);
					
					dbDao.addCmpbGuidelineBase(bse);
					
					//svc lane이 없으면 전체 다 등록
					if (isSvcLaneEmpty(strRoutDpSeq, rsltRtListVerticalExcelVOs)) {
						dbDao.addCmpbGuidelineServiceLaneAll(bse);
					}
					
				}
				
				//svc lane
				if (strVslSlanCd != null && !"".equals(strVslSlanCd)) {
					
					PriCmpbGlineSvcLaneVO svcLane = new PriCmpbGlineSvcLaneVO();
					svcLane.setSvcScpCd(strSvcScpCd);
					svcLane.setCreOfcCd(strCreOfcCd);
					svcLane.setGlineSeq(strGlineSeq);
					svcLane.setPrsCustTpCd(strPrsCustTpCd);
					svcLane.setBseSeq(String.valueOf(nextBseSeq));
					svcLane.setVslSlanCd(strVslSlanCd);
					svcLane.setCreUsrId(strCreUsrId);
					svcLane.setUpdUsrId(strUpdUsrId);
					
					svcLaneVoList.add(svcLane);
					
				} 

				//cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;
					
					String cmdtTpCd = "";
					
					if(strCmdtCd.length() == 6) cmdtTpCd = "C";
					else if(strCmdtCd.length() == 5) cmdtTpCd = "G";
					else if(strCmdtCd.length() == 4) cmdtTpCd = "R";
					
					PriCmpbGlineCmdtVO cmdt = new PriCmpbGlineCmdtVO();
					cmdt.setSvcScpCd(strSvcScpCd);
					cmdt.setCreOfcCd(strCreOfcCd);
					cmdt.setGlineSeq(strGlineSeq);
					cmdt.setPrsCustTpCd(strPrsCustTpCd);
					cmdt.setBseSeq(String.valueOf(nextBseSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);
					
					cmdtVoList.add(cmdt);
				}
				
				//pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = "";
					
					if(strOrgPntCd.length() == 5) locTpCd = "L";
					else if(strOrgPntCd.length() == 4) locTpCd = "G";
					else if(strOrgPntCd.length() == 3) locTpCd = "R";
					else if(strOrgPntCd.length() == 2) locTpCd = "C";
					
					PriCmpbGlineRoutPntVO pnt = new PriCmpbGlineRoutPntVO();
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCreOfcCd(strCreOfcCd);
					pnt.setGlineSeq(strGlineSeq);
					pnt.setPrsCustTpCd(strPrsCustTpCd);
					pnt.setBseSeq(String.valueOf(nextBseSeq));
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					
					pntVoList.add(pnt);
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					nextRoutViaSeq++;
					
					String locTpCd = "";
					
					if(strOrgViaCd.length() == 5) locTpCd = "L";
					else if(strOrgViaCd.length() == 4) locTpCd = "G";
					else if(strOrgViaCd.length() == 3) locTpCd = "R";
					else if(strOrgViaCd.length() == 2) locTpCd = "C";
					
					PriCmpbGlineRoutViaVO via = new PriCmpbGlineRoutViaVO();
					via.setSvcScpCd(strSvcScpCd);
					via.setCreOfcCd(strCreOfcCd);
					via.setGlineSeq(strGlineSeq);
					via.setPrsCustTpCd(strPrsCustTpCd);
					via.setBseSeq(String.valueOf(nextBseSeq));
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setOrgDestTpCd("O");
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strOrgViaCd);
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);
					
					viaVoList.add(via);
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					nextRoutViaSeq++;
					
					String locTpCd = "";
					
					if(strDestViaCd.length() == 5) locTpCd = "L";
					else if(strDestViaCd.length() == 4) locTpCd = "G";
					else if(strDestViaCd.length() == 3) locTpCd = "R";
					else if(strDestViaCd.length() == 2) locTpCd = "C";
					
					PriCmpbGlineRoutViaVO via = new PriCmpbGlineRoutViaVO();
					via.setSvcScpCd(strSvcScpCd);
					via.setCreOfcCd(strCreOfcCd);
					via.setGlineSeq(strGlineSeq);
					via.setPrsCustTpCd(strPrsCustTpCd);
					via.setBseSeq(String.valueOf(nextBseSeq));
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setOrgDestTpCd("D");
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strDestViaCd);
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);
					
					viaVoList.add(via);
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;
					
					String locTpCd = "";
					
					if(strDestPntCd.length() == 5) locTpCd = "L";
					else if(strDestPntCd.length() == 4) locTpCd = "G";
					else if(strDestPntCd.length() == 3) locTpCd = "R";
					else if(strDestPntCd.length() == 2) locTpCd = "C";
					
					PriCmpbGlineRoutPntVO pnt = new PriCmpbGlineRoutPntVO();
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCreOfcCd(strCreOfcCd);
					pnt.setGlineSeq(strGlineSeq);
					pnt.setPrsCustTpCd(strPrsCustTpCd);
					pnt.setBseSeq(String.valueOf(nextBseSeq));
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					
					pntVoList.add(pnt);
				}
				
				if (strRateAmt != null && !"".equals(strRateAmt)) {
					nextRtSeq++;
					
					PriCmpbGlineAmtVO rt = new PriCmpbGlineAmtVO();
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCreOfcCd(strCreOfcCd);
					rt.setGlineSeq(strGlineSeq);
					rt.setPrsCustTpCd(strPrsCustTpCd);
					rt.setBseSeq(String.valueOf(nextBseSeq));
					rt.setCmpbSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd(strPerTypeCd);
					rt.setPrcCgoTpCd(strCgoTypeCd);
					rt.setCurrCd("USD");
					rt.setCmpbAmt(strRateAmt);
					rt.setMqcRngFmQty(strMqcRngFmQty);
					rt.setMqcRngToQty(strMqcRngToQty);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);
					
					amtVoList.add(rt);
					
				}
			}
			
			if (bseVoList.size() > 0) {
				dbDao.addCmpbGuidelineBaseS(bseVoList);
			}
			if (svcLaneVoList.size() > 0) {
				dbDao.addCmpbGuidelineServiceLaneS(svcLaneVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addCmpbGuidelineCommodityS(cmdtVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addCmpbGuidelineRouetPointS(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addCmpbGuidelineRouteViaS(viaVoList);
			}
			if (amtVoList.size() > 0) {
				dbDao.addCmpbGuidelineAmountS(amtVoList);
			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 * EXCEL 저장시 BSE SEQ 별로 SVC LANE 이 하나라도 있는지 체크한다.<br>
	 * 
	 * @param String paramRoutDpSeq
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return boolean isSvcLaneEmpty 
	 * @exception EventException
	 */
	private boolean isSvcLaneEmpty(String paramRoutDpSeq, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) 
	throws EventException {
		
		try {
			
			//svc lane이 bse seq 별로 모두 없는 지 여부 플래그
			boolean isSvcLaneEmpty = true; 
			
			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				RsltRtListVerticalExcelVO row = rsltRtListVerticalExcelVOs[i];
				
				String strRoutDpSeq = row.getRoutDpSeq();
				String strVslSlanCd = row.getVslSlanCd();
				
				
				//bse seq가 param 과 같은 경우 만 체크
				if (paramRoutDpSeq.equals(strRoutDpSeq)) {
					
					if (strVslSlanCd != null && !"".equals(strVslSlanCd)) {
						isSvcLaneEmpty = false;
					}
				}
			}	
			
			return isSvcLaneEmpty;
			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}
	
	
	/**
	 * CMPB Guideline LOAD EXCEL(ESM_PRI_6001)을 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @param rsltRtListVerticalExcelVOs RsltRtListVerticalExcelVO[] 
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriCmpbGlineBseVO priCmpbGlineBseVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) 
		throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
		
		try {
			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				
				RsltRtListVerticalExcelVO row = rsltRtListVerticalExcelVOs[i];
				
				String strVslSlanCd = row.getVslSlanCd();
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				
				//svc lane
				if (strVslSlanCd != null && !"".equals(strVslSlanCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setSvcScpCd(priCmpbGlineBseVO.getSvcScpCd());
					paramVO.setCd(strVslSlanCd);
					
					RsltCdListVO cdVO = dbDao.searchCheckSvcLaneExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strVslSlanCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("vsl_slan_cd");
						
						rslt.add(cdVO);
					}
				}
				
				//cmdt
				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setSvcScpCd(priCmpbGlineBseVO.getSvcScpCd());
					paramVO.setCreOfcCd(priCmpbGlineBseVO.getCreOfcCd());
					paramVO.setGlineSeq(priCmpbGlineBseVO.getGlineSeq());
					paramVO.setCd(strCmdtCd);
					
					RsltCdListVO cdVO = dbDao.searchCheckCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");
						
						rslt.add(cdVO);
					}
				}

				//pnt origin
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setSvcScpCd(priCmpbGlineBseVO.getSvcScpCd());
					paramVO.setCreOfcCd(priCmpbGlineBseVO.getCreOfcCd());
					paramVO.setGlineSeq(priCmpbGlineBseVO.getGlineSeq());
					paramVO.setCd(strOrgPntCd);
					
					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_pnt_loc_def_cd");
						
						rslt.add(cdVO);
					}
				}
				
				//
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setSvcScpCd(priCmpbGlineBseVO.getSvcScpCd());
					paramVO.setCreOfcCd(priCmpbGlineBseVO.getCreOfcCd());
					paramVO.setGlineSeq(priCmpbGlineBseVO.getGlineSeq());
					paramVO.setCd(strOrgViaCd);
					
					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_via_port_def_cd");
						
						rslt.add(cdVO);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setSvcScpCd(priCmpbGlineBseVO.getSvcScpCd());
					paramVO.setCreOfcCd(priCmpbGlineBseVO.getCreOfcCd());
					paramVO.setGlineSeq(priCmpbGlineBseVO.getGlineSeq());
					paramVO.setCd(strDestViaCd);
					
					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_via_port_def_cd");
						
						rslt.add(cdVO);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setSvcScpCd(priCmpbGlineBseVO.getSvcScpCd());
					paramVO.setCreOfcCd(priCmpbGlineBseVO.getCreOfcCd());
					paramVO.setGlineSeq(priCmpbGlineBseVO.getGlineSeq());
					paramVO.setCd(strDestPntCd);
					
					RsltCdListVO cdVO = dbDao.searchCheckLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_pnt_loc_def_cd");
						
						rslt.add(cdVO);
					}
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

		
		return rslt;
	}

	
	/**
	 * CMPB Guideline Inquiry(ESM_PRI_6003) Origin, Dest Location 정보를 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO 
	 * @return List<RsltRepCmdtAndCmdtVO>
	 * @exception EventException
	 */
	public List<RsltRepCmdtAndCmdtVO> searchCommodityList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws EventException {
		try {
			return dbDao.searchCommodityList(rsltCmpbGuidelineVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}	
	
	/**
	 * CMPB Guideline Inquiry(ESM_PRI_6003) Origin, Dest Location 정보를 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO 
	 * @return List<RsltOriDestLocationVO>
	 * @exception EventException
	 */
	public List<RsltOriDestLocationVO> searchLocationList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws EventException {
		try {
			return dbDao.searchLocationList(rsltCmpbGuidelineVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}

	}	
	
}