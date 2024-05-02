/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchBaseTariffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchBaseTariffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * base tariff 조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchBaseTariffRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchBaseTariffRSQL").append("\n"); 
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
		query.append("SELECT X.*" ).append("\n"); 
		query.append("      ,(SELECT UPD_MNU_NO" ).append("\n"); 
		query.append("        FROM   PSO_CONDITION" ).append("\n"); 
		query.append("        WHERE  COND_NO = (CASE WHEN @[uid] = '0004' AND X.PSO_CHG_TP_CD = 'B' AND X.BM = 1     THEN X.COND_NO_21 " ).append("\n"); 
		query.append("                               WHEN @[uid] = '0004' AND X.PSO_CHG_TP_CD = 'B' AND X.BM IS NULL THEN X.COND_NO_23" ).append("\n"); 
		query.append("                          ELSE X.COND_NO_21     " ).append("\n"); 
		query.append("                          END)) UPD_MNU_NO_COND " ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT -1*(DECODE(T21.PSO_CHG_TP_CD, 'B', DENSE_RANK() OVER(PARTITION BY T21.CHG_XPR_NO ORDER BY T21.CHG_XPR_SEQ ASC)) + 1) UK" ).append("\n"); 
		query.append("      ,DECODE(DECODE(T21.PSO_CHG_TP_CD, 'B', ROW_NUMBER() OVER(PARTITION BY T21.CHG_XPR_NO, T21.CHG_XPR_SEQ ORDER BY T21.CHG_XPR_SEQ ASC)), 1, 1) BM" ).append("\n"); 
		query.append("      ,T22.DP_NO AS SEQ" ).append("\n"); 
		query.append("      ,T21.CURR_CD CURRENCY" ).append("\n"); 
		query.append("      ,T21.YD_CHG_NO" ).append("\n"); 
		query.append("      ,T21.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("      ,T21.YD_CHG_XPR_NO" ).append("\n"); 
		query.append("      ,T22.OBJ_LIST_NO" ).append("\n"); 
		query.append("      ,T26.PSO_OBJ_CD OBJECT" ).append("\n"); 
		query.append("      ,T26.PSO_OBJ_CD_DSP OBJECT_DSP" ).append("\n"); 
		query.append("      ,T26.PSO_MEAS_UT_CD OBJECT_CODE" ).append("\n"); 
		query.append("      ,T26.PSO_MEAS_UT_CD_DSP OBJECT_CODE_DSP" ).append("\n"); 
		query.append("      ,T26.PSO_MEAS_UT_CD UOM" ).append("\n"); 
		query.append("      ,T26.PSO_MEAS_UT_CD_DSP UOM_DSP" ).append("\n"); 
		query.append("      ,PSO_TRF_TP_CD AS RATE_CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  --Framework의 문제로 Regex를 안 씀" ).append("\n"); 
		query.append("      ,NVL2(T23.FM_VAL, CASE WHEN T26.PSO_MEAS_UT_CD_DSP IN ('TIME') THEN TO_CHAR(T23.FM_VAL, 'FM0000') -- SUBSTR(TO_CHAR(T23.FM_VAL, 'FM0000'), 1, 2) || ':' || SUBSTR(TO_CHAR(T23.FM_VAL, 'FM0000'), 3, 2)      " ).append("\n"); 
		query.append("                             ELSE RTRIM(RTRIM(TO_CHAR(T23.FM_VAL, 'FM9,999,999,999,990.0000'), '0'), '.')" ).append("\n"); 
		query.append("                        END, NULL)  RANGE_FROM" ).append("\n"); 
		query.append("      ,NVL2(T23.TO_VAL, CASE WHEN T26.PSO_MEAS_UT_CD_DSP IN ('TIME') THEN TO_CHAR(T23.TO_VAL, 'FM0000') -- SUBSTR(TO_CHAR(T23.TO_VAL, 'FM0000'), 1, 2) || ':' || SUBSTR(TO_CHAR(T23.TO_VAL, 'FM0000'), 3, 2)      " ).append("\n"); 
		query.append("                             ELSE RTRIM(RTRIM(TO_CHAR(T23.TO_VAL, 'FM9,999,999,999,990.0000'), '0'), '.')" ).append("\n"); 
		query.append("                        END, NULL)  RANGE_TO    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,T23.TRF_RT_AMT RATE_VALUE" ).append("\n"); 
		query.append("      ,T21.CHG_XPR_NO" ).append("\n"); 
		query.append("      ,T21.CHG_XPR_SEQ" ).append("\n"); 
		query.append("      ,T21.PSO_CHG_TP_CD    -- B/S/D" ).append("\n"); 
		query.append("	  ,T21.CPLS_FLG " ).append("\n"); 
		query.append("      ,DECODE(T21.DFLT_FOML_FLG, 'Y', 1, 'N', 0, 0) DEFAULT2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,CASE WHEN @[uid] = '0004' AND T21.PSO_CHG_TP_CD = 'B' THEN T21.COND_NO END AS BM_CONDITION" ).append("\n"); 
		query.append("      ,(SELECT COND_DESC  FROM PSO_CONDITION WHERE COND_NO = CASE WHEN @[uid] = '0004' AND T21.PSO_CHG_TP_CD = 'B' THEN T21.COND_NO END) BM_COND_DESC" ).append("\n"); 
		query.append("      ,CASE WHEN @[uid] = '0004' AND T21.PSO_CHG_TP_CD = 'B' THEN T23.COND_NO ELSE T21.COND_NO END AS CONDITION" ).append("\n"); 
		query.append("      ,(SELECT COND_DESC  FROM PSO_CONDITION WHERE COND_NO = CASE WHEN @[uid] = '0004' AND T21.PSO_CHG_TP_CD = 'B' THEN T23.COND_NO ELSE T21.COND_NO END) COND_DESC      " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,'' SEQ2 -- FOR CONDITION_NEW" ).append("\n"); 
		query.append("      ,T21.FOML_NO AS FORMULA_NO" ).append("\n"); 
		query.append("      ,T21.PSO_CTRL_STMT_TP_CD SUM_OPTION" ).append("\n"); 
		query.append("      ,T22.PSO_TRF_TP_CD" ).append("\n"); 
		query.append("      ,T22.CONS_ALS_NM" ).append("\n"); 
		query.append("      ,T23.PORT_TRF_NO" ).append("\n"); 
		query.append("      ,T23.TRF_SEQ" ).append("\n"); 
		query.append("      ,T23.COND_NO COND_NO_23  " ).append("\n"); 
		query.append("      ,T21.COND_NO COND_NO_21" ).append("\n"); 
		query.append("#if(${uid} == '0002')" ).append("\n"); 
		query.append("      ,T24.DFLT_VAL REGULAR_VALUE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,T25.FOML_DESC FOML_DESC" ).append("\n"); 
		query.append("      ,T25.FOML_SYS_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       --이전 VO에 존재하던 필드" ).append("\n"); 
		query.append("      ,T22.PSO_RT_TP_CD METHOD_CODE" ).append("\n"); 
		query.append("      ,'' INV_USE" ).append("\n"); 
		query.append("      ,'' IDX" ).append("\n"); 
		query.append("      ,'' OBJECT_NAME" ).append("\n"); 
		query.append("      ,T21.COND_ALS_NM" ).append("\n"); 
		query.append("	  	" ).append("\n"); 
		query.append("FROM   (SELECT T1.YD_CHG_NO" ).append("\n"); 
		query.append("              ,T1.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("              ,T1.CURR_CD" ).append("\n"); 
		query.append("			  ,T1.CPLS_FLG" ).append("\n"); 
		query.append("              ,T2.YD_CHG_XPR_NO" ).append("\n"); 
		query.append("              ,T2.PSO_CHG_TP_CD" ).append("\n"); 
		query.append("              ,T3.CHG_XPR_NO" ).append("\n"); 
		query.append("              ,T3.CHG_XPR_SEQ" ).append("\n"); 
		query.append("              ,T3.PSO_CTRL_STMT_TP_CD" ).append("\n"); 
		query.append("              ,T3.COND_NO" ).append("\n"); 
		query.append("              ,T3.FOML_NO" ).append("\n"); 
		query.append("			  ,T3.DFLT_FOML_FLG" ).append("\n"); 
		query.append("			  ,T3.COND_ALS_NM" ).append("\n"); 
		query.append("        FROM   PSO_YD_CHG      T1" ).append("\n"); 
		query.append("              ,PSO_YD_CHG_XPR  T2" ).append("\n"); 
		query.append("			  ,PSO_CHG_XPR     T3_0 " ).append("\n"); 
		query.append("              ,PSO_CHG_XPR_DTL T3" ).append("\n"); 
		query.append("              /*,(SELECT T2.ACCT_CD" ).append("\n"); 
		query.append("                      ,T2.LGS_COST_CD" ).append("\n"); 
		query.append("                      ,LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                FROM   PSO_INV_OFC_COST T1" ).append("\n"); 
		query.append("                      ,TES_LGS_COST     T2" ).append("\n"); 
		query.append("                WHERE  T1.LGS_COST_CD = T2.LGS_COST_CD" ).append("\n"); 
		query.append("                AND    T1.OFC_CD = *ofc_cd" ).append("\n"); 
		query.append("                AND    T2.ACCT_CD <> '999999'" ).append("\n"); 
		query.append("                AND    LENGTH(T2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("                ORDER  BY 1) T5" ).append("\n"); 
		query.append("			   */" ).append("\n"); 
		query.append("              ,TES_LGS_COST T5 " ).append("\n"); 
		query.append("        WHERE  T1.YD_CHG_NO = T2.YD_CHG_NO" ).append("\n"); 
		query.append("        AND    T1.YD_CHG_VER_SEQ = T2.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("        AND    T1.LGS_COST_CD = T5.LGS_COST_CD" ).append("\n"); 
		query.append("#if( ${port_cd} == '' )" ).append("\n"); 
		query.append("		AND     T1.YD_CD            = @[combo1]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		AND     T1.YD_CD            = @[port_cd] || @[combo1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("        AND    T1.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("#if( ${org_vndr_nm} != '' )" ).append("\n"); 
		query.append("		AND     T1.ORG_VNDR_NM            LIKE '%' || @[org_vndr_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${acct_cd} == '' && ${combo3} != '')" ).append("\n"); 
		query.append("        AND     T1.LGS_COST_CD      = @[combo3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${acct_cd} != '' )" ).append("\n"); 
		query.append("		AND     T5.acct_cd         = @[acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    T1.YD_CHG_VER_SEQ = TO_NUMBER(@[combo4])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${combo5} != '' )" ).append("\n"); 
		query.append("		AND    T1.CURR_CD            = @[combo5]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    T1.EFF_DT = TO_DATE(REPLACE(@[from_date], '-', ''), 'YYYYMMDD')        " ).append("\n"); 
		query.append("        AND    T1.EXP_DT = TO_DATE(REPLACE(@[to_date], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    T2.CHG_XPR_NO = T3.CHG_XPR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    T3.CHG_XPR_NO = T3_0.CHG_XPR_NO" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        AND    T3_0.UPD_MNU_NO = DECODE(@[uid], '0002', 1, '0004', 2, T3_0.UPD_MNU_NO)	-- 2번화면:1, 4번화면:2" ).append("\n"); 
		query.append("	   ) T21" ).append("\n"); 
		query.append("      ,PSO_TARIFF T22" ).append("\n"); 
		query.append("      ,PSO_TRF_DTL T23" ).append("\n"); 
		query.append("#if(${uid} == '0002')" ).append("\n"); 
		query.append("      ,PSO_YD_CHG_OBJ_LIST T24" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,PSO_FORMULA T25" ).append("\n"); 
		query.append("      ,(        " ).append("\n"); 
		query.append("        SELECT DISTINCT B.OBJ_LIST_NO" ).append("\n"); 
		query.append("             , B.PSO_OBJ_CD PSO_OBJ_CD" ).append("\n"); 
		query.append("             , B.OBJ_LIST_NM PSO_OBJ_CD_DSP" ).append("\n"); 
		query.append("             , B.PSO_MEAS_UT_CD PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("             , C2.INTG_CD_VAL_DP_DESC PSO_MEAS_UT_CD_DSP" ).append("\n"); 
		query.append("          FROM PSO_OBJ_LIST B" ).append("\n"); 
		query.append("             , COM_INTG_CD_DTL C2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND B.PSO_MEAS_UT_CD = C2.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("           AND C2.INTG_CD_ID = 'CD01848'" ).append("\n"); 
		query.append("       ) T26" ).append("\n"); 
		query.append("WHERE  T21.CHG_XPR_NO = T22.CHG_XPR_NO" ).append("\n"); 
		query.append("AND    T21.CHG_XPR_SEQ = T22.CHG_XPR_SEQ" ).append("\n"); 
		query.append("AND    T22.PORT_TRF_NO = T23.PORT_TRF_NO" ).append("\n"); 
		query.append("#if(${uid} == '0002')" ).append("\n"); 
		query.append("AND    T21.YD_CHG_NO = T24.YD_CHG_NO(+)" ).append("\n"); 
		query.append("AND    T21.YD_CHG_VER_SEQ = T24.YD_CHG_VER_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    T21.FOML_NO = T25.FOML_NO" ).append("\n"); 
		query.append("AND    T22.OBJ_LIST_NO  = T26.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("ORDER  BY X.PSO_CHG_TP_CD" ).append("\n"); 
		query.append("         ,X.CHG_XPR_NO" ).append("\n"); 
		query.append("         ,X.CHG_XPR_SEQ" ).append("\n"); 
		query.append("         ,X.PORT_TRF_NO" ).append("\n"); 
		query.append("         ,X.TRF_SEQ" ).append("\n"); 

	}
}