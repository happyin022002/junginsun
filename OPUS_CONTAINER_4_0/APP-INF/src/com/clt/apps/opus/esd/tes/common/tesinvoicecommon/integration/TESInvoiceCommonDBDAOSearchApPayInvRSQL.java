/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOSearchApPayInvRSQL.java
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

public class TESInvoiceCommonDBDAOSearchApPayInvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchApPayInv
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOSearchApPayInvRSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOSearchApPayInvRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("    'TES' INV_SUB_SYS_CD," ).append("\n"); 
		query.append("    COST_OFC_CD," ).append("\n"); 
		query.append("    INV_OFC_CD," ).append("\n"); 
		query.append("    VNDR_SEQ," ).append("\n"); 
		query.append("    YD_CD," ).append("\n"); 
		query.append("    INV_NO," ).append("\n"); 
		query.append("    to_char(ISS_DT, 'YYYYMMDD') INV_ISS_DT," ).append("\n"); 
		query.append("    to_char(RCV_DT, 'YYYYMMDD')  INV_RCV_DT," ).append("\n"); 
		query.append("    to_char(EFF_DT, 'YYYYMMDD')  INV_EFF_DT," ).append("\n"); 
		query.append("    to_char(INV_CFM_DT, 'YYYYMMDD')  INV_CFM_DT," ).append("\n"); 
		query.append("    '' VNDR_TERM_NM," ).append("\n"); 
		query.append("    to_char(PAY_DUE_DT, 'YYYYMMDD')  PAY_DUE_DT,       --iss + Term" ).append("\n"); 
		query.append("    CURR_CD INV_CURR_CD," ).append("\n"); 
		query.append("    NVL(TTL_INV_AMT, 0) - NVL(VAT_AMT, 0)  INV_NET_AMT,	" ).append("\n"); 
		query.append("    NVL(TTL_INV_AMT, 0)  INV_TTL_AMT," ).append("\n"); 
		query.append("    VAT_AMT INV_VAT_AMT," ).append("\n"); 
		query.append("    WHLD_TAX_AMT WHLD_TAX_AMT, " ).append("\n"); 
		query.append("    'N' INV_CXL_FLG," ).append("\n"); 
		query.append("    'N' DELT_FLG," ).append("\n"); 
		query.append("    @[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE CRE_DT," ).append("\n"); 
		query.append("    @[cre_usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE UPD_DT" ).append("\n"); 
		query.append("from TES_TML_SO_HDR" ).append("\n"); 
		query.append("where " ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("and TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("and TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 

	}
}