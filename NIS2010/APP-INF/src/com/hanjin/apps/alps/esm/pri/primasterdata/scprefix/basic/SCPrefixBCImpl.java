/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCPrefixBCImpl.java
*@FileTitle : S/C Prefix Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.04.16 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.integration.SCPrefixDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.vo.PriScPfxMapgListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScPfxMapgVO;
import com.hanjin.syscommon.common.table.PriScPfxVO;

/**
 * NIS2010-PRIMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Moon Dong Gyu
 * @see UI_PRI_0014EventResponse,SCPrefixBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCPrefixBCImpl extends BasicCommandSupport implements SCPrefixBC {

	// Database Access Object
	private transient SCPrefixDBDAO dbDao = null;

	/**
	 * SCPrefixBCImpl 객체 생성<br>
	 * SCPrefixDBDAO를 생성한다.<br>
	 */
	public SCPrefixBCImpl() {
		dbDao = new SCPrefixDBDAO();
	}

	/**
	 * S/C Prefix and Scope Mapping List 를 조회합니다.<br>
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
	 * S/C Prefix 를 조회합니다.<br>
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
	 * S/C Prefix and Scope Mapping List 를 저장합니다.<br>
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
     * S/C Prefix 를 저장합니다.<br>
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
     * S/C Prefix and Scope Mapping 에서 사용하는 Prefix 인지 여부를 조회합니다.<br>
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