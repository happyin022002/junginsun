/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VIPDeductAgreementDBDAOAddVIPAgreementCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VIPDeductAgreementDBDAOAddVIPAgreementCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규 VIP Agreement 추가
	  * 2016.08.05 김상현 [CHM-201642499] ALPS > ACM VIP Agreement Creation 상 SC/RFA No. 추가 요청
	  * </pre>
	  */
	public VIPDeductAgreementDBDAOAddVIPAgreementCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vip_bkg_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.integration").append("\n"); 
		query.append("FileName : VIPDeductAgreementDBDAOAddVIPAgreementCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_VIP_AGMT(" ).append("\n"); 
		query.append("  CUST_GRP_ID," ).append("\n"); 
		query.append("  AGMT_SEQ," ).append("\n"); 
		query.append("  TRD_CD," ).append("\n"); 
		query.append("  DIR_CD," ).append("\n"); 
		query.append("  HUL_BND_CD," ).append("\n"); 
		query.append("  SUB_TRD_CD," ).append("\n"); 
		query.append("  POR_GRP_TP_CD," ).append("\n"); 
		query.append("  POR_ROUT_CD," ).append("\n"); 
		query.append("  POL_GRP_TP_CD," ).append("\n"); 
		query.append("  POL_ROUT_CD," ).append("\n"); 
		query.append("  POD_GRP_TP_CD," ).append("\n"); 
		query.append("  POD_ROUT_CD," ).append("\n"); 
		query.append("  DEL_GRP_TP_CD," ).append("\n"); 
		query.append("  DEL_ROUT_CD," ).append("\n"); 
		query.append("  CNTR_TPSZ_GRP_NM," ).append("\n"); 
		query.append("  VIP_BKG_RT," ).append("\n"); 
		query.append("  DELT_FLG," ).append("\n"); 
		query.append("  SC_NO," ).append("\n"); 
		query.append("  RFA_NO," ).append("\n"); 
		query.append("  TAA_NO," ).append("\n"); 
		query.append("  FM_EFF_DT," ).append("\n"); 
		query.append("  TO_EFF_DT," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("  @[cust_grp_id]," ).append("\n"); 
		query.append("  @[agmt_seq]," ).append("\n"); 
		query.append("  @[trd_cd]," ).append("\n"); 
		query.append("  @[dir_cd]," ).append("\n"); 
		query.append("  @[hul_bnd_cd]," ).append("\n"); 
		query.append("  @[sub_trd_cd]," ).append("\n"); 
		query.append("  @[por_grp_tp_cd]," ).append("\n"); 
		query.append("  @[por_rout_cd]," ).append("\n"); 
		query.append("  @[pol_grp_tp_cd]," ).append("\n"); 
		query.append("  @[pol_rout_cd]," ).append("\n"); 
		query.append("  @[pod_grp_tp_cd]," ).append("\n"); 
		query.append("  @[pod_rout_cd]," ).append("\n"); 
		query.append("  @[del_grp_tp_cd]," ).append("\n"); 
		query.append("  @[del_rout_cd]," ).append("\n"); 
		query.append("  '*'," ).append("\n"); 
		query.append("  @[vip_bkg_rt]," ).append("\n"); 
		query.append("  'N'," ).append("\n"); 
		query.append("  @[sc_no]," ).append("\n"); 
		query.append("  @[rfa_no]," ).append("\n"); 
		query.append("  @[taa_no]," ).append("\n"); 
		query.append("  @[fm_eff_dt]," ).append("\n"); 
		query.append("  @[to_eff_dt]," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}