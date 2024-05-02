/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaACECustomsTransmissionDBDAOsearchCntrLineOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaACECustomsTransmissionDBDAOsearchCntrLineOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaACECustomsTransmissionDBDAOsearchCntrLineOBRSQL
	  * </pre>
	  */
	public UsaACECustomsTransmissionDBDAOsearchCntrLineOBRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaACECustomsTransmissionDBDAOsearchCntrLineOBRSQL").append("\n"); 
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
		query.append("       B.BKG_NO BL_NO," ).append("\n"); 
		query.append("       RPAD(" ).append("\n"); 
		query.append("       'C01'||" ).append("\n"); 
		query.append("       RPAD(C.CNTR_NO, 14, ' ')||" ).append("\n"); 
		query.append("       RPAD(NVL(DECODE(C.CNTR_NO, S.CNTR_NO, S.SEAL_NO1), '999'), 15, ' ')||" ).append("\n"); 
		query.append("	   RPAD(NVL(DECODE(C.CNTR_NO, S.CNTR_NO, S.SEAL_NO2), ' '), 15, ' ')||" ).append("\n"); 
		query.append("	 ( SELECT DECODE(MAX(ATTR_CTNT2),'','  ',MAX(ATTR_CTNT2)) AS ATTR_CTNT2 FROM BKG_CSTMS_cD_cONV_CTNT" ).append("\n"); 
		query.append("		WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("		AND CSTMS_DIV_ID = 'ACE_CNTR_EQ_DESC_CD'" ).append("\n"); 
		query.append("		AND ATTR_CTNT1 = C.CNTR_TPSZ_CD )||" ).append("\n"); 
		query.append("	 ( SELECT LPAD(NVL(MAX(ATTR_CTNT2),'     '),5) AS ATTR_CTNT2 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("		WHERE CNT_CD='US'" ).append("\n"); 
		query.append("		AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("		AND ATTR_CTNT1 = C.CNTR_TPSZ_CD)||" ).append("\n"); 
		query.append("     ( SELECT LPAD(NVL(MAX(ATTR_CTNT3),'        '),8) AS ATTR_CTNT3 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("        WHERE CNT_CD='US'" ).append("\n"); 
		query.append("        AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("        AND ATTR_CTNT1 = C.CNTR_TPSZ_CD)||" ).append("\n"); 
		query.append("     ( SELECT LPAD(NVL(MAX(ATTR_CTNT4),'        '),8) AS ATTR_CTNT4 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("        WHERE CNT_CD='US'" ).append("\n"); 
		query.append("        AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("        AND ATTR_CTNT1 = C.CNTR_TPSZ_CD)||" ).append("\n"); 
		query.append("     ( SELECT LPAD(NVL(MAX(ATTR_CTNT5),'    '),4) AS ATTR_CTNT5 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("		WHERE CNT_CD='US'" ).append("\n"); 
		query.append("		AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("		AND ATTR_CTNT1 = C.CNTR_TPSZ_CD )||" ).append("\n"); 
		query.append("       DECODE(K.BKG_CGO_TP_CD, 'M', 'E', 'L')||" ).append("\n"); 
		query.append("       DECODE(K.BB_CGO_FLG," ).append("\n"); 
		query.append("	      'Y', 'BB'," ).append("\n"); 
		query.append("	      DECODE(NVL(K.RCV_TERM_CD,' ')||NVL(K.DE_TERM_CD,' ')," ).append("\n"); 
		query.append("		     'YY','CY'," ).append("\n"); 
		query.append("		     'YD','PH'," ).append("\n"); 
		query.append("		     'DY','HP'," ).append("\n"); 
		query.append("		     'DD','HH'," ).append("\n"); 
		query.append("		     'SY','CS'," ).append("\n"); 
		query.append("		     'YS','CS'," ).append("\n"); 
		query.append("		     'SD','CS'," ).append("\n"); 
		query.append("		     'DS','CS'," ).append("\n"); 
		query.append("		     'MM','MD'," ).append("\n"); 
		query.append("		     'TT','PP'," ).append("\n"); 
		query.append("		     'HH','HL'," ).append("\n"); 
		query.append("		     '  '))||" ).append("\n"); 
		query.append("       '   ',80,' ')||CHR(10) BUF3," ).append("\n"); 
		query.append("       RPAD(" ).append("\n"); 
		query.append("       'C02'||" ).append("\n"); 
		query.append("       RPAD( (SELECT X.VIN_CTNT FROM BKG_XPT_IMP_LIC X WHERE X.BKG_NO = B.BKG_NO AND X.IO_BND_CD = 'O' AND X.CNT_CD = 'US' AND ROWNUM = 1), 30, ' ')||" ).append("\n"); 
		query.append("       '   ',80,' ')||CHR(10) BUF32," ).append("\n"); 
		query.append("       RPAD(" ).append("\n"); 
		query.append("       'C03'||" ).append("\n"); 
		query.append("	   RPAD(NVL(DECODE(C.CNTR_NO, S.CNTR_NO, S.SEAL_NO3), ' '), 15, ' ')||" ).append("\n"); 
		query.append("	   RPAD(NVL(DECODE(C.CNTR_NO, S.CNTR_NO, S.SEAL_NO4), ' '), 15, ' ')||" ).append("\n"); 
		query.append("	   RPAD(NVL(DECODE(C.CNTR_NO, S.CNTR_NO, S.SEAL_NO5), ' '), 15, ' ')||" ).append("\n"); 
		query.append("	   RPAD(NVL(DECODE(C.CNTR_NO, S.CNTR_NO, S.SEAL_NO6), ' '), 15, ' ')||" ).append("\n"); 
		query.append("       '   ',80,' ')||CHR(10) BUF33," ).append("\n"); 
		query.append("       NVL(LENGTH(S.SEAL_NO3),0) BUF33_CHKECK," ).append("\n"); 
		query.append("       C.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT A.BKG_NO, A.CNTR_NO, " ).append("\n"); 
		query.append("		MAX(DECODE(A.RANK_SEAL, 1, BKG_SPCLCHAR_CONV_FNC(SEAL_NO ,'X'))) SEAL_NO1," ).append("\n"); 
		query.append("		MAX(DECODE(A.RANK_SEAL, 2, BKG_SPCLCHAR_CONV_FNC(SEAL_NO ,'X'))) SEAL_NO2," ).append("\n"); 
		query.append("		MAX(DECODE(A.RANK_SEAL, 3, BKG_SPCLCHAR_CONV_FNC(SEAL_NO ,'X'))) SEAL_NO3," ).append("\n"); 
		query.append("		MAX(DECODE(A.RANK_SEAL, 4, BKG_SPCLCHAR_CONV_FNC(SEAL_NO ,'X'))) SEAL_NO4," ).append("\n"); 
		query.append("		MAX(DECODE(A.RANK_SEAL, 5, BKG_SPCLCHAR_CONV_FNC(SEAL_NO ,'X'))) SEAL_NO5," ).append("\n"); 
		query.append("		MAX(DECODE(A.RANK_SEAL, 6, BKG_SPCLCHAR_CONV_FNC(SEAL_NO ,'X'))) SEAL_NO6" ).append("\n"); 
		query.append("	FROM(" ).append("\n"); 
		query.append("		SELECT A.BKG_NO, CT.CNTR_NO, S.CNTR_SEAL_NO SEAL_NO," ).append("\n"); 
		query.append("    RANK() OVER(PARTITION BY A.BKG_NO, CT.CNTR_NO ORDER BY A.BKG_NO, S.CNTR_NO, S.CNTR_SEAL_NO DESC) RANK_SEAL" ).append("\n"); 
		query.append("		FROM (SELECT DISTINCT COLUMN_VALUE BKG_NO FROM TABLE(BKG_SPLIT_CLOB_FNC(${bl_no},',')) WHERE COLUMN_VALUE IS NOT NULL) A," ).append("\n"); 
		query.append("    BKG_CNTR_SEAL_NO S," ).append("\n"); 
		query.append("			BKG_CONTAINER CT" ).append("\n"); 
		query.append("		WHERE A.BKG_NO = CT.BKG_NO (+)" ).append("\n"); 
		query.append("			AND CT.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("			AND CT.CNTR_NO = S.CNTR_NO(+) " ).append("\n"); 
		query.append("			--AND S.CSTMS_DIV_ID(+)= 'CTM'" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("	GROUP BY A.BKG_NO, A.CNTR_NO" ).append("\n"); 
		query.append("	) S," ).append("\n"); 
		query.append("	BKG_VVD B, BKG_CONTAINER C, BKG_BOOKING K " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("	AND B.BKG_NO 	= S.BKG_NO" ).append("\n"); 
		query.append("	AND C.CNTR_NO	= S.CNTR_NO" ).append("\n"); 
		query.append("	AND B.BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("	AND B.BKG_NO     = K.BKG_NO" ).append("\n"); 
		query.append("    AND B.VSL_CD     = SUBSTR(@[vvd],1,4) " ).append("\n"); 
		query.append("    AND B.SKD_VOY_NO = SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("    AND B.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	--AND C.IBD_CNTR_STS_CD  = 'A'" ).append("\n"); 

	}
}