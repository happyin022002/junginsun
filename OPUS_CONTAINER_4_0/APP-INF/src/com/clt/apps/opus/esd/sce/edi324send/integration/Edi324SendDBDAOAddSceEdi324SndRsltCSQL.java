/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi324SendDBDAOAddSceEdi324SndRsltCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.02.09 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi324send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi324SendDBDAOAddSceEdi324SndRsltCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_EDI_324_SND_RSLT테이블에  데이터를 미리 입력을 한다.
	  * </pre>
	  */
	public Edi324SendDBDAOAddSceEdi324SndRsltCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_loc_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_vsl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_loc_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_estm_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_loc_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_loc_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lbs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_dep_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_estm_arr_gdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi324send.integration").append("\n"); 
		query.append("FileName : Edi324SendDBDAOAddSceEdi324SndRsltCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_EDI_324_SND_RSLT (" ).append("\n"); 
		query.append("        VNDR_SEQ," ).append("\n"); 
		query.append("        BKG_NO," ).append("\n"); 
		query.append("        CNTR_NO," ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        EDI_SND_SEQ," ).append("\n"); 
		query.append("        EDI_SND_ID," ).append("\n"); 
		query.append("        MNL_FLG," ).append("\n"); 
		query.append("        EDI_SND_TP_CD," ).append("\n"); 
		query.append("        EDI_SND_RMK," ).append("\n"); 
		query.append("        EDI_SND_DT," ).append("\n"); 
		query.append("        COP_NO," ).append("\n"); 
		query.append("        LLOYD_VSL_NO," ).append("\n"); 
		query.append("        VSL_NM," ).append("\n"); 
		query.append("        POL_YD_CD," ).append("\n"); 
		query.append("        POL_DEP_ACT_DT," ).append("\n"); 
		query.append("        POD_YD_CD," ).append("\n"); 
		query.append("        POD_NM," ).append("\n"); 
		query.append("        ACT_CD," ).append("\n"); 
		query.append("        POD_ESTM_ARR_DT," ).append("\n"); 
		query.append("        POD_ESTM_ARR_GDT," ).append("\n"); 
		query.append("        BL_NO," ).append("\n"); 
		query.append("        CNTR_WGT," ).append("\n"); 
		query.append("        CNTR_WGT_UT_CD," ).append("\n"); 
		query.append("        CNTR_LBS_WGT," ).append("\n"); 
		query.append("        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        CNTR_LEN," ).append("\n"); 
		query.append("        CNTR_HGT," ).append("\n"); 
		query.append("        CNTR_SEAL_NO," ).append("\n"); 
		query.append("        ORG_YD_CD," ).append("\n"); 
		query.append("        ORG_YD_LOC_CTY_NM," ).append("\n"); 
		query.append("        ORG_YD_LOC_STE_CD," ).append("\n"); 
		query.append("        ORG_LOC_NM," ).append("\n"); 
		query.append("        DEST_YD_CD," ).append("\n"); 
		query.append("        DEST_YD_NM," ).append("\n"); 
		query.append("        DEST_YD_LOC_CTY_NM," ).append("\n"); 
		query.append("        DEST_YD_LOC_STE_CD," ).append("\n"); 
		query.append("        DEST_LOC_NM," ).append("\n"); 
		query.append("        DG_FLG," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT" ).append("\n"); 
		query.append(")     VALUES (" ).append("\n"); 
		query.append("        @[vndr_seq]," ).append("\n"); 
		query.append("        @[bkg_no]," ).append("\n"); 
		query.append("        @[cntr_no]," ).append("\n"); 
		query.append("        @[vsl_cd]," ).append("\n"); 
		query.append("        @[skd_voy_no]," ).append("\n"); 
		query.append("        @[skd_dir_cd]," ).append("\n"); 
		query.append("        @[edi_snd_seq]," ).append("\n"); 
		query.append("        @[edi_snd_id]," ).append("\n"); 
		query.append("        @[mnl_flg]," ).append("\n"); 
		query.append("        @[edi_snd_tp_cd]," ).append("\n"); 
		query.append("        @[edi_snd_rmk]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[cop_no]," ).append("\n"); 
		query.append("        @[lloyd_vsl_no]," ).append("\n"); 
		query.append("        @[vsl_nm]," ).append("\n"); 
		query.append("        @[pol_yd_cd]," ).append("\n"); 
		query.append("        TO_DATE(@[pol_dep_act_dt],'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("        @[pod_yd_cd]," ).append("\n"); 
		query.append("        @[pod_nm]," ).append("\n"); 
		query.append("        @[act_cd]," ).append("\n"); 
		query.append("        TO_DATE(@[pod_estm_arr_dt],'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("        TO_DATE(@[pod_estm_arr_gdt],'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("        @[bl_no]," ).append("\n"); 
		query.append("        @[cntr_wgt]," ).append("\n"); 
		query.append("        @[cntr_wgt_ut_cd]," ).append("\n"); 
		query.append("        @[cntr_lbs_wgt]," ).append("\n"); 
		query.append("        @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("        @[cntr_len]," ).append("\n"); 
		query.append("        @[cntr_hgt]," ).append("\n"); 
		query.append("        @[cntr_seal_no]," ).append("\n"); 
		query.append("        @[org_yd_cd]," ).append("\n"); 
		query.append("        @[org_yd_loc_cty_nm]," ).append("\n"); 
		query.append("        @[org_yd_loc_ste_cd]," ).append("\n"); 
		query.append("        @[org_loc_nm]," ).append("\n"); 
		query.append("        @[dest_yd_cd]," ).append("\n"); 
		query.append("        @[dest_yd_nm]," ).append("\n"); 
		query.append("        @[dest_yd_loc_cty_nm]," ).append("\n"); 
		query.append("        @[dest_yd_loc_ste_cd]," ).append("\n"); 
		query.append("        @[dest_loc_nm]," ).append("\n"); 
		query.append("        @[dg_flg]," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}