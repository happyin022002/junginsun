/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOMultiVesselInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.02.23 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOMultiVesselInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vessel정보 입력
	  * </pre>
	  */
	public LaneSimulationDBDAOMultiVesselInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_crr_bsa_capa4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_crr_bsa_capa5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ldf_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sect_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_crr_bsa_capa2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_crr_bsa_capa3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_crr_bsa_capa1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_hjs_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sim_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_bfr_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_chtr_capa1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_chtr_capa2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_chtr_capa3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_lse_capa2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_chtr_capa4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_lse_capa1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_chtr_capa5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_lse_capa5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_lse_capa4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_lse_capa3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOMultiVesselInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_SIM_VSL_SET_INFO (" ).append("\n"); 
		query.append("SECT_NO" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SIM_DIV_CD" ).append("\n"); 
		query.append(",	VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",	VOP_CD" ).append("\n"); 
		query.append(",	VSL_CAPA" ).append("\n"); 
		query.append(",	BSA_CAPA" ).append("\n"); 
		query.append(",	FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append(",	LDF_RTO" ).append("\n"); 
		query.append(",	OTR_CRR_BSA_CAPA1" ).append("\n"); 
		query.append(",	OTR_CRR_BSA_CAPA2" ).append("\n"); 
		query.append(",	OTR_CRR_BSA_CAPA3" ).append("\n"); 
		query.append(",	OTR_CRR_BSA_CAPA4" ).append("\n"); 
		query.append(",	OTR_CRR_BSA_CAPA5" ).append("\n"); 
		query.append(",	HJS_BFR_BSA_CAPA" ).append("\n"); 
		query.append(",	SUB_LSE_CAPA1" ).append("\n"); 
		query.append(",	SUB_LSE_CAPA2" ).append("\n"); 
		query.append(",	SUB_LSE_CAPA3" ).append("\n"); 
		query.append(",	SUB_LSE_CAPA4" ).append("\n"); 
		query.append(",	SUB_LSE_CAPA5" ).append("\n"); 
		query.append(",	SUB_CHTR_CAPA1" ).append("\n"); 
		query.append(",	SUB_CHTR_CAPA2" ).append("\n"); 
		query.append(",	SUB_CHTR_CAPA3" ).append("\n"); 
		query.append(",	SUB_CHTR_CAPA4" ).append("\n"); 
		query.append(",	SUB_CHTR_CAPA5" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	SIM_DT" ).append("\n"); 
		query.append(",	SIM_NO" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[sect_no]" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[sim_div_cd]" ).append("\n"); 
		query.append(",	@[vsl_clss_capa]" ).append("\n"); 
		query.append(",	@[vop_cd]" ).append("\n"); 
		query.append(",	@[vsl_capa]" ).append("\n"); 
		query.append(",	@[bsa_capa]" ).append("\n"); 
		query.append(",	@[fnl_hjs_bsa_capa]" ).append("\n"); 
		query.append(",	@[ldf_rto]" ).append("\n"); 
		query.append(",	@[otr_crr_bsa_capa1]" ).append("\n"); 
		query.append(",	@[otr_crr_bsa_capa2]" ).append("\n"); 
		query.append(",	@[otr_crr_bsa_capa3]" ).append("\n"); 
		query.append(",	@[otr_crr_bsa_capa4]" ).append("\n"); 
		query.append(",	@[otr_crr_bsa_capa5]" ).append("\n"); 
		query.append(",	@[hjs_bfr_bsa_capa]" ).append("\n"); 
		query.append(",	@[sub_lse_capa1]" ).append("\n"); 
		query.append(",	@[sub_lse_capa2]" ).append("\n"); 
		query.append(",	@[sub_lse_capa3]" ).append("\n"); 
		query.append(",	@[sub_lse_capa4]" ).append("\n"); 
		query.append(",	@[sub_lse_capa5]" ).append("\n"); 
		query.append(",	@[sub_chtr_capa1]" ).append("\n"); 
		query.append(",	@[sub_chtr_capa2]" ).append("\n"); 
		query.append(",	@[sub_chtr_capa3]" ).append("\n"); 
		query.append(",	@[sub_chtr_capa4]" ).append("\n"); 
		query.append(",	@[sub_chtr_capa5]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[sim_dt]" ).append("\n"); 
		query.append(",	@[sim_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}