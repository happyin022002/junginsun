/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceBCImpl.java
*@FileTitle : Insurance Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.insurance.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.cps.cni.insurance.insurance.integration.InsuranceDBDAO;
import com.clt.apps.opus.cps.cni.insurance.insurance.vo.ContainerPremiumVO;
import com.clt.apps.opus.cps.cni.insurance.insurance.vo.CustomInsuranceVO;
import com.clt.apps.opus.cps.cni.insurance.insurance.vo.CustomPremiumInstallmentVO;
import com.clt.apps.opus.cps.cni.insurance.insurance.vo.CustomPremiumVO;
import com.clt.apps.opus.cps.cni.insurance.insurance.vo.SearchInsuranceVO;
import com.clt.apps.opus.cps.cni.insurance.insurance.vo.SearchPremiumInstallmentListVO;
import com.clt.apps.opus.cps.cni.insurance.insurance.vo.SearchPremiumVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-Insurance Business Logic Command Interface<br>
 * - OPUS-Insurance에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon, Seyeong
 * @see InsuranceBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class InsuranceBCImpl extends BasicCommandSupport implements InsuranceBC {

	// Database Access Object
	private transient InsuranceDBDAO dbDao = null;

	/**
	 * InsuranceBCImpl 객체 생성<br>
	 * InsuranceDBDAO를 생성한다.<br>
	 */
	public InsuranceBCImpl() {
		dbDao = new InsuranceDBDAO();
	}
	
	/**
	 * Main Insurance를 조회한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @return SearchInsuranceVO
	 * @exception EventException
	 */
	public SearchInsuranceVO searchInsurance(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws EventException {
		try {
			return dbDao.searchInsurance(insurTpCd, insurPlcyYr, insurClmPtyNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09050",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09050",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Main Insurance를 생성 및 변경한다.<br>
	 * 
	 * @param CustomInsuranceVO customInsuranceVO
	 * @param String usrId 
	 * @exception EventException
	 */
	public void manageInsurance(CustomInsuranceVO customInsuranceVO, String usrId) throws EventException{
		try {

			SearchInsuranceVO searchInsuranceVO = dbDao.searchInsurance(customInsuranceVO.getInsurTpCd(), customInsuranceVO.getInsurPlcyYr(), customInsuranceVO.getInsurClmPtyNo());
			
			if ( searchInsuranceVO == null){//Insert
				customInsuranceVO.setCreUsrId(usrId);
				dbDao.addInsurance(customInsuranceVO);
			} else {//Update
				customInsuranceVO.setUpdUsrId(usrId);
				dbDao.modifyInsurance(customInsuranceVO);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09051",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09051",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Premium를 생성 및 변경한다.<br>
	 * 
	 * @param CustomPremiumVO customPremiumVO
	 * @param CustomPremiumInstallmentVO[] customPremiumInstallmentVOs
	 * @param String usrId 
	 * @exception EventException
	 */
	public void managePremium(CustomPremiumVO customPremiumVO, CustomPremiumInstallmentVO[] customPremiumInstallmentVOs, String usrId) throws EventException{
		try {
	
			//Premium의 Insurer 정보를 넣어줌
			customPremiumVO.setInsurClmPtyNo(customPremiumVO.getInsurClmPtyPrmNo());
			
			SearchPremiumVO searchPremiumVO = dbDao.searchPremium(customPremiumVO.getInsurTpCd(), customPremiumVO.getInsurPlcyYr(), customPremiumVO.getInsurClmPtyNo(), customPremiumVO.getInsurPrmTpCd());
			
			if ( searchPremiumVO == null){//Insert
				
				SearchInsuranceVO searchInsuranceVO = dbDao.searchInsurance(customPremiumVO.getInsurTpCd(), customPremiumVO.getInsurPlcyYr(), customPremiumVO.getInsurClmPtyNo());

				//Main Terms가 입력되어 있는지 확인해서 없는 경우 에러 메시지 조회
				if (searchInsuranceVO == null) {
					throw new EventException(new ErrorHandler("CNI09066",new String[]{}).getMessage());
				}
				
				customPremiumVO.setCreUsrId(usrId);
				dbDao.addPremium(customPremiumVO);
			} else {//Update
				customPremiumVO.setUpdUsrId(usrId);
				dbDao.modifyPremium(customPremiumVO);
			}
			
			List<CustomPremiumInstallmentVO> addVoList = new ArrayList<CustomPremiumInstallmentVO>();
			List<CustomPremiumInstallmentVO> modifyVoList = new ArrayList<CustomPremiumInstallmentVO>();
			List<CustomPremiumInstallmentVO> removeVoList = new ArrayList<CustomPremiumInstallmentVO>();
			
			if (customPremiumInstallmentVOs != null) {
				for ( int i=0; i<customPremiumInstallmentVOs.length; i++ ) {
					if ( customPremiumInstallmentVOs[i].getIbflag().equals("I")){
						customPremiumInstallmentVOs[i].setCreUsrId(usrId);
						addVoList.add(customPremiumInstallmentVOs[i]);
					} else if ( customPremiumInstallmentVOs[i].getIbflag().equals("U")){
						customPremiumInstallmentVOs[i].setUpdUsrId(usrId);
						modifyVoList.add(customPremiumInstallmentVOs[i]);
					} else if ( customPremiumInstallmentVOs[i].getIbflag().equals("D")){
						removeVoList.add(customPremiumInstallmentVOs[i]);
					}
				}
				
				if ( addVoList.size() > 0 ) {
					dbDao.addPremiumInstallments(addVoList);
				}
				
				if ( modifyVoList.size() > 0 ) {
					dbDao.modifyPremiumInstallments(modifyVoList);
				}
				
				if ( removeVoList.size() > 0 ) {
					dbDao.removePremiumInstallments(removeVoList);
				}
			}
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09053",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09053",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Premium를 조회한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @return ContainerPremiumVO
	 * @exception EventException
	 */
	public ContainerPremiumVO searchPremium(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws EventException {

		try {
			ContainerPremiumVO containerPremiumVO = new ContainerPremiumVO();

			SearchPremiumVO searchPremiumVO =  dbDao.searchPremium(insurTpCd, insurPlcyYr, insurClmPtyNo, insurPrmTpCd);
			containerPremiumVO.setSearchPremiumVO(searchPremiumVO);
			List<SearchPremiumInstallmentListVO> searchPremiumInstallmentListVO =  dbDao.searchPremiumInstallmentList(insurTpCd, insurPlcyYr, insurClmPtyNo, insurPrmTpCd);
			containerPremiumVO.setSearchPremiumInstallmentListVO(searchPremiumInstallmentListVO);
			
			return containerPremiumVO;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09052",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09052",new String[]{}).getMessage(), ex);
		}
		
	}

	/**
	 * Insurance 보험 등록 되어있는지 검사한다
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckInsurance(String insurTpCd, String insurPlcyYr) throws EventException {
		try {
			return dbDao.searchCheckInsurance(insurTpCd, insurPlcyYr);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09064",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09064",new String[]{}).getMessage(), ex);
		}
		
	}

	/**
	 * Insurance 삭제한다
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @exception EventException
	 */
	public void removeInsurance(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws EventException {
		try {
			dbDao.removeInsurancePremiumInstall(insurTpCd, insurPlcyYr, insurClmPtyNo);
			dbDao.removeInsurancePremium(insurTpCd, insurPlcyYr, insurClmPtyNo);
			dbDao.removeInsuranceDetail(insurTpCd, insurPlcyYr, insurClmPtyNo);
			dbDao.removeInsuranceContract(insurTpCd, insurPlcyYr, insurClmPtyNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09060",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09060",new String[]{}).getMessage(), ex);
		}
		
	}

	/**
	 * Insurance Premium 삭제한다
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @exception EventException
	 */
	public void removePremium(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws EventException {
		try {
			dbDao.removePremiumInstall(insurTpCd, insurPlcyYr, insurClmPtyNo, insurPrmTpCd);
			dbDao.removePremium(insurTpCd, insurPlcyYr, insurClmPtyNo, insurPrmTpCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09061",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09061",new String[]{}).getMessage(), ex);
		}
		
	}

	/**
	 * Insurance 보험 Premium 등록 되어있는지 검사한다
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurPrmTpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckPremium(String insurTpCd, String insurPlcyYr, String insurPrmTpCd) throws EventException {
		try {
			return dbDao.searchCheckPremium(insurTpCd, insurPlcyYr, insurPrmTpCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09065",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09065",new String[]{}).getMessage(), ex);
		}
		
	}
	
}