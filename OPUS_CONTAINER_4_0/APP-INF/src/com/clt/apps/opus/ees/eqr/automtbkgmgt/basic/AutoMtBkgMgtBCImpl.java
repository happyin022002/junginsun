/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: CntrAccuracyTrendBCImpl.java
*@FileTitle 	: Accuracy Trend
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.automtbkgmgt.vo.AutoMtBkgVO;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.integration.AutoMtBkgMgtDBDAO;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * @author 
 * @see EventResponse,AutoMtBkgMgtBC 
 * @since J2EE 1.6
 */
public class AutoMtBkgMgtBCImpl extends BasicCommandSupport implements AutoMtBkgMgtBC {

	// Database Access Object
	private transient AutoMtBkgMgtDBDAO dbDao = null;

	/**
	 * AutoMtBkgMgtBCImpl <br>
	 * Create AutoMtBkgMgtDBDAO <br>
	 */
	public AutoMtBkgMgtBCImpl() {
		dbDao = new AutoMtBkgMgtDBDAO();
	}
	
	/**
	 * Auto Mt Booking : Retrieve<br>
	 * query information. <br>
	 * 
	 * @return List<AutoMtBkgVO>
	 * @exception EventException
	 */ 
	public List<AutoMtBkgVO> searchAutoMtBkg() throws EventException{ 
		//Auto-generated method stub
		try {						
			return dbDao.searchAutoMtBkg();
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
}