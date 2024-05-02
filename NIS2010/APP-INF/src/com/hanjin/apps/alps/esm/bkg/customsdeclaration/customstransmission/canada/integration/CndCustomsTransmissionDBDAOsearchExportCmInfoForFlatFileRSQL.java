/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchExportCmInfoForFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
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

public class CndCustomsTransmissionDBDAOsearchExportCmInfoForFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchExportCmInfoForFlatFileRSQL(){
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
		query.append("FileName : CndCustomsTransmissionDBDAOsearchExportCmInfoForFlatFileRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     CMPKG" ).append("\n"); 
		query.append("    ,CMPKGU" ).append("\n"); 
		query.append("    ,CMWGT" ).append("\n"); 
		query.append("    ,CMWGTU" ).append("\n"); 
		query.append("    ,CMDESC" ).append("\n"); 
		query.append("    ,DG.IMDG_UN_NO AS CMUNNO    " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT NVL(M.PCK_QTY,0) AS CMPKG       " ).append("\n"); 
		query.append("           ,NVL(P.USA_CSTMS_PCK_CD,'PK') AS CMPKGU " ).append("\n"); 
		query.append("           ,NVL(M.CNTR_MF_WGT, 0)			AS CMWGT       " ).append("\n"); 
		query.append("           ,NVL(M.WGT_UT_CD,'KG') AS CMWGTU" ).append("\n"); 
		query.append("           ,DECODE(NVL(BKG_SPCLCHAR_CONV_FNC(M.CNTR_MF_GDS_DESC,'S'),' '),' ',Translate(NVL(BKG_SPCLCHAR_CONV_FNC(M.CNTR_MF_GDS_DESC,'S'),' '),CHR(13)||CHR(10),' '), Translate(NVL(BKG_SPCLCHAR_CONV_FNC(M.CNTR_MF_GDS_DESC,'S'),' '),CHR(13)||CHR(10),' ')) AS CMDESC" ).append("\n"); 
		query.append("           ,M.CNTR_MF_NO" ).append("\n"); 
		query.append("           ,M.BKG_NO" ).append("\n"); 
		query.append("           ,M.CNTR_NO" ).append("\n"); 
		query.append("           ,M.CNTR_MF_SEQ" ).append("\n"); 
		query.append("      FROM  BKG_CNTR_MF_DESC M" ).append("\n"); 
		query.append("           ,BKG_BL_DOC D" ).append("\n"); 
		query.append("           ,MDM_PCK_TP P" ).append("\n"); 
		query.append("     WHERE  M.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("       AND  D.PCK_TP_CD = P.PCK_CD(+)" ).append("\n"); 
		query.append("       AND  D.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND  M.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(") X , BKG_DG_CGO DG" ).append("\n"); 
		query.append("WHERE X.BKG_NO		= DG.BKG_NO(+)" ).append("\n"); 
		query.append("AND  X.CNTR_NO		= DG.CNTR_NO(+)" ).append("\n"); 
		query.append("AND  X.CNTR_MF_SEQ = DG.CNTR_CGO_SEQ(+)    " ).append("\n"); 
		query.append("#if (${mbl_no} != '') " ).append("\n"); 
		query.append("   AND  X.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 

	}
}