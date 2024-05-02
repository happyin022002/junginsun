/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGInternalFinderBCImpl.java
*@FileTitle : SCG COMMON
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.02 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration.SCGInternalFinderDBDAO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.CheckUNNumberVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.SearchUNNumberVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.vo.CheckPckCdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgSpclProviVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoVO;
import com.hanjin.syscommon.common.table.ScgIrrTpCdVO;

/**
 * ALPS-SCGCommon Business Logic Basic Command implementation<br>
 * - ALPS-SCGCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Dohyoung Lee
 * @see SCG_COM_INTERNALEventResponse,SCGInternalFinderBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SCGInternalFinderBCImpl extends BasicCommandSupport implements SCGInternalFinderBC {

	// Database Access Object
	private transient SCGInternalFinderDBDAO dbDao = null;

	/**
	 * SCGInternalFinderBCImpl 객체 생성<br>
	 * SCGInternalFinderDBDAO를 생성한다.<br>
	 */
	public SCGInternalFinderBCImpl() {
		dbDao = new SCGInternalFinderDBDAO();
	}

	/**
	 * UN No.를 조회 합니다. <br>
	 * 
	 * @param unNumberCode 
	 * @return List<CheckUNNumberVO>
	 * @exception EventException
	 */
	public List<CheckUNNumberVO> checkUNNumber(String unNumberCode) throws EventException {
		try {
			return dbDao.checkUNNumber(unNumberCode);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
		}		
	}
	
	/**
	 * Class 를 조회 합니다. <br>
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
	 * Special Provisions 를 조회 합니다. <br>
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
	 * Akward 유형에 따라 Irregular Type 을 조회합니다. <br>
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
	 * IMDG UN Number 의 List를 조회 합니다. <br>
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
     * SPCL CGO Irregular List 의 UN No. 를 Check 합니다. <br>
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
     * IMDG UN Number 의 Total 건수를 조회 합니다. <br>
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
     * IMDG UN Number 의  Seq 를 조회 합니다. <br>
     * 
     * @param ScgImdgUnNoVO
     * @return List<ScgImdgUnNoVO> 
     * @throws EventException
     */
	public List<ScgImdgUnNoVO> searchImdgUnNoSeqList(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException{
        try {
            return dbDao.searchImdgUnNoSeqList(scgImdgUnNoVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No Seq"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No Seq"}).getMessage(), ex);
		}		
    } 

    /**
     * IMDG UN No, IMDG UN No Seq 의 Class, Sub Risk, PG 를 조회 합니다. <br>
     * 
     * @param ScgImdgUnNoVO
     * @return List<PartnerApprovalRequestVO> 
     * @throws EventException
     */
	public List<PartnerApprovalRequestVO> searchClassSubRiskPGData(ScgImdgUnNoVO scgImdgUnNoVO) throws EventException{
        try {
            return dbDao.searchClassSubRiskPGData(scgImdgUnNoVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No Seq"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMDG UN No Seq"}).getMessage(), ex);
		}		
    }
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param pckCd
	 * @return List<CheckPckCdVO>
	 * @exception EventException
	 */
	public List<CheckPckCdVO> checkPckCd(String pckCd) throws EventException {
		try {
			return dbDao.checkPckCd(pckCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
}