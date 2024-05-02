/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EDIVOMAKERDAOTES_EDI_RCV_RULE_VNDR_MGMTRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EDIVOMAKERDAOTES_EDI_RCV_RULE_VNDR_MGMTRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES_EDI_RCV_RULE_VNDR_MGMT
	  * </pre>
	  */
	public EDIVOMAKERDAOTES_EDI_RCV_RULE_VNDR_MGMTRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.vo").append("\n"); 
		query.append("FileName : EDIVOMAKERDAOTES_EDI_RCV_RULE_VNDR_MGMTRSQL").append("\n"); 
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
		query.append("EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append(", EDI_VNDR_SEQ" ).append("\n"); 
		query.append(", INV_OFC_CD" ).append("\n"); 
		query.append(", INV_OFC_MDM_REF_FLG" ).append("\n"); 
		query.append(", COST_OFC_CD" ).append("\n"); 
		query.append(", COST_OFC_MDM_REF_FLG" ).append("\n"); 
		query.append(", IMPL_MN_TP_CD" ).append("\n"); 
		query.append(", IMPL_TP_CD" ).append("\n"); 
		query.append(", IMPL_SUB_TP_CD" ).append("\n"); 
		query.append(", PARS_MZD_CD" ).append("\n"); 
		query.append(", EDI_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", VNDR_TRF_REF_FLG" ).append("\n"); 
		query.append(", STO_PRD_DT_CHK_FLG" ).append("\n"); 
		query.append("FROM TES_EDI_RCV_RULE_VNDR_MGMT" ).append("\n"); 

	}
}