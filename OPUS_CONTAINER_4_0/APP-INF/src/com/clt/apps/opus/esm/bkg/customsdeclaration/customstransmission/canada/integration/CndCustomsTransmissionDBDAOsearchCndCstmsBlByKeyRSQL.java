/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchCndCstmsBlByKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchCndCstmsBlByKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndCstmsBlByKey
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchCndCstmsBlByKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchCndCstmsBlByKeyRSQL").append("\n"); 
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
		query.append("SELECT BL_NO" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,CSTMS_POL_CD" ).append("\n"); 
		query.append("      ,CSTMS_POD_CD" ).append("\n"); 
		query.append("      ,(SELECT OFC_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION M" ).append("\n"); 
		query.append("         WHERE A.OBL_ISS_OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("       ) AS OFC_ENG_NM" ).append("\n"); 
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
		query.append("      ,B.CSTMS_ACK_PROC_RSLT_CD" ).append("\n"); 
		query.append("      ,(SELECT DISTINCT FIRST_VALUE(RCV.CND_ACK_SUB_CD) OVER(ORDER BY RCV.RCV_DT DESC)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RCV_LOG RCV  " ).append("\n"); 
		query.append("         WHERE RCV.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("           AND RCV.CND_ACK_SUB_CD IN ('21','37')" ).append("\n"); 
		query.append("           AND RCV.BL_NO(+) = B.BL_NO) AS LAST_ACK" ).append("\n"); 
		query.append("      ,'' AS REASON" ).append("\n"); 
		query.append("      ,'' AS CNTR_NO" ).append("\n"); 
		query.append("  FROM BKG_BL_ISS       A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND B.CSTMS_ACK_KEY_NO = @[cstms_bat_no]" ).append("\n"); 
		query.append("   AND B.CNT_CD = 'CA'" ).append("\n"); 

	}
}