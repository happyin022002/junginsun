/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PerformanceInquiryDBDAOSearchNonTPBListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceInquiryDBDAOSearchNonTPBListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchNonTPBList
	  * </pre>
	  */
	public PerformanceInquiryDBDAOSearchNonTPBListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_date_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.integration").append("\n"); 
		query.append("FileName : PerformanceInquiryDBDAOSearchNonTPBListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("#if (${s_if_rhq_cd} == 'all')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   NVL(A.CFM_OFC_CD, 'TOTAL') IF_OFC_CD" ).append("\n"); 
		query.append("       , NVL(A.CD_TYPE,'S.TTL') CD_TYPE" ).append("\n"); 
		query.append("       , TOTAL_CNT, '' TOTAL_RATIO" ).append("\n"); 
		query.append("       , TES_CNT, '' TES_RATIO" ).append("\n"); 
		query.append("       , TRS_CNT, '' TRS_RATIO" ).append("\n"); 
		query.append("       , MNR_CNT, '' MNR_RATIO" ).append("\n"); 
		query.append("	   , PSO_CNT, '' PSO_RATIO" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   B.CFM_OFC_CD" ).append("\n"); 
		query.append("                  , DECODE(B.INTG_CD_VAL_CTNT,'CD','Case Duplicated','CN','Wrong Candidate','DE','Wrong Candidate','VF','Wrong Data Input','OR','Wrong Data Input','WD','Wrong Data Input','Cancel') cd_type" ).append("\n"); 
		query.append("                  , SUM(A.CNT) TOTAL_CNT" ).append("\n"); 
		query.append("                  , SUM(DECODE(A.N3PTY_EXPN_TP_CD, 'TES', A.CNT)) AS TES_CNT" ).append("\n"); 
		query.append("                  , SUM(DECODE(A.N3PTY_EXPN_TP_CD, 'TRS', A.CNT)) AS TRS_CNT" ).append("\n"); 
		query.append("                  , SUM(DECODE(A.N3PTY_EXPN_TP_CD, 'MNR', A.CNT)) AS MNR_CNT" ).append("\n"); 
		query.append("                  , SUM(DECODE(A.N3PTY_EXPN_TP_CD, 'PSO', A.CNT)) AS PSO_CNT" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   M.RHQ AS CFM_OFC_CD" ).append("\n"); 
		query.append("                             , N3PTY_NON_CFM_RSN_CD" ).append("\n"); 
		query.append("                             , N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("                             , COUNT(A.OTS_DTL_SEQ) AS CNT" ).append("\n"); 
		query.append("                      FROM     TPB_OTS_DTL A" ).append("\n"); 
		query.append("                             , (" ).append("\n"); 
		query.append("                                 SELECT   RHQ_CD RHQ" ).append("\n"); 
		query.append("                                        , OFC_CD OFC" ).append("\n"); 
		query.append("                                 FROM     TPB_HNDL_OFC" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      N3PTY_OFC_TP_CD='T'" ).append("\n"); 
		query.append("                                 AND      NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '' && ${s_if_rhq_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '' && ${s_if_ctrl_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '' && ${s_if_ofc_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                               ) M" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.CFM_OFC_CD = M.OFC" ).append("\n"); 
		query.append("                      AND      A.N3PTY_CFM_CD = 'N'" ).append("\n"); 
		query.append("                      AND      IF_DT >= DECODE(@[s_date_type], 'L', TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[user_ofc_cd]), TO_DATE(@[s_sdate],'YYYY-MM-DD') + 9/24 )" ).append("\n"); 
		query.append("                      AND      IF_DT < DECODE(@[s_date_type], 'L', TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[user_ofc_cd]),TO_DATE(@[s_edate], 'YYYY-MM-DD') + 9/24 ) + 1" ).append("\n"); 
		query.append("                      AND      A.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("                      GROUP BY M.RHQ" ).append("\n"); 
		query.append("                             , N3PTY_NON_CFM_RSN_CD" ).append("\n"); 
		query.append("                             , N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("                    ) A" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   A.RHQ AS CFM_OFC_CD" ).append("\n"); 
		query.append("                             , B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                      FROM     (" ).append("\n"); 
		query.append("                                 SELECT   RHQ_CD RHQ" ).append("\n"); 
		query.append("                                        , OFC_CD OFC" ).append("\n"); 
		query.append("                                 FROM     TPB_HNDL_OFC" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      N3PTY_OFC_TP_CD='T'" ).append("\n"); 
		query.append("                                 AND      NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '' && ${s_if_rhq_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '' && ${s_if_ctrl_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '' && ${s_if_ofc_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                               ) A, COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      B.INTG_CD_ID = 'CD00902'" ).append("\n"); 
		query.append("                      GROUP BY A.RHQ, B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                    ) B" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.N3PTY_NON_CFM_RSN_CD(+) = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("           AND      A.CFM_OFC_CD(+) = B.CFM_OFC_CD" ).append("\n"); 
		query.append("           GROUP BY CUBE(B.CFM_OFC_CD, DECODE(B.INTG_CD_VAL_CTNT,'CD','Case Duplicated','CN','Wrong Candidate','DE','Wrong Candidate','VF','Wrong Data Input','OR','Wrong Data Input','WD','Wrong Data Input','Cancel'))" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append("ORDER BY A.CFM_OFC_CD" ).append("\n"); 
		query.append("       , A.CD_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   NVL(A.CFM_OFC_CD, 'Total') AS IF_OFC_CD" ).append("\n"); 
		query.append("       , NVL(A.CD_TYPE,'S.TTL') AS CD_TYPE" ).append("\n"); 
		query.append("       , TOTAL_CNT, '' AS TOTAL_RATIO" ).append("\n"); 
		query.append("       , TES_CNT, '' AS TES_RATIO" ).append("\n"); 
		query.append("       , TRS_CNT, '' AS TRS_RATIO" ).append("\n"); 
		query.append("       , MNR_CNT, '' AS MNR_RATIO" ).append("\n"); 
		query.append("	   , PSO_CNT, '' AS PSO_RATIO" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   B.CFM_OFC_CD" ).append("\n"); 
		query.append("                  , DECODE(B.INTG_CD_VAL_CTNT,'CD','Case Duplicated','CN','Wrong Candidate','DE','Wrong Candidate','VF','Wrong Data Input','OR','Wrong Data Input','WD','Wrong Data Input','Cancel') cd_type" ).append("\n"); 
		query.append("                  , SUM(A.CNT) TOTAL_CNT" ).append("\n"); 
		query.append("                  , SUM(DECODE(A.N3PTY_EXPN_TP_CD, 'TES', A.CNT)) TES_CNT" ).append("\n"); 
		query.append("                  , SUM(DECODE(A.N3PTY_EXPN_TP_CD, 'TRS', A.CNT)) TRS_CNT" ).append("\n"); 
		query.append("                  , SUM(DECODE(A.N3PTY_EXPN_TP_CD, 'MNR', A.CNT)) MNR_CNT" ).append("\n"); 
		query.append("                  , SUM(DECODE(A.N3PTY_EXPN_TP_CD, 'PSO', A.CNT)) PSO_CNT" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   M.OFC AS CFM_OFC_CD" ).append("\n"); 
		query.append("                             , N3PTY_NON_CFM_RSN_CD" ).append("\n"); 
		query.append("                             , N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("                             , COUNT(A.OTS_DTL_SEQ) AS CNT" ).append("\n"); 
		query.append("                      FROM     TPB_OTS_DTL A" ).append("\n"); 
		query.append("                             , (" ).append("\n"); 
		query.append("                                 SELECT   RHQ_CD RHQ" ).append("\n"); 
		query.append("                                        , OFC_CD OFC" ).append("\n"); 
		query.append("                                 FROM     TPB_HNDL_OFC" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      N3PTY_OFC_TP_CD='T'" ).append("\n"); 
		query.append("                                 AND      NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '' && ${s_if_rhq_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '' && ${s_if_ctrl_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '' && ${s_if_ofc_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                               ) M" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.CFM_OFC_CD = M.OFC" ).append("\n"); 
		query.append("                      AND      A.N3PTY_CFM_CD = 'N'" ).append("\n"); 
		query.append("                      AND      IF_DT >= DECODE(@[s_date_type], 'L', TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[user_ofc_cd]), TO_DATE(@[s_sdate],'YYYY-MM-DD') + 9/24 )" ).append("\n"); 
		query.append("                      AND      IF_DT < DECODE(@[s_date_type], 'L', TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[user_ofc_cd]),TO_DATE(@[s_edate], 'YYYY-MM-DD') + 9/24 ) + 1" ).append("\n"); 
		query.append("                      AND      A.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("                      GROUP BY M.OFC" ).append("\n"); 
		query.append("                             , N3PTY_NON_CFM_RSN_CD" ).append("\n"); 
		query.append("                             , N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("                    ) A" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   A.OFC AS CFM_OFC_CD" ).append("\n"); 
		query.append("                             , B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                      FROM     (" ).append("\n"); 
		query.append("                                 SELECT   RHQ_CD RHQ" ).append("\n"); 
		query.append("                                        , OFC_CD OFC" ).append("\n"); 
		query.append("                                 FROM     TPB_HNDL_OFC" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      N3PTY_OFC_TP_CD='T'" ).append("\n"); 
		query.append("                                 AND      NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '' && ${s_if_rhq_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      RHQ_CD = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ctrl_cd} != '' && ${s_if_ctrl_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      N3PTY_CTRL_OFC_CD = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '' && ${s_if_ofc_cd} != 'all')" ).append("\n"); 
		query.append("                                 AND      OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                             , COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      B.INTG_CD_ID = 'CD00902'" ).append("\n"); 
		query.append("                      GROUP BY A.OFC" ).append("\n"); 
		query.append("                             , B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                    ) B" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.N3PTY_NON_CFM_RSN_CD(+) = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("           AND      A.CFM_OFC_CD(+) = B.CFM_OFC_CD" ).append("\n"); 
		query.append("           GROUP BY CUBE(B.CFM_OFC_CD, DECODE(B.INTG_CD_VAL_CTNT,'CD','Case Duplicated','CN','Wrong Candidate','DE','Wrong Candidate','VF','Wrong Data Input','OR','Wrong Data Input','WD','Wrong Data Input','Cancel'))" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append("ORDER BY A.CFM_OFC_CD" ).append("\n"); 
		query.append("       , A.CD_TYPE" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}