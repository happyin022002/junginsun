/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAManageDBDAOAddMultiBsaSltChtrBzcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOAddMultiBsaSltChtrBzcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BsaSltChtrBzc Table Insert Quiry
	  * </pre>
	  */
	public BSAManageDBDAOAddMultiBsaSltChtrBzcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scht_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_bsa_bfr_sub_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bsa_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_bsa_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_fnl_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOAddMultiBsaSltChtrBzcCSQL").append("\n"); 
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
		query.append("INSERT INTO BSA_SLT_CHTR_BZC (" ).append("\n"); 
		query.append("     BSA_SEQ" ).append("\n"); 
		query.append("   , TRD_CD" ).append("\n"); 
		query.append("   , RLANE_CD" ).append("\n"); 
		query.append("   , DIR_CD" ).append("\n"); 
		query.append("   , VSL_SEQ" ).append("\n"); 
		query.append("   , VVD_CD" ).append("\n"); 
		query.append("   , BSA_FM_DT" ).append("\n"); 
		query.append("   , BSA_TO_DT" ).append("\n"); 
		query.append("   , VSL_CD" ).append("\n"); 
		query.append("   , CO_FNL_BSA_CAPA" ).append("\n"); 
		query.append("   , CO_BSA_BFR_SUB_CAPA" ).append("\n"); 
		query.append("   , VSL_BSA_CHK_FLG" ).append("\n"); 
		query.append("   , SCHT_DESC" ).append("\n"); 
		query.append("   , VSL_MLT_INP_FLG" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append(" )VALUES (" ).append("\n"); 
		query.append("     @[bsa_seq]" ).append("\n"); 
		query.append("   , @[trd_cd]" ).append("\n"); 
		query.append("   , @[rlane_cd]" ).append("\n"); 
		query.append("   , @[dir_cd]" ).append("\n"); 
		query.append("   , @[vsl_seq]" ).append("\n"); 
		query.append("   , @[vvd_cd]" ).append("\n"); 
		query.append("   , @[bsa_fm_dt]" ).append("\n"); 
		query.append("   , @[bsa_to_dt]" ).append("\n"); 
		query.append("   , @[vsl_cd]" ).append("\n"); 
		query.append("   , @[co_fnl_bsa_capa]" ).append("\n"); 
		query.append("   , @[co_bsa_bfr_sub_capa]" ).append("\n"); 
		query.append("   , @[vsl_bsa_chk_flg]" ).append("\n"); 
		query.append("   , @[scht_desc]" ).append("\n"); 
		query.append("   , 'N'" ).append("\n"); 
		query.append("   , @[cre_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[upd_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}