/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageCommonDBDAOGetSetFltFileTagRulesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.22 
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

public class TESeBillingManageCommonDBDAOGetSetFltFileTagRulesRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VNDR단위에 처리 대상 TAG RULE
	  * </pre>
	  */
	public TESeBillingManageCommonDBDAOGetSetFltFileTagRulesRSQL(){
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
		query.append("FileName : TESeBillingManageCommonDBDAOGetSetFltFileTagRulesRSQL").append("\n"); 
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
		query.append("M.SNDR_ID, V.EDI_VNDR_SEQ," ).append("\n"); 
		query.append("T.FLT_FILE_TAG_NM, T.TBL_NM, T.TBL_VO_NM, T.HDR_TAG_FLG, T.SAV_SEQ, T.PRNT_TAG_NM, T.TAG_VLD_KNT, T.MNL_CNTR_RCV_TAG_FLG" ).append("\n"); 
		query.append("FROM TES_EDI_RCV_RULE_MN M, TES_EDI_RCV_RULE_VNDR_MGMT V, TES_EDI_RCV_FLT_FILE_TAG T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.EDI_RCV_RULE_MN_SEQ = V.EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append("AND M.SNDR_ID = @[sndr_id]" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--AND NVL(M.CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND V.EDI_VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND V.EDI_RCV_RULE_MN_SEQ = T.EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append("AND V.EDI_VNDR_SEQ = T.EDI_VNDR_SEQ" ).append("\n"); 
		query.append("ORDER BY T.SAV_SEQ" ).append("\n"); 

	}
}