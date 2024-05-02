/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOModifyTEMPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.18
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.10.18 김종호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOModifyTEMPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성용 파일
	  * </pre>
	  */
	public BLIssuanceDBDAOModifyTEMPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOModifyTEMPRSQL").append("\n"); 
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
		query.append("select 1 as BKG_NO," ).append("\n"); 
		query.append("2 as INFO_SEQ," ).append("\n"); 
		query.append("3 as BL_NO, " ).append("\n"); 
		query.append("4 as MRG_FILE_NM," ).append("\n"); 
		query.append("5 as DOC_ECD_PROC_FLG," ).append("\n"); 
		query.append("6 as MRG_DT," ).append("\n"); 
		query.append("7 as N1ST_PRN_DT," ).append("\n"); 
		query.append("8 as WBL_PRN_DT," ).append("\n"); 
		query.append("9 as WBL_PRN_GDT," ).append("\n"); 
		query.append("0 as PRN_USR_ID," ).append("\n"); 
		query.append("1 as PRN_CUST_TP_CD," ).append("\n"); 
		query.append("2 as INET_BL_SND_VIA_CD" ).append("\n"); 
		query.append(", 3 as SHPR_CNT_CD" ).append("\n"); 
		query.append(", 4 as SHPR_SEQ" ).append("\n"); 
		query.append(", 5 as CNEE_CNT_CD" ).append("\n"); 
		query.append(", 6 as CNEE_SEQ" ).append("\n"); 
		query.append(", 7 as NTFY_CNT_CD" ).append("\n"); 
		query.append(", 8 as NTFY_SEQ" ).append("\n"); 
		query.append(", 9 as FRT_FWRD_CNT_CD" ).append("\n"); 
		query.append(", 0 as FRT_FWRD_SEQ" ).append("\n"); 
		query.append(", 1 as VSL_CD" ).append("\n"); 
		query.append(", 2 as SKD_VOY_NO" ).append("\n"); 
		query.append(", 3 as SKD_DIR_CD" ).append("\n"); 
		query.append(", 4 as BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", 5 as LOCL_VER_CTNT" ).append("\n"); 
		query.append(", 6 as WBL_PRN_KNT" ).append("\n"); 
		query.append(", 7 as UPD_USR_ID" ).append("\n"); 
		query.append(", 8 as RESULT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" from dual" ).append("\n"); 

	}
}