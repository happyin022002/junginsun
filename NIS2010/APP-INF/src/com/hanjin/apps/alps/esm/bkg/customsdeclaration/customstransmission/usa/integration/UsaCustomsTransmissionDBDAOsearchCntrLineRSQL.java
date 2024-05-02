/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCntrLineRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.03.20 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCntrLineRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCntrLineRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCntrLineRSQL").append("\n"); 
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
		query.append("B.BL_NO," ).append("\n"); 
		query.append("RPAD(" ).append("\n"); 
		query.append("'C01'||" ).append("\n"); 
		query.append("RPAD(C.CNTR_NO, 14, ' ')||" ).append("\n"); 
		query.append("RPAD(NVL(DECODE(C.CNTR_NO, S.CNTR_NO, S.SEAL_NO1), '999'), 15, ' ')||" ).append("\n"); 
		query.append("RPAD(NVL(DECODE(C.CNTR_NO, S.CNTR_NO, S.SEAL_NO2), ' '), 15, ' ')||" ).append("\n"); 
		query.append("'  '||" ).append("\n"); 
		query.append("(SELECT LPAD(NVL(MAX(ATTR_CTNT2),'     '),5) AS ATTR_CTNT2 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD='US'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = C.CNTR_TPSZ_CD)||" ).append("\n"); 
		query.append("(SELECT LPAD(NVL(MAX(ATTR_CTNT3),'        '),8) AS ATTR_CTNT3 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD='US'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = C.CNTR_TPSZ_CD)||" ).append("\n"); 
		query.append("(SELECT LPAD(NVL(MAX(ATTR_CTNT4),'        '),8) AS ATTR_CTNT4 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD='US'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = C.CNTR_TPSZ_CD)||" ).append("\n"); 
		query.append("( SELECT LPAD(NVL(MAX(ATTR_CTNT5),'    '),4) AS ATTR_CTNT5 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD='US'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID='CNTR_SPEC_INFO'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = C.CNTR_TPSZ_CD )||" ).append("\n"); 
		query.append("DECODE(B.FULL_MTY_CD, 'M', 'E', DECODE('${gubun}','TEST','L',' '))||" ).append("\n"); 
		query.append("DECODE(K.BB_CGO_FLG," ).append("\n"); 
		query.append("'Y', 'BB'," ).append("\n"); 
		query.append("DECODE(NVL(B.RCV_TERM_CD,' ')||NVL(B.DE_TERM_CD,' ')," ).append("\n"); 
		query.append("'YY','CY'," ).append("\n"); 
		query.append("'YD','PH'," ).append("\n"); 
		query.append("'DY','HP'," ).append("\n"); 
		query.append("'DD','HH'," ).append("\n"); 
		query.append("'SY','CS'," ).append("\n"); 
		query.append("'YS','CS'," ).append("\n"); 
		query.append("'SD','CS'," ).append("\n"); 
		query.append("'DS','CS'," ).append("\n"); 
		query.append("'MM','MD'," ).append("\n"); 
		query.append("'TT','PP'," ).append("\n"); 
		query.append("'HH','HL'," ).append("\n"); 
		query.append("'  '))||" ).append("\n"); 
		query.append("'   ',80,' ')||CHR(10) BUF3," ).append("\n"); 
		query.append("C.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.BL_NO, A.CNTR_NO," ).append("\n"); 
		query.append("MAX(DECODE(A.RANK_SEAL, 1, SEAL_NO)) SEAL_NO1," ).append("\n"); 
		query.append("MAX(DECODE(A.RANK_SEAL, 2, SEAL_NO)) SEAL_NO2" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT A.BL_NO, CT.CNTR_NO, S.SEAL_NO," ).append("\n"); 
		query.append("RANK() OVER(PARTITION BY A.BL_NO, CT.CNTR_NO ORDER BY A.BL_NO, S.CNTR_NO, S.SEAL_NO DESC) RANK_SEAL" ).append("\n"); 
		query.append("FROM (SELECT COLUMN_VALUE BL_NO FROM TABLE(BKG_SPLIT_CLOB_FNC(${bl_no},',')) WHERE COLUMN_VALUE IS NOT NULL) A," ).append("\n"); 
		query.append("BKG_CSTMS_SEAL_NO S," ).append("\n"); 
		query.append("BKG_CSTMS_ADV_CNTR CT" ).append("\n"); 
		query.append("WHERE A.BL_NO = CT.BL_NO (+)" ).append("\n"); 
		query.append("AND CT.CNT_CD(+) = 'US'" ).append("\n"); 
		query.append("AND CT.BL_NO = S.BL_NO(+)" ).append("\n"); 
		query.append("AND CT.CNTR_NO = S.CNTR_NO(+)" ).append("\n"); 
		query.append("AND S.CNT_CD(+) = 'US'" ).append("\n"); 
		query.append("AND S.CSTMS_DIV_ID(+)= 'CTM'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY A.BL_NO, A.CNTR_NO" ).append("\n"); 
		query.append(") S," ).append("\n"); 
		query.append("BKG_CSTMS_ADV_BL B, BKG_CSTMS_ADV_CNTR C, BKG_BOOKING K" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("B.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND B.BL_NO 	= S.BL_NO" ).append("\n"); 
		query.append("AND C.CNTR_NO	= S.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNT_CD    = C.CNT_CD" ).append("\n"); 
		query.append("AND B.BL_NO     = C.BL_NO" ).append("\n"); 
		query.append("AND B.BL_NO     = K.BL_NO (+)" ).append("\n"); 
		query.append("AND C.IBD_CNTR_STS_CD  = 'A'" ).append("\n"); 

	}
}