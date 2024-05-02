/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOSearchAGTCommForAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.01
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.07.01 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOSearchAGTCommForAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAGTCommForAudit
	  * </pre>
	  */
	public AGTAuditDBDAOSearchAGTCommForAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOSearchAGTCommForAuditRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX (A XAK11AGT_AGN_COMM)*/" ).append("\n"); 
		query.append("B.BL_NO                                                                                        AS BL_NO," ).append("\n"); 
		query.append("A.BKG_NO                                                                                       AS BKG_NO," ).append("\n"); 
		query.append("MAX(C.BKG_STS_CD)                                                                              AS BKG_STS_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("MAX(DECODE(A.COMM_VSL_CD,'CNTC','',CONCAT(CONCAT(A.COMM_VSL_CD,A.COMM_SKD_VOY_NO),CONCAT(A.COMM_SKD_DIR_CD,A.COMM_REV_DIR_CD)))) AS VVD," ).append("\n"); 
		query.append("MAX(A.COMM_OCCR_INFO_CD)                                                                       AS PORT," ).append("\n"); 
		query.append("A.SAIL_ARR_DT," ).append("\n"); 
		query.append("A.AC_SEQ," ).append("\n"); 
		query.append("SUM(DECODE(SIGN(INSTR('GNKHSROCD',A.AC_TP_CD)),1,A.ACT_PRE_COMM_AMT,0))                   AS PRE_AMT," ).append("\n"); 
		query.append("SUM(DECODE(A.AC_TP_CD,'G',A.ACT_COMM_AMT, 0))                                                  AS COMM1," ).append("\n"); 
		query.append("SUM(DECODE(A.AC_TP_CD,'N',A.ACT_COMM_AMT, 0))                                                  AS COMM2," ).append("\n"); 
		query.append("SUM(DECODE(A.AC_TP_CD,'K',A.ACT_COMM_AMT, 0))                                                  AS BRKG," ).append("\n"); 
		query.append("SUM(DECODE(A.AC_TP_CD,'H',A.ACT_COMM_AMT, 0))                                                  AS CHF," ).append("\n"); 
		query.append("SUM(DECODE(A.AC_TP_CD,'S',A.ACT_COMM_AMT, 0))                                                  AS TS," ).append("\n"); 
		query.append("SUM(DECODE(A.AC_TP_CD,'R',A.ACT_COMM_AMT, 0))                                                  AS TR," ).append("\n"); 
		query.append("SUM(DECODE(A.AC_TP_CD,'O',A.ACT_COMM_AMT, 0))                                                  AS SOC," ).append("\n"); 
		query.append("SUM(DECODE(A.AC_TP_CD,'C',A.ACT_COMM_AMT, 0))                                                  AS CROSS," ).append("\n"); 
		query.append("SUM(DECODE(A.AC_TP_CD,'D',A.ACT_COMM_AMT, 0))                                                  AS DOC," ).append("\n"); 
		query.append("SUM(DECODE(SIGN(INSTR('GNKHSROCD',A.AC_TP_CD)),1,A.ACT_IF_COMM_AMT,0))                         AS USD_AMT," ).append("\n"); 
		query.append("MAX(DECODE(A.XCH_RT_APLY_LVL,'1',A.VVD_XCH_RT,'2',A.MON_XCH_RT,'4',A.MON_XCH_RT,A.DLY_XCH_RT)) AS EX_RATE," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("SUM(DECODE(SIGN(INSTR('GNKHSROCD',A.AC_TP_CD)),1,A.ACT_IF_LOCL_COMM_AMT,0))                    AS LCL_AMT," ).append("\n"); 
		query.append("A.COMM_PROC_STS_CD," ).append("\n"); 
		query.append("A.COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("A.AR_OFC_CD," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("MAX(B.SVC_SCP_CD)                                                                              AS SCP" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM       A," ).append("\n"); 
		query.append("AGT_COMM_BKG_INFO  B," ).append("\n"); 
		query.append("BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD        = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.AGN_CD           = @[agn_cd]" ).append("\n"); 
		query.append("AND A.AC_TP_CD        <> 'T'         -- OTHER COMMISSION은 조회대상에서 제외" ).append("\n"); 
		query.append("AND A.CRE_USR_ID      <> 'COST'" ).append("\n"); 
		query.append("AND A.BKG_NO           = A.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO           = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.IO_BND_CD        = A.IO_BND_CD" ).append("\n"); 
		query.append("AND A.AC_SEQ           = A.AC_SEQ" ).append("\n"); 
		query.append("AND A.BKG_NO           = B.BKG_NO" ).append("\n"); 
		query.append("AND A.AGN_CD           = A.AGN_CD" ).append("\n"); 
		query.append("#if(${vvd} != '')" ).append("\n"); 
		query.append("AND A.COMM_VSL_CD||A.COMM_SKD_VOY_NO||A.COMM_SKD_DIR_CD||A.COMM_REV_DIR_CD LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_nos} != '')" ).append("\n"); 
		query.append("AND B.BL_NO" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( ${bl_nos}" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sts_cd} == '1')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( 'RS','RM'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.AC_RQST_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[search_dt_to], '-'),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '2')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD = 'AS'" ).append("\n"); 
		query.append("AND A.AC_APRO_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[search_dt_to], '-'),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '3')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD = 'IF'" ).append("\n"); 
		query.append("AND A.AC_IF_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[search_dt_to], '-'),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '4')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( 'RS','RM'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[search_dt_to], '-'),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '5')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( 'RS','RM'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[search_dt_to], '-'),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.AC_RQST_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[search_dt_fr], '-'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[search_dt_to], '-'),'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("B.BL_NO," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.SAIL_ARR_DT," ).append("\n"); 
		query.append("A.AC_SEQ," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("A.COMM_PROC_STS_CD," ).append("\n"); 
		query.append("A.COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("A.AR_OFC_CD," ).append("\n"); 
		query.append("A.AGN_CD" ).append("\n"); 
		query.append("ORDER BY 1,2,3,4,5,6" ).append("\n"); 

	}
}