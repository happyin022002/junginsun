/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrForecastPrecisionManageDBDAOSearchMtyRailResultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.03.10 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrusarail.cntrforecastprecisionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrForecastPrecisionManageDBDAOSearchMtyRailResultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_RAIL_TZ_RPT 데이터 조회
	  * </pre>
	  */
	public CntrForecastPrecisionManageDBDAOSearchMtyRailResultRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrusarail.cntrforecastprecisionmanage.integration").append("\n"); 
		query.append("FileName : CntrForecastPrecisionManageDBDAOSearchMtyRailResultRSQL").append("\n"); 
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
		query.append("WITH MTY_RAIL AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	FM_NOD_CD" ).append("\n"); 
		query.append(",TO_NOD_CD" ).append("\n"); 
		query.append(",EQ_TPSZ_CD" ).append("\n"); 
		query.append(",ORG_GATE_IN_DT" ).append("\n"); 
		query.append(",ORG_GATE_OUT_DT" ).append("\n"); 
		query.append(",NVL(ORG_GATE_OUT_DT,ORG_GATE_IN_DT+1) AS DEPARTURE_DATE" ).append("\n"); 
		query.append(",DEST_GATE_IN_DT" ).append("\n"); 
		query.append(",DEST_AVAL_DT" ).append("\n"); 
		query.append(",DEST_GATE_OUT_DT" ).append("\n"); 
		query.append(",NVL(DEST_GATE_IN_DT,NVL(DEST_AVAL_DT,DEST_GATE_OUT_DT)) AS ARRIVAL_DATE" ).append("\n"); 
		query.append(",TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM	SCE_RAIL_TZ_RPT" ).append("\n"); 
		query.append("WHERE	CGO_TP_CD  = 'M'               -- MTY" ).append("\n"); 
		query.append("AND	DELT_FLG   = 'N'               -- S/O CANCEL 안된것만." ).append("\n"); 
		query.append("AND (DEST_GATE_IN_DT IS NOT NULL OR DEST_AVAL_DT IS NOT NULL OR DEST_GATE_OUT_DT IS NOT NULL)" ).append("\n"); 
		query.append("AND	SO_CRE_DT  BETWEEN ADD_MONTHS(TO_DATE('${fm_dt} 00:00:00','YYYY-MM-DD HH24:MI:SS'),-3)" ).append("\n"); 
		query.append("AND ADD_MONTHS(TO_DATE('${to_dt} 23:59:59','YYYY-MM-DD HH24:MI:SS'),3)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${gubun} == 'A' )" ).append("\n"); 
		query.append("SELECT	 B.LOC_CD		AS DEST1" ).append("\n"); 
		query.append(",NVL(C.LOC_CD,'Total')		AS DEST2" ).append("\n"); 
		query.append("#elseif ( ${gubun} == 'B' )" ).append("\n"); 
		query.append("SELECT	 A.FM_NOD_CD		AS DEST1" ).append("\n"); 
		query.append(",NVL(A.TO_NOD_CD,'Total')		AS DEST2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,A.EQ_TPSZ_CD,1,0))	AS TOTAL" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'$key',1,0))		AS ${key}_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${gubun} == 'A' )" ).append("\n"); 
		query.append(",GROUPING(C.LOC_CD)+GROUPING(B.LOC_CD)	AS COLOR" ).append("\n"); 
		query.append("#elseif ( ${gubun} == 'B' )" ).append("\n"); 
		query.append(",GROUPING(A.FM_NOD_CD)+GROUPING(A.TO_NOD_CD)	AS COLOR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM	 MTY_RAIL A" ).append("\n"); 
		query.append(",MDM_YARD B" ).append("\n"); 
		query.append(",MDM_YARD C" ).append("\n"); 
		query.append("#if ( ${rail_company} != '' )" ).append("\n"); 
		query.append(",TRS_TRSP_RAIL_BIL_VNDR_SET D" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE	A.FM_NOD_CD	= B.YD_CD" ).append("\n"); 
		query.append("AND	A.TO_NOD_CD	= C.YD_CD" ).append("\n"); 
		query.append("#if ( ${date_kind} == 'D' )" ).append("\n"); 
		query.append("AND	A.DEPARTURE_DATE		BETWEEN  TO_DATE('${fm_dt} 00:00:00', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND  TO_DATE('${to_dt} 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#elseif ( ${date_kind} == 'A' )" ).append("\n"); 
		query.append("AND	A.ARRIVAL_DATE		BETWEEN  TO_DATE('${fm_dt} 00:00:00', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND  TO_DATE('${to_dt} 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${org_loc} != '' )" ).append("\n"); 
		query.append("AND B.LOC_CD = @[org_loc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${dest_loc} != '' )" ).append("\n"); 
		query.append("AND C.LOC_CD = @[dest_loc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${rail_company} != '' )" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND D.SUB_RAIL_SEQ	= '1'" ).append("\n"); 
		query.append("AND D.VNDR_SEQ		= @[rail_company]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${gubun} == 'A' )" ).append("\n"); 
		query.append("HAVING GROUPING(B.LOC_CD)+GROUPING(C.LOC_CD) <> 2" ).append("\n"); 
		query.append("GROUP BY ROLLUP(B.LOC_CD,C.LOC_CD)" ).append("\n"); 
		query.append("#elseif ( ${gubun} == 'B' )" ).append("\n"); 
		query.append("HAVING GROUPING(A.FM_NOD_CD)+GROUPING(A.TO_NOD_CD) <> 2" ).append("\n"); 
		query.append("GROUP BY ROLLUP(A.FM_NOD_CD,A.TO_NOD_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	'Total' AS DEST1" ).append("\n"); 
		query.append("#if ( ${gubun} == 'A' )" ).append("\n"); 
		query.append(",NVL(C.LOC_CD,'G.Total')	AS DEST2" ).append("\n"); 
		query.append("#elseif ( ${gubun} == 'B' )" ).append("\n"); 
		query.append(",NVL(A.TO_NOD_CD,'G.Total')	AS DEST2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD, A.EQ_TPSZ_CD, 1, 0)) AS TOTAL" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append(",SUM(DECODE(A.EQ_TPSZ_CD,'$key',1,0))		AS ${key}_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${gubun} == 'A' )" ).append("\n"); 
		query.append(",GROUPING(C.LOC_CD) + 2	AS COLOR" ).append("\n"); 
		query.append("#elseif ( ${gubun} == 'B' )" ).append("\n"); 
		query.append(",GROUPING(A.TO_NOD_CD) + 2	AS COLOR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM	 MTY_RAIL A" ).append("\n"); 
		query.append(",MDM_YARD B" ).append("\n"); 
		query.append(",MDM_YARD C" ).append("\n"); 
		query.append("#if ( ${rail_company} != '' )" ).append("\n"); 
		query.append(",TRS_TRSP_RAIL_BIL_VNDR_SET D" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE	A.FM_NOD_CD	= B.YD_CD" ).append("\n"); 
		query.append("AND	A.TO_NOD_CD	= C.YD_CD" ).append("\n"); 
		query.append("#if ( ${date_kind} == 'D' )" ).append("\n"); 
		query.append("AND	A.DEPARTURE_DATE		BETWEEN  TO_DATE('${fm_dt} 00:00:00', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND  TO_DATE('${to_dt} 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#elseif ( ${date_kind} == 'A' )" ).append("\n"); 
		query.append("AND	A.ARRIVAL_DATE		BETWEEN  TO_DATE('${fm_dt} 00:00:00', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("AND  TO_DATE('${to_dt} 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${org_loc} != '' )" ).append("\n"); 
		query.append("AND B.LOC_CD = @[org_loc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${dest_loc} != '' )" ).append("\n"); 
		query.append("AND C.LOC_CD = @[dest_loc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${rail_company} != '' )" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND D.SUB_RAIL_SEQ	= '1'" ).append("\n"); 
		query.append("AND D.VNDR_SEQ		= @[rail_company]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${gubun} == 'A' )" ).append("\n"); 
		query.append("GROUP BY ROLLUP(C.LOC_CD)" ).append("\n"); 
		query.append("#elseif ( ${gubun} == 'B' )" ).append("\n"); 
		query.append("GROUP BY ROLLUP(A.TO_NOD_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}