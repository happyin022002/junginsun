/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgncommagmthistoryDBDAOSearchAgncommagmtMasterHistoryListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.04
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.04 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgncommagmthistoryDBDAOSearchAgncommagmtMasterHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchAgncommagmtMasterHistoryList
	  * </pre>
	  */
	public AgncommagmthistoryDBDAOSearchAgncommagmtMasterHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_his_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.integration").append("\n");
		query.append("FileName : AgncommagmthistoryDBDAOSearchAgncommagmtMasterHistoryListRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append(" SEQ" ).append("\n");
		query.append(",ITEM" ).append("\n");
		query.append(",AGN_AGMT_NO" ).append("\n");
		query.append(",DECODE(A.SEQ," ).append("\n");
		query.append("        1,DECODE(B.EFF_DT      ,B.PRE_EFF_DT      ,'',B.EFF_DT)," ).append("\n");
		query.append("        2,DECODE(B.AGN_AGMT_RMK,B.PRE_AGN_AGMT_RMK,'',B.AGN_AGMT_RMK)," ).append("\n");
		query.append("        3,DECODE(B.DELT_FLG    ,B.PRE_DELT_FLG    ,'',B.DELT_FLG)							" ).append("\n");
		query.append("        ) AS CURRENT_VALUE" ).append("\n");
		query.append(",DECODE(A.SEQ," ).append("\n");
		query.append("        1,DECODE(B.EFF_DT      ,B.PRE_EFF_DT      ,'',B.PRE_EFF_DT)," ).append("\n");
		query.append("        2,DECODE(B.AGN_AGMT_RMK,B.PRE_AGN_AGMT_RMK,'',B.PRE_AGN_AGMT_RMK)," ).append("\n");
		query.append("        3,DECODE(B.DELT_FLG    ,B.PRE_DELT_FLG    ,'',B.PRE_DELT_FLG)" ).append("\n");
		query.append("        ) AS PREVIOUS_VALUE" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("" ).append("\n");
		query.append("(" ).append("\n");
		query.append("    SELECT 1 AS SEQ, 'Effective Date' AS ITEM FROM DUAL UNION ALL" ).append("\n");
		query.append("    SELECT 2 AS SEQ, 'Remark'                 FROM DUAL UNION ALL" ).append("\n");
		query.append("    SELECT 3 AS SEQ, 'Del'                    FROM DUAL" ).append("\n");
		query.append(")A," ).append("\n");
		query.append("    (" ).append("\n");
		query.append("    SELECT" ).append("\n");
		query.append("     AGN_CD" ).append("\n");
		query.append("    ,AGN_AGMT_NO" ).append("\n");
		query.append("    ,AGMT_HIS_NO" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("    ,DECODE(AGMT_FM_DT_CD, 'S', 'SA Date / ' , 'B', 'BKG / ', 'R', 'Rev Month / ')" ).append("\n");
		query.append("    ||TO_CHAR(TO_DATE(AGMT_FM_DT, 'YYYYMMDD'), 'YYYY-MM-DD ~ ')" ).append("\n");
		query.append("    ||DECODE(AGMT_TO_DT_CD, 'S', 'SA Date / ', 'B', 'BKG', 'R / ', 'Rev Month / ')" ).append("\n");
		query.append("    ||TO_CHAR(TO_DATE(AGMT_TO_DT, 'YYYYMMDD'), 'YYYY-MM-DD') EFF_DT" ).append("\n");
		query.append("    ,AGN_AGMT_RMK" ).append("\n");
		query.append("    ,DELT_FLG" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("    ,DECODE(PRE_AGMT_FM_DT_CD, 'S', 'SA Date / ' , 'B', 'BKG / ', 'R', 'Rev Month / ')" ).append("\n");
		query.append("    ||TO_CHAR(TO_DATE(PRE_AGMT_FM_DT, 'YYYYMMDD'), 'YYYY-MM-DD ~ ')" ).append("\n");
		query.append("    ||DECODE(PRE_AGMT_TO_DT_CD, 'S', 'SA Date / ', 'B', 'BKG', 'R / ', 'Rev Month / ')" ).append("\n");
		query.append("    ||TO_CHAR(TO_DATE(PRE_AGMT_TO_DT, 'YYYYMMDD'), 'YYYY-MM-DD') PRE_EFF_DT" ).append("\n");
		query.append("    ,PRE_AGN_AGMT_RMK" ).append("\n");
		query.append("    ,PRE_DELT_FLG" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("    FROM" ).append("\n");
		query.append("    (" ).append("\n");
		query.append("        SELECT" ).append("\n");
		query.append("         AGN_CD" ).append("\n");
		query.append("        ,AGN_AGMT_NO" ).append("\n");
		query.append("        ,AGMT_HIS_NO" ).append("\n");
		query.append("" ).append("\n");
		query.append("        ,AGMT_FM_DT_CD" ).append("\n");
		query.append("        ,AGMT_FM_DT" ).append("\n");
		query.append("        ,AGMT_TO_DT_CD" ).append("\n");
		query.append("        ,AGMT_TO_DT" ).append("\n");
		query.append("        ,AGN_AGMT_RMK" ).append("\n");
		query.append("        ,DELT_FLG" ).append("\n");
		query.append("" ).append("\n");
		query.append("        ,LAG(AGMT_FM_DT_CD) OVER  ( ORDER BY AGMT_HIS_NO, CRE_DT) AS PRE_AGMT_FM_DT_CD" ).append("\n");
		query.append("        ,LAG(AGMT_FM_DT)    OVER  ( ORDER BY AGMT_HIS_NO, CRE_DT) AS PRE_AGMT_FM_DT" ).append("\n");
		query.append("        ,LAG(AGMT_TO_DT_CD) OVER  ( ORDER BY AGMT_HIS_NO, CRE_DT) AS PRE_AGMT_TO_DT_CD" ).append("\n");
		query.append("        ,LAG(AGMT_TO_DT)    OVER  ( ORDER BY AGMT_HIS_NO, CRE_DT) AS PRE_AGMT_TO_DT" ).append("\n");
		query.append("        ,LAG(AGN_AGMT_RMK)  OVER  ( ORDER BY AGMT_HIS_NO, CRE_DT) AS PRE_AGN_AGMT_RMK" ).append("\n");
		query.append("        ,LAG(DELT_FLG)      OVER  ( ORDER BY AGMT_HIS_NO, CRE_DT) AS PRE_DELT_FLG" ).append("\n");
		query.append("" ).append("\n");
		query.append("        ,CRE_GDT" ).append("\n");
		query.append("        ,CRE_USR_ID" ).append("\n");
		query.append("		,CRE_DT" ).append("\n");
		query.append("        ,UPD_USR_ID" ).append("\n");
		query.append("        ,UPD_DT" ).append("\n");
		query.append("        FROM ACM_AGN_AGMT_MST_HIS A" ).append("\n");
		query.append("        WHERE AGN_AGMT_NO =  @[agn_agmt_no]" ).append("\n");
		query.append("    )" ).append("\n");
		query.append("    WHERE AGMT_HIS_NO =  @[agmt_his_no]" ).append("\n");
		query.append(")B" ).append("\n");

	}
}