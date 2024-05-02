/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCustLineInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.09
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.07.09 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCustLineInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCustLineInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCustLineInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("         A.BL_NO," ).append("\n"); 
		query.append("         RPAD('S01'||RPAD(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_NM),1), 'X'),35,' ')||" ).append("\n"); 
		query.append("             RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_NM),2), 'X')),'.'),35,' '),80,' ') BUF21," ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("         RPAD('S02'||RPAD(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),1), 'X'),35,' ')||" ).append("\n"); 
		query.append("             RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),2), 'X')),'.'),35,' '),80,' ') BUF21_1," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("         DECODE(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),3),NULL,SCE_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),3)," ).append("\n"); 
		query.append("               RPAD('S03'||RPAD(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),3), 'X'),35,' ')||" ).append("\n"); 
		query.append("             SUBSTR(NVL(RTRIM(A.PHN_NO),' ')||NVL(RTRIM(A.FAX_NO),' '),1,35),80,' ')) BUF22," ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("         RPAD('U01'||RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_NM),1), 'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("               RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_NM),2),'X')),'.'),35,' '),80,' ') BUF23," ).append("\n"); 
		query.append("         RPAD('U02'||RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),1), 'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("               RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),2),'X')),'.'),35,' '),80,' ') BUF23_1," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("         DECODE(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),3),NULL,SCE_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),3)," ).append("\n"); 
		query.append("               RPAD('U03'||RPAD(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),3),'X'),35,' ')||" ).append("\n"); 
		query.append("            SUBSTR(NVL(RTRIM(B.PHN_NO),' ')||NVL(RTRIM(B.FAX_NO),' '),1,35),80,' ')) BUF24," ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("         RPAD('N01'||RPAD(NVL(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_NM),1),'X'),'SAME AS CONSIGNEE'),35,' ')||" ).append("\n"); 
		query.append("               RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_NM),2),'X')),'.'),35,' '),80,' ') BUF25," ).append("\n"); 
		query.append("         RPAD('N02'||RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),1),'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("               RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),2),'X')),'.'),35,' '),80,' ') BUF25_1," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("         DECODE(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),3),NULL,SCE_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),3)," ).append("\n"); 
		query.append("               RPAD('N03'||RPAD(BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(RTRIM(C.CUST_ADDR),3),'X'),35,' ')||" ).append("\n"); 
		query.append("             SUBSTR(NVL(RTRIM(C.PHN_NO),' ')||NVL(RTRIM(C.FAX_NO),' '),1,35),80,' ')) BUF26" ).append("\n"); 
		query.append("         ,(" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("            SELECT   " ).append("\n"); 
		query.append("            'X'" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_ADV_ORZ_PTY " ).append("\n"); 
		query.append("            WHERE NVL(CUST_CNT_CD, 'XXX') = DECODE(CUST_CNT_CD, '', 'XXX', DECODE(Bk.CUST_TO_ORD_FLG, 'Y',  C.CUST_CNT_CD , B.CUST_CNT_CD )) -- TO ordre Flg ='Y' 이면 Notify 아니면, Consignee 의 Customer_cd와비교" ).append("\n"); 
		query.append("			AND NVL(CUST_SEQ, 999999) = DECODE(CUST_SEQ, '', 999999, DECODE(Bk.CUST_TO_ORD_FLG, 'Y',  C.CUST_SEQ , B.CUST_SEQ ))" ).append("\n"); 
		query.append("            AND NVL(SC_NO, 'XXX') IN ('XXX', BK.SC_NO)" ).append("\n"); 
		query.append("            AND NVL(POD_CD, 'XXX') IN ('XXX',IT.POD_cD) " ).append("\n"); 
		query.append("            AND NVL(DEL_CD, 'XXX') IN ('XXX',IT.DEL_cD)" ).append("\n"); 
		query.append("            AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("            AND ROWNUM=1" ).append("\n"); 
		query.append("         ) BUF27" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_ADV_CUST A, BKG_CSTMS_ADV_CUST B, BKG_CSTMS_ADV_CUST C, BKG_CUSTOMER BS, BKG_CUSTOMER BC, BKG_CUSTOMER BN, BKG_CSTMS_ADV_BL IT, MDM_LOCATION L1, MDM_LOCATION L2, BKG_BOOKING BK" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("			  AND A.BL_NO in (SELECT COLUMN_VALUE BL_NO FROM TABLE(BKG_SPLIT_CLOB_FNC(${bl_no},',')) WHERE COLUMN_VALUE IS NOT NULL)" ).append("\n"); 
		query.append("			  AND A.CNT_CD = 'US'" ).append("\n"); 
		query.append("              AND A.BKG_CUST_TP_CD    = 'S'" ).append("\n"); 
		query.append("              AND A.BL_NO     = B.BL_NO" ).append("\n"); 
		query.append("			  AND B.CNT_CD = 'US'" ).append("\n"); 
		query.append("              AND B.BKG_CUST_TP_CD    = 'C'" ).append("\n"); 
		query.append("              AND A.BL_NO     = C.BL_NO(+)" ).append("\n"); 
		query.append("			  AND C.CNT_CD(+) = 'US'" ).append("\n"); 
		query.append("              AND C.BKG_CUST_TP_CD(+)    = 'N'  " ).append("\n"); 
		query.append("              AND A.BL_NO     = IT.BL_NO" ).append("\n"); 
		query.append("              AND IT.BKG_NO			= BS.BKG_NO (+)" ).append("\n"); 
		query.append("              AND BS.BKG_CUST_TP_CD	(+)	= 'S'" ).append("\n"); 
		query.append("              AND IT.BKG_NO			= BC.BKG_NO (+)" ).append("\n"); 
		query.append("              AND BC.BKG_CUST_TP_CD (+)		= 'C'" ).append("\n"); 
		query.append("              AND IT.BKG_NO			= BN.BKG_NO (+)" ).append("\n"); 
		query.append("              AND BN.BKG_CUST_TP_CD	(+)	= 'N'" ).append("\n"); 
		query.append("              AND IT.POR_CD			= L1.LOC_CD" ).append("\n"); 
		query.append("              AND IT.CSTMS_POD_CD	= L2.LOC_CD" ).append("\n"); 
		query.append("              AND A.BL_NO     = BK.BL_NO (+)" ).append("\n"); 

	}
}