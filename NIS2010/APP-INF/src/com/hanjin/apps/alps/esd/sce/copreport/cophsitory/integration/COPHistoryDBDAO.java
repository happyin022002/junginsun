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
* 2009.09.03 - 오현경  - NIS2010 Construction 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.cophsitory.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.hanjin.apps.alps.esd.sce.copreport.cophsitory.basic.COPHistoryBCImpl;
import com.hanjin.apps.alps.esd.sce.copreport.cophsitory.vo.SearchCOPHistoryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-SCE에 대한 DB 처리를 담당<br>
 * - ENIS-SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author minestar
 * @see COPHistoryBCImpl 참조
 * @since J2EE 1.4
 */
public class COPHistoryDBDAO extends DBDAOSupport {

	/**
	 * minestar - COP 의 History 검색.
     * @param  COPInquiryVO inqVO
     * @return List<SearchCOPHistoryVO>
     * @exception EventException
	 */
    public List<SearchCOPHistoryVO> searchCOPHistory(COPInquiryVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCOPHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
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
    	
/*
	public DBRowSet searchCOPHistory( RequestDataSetBC dataSet) throws DAOException {


        Connection con    = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBRowSet dbRowSet = new DBRowSet();

        String szBkgNo = dataSet.getString("bkg_no");
        String szBkgNoSplit =dataSet.getString("bkg_no_split");
        String szBlNo =dataSet.getString("bl_no");
        String szCntrNo =dataSet.getString("cntr_no");
        String szCopNo =dataSet.getString("cop_no");

        int i = 1;

        StringBuffer queryString = new StringBuffer("");

        queryString.append ("			select bkg_no, bkg_no_split 											\n");
        queryString.append ("			from bkg_booking 														\n");
        queryString.append ("			where bl_no = substr( ? ,1,10) 											\n");
        queryString.append ("			and BL_NO_TP = substr( ? ,11,1)											\n");
        queryString.append ("			and BL_NO_CHK = substr( ?,12,1) 										\n");


        StringBuffer queryStr = new StringBuffer("") ;

        queryStr.append ("			SELECT																						\n");
        queryStr.append ("			ROWNUM SEQ,																					\n");
        queryStr.append ("			COP_NO,																						\n");
        queryStr.append ("			CNTR_NO,																					\n");
        queryStr.append ("			BKG_NO,BKG_NO_SPLIT,																		\n");
        queryStr.append ("			(CASE																						\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'BR' THEN 'BKG Replan'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'CC' THEN 'COP Create'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'TC' THEN 'Terminal Change'										\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'CN' THEN 'COP Cancel'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'CA' THEN 'CNTR Attach'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'CD' THEN 'CNTR Detach'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'CO' THEN 'CNTR Orphaned'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'OI' THEN 'TRO/O Insert'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'OU' THEN 'TRO/O Update'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'OD' THEN 'TRO/O Delete'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'OR' THEN 'TRO/O Error'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'II' THEN 'TRO/I Insert'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'IU' THEN 'TRO/I Update'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'ID' THEN 'TRO/I Delete'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'IF' THEN 'TRO/I Frustrate'										\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'MC' THEN 'Manual Change'											\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'SO' THEN 'SO Auto Change(O/B)'		 							\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'ST' THEN 'SO Auto Change(Ocean)' 								\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'SI' THEN 'SO Auto Change(I/B)' 									\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'SP' THEN 'SO Validation Pass'									\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'TC' THEN 'Terminal Change'										\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'SC' THEN 'COP Status Change'										\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'ZC' THEN 'COP TP/SZ Change'										\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'MS' THEN 'COP MVMT Start'										\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'MF' THEN 'COP MVMT Finish'										\n");
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'MH' THEN 'COP CNTR Finish'										\n"); //N200905070100	SCEM 315 CX Status 개발 요청 
        queryStr.append ("			    WHEN BKG_EVNT_TP_CD = 'MR' THEN 'Manual Replan'									    	\n");
        queryStr.append ("			END) EVENT,																					\n");
        queryStr.append ("			CNTR_TPSZ_CD,																				\n");
        queryStr.append ("			DECODE(MST_LCL_CD,'X','X','Y') MST_LCL_CD,													\n");
        queryStr.append ("			BKG_STS_CD,																					\n");
        queryStr.append ("			DECODE(COP_STS_CD,'C','Create','T','In-Transit','X','Cancel','M','Manual Close','F','Closed') COP_STS_CD,	\n");
        queryStr.append ("			DECODE(COP_SUB_STS_CD,'R','Y','N') COP_SUB_STS_CD,											\n");
        queryStr.append ("			(SELECT BKG_RCV_TERM_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = H.BKG_PCTL_NO) R_TERM,		\n");
        queryStr.append ("			SCE_COP_GET_ROUTE_FNC(H.OB_PCTL_NO,'O','P') OB_ROUTE,										\n");
        queryStr.append ("			SCE_COP_GET_ROUTE_FNC(H.OCN_PCTL_NO,'T','P') OCN_ROUTE,										\n");
        queryStr.append ("			SCE_COP_GET_ROUTE_FNC(H.IB_PCTL_NO,'I','P') IB_ROUTE,										\n");
        queryStr.append ("			(SELECT BKG_DE_TERM_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = H.BKG_PCTL_NO) D_TERM,			\n");
        queryStr.append ("			TO_CHAR(CRE_DT,'YYYY/MM/DD HH24:MI:SS') CRE_DT,																						\n");
        queryStr.append ("			CRE_USR_ID,																					\n");
        queryStr.append ("			CRE_OFC_CD,																					\n");
        queryStr.append ("			UMCH_STS_CD,																				\n");
        queryStr.append ("			OB_BKG_TRO_NO,																				\n");
        queryStr.append ("			IB_BKG_TRO_NO																				\n");
        queryStr.append ("			FROM SCE_COP_HIS H																			\n");
        queryStr.append ("			WHERE   BKG_NO  = NVL( ?,BKG_NO)															\n");
        queryStr.append ("			AND     BKG_NO_SPLIT = NVL( ? ,BKG_NO_SPLIT)												\n");
        queryStr.append ("			AND     COP_NO  = NVL( ? ,COP_NO)															\n");
        queryStr.append ("			AND     CNTR_NO = NVL(? ,CNTR_NO)															\n");
        queryStr.append ("			AND     CRE_USR_ID <> 'GenS/O'																\n");
        queryStr.append ("			ORDER BY CRE_DT, COP_NO, BKG_NO,BKG_NO_SPLIT, CNTR_NO										\n");

        log.info("SQL :\n" + queryStr );

        try {
            con  = getConnection();
            // BL No 가 들어왔을 경우 bkg_no, bkg_no_split 값을 구한다.

            if( szBlNo != null && szBlNo.length() > 0) {
                //Loggable Statement 사용에 의해 추가
                if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                    ps = new LoggableStatement(con, queryString.toString());
                } else {
                    ps = con.prepareStatement(queryString.toString());
                }
                i = 1;
                ps.setString( i++, szBlNo);
                ps.setString( i++, szBlNo);
                ps.setString( i++, szBlNo);

                rs = ps.executeQuery();

                if( rs.next()) {
                	szBkgNo = rs.getString( "bkg_no");
                	szBkgNoSplit = rs.getString( "bkg_no_split");
                }
            }

            closeResultSet( rs);
            closeStatement(ps);

            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                ps = new LoggableStatement(con, queryStr.toString());
            } else {
                ps = con.prepareStatement(queryStr.toString());
            }

            i = 1;
            ps.setString( i++, szBkgNo);
            ps.setString( i++, szBkgNoSplit);
            ps.setString( i++, szCopNo);
            ps.setString( i++, szCntrNo);

            if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
  				log.info(" SQL :\n" + ((LoggableStatement)ps).getQueryString());
      	  	}

            rs = ps.executeQuery();
            dbRowSet.populate( rs );

        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        }finally {
        	closeResultSet(rs);
            closeStatement(ps);
            closeConnection(con);
        }

		return dbRowSet;

	}
*/
}