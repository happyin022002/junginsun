/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOMultiBsaSltChtrCrrCapaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOMultiBsaSltChtrCrrCapaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BsaSltChtrCrrCapa Table Insert/Update Quiry
	  * </pre>
	  */
	public BSAManageDBDAOMultiBsaSltChtrCrrCapaCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOMultiBsaSltChtrCrrCapaCSQL").append("\n"); 
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
		query.append("MERGE INTO BSA_SLT_CHTR_CRR_CAPA A" ).append("\n"); 
		query.append("USING (SELECT @[bsa_seq]       AS BSA_SEQ," ).append("\n"); 
		query.append("@[trd_cd]        AS TRD_CD," ).append("\n"); 
		query.append("@[rlane_cd]      AS RLANE_CD," ).append("\n"); 
		query.append("@[dir_cd]        AS DIR_CD," ).append("\n"); 
		query.append("@[vsl_seq]       AS VSL_SEQ," ).append("\n"); 
		query.append("@[bsa_op_cd]     AS BSA_OP_CD," ).append("\n"); 
		query.append("@[bsa_op_jb_cd]  AS BSA_OP_JB_CD," ).append("\n"); 
		query.append("@[crr_cd]        AS CRR_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON ( A.BSA_SEQ      = B.BSA_SEQ      AND" ).append("\n"); 
		query.append("A.TRD_CD       = B.TRD_CD       AND" ).append("\n"); 
		query.append("A.RLANE_CD     = B.RLANE_CD     AND" ).append("\n"); 
		query.append("A.DIR_CD       = B.DIR_CD       AND" ).append("\n"); 
		query.append("A.VSL_SEQ      = B.VSL_SEQ      AND" ).append("\n"); 
		query.append("A.BSA_OP_CD    = B.BSA_OP_CD    AND" ).append("\n"); 
		query.append("A.BSA_OP_JB_CD = B.BSA_OP_JB_CD AND" ).append("\n"); 
		query.append("A.CRR_CD       = B.CRR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET    CRR_BSA_CAPA = @[crr_bsa_capa]," ).append("\n"); 
		query.append("UPD_USR_ID   = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (BSA_SEQ," ).append("\n"); 
		query.append("TRD_CD," ).append("\n"); 
		query.append("RLANE_CD," ).append("\n"); 
		query.append("DIR_CD," ).append("\n"); 
		query.append("VSL_SEQ," ).append("\n"); 
		query.append("BSA_OP_CD," ).append("\n"); 
		query.append("BSA_OP_JB_CD," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("CRR_BSA_CAPA," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[bsa_seq]," ).append("\n"); 
		query.append("@[trd_cd]," ).append("\n"); 
		query.append("@[rlane_cd]," ).append("\n"); 
		query.append("@[dir_cd]," ).append("\n"); 
		query.append("@[vsl_seq]," ).append("\n"); 
		query.append("@[bsa_op_cd]," ).append("\n"); 
		query.append("@[bsa_op_jb_cd]," ).append("\n"); 
		query.append("@[crr_cd]," ).append("\n"); 
		query.append("@[crr_bsa_capa]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}