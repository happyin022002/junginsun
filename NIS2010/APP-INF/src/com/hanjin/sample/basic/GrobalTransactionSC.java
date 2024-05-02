/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : BST
*@FileName       : GrobalTransactionSC.java
*@FileTitle      	 : 
*@Author           : Jeong-Hoon, KIM
*Open Issues     :
*Change history  :
*@LastModifyDate : 2011. 9. 30.
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.sample.basic;

import java.sql.SQLException;
import java.util.Map;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * GrobalTransactionSC.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2011. 9. 30.
 */
public class GrobalTransactionSC extends ServiceCommandSupport {

	@Override
	public EventResponse perform(Event ev) throws EventException {
		begin();
		
		Map<String,String> map = null;
		try {
			new SQLExecuter("DEFAULTXA").executeUpdate(new GlobalTransactionISQL(), map, map);
			new SQLExecuter("DMT_HJSBAT").executeUpdate(new GlobalTransactionISQL(), map, map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commit();
		
		return null;
	}

}

