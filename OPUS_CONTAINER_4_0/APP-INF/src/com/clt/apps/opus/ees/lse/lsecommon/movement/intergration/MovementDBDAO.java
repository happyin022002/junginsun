/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MovementDBDAO.java
*@FileTitle : Container Movement Status Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.10 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.movement.intergration;

import java.sql.SQLException;

import java.util.List;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmMvmtStsVO;


/**
 * MovementDBDAO <br>
 * Movement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jang Jun-Woo
 * @see MovementBCImpl 참조
 * @since J2EE 1.6
 */
public class MovementDBDAO extends DBDAOSupport {

	/**
	 * Container Movement Status 코드목록을 조회합니다.<br>
	 *
	 * @return List<MdmMvmtSts>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmMvmtStsVO> searchContainerMovementStatusListData() throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmMvmtStsVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MovementDBDAOContainerMovementStatusRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmMvmtStsVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}