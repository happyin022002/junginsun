/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.12.02 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCustInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCustInfoRSQL").append("\n"); 
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
		query.append("SELECT TB.*" ).append("\n"); 
		query.append("      ,CASE WHEN LENGTH(S02_B) > 70 " ).append("\n"); 
		query.append("            THEN RPAD('S02' || SUBSTR(S02_B, 1, 70), 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            ELSE RPAD('S02' || S02_B, 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("        END S02" ).append("\n"); 
		query.append("      ,CASE WHEN LENGTH(S02_B) > 70 " ).append("\n"); 
		query.append("            THEN RPAD('S03' || SUBSTR(S02_B, 71) || ' ' || S03_B , 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            WHEN S03_B IS NOT NULL" ).append("\n"); 
		query.append("            THEN RPAD('S03' || S03_B, 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("        END S03" ).append("\n"); 
		query.append("      ,CASE WHEN LENGTH(U02_B) > 70 " ).append("\n"); 
		query.append("            THEN RPAD('U02' || SUBSTR(U02_B, 1, 70), 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            ELSE RPAD('U02' || U02_B, 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("        END U02" ).append("\n"); 
		query.append("      ,CASE WHEN LENGTH(U02_B) > 70 " ).append("\n"); 
		query.append("            THEN RPAD('U03' || SUBSTR(U02_B, 71) || ' ' || U03_B , 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            WHEN U03_B IS NOT NULL" ).append("\n"); 
		query.append("            THEN RPAD('U03' || U03_B, 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("        END U03" ).append("\n"); 
		query.append("      ,CASE WHEN LENGTH(N02_B) > 70 " ).append("\n"); 
		query.append("            THEN RPAD('N02' || SUBSTR(N02_B, 1, 70), 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            ELSE RPAD('N02' || N02_B, 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("        END N02" ).append("\n"); 
		query.append("      ,CASE WHEN LENGTH(N02_B) > 70 " ).append("\n"); 
		query.append("            THEN RPAD('N03' || SUBSTR(N02_B, 71) || ' ' || N03_B , 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            WHEN N03_B IS NOT NULL" ).append("\n"); 
		query.append("            THEN RPAD('N03' || N03_B, 80, ' ') || CHR(10)" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("        END N03" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT A.BL_NO" ).append("\n"); 
		query.append("      ,RPAD('S01'||RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(A.CUST_NM),1, ''), 'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("                   RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(A.CUST_NM),2, ''), 'X')),'.'),35,' '),80,' ') || CHR(10) AS S01" ).append("\n"); 
		query.append("      ,RPAD('S02'||RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),1, ''), 'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("                   RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),2, ''), 'X')),'.'),35,' '),80,' ') || CHR(10) AS S02_OLD" ).append("\n"); 
		query.append("      ,DECODE(BKG_TOKEN_NL_FNC(A.CUST_ADDR, 3, ''), NULL, ''," ).append("\n"); 
		query.append("              RPAD('S03'||RPAD(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(A.CUST_ADDR, 3, ''), 'X') || TRIM(A.PHN_NO) || TRIM(A.FAX_NO), 35, ' '),80,' ') || CHR(10)" ).append("\n"); 
		query.append("              ) AS S03_OLD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,CASE WHEN A.CUST_CTY_NM IS NOT NULL AND A.CSTMS_DECL_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("            THEN BKG_SPCLCHAR_CONV_FNC(A.EUR_CSTMS_ST_NM || ' ' || A.CUST_CTY_NM || ' ' || A.CUST_STE_CD || ' ' || A.CUST_ZIP_ID || ' ' || A.CSTMS_DECL_CNT_CD, 'X')" ).append("\n"); 
		query.append("            ELSE RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),1, ''), 'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("                 RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),2, ''), 'X')),'.'),35,' ')" ).append("\n"); 
		query.append("        END AS S02_B" ).append("\n"); 
		query.append("      ,CASE WHEN A.PHN_NO IS NOT NULL OR A.FAX_NO IS NOT NULL" ).append("\n"); 
		query.append("            THEN BKG_SPCLCHAR_CONV_FNC(TRIM(A.PHN_NO) || ' ' || TRIM(A.FAX_NO), 'X')" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS S03_B" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,RPAD('U01'||RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(B.CUST_NM),1, ''), 'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("                   RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(B.CUST_NM),2, ''),'X')),'.'),35,' '),80,' ') || CHR(10) AS U01" ).append("\n"); 
		query.append("      ,RPAD('U02'||RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),1, ''),'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("                   RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),2, ''),'X')),'.'),35,' '),80,' ') || CHR(10) AS U02_OLD" ).append("\n"); 
		query.append("      ,DECODE(BKG_TOKEN_NL_FNC(B.CUST_ADDR, 3, ''), NULL, ''," ).append("\n"); 
		query.append("              RPAD('U03'||RPAD(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(B.CUST_ADDR, 3, ''), 'X') || TRIM(B.PHN_NO) || TRIM(B.FAX_NO), 35, ' '),80,' ') || CHR(10)" ).append("\n"); 
		query.append("              ) AS U03_OLD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,CASE WHEN B.CUST_CTY_NM IS NOT NULL AND B.CSTMS_DECL_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("            THEN BKG_SPCLCHAR_CONV_FNC(B.EUR_CSTMS_ST_NM || ' ' || B.CUST_CTY_NM || ' ' || B.CUST_STE_CD || ' ' || B.CUST_ZIP_ID || ' ' || B.CSTMS_DECL_CNT_CD, 'X')" ).append("\n"); 
		query.append("            ELSE RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),1, ''), 'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("                 RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),2, ''), 'X')),'.'),35,' ')" ).append("\n"); 
		query.append("        END AS U02_B" ).append("\n"); 
		query.append("      ,CASE WHEN B.PHN_NO IS NOT NULL OR B.FAX_NO IS NOT NULL" ).append("\n"); 
		query.append("            THEN BKG_SPCLCHAR_CONV_FNC(TRIM(B.PHN_NO) || ' ' || TRIM(B.FAX_NO), 'X')" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS U03_B" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("      ,RPAD('N01'||RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(C.CUST_NM),1, ''),'X')),'SAME AS CONSIGNEE'),35,' ')||" ).append("\n"); 
		query.append("                   RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(C.CUST_NM),2, ''),'X')),'.'),35,' '),80,' ') || CHR(10) AS N01" ).append("\n"); 
		query.append("      ,RPAD('N02'||RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),1, ''),'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("                   RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),2, ''),'X')),'.'),35,' '),80,' ') || CHR(10) AS N02_OLD" ).append("\n"); 
		query.append("      ,DECODE(BKG_TOKEN_NL_FNC(C.CUST_ADDR, 3, ''), NULL, ''," ).append("\n"); 
		query.append("              RPAD('N03'||RPAD(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(C.CUST_ADDR, 3, ''), 'X') || TRIM(C.PHN_NO) || TRIM(C.FAX_NO), 35, ' '),80,' ') || CHR(10)" ).append("\n"); 
		query.append("              ) AS N03_OLD" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("      ,CASE WHEN C.CUST_CTY_NM IS NOT NULL AND C.CSTMS_DECL_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("            THEN BKG_SPCLCHAR_CONV_FNC(C.EUR_CSTMS_ST_NM || ' ' || C.CUST_CTY_NM || ' ' || C.CUST_STE_CD || ' ' || C.CUST_ZIP_ID || ' ' || C.CSTMS_DECL_CNT_CD, 'X')" ).append("\n"); 
		query.append("            ELSE RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),1, ''), 'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("                 RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),2, ''), 'X')),'.'),35,' ')" ).append("\n"); 
		query.append("        END AS N02_B" ).append("\n"); 
		query.append("      ,CASE WHEN C.PHN_NO IS NOT NULL OR C.FAX_NO IS NOT NULL" ).append("\n"); 
		query.append("            THEN BKG_SPCLCHAR_CONV_FNC(TRIM(C.PHN_NO) || ' ' || TRIM(C.FAX_NO), 'X')" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("        END AS N03_B" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("      ,(SELECT 'X'" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_ORZ_PTY" ).append("\n"); 
		query.append("         WHERE NVL(CUST_CNT_CD, 'XXX') = DECODE(CUST_CNT_CD, '', 'XXX', DECODE(Bk.CUST_TO_ORD_FLG, 'Y',  C.CUST_CNT_CD , B.CUST_CNT_CD )) -- TO ordre Flg ='Y' 이면 Notify 아니면, Consignee 의 Customer_cd와비교" ).append("\n"); 
		query.append("           AND NVL(CUST_SEQ, 999999) = DECODE(CUST_SEQ, '', 999999, DECODE(Bk.CUST_TO_ORD_FLG, 'Y',  C.CUST_SEQ , B.CUST_SEQ ))" ).append("\n"); 
		query.append("           AND NVL(SC_NO, 'XXX') IN ('XXX', BK.SC_NO)" ).append("\n"); 
		query.append("           AND NVL(POD_CD, 'XXX') IN ('XXX',BL.POD_cD)" ).append("\n"); 
		query.append("           AND NVL(DEL_CD, 'XXX') IN ('XXX',BL.DEL_cD)" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND ROWNUM=1" ).append("\n"); 
		query.append("       ) ORZ_PTY" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_CUST A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CUST B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CUST C" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER       BS" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER       BC" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER       BN" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL   BL" ).append("\n"); 
		query.append("      ,BKG_BOOKING        BK" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.CNT_CD         = 'US'" ).append("\n"); 
		query.append("   AND A.BL_NO          = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND B.CNT_CD         = A.CNT_CD" ).append("\n"); 
		query.append("   AND B.BL_NO          = A.BL_NO" ).append("\n"); 
		query.append("   AND B.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND C.CNT_CD(+)      = A.CNT_CD" ).append("\n"); 
		query.append("   AND C.BL_NO(+)       = A.BL_NO" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND BS.BKG_NO(+)        = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BS.BKG_CUST_TP_CD(+)= 'S'" ).append("\n"); 
		query.append("   AND BC.BKG_NO(+)        = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BC.BKG_CUST_TP_CD(+)= 'C'" ).append("\n"); 
		query.append("   AND BN.BKG_NO(+)     = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BN.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND BL.BL_NO         = A.BL_NO" ).append("\n"); 
		query.append("   AND BL.BKG_NO        = BK.BKG_NO(+)" ).append("\n"); 
		query.append(")TB" ).append("\n"); 

	}
}