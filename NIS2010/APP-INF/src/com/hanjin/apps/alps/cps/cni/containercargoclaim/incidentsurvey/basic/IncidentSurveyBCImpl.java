/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IncidentSurveyBCImpl.java
 *@FileTitle : IncidentSurveyBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBC;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.integration.IncidentSurveyDBDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmInciVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSlvVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSveyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentClaimInquiryVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentCreationVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentInquiryCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentInquiryVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.SalvageVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo.SurveyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-GEMCommon Business Logic Basic Command implementation<br>
 * - NIS2010-GEMCommon에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author choijungmi
 * @see ClaimMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class IncidentSurveyBCImpl extends BasicCommandSupport implements IncidentSurveyBC
{

    // Database Access Object
    private transient IncidentSurveyDBDAO dbDao = null;

    /**
     * ContainerCargoClaimBCImpl 객체 생성<br>
     * IncidentSurveyDBDAO 생성한다.<br>
     */
    public IncidentSurveyBCImpl()
    {
        dbDao = new IncidentSurveyDBDAO();
    }

    // ===========================================================================
    // 양정란
    // ===========================================================================
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0012] Survey
    // ---------------------------------------------------------------------------
	/**
	 * Survey 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category searchSurveyInfo 
	 * @param String  cgoClmNo
     * @return List<SurveyVO> 
     * @throws EventException
     */	
	
	public List<SurveyVO> searchSurveyInfo(String cgoClmNo) throws EventException {
		try {
			
			return dbDao.searchSurveyInfo(cgoClmNo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}
	 /**
	 * Survey 멀티 이벤트 처리<br>
	 * 
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category manageSurvey
	 * @param CniCgoClmSveyVO cniCgoClmSveyVO
	 * @return String 
	 * @exception EventException
	 */
	public String  manageSurvey(CniCgoClmSveyVO cniCgoClmSveyVO) throws EventException {		
		try {
			String manageStr="";
			
			// 데이타 수정
			String[] exist = dbDao.searchSurveyExist(cniCgoClmSveyVO.getCgoClmNo());
			
			if (exist[0].trim().equals("MS")) {
				dbDao.modifySurvey(cniCgoClmSveyVO);// 존재하면
				manageStr = "Y";
			}
			if (exist[0].trim().equals("M")) {
				dbDao.addSurvey(cniCgoClmSveyVO);// 없으면
				manageStr = "Y";
			}
			if (exist[0].trim().equals("")) {
				manageStr = "N";
			}
			
			
			
			return manageStr;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}	
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0013] Salvage
    // ---------------------------------------------------------------------------
	/**
	 * Salvage 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0013
	 * @category SearchSalvageList 
	 * @param String  cgoClmNo
     * @return List<SalvageVO> 
     * @throws EventException
     */	
	
	public List<SalvageVO> searchSalvageInfo(String cgoClmNo) throws EventException {
		try {
			
			return dbDao.searchSalvageInfo(cgoClmNo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}	
	
	 /**
	 * Salvage 멀티 이벤트 처리<br>
	 * 
	 * @author 양정란
	 * @category CPS_CNI_0013
	 * @category manageSalvage
	 * @param CniCgoClmSlvVO cniCgoClmSlvVO
	 * @return String 
	 * @exception EventException
	 */
	public String  manageSalvage(CniCgoClmSlvVO cniCgoClmSlvVO) throws EventException {		
		try {
			String manageStr="";
			
			// 데이타 수정
			// CNI_CGO_CLM_SLV(테이블)의 데이타 존재 여부에 따라,Display 되는 Message 를 구분하여 표시함
			// manageStr = "N" : Claim Main 데이터가 없을시, CNI_CGO_CLM_SLV(테이블)을 Modify 할 수 없음
			// manageStr = "Y" : 정상처리
			String[] exist = dbDao.searchSalvageExist(cniCgoClmSlvVO.getCgoClmNo());

			if (exist[0].trim().equals("MS")) {
				dbDao.modifySalvage(cniCgoClmSlvVO);// 존재하면
				manageStr = "Y";
			}
			if (exist[0].trim().equals("M")) {
				dbDao.addSalvage(cniCgoClmSlvVO);// 없으면
				manageStr = "Y";
			}
			if (exist[0].trim().equals("")) {
				manageStr = "N";
			}
			
			return manageStr;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}	
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0030] Incident-Creation
    // ---------------------------------------------------------------------------
	/**
	 * Incident-Creation 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchIncidentCreationInfo 
	 * @param String  cgoClmInciNo
     * @return List<IncidentCreationVO> 
     * @throws EventException
     */	
	
	public List<IncidentCreationVO> searchIncidentCreationInfo(String cgoClmInciNo) throws EventException {
		try {
			return dbDao.searchIncidentCreationInfo(cgoClmInciNo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}
	
	/**
	 * location 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchLocation 
	 * @param String  locCd
     * @return String
     * @throws EventException
     */		
	public String searchLocation(String locCd) throws EventException {
		try {
			return dbDao.searchLocation(locCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI00034",new String[]{"Location"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI00034",new String[]{"Location"}).getMessage(), ex);
		}
		
	}

	/**
	 * VVD 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchVesselName 
	 * @param String  vslCd
     * @return String
     * @throws EventException
     */		
	public String searchVesselName(String vslCd) throws EventException {
		try {
			return dbDao.searchVesselName(vslCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09014",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI09014",new String[]{}).getMessage(), ex);
		}
		
	}	
	
	 /**
	 * Incident-Creation 멀티 이벤트 처리<br>
	 * 
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category manageIncident
	 * @param CniCgoClmInciVO cniCgoClmInciVO
	 * @return String 
	 * @exception EventException
	 */
	public String  manageIncident(CniCgoClmInciVO cniCgoClmInciVO) throws EventException {		
		try {
			String etcClmInciNo="";//입력, 저장후 재조회를 위한 변수.
			String cgoClmInciNo = "";
			
			// 데이타 수정-Incident 테이블만  체크한다.
			String exist = dbDao.searchIncidentExist(cniCgoClmInciVO.getCgoClmInciNo());

			if (exist.equals("Y")) {
				dbDao.modifyIncident(cniCgoClmInciVO);// 존재하면
				etcClmInciNo = cniCgoClmInciVO.getCgoClmInciNo();
			}
			if (exist.equals("")) {
				
				cgoClmInciNo = dbDao.searchMaxClaimInciNo();//Max Inci NO 채번.
				cniCgoClmInciVO.setCgoClmInciNo(cgoClmInciNo);
				
				dbDao.addIncident(cniCgoClmInciVO);// 없으면 INSERT  
				etcClmInciNo = cgoClmInciNo;
			}
			
			return etcClmInciNo;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}	
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0031] Incident-Inquiry
    // ---------------------------------------------------------------------------
	/**
	 * Incident-Inquiry 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0031
	 * @category searchIncidentInquiryList 
	 * @param IncidentInquiryCondVO incidentInquiryCondVO
     * @return List<IncidentInquiryVO> 
     * @throws EventException
     */	
	
	public List<IncidentInquiryVO> searchIncidentInquiryList(IncidentInquiryCondVO incidentInquiryCondVO) throws EventException {
		try {
			
			List<IncidentInquiryVO> returnList = new ArrayList<IncidentInquiryVO>();
			
			returnList = dbDao.searchIncidentInquiryList(incidentInquiryCondVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				IncidentInquiryVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}			
			
			return returnList;			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0032] Incident-Claim Inquiry
    // ---------------------------------------------------------------------------
	/**
	 * Incident-Claim Inquiry 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0032
	 * @category searchIncidentClaimInquiryList 
	 * @param String cgoClmInciNo
	 * @param String pageNo
     * @return List<IncidentClaimInquiryVO> 
     * @throws EventException
     */	
	
	public List<IncidentClaimInquiryVO> searchIncidentClaimInquiryList(String cgoClmInciNo, String pageNo) throws EventException {
		try {
			
			List<IncidentClaimInquiryVO> returnList = new ArrayList<IncidentClaimInquiryVO>();
			
			returnList = dbDao.searchIncidentClaimInquiryList(cgoClmInciNo, pageNo);
			
			if (returnList != null && !returnList.isEmpty()) {
				IncidentClaimInquiryVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}			
			
			return returnList;			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}	
	
	/**
	 * Claim Main Survey 멀티 이벤트 처리<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category manageClaimMainSurvey
	 * @param CniCgoClmSveyVO cniCgoClmSveyVO
	 * @exception EventException
	 */
	public void manageClaimMainSurvey(CniCgoClmSveyVO cniCgoClmSveyVO) throws EventException {		
		try {
			
			String[] exist = dbDao.searchSurveyExist(cniCgoClmSveyVO.getCgoClmNo());

			if (exist[0].trim().equals("MS")) {
				dbDao.modifyClaimMainSurvey(cniCgoClmSveyVO);// 존재하면
			}
			if (exist[0].trim().equals("M")) {
				dbDao.addSurvey(cniCgoClmSveyVO);// 없으면
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
	}

}