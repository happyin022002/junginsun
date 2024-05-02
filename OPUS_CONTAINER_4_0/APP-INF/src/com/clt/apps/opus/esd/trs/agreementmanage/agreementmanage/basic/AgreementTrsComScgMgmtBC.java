/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : AgreementTrsComScgMgmtBC.java
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

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsComScgMgmtTpSzVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Command Interface
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스
 * @author Hyungwook Choi
 * @see EsdTrs0237EventResponse 참조
 * @since J2EE 1.5
 */
public interface AgreementTrsComScgMgmtBC {
	/**
	 * Selecting Common Surcharge Management ( ESD_TRS_0237 )
	 * 
	 * @param trsComScgMgmtTpSzVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public List<TrsComScgMgmtTpSzVO> searchTrsComScgMgmt(TrsComScgMgmtTpSzVO trsComScgMgmtTpSzVO, SignOnUserAccount account) throws EventException;

    /**
     * Modifing Common Surcharge Management ( ESD_TRS_0237 )
     * 
     * @param trspTmpSeq
     * @throws EventException
     */
    public void multiTrsComScgMgmt(String trspTmpSeq) throws EventException;

    /**
     * Deleting Common Surcharge Management ( ESD_TRS_0237 )
     * 
     * @param trsComScgMgmtTpSzVOs
     * @param account
     * @throws EventException
     */
    public void deleteTrsComScgMgmt(TrsComScgMgmtTpSzVO[] trsComScgMgmtTpSzVOs, SignOnUserAccount account) throws EventException;

    /**
     * Searching ComboList of RCC Code
     * 
     * @param e
     * @return
     * @throws EventException
     */
    public List<TrsComScgMgmtTpSzVO> searchRccCdComList(Event e) throws EventException;

	/**
	 * Insert Common Surcharge Temp ( ESD_TRS_0237 )
	 * 
	 * @param trsComScgMgmtTpSzVOs
	 * @param userId
	 * @return trspTmpSeq
	 * @throws EventException
	 */
	public String insertAgmtVerifyData(List<TrsComScgMgmtTpSzVO> trsComScgMgmtTpSzVOs, String userId) throws EventException;

    /**
     * Check Verification of Common Surcharge Temp ( ESD_TRS_0237 )
     * 
     * @param trspTmpSeq
     * @return DBRowSet
     * @throws EventException
     */
	public DBRowSet verifySurcharge(String trspTmpSeq) throws EventException;

    /**
     * Deleting Common Surcharge Temp ( ESD_TRS_0237 )
     * 
     * @param trspTmpSeq
     * @throws EventException
     */
	public void deleteTrsAgmtTmp(String trspTmpSeq) throws EventException;
}
