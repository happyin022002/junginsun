/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DominicanManifestDownloadDBDAOsearchManifestBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DominicanManifestDownloadDBDAOsearchManifestBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * manifest bl 정보 조회
	  * </pre>
	  */
	public DominicanManifestDownloadDBDAOsearchManifestBLRSQL(){
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.integration").append("\n"); 
		query.append("FileName : DominicanManifestDownloadDBDAOsearchManifestBLRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("          BK.BL_NO" ).append("\n"); 
		query.append("         , 'IG9016-C' BL_TYPE" ).append("\n"); 
		query.append("         , 'IG9035-I' Transit_Type" ).append("\n"); 
		query.append("         , BV.POD_CD Last_Port_Code" ).append("\n"); 
		query.append("         , BV.POL_CD Loading_Port_Code" ).append("\n"); 
		query.append("         , REPLACE(REPLACE((NVL(BBD.PCK_CMDT_DESC, '') || CHR(10) || NVL(BBD.CNTR_CMDT_DESC, '') || CHR(10) ||  NVL(BBMD.CMDT_DESC, '')),CHR(9),''),CHR(13),'') Goods_Name" ).append("\n"); 
		query.append("         , BBD.PCK_TP_CD Package_Unit_Code" ).append("\n"); 
		query.append("         , BBD.PCK_QTY Package_Qty" ).append("\n"); 
		query.append("         , '' Gross_Weight" ).append("\n"); 
		query.append("         , '' value" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,( SELECT SUM(CHG_AMT) FROM BKG_CHG_RT WHERE BKG_NO = BK.BKG_NO AND CHG_CD = 'OFT') Flight_Charge" ).append("\n"); 
		query.append("         , '' volume" ).append("\n"); 
		query.append("         , 'IG1015-G' Express_Type" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         , 'SA09-002' Consignor_Type" ).append("\n"); 
		query.append("         , BCS.CUST_CNT_CD || BCS.CUST_SEQ AS Consignor_Code" ).append("\n"); 
		query.append("         , BCS_C.PHN_NO Consignor_Tel" ).append("\n"); 
		query.append("         , BCS.CUST_CNT_CD Consignor_Country_Code" ).append("\n"); 
		query.append("         , BCS.CUST_NM Consignor_Name" ).append("\n"); 
		query.append("         , 'SA13-RNC' Consignor_Document_Type" ).append("\n"); 
		query.append("         , 'B0103_DGA' Consignor_Document_No" ).append("\n"); 
		query.append("         , BCS.CUST_EML Consignor_Email" ).append("\n"); 
		query.append("         , BCS.CUST_FAX_NO Consignee_Fax" ).append("\n"); 
		query.append("         , BCS.CUST_ZIP_ID Consignor_Zip_Code" ).append("\n"); 
		query.append("         , BCS.CUST_STE_CD  Consignor_Street" ).append("\n"); 
		query.append("         , '' Consignor_Zone_Name" ).append("\n"); 
		query.append("         , BCS.CUST_CTY_NM Consignor_City" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , 'SA09-002' Consignee_Type" ).append("\n"); 
		query.append("         , BCC.CUST_CNT_CD || BCC.CUST_SEQ AS Consignee_Code" ).append("\n"); 
		query.append("         , BCC_C.PHN_NO Consignee_Tel" ).append("\n"); 
		query.append("         , BCC.CUST_CNT_CD Consignee_Country_Code" ).append("\n"); 
		query.append("         , BCC.CUST_NM Consignee_Name" ).append("\n"); 
		query.append("         , 'SA13-RNC' Consignee_Document_Type" ).append("\n"); 
		query.append("         , 'B0103_DGA' Consignee_Document_No" ).append("\n"); 
		query.append("         , BCC.CUST_EML Consignee_Email" ).append("\n"); 
		query.append("         , BCC.CUST_FAX_NO Consignee_Fax" ).append("\n"); 
		query.append("         , BCC.CUST_ZIP_ID Consignee_Zip_Code" ).append("\n"); 
		query.append("         , BCC.CUST_STE_CD  Consignee_Street" ).append("\n"); 
		query.append("         , '' Consignee_Zone_Name" ).append("\n"); 
		query.append("         , BCC.CUST_CTY_NM Consignee_City" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , 'SA09-002' Notify_Type" ).append("\n"); 
		query.append("         , BCN.CUST_CNT_CD || BCN.CUST_SEQ AS Notify_Code" ).append("\n"); 
		query.append("         , BCN.CUST_CNT_CD Notify_Country_Code" ).append("\n"); 
		query.append("         , 'SA13-RNC' Notify_Document_Type" ).append("\n"); 
		query.append("         , 'B0103_DGA' Notify_Document_No" ).append("\n"); 
		query.append("         , BCN.CUST_NM Notify_Name" ).append("\n"); 
		query.append("         , BCN.CUST_EML Notify_Email" ).append("\n"); 
		query.append("         , BCN_C.PHN_NO Notify_Tel" ).append("\n"); 
		query.append("         , BCN.CUST_FAX_NO Notify_Fax" ).append("\n"); 
		query.append("         , BCN.CUST_ZIP_ID Notify_Zip_Code" ).append("\n"); 
		query.append("         , BCN.CUST_STE_CD  Notify_Street" ).append("\n"); 
		query.append("         , '' Notify_Zone_Name" ).append("\n"); 
		query.append("         , BCN.CUST_CTY_NM Notify_City" ).append("\n"); 
		query.append("                                              " ).append("\n"); 
		query.append("  FROM   " ).append("\n"); 
		query.append("        BKG_VVD BV" ).append("\n"); 
		query.append("        ,BKG_BOOKING BK                                                                               " ).append("\n"); 
		query.append("        ,BKG_BL_ISS  BBI                                                                              " ).append("\n"); 
		query.append("        ,BKG_BL_DOC  BBD                                                                              " ).append("\n"); 
		query.append("        ,BKG_RATE    BR                                                                               " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCS                                                                             " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCC                                                                             " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCN                                                                             " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCF                                                                             " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCA                                                                             " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCE    " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , MDM_CUST_CNTC_PNT BCS_C" ).append("\n"); 
		query.append("        , MDM_CUST_CNTC_PNT BCC_C" ).append("\n"); 
		query.append("        , MDM_CUST_CNTC_PNT BCN_C" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,BKG_BL_MK_DESC BBMD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,BKG_CSTMS_CMDT   CMD                                                                         " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC0                                                                        " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC1                                                                        " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC2                                                                        " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC3                                                                        " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC4                                                                        " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC5                                                                        " ).append("\n"); 
		query.append("        ,MDM_ORGANIZATION OFC                                                                         " ).append("\n"); 
		query.append("        ,MDM_COMMODITY    COM                                                                         " ).append("\n"); 
		query.append(" WHERE BV.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND BV.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND BV.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND BV.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BV.BKG_NO" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BBI.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BBD.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BR.BKG_NO       (+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCS.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCS.BKG_CUST_TP_CD =   'S'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCC.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCC.BKG_CUST_TP_CD(+) =   'C'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCN.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCN.BKG_CUST_TP_CD(+) =   'N'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCF.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCF.BKG_CUST_TP_CD(+) =   'F'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCA.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCA.BKG_CUST_TP_CD(+) =   'A'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCE.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCE.BKG_CUST_TP_CD(+) =   'E'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND   LOC0.LOC_CD(+)     =  BV.POD_CD" ).append("\n"); 
		query.append("   AND   BK.POR_CD         =   LOC3.LOC_CD  (+)" ).append("\n"); 
		query.append("   AND   BK.POL_CD         =   LOC1.LOC_CD  (+)" ).append("\n"); 
		query.append("   AND   BK.POD_CD         =   LOC2.LOC_CD  (+)" ).append("\n"); 
		query.append("   AND   BK.DEL_CD         =   LOC4.LOC_CD  (+)" ).append("\n"); 
		query.append("   AND   LOC5.LOC_CD(+)    = NVL(BK.PRE_RLY_PORT_CD,' ')" ).append("\n"); 
		query.append("   AND   BBI.OBL_ISS_OFC_CD      = OFC.OFC_CD(+)" ).append("\n"); 
		query.append("   AND   BK.CMDT_CD         = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND   BK.CMDT_CD         = CMD.MF_CMDT_CD(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND   BK.BKG_NO = BBMD.BKG_NO (+)" ).append("\n"); 
		query.append("   AND   BBMD.MK_SEQ(+) = 1" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND   BCS.CUST_CNT_CD = BCS_C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND   BCS.CUST_SEQ    = BCS_C.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND   BCC.CUST_CNT_CD = BCC_C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND   BCC.CUST_SEQ    = BCC_C.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND   BCN.CUST_CNT_CD = BCN_C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND   BCN.CUST_SEQ    = BCN_C.CUST_SEQ(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 

	}
}