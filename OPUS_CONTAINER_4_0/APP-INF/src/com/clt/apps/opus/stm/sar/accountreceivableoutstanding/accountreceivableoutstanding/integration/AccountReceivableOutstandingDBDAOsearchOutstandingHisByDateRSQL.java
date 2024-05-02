/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchOutstandingHisByDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOsearchOutstandingHisByDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outstanding Inquiry by B/L(Invoice) History
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchOutstandingHisByDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchOutstandingHisByDateRSQL").append("\n"); 
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
		query.append("SELECT   A.BL_NO " ).append("\n"); 
		query.append("       , A.INV_NO" ).append("\n"); 
		query.append("       , A.INV_OFC_CD" ).append("\n"); 
		query.append("       , TO_CHAR(A.IF_DT,'YYYY-MM-DD HH24:MI:SS') IF_DT" ).append("\n"); 
		query.append("       , NVL((SELECT SLD.LU_DESC" ).append("\n"); 
		query.append("        FROM SCO_LU_DTL SLD, SCO_LU_HDR SLH" ).append("\n"); 
		query.append("        WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("        AND SLH.LU_APPL_CD='SAR'" ).append("\n"); 
		query.append("        AND SLH.LU_TP_CD='OTS HIS TYPE'" ).append("\n"); 
		query.append("        AND SLD.LU_CD = A.OTS_HIS_TP_CD),A.OTS_HIS_TP_CD) AS OTS_HIS_TP_CD" ).append("\n"); 
		query.append("       , A.CURR_CD" ).append("\n"); 
		query.append("       , A.OTS_AMT" ).append("\n"); 
		query.append("       , A.GL_DT" ).append("\n"); 
		query.append("       , A.REF_NO" ).append("\n"); 
		query.append("       , CASE WHEN A.OTS_HIS_TP_CD = 'OTS' THEN " ).append("\n"); 
		query.append("     		 ( SELECT MAX(TJ_SRC_NM)" ).append("\n"); 
		query.append("                FROM SAR_OTS_CHG" ).append("\n"); 
		query.append("               WHERE OTS_HIS_SEQ = A.OTS_HIS_SEQ" ).append("\n"); 
		query.append("                AND IF_NO = A.IF_NO )" ).append("\n"); 
		query.append("         ELSE " ).append("\n"); 
		query.append("             ''" ).append("\n"); 
		query.append("         END AS TJ_SRC_NM" ).append("\n"); 
		query.append("       , A.OTS_RMK" ).append("\n"); 
		query.append("       , A.IF_NO" ).append("\n"); 
		query.append("       , A.RHQ_CD" ).append("\n"); 
		query.append("       , A.OTS_OFC_CD" ).append("\n"); 
		query.append("       , CASE WHEN A.OTS_HIS_TP_CD = 'OTS' THEN " ).append("\n"); 
		query.append("			A.REV_TP_SRC_CD" ).append("\n"); 
		query.append("         ELSE " ).append("\n"); 
		query.append("             ''" ).append("\n"); 
		query.append("         END AS REV_TP_SRC_CD" ).append("\n"); 
		query.append("       , A.CRE_USR_ID" ).append("\n"); 
		query.append("       , '' AS BKG_NO      " ).append("\n"); 
		query.append("       , '' AS COND_DT" ).append("\n"); 
		query.append("       , '' AS COND_GL_IF" ).append("\n"); 
		query.append(" FROM    SAR_OTS_HIS A" ).append("\n"); 
		query.append(" WHERE   1 = 1" ).append("\n"); 
		query.append("   AND   A.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("   AND   A.OTS_OFC_CD =@[ots_ofc_cd]" ).append("\n"); 
		query.append("   AND   A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND   A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#if(${curr_cd} != '') " ).append("\n"); 
		query.append("   AND   A.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cond_dt} != '')" ).append("\n"); 
		query.append("	#if(${cond_gl_if} == 'G')" ).append("\n"); 
		query.append("		AND A.GL_DT <= @[cond_dt]	" ).append("\n"); 
		query.append("    #end	 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${cond_gl_if} == 'I')" ).append("\n"); 
		query.append("		AND A.IF_DT < TO_DATE(@[cond_dt], 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("    #end	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.OTS_HIS_SEQ" ).append("\n"); 

	}
}