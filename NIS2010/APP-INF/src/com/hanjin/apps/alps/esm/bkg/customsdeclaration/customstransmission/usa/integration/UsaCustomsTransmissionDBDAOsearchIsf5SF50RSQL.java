/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchIsf5SF50RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.28
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.06.28 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchIsf5SF50RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, isf5전송관련, 연관 vo : UsaIsf5ResultVO. vo생성금지.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchIsf5SF50RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchIsf5SF50RSQL").append("\n"); 
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
		query.append("SELECT T1.FPOD" ).append("\n"); 
		query.append("      ,DECODE(ML.LOC_AMS_PORT_CD, NULL, T1.HUB_LOC_CD, T1.DEL) DEL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("		  NVL( DECODE(SUBSTR(IT.POD_CD,1,2), 'US', L2.LOC_AMS_PORT_CD, L1.LOC_AMS_PORT_CD) " ).append("\n"); 
		query.append("                         , CASE WHEN L1.LOC_CHR_CD = 'ECP' AND IT.DEL_CD LIKE 'CA%' THEN '13400'" ).append("\n"); 
		query.append("                                WHEN L1.LOC_CHR_CD = 'WCP' AND IT.DEL_CD LIKE 'CA%' THEN '12200'" ).append("\n"); 
		query.append("                                WHEN L1.LOC_CHR_CD = 'WCP' AND IT.DEL_CD LIKE 'MX%' THEN '12200'" ).append("\n"); 
		query.append("                           ELSE ''" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                         ) FPOD" ).append("\n"); 
		query.append("          ,CASE WHEN L2.UN_LOC_IND_CD = 'Y' THEN L2.LOC_CD" ).append("\n"); 
		query.append("                WHEN ZL.LOC_CD LIKE 'US%'   THEN IT.DEL_CD" ).append("\n"); 
		query.append("                WHEN ZL.UN_LOC_IND_CD = 'Y' THEN ZL.LOC_CD" ).append("\n"); 
		query.append("                ELSE NVL(L2.UN_LOC_CD, IT.DEL_CD)" ).append("\n"); 
		query.append("            END DEL" ).append("\n"); 
		query.append("          , NVL( DECODE(L3.UN_LOC_IND_CD,'Y', L3.LOC_CD, L3.UN_LOC_CD) , IT.HUB_LOC_CD) HUB_LOC_CD" ).append("\n"); 
		query.append("      FROM BKG_CSTMS_ADV_BL IT" ).append("\n"); 
		query.append("          ,MDM_LOCATION L1" ).append("\n"); 
		query.append("          ,MDM_LOCATION L2" ).append("\n"); 
		query.append("          ,MDM_LOCATION L3" ).append("\n"); 
		query.append("          ,MDM_ZONE Z" ).append("\n"); 
		query.append("          ,MDM_LOCATION ZL" ).append("\n"); 
		query.append("     WHERE IT.CNT_CD = 'US'" ).append("\n"); 
		query.append("       AND IT.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND IT.CSTMS_POD_CD = L1.LOC_CD(+)" ).append("\n"); 
		query.append("       AND IT.DEL_CD = L2.LOC_CD(+)" ).append("\n"); 
		query.append("       AND IT.HUB_LOC_CD = L3.LOC_CD(+)" ).append("\n"); 
		query.append("       AND IT.DEL_CD = Z.LOC_CD(+)" ).append("\n"); 
		query.append("       AND SUBSTR(Z.REP_YD_CD, 1, 5) = ZL.LOC_CD(+)" ).append("\n"); 
		query.append("    ) T1" ).append("\n"); 
		query.append("    , MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE T1.DEL = ML.LOC_CD(+)" ).append("\n"); 

	}
}