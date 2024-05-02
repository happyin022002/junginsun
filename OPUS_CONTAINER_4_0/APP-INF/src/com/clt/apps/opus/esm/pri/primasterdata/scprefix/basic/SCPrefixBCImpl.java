/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCPrefixBCImpl.java
*@FileTitle : S/C Prefix Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.scprefix.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.scprefix.integration.SCPrefixDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.scprefix.vo.PriScPfxMapgListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScPfxMapgVO;
import com.clt.syscommon.common.table.PriScPfxVO;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 * - Handling a biz logic about PRIMasterData<br>
 *
 * @author
 * @see UI_PRI_0014EventResponse,SCPrefixBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class SCPrefixBCImpl extends BasicCommandSupport implements SCPrefixBC {

	// Database Access Object
	private transient SCPrefixDBDAO dbDao = null;

	/**
	 * Creating SCPrefixBCImpl object<br>
	 * Creating SCPrefixDBDAO.<br>
	 */
	public SCPrefixBCImpl() {
		dbDao = new SCPrefixDBDAO();
	}

	/**
	 * Retrieving S/C Prefix and Scope Mapping List<br>
	 * 
	 * @param PriScPfxMapgVO priScPfxMapgVO
	 * @return List<PriScPfxMapgListVO>
	 * @exception EventException
	 */
	public List<PriScPfxMapgListVO> searchSCPrefixMappingList (PriScPfxMapgVO priScPfxMapgVO) throws EventException {
        try {
            return dbDao.searchSCPrefixMappingList(priScPfxMapgVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
    }

	/**
	 * Retrieving S/C Prefix <br>
	 * 
	 * @param PriScPfxVO priScPfxVO
	 * @return List<PriScPfxVO>
	 * @exception EventException
	 */
	public List<PriScPfxVO> searchSCPrefixList (PriScPfxVO priScPfxVO) throws EventException {
        try {
            return dbDao.searchSCPrefixList(priScPfxVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
    }

	/**
	 * Saving S/C Prefix and Scope Mapping List <br>
	 * 
	 * @param PriScPfxMapgVO[] priScPfxMapgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSCPrefixMapping (PriScPfxMapgVO[] priScPfxMapgVOs, SignOnUserAccount account)
            throws EventException {
        try {
            for (int i = 0; i < priScPfxMapgVOs.length; i++) {
                if (priScPfxMapgVOs[i].getIbflag().equals("I")) {
                    priScPfxMapgVOs[i].setCreUsrId(account.getUsr_id());
                    dbDao.addSCPrefixMapping(priScPfxMapgVOs[i]);
                } else if (priScPfxMapgVOs[i].getIbflag().equals("U")) {
                    priScPfxMapgVOs[i].setUpdUsrId(account.getUsr_id());
                    dbDao.modifySCPrefixMapping(priScPfxMapgVOs[i]);
                } else if (priScPfxMapgVOs[i].getIbflag().equals("D")) {
                    dbDao.removeSCPrefixMapping(priScPfxMapgVOs[i]);
                }
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
        }
    }

    /**
     * Saving S/C Prefix<br>
     * 
     * @param PriScPfxVO[] priScPfxVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageSCPrefix (PriScPfxVO[] priScPfxVOs, SignOnUserAccount account) throws EventException {
        try {
            for (int i = 0; i < priScPfxVOs.length; i++) {
                if (priScPfxVOs[i].getIbflag().equals("I")) {
                    priScPfxVOs[i].setCreUsrId(account.getUsr_id());
                    dbDao.addSCPrefix(priScPfxVOs[i]);
                } else if (priScPfxVOs[i].getIbflag().equals("U")) {
                    priScPfxVOs[i].setUpdUsrId(account.getUsr_id());
                    dbDao.modifySCPrefix(priScPfxVOs[i]);
                } else if (priScPfxVOs[i].getIbflag().equals("D")) {
                    priScPfxVOs[i].setUpdUsrId(account.getUsr_id());
                    priScPfxVOs[i].setDeltFlg("Y");
                    dbDao.removeSCPrefix(priScPfxVOs[i]);
                }
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
        }
    }

    /**
     * Retrieving whether the prfix is in use at S/C Prefix and Scope Mapping <br>
     * 
     * @param PriScPfxVO[] priScPfxVOs
     * @return String
     * @exception EventException
     */
    public String searchUsedPrefix (PriScPfxVO[] priScPfxVOs) throws EventException {
        try {
            boolean isUsed = false;
            boolean isFirst = true;
            StringBuffer sbUsedData = new StringBuffer();
            for (int i = 0; i < priScPfxVOs.length; i++) {
                if (priScPfxVOs[i].getIbflag().equals("D")) {
                    isUsed = dbDao.searchUsedPrefix(priScPfxVOs[i]);
                    if (isUsed) {
                        if (!isFirst) {
                            sbUsedData.append(";");
                        }
                        sbUsedData.append(priScPfxVOs[i].getScPfxCd());
                        isFirst = false;
                    }
                }
            }
            return sbUsedData.toString();
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
    }
}