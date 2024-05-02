/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOsearchBlCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOsearchBlCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlCust
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOsearchBlCustRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOsearchBlCustRSQL").append("\n"); 
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
		query.append("    BL_PT_TYPE" ).append("\n"); 
		query.append("    ,BL_PT_TIN " ).append("\n"); 
		query.append("    ,BL_PT_EORI" ).append("\n"); 
		query.append("    ,BL_PT_NAME" ).append("\n"); 
		query.append("    ,BL_PT_ADDRESS" ).append("\n"); 
		query.append("    ,BL_PT_STREET" ).append("\n"); 
		query.append("    ,BL_PT_CITY" ).append("\n"); 
		query.append("    ,BL_PT_POSTAL_CD" ).append("\n"); 
		query.append("    ,BL_PT_CNT_CD" ).append("\n"); 
		query.append("    ,VSL_CD" ).append("\n"); 
		query.append("    ,SKD_VOY_NO" ).append("\n"); 
		query.append("    ,SKD_DIR_CD" ).append("\n"); 
		query.append("    ,BKG_NO" ).append("\n"); 
		query.append("    ,POL_CD" ).append("\n"); 
		query.append("    ,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("    ,TRDR_ID_NO" ).append("\n"); 
		query.append("    ,EORI_NO" ).append("\n"); 
		query.append("    ,CUST_NM" ).append("\n"); 
		query.append("    ,CUST_ADDR" ).append("\n"); 
		query.append("    ,CUST_CTY_NM" ).append("\n"); 
		query.append("    ,CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("    ,CUST_ZIP_ID " ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,'' AS BL_PT_CON_NAME" ).append("\n"); 
		query.append("    ,'' AS BL_PT_FAX_NO" ).append("\n"); 
		query.append("    ,'' AS BL_PT_EM_NO" ).append("\n"); 
		query.append("    ,'' AS BL_PT_TEL_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  DECODE(BKG_CUST_TP_CD,'C','CN','F','CG','S','CZ','CX') AS BL_PT_TYPE" ).append("\n"); 
		query.append(" , '' AS BL_PT_TIN " ).append("\n"); 
		query.append(" , EORI_NO            AS  BL_PT_EORI" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_NM,'X')      AS  BL_PT_NAME" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_ADDR,'X')    AS  BL_PT_ADDRESS" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(EUR_CSTMS_ST_NM,'X')    AS  BL_PT_STREET" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_CTY_NM,'X')        AS  BL_PT_CITY" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_ZIP_ID,'X')        AS  BL_PT_POSTAL_CD" ).append("\n"); 
		query.append(" , CSTMS_DECL_CNT_CD  AS  BL_PT_CNT_CD" ).append("\n"); 
		query.append(" , BK.VSL_CD,      BK.SKD_VOY_NO,    BK.SKD_DIR_CD,  BK.BKG_NO,   BK.POL_CD, X.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(" , '' TRDR_ID_NO,        EORI_NO,          CUST_NM,     CUST_ADDR,    CUST_CTY_NM" ).append("\n"); 
		query.append(" , CSTMS_DECL_CNT_CD, CUST_ZIP_ID " ).append("\n"); 
		query.append(" , BK.CRE_USR_ID, BK.CRE_DT,BK.UPD_USR_ID,       BK.UPD_DT" ).append("\n"); 
		query.append("FROM  BKG_CUSTOMER X" ).append("\n"); 
		query.append("    , BKG_BOOKING BK " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("AND BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND X.BKG_CUST_TP_CD IN ('N','F','S')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /* EDI 전송시 Consignee 항목 bkg_booking.CUST_TO_ORD_FLG='Y') 일때, Notify 정보 사용. S -SHIPPER, N-NOTIFY */" ).append("\n"); 
		query.append("  'CN' AS BL_PT_TYPE" ).append("\n"); 
		query.append(" , '' AS BL_PT_TIN" ).append("\n"); 
		query.append(" , EORI_NO            AS  BL_PT_EORI" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_NM,'X')      AS  BL_PT_NAME" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_ADDR,'X')    AS  BL_PT_ADDRESS" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(EUR_CSTMS_ST_NM,'X')    AS  BL_PT_STREET" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_CTY_NM,'X')        AS  BL_PT_CITY" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_ZIP_ID,'X')        AS  BL_PT_POSTAL_CD" ).append("\n"); 
		query.append(" , CSTMS_DECL_CNT_CD  AS  BL_PT_CNT_CD" ).append("\n"); 
		query.append(" , BK.VSL_CD,     BK.SKD_VOY_NO,      BK.SKD_DIR_CD,  BK.BKG_NO,    BK.POL_CD, X.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(" , '' TRDR_ID_NO,        EORI_NO,          CUST_NM,     CUST_ADDR,    CUST_CTY_NM" ).append("\n"); 
		query.append(" , CSTMS_DECL_CNT_CD, CUST_ZIP_ID" ).append("\n"); 
		query.append(" , BK.CRE_USR_ID, BK.CRE_DT, BK.UPD_USR_ID,       BK.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER X" ).append("\n"); 
		query.append(", BKG_BOOKING BK " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("AND BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD = DECODE((SELECT CUST_TO_ORD_FLG FROM BKG_BOOKING WHERE BL_NO = X.BKG_NO), 'Y','N','C')" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("ORDER BY DECODE(BL_PT_TYPE,'CZ',1,'CN',2,'CX',3,4)" ).append("\n"); 

	}
}