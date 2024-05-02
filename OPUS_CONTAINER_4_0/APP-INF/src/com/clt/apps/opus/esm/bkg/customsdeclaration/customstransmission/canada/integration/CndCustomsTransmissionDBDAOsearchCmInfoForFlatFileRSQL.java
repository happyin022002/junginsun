/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchCmInfoForFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.12 
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
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
		query.append("SELECT CM.HAMO_CMDT_CD				AS CMCODE" ).append("\n"); 
		query.append("       ,NVL(CM.PCK_QTY, 0)			AS CMPKG" ).append("\n"); 
		query.append("       ,NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_PCK_TP_CONV AA" ).append("\n"); 
		query.append("             WHERE AA.CNT_CD = 'CA'" ).append("\n"); 
		query.append("               AND AA.PCK_TP_CD = CM.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("            ), NVL(CM.AMS_PCK_TP_CD, 'PK')) AS CMPKGU" ).append("\n"); 
		query.append("       ,NVL(CM.GRS_WGT, 0)			AS CMWGT" ).append("\n"); 
		query.append("       ,NVL(SUBSTR(CM.WGT_UT_CD,1,2), 'KG')		AS CMWGTU" ).append("\n"); 
		query.append("       ,DECODE(CM.CGO_DESC, NULL, ' ', BKG_SPCLCHAR_CONV_FNC(CM.CGO_DESC,'M')) AS CMDESC" ).append("\n"); 
		query.append("       ,DG.IMDG_UN_NO				AS CMUNNO" ).append("\n"); 
		query.append("  FROM  BKG_CSTMS_ADV_CNTR_MF CM" ).append("\n"); 
		query.append("       ,(SELECT DG.IMDG_UN_NO" ).append("\n"); 
		query.append("               ,DG.CNTR_NO" ).append("\n"); 
		query.append("               ,DG.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("               ,BL.CNT_CD" ).append("\n"); 
		query.append("               ,BL.BL_NO" ).append("\n"); 
		query.append("           FROM BKG_CSTMS_ADV_BL BL, BKG_DG_CGO DG" ).append("\n"); 
		query.append("          WHERE BL.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("            AND BL.CNT_CD = 'CA'" ).append("\n"); 
		query.append("            AND BL.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("         ) DG" ).append("\n"); 
		query.append(" WHERE  CM.CNT_CD 		= 'CA'" ).append("\n"); 
		query.append("   AND  CM.BL_NO		= @[bl_no]" ).append("\n"); 
		query.append("   AND  CM.CNTR_NO		= @[cntr_no]" ).append("\n"); 
		query.append("   AND  CM.CNT_CD		= DG.CNT_CD(+)" ).append("\n"); 
		query.append("   AND  CM.BL_NO		= DG.BL_NO(+)" ).append("\n"); 
		query.append("   AND  CM.CNTR_NO		= DG.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND  CM.CMDT_GDS_SEQ = DG.CNTR_CGO_SEQ(+)" ).append("\n"); 

	}
}