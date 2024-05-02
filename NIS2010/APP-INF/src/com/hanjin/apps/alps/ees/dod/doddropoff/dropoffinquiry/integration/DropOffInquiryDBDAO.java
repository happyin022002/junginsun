/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DropOffInquiry.java
*@FileTitle : Drop Off Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-11-04 Jeong-Min Park
* 1.0 최초 생성
*  
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.vo.DropOffInvoiceInquiryDetailListVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.vo.DropOffInvoiceInquiryINVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.vo.DropOffInvoiceInquiryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
//import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * DropOffInquiryDBDAO <br>
 * 
 * @author Jeong-Min Park
 * @see EventSupport
 * @since J2EE 1.4
 */
public class DropOffInquiryDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 7296549438223955377L;

	/**
	 * EES_DOD_0003 : [SEARCH]<br>
	 * DOD Queue List 조회 <br>
	 * 
	 * @param searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @throws DAOException 
	 */
	public List<SearchDodDrpOffChgVO> searchDropOffQueueListInquiryList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDodDrpOffChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchDodDrpOffChgVO != null){
				Map<String, String> mapVO = searchDodDrpOffChgVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(searchDodDrpOffChgVO.getOfcFlg().equals("O")) {
					String ofcCd = searchDodDrpOffChgVO.getOfcCd();
					//log.error("\n DAO.searchDropOffQueueListInquiryList - ofcCd : " + JSPUtil.getNull(ofcCd)+"<<<<<");
					List<String> ofcCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(ofcCd, ",");
				    while (st.hasMoreTokens()) {
				    	ofcCdList.add(st.nextToken());
				    }
					velParam.put("ofc_cd_list", ofcCdList);
				}				
			}
			//log.error("\n DAO velParam - ofcCdList : " + velParam.get("ofc_cd_list") + "<<<< \n");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffInquiryDBDAOSearchDropOffQueueListInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodDrpOffChgVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * EES_DOD_0004 DOD Invoice Inquiry
	 * DOD DropOff Invoice Inquiry 조회
	 * 
	 * @param dropOffInvoiceInquiryINVO
	 * @return List<DropOffInvoiceInquiryListVO>
	 * @throws DAOException
	 */
	public List<DropOffInvoiceInquiryListVO> searchDropOffInvoiceInquiryList(DropOffInvoiceInquiryINVO dropOffInvoiceInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DropOffInvoiceInquiryListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dropOffInvoiceInquiryINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(dropOffInvoiceInquiryINVO.getSBkgNo() != null && dropOffInvoiceInquiryINVO.getSBkgNo().length() > 0) {
				List<String> bkgNos = new ArrayList<String>();
				String[] arrBkgNo = dropOffInvoiceInquiryINVO.getSBkgNo().split(",");
				for(int i = 0; i < arrBkgNo.length; i++) {
					bkgNos.add(arrBkgNo[i]);
				}

				param.put("bkgNos", bkgNos);
				velParam.put("bkgNos", bkgNos);
			}


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DropOffInquiryDBDAOsearchDropOffInvoiceInquiryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DropOffInvoiceInquiryListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * DOD DropOff Invoice Inquiry Detail POPUP 조회
	 * 
	 * @param dropOffInvoiceInquiryINVO
	 * @return List<DropOffInvoiceInquiryDetailListVO>
	 * @throws DAOException
	 */
	public List<DropOffInvoiceInquiryDetailListVO> searchDropOffInvoiceInquiryDetailList(DropOffInvoiceInquiryINVO dropOffInvoiceInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DropOffInvoiceInquiryDetailListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dropOffInvoiceInquiryINVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DropOffInquiryDBDAOsearchDropOffInvoiceInquiryDetailListRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DropOffInvoiceInquiryDetailListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
}
