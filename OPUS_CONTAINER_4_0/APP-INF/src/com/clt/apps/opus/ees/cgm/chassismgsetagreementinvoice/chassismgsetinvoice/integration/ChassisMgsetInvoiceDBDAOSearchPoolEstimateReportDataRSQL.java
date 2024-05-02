/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchPoolEstimateReportDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.12.29 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchPoolEstimateReportDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchPoolEstimateReportDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year_mh",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchPoolEstimateReportDataRSQL").append("\n"); 
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
		query.append("#if( ${chss_pool_tp_cd} == 'CP'  )" ).append("\n"); 
		query.append("SELECT  @[chss_pool_tp_cd] CHSS_POOL_TP_CD" ).append("\n"); 
		query.append(", A.LOC_CD CHSS_POOL_CD" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '01'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) JAN" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '02'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) FEB" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '03'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) MAR" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '04'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) APR" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '05'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) MAY" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '06'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) JUN" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '07'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) JUL" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year] || '08'" ).append("\n"); 
		query.append("AND REV_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) AUG" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '09'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) SEP" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '10'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) OCT" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '11'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) NOV" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]   || '12'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) DEC" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("AND REV_YRMON LIKE @[year]   || '%'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) TOTAL" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP   A" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD ='CP'" ).append("\n"); 
		query.append("AND A.REV_YRMON like @[year]||'%'" ).append("\n"); 
		query.append("AND A.EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("GROUP BY  A.LOC_CD" ).append("\n"); 
		query.append("#elseif( ${chss_pool_tp_cd} == 'NP'  )" ).append("\n"); 
		query.append("SELECT  @[chss_pool_tp_cd] CHSS_POOL_TP_CD" ).append("\n"); 
		query.append(", A.AGMT_NO" ).append("\n"); 
		query.append(",C.VNDR_LGL_ENG_NM CHSS_POOL_CD" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '01'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) JAN" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '02'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) FEB" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '03'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) MAR" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '04'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) APR" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '05'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) MAY" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '06'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) JUN" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '07'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) JUL" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '08'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) AUG" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '09'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) SEP" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '10'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) OCT" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '11'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) NOV" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '12'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) DEC" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON LIKE @[year] || '%'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) TOTAL" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP A, CGM_AGREEMENT B, MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND B.AGMT_OFC_CTY_CD = SUBSTR( A.AGMT_NO,1,3)" ).append("\n"); 
		query.append("AND B.AGMT_SEQ = SUBSTR(A.AGMT_NO, 4)" ).append("\n"); 
		query.append("AND B.LST_VER_FLG ='Y'" ).append("\n"); 
		query.append("AND B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD ='NP'" ).append("\n"); 
		query.append("AND A.REV_YRMON like @[year]||'%'" ).append("\n"); 
		query.append("AND A.EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("GROUP BY A.AGMT_NO,C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  AA.CHSS_POOL_TP_CD" ).append("\n"); 
		query.append(", '' AGMT_NO" ).append("\n"); 
		query.append(", AA.CHSS_POOL_CD" ).append("\n"); 
		query.append(",SUM(AA.JAN) JAN" ).append("\n"); 
		query.append(",SUM(AA.FEB) FEB" ).append("\n"); 
		query.append(",SUM(AA.MAR) MAR" ).append("\n"); 
		query.append(",SUM(AA.APR) APR" ).append("\n"); 
		query.append(",SUM(AA.MAY) MAY" ).append("\n"); 
		query.append(",SUM(AA.JUN) JUN" ).append("\n"); 
		query.append(",SUM(AA.JUL) JUL" ).append("\n"); 
		query.append(",SUM(AA.AUG) AUG" ).append("\n"); 
		query.append(",SUM(AA.SEP) SEP" ).append("\n"); 
		query.append(",SUM(AA.OCT) OCT" ).append("\n"); 
		query.append(",SUM(AA.NOV) NOV" ).append("\n"); 
		query.append(",SUM(AA.DEC) DEC" ).append("\n"); 
		query.append(",SUM(AA.TOTAL) TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  @[chss_pool_tp_cd] CHSS_POOL_TP_CD" ).append("\n"); 
		query.append(", A.AGMT_NO" ).append("\n"); 
		query.append(",C.VNDR_LGL_ENG_NM CHSS_POOL_CD" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '01'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) JAN" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD  = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '021'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) FEB" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD  = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '03'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) MAR" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD   = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '04'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) APR" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD   = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '05'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) MAY" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD  = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '06'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) JUN" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD   = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '07'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) JUL" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD  = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '08'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) AUG" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD   = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '09'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) SEP" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD   = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '10'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) OCT" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD   = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '11'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) NOV" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD   = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON = @[year]|| '12'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) DEC" ).append("\n"); 
		query.append(", NVL((SELECT SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD   = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND AGMT_NO = A.AGMT_NO" ).append("\n"); 
		query.append("AND REV_YRMON LIKE @[year] || '%'" ).append("\n"); 
		query.append("AND EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("),0) TOTAL" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP A, CGM_AGREEMENT B, MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE SYS_SRC_ID ='CHS'" ).append("\n"); 
		query.append("AND B.AGMT_OFC_CTY_CD = SUBSTR( A.AGMT_NO,1,3)" ).append("\n"); 
		query.append("AND B.AGMT_SEQ = SUBSTR(A.AGMT_NO, 4)" ).append("\n"); 
		query.append("AND B.LST_VER_FLG ='Y'" ).append("\n"); 
		query.append("AND B.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD   = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("AND A.REV_YRMON LIKE @[year]||'%'" ).append("\n"); 
		query.append("AND A.EXE_YRMON = @[year_mh]" ).append("\n"); 
		query.append("GROUP BY A.AGMT_NO,C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(") aa" ).append("\n"); 
		query.append("GROUP BY AA.CHSS_POOL_TP_CD,AA.CHSS_POOL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}