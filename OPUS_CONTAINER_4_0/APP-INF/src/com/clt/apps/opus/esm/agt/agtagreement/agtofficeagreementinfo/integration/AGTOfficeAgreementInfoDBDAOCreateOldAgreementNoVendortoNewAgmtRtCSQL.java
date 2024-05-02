/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewAgmtRtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.06.22 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewAgmtRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewAgmtRtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_seq_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_ver_seq_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd_value",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cd_value",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewAgmtRtCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO AGT_AGN_AGMT_RT" ).append("\n"); 
		query.append("( AGMT_OFC_CD," ).append("\n"); 
		query.append("AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("AGN_AGMT_SEQ," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("AGN_AGMT_VER_SEQ," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("AGN_SEQ," ).append("\n"); 
		query.append("CNTR_INP_TERM_CD," ).append("\n"); 
		query.append("FULL_MTY_CD," ).append("\n"); 
		query.append("COMM_PAY_TERM_CD," ).append("\n"); 
		query.append("GRS_NET_DIV_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("CHG_DDCT_INP_CD," ).append("\n"); 
		query.append("HLG_DDCT_ORG_FLG," ).append("\n"); 
		query.append("HLG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("FDRG_DDCT_ORG_FLG," ).append("\n"); 
		query.append("FDRG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("CUST_INP_TERM_CD," ).append("\n"); 
		query.append("SC_INP_TERM_CD," ).append("\n"); 
		query.append("RFA_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_OFC_INP_TERM_CD," ).append("\n"); 
		query.append("SLS_OFC_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_POR_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_POL_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_POD_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_DEL_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_PPD_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_CLT_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_N3RD_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_SOC_FLG," ).append("\n"); 
		query.append("BKG_DBL_FLG," ).append("\n"); 
		query.append("SC_OFC_INP_CD," ).append("\n"); 
		query.append("RFA_OFC_INP_CD," ).append("\n"); 
		query.append("LANE_INP_TERM_CD," ).append("\n"); 
		query.append("VSL_INP_TERM_CD," ).append("\n"); 
		query.append("LOCL_CHG_INP_TERM_CD," ).append("\n"); 
		query.append("COMM_STND_COST_CD," ).append("\n"); 
		query.append("FX_COMM_AMT," ).append("\n"); 
		query.append("BKG_COMM_RT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[agmt_ofc_cd]," ).append("\n"); 
		query.append("@[agmt_ofc_cty_cd]," ).append("\n"); 
		query.append("@[agn_agmt_seq]," ).append("\n"); 
		query.append("@[vndr_cnt_cd]," ).append("\n"); 
		query.append("@[vndr_seq]," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("AGN_SEQ," ).append("\n"); 
		query.append("CNTR_INP_TERM_CD," ).append("\n"); 
		query.append("FULL_MTY_CD," ).append("\n"); 
		query.append("COMM_PAY_TERM_CD," ).append("\n"); 
		query.append("GRS_NET_DIV_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("CHG_DDCT_INP_CD," ).append("\n"); 
		query.append("HLG_DDCT_ORG_FLG," ).append("\n"); 
		query.append("HLG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("FDRG_DDCT_ORG_FLG," ).append("\n"); 
		query.append("FDRG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("CUST_INP_TERM_CD," ).append("\n"); 
		query.append("SC_INP_TERM_CD," ).append("\n"); 
		query.append("RFA_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_OFC_INP_TERM_CD," ).append("\n"); 
		query.append("SLS_OFC_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_POR_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_POL_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_POD_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_DEL_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_PPD_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_CLT_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_N3RD_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_SOC_FLG," ).append("\n"); 
		query.append("BKG_DBL_FLG," ).append("\n"); 
		query.append("SC_OFC_INP_CD," ).append("\n"); 
		query.append("RFA_OFC_INP_CD," ).append("\n"); 
		query.append("LANE_INP_TERM_CD," ).append("\n"); 
		query.append("VSL_INP_TERM_CD," ).append("\n"); 
		query.append("LOCL_CHG_INP_TERM_CD," ).append("\n"); 
		query.append("COMM_STND_COST_CD," ).append("\n"); 
		query.append("FX_COMM_AMT," ).append("\n"); 
		query.append("BKG_COMM_RT," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM AGT_AGN_AGMT_RT" ).append("\n"); 
		query.append("WHERE AGMT_OFC_CD      = @[agmt_ofc_cd_value]" ).append("\n"); 
		query.append("AND AGMT_OFC_CTY_CD  = @[agmt_ofc_cty_cd_value]" ).append("\n"); 
		query.append("AND AGN_AGMT_SEQ     = @[agn_agmt_seq_value]" ).append("\n"); 
		query.append("AND VNDR_CNT_CD      = @[vndr_cnt_cd_value]" ).append("\n"); 
		query.append("AND VNDR_SEQ         = @[vndr_seq_value]" ).append("\n"); 
		query.append("AND AGN_AGMT_VER_SEQ = @[agn_agmt_ver_seq_value]" ).append("\n"); 

	}
}