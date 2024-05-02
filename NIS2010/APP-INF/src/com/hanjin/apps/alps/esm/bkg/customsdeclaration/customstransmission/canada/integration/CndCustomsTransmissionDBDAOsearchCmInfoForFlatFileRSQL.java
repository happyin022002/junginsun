/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchCmInfoForFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.22 
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

public class CndCustomsTransmissionDBDAOsearchCmInfoForFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCmInfoForFlatFile
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchCmInfoForFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchCmInfoForFlatFileRSQL").append("\n"); 
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
		query.append("SELECT  NVL(CM.PCK_QTY, 0)			AS CMPKG" ).append("\n"); 
		query.append("       ,NVL(CM.AMS_PCK_TP_CD, 'PK')	AS CMPKGU" ).append("\n"); 
		query.append("       ,NVL(CM.GRS_WGT, 0)			AS CMWGT" ).append("\n"); 
		query.append("       ,NVL(SUBSTR(CM.WGT_UT_CD,1,2), 'KG')		AS CMWGTU" ).append("\n"); 
		query.append("       ,DECODE(NVL(BKG_SPCLCHAR_CONV_FNC(CM.CGO_DESC,'S'),' '),' ',Translate(NVL(BKG_SPCLCHAR_CONV_FNC(CM.CGO_DESC,'S'),' '),CHR(13)||CHR(10),' '), Translate(NVL(BKG_SPCLCHAR_CONV_FNC(CM.CGO_DESC,'S'),' '),CHR(13)||CHR(10),' '))" ).append("\n"); 
		query.append("		AS CMDESC" ).append("\n"); 
		query.append("       ,DECODE( BKG.DCGO_FLG, 'Y', ( /* CM 탭의 DG 정보를 정확히 입력하지 않으므로, BCM.DCGO_SEQ가 없으면 Container 것을 참조 한다 */" ).append("\n"); 
		query.append("                                       SELECT SUBSTR(MIN(   DECODE(BCM.DCGO_SEQ,    NULL,'1', '0')" ).append("\n"); 
		query.append("                                                         || DECODE(DG.CNTR_CGO_SEQ, NULL,'00',LPAD(DG.CNTR_CGO_SEQ,2,'0'))" ).append("\n"); 
		query.append("                                                         || DG.IMDG_UN_NO),4)" ).append("\n"); 
		query.append("                                         FROM BKG_CNTR_MF_DESC BCM" ).append("\n"); 
		query.append("                                            , BKG_DG_CGO       DG" ).append("\n"); 
		query.append("                                        WHERE 1 = 1" ).append("\n"); 
		query.append("                                          AND BCM.BKG_NO           = ABL.BKG_NO " ).append("\n"); 
		query.append("                                          AND BCM.CNTR_NO          = CM.CNTR_NO " ).append("\n"); 
		query.append("                                          AND BCM.CNTR_MF_SEQ      = CM.CMDT_GDS_SEQ  " ).append("\n"); 
		query.append("                                          AND DG.BKG_NO            = BCM.BKG_NO" ).append("\n"); 
		query.append("                                          AND DG.CNTR_NO           = BCM.CNTR_NO " ).append("\n"); 
		query.append("                                          AND NVL(BCM.DCGO_SEQ, 0) = DECODE(BCM.DCGO_SEQ, NULL,0,DG.DCGO_SEQ)" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                 ) AS CMUNNO" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL      ABL" ).append("\n"); 
		query.append("     , BKG_CSTMS_ADV_CNTR_MF CM" ).append("\n"); 
		query.append("     , BKG_BOOKING           BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE ABL.CNT_CD = 'CA'" ).append("\n"); 
		query.append("   AND ABL.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("   AND CM.BL_NO		= ABL.BL_NO" ).append("\n"); 
		query.append("   AND CM.CNTR_NO	= @[cntr_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = ABL.BKG_NO" ).append("\n"); 

	}
}