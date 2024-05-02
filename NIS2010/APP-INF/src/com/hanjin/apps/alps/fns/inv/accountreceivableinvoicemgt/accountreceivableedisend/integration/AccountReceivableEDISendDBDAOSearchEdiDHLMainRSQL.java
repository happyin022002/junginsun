/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiDHLMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.14 
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

public class AccountReceivableEDISendDBDAOSearchEdiDHLMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiDHLMain
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiDHLMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiDHLMainRSQL").append("\n"); 
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
		query.append("SELECT A.INV_NO INV_NUMBER," ).append("\n"); 
		query.append("  NVL(A.ISS_DT, A.RISS_DT) INV_CREATION_DATE," ).append("\n"); 
		query.append("  C.ACT_CUST_CNT_CD || LPAD(TO_CHAR(C.ACT_CUST_SEQ), 6, '0') PT_CD," ).append("\n"); 
		query.append("  DECODE(C.CUST_CR_FLG, 'Y', DECODE(NVL(E.CUST_RLSE_CTRL_FLG, 'N'), 'Y', NVL(A.ISS_DT, A.RISS_DT), DECODE(NVL(E.INV_DUE_DT_DP_FLG, 'N'), 'Y', NVL(A.ISS_DT, A.RISS_DT), C.DUE_DT)), NVL(A.ISS_DT, A.RISS_DT)) INV_DUE_DATE," ).append("\n"); 
		query.append("  (SELECT K.INV_REF_NO" ).append("\n"); 
		query.append("   FROM INV_AR_MN K" ).append("\n"); 
		query.append("   WHERE K.AR_IF_NO = (SELECT SUBSTR(MAX(DECODE(V1.REV_TP_CD, 'M', '1', '2')||V1.AR_IF_NO), 2,11)" ).append("\n"); 
		query.append("                       FROM INV_AR_MN V1, INV_AR_ISS_DTL V2" ).append("\n"); 
		query.append("                       WHERE V1.AR_IF_NO = V2.AR_IF_NO AND V1.INV_REF_NO IS NOT NULL AND V2.INV_NO = A.INV_NO)" ).append("\n"); 
		query.append("  ) EXT_CUST_REF," ).append("\n"); 
		query.append("  SUBSTR(NVL(E.LOCL_NM, D.CUST_LGL_ENG_NM),1,50) PT_NAME," ).append("\n"); 
		query.append("  NVL(E.LOCL_ADDR1 || E.LOCL_ADDR2 || E.LOCL_ADDR3 || E.LOCL_ADDR4, F.BZET_ADDR) PT_ADDRESS," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(E.LOCL_ADDR1)," ).append("\n"); 
		query.append("    DECODE(TRIM(E.LOCL_ADDR1 || E.LOCL_ADDR2 || E.LOCL_ADDR3 || E.LOCL_ADDR4), '', " ).append("\n"); 
		query.append("      DECODE(C.ACT_CUST_CNT_CD, 'TB', DECODE(F.PRMRY_CHK_FLG, 'Y', " ).append("\n"); 
		query.append("        DECODE(TRIM(F.LOCL_ADDR1||F.LOCL_ADDR2||F.LOCL_ADDR3||F.LOCL_ADDR4), '', SUBSTR(F.BZET_ADDR, 1, 50), F.LOCL_ADDR1), '')," ).append("\n"); 
		query.append("          DECODE(F.PRMRY_CHK_FLG, 'Y', DECODE(SUBSTR(F.BZET_ADDR, 1, 50), '', '', SUBSTR(F.BZET_ADDR, 1, 50)), '')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS1," ).append("\n"); 
		query.append("  (SELECT SUBSTR(OFC_ENG_NM, INSTRB(OFC_ENG_NM, ',') + 1) FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd]) PT_IFR_ADDRESS1," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(E.LOCL_ADDR2)," ).append("\n"); 
		query.append("    DECODE(TRIM(E.LOCL_ADDR1 || E.LOCL_ADDR2 || E.LOCL_ADDR3 || E.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(C.ACT_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(F.PRMRY_CHK_FLG,'Y',DECODE(TRIM(F.LOCL_ADDR1||F.LOCL_ADDR2||F.LOCL_ADDR3||F.LOCL_ADDR4),'',SUBSTR(F.BZET_ADDR,51,100),F.LOCL_ADDR2),'')," ).append("\n"); 
		query.append("          DECODE(F.PRMRY_CHK_FLG,'Y',DECODE(SUBSTR(F.BZET_ADDR,51,100),'','', SUBSTR(F.BZET_ADDR,51,100)),'')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS2," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(E.LOCL_ADDR3)," ).append("\n"); 
		query.append("    DECODE(TRIM(E.LOCL_ADDR1 || E.LOCL_ADDR2 || E.LOCL_ADDR3 || E.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(C.ACT_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(F.PRMRY_CHK_FLG,'Y',DECODE(TRIM(F.LOCL_ADDR1||F.LOCL_ADDR2||F.LOCL_ADDR3||F.LOCL_ADDR4),'',SUBSTR(F.BZET_ADDR,101,150),F.LOCL_ADDR3),'')," ).append("\n"); 
		query.append("          DECODE(F.PRMRY_CHK_FLG,'Y',DECODE(SUBSTR(F.BZET_ADDR,101,150),'','', SUBSTR(F.BZET_ADDR,101,150)),'')))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS3," ).append("\n"); 
		query.append("  SUBSTR(NVL(TRIM(E.LOCL_ADDR4)," ).append("\n"); 
		query.append("    DECODE(TRIM(E.LOCL_ADDR1 || E.LOCL_ADDR2 || E.LOCL_ADDR3 || E.LOCL_ADDR4),''," ).append("\n"); 
		query.append("      DECODE(C.ACT_CUST_CNT_CD,'TB'," ).append("\n"); 
		query.append("        DECODE(F.PRMRY_CHK_FLG,'Y',DECODE(TRIM(F.LOCL_ADDR1||F.LOCL_ADDR2||F.LOCL_ADDR3||F.LOCL_ADDR4),'',SUBSTR(F.BZET_ADDR,151,200),F.LOCL_ADDR4)||DECODE(F.ZIP_CD,'','',', '||F.ZIP_CD)||DECODE(F.CTY_NM,'','',', '||F.CTY_NM),'')," ).append("\n"); 
		query.append("          DECODE(F.PRMRY_CHK_FLG,'Y',SUBSTR(F.BZET_ADDR,151,200)||DECODE(F.ZIP_CD,'','','  '||F.ZIP_CD)||DECODE(F.CTY_NM,'','',', '||F.CTY_NM))))), 1, 50" ).append("\n"); 
		query.append("  ) PT_ADDRESS4," ).append("\n"); 
		query.append("  D.CUST_RGST_NO PT_VAT_ID," ).append("\n"); 
		query.append("  G.VSL_ENG_NM FULL_VSL_NM," ).append("\n"); 
		query.append("  C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD BKG_VVD," ).append("\n"); 
		query.append("  C.POR_CD BL_POR_CD," ).append("\n"); 
		query.append("  R.LOC_NM BL_POR_NM," ).append("\n"); 
		query.append("  C.POL_CD BL_POL_CD," ).append("\n"); 
		query.append("  H.LOC_NM BL_POL_NM," ).append("\n"); 
		query.append("  C.POD_CD BL_POD_CD," ).append("\n"); 
		query.append("  I.LOC_NM BL_POD_NM," ).append("\n"); 
		query.append("  C.DEL_CD BL_DEL_CD," ).append("\n"); 
		query.append("  DD.LOC_NM BL_DEL_NM," ).append("\n"); 
		query.append("  C.SAIL_DT POL_DATE," ).append("\n"); 
		query.append("  C.SAIL_ARR_DT POD_DATE," ).append("\n"); 
		query.append("  C.BL_SRC_NO BL_NO," ).append("\n"); 
		query.append("  C.BKG_NO BKG_NO," ).append("\n"); 
		query.append("  C.INV_RMK BKG_REMARK," ).append("\n"); 
		query.append("  C.IO_BND_CD FC_PAYAT" ).append("\n"); 
		query.append("FROM INV_AR_ISS A," ).append("\n"); 
		query.append("  INV_AR_ISS_DTL B," ).append("\n"); 
		query.append("  INV_AR_MN C," ).append("\n"); 
		query.append("  MDM_CUSTOMER D," ).append("\n"); 
		query.append("  MDM_CR_CUST E," ).append("\n"); 
		query.append("  MDM_CUST_ADDR F," ).append("\n"); 
		query.append("  MDM_VSL_CNTR G," ).append("\n"); 
		query.append("  MDM_LOCATION H," ).append("\n"); 
		query.append("  MDM_LOCATION I," ).append("\n"); 
		query.append("  MDM_LOCATION R," ).append("\n"); 
		query.append("  MDM_LOCATION DD" ).append("\n"); 
		query.append("WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("  AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("  AND C.ACT_CUST_CNT_CD = D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND C.ACT_CUST_SEQ = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND C.ACT_CUST_CNT_CD = E.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND C.ACT_CUST_SEQ = E.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND C.ACT_CUST_CNT_CD = F.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND C.ACT_CUST_SEQ = F.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND F.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("  AND C.VSL_CD = G.VSL_CD(+)" ).append("\n"); 
		query.append("  AND C.POL_CD = H.LOC_CD(+)" ).append("\n"); 
		query.append("  AND C.POD_CD = I.LOC_CD(+)" ).append("\n"); 
		query.append("  AND C.POR_CD = R.LOC_CD(+)" ).append("\n"); 
		query.append("  AND C.DEL_CD = DD.LOC_CD(+)" ).append("\n"); 
		query.append("  AND A.INV_SEQ = (SELECT MAX(B.INV_SEQ) FROM INV_AR_ISS B" ).append("\n"); 
		query.append("                   WHERE   B.INV_NO = A.INV_NO)" ).append("\n"); 
		query.append("  AND C.AR_IF_NO = (SELECT DECODE(MAX(Z3.INV_DUP_FLG),'Y',SUBSTR(MAX(DECODE(Z2.REV_TP_CD, 'M', '1', '2')||Z1.AR_IF_NO), 2,11),MAX(Z1.AR_IF_NO))" ).append("\n"); 
		query.append("                    FROM INV_AR_ISS_DTL Z1, INV_AR_MN Z2, INV_AR_STUP_OFC Z3 " ).append("\n"); 
		query.append("                    WHERE Z1.AR_IF_NO = Z2.AR_IF_NO AND Z2.AR_OFC_CD = Z3.AR_OFC_CD(+) AND Z1.INV_NO = A.INV_NO)" ).append("\n"); 
		query.append("  AND C.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("  AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 
		query.append("ORDER BY A.INV_NO, C.AR_IF_NO DESC" ).append("\n"); 

	}
}