/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchDelAmsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.22 
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

public class UsaCustomsTransmissionDBDAOsearchDelAmsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchDelAmsRSQL(){
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
		params.put("it_ittype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("booking_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchDelAmsRSQL").append("\n"); 
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
		query.append("SELECT CASE " ).append("\n"); 
		query.append("          WHEN @[it_ittype] IN ('62', '63') THEN" ).append("\n"); 
		query.append("             CASE" ).append("\n"); 
		query.append("                WHEN @[booking_pod_cd] = 'USNYC' THEN" ).append("\n"); 
		query.append("                   (NVL((SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("                           FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                          WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                            AND CSTMS_DIV_ID = 'AMS_TML_CD_MAP'" ).append("\n"); 
		query.append("                            AND ATTR_CTNT1 = (SELECT V.POD_YD_CD" ).append("\n"); 
		query.append("                                               FROM BKG_VVD V," ).append("\n"); 
		query.append("                                                    BKG_BOOKING B" ).append("\n"); 
		query.append("                                              WHERE V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                                AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                                AND V.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                                AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                AND V.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1)), NVL((SELECT NVL(NVL(C.LOC_AMS_PORT_CD, D.LOC_AMS_PORT_CD), DECODE(SUBSTR(B.DEL_CD, 1, 2), 'MX', '20195', 'CA', '13400'))" ).append("\n"); 
		query.append("                                                                        FROM BKG_CSTMS_ADV_BL A," ).append("\n"); 
		query.append("                                                                             BKG_BOOKING B," ).append("\n"); 
		query.append("                                                                             MDM_LOCATION C," ).append("\n"); 
		query.append("                                                                             MDM_LOCATION D" ).append("\n"); 
		query.append("                                                                       WHERE A.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                                                         AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                                                                         AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                                                         AND C.LOC_CD = B.POD_CD" ).append("\n"); 
		query.append("                                                                         AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                                         AND D.LOC_CD(+) = C.SCC_CD" ).append("\n"); 
		query.append("                                                                         AND D.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("                                                                         AND ROWNUM = 1), RPAD(' ', 5, ' '))))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                   NVL((SELECT NVL(NVL(C.LOC_AMS_PORT_CD, D.LOC_AMS_PORT_CD), DECODE(SUBSTR(B.DEL_CD, 1, 2), 'MX', '20195', 'CA', '13400'))" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_BL A," ).append("\n"); 
		query.append("                               BKG_BOOKING B," ).append("\n"); 
		query.append("                               MDM_LOCATION C," ).append("\n"); 
		query.append("                               MDM_LOCATION D" ).append("\n"); 
		query.append("                         WHERE A.CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                           AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                           AND C.LOC_CD = B.POD_CD" ).append("\n"); 
		query.append("                           AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND D.LOC_CD(+) = C.SCC_CD" ).append("\n"); 
		query.append("                           AND D.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1), RPAD(' ', 5, ' '))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("             RPAD(' ', 5, ' ')" ).append("\n"); 
		query.append("       END" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}