/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CustomerNominatedTruckerAproDAOCreateCntAproCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.20
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.01.20 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerAproDAOCreateCntAproCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNT Approval Create
	  * </pre>
	  */
	public CustomerNominatedTruckerAproDAOCreateCntAproCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hjs_trkr_fuel_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_fuel_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_trkr_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_mqc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_fuel_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_his_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_cust_nomi_trkr_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_trkr_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dor_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_fuel_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerAproDAOCreateCntAproCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_CUST_NOMI_TRKR (" ).append("\n"); 
		query.append("	 APRO_NO" ).append("\n"); 
		query.append("	,PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("	,PRC_CTRT_NO" ).append("\n"); 
		query.append("	,VNDR_SEQ" ).append("\n"); 
		query.append("	,IO_BND_CD " ).append("\n"); 
		query.append("	,ORG_NOD_CD" ).append("\n"); 
		query.append("	,DEST_NOD_CD" ).append("\n"); 
		query.append("	,MTY_PKUP_RTN_YD_CD " ).append("\n"); 
		query.append("	,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,CUST_NOMI_TRKR_BZC_AMT" ).append("\n"); 
		query.append("	,CUST_NOMI_TRKR_FUEL_DIV_CD" ).append("\n"); 
		query.append("	,CUST_NOMI_TRKR_FUEL_RTO" ).append("\n"); 
		query.append("	,CUST_NOMI_TRKR_FUEL_AMT" ).append("\n"); 
		query.append("	,RGST_USR_ID" ).append("\n"); 
		query.append("	,RGST_OFC_CD" ).append("\n"); 
		query.append("	,COST_DESC" ).append("\n"); 
		query.append("	,APRO_USR_ID" ).append("\n"); 
		query.append("    ,APRO_OFC_CD" ).append("\n"); 
		query.append("    ,APRO_HIS_DESC" ).append("\n"); 
		query.append("    ,HJS_TRKR_AGMT_NO" ).append("\n"); 
		query.append("	,HJS_TRKR_BZC_AMT " ).append("\n"); 
		query.append("	,HJS_TRKR_FUEL_AMT" ).append("\n"); 
		query.append("	,HJS_CUST_NOMI_TRKR_AGMT_NO" ).append("\n"); 
		query.append("    ,CUST_NOMI_TRKR_RQST_DT" ).append("\n"); 
		query.append("    ,CUST_NOMI_TRKR_APRO_DT" ).append("\n"); 
		query.append("	,DISP_STS_CD" ).append("\n"); 
		query.append("	,CUST_NOMI_TRKR_SAV_DT" ).append("\n"); 
		query.append("	,SLS_OFC_CD" ).append("\n"); 
		query.append("	,CTRT_CUST_SREP_CD " ).append("\n"); 
		query.append("	,CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("	,CTRT_CUST_SEQ" ).append("\n"); 
		query.append("	,CTRT_EFF_DT" ).append("\n"); 
		query.append("	,CTRT_EXP_DT" ).append("\n"); 
		query.append("	,FNL_MQC_DESC" ).append("\n"); 
		query.append("    ,CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(")VALUES (" ).append("\n"); 
		query.append("	 (SELECT SUBSTR(@[cre_ofc_cd],1,3) -- 세션 오피스 코드" ).append("\n"); 
		query.append("	     ||TO_CHAR(SYSDATE, 'YYMMDD')" ).append("\n"); 
		query.append("	     ||NVL((SELECT LPAD(MAX(SUBSTR(APRO_NO, 10))+1, 4, '0')" ).append("\n"); 
		query.append("	              FROM TRS_CUST_NOMI_TRKR" ).append("\n"); 
		query.append("	             WHERE APRO_NO LIKE SUBSTR(@[cre_ofc_cd],1, 3)||TO_CHAR(SYSDATE, 'YYMMDD') || '%'" ).append("\n"); 
		query.append("	               AND LENGTH(APRO_NO) >= 12" ).append("\n"); 
		query.append("	     ), '0001') APRO_NO" ).append("\n"); 
		query.append("	 FROM DUAL)" ).append("\n"); 
		query.append("	,@[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append("	,@[prc_ctrt_no]" ).append("\n"); 
		query.append("	,@[vndr_seq]" ).append("\n"); 
		query.append("	,@[io_bnd_cd] " ).append("\n"); 
		query.append("	,@[fm_nod_cd] || @[fm_nod_yard]" ).append("\n"); 
		query.append("	,@[dor_nod_cd] || @[dor_nod_yard]" ).append("\n"); 
		query.append("	,@[to_nod_cd]||@[to_nod_yard]" ).append("\n"); 
		query.append("	,@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("	,@[cust_nomi_trkr_bzc_amt]" ).append("\n"); 
		query.append("	,@[cust_nomi_trkr_fuel_div_cd]" ).append("\n"); 
		query.append("	,@[cust_nomi_trkr_fuel_rto]" ).append("\n"); 
		query.append("	,@[cust_nomi_trkr_fuel_amt]" ).append("\n"); 
		query.append("	,@[rgst_usr_id]" ).append("\n"); 
		query.append("	,@[rgst_ofc_cd]" ).append("\n"); 
		query.append("	,@[cost_desc]" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("	,@[cre_ofc_cd]" ).append("\n"); 
		query.append("	,@[apro_his_desc]" ).append("\n"); 
		query.append("    ,@[hjs_trkr_agmt_no]" ).append("\n"); 
		query.append("    ,@[hjs_trkr_bzc_amt]" ).append("\n"); 
		query.append("    ,@[hjs_trkr_fuel_amt]  " ).append("\n"); 
		query.append("    ,@[hjs_cust_nomi_trkr_agmt_no]  " ).append("\n"); 
		query.append("	,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]) -- 세션 Office Code" ).append("\n"); 
		query.append("    ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append("	,'03' -- disp_sts_cd saved" ).append("\n"); 
		query.append("	,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]) -- 세션 Office Code" ).append("\n"); 
		query.append("	,@[sls_ofc_cd]" ).append("\n"); 
		query.append("	,@[ctrt_cust_srep_cd]" ).append("\n"); 
		query.append("	,substr(@[ctrt_cust_cnt_cd],1,2)" ).append("\n"); 
		query.append("	,substr(@[ctrt_cust_cnt_cd],3)" ).append("\n"); 
		query.append("	,TO_DATE(SUBSTR(REPLACE(@[ctrt_eff_dt] , '-', ''), 0, 8), 'YYYYMMDD')" ).append("\n"); 
		query.append("	,TO_DATE(SUBSTR(REPLACE(@[ctrt_exp_dt] , '-', ''), 0, 8), 'YYYYMMDD')" ).append("\n"); 
		query.append("	,@[fnl_mqc_desc]" ).append("\n"); 
		query.append("    ,@[cust_nomi_trkr_ind_cd]" ).append("\n"); 
		query.append("	,@[cre_usr_id] -- 세션 User_id" ).append("\n"); 
		query.append("	,sysdate --cre_dt" ).append("\n"); 
		query.append("	,@[cre_usr_id] -- 세션 User_id" ).append("\n"); 
		query.append("	,sysdate --upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}