/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 조건의 Mty Rail Cntr No.를 조회한다
	  * 
	  * 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
	  * </pre>
	  */
	public CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalDetailRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.integration").append("\n"); 
		query.append("FileName : CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalDetailRSQL").append("\n"); 
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
		query.append("SELECT GUBUN" ).append("\n"); 
		query.append("      ,EQ_NO, MT" ).append("\n"); 
		query.append("      ,(SELECT CM.CNMV_STS_CD " ).append("\n"); 
		query.append(" 		  FROM MST_CONTAINER CM" ).append("\n"); 
		query.append("         WHERE CM.CNTR_NO = AA.EQ_NO" ).append("\n"); 
		query.append("       ) MVMT_STS_CD" ).append("\n"); 
		query.append("  FROM(	" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("			#if ( ${gubun} == 'A' ) " ).append("\n"); 
		query.append("				TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd') || NVL(C.LOC_CD,'ZZZZZ') || NVL(A.TO_NOD_CD, 'ZZZZZZZ') || NVL(A.EQ_TPSZ_CD,'ZZ') AS GUBUN " ).append("\n"); 
		query.append("			#elseif ( ${gubun} == 'B' ) " ).append("\n"); 
		query.append("				TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd') || NVL(A.TO_NOD_CD,'ZZZZZ') || NVL(A.FM_NOD_CD, 'ZZZZZZZ') || NVL(A.EQ_TPSZ_CD,'ZZ') AS GUBUN " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("				,A.EQ_NO" ).append("\n"); 
		query.append("			    ,(SELECT DECODE(COUNT(*),0,0,1)" ).append("\n"); 
		query.append("        			FROM SCE_CLM CLM, CTM_MOVEMENT CM" ).append("\n"); 
		query.append("			       WHERE A.TRSP_SO_OFC_CTY_CD = CLM.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			         AND A.TRSP_SO_SEQ = CLM.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			         AND CM.CNTR_NO = CLM.CNTR_NO" ).append("\n"); 
		query.append("			         AND CM.CNMV_YR = CLM.CNMV_YR" ).append("\n"); 
		query.append("			         AND CM.CNMV_ID_NO = CLM.CNMV_ID_NO  " ).append("\n"); 
		query.append("			         AND CM.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("					 AND CM.ORG_YD_CD = A.TO_NOD_CD" ).append("\n"); 
		query.append("			       GROUP BY CM.CNTR_NO ) MT" ).append("\n"); 
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
		query.append("			AND	A.DELT_FLG	= 'N'			-- S/O CANCEL " ).append("\n"); 
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
		query.append("		UNION ALL " ).append("\n"); 
		query.append("		SELECT	" ).append("\n"); 
		query.append("				TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd') || 'ZZZZZ'||	'ZZZZZZZ' ||A.EQ_TPSZ_CD GUBUN " ).append("\n"); 
		query.append("				,A.EQ_NO" ).append("\n"); 
		query.append("			    ,(SELECT DECODE(COUNT(*),0,0,1)" ).append("\n"); 
		query.append("        			FROM SCE_CLM CLM, CTM_MOVEMENT CM" ).append("\n"); 
		query.append("			       WHERE A.TRSP_SO_OFC_CTY_CD = CLM.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			         AND A.TRSP_SO_SEQ = CLM.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			         AND CM.CNTR_NO = CLM.CNTR_NO" ).append("\n"); 
		query.append("			         AND CM.CNMV_YR = CLM.CNMV_YR" ).append("\n"); 
		query.append("			         AND CM.CNMV_ID_NO = CLM.CNMV_ID_NO  " ).append("\n"); 
		query.append("			         AND CM.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("					 AND CM.ORG_YD_CD = A.TO_NOD_CD" ).append("\n"); 
		query.append("			       GROUP BY CM.CNTR_NO ) MT" ).append("\n"); 
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
		query.append("			AND	A.DELT_FLG	= 'N'			-- S/O CANCEL " ).append("\n"); 
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
		query.append("		UNION ALL " ).append("\n"); 
		query.append("		SELECT	" ).append("\n"); 
		query.append("			#if ( ${gubun} == 'A' ) " ).append("\n"); 
		query.append("				TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd') || NVL(C.LOC_CD,'ZZZZZ') || 'ZZZZZZZ' || NVL(A.EQ_TPSZ_CD,'ZZ') AS GUBUN " ).append("\n"); 
		query.append("			#elseif ( ${gubun} == 'B' ) " ).append("\n"); 
		query.append("				TO_CHAR(A.RAIL_DEST_N2ND_ETA_DT,'yyyyMMdd') || NVL(A.TO_NOD_CD,'ZZZZZ') || 'ZZZZZZZ' || NVL(A.EQ_TPSZ_CD,'ZZ') AS GUBUN " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("				,A.EQ_NO" ).append("\n"); 
		query.append("			    ,(SELECT DECODE(COUNT(*),0,0,1)" ).append("\n"); 
		query.append("        			FROM SCE_CLM CLM, CTM_MOVEMENT CM" ).append("\n"); 
		query.append("			       WHERE A.TRSP_SO_OFC_CTY_CD = CLM.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			         AND A.TRSP_SO_SEQ = CLM.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			         AND CM.CNTR_NO = CLM.CNTR_NO" ).append("\n"); 
		query.append("			         AND CM.CNMV_YR = CLM.CNMV_YR" ).append("\n"); 
		query.append("			         AND CM.CNMV_ID_NO = CLM.CNMV_ID_NO  " ).append("\n"); 
		query.append("			         AND CM.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("					 AND CM.ORG_YD_CD = A.TO_NOD_CD" ).append("\n"); 
		query.append("			       GROUP BY CM.CNTR_NO ) MT " ).append("\n"); 
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
		query.append("			AND	A.DELT_FLG	= 'N'			-- S/O CANCEL " ).append("\n"); 
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
		query.append("		)AA" ).append("\n"); 
		query.append("ORDER BY GUBUN, MT" ).append("\n"); 

	}
}