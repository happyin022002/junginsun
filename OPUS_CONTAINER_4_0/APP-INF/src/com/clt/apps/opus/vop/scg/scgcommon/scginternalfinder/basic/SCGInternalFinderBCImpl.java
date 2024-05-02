/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGInternalFinderBCImpl.java
*@FileTitle : SCG COMMON
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.basic;

import java.util.List;

import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration.SCGInternalFinderDBDAO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.CheckUNNumberVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchImdgAmdtMstVO;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchUNNumberVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;
import com.clt.syscommon.common.table.ScgImdgUnNoVO;
import com.clt.syscommon.common.table.ScgIrrTpCdVO;

/**
 * OPUS-SCGCommon Business Logic Basic Command implementation<br>
 * - Handling business transactions of OPUS-SCGCommon<br>
 *
 * @author
 * @see SCG_COM_INTERNALEventResponse,SCGInternalFinderBC
 * @since J2EE 1.6
 */
public class SCGInternalFinderBCImpl extends BasicCommandSupport implements SCGInternalFinderBC {

	// Database Access Object
	private transient SCGInternalFinderDBDAO dbDao = null;

	/**
	 * SCGInternalFinderBCImpl object creation<br>
	 * SCGInternalFinderDBDAO creation<br>
	 */
	public SCGInternalFinderBCImpl() {
		dbDao = new SCGInternalFinderDBDAO();
	}

	/**
	 * UN No. retrieve <br>
	 * 
	 * @param scgImdgUnNoVO 
	 * @return List<CheckUNNumberVO>
	 * @exception EventException
	 */
	public List<CheckUNNumberVO> checkUNNumber(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException {
		try {
			return dbDao.checkUNNumber(scgImdgUnNoVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
		}		
	}
	
	/**
	 * Class retrieve <br>
	 * 
	 * @return List<ScgImdgClssCdVO>
	 * @exception EventException
	 */
	public List<ScgImdgClssCdVO> searchUNClass() throws EventException {
		try {
			return dbDao.searchUNClass();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Class Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Class Code"}).getMessage(), ex);
		}		
	}

	/**
	 * Special Provisions retrieve <br>
	 * 
	 * @param spclProviNo
	 * @return List<ScgImdgSpclProviVO>
	 * @exception EventException
	 */
	public List<ScgImdgSpclProviVO> checkSpclProvi(String spclProviNo) throws EventException {
		try {
			return dbDao.checkSpclProvi(spclProviNo);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
		}		
	}
	
	/**
	 * Irregular Type retrieve according to Akward type <br>
	 * 
	 * @param scgIrrTpCdVO 
	 * @return List<ScgIrrTpCdVO>
	 * @exception EventException
	 */
	public List<ScgIrrTpCdVO> searchIrregularType(ScgIrrTpCdVO scgIrrTpCdVO) throws EventException {
		try {
			return dbDao.searchIrregularType(scgIrrTpCdVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Irregular Type"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Irregular Type"}).getMessage(), ex);
		}		
	}
 
 	/**
	 * IMDG UN Number List retrieve <br>
	 * 
	 * @param searchUNNumberVO
	 * @return List<SearchUNNumberVO>
	 * @throws EventException
	 */
	public List<SearchUNNumberVO> searchUNNumber(
			SearchUNNumberVO searchUNNumberVO) throws EventException {
		try {
			return dbDao.searchUNNumber(searchUNNumberVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No"}).getMessage(), ex);
		}		
	}
    /**
     * SPCL CGO Irregular List UN No. Check <br>
     * 
     * @param searchUNNumberVO
     * @return List<SearchUNNumberVO>
     * @exception EventException
     */
    public List<SearchUNNumberVO> checkIrrUnNoList(
            SearchUNNumberVO searchUNNumberVO) throws EventException {
        try {
            return dbDao.checkIrrUnNoList(searchUNNumberVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No"}).getMessage(), ex);
		}		
    }
    
    /**
     * IMDG UN Number Total retrieve <br>
     * 
     * @param searchUNNumberVO
     * @return String
     * @throws EventException
     */
    public String searchUNNumberTotalCnt(SearchUNNumberVO searchUNNumberVO) throws EventException{
        try {
            return dbDao.searchUNNumberTotalCnt(searchUNNumberVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No"}).getMessage(), ex);
		}		
    }
    
    /**
	 * UN No. Combo retrieve <br>
	 * 
	 * @param scgImdgUnNoVO 
	 * @return List<CheckUNNumberVO>
	 * @exception EventException
	 */
	public List<CheckUNNumberVO> searchUNNo(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException {
		try {
			return dbDao.searchUNNo(scgImdgUnNoVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
		}		
	}
	
    /**
     * 특정Port의 RSO 조회 합니다. <br>
     * 
     * @param LocationVO locationVO
     * @return String
     * @throws EventException
     */
    public String searchRSOforSpecificPort(LocationVO locationVO) throws EventException{
        try {
            return dbDao.searchRSOforSpecificPort(locationVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No"}).getMessage(), ex);
		}		
    }

    /**
	 * SCG_IMDG_AMDT_MST retrieve <br>
	 * 
	 * @param searchImdgAmdtMstVO 
	 * @return List<SearchImdgAmdtMstVO>
	 * @exception EventException
	 */
	public List<SearchImdgAmdtMstVO> searchImdgAmdtMst(SearchImdgAmdtMstVO searchImdgAmdtMstVO) throws EventException {
		try {
			return dbDao.searchImdgAmdtMst(searchImdgAmdtMstVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG Amdt"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG Amdt"}).getMessage(), ex);
		}		
	}

    /**
	 * SCG_IMDG_AMDT_MST List retrieve <br>
	 * 
	 * @param searchImdgAmdtMstVO 
	 * @return List<SearchImdgAmdtMstVO>
	 * @exception EventException
	 */
	public List<SearchImdgAmdtMstVO> searchImdgAmdtMstList(SearchImdgAmdtMstVO searchImdgAmdtMstVO) throws EventException {
		try {
			return dbDao.searchImdgAmdtMstList(searchImdgAmdtMstVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG Amdt List"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG Amdt List"}).getMessage(), ex);
		}		
	} 
	
    /**
	 * SCG_IMDG_UN_NO 의  IMDG_AMDT_NO  retrieve <br>
	 * 
	 * @param ScgImdgUnNoVO scgImdgUnNoVO 
	 * @return List<ScgImdgUnNoVO>
	 * @exception EventException
	 */
	public List<ScgImdgUnNoVO> searchImdgAmdtNo(ScgImdgUnNoVO scgImdgUnNoVO)throws EventException {
		try {
			return dbDao.searchImdgAmdtNo(scgImdgUnNoVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG Amdt No"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG Amdt No"}).getMessage(), ex);
		}		
	} 
	
    /**
     * 로그인 User의 RSO 조회 합니다. <br>
     * 
     * @param SignOnUserAccount account
     * @return String
     * @throws EventException
     */
    public String searchRSOforUser(SignOnUserAccount account) throws EventException{
        try {
            return dbDao.searchRSOforUser(account.getUsr_id());
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Login User RSO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Login User RSO"}).getMessage(), ex);
		}		
    }
}