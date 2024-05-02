/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL
	  * </pre>
	  */
	public UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL(){
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
		params.put("tmpstr4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL").append("\n"); 
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
		query.append("SELECT RPAD('ACR' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || RPAD(' ', 6, ' ') || 'HI', 80, ' ')||CHR(10)||" ).append("\n"); 
		query.append("	   RPAD('M01' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || '10'||" ).append("\n"); 
		query.append("	        RPAD(@[vsl_flag],2,' ')||" ).append("\n"); 
		query.append("	        RPAD(' ', 23, ' ')||" ).append("\n"); 
		query.append("	        NVL((SELECT CASE WHEN TO_DATE(ATTR_CTNT1,'YYYYMMDDHH24MISS') > SYSDATE" ).append("\n"); 
		query.append("                             THEN SUBSTR(@[vvd], 6, 4) || ' '" ).append("\n"); 
		query.append("                             ELSE SUBSTR(@[vvd], 5, 5)" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                   FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                  WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                    AND CSTMS_DIV_ID = 'US_M01_VOY_NO'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                ), SUBSTR(@[vvd], 5, 5))||" ).append("\n"); 
		query.append("	        RPAD(' ', 5, ' ') || '000001' || ' ' ||@[vsl_lloyd],80,' ')||CHR(10)||" ).append("\n"); 
		query.append("       RPAD('M02'||@[crr_bat_no], 80, ' ')||CHR(10) ||" ).append("\n"); 
		query.append("	   RPAD('P01'||RPAD(@[tmpstr4],4,' ')||RPAD(@[vps_eta_dt],6,' ')||LPAD(' ',5,' '), 80, ' ')||CHR(10)" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}