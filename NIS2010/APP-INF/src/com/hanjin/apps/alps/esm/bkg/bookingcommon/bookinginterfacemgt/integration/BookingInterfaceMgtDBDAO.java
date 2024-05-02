/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingInterfaceMgtDBDAO.java
*@FileTitle : Booking Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.10.22 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.basic.BookingInterfaceMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.vo.SearchBkgInfoForINVVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.vo.SearchBkgInfoForINV_ChargeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.vo.SearchBkgInfoForINV_CntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.vo.SearchBkgInfoForINV_HdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS BookingInterfaceMgtDBDAO <br>
 * - ALPS-BookingCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Ki Jong
 * @see BookingInterfaceMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class BookingInterfaceMgtDBDAO extends DBDAOSupport {

	/**
	 * BKG에서 INV로 INTERFACE할 정보를 조회한다.<br>
	 * 
	 * @param String  bkgNo
	 * @return SearchBkgInfoForINVVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchBkgInfoForINVVO searchBkgInfoForINVVO(String  bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBkgInfoForINV_HdVO> hd_list = null;
		List<SearchBkgInfoForINV_CntrVO> cntr_list = null;
		List<SearchBkgInfoForINV_ChargeVO> charge_list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		SearchBkgInfoForINVVO searchBkgInfoForINVVO = new SearchBkgInfoForINVVO();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			/*1.Header*/
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingInterfaceMgtDAOSearchBkgInfoForINV_1RSQL(), param, velParam);
			hd_list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBkgInfoForINV_HdVO .class);
			
			/*2.Container*/
			dbRowset = null;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingInterfaceMgtDAOSearchBkgInfoForINV_2RSQL(), param, velParam);
			cntr_list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBkgInfoForINV_CntrVO .class);
			
			/*3.Charge*/
			dbRowset = null;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingInterfaceMgtDAOSearchBkgInfoForINV_3RSQL(), param, velParam);
			charge_list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBkgInfoForINV_ChargeVO .class);
			
			searchBkgInfoForINVVO.setSearchBkgInfoForINV_HdVOs(hd_list);
			searchBkgInfoForINVVO.setSearchBkgInfoForINV_CntrVOs(cntr_list);
			searchBkgInfoForINVVO.setSearchBkgInfoForINV_ChargeVOs(charge_list);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchBkgInfoForINVVO;
	}
}