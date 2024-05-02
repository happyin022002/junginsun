/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TermChangeDBDAOTermChangeCreationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.02.10 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TermChangeDBDAOTermChangeCreationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Term Change Creation 대상 장비목록을 조회한다.
	  * </pre>
	  */
	public TermChangeDBDAOTermChangeCreationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("di_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.integration").append("\n"); 
		query.append("FileName : TermChangeDBDAOTermChangeCreationListRSQL").append("\n"); 
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
		query.append("WITH LV_CNTR_LIST AS (" ).append("\n"); 
		query.append("    SELECT  A.CNTR_NO, A.CNTR_TPSZ_CD, A.LST_STS_YD_CD," ).append("\n"); 
		query.append("            B.CNTR_PKUP_CHG_AMT," ).append("\n"); 
		query.append("            CASE WHEN B.CNTR_PKUP_CHG_AMT > 0" ).append("\n"); 
		query.append("                 THEN B.CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append("                 ELSE 0 END CNTR_PKUP_PSV_AMT," ).append("\n"); 
		query.append("            CASE WHEN B.CNTR_PKUP_CHG_AMT < 0" ).append("\n"); 
		query.append("                 THEN ABS(B.CNTR_PKUP_CHG_AMT)" ).append("\n"); 
		query.append("                 ELSE 0 END CNTR_PKUP_NGV_AMT," ).append("\n"); 
		query.append("            B.CNTR_MIN_ONH_DYS, B.RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("            B.CNTR_DIR_ITCHG_FEE_AMT AS DII_FEE," ).append("\n"); 
		query.append("            B.CNTR_STS_CD, A.ONH_DT, A.CNMV_STS_CD," ).append("\n"); 
		query.append("			TO_CHAR(A.CNMV_DT ,'YYYYMMDD') AS CNMV_DT," ).append("\n"); 
		query.append("			A.FULL_FLG AS CNTR_FULL_FLG, " ).append("\n"); 
		query.append("			P.CUR_AGMT_CTY_CD, P.CUR_AGMT_SEQ, " ).append("\n"); 
		query.append("			P.AFT_AGMT_CTY_CD, P.AFT_AGMT_SEQ," ).append("\n"); 
		query.append("			P.ACT_DT, P.DI_FLAG, P.CUR_LSTM_CD, " ).append("\n"); 
		query.append("			P.AFT_LSTM_CD, P.AFT_VNDR_SEQ, P.OFC_CD," ).append("\n"); 
		query.append("			B.CNTR_STS_SEQ, B.YD_CD, B.LOC_CD, " ).append("\n"); 
		query.append("            B.SCC_CD, B.ECC_CD, B.LCC_CD, B.RCC_CD" ).append("\n"); 
		query.append("    FROM   (SELECT  @[cur_agmt_cty_cd]  AS CUR_AGMT_CTY_CD," ).append("\n"); 
		query.append("                    @[cur_agmt_seq]     AS CUR_AGMT_SEQ," ).append("\n"); 
		query.append("                    @[aft_agmt_cty_cd]  AS AFT_AGMT_CTY_CD," ).append("\n"); 
		query.append("                    @[aft_agmt_seq]     AS AFT_AGMT_SEQ," ).append("\n"); 
		query.append("                    @[act_dt]           AS ACT_DT," ).append("\n"); 
		query.append("                    @[di_flag]          AS DI_FLAG," ).append("\n"); 
		query.append("                    @[cur_lstm_cd]      AS CUR_LSTM_CD," ).append("\n"); 
		query.append("                    @[aft_lstm_cd]      AS AFT_LSTM_CD," ).append("\n"); 
		query.append("                    @[aft_vndr_seq]     AS AFT_VNDR_SEQ," ).append("\n"); 
		query.append("                    @[ofc_cd]           AS OFC_CD            " ).append("\n"); 
		query.append("            FROM    DUAL) P," ).append("\n"); 
		query.append("            MST_CONTAINER A," ).append("\n"); 
		query.append("            MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("    WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("    AND     A.LST_STS_SEQ = B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("    AND     B.CNTR_STS_EVNT_DT <= TO_DATE(P.ACT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("    AND     A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("#if (${di_flag} == '')" ).append("\n"); 
		query.append("    AND     A.AGMT_SEQ = P.CUR_AGMT_SEQ" ).append("\n"); 
		query.append("    AND     A.AGMT_CTY_CD = P.CUR_AGMT_CTY_CD" ).append("\n"); 
		query.append("	AND     A.CNTR_STS_CD IN ('DII','FND','LSI','LST','MUI','MUO','OWN','SBI','SBO','SRI')" ).append("\n"); 
		query.append("	AND   ((A.CNMV_STS_CD <> 'XX' AND  A.CNTR_STS_CD IN ('DII','FND','LSI','MUI','OWN','SBI','SRI'))" ).append("\n"); 
		query.append("	OR	   (A.CNMV_STS_CD  = 'XX' AND  A.CNTR_STS_CD IN ('LST','MUO','SBO')))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND     A.AGMT_SEQ = DECODE(P.CUR_LSTM_CD, 'MO', P.AFT_AGMT_SEQ, P.CUR_AGMT_SEQ)" ).append("\n"); 
		query.append("    AND     A.AGMT_CTY_CD = DECODE(P.CUR_LSTM_CD, 'MO', P.AFT_AGMT_CTY_CD, P.CUR_AGMT_CTY_CD)" ).append("\n"); 
		query.append("	AND     A.CNTR_STS_CD = DECODE(P.CUR_LSTM_CD, 'MI', 'LSI', 'MUO')    " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${aft_lstm_cd} == 'OW')" ).append("\n"); 
		query.append(", LV_TPSZ_SEQ_LIST AS (" ).append("\n"); 
		query.append("    SELECT  ROWNUM AS ROW_SEQ,CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("			MST_CNTR_TERM_CNG_SEQ_FNC('N') AS TERM_CNG_SEQ" ).append("\n"); 
		query.append("    FROM   (SELECT  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            FROM    LV_CNTR_LIST" ).append("\n"); 
		query.append("            WHERE   AFT_LSTM_CD = 'OW'" ).append("\n"); 
		query.append("            GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("), LV_TERM_CNG_SEQ_SET AS(" ).append("\n"); 
		query.append("    SELECT  SUBSTR(MAX(RPAD(TO_CHAR(LEVEL,'00'), 5) ||" ).append("\n"); 
		query.append("            SYS_CONNECT_BY_PATH(TERM_CNG_SEQ, '*')),7) AS SEQ_SET" ).append("\n"); 
		query.append("    FROM   (SELECT  TERM_CNG_SEQ, ROW_NUMBER() OVER(ORDER BY TERM_CNG_SEQ) AS RN" ).append("\n"); 
		query.append("            FROM    LV_TPSZ_SEQ_LIST)" ).append("\n"); 
		query.append("    CONNECT BY PRIOR RN = RN -1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT  A.CNTR_NO, A.CNTR_TPSZ_CD, A.LST_STS_YD_CD, 0 AS CNTR_PKUP_CHG_AMT," ).append("\n"); 
		query.append("        0 AS CNTR_PKUP_PSV_AMT, 0 AS CNTR_PKUP_NGV_AMT, 0 AS CNTR_MIN_ONH_DYS," ).append("\n"); 
		query.append("        0 AS RNTL_CHG_FREE_DYS, 0 AS DII_FEE, A.CNTR_STS_CD, A.ONH_DT," ).append("\n"); 
		query.append("        A.CNMV_STS_CD, A.CNMV_DT, A.CNTR_FULL_FLG," ).append("\n"); 
		query.append("#if (${aft_lstm_cd} == 'OW')" ).append("\n"); 
		query.append("		B.TERM_CNG_SEQ, C.SEQ_SET,	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        A.CUR_AGMT_CTY_CD, A.CUR_AGMT_SEQ, A.AFT_AGMT_CTY_CD," ).append("\n"); 
		query.append("        A.AFT_AGMT_SEQ, A.ACT_DT, NVL(A.DI_FLAG,'N') DI_FLAG," ).append("\n"); 
		query.append("        A.AFT_LSTM_CD, A.AFT_VNDR_SEQ, A.OFC_CD, A.CNTR_STS_SEQ, " ).append("\n"); 
		query.append("        A.YD_CD, A.LOC_CD, A.SCC_CD, A.ECC_CD, A.LCC_CD, A.RCC_CD" ).append("\n"); 
		query.append("FROM    LV_CNTR_LIST A" ).append("\n"); 
		query.append("#if (${aft_lstm_cd} == 'OW')" ).append("\n"); 
		query.append(" 	  , LV_TPSZ_SEQ_LIST B," ).append("\n"); 
		query.append("        LV_TERM_CNG_SEQ_SET C" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND     A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}