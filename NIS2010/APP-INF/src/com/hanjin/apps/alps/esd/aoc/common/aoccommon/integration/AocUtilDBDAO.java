/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : AocUtilDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.integration;

import com.hanjin.apps.alps.esd.aoc.common.aoccommon.vo.AocComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * NIS2010 AocUtilDAO <br>
 * - NIS2010-BookingCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see AocUtil 참조
 * @since J2EE 1.4
 */

public class AocUtilDBDAO extends DBDAOSupport
{
	/**
	 * searchCombo  이벤트 처리<br>
	 * @author Min Jung Ho
	 * @param String comCode
	 * @return List<AocComboVO>
	 * @exception EventException
	 */	
    public List<AocComboVO> searchCombo(String comCode) throws DAOException
    {
        DBRowSet dbRowset = null;
        List<AocComboVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try
        {
			log.debug("# SEARCH COMMON-CODE : " + comCode);        	
            param.put("cm_code", comCode);
			if (comCode == null || comCode.length() == 0) {
				// BKG00104 - 필수입력항목
				throw new RuntimeException("BKG00104");
			}            

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            AocUtilDBDAOAocComboRSQL template = new AocUtilDBDAOAocComboRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = new ArrayList<AocComboVO>();
            while (dbRowset.next()) 
            {
            	AocComboVO vo = new AocComboVO();
                vo.setComboCd(dbRowset.getString("intg_cd_id"));
                vo.setVal(dbRowset.getString("intg_cd_val_ctnt"));
                vo.setName(dbRowset.getString("intg_cd_val_dp_desc"));
                vo.setDesc(dbRowset.getString("intg_cd_val_desc"));
				list.add(vo);                
            }
        }
        catch(SQLException se)
        {
            throw new DAOException((new ErrorHandler(se)).getMessage(), se);
        }
        catch(Exception ex)
        {
            throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
        }
        return list;
    }
}