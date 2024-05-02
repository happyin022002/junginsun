/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchAmsCodeByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.29 
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

public class UsaCustomsTransmissionDBDAOsearchAmsCodeByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchAmsCodeByVvdRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchAmsCodeByVvdRSQL").append("\n"); 
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
		query.append("SELECT CASE" ).append("\n"); 
		query.append("          WHEN @[loc_cd] = 'USNYC' THEN" ).append("\n"); 
		query.append("             (NVL((SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                    WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                      AND CSTMS_DIV_ID = 'AMS_TML_CD_MAP'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT1 = (SELECT V.POD_YD_CD" ).append("\n"); 
		query.append("                                               FROM BKG_VVD V" ).append("\n"); 
		query.append("                                        #if (${bl_no} != '')" ).append("\n"); 
		query.append("                                                    ,BKG_BOOKING B" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                              WHERE V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                                AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                                AND V.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                        #if (${bl_no} != '')" ).append("\n"); 
		query.append("                                                AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                                AND V.POD_CD = @[loc_cd]" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1)), (SELECT LOC_AMS_PORT_CD" ).append("\n"); 
		query.append("                                                                     FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                                    WHERE LOC_CD = @[loc_cd])))" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             (SELECT LOC_AMS_PORT_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("               WHERE LOC_CD = @[loc_cd])" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}