/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrTpSzDBDAO.java
*@FileTitle : Container Type/Size Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.cntrtpsz.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;


/**
 * CntrTpSzDBDAO <br>
 * CntrTpSz system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Nho Jung Yong
 * @see commonBCImpl 참조
 * @since J2EE 1.4
 */
public class ContainerTypeSizeDBDAO extends DBDAOSupport {

	/**
	 * Container Type/Size의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @return List<MdmCntrTpSzVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCntrTpSzVO> searchContainerTypeSizeListData() throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmCntrTpSzVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery(new ContainerTypeSizeDBDAOContainerTypeSizeListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCntrTpSzVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Container Type Size의 가변적 Header를 조회합니다.<br>
	 *
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchContainerTypeSizeDynamicHeaderData() throws DAOException {
		String cntrTpszHd = "";
		DBRowSet dbRowset = null;

		try{
			dbRowset = new SQLExecuter().executeQuery(new ContainerTypeSizeDBDAOContainerTypeSizeDynamicHeaderRSQL(), null, null);
			if(dbRowset.next()) {
				cntrTpszHd = dbRowset.getString("CNTR_TPSZ_HD");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return cntrTpszHd;
	}
}