/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAOAddFinanceOfficeInfoListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.22 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOAddFinanceOfficeInfoListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMSetupDBDAOAddFinanceOfficeInfoListCSQL(){
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_div_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_info_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_chr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_to_dt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_fm_dt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration").append("\n");
		query.append("FileName : ACMSetupDBDAOAddFinanceOfficeInfoListCSQL").append("\n");
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
		query.append("INSERT INTO ACM_OFC_INFO" ).append("\n");
		query.append("       (AGN_INFO_SEQ," ).append("\n");
		query.append("        AGN_CD," ).append("\n");
		query.append("        RHQ_CD," ).append("\n");
		query.append("        OFC_CD," ).append("\n");
		query.append("        OFC_GRP_ID," ).append("\n");
		query.append("        DP_GRP_NM," ).append("\n");
		query.append("        OFC_CHR_CD," ).append("\n");
		query.append("        AGN_FM_DT_CD," ).append("\n");
		query.append("        AGN_FM_DT," ).append("\n");
		query.append("        AGN_TO_DT_CD," ).append("\n");
		query.append("        AGN_TO_DT," ).append("\n");
		query.append("        VNDR_CNT_CD," ).append("\n");
		query.append("        VNDR_SEQ," ).append("\n");
		query.append("        XCH_RT_DIV_LVL," ).append("\n");
		query.append("        CURR_CD," ).append("\n");
		query.append("        AR_OFC_CD," ).append("\n");
		query.append("        CRE_USR_ID," ).append("\n");
		query.append("        CRE_DT," ).append("\n");
		query.append("        UPD_USR_ID," ).append("\n");
		query.append("        UPD_DT)" ).append("\n");
		query.append("" ).append("\n");
		query.append("VALUES (@[agn_info_seq]," ).append("\n");
		query.append("        @[agn_cd]," ).append("\n");
		query.append("        @[rhq_cd]," ).append("\n");
		query.append("        @[ofc_cd]," ).append("\n");
		query.append("        @[ofc_grp_id]," ).append("\n");
		query.append("        @[dp_grp_nm]," ).append("\n");
		query.append("        @[ofc_chr_cd]," ).append("\n");
		query.append("        @[agn_fm_dt_cd]," ).append("\n");
		query.append("        @[agn_fm_dt]," ).append("\n");
		query.append("        @[agn_to_dt_cd]," ).append("\n");
		query.append("        @[agn_to_dt]," ).append("\n");
		query.append("        (SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[vndr_seq])," ).append("\n");
		query.append("        @[vndr_seq]," ).append("\n");
		query.append("        @[xch_rt_div_lvl]," ).append("\n");
		query.append("        @[curr_cd]," ).append("\n");
		query.append("        @[ar_ofc_cd]," ).append("\n");
		query.append("        @[usr_id]," ).append("\n");
		query.append("        SYSDATE," ).append("\n");
		query.append("        @[usr_id]," ).append("\n");
		query.append("        SYSDATE)" ).append("\n");

	}
}