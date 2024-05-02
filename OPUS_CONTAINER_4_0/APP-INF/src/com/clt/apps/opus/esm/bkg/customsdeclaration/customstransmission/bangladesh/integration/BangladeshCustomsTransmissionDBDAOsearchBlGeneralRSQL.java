/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BangladeshCustomsTransmissionDBDAOsearchBlGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.06
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.09.06 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshCustomsTransmissionDBDAOsearchBlGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 방글라데시 세관 신고용 Manifest B/L General 정보를 조회한다.
	  * </pre>
	  */
	public BangladeshCustomsTransmissionDBDAOsearchBlGeneralRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration").append("\n"); 
		query.append("FileName : BangladeshCustomsTransmissionDBDAOsearchBlGeneralRSQL").append("\n"); 
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
		query.append("SELECT '{BL_INFO'||CHR(10)||" ).append("\n"); 
		query.append("       'BLNBR:'||COM_ConstantMgr_PKG.COM_getScacCode_FNC()||NVL(BKG.BL_NO,' ')||DECODE(NVL(BKG.BL_TP_CD,' '),'S',' ','W',' ',NVL(BKG.BL_TP_CD,' '))||CHR(10)||" ).append("\n"); 
		query.append("       'LINE_NO:'||NVL(BD.BL_LINE_NO,'')||CHR(10)||" ).append("\n"); 
		query.append("       'BL_TYPE:'||NVL(DECODE(BD.HBL_FLG,'1','MSB','0','HSB',''),DECODE(HBL.BKG_NO,NULL,'MSB','HSB'))||CHR(10)||" ).append("\n"); 
		query.append("       'CONSOL_CG_IND:'||DECODE(BKG.DE_TERM_CD, 'S', '1'," ).append("\n"); 
		query.append("       DECODE((SELECT 'X' FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("                    WHERE BC.CNTR_PRT_FLG = 'Y'" ).append("\n"); 
		query.append("                      AND BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      AND ROWNUM =1), 'X', '1', '0'))||CHR(10)||" ).append("\n"); 
		query.append("       'DG_IND:'||DECODE(BKG.DCGO_FLG, 'Y', 'Yes', ' ')||CHR(10)||" ).append("\n"); 
		query.append("       'BLPOL:'||@[pol_cd]||CHR(10)||" ).append("\n"); 
		query.append("       'BLPOD:'||NVL(BKG.POD_CD, ' ')||CHR(10)||" ).append("\n"); 
		query.append("       'SHPR1:'||SCE_TOKEN_NL_FNC(BCS.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("       'SHPR2:'||SCE_TOKEN_NL_FNC(BCS.CUST_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("       'SHPR3:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("       'SHPR4:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("       'SHPR5:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("       'CNEE_CD:'||(SELECT NVL(CNEE_LIC_NO, '')" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_BD_CNTR" ).append("\n"); 
		query.append("                     WHERE BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("                       AND CNEE_LIC_NO IS NOT NULL" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)||CHR(10)||" ).append("\n"); 
		query.append("       'CNEE1:'||SCE_TOKEN_NL_FNC(BCC.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("       'CNEE2:'||SCE_TOKEN_NL_FNC(BCC.CUST_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("       'CNEE3:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("       'CNEE4:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("       'CNEE5:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("       'NTFY_CD:'||(SELECT NVL(NTFY_LIC_NO, '')" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_BD_CNTR" ).append("\n"); 
		query.append("                     WHERE BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("                       AND NTFY_LIC_NO IS NOT NULL" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)||CHR(10)||" ).append("\n"); 
		query.append("       'NTFY1:'||SCE_TOKEN_NL_FNC(BCN.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("       'NTFY2:'||SCE_TOKEN_NL_FNC(BCN.CUST_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("       'NTFY3:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("       'NTFY4:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("       'NTFY5:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("       'BLPKG:'||BDC.PCK_QTY||CHR(10)||" ).append("\n"); 
		query.append("       'BLPKGU:'||NVL(CNV.CSTMS_PCK_TP_CD, BDC.PCK_TP_CD)||CHR(10)||" ).append("\n"); 
		query.append("       'BLWGT:'||BDC.ACT_WGT||CHR(10)||" ).append("\n"); 
		query.append("       'BLMEA:'||BDC.MEAS_QTY||CHR(10)||" ).append("\n"); 
		query.append("       'BL_REMARK:'||(SELECT NVL(BIL_RMK, '')" ).append("\n"); 
		query.append("                        FROM BKG_CSTMS_BD_CNTR" ).append("\n"); 
		query.append("                       WHERE BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("                         AND BIL_RMK IS NOT NULL" ).append("\n"); 
		query.append("                         AND ROWNUM = 1)||CHR(10)  bl_desc" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_CUSTOMER BCC," ).append("\n"); 
		query.append("       BKG_CUSTOMER BCS," ).append("\n"); 
		query.append("       BKG_CUSTOMER BCN," ).append("\n"); 
		query.append("       BKG_BL_DOC BDC," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV CNV" ).append("\n"); 
		query.append("       ,BKG_CSTMS_BD_CNTR BD" ).append("\n"); 
		query.append("       ,BKG_HBL HBL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.BKG_NO=BCC.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BL_NO = BD.BL_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = HBL.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND BKG.BKG_NO=BCS.BKG_NO" ).append("\n"); 
		query.append("   AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND BKG.BKG_NO=BCN.BKG_NO" ).append("\n"); 
		query.append("   AND BCN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = BDC.BKG_NO" ).append("\n"); 
		query.append("   AND BDC.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND CNV.CNT_CD(+) = 'BD'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}