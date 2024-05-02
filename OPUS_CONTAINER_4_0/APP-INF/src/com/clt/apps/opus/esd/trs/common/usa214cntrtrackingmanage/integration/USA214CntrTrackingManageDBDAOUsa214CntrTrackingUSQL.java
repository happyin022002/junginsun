/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USA214CntrTrackingManageDBDAOUsa214CntrTrackingUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.12.02 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.usa214cntrtrackingmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA214CntrTrackingManageDBDAOUsa214CntrTrackingUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Usa210CntrTracking update
	  * </pre>
	  */
	public USA214CntrTrackingManageDBDAOUsa214CntrTrackingUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("de_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.usa214cntrtrackingmanage.integration ").append("\n"); 
		query.append("FileName : USA214CntrTrackingManageDBDAOUsa214CntrTrackingUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD SET" ).append("\n"); 
		query.append("APNT_DT = CASE WHEN APNT_DT IS NULL" ).append("\n"); 
		query.append("#if (${apnt_dt} == '' && ${de_dt} != '')" ).append("\n"); 
		query.append("THEN NVL(TO_DATE(@[de_dt], 'YYYYMMDDHH24MISS'), APNT_DT)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("THEN NVL(TO_DATE(@[apnt_dt], 'YYYYMMDDHH24MISS'), APNT_DT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ELSE NVL(TO_DATE(@[apnt_dt], 'YYYYMMDDHH24MISS'), APNT_DT)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(", DE_DT   = NVL(TO_DATE(@[de_dt], 'YYYYMMDDHH24MISS'), DE_DT)" ).append("\n"); 
		query.append(", EQ_NO   = NVL(@[cntr_no], EQ_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${apnt_dt} == '')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", EDI_RCV_MSG_TP_CD   = '214'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = SUBSTR (@[so_no],1,3)" ).append("\n"); 
		query.append("AND TRSP_SO_SEQ          = SUBSTR (@[so_no],4)" ).append("\n"); 
		query.append("AND TRSP_WO_SEQ  IS NOT NULL" ).append("\n"); 

	}
}