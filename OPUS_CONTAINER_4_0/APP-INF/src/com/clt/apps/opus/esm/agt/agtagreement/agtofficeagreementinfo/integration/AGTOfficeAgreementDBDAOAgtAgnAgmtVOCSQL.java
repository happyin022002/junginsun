/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeAgreementDBDAOAgtAgnAgmtVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.18 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeAgreementDBDAOAgtAgnAgmtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Table agt_agn_agmt Insert
	  * </pre>
	  */
	public AGTOfficeAgreementDBDAOAgtAgnAgmtVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",Y";
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
		params.put("xch_rt_div_lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",Y";
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
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_chr_lvl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeAgreementDBDAOAgtAgnAgmtVOCSQL").append("\n"); 
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
		query.append("INSERT INTO AGT_AGN_AGMT(" ).append("\n"); 
		query.append("AGMT_OFC_CD," ).append("\n"); 
		query.append("AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("AGN_AGMT_SEQ," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("AGN_AGMT_VER_SEQ," ).append("\n"); 
		query.append("FM_EFF_DT," ).append("\n"); 
		query.append("TO_EFF_DT," ).append("\n"); 
		query.append("XCH_RT_DIV_LVL," ).append("\n"); 
		query.append("OFC_CHR_LVL," ).append("\n"); 
		query.append("AGN_AGMT_RMK," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[agmt_ofc_cd]," ).append("\n"); 
		query.append("@[agmt_ofc_cty_cd]," ).append("\n"); 
		query.append("@[agn_agmt_seq]," ).append("\n"); 
		query.append("@[vndr_cnt_cd]," ).append("\n"); 
		query.append("@[vndr_seq]," ).append("\n"); 
		query.append("(SELECT NVL(MAX(AGN_AGMT_VER_SEQ) + 1, 1) AS AGN_AGMT_VER_SEQ" ).append("\n"); 
		query.append("FROM AGT_AGN_AGMT" ).append("\n"); 
		query.append("WHERE AGMT_OFC_CD = @[agmt_ofc_cd]" ).append("\n"); 
		query.append("AND AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND AGN_AGMT_SEQ = @[agn_agmt_seq]" ).append("\n"); 
		query.append("AND VNDR_CNT_CD = @[vndr_cnt_cd]" ).append("\n"); 
		query.append("AND VNDR_SEQ = @[vndr_seq])," ).append("\n"); 
		query.append("@[fm_eff_dt]," ).append("\n"); 
		query.append("@[to_eff_dt]," ).append("\n"); 
		query.append("@[xch_rt_div_lvl]," ).append("\n"); 
		query.append("@[ofc_chr_lvl]," ).append("\n"); 
		query.append("@[agn_agmt_rmk]," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}