/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOAddExcelBsaCarrieListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.16
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.09.16 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI, Duk-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOAddExcelBsaCarrieListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Excel Upload를 이용하여 Add Carrier BSA 정보를 생성한다.
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOAddExcelBsaCarrieListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_add_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOAddExcelBsaCarrieListCSQL").append("\n"); 
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
		query.append("MERGE INTO  JOO_ADD_BSA_CRR X" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("            (SELECT @[vsl_cd]     AS VSL_CD" ).append("\n"); 
		query.append("                  , @[skd_voy_no] AS SKD_VOY_NO" ).append("\n"); 
		query.append("                  , @[skd_dir_cd] AS SKD_DIR_CD" ).append("\n"); 
		query.append("                  , @[port_cd]    AS PORT_CD" ).append("\n"); 
		query.append("                  , @[port_seq]   AS PORT_SEQ" ).append("\n"); 
		query.append("                  , @[jo_crr_cd]  AS JO_CRR_CD" ).append("\n"); 
		query.append("                  , @[jo_add_crr_cd]  AS JO_ADD_CRR_CD" ).append("\n"); 
		query.append("               FROM DUAL" ).append("\n"); 
		query.append("            ) Y" ).append("\n"); 
		query.append("ON          ( X.VSL_CD     = Y.VSL_CD" ).append("\n"); 
		query.append("              AND X.SKD_VOY_NO = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND X.SKD_DIR_CD = Y.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND X.PORT_CD    = Y.PORT_CD" ).append("\n"); 
		query.append("              AND X.PORT_SEQ   = Y.PORT_SEQ" ).append("\n"); 
		query.append("              AND X.JO_CRR_CD  = Y.JO_CRR_CD" ).append("\n"); 
		query.append("              AND X.JO_ADD_CRR_CD  = Y.JO_ADD_CRR_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("UPDATE       " ).append("\n"); 
		query.append("SET        	JO_BSA_TEU_QTY	= @[jo_bsa_teu_qty]" ).append("\n"); 
		query.append("       	,  	UPD_USR_ID		= @[upd_usr_id]" ).append("\n"); 
		query.append("		,	UPD_DT			= SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT     ( " ).append("\n"); 
		query.append("  VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", PORT_CD" ).append("\n"); 
		query.append(", PORT_SEQ" ).append("\n"); 
		query.append(", JO_CRR_CD" ).append("\n"); 
		query.append(", JO_BSA_TEU_QTY" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", JO_ADD_CRR_CD" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("VALUES     (" ).append("\n"); 
		query.append("@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[port_cd]" ).append("\n"); 
		query.append(",@[port_seq]" ).append("\n"); 
		query.append(",@[jo_crr_cd]" ).append("\n"); 
		query.append(",@[jo_bsa_teu_qty]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",@[jo_add_crr_cd]" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}