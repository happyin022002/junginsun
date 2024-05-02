/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScqAwkwardDBDAOaddPriScqAwkMnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOaddPriScqAwkMnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_MN
	  * * 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
	  * </pre>
	  */
	public ScqAwkwardDBDAOaddPriScqAwkMnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_bid_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOaddPriScqAwkMnCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCQ_AWK_MN" ).append("\n"); 
		query.append("	( SCQ_RQST_NO                      " ).append("\n"); 
		query.append("	, SCQ_VER_NO                       " ).append("\n"); 
		query.append("	, PROG_STS_CD                      " ).append("\n"); 
		query.append("	, RQST_OFC_CD                      " ).append("\n"); 
		query.append("	, RQST_SREP_CD                     " ).append("\n"); 
		query.append("	, POR_CD                           " ).append("\n"); 
		query.append("	, POL_CD                           " ).append("\n"); 
		query.append("	, POL_YD_CD                        " ).append("\n"); 
		query.append("	, POD_CD                           " ).append("\n"); 
		query.append("	, POD_YD_CD                        " ).append("\n"); 
		query.append("	, DEL_CD                           " ).append("\n"); 
		query.append("	, SVC_SCP_CD                       " ).append("\n"); 
		query.append("	, CUST_CNT_CD                      " ).append("\n"); 
		query.append("	, CUST_SEQ                         " ).append("\n"); 
		query.append("	, RCV_TERM_CD                      " ).append("\n"); 
		query.append("	, DE_TERM_CD" ).append("\n"); 
		query.append("#if(${prop_eff_dt}!='')                       " ).append("\n"); 
		query.append("	, PROP_EFF_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${prop_exp_dt}!='')                      " ).append("\n"); 
		query.append("	, PROP_EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${apro_eff_dt}!='')                      " ).append("\n"); 
		query.append("	, APRO_EFF_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${apro_exp_dt}!='')                      " ).append("\n"); 
		query.append("	, APRO_EXP_DT" ).append("\n"); 
		query.append("#end                      " ).append("\n"); 
		query.append("	, DELT_FLG                         " ).append("\n"); 
		query.append("	, CRE_USR_ID                       " ).append("\n"); 
		query.append("	, CRE_DT                           " ).append("\n"); 
		query.append("	, UPD_USR_ID                       " ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	, APRO_OFC_CD" ).append("\n"); 
		query.append("    , ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("    , ACT_CUST_SEQ" ).append("\n"); 
		query.append("    , ACT_CUST_NM" ).append("\n"); 
		query.append("    , SCQ_BID_FLG" ).append("\n"); 
		query.append("    , MEAS_SYS_CD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	VALUES" ).append("\n"); 
		query.append("	( @[scq_rqst_no]                " ).append("\n"); 
		query.append("	, @[scq_ver_no]                     " ).append("\n"); 
		query.append("	, @[prog_sts_cd]                     " ).append("\n"); 
		query.append("	, @[rqst_ofc_cd]                     " ).append("\n"); 
		query.append("	, @[rqst_srep_cd]                     " ).append("\n"); 
		query.append("	, @[por_cd]                     " ).append("\n"); 
		query.append("	, @[pol_cd]                     " ).append("\n"); 
		query.append("	, @[pol_yd_cd]                     " ).append("\n"); 
		query.append("	, @[pod_cd]                     " ).append("\n"); 
		query.append("	, @[pod_yd_cd]                     " ).append("\n"); 
		query.append("	, @[del_cd]                     " ).append("\n"); 
		query.append("	, @[svc_scp_cd]                     " ).append("\n"); 
		query.append("	, @[cust_cnt_cd]                     " ).append("\n"); 
		query.append("	, @[cust_seq]                     " ).append("\n"); 
		query.append("	, @[rcv_term_cd]                     " ).append("\n"); 
		query.append("	, @[de_term_cd]                     " ).append("\n"); 
		query.append("#if(${prop_eff_dt}!='')" ).append("\n"); 
		query.append("	, TO_DATE(@[prop_eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${prop_exp_dt}!='')                     " ).append("\n"); 
		query.append("	, TO_DATE(@[prop_exp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${apro_eff_dt}!='')                     " ).append("\n"); 
		query.append("	, TO_DATE(@[apro_eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${apro_exp_dt}!='')                     " ).append("\n"); 
		query.append("	, TO_DATE(@[apro_exp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end                    " ).append("\n"); 
		query.append("	, @[delt_flg]                     " ).append("\n"); 
		query.append("	, @[cre_usr_id]                     " ).append("\n"); 
		query.append("	, SYSDATE                     " ).append("\n"); 
		query.append("	, @[cre_usr_id]                     " ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[apro_ofc_cd]" ).append("\n"); 
		query.append("    , @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("    , @[act_cust_seq]" ).append("\n"); 
		query.append("    , @[act_cust_nm]" ).append("\n"); 
		query.append("    , @[scq_bid_flg]" ).append("\n"); 
		query.append("    , NVL ( @[meas_sys_cd], 'M' )" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}