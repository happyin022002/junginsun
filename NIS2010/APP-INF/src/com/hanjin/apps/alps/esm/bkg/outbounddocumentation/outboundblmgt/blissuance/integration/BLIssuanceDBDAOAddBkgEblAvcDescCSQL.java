/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBkgEblAvcDescCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.04.28 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddBkgEblAvcDescCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBkgEblAvcDescCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ebl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddBkgEblAvcDescCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EBL_AVC_DESC" ).append("\n"); 
		query.append("	(BKG_NO" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,BKG_EBL_SEQ" ).append("\n"); 
		query.append("	,CNTR_SEQ" ).append("\n"); 
		query.append("	,DOC_PARA_NO1" ).append("\n"); 
		query.append("	,DOC_PARA_NO2" ).append("\n"); 
		query.append("	,CMDT_DESC" ).append("\n"); 
		query.append("	,PCK_CMDT_DESC" ).append("\n"); 
		query.append("	,MK_DESC" ).append("\n"); 
		query.append("	,IF_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT)" ).append("\n"); 
		query.append("WITH BK AS (" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("                             REGEXP_REPLACE(REPLACE(REPLACE(REPLACE(MARKS, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)), '', '') AS MARKS," ).append("\n"); 
		query.append("                             REGEXP_REPLACE(REPLACE(REPLACE(REPLACE(DESCRIPTION, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)), '', '') AS DESCRIPTION," ).append("\n"); 
		query.append("							 PCK_CMDT_DESC AS PCK_CMDT_DESC" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                              SELECT RTRIM(NVL(MARK.MK_DESC,''), CHR(13)||CHR(10))  AS MARKS" ).append("\n"); 
		query.append("                                    ,DSCRT.MF_ID " ).append("\n"); 
		query.append("                                     || DECODE(DOC.PCK_CMDT_DESC,'',''," ).append("\n"); 
		query.append("                                            CASE WHEN INSTR(DOC.PCK_CMDT_DESC, ' ', 1) < 8 AND INSTR(DOC.PCK_CMDT_DESC, ' ', 1) > 0 THEN " ).append("\n"); 
		query.append("                                                    LTRIM(RPAD('',8 - INSTR(SUBSTR(DOC.PCK_CMDT_DESC,INSTR(DOC.PCK_CMDT_DESC, ' ', 1)), ' ', 1), ' '))" ).append("\n"); 
		query.append("                                            END || LTRIM(SUBSTR(DOC.PCK_CMDT_DESC,INSTR(DOC.PCK_CMDT_DESC, ' ', 1))) || CHR(13) || CHR(10))" ).append("\n"); 
		query.append("                                     ||  DECODE(DOC.CNTR_CMDT_DESC,'',''," ).append("\n"); 
		query.append("                                            CASE WHEN INSTR(DOC.CNTR_CMDT_DESC, ' ', 1) < 8 AND INSTR(DOC.CNTR_CMDT_DESC, ' ', 1) > 0 THEN " ).append("\n"); 
		query.append("                                                    LTRIM(RPAD('',8 - INSTR(SUBSTR(DOC.CNTR_CMDT_DESC,INSTR(DOC.CNTR_CMDT_DESC, ' ', 1)), ' ', 1), ' ')) " ).append("\n"); 
		query.append("                                            END || LTRIM(SUBSTR(DOC.CNTR_CMDT_DESC,INSTR(DOC.CNTR_CMDT_DESC, ' ', 1))) || CHR(13) || CHR(10))" ).append("\n"); 
		query.append("                                     || NVL( ''||REPLACE(CMDT_DESC, CHR(13)||CHR(10), CHR(13)||CHR(10)||'') || CHR(13) || CHR(10) , '')" ).append("\n"); 
		query.append("                                     || TRIM(TRAILING CHR(13) FROM TRIM(TRAILING CHR(10) FROM CAED_RMK )) AS DESCRIPTION" ).append("\n"); 
		query.append("                                    , DECODE(DOC.PCK_CMDT_DESC,'',''," ).append("\n"); 
		query.append("                                            CASE WHEN INSTR(DOC.PCK_CMDT_DESC, ' ', 1) < 8 AND INSTR(DOC.PCK_CMDT_DESC, ' ', 1) > 0 THEN " ).append("\n"); 
		query.append("                                                    RPAD(' ',8 - INSTR(SUBSTR(DOC.PCK_CMDT_DESC,1,INSTR(DOC.PCK_CMDT_DESC, ' ', 1)), ' ', 1), ' ') " ).append("\n"); 
		query.append("                                            END || SUBSTR(DOC.PCK_CMDT_DESC,1,INSTR(DOC.PCK_CMDT_DESC, ' ', 1)) || CHR(13) || CHR(10)) " ).append("\n"); 
		query.append("                                     ||  DECODE(DOC.CNTR_CMDT_DESC,'',''," ).append("\n"); 
		query.append("                                            CASE WHEN INSTR(DOC.CNTR_CMDT_DESC, ' ', 1) < 8 AND INSTR(DOC.CNTR_CMDT_DESC, ' ', 1) > 0 THEN " ).append("\n"); 
		query.append("                                                    RPAD(' ',8 - INSTR(SUBSTR(DOC.CNTR_CMDT_DESC,1,INSTR(DOC.CNTR_CMDT_DESC, ' ', 1)), ' ', 1), ' ') " ).append("\n"); 
		query.append("                                            END || SUBSTR(DOC.CNTR_CMDT_DESC,1,INSTR(DOC.CNTR_CMDT_DESC, ' ', 1)) || CHR(13) || CHR(10)) AS PCK_CMDT_DESC" ).append("\n"); 
		query.append("                                     ,DOC.BKG_NO" ).append("\n"); 
		query.append("                                FROM BKG_BL_MK_DESC MARK" ).append("\n"); 
		query.append("                                    ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("                                    ,(" ).append("\n"); 
		query.append("                                        SELECT MAX(CA) || MAX(MX) || MAX(US) AS MF_ID" ).append("\n"); 
		query.append("                                              ,MAX(CAED_RMK) AS CAED_RMK" ).append("\n"); 
		query.append("                                          FROM (SELECT CASE WHEN CNT_CD = 'CA' THEN" ).append("\n"); 
		query.append("                                                                '['||DECODE(CAED_TP_CD,'CE',CAED_PFX_CTNT ||  ' ' ||CAED_NO1 ||  '-' ||CAED_NO2 || '-' || CAED_NO3  " ).append("\n"); 
		query.append("                                                                                      ,'G7',G7_EDI_PFX_CTNT|| ' ' ||G7_EDI_NO1|| '-' ||G7_EDI_NO2  " ).append("\n"); 
		query.append("                                                                                      ,'SM',MF_SMRY_RPT_PFX_CTNT|| ' ' ||MF_SMRY_RPT_NO  " ).append("\n"); 
		query.append("                                                                                      ,'EX',B13A_XPT_PFX_CTNT || ' ' || TO_CHAR(B13A_XPT_DT,'YYYY/MM/DD HH24:MI') || ' ' || B13A_XPT_NO1 || '-' || B13A_XPT_NO2  " ).append("\n"); 
		query.append("                                                                                      ,'IT',CGO_CTRL_PFX_CTNT ||  ' ' ||CGO_CTRL_NO" ).append("\n"); 
		query.append("                                                                                      ,'ND',NDR_REF_PFX_CTNT || ' ' || NDR_REF_ID) || ']' || CHR(13) || CHR(10)" ).append("\n"); 
		query.append("                                                        END AS CA" ).append("\n"); 
		query.append("                                                       ,CASE WHEN CNT_CD = 'US' THEN" ).append("\n"); 
		query.append("                                                                '['||DECODE(AES_TP_CD,'AE',AES_INLND_TRNS_PFX_CTNT || ' ' || AES_INLND_TRNS_NO" ).append("\n"); 
		query.append("                                                                                     ,'PA',AES_PTA_PFX_CTNT || ' ' || AES_PTA_NO1 || ' ' || AES_PTA_NO2 || ' ' || TO_CHAR(AES_PTA_DT,'MM-DD-YYYY')" ).append("\n"); 
		query.append("                                                                                     ,'PU',AES_PTU_PFX_CTNT || ' ' || AES_PTU_NO || ' ' || TO_CHAR(AES_PTU_DT,'MM-DD-YYYY')" ).append("\n"); 
		query.append("                                                                                     ,'DN',AES_DWN_PFX_CTNT || ' ' || AES_DWN_NO || ' ' || TO_CHAR(AES_DWN_DT,'MM-DD-YYYY') " ).append("\n"); 
		query.append("                                                                                     ,'EX',DECODE(AES_EXPT_ID,'LV','NOEEI 30.37 (A) LOW VALUE'" ).append("\n"); 
		query.append("                                                                                                             ,'TT','NOEEI 30.37 (B) TOOLS OF TRADE'" ).append("\n"); 
		query.append("                                                                                                             ,'TE','NOEEI 30.37 (R) TEMPORARY EXPORTS'" ).append("\n"); 
		query.append("                                                                                                             ,'AF','NOEEI 30.39      U.S. ARMED FORCES'" ).append("\n"); 
		query.append("                                                                                                             ,'SA','NOEEI 30.37 (E) IN-BOND CARGO'))||']' || CHR(13) || CHR(10)" ).append("\n"); 
		query.append("                                                        END AS US" ).append("\n"); 
		query.append("                                                       ,CASE WHEN CNT_CD = 'MX' THEN" ).append("\n"); 
		query.append("                                                                CASE WHEN MX_SHPR_TAX_ID IS NOT NULL THEN '['|| MX_SHPR_PFX_CTNT || ' : ' ||MX_SHPR_TAX_ID ||']' || CHR(13) || CHR(10) END ||         " ).append("\n"); 
		query.append("                                                                CASE WHEN MX_CNEE_TAX_ID IS NOT NULL THEN '['|| MX_CNEE_PFX_CTNT || ' : ' ||MX_CNEE_TAX_ID ||']' || CHR(13) || CHR(10) END ||        " ).append("\n"); 
		query.append("                                                                CASE WHEN MX_NTFY_TAX_ID IS NOT NULL THEN '['|| MX_NTFY_PFX_CTNT || ' : ' ||MX_NTFY_TAX_ID ||']' || CHR(13) || CHR(10) END" ).append("\n"); 
		query.append("                                                        END AS MX" ).append("\n"); 
		query.append("                                                       ,CASE WHEN CNT_CD = 'CA' AND NDR_REF_CTNT IS NOT NULL THEN " ).append("\n"); 
		query.append("                                                                '        CAED MANUAL INPUT' || CHR(13) || CHR(10) || NVL( '        '||REPLACE(NDR_REF_CTNT, CHR(13)||CHR(10), CHR(13)||CHR(10)||'        ') || CHR(13) || CHR(10) , '') " ).append("\n"); 
		query.append("                                                        END AS CAED_RMK" ).append("\n"); 
		query.append("                                                  FROM BKG_XPT_IMP_LIC MF" ).append("\n"); 
		query.append("                                                 WHERE BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("                                                   AND CNT_CD IN ('CA','MX','US')" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                                      ) DSCRT" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                                 AND DOC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                 AND DOC.BKG_NO = MARK.BKG_NO" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT	D.BKG_NO BKG_NO      " ).append("\n"); 
		query.append("	,B.BL_NO BL_NO" ).append("\n"); 
		query.append("	,@[bkg_ebl_seq] BKG_EBL_SEQ    " ).append("\n"); 
		query.append("	,ROWNUM CNTR_SEQ" ).append("\n"); 
		query.append("	,D.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000')) DOC_PARA_NO1" ).append("\n"); 
		query.append("	,D.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000'))||LTRIM(TO_CHAR(ROWNUM, '0000')) DOC_PARA_NO2" ).append("\n"); 
		query.append("    ,DBMS_LOB.SUBSTR(REPLACE(DESCRIPTION,CHR(13)||CHR(10),'^'), " ).append("\n"); 
		query.append("                       DECODE(LVL,1,INSTR(REPLACE(DESCRIPTION||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,LVL)-1,INSTR(REPLACE(DESCRIPTION||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,LVL)- INSTR(REPLACE(DESCRIPTION||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,LVL-1)-1), " ).append("\n"); 
		query.append("                       DECODE(LVL,1,1,INSTR(REPLACE(DESCRIPTION||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,LVL-1)+1) ) CMDT_DESC" ).append("\n"); 
		query.append("	,BK.PCK_CMDT_DESC PCK_CMDT_DESC " ).append("\n"); 
		query.append("	,BK.MARKS MARKS" ).append("\n"); 
		query.append("	,'N' IF_FLG " ).append("\n"); 
		query.append("	,@[usr_id] CRE_USR_ID  " ).append("\n"); 
		query.append("	,SYSDATE CRE_DT      " ).append("\n"); 
		query.append("	,@[usr_id] UPD_USR_ID  " ).append("\n"); 
		query.append("	,SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM	BKG_BL_MK_DESC D" ).append("\n"); 
		query.append("        ,BKG_BOOKING B" ).append("\n"); 
		query.append("		,BKG_BL_DOC BL" ).append("\n"); 
		query.append("		,BK" ).append("\n"); 
		query.append(" ,(SELECT LEVEL AS LVL FROM DUAL CONNECT BY LEVEL <= (SELECT " ).append("\n"); 
		query.append("								(DBMS_LOB.GETLENGTH(TRIM(DESCRIPTION)) - DBMS_LOB.GETLENGTH(REPLACE(TRIM(DESCRIPTION),CHR(13),'')))" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                              SELECT RTRIM(NVL(MARK.MK_DESC,''), CHR(13)||CHR(10))  AS MARKS" ).append("\n"); 
		query.append("                                    ,DSCRT.MF_ID " ).append("\n"); 
		query.append("                                     || DECODE(DOC.PCK_CMDT_DESC,'',''," ).append("\n"); 
		query.append("                                            CASE WHEN INSTR(DOC.PCK_CMDT_DESC, ' ', 1) < 8 AND INSTR(DOC.PCK_CMDT_DESC, ' ', 1) > 0 THEN " ).append("\n"); 
		query.append("                                                    RPAD(' ',8 - INSTR(SUBSTR(DOC.PCK_CMDT_DESC,INSTR(DOC.PCK_CMDT_DESC, ' ', 1)), ' ', 1), ' ') " ).append("\n"); 
		query.append("                                            END || SUBSTR(DOC.PCK_CMDT_DESC,INSTR(DOC.PCK_CMDT_DESC, ' ', 1)) || CHR(13) || CHR(10))" ).append("\n"); 
		query.append("                                     ||  DECODE(DOC.CNTR_CMDT_DESC,'',''," ).append("\n"); 
		query.append("                                            CASE WHEN INSTR(DOC.CNTR_CMDT_DESC, ' ', 1) < 8 AND INSTR(DOC.CNTR_CMDT_DESC, ' ', 1) > 0 THEN " ).append("\n"); 
		query.append("                                                    RPAD(' ',8 - INSTR(SUBSTR(DOC.CNTR_CMDT_DESC,INSTR(DOC.CNTR_CMDT_DESC, ' ', 1)), ' ', 1), ' ') " ).append("\n"); 
		query.append("                                            END || SUBSTR(DOC.CNTR_CMDT_DESC,INSTR(DOC.CNTR_CMDT_DESC, ' ', 1)) || CHR(13) || CHR(10))" ).append("\n"); 
		query.append("                                     || NVL( ''||REPLACE(CMDT_DESC, CHR(13)||CHR(10), CHR(13)||CHR(10)||'') || CHR(13) || CHR(10) , '')" ).append("\n"); 
		query.append("                                     || TRIM(TRAILING CHR(13) FROM TRIM(TRAILING CHR(10) FROM CAED_RMK )) AS DESCRIPTION" ).append("\n"); 
		query.append("                                     ,DOC.BKG_NO" ).append("\n"); 
		query.append("                                FROM BKG_BL_MK_DESC MARK" ).append("\n"); 
		query.append("                                    ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("                                    ,(" ).append("\n"); 
		query.append("                                        SELECT MAX(CA) || MAX(MX) || MAX(US) AS MF_ID" ).append("\n"); 
		query.append("                                              ,MAX(CAED_RMK) AS CAED_RMK" ).append("\n"); 
		query.append("                                          FROM (SELECT CASE WHEN CNT_CD = 'CA' THEN" ).append("\n"); 
		query.append("                                                                '['||DECODE(CAED_TP_CD,'CE',CAED_PFX_CTNT ||  ' ' ||CAED_NO1 ||  '-' ||CAED_NO2 || '-' || CAED_NO3  " ).append("\n"); 
		query.append("                                                                                      ,'G7',G7_EDI_PFX_CTNT|| ' ' ||G7_EDI_NO1|| '-' ||G7_EDI_NO2  " ).append("\n"); 
		query.append("                                                                                      ,'SM',MF_SMRY_RPT_PFX_CTNT|| ' ' ||MF_SMRY_RPT_NO  " ).append("\n"); 
		query.append("                                                                                      ,'EX',B13A_XPT_PFX_CTNT || ' ' || TO_CHAR(B13A_XPT_DT,'YYYY/MM/DD HH24:MI') || ' ' || B13A_XPT_NO1 || '-' || B13A_XPT_NO2  " ).append("\n"); 
		query.append("                                                                                      ,'IT',CGO_CTRL_PFX_CTNT ||  ' ' ||CGO_CTRL_NO" ).append("\n"); 
		query.append("                                                                                      ,'ND',NDR_REF_PFX_CTNT || ' ' || NDR_REF_ID) || ']' || CHR(13) || CHR(10)" ).append("\n"); 
		query.append("                                                        END AS CA" ).append("\n"); 
		query.append("                                                       ,CASE WHEN CNT_CD = 'US' THEN" ).append("\n"); 
		query.append("                                                                '['||DECODE(AES_TP_CD,'AE',AES_INLND_TRNS_PFX_CTNT || ' ' || AES_INLND_TRNS_NO" ).append("\n"); 
		query.append("                                                                                     ,'PA',AES_PTA_PFX_CTNT || ' ' || AES_PTA_NO1 || ' ' || AES_PTA_NO2 || ' ' || TO_CHAR(AES_PTA_DT,'MM-DD-YYYY')" ).append("\n"); 
		query.append("                                                                                     ,'PU',AES_PTU_PFX_CTNT || ' ' || AES_PTU_NO || ' ' || TO_CHAR(AES_PTU_DT,'MM-DD-YYYY')" ).append("\n"); 
		query.append("                                                                                     ,'DN',AES_DWN_PFX_CTNT || ' ' || AES_DWN_NO || ' ' || TO_CHAR(AES_DWN_DT,'MM-DD-YYYY') " ).append("\n"); 
		query.append("                                                                                     ,'EX',DECODE(AES_EXPT_ID,'LV','NOEEI 30.37 (A) LOW VALUE'" ).append("\n"); 
		query.append("                                                                                                             ,'TT','NOEEI 30.37 (B) TOOLS OF TRADE'" ).append("\n"); 
		query.append("                                                                                                             ,'TE','NOEEI 30.37 (R) TEMPORARY EXPORTS'" ).append("\n"); 
		query.append("                                                                                                             ,'AF','NOEEI 30.39      U.S. ARMED FORCES'" ).append("\n"); 
		query.append("                                                                                                             ,'SA','NOEEI 30.37 (E) IN-BOND CARGO'))||']' || CHR(13) || CHR(10)" ).append("\n"); 
		query.append("                                                        END AS US" ).append("\n"); 
		query.append("                                                       ,CASE WHEN CNT_CD = 'MX' THEN" ).append("\n"); 
		query.append("                                                                CASE WHEN MX_SHPR_TAX_ID IS NOT NULL THEN '['|| MX_SHPR_PFX_CTNT || ' : ' ||MX_SHPR_TAX_ID ||']' || CHR(13) || CHR(10) END ||         " ).append("\n"); 
		query.append("                                                                CASE WHEN MX_CNEE_TAX_ID IS NOT NULL THEN '['|| MX_CNEE_PFX_CTNT || ' : ' ||MX_CNEE_TAX_ID ||']' || CHR(13) || CHR(10) END ||        " ).append("\n"); 
		query.append("                                                                CASE WHEN MX_NTFY_TAX_ID IS NOT NULL THEN '['|| MX_NTFY_PFX_CTNT || ' : ' ||MX_NTFY_TAX_ID ||']' || CHR(13) || CHR(10) END" ).append("\n"); 
		query.append("                                                        END AS MX" ).append("\n"); 
		query.append("                                                       ,CASE WHEN CNT_CD = 'CA' AND NDR_REF_CTNT IS NOT NULL THEN " ).append("\n"); 
		query.append("                                                                '        CAED MANUAL INPUT' || CHR(13) || CHR(10) || NVL( '        '||REPLACE(NDR_REF_CTNT, CHR(13)||CHR(10), CHR(13)||CHR(10)||'        ') || CHR(13) || CHR(10) , '') " ).append("\n"); 
		query.append("                                                        END AS CAED_RMK" ).append("\n"); 
		query.append("                                                  FROM BKG_XPT_IMP_LIC MF" ).append("\n"); 
		query.append("                                                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                   AND CNT_CD IN ('CA','MX','US')" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                                      ) DSCRT" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                                 AND DOC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                 AND DOC.BKG_NO = MARK.BKG_NO" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                             ))C" ).append("\n"); 
		query.append("  WHERE D.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND  D.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND  D.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("   AND  D.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}