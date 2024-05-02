/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgreementTrsAgmtEqTpRuleDBDAOSearchComIntgCdDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.05.02 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementTrsAgmtEqTpRuleDBDAOSearchComIntgCdDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchComIntgCdDtl
	  * </pre>
	  */
	public AgreementTrsAgmtEqTpRuleDBDAOSearchComIntgCdDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_intg_cd_val_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_intg_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementTrsAgmtEqTpRuleDBDAOSearchComIntgCdDtlRSQL").append("\n"); 
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
		query.append("SELECT INTG_CD_ID AS INTG_CD_ID, " ).append("\n"); 
		query.append("       INTG_CD_VAL_CTNT AS INTG_CD_VAL_CTNT, " ).append("\n"); 
		query.append("       INTG_CD_VAL_DP_DESC AS INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${frm_intg_cd_id} != '') " ).append("\n"); 
		query.append(" AND INTG_CD_ID = @[frm_intg_cd_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_intg_cd_val_ctnt} != '') " ).append("\n"); 
		query.append(" AND INTG_CD_VAL_CTNT = @[frm_intg_cd_val_ctnt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}