/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchIsf5InfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.13 
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

public class UsaCustomsTransmissionDBDAOsearchIsf5InfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Isf5Info
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchIsf5InfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("isf_act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchIsf5InfoRSQL").append("\n"); 
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
		query.append("SELECT TB.ISF_ACT_CD" ).append("\n"); 
		query.append("      ,DECODE(TB.ISF_ACT_CD, 'A', '', TB.CSTMS_RMK3) AS CSTMS_RMK3" ).append("\n"); 
		query.append("      ,TB.MBL_NO" ).append("\n"); 
		query.append("      ,TB.MH" ).append("\n"); 
		query.append("      ,TB.BL_NO" ).append("\n"); 
		query.append("      ,SUBSTR(NVL(MF.HAMO_CMDT_CD,' '), 1, 6) AS HAMO_CMDT_CD" ).append("\n"); 
		query.append("      ,MF.CNTR_NO" ).append("\n"); 
		query.append("      ,COUNT(DISTINCT MF.CNTR_NO) OVER() AS CNTR_CNT" ).append("\n"); 
		query.append("      ,TB.CSTMS_PORT_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT CASE WHEN @[isf_act_cd] IS NOT NULL THEN @[isf_act_cd]" ).append("\n"); 
		query.append("		            WHEN STWG.STWG_CNT = 1 THEN 'A' --마지막이 DELETE 전송의 경우" ).append("\n"); 
		query.append("		            WHEN RSLT.RSLT_CNT < 1 THEN 'A' --수신 ACCEPT 된게 없는경우" ).append("\n"); 
		query.append("		            WHEN BL.MF_STS_CD = 'D' THEN 'D'" ).append("\n"); 
		query.append("		            ELSE 'R' END ISF_ACT_CD" ).append("\n"); 
		query.append("		      ,RSLT.CSTMS_RMK3 AS CSTMS_RMK3" ).append("\n"); 
		query.append("              ,BL.MF_NO AS MBL_NO" ).append("\n"); 
		query.append("              ,DECODE(BL.MF_NO, NULL, 'M', 'H') AS MH" ).append("\n"); 
		query.append("              ,BL.BL_NO" ).append("\n"); 
		query.append("			  ,BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("		  FROM (" ).append("\n"); 
		query.append("		        SELECT COUNT(*) AS RSLT_CNT," ).append("\n"); 
		query.append("                       MAX((SELECT /*+INDEX_DESC( A XPKBKG_CSTMS_ADV_RSLT) */ " ).append("\n"); 
		query.append("                                  A.CSTMS_RMK3" ).append("\n"); 
		query.append("                            FROM BKG_CSTMS_ADV_RSLT A" ).append("\n"); 
		query.append("		                    WHERE A.CNT_CD = 'US'" ).append("\n"); 
		query.append("		                    AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		                    AND A.DSPO_CD = 'SN'" ).append("\n"); 
		query.append("		                    AND TRIM(A.CSTMS_RMK3) IS NOT NULL" ).append("\n"); 
		query.append("                            AND ROWNUM = 1)) AS CSTMS_RMK3 " ).append("\n"); 
		query.append("		          FROM BKG_CSTMS_ADV_RSLT" ).append("\n"); 
		query.append("		         WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("		           AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		           AND DSPO_CD = 'SN'" ).append("\n"); 
		query.append("		           AND TRIM(CSTMS_RMK3) IS NOT NULL" ).append("\n"); 
		query.append("		           AND ROWNUM = 1" ).append("\n"); 
		query.append("		       ) RSLT" ).append("\n"); 
		query.append("		      ,(" ).append("\n"); 
		query.append("		        SELECT COUNT(*) AS STWG_CNT" ).append("\n"); 
		query.append("		          FROM BKG_CSTMS_ADV_STWG_SND_LOG" ).append("\n"); 
		query.append("		         WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		           AND ISF_ACT_CD = 'D'" ).append("\n"); 
		query.append("		           AND TRIM(ISF_RMK) = 'ISF DELETED'" ).append("\n"); 
		query.append("		           AND STWG_SND_ID = (SELECT MAX(STWG_SND_ID) FROM BKG_CSTMS_ADV_STWG_SND_LOG WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("		           AND ROWNUM = 1" ).append("\n"); 
		query.append("		       ) STWG" ).append("\n"); 
		query.append("		      ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("		 WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("		   AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       ) TB" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CNTR_MF MF" ).append("\n"); 
		query.append(" WHERE TB.BL_NO = MF.BL_NO(+)" ).append("\n"); 
		query.append("   AND MF.CNT_CD(+) = 'US'" ).append("\n"); 

	}
}