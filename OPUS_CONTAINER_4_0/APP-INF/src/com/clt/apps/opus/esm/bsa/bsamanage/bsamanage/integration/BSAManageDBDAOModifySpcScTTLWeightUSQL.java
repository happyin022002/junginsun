/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOModifySpcScTTLWeightUSQL.java
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

public class BSAManageDBDAOModifySpcScTTLWeightUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifySpcScTTLWeight
	  * </pre>
	  */
	public BSAManageDBDAOModifySpcScTTLWeightUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOModifySpcScTTLWeightUSQL").append("\n"); 
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
		query.append("UPDATE BSA_SLT_CHTR_CRR_CAPA X" ).append("\n"); 
		query.append("SET UPD_USR_ID   = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT       = SYSDATE," ).append("\n"); 
		query.append("CRR_BSA_CAPA = (" ).append("\n"); 
		query.append("SELECT NVL(SUM(DECODE(B.BSA_OP_JB_CD, '007', B.CRR_BSA_CAPA)), 0)" ).append("\n"); 
		query.append("* NVL(SUM(DECODE(B.BSA_OP_JB_CD, '008', B.CRR_BSA_CAPA)), 0)  CRR_BSA_CAPA" ).append("\n"); 
		query.append("FROM BSA_SLT_CHTR_CRR_CAPA B" ).append("\n"); 
		query.append("WHERE B.BSA_SEQ   = X.BSA_SEQ" ).append("\n"); 
		query.append("AND B.TRD_CD    = X.TRD_CD" ).append("\n"); 
		query.append("AND B.RLANE_CD  = X.RLANE_CD" ).append("\n"); 
		query.append("AND B.DIR_CD    = X.DIR_CD" ).append("\n"); 
		query.append("AND B.BSA_OP_CD = X.BSA_OP_CD" ).append("\n"); 
		query.append("AND B.CRR_CD    = X.CRR_CD" ).append("\n"); 
		query.append("AND B.VSL_SEQ   = X.VSL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE X.BSA_OP_JB_CD = '009'" ).append("\n"); 
		query.append("AND X.BSA_SEQ      = @[bsa_seq]" ).append("\n"); 
		query.append("AND X.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("AND X.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("AND X.DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("AND X.VSL_SEQ      = @[vsl_seq]" ).append("\n"); 
		query.append("AND X.BSA_OP_CD    = @[bsa_op_cd]" ).append("\n"); 

	}
}