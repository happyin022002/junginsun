/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageBCImpl.java
 *@FileTitle : PRD Common Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.ccd.commoncode.location.vo.YardVO;
import com.clt.apps.opus.bcm.ccd.commoncode.location.vo.ZoneVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.integration.PrdCommonManageDBDAO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ContinentVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ServiceProviderVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ValidationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;

/**
 * PRD Business Logic Basic Command implementation<br>
 * 
 * @author jungsunyoung
 * @see EventResponse,PrdCommonManageBC
 * @since J2EE 1.4
 */
public class PrdCommonManageBCImpl extends BasicCommandSupport implements PrdCommonManageBC {

	// Database Access Object
	private transient PrdCommonManageDBDAO dbDao = null;

	/**
	 * creating PrdCommonManageBCImpl Object<br>
	 * creating PrdCommonManageDBDAO<br>
	 */
	public PrdCommonManageBCImpl() {
		dbDao = new PrdCommonManageDBDAO();
	}

	/**
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
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
	@SuppressWarnings("rawtypes")
	public List validationPort(ValidationVO vo) throws EventException {
		try {
			List list = dbDao.validationPort(vo);
			if (list.size() < 1) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
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
	@SuppressWarnings("rawtypes")
	public List validationLocation(ValidationVO vo) throws EventException {
		try {
			List list = dbDao.validationLocation(vo);
			if (list.size() < 1) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
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
	@SuppressWarnings("rawtypes")
	public List validationNode(ValidationVO validationVO) throws EventException {
		try {
			List list = dbDao.validationNode(validationVO);
			if (list.size() < 1) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
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
	@SuppressWarnings("rawtypes")
	public List validationTerminal(ValidationVO vo) throws EventException {
		try {
			List list = dbDao.validationTerminal(vo);
			if (list.size() < 1) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
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
	@SuppressWarnings("rawtypes")
	public List validationCountry(ValidationVO vo) throws EventException {
		try {
			List list = dbDao.validationCountry(vo);
			if (list.size() < 1) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * retrieving Continent List - GeoHierarchyManage
	 * 
	 * @return List
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
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
	 * retrieving Continent List
	 * 
	 * @param ValidationVO vo
	 * @return boolean
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public boolean isFullCargoCutOffInThePast(ValidationVO vo) throws EventException {
		
		//List<ValidationVO>	rtnList		= new ArrayList<ValidationVO>();
		boolean				isInThePast	= false;
		
		try {
			isInThePast	= dbDao.isFullCargoCutOffInThePast(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return isInThePast;
	}

	/**
	 * retrieving Sub-Continent List - GeoHierarchyManage
	 * 
	 * @param vo
	 * @return List
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ValidationVO> validationLane(ValidationVO vo) throws EventException {
		try {
			List list = dbDao.validationLane(vo);
			if (list.size() < 1) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
			}
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
	@SuppressWarnings("rawtypes")
	public List validationFdrLane(ValidationVO vo) throws EventException {
		try {
			List list = dbDao.validationFdrLane(vo);
			if (list.size() < 1) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
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
	@SuppressWarnings("rawtypes")
	public List validationCallingTmlMtxLane(ValidationVO vo) throws EventException {
		try {
			List list = dbDao.validationCallingTmlMtxLane(vo);
			if (list.size() < 1) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
			} else {
				ValidationVO vo2 = (ValidationVO) list.get(0);
				if ("FDR".equals(vo2.getKind()) && "N".equals(vo2.getChk())) {
					throw new EventException((new ErrorHandler("PRD00001")).getMessage());
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
	@SuppressWarnings("rawtypes")
	public List validationVendor(ValidationVO vo) throws EventException {
		try {
			List list = dbDao.validationVendor(vo);
			// if(list.size() < 1){
			// throw new EventException( (new ErrorHandler("PRD00001")).getMessage() );
			// }
			return list;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * PrdCommonManageBCImpl's searchServiceProviderList
	 * 
	 * @param vo
	 * @return List
	 * @throws EventException
	 */
	public List<ServiceProviderVO> searchServiceProviderList(ServiceProviderVO vo) throws EventException {
		try {
			return dbDao.searchServiceProviderList(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * PrdCommonManageBCImpl's validationCallingTmlMtxTmlCd
	 * 
	 * @param vo
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationCallingTmlMtxTmlCd(ValidationVO vo) throws EventException {
		try {
			List list = dbDao.validationCallingTmlMtxTmlCd(vo);
			if (list.size() < 1) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
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
	public boolean isDoorTerminal(String check_data) throws EventException {
		try {
			return dbDao.isDoorTerminal(check_data);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * (non-Javadoc) PrdCommonManageBCImpl's multiPrdNodeByYard
	 * 
	 * @param YardVO ydVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean multiPrdNodeByYard(YardVO ydVO) throws EventException {
		boolean isSuccessful = false;
		String yd_cd = ydVO.getYdCd();

		try {
			if (ydVO.getDeltFlg().equals("D")) {
				dbDao.removePrdNode(ydVO);
			} else {
				if (dbDao.isPrdNode(yd_cd)) {
					dbDao.createPrdNode(ydVO);
				} else {
					dbDao.updatePrdNode(ydVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		isSuccessful = true;
		return isSuccessful;

	}

	/**
	 * (non-Javadoc) PrdCommonManageBCImpl's multiPrdNodeByYard
	 * 
	 * @param ZoneVO zoneVO
	 * @return boolean
	 * @throws EventException
	 */

	public boolean multiPrdNodeByZone(ZoneVO zoneVO) throws EventException {
		boolean isSuccessful = false;
		String zn_cd = zoneVO.getZnCd();

		try {
			if (zoneVO.getDeltFlg().equals("D")) {
				dbDao.removePrdNode(zoneVO);
			} else {
				if (dbDao.isPrdNode(zn_cd)) {
					dbDao.createPrdNode(zoneVO);
				} else {
					dbDao.updatePrdNode(zoneVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		isSuccessful = true;
		return isSuccessful;
	}

	/**
	 * @param contiCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchCntOfConti(String contiCd) throws EventException {
		try {
			String[] cnt_cd = dbDao.searchCntOfConti(contiCd);
			if (cnt_cd == null) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
			}
			return cnt_cd;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param comIntgCdDtlVO
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<ComIntgCdDtlVO> searchComIntgCdDtl(ComIntgCdDtlVO comIntgCdDtlVO) throws EventException {
		try {
			return dbDao.searchComIntgCdDtl(comIntgCdDtlVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

}