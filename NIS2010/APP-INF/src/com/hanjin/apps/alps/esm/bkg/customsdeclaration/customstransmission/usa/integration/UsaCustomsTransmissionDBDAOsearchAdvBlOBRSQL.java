/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchAdvBlOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchAdvBlOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWKIM, BKG_CSTMS_ADV_BL조회.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchAdvBlOBRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchAdvBlOBRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      BKG.VSL_CD" ).append("\n"); 
		query.append("      ,NVL(BKG.USA_CSTMS_FILE_CD,'3') AS CSTMS_FILE_TP_CD " ).append("\n"); 
		query.append("      ,'N' FROB_FLG " ).append("\n"); 
		query.append("      , ( SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = DECODE(BKG.BKG_CRE_TP_CD, 'S', BKG.FM_BKG_NO, NULL)) PRE_MF_NO" ).append("\n"); 
		query.append("      ,BKG.BL_NO " ).append("\n"); 
		query.append("      ,BKG.POL_CD" ).append("\n"); 
		query.append("      ,NVL(P.USA_CSTMS_PCK_CD,'PKG') AS AMS_PCK_TP_CD" ).append("\n"); 
		query.append("      ,'US' CNT_CD" ).append("\n"); 
		query.append("      ,NVL(D.WGT_UT_CD,'KGS') AS WGT_UT_CD" ).append("\n"); 
		query.append("      ,VVD.POD_CD CSTMS_POD_CD" ).append("\n"); 
		query.append("      ,BKG.UPD_USR_ID" ).append("\n"); 
		query.append("      ,(SELECT SUBSTR( MIN( LPAD(CLPT_SEQ, 2, 0) ||VPS_PORT_CD) , 3)" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND	SUBSTR(VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                                                                                    WHERE CNT_cD='US'" ).append("\n"); 
		query.append("                                                                                    AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("                                                                        )                             " ).append("\n"); 
		query.append("                     AND VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                     AND SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("       )AS CSTMS_PORT_CD" ).append("\n"); 
		query.append("       ,D.ACT_WGT AS CGO_WGT" ).append("\n"); 
		query.append("       ,CASE WHEN BKG.POD_CD = BKG.DEL_CD THEN BKG.POD_CD ELSE '' END CSTMS_LOC_CD" ).append("\n"); 
		query.append("       , SYSDATE AMDT_SND_DT" ).append("\n"); 
		query.append("      ,BKG.DEL_CD" ).append("\n"); 
		query.append("      ,BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,BKG.POD_CD " ).append("\n"); 
		query.append("      ,C.CA_ISS_DT" ).append("\n"); 
		query.append("      ,BKG.CRE_USR_ID" ).append("\n"); 
		query.append("      ,BKG.BKG_NO" ).append("\n"); 
		query.append("      ,BKG.BKG_CGO_TP_CD FULL_MTY_CD" ).append("\n"); 
		query.append("      ,BKG.POR_CD" ).append("\n"); 
		query.append("      ,VVD.POL_CD CSTMS_POL_CD" ).append("\n"); 
		query.append("	   ,'' AS MF_NO" ).append("\n"); 
		query.append("       ,D.BDR_FLG     " ).append("\n"); 
		query.append("      ,'A' MF_STS_CD " ).append("\n"); 
		query.append("      ,SCAC_CD" ).append("\n"); 
		query.append("       ,SYSDATE MF_SND_DT " ).append("\n"); 
		query.append("       ,D.MEAS_QTY      " ).append("\n"); 
		query.append("       ,D.PCK_QTY" ).append("\n"); 
		query.append("      ,TO_CHAR(D.BDR_DT,'YYYYMMDDHH24MISS') AS BDR_DTBDR_DT" ).append("\n"); 
		query.append("      ,BKG.RCV_TERM_CD" ).append("\n"); 
		query.append("      ,D.MEAS_UT_CD" ).append("\n"); 
		query.append("      ,BKG.UPD_DT" ).append("\n"); 
		query.append("      ,BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,BKG.DE_TERM_CD" ).append("\n"); 
		query.append("      ,BKG.SLAN_CD" ).append("\n"); 
		query.append("      ,C.CA_NO" ).append("\n"); 
		query.append("      ,CASE WHEN BKG.POD_CD = 'USLAX' AND L2.SCC_CD = 'USLGB' THEN L1.SCC_CD" ).append("\n"); 
		query.append("             WHEN BKG.POD_CD = 'USSEA' AND (L2.STE_CD LIKE 'ID%' OR L2.STE_CD LIKE 'MT%') THEN BKG.POD_CD" ).append("\n"); 
		query.append("             WHEN BKG.POD_CD = BKG.DEL_CD THEN BKG.POD_CD" ).append("\n"); 
		query.append("      		 ELSE L2.SCC_CD" ).append("\n"); 
		query.append("       END HUB_LOC_CD" ).append("\n"); 
		query.append("	  ,BKG.POD_CD IBFLAG" ).append("\n"); 
		query.append("	  ,(SELECT ATTR_CTNT2 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("		WHERE CNT_CD='US'" ).append("\n"); 
		query.append("		AND CSTMS_DIV_ID='AMS_TML_CD_MAP'" ).append("\n"); 
		query.append("		AND ATTR_CTNT1= BKG.POL_NOD_CD" ).append("\n"); 
		query.append("		AND ROWNUM=1" ).append("\n"); 
		query.append("		) AMS_TML_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG , BKG_VVD VVD , BKG_BL_DOC D,MDM_PCK_TP P" ).append("\n"); 
		query.append("	,(  SELECT  BKG_NO" ).append("\n"); 
		query.append("	           ,CORR_NO AS CA_NO" ).append("\n"); 
		query.append("        	   ,TO_CHAR(CORR_DT,'YYYYMMDDHH24MISS') AS CA_ISS_DT" ).append("\n"); 
		query.append("        FROM   BKG_CORRECTION" ).append("\n"); 
		query.append("        WHERE  CORR_DT = ( SELECT MAX(CORR_DT)" ).append("\n"); 
		query.append("                           FROM   BKG_CORRECTION" ).append("\n"); 
		query.append("                           WHERE  BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("                             AND  CORR_CXL_FLG = 'N' )" ).append("\n"); 
		query.append("        AND    BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("        AND    CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("     ) C" ).append("\n"); 
		query.append("    ,MDM_LOCATION L1" ).append("\n"); 
		query.append("    ,MDM_LOCATION L2  " ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("    AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("    AND BKG.BKG_NO     = D.BKG_NO(+)     " ).append("\n"); 
		query.append("    AND BKG.BKG_NO     = C.BKG_NO(+)    " ).append("\n"); 
		query.append("    AND D.PCK_TP_CD  = P.PCK_CD(+)" ).append("\n"); 
		query.append("    AND BKG.POD_CD     = L1.LOC_CD" ).append("\n"); 
		query.append("    AND BKG.DEL_CD     = L2.LOC_CD    " ).append("\n"); 
		query.append("    AND VVD.VSL_CD     = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("    AND VVD.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("    AND VVD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 

	}
}