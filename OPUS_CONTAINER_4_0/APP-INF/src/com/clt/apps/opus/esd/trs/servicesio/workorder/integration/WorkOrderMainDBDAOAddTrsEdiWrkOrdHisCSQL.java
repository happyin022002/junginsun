/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderMainDBDAOAddTrsEdiWrkOrdHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderMainDBDAOAddTrsEdiWrkOrdHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderMainDBDAOAddTrsEdiWrkOrdHis
	  * </pre>
	  */
	public WorkOrderMainDBDAOAddTrsEdiWrkOrdHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOAddTrsEdiWrkOrdHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_EDI_WRK_ORD_HIS (" ).append("\n"); 
		query.append("   TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("  ,EDI_MSG_SEQ" ).append("\n"); 
		query.append("  ,TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_WO_SEQ" ).append("\n"); 
		query.append("  ,VNDR_SEQ" ).append("\n"); 
		query.append("  ,MSG_BND_CD" ).append("\n"); 
		query.append("  ,MSG_TP_CD" ).append("\n"); 
		query.append("  ,CRE_OFC_CD" ).append("\n"); 
		query.append("  ,LOCL_CRE_DT" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT T.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,T.TRSP_SO_SEQ" ).append("\n"); 
		query.append("        ,T.EDI_MSG_SEQ" ).append("\n"); 
		query.append("        ,T.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,T.TRSP_WO_SEQ" ).append("\n"); 
		query.append("        ,SO.VNDR_SEQ" ).append("\n"); 
		query.append("        ,T.MSG_BND_CD" ).append("\n"); 
		query.append("        ,T.MSG_TP_CD" ).append("\n"); 
		query.append("        ,SO.CRE_OFC_CD" ).append("\n"); 
		query.append("        ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(SO.CRE_OFC_CD) LOCL_CRE_DT" ).append("\n"); 
		query.append("        ,T.CRE_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("		,T.UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("    FROM (SELECT @[trsp_so_ofc_cty_cd] TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,@[trsp_so_seq] TRSP_SO_SEQ" ).append("\n"); 
		query.append("                ,@[rcv_msg_seq] AS EDI_MSG_SEQ" ).append("\n"); 
		query.append("                ,@[trsp_wo_ofc_cty_cd] TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                ,@[trsp_wo_seq] TRSP_WO_SEQ" ).append("\n"); 
		query.append("                ,'I' MSG_BND_CD" ).append("\n"); 
		query.append("                ,@[rcv_msg_tp_cd] MSG_TP_CD" ).append("\n"); 
		query.append("                ,'EDIUSER' CRE_USR_ID" ).append("\n"); 
		query.append("                ,'EDIUSER' UPD_USR_ID" ).append("\n"); 
		query.append("            FROM DUAL) T" ).append("\n"); 
		query.append("        ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("   WHERE T.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("     AND T.TRSP_SO_SEQ = SO.TRSP_SO_SEQ(+)" ).append("\n"); 

	}
}