/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementTrsComScgMgmtDBDAOMergeTrsComScgTmpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.04.15 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementTrsComScgMgmtDBDAOMergeTrsComScgTmpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MergeTrsComScgTmp
	  * </pre>
	  */
	public AgreementTrsComScgMgmtDBDAOMergeTrsComScgTmpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_scg_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("one_wy_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_scg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rnd_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementTrsComScgMgmtDBDAOMergeTrsComScgTmpCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_COM_SCG_MGMT_TMP" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           TRSP_TMP_SEQ," ).append("\n"); 
		query.append("           ROW_NO," ).append("\n"); 
		query.append("           COM_SCG_KND_CD," ).append("\n"); 
		query.append("           COM_SCG_SEQ," ).append("\n"); 
		query.append("           TRSP_COST_MOD_CD," ).append("\n"); 
		query.append("           AGMT_TRSP_TP_CD," ).append("\n"); 
		query.append("           RCC_CD," ).append("\n"); 
		query.append("           LCC_CD," ).append("\n"); 
		query.append("           SCC_CD," ).append("\n"); 
		query.append("           EQ_KND_CD," ).append("\n"); 
		query.append("           EQ_TPSZ_CD," ).append("\n"); 
		query.append("           CGO_TP_CD," ).append("\n"); 
		query.append("           BND_CD," ).append("\n"); 
		query.append("           RT_TP_CD," ).append("\n"); 
		query.append("           CURR_CD," ).append("\n"); 
		query.append("           ONE_WY_RT," ).append("\n"); 
		query.append("           RND_RT," ).append("\n"); 
		query.append("           EFF_FM_DT," ).append("\n"); 
		query.append("           EFF_TO_DT," ).append("\n"); 
		query.append("           WO_APLY_FLG," ).append("\n"); 
		query.append("           CRE_USR_ID," ).append("\n"); 
		query.append("           CRE_DT," ).append("\n"); 
		query.append("           UPD_USR_ID," ).append("\n"); 
		query.append("           UPD_DT" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  VALUES" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           @[trsp_tmp_seq]," ).append("\n"); 
		query.append("           @[seq]," ).append("\n"); 
		query.append("           @[com_scg_knd_cd]," ).append("\n"); 
		query.append("           NVL(@[com_scg_seq], 0)," ).append("\n"); 
		query.append("           @[trsp_cost_mod_cd]," ).append("\n"); 
		query.append("           @[agmt_trsp_tp_cd]," ).append("\n"); 
		query.append("           @[rcc_cd]," ).append("\n"); 
		query.append("           @[lcc_cd]," ).append("\n"); 
		query.append("           @[scc_cd]," ).append("\n"); 
		query.append("           @[eq_knd_cd]," ).append("\n"); 
		query.append("           @[eq_tp_cd] || @[eq_sz_cd]," ).append("\n"); 
		query.append("           @[cgo_tp_cd]," ).append("\n"); 
		query.append("           @[bnd_cd]," ).append("\n"); 
		query.append("           @[rt_tp_cd]," ).append("\n"); 
		query.append("           @[curr_cd]," ).append("\n"); 
		query.append("           @[one_wy_rt]," ).append("\n"); 
		query.append("           @[rnd_rt]," ).append("\n"); 
		query.append("           TO_DATE(@[eff_fm_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("           TO_DATE(@[eff_to_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("           @[wo_aply_flg]," ).append("\n"); 
		query.append("           @[cre_usr_id]," ).append("\n"); 
		query.append("           SYSDATE," ).append("\n"); 
		query.append("           @[upd_usr_id]," ).append("\n"); 
		query.append("           SYSDATE" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}