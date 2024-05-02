/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArgCustomsTransmissionDBDAOsearchTransmitBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.05.20 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArgCustomsTransmissionDBDAOsearchTransmitBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTransmitBlInfo
	  * </pre>
	  */
	public ArgCustomsTransmissionDBDAOsearchTransmitBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mode_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.integration").append("\n"); 
		query.append("FileName : ArgCustomsTransmissionDBDAOsearchTransmitBlInfoRSQL").append("\n"); 
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
		query.append("SELECT VVD.VSL_CD                      AS VSL_CODE" ).append("\n"); 
		query.append("      ,VSL.VSL_ENG_NM                  AS VSL_NAME" ).append("\n"); 
		query.append("      ,VSL.VSL_RGST_CNT_CD             AS VSL_NATION_CD" ).append("\n"); 
		query.append("      ,DECODE(@[mode_type], 'O', 'E', 'I') AS EX_IND" ).append("\n"); 
		query.append("      ,DECODE(@[mode_type], 'I', VVD.POD_YD_CD, VVD.POL_YD_CD) AS TERMINAL_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(SKD.VPS_ETA_DT,'YYYYMMDD') AS ETA" ).append("\n"); 
		query.append("      ,TO_CHAR(SKD.VPS_ETD_DT,'YYYYMMDD') AS ETD" ).append("\n"); 
		query.append("      ,BKG.BL_NO                       AS BLNBR" ).append("\n"); 
		query.append("      ,BKG.POL_CD                      AS BLPOL" ).append("\n"); 
		query.append("      ,BKG.POD_CD                      AS BLPOD" ).append("\n"); 
		query.append("      ,BKG.RCV_TERM_CD || BKG.DE_TERM_CD AS RD_TERM" ).append("\n"); 
		query.append("      ,VVD.POL_CD                      AS VSPOL" ).append("\n"); 
		query.append("      ,VVD.POD_CD                      AS VSPOD" ).append("\n"); 
		query.append("      ,DECODE(BKG.KR_CSTMS_CUST_TP_CD, 'C', 'Y', 'N') AS CONSOLIDATE_IND" ).append("\n"); 
		query.append("#if (${mode_type} == 'I')" ).append("\n"); 
		query.append("      ,(SELECT DECODE(IN_TZ_FLG,'S','Y','Y','Y','N','N')" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_ARG_BL" ).append("\n"); 
		query.append("        WHERE BL_NO = @[bl_no]) AS TR_IND" ).append("\n"); 
		query.append("      ,(SELECT SUBSTR(VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("           AND CLPT_SEQ = (SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                             FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                            WHERE VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                              AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("                              AND SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("                              AND VPS_PORT_CD NOT LIKE 'AR%'" ).append("\n"); 
		query.append("                              AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                              AND CLPT_SEQ < (SELECT CLPT_SEQ" ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                               WHERE VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                                                 AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                 AND SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                 AND VPS_PORT_CD = VVD.POD_CD" ).append("\n"); 
		query.append("                                                 AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS FOREIGN_NATION_CD" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("      ,(SELECT DECODE(IN_TZ_FLG,'S','Y','Y','Y','N','N')" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_ARG_BL" ).append("\n"); 
		query.append("        WHERE BL_NO = @[bl_no]) AS TR_IND" ).append("\n"); 
		query.append("      ,(SELECT SUBSTR(VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("           AND CLPT_SEQ = (SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                             FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                            WHERE VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                              AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("                              AND SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("                              AND VPS_PORT_CD NOT LIKE 'AR%'" ).append("\n"); 
		query.append("                              AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                              AND CLPT_SEQ > (SELECT CLPT_SEQ" ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                               WHERE VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                                                 AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                 AND SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                 AND VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                 AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS FOREIGN_NATION_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      ,BKG.CMDT_CD                     AS COMMODITY_CD" ).append("\n"); 
		query.append("      ,DOC.PCK_QTY                     AS BLPKG" ).append("\n"); 
		query.append("      ,DOC.ACT_WGT                     AS BLWGT" ).append("\n"); 
		query.append("      ,DOC.WGT_UT_CD                   AS BLWGT_UNIT" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_TOKEN_NL_FNC(DOC.CSTMS_DESC, 0, ''), 1, 80) AS B_DESC" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_TOKEN_NL_FNC(BMK.MK_DESC, 0, ''), 1, 100)  AS MARKNO" ).append("\n"); 
		query.append("      ,(SELECT NVL(A.DE_NO, '')" ).append("\n"); 
		query.append("          FROM ( SELECT DE_NO, REF_SEQ, MIN(REF_SEQ) OVER(PARTITION BY BKG_NO) AS MSEQ" ).append("\n"); 
		query.append("                   FROM BKG_REF_DTL" ).append("\n"); 
		query.append("                  WHERE BKG_NO = @[bkg_no]) A" ).append("\n"); 
		query.append("         WHERE A.REF_SEQ = A.MSEQ) AS SHIP_ID_IND" ).append("\n"); 
		query.append("      ,'CZ'                            AS SHP_BL_PT_TYPE" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_TOKEN_NL_FNC(SHP.CUST_NM ,0, ''),1,35)   AS SHP_BL_PT_NAME" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_TOKEN_NL_FNC(SHP.CUST_ADDR ,0, ''),1,35) AS SHP_BL_PT_ADDRESS" ).append("\n"); 
		query.append("      ,SHP.CUST_STE_CD                 AS SHP_BL_PT_STREET" ).append("\n"); 
		query.append("      ,SHP.CUST_CTY_NM                 AS SHP_BL_PT_CITY" ).append("\n"); 
		query.append("      ,SHP.CUST_ZIP_ID                 AS SHP_BL_PT_POSTAL_CD" ).append("\n"); 
		query.append("      ,SHP.CSTMS_DECL_CNT_CD           AS SHP_BL_PT_CNT_CD" ).append("\n"); 
		query.append("      ,SUBSTR(MSH.CUST_RGST_NO, 1, INSTR(MSH.CUST_RGST_NO, '-') - 1) AS SHP_BL_PT_TAX_TYPE" ).append("\n"); 
		query.append("      ,SUBSTR(MSH.CUST_RGST_NO, INSTR(MSH.CUST_RGST_NO, '-') + 1)    AS SHP_BL_PT_TAX_ID" ).append("\n"); 
		query.append("      ,'CN'                            AS CNE_BL_PT_TYPE" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_TOKEN_NL_FNC(CNE.CUST_NM ,0, ''),1,35)   AS CNE_BL_PT_NAME" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_TOKEN_NL_FNC(CNE.CUST_ADDR ,0, ''),1,35) AS CNE_BL_PT_ADDRESS" ).append("\n"); 
		query.append("      ,CNE.CUST_STE_CD                 AS CNE_BL_PT_STREET" ).append("\n"); 
		query.append("      ,CNE.CUST_CTY_NM                 AS CNE_BL_PT_CITY" ).append("\n"); 
		query.append("      ,CNE.CUST_ZIP_ID                 AS CNE_BL_PT_POSTAL_CD" ).append("\n"); 
		query.append("      ,CNE.CSTMS_DECL_CNT_CD           AS CNE_BL_PT_CNT_CD" ).append("\n"); 
		query.append("      ,SUBSTR(MCN.CUST_RGST_NO, 1, INSTR(MCN.CUST_RGST_NO, '-') - 1) AS CNE_BL_PT_TAX_TYPE" ).append("\n"); 
		query.append("      ,SUBSTR(MCN.CUST_RGST_NO, INSTR(MCN.CUST_RGST_NO, '-') + 1)    AS CNE_BL_PT_TAX_ID" ).append("\n"); 
		query.append("      ,'NI'                            AS NFY_BL_PT_TYPE" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_TOKEN_NL_FNC(NFY.CUST_NM ,0, ''),1,35)   AS NFY_BL_PT_NAME" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_TOKEN_NL_FNC(NFY.CUST_ADDR ,0, ''),1,35) AS NFY_BL_PT_ADDRESS" ).append("\n"); 
		query.append("      ,NFY.CUST_STE_CD                 AS NFY_BL_PT_STREET" ).append("\n"); 
		query.append("      ,NFY.CUST_CTY_NM                 AS NFY_BL_PT_CITY" ).append("\n"); 
		query.append("      ,NFY.CUST_ZIP_ID                 AS NFY_BL_PT_POSTAL_CD" ).append("\n"); 
		query.append("      ,NFY.CSTMS_DECL_CNT_CD           AS NFY_BL_PT_CNT_CD" ).append("\n"); 
		query.append("      ,SUBSTR(MNF.CUST_RGST_NO, 1, INSTR(MNF.CUST_RGST_NO, '-') - 1) AS NFY_BL_PT_TAX_TYPE" ).append("\n"); 
		query.append("      ,SUBSTR(MNF.CUST_RGST_NO, INSTR(MNF.CUST_RGST_NO, '-') + 1)    AS NFY_BL_PT_TAX_ID" ).append("\n"); 
		query.append("  FROM BKG_BOOKING           BKG" ).append("\n"); 
		query.append("      ,BKG_BL_DOC            DOC" ).append("\n"); 
		query.append("      ,BKG_VVD               VVD" ).append("\n"); 
		query.append("      ,BKG_BL_MK_DESC        BMK" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR          VSL" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD      SKD" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER          SHP" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER          CNE" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER          NFY" ).append("\n"); 
		query.append("      ,MDM_CUSTOMER          MSH" ).append("\n"); 
		query.append("      ,MDM_CUSTOMER          MCN" ).append("\n"); 
		query.append("      ,MDM_CUSTOMER          MNF" ).append("\n"); 
		query.append(" WHERE BKG.BL_NO          = @[bl_no]" ).append("\n"); 
		query.append("   AND VVD.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND VVD.POD_CD         = @[pod_cd]" ).append("\n"); 
		query.append("   AND VVD.POL_CD         = @[pol_cd]" ).append("\n"); 
		query.append("   AND BKG.BKG_NO         = DOC.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO         = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO         = BMK.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BMK.MK_SEQ(+)      = 1 " ).append("\n"); 
		query.append("   AND VVD.VSL_CD         = VSL.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("#if (${mode_type} == 'I') " ).append("\n"); 
		query.append("   AND SKD.VPS_PORT_CD    = VVD.POD_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SKD.VPS_PORT_CD    = VVD.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND SKD.CLPT_IND_SEQ   = '1'" ).append("\n"); 
		query.append("   AND BKG.BKG_NO         = SHP.BKG_NO" ).append("\n"); 
		query.append("   AND SHP.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND BKG.BKG_NO         = CNE.BKG_NO" ).append("\n"); 
		query.append("   AND CNE.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND BKG.BKG_NO         = NFY.BKG_NO(+)" ).append("\n"); 
		query.append("   AND NFY.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND SHP.CUST_CNT_CD    = MSH.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND SHP.CUST_SEQ       = MSH.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND CNE.CUST_CNT_CD    = MCN.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND CNE.CUST_SEQ       = MCN.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND NFY.CUST_CNT_CD    = MNF.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND NFY.CUST_SEQ       = MNF.CUST_SEQ(+)" ).append("\n"); 

	}
}