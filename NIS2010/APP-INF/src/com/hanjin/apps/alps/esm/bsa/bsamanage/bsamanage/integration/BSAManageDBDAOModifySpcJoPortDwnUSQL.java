/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOModifySpcJoPortDwnUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOModifySpcJoPortDwnUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifySpcJoPortDwn UPDATE
	  * </pre>
	  */
	public BSAManageDBDAOModifySpcJoPortDwnUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOModifySpcJoPortDwnUSQL").append("\n"); 
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
		query.append("UPDATE BSA_JNT_OP_PORT_DWN X" ).append("\n"); 
		query.append("SET UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT        = SYSDATE" ).append("\n"); 
		query.append(",PORT_BSA_CAPA = (" ).append("\n"); 
		query.append("SELECT NVL(A.SPC_CTRL_SLT_CAPA,0) SPC_CTRL_SLT_CAPA" ).append("\n"); 
		query.append("FROM BSA_JNT_OP_CRR_CAPA A" ).append("\n"); 
		query.append("WHERE A.BSA_SEQ      = X.BSA_SEQ" ).append("\n"); 
		query.append("AND A.TRD_CD       = X.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD     = X.RLANE_CD" ).append("\n"); 
		query.append("AND A.DIR_CD       = X.DIR_CD" ).append("\n"); 
		query.append("AND A.VOP_CD       = X.VOP_CD" ).append("\n"); 
		query.append("AND A.VSL_CAPA     = X.VSL_CAPA" ).append("\n"); 
		query.append("AND A.BSA_OP_CD    = X.BSA_OP_CD" ).append("\n"); 
		query.append("AND A.BSA_OP_JB_CD = X.BSA_OP_JB_CD" ).append("\n"); 
		query.append("AND A.CRR_CD       = X.CRR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE X.BSA_SEQ      = @[bsa_seq]" ).append("\n"); 
		query.append("AND X.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("AND X.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("AND X.DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("AND X.VOP_CD       = @[vop_cd]" ).append("\n"); 
		query.append("AND X.VSL_CAPA     = @[vsl_capa]" ).append("\n"); 
		query.append("AND X.BSA_OP_CD    = @[bsa_op_cd]" ).append("\n"); 
		query.append("AND X.BSA_OP_JB_CD = @[bsa_op_jb_cd]" ).append("\n"); 

	}
}