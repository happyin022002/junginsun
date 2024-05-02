/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBasicRegisterDAOCustomAcctItmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDAOCustomAcctItmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOBasicRegisterDAOCustomAcctItmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnd_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDAOCustomAcctItmVORSQL").append("\n"); 
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
		query.append("#if (${condflag} != '' && ${condflag} == 'checkAccount') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT ACCT_CD" ).append("\n"); 
		query.append("     , ACCT_ENG_NM AS ACCT_NM" ).append("\n"); 
		query.append("  FROM MDM_ACCOUNT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${pnd_tgt_flg} != '')" ).append("\n"); 
		query.append("   AND PND_TGT_FLG = @[pnd_tgt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${condflag} != '' && ${condflag} == 'accountuse') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT ACCT_CD" ).append("\n"); 
		query.append("     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("  FROM FMS_OTR_EXPN" ).append("\n"); 
		query.append(" WHERE ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("#if(${acct_itm_seq} != '')" ).append("\n"); 
		query.append("   AND ACCT_ITM_SEQ = @[acct_itm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT ACCT_CD" ).append("\n"); 
		query.append("     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("  FROM FMS_INV_DTL" ).append("\n"); 
		query.append(" WHERE ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("#if(${acct_itm_seq} != '')" ).append("\n"); 
		query.append("   AND ACCT_ITM_SEQ = @[acct_itm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT ACCT_CD" ).append("\n"); 
		query.append("     , ACCT_ITM_SEQ" ).append("\n"); 
		query.append("  FROM FMS_BUNKER" ).append("\n"); 
		query.append(" WHERE ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("#if(${acct_itm_seq} != '')" ).append("\n"); 
		query.append("   AND ACCT_ITM_SEQ = @[acct_itm_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT AI.ACCT_CD" ).append("\n"); 
		query.append("     , AI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("     , AI.ACCT_ITM_NM" ).append("\n"); 
		query.append("     , (SELECT MA.ACCT_ENG_NM " ).append("\n"); 
		query.append("          FROM MDM_ACCOUNT MA" ).append("\n"); 
		query.append("         WHERE MA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND MA.ACCT_CD = AI.ACCT_CD" ).append("\n"); 
		query.append("       ) AS ACCT_NM" ).append("\n"); 
		query.append("     , AI.AP_CR_ACCT_CD" ).append("\n"); 
		query.append("     , (SELECT MA.ACCT_ENG_NM " ).append("\n"); 
		query.append("          FROM MDM_ACCOUNT MA" ).append("\n"); 
		query.append("         WHERE MA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND MA.ACCT_CD = AI.AP_CR_ACCT_CD" ).append("\n"); 
		query.append("       ) AS AP_CR_ACCT_NM" ).append("\n"); 
		query.append("     , AI.AR_CR_ACCT_CD" ).append("\n"); 
		query.append("     , (SELECT MA.ACCT_ENG_NM " ).append("\n"); 
		query.append("          FROM MDM_ACCOUNT MA" ).append("\n"); 
		query.append("         WHERE MA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND MA.ACCT_CD = AI.AR_CR_ACCT_CD" ).append("\n"); 
		query.append("       ) AS AR_CR_ACCT_NM" ).append("\n"); 
		query.append("     , AI.CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(AI.CRE_DT,'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("     , AI.UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(AI.UPD_DT,'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("  FROM FMS_ACCT_ITM AI" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" ORDER BY AI.ACCT_CD, AI.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}