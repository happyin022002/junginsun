/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SPCManageDBDAOModifymultiSpcSlotSwapByVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.03.25 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOModifymultiSpcSlotSwapByVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA_VVD_SWAP_INFO Table UPDage 쿼리
	  * </pre>
	  */
	public SPCManageDBDAOModifymultiSpcSlotSwapByVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_swap_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pur_teu_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_swap_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_teu_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pur_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_swap_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slt_swap_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slt_swap_teu_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOModifymultiSpcSlotSwapByVvdUSQL").append("\n"); 
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
		query.append("UPDATE BSA_VVD_SWAP_INFO SET " ).append("\n"); 
		query.append("	SLS_TEU_CAPA 		= @[sls_teu_capa]" ).append("\n"); 
		query.append(",	SLS_WGT 			= @[sls_wgt]" ).append("\n"); 
		query.append(",	PUR_TEU_CAPA 		= @[pur_teu_capa]" ).append("\n"); 
		query.append(",	PUR_WGT 			= @[pur_wgt]" ).append("\n"); 
		query.append(",	SLT_SWAP_RLANE_CD 	= @[slt_swap_rlane_cd]" ).append("\n"); 
		query.append(",	SLT_SWAP_VVD_CD 	= @[slt_swap_vvd_cd]" ).append("\n"); 
		query.append(",	SLT_SWAP_TEU_CAPA 	= @[slt_swap_teu_capa]" ).append("\n"); 
		query.append(",	SLT_SWAP_WGT 		= @[slt_swap_wgt]" ).append("\n"); 
		query.append(",	SLT_SWAP_AMT 		= @[slt_swap_amt]" ).append("\n"); 
		query.append(",	UPD_USR_ID 			= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT 				= SYSDATE" ).append("\n"); 
		query.append("WHERE	TRD_CD 		= @[trd_cd]" ).append("\n"); 
		query.append("AND	RLANE_CD 		= @[rlane_cd]" ).append("\n"); 
		query.append("AND	VSL_CD 			= @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO 		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD 		= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	CRR_CD 			= @[crr_cd]" ).append("\n"); 
		query.append("AND	BSA_OP_JB_CD 	= @[bsa_op_jb_cd]" ).append("\n"); 

	}
}