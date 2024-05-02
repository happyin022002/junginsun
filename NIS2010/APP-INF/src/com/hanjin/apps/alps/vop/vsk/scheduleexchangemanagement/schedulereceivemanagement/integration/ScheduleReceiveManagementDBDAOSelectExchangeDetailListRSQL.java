/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleReceiveManagementDBDAOSelectExchangeDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleReceiveManagementDBDAOSelectExchangeDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exchange Detail List 조회
	  * </pre>
	  */
	public ScheduleReceiveManagementDBDAOSelectExchangeDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration").append("\n"); 
		query.append("FileName : ScheduleReceiveManagementDBDAOSelectExchangeDetailListRSQL").append("\n"); 
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
		query.append("SELECT    	D.SND_RCV_KND_CD" ).append("\n"); 
		query.append("      ,    	D.SKD_EDI_RCV_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  ,		(SELECT VS.VSL_SLAN_CD FROM VSK_VSL_SKD VS WHERE VS.VSL_CD = D.VSL_CD_CTNT AND VS.SKD_VOY_NO = D.SKD_VOY_NO_CTNT AND VS.SKD_DIR_CD = D.SKD_DIR_CD_CTNT)" ).append("\n"); 
		query.append("			AS VSL_SLAN_CD_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,    	D.VSL_CD_CTNT" ).append("\n"); 
		query.append("      ,    	D.SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("      ,    	D.SKD_DIR_CD_CTNT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,    	D.SKD_EDI_RCV_SEQ" ).append("\n"); 
		query.append("      ,    	D.EDI_XCH_LOG_SEQ" ).append("\n"); 
		query.append("      ,    	PS.VPS_PORT_CD								AS VPS_PORT_CD_CTNT" ).append("\n"); 
		query.append("      ,    	D.VPS_PORT_NM" ).append("\n"); 
		query.append("      ,    	D.YD_CD_CTNT" ).append("\n"); 
		query.append("      ,    	D.CLPT_IND_SEQ_CTNT" ).append("\n"); 
		query.append("      ,    	D.CLPT_SEQ_CTNT" ).append("\n"); 
		query.append("      ,    	D.LOC_IND_CD_CTNT" ).append("\n"); 
		query.append("      ,    	D.CALL_YD_IND_SEQ_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,     TO_CHAR(PS.VPS_ETA_DT,'YYYYMMDDHH24MI')   	AS CST_ETA_DT" ).append("\n"); 
		query.append("      ,     TO_CHAR(PS.VPS_ETB_DT,'YYYYMMDDHH24MI')   	AS CST_ETB_DT" ).append("\n"); 
		query.append("      ,     TO_CHAR(PS.VPS_ETD_DT,'YYYYMMDDHH24MI')   	AS CST_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,      CASE WHEN D.VPS_ETA_DT_CTNT IS NULL THEN TO_CHAR(PS.VPS_ETA_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                  ELSE TO_CHAR(TO_DATE(D.VPS_ETA_DT_CTNT,'YYYYMMDDHH24MI') ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("             END  VPS_ETA_DT_CTNT" ).append("\n"); 
		query.append("      ,      CASE WHEN D.VPS_ETB_DT_CTNT IS NULL THEN TO_CHAR(PS.VPS_ETB_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                  ELSE TO_CHAR(TO_DATE(D.VPS_ETB_DT_CTNT,'YYYYMMDDHH24MI') ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("             END  VPS_ETB_DT_CTNT" ).append("\n"); 
		query.append("      ,      CASE WHEN D.VPS_ETD_DT_CTNT IS NULL THEN TO_CHAR(PS.VPS_ETD_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                  ELSE TO_CHAR(TO_DATE(D.VPS_ETD_DT_CTNT,'YYYYMMDDHH24MI') ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("             END  VPS_ETD_DT_CTNT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,    	D.ACT_ARR_DT_CTNT" ).append("\n"); 
		query.append("      ,    	D.ACT_BRTH_DT_CTNT" ).append("\n"); 
		query.append("      ,    	D.ACT_DEP_DT_CTNT" ).append("\n"); 
		query.append("      ,    	D.TURN_PORT_FLG_CTNT" ).append("\n"); 
		query.append("      ,    	D.TURN_PORT_IND_CD_CTNT" ).append("\n"); 
		query.append("      ,    	D.TURN_SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("      ,    	D.TURN_SKD_DIR_CD_CTNT" ).append("\n"); 
		query.append("      ,    	D.TURN_CLPT_IND_SEQ_CTNT" ).append("\n"); 
		query.append("      ,    	D.CRE_USR_ID" ).append("\n"); 
		query.append("      ,    	D.CRE_DT" ).append("\n"); 
		query.append("      ,    	PS.UPD_USR_ID" ).append("\n"); 
		query.append("      ,    	TO_CHAR(PS.UPD_DT,'YYYYMMDDHH24MISS')	AS UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ------- ::2014-04-14::----------------------------------------------------------------" ).append("\n"); 
		query.append("      ,     PS.CLPT_SEQ" ).append("\n"); 
		query.append("      ,     PS.YD_CD" ).append("\n"); 
		query.append("      ,     PS.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("      ,     SUBSTR(PS.YD_CD,6,2)					AS TML_CD" ).append("\n"); 
		query.append("      ,     PS.TURN_PORT_FLG" ).append("\n"); 
		query.append("      ,     PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("      ,     PS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("      ,     PS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,     PS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM      	VSK_VSL_SKD_XCH_EDI_DTL  	D" ).append("\n"); 
		query.append("      ,   	VSK_VSL_PORT_SKD         	PS" ).append("\n"); 
		query.append("WHERE     	1 = 1" ).append("\n"); 
		query.append("AND       	PS.VSL_CD                	= D.VSL_CD_CTNT" ).append("\n"); 
		query.append("AND       	PS.SKD_VOY_NO            	= D.SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("AND       	PS.SKD_DIR_CD            	= D.SKD_DIR_CD_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND       	PS.VPS_PORT_CD           	= D.VPS_PORT_CD_CTNT" ).append("\n"); 
		query.append("AND         DECODE(PS.VPS_PORT_CD,'USLGB','0','USLAX','0',PS.VPS_PORT_CD)" ).append("\n"); 
		query.append("                                       = DECODE(D.VPS_PORT_CD_CTNT,'USLGB','0','USLAX','0',D.VPS_PORT_CD_CTNT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       	PS.CLPT_IND_SEQ          	= '1'" ).append("\n"); 
		query.append("AND       	D.SND_RCV_KND_CD        	= 'R'" ).append("\n"); 
		query.append("AND       	D.SKD_EDI_RCV_SEQ       	= @[skd_edi_rcv_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}