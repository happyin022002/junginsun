/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchAdjustForOTSDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.03 
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

public class AccountReceivableAdjustDBDAOsearchAdjustForOTSDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Adjust for OTS Detail
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchAdjustForOTSDetailRSQL(){
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
		query.append("FileName : AccountReceivableAdjustDBDAOsearchAdjustForOTSDetailRSQL").append("\n"); 
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
		query.append("SELECT B.RHQ_CD" ).append("\n"); 
		query.append("    , B.OTS_OFC_CD" ).append("\n"); 
		query.append("    , B.BL_NO" ).append("\n"); 
		query.append("    , B.INV_NO" ).append("\n"); 
		query.append("    , B.CURR_CD BL_CURR_CD" ).append("\n"); 
		query.append("    , A.CHG_TP_CD" ).append("\n"); 
		query.append("    , NVL(SUM(A.ADJ_AMT), 0) ADJ_AMT" ).append("\n"); 
		query.append("    , A.UPD_USR_ID" ).append("\n"); 
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
		query.append(")	" ).append("\n"); 
		query.append("	AND A.ADJ_STS_CD = @[sts_cd]" ).append("\n"); 
		query.append("GROUP BY B.RHQ_CD" ).append("\n"); 
		query.append("    , B.OTS_OFC_CD" ).append("\n"); 
		query.append("    , B.BL_NO" ).append("\n"); 
		query.append("    , B.INV_NO" ).append("\n"); 
		query.append("    , B.CURR_CD" ).append("\n"); 
		query.append("    , A.CHG_TP_CD" ).append("\n"); 
		query.append("    , A.UPD_USR_ID" ).append("\n"); 

	}
}