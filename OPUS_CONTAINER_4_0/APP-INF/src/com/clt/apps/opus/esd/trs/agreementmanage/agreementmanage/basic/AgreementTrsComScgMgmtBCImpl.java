/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : AgreementTrsComScgMgmtBCImpl.java
*@FileTitle      : Common Surcharge Management
*Open Issues     : 
*Change history  : 
*@LastModifyDate : 2014-11-05
*@LastModifier   : Hyungwook Choi
*@LastVersion    : 1.0
* 2014-11-05 Hyungwook Choi
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0237Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration.AgreementTrsComScgMgmtDBDAO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsComScgMgmtTpSzVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
  * ESD-TRS Business Logic Basic Command implementation
  * - ESD-TRS에 대한 비지니스 로직을 처리한다.
  * @author agreement
  * @see ESD_TRS_0237EventResponse, AgreementTrsComScgMgmtBC 각 DAO 클래스 참조
  * @since J2EE 1.4
  */
public class AgreementTrsComScgMgmtBCImpl extends BasicCommandSupport implements AgreementTrsComScgMgmtBC {
    private transient AgreementTrsComScgMgmtDBDAO dbDao = null;

    /**
     * AgreementTrsComScgMgmtBCImpl 객체 생성
     * AgreementTrsComScgMgmtDBDAO 를 생성한다.
     */
    public AgreementTrsComScgMgmtBCImpl() {
        dbDao = new AgreementTrsComScgMgmtDBDAO();
    }

    /**
     * Selecting Common Surcharge Management ( ESD_TRS_0237 )
     * 
     * @param trsComScgMgmtTpSzVO
     * @param account
     * @return
     * @throws EventException
     */
    public List<TrsComScgMgmtTpSzVO> searchTrsComScgMgmt(TrsComScgMgmtTpSzVO trsComScgMgmtTpSzVO, SignOnUserAccount account) throws EventException {
        try {
        	trsComScgMgmtTpSzVO.setUsrOfcCd(account.getOfc_cd());
            return dbDao.searchTrsComScgMgmt(trsComScgMgmtTpSzVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Modifing Common Surcharge Management ( ESD_TRS_0237 )
     * 
     * @param trspTmpSeq
     * @throws EventException
     */
    public void multiTrsComScgMgmt(String trspTmpSeq) throws EventException {
        try {
            dbDao.multiTrsComScgMgmt(trspTmpSeq);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }

    /**
     * Deleting Common Surcharge Management ( ESD_TRS_0237 )
     * 
     * @param trsComScgMgmtTpSzVOs
     * @param account
     * @throws EventException
     */
    public void deleteTrsComScgMgmt(TrsComScgMgmtTpSzVO[] trsComScgMgmtTpSzVOs, SignOnUserAccount account) throws EventException {
        try {
            for ( int i=0; i < trsComScgMgmtTpSzVOs.length; i++ ) {
                dbDao.deleteTrsComScgMgmt(trsComScgMgmtTpSzVOs[i]);
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * Searching ComboList of RCC Code
     * 
     * @param e
     * @return
     * @throws EventException
     */
    public List<TrsComScgMgmtTpSzVO> searchRccCdComList(Event e) throws EventException {
    	List<TrsComScgMgmtTpSzVO> list = null;
    	EsdTrs0237Event event = (EsdTrs0237Event)e;
    	try {
    		list = dbDao.searchRccCdComList(event);
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
    }

	/**
	 * Insert Common Surcharge Temp ( ESD_TRS_0237 )
	 * 
	 * @param trsComScgMgmtTpSzVOs
	 * @param userId
	 * @return trspTmpSeq
	 * @throws EventException
	 */
	public String insertAgmtVerifyData(List<TrsComScgMgmtTpSzVO> trsComScgMgmtTpSzVOs, String userId) throws EventException {
		String trspTmpSeq = "";
        try {
        	trspTmpSeq = dbDao.insertAgmtVerifyData(trsComScgMgmtTpSzVOs, userId);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
		return trspTmpSeq;
	}

    /**
     * Check Verification of Common Surcharge Temp ( ESD_TRS_0237 )
     * 
     * @param trspTmpSeq
     * @return DBRowSet
     * @throws EventException
     */
	public DBRowSet verifySurcharge(String trspTmpSeq) throws EventException {
        DBRowSet             rowSet = null;
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	rowSet = dbDao.verifySurcharge(trspTmpSeq);
//            eventResponse.setRsVo(rowSet);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return rowSet;
	}

    /**
     * Deleting Common Surcharge Temp ( ESD_TRS_0237 )
     * 
     * @param tmpTblSeq
     * @throws EventException
     */
	public void deleteTrsAgmtTmp(String tmpTblSeq) throws EventException {
        try {
            dbDao.deleteTrsAgmtTmp(tmpTblSeq);
        } catch (DAOException de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err "+de.toString(), de);
            throw new EventException(de.getMessage());
        }
	}
}
