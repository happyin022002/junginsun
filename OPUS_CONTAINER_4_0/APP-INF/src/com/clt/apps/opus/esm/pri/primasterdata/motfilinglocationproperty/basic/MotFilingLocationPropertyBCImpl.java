/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MotFilingLocationPropertyBCImpl.java
*@FileTitle : MOT Base Port Table Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.basic;

import java.util.ArrayList;
import java.util.List;
import com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.integration.MotFilingLocationPropertyDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriMotFileLocPptVO;

/**
 * opus-PRIMasterData Business Logic Command Interface<br>
 * - opus-PRIMasterData에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SongHoJin
 * @see Esm_pri_4035EventResponse 참조
 * @since J2EE 1.6
 */
public class MotFilingLocationPropertyBCImpl extends BasicCommandSupport implements MotFilingLocationPropertyBC {

	// Database Access Object
	private transient MotFilingLocationPropertyDBDAO dbDao = null;

	/**
	 * MotFilingLocationPropertyBCImpl 객체 생성<br>
	 * MotFilingLocationPropertyDBDAO를 생성한다.<br>
	 */
	public MotFilingLocationPropertyBCImpl() {
		dbDao = new MotFilingLocationPropertyDBDAO();
	}
	/**
	 * MOT Filing Location Property 정보를  조회  합니다.<br>
	 * 
	 * @param PriMotFileLocPptVO priMotFileLocPptVO
	 * @return List<PriMotFileLocPptVO>
	 * @exception EventException
	 */
	public List<PriMotFileLocPptVO> searchPriMotFileLocPpt(PriMotFileLocPptVO priMotFileLocPptVO) throws EventException {
		try {
			return dbDao.searchPriMotFileLocPpt(priMotFileLocPptVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * MOT Filing Location Property 정보를  관리  합니다.<br>
	 * 
	 * @param PriMotFileLocPptVO[] priMotFileLocPptVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void managePriMotFileLocPpt(PriMotFileLocPptVO[] priMotFileLocPptVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriMotFileLocPptVO> insertVoList = new ArrayList<PriMotFileLocPptVO>();
			List<PriMotFileLocPptVO> updateVoList = new ArrayList<PriMotFileLocPptVO>();
			List<PriMotFileLocPptVO> deleteVoList = new ArrayList<PriMotFileLocPptVO>();
			for ( int i=0; i<priMotFileLocPptVO .length; i++ ) {
				if ( priMotFileLocPptVO[i].getIbflag().equals("I")){
					priMotFileLocPptVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(priMotFileLocPptVO[i]);
				} else if ( priMotFileLocPptVO[i].getIbflag().equals("U")){
					priMotFileLocPptVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priMotFileLocPptVO[i]);
				} else if ( priMotFileLocPptVO[i].getIbflag().equals("D")){
					priMotFileLocPptVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priMotFileLocPptVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addPriMotFileLocPptS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPriMotFileLocPptS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePriMotFileLocPptS(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
}