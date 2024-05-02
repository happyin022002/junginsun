/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOAddBsaInformationEntryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.03.15 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOAddBsaInformationEntryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddBsaInformationEntry
	  * 1. 2013.02.07 이수진 [CHM-201322641] BSA Enmtry 기능 추가
	  *    - 	JO_PRC_FSH_FLG 항목 추가
	  * 
	  * 2. 2013.02.22 이수진 [CHM-201322641] BSA Enmtry 기능 추가
	  *    - Add BSA 값이 0인 경우에 Add BSA Carrier Flag를 'N'으로 저장되도록 로직 변경
	  * 
	  * 3. 2016.03.15 박정민 [CHM-201640491] JO Revenue Loading Information 기능 보완 건
	  *    - INSERT 모듈 MERGE문으로 교체
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOAddBsaInformationEntryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("jo_45ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_add_bsa_crr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rf_ocn_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_40ft_ovr_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_20ft_ovr_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rf_ocn_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rnd_knd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ovr_mt_ocn_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_entr_rdr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_sctr_prc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_20ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ovr_bsa_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_inter_ovr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_und_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_fsh_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ovr_mt_inter_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_rf_inter_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ovr_inter_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_rdr_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_entr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_ovr_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_rnd_rule_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ovr_ocn_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ton_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_add_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ovr_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_40ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rf_inter_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_prc_fsh_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOAddBsaInformationEntryCSQL").append("\n"); 
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
		query.append("MERGE INTO JOO_BSA_AGMT A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT @[trd_cd] AS  TRD_CD" ).append("\n"); 
		query.append("         , @[rlane_cd] AS  RLANE_CD" ).append("\n"); 
		query.append("         , @[vsl_cd] AS  VSL_CD" ).append("\n"); 
		query.append("         , @[skd_voy_no] AS  SKD_VOY_NO" ).append("\n"); 
		query.append("         , @[skd_dir_cd] AS  SKD_DIR_CD" ).append("\n"); 
		query.append("         , @[port_cd] AS  PORT_CD" ).append("\n"); 
		query.append("         , @[port_seq] AS  PORT_SEQ" ).append("\n"); 
		query.append("         , @[jo_crr_cd] AS JO_CRR_CD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append(" ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("AND A.PORT_SEQ = B.PORT_SEQ" ).append("\n"); 
		query.append("AND A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE " ).append("\n"); 
		query.append("        SET OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("          , RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("          , JO_BSA_TEU_QTY = @[jo_bsa_teu_qty]" ).append("\n"); 
		query.append("          , JO_BSA_ADD_TEU_QTY = @[jo_bsa_add_teu_qty]" ).append("\n"); 
		query.append("          , JO_ADD_BSA_CRR_FLG = decode(@[jo_bsa_add_teu_qty],0,'N',@[jo_add_bsa_crr_flg])" ).append("\n"); 
		query.append("          , JO_OVR_BSA_TEU_QTY = @[jo_ovr_bsa_teu_qty]" ).append("\n"); 
		query.append("          , JO_TON_TEU_QTY = @[jo_ton_teu_qty]" ).append("\n"); 
		query.append("          , JO_OVR_TON_WGT = @[jo_ovr_ton_wgt]" ).append("\n"); 
		query.append("          , JO_20FT_SUB_TEU_QTY = @[jo_20ft_sub_teu_qty]" ).append("\n"); 
		query.append("          , JO_20FT_OVR_RTO = @[jo_20ft_ovr_rto]" ).append("\n"); 
		query.append("          , JO_40FT_SUB_TEU_QTY = @[jo_40ft_sub_teu_qty]" ).append("\n"); 
		query.append("          , JO_40FT_OVR_RTO = @[jo_40ft_ovr_rto]" ).append("\n"); 
		query.append("          , JO_45FT_SUB_TEU_QTY = @[jo_45ft_sub_teu_qty]" ).append("\n"); 
		query.append("          , JO_45FT_OVR_RTO = @[jo_45ft_ovr_rto]" ).append("\n"); 
		query.append("          , JO_45FT_UND_RTO = @[jo_45ft_und_rto]" ).append("\n"); 
		query.append("          , JO_RF_OCN_TEU_QTY = @[jo_rf_ocn_teu_qty]" ).append("\n"); 
		query.append("          , JO_RF_INTER_TEU_QTY = @[jo_rf_inter_teu_qty]" ).append("\n"); 
		query.append("          , JO_RND_KND_FLG = @[jo_rnd_knd_flg]" ).append("\n"); 
		query.append("          , JO_RND_RULE_LVL = @[jo_rnd_rule_lvl]" ).append("\n"); 
		query.append("          , JO_INTER_OVR_FLG = @[jo_inter_ovr_flg]" ).append("\n"); 
		query.append("          , JO_RDR_PORT_CD = @[jo_rdr_port_cd]" ).append("\n"); 
		query.append("          , JO_FSH_FLG = @[jo_fsh_flg]" ).append("\n"); 
		query.append("          , JO_BSA_PRC = @[jo_bsa_prc]" ).append("\n"); 
		query.append("          , JO_OVR_OCN_PRC = @[jo_ovr_ocn_prc]" ).append("\n"); 
		query.append("          , JO_OVR_INTER_PRC = @[jo_ovr_inter_prc]" ).append("\n"); 
		query.append("          , JO_OVR_MT_OCN_PRC = @[jo_ovr_mt_ocn_prc]" ).append("\n"); 
		query.append("          , JO_OVR_MT_INTER_PRC = @[jo_ovr_mt_inter_prc]" ).append("\n"); 
		query.append("          , JO_SCTR_PRC_FLG = @[jo_sctr_prc_flg]" ).append("\n"); 
		query.append("          , JO_RF_OCN_PRC = @[jo_rf_ocn_prc]" ).append("\n"); 
		query.append("          , JO_RF_INTER_PRC = @[jo_rf_inter_prc]" ).append("\n"); 
		query.append("          , JO_PRC_FSH_FLG = @[jo_prc_fsh_flg]" ).append("\n"); 
		query.append("          , YRWK = @[yrwk]" ).append("\n"); 
		query.append("          , REV_PORT_ETD_DT = @[rev_port_etd_dt]" ).append("\n"); 
		query.append("          , JO_BSA_ENTR_RMK = @[jo_bsa_entr_rmk]" ).append("\n"); 
		query.append("          , JO_BSA_ENTR_RDR_RMK = @[jo_bsa_entr_rdr_rmk]" ).append("\n"); 
		query.append("          , DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("          , CRE_DT = SYSDATE" ).append("\n"); 
		query.append("          , CRE_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("          , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("          , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("          TRD_CD" ).append("\n"); 
		query.append("        , RLANE_CD" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("        , PORT_CD" ).append("\n"); 
		query.append("        , PORT_SEQ" ).append("\n"); 
		query.append("        , OFC_CD" ).append("\n"); 
		query.append("        , RE_DIVR_CD" ).append("\n"); 
		query.append("        , JO_CRR_CD" ).append("\n"); 
		query.append("        , JO_BSA_TEU_QTY" ).append("\n"); 
		query.append("        , JO_BSA_ADD_TEU_QTY" ).append("\n"); 
		query.append("        , JO_ADD_BSA_CRR_FLG" ).append("\n"); 
		query.append("        , JO_OVR_BSA_TEU_QTY" ).append("\n"); 
		query.append("        , JO_TON_TEU_QTY" ).append("\n"); 
		query.append("        , JO_OVR_TON_WGT" ).append("\n"); 
		query.append("        , JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("        , JO_20FT_OVR_RTO" ).append("\n"); 
		query.append("        , JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("        , JO_40FT_OVR_RTO" ).append("\n"); 
		query.append("        , JO_45FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("        , JO_45FT_OVR_RTO" ).append("\n"); 
		query.append("        , JO_45FT_UND_RTO" ).append("\n"); 
		query.append("        , JO_RF_OCN_TEU_QTY" ).append("\n"); 
		query.append("        , JO_RF_INTER_TEU_QTY" ).append("\n"); 
		query.append("        , JO_RND_KND_FLG" ).append("\n"); 
		query.append("        , JO_RND_RULE_LVL" ).append("\n"); 
		query.append("        , JO_INTER_OVR_FLG" ).append("\n"); 
		query.append("        , JO_RDR_PORT_CD" ).append("\n"); 
		query.append("        , JO_FSH_FLG" ).append("\n"); 
		query.append("        , JO_BSA_PRC" ).append("\n"); 
		query.append("        , JO_OVR_OCN_PRC" ).append("\n"); 
		query.append("        , JO_OVR_INTER_PRC" ).append("\n"); 
		query.append("        , JO_OVR_MT_OCN_PRC" ).append("\n"); 
		query.append("        , JO_OVR_MT_INTER_PRC" ).append("\n"); 
		query.append("        , JO_SCTR_PRC_FLG" ).append("\n"); 
		query.append("        , JO_RF_OCN_PRC" ).append("\n"); 
		query.append("        , JO_RF_INTER_PRC" ).append("\n"); 
		query.append("        , JO_PRC_FSH_FLG" ).append("\n"); 
		query.append("        , YRWK" ).append("\n"); 
		query.append("        , REV_PORT_ETD_DT" ).append("\n"); 
		query.append("        , JO_BSA_ENTR_RMK" ).append("\n"); 
		query.append("        , JO_BSA_ENTR_RDR_RMK" ).append("\n"); 
		query.append("        , DELT_FLG" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID     " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     VALUES" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("          @[trd_cd]" ).append("\n"); 
		query.append("        , @[rlane_cd]" ).append("\n"); 
		query.append("        , @[vsl_cd]" ).append("\n"); 
		query.append("        , @[skd_voy_no]" ).append("\n"); 
		query.append("        , @[skd_dir_cd]" ).append("\n"); 
		query.append("        , @[port_cd]" ).append("\n"); 
		query.append("        , @[port_seq]" ).append("\n"); 
		query.append("        , @[ofc_cd]" ).append("\n"); 
		query.append("        , @[re_divr_cd]" ).append("\n"); 
		query.append("        , @[jo_crr_cd]" ).append("\n"); 
		query.append("        , @[jo_bsa_teu_qty]" ).append("\n"); 
		query.append("        , @[jo_bsa_add_teu_qty]" ).append("\n"); 
		query.append("        , decode(@[jo_bsa_add_teu_qty],0,'N',@[jo_add_bsa_crr_flg])" ).append("\n"); 
		query.append("        , @[jo_ovr_bsa_teu_qty]" ).append("\n"); 
		query.append("        , @[jo_ton_teu_qty]" ).append("\n"); 
		query.append("        , @[jo_ovr_ton_wgt]" ).append("\n"); 
		query.append("        , @[jo_20ft_sub_teu_qty]" ).append("\n"); 
		query.append("        , @[jo_20ft_ovr_rto]" ).append("\n"); 
		query.append("        , @[jo_40ft_sub_teu_qty]" ).append("\n"); 
		query.append("        , @[jo_40ft_ovr_rto]" ).append("\n"); 
		query.append("        , @[jo_45ft_sub_teu_qty]" ).append("\n"); 
		query.append("        , @[jo_45ft_ovr_rto]" ).append("\n"); 
		query.append("        , @[jo_45ft_und_rto]" ).append("\n"); 
		query.append("        , @[jo_rf_ocn_teu_qty]" ).append("\n"); 
		query.append("        , @[jo_rf_inter_teu_qty]" ).append("\n"); 
		query.append("        , @[jo_rnd_knd_flg]" ).append("\n"); 
		query.append("        , @[jo_rnd_rule_lvl]" ).append("\n"); 
		query.append("        , @[jo_inter_ovr_flg]" ).append("\n"); 
		query.append("        , @[jo_rdr_port_cd]" ).append("\n"); 
		query.append("        , @[jo_fsh_flg]" ).append("\n"); 
		query.append("        , @[jo_bsa_prc]" ).append("\n"); 
		query.append("        , @[jo_ovr_ocn_prc]" ).append("\n"); 
		query.append("        , @[jo_ovr_inter_prc]" ).append("\n"); 
		query.append("        , @[jo_ovr_mt_ocn_prc]" ).append("\n"); 
		query.append("        , @[jo_ovr_mt_inter_prc]" ).append("\n"); 
		query.append("        , @[jo_sctr_prc_flg]" ).append("\n"); 
		query.append("        , @[jo_rf_ocn_prc]" ).append("\n"); 
		query.append("        , @[jo_rf_inter_prc]" ).append("\n"); 
		query.append("        , @[jo_prc_fsh_flg]" ).append("\n"); 
		query.append("        , @[yrwk]" ).append("\n"); 
		query.append("        , @[rev_port_etd_dt]" ).append("\n"); 
		query.append("        , @[jo_bsa_entr_rmk]" ).append("\n"); 
		query.append("        , @[jo_bsa_entr_rdr_rmk]" ).append("\n"); 
		query.append("        , @[delt_flg]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}