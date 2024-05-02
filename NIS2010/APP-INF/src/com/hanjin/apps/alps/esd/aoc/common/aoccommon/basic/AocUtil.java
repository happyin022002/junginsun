/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AocUtil.java
*@FileTitle : Aoc Page
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* ------------------------------------------------------
* HISTORY
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic;

import com.hanjin.apps.alps.esd.aoc.common.aoccommon.integration.AocUtilDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import java.util.List;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.vo.AocComboVO;

/**
 * AOC에서 공통으로 사용 할 Utility class<br>
 *
 * @author Min Jung Ho
 * @see AOC에서 공통으로 사용 할 Utility class
 * @since J2EE 1.6
 */
public class AocUtil
{
	// Database Access Object
	private transient AocUtilDBDAO dbDao = null;
	
    /**
     * AocUtil 객체 생성<br>
     * AocUtilDBDAO를 생성한다.<br>
     */	
    public AocUtil()
    {
        dbDao = new AocUtilDBDAO();
    }

    /**
     * 공통콤보 목록조회<br>
     * 
     * @param String comCode
     * @return List<AocComboVO>
     * @exception EventException
     */    
    public List<AocComboVO> searchCombo(String comCode) throws EventException
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
