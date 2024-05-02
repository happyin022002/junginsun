/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArgCustomsTransmissionDBDAOsearchTransmitCmListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArgCustomsTransmissionDBDAOsearchTransmitCmListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTransmitCmList
	  * </pre>
	  */
	public ArgCustomsTransmissionDBDAOsearchTransmitCmListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.integration").append("\n"); 
		query.append("FileName : ArgCustomsTransmissionDBDAOsearchTransmitCmListRSQL").append("\n"); 
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
		query.append("SELECT CM.PCK_QTY          AS CM_PKG" ).append("\n"); 
		query.append("      ,NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_PCK_TP_CONV AA" ).append("\n"); 
		query.append("             WHERE AA.CNT_CD = 'AR'" ).append("\n"); 
		query.append("               AND AA.PCK_TP_CD = CM.PCK_TP_CD" ).append("\n"); 
		query.append("           ),CM.PCK_TP_CD) AS CM_PKGU" ).append("\n"); 
		query.append("      ,CM.CNTR_MF_WGT      AS CM_WGT" ).append("\n"); 
		query.append("      ,CM.WGT_UT_CD        AS CM_WGT_UNIT" ).append("\n"); 
		query.append("      ,CM.CMDT_HS_CD       AS CM_HSCODE" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_TOKEN_NL_FNC(CM.CNTR_MF_GDS_DESC,0, ''), 1, 80)  AS CM_DESC" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_TOKEN_NL_FNC(CM.CNTR_MF_MK_DESC, 0, ''), 1, 100) AS CM_MARKNO" ).append("\n"); 
		query.append("      ,CNT.CNTR_NO         AS CM_CNTRNBR" ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(CNT.CNTR_TPSZ_CD, 2, 1), '2', '20', '40') AS CM_CNTRSIZE" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("      ,BKG_CONTAINER CNT" ).append("\n"); 
		query.append(" WHERE CM.CNTR_NO(+) = CNT.CNTR_NO" ).append("\n"); 
		query.append("   AND CM.BKG_NO(+) = CNT.BKG_NO" ).append("\n"); 
		query.append("   AND CNT.BKG_NO  = @[bkg_no]" ).append("\n"); 

	}
}