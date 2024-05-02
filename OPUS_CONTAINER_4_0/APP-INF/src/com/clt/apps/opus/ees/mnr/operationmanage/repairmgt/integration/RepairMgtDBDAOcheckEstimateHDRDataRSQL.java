/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtDBDAOcheckEstimateHDRDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.08.18 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOcheckEstimateHDRDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkEstimateHDRData
	  * </pre>
	  */
	public RepairMgtDBDAOcheckEstimateHDRDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOcheckEstimateHDRDataRSQL").append("\n"); 
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
		query.append("SELECT C.RQST_EQ_NO,C.RPR_RQST_SEQ,C.RPR_RQST_VER_NO,D.RPR_STS_CD,D.COST_OFC_CD FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.RQST_EQ_NO,A.RPR_RQST_SEQ,MAX(A.RPR_RQST_VER_NO) AS RPR_RQST_VER_NO" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR A" ).append("\n"); 
		query.append("WHERE A.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND A.RPR_RQST_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(B.RPR_RQST_SEQ)" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR B" ).append("\n"); 
		query.append("WHERE B.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY A.RQST_EQ_NO,A.RPR_RQST_SEQ" ).append("\n"); 
		query.append(") C,MNR_RPR_RQST_HDR D" ).append("\n"); 
		query.append("WHERE C.RQST_EQ_NO = D.RQST_EQ_NO" ).append("\n"); 
		query.append("AND   C.RPR_RQST_SEQ = D.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND   C.RPR_RQST_VER_NO = D.RPR_RQST_VER_NO" ).append("\n"); 

	}
}