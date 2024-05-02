/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITCharterIOBunkerRegisterBCImpl.java
*@FileTitle : BunkerDataManagement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.26
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.26 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration.TCharterIOBunkerRegisterDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration.TCharterIOBunkerRegisterEAIDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.CustomBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchIdVslCdByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchVvdByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - ALPS-TimeCharterInOutAccounting에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Yoon-Tae, Jung
 * @see TCharterIOBunkerRegisterBC,TCharterIOBunkerRegisterBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.5
 */

public class TCharterIOBunkerRegisterBCImpl extends BasicCommandSupport implements TCharterIOBunkerRegisterBC {

	// Database Access Object
	private transient TCharterIOBunkerRegisterDBDAO dbDao = null;

	/**
	 * ITCharterIOBunkerRegisterBCImpl 객체 생성<br>
	 * ITCharterIOBunkerRegisterDBDAO를 생성한다.<br>
	 */
	public TCharterIOBunkerRegisterBCImpl() {
		dbDao = new TCharterIOBunkerRegisterDBDAO();
	}
	
	/**
	 * Bunker 정보를 가져온다<br>
	 * 
	 * @param searchBunkerVO SearchBunkerVO
	 * @return List<SearchBunkerVO>
	 * @exception EventException
	 */
	public List<SearchBunkerVO> searchBunkerList(SearchBunkerVO searchBunkerVO) throws EventException {
		try {
			//validationCheck(화면 필수 입력 값)
			//block 2017.05.17
			//validationCheck(searchBunkerVO);		
			
			return dbDao.searchBunkerList(searchBunkerVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01202",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01202",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker 화면에 대한 멀티 이벤트 처리(입력/수정/삭제)<br>
	 * 
	 * @param customBunkerVOs CustomBunkerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageBunker(CustomBunkerVO[] customBunkerVOs, String usrId) throws EventException{
		try {
			List<CustomBunkerVO> addVoList 	  = new ArrayList<CustomBunkerVO>();
			List<CustomBunkerVO> modifyVoList = new ArrayList<CustomBunkerVO>();
			List<CustomBunkerVO> removeVoList = new ArrayList<CustomBunkerVO>();

			for(int i=0; i<customBunkerVOs.length; i++) {
				if(customBunkerVOs[i].getIbflag().equals("I")) {
					customBunkerVOs[i].setCreUsrId(usrId);
					customBunkerVOs[i].setUpdUsrId(usrId);
					addVoList.add(customBunkerVOs[i]);
					
				} else if(customBunkerVOs[i].getIbflag().equals("U")) {
					customBunkerVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(customBunkerVOs[i]);
					
				} else if(customBunkerVOs[i].getIbflag().equals("D")) {
					removeVoList.add(customBunkerVOs[i]);
				}
			}
			
			//데이타 입력
			if(addVoList.size() > 0) {
				dbDao.addBunkers(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyBunkers(modifyVoList);
			}
			
			//데이타 삭제
			if(removeVoList.size() > 0) {
				dbDao.removeBunkers(removeVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * 계약번호에 해당하는 vslCd 가져오기
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchIdVslCdByBunkerVO>
	 * @exception EventException
	 */
	public List<SearchIdVslCdByBunkerVO> searchIdVslCdListByBunker(String fletCtrtNo) throws EventException {
		try {
			return dbDao.searchIdVslCdListByBunker(fletCtrtNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * vslCd와 bnkDt에 해당하는 항차 가져오기<br>
	 * 
	 * @param vslCd String
	 * @param bunkerDt String
	 * @return List<SearchVvdByBunkerVO>
	 * @exception EventException
	 */
	public List<SearchVvdByBunkerVO> searchVvdListByBunker(String vslCd, String bunkerDt) throws EventException {
		try {
			return dbDao.searchVvdListByBunker(vslCd, bunkerDt);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01205",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01205",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Location Code 가져오기<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCdByBunker(String locCd) throws EventException {
		try {
			return dbDao.searchCheckLocCdByBunker(locCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01206",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01206",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker 테이블에서 계약 테이블에 업데이트 할 정보가져오기<br>
	 * 
	 * @param fletCtrtNo String 
	 * @param bnkYrmon String 
	 * @return List<ContractByBunkerVO>
	 * @exception EventException
	 */
	public List<ContractByBunkerVO> searchContractByBunker(String fletCtrtNo, String bnkYrmon) throws EventException {
		try {
			bnkYrmon = JSPUtil.removeCharacter(bnkYrmon,"-");
			
			return dbDao.searchContractByBunker(fletCtrtNo, bnkYrmon);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker 테이블에서 Interface 할 정보가져오기<br>
	 * 
	 * @param bnkYrmon String 
	 * @return List<SearchBunkerInterfaceVO>
	 * @exception EventException
	 */
	public List<SearchBunkerInterfaceVO> searchBunkerInterfaceList(String bnkYrmon) throws EventException {
		try {
			return dbDao.searchBunkerInterfaceList(bnkYrmon);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01202",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01202",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * BOD, BOR Monthly Interface 화면에서 EAI 데이타 전송<br>
	 * 
	 * @param bnkYrmon String
	 * @param usrId String 
	 * @exception EventException
	 */
	public void sendBunkerData(String bnkYrmon, String usrId) throws EventException {
		try {
			List<SearchBunkerInterfaceVO> searchBunkerInterfaceVO = null;
			
			searchBunkerInterfaceVO = dbDao.searchBunkerDataList(bnkYrmon);
			
			dbDao.modifyBunkerDatas(bnkYrmon, usrId);
							
			TCharterIOBunkerRegisterEAIDAO eaiDbDao = new TCharterIOBunkerRegisterEAIDAO();
			eaiDbDao.sendBunkerData(searchBunkerInterfaceVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01203",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01203",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker Data Management 화면에서 필수입력 항목 체크<br>
	 * 
	 * @param searchBunkerVO SearchBunkerVO 
	 * @exception EventException
	 */
	private void validationCheck(SearchBunkerVO searchBunkerVO) throws EventException {
		
		String msgCode = "";
		
		try {
			if(   searchBunkerVO.getBnkYrmon().equals("")
			   || searchBunkerVO.getFletCtrtNo().equals("")
			   || searchBunkerVO.getVslCd().equals("")) {
				
				if(searchBunkerVO.getBnkYrmon().equals("")) {
					msgCode = "FMS01024";
				} else if(searchBunkerVO.getFletCtrtNo().equals("")) {
					msgCode = "FMS01025";
				} else if(searchBunkerVO.getVslCd().equals("")) {
					msgCode = "FMS01097";
				}
				
				throw new EventException(new ErrorHandler(msgCode,new String[]{}).getMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 기 작성된 BOD / BOR Data / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @param aproFlg String
	 * @return List<SearchBunkerListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchBunkerListByPaymentSlipVO> searchBunkerListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd, String aproFlg) throws EventException {
		try {
			return dbDao.searchBunkerListByPaymentSlip(fletCtrtNo, ofcCd, csrCurrCd, aproFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01407",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01407",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 전표 생성 완료 후 Invoice 테이블을 업데이트한다<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param slpSerNo String
	 * @exception EventException
	 */
	public void modifyPaymentSlipBunkers(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, String slpSerNo) throws EventException{
		try {
			List<CustomPamCsulSlpVO> modifyVoList = new ArrayList<CustomPamCsulSlpVO>();

			for(int i=0; i<customPamCsulSlpVOs.length; i++) {
				if(   customPamCsulSlpVOs[i].getIbflag().equals("I")
				   && !customPamCsulSlpVOs[i].getBnkSeq().equals("")
				   && !customPamCsulSlpVOs[i].getFletCtrtNo().equals("")) {
					
					customPamCsulSlpVOs[i].setSlpFuncCd(customPamConsultationVOs[0].getSlpTp());
					customPamCsulSlpVOs[i].setSlpOfcCd(customPamConsultationVOs[0].getSlpOfcCd());
					customPamCsulSlpVOs[i].setSlpSerNo(slpSerNo);
					customPamCsulSlpVOs[i].setUpdUsrId(customPamConsultationVOs[0].getUpdUsrId());
					
					modifyVoList.add(customPamCsulSlpVOs[i]);
					
				}
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyPaymentSlipBunkers(modifyVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01401",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * 용선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipApprovalCancelBunker(String csrNo, String usrId) throws EventException{
		try {
			
			//데이타 수정
			dbDao.modifySlipApprovalCancelBunker( csrNo , usrId );
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * 대선 전표가 생성되면 정산 테이블에 관련 항목들에 대해서 수정한다<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifySubletRevenueSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException{
		try {
			List<CustomCsulSlpVO> modifyRevSlips = new ArrayList<CustomCsulSlpVO>();

			for ( int i=0; i<customCsulSlpVOs .length; i++ ) {
				if(customCsulSlpVOs[i].getAcctCd().equals("954111")) {
					modifyRevSlips.add(customCsulSlpVOs[i]);
				}
			}
	
			if ( modifyRevSlips.size() > 0 ) {
				dbDao.modifySubletRevenueSlips(modifyRevSlips);
			}
	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01411",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01411",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * AP, AR 대선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyApArSlipApprovalCancelBunker(String csrNo, String usrId) throws EventException{
		try {
			
			if(csrNo.substring(0,3).equals("20T")) {
				//AR 대선에 대한 Bunker 전표 정보를  Null 로 업데이트된다
				dbDao.modifyArSlipApprovalCancelBunker( csrNo , usrId );
			} else {
				//AP 대선에 대한 Bunker 전표 정보를  Null 로 업데이트된다
				dbDao.modifyApSlipApprovalCancelBunker( csrNo , usrId );
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01419",new String[]{}).getMessage(), de);
		}
	}
}