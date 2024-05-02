/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TrsUtilDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.07.26
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.06.04 민정호
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2011.07.26 민정호 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration;

import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsComboVO;
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
 * NIS2010 TrsUtilDAO <br>
 * - NIS2010-BookingCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Min Jung Ho
 * @see TrsUtil 참조
 * @since J2EE 1.4
 */

public class TrsUtilDBDAO extends DBDAOSupport
{
	/**
	 * searchCombo  이벤트 처리<br>
	 * @author Min Jung Ho
	 * @param String comCode
	 * @return List<TrsComboVO>
	 * @exception EventException
	 */	
    public List<TrsComboVO> searchCombo(String comCode) throws DAOException
    {
        DBRowSet dbRowset = null;
        List<TrsComboVO> list = null;
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
            TrsUtilDBDAOTrsComboRSQL template = new TrsUtilDBDAOTrsComboRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = new ArrayList<TrsComboVO>();
            while (dbRowset.next()) 
            {
            	TrsComboVO vo = new TrsComboVO();
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