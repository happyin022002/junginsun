/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtDBDAOsearchEQWorkOrderHistoryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.12.09 박명신
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

public class RepairMgtDBDAOsearchEQWorkOrderHistoryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * work order history 조회
	  * </pre>
	  */
	public RepairMgtDBDAOsearchEQWorkOrderHistoryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mnr_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mnr_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_wo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchEQWorkOrderHistoryListDataRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(C.RQST_DT,'YYYY-MM-DD') AS RQST_DT," ).append("\n"); 
		query.append("A.COST_OFC_CD," ).append("\n"); 
		query.append("'REPAIR' RPR," ).append("\n"); 
		query.append("D.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("C.RQST_REF_NO AS EST_NO," ).append("\n"); 
		query.append("A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ AS WO_NO," ).append("\n"); 
		query.append("B.YD_CD," ).append("\n"); 
		query.append("TO_CHAR(B.RPR_RSLT_DT,'YYYY-MM-DD') AS RPR_RSLT_DT," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("B.COST_AMT," ).append("\n"); 
		query.append("C.RPR_STS_CD" ).append("\n"); 
		query.append("FROM  MNR_ORD_HDR A, MNR_ORD_DTL B, MNR_RPR_RQST_HDR C, MDM_VENDOR D" ).append("\n"); 
		query.append("WHERE B.MNR_ORD_OFC_CTY_CD = A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   B.MNR_ORD_SEQ = A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   C.MNR_ORD_OFC_CTY_CD  = A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   C.MNR_ORD_SEQ = A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("AND   C.RQST_DT BETWEEN TO_DATE(@[fm_mnr_inp_dt],'YYYY-MM-DD') AND TO_DATE(@[to_mnr_inp_dt],'YYYY-MM-DD')+ 0.99999" ).append("\n"); 
		query.append("AND   B.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#if (${mnr_wo_tp_cd} != '')" ).append("\n"); 
		query.append("AND	  A.MNR_WO_TP_CD = @[mnr_wo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RQST_DT DESC" ).append("\n"); 

	}
}