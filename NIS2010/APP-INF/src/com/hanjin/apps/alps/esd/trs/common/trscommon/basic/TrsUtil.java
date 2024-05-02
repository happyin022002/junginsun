/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TrsUtil.java
*@FileTitle : Trs Page
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.04.23 민정호
* 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2011.07.26 민정호 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.basic;

import com.hanjin.apps.alps.esd.trs.common.trscommon.integration.TrsUtilDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import java.util.List;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsComboVO;

/**
 * TRS에서 공통으로 사용 할 Utility class<br>
 *
 * @author Min Jung Ho
 * @see TRS에서 공통으로 사용 할 Utility class
 * @since J2EE 1.6
 */
public class TrsUtil extends BasicCommandSupport
{
	// Database Access Object
	private transient TrsUtilDBDAO dbDao = null;
	
    /**
     * TrsUtil 객체 생성<br>
     * TrsUtilDBDAO를 생성한다.<br>
     */	
    public TrsUtil()
    {
        dbDao = new TrsUtilDBDAO();
    }

    /**
     * 공통콤보 목록조회<br>
     * 
     * @param String comCode
     * @return List<TrsComboVO>
     * @exception EventException
     */    
    public List<TrsComboVO> searchCombo(String comCode) throws EventException
    {
        try
        {
            return dbDao.searchCombo(comCode);
        }
        catch(DAOException de)
        {
            throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), de);
        }
        catch(Exception de)
        {
            throw new EventException((new ErrorHandler("COM12240", new String[0])).getMessage(), de);
        }
    }
}
