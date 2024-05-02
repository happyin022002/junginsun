/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermDBDAO.java
*@FileTitle : Lease Term Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.leaseterm.integration;

import java.sql.SQLException;

import java.util.List;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MstLseTermVO;


/**
 * LeaseTermDBDAO <br>
 * LeaseTerm system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Nho Jung Yong
 * @see LeaseTermBCImpl 참조
 * @since J2EE 1.4
 */
public class LeaseTermDBDAO extends DBDAOSupport {

	/**
	 * Lease Term의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @return List<MstLseTermVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MstLseTermVO> searchLeaseTermComboItemData() throws DAOException {

		DBRowSet dbRowset = null;
		List<MstLseTermVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseTermDBDAOLeaseTermComboItemRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MstLseTermVO.class);
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