/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageBCImpl.java
 *@FileTitle : PRD 공통관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-16 jungsunyoung
 * 1.0 최초 생성
 * 2009.08.03 NohSeungBae alps f/w 로 구조 변경 
* 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcommon.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.common.prdcommon.integration.PrdCommonManageDBDAO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ContinentVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ServiceProviderVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ValidationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungsunyoung
 * @see EventResponse,PrdCommonManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PrdCommonManageBCImpl extends BasicCommandSupport implements PrdCommonManageBC {

    // Database Access Object
    private transient PrdCommonManageDBDAO dbDao = null;

    /**
     * PrdCommonManageBCImpl 객체 생성<br>
     * PrdCommonManageDBDAO를 생성한다.<br>
     */
    public PrdCommonManageBCImpl() {
        dbDao = new PrdCommonManageDBDAO();
    }

    /**
     * PRD 업무 시나리오 마감작업<br>
     * PrdCommonManage업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        dbDao = null;
    }

    /**
     * validationPort
     * 
	 * @param vo
	 * @return List
     * @tnhrows EventException
     */
    public List validationPort(ValidationVO vo) throws EventException {

	    try {
            List list =  dbDao.validationPort(vo);
            if(list.size() < 1){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
	}

    /**
     * validationLocation
     * 
	 * @param vo
     * @return List
     * @throws EventException
     */
	@Override
    public List validationLocation(ValidationVO vo) throws EventException {
        try {
            List list =  dbDao.validationLocation(vo);
            if(list.size() < 1){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * validationNode
     * 
	 * @param validationVO
	 * @return List
     * @throws EventException
     */
	@Override
    public List validationNode(ValidationVO validationVO) throws EventException {
        try {
            List list =  dbDao.validationNode(validationVO);
            if(list.size() < 1){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * validationTerminal
     * 
	 * @param vo
     * @return List
     * @throws EventException
     */
    @Override
    public List validationTerminal(ValidationVO vo) throws EventException {
        try {
            List list =  dbDao.validationTerminal(vo);
            if(list.size() < 1){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * validationCountry
     * 
	 * @param vo
	 * @return List
     * @throws EventException
     */
    @Override
    public List validationCountry(ValidationVO vo) throws EventException {
        try {
            List list =  dbDao.validationCountry(vo);
            if(list.size() < 1){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * Continent List 조회 이벤트 처리<br>
     * GeoHierarchyManage화면에 대한 조회 이벤트 처리<br>
     * 
     * @return List
     * @exception EventException
     */
    @Override
    public List searchContinent() throws EventException {
        try {
            return dbDao.searchContinentList();
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * Sub-Continent List 조회 이벤트 처리<br>
     * GeoHierarchyManage화면에 대한 조회 이벤트 처리<br>
     * 
	 * @param vo
	 * @return List
     * @exception EventException
     */
    @Override
    public List searchSubContinent(ContinentVO vo) throws EventException {
        try {
            return dbDao.searchSubContinent(vo);
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * validationLane
     * 
	 * @param vo
	 * @return List
     * @throws EventException
     */
    @Override
    public List<ValidationVO> validationLane(ValidationVO vo) throws EventException {
        try {
            List list =  dbDao.validationLane(vo);
            if(list.size() < 1){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * searchContinentCode
     * 
	 * @param ValidationVO vo
	 * @return List<ValidationVO>
     * @throws EventException
     */
    @Override
    public List<ValidationVO> searchContinentCode(ValidationVO vo) throws EventException {
        try {
            List list =  dbDao.searchContinentCode(vo);
//            if(list.size() < 1){
//                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
//            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }


    /**
     * PrdCommonManageBCImpl's validationFdrLane
     * 
	 * @param vo
     * @return List
     * @throws EventException
     */
    @Override
    public List validationFdrLane(ValidationVO vo) throws EventException {
        try {
            List list =  dbDao.validationFdrLane(vo);
            if(list.size() < 1){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * PrdCommonManageBCImpl's validationCallingTmlMtxLane
     * 
	 * @param vo
     * @return List
     * @throws EventException
     */
    @Override
    public List validationCallingTmlMtxLane(ValidationVO vo) throws EventException {
        try {
            List list =  dbDao.validationCallingTmlMtxLane(vo);
            if(list.size() < 1){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }else{
                ValidationVO vo2 = (ValidationVO)list.get(0);
                if("FDR".equals(vo2.getKind()) && "N".equals(vo2.getChk())){
                    throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
                }
            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * validationVendor
     * 
	 * @param vo
     * @return List
     * @throws EventException
     */
    @Override
    public List validationVendor(ValidationVO vo) throws EventException {
        try {
        	String vnd = vo.getCheckData();
        	if( !isNumberChk(vnd) )  {
        		throw new EventException( (new ErrorHandler("COM12241")).getMessage() );
        	}
            List list =  dbDao.validationVendor(vo);
            if(list.size() < 1){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }
	
	/**
	 * 해당 str 가 Number 인지 확인 한다<br>
	 *
	 * @param String str
	 * @return Boolean
	 */
	public boolean isNumberChk( String str ) {
		boolean returnValue = true;
		if ( str == null || str.equals("") ) returnValue = false;
		for ( int i=0; i<str.length() ; i++ ) {
			char ch = str.charAt(i);
			if ( ch < 48 || ch > 59 ) {
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
    /**
     * PrdCommonManageBCImpl's searchServiceProviderList
     * ★2009-09-21 kim kwijin수정
	 * @param vo
	 * @return List
     * @throws EventException
     */
    @Override
    public List<ServiceProviderVO> searchServiceProviderList(ServiceProviderVO vo) throws EventException {
    	try {
			return dbDao.searchServiceProviderList(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }

    /**
     * PrdCommonManageBCImpl's getPrdPgmRole
     * @param pgmId
     * @param usrId
     * @return
     * @throws EventException
     */
    public String getPrdPgmRole(String pgmId, String usrId) throws EventException {

    	String returnCrud = "";
        try {
        	returnCrud = dbDao.getPrdPgmRole(pgmId, usrId);

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return returnCrud;
    }

    /**
     * PrdCommonManageBCImpl's validationCallingTmlMtxTmlCd
     * 
	 * @param vo
     * @return List
     * @throws EventException
     */
    @Override
    public List validationCallingTmlMtxTmlCd(ValidationVO vo) throws EventException {
        try {
            List list =  dbDao.validationCallingTmlMtxTmlCd(vo);
            if(list.size() < 1){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }
            return list;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * (non-Javadoc) PrdCommonManageBCImpl's isDoorTml
     * 
	 * @param check_data
     * @return boolean
     * @throws EventException
     */
    @Override
    public boolean isDoorTerminal(String check_data) throws EventException {
        try {
			return dbDao.isDoorTerminal(check_data);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
    }

	@Override
	public DBRowSet getRowSetPrdPgmRole(String pgmId, String usrId)
			throws EventException {
    	DBRowSet rowSet=null; 

      
      try {

      	rowSet = dbDao.getRowSetPrdPgmRole(pgmId,usrId);

      } catch (DAOException de) {
          log.error("err "+de.toString(),de);
          throw new EventException(de.getMessage());
      } 

      return rowSet;
	}
	
	/**
	 * @param contiCd
	 * @return String[]
	 * @throws EventException
	 */
    public String[] searchCntOfConti(String contiCd) throws EventException {
        try {
            String[] cnt_cd =  dbDao.searchCntOfConti(contiCd);
            if(cnt_cd == null){
                throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
            }
            return cnt_cd;
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }
    
    /**
     * validationLaneVvd
     * 
	 * @param ValidationVO vo
	 * @return List
     * @tnhrows EventException
     */
    public List validationLaneVvd(ValidationVO vo) throws EventException {

	    try {
            return dbDao.validationLaneVvd(vo);
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
	}

}