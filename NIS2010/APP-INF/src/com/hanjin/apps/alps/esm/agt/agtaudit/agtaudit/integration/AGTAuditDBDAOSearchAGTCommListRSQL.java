/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOSearchAGTCommListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOSearchAGTCommListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAGTCommList
	  * </pre>
	  */
	public AGTAuditDBDAOSearchAGTCommListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOSearchAGTCommListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("BL_NO" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO" ).append("\n"); 
		query.append("WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append(")                                                                                                AS BL_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("MAX(DECODE(COMM_VSL_CD,'CNTC','',COMM_VSL_CD||COMM_SKD_VOY_NO||COMM_SKD_DIR_CD||COMM_REV_DIR_CD)) AS VVD," ).append("\n"); 
		query.append("MAX(COMM_OCCR_INFO_CD)                                                                         AS PORT," ).append("\n"); 
		query.append("SAIL_ARR_DT," ).append("\n"); 
		query.append("AC_SEQ," ).append("\n"); 
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
		query.append("CURR_CD," ).append("\n"); 
		query.append("SUM(DECODE(SIGN(INSTR('GNKHSROCD',AC_TP_CD)),1,ACT_IF_LOCL_COMM_AMT,0))                        AS LCL_AMT," ).append("\n"); 
		query.append("COMM_PROC_STS_CD," ).append("\n"); 
		query.append("COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("AGN_CD" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM A" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND AR_OFC_CD    = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND AGN_CD       = @[agn_cd]" ).append("\n"); 
		query.append("#if(${sts_cd} == '1')" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( 'CS','CE','IC','CA'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '2')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD IN ('RS','RM')" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '3')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD = 'AS'" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '4')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD = 'IF'" ).append("\n"); 
		query.append("AND A.AC_IF_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND AC_TP_CD     <> 'T' -- OTHER COMMISSION은 조회대상에서 제외" ).append("\n"); 
		query.append("AND CRE_USR_ID   <> 'COST' -- 2007.05.07 이전 데이터는 조회대상에서 제외" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("SAIL_ARR_DT," ).append("\n"); 
		query.append("AC_SEQ," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("COMM_PROC_STS_CD," ).append("\n"); 
		query.append("COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("AGN_CD" ).append("\n"); 
		query.append("ORDER BY 1, 2, 3, 4, 5, 6" ).append("\n"); 

	}
}