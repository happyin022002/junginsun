/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FFCmpnAuditDBDAOSearchFFCmpnDetailHistorybyBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnAuditDBDAOSearchFFCmpnDetailHistorybyBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFFCmpnDetailHistorybyBlList
	  * </pre>
	  */
	public FFCmpnAuditDBDAOSearchFFCmpnDetailHistorybyBlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.integration").append("\n"); 
		query.append("FileName : FFCmpnAuditDBDAOSearchFFCmpnDetailHistorybyBlListRSQL").append("\n"); 
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
		query.append("SELECT B.FF_CMPN_SEQ," ).append("\n"); 
		query.append("       --DECODE(SUBSTR (B.FF_DIV_CD, 1, 1), 'B', DECODE(NVL(B.FF_BKG_RT, 0), 0, 0, (B.CRNT_AMT/B.FF_BKG_RT)*100), 0) AS ACT_COMM_ABLE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       CASE						 " ).append("\n"); 
		query.append("         WHEN SUBSTR (B.FF_DIV_CD, 1, 1) = 'B' AND NVL (B.FF_BKG_RT, 0) != 0 						 " ).append("\n"); 
		query.append("         THEN DECODE(NVL(B.FF_CHG_AMT,0),0,(B.CRNT_AMT / B.FF_BKG_RT) * 100,B.FF_CHG_AMT)						 " ).append("\n"); 
		query.append("         ELSE 0						 " ).append("\n"); 
		query.append("       END AS ACT_COMM_ABLE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       B.FF_BKG_RT," ).append("\n"); 
		query.append("       DECODE(SUBSTR (B.FF_DIV_CD, 1, 1), 'B', B.CRNT_AMT, 0) AS ACT_COMM_AMT," ).append("\n"); 
		query.append("       B.BKG_BX_QTY," ).append("\n"); 
		query.append("       B.FF_BX_AMT," ).append("\n"); 
		query.append("       B.BKG_TEU_QTY," ).append("\n"); 
		query.append("       B.FF_TEU_AMT," ).append("\n"); 
		query.append("       B.BKG_FEU_QTY," ).append("\n"); 
		query.append("       B.FF_FEU_AMT," ).append("\n"); 
		query.append("       B.BKG_RF_QTY," ).append("\n"); 
		query.append("       B.FF_RF_AMT," ).append("\n"); 
		query.append("       DECODE(SUBSTR (B.FF_DIV_CD, 1, 1), 'C', B.CRNT_AMT, 0 ) AS CNTR_COMM_AMT," ).append("\n"); 
		query.append("       B.IF_AMT," ).append("\n"); 
		query.append("       TO_CHAR(B.CRE_DT, 'YYYY-MM-DD') AS CRE_DT," ).append("\n"); 
		query.append("       B.FF_CMPN_STS_CD," ).append("\n"); 
		query.append("       REPLACE(B.FF_CMPN_RMK, '&', '&amp;') AS FF_CMPN_RMK," ).append("\n"); 
		query.append("       TO_CHAR(B.IF_DT, 'YYYY-MM-DD') AS IF_DT," ).append("\n"); 
		query.append("       B.FF_CNT_CD," ).append("\n"); 
		query.append("       B.FF_SEQ," ).append("\n"); 
		query.append("       B.FF_AGMT_SEQ" ).append("\n"); 
		query.append("  FROM ACM_AGN_BKG_INFO A," ).append("\n"); 
		query.append("       ACM_FF_CMPN B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND B.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("   AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}