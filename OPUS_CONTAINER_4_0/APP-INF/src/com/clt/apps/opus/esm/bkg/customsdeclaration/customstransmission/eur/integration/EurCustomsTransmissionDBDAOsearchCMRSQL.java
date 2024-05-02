/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchCMRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.05 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchCMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cm 정보를 조회한다.
	  * 1. 2011.01.11 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *    : MRN ITEM 정보를 추가함 (BKG_CSTMS_EUR_CNTR_MF_SND.MF_ITM_NO)
	  * 2011.03.03 김영철 [CHM-201109060] Desc 값에 Tab, Enter 값을 공백으로 치완
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchCMRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("receiver_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchCMRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("         A.CMDT_HS_CD D_CMDT" ).append("\n"); 
		query.append("        ,NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_PCK_TP_CONV AA" ).append("\n"); 
		query.append("             WHERE AA.CNT_CD = 'EU'" ).append("\n"); 
		query.append("               AND AA.RCVR_ID = DECODE(@[receiver_id], 'IMP', 'IMP', 'EU')" ).append("\n"); 
		query.append("               AND AA.PCK_TP_CD = A.PCK_TP_CD" ).append("\n"); 
		query.append("           ),A.PCK_TP_CD) AS D_PUNIT" ).append("\n"); 
		query.append("        ,(SELECT PCK_NM " ).append("\n"); 
		query.append("            FROM MDM_PCK_TP " ).append("\n"); 
		query.append("           WHERE PCK_CD = NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("                                 FROM BKG_CSTMS_PCK_TP_CONV AA" ).append("\n"); 
		query.append("                                WHERE AA.CNT_CD = 'EU'" ).append("\n"); 
		query.append("                                  AND AA.RCVR_ID = DECODE(@[receiver_id], 'IMP', 'IMP', 'EU')" ).append("\n"); 
		query.append("                                  AND AA.PCK_TP_CD = A.PCK_TP_CD" ).append("\n"); 
		query.append("                              ),A.PCK_TP_CD)" ).append("\n"); 
		query.append("         ) AS D_PUNIT_DESC" ).append("\n"); 
		query.append("        ,A.PCK_QTY D_PKG" ).append("\n"); 
		query.append("        ,DECODE(NVL(A.WGT_UT_CD,' '),'LBS',ROUND(NVL(A.CNTR_MF_WGT,0)*0.4536,3),NVL(A.CNTR_MF_WGT,0)) D_WGT" ).append("\n"); 
		query.append("        ,DECODE(NVL(A.MEAS_UT_CD,' '),'CBF',ROUND(NVL(A.MEAS_QTY,0)*0.0283,3),NVL(A.MEAS_QTY,0))D_MEAS" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(BKG_SPCLCHAR_CONV_FNC(A.CNTR_MF_GDS_DESC, 'X'),CHR(9),''),CHR(13),'') D_DESC" ).append("\n"); 
		query.append("        ,DECODE(A.CNTR_MF_MK_DESC, NULL, TO_CLOB('')," ).append("\n"); 
		query.append("               'D_MARK:' || REPLACE(REPLACE(TO_CLOB(A.CNTR_MF_MK_DESC), CHR(13)||CHR(10), CHR(10)), CHR(10), CHR(10)||'D_MARK:')) D_MARK" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("            SELECT MAX(C_SND.MF_ITM_NO)" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_EUR_CNTR_MF_SND C_SND" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND C_SND.BL_NO = (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = A.BKG_NO)" ).append("\n"); 
		query.append("            AND C_SND.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("            AND C_SND.CNTR_CGO_SEQ = A.CNTR_MF_SEQ " ).append("\n"); 
		query.append("            AND C_SND.VSL_CD > ' '" ).append("\n"); 
		query.append("            AND C_SND.SKD_VOY_NO > ' '" ).append("\n"); 
		query.append("            AND C_SND.SKD_DIR_CD > ' '   " ).append("\n"); 
		query.append("            AND C_SND.CSTMS_PORT_CD > ' ' " ).append("\n"); 
		query.append("            AND C_SND.EDI_SND_SEQ = (" ).append("\n"); 
		query.append("                                    SELECT MAX(C_SND.EDI_SND_SEQ)" ).append("\n"); 
		query.append("                                    FROM BKG_CSTMS_EUR_CNTR_MF_SND C_SND" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                    AND C_SND.BL_NO = (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = A.BKG_NO)" ).append("\n"); 
		query.append("                                    AND C_SND.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                                    AND C_SND.CNTR_CGO_SEQ = A.CNTR_MF_SEQ " ).append("\n"); 
		query.append("                                    AND C_SND.VSL_CD > ' '" ).append("\n"); 
		query.append("                                    AND C_SND.SKD_VOY_NO > ' '" ).append("\n"); 
		query.append("                                    AND C_SND.SKD_DIR_CD > ' '   " ).append("\n"); 
		query.append("                                    AND C_SND.CSTMS_PORT_CD > ' ' " ).append("\n"); 
		query.append("                                    AND C_SND.EDI_SND_SEQ > 0                    " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("         ) AS MF_ITM_NO" ).append("\n"); 
		query.append("		 ,HAMO_TRF_CD D_HTS_CD" ).append("\n"); 
		query.append("		 ,CMDT_HS_CD D_HS_CD" ).append("\n"); 
		query.append("         ,NCM_NO D_NCM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM  BKG_CNTR_MF_DESC A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.BKG_NO         =   @[bkg_no]" ).append("\n"); 
		query.append("   AND A.CNTR_NO        =   @[cntr_cd]" ).append("\n"); 
		query.append("   AND A.CNTR_MF_SEQ > 0" ).append("\n"); 

	}
}