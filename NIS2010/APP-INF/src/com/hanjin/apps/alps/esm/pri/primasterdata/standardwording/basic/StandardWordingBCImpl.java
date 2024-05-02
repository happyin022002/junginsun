/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StandardWordingBCImpl.java
*@FileTitle : Standard Wording for S/C Notes
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.13 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.integration.StandardWordingDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScStndWdgVO;

/**
 * NIS2010-PRIMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0085EventResponse,StandardWordingBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class StandardWordingBCImpl extends BasicCommandSupport implements StandardWordingBC {

	// Database Access Object
	private transient StandardWordingDBDAO dbDao = null;

	/**
	 * StandardWordingBCImpl 객체 생성<br>
	 * StandardWordingDBDAO를 생성한다.<br>
	 */
	public StandardWordingBCImpl() {
		dbDao = new StandardWordingDBDAO();
	}

	/**
	 * Standard Wording for S/C Notes 를 조회합니다.<br>
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
	 * Standard Wording for S/C Notes 를 저장합니다.<br>
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