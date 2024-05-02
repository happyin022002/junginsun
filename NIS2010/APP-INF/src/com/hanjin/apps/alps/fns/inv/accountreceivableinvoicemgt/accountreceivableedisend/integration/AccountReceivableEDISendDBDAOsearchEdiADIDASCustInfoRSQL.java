/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchEdiADIDASCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOsearchEdiADIDASCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiADIDASCustInfo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchEdiADIDASCustInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchEdiADIDASCustInfoRSQL").append("\n"); 
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
		query.append("WITH AR_CUSTOMER  AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  DISTINCT C.BL_SRC_NO,C.AR_OFC_CD,  C.ACT_CUST_CNT_CD AS  P_CUST_CNT_CD, C.ACT_CUST_SEQ AS  P_CUST_SEQ , D.CUST_CNT_CD AS C_CUST_CNT_CD, D.CUST_SEQ AS C_CUST_SEQ, D.CUST_FAX_NO AS C_CUST_FAX_NO, D.CUST_EML AS C_CUST_EML, E.CUST_CNT_CD AS N_CUST_CNT_CD, E.CUST_SEQ AS N_CUST_SEQ, E.CUST_FAX_NO AS N_CUST_FAX_NO, E.CUST_EML AS N_CUST_EML" ).append("\n"); 
		query.append("FROM INV_AR_ISS A," ).append("\n"); 
		query.append("  INV_AR_ISS_DTL B," ).append("\n"); 
		query.append("  INV_AR_MN C," ).append("\n"); 
		query.append("  BKG_CUSTOMER D," ).append("\n"); 
		query.append("  BKG_CUSTOMER E" ).append("\n"); 
		query.append("WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("  AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("  AND C.BL_SRC_NO = D.BKG_NO(+) " ).append("\n"); 
		query.append("  AND C.BL_SRC_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("  AND C.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("  AND D.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("  AND E.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("  AND A.INV_SEQ = (SELECT MAX(B.INV_SEQ) FROM INV_AR_ISS B" ).append("\n"); 
		query.append("                   WHERE   B.INV_NO = A.INV_NO)" ).append("\n"); 
		query.append("  AND C.AR_IF_NO = (SELECT DECODE(MAX(Z3.INV_DUP_FLG),'Y',SUBSTR(MAX(DECODE(Z2.REV_TP_CD, 'M', '1', '2')||Z1.AR_IF_NO), 2,11),MAX(Z1.AR_IF_NO))" ).append("\n"); 
		query.append("                    FROM INV_AR_ISS_DTL Z1, INV_AR_MN Z2, INV_AR_STUP_OFC Z3 " ).append("\n"); 
		query.append("                    WHERE Z1.AR_IF_NO = Z2.AR_IF_NO AND Z2.AR_OFC_CD = Z3.AR_OFC_CD(+) AND Z1.INV_NO = A.INV_NO)" ).append("\n"); 
		query.append("  AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("  'ITO' AS PT_TYPE," ).append("\n"); 
		query.append("  F.P_CUST_CNT_CD ||LPAD(F.P_CUST_SEQ, 6, '0') AS PT_CD," ).append("\n"); 
		query.append("   SUBSTR(NVL(H.LOCL_NM, J.CUST_LGL_ENG_NM),1,50) PT_NAME , " ).append("\n"); 
		query.append("  NVL(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4, I.BZET_ADDR) PT_ADDRESS," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR1)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4), '', " ).append("\n"); 
		query.append("      DECODE(F.P_CUST_CNT_CD, 'TB', DECODE(I.PRMRY_CHK_FLG, 'Y', " ).append("\n"); 
		query.append("        DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4), '', SUBSTR(I.BZET_ADDR, 1, 50), I.LOCL_ADDR1), '')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG, 'Y', DECODE(SUBSTR(I.BZET_ADDR, 1, 50), '', '', SUBSTR(I.BZET_ADDR, 1, 50)), '')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS1," ).append("\n"); 
		query.append("  --(SELECT SUBSTR(OFC_ENG_NM, INSTRB(OFC_ENG_NM, ',') + 1) FROM MDM_ORGANIZATION WHERE OFC_CD = 'HAMSC') PT_IFR_ADDRESS1," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR2)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(F.P_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4),'',SUBSTR(I.BZET_ADDR,51,100),I.LOCL_ADDR2),'')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(SUBSTR(I.BZET_ADDR,51,100),'','', SUBSTR(I.BZET_ADDR,51,100)),'')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS2," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR3)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(F.P_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4),'',SUBSTR(I.BZET_ADDR,101,150),I.LOCL_ADDR3),'')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(SUBSTR(I.BZET_ADDR,101,150),'','', SUBSTR(I.BZET_ADDR,101,150)),'')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS3," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR4)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(F.P_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4),'',SUBSTR(I.BZET_ADDR,151,200),I.LOCL_ADDR4)||DECODE(I.ZIP_CD,'','',', '||I.ZIP_CD)||DECODE(I.CTY_NM,'','',', '||I.CTY_NM),'')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG,'Y',SUBSTR(I.BZET_ADDR,151,200)||DECODE(I.ZIP_CD,'','','  '||I.ZIP_CD)||DECODE(I.CTY_NM,'','',', '||I.CTY_NM))))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS4," ).append("\n"); 
		query.append("  J.CUST_RGST_NO AS PT_VAT_ID," ).append("\n"); 
		query.append("  I.CTY_NM AS PT_CITY_NAME," ).append("\n"); 
		query.append("  I.STE_CD  AS PT_ST_PROV_CD," ).append("\n"); 
		query.append("  I.ZIP_CD  AS PT_ZIP_CD," ).append("\n"); 
		query.append("  I.CNT_CD AS PT_COUNTRY_CD," ).append("\n"); 
		query.append("  DECODE(  @[io_bnd_cd], 'O', H.OB_EML, H.IB_EML) AS PT_EML," ).append("\n"); 
		query.append("  DECODE(  @[io_bnd_cd], 'O', H.OB_FAX_NO, H.IB_FAX_NO) AS PT_FAX," ).append("\n"); 
		query.append("  DECODE(  @[io_bnd_cd], 'O', H.OB_PHN_NO, H.IB_PHN_NO) AS PT_EML," ).append("\n"); 
		query.append("  '' AS PT_BA" ).append("\n"); 
		query.append("  FROM AR_CUSTOMER F, MDM_CR_CUST H, MDM_CUST_ADDR I , MDM_CUSTOMER J" ).append("\n"); 
		query.append(" WHERE   F.P_CUST_CNT_CD =H.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.P_CUST_SEQ    =H.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     F.P_CUST_CNT_CD =I.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.P_CUST_SEQ    =I.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     F.P_CUST_CNT_CD =J.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.P_CUST_SEQ    =J.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     I.DELT_FLG <>'Y'" ).append("\n"); 
		query.append(" AND     ROWNUM = 1" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" SELECT DISTINCT" ).append("\n"); 
		query.append("  'CX' PT_TYPE," ).append("\n"); 
		query.append("  F.C_CUST_CNT_CD ||LPAD(F.C_CUST_SEQ, 6, '0') AS PT_CD," ).append("\n"); 
		query.append("   SUBSTR(NVL(H.LOCL_NM, J.CUST_LGL_ENG_NM),1,50) PT_NAME , " ).append("\n"); 
		query.append("  NVL(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4, I.BZET_ADDR) PT_ADDRESS," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR1)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4), '', " ).append("\n"); 
		query.append("      DECODE(F.P_CUST_CNT_CD, 'TB', DECODE(I.PRMRY_CHK_FLG, 'Y', " ).append("\n"); 
		query.append("        DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4), '', SUBSTR(I.BZET_ADDR, 1, 50), I.LOCL_ADDR1), '')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG, 'Y', DECODE(SUBSTR(I.BZET_ADDR, 1, 50), '', '', SUBSTR(I.BZET_ADDR, 1, 50)), '')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS1," ).append("\n"); 
		query.append("  --(SELECT SUBSTR(OFC_ENG_NM, INSTRB(OFC_ENG_NM, ',') + 1) FROM MDM_ORGANIZATION WHERE OFC_CD = 'HAMSC') PT_IFR_ADDRESS1," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR2)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(F.P_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4),'',SUBSTR(I.BZET_ADDR,51,100),I.LOCL_ADDR2),'')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(SUBSTR(I.BZET_ADDR,51,100),'','', SUBSTR(I.BZET_ADDR,51,100)),'')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS2," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR3)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(F.P_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4),'',SUBSTR(I.BZET_ADDR,101,150),I.LOCL_ADDR3),'')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(SUBSTR(I.BZET_ADDR,101,150),'','', SUBSTR(I.BZET_ADDR,101,150)),'')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS3," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR4)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(F.P_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4),'',SUBSTR(I.BZET_ADDR,151,200),I.LOCL_ADDR4)||DECODE(I.ZIP_CD,'','',', '||I.ZIP_CD)||DECODE(I.CTY_NM,'','',', '||I.CTY_NM),'')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG,'Y',SUBSTR(I.BZET_ADDR,151,200)||DECODE(I.ZIP_CD,'','','  '||I.ZIP_CD)||DECODE(I.CTY_NM,'','',', '||I.CTY_NM))))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS4," ).append("\n"); 
		query.append("  J.CUST_RGST_NO AS PT_VAT_ID," ).append("\n"); 
		query.append("  I.CTY_NM AS PT_CITY_NAME," ).append("\n"); 
		query.append("  I.STE_CD  AS PT_ST_PROV_CD," ).append("\n"); 
		query.append("  I.ZIP_CD  AS PT_ZIP_CD," ).append("\n"); 
		query.append("  I.CNT_CD AS PT_COUNTRY_CD," ).append("\n"); 
		query.append("  DECODE(  @[io_bnd_cd], 'O', H.OB_EML, H.IB_EML) AS PT_EML," ).append("\n"); 
		query.append("  DECODE(  @[io_bnd_cd], 'O', H.OB_FAX_NO, H.IB_FAX_NO) AS PT_FAX," ).append("\n"); 
		query.append("  DECODE(  @[io_bnd_cd], 'O', H.OB_PHN_NO, H.IB_PHN_NO) AS PT_EML," ).append("\n"); 
		query.append("  '' AS PT_BA" ).append("\n"); 
		query.append(" FROM AR_CUSTOMER F, MDM_CR_CUST H, MDM_CUST_ADDR I , MDM_CUSTOMER J" ).append("\n"); 
		query.append(" WHERE   F.C_CUST_CNT_CD =H.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.C_CUST_SEQ    =H.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     F.C_CUST_CNT_CD =I.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.C_CUST_SEQ    =I.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     F.C_CUST_CNT_CD =J.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.C_CUST_SEQ    =J.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     I.DELT_FLG <>'Y'" ).append("\n"); 
		query.append(" AND     ROWNUM = 1" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" SELECT DISTINCT" ).append("\n"); 
		query.append("  'IFR' PT_TYPE," ).append("\n"); 
		query.append("  '' AS PT_CD," ).append("\n"); 
		query.append("  (SELECT OFC_ENG_NM  FROM MDM_ORGANIZATION WHERE F.AR_OFC_CD = OFC_CD AND DELT_FLG ='N' AND ROWNUM =1 ) AS PT_NAME , " ).append("\n"); 
		query.append("  (SELECT OFC_ADDR   FROM MDM_ORGANIZATION WHERE F.AR_OFC_CD = OFC_CD AND DELT_FLG ='N' AND ROWNUM =1 ) AS  PT_ADDRESS," ).append("\n"); 
		query.append("   '' AS PT_ADDRESS1," ).append("\n"); 
		query.append("  '' AS PT_ADDRESS2," ).append("\n"); 
		query.append("  '' AS PT_ADDRESS3," ).append("\n"); 
		query.append("  '' AS PT_ADDRESS4," ).append("\n"); 
		query.append("  '' AS PT_VAT_ID," ).append("\n"); 
		query.append("  '' AS PT_CITY_NAME," ).append("\n"); 
		query.append("  '' AS PT_ST_PROV_CD," ).append("\n"); 
		query.append("  (SELECT OFC_ZIP_CD  FROM MDM_ORGANIZATION WHERE F.AR_OFC_CD = OFC_CD AND DELT_FLG ='N' AND ROWNUM =1 ) AS PT_ZIP_CD," ).append("\n"); 
		query.append("  (SELECT VNDR_CNT_CD  FROM MDM_ORGANIZATION WHERE F.AR_OFC_CD = OFC_CD AND DELT_FLG ='N' AND ROWNUM =1 ) AS PT_COUNTRY_CD," ).append("\n"); 
		query.append("  '' AS PT_EML," ).append("\n"); 
		query.append("  '' AS PT_FAX," ).append("\n"); 
		query.append("  '' AS PT_TEL," ).append("\n"); 
		query.append("  '' AS PT_BA" ).append("\n"); 
		query.append(" FROM AR_CUSTOMER F, MDM_CR_CUST H, MDM_CUST_ADDR I , MDM_CUSTOMER J" ).append("\n"); 
		query.append(" WHERE   F.C_CUST_CNT_CD =H.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.C_CUST_SEQ    =H.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     F.C_CUST_CNT_CD =I.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.C_CUST_SEQ    =I.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     F.C_CUST_CNT_CD =J.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.C_CUST_SEQ    =J.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     I.DELT_FLG <>'Y'" ).append("\n"); 
		query.append(" AND     ROWNUM = 1" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("  'PTO' PT_TYPE," ).append("\n"); 
		query.append("  F.N_CUST_CNT_CD ||LPAD(F.N_CUST_SEQ, 6, '0') AS PT_CD," ).append("\n"); 
		query.append("   SUBSTR(NVL(H.LOCL_NM, J.CUST_LGL_ENG_NM),1,50) PT_NAME , " ).append("\n"); 
		query.append("  NVL(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4, I.BZET_ADDR) PT_ADDRESS," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR1)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4), '', " ).append("\n"); 
		query.append("      DECODE(F.P_CUST_CNT_CD, 'TB', DECODE(I.PRMRY_CHK_FLG, 'Y', " ).append("\n"); 
		query.append("        DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4), '', SUBSTR(I.BZET_ADDR, 1, 50), I.LOCL_ADDR1), '')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG, 'Y', DECODE(SUBSTR(I.BZET_ADDR, 1, 50), '', '', SUBSTR(I.BZET_ADDR, 1, 50)), '')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS1," ).append("\n"); 
		query.append("  --(SELECT SUBSTR(OFC_ENG_NM, INSTRB(OFC_ENG_NM, ',') + 1) FROM MDM_ORGANIZATION WHERE OFC_CD = 'HAMSC') PT_IFR_ADDRESS1," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR2)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(F.N_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4),'',SUBSTR(I.BZET_ADDR,51,100),I.LOCL_ADDR2),'')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(SUBSTR(I.BZET_ADDR,51,100),'','', SUBSTR(I.BZET_ADDR,51,100)),'')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS2," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR3)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(F.N_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4),'',SUBSTR(I.BZET_ADDR,101,150),I.LOCL_ADDR3),'')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(SUBSTR(I.BZET_ADDR,101,150),'','', SUBSTR(I.BZET_ADDR,101,150)),'')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS3," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(H.LOCL_ADDR4)," ).append("\n"); 
		query.append("    DECODE(TRIM(H.LOCL_ADDR1 || H.LOCL_ADDR2 || H.LOCL_ADDR3 || H.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(F.N_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(I.PRMRY_CHK_FLG,'Y',DECODE(TRIM(I.LOCL_ADDR1||I.LOCL_ADDR2||I.LOCL_ADDR3||I.LOCL_ADDR4),'',SUBSTR(I.BZET_ADDR,151,200),I.LOCL_ADDR4)||DECODE(I.ZIP_CD,'','',', '||I.ZIP_CD)||DECODE(I.CTY_NM,'','',', '||I.CTY_NM),'')," ).append("\n"); 
		query.append("          DECODE(I.PRMRY_CHK_FLG,'Y',SUBSTR(I.BZET_ADDR,151,200)||DECODE(I.ZIP_CD,'','','  '||I.ZIP_CD)||DECODE(I.CTY_NM,'','',', '||I.CTY_NM))))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS4," ).append("\n"); 
		query.append("  J.CUST_RGST_NO AS PT_VAT_ID," ).append("\n"); 
		query.append("  I.CTY_NM  AS PT_CITY_NAME," ).append("\n"); 
		query.append("  I.STE_CD  AS PT_ST_PROV_CD," ).append("\n"); 
		query.append("  I.ZIP_CD  AS PT_ZIP_CD," ).append("\n"); 
		query.append("  I.CNT_CD  AS PT_COUNTRY_CD," ).append("\n"); 
		query.append("  DECODE(  @[io_bnd_cd], 'O', H.OB_EML, H.IB_EML) AS PT_EML," ).append("\n"); 
		query.append("  DECODE(  @[io_bnd_cd], 'O', H.OB_FAX_NO, H.IB_FAX_NO) AS PT_FAX," ).append("\n"); 
		query.append("  DECODE(  @[io_bnd_cd], 'O', H.OB_PHN_NO, H.IB_PHN_NO) AS PT_EML," ).append("\n"); 
		query.append("  '' AS PT_BA" ).append("\n"); 
		query.append(" FROM AR_CUSTOMER F, MDM_CR_CUST H, MDM_CUST_ADDR I , MDM_CUSTOMER J" ).append("\n"); 
		query.append(" WHERE   F.N_CUST_CNT_CD =H.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.N_CUST_SEQ    =H.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     F.N_CUST_CNT_CD =I.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.N_CUST_SEQ    =I.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     F.N_CUST_CNT_CD =J.CUST_CNT_CD(+)" ).append("\n"); 
		query.append(" AND     F.N_CUST_SEQ    =J.CUST_SEQ(+)" ).append("\n"); 
		query.append(" AND     I.DELT_FLG <>'Y'" ).append("\n"); 
		query.append(" AND     ROWNUM = 1" ).append("\n"); 

	}
}