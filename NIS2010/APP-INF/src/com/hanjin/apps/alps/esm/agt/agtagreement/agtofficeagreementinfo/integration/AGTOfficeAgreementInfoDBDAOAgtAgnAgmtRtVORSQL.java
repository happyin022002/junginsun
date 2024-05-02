/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeAgreementInfoDBDAOAgtAgnAgmtRtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeAgreementInfoDBDAOAgtAgnAgmtRtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTOfficeAgreementInfoDBDAOAgtAgnAgmtRtVORSQL(){
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
		params.put("agn_agmt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeAgreementInfoDBDAOAgtAgnAgmtRtVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("AGMT_OFC_CD," ).append("\n"); 
		query.append("AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("AGN_AGMT_SEQ," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("AGN_AGMT_VER_SEQ," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("AGN_SEQ," ).append("\n"); 
		query.append("DECODE(CNTR_INP_TERM_CD, '*', '', CNTR_INP_TERM_CD) AS CNTR_INP_TERM_CD," ).append("\n"); 
		query.append("FULL_MTY_CD," ).append("\n"); 
		query.append("COMM_PAY_TERM_CD," ).append("\n"); 
		query.append("GRS_NET_DIV_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("DECODE(CHG_DDCT_INP_CD, '*', '', CHG_DDCT_INP_CD) AS CHG_DDCT_INP_CD," ).append("\n"); 
		query.append("HLG_DDCT_ORG_FLG," ).append("\n"); 
		query.append("HLG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("FDRG_DDCT_ORG_FLG," ).append("\n"); 
		query.append("FDRG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("DECODE(CUST_INP_TERM_CD, '*', '', CUST_INP_TERM_CD) AS CUST_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(SC_INP_TERM_CD, '*', '', SC_INP_TERM_CD) AS SC_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(RFA_INP_TERM_CD, '*', '', RFA_INP_TERM_CD) AS RFA_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(BKG_OFC_INP_TERM_CD, '*', '', BKG_OFC_INP_TERM_CD) AS BKG_OFC_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(SLS_OFC_INP_TERM_CD, '*' ,'', SLS_OFC_INP_TERM_CD) AS SLS_OFC_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(BKG_POR_INP_TERM_CD, '*', '', BKG_POR_INP_TERM_CD) AS BKG_POR_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(BKG_POL_INP_TERM_CD, '*', '', BKG_POL_INP_TERM_CD) AS BKG_POL_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(BKG_POD_INP_TERM_CD, '*', '', BKG_POD_INP_TERM_CD) AS BKG_POD_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(BKG_DEL_INP_TERM_CD, '*', '', BKG_DEL_INP_TERM_CD) AS BKG_DEL_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(BKG_PPD_INP_TERM_CD, '*', '', BKG_PPD_INP_TERM_CD) AS BKG_PPD_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(BKG_CLT_INP_TERM_CD, '*', '', BKG_CLT_INP_TERM_CD) AS BKG_CLT_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(BKG_N3RD_INP_TERM_CD, '*', '', BKG_N3RD_INP_TERM_CD) AS BKG_N3RD_INP_TERM_CD," ).append("\n"); 
		query.append("BKG_SOC_FLG," ).append("\n"); 
		query.append("BKG_DBL_FLG," ).append("\n"); 
		query.append("DECODE(SC_OFC_INP_CD, '*', '', SC_OFC_INP_CD) AS SC_OFC_INP_CD," ).append("\n"); 
		query.append("DECODE(RFA_OFC_INP_CD, '*', '', RFA_OFC_INP_CD) AS RFA_OFC_INP_CD," ).append("\n"); 
		query.append("DECODE(LANE_INP_TERM_CD, '*', '', LANE_INP_TERM_CD) AS LANE_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(VSL_INP_TERM_CD, '*', '', VSL_INP_TERM_CD) AS VSL_INP_TERM_CD," ).append("\n"); 
		query.append("DECODE(LOCL_CHG_INP_TERM_CD, '*', '', LOCL_CHG_INP_TERM_CD) AS LOCL_CHG_INP_TERM_CD," ).append("\n"); 
		query.append("COMM_STND_COST_CD," ).append("\n"); 
		query.append("FX_COMM_AMT," ).append("\n"); 
		query.append("BKG_COMM_RT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM AGT_AGN_AGMT_RT" ).append("\n"); 
		query.append("WHERE AGMT_OFC_CD = @[agmt_ofc_cd]" ).append("\n"); 
		query.append("AND AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND AGN_AGMT_SEQ = @[agn_agmt_seq]" ).append("\n"); 
		query.append("AND VNDR_CNT_CD = @[vndr_cnt_cd]" ).append("\n"); 
		query.append("AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND AGN_AGMT_VER_SEQ = @[agn_agmt_ver_seq]" ).append("\n"); 

	}
}