/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOsearchShipChsMovementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.31
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.31 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOsearchShipChsMovementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Shipper's Chassis의 Movement 관리현황을 조회합니다.
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOsearchShipChsMovementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOsearchShipChsMovementListRSQL").append("\n"); 
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
		query.append("SELECT  ROW_SEQ, CHSS_NO, MVMT_DT, YD_CD, LOC_CD, GATE_IO_CD," ).append("\n"); 
		query.append("        SYS_SEQ_01, CNTR_NO_01, SYS_SEQ_02, CNTR_NO_02, CNT_SEQ, LST_SEQ" ).append("\n"); 
		query.append("FROM   (SELECT  ROW_NUMBER() OVER(ORDER BY A.CHSS_NO, A.MVMT_DT, A.YD_CD) AS ROW_SEQ," ).append("\n"); 
		query.append("				A.CHSS_NO, A.MVMT_DT, A.YD_CD, A.LOC_CD, A.GATE_IO_CD," ).append("\n"); 
		query.append("                MAX(CASE WHEN A.SYS_SEQ = B.FST_SEQ THEN A.SYS_SEQ END) SYS_SEQ_01," ).append("\n"); 
		query.append("                MAX(CASE WHEN A.SYS_SEQ = B.FST_SEQ THEN A.CNTR_NO END) CNTR_NO_01," ).append("\n"); 
		query.append("                MAX(CASE WHEN A.SYS_SEQ > B.FST_SEQ THEN A.SYS_SEQ END) SYS_SEQ_02,                  " ).append("\n"); 
		query.append("                MAX(CASE WHEN A.SYS_SEQ > B.FST_SEQ THEN A.CNTR_NO END) CNTR_NO_02," ).append("\n"); 
		query.append("                MAX(B.CNT_SEQ) AS CNT_SEQ, MAX(B.LST_SEQ) AS LST_SEQ " ).append("\n"); 
		query.append("        FROM    CGM_CHSS_MVMT_HIS A,          " ).append("\n"); 
		query.append("               (SELECT  CHSS_NO, MVMT_DT, COUNT(*) AS CNT_SEQ," ).append("\n"); 
		query.append("                        MIN(SYS_SEQ) AS FST_SEQ, MAX(SYS_SEQ) AS LST_SEQ                      " ).append("\n"); 
		query.append("                FROM    CGM_CHSS_MVMT_HIS" ).append("\n"); 
		query.append("                WHERE   CHSS_OWNR_CO_CD = 'O'" ).append("\n"); 
		query.append("        #if ( ${p_chss_no} != '' )" ).append("\n"); 
		query.append("                AND     CHSS_NO = @[p_chss_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if ( ${p_mvmt_dt} != '' )" ).append("\n"); 
		query.append("                AND     MVMT_DT BETWEEN TO_DATE(@[p_mvmt_dt],'YYYYMMDD') AND TO_DATE(@[p_mvmt_dt],'YYYYMMDD') +0.999999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if ( ${p_loc_cd} != '' )" ).append("\n"); 
		query.append("                AND     LOC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if ( ${p_yd_cd} != '' )" ).append("\n"); 
		query.append("                AND     YD_CD = @[p_yd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                GROUP BY CHSS_NO, MVMT_DT, YD_CD, LOC_CD, GATE_IO_CD                                " ).append("\n"); 
		query.append("                ) B" ).append("\n"); 
		query.append("        WHERE   A.CHSS_NO = B.CHSS_NO " ).append("\n"); 
		query.append("        AND     A.MVMT_DT = B.MVMT_DT" ).append("\n"); 
		query.append("        AND     A.SYS_SEQ IN(B.FST_SEQ, B.LST_SEQ)" ).append("\n"); 
		query.append("        GROUP BY A.CHSS_NO, A.MVMT_DT, A.YD_CD, A.LOC_CD, A.GATE_IO_CD" ).append("\n"); 
		query.append("        ORDER BY A.CHSS_NO, A.MVMT_DT, A.YD_CD)" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("WHERE 	ROW_SEQ BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 

	}
}