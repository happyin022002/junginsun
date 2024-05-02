/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchAdjustForOTSHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOsearchAdjustForOTSHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Adjust for OTS History
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchAdjustForOTSHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchAdjustForOTSHistoryRSQL").append("\n"); 
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
		query.append("SELECT B.IF_NO" ).append("\n"); 
		query.append("    , B.RHQ_CD" ).append("\n"); 
		query.append("    , B.OTS_OFC_CD" ).append("\n"); 
		query.append("    , B.BL_NO" ).append("\n"); 
		query.append("    , B.INV_NO" ).append("\n"); 
		query.append("    , B.CURR_CD" ).append("\n"); 
		query.append("    , CASE WHEN A.ADJ_STS_CD = 'ADJUST' AND (A.ADJ_TP_CD = 'OFF' OR A.ADJ_TP_CD = 'OFFC') THEN 'OFF'" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'REVERSE' AND (A.ADJ_TP_CD = 'OFF' OR A.ADJ_TP_CD = 'OFFC') THEN 'OFFR'" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'ADJUST' AND (A.ADJ_TP_CD = 'AGT' OR A.ADJ_TP_CD = 'AGC') THEN 'AGT'" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'ADJUST' THEN 'ADJ'" ).append("\n"); 
		query.append("           ELSE 'ADJR'" ).append("\n"); 
		query.append("      END OTS_HIS_TP_CD" ).append("\n"); 
		query.append("	, A.ADJ_NO REF_NO" ).append("\n"); 
		query.append("    , B.OTS_SRC_CD" ).append("\n"); 
		query.append("    , A.ADJ_GL_DT GL_DT" ).append("\n"); 
		query.append("    , NVL(SUM(A.ADJ_AMT), 0) OTS_AMT" ).append("\n"); 
		query.append("    , A.ADJ_OFC_CD INV_OFC_CD" ).append("\n"); 
		query.append("    , CASE WHEN A.ADJ_STS_CD = 'ADJUST' AND (A.ADJ_TP_CD = 'OFF' OR A.ADJ_TP_CD = 'OFFC') THEN A.ADJ_RMK" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'REVERSE' AND (A.ADJ_TP_CD = 'OFF' OR A.ADJ_TP_CD = 'OFFC') THEN A.ADJ_RMK" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'ADJUST' AND (A.ADJ_TP_CD = 'AGT' OR A.ADJ_TP_CD = 'AGC') THEN B.OTS_RMK" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'ADJUST' THEN A.ADJ_RMK" ).append("\n"); 
		query.append("           ELSE A.ADJ_RMK" ).append("\n"); 
		query.append("      END AS OTS_RMK" ).append("\n"); 
		query.append("    , A.CRE_USR_ID" ).append("\n"); 
		query.append("    , A.UPD_USR_ID" ).append("\n"); 
		query.append("    , B.SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , B.SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , B.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , B.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , B.VSL_CD" ).append("\n"); 
		query.append("    , B.SKD_VOY_NO" ).append("\n"); 
		query.append("    , B.DIR_CD" ).append("\n"); 
		query.append("    , B.SVC_SCP_CD" ).append("\n"); 
		query.append("    , B.XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , B.LOCL_XCH_RT" ).append("\n"); 
		query.append("    , B.USD_XCH_RT" ).append("\n"); 
		query.append("    , B.BKG_IO_BND_CD" ).append("\n"); 
		query.append("    , B.XCH_RT_DT" ).append("\n"); 
		query.append("    , B.POL_CD" ).append("\n"); 
		query.append("    , B.POD_CD " ).append("\n"); 
		query.append("	, B.REV_TP_SRC_CD" ).append("\n"); 
		query.append("	, B.REV_VVD_CD   " ).append("\n"); 
		query.append("FROM SAR_ADJ_HIS A," ).append("\n"); 
		query.append("     SAR_OTS_HIS B" ).append("\n"); 
		query.append("WHERE A.OTS_HIS_SEQ = B.OTS_HIS_SEQ" ).append("\n"); 
		query.append("	AND A.ADJ_NO IN (" ).append("\n"); 
		query.append("#foreach( $key IN ${adj_no_list}) " ).append("\n"); 
		query.append("	#if($velocityCount < $adj_no_list.size())" ).append("\n"); 
		query.append("  		'$key'," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		'$key'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("	AND A.ADJ_STS_CD = @[sts_cd]" ).append("\n"); 
		query.append("GROUP BY B.IF_NO" ).append("\n"); 
		query.append("    , B.RHQ_CD" ).append("\n"); 
		query.append("    , B.OTS_OFC_CD" ).append("\n"); 
		query.append("    , B.BL_NO" ).append("\n"); 
		query.append("    , B.INV_NO" ).append("\n"); 
		query.append("    , B.CURR_CD" ).append("\n"); 
		query.append("    , CASE WHEN A.ADJ_STS_CD = 'ADJUST' AND (A.ADJ_TP_CD = 'OFF' OR A.ADJ_TP_CD = 'OFFC') THEN 'OFF'" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'REVERSE' AND (A.ADJ_TP_CD = 'OFF' OR A.ADJ_TP_CD = 'OFFC') THEN 'OFFR'" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'ADJUST' AND (A.ADJ_TP_CD = 'AGT' OR A.ADJ_TP_CD = 'AGC') THEN 'AGT'" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'ADJUST' THEN 'ADJ'" ).append("\n"); 
		query.append("           ELSE 'ADJR'" ).append("\n"); 
		query.append("      END" ).append("\n"); 
		query.append("	, A.ADJ_NO" ).append("\n"); 
		query.append("    , B.OTS_SRC_CD" ).append("\n"); 
		query.append("    , A.ADJ_GL_DT" ).append("\n"); 
		query.append("    , A.ADJ_OFC_CD" ).append("\n"); 
		query.append("    , CASE WHEN A.ADJ_STS_CD = 'ADJUST' AND (A.ADJ_TP_CD = 'OFF' OR A.ADJ_TP_CD = 'OFFC') THEN A.ADJ_RMK" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'REVERSE' AND (A.ADJ_TP_CD = 'OFF' OR A.ADJ_TP_CD = 'OFFC') THEN A.ADJ_RMK" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'ADJUST' AND (A.ADJ_TP_CD = 'AGT' OR A.ADJ_TP_CD = 'AGC') THEN B.OTS_RMK" ).append("\n"); 
		query.append("           WHEN A.ADJ_STS_CD = 'ADJUST' THEN A.ADJ_RMK" ).append("\n"); 
		query.append("           ELSE A.ADJ_RMK" ).append("\n"); 
		query.append("      END" ).append("\n"); 
		query.append("    , A.CRE_USR_ID" ).append("\n"); 
		query.append("    , A.UPD_USR_ID" ).append("\n"); 
		query.append("    , B.SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , B.SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , B.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , B.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , B.VSL_CD" ).append("\n"); 
		query.append("    , B.SKD_VOY_NO" ).append("\n"); 
		query.append("    , B.DIR_CD" ).append("\n"); 
		query.append("    , B.SVC_SCP_CD" ).append("\n"); 
		query.append("    , B.XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , B.LOCL_XCH_RT" ).append("\n"); 
		query.append("    , B.USD_XCH_RT" ).append("\n"); 
		query.append("    , B.BKG_IO_BND_CD" ).append("\n"); 
		query.append("    , B.XCH_RT_DT" ).append("\n"); 
		query.append("    , B.POL_CD" ).append("\n"); 
		query.append("    , B.POD_CD" ).append("\n"); 
		query.append("    , B.OTS_HIS_SEQ" ).append("\n"); 
		query.append("	, B.REV_TP_SRC_CD" ).append("\n"); 
		query.append("	, B.REV_VVD_CD  " ).append("\n"); 
		query.append("ORDER BY B.OTS_HIS_SEQ" ).append("\n"); 

	}
}