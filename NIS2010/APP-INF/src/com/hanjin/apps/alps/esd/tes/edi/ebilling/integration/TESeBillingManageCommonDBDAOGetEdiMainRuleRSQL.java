/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageCommonDBDAOGetEdiMainRuleRSQL.java
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

public class TESeBillingManageCommonDBDAOGetEdiMainRuleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Main Rule 조회
	  * </pre>
	  */
	public TESeBillingManageCommonDBDAOGetEdiMainRuleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingManageCommonDBDAOGetEdiMainRuleRSQL").append("\n"); 
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
		query.append("--M.SNDR_ID, M.RCVR_ID, M.INV_TAG_NM, M.INIT_INV_TAG_VAL_CHK_FLG, M.INIT_ALL_TAG_VAL_CHK_FLG" ).append("\n"); 
		query.append("M.EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append(", M.SNDR_ID" ).append("\n"); 
		query.append(", M.RCVR_ID" ).append("\n"); 
		query.append(", M.CFM_FLG" ).append("\n"); 
		query.append(", M.CFM_DT" ).append("\n"); 
		query.append(", M.DELT_FLG" ).append("\n"); 
		query.append(", M.DELT_DT" ).append("\n"); 
		query.append(", M.INV_TAG_NM" ).append("\n"); 
		query.append(", M.INIT_INV_TAG_VAL_CHK_FLG" ).append("\n"); 
		query.append(", M.INIT_ALL_TAG_VAL_CHK_FLG" ).append("\n"); 
		query.append(", M.EDI_RMK" ).append("\n"); 
		query.append("FROM TES_EDI_RCV_RULE_MN M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.SNDR_ID = @[sndr_id]" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(M.CFM_FLG,'N') = 'Y'" ).append("\n"); 

	}
}