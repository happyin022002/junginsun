/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingDBDAO.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargeAutoratingListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS SurchargeAutoRatingDBDAO <br>
 * - OPUS-SurchargeAutoRatingDBDAO system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LEE JINSEO
 * @see RfaOftAutoRatingBCImpl 참조
 * @since J2EE 1.6
 */
public class SurchargeAutoRatingDBDAO extends DBDAOSupport {



	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking RfaAmericaOft AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 각 지역별 특화된 Surcharge (추가[특별] 요금, 할증료, 추징금, 부가금[세] )를 찾아오는 서비스
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd 
	 * @param String CMDTCd
	 * @param String ctrtTpCd
	 * @return List<SearchSurchargeAutoratingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSurchargeAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd , String CMDTCd, String ctrtTpCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSurchargeAutoratingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("ca_flag", caFlag);
			param.put("svc_scp_cd", scpCd);
			param.put("cmdt_cd", CMDTCd);
			param.put("ctrt_tp_cd", ctrtTpCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeAutoRatingDBDAOSearchSurchargeAutoratingListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScNoteOutVO.class);

		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	

}
