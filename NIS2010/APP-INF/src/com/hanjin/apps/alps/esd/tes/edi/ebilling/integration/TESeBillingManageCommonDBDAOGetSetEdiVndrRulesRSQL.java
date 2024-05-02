/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageCommonDBDAOGetSetEdiVndrRulesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageCommonDBDAOGetSetEdiVndrRulesRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VNDR단위에 호출할 기본 EDI VNDR RULE
	  * </pre>
	  */
	public TESeBillingManageCommonDBDAOGetSetEdiVndrRulesRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingManageCommonDBDAOGetSetEdiVndrRulesRSQL").append("\n"); 
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
		query.append("M.EDI_RCV_RULE_MN_SEQ, M.SNDR_ID," ).append("\n"); 
		query.append("V.EDI_VNDR_SEQ, V.INV_OFC_CD, V.INV_OFC_MDM_REF_FLG, V.COST_OFC_CD, V.COST_OFC_MDM_REF_FLG," ).append("\n"); 
		query.append("V.IMPL_MN_TP_CD, V.IMPL_TP_CD, V.IMPL_SUB_TP_CD, V.PARS_MZD_CD, V.VNDR_TRF_REF_FLG, V.STO_PRD_DT_CHK_FLG" ).append("\n"); 
		query.append("FROM TES_EDI_RCV_RULE_MN M, TES_EDI_RCV_RULE_VNDR_MGMT V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.EDI_RCV_RULE_MN_SEQ = V.EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(M.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND M.SNDR_ID = @[sndr_id]" ).append("\n"); 
		query.append("AND V.EDI_VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}