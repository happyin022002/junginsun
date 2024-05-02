/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : RepairMgtDBDAOsearchEQWorkOrderHistoryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
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
		query.append("SELECT   TO_CHAR(OM.MNR_INP_DT,'YYYY-MM-DD') AS RQST_DT" ).append("\n"); 
		query.append("       , OM.COST_OFC_CD" ).append("\n"); 
		query.append("       , CASE WHEN EM.MNR_ORD_SEQ IS NOT NULL THEN 'Repair' ELSE 'Simple' END RPR" ).append("\n"); 
		query.append("       , MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("       , EM.RQST_REF_NO AS EST_NO" ).append("\n"); 
		query.append("       , OM.MNR_ORD_OFC_CTY_CD || OM.MNR_ORD_SEQ AS WO_NO" ).append("\n"); 
		query.append("       , OD.YD_CD" ).append("\n"); 
		query.append("       , TO_CHAR(OD.RPR_RSLT_DT,'YYYY-MM-DD') AS RPR_RSLT_DT" ).append("\n"); 
		query.append("       , OM.CURR_CD" ).append("\n"); 
		query.append("       , OD.COST_AMT" ).append("\n"); 
		query.append("       , EM.RPR_STS_CD" ).append("\n"); 
		query.append("       , EM.RQST_EQ_NO" ).append("\n"); 
		query.append("       , EM.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , OD.ORD_DTL_SEQ" ).append("\n"); 
		query.append("FROM     MNR_ORD_HDR OM" ).append("\n"); 
		query.append("       , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("       , MNR_RPR_RQST_HDR EM" ).append("\n"); 
		query.append("       , MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      OM.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND      OM.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND      OM.MNR_ORD_OFC_CTY_CD  = EM.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND      OM.MNR_ORD_SEQ = EM.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("AND      OM.VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("AND      OM.MNR_INP_DT BETWEEN TO_DATE(@[fm_mnr_inp_dt],'YYYY-MM-DD') AND TO_DATE(@[to_mnr_inp_dt],'YYYY-MM-DD')+ 0.99999" ).append("\n"); 
		query.append("AND      OD.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#if (${mnr_wo_tp_cd} != '')" ).append("\n"); 
		query.append("AND	     OM.MNR_WO_TP_CD = @[mnr_wo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RQST_DT DESC" ).append("\n"); 

	}
}