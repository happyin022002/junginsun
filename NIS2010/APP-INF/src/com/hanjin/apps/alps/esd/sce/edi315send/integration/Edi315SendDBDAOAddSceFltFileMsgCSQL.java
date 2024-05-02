/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOAddSceFltFileMsgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.05.10 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOAddSceFltFileMsgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSceFltFileMsg
	  * </pre>
	  */
	public Edi315SendDBDAOAddSceFltFileMsgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_atd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_ata",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_etd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_eta",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_hr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ibd_trsp_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_ata",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_atd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_eta",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_evnt_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_stnd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_eta",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_etd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_etd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_atd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_ata",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_code",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_snd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOAddSceFltFileMsgCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_FLT_FILE_MSG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("EDI_SND_DT" ).append("\n"); 
		query.append(",EDI_SND_HR" ).append("\n"); 
		query.append(",EDI_SND_SEQ" ).append("\n"); 
		query.append(",FLT_FILE_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",EDI_EVNT_NOD_CD" ).append("\n"); 
		query.append(",EDI_EVNT_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",POR_DEP_ESTM_DT" ).append("\n"); 
		query.append(",POR_DEP_ACT_DT" ).append("\n"); 
		query.append(",POL_ARR_ESTM_DT" ).append("\n"); 
		query.append(",POL_ARR_ACT_DT" ).append("\n"); 
		query.append(",POL_DEP_ESTM_DT" ).append("\n"); 
		query.append(",POL_DEP_ACT_DT" ).append("\n"); 
		query.append(",POD_ARR_ESTM_DT" ).append("\n"); 
		query.append(",POD_ARR_ACT_DT" ).append("\n"); 
		query.append(",POD_DEP_ESTM_DT" ).append("\n"); 
		query.append(",POD_DEP_ACT_DT" ).append("\n"); 
		query.append(",DEL_ARR_ESTM_DT" ).append("\n"); 
		query.append(",DEL_ARR_ACT_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",POR_NOD_CD" ).append("\n"); 
		query.append(",POL_NOD_CD" ).append("\n"); 
		query.append(",POD_NOD_CD" ).append("\n"); 
		query.append(",DEL_NOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",CUST_EDI_STS_CD" ).append("\n"); 
		query.append(",EDI_STND_STS_CD" ).append("\n"); 
		query.append(",EDI_GRP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",COP_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",PROV_TRD_PRNR_ID" ).append("\n"); 
		query.append(",CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",TRNK_VSL_CD" ).append("\n"); 
		query.append(",TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(",TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",CRNT_VSL_CD" ).append("\n"); 
		query.append(",CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append(",CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append(",CALL_VSL_CD" ).append("\n"); 
		query.append(",CALL_SKD_VOY_NO" ).append("\n"); 
		query.append(",CALL_SKD_DIR_CD" ).append("\n"); 
		query.append(",EDI_RCV_SEQ" ).append("\n"); 
		query.append(",EDI_RCV_DTL_SEQ" ).append("\n"); 
		query.append(",IBD_TRSP_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[edi_snd_dt] --TO_CHAR(SYSDATE,'YYYYMMDD')--EDI_SND_DT" ).append("\n"); 
		query.append(",@[edi_snd_hr] --TO_CHAR(SYSDATE,'HH24')    --EDI_SND_HR" ).append("\n"); 
		query.append(",@[edi_snd_seq]--SCE_EDI_AMS_IF_SEQ.NEXTVAL --EDI_SND_SEQ" ).append("\n"); 
		query.append(",nvl(@[flt_file_ref_no],'-')--flt_file_ref_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",@[bkg_no]                  --bkg_no" ).append("\n"); 
		query.append(",@[bl_no]					--bl_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",@[edi_evnt_nod_cd]							--edi_evnt_nod_cd" ).append("\n"); 
		query.append(",to_date(@[edi_evnt_dt],'yyyymmddhh24miss')	--edi_evnt_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",case when @[por_etd] is not null then to_date(@[por_etd]||'00','yyyymmddhh24miss') end  --por_dep_estm_dt" ).append("\n"); 
		query.append(",case when @[por_atd] is not null then to_date(@[por_atd]||'00','yyyymmddhh24miss') end  --por_dep_act_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",case when @[pol_eta] is not null then to_date(@[pol_eta]||'00','yyyymmddhh24miss') end  --pol_dep_estm_dt" ).append("\n"); 
		query.append(",case when @[pol_ata] is not null then to_date(@[pol_ata]||'00','yyyymmddhh24miss') end  --pol_arr_act_dt" ).append("\n"); 
		query.append(",case when @[pol_etd] is not null then to_date(@[pol_etd]||'00','yyyymmddhh24miss') end  --pol_dep_estm_dt" ).append("\n"); 
		query.append(",case when @[pol_atd] is not null then to_date(@[pol_atd]||'00','yyyymmddhh24miss') end  --pol_dep_act_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",case when @[pod_eta] is not null then to_date(@[pod_eta]||'00','yyyymmddhh24miss') end  --pod_arr_estm_dt" ).append("\n"); 
		query.append(",case when @[pod_ata] is not null then to_date(@[pod_ata]||'00','yyyymmddhh24miss') end  --pod_arr_act_dt" ).append("\n"); 
		query.append(",case when @[pod_etd] is not null then to_date(@[pod_etd]||'00','yyyymmddhh24miss') end  --pod_dep_estm_dt" ).append("\n"); 
		query.append(",case when @[pod_atd] is not null then to_date(@[pod_atd]||'00','yyyymmddhh24miss') end  --pod_dep_act_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",case when @[del_eta] is not null then to_date(@[del_eta]||'00','yyyymmddhh24miss') end  --del_arr_estm_dt" ).append("\n"); 
		query.append(",case when @[del_ata] is not null then to_date(@[del_ata]||'00','yyyymmddhh24miss') end  --del_arr_act_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",@[por_code]                --por_nod_cd" ).append("\n"); 
		query.append(",@[pol_code]                --pol_nod_cd" ).append("\n"); 
		query.append(",@[pod_code]                --pod_nod_cd" ).append("\n"); 
		query.append(",@[del_code]                --del_nod_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",SYSDATE                      --cre_dt" ).append("\n"); 
		query.append(",SYSDATE                      --upd_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",@[cust_edi_sts_cd]" ).append("\n"); 
		query.append(",@[edi_stnd_sts_cd]" ).append("\n"); 
		query.append(",@[edi_grp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",@[cop_no]" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",@[prov_trd_prnr_id] --prov_trd_prnr_id" ).append("\n"); 
		query.append(",@[cust_trd_prnr_id] --cust_trd_prnr_id" ).append("\n"); 
		query.append(",@[trnk_vsl_cd] --trnk_vsl_cd" ).append("\n"); 
		query.append(",@[trnk_skd_voy_no] --trnk_skd_voy_no" ).append("\n"); 
		query.append(",@[trnk_skd_dir_cd] --trnk_skd_dir_cd" ).append("\n"); 
		query.append(",@[cre_usr_id] --cre_usr_id" ).append("\n"); 
		query.append(",@[upd_usr_id] --upd_usr_id" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",@[crnt_vsl_cd] --crnt_vsl_cd" ).append("\n"); 
		query.append(",@[crnt_skd_voy_no]--crnt_skd_voy_no" ).append("\n"); 
		query.append(",@[crnt_skd_dir_cd]--crnt_skd_dir_cd" ).append("\n"); 
		query.append(",@[call_vsl_cd]--call_vsl_cd" ).append("\n"); 
		query.append(",@[call_skd_voy_no]--call_skd_voy_no" ).append("\n"); 
		query.append(",@[call_skd_dir_cd]--call_skd_dir_cd" ).append("\n"); 
		query.append(",@[edi_rcv_seq]--edi_rcv_seq" ).append("\n"); 
		query.append(",@[edi_rcv_dtl_seq]--edi_rcv_dtl_seq" ).append("\n"); 
		query.append(",@[ibd_trsp_no]--ibd_trsp_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}