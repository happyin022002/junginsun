/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseRPListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.04.11 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseRPListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseRPListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mode_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseRPListRSQL").append("\n"); 
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
		query.append("SELECT STK.SO_OFC_CTY_CD AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("STK.SO_SEQ AS SO_SEQ," ).append("\n"); 
		query.append("ORD.EQ_NO AS CNTR_NO" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("MDM_LOCATION ML," ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD ORD," ).append("\n"); 
		query.append("CIM_CNTR_STK STK" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND ORD.TRSP_COST_DTL_MOD_CD = 'ER'" ).append("\n"); 
		query.append("/*********************************/" ).append("\n"); 
		query.append("AND ORD.TRSP_COST_DTL_MOD_CD = 'ER'    /** Carriou **/" ).append("\n"); 
		query.append("AND NVL(ORD.TRSP_SO_CMB_TP_CD,'N') NOT IN ('FF','FM')" ).append("\n"); 
		query.append("--   AND ORD.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("AND ORD.CRE_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND ML.CONTI_CD = 'E'" ).append("\n"); 
		query.append("/*********************************/" ).append("\n"); 
		query.append("AND ORD.TRSP_CRR_MOD_CD = @[mode_cd]" ).append("\n"); 
		query.append("AND ORD.EQ_TPSZ_CD = @[tp]" ).append("\n"); 
		query.append("AND ORD.FM_NOD_CD = @[empty_cy]" ).append("\n"); 
		query.append("AND ORD.FM_NOD_CD = STK.STK_YD_CD" ).append("\n"); 
		query.append("AND ORD.TRSP_WO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("AND STK.SO_OFC_CTY_CD = ORD.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND STK.SO_SEQ = ORD.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND ROWNUM <= @[qty]" ).append("\n"); 
		query.append("AND NVL (ORD.EQ_NO, '1') = NVL (@[cntr_no], '1')" ).append("\n"); 
		query.append("AND ORD.TRSP_WO_OFC_CTY_CD = SUBSTR (@[wo_no], 1, 3)" ).append("\n"); 
		query.append("AND ORD.TRSP_WO_SEQ = SUBSTR (@[wo_no], 4)" ).append("\n"); 
		query.append("AND STK.STK_EVNT_DT = TO_DATE (@[issue_dt], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("AND STK.STK_LOC_CD = SUBSTR (@[empty_cy], 1, 5)" ).append("\n"); 
		query.append("AND STK.STK_YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("AND STK.STK_GATE_IO_CD = @[bd]" ).append("\n"); 
		query.append("AND STK.TRSP_SO_TP_CD = @[type_cd]" ).append("\n"); 
		query.append("AND STK.STL_FLG = 'N'" ).append("\n"); 

	}
}