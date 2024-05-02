/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OCPChgColmanageBCImpl
*@FileTitle : OCP Charge Collection Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.integration.OCPChgColmanageDBDAO;
import com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.vo.SearchOCPChgListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OCPChgColmanageBCImpl<br>
 * checking collectable US OCP charge, input goings-on 
 */
public class OCPChgColmanageBCImpl extends BasicCommandSupport implements OCPChgColmanageBC {

	
	// Database Access Object 
	private transient OCPChgColmanageDBDAO dbDao = null;

	/**
	 * OCPChgColmanageBCImpl Create Object<br>
	 * Create OCPChgColmanageDBDAO<br>
	 */
	public OCPChgColmanageBCImpl(){
		dbDao = new OCPChgColmanageDBDAO();
	}
	
	/**
	 * ESD_EAS_0010 : Retrieve<br>
	 * [US OCP charge collection]<br>
	 * 
	 * @param SearchOCPChgListVO searchOCPChgListVO
	 * @return List<SearchOCPChgListVO>
	 * @exception EventException
	 */
	public List<SearchOCPChgListVO> searchOcpChgList(SearchOCPChgListVO searchOCPChgListVO) throws EventException {
		try {
			return dbDao.searchOcpChgList(searchOCPChgListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	

}
