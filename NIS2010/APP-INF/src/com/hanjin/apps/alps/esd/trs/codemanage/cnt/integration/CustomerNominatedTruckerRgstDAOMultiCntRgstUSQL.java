/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerNominatedTruckerRgstDAOMultiCntRgstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.30
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.09.30 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerRgstDAOMultiCntRgstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNT Update
	  * </pre>
	  */
	public CustomerNominatedTruckerRgstDAOMultiCntRgstUSQL(){
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
		params.put("org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_mqc_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nomi_trkr_fuel_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_pkup_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration ").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerRgstDAOMultiCntRgstUSQL").append("\n"); 
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
		query.append("UPDATE TRS_CUST_NOMI_TRKR" ).append("\n"); 
		query.append("   SET PRC_CTRT_TP_CD          = @[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append("      ,PRC_CTRT_NO             = @[prc_ctrt_no]" ).append("\n"); 
		query.append("      ,VNDR_SEQ                = @[vndr_seq]" ).append("\n"); 
		query.append("      ,IO_BND_CD               = @[io_bnd_cd]" ).append("\n"); 
		query.append("      ,ORG_NOD_CD              = @[org_nod_cd] || @[org_nod_yard]" ).append("\n"); 
		query.append("      ,DEST_NOD_CD             = @[dest_nod_cd] || @[dest_nod_yard]" ).append("\n"); 
		query.append("      ,MTY_PKUP_RTN_YD_CD      = @[mty_pkup_rtn_yd_cd]" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD            = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_BZC_AMT  = @[cust_nomi_trkr_bzc_amt]" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_FUEL_DIV_CD = @[cust_nomi_trkr_fuel_div_cd]" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_FUEL_RTO = @[cust_nomi_trkr_fuel_rto]" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_FUEL_AMT = @[cust_nomi_trkr_fuel_amt]" ).append("\n"); 
		query.append("      ,RGST_USR_ID             = @[rgst_usr_id]" ).append("\n"); 
		query.append("      ,RGST_OFC_CD             = @[rgst_ofc_cd]" ).append("\n"); 
		query.append("      ,COST_DESC               = @[cost_desc]" ).append("\n"); 
		query.append("      ,CUST_NOMI_TRKR_SAV_DT   = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]) -- 세션 Office Code" ).append("\n"); 
		query.append("      ,SLS_OFC_CD              = @[sls_ofc_cd]" ).append("\n"); 
		query.append("      ,CTRT_CUST_SREP_CD       = @[ctrt_cust_srep_cd]" ).append("\n"); 
		query.append("      ,CTRT_CUST_CNT_CD        = substr(@[ctrt_cust_cd],1,2)" ).append("\n"); 
		query.append("      ,CTRT_CUST_SEQ           = substr(@[ctrt_cust_cd],3)" ).append("\n"); 
		query.append("      ,CTRT_EFF_DT             = TO_DATE(SUBSTR(REPLACE(@[ctrt_eff_dt] , '-', ''), 0, 8), 'YYYYMMDD')" ).append("\n"); 
		query.append("      ,CTRT_EXP_DT             = TO_DATE(SUBSTR(REPLACE(@[ctrt_exp_dt] , '-', ''), 0, 8), 'YYYYMMDD')" ).append("\n"); 
		query.append("      ,FNL_MQC_DESC            = @[fnl_mqc_desc]" ).append("\n"); 
		query.append("      ,UPD_USR_ID              = @[upd_usr_id]    -- 세션 User_id" ).append("\n"); 
		query.append("      ,UPD_DT                  = sysdate" ).append("\n"); 
		query.append(" WHERE APRO_NO = @[apro_no]" ).append("\n"); 

	}
}