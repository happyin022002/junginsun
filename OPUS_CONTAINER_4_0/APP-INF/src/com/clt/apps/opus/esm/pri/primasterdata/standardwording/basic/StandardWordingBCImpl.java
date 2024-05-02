/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StandardWordingBCImpl.java
*@FileTitle : Standard Wording for S/C Notes
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.standardwording.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.standardwording.integration.StandardWordingDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScStndWdgVO;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 * - Handling a biz logic about PRIMasterData<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0085EventResponse,StandardWordingBC  - Refer to each DAO Class
 * @since J2EE 1.4
 */
public class StandardWordingBCImpl extends BasicCommandSupport implements StandardWordingBC {

	// Database Access Object
	private transient StandardWordingDBDAO dbDao = null;

	/**
	 * Creating StandardWordingBCImpl object<br>
	 * Creating StandardWordingDBDAO<br>
	 */
	public StandardWordingBCImpl() {
		dbDao = new StandardWordingDBDAO();
	}

	/**
	 * Retrieving Standard Wording for S/C Notes <br>
	 * 
	 * @param PriScStndWdgVO priScStndWdgVO
	 * @return List<PriScStndWdgVO>
	 * @exception EventException
	 */
	public List<PriScStndWdgVO> searchStandardWordingList(PriScStndWdgVO priScStndWdgVO) throws EventException {
		try {
			return dbDao.searchStandardWordingList(priScStndWdgVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving Standard Wording for S/C Notes<br>
	 * 
	 * @param PriScStndWdgVO[] priScStndWdgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageStandardWording(PriScStndWdgVO[] priScStndWdgVOs, SignOnUserAccount account) throws EventException{
		try {
			for ( int i=0; i<priScStndWdgVOs .length; i++ ) {
				if ( priScStndWdgVOs[i].getIbflag().equals("I")){
					priScStndWdgVOs[i].setCreUsrId(account.getUsr_id());
					dbDao.addmanageStandardWording(priScStndWdgVOs[i]);
				} else if ( priScStndWdgVOs[i].getIbflag().equals("U")){
					priScStndWdgVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifymanageStandardWording(priScStndWdgVOs[i]);
				} else if ( priScStndWdgVOs[i].getIbflag().equals("D")){
					dbDao.removemanageStandardWording(priScStndWdgVOs[i]);
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