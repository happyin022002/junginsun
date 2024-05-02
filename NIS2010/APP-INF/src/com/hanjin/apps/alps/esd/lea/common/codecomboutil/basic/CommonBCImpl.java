/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonBCImpl.java
*@FileTitle : 공통업무 관리 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-20
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-11-20 junghyung kim
* 1.0 최초 생성
* @History
* 2009-09-08 : Ho-Jin Lee Alps 전환
* 2011-05-02 이정수 : Office COMBO가 정상적으로 생성되도록 수정
=========================================================*/
package com.hanjin.apps.alps.esd.lea.common.codecomboutil.basic;

//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.lea.common.codecomboutil.integration.CodeComboUtilDBDAO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostCodeListVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ENIS-Agent Commission에 대한 공통업무 처리를 담당<br>
 * - ENIS-Agent Commission에 대한 공통업무 비지니스 로직을 처리한다.<br>
 * 
 * @author junghyung kim
 * @see CommonBC 참조
 * @since J2EE 1.4
 */
public class CommonBCImpl   extends BasicCommandSupport implements CommonBC {

    // Database Access Object
    private transient CodeComboUtilDBDAO dbDao=null;
    
    /**
     * CommonDBDAO를 생성한다.<br>
     */
    public CommonBCImpl(){
        dbDao = new CodeComboUtilDBDAO();
    }
    
    
    /**
     * 해당 Logistics Office 에 대한 Sub Office List 정보를 조회한다.
     * 
     * @param String ctrlOfcCd
     * @return String
     * @throws EventException
     */
    public String searchLogisticsSubOfficeCodeList(String ctrlOfcCd) throws EventException {
    	
		try {
			DBRowSet dbRowset = dbDao.searchLogisticsSubOfficeCodeList(ctrlOfcCd);
			StringBuffer buf = new StringBuffer();
			
			while(dbRowset.next()) {
				String code = dbRowset.getString(1);
				buf.append(code).append("|");
			}
			
			if(buf.length() > 0)
				buf.deleteCharAt(buf.length()-1);
			
			return buf.toString();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
 
    /**
     * 해당 RHQ 에 대한 Control Office List 정보를 조회한다.
     * 
     * @param String rhqCd
     * @return String
     * @throws EventException
     */
    public String searchCtrlOfficeCodeList(String rhqCd) throws EventException {
    	
		try {
			DBRowSet dbRowset = dbDao.searchCtrlOfficeCodeList(rhqCd);
			StringBuffer buf = new StringBuffer();
			
			while(dbRowset.next()) {
				String code = dbRowset.getString(1);
				buf.append(code).append("|");
			}
			
			if(buf.length() > 0)
				buf.deleteCharAt(buf.length()-1);
			
			return buf.toString();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}   
   

}