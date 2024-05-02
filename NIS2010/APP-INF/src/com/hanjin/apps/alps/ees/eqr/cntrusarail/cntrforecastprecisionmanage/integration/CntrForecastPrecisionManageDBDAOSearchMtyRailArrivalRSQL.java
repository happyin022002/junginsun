/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrusarail.cntrforecastprecisionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_RAIL_TZ_RPT 데이터 조회
	  * 
	  * 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
	  * </pre>
	  */
	public CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalRSQL(){
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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalRSQL").append("\n"); 
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
		query.append("SELECT	 NVL(DEST1,'G.Total') AS DEST1 " ).append("\n"); 
		query.append("		,CASE WHEN COLOR=2 THEN DEST1 ELSE NVL(DEST2,'G.Total') END DEST2 " ).append("\n"); 
		query.append("		,DECODE(COLOR,1,'Total', 1.5, DECODE(DEST2, '','G.Total',NVL(TPSZ,'Total')),NVL(TPSZ,'Total')) TPSZ " ).append("\n"); 
		query.append("	#foreach ( $key in ${arrday} ) " ).append("\n"); 
		query.append("		,DAY_${key} " ).append("\n"); 
		query.append("		,DAY_${key}_MT" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("		,COLOR " ).append("\n"); 
		query.append("		,GUBUN " ).append("\n"); 
		query.append("FROM	( " ).append("\n"); 
		query.append("		#if ( ${gubun} == 'A' ) " ).append("\n"); 
		query.append("		SELECT  GROUPING(C.LOC_CD) + GROUPING(A.TO_NOD_CD) + GROUPING(A.EQ_TPSZ_CD) COLOR" ).append("\n"); 
		query.append("				,C.LOC_CD DEST1 " ).append("\n"); 
		query.append("				,A.TO_NOD_CD DEST2 " ).append("\n"); 
		query.append("		#elseif ( ${gubun} == 'B' ) " ).append("\n"); 
		query.append("		SELECT  GROUPING(A.FM_NOD_CD) + GROUPING(A.TO_NOD_CD) + GROUPING(A.EQ_TPSZ_CD) COLOR" ).append("\n"); 
		query.append("				,A.TO_NOD_CD DEST1" ).append("\n"); 
		query.append("				,A.FM_NOD_CD DEST2" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("				,A.EQ_TPSZ_CD AS TPSZ " ).append("\n"); 
		query.append("			#if ( ${gubun} == 'A' ) " ).append("\n"); 
		query.append("				,NVL(C.LOC_CD,'ZZZZZ') || NVL(A.TO_NOD_CD, 'ZZZZZZZ') || NVL(A.EQ_TPSZ_CD,'ZZ') AS GUBUN " ).append("\n"); 
		query.append("			#elseif ( ${gubun} == 'B' ) " ).append("\n"); 
		query.append("				,NVL(A.TO_NOD_CD,'ZZZZZ') || NVL(A.FM_NOD_CD, 'ZZZZZZZ') || NVL(A.EQ_TPSZ_CD,'ZZ') AS GUBUN " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			#foreach ( $key IN ${arrday} ) " ).append("\n"); 
		query.append("				,COUNT(DECODE(TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd'),TO_CHAR(TO_DATE(@[fm_dt],'yyyy-MM-dd')+$key,'yyyyMMdd'),1)) AS DAY_${key} " ).append("\n"); 
		query.append("				,NVL(SUM(DECODE(TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd'),TO_CHAR(TO_DATE(@[fm_dt],'yyyy-MM-dd')+$key,'yyyyMMdd')," ).append("\n"); 
		query.append("		        ( SELECT DECODE(COUNT(*),0,0,1)" ).append("\n"); 
		query.append("        			FROM SCE_CLM CLM, CTM_MOVEMENT CM" ).append("\n"); 
		query.append("			        WHERE A.TRSP_SO_OFC_CTY_CD = CLM.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			          AND A.TRSP_SO_SEQ = CLM.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			          AND CM.CNTR_NO = CLM.CNTR_NO" ).append("\n"); 
		query.append("			          AND CM.CNMV_YR = CLM.CNMV_YR" ).append("\n"); 
		query.append("			          AND CM.CNMV_ID_NO = CLM.CNMV_ID_NO  " ).append("\n"); 
		query.append("			          AND CM.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("					  AND CM.ORG_YD_CD = A.TO_NOD_CD" ).append("\n"); 
		query.append("			        GROUP BY CM.CNTR_NO ))),0) AS DAY_${key}_MT" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		FROM	SCE_RAIL_TZ_RPT A " ).append("\n"); 
		query.append("				,MDM_YARD B " ).append("\n"); 
		query.append("				,MDM_YARD C" ).append("\n"); 
		query.append("	#if ( ${rail_company} != '' ) " ).append("\n"); 
		query.append("				,TRS_TRSP_RAIL_BIL_VNDR_SET D" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("		WHERE	A.FM_NOD_CD	= B.YD_CD " ).append("\n"); 
		query.append("			AND	A.TO_NOD_CD	= C.YD_CD " ).append("\n"); 
		query.append("			AND	A.RAIL_DEST_N2ND_ETA_DT BETWEEN  TO_DATE('${fm_dt} 00:00:00', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("										AND  TO_DATE('${to_dt} 23:59:59', 'YYYY-MM-DD HH24:MI:SS') " ).append("\n"); 
		query.append("			AND	A.CGO_TP_CD	= 'M'			-- MTY " ).append("\n"); 
		query.append("			AND	A.DELT_FLG	= 'N'			-- S/O CANCEL ??????????." ).append("\n"); 
		query.append("		#if ( ${org_loc} != '' ) " ).append("\n"); 
		query.append("			AND B.LOC_CD = @[org_loc] " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if ( ${dest_loc} != '' ) " ).append("\n"); 
		query.append("			AND C.LOC_CD = @[dest_loc] " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if ( ${tpszText} != '' )" ).append("\n"); 
		query.append("			AND	A.EQ_TPSZ_CD IN ( ${tpszText} )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if ( ${rail_company} != '' ) " ).append("\n"); 
		query.append("         	AND A.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			AND A.TRSP_SO_SEQ = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			AND D.SUB_RAIL_SEQ	= '1'" ).append("\n"); 
		query.append("			AND D.VNDR_SEQ		= @[rail_company]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if ( ${gubun} == 'A' ) " ).append("\n"); 
		query.append("		HAVING GROUPING(C.LOC_CD) + GROUPING(A.TO_NOD_CD) + GROUPING(a.eq_tpsz_cd) < 2 " ).append("\n"); 
		query.append("		GROUP BY ROLLUP(C.LOC_CD,A.TO_NOD_CD,A.EQ_TPSZ_CD) " ).append("\n"); 
		query.append("		#elseif ( ${gubun} == 'B' ) " ).append("\n"); 
		query.append("		HAVING GROUPING(A.FM_NOD_CD) + GROUPING(A.TO_NOD_CD) + GROUPING(A.EQ_TPSZ_CD) < 2 " ).append("\n"); 
		query.append("		GROUP BY ROLLUP(A.FM_NOD_CD,A.TO_NOD_CD,A.EQ_TPSZ_CD) " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		UNION ALL " ).append("\n"); 
		query.append("		SELECT	2 COLOR" ).append("\n"); 
		query.append("				,'Total' " ).append("\n"); 
		query.append("				,'Total' " ).append("\n"); 
		query.append("				,A.EQ_TPSZ_CD " ).append("\n"); 
		query.append("				,'ZZZZZ'||	'ZZZZZZZ' ||A.EQ_TPSZ_CD GUBUN " ).append("\n"); 
		query.append("			#foreach ( $key in ${arrday} ) " ).append("\n"); 
		query.append("				,COUNT(DECODE(TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd'),TO_CHAR(TO_DATE(@[fm_dt],'yyyy-MM-dd')+$key,'yyyyMMdd'),1)) AS DAY_${key} " ).append("\n"); 
		query.append("				,NVL(SUM(DECODE(TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd'),TO_CHAR(TO_DATE(@[fm_dt],'yyyy-MM-dd')+$key,'yyyyMMdd')," ).append("\n"); 
		query.append("		        ( SELECT DECODE(COUNT(*),0,0,1)" ).append("\n"); 
		query.append("        			FROM SCE_CLM CLM, CTM_MOVEMENT CM" ).append("\n"); 
		query.append("			        WHERE A.TRSP_SO_OFC_CTY_CD = CLM.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			          AND A.TRSP_SO_SEQ = CLM.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			          AND CM.CNTR_NO = CLM.CNTR_NO" ).append("\n"); 
		query.append("			          AND CM.CNMV_YR = CLM.CNMV_YR" ).append("\n"); 
		query.append("			          AND CM.CNMV_ID_NO = CLM.CNMV_ID_NO  " ).append("\n"); 
		query.append("			          AND CM.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("					  AND CM.ORG_YD_CD = A.TO_NOD_CD" ).append("\n"); 
		query.append("			        GROUP BY CM.CNTR_NO ))),0) AS DAY_${key}_MT" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		FROM	SCE_RAIL_TZ_RPT A " ).append("\n"); 
		query.append("				,MDM_YARD B " ).append("\n"); 
		query.append("				,MDM_YARD C " ).append("\n"); 
		query.append("	#if ( ${rail_company} != '' ) " ).append("\n"); 
		query.append("				,TRS_TRSP_RAIL_BIL_VNDR_SET D" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("		WHERE	A.FM_NOD_CD	= B.YD_CD " ).append("\n"); 
		query.append("			AND	A.TO_NOD_CD	= C.YD_CD " ).append("\n"); 
		query.append("			AND	A.RAIL_DEST_N2ND_ETA_DT BETWEEN  TO_DATE('${fm_dt} 00:00:00', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("										AND  TO_DATE('${to_dt} 23:59:59', 'YYYY-MM-DD HH24:MI:SS') " ).append("\n"); 
		query.append("			AND	A.CGO_TP_CD	= 'M'				-- MTY " ).append("\n"); 
		query.append("			AND	A.DELT_FLG	= 'N'			-- S/O CANCEL ??????????." ).append("\n"); 
		query.append("		#if ( ${org_loc} != '' ) " ).append("\n"); 
		query.append("			AND B.LOC_CD = @[org_loc] " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if ( ${dest_loc} != '' ) " ).append("\n"); 
		query.append("			AND C.LOC_CD = @[dest_loc] " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if ( ${tpszText} != '' )" ).append("\n"); 
		query.append("			AND	A.EQ_TPSZ_CD IN ( ${tpszText})" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if ( ${rail_company} != '' ) " ).append("\n"); 
		query.append("	  	    AND A.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			AND A.TRSP_SO_SEQ = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			AND D.SUB_RAIL_SEQ	= '1'" ).append("\n"); 
		query.append("			AND D.VNDR_SEQ		= @[rail_company]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		GROUP BY  A.EQ_TPSZ_CD " ).append("\n"); 
		query.append("		UNION ALL " ).append("\n"); 
		query.append("		SELECT	1.5 COLOR" ).append("\n"); 
		query.append("			#if ( ${gubun} == 'A' ) " ).append("\n"); 
		query.append("				,C.LOC_CD		DEST1 " ).append("\n"); 
		query.append("				,DECODE(C.LOC_CD,NULL,'','Total') DEST2 " ).append("\n"); 
		query.append("			#elseif ( ${gubun} == 'B' ) " ).append("\n"); 
		query.append("				,A.TO_NOD_CD	DEST1 " ).append("\n"); 
		query.append("				,DECODE(A.TO_NOD_CD,NULL,'','Total') DEST2 " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("				,A.EQ_TPSZ_CD AS TPSZ " ).append("\n"); 
		query.append("			#if ( ${gubun} == 'A' ) " ).append("\n"); 
		query.append("				,NVL(C.LOC_CD,'ZZZZZ') || 'ZZZZZZZ' || NVL(A.EQ_TPSZ_CD,'ZZ') AS GUBUN " ).append("\n"); 
		query.append("			#elseif ( ${gubun} == 'B' ) " ).append("\n"); 
		query.append("				,NVL(A.TO_NOD_CD,'ZZZZZ') || 'ZZZZZZZ' || NVL(A.EQ_TPSZ_CD,'ZZ') AS GUBUN " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			#foreach ( $key in ${arrday} ) " ).append("\n"); 
		query.append("				,COUNT(DECODE(TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd'),TO_CHAR(TO_DATE(@[fm_dt],'yyyy-MM-dd')+$key,'yyyyMMdd'),1)) AS DAY_${key} " ).append("\n"); 
		query.append("				,NVL(SUM(DECODE(TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd'),TO_CHAR(TO_DATE(@[fm_dt],'yyyy-MM-dd')+$key,'yyyyMMdd')," ).append("\n"); 
		query.append("		        ( SELECT DECODE(COUNT(*),0,0,1)" ).append("\n"); 
		query.append("        			FROM SCE_CLM CLM, CTM_MOVEMENT CM" ).append("\n"); 
		query.append("			        WHERE A.TRSP_SO_OFC_CTY_CD = CLM.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			          AND A.TRSP_SO_SEQ = CLM.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			          AND CM.CNTR_NO = CLM.CNTR_NO" ).append("\n"); 
		query.append("			          AND CM.CNMV_YR = CLM.CNMV_YR" ).append("\n"); 
		query.append("			          AND CM.CNMV_ID_NO = CLM.CNMV_ID_NO  " ).append("\n"); 
		query.append("			          AND CM.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("					  AND CM.ORG_YD_CD = A.TO_NOD_CD" ).append("\n"); 
		query.append("			        GROUP BY CM.CNTR_NO ))),0) AS DAY_${key}_MT" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		FROM	SCE_RAIL_TZ_RPT A " ).append("\n"); 
		query.append("				,MDM_YARD B " ).append("\n"); 
		query.append("				,MDM_YARD C" ).append("\n"); 
		query.append("	#if ( ${rail_company} != '' ) " ).append("\n"); 
		query.append("				,TRS_TRSP_RAIL_BIL_VNDR_SET D" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("		WHERE	A.FM_NOD_CD	= B.YD_CD " ).append("\n"); 
		query.append("			AND	A.TO_NOD_CD	= C.YD_CD " ).append("\n"); 
		query.append("			AND	A.RAIL_DEST_N2ND_ETA_DT BETWEEN  TO_DATE('${fm_dt} 00:00:00', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("										AND  TO_DATE('${to_dt} 23:59:59', 'YYYY-MM-DD HH24:MI:SS') " ).append("\n"); 
		query.append("			AND	A.CGO_TP_CD	= 'M'				-- MTY " ).append("\n"); 
		query.append("			AND	A.DELT_FLG	= 'N'			-- S/O CANCEL ??????????." ).append("\n"); 
		query.append("		#if ( ${org_loc} != '' ) " ).append("\n"); 
		query.append("			AND B.LOC_CD = @[org_loc] " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if ( ${dest_loc} != '' ) " ).append("\n"); 
		query.append("			AND C.LOC_CD = @[dest_loc] " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if ( ${tpszText} != '' )" ).append("\n"); 
		query.append("			AND	A.EQ_TPSZ_CD IN ( ${tpszText})" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if ( ${rail_company} != '' ) " ).append("\n"); 
		query.append("	      	AND A.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			AND A.TRSP_SO_SEQ = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			AND D.SUB_RAIL_SEQ	= '1'" ).append("\n"); 
		query.append("			AND D.VNDR_SEQ		= @[rail_company]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#if ( ${gubun} == 'A' )" ).append("\n"); 
		query.append("		GROUP BY  ROLLUP(C.LOC_CD,A.EQ_TPSZ_CD) " ).append("\n"); 
		query.append("	#elseif ( ${gubun} == 'B' )" ).append("\n"); 
		query.append("		GROUP BY  ROLLUP(A.TO_NOD_CD,A.EQ_TPSZ_CD) " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("ORDER BY GUBUN,COLOR" ).append("\n"); 

	}
}