/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonBCImpl.java
*@FileTitle : AccountPayableCommonBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.accountpayablecommon.basic;

import java.util.List;
import com.hanjin.bizcommon.accountpayablecommon.integration.AccountPayableCommonDBDAO;
import com.hanjin.bizcommon.accountpayablecommon.vo.CenterListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * AccountPayableCommon Business Logic implementation 
 * 
 * @author 
 * @see AccountPayableCommonSC
 * @since J2EE 1.6
 */ 
public class AccountPayableCommonBCImpl extends BasicCommandSupport implements AccountPayableCommonBC {	

	// Database Access Object
    private transient AccountPayableCommonDBDAO dbDao = null;    
    
    public AccountPayableCommonBCImpl()
    {
        dbDao = new AccountPayableCommonDBDAO();        
    }


    /**
     * [COM_COM_0440]
     * Cenetr List Popup<br>
     * 
     * @param CenterListVO centerListVO
     * @return List<CenterListVO>
     * @exception EventException
     */    
    public List<CenterListVO> searchPopCenterListVO(CenterListVO centerListVO) throws EventException {
    	try {
    		return dbDao.searchPopCenterList(centerListVO);
  		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
    }

   
	
	
}