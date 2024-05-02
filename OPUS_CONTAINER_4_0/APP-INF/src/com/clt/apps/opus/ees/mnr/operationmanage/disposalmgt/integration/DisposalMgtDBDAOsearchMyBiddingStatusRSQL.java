/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchMyBiddingStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchMyBiddingStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMyBiddingStatus
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchMyBiddingStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selected_disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchMyBiddingStatusRSQL").append("\n"); 
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
		query.append("SELECT (CASE" ).append("\n"); 
		query.append("            WHEN GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("              BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_ST_DT, @[ofc_cd]) " ).append("\n"); 
		query.append("              AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd])" ).append("\n"); 
		query.append("              AND A.DISP_STS_CD = 'HA' THEN 'O'" ).append("\n"); 
		query.append("            WHEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[ofc_cd], GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), 'GMT') > GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, 'GMT')" ).append("\n"); 
		query.append("              OR A.DISP_STS_CD IN ('HC', 'HE', 'HP') THEN 'C'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       ) AS BIDDING_STATUS" ).append("\n"); 
		query.append("  FROM MNR_DISP_HDR A" ).append("\n"); 
		query.append(" WHERE A.DISP_NO = @[selected_disp_no] " ).append("\n"); 

	}
}