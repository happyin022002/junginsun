/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAuditDBDAOSearchFFCmpnDetailBasicbyBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.05
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.12.05 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnAuditDBDAOSearchFFCmpnDetailBasicbyBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFFCmpnDetailBasicbyBlList
	  * </pre>
	  */
	public FFCmpnAuditDBDAOSearchFFCmpnDetailBasicbyBlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.integration").append("\n"); 
		query.append("FileName : FFCmpnAuditDBDAOSearchFFCmpnDetailBasicbyBlListRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(B.VSL_DEP_DT, 'YYYY-MM-DD') AS VSL_DEP_DT," ).append("\n"); 
		query.append("       A.BKG_NO," ).append("\n"); 
		query.append("       NVL(A.BL_NO, '') AS BL_NO," ).append("\n"); 
		query.append("       C.CUST_CNT_CD||TRIM(TO_CHAR(C.CUST_SEQ, '000000')) AS SHPR_CNT_SEQ," ).append("\n"); 
		query.append("       NVL(LTRIM(D.CUST_LGL_ENG_NM), '') AS SHPR_NM," ).append("\n"); 
		query.append("       DECODE(B.BKG_FF_CNT_CD, '*', '', B.BKG_FF_CNT_CD||TRIM(TO_CHAR(B.BKG_FF_SEQ, '000000'))) AS FF_CNT_SEQ," ).append("\n"); 
		query.append("       B.VNDR_CNT_CD||TRIM(TO_CHAR(B.VNDR_SEQ, '000000')) AS VNDR_CNT_SEQ," ).append("\n"); 
		query.append("       NVL(LTRIM(E.CUST_LGL_ENG_NM), '') AS FF_NM," ).append("\n"); 
		query.append("       B.FF_VSL_CD||B.FF_SKD_VOY_NO||B.FF_SKD_DIR_CD AS COMM_VSL," ).append("\n"); 
		query.append("       A.POR_CD," ).append("\n"); 
		query.append("       A.POL_CD," ).append("\n"); 
		query.append("       A.POD_CD," ).append("\n"); 
		query.append("       A.DEL_CD," ).append("\n"); 
		query.append("       B.FF_REF_NO," ).append("\n"); 
		query.append("       B.FMC_NO," ).append("\n"); 
		query.append("       NVL(B.SC_NO, '')||'/'||NVL(B.RFA_NO, '') AS SC_RFA_NO," ).append("\n"); 
		query.append("       '' AS FF_KND_CD" ).append("\n"); 
		query.append("  FROM ACM_AGN_BKG_INFO A," ).append("\n"); 
		query.append("       ACM_FF_CMPN B," ).append("\n"); 
		query.append("       BKG_CUSTOMER C," ).append("\n"); 
		query.append("       MDM_CUSTOMER D," ).append("\n"); 
		query.append("       MDM_CUSTOMER E" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("   AND C.CUST_CNT_CD   = D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND C.CUST_SEQ      = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND B.BKG_FF_CNT_CD = E.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND B.BKG_FF_SEQ    = E.CUST_SEQ(+)" ).append("\n"); 
		query.append(" #if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${bkg_no} != '')" ).append("\n"); 
		query.append("   AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 

	}
}