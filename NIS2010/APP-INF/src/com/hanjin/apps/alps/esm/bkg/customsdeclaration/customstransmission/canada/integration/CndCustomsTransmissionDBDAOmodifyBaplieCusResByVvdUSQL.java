/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOmodifyBaplieCusResByVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOmodifyBaplieCusResByVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOmodifyBaplieCusResByVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOmodifyBaplieCusResByVvdUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_STWG_CNTR" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("     RSPN_MSG_RCV_DT = TO_DATE(@[rcv_dt],'RRMMDDHH24MISS')" ).append("\n"); 
		query.append("    ,RSPN_ERR_RSLT_CD ='A'" ).append("\n"); 
		query.append("    ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("    AND STWG_SND_ID LIKE NVL(TO_CHAR( TO_DATE(SUBSTR(@[crr_bat_no],4,6) ,'YYMMDD'), 'YYMMDD'), ' ')||'%'||NVL(SUBSTR(@[crr_bat_no],10), ' ')" ).append("\n"); 
		query.append("    AND (RSPN_MSG_RCV_DT IS NULL OR TO_DATE( @[rcv_dt] ,'RRMMDDHH24MISS') <> RSPN_MSG_RCV_DT )" ).append("\n"); 

	}
}