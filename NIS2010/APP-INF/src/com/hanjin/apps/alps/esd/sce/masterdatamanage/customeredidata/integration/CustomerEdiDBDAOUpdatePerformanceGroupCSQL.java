/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerEdiDBDAOUpdatePerformanceGroupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOUpdatePerformanceGroupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePerformanceGroup
	  * </pre>
	  */
	public CustomerEdiDBDAOUpdatePerformanceGroupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_cgo_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOUpdatePerformanceGroupCSQL").append("\n"); 
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
		query.append("MERGE INTO EDI_USR_CUST C" ).append("\n"); 
		query.append("USING ( SELECT @[user_id] CRE_USR_ID" ).append("\n"); 
		query.append("            ,  @[edi_grp_id] EDI_GRP_CD" ).append("\n"); 
		query.append("            ,  @[tp_id] CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("            ,  @[edi_grp_desc] EDI_GRP_DESC" ).append("\n"); 
		query.append("            ,  @[edi_cgo_rmk] EDI_CGO_RMK" ).append("\n"); 
		query.append("            ,  @[user_id] UPD_USR_ID" ).append("\n"); 
		query.append("        FROM DUAL) S" ).append("\n"); 
		query.append("ON (C.CRE_USR_ID = S.CRE_USR_ID" ).append("\n"); 
		query.append("    AND C.EDI_GRP_CD = S.EDI_GRP_CD" ).append("\n"); 
		query.append("    AND C.EDI_STS_SEQ = 2" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET C.EDI_CGO_RMK = S.EDI_CGO_RMK" ).append("\n"); 
		query.append(" ,  C.UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" ,  C.UPD_USR_ID = S.UPD_USR_ID" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN   " ).append("\n"); 
		query.append("INSERT (C.CRE_USR_ID" ).append("\n"); 
		query.append("        ,C.EDI_GRP_CD" ).append("\n"); 
		query.append("        ,C.EDI_STS_SEQ" ).append("\n"); 
		query.append("        ,C.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("        ,C.EDI_GRP_DESC" ).append("\n"); 
		query.append("        ,C.EDI_CGO_RMK" ).append("\n"); 
		query.append("        ,C.CRE_DT" ).append("\n"); 
		query.append("        ,C.UPD_USR_ID" ).append("\n"); 
		query.append("        ,C.UPD_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" VALUES (S.CRE_USR_ID" ).append("\n"); 
		query.append("        ,S.EDI_GRP_CD" ).append("\n"); 
		query.append("        , 2" ).append("\n"); 
		query.append("        ,S.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("        ,S.EDI_GRP_DESC" ).append("\n"); 
		query.append("        ,S.EDI_CGO_RMK" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,S.UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}