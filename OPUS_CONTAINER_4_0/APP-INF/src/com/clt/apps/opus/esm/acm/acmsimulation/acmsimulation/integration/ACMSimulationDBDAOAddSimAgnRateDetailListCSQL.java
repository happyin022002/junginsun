/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSimulationDBDAOAddSimAgnRateDetailListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.09 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOAddSimAgnRateDetailListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * AddSimAgnRateDetail
	  * </pre>
	  */
	public ACMSimulationDBDAOAddSimAgnRateDetailListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_fx_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cvrg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hlg_ddct_dest_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdrg_ddct_org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdrg_ddct_dest_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_set_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oft_pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hlg_ddct_org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n");
		query.append("FileName : ACMSimulationDBDAOAddSimAgnRateDetailListCSQL").append("\n");
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
		query.append("INSERT INTO ACM_SIM_AGMT_DTL" ).append("\n");
		query.append("       (AGN_CD," ).append("\n");
		query.append("        AGN_AGMT_NO," ).append("\n");
		query.append("        IO_BND_CD," ).append("\n");
		query.append("        AC_TP_CD," ).append("\n");
		query.append("        AGN_AGMT_SEQ," ).append("\n");
		query.append("        OFC_SET_TP_CD," ).append("\n");
		query.append("        OFC_CVRG_CD," ).append("\n");
		query.append("        OFC_CD," ).append("\n");
		query.append("        OFT_PAY_TERM_CD," ).append("\n");
		query.append("        FULL_MTY_CD," ).append("\n");
		query.append("        CURR_CD," ).append("\n");
		query.append("        COMM_FX_AMT," ).append("\n");
		query.append("        COMM_PAY_TERM_CD," ).append("\n");
		query.append("        REV_DIV_CD," ).append("\n");
		query.append("        COMM_RT," ).append("\n");
		query.append("        HLG_DDCT_ORG_FLG," ).append("\n");
		query.append("        HLG_DDCT_DEST_FLG," ).append("\n");
		query.append("        FDRG_DDCT_ORG_FLG," ).append("\n");
		query.append("        FDRG_DDCT_DEST_FLG," ).append("\n");
		query.append("        DELT_FLG," ).append("\n");
		query.append("        CRE_GDT," ).append("\n");
		query.append("        CRE_USR_ID," ).append("\n");
		query.append("        CRE_DT," ).append("\n");
		query.append("        UPD_USR_ID," ).append("\n");
		query.append("        UPD_DT)" ).append("\n");
		query.append("" ).append("\n");
		query.append("VALUES (@[agn_cd]," ).append("\n");
		query.append("        @[agn_agmt_no]," ).append("\n");
		query.append("        @[io_bnd_cd]," ).append("\n");
		query.append("        @[ac_tp_cd]," ).append("\n");
		query.append("        (SELECT NVL(MAX(AGN_AGMT_SEQ)+1, 1)" ).append("\n");
		query.append("           FROM ACM_SIM_AGMT_DTL" ).append("\n");
		query.append("          WHERE AGN_CD = @[agn_cd]" ).append("\n");
		query.append("            AND AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n");
		query.append("            AND IO_BND_CD = @[io_bnd_cd]" ).append("\n");
		query.append("            AND AC_TP_CD = @[ac_tp_cd])," ).append("\n");
		query.append("        @[ofc_set_tp_cd]," ).append("\n");
		query.append("        @[ofc_cvrg_cd]," ).append("\n");
		query.append("        @[ofc_cd]," ).append("\n");
		query.append("        @[oft_pay_term_cd]," ).append("\n");
		query.append("        @[full_mty_cd]," ).append("\n");
		query.append("        @[curr_cd]," ).append("\n");
		query.append("        @[comm_fx_amt]," ).append("\n");
		query.append("        @[comm_pay_term_cd]," ).append("\n");
		query.append("        @[rev_div_cd]," ).append("\n");
		query.append("        @[comm_rt]," ).append("\n");
		query.append("        @[hlg_ddct_org_flg]," ).append("\n");
		query.append("        @[hlg_ddct_dest_flg]," ).append("\n");
		query.append("        @[fdrg_ddct_org_flg]," ).append("\n");
		query.append("        @[fdrg_ddct_dest_flg]," ).append("\n");
		query.append("        'N'," ).append("\n");
		query.append("        GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'GMT')," ).append("\n");
		query.append("        @[usr_id]," ).append("\n");
		query.append("        SYSDATE," ).append("\n");
		query.append("        @[usr_id]," ).append("\n");
		query.append("        SYSDATE)" ).append("\n");

	}
}