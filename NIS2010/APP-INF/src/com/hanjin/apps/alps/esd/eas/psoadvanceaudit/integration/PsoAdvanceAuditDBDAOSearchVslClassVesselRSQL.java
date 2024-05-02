/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOSearchVslClassVesselRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.06.17 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOSearchVslClassVesselRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PsoAdvanceAuditDBDAOSearchVslClassVessel 
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOSearchVslClassVesselRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contractType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vesselClass",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOSearchVslClassVesselRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD, VSL_ENG_NM AS VSL_NM" ).append("\n"); 
		query.append(",CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("  FROM MDM_VSL_CNTR AA" ).append("\n"); 
		query.append("     , (SELECT MAX(FM_CD_CAL) AS FM_CD_CAL" ).append("\n"); 
		query.append("             , MAX(TO_CD_CAL) AS TO_CD_CAL" ).append("\n"); 
		query.append("          FROM (SELECT CASE WHEN A.INTG_CD_VAL_DP_SEQ =B.CD_SEQ-1 THEN INTG_CD_VAL_CTNT ELSE '0' END FM_CD_CAL" ).append("\n"); 
		query.append("                     , CASE WHEN A.INTG_CD_VAL_DP_SEQ =B.CD_SEQ THEN INTG_CD_VAL_CTNT ELSE '0' END TO_CD_CAL" ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("                     , (SELECT INTG_CD_ID,INTG_CD_VAL_DP_SEQ AS CD_SEQ" ).append("\n"); 
		query.append("                          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                         WHERE 1=1 " ).append("\n"); 
		query.append("                           AND INTG_CD_ID ='CD03434'" ).append("\n"); 
		query.append("                           AND INTG_CD_VAL_CTNT =  @[vesselClass]" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.INTG_CD_ID = B.INTG_CD_ID" ).append("\n"); 
		query.append("                   AND A.INTG_CD_VAL_DP_SEQ BETWEEN B.CD_SEQ-1 AND B.CD_SEQ" ).append("\n"); 
		query.append("              )      " ).append("\n"); 
		query.append("       )BB" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if ( ${contractType} !='' && ${contractType} != 'ALL')" ).append("\n"); 
		query.append("   AND VSL_CD IN (SELECT VSL_CD FROM FMS_CONTRACT WHERE FLET_CTRT_TP_CD IN (@[contractType]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND CNTR_VSL_CLSS_CAPA  BETWEEN BB.FM_CD_CAL AND BB.TO_CD_CAL" ).append("\n"); 

	}
}