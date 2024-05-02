/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OPMasterDBDAOMultiHistVSLInfoMasCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOMultiHistVSLInfoMasCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiHistVSLInfoMas
	  * </pre>
	  */
	public OPMasterDBDAOMultiHistVSLInfoMasCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_oshp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_prc_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_retn_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_retn_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_aply_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_aply_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dznd_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_ldb_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_rgst_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_vsl_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOMultiHistVSLInfoMasCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_VSL_RGST (" ).append("\n"); 
		query.append("     VSL_CD" ).append("\n"); 
		query.append("    ,VSL_SEQ" ).append("\n"); 
		query.append("    ,VVD_CD" ).append("\n"); 
		query.append("    ,VSL_APLY_FM_DT" ).append("\n"); 
		query.append("    ,VSL_APLY_TO_DT" ).append("\n"); 
		query.append("    ,VSL_TP_CD" ).append("\n"); 
		query.append("    ,VSL_OSHP_CD" ).append("\n"); 
		query.append("    ,VOP_CD" ).append("\n"); 
		query.append("    ,VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("    ,PORT_CLSS_CAPA" ).append("\n"); 
		query.append("    ,STND_LDB_CAPA" ).append("\n"); 
		query.append("    ,VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,VSL_DZND_CAPA" ).append("\n"); 
		query.append("    ,BSA_VSL_FLG" ).append("\n"); 
		query.append("    ,CRR_CD" ).append("\n"); 
		query.append("    ,LST_FLG" ).append("\n"); 
		query.append("    ,DELT_FLG" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("	,TRD_CHK_FLG" ).append("\n"); 
		query.append("	,VSL_PRC" ).append("\n"); 
		query.append("	,VSL_PRC_RTO" ).append("\n"); 
		query.append("	,VSL_RETN_FM_DT" ).append("\n"); 
		query.append("	,VSL_RETN_TO_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("     @[vsl_cd]" ).append("\n"); 
		query.append("    ,@[vsl_seq]" ).append("\n"); 
		query.append("    ,@[vvd_cd]" ).append("\n"); 
		query.append("    ,TO_DATE(@[vsl_aply_fm_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("    ,TO_DATE(@[vsl_aply_to_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("    ,@[vsl_tp_cd]" ).append("\n"); 
		query.append("    ,@[vsl_oshp_cd]" ).append("\n"); 
		query.append("    ,@[vop_cd]" ).append("\n"); 
		query.append("    ,@[vsl_rgst_cnt_cd]" ).append("\n"); 
		query.append("    ,@[port_clss_capa]" ).append("\n"); 
		query.append("    ,@[stnd_ldb_capa]" ).append("\n"); 
		query.append("    ,@[vsl_clss_capa]" ).append("\n"); 
		query.append("    ,@[vsl_dznd_capa]" ).append("\n"); 
		query.append("    ,@[bsa_vsl_flg]" ).append("\n"); 
		query.append("    ,@[crr_cd]" ).append("\n"); 
		query.append("    ,'Y'" ).append("\n"); 
		query.append("    ,'N'" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,sysdate" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,sysdate" ).append("\n"); 
		query.append("	,@[trd_chk_flg]" ).append("\n"); 
		query.append("	,@[vsl_prc]" ).append("\n"); 
		query.append("	,@[vsl_prc_rto]" ).append("\n"); 
		query.append("	,TO_DATE(@[vsl_retn_fm_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	,TO_DATE(@[vsl_retn_to_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}