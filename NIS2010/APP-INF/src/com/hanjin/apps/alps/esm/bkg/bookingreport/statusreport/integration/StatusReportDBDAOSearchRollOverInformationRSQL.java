/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : StatusReportDBDAOSearchRollOverInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchRollOverInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Roll over information report
	  * </pre>
	  */
	public StatusReportDBDAOSearchRollOverInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("roll_ovr_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchRollOverInformationRSQL").append("\n"); 
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
		query.append("SELECT OFC_N3RD_LVL_CD RHQ_OFC" ).append("\n"); 
		query.append("       ,BB.BKG_OFC_CD" ).append("\n"); 
		query.append("       ,BB.BL_NO" ).append("\n"); 
		query.append("       ,to_char(OVR.evnt_dt, 'yyyy-mm-dd hh24:mi') evnt_dt" ).append("\n"); 
		query.append("       ,BC.CUST_CNT_CD||lpad(BC.CUST_SEQ, 6, 0) CUST_CD" ).append("\n"); 
		query.append("       ,REPLACE(BC.CUST_NM,CHR(13)||CHR(10),' ') CUST_NM" ).append("\n"); 
		query.append("       ,pre_vsl_cd||pre_skd_voy_no||pre_skd_dir_cd PRE_VVD" ).append("\n"); 
		query.append("       ,OVR.new_vsl_cd||OVR.new_skd_voy_no||OVR.new_skd_dir_cd NEW_VVD" ).append("\n"); 
		query.append("       ,CICD.INTG_CD_VAL_DESC roll_ovr_rsn_cd" ).append("\n"); 
		query.append("  FROM DMT_OFC_LVL_V OFC" ).append("\n"); 
		query.append("       ,BKG_ROLL_OVR OVR" ).append("\n"); 
		query.append("       ,BKG_BOOKING BB" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER BC" ).append("\n"); 
		query.append("       ,COM_INTG_CD_DTL CICD" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append(" AND BB.BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" AND BB.BKG_CRE_DT BETWEEN TO_DATE(replace(@[bkg_from_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[bkg_to_dt],'-',''),'YYYYMMDD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq_cd} != '')" ).append("\n"); 
		query.append(" AND OFC_N3RD_LVL_CD = @[rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append(" AND BB.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append(" AND BC.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append(" AND BC.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append(" AND REPLACE(BC.CUST_NM,CHR(13)||CHR(10),' ') like @[cust_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${roll_ovr_rsn_cd} != '')" ).append("\n"); 
		query.append(" AND OVR.ROLL_OVR_RSN_CD = @[roll_ovr_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_cd} == 'S' && ${ctrt_no} != '')" ).append("\n"); 
		query.append(" AND BB.SC_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${ctrt_cd} == 'R' && ${ctrt_no} != '')" ).append("\n"); 
		query.append(" AND BB.RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${ctrt_cd} == 'T' && ${ctrt_no} != '')" ).append("\n"); 
		query.append(" AND BB.TAA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" AND BB.BKG_NO = OVR.BKG_NO" ).append("\n"); 
		query.append(" AND BB.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append(" AND BC.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append(" AND BB.BKG_OFC_CD = OFC.OFC_N8TH_LVL_CD(+)" ).append("\n"); 
		query.append(" AND ROLL_OVR_SEQ < (select max(ROLL_OVR_SEQ) from bkg_roll_ovr max_seq where max_seq.bkg_no = ovr.bkg_no)" ).append("\n"); 
		query.append(" AND OVR.ROLL_OVR_RSN_CD = CICD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append(" AND CICD.INTG_CD_ID(+) = 'CD01571'" ).append("\n"); 
		query.append(" ORDER BY OVR.CRE_DT" ).append("\n"); 

	}
}