/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VendorCmDBDAOSearchJoEdiHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VendorCmDBDAOSearchJoEdiHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VendorCmDBDAOSearchJoEdiHistory
	  * </pre>
	  */
	public VendorCmDBDAOSearchJoEdiHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.vendorcm.integration").append("\n"); 
		query.append("FileName : VendorCmDBDAOSearchJoEdiHistoryRSQL").append("\n"); 
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
		query.append("SELECT T.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,T.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,T.TRSP_SO_OFC_CTY_CD || T.TRSP_SO_SEQ SO_NO" ).append("\n"); 
		query.append("      ,NVL(SO.EQ_NO, SO.COP_NO) AS EQ_COP_NO" ).append("\n"); 
		query.append("      ,T.EDI_MSG_SEQ" ).append("\n"); 
		query.append("      ,T.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,T.TRSP_WO_SEQ" ).append("\n"); 
		query.append("      ,T.TRSP_WO_OFC_CTY_CD || T.TRSP_WO_SEQ WO_NO" ).append("\n"); 
		query.append("      ,T.VNDR_SEQ" ).append("\n"); 
		query.append("      ,V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,T.MSG_BND_CD" ).append("\n"); 
		query.append("	  ,DECODE(T.MSG_BND_CD, 'I', 'Incoming', 'O', 'Outgoing') AS MSG_BND_NM" ).append("\n"); 
		query.append("      ,T.MSG_TP_CD" ).append("\n"); 
		query.append("	  ,C.INTG_CD_VAL_DP_DESC AS MSG_TP_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(T.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,T.CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(T.CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append("      ,T.UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(T.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("	  ,CASE WHEN MSG_TP_CD = 'P' AND MSG_BND_CD = 'I' THEN  '1' ELSE '0' END POP_IMG" ).append("\n"); 
		query.append("  FROM TRS_EDI_WRK_ORD_HIS T" ).append("\n"); 
		query.append("      ,MDM_VENDOR          V" ).append("\n"); 
		query.append("	  ,TRS_TRSP_SVC_ORD    SO" ).append("\n"); 
		query.append("	  ,COM_INTG_CD_DTL     C" ).append("\n"); 
		query.append(" WHERE (T.TRSP_SO_OFC_CTY_CD, T.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${soArrays})  " ).append("\n"); 
		query.append("				#if($velocityCount == 1)  " ).append("\n"); 
		query.append("					(SUBSTR('$code', 1, 3), SUBSTR('$code', 4))" ).append("\n"); 
		query.append("				#else  " ).append("\n"); 
		query.append("					 ,(SUBSTR('$code', 1, 3), SUBSTR('$code', 4))" ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("   AND T.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND T.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND T.VNDR_SEQ = V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND T.MSG_TP_CD = C.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND C.INTG_CD_ID(+) = 'CD30028'" ).append("\n"); 
		query.append(" ORDER BY NVL(SO.EQ_NO, SO.COP_NO)" ).append("\n"); 
		query.append("         ,T.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("         ,T.TRSP_SO_SEQ" ).append("\n"); 
		query.append("         ,T.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("         ,T.TRSP_WO_SEQ" ).append("\n"); 
		query.append("         ,T.VNDR_SEQ" ).append("\n"); 
		query.append("         ,T.CRE_DT" ).append("\n"); 

	}
}