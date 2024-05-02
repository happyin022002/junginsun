/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchEmlNtfcW01InfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.13
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.10.13 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchEmlNtfcW01InfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchEmlNtfcW01InfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reason",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchEmlNtfcW01InfoRSQL").append("\n"); 
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
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("SELECT '03' AS EML_TYPE" ).append("\n"); 
		query.append("      ,(SELECT S.CUST_NM" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_CUST S" ).append("\n"); 
		query.append("         WHERE S.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("           AND S.BL_NO  = B.BL_NO" ).append("\n"); 
		query.append("           AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("       ) AS SHIPPER" ).append("\n"); 
		query.append("      ,(SELECT S.CUST_NM" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_CUST S" ).append("\n"); 
		query.append("         WHERE S.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("           AND S.BL_NO  = B.BL_NO" ).append("\n"); 
		query.append("           AND S.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("       ) AS CONSIGNEE" ).append("\n"); 
		query.append("      ,@[reason] AS REASON" ).append("\n"); 
		query.append("      ,B.CSTMS_POL_CD" ).append("\n"); 
		query.append("      ,B.CSTMS_POD_CD" ).append("\n"); 
		query.append("      ,B.BL_NO" ).append("\n"); 
		query.append("      ,(SELECT USR_EML" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_SND_LOG     AA" ).append("\n"); 
		query.append("              ,COM_USER                  BB" ).append("\n"); 
		query.append("         WHERE AA.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND AA.CRR_BAT_NO = @[crr_bat_no]" ).append("\n"); 
		query.append("           AND AA.CRE_USR_ID = BB.USR_ID" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS USR_EML" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append(" WHERE B.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT DECODE(B.BL_NO, NULL, '11', '03') AS EML_TYPE" ).append("\n"); 
		query.append("      ,(SELECT S.CUST_NM" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_CUST S" ).append("\n"); 
		query.append("         WHERE S.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("           AND S.BL_NO  = B.BL_NO" ).append("\n"); 
		query.append("           AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("       ) AS SHIPPER" ).append("\n"); 
		query.append("      ,(SELECT S.CUST_NM" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_CUST S" ).append("\n"); 
		query.append("         WHERE S.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("           AND S.BL_NO  = B.BL_NO" ).append("\n"); 
		query.append("           AND S.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("       ) AS CONSIGNEE" ).append("\n"); 
		query.append("      ,@[reason] AS REASON" ).append("\n"); 
		query.append("      ,NVL(B.CSTMS_POL_CD, A.POL_CD) AS CSTMS_POL_CD" ).append("\n"); 
		query.append("      ,NVL(B.CSTMS_POD_CD, A.POD_CD) AS CSTMS_POD_CD" ).append("\n"); 
		query.append("      ,B.BL_NO" ).append("\n"); 
		query.append("      ,(SELECT USR_EML" ).append("\n"); 
		query.append("          FROM COM_USER                  BB" ).append("\n"); 
		query.append("         WHERE A.CRE_USR_ID = BB.USR_ID" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS USR_EML" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_SND_LOG     A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL          B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_EDI_BL_RSPN C" ).append("\n"); 
		query.append(" WHERE A.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND A.CRR_BAT_NO = @[crr_bat_no]" ).append("\n"); 
		query.append("   AND A.CRR_BAT_NO = C.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("   AND A.CNT_CD     = C.CNT_CD(+)" ).append("\n"); 
		query.append("   AND C.CNT_CD     = B.CNT_CD(+)" ).append("\n"); 
		query.append("   AND C.BL_NO      = B.BL_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}