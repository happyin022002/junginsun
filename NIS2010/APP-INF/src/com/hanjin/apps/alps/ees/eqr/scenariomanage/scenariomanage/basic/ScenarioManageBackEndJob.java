/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioManageBackEndJob.java
*@FileTitle : Inquire Scenario ID List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.22 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.basic;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration.ScenarioManageDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-ScenarioManage Business Logic Basic Command implementation<br>
 * - ALPS-ScenarioManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0002EventResponse,ScenarioManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ScenarioManageBackEndJob extends BackEndCommandSupport{

	// Database Access Object
	private ScenarioManageDBDAO dbDao = null;
	
	// parameter ( 넘겨주는 파라메너 xml 또는 String )
	String paramString = "";
	
	/**
	 * parameter get 
	 * @return String  
	 */
	public String getParamString() {
		return paramString;
	}

	/**
	 * parameter set 
	 * @param paramString
	 */
	public void setParamString(String paramString) {
		this.paramString = paramString;
	}

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 8226210199438116006L;

	/**
	 * doStart
	 * @return null 
	 */
	public Object doStart() throws Exception {
		dbDao	= new ScenarioManageDBDAO();
//		if( log.isDebugEnabled())
//		{
//			log.debug("\n\n==> " + paramString );
//		}
		
		   try{
			dbDao.createNewScenarioID_jms(paramString);   
			   
	    	}catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		    }
	   
		return null;
	}

}