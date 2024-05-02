/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL(){
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
		params.put("loc_amsport",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lloyd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchMiHiHeaderFooterRSQL").append("\n"); 
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
		query.append("SELECT RPAD('ACR' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || RPAD(' ', 6, ' ') || @[trsp_msg_tp_cd], 80, ' ') || CHR(10) AS ACR" ).append("\n"); 
		query.append("--NYK : VESSEL NAME 삭제요청, VOY NO 5자리 -> 4자리" ).append("\n"); 
		query.append("      ,RPAD('M01' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || '10'|| @[vsl_flag] || RPAD(' ', 23, ' ')" ).append("\n"); 
		query.append("       || NVL((SELECT CASE WHEN TO_DATE(ATTR_CTNT1,'YYYYMMDDHH24MISS') > SYSDATE" ).append("\n"); 
		query.append("                           THEN SUBSTR(@[vvd], 6, 4) || ' '" ).append("\n"); 
		query.append("                           ELSE SUBSTR(@[vvd], 5, 5)" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                  AND CSTMS_DIV_ID = 'US_M01_VOY_NO'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1" ).append("\n"); 
		query.append("              ), SUBSTR(@[vvd], 5, 5))" ).append("\n"); 
		query.append("       || RPAD(' ', 5, ' ') || '000001' || ' ' || @[vsl_lloyd], 80, ' ') || CHR(10) AS M01" ).append("\n"); 
		query.append("      ,RPAD('M02' || @[crr_bat_no], 80, ' ') || CHR(10) AS M02" ).append("\n"); 
		query.append("      ,RPAD('P01' || SUBSTR(@[loc_amsport], 1, 4) || SUBSTR(@[vps_eta_dt], 1, 6) ||LPAD(' ',5,' '), 80, ' ') || CHR(10) AS P01" ).append("\n"); 
		query.append("      ,RPAD('J01' || COM_ConstantMgr_PKG.COM_getScacCode_FNC(), 80, ' ') || CHR(10) AS J01" ).append("\n"); 
		query.append("      ,RPAD('ZCR' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || RPAD(' ', 6, ' ') || @[trsp_msg_tp_cd] || RPAD(' ', 19, ' ') || '#####' ,80,' ') AS ZCR" ).append("\n"); 
		query.append("      ,'' AS HEADER" ).append("\n"); 
		query.append("      ,'' AS FOOTER" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}