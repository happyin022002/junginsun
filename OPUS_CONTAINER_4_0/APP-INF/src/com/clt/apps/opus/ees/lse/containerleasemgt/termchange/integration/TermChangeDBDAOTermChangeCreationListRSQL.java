/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TermChangeDBDAOTermChangeCreationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.termchange.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.termchange.integration").append("\n"); 
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
		query.append("    SELECT  A.CNTR_NO, A.CNTR_TPSZ_CD, A.ONH_YD_CD LST_STS_YD_CD, A.CRNT_YD_CD," ).append("\n"); 
		query.append("            B.CNTR_PKUP_CHG_AMT," ).append("\n"); 
		query.append("            CASE WHEN B.CNTR_PKUP_CHG_AMT > 0" ).append("\n"); 
		query.append("                 THEN B.CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append("                 ELSE 0 END CNTR_PKUP_PSV_AMT," ).append("\n"); 
		query.append("            CASE WHEN B.CNTR_PKUP_CHG_AMT < 0" ).append("\n"); 
		query.append("                 THEN ABS(B.CNTR_PKUP_CHG_AMT)" ).append("\n"); 
		query.append("                 ELSE 0 END CNTR_PKUP_NGV_AMT," ).append("\n"); 
		query.append("            B.CNTR_MIN_ONH_DYS, B.RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("            B.CNTR_DIR_ITCHG_FEE_AMT AS DII_FEE," ).append("\n"); 
		query.append("            LST.CNTR_STS_CD AS DP_CNTR_STS_CD," ).append("\n"); 
		query.append("            A.CNMV_STS_CD AS DP_CNMV_STS_CD, " ).append("\n"); 
		query.append("            DECODE(SIGN(TO_DATE(P.ACT_DT,'YYYYMMDD') - LST.CNTR_STS_EVNT_DT), -1, B.CNTR_STS_CD, LST.CNTR_STS_CD) AS CNTR_STS_CD," ).append("\n"); 
		query.append("            DECODE(SIGN(TO_DATE(P.ACT_DT,'YYYYMMDD') - LST.CNTR_STS_EVNT_DT), -1, 'MT'         , A.CNMV_STS_CD)   AS CNMV_STS_CD," ).append("\n"); 
		query.append("            A.ONH_DT, " ).append("\n"); 
		query.append("			TO_CHAR(A.CNMV_DT ,'YYYYMMDD') AS CNMV_DT," ).append("\n"); 
		query.append("			A.FULL_FLG AS CNTR_FULL_FLG, " ).append("\n"); 
		query.append("			P.CUR_AGMT_CTY_CD, P.CUR_AGMT_SEQ, " ).append("\n"); 
		query.append("			P.AFT_AGMT_CTY_CD, P.AFT_AGMT_SEQ," ).append("\n"); 
		query.append("			P.ACT_DT, P.DI_FLAG, P.CUR_LSTM_CD, " ).append("\n"); 
		query.append("			P.AFT_LSTM_CD, P.AFT_VNDR_SEQ, P.OFC_CD," ).append("\n"); 
		query.append("			B.CNTR_STS_SEQ, B.YD_CD, B.LOC_CD, " ).append("\n"); 
		query.append("            B.SCC_CD, B.ECC_CD, B.LCC_CD, B.RCC_CD" ).append("\n"); 
		query.append("            , A.DISP_FLG " ).append("\n"); 
		query.append("            , NVL(( SELECT 'Y'" ).append("\n"); 
		query.append("                  FROM MNR_TTL_LSS_RQST_HDR TH" ).append("\n"); 
		query.append("                        , MNR_TTL_LSS_RQST_DTL TD" ).append("\n"); 
		query.append("                 WHERE 1                   = 1" ).append("\n"); 
		query.append("                    AND    TH.TTL_LSS_NO      = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("                    AND    TD.RQST_EQ_NO    = A.CNTR_NO" ).append("\n"); 
		query.append("                    AND    ROWNUM            = 1), 'N') AS TLL_FLG" ).append("\n"); 
		query.append("            , DECODE(SIGN(TO_DATE(P.ACT_DT,'YYYYMMDD') - B.CNTR_STS_EVNT_DT), -1, 'Y', 0, 'Y', 'N') AS DT_FLG" ).append("\n"); 
		query.append("            , TO_CHAR(A.ONH_DT ,'YYYYMMDD') AS DP_ONH_DT" ).append("\n"); 
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
		query.append("            MST_CNTR_STS_HIS B," ).append("\n"); 
		query.append("            MST_CNTR_STS_HIS LST" ).append("\n"); 
		query.append("    WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("    AND     A.ONH_STS_SEQ = B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("    AND     A.CNTR_NO     = LST.CNTR_NO" ).append("\n"); 
		query.append("    AND     A.LST_STS_SEQ  = LST.CNTR_STS_SEQ" ).append("\n"); 
		query.append("#if (${tmp_seq} != '') " ).append("\n"); 
		query.append("	AND A.CNTR_NO IN ( SELECT INP_MSG1" ).append("\n"); 
		query.append("                       FROM EQR_CTRL_DAT_VRFY" ).append("\n"); 
		query.append("                       WHERE TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${cntr_list} != '')" ).append("\n"); 
		query.append("	AND	 A.CNTR_NO IN (" ).append("\n"); 
		query.append("		#foreach ($key IN ${cntr_list})" ).append("\n"); 
		query.append("			#if($velocityCount < $cntr_list.size())" ).append("\n"); 
		query.append("				'$key'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$key'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${di_flag} == '')" ).append("\n"); 
		query.append("    AND     A.AGMT_SEQ = P.CUR_AGMT_SEQ" ).append("\n"); 
		query.append("    AND     A.AGMT_CTY_CD = P.CUR_AGMT_CTY_CD" ).append("\n"); 
		query.append("	AND     A.CNTR_STS_CD IN ('DII','FND','LSI','LST','MUI','MUO','OWN','SBI','SBO','SRI', 'RPC')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND     A.AGMT_SEQ    = DECODE(P.CUR_LSTM_CD, 'MO', P.AFT_AGMT_SEQ, P.CUR_AGMT_SEQ)" ).append("\n"); 
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
		query.append("SELECT  A.CNTR_NO, A.CNTR_TPSZ_CD, A.LST_STS_YD_CD, A.CRNT_YD_CD, 0 AS CNTR_PKUP_CHG_AMT," ).append("\n"); 
		query.append("#if (${tmp_seq} != '') " ).append("\n"); 
		query.append("		ECDV.INP_MSG2 AS CNTR_PKUP_PSV_AMT," ).append("\n"); 
		query.append("        ECDV.INP_MSG3 AS CNTR_PKUP_NGV_AMT," ).append("\n"); 
		query.append("        ECDV.INP_MSG4 AS CNTR_MIN_ONH_DYS," ).append("\n"); 
		query.append("        ECDV.INP_MSG5 AS RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("        ECDV.INP_MSG6 AS DII_FEE," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		0 AS CNTR_PKUP_PSV_AMT, 0 AS CNTR_PKUP_NGV_AMT, 0 AS CNTR_MIN_ONH_DYS," ).append("\n"); 
		query.append("        0 AS RNTL_CHG_FREE_DYS, 0 AS DII_FEE, " ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("		A.ONH_DT," ).append("\n"); 
		query.append("        A.CNTR_STS_CD, A.DP_CNTR_STS_CD, A.CNMV_STS_CD, A.DP_CNMV_STS_CD, A.CNMV_DT, A.CNTR_FULL_FLG," ).append("\n"); 
		query.append("#if (${aft_lstm_cd} == 'OW')" ).append("\n"); 
		query.append("		B.TERM_CNG_SEQ, C.SEQ_SET,	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        A.CUR_AGMT_CTY_CD, A.CUR_AGMT_SEQ, A.AFT_AGMT_CTY_CD," ).append("\n"); 
		query.append("        A.AFT_AGMT_SEQ, A.ACT_DT, NVL(A.DI_FLAG,'N') DI_FLAG," ).append("\n"); 
		query.append("        A.AFT_LSTM_CD, A.AFT_VNDR_SEQ, A.OFC_CD, A.CNTR_STS_SEQ, A.DP_ONH_DT," ).append("\n"); 
		query.append("        A.YD_CD, A.LOC_CD, A.SCC_CD, A.ECC_CD, A.LCC_CD, A.RCC_CD, DECODE(A.TLL_FLG, 'Y', 'T', DECODE(A.DISP_FLG, 'Y', 'D', DECODE(A.DT_FLG, 'Y', 'E', 'O.K'))) AS ERR_CD" ).append("\n"); 
		query.append("FROM    LV_CNTR_LIST A" ).append("\n"); 
		query.append("#if (${tmp_seq} != '') " ).append("\n"); 
		query.append("		, EQR_CTRL_DAT_VRFY ECDV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aft_lstm_cd} == 'OW')" ).append("\n"); 
		query.append(" 	  , LV_TPSZ_SEQ_LIST B," ).append("\n"); 
		query.append("        LV_TERM_CNG_SEQ_SET C" ).append("\n"); 
		query.append("	WHERE    1 = 1" ).append("\n"); 
		query.append("	AND     A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("	#if (${tmp_seq} != '') " ).append("\n"); 
		query.append("		AND A.CNTR_NO = ECDV.INP_MSG1" ).append("\n"); 
		query.append("    	AND ECDV.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	WHERE    1 = 1" ).append("\n"); 
		query.append("	#if (${tmp_seq} != '') " ).append("\n"); 
		query.append("		AND A.CNTR_NO = ECDV.INP_MSG1" ).append("\n"); 
		query.append("    	AND ECDV.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}