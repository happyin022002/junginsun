/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SurplusAreaDBDAOSearchBkgSurplusAreaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurplusAreaDBDAOSearchBkgSurplusAreaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surplus Area - Yard 의 BKG for OP Ref 팝업 데이터를 조회함
	  * </pre>
	  */
	public SurplusAreaDBDAOSearchBkgSurplusAreaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration").append("\n"); 
		query.append("FileName : SurplusAreaDBDAOSearchBkgSurplusAreaRSQL").append("\n"); 
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
		query.append("WITH " ).append("\n"); 
		query.append("SIM_TP_CD_DATA AS (" ).append("\n"); 
		query.append("    SELECT 3 GRP_CD, 1 SORT, 'OP' CODE, 'OP' NAME FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("SIM_SS_DATA AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        S.GRP_CD, S.SORT, S.CODE, S.NAME, Q.LOC_CD" ).append("\n"); 
		query.append("        , Q.CNTR_TPSZ_CD, Q.FCAST_YRWK" ).append("\n"); 
		query.append("        , SUM(NVL(DECODE(Q.INVT_SIM_TP_CD,S.CODE,Q.QTY,0),0)) QTY" ).append("\n"); 
		query.append("    FROM SIM_TP_CD_DATA S, (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        #if (${loc_type_code} == '2') --RCC (by Country)" ).append("\n"); 
		query.append("            SUBSTR(Q.YD_CD,1,2)" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '3') --RCC (by LCC)" ).append("\n"); 
		query.append("            B.LCC_CD" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '4') --LCC (by ECC)" ).append("\n"); 
		query.append("            B.ECC_CD" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '5') --LCC (by SCC)" ).append("\n"); 
		query.append("            B.SCC_CD" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '6') --ECC (by SCC)" ).append("\n"); 
		query.append("            B.SCC_CD" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '7') --SCC (by Yard)" ).append("\n"); 
		query.append("            Q.YD_CD" ).append("\n"); 
		query.append("        #end    " ).append("\n"); 
		query.append("            LOC_CD" ).append("\n"); 
		query.append("            , Q.INVT_SIM_TP_CD" ).append("\n"); 
		query.append("            , Q.CNTR_TPSZ_CD, Q.FCAST_YRWK" ).append("\n"); 
		query.append("            , SUM(NVL(Q.CNTR_QTY,0)) QTY" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("            Q.YD_CD, " ).append("\n"); 
		query.append("			CASE" ).append("\n"); 
		query.append("			WHEN Q.FCAST_YRWK >= @[curr_yrwk] --(SELECT MAX(W.PLN_YR||W.PLN_WK) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT) " ).append("\n"); 
		query.append("			THEN " ).append("\n"); 
		query.append("		    	CASE" ).append("\n"); 
		query.append("			    WHEN SQ.FCAST_YRWK IS NOT NULL " ).append("\n"); 
		query.append("			    THEN Q.INVT_SIM_TP_CD" ).append("\n"); 
		query.append("			    ELSE DECODE(Q.INVT_SIM_TP_CD,'OF','OP','OP','XX','MF','MG','MG','XX',Q.INVT_SIM_TP_CD) --Q.INVT_SIM_TP_CD DECODE(Q.INVT_SIM_TP_CD,'OF','OP','OP','XX','MF','MG','MG','XX',Q.INVT_SIM_TP_CD)" ).append("\n"); 
		query.append("			    END" ).append("\n"); 
		query.append("			ELSE Q.INVT_SIM_TP_CD" ).append("\n"); 
		query.append("			END INVT_SIM_TP_CD ,  " ).append("\n"); 
		query.append("			Q.CNTR_TPSZ_CD, Q.FCAST_YRWK, NVL(SQ.CNTR_QTY,Q.CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append("            FROM EQR_CTRL_INVT_SIM_DTL D, EQR_CTRL_INVT_SIM_DTL_QTY Q" ).append("\n"); 
		query.append("               , ( SELECT Q.FCAST_YRWK, Q.YD_CD, Q.INVT_SIM_TP_CD, Q.CNTR_TPSZ_CD, Q.CNTR_QTY, Q.TMP_SAV_FLG, Q.CRE_DT, Q.UPD_DT  " ).append("\n"); 
		query.append("                   FROM EQR_CTRL_INVT_SIM S, EQR_CTRL_INVT_SIM_QTY Q" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                   AND S.FCAST_YRWK = Q.FCAST_YRWK" ).append("\n"); 
		query.append("                   AND S.YD_CD = Q.YD_CD" ).append("\n"); 
		query.append("                   AND S.INVT_SIM_TP_CD = Q.INVT_SIM_TP_CD " ).append("\n"); 
		query.append("                   AND Q.FCAST_YRWK >= @[curr_yrwk] --(SELECT MAX(W.PLN_YR||W.PLN_WK) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)" ).append("\n"); 
		query.append("                   AND Q.UPD_DT >= (SELECT TO_DATE(W.WK_ST_DT,'YYYYMMDD')+(1+5/24) BAT_MND FROM EQR_WK_PRD W WHERE W.PLN_YR = SUBSTR(@[curr_yrwk],1,4) AND W.PLN_WK = SUBSTR(@[curr_yrwk],5))" ).append("\n"); 
		query.append("                 ) SQ" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND D.FCAST_YRWK = Q.FCAST_YRWK" ).append("\n"); 
		query.append("            AND D.YD_CD = Q.YD_CD" ).append("\n"); 
		query.append("            AND D.INVT_SIM_TP_CD = Q.INVT_SIM_TP_CD" ).append("\n"); 
		query.append("            AND D.FCAST_YRWK = Q.FCAST_YRWK" ).append("\n"); 
		query.append("            AND Q.FCAST_YRWK BETWEEN @[fm_yrwk] AND @[to_yrwk]" ).append("\n"); 
		query.append("            AND Q.FCAST_YRWK = SQ.FCAST_YRWK(+)" ).append("\n"); 
		query.append("            AND Q.YD_CD = SQ.YD_CD(+)" ).append("\n"); 
		query.append("            AND Q.INVT_SIM_TP_CD = SQ.INVT_SIM_TP_CD(+)" ).append("\n"); 
		query.append("            AND Q.CNTR_TPSZ_CD = SQ.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("            GROUP BY Q.YD_CD, Q.INVT_SIM_TP_CD, Q.CNTR_TPSZ_CD, Q.FCAST_YRWK, NVL(SQ.CNTR_QTY,Q.CNTR_QTY), SQ.FCAST_YRWK" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("            Q.YD_CD, " ).append("\n"); 
		query.append("			Q.INVT_SIM_TP_CD INVT_SIM_TP_CD , " ).append("\n"); 
		query.append("			Q.CNTR_TPSZ_CD, Q.FCAST_YRWK, Q.CNTR_QTY" ).append("\n"); 
		query.append("            FROM EQR_CTRL_INVT_SIM S, EQR_CTRL_INVT_SIM_QTY Q" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND S.FCAST_YRWK = Q.FCAST_YRWK" ).append("\n"); 
		query.append("            AND S.YD_CD = Q.YD_CD" ).append("\n"); 
		query.append("            AND S.INVT_SIM_TP_CD = Q.INVT_SIM_TP_CD " ).append("\n"); 
		query.append("            AND S.FCAST_YRWK = Q.FCAST_YRWK" ).append("\n"); 
		query.append("            AND Q.FCAST_YRWK >= @[curr_yrwk] --(SELECT MAX(W.PLN_YR||W.PLN_WK) FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)" ).append("\n"); 
		query.append("            AND Q.UPD_DT >= (SELECT TO_DATE(W.WK_ST_DT,'YYYYMMDD')+(1+5/24) BAT_MND FROM EQR_WK_PRD W WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN W.WK_ST_DT AND W.WK_END_DT)" ).append("\n"); 
		query.append("            AND NOT EXISTS (" ).append("\n"); 
		query.append("                SELECT 'X' " ).append("\n"); 
		query.append("                FROM EQR_CTRL_INVT_SIM_DTL_QTY X" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND X.FCAST_YRWK = Q.FCAST_YRWK" ).append("\n"); 
		query.append("                AND X.YD_CD = Q.YD_CD" ).append("\n"); 
		query.append("                AND X.INVT_SIM_TP_CD = Q.INVT_SIM_TP_CD" ).append("\n"); 
		query.append("                AND X.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            GROUP BY Q.YD_CD, Q.INVT_SIM_TP_CD, Q.CNTR_TPSZ_CD, Q.FCAST_YRWK, Q.CNTR_QTY" ).append("\n"); 
		query.append("        ) Q, MDM_LOCATION A, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("            AND A.LOC_CD = SUBSTR(Q.YD_CD,1,5)" ).append("\n"); 
		query.append("            AND A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("            AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("        #if (${loc_type_code} == '2') --RCC (by Country)" ).append("\n"); 
		query.append("            AND B.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '3') --RCC (by LCC)          " ).append("\n"); 
		query.append("            AND B.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '4') --LCC (by ECC)" ).append("\n"); 
		query.append("            AND B.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '5') --LCC (by SCC)" ).append("\n"); 
		query.append("            AND B.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '6') --ECC (by SCC)" ).append("\n"); 
		query.append("            AND B.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '7') --SCC (by Yard)" ).append("\n"); 
		query.append("            AND B.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #end         " ).append("\n"); 
		query.append("        GROUP BY " ).append("\n"); 
		query.append("        #if (${loc_type_code} == '2') --RCC (by Country)" ).append("\n"); 
		query.append("            SUBSTR(Q.YD_CD,1,2)" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '3') --RCC (by LCC)          " ).append("\n"); 
		query.append("            B.LCC_CD" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '4') --LCC (by ECC)" ).append("\n"); 
		query.append("            B.ECC_CD" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '5') --LCC (by SCC)" ).append("\n"); 
		query.append("            B.SCC_CD" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '6') --ECC (by SCC)" ).append("\n"); 
		query.append("            B.SCC_CD" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '7') --SCC (by Yard)" ).append("\n"); 
		query.append("            Q.YD_CD" ).append("\n"); 
		query.append("        #end      " ).append("\n"); 
		query.append("            , Q.INVT_SIM_TP_CD, Q.CNTR_TPSZ_CD, Q.FCAST_YRWK " ).append("\n"); 
		query.append("    ) Q         " ).append("\n"); 
		query.append("    GROUP BY S.GRP_CD, S.SORT, S.CODE, S.NAME, Q.LOC_CD, Q.CNTR_TPSZ_CD, Q.FCAST_YRWK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.LOC_CD, A.CODE, A.NAME, A.GRP_CD, A.SORT" ).append("\n"); 
		query.append("#foreach($key in ${arrweek}) " ).append("\n"); 
		query.append(", MAX(A.D2_$key) D2_$key, MAX(A.D4_$key) D4_$key, MAX(A.D5_$key) D5_$key, MAX(A.D7_$key) D7_$key, MAX(A.R2_$key) R2_$key, MAX(A.R5_$key) R5_$key" ).append("\n"); 
		query.append(", MAX(A.R9_$key) R9_$key, MAX(A.O2_$key) O2_$key, MAX(A.O4_$key) O4_$key, MAX(A.S2_$key) S2_$key, MAX(A.S4_$key) S4_$key, MAX(A.F2_$key) F2_$key" ).append("\n"); 
		query.append(", MAX(A.F4_$key) F4_$key, MAX(A.F5_$key) F5_$key, MAX(A.A2_$key) A2_$key, MAX(A.A4_$key) A4_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" CASE WHEN GROUPING(R.LOC_CD)='1' THEN 'TTL' ELSE R.LOC_CD END LOC_CD" ).append("\n"); 
		query.append(", R.CODE, R.NAME, R.GRP_CD, R.SORT" ).append("\n"); 
		query.append("#foreach($key in ${arrweek})" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='D2$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END D2_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='D4$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END D4_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='D5$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END D5_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='D7$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END D7_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='R2$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END R2_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='R5$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END R5_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='R9$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END R9_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='O2$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END O2_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='O4$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END O4_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='S2$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END S2_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='S4$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END S4_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='F2$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END F2_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='F4$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END F4_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='F5$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END F5_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='A2$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END A2_$key" ).append("\n"); 
		query.append(",CASE WHEN R.CNTR_TPSZ_CD||R.FCAST_YRWK='A4$key' THEN DECODE(R.GRP_CD,'5',DECODE(GROUPING(R.LOC_CD),'1',TO_NUMBER(''),MAX(NVL((R.QTY),0))),SUM(NVL(R.QTY,0))) ELSE 0 END A4_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM SIM_SS_DATA R" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS ((R.GRP_CD, R.SORT, R.CODE, R.NAME, R.CNTR_TPSZ_CD, R.FCAST_YRWK),(R.LOC_CD, R.GRP_CD, R.SORT, R.CODE, R.NAME, R.CNTR_TPSZ_CD, R.FCAST_YRWK))" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY A.LOC_CD, A.CODE, A.NAME, A.GRP_CD, A.SORT" ).append("\n"); 
		query.append("ORDER BY CASE WHEN A.LOC_CD ='TTL' THEN 'AAAAA' ELSE A.LOC_CD END, A.GRP_CD, A.SORT" ).append("\n"); 

	}
}