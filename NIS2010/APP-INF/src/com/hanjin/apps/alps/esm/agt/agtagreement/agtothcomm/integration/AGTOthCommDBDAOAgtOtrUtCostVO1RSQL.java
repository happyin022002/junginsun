/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOthCommDBDAOAgtOtrUtCostVO1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.18 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOthCommDBDAOAgtOtrUtCostVO1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commission Unit Cost Inquiry
	  * </pre>
	  */
	public AGTOthCommDBDAOAgtOtrUtCostVO1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_yrmon1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.integration").append("\n"); 
		query.append("FileName : AGTOthCommDBDAOAgtOtrUtCostVO1RSQL").append("\n"); 
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
		query.append("SELECT KIND," ).append("\n"); 
		query.append("BND," ).append("\n"); 
		query.append("ROUND(D2, 2) D2," ).append("\n"); 
		query.append("ROUND(D4, 2) D4," ).append("\n"); 
		query.append("ROUND(D5, 2) D5," ).append("\n"); 
		query.append("ROUND(D7, 2) D7," ).append("\n"); 
		query.append("ROUND(D9, 2) D9," ).append("\n"); 
		query.append("ROUND(R2, 2) R2," ).append("\n"); 
		query.append("ROUND(R4, 2) R4," ).append("\n"); 
		query.append("ROUND(R5, 2) R5," ).append("\n"); 
		query.append("ROUND(R7, 2) R7," ).append("\n"); 
		query.append("ROUND(F2, 2) F2," ).append("\n"); 
		query.append("ROUND(F4, 2) F4," ).append("\n"); 
		query.append("ROUND(O2, 2) O2," ).append("\n"); 
		query.append("ROUND(O4, 2) O4," ).append("\n"); 
		query.append("ROUND(P2, 2) P2," ).append("\n"); 
		query.append("ROUND(P4, 2) P4," ).append("\n"); 
		query.append("ROUND(S2, 2) S2," ).append("\n"); 
		query.append("ROUND(S4, 2) S4," ).append("\n"); 
		query.append("ROUND(T2, 2) T2," ).append("\n"); 
		query.append("ROUND(T4, 2) T4," ).append("\n"); 
		query.append("ROUND(A2, 2) A2," ).append("\n"); 
		query.append("ROUND(A4, 2) A4," ).append("\n"); 
		query.append("ROUND(DW, 2) DW," ).append("\n"); 
		query.append("ROUND(DX, 2) DX" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("1             AS SEQ," ).append("\n"); 
		query.append("'Commission'  AS KIND," ).append("\n"); 
		query.append("'I/B'         AS BND" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 2             AS SEQ," ).append("\n"); 
		query.append("'Commission'," ).append("\n"); 
		query.append("'T/S'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("3             AS SEQ," ).append("\n"); 
		query.append("'Commission'," ).append("\n"); 
		query.append("'O/B'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("4             AS SEQ," ).append("\n"); 
		query.append("'Brokerage/FAC'," ).append("\n"); 
		query.append("'   '" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 5             AS SEQ," ).append("\n"); 
		query.append("'CHF'," ).append("\n"); 
		query.append("'I/B'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 6             AS SEQ," ).append("\n"); 
		query.append("'CHF'," ).append("\n"); 
		query.append("'O/B'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("COMM_TYPE," ).append("\n"); 
		query.append("BOUND," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ,  1, TPSZZ, NULL), NULL, 0, UNIT_COST)) D2," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ,  2, TPSZZ, NULL), NULL, 0, UNIT_COST)) D4," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ,  3, TPSZZ, NULL), NULL, 0, UNIT_COST)) D5," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ,  4, TPSZZ, NULL), NULL, 0, UNIT_COST)) D7," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ,  5, TPSZZ, NULL), NULL, 0, UNIT_COST)) D8," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ,  6, TPSZZ, NULL), NULL, 0, UNIT_COST)) D9," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ,  7, TPSZZ, NULL), NULL, 0, UNIT_COST)) R2," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ,  8, TPSZZ, NULL), NULL, 0, UNIT_COST)) R4," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ,  9, TPSZZ, NULL), NULL, 0, UNIT_COST)) R5," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 10, TPSZZ, NULL), NULL, 0, UNIT_COST)) R7," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 11, TPSZZ, NULL), NULL, 0, UNIT_COST)) F2," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 12, TPSZZ, NULL), NULL, 0, UNIT_COST)) F4," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 13, TPSZZ, NULL), NULL, 0, UNIT_COST)) F5," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 14, TPSZZ, NULL), NULL, 0, UNIT_COST)) O2," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 15, TPSZZ, NULL), NULL, 0, UNIT_COST)) O4," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 16, TPSZZ, NULL), NULL, 0, UNIT_COST)) P2," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 17, TPSZZ, NULL), NULL, 0, UNIT_COST)) P4," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 18, TPSZZ, NULL), NULL, 0, UNIT_COST)) S2," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 19, TPSZZ, NULL), NULL, 0, UNIT_COST)) S4," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 20, TPSZZ, NULL), NULL, 0, UNIT_COST)) T2," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 21, TPSZZ, NULL), NULL, 0, UNIT_COST)) T4," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 22, TPSZZ, NULL), NULL, 0, UNIT_COST)) A2," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 23, TPSZZ, NULL), NULL, 0, UNIT_COST)) A4," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 24, TPSZZ, NULL), NULL, 0, UNIT_COST)) DW," ).append("\n"); 
		query.append("SUM(DECODE(DECODE(SEQ, 25, TPSZZ, NULL), NULL, 0, UNIT_COST)) DX" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(     SELECT DECODE(AC_TP_CD, 'K', 'Brokerage/FAC', 'B', 'Brokerage/FAC', 'F', 'Brokerage/FAC', 'H', 'CHF', 'Commission') COMM_TYPE," ).append("\n"); 
		query.append("DECODE(IO_BND_CD||AC_TP_CD, 'OS', 'T/S', 'IS', 'T/S', 'OF', '   ', 'OB', '   ', 'OK', '   ', DECODE(IO_BND_CD, 'O', 'O/B', 'I/B')) BOUND," ).append("\n"); 
		query.append("CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("SUM(COMM_UT_AMT) UNIT_COST" ).append("\n"); 
		query.append("FROM AGT_OTR_UT_COST" ).append("\n"); 
		query.append("WHERE COMM_YRMON = REPLACE(@[comm_yrmon1], '-', '')" ).append("\n"); 
		query.append("AND OFC_CD     = @[ofc_cd]" ).append("\n"); 
		query.append("AND BKG_POR_CD = NVL(@[bkg_por_cd], BKG_POR_CD)" ).append("\n"); 
		query.append("AND BKG_DEL_CD = NVL(@[bkg_del_cd], BKG_DEL_CD)" ).append("\n"); 
		query.append("GROUP BY DECODE(AC_TP_CD, 'K', 'Brokerage/FAC', 'B', 'Brokerage/FAC', 'F', 'Brokerage/FAC', 'H', 'CHF', 'Commission'), DECODE(IO_BND_CD||AC_TP_CD, 'OS', 'T/S', 'IS', 'T/S', 'OF', '   ', 'OB', '   ', 'OK', '   ', DECODE(IO_BND_CD, 'O', 'O/B', 'I/B')) , CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("DECODE(CNTR_TPSZ_CD, 'D2', 1, 'D4', 2, 'D5', 3, 'D7', 4, 'D8', 5, 'D9', 6, 'R2', 7, 'R4', 8, 'R5', 9, 'R7', 10, 'F2', 11, 'F4', 12, 'F5', 13, 'O2', 14, 'O4', 15, 'P2', 16, 'P4', 17, 'S2', 18, 'S4', 19, 'T2', 20, 'T4', 21, 'A2', 22, 'A4', 23, 'DW', 24, 25) SEQ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD TPSZZ" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE TPSZZ = TPSZ" ).append("\n"); 
		query.append("GROUP BY DECODE(COMM_TYPE, 'Commission', 1, 'CHF', 3, 2), COMM_TYPE, BOUND" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE KIND = COMM_TYPE(+)" ).append("\n"); 
		query.append("AND BND  = BOUND(+)" ).append("\n"); 
		query.append("ORDER BY SEQ" ).append("\n"); 

	}
}