/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchAccountTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchAccountTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Account Type 별 Code List 조회
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchAccountTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchAccountTypeRSQL").append("\n"); 
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
		query.append("#if (${acct_ctnt} == 'ADJ')" ).append("\n"); 
		query.append("    SELECT ACCT_TP_CD" ).append("\n"); 
		query.append("           , ACCT_TP_NM" ).append("\n"); 
		query.append("           , PAY_ACCT_CD" ).append("\n"); 
		query.append("           , AMT_SGN_CD" ).append("\n"); 
		query.append("    FROM SAR_ACCT_MTX" ).append("\n"); 
		query.append("    WHERE ACCT_CTNT1 = @[acct_ctnt]" ).append("\n"); 
		query.append("    AND ACCT_CTNT2 = @[acct_ctnt2]" ).append("\n"); 
		query.append("    AND ACCT_CTNT4 = @[acct_ctnt4]" ).append("\n"); 
		query.append("    AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("    SELECT A.ACCT_TP_CD" ).append("\n"); 
		query.append("           , A.ACCT_TP_NM" ).append("\n"); 
		query.append("           , A.PAY_ACCT_CD" ).append("\n"); 
		query.append("           , A.AMT_SGN_CD" ).append("\n"); 
		query.append("    FROM SAR_ACCT_MTX A," ).append("\n"); 
		query.append("         SCO_OFC_INFO B" ).append("\n"); 
		query.append("    WHERE A.ACCT_TP_CD IN (B.OFC_ADJ_TP_CD1, B.OFC_ADJ_TP_CD2, B.OFC_ADJ_TP_CD3, B.OFC_ADJ_TP_CD4, B.OFC_ADJ_TP_CD5)" ).append("\n"); 
		query.append("    AND A.ACCT_CTNT1 = @[acct_ctnt]" ).append("\n"); 
		query.append("    AND A.ACCT_CTNT2 = @[acct_ctnt2]" ).append("\n"); 
		query.append("    AND NVL(A.ACCT_CTNT4, 'N') <> @[acct_ctnt4]" ).append("\n"); 
		query.append("    AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    AND B.OFC_CD = SUBSTR(@[ofc_cd], 1, 5)" ).append("\n"); 
		query.append("    ORDER BY ACCT_TP_CD" ).append("\n"); 
		query.append("#elseif (${acct_ctnt} == 'WRTF')" ).append("\n"); 
		query.append("    SELECT ACCT_TP_CD" ).append("\n"); 
		query.append("           , ACCT_TP_NM" ).append("\n"); 
		query.append("           , PAY_ACCT_CD" ).append("\n"); 
		query.append("           , AMT_SGN_CD" ).append("\n"); 
		query.append("    FROM SAR_ACCT_MTX" ).append("\n"); 
		query.append("    WHERE ACCT_CTNT1 = @[acct_ctnt]" ).append("\n"); 
		query.append("    AND ACCT_CTNT2 = @[acct_ctnt2]" ).append("\n"); 
		query.append("    AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("    SELECT A.ACCT_TP_CD" ).append("\n"); 
		query.append("           , A.ACCT_TP_NM" ).append("\n"); 
		query.append("           , A.PAY_ACCT_CD" ).append("\n"); 
		query.append("           , A.AMT_SGN_CD" ).append("\n"); 
		query.append("    FROM SAR_ACCT_MTX A," ).append("\n"); 
		query.append("         SCO_OFC_INFO B" ).append("\n"); 
		query.append("    WHERE A.ACCT_TP_CD IN (B.OFC_WRTF_TP_CD1, B.OFC_WRTF_TP_CD2, B.OFC_WRTF_TP_CD3, B.OFC_WRTF_TP_CD4, B.OFC_WRTF_TP_CD5)" ).append("\n"); 
		query.append("    AND A.ACCT_CTNT1 = @[acct_ctnt]" ).append("\n"); 
		query.append("    AND NVL(A.ACCT_CTNT2, 'N') <> @[acct_ctnt2]" ).append("\n"); 
		query.append("    AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("    AND B.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("    ORDER BY ACCT_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}