/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOBlankVoyageStatusCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOBlankVoyageStatusCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Blank Voyage Status : 데이타 생성 Query
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOBlankVoyageStatusCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpn_agmt_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("atch_file_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpn_agmt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_cmpn_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpn_agmt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_flg",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration ").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOBlankVoyageStatusCSQL").append("\n"); 
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
		query.append("INSERT INTO joo_cmpn_agmt (" ).append("\n"); 
		query.append("	jo_crr_cd,      " ).append("\n"); 
		query.append("	trd_cd,         " ).append("\n"); 
		query.append("	rlane_cd,       " ).append("\n"); 
		query.append("	re_divr_cd,     " ).append("\n"); 
		query.append("	cmpn_agmt_seq,  " ).append("\n"); 
		query.append("	ofc_cd,         " ).append("\n"); 
		query.append("	agmt_ofc_cd,    " ).append("\n"); 
		query.append("	jo_cmpn_knd_cd, " ).append("\n"); 
		query.append("	cmpn_agmt_yrmon," ).append("\n"); 
		query.append("	cmpn_agmt_yrwk, " ).append("\n"); 
		query.append("	vsl_cd,         " ).append("\n"); 
		query.append("	skd_voy_no,     " ).append("\n"); 
		query.append("	skd_dir_cd,     " ).append("\n"); 
		query.append("	bsa_qty,        " ).append("\n"); 
		query.append("	bsa_slt_prc,    " ).append("\n"); 
		query.append("	agmt_ttl_amt,   " ).append("\n"); 
		query.append("	atch_file_id,   " ).append("\n"); 
		query.append("	cmpn_agmt_rmk,  " ).append("\n"); 
		query.append("	stl_flg,        " ).append("\n"); 
		query.append("	stl_vsl_cd,     " ).append("\n"); 
		query.append("	stl_voy_no,     " ).append("\n"); 
		query.append("	stl_dir_cd,     " ).append("\n"); 
		query.append("	stl_dt,         " ).append("\n"); 
		query.append("	delt_flg,       " ).append("\n"); 
		query.append("	cre_dt,         " ).append("\n"); 
		query.append("	cre_usr_id,     " ).append("\n"); 
		query.append("	upd_dt,         " ).append("\n"); 
		query.append("	upd_usr_id   " ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[jo_crr_cd]" ).append("\n"); 
		query.append(",   @[trd_cd]" ).append("\n"); 
		query.append(",	@[rlane_cd]" ).append("\n"); 
		query.append(",	@[re_divr_cd]" ).append("\n"); 
		query.append(",	(	SELECT  NVL(MAX(cmpn_agmt_seq),0) +  1" ).append("\n"); 
		query.append("		FROM    joo_cmpn_agmt" ).append("\n"); 
		query.append("		WHERE   1 = 1" ).append("\n"); 
		query.append("        		AND jo_crr_cd  = @[jo_crr_cd]      " ).append("\n"); 
		query.append("	    		AND trd_cd     = @[trd_cd]      " ).append("\n"); 
		query.append("	    		AND rlane_cd   = @[rlane_cd]      " ).append("\n"); 
		query.append("	    		AND re_divr_cd = @[re_divr_cd] )  " ).append("\n"); 
		query.append(",	@[ofc_cd]" ).append("\n"); 
		query.append(",	@[agmt_ofc_cd]" ).append("\n"); 
		query.append(",	@[jo_cmpn_knd_cd]" ).append("\n"); 
		query.append(",	@[cmpn_agmt_yrmon]" ).append("\n"); 
		query.append(",	@[cmpn_agmt_yrwk]" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[bsa_qty]" ).append("\n"); 
		query.append(",	@[bsa_slt_prc]" ).append("\n"); 
		query.append(",	@[agmt_ttl_amt]" ).append("\n"); 
		query.append(",	@[atch_file_id]" ).append("\n"); 
		query.append(",	@[cmpn_agmt_rmk]" ).append("\n"); 
		query.append(",	@[stl_flg]" ).append("\n"); 
		query.append(",	@[stl_vsl_cd]" ).append("\n"); 
		query.append(",	@[stl_voy_no]" ).append("\n"); 
		query.append(",	@[stl_dir_cd]" ).append("\n"); 
		query.append(",	@[stl_dt]" ).append("\n"); 
		query.append(",	@[delt_flg]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}