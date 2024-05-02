/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOgetContainerYardNotLikeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOgetContainerYardNotLikeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOgetContainerYardNotLikeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration").append("\n"); 
		query.append("FileName : ContainerMovementValidationDBDAOgetContainerYardNotLikeRSQL").append("\n"); 
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
		query.append("SELECT A.CNTR_NO," ).append("\n"); 
		query.append("       A.CNMV_STS_CD," ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.CRNT_YD_CD," ).append("\n"); 
		query.append("       A.ACIAC_DIV_CD," ).append("\n"); 
		query.append("       A.CO_CRE_FLG," ).append("\n"); 
		query.append("       A.IMDT_EXT_FLG," ).append("\n"); 
		query.append("       A.NEW_FLG," ).append("\n"); 
		query.append("       DECODE (B.CNTR_NO, NULL, 0, 1) CNTR_EX," ).append("\n"); 
		query.append("	   A.FCNTR_FLG," ).append("\n"); 
		query.append("       A.LSTM_CD," ).append("\n"); 
		query.append("       A.DMG_FLG" ).append("\n"); 
		query.append("  FROM (SELECT MM.CNTR_NO," ).append("\n"); 
		query.append("               MM.CNMV_STS_CD," ).append("\n"); 
		query.append("               MM.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               MM.CRNT_YD_CD," ).append("\n"); 
		query.append("               MM.ACIAC_DIV_CD," ).append("\n"); 
		query.append("               MM.CO_CRE_FLG," ).append("\n"); 
		query.append("               MM.IMDT_EXT_FLG," ).append("\n"); 
		query.append("               MM.NEW_FLG," ).append("\n"); 
		query.append("               MM.FCNTR_FLG," ).append("\n"); 
		query.append("               MM.LSTM_CD," ).append("\n"); 
		query.append("               MM.DMG_FLG" ).append("\n"); 
		query.append("          FROM (SELECT M.CNTR_NO," ).append("\n"); 
		query.append("                       M.CNMV_STS_CD," ).append("\n"); 
		query.append("                       M.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       M.CRNT_YD_CD," ).append("\n"); 
		query.append("                       M.ACIAC_DIV_CD," ).append("\n"); 
		query.append("                       CASE WHEN SYS_AREA_GRP_ID = RGN_CD THEN 'Y' ELSE 'N' END AS CO_CRE_FLG," ).append("\n"); 
		query.append("                       M.IMDT_EXT_FLG," ).append("\n"); 
		query.append("                       M.CO_CRE_FLG AS NEW_FLG," ).append("\n"); 
		query.append("                       M.FULL_FLG AS FCNTR_FLG," ).append("\n"); 
		query.append("                       M.LSTM_CD," ).append("\n"); 
		query.append("                       M.DMG_FLG" ).append("\n"); 
		query.append("                  FROM MST_CONTAINER M," ).append("\n"); 
		query.append("                       (SELECT SYS_AREA_GRP_ID AS RGN_CD" ).append("\n"); 
		query.append("                          FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                         WHERE CNT_CD = SUBSTR (@[yard_cd], 1, 2)" ).append("\n"); 
		query.append("                           AND CO_IND_CD = 'H')" ).append("\n"); 
		query.append("                 WHERE M.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("              ORDER BY CNMV_DT DESC) MM" ).append("\n"); 
		query.append("         WHERE ROWNUM = 1) A," ).append("\n"); 
		query.append("       (SELECT CNTR_NO" ).append("\n"); 
		query.append("          FROM (SELECT CNTR_NO" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                 WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("              ORDER BY CNMV_EVNT_DT DESC)" ).append("\n"); 
		query.append("         WHERE ROWNUM = 1) B" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}