/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOSearchSpcJoPortDownDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.02 남궁진호
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

public class BSAManageDBDAOSearchSpcJoPortDownDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpcJoPortDownDetailList SELECT
	  * </pre>
	  */
	public BSAManageDBDAOSearchSpcJoPortDownDetailListRSQL(){
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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchSpcJoPortDownDetailListRSQL").append("\n"); 
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
		query.append("BSA_SEQ," ).append("\n"); 
		query.append("TRD_CD," ).append("\n"); 
		query.append("RLANE_CD," ).append("\n"); 
		query.append("DIR_CD," ).append("\n"); 
		query.append("VOP_CD," ).append("\n"); 
		query.append("VSL_CAPA," ).append("\n"); 
		query.append("BSA_OP_CD," ).append("\n"); 
		query.append("BSA_OP_JB_CD," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("PORT_SEQ," ).append("\n"); 
		query.append("PORT_CD," ).append("\n"); 
		query.append("PORT_BSA_CAPA" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BSA_JNT_OP_PORT_DWN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BSA_SEQ      = @[bsa_seq]" ).append("\n"); 
		query.append("AND    TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("AND    RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("AND    DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("AND    VOP_CD       = @[vop_cd]" ).append("\n"); 
		query.append("AND    VSL_CAPA     = @[vsl_capa]" ).append("\n"); 
		query.append("AND    BSA_OP_CD    = @[bsa_op_cd]" ).append("\n"); 
		query.append("AND    BSA_OP_JB_CD = @[bsa_op_jb_cd]" ).append("\n"); 
		query.append("AND    CRR_CD       = @[crr_cd]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("PORT_SEQ" ).append("\n"); 

	}
}