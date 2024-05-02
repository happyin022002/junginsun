/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDBDAOAddSceEdiHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOAddSceEdiHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for add
	  * </pre>
	  */
	public Edi315SendDBDAOAddSceEdiHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_if_key_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("man_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vdl_by_cntr_attach",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("log_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_if_key_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_if_key_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_rcv_if_key_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOAddSceEdiHisCSQL").append("\n"); 
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
		query.append("INSERT INTO sce_edi_his" ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                         EDI_RCV_DT" ).append("\n"); 
		query.append("                        ,EDI_RCV_SEQ" ).append("\n"); 
		query.append("                        ,EDI_STND_STS_CD" ).append("\n"); 
		query.append("                        ,CUST_EDI_STS_CD" ).append("\n"); 
		query.append("                        ,ACT_STS_MAPG_CD" ).append("\n"); 
		query.append("                        ,COP_ACT_CD" ).append("\n"); 
		query.append("                        ,BKG_NO" ).append("\n"); 
		query.append("                        ,BL_NO" ).append("\n"); 
		query.append("                        ,CNTR_NO" ).append("\n"); 
		query.append("                        ,COP_NO" ).append("\n"); 
		query.append("                        ,COP_DTL_SEQ" ).append("\n"); 
		query.append("                        ,COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("                        ,CRNT_VSL_CD" ).append("\n"); 
		query.append("                        ,CRNT_SKD_VOY_NO " ).append("\n"); 
		query.append("                        ,CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("                        ,EDI_EVNT_DT" ).append("\n"); 
		query.append("                        ,EVNT_YD_CD" ).append("\n"); 
		query.append("                        ,RCV_IF_KEY_DT" ).append("\n"); 
		query.append("                        ,RCV_IF_KEY_SEQ" ).append("\n"); 
		query.append("                        ,SRC_MDL_ID" ).append("\n"); 
		query.append("                        ,MNL_FLG" ).append("\n"); 
		query.append("                        ,EDI_SAV_FLG" ).append("\n"); 
		query.append("                        ,EDI_GRP_CD" ).append("\n"); 
		query.append("                        ,CRE_USR_ID" ).append("\n"); 
		query.append("                        ,CRE_DT" ).append("\n"); 
		query.append("                        ,UPD_USR_ID" ).append("\n"); 
		query.append("                        ,UPD_DT" ).append("\n"); 
		query.append("                        ,EDI_IF_KEY_DT" ).append("\n"); 
		query.append("                        ,EDI_IF_KEY_SEQ" ).append("\n"); 
		query.append("						,ATD_CNTR_ATCH_FLG" ).append("\n"); 
		query.append("						,CLPT_IND_SEQ" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append(" values( " ).append("\n"); 
		query.append("        @[rcv_dt],                       " ).append("\n"); 
		query.append("        @[rcv_seq],                      " ).append("\n"); 
		query.append("        @[edi_status],                   " ).append("\n"); 
		query.append("        @[cust_status],                  " ).append("\n"); 
		query.append("        @[mvmt_sts],                     " ).append("\n"); 
		query.append("        @[cop_act_cd]," ).append("\n"); 
		query.append("        @[bkg_no],                       " ).append("\n"); 
		query.append("        @[bl_no],                        " ).append("\n"); 
		query.append("        @[cntr_no],                      " ).append("\n"); 
		query.append("        @[cop_no]," ).append("\n"); 
		query.append("        @[cop_dtl_seq], " ).append("\n"); 
		query.append("        @[cost_act_grp_seq], " ).append("\n"); 
		query.append("        substr(@[curr_vvd], 1, 4),       " ).append("\n"); 
		query.append("        substr(@[curr_vvd], 5, 4),       " ).append("\n"); 
		query.append("        substr(@[curr_vvd], 9, 1),       " ).append("\n"); 
		query.append("        to_date(@[event_dt],'YYYYMMDDHH24MISS'),              " ).append("\n"); 
		query.append("        @[event_yard],                   " ).append("\n"); 
		query.append("        @[act_rcv_if_key_dt]," ).append("\n"); 
		query.append("        @[act_rcv_if_key_no]," ).append("\n"); 
		query.append("        @[call_from],                    " ).append("\n"); 
		query.append("        @[man_flg],                     " ).append("\n"); 
		query.append("        @[log_flg],                      " ).append("\n"); 
		query.append("        @[edi_grp_cd], " ).append("\n"); 
		query.append("        nvl(@[cre_id],'-'),                       " ).append("\n"); 
		query.append("        sysdate,                       " ).append("\n"); 
		query.append("        nvl(@[upd_id],'-'),                       " ).append("\n"); 
		query.append("        sysdate," ).append("\n"); 
		query.append("		@[edi_if_key_dt]," ).append("\n"); 
		query.append("		@[edi_if_key_seq]," ).append("\n"); 
		query.append("		@[vdl_by_cntr_attach]," ).append("\n"); 
		query.append("		@[clpt_ind_seq]" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}