/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COPManageDBDAO.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : minestar
*@LastVersion : 1.0
* 2006-11-20 minestar
* 1.0 최초 생성
* 2009-03-10 JSAN [N200903100120] [SCEM] COP History 화면 보완 요청; Event Date(여기서는 CRE_DT) 에서 보여주는 시간정보 단위를 시/분 단위로 확대
* 
* 2009-05-14 iskim
* 	(1) N200905070100	SCEM 315 CX Status 개발 요청 
* 		MH 추가 : Container attach 시에 Finish 됨을 history 로 명시
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.cophsitory.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.apps.opus.esd.sce.copreport.cophsitory.basic.COPHistoryBCImpl;
import com.clt.apps.opus.esd.sce.copreport.cophsitory.vo.SearchCOPHistoryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * SCE에 대한 DB 처리를 담당<br>
 * - SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author minestar
 * @see COPHistoryBCImpl 참조
 * @since J2EE 1.4
 */
public class COPHistoryDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * minestar - COP 의 History 검색.
     * @param  COPInquiryVO inqVO
     * @return List<SearchCOPHistoryVO>
     * @exception EventException
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchCOPHistoryVO> searchCOPHistory(COPInquiryVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCOPHistoryVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (inqVO.getBkgNo() != null && inqVO.getBkgNo().trim().length() > 0) {
				velParam.put("bkg_no", inqVO.getBkgNo());
				param.put("bkg_no", inqVO.getBkgNo());					
			}			
			if (inqVO.getCopNo() != null && inqVO.getCopNo().trim().length() > 0) {
				velParam.put("cop_no", inqVO.getCopNo());
				param.put("cop_no", inqVO.getCopNo());					
			}				

			if (inqVO.getCntrNo() != null && inqVO.getCntrNo().trim().length() > 0) {
				velParam.put("cntr_no", inqVO.getCntrNo());
				param.put("cntr_no", inqVO.getCntrNo());					
			}

			if (inqVO.getBlNo() != null && inqVO.getBlNo().trim().length() > 0) {
				velParam.put("bl_no", inqVO.getBlNo());
				param.put("bl_no", inqVO.getBlNo());					
			}
			if (inqVO.getPageNo() != null && inqVO.getPageNo().trim().length() > 0) {
				//velParam.put("page_no", inqVO.getPageNo());
				param.put("page_no", inqVO.getPageNo());					
			}				
			if (inqVO.getPagerows() != null && inqVO.getPagerows().trim().length() > 0) {
				//velParam.put("pagerows", inqVO.getPagerows());
				param.put("pagerows", inqVO.getPagerows());					
			}	
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPHistoryDBDAOSearchCOPHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCOPHistoryVO .class);				

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

        return list;
    }	
    	
}