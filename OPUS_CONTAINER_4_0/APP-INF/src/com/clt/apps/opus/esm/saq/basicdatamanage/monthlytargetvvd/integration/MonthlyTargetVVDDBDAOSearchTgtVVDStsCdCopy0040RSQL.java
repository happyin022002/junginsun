/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyTargetVVDDBDAOSearchTgtVVDStsCdCopy0040RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.28 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyTargetVVDDBDAOSearchTgtVVDStsCdCopy0040RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public MonthlyTargetVVDDBDAOSearchTgtVVDStsCdCopy0040RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration").append("\n"); 
		query.append("FileName : MonthlyTargetVVDDBDAOSearchTgtVVDStsCdCopy0040RSQL").append("\n"); 
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
		query.append("SELECT TGT_VVD_STS_CD " ).append("\n"); 
		query.append("       , ( SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL       " ).append("\n"); 
		query.append("           WHERE INTG_CD_VAL_CTNT = A.TGT_VVD_STS_CD " ).append("\n"); 
		query.append("                 AND INTG_CD_ID = 'CD01216' ) STS_TEXT 		" ).append("\n"); 
		query.append("FROM SAQ_MON_TGT_VVD A " ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    BSE_YR = @[year] AND " ).append("\n"); 
		query.append("    BSE_QTR_CD = @[quarter] AND " ).append("\n"); 
		query.append("    TRD_CD = @[trade] AND " ).append("\n"); 
		query.append("    DIR_CD = @[bound] AND " ).append("\n"); 
		query.append("    ROWNUM = 1" ).append("\n"); 

	}
}