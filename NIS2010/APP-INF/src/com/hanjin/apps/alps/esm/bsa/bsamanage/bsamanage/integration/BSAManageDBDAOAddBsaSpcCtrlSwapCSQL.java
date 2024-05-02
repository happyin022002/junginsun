/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOAddBsaSpcCtrlSwapCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.27
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.08.27 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOAddBsaSpcCtrlSwapCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BsaSpcCtrlSwap Table Insert Quiry
	  * </pre>
	  */
	public BSAManageDBDAOAddBsaSpcCtrlSwapCSQL(){
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
		params.put("vsl_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOAddBsaSpcCtrlSwapCSQL").append("\n"); 
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
		query.append("INSERT INTO BSA_SPC_CTRL_SWAP (" ).append("\n"); 
		query.append("        BSA_SEQ" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , VOP_CD" ).append("\n"); 
		query.append("      , VSL_CAPA" ).append("\n"); 
		query.append("      , BSA_OP_CD" ).append("\n"); 
		query.append("      , BSA_OP_JB_CD" ).append("\n"); 
		query.append("      , BSA_FM_CRR_CD" ).append("\n"); 
		query.append("      , BSA_TO_CRR_CD" ).append("\n"); 
		query.append("      , CRR_SWAP_CAPA" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append(")SELECT" ).append("\n"); 
		query.append("        @[bsa_seq]" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , VOP_CD" ).append("\n"); 
		query.append("      , VSL_CAPA" ).append("\n"); 
		query.append("      , BSA_OP_CD" ).append("\n"); 
		query.append("      , BSA_OP_JB_CD" ).append("\n"); 
		query.append("      , BSA_FM_CRR_CD" ).append("\n"); 
		query.append("      , BSA_TO_CRR_CD" ).append("\n"); 
		query.append("      , CRR_SWAP_CAPA" ).append("\n"); 
		query.append("      , @[cre_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("      , @[upd_usr_id]" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append("FROM BSA_SPC_CTRL_SWAP" ).append("\n"); 
		query.append("WHERE BSA_SEQ      = (@[bsa_seq] -1)" ).append("\n"); 
		query.append("  AND TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("  AND RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("  AND DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("  AND VOP_CD       = @[vop_cd]" ).append("\n"); 
		query.append("  AND VSL_CAPA     = @[vsl_capa]" ).append("\n"); 
		query.append("  AND BSA_OP_CD    = 'J'" ).append("\n"); 
		query.append("  AND BSA_OP_JB_CD = '007'" ).append("\n"); 

	}
}