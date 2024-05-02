/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralCodeMgtDBDAOaddGeneralCodeDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeMgtDBDAOaddGeneralCodeDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력
	  * </pre>
	  */
	public GeneralCodeMgtDBDAOaddGeneralCodeDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_cd_dp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_dflt_pnt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_shp_srch_patt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_ref_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_grp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnt_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_dp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_cd_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_val_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_cd_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pair_cd_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeMgtDBDAOaddGeneralCodeDataCSQL").append("\n"); 
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
		query.append("insert into mnr_gen_cd (" ).append("\n"); 
		query.append("	mnr_cd_seq," ).append("\n"); 
		query.append("	eq_knd_cd," ).append("\n"); 
		query.append("	mnr_cd_id," ).append("\n"); 
		query.append("	prnt_cd_id," ).append("\n"); 
		query.append("	mnr_cd_dp_desc," ).append("\n"); 
		query.append("	mnr_cd_desc," ).append("\n"); 
		query.append("	mnr_cd_dp_seq," ).append("\n"); 
		query.append("	pair_cd_id," ).append("\n"); 
		query.append("	pair_cd_dp_desc," ).append("\n"); 
		query.append("	pair_cd_desc," ).append("\n"); 
		query.append("	pair_ref_cd," ).append("\n"); 
		query.append("	pair_dp_seq," ).append("\n"); 
		query.append("	mnr_cd_grp_no," ).append("\n"); 
		query.append("	mnr_cd_grp_tp_cd," ).append("\n"); 
		query.append("    agmt_use_flg," ).append("\n"); 
		query.append("	delt_flg," ).append("\n"); 
		query.append("	mnr_cd_dflt_pnt_no," ).append("\n"); 
		query.append("	mnr_ord_tp_cd," ).append("\n"); 
		query.append("	cre_usr_id," ).append("\n"); 
		query.append("	cre_dt," ).append("\n"); 
		query.append("	upd_usr_id," ).append("\n"); 
		query.append("	upd_dt," ).append("\n"); 
		query.append("    cost_shp_srch_patt_nm," ).append("\n"); 
		query.append("    acct_cd," ).append("\n"); 
		query.append("    agmt_val_flg," ).append("\n"); 
		query.append("    agmt_rt_flg" ).append("\n"); 
		query.append(") values( " ).append("\n"); 
		query.append("	MNR_CD_SEQ.NEXTVAL," ).append("\n"); 
		query.append("	@[eq_knd_cd]," ).append("\n"); 
		query.append("	@[mnr_cd_id]," ).append("\n"); 
		query.append("	@[prnt_cd_id]," ).append("\n"); 
		query.append("	@[mnr_cd_dp_desc]," ).append("\n"); 
		query.append("	@[mnr_cd_desc]," ).append("\n"); 
		query.append("	@[mnr_cd_dp_seq]," ).append("\n"); 
		query.append("	@[pair_cd_id]," ).append("\n"); 
		query.append("	@[pair_cd_dp_desc]," ).append("\n"); 
		query.append("	@[pair_cd_desc]," ).append("\n"); 
		query.append("	@[pair_ref_cd]," ).append("\n"); 
		query.append("	@[pair_dp_seq]," ).append("\n"); 
		query.append("	@[mnr_cd_grp_no]," ).append("\n"); 
		query.append("	@[mnr_cd_grp_tp_cd]," ).append("\n"); 
		query.append("    DECODE(@[agmt_use_flg],'1','Y','N')," ).append("\n"); 
		query.append("	@[delt_flg]," ).append("\n"); 
		query.append("	@[mnr_cd_dflt_pnt_no]," ).append("\n"); 
		query.append("	@[mnr_ord_tp_cd]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("    @[cost_shp_srch_patt_nm]," ).append("\n"); 
		query.append("    @[acct_cd]," ).append("\n"); 
		query.append("    DECODE(@[agmt_val_flg],'1','Y','N')," ).append("\n"); 
		query.append("    DECODE(@[agmt_rt_flg],'1','Y','N')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}