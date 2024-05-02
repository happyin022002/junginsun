/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterStandardPrimeCostBCImpl.java
*@FileTitle : TEU Range Target
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.15 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration.TCharterStandardPrimeCostDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomMktRtVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomStndHirVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomTeuRngVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchHireBaseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchStandardHireBaseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchStandardHireListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchTeuRangeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-TimeCharterInOutFleetManagement Business Logic Basic Command implementation<br>
 * - NIS2010-TimeCharterInOutFleetManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Woo-Seok
 * @see Esm_Fms_0062EventResponse,TCharterStandardPrimeCostBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TCharterStandardPrimeCostBCImpl extends BasicCommandSupport implements TCharterStandardPrimeCostBC {

	// Database Access Object
	private transient TCharterStandardPrimeCostDBDAO dbDao = null;

	/**
	 * TCharterStandardPrimeCostBCImpl 객체 생성<br>
	 * TCharterStandardPrimeCostDBDAO를 생성한다.<br>
	 */
	public TCharterStandardPrimeCostBCImpl() {
		dbDao = new TCharterStandardPrimeCostDBDAO();
	}
	
	/**
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 조회한다<br>
	 * 
	 * @param rngYr String
	 * @return List<SearchTeuRangeListVO>
	 * @exception EventException
	 */
	public List<SearchTeuRangeListVO> searchTeuRangeList(String rngYr) throws EventException {
		try {
			return dbDao.searchTeuRangeList(rngYr);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01800",new String[]{}).getMessage(), ex);
		} catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01800",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 변경한다<br>
	 * 
	 * @param customTeuRngVOs CustomTeuRngVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageTeuRange(CustomTeuRngVO[] customTeuRngVOs, String usrId) throws EventException{
		try {
			List<CustomTeuRngVO> addVoList = new ArrayList<CustomTeuRngVO>();
			List<CustomTeuRngVO> modifyVoList = new ArrayList<CustomTeuRngVO>();
			List<CustomTeuRngVO> remofeVoList = new ArrayList<CustomTeuRngVO>();
			for ( int i=0; i<customTeuRngVOs .length; i++ ) {
				if ( customTeuRngVOs[i].getIbflag().equals("I")){
					customTeuRngVOs[i].setCreUsrId(usrId);
					customTeuRngVOs[i].setUpdUsrId(usrId);
					
					if (customTeuRngVOs[i].getHirAplyFlg().equals("1")) {
						customTeuRngVOs[i].setHirAplyFlg("Y");
					} else {
						customTeuRngVOs[i].setHirAplyFlg("N");
					}

					if (customTeuRngVOs[i].getMktRtAplyFlg().equals("1")) {
						customTeuRngVOs[i].setMktRtAplyFlg("Y");
					} else {
						customTeuRngVOs[i].setMktRtAplyFlg("N");
					}
					
					addVoList.add(customTeuRngVOs[i]);
				} else if ( customTeuRngVOs[i].getIbflag().equals("U")){
					customTeuRngVOs[i].setUpdUsrId(usrId);
					
					if (customTeuRngVOs[i].getHirAplyFlg().equals("1")) {
						customTeuRngVOs[i].setHirAplyFlg("Y");
					} else {
						customTeuRngVOs[i].setHirAplyFlg("N");
					}

					if (customTeuRngVOs[i].getMktRtAplyFlg().equals("1")) {
						customTeuRngVOs[i].setMktRtAplyFlg("Y");
					} else {
						customTeuRngVOs[i].setMktRtAplyFlg("N");
					}
					
					modifyVoList.add(customTeuRngVOs[i]);
				} else if ( customTeuRngVOs[i].getIbflag().equals("D")){
					customTeuRngVOs[i].setUpdUsrId(usrId);
					remofeVoList.add(customTeuRngVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addTeuRngs(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyTeuRngs(modifyVoList);
			}

			if ( remofeVoList.size() > 0 ) {
				dbDao.modifyTeuRngDeleteFlags(remofeVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01801",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01801",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 전체 삭제한다<br>
	 * 
	 * @param rngYr String
	 * @exception EventException
	 */
	public void removeAllTeuRange(String rngYr) throws EventException{
		try {
			dbDao.removeAllTeuRange(rngYr);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01804",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01804",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Hire 설정 중, 현 Market rate를 반영할 Hire의 범위를 조회한다<br>
	 * 
	 * @param mktRtYrmon String
	 * @return List<SearchHireBaseListVO>
	 * @exception EventException
	 */
	public List<SearchHireBaseListVO> searchHireBaseList(String mktRtYrmon) throws EventException {
		try {
			return dbDao.searchHireBaseList(mktRtYrmon);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01802",new String[]{}).getMessage(), ex);
		} catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01802",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Hire 설정 중, 현 Market rate를 반영할 Hire의 범위를 변경한다<br>
	 * 
	 * @param customMktRtVOs CustomMktRtVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageHireBase(CustomMktRtVO[] customMktRtVOs, String usrId) throws EventException{
		try {
			List<CustomMktRtVO> addVoList = new ArrayList<CustomMktRtVO>();
			List<CustomMktRtVO> modifyVoList = new ArrayList<CustomMktRtVO>();
			List<CustomMktRtVO> remofeVoList = new ArrayList<CustomMktRtVO>();
			for ( int i=0; i<customMktRtVOs .length; i++ ) {
				if ( customMktRtVOs[i].getIbflag().equals("I")){
					customMktRtVOs[i].setCreUsrId(usrId);
					customMktRtVOs[i].setUpdUsrId(usrId);
					addVoList.add(customMktRtVOs[i]);
				} else if ( customMktRtVOs[i].getIbflag().equals("U")){
					customMktRtVOs[i].setUpdUsrId(usrId);
					modifyVoList.add(customMktRtVOs[i]);
				} else if ( customMktRtVOs[i].getIbflag().equals("D")){
					customMktRtVOs[i].setUpdUsrId(usrId);
					remofeVoList.add(customMktRtVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addMktRts(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyMktRts(modifyVoList);
			}

			if ( remofeVoList.size() > 0 ) {
				dbDao.modifyMktRtDeleteFlags(remofeVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01803",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01803",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Standard Hire 설정 중, 현 Market rate를 반영할 Hire의 범위를 전체 삭제한다<br>
	 * 
	 * @param mktRtYrmon String
	 * @exception EventException
	 */
	public void removeAllHireBase(String mktRtYrmon) throws EventException{
		try {
			dbDao.removeAllHireBase(mktRtYrmon);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01805",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01805",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 월간 Standard Hire (표준 용선료)를 조회한다<br>
	 * 
	 * @param rngYr String
	 * @return List<SearchStandardHireListVO>
	 * @exception EventException
	 */
	public List<SearchStandardHireListVO> searchStandardHireList(String rngYr) throws EventException {
		try {
			return dbDao.searchStandardHireList(rngYr);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01806",new String[]{}).getMessage(), ex);
		} catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01806",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 월간 Standard Hire (표준 용선료)를 등록 및 변경한다<br>
	 * 
	 * @param customStndHirVOs CustomStndHirVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageStandardHire(CustomStndHirVO[] customStndHirVOs, String usrId) throws EventException {
		try {
			List<CustomStndHirVO> modifyVoList = new ArrayList<CustomStndHirVO>();
			for ( int i=0; i<customStndHirVOs .length; i++ ) {
				if (customStndHirVOs[i].getIbflag().equals("U") ||
					customStndHirVOs[i].getIbflag().equals("I")){
					if(customStndHirVOs[i].getMktRtAplyFlg().equals("1")) {
						customStndHirVOs[i].setMktRtAplyFlg("Y");
					} else {
						customStndHirVOs[i].setMktRtAplyFlg("N");
					}
					customStndHirVOs[i].setUpdUsrId(usrId);
					customStndHirVOs[i].setCreUsrId(usrId);
					modifyVoList.add(customStndHirVOs[i]);
				}
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyStandardHires(modifyVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01807",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01807",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 월간 Standard Hire (표준 용선료)를 삭제한다<br>
	 * 
	 * @param rngYr String
	 * @exception EventException
	 */
	public void removeAllStandardHire(String rngYr) throws EventException {
		try {
			dbDao.removeAllStandardHire(rngYr);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01808",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01808",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 월간 Standard Hire (표준 용선료)를 산출한다<br>
	 * 
	 * @param rngYr String
	 * @param usrId String
	 * @return List<SearchStandardHireBaseListVO>
	 * @exception EventException
	 */
	public List<SearchStandardHireBaseListVO> searchStandardHireBaseList(String rngYr, String usrId) throws EventException {
		try {
			dbDao.reomveStandardHireBase(rngYr);
			dbDao.addStandardHireBases(rngYr, usrId);
			return dbDao.searchStandardHireBaseList(rngYr);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01809",new String[]{}).getMessage(), ex);
		} catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01809",new String[]{}).getMessage(), ex);
		}
	}
}