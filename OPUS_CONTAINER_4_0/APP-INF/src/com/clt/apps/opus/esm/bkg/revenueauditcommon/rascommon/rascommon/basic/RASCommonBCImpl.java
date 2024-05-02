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
package com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.integration.RASCommonDBDAO;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmChargeVO;

/**
 * OPUS-PRICommon Business Logic Basic Command implementation<br>
 * - OPUS-PRICommon biz logic process<br>
 *
 * @author Park Sungsoo
 * @see PRICommonEventResponse,PRICommonBC DAO class reference
 * @since J2EE 1.4
 */

public class RASCommonBCImpl extends BasicCommandSupport implements RASCommonBC {

	// Database Access Object
	private transient RASCommonDBDAO dbDao = null;

	/**
	 * PRICommonBCImpl object creation<br>
	 * RASCommonDBDAO creation.<br>
	 */
	public RASCommonBCImpl() {
		dbDao = new RASCommonDBDAO();
	}

	/**
	 * Service Scope Code List retrieve<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList (RsltCdListVO rsltcdlistvo) throws EventException {
        try {
            return dbDao.searchServiceScopeCodeList(rsltcdlistvo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 *  ComCodeDescList retrieve event<br>
	 *  common code,name retrieve event<br>
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
				RsltCdListVO rsltcdlistvo = new RsltCdListVO() ;
				rsltcdlistvo.setCd(cdList.get(i).getCode());
				
				if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD01701") ){
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD01714")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02128")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02141")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02085")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());	
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02202")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());						
				}else {
					rsltcdlistvo.setNm(cdList.get(i).getName());
				}

				list.add(rsltcdlistvo);
			}

			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		}
	}	
	

	/**
	 *  ComCodeList retrieve event<br>
	 *  common code,name retrieve event<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
    public List<RsltCdListVO> searchComCodeList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect(rsltcdlistvo.getCd(),0);
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

			for (int i = 0; i < cdList.size(); i++) {
				RsltCdListVO rowVo = new RsltCdListVO() ;
				rowVo.setCd(cdList.get(i).getCode());
				rowVo.setNm(cdList.get(i).getName());

				list.add(rowVo);
			}
			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		}
	}	


	/**
	 *  RasOrganizationList retrieve event<br>
	 *  organization retrieve(Ras)<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRasOrganizationList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchRasOrganizationList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *  seacrhRasContiList retrieve event<br>
	 *  organization retrieve(Ras)<br>
	 * 
	 * @param RsltContiListVO rsltcontilistvo
	 * @return List<RsltContiListVO>
	 * @exception EventException
	 */
	public List<RsltContiListVO> seacrhRasContiList(RsltContiListVO rsltcontilistvo) throws EventException {
		try {
			return dbDao.seacrhRasContiList(rsltcontilistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	


	/**
	 *  UsExangeAmount retrieve event<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchUsExangeAmount(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchUsExangeAmount(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	


	/**
	 * BkgRevUmchTpList retrieve event<br>
	 * BKG_REV_UMCH_TP table retrieve<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchTpList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchBkgRevUmchTpList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	


	/**
	 * BkgRevUmchSubTpList retrieve event<br>
	 * BKG_REV_UMCH_SUB_TP table retrieve<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchSubTpList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchBkgRevUmchSubTpList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	

	/**
	 * retrieve event<br>
	 *  PRICommon screen retrieve event<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRatingUnitCodeList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchRatingUnitCodeList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	


	/**
	 * retrieve event<br>
	 *  PRICommon screen retrieve event<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRepChargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchRepChargeCodeList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	

	/**
     * charge list retrieve<br>
     * 
     * @param  MdmChargeVO mdmChargeVO
     * @return List<MdmChargeVO>
     * @exception EventException
     */
    public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws EventException {
        try {
            return dbDao.searchChargeList(mdmChargeVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
    }
}