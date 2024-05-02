/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrInfo
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCntrInfoRSQL(){
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
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT B.BL_NO " ).append("\n"); 
		query.append("      ,C.CNTR_NO" ).append("\n"); 
		query.append("      , CASE WHEN BC.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("             THEN RPAD('C01'|| RPAD('NC', 44, ' ')" ).append("\n"); 
		query.append("               || RPAD('NC', 27, ' ')" ).append("\n"); 
		query.append("               || DECODE(B.FULL_MTY_CD, 'M', 'E', 'L')" ).append("\n"); 
		query.append("               || '   ',80,' ') || CHR(10)" ).append("\n"); 
		query.append("             ELSE RPAD('C01'|| RPAD(C.CNTR_NO, 14, ' ')" ).append("\n"); 
		query.append("               || RPAD(NVL(SEAL_NO1, ' '), 15, ' ')" ).append("\n"); 
		query.append("               || RPAD(NVL(SEAL_NO2, ' '), 15, ' ')" ).append("\n"); 
		query.append("               || (SELECT NVL(MAX(ATTR_CTNT2), '  ') AS ATTR_CTNT2" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                    WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                      AND CSTMS_DIV_ID = 'ACE_CNTR_EQ_DESC_CD'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT1 = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("               || (SELECT LPAD(NVL(MAX(ATTR_CTNT2), ' '),5, '0') AS ATTR_CTNT2" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                    WHERE CNT_CD='US'" ).append("\n"); 
		query.append("                      AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT1 = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("               || (SELECT LPAD(NVL(MAX(ATTR_CTNT3), ' '),8, '0') AS ATTR_CTNT3" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                    WHERE CNT_CD='US'" ).append("\n"); 
		query.append("                      AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT1 = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("               || '00000806'" ).append("\n"); 
		query.append("               || (SELECT LPAD(NVL(MAX(ATTR_CTNT5),' '),4) AS ATTR_CTNT5" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                    WHERE CNT_CD='US'" ).append("\n"); 
		query.append("                      AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT1 = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("               || DECODE(B.FULL_MTY_CD, 'M', 'E', 'L')" ).append("\n"); 
		query.append("               || DECODE(K.BB_CGO_FLG, 'Y', 'BB'," ).append("\n"); 
		query.append("                    DECODE(NVL(B.RCV_TERM_CD,' ')||NVL(B.DE_TERM_CD,' ')," ).append("\n"); 
		query.append("                       'YY','CY'," ).append("\n"); 
		query.append("                       'YD','PH'," ).append("\n"); 
		query.append("                       'DY','HP'," ).append("\n"); 
		query.append("                       'DD','HH'," ).append("\n"); 
		query.append("                       'SY','CS'," ).append("\n"); 
		query.append("                       'YS','CS'," ).append("\n"); 
		query.append("                       'SD','CS'," ).append("\n"); 
		query.append("                       'DS','CS'," ).append("\n"); 
		query.append("                       'MM','MD'," ).append("\n"); 
		query.append("                       'TT','PP'," ).append("\n"); 
		query.append("                       'HH','HL'," ).append("\n"); 
		query.append("                       '  '))" ).append("\n"); 
		query.append("                || '   ',80,' ') || CHR(10) " ).append("\n"); 
		query.append("                END C01" ).append("\n"); 
		query.append("      ,(SELECT SUBSTR(NVL(CMDT_NM, ' '),1,45)" ).append("\n"); 
		query.append("          FROM MDM_COMMODITY " ).append("\n"); 
		query.append("         WHERE CMDT_CD = K.CMDT_CD" ).append("\n"); 
		query.append("       ) AS CMDT_NM" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("      ,BKG_BOOKING K" ).append("\n"); 
		query.append("      ,BKG_CONTAINER BC" ).append("\n"); 
		query.append("      ,(SELECT A.BL_NO" ).append("\n"); 
		query.append("              ,A.CNTR_NO " ).append("\n"); 
		query.append("              ,MAX(DECODE(A.RANK_SEAL, 1, BKG_SPCLCHAR_CONV_FNC(SEAL_NO ,'X'))) SEAL_NO1" ).append("\n"); 
		query.append("              ,MAX(DECODE(A.RANK_SEAL, 2, BKG_SPCLCHAR_CONV_FNC(SEAL_NO ,'X'))) SEAL_NO2" ).append("\n"); 
		query.append("         FROM (SELECT S.BL_NO" ).append("\n"); 
		query.append("                     ,S.CNTR_NO" ).append("\n"); 
		query.append("                     ,S.SEAL_NO" ).append("\n"); 
		query.append("                     ,RANK() OVER(PARTITION BY S.BL_NO, S.CNTR_NO ORDER BY S.BL_NO, S.CNTR_NO, S.SEAL_NO DESC) RANK_SEAL" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_SEAL_NO  S" ).append("\n"); 
		query.append("               WHERE S.CNT_CD = 'US'" ).append("\n"); 
		query.append("                 AND S.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("                 AND S.CSTMS_DIV_ID= 'CTM'" ).append("\n"); 
		query.append("              ) A" ).append("\n"); 
		query.append("         GROUP BY A.BL_NO, A.CNTR_NO" ).append("\n"); 
		query.append("       ) S" ).append("\n"); 
		query.append(" WHERE B.CNT_CD    = 'US'" ).append("\n"); 
		query.append("   AND B.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("   AND B.CNT_CD    = C.CNT_CD" ).append("\n"); 
		query.append("   AND B.BL_NO     = C.BL_NO" ).append("\n"); 
		query.append("   AND C.IBD_CNTR_STS_CD  = 'A'" ).append("\n"); 
		query.append("   AND B.BKG_NO    = K.BKG_NO" ).append("\n"); 
		query.append("   AND C.BL_NO     = S.BL_NO(+)" ).append("\n"); 
		query.append("   AND C.CNTR_NO   = S.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND BC.BKG_NO = K.BKG_NO" ).append("\n"); 
		query.append("   AND BC.CNTR_NO = C.CNTR_NO" ).append("\n"); 

	}
}