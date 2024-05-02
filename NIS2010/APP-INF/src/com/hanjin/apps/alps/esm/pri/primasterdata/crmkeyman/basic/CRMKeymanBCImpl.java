/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CRMKeymanBCImpl.java
*@FileTitle : CRM Keyman Info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.08.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmkeyman.basic;

import com.hanjin.apps.alps.esm.pri.primasterdata.crmkeyman.integration.CRMKeymanDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCrmCustKmanVO;

/**
 * NIS2010-PRIMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Moon Dong Gyu
 * @see EventResponse,CRMKeymanBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class CRMKeymanBCImpl extends BasicCommandSupport implements CRMKeymanBC {

	// Database Access Object
	private transient CRMKeymanDBDAO dbDao = null;

	/**
	 * CRMKeymanBCImpl 객체 생성<br>
	 * CRMKeymanDBDAO를 생성한다.<br>
	 */
	public CRMKeymanBCImpl() {
		dbDao = new CRMKeymanDBDAO();
	}

    /**
     * CRM으로부터 받은 Keyman 정보를 저장합니다.<br>
     * 
     * @param PriCrmCustKmanVO[] priCrmCustKmanVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void receiveCRMKeyman(PriCrmCustKmanVO[] priCrmCustKmanVOs, SignOnUserAccount account) throws EventException{
        try {
            if (priCrmCustKmanVOs != null) {
                int cnt = priCrmCustKmanVOs.length;

                // 기존 데이터 삭제
                for (int i = 0 ; i < cnt ; i++) {
                    dbDao.removeCRMKeyman(priCrmCustKmanVOs[i]);
                }

                for (int i = 0 ; i < cnt ; i++) {
                    dbDao.addCRMKeyman(priCrmCustKmanVOs[i]);
                }
            }

        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }
}