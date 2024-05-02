/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchOffhireCnfmListNonConfirmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchOffhireCnfmListNonConfirmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Off Hire Non Confirm 목록
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchOffhireCnfmListNonConfirmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchOffhireCnfmListNonConfirmRSQL").append("\n"); 
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
		query.append("SELECT  O.VSL_CD" ).append("\n"); 
		query.append("       ,O.SKD_VOY_NO" ).append("\n"); 
		query.append("	   ,O.SKD_DIR_CD" ).append("\n"); 
		query.append("	   ,O.VNOR_VSL_STS_CD" ).append("\n"); 
		query.append("       ,O.VNOR_FM_PORT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(O.VNOR_OFFH_FM_DT,'YYYYMMDD') AS VNOR_OFFH_FM_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(O.VNOR_OFFH_FM_DT,'HH24MI') AS VNOR_OFFH_FM_DT_HM" ).append("\n"); 
		query.append("       ,TO_CHAR(O.VNOR_OFFH_TO_DT,'YYYYMMDD') AS VNOR_OFFH_TO_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(O.VNOR_OFFH_TO_DT,'HH24MI') AS VNOR_OFFH_TO_DT_HM" ).append("\n"); 
		query.append("       ,F.VNOR_ITM_CD" ).append("\n"); 
		query.append("       ,F.VNOR_ITM_OFC_CD" ).append("\n"); 
		query.append("       ,F.VNOR_ITM_UT_CD" ).append("\n"); 
		query.append("       ,F.VNOR_ITM_VAL" ).append("\n"); 
		query.append("       ,F.VNOR_ITM_FLET_ADD_CD" ).append("\n"); 
		query.append("       ,F.VNOR_ITM_RMK" ).append("\n"); 
		query.append("       ,F.ATCH_FILE_OP_KNT" ).append("\n"); 
		query.append("       ,(SELECT COUNT(1) FROM FMS_ATCH_FILE WHERE ATCH_FILE_LNK_ID = F.ATCH_FILE_FLET_LNK_ID ) AS ATCH_FILE_FLET_KNT" ).append("\n"); 
		query.append("       ,TO_CHAR(F.UPD_DT, 'yyyy-mm-dd hh24:mi:ss') AS UPD_DT              " ).append("\n"); 
		query.append("       ,(SELECT U.USR_NM FROM COM_USER U WHERE U.USR_ID = F.CRE_USR_ID) AS UPD_USR_ID" ).append("\n"); 
		query.append("	   ,F.VNOR_SEQ" ).append("\n"); 
		query.append("       ,F.VNOR_ITM_SEQ" ).append("\n"); 
		query.append("	   ,F.ATCH_FILE_OP_LNK_ID " ).append("\n"); 
		query.append("       ,F.ATCH_FILE_FLET_LNK_ID " ).append("\n"); 
		query.append("	   ,O.VNOR_OFFH_KND_CD" ).append("\n"); 
		query.append("FROM FMS_VNOR O, FMS_VNOR_ITM F" ).append("\n"); 
		query.append("WHERE O.VSL_CD = F.VSL_CD" ).append("\n"); 
		query.append("  AND O.VNOR_SEQ = F.VNOR_SEQ  " ).append("\n"); 
		query.append("  AND F.VNOR_ITM_PROC_CD = 'N'" ).append("\n"); 
		query.append("ORDER BY  O.VNOR_OFFH_FM_DT, O.VSL_CD, O.SKD_VOY_NO" ).append("\n"); 

	}
}