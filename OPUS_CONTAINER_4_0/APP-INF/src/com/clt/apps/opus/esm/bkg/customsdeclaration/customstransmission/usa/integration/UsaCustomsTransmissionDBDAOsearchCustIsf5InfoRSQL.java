/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCustIsf5InfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.03.05 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCustIsf5InfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCustIsf5Info
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCustIsf5InfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCustIsf5InfoRSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO" ).append("\n"); 
		query.append("      ,RPAD('N00' ||'BKP' || RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(A.CUST_NM),1, ''), 'X')),'.'),35,' '),80,' ') || CHR(10) AS BKP_N00" ).append("\n"); 
		query.append("      ,RPAD('N02' || RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),1, ''), 'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("                     RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),2, ''), 'X')),'.'),35,' '),80,' ') || CHR(10) AS BKP_N02" ).append("\n"); 
		query.append("      ,RPAD('N03' || RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(A.CUST_ADDR),3, ''), 'X')),'.'),35,' '),80,' ') || CHR(10) AS BKP_N03" ).append("\n"); 
		query.append("      ,RPAD('N00' ||'ST ' || RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(B.CUST_NM),1, ''), 'X')),'.'),35,' '),80,' ') || CHR(10) AS ST_N00" ).append("\n"); 
		query.append("      ,RPAD('N02' || RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),1, ''), 'X')),'.'),35,' ')||" ).append("\n"); 
		query.append("                     RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),2, ''), 'X')),'.'),35,' '),80,' ') || CHR(10) AS ST_N02" ).append("\n"); 
		query.append("      ,RPAD('N03' || RPAD(NVL(RTRIM(BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(RTRIM(B.CUST_ADDR),3, ''), 'X')),'.'),35,' '),80,' ') || CHR(10) AS ST_N03" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_CUST A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CUST B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL   BB" ).append("\n"); 
		query.append("      ,BKG_BOOKING        BK" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.CNT_CD         = B.CNT_CD" ).append("\n"); 
		query.append("   AND A.BL_NO          = B.BL_NO" ).append("\n"); 
		query.append("   AND B.CNT_CD         = BB.CNT_CD" ).append("\n"); 
		query.append("   AND B.BL_NO          = BB.BL_NO" ).append("\n"); 
		query.append("   AND BB.BKG_NO        = BK.BKG_NO" ).append("\n"); 
		query.append("   AND A.CNT_CD         = 'US'" ).append("\n"); 
		query.append("   AND A.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND B.BKG_CUST_TP_CD = DECODE(BK.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("   AND A.BL_NO          = 'BAS500001100'" ).append("\n"); 

	}
}