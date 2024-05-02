/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchBlCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
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

public class EurCustomsTransmissionDBDAOsearchBlCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ENS 쪽 CUST 정보를 조회 한다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchBlCustRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchBlCustRSQL").append("\n"); 
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
		query.append("/* Eur24BlCustListVOs Eur24CustomsTransmissionDBDAOSearchBlCust ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd) */" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  DECODE(BKG_CUST_TP_CD,'C','CN','F','CG','S','CZ','CX') AS BL_PT_TYPE /* 76 CN-Consignee, CZ-Shipper, CG-Forwarder, CX-Notify  */" ).append("\n"); 
		query.append(" , '' AS BL_PT_TIN /* 77 */" ).append("\n"); 
		query.append(" , EORI_NO            AS  BL_PT_EORI       /* 78 */" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_NM,'X')      AS  BL_PT_NAME       /* 79 */" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_ADDR,'X')    AS  BL_PT_ADDRESS    /* 80 */" ).append("\n"); 
		query.append(" , EUR_CSTMS_ST_NM    AS  BL_PT_STREET     /* 81 */" ).append("\n"); 
		query.append(" , CUST_CTY_NM        AS  BL_PT_CITY       /* 82 */" ).append("\n"); 
		query.append(" , CUST_ZIP_ID        AS  BL_PT_POSTAL_CD  /* 83 */" ).append("\n"); 
		query.append(" , CSTMS_DECL_CNT_CD  AS  BL_PT_CNT_CD     /* 84 */    " ).append("\n"); 
		query.append(" , (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("      FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("     WHERE CNT_CD       = 'EU'" ).append("\n"); 
		query.append("       AND CSTMS_DIV_ID = 'BL_PT_AG_ATLAS'" ).append("\n"); 
		query.append("       AND ATTR_CTNT1   = X.CUST_CNT_CD || X.CUST_SEQ" ).append("\n"); 
		query.append("   ) AS BL_PT_AG_ATLAS" ).append("\n"); 
		query.append(" ,   VSL_CD,            SKD_VOY_NO,       SKD_DIR_CD,  BL_NO,      CSTMS_PORT_CD, BKG_CUST_TP_CD" ).append("\n"); 
		query.append(" , TRDR_ID_NO,        EORI_NO,          CUST_NM,     CUST_ADDR,    CUST_CTY_NM" ).append("\n"); 
		query.append(" , CSTMS_DECL_CNT_CD, CUST_ZIP_ID " ).append("\n"); 
		query.append(" , CRE_USR_ID, CRE_DT,UPD_USR_ID,       UPD_DT" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_EUR_CUST X" ).append("\n"); 
		query.append("WHERE (X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.BL_NO, X.CSTMS_PORT_CD) = (" ).append("\n"); 
		query.append("            SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BL_NO, CSTMS_PORT_CD" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND MSG_SND_NO = (" ).append("\n"); 
		query.append("                            SELECT NVL(MAX(A.MSG_SND_NO), ' ')" ).append("\n"); 
		query.append("                            FROM BKG_CSTMS_ADV_EUR_SND A " ).append("\n"); 
		query.append("                            WHERE A.MSG_SND_NO LIKE @[bl_no] ||'%'" ).append("\n"); 
		query.append("                            AND EUR_EDI_MSG_TP_ID = 'ENS'" ).append("\n"); 
		query.append("                            GROUP BY A.BL_NO" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        )            " ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD IN ('N','F','S')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /* EDI 전송시 Consignee 항목 bkg_booking.CUST_TO_ORD_FLG='Y') 일때, Notify 정보 사용. S -SHIPPER, N-NOTIFY */" ).append("\n"); 
		query.append("  'CN' AS BL_PT_TYPE /* 76 */" ).append("\n"); 
		query.append(" , '' AS BL_PT_TIN /* 77 */" ).append("\n"); 
		query.append(" , EORI_NO            AS  BL_PT_EORI       /* 78 */" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_NM,'X')      AS  BL_PT_NAME       /* 79 */" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CUST_ADDR,'X')    AS  BL_PT_ADDRESS    /* 80 */" ).append("\n"); 
		query.append(" , EUR_CSTMS_ST_NM    AS  BL_PT_STREET     /* 81 */" ).append("\n"); 
		query.append(" , CUST_CTY_NM        AS  BL_PT_CITY       /* 82 */" ).append("\n"); 
		query.append(" , CUST_ZIP_ID        AS  BL_PT_POSTAL_CD  /* 83 */" ).append("\n"); 
		query.append(" , CSTMS_DECL_CNT_CD  AS  BL_PT_CNT_CD     /* 84 */    " ).append("\n"); 
		query.append(" , (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("      FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("     WHERE CNT_CD       = 'EU'" ).append("\n"); 
		query.append("       AND CSTMS_DIV_ID = 'BL_PT_AG_ATLAS'" ).append("\n"); 
		query.append("       AND ATTR_CTNT1   = X.CUST_CNT_CD || X.CUST_SEQ" ).append("\n"); 
		query.append("   ) AS BL_PT_AG_ATLAS" ).append("\n"); 
		query.append(" ,   VSL_CD,            SKD_VOY_NO,       SKD_DIR_CD,  BL_NO,      CSTMS_PORT_CD, BKG_CUST_TP_CD" ).append("\n"); 
		query.append(" , TRDR_ID_NO,        EORI_NO,          CUST_NM,     CUST_ADDR,    CUST_CTY_NM" ).append("\n"); 
		query.append(" , CSTMS_DECL_CNT_CD, CUST_ZIP_ID" ).append("\n"); 
		query.append(" , CRE_USR_ID, CRE_DT,UPD_USR_ID,       UPD_DT" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_EUR_CUST X" ).append("\n"); 
		query.append("WHERE (X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.BL_NO, X.CSTMS_PORT_CD) = (" ).append("\n"); 
		query.append("            SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BL_NO, CSTMS_PORT_CD" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND MSG_SND_NO = (" ).append("\n"); 
		query.append("                            SELECT NVL(MAX(A.MSG_SND_NO), ' ')" ).append("\n"); 
		query.append("                            FROM BKG_CSTMS_ADV_EUR_SND A " ).append("\n"); 
		query.append("                            WHERE A.MSG_SND_NO LIKE @[bl_no] ||'%'" ).append("\n"); 
		query.append("                            AND EUR_EDI_MSG_TP_ID = 'ENS'" ).append("\n"); 
		query.append("                            GROUP BY A.BL_NO" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        )            " ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD = DECODE((SELECT CUST_TO_ORD_FLG FROM BKG_BOOKING WHERE BL_NO = X.BL_NO), 'Y','N','C')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY DECODE(BL_PT_TYPE,'CZ',1,'CN',2,'CX',3,4)" ).append("\n"); 

	}
}