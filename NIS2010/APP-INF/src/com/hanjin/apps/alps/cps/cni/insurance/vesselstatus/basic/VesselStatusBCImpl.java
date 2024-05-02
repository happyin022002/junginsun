/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselStatusBCImpl.java
*@FileTitle : Vessel Status Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.integration.VesselStatusDBDAO;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.CondSearchVesselStatusListVO;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.CustomVesselStatusVO;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.SearchInsuranceVesselDataVO;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.SearchVesselStatusListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-Vessel Status Entry Business Logic Command Interface<br>
 * - ALPS-Vessel Status Entry에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon, Seyeong
 * @see VesselStatusBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class VesselStatusBCImpl extends BasicCommandSupport implements VesselStatusBC {

	// Database Access Object
	private transient VesselStatusDBDAO dbDao = null;

	/**
	 * VesselStatusBCImpl 객체 생성<br>
	 * VesselStatusDBDAO를 생성한다.<br>
	 */
	public VesselStatusBCImpl() {
		dbDao = new VesselStatusDBDAO();
	}
	
	/**
	 * Vessel Status Entry를 조회한다.<br>
	 * 
	 * @param CondSearchVesselStatusListVO condSearchVesselStatusListVO
	 * @return List<SearchVesselStatusListVO>
	 * @exception EventException
	 */
	public List<SearchVesselStatusListVO> searchVesselStatusList(CondSearchVesselStatusListVO condSearchVesselStatusListVO) throws EventException {
		try {
			return dbDao.searchVesselStatusList(condSearchVesselStatusListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09054",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09054",new String[]{}).getMessage(), ex);
		}
				
	}
	
	/**
	 * 국가명을 조회한다
	 * 
	 * @param String flag
	 * @return String
	 * @exception EventException
	 */
	public String searchInsuranceFlag(String flag) throws EventException {
		try {
			return dbDao.searchInsuranceFlag(flag);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09057",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09057",new String[]{}).getMessage(), ex);
		}
		
	}

	/**
	 * 선박명을 조회한다
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String searchInsuranceVessel(String vslCd) throws EventException {
		try {
			return dbDao.searchInsuranceVessel(vslCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09056",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09056",new String[]{}).getMessage(), ex);
		}
		
	}

	/**
	 * Vessel Status Entry를 생성 및 변경한다.<br>
	 * 
	 * @param CustomVesselStatusVO[] customVesselStatusVOs
	 * @param String usrId 
	 * @exception EventException
	 */
	public void manageVesselStatus(CustomVesselStatusVO[] customVesselStatusVOs, String usrId) throws EventException{
		String existData = "";
		String tempData = "";
		try {
	
			List<CustomVesselStatusVO> addVoList = new ArrayList<CustomVesselStatusVO>();
			List<CustomVesselStatusVO> modifyVoList = new ArrayList<CustomVesselStatusVO>();
			List<CustomVesselStatusVO> removeVoList = new ArrayList<CustomVesselStatusVO>();
			
			if (customVesselStatusVOs != null) {
				for ( int i=0; i<customVesselStatusVOs.length; i++ ) {
					if ( customVesselStatusVOs[i].getIbflag().equals("I")){
						
						
						existData = dbDao.searchVesselStatusInfo(customVesselStatusVOs[i]);
						if(existData.equals("Y")){//있으면 에러처리
							tempData = customVesselStatusVOs[i].getVslCd()+" - "+customVesselStatusVOs[i].getInsurTpCd()+" - "+customVesselStatusVOs[i].getInsurEffDt()+" - "+customVesselStatusVOs[i].getInsurPlcyYr();
							throw new DAOException(new ErrorHandler("CNI00002",new String[]{tempData}).getMessage());
							
						}else{
							customVesselStatusVOs[i].setCreUsrId(usrId);
							addVoList.add(customVesselStatusVOs[i]);
						}
					} else if ( customVesselStatusVOs[i].getIbflag().equals("U")){
						customVesselStatusVOs[i].setUpdUsrId(usrId);
						modifyVoList.add(customVesselStatusVOs[i]);
					} else if ( customVesselStatusVOs[i].getIbflag().equals("D")){
						removeVoList.add(customVesselStatusVOs[i]);
					}
				}
				
				if(!existData.equals("Y")){
					if ( addVoList.size() > 0 ) {
						dbDao.addVesselStatuss(addVoList);
					}
				}
				
				if ( modifyVoList.size() > 0 ) {
					dbDao.modifyVesselStatuss(modifyVoList);
				}
				
				if ( removeVoList.size() > 0 ) {
					dbDao.removeVesselStatuss(removeVoList);
				}
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CNI00002",new String[]{tempData}).getMessage(), ex);
//				throw new EventException(new ErrorHandler("CNI09055",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09055",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Vessel Status의 선박 관련 항목 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return SearchInsuranceVesselDataVO
	 * @exception EventException
	 */
	public SearchInsuranceVesselDataVO searchInsuranceVesselData(String vslCd) throws EventException {
		try {
			return dbDao.searchInsuranceVesselData(vslCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09067",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09067",new String[]{}).getMessage(), ex);
		}
		
	}
	
}