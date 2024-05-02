/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.17 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchEtaRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(TO_CHAR(MAX(VPS_ETA_DT),'MMDDRR'),' ') MAX_MMDDRR," ).append("\n"); 
		query.append("NVL(TO_CHAR(MAX(DECODE(VPS_ETB_DT,NULL,VPS_ETA_DT,VPS_ETB_DT)),'RRMMDDHH24MISS'),' ') MAX_RRMMDDH," ).append("\n"); 
		query.append("NVL(TO_CHAR(MIN(DECODE(VPS_ETB_DT,NULL,VPS_ETA_DT,VPS_ETB_DT)),'RRMMDDHH24MISS'),' ') MIN_RRMMDDH," ).append("\n"); 
		query.append("NVL(TO_CHAR(NEW_TIME(GLOBALDATE_PKG.TIME_CONV_FNC(@[pod],MAX(VPS_ETD_DT), 'GMT'),'GMT','EDT'),'RRMMDDHH24MI'),' ') MAX_ETD_RMDHM," ).append("\n"); 
		query.append("NVL(TO_CHAR(MAX(VPS_ETA_DT),'ddMonrr', 'NLS_DATE_LANGUAGE=AMERICAN'),' ') MAX_ETA_DDMONRR," ).append("\n"); 
		query.append("NVL(TO_CHAR(MAX(VPS_ETD_DT),'ddMonrr', 'NLS_DATE_LANGUAGE=AMERICAN'),' ') MAX_ETD_DDMONRR," ).append("\n"); 
		query.append("NVL(TO_CHAR(MAX(DECODE(VPS_ETB_DT,NULL,VPS_ETA_DT,VPS_ETB_DT)), 'YYYYMMDD HH24:MI'),' ') ymd_vps_eta_dt" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("VSL_CD		= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO	= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD	= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 

	}
}