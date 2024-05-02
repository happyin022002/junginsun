/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonBCImpl.java
*@FileTitle : PRICommon
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.integration.PRICommonDBDAO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.CheckUpdateDateVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.PriParaCdDtlVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.PriParaCdVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltPriAuthorizationVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltPriMdmSlsRepVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComUpldFileVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmChargeVO;
import com.clt.syscommon.common.table.MdmSlsRepVO;
import com.clt.syscommon.common.table.PriAuthorizationVO;
import com.clt.syscommon.common.table.PriTariffVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * PRICommon Business Logic Basic Command implementation<br>
 * - handling biz logic about PRICommon<br>
 *
 * @author  
 * @see PRICommonEventResponse,PRICommonBC reference each DAO class
 * @since J2EE 1.4
 */

public class PRICommonBCImpl extends BasicCommandSupport implements PRICommonBC {

	// Database Access Object
	private transient PRICommonDBDAO dbDao = null;

	/**
	 * PRICommonBCImpl object creation<br>
	 * creating PRICommonDBDAO <br>
	 */
	public PRICommonBCImpl() {
		dbDao = new PRICommonDBDAO();
	}

	/**
	 * Service Scope Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList (RsltCdListVO rsltCdlistVo) throws EventException {
        try {
            return dbDao.searchServiceScopeCodeList(rsltCdlistVo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * CurrencyCodeList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCurrencyCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCurrencyCodeList(rsltCdlistVo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	/**
	 *  PerCodeList retrieving<br>
	 *  Per Type code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchPerCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchPerCodeList(rsltCdlistVo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
		
	/**
	 * Sub-continent Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSubcontinentCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSubcontinentCodeList(rsltCdlistVo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Service Scope Detail Name<br>
	 * 
	 * @param String svcScpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchServiceScopeCodeDetailName(String svcScpCd) throws EventException {
		try {
			return dbDao.searchServiceScopeCodeDetailName(svcScpCd);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Location Name<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchLocationName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
		    List<RsltCdListVO> list = null;
            if (rsltCdlistVo.getNm() != null && ("rg".equals(rsltCdlistVo.getNm()) || "rpscp".equals(rsltCdlistVo.getNm())|| "rqscp".equals(rsltCdlistVo.getNm()) )) {
                list = dbDao.searchRFALocationName(rsltCdlistVo);
            } else {
                list = dbDao.searchLocationName(rsltCdlistVo);
            }
			return list;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		

	/**
	 * Country Name<br>
	 * @param String cntCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCountryName(String cntCd) throws EventException {
		try {
			return dbDao.searchCountryName(cntCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}			

	/**
	 * Commodity Name<br>
	 * 
	 * @param String cmdtCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCommodityName(String cmdtCd) throws EventException {
		try {
			return dbDao.searchCommodityName(cmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Rep Commodity Name<br>
	 * 
	 * @param String repCmdtCd
	 * @return String
	 * @exception EventException
	 */
	public String searchRepCommodityName(String repCmdtCd) throws EventException {
		try {
			return dbDao.searchRepCommodityName(repCmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 *  SurchargeCodeList retrieving<br>
	 *  Surcharge code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSurchargeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSurchargeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	/**
	 * Commodity Group Name<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchCommodityGroupName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
		    String cmdtNm = null;
		    if (rsltCdlistVo.getNm() != null && "proposal".equals(rsltCdlistVo.getNm())) {
                cmdtNm = dbDao.searchSpCommodityGroupName(rsltCdlistVo);
            } else if (rsltCdlistVo.getNm() != null && "rg".equals(rsltCdlistVo.getNm())) {
                cmdtNm = dbDao.searchRgCommodityGroupName(rsltCdlistVo);
            } else if (rsltCdlistVo.getNm() != null && "rpscp".equals(rsltCdlistVo.getNm())) {
                cmdtNm = dbDao.searchRpCommodityGroupName(rsltCdlistVo);
            } else {
                cmdtNm = dbDao.searchCommodityGroupName(rsltCdlistVo);
            }
		    
		    return cmdtNm;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}			
	/**
     * Location Group Name<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return String
     * @exception EventException
     */
    public String searchLocationGroupName (RsltCdListVO rsltCdlistVo) throws EventException {
        try {
            String locNm = null;
            if (rsltCdlistVo.getNm() != null && "rg".equals(rsltCdlistVo.getNm())) {
                locNm = dbDao.searchRgLocationGroupName(rsltCdlistVo);
            } else if (rsltCdlistVo.getNm() != null && "rpscp".equals(rsltCdlistVo.getNm())) {
                locNm = dbDao.searchRpLocationGroupName(rsltCdlistVo);
            } else {
                locNm = dbDao.searchLocationGroupName(rsltCdlistVo);
            }

            return locNm;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
    }
	/**
	 *  MdmCntrSzCodeList retrieving<br>
	 *  mdm_cntr_sz code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMdmCntrSzCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchMdmCntrSzCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 *  SpScpServiceScopeCodeList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSpScpServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSpScpServiceScopeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *  OfficeCodeList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchOfficeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchOfficeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 *  SalesRepByOfficeList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepByOfficeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSalesRepByOfficeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *  SpScpMqcServiceScopeCodeList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSpScpMqcServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSpScpMqcServiceScopeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *  Ras OrganizationList retrieving<br>

	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRasOrganizationList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRasOrganizationList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *  UsExangeAmount retrieving<br>
	 *  returning current AMOUNT * US exchange rate by CUR <br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchUsExangeAmount(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchUsExangeAmount(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * unmatch type code List retrieving<br>
	 * BKG_REV_UMCH_TP table retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchTpList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchBkgRevUmchTpList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * unmatch sub type code List retrieving<br>
	 * BKG_REV_UMCH_SUB_TP table retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchSubTpList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchBkgRevUmchSubTpList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *  SalesRepCodeList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSalesRepCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *  SpScopeGroupLocationName retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public String searchSpScopeGroupLocationName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSpScopeGroupLocationName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  SubTrdCdList retrieving<br>
	 *  mdm_sub_trd code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSubTrdCdList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSubTrdCdList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 *  SvcScpLaneCdList retrieving<br>
	 *  mdm_svc_scp_lane code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSvcScpLaneCdList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSvcScpLaneCdList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  CustomerName retrieving<br>
	 *  CustomerName code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustomerName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCustomerName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  ChargeCdList retrieving<br>
	 *  mdm_charge code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchChargeCdList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchChargeCdList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 *  ScgGrpCmdtCdList retrieving<br>
	 *  mdm_charge code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScgGrpCmdtCdList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchScgGrpCmdtCdList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 *  SurchargeGroupLocationName retrieving<br>
	 *  pri_scg_grp_loc name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchSurchargeGroupLocationName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSurchargeGroupLocationName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Region Name<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRegionName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRegionName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *    Authorization retrieving<br>
	 * 
	 * @param PriAuthorizationVO vo
	 * @return List<PriAuthorizationVO>
	 * @exception EventException
	 */
	public List<PriAuthorizationVO> searchAuthorization(PriAuthorizationVO vo) throws EventException {
		try {
			return dbDao.searchAuthorization(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * PRI_AUTHORIZATION table retrieving by Tariff Code <br>
	 * 
	 * @param RsltCdListVO vo
	 * @return List<PriAuthorizationVO>
	 * @exception EventException
	 */
	public List<PriAuthorizationVO> searchAuthByTariff(RsltCdListVO vo) throws EventException {
		try {
			return dbDao.searchAuthByTariff(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  ScopeChargeCodeList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScopeChargeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchScopeChargeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	
	/**
	 *  AllCurrencyCodeList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAllCurrencyCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchAllCurrencyCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  SvcScpPptMapgList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSvcScpPptMapgList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSvcScpPptMapgList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  AllPerCodeList retrieving<br>
	 *  Per Type code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAllPerCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchAllPerCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * NoteConvRuleMapgList retrieving<br>
	 * retrieving Note Conversion Rule code, description by CONVERSION TYPE <br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchNoteConvRuleMapgList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchNoteConvRuleMapgList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
		
	
	/**
	 * Request Office Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRequestOfficeName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRequestOfficeName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *  CustBySaleRepList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustBySaleRepList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCustBySaleRepList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Office Code and Sales Rep Name retrieving by Sales Rep Code <br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustByReqOffice(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCustByReqOffice(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 *  ApprovalOfficeList retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalOfficeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchApprovalOfficeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	
	/**
	 * office code andApproval Office retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalOfficeAllList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchApprovalOfficeAllList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	
	/**
	 * Location, Group Location, Country, Region  Name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTotalLocationName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchTotalLocationName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	
	/**
	 * VESSEL SERVICE LANE name retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchVesselServiceLaneName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchVesselServiceLaneName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * VSK VESSEL SCHEDULE code retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchVskVesselScheduleCode(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchVskVesselScheduleCode(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Actual Customer list retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchActualCustomerList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchActualCustomerList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * IMDG Class list retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchImdgClassCode(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchImdgClassCode(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Location Code retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeLocationCode(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchServiceScopeLocationCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	
  
	/**
	 * RFA Proposal Service Scope Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRpScpServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRpScpServiceScopeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * retrieving SYS_GUID() <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchSysGuid() throws EventException {
		try {
			return dbDao.searchSysGuid();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *  common code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
    public List<RsltCdListVO> searchComCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect(rsltCdlistVo.getCd(),0);
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
	//CD01701
			for (int i = 0; i < cdList.size(); i++) {
				RsltCdListVO rowVo = new RsltCdListVO() ;
				rowVo.setCd(cdList.get(i).getCode());
				rowVo.setNm(cdList.get(i).getName());

				list.add(rowVo);
			}
			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * retrieving common code, description <br>
	 * 
	 * @param RsltCdListVO paramCdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
    public List<RsltCdListVO> searchComCodeDescList(RsltCdListVO paramCdlistvo) throws EventException {
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect(paramCdlistvo.getCd(),0);
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

			for (int i = 0; i < cdList.size(); i++) {
				RsltCdListVO rsltCdlistVo = new RsltCdListVO() ;
				rsltCdlistVo.setCd(cdList.get(i).getCode());
				
				if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD01701") ){
					rsltCdlistVo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD01714")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02128")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02141")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02085")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());	
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02202")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());						
				}else {
					rsltCdlistVo.setNm(cdList.get(i).getName());
				}

				list.add(rsltCdlistVo);
			}

			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}			

	/**
	 * retrieving existence of PROP_NO in DMT S/C EXCEPTION GROUP<br>
	 * 
	 * @param rsltCdlistVo RsltCdListVO
	 * @return String 
	 * @exception EventException
	 */
	public String searchDmtScExptGrpCount(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchDmtScExptGrpCount(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
			
	/**
	 * Rep Charge Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRepChargeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRepChargeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * S/C No prefix list retrieving<br>
	 *  common code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScPrefixList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchScPrefixList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * S/C RHQ list retrieving<br>
	 *  common code, description retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRHQList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRHQList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * after Batch Job, retrieving jobid by program no(etc1)and  parameter(etc2)<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public RsltCdListVO searchBatchScheduleJobIdAndStatus(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			RsltCdListVO rtn = new RsltCdListVO();
			rsltCdlistVo.setEtc2(rsltCdlistVo.getEtc2().replaceAll("\\|", " "));
			String jobId = dbDao.searchBatchScheduleJobId(rsltCdlistVo);
			int status = 0;
 
			if( jobId !=  null && !jobId.isEmpty() ){
				ScheduleUtil su = new ScheduleUtil();
				status = su.getJobStatus(jobId, "QT");
				rtn.setCd(jobId);
				rtn.setNm(String.valueOf(status));
			}
			
			return rtn;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
		
	/**
	 * retrieving S/C Term Type <br>
	 * 
	 * @param  rsltCdlistVo RsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTermTypeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchTermTypeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * retrieving RFA Term Type<br>
	 * 
	 * @param  rsltCdlistVo RsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRfaTermTypeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRfaTermTypeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	

	/**
	 *  retrieving CHARGE code list by SCOPE <br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTradeCodeList(RsltCdListVO rsltCdlistVo) throws EventException{
		try {
			return dbDao.searchTradeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
		    throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 *  retrieving CHARGE code list by SCOPE <br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRLaneCodeList(RsltCdListVO rsltCdlistVo) throws EventException{
		try {
			return dbDao.searchRLaneCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * organization chart retrieving<br>
     * 
     * @param  ComOrganizationVO comOrganizationVO
     * @param List<OrganizationVO> orgList
     * @return List<ComOrganizationVO>
     * 
     * @exception EventException
     */
    public List<ComOrganizationVO> searchOrganizationList(ComOrganizationVO comOrganizationVO,List<OrganizationVO> orgList) throws EventException {
        try {
        	
            return dbDao.searchOrganizationList(comOrganizationVO,orgList);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * charge list retrieving<br>
     * 
     * @param  MdmChargeVO mdmChargeVO
     * @return List<MdmChargeVO>
     * @exception EventException
     */
    public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws EventException {
        try {
            return dbDao.searchChargeList(mdmChargeVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    
    /**
     * retrieving login user's SELECT authority and REQUEST OFFICE[PRS]<br>
     * 
	 * @param RsltPriAuthorizationVO priAuthorizationVO
	 * @param SignOnUserAccount account
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public  RsltCdListVO  searchAuthorizationOffice (RsltPriAuthorizationVO priAuthorizationVO,SignOnUserAccount account) throws EventException {
		try {
			RsltCdListVO returnVO = new RsltCdListVO();
			returnVO.setCd("X"); 
			List<RsltPriMdmSlsRepVO> mdmSlsRepVO = dbDao.searchMdmSlsRep(account.getUsr_id());
			if( mdmSlsRepVO.size() > 0 && mdmSlsRepVO.get(0).getOfcCd() != null && mdmSlsRepVO.get(0).getOfcCd().length() != 0){
				returnVO.setCd("S"); 
				returnVO.setNm(mdmSlsRepVO.get(0).getOfcCd());// request office
			}else{			
				List<RsltPriAuthorizationVO> authVO = dbDao.searchPriAuthorization(priAuthorizationVO);
				if( authVO != null && authVO.size() > 0 ){
					returnVO.setCd("A"); 
				}
			}
			return returnVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	

    /**
     * User information retrieving by Sales Rep Code <br>
     * 
     * @param MdmSlsRepVO mdmSlsRepVO
     * @return List<ComUserVO>
     * @exception EventException
     */
    public List<ComUserVO> searchSalesRepInfo (MdmSlsRepVO mdmSlsRepVO) throws EventException {
        try {
            return dbDao.searchSalesRepInfo(mdmSlsRepVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
    }
    
	/**
	 * Tariff Code List retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchTariffCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

    /**
     * Tariff Code retrieving by Service Scope Code <br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchTariffCodeByServiceScopeCode(RsltCdListVO rsltCdlistVo) throws EventException {
        try {
            return dbDao.searchTariffCodeByServiceScopeCode(rsltCdlistVo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
    }
    
    /**
	 * RFA Actual Customer list retrieving<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRFAActualCustomerList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRFAActualCustomerList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * in case of existence of Tariff Code, Service Scope Code List retrieving<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchTariffServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
        try {
            return dbDao.searchTariffServiceScopeCodeList(rsltCdlistVo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * BackEndJob's state retrieving<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

    /**
     * Uploaded Excel Template File Key retrieving<br>
     * 
     * @param ComUpldFileVO comUpldFileVO
     * @return String
     * @exception EventException
     */
	public String searchExcelTemplateFileKey (ComUpldFileVO comUpldFileVO) throws EventException {
        try {
            return dbDao.searchExcelTemplateFileKey(comUpldFileVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
	
    /**
	 * Compensation Charge Combo list retrieving<br>
	 * DHF, CMS, NMS, ODF retrieving<br>
     * 
     * @param  RsltCompensationChargeComboListVO pVo
     * @return List<RsltCompensationChargeComboListVO>
     * @exception EventException
     */
    public List<RsltCompensationChargeComboListVO> searchCompensationChargeComboList(RsltCompensationChargeComboListVO pVo) throws EventException {
        try {
            return dbDao.searchCompensationChargeComboList(pVo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Customer List retrieving about Sales Rep<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchSalesRepListByCustOnly(RsltCdListVO rsltCdlistVo) throws EventException {
        try {
            return dbDao.searchSalesRepListByCustOnly(rsltCdlistVo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    
    /**
     * checking Region Code, Contry Code correction in  MDM_SVC_SCP_LMT's Origin, Dest<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchCheckServiceScopeOriginDestRegionList(RsltCdListVO rsltCdlistVo) throws EventException {
        try {
            return dbDao.searchCheckServiceScopeOriginDestRegionList(rsltCdlistVo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    
    /**
     * after loading, checking upd_dt change<br>
     * 
     * @param CheckUpdateDateVO checkUpdateDate
     * @return CheckUpdateDateVO
     * @exception DAOException
     */
    public CheckUpdateDateVO searchCheckUpdateDate(CheckUpdateDateVO checkUpdateDate) throws EventException {
        try {
        	checkUpdateDate.setTableName(checkUpdateDate.getTableName().toUpperCase());
            return dbDao.searchCheckUpdateDate(checkUpdateDate);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * retrieving Tariff Name by inputed Tariff Code
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return List<PriTariffVO>
	 * @exception EventException
	 */
	public List<PriTariffVO> searchTariffCodeName(PriTariffVO priTariffVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchTariffCodeName(priTariffVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * retrieving SYSDATE YYYYMMDD type<br>
	 * 
     * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchSystemDate(RsltCdListVO rsltCdlistVo) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchSystemDate(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving Rep Service Scoop Code List<br>
	 * 
	 * 
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRepSvcScpCd() throws EventException {
		try {
			return dbDao.searchRepSvcScpCdList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 * Percent Base CHG Creation 화면에서 사용할 ChargeList 를 조회합니다.<br>
	 * mdm_charge 코드,명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchChargeListForPctBse (RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchChargeListForPctBse(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search the info from PRI_PARA_CD Table.
	 * 
	 * @param PriParaCdVO priParaCdVo
	 * @return List<PriParaCdVO>
	 * @exception EventException
	 * @LastModifyDate : 2014.10.13
	 */
	public List<PriParaCdVO> searchPriParaCd (PriParaCdVO priParaCdVo) throws EventException {
		try {
			return dbDao.searchPriParaCd(priParaCdVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Search the info from PRI_PARA_CD_DTL Table.
	 * 
	 * @param PriParaCdDtlVO priParaCdDtlVo
	 * @return List<PriParaCdDtlVO>
	 * @exception EventException
	 * @LastModifyDate : 2014.10.13
	 */
	public List<PriParaCdDtlVO> searchPriParaCdDtl (PriParaCdDtlVO priParaCdDtlVo) throws EventException {
		try {
			return dbDao.searchPriParaCdDtl(priParaCdDtlVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
     * check to User Role(COM_USR_ROLE_MTCH) in use about PRI <br>
     *
     * @param ComUserVO comUserVo
     * @return String
     * @exception EventException
     * @LastModifyDate : 2014.10.13
     */
	public String checkPriUserRole(ComUserVO comUserVo) throws EventException {
		try {
			return dbDao.checkPriUserRole(comUserVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * CNTR Type retrieving<br>
	 * 
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCntrTpCodeList() throws EventException {
		try {
			return dbDao.searchCntrTpCodeList();
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	

	
	
	

}