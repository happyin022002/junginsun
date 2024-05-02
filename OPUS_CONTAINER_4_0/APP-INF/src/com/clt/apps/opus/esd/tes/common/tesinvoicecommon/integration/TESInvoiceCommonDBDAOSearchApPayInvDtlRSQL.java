/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOSearchApPayInvDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2011.03.08 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ParkChaeHeung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOSearchApPayInvDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchApPayInvDtl
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOSearchApPayInvDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOSearchApPayInvDtlRSQL").append("\n"); 
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
		query.append("	'I' IBFLAG," ).append("\n"); 
		query.append("	NVL((SELECT INV_RGST_SEQ " ).append("\n"); 
		query.append("		 FROM AP_PAY_INV_DTL D" ).append("\n"); 
		query.append("		 WHERE  D.INV_RGST_NO = @[inv_rgst_no] ), 0)+1 INV_RGST_SEQ," ).append("\n"); 
		query.append("	LGS_COST_CD," ).append("\n"); 
		query.append("	(select decode(length(T1.lgs_cost_cd), 4, 110911, x.acct_cd) from tes_lgs_cost x where x.lgs_cost_cd = T1.lgs_cost_cd) ACCT_CD," ).append("\n"); 
		query.append("	'CNTC' VSL_CD," ).append("\n"); 
		query.append("	'1102' SKD_VOY_NO," ).append("\n"); 
		query.append("	'M' SKD_DIR_CD," ).append("\n"); 
		query.append("	'M' REV_DIR_CD," ).append("\n"); 
		query.append("	( SELECT X.vsl_slan_cd " ).append("\n"); 
		query.append("	  FROM VSK_VSL_SKD X " ).append("\n"); 
		query.append("	  WHERE X.VSL_CD = t1.vsl_cd AND X.SKD_VOY_NO = t1.skd_voy_no AND X.skd_dir_cd = T1.skd_dir_cd" ).append("\n"); 
		query.append("	) SLAN_CD," ).append("\n"); 
		query.append("	VSL_CD||SKD_VOY_NO||SKD_DIR_CD ACT_VVD_CD," ).append("\n"); 
		query.append("	SUBSTR((select x.yd_cd from tes_tml_so_hdr x where x.tml_so_ofc_cty_cd = t1.tml_so_ofc_cty_cd and x.tml_so_seq = t1.tml_so_seq), 1, 5) PORT_CD," ).append("\n"); 
		query.append("	(select x.yd_cd from tes_tml_so_hdr x where x.tml_so_ofc_cty_cd = t1.tml_so_ofc_cty_cd and x.tml_so_seq = t1.tml_so_seq) YD_CD," ).append("\n"); 
		query.append("	INV_AMT," ).append("\n"); 
		query.append("	TML_SO_OFC_CTY_CD SO_OFC_CTY_CD," ).append("\n"); 
		query.append("	TML_SO_SEQ SO_SEQ," ).append("\n"); 
		query.append("	'N' DELT_FLG," ).append("\n"); 
		query.append("	@[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("	SYSDATE CRE_DT," ).append("\n"); 
		query.append("	@[cre_usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("	SYSDATE UPD_DT," ).append("\n"); 
		query.append("	'' as INV_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	TES_TML_SO_DTL T1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	AND TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	AND TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 

	}
}