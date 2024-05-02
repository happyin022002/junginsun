/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdSummaryCellToCellRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.20 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdSummaryCellToCellRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD로 RF 상태를 요약 조회한다.
	  * (CellToCell값 조회)
	  * </pre>
	  */
	public TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdSummaryCellToCellRSQL(){
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
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("indicator",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("preplantype",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration").append("\n"); 
		query.append("FileName : TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdSummaryCellToCellRSQL").append("\n"); 
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
		query.append("WITH SKD AS (" ).append("\n"); 
		query.append("    SELECT S.*," ).append("\n"); 
		query.append("      P.REP_PORT_CD," ).append("\n"); 
		query.append("      DECODE(P.CHK_MTY_PLN_FLG, 'Y', 'E', 'F') AS PLANTYPE" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD S," ).append("\n"); 
		query.append("      STO_PLN_VSL_PORT_SKD P" ).append("\n"); 
		query.append("    WHERE S.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND S.TURN_PORT_IND_CD <> 'V'" ).append("\n"); 
		query.append("      AND S.TURN_PORT_IND_CD <> 'F'" ).append("\n"); 
		query.append("      AND S.TURN_PORT_IND_CD <> 'D'" ).append("\n"); 
		query.append("      AND (S.SKD_CNG_STS_CD IS NULL" ).append("\n"); 
		query.append("          OR S.SKD_CNG_STS_CD <> 'S')" ).append("\n"); 
		query.append("      AND S.VPS_PORT_CD <> 'PAPAC'" ).append("\n"); 
		query.append("      AND S.VPS_PORT_CD <> 'EGSUZ'" ).append("\n"); 
		query.append("      AND S.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("      AND S.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND S.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND S.VPS_PORT_CD = P.VPS_PORT_CD" ).append("\n"); 
		query.append("      AND S.CLPT_IND_SEQ = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("      AND (P.CHK_FNL_PLN_FLG = 'Y' OR P.CHK_MTY_PLN_FLG = 'Y')" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("      PRE_SKD AS (" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT *" ).append("\n"); 
		query.append("            FROM SKD" ).append("\n"); 
		query.append("            WHERE VPS_ETA_DT < (" ).append("\n"); 
		query.append("                SELECT MAX(VPS_ETA_DT)" ).append("\n"); 
		query.append("                FROM SKD" ).append("\n"); 
		query.append("                WHERE SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                  AND VPS_PORT_CD =  @[port]" ).append("\n"); 
		query.append("                  AND CLPT_IND_SEQ = @[indicator])" ).append("\n"); 
		query.append("            ORDER BY VPS_ETA_DT DESC )" ).append("\n"); 
		query.append("        WHERE ROWNUM=1 )    " ).append("\n"); 
		query.append("    SELECT COUNT(A.ID) AS cellToCell" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT ID ," ).append("\n"); 
		query.append("          BAY ," ).append("\n"); 
		query.append("          ROWW ," ).append("\n"); 
		query.append("          TIER ," ).append("\n"); 
		query.append("          PORT_CD ," ).append("\n"); 
		query.append("		  CALL_IND" ).append("\n"); 
		query.append("        FROM BAY_PLAN C," ).append("\n"); 
		query.append("             PRE_SKD D" ).append("\n"); 
		query.append("       WHERE C.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("          AND C.VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND C.DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND C.PORT_CD = D.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND C.CALL_IND = D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          AND C.PLAN_TYPE = @[preplantype]" ).append("\n"); 
		query.append("          AND TEMP IS NOT NULL) A," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT *" ).append("\n"); 
		query.append("        FROM BAY_PLAN" ).append("\n"); 
		query.append("        WHERE VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("          AND VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("          AND DIR_CD =  SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("          AND PORT_CD =  @[port]" ).append("\n"); 
		query.append("          AND CALL_IND = @[indicator]" ).append("\n"); 
		query.append("          AND PLAN_TYPE = @[preplantype]" ).append("\n"); 
		query.append("          AND POL <> PORT_CD" ).append("\n"); 
		query.append("          AND TEMP IS NOT NULL) B" ).append("\n"); 
		query.append("    WHERE A.ID = B.ID" ).append("\n"); 
		query.append("      AND (A.BAY <> B.BAY" ).append("\n"); 
		query.append("          OR A.ROWW <> B.ROWW" ).append("\n"); 
		query.append("          OR A.TIER <> B.TIER" ).append("\n"); 
		query.append("          OR B.SHIFT_TYPE IS NOT NULL)" ).append("\n"); 
		query.append("    GROUP BY A.PORT_CD, A.CALL_IND" ).append("\n"); 

	}
}