/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRailScgDBDAOSearchRailFixScgAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.18
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.10.18 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRailScgDBDAOSearchRailFixScgAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 조회
	  * </pre>
	  */
	public AgreementRailScgDBDAOSearchRailFixScgAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railRoadCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmtRefNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("effDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmAgmtNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementRailScgDBDAOSearchRailFixScgAgmtRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("       C.VNDR_LGL_ENG_NM AS VNDR_NM," ).append("\n"); 
		query.append("       A.TRSP_AGMT_OFC_CTY_CD||A.TRSP_AGMT_SEQ AS AGMT_NO," ).append("\n"); 
		query.append("       A.SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("       A.TRSP_RAIL_SCG_CD AS TRSP_RAIL_SCG_CD," ).append("\n"); 
		query.append("       A.COM_SCG_APLY_FLG," ).append("\n"); 
		query.append("       A.WO_APLY_FLG," ).append("\n"); 
		query.append("       A.AGMT_ROUT_ALL_FLG AS AGMT_ROUT_ALL_FLG," ).append("\n"); 
		query.append("       DECODE(A.FM_NOD_CD, '00', '', SUBSTR(A.FM_NOD_CD, 1, 5)) AS FM_NOD_CD," ).append("\n"); 
		query.append("       DECODE(A.FM_NOD_CD, '00', '', SUBSTR(A.FM_NOD_CD, 6)) AS FM_NOD_YARD," ).append("\n"); 
		query.append("       DECODE(A.TO_NOD_CD, '00', '', SUBSTR(A.TO_NOD_CD, 1, 5)) AS TO_NOD_CD," ).append("\n"); 
		query.append("       DECODE(A.TO_NOD_CD, '00', '', SUBSTR(A.TO_NOD_CD, 6)) AS TO_NOD_YARD," ).append("\n"); 
		query.append("       A.CGO_TP_CD AS CGO_TP_CD," ).append("\n"); 
		query.append("       A.LBS_OVR_WGT AS LBS_OVR_WGT," ).append("\n"); 
		query.append("       A.CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("       A.FX_SCG_ALL_RT AS FX_SCG_ALL_RT," ).append("\n"); 
		query.append("       A.FX_SCG_20FT_RT AS FX_SCG_20FT_RT," ).append("\n"); 
		query.append("       A.FX_SCG_40FT_RT AS FX_SCG_40FT_RT," ).append("\n"); 
		query.append("       A.FX_SCG_45FT_RT AS FX_SCG_45FT_RT," ).append("\n"); 
		query.append("       TO_CHAR(A.EFF_FM_DT, 'YYYYMMDD') AS EFF_FM_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.EFF_TO_DT, 'YYYYMMDD') AS EFF_TO_DT," ).append("\n"); 
		query.append("       A.USR_DEF_RMK," ).append("\n"); 
		query.append("       A.FUEL_SCG_APLY_FLG AS FUEL_SCG_APLY_FLG," ).append("\n"); 
		query.append("       TO_CHAR(A.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') AS LOCL_CRE_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.LOCL_UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS LOCL_UPD_DT," ).append("\n"); 
		query.append("       A.AGMT_EQ_SZ_NO AS AGMT_EQ_SZ_NO," ).append("\n"); 
		query.append("       A.TRSP_AGMT_SCG_SEQ AS TRSP_AGMT_SCG_SEQ," ).append("\n"); 
		query.append("       B.AGMT_REF_NO," ).append("\n"); 
		query.append("       A.AGMT_COST_FLG," ).append("\n"); 
		query.append("       DECODE(NVL(A.FX_SCG_ALL_RT, 0), 0 , 'N'||A.TRSP_AGMT_SCG_SEQ, 'Y') AS FX_SCG_ALL_RT_YN, -- for effective date validation check" ).append("\n"); 
		query.append("       DECODE(NVL(A.FX_SCG_20FT_RT, 0), 0 , 'N'||A.TRSP_AGMT_SCG_SEQ, 'Y') AS FX_SCG_20FT_RT_YN, -- for effective date validation check" ).append("\n"); 
		query.append("       DECODE(NVL(A.FX_SCG_40FT_RT, 0), 0 , 'N'||A.TRSP_AGMT_SCG_SEQ, 'Y') AS FX_SCG_40FT_RT_YN, -- for effective date validation check" ).append("\n"); 
		query.append("       DECODE(NVL(A.FX_SCG_45FT_RT, 0), 0 , 'N'||A.TRSP_AGMT_SCG_SEQ, 'Y') AS FX_SCG_45FT_RT_YN -- for effective date validation check  " ).append("\n"); 
		query.append("  FROM TRS_AGMT_RAIL_SCG_RT A," ).append("\n"); 
		query.append("       TRS_AGMT_HDR B," ).append("\n"); 
		query.append("       MDM_VENDOR C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("   AND A.TRSP_RAIL_SCG_CD IN ( 'OWS', 'HZS', 'TTL' )" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if(${fmAgmtNo} != '')" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_OFC_CTY_CD = SUBSTR(@[fmAgmtNo], 1, 3)" ).append("\n"); 
		query.append("   AND A.TRSP_AGMT_SEQ = SUBSTR(@[fmAgmtNo], 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${agmtRefNo} != '')" ).append("\n"); 
		query.append("   AND B.AGMT_REF_NO LIKE '%' || @[agmtRefNo] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${railRoadCode} != '')" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[railRoadCode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${effDt} != '')" ).append("\n"); 
		query.append("   AND 1 = CASE WHEN A.EFF_TO_DT >= TO_DATE(@[effDt], 'YYYYMMDD') THEN" ).append("\n"); 
		query.append(" 	                CASE WHEN A.EFF_FM_DT <= TO_DATE(@[effDt], 'YYYYMMDD') THEN 1" ).append("\n"); 
		query.append("    	                 ELSE 0" ).append("\n"); 
		query.append("        	         END" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}