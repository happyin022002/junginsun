/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchObjectBySimulationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchObjectBySimulationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff에 사용된 Formula/Condition를 구성하는 Objects 구하기
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchObjectBySimulationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchObjectBySimulationRSQL").append("\n"); 
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
		query.append("SELECT Y.OBJ_LIST_NO" ).append("\n"); 
		query.append("      ,Y.OBJ_LIST_NM" ).append("\n"); 
		query.append("      ,Y.PSO_OBJ_LIST_TP_CD" ).append("\n"); 
		query.append("      ,CASE WHEN Y.OBJ_LIST_NO IN (18, 19, 20, 21, 22) THEN 1 " ).append("\n"); 
		query.append("            ELSE NULL " ).append("\n"); 
		query.append("       END  DFLT_VAL		/*Actual로 쓰임. Actual이 없으면 Regular Value로 채움. Constant 등은 값을 1로 설정함.*/" ).append("\n"); 
		query.append("	  ,Z.DFLT_VAL REG_VAL	" ).append("\n"); 
		query.append("      ,Y.PSO_MEAS_UT_CD         PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,YY.INTG_CD_VAL_DP_DESC   PSO_MEAS_UT_NM  " ).append("\n"); 
		query.append("FROM   (SELECT DISTINCT DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("        FROM   (SELECT BB.OBJ_LIST_NO" ).append("\n"); 
		query.append("                      ,BB.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                FROM   (SELECT D.FOML_NO" ).append("\n"); 
		query.append("                              ,D.COND_NO" ).append("\n"); 
		query.append("                        FROM   PSO_YD_CHG      A" ).append("\n"); 
		query.append("                              ,PSO_YD_CHG_XPR  B" ).append("\n"); 
		query.append("                              ,PSO_CHG_XPR     C" ).append("\n"); 
		query.append("                              ,PSO_CHG_XPR_DTL D" ).append("\n"); 
		query.append("                        WHERE  A.YD_CHG_NO = B.YD_CHG_NO" ).append("\n"); 
		query.append("                        AND    A.YD_CHG_VER_SEQ = B.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                        AND    C.CHG_XPR_NO = B.CHG_XPR_NO" ).append("\n"); 
		query.append("                        AND    C.CHG_XPR_NO = D.CHG_XPR_NO" ).append("\n"); 
		query.append("                        AND    A.YD_CHG_NO = TO_NUMBER(@[yd_chg_no])" ).append("\n"); 
		query.append("                        AND    A.YD_CHG_VER_SEQ = TO_NUMBER(@[yd_chg_ver_seq])" ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                      ,PSO_FORMULA B" ).append("\n"); 
		query.append("                      ,PSO_FOML_DTL BB" ).append("\n"); 
		query.append("                WHERE  1 = 1" ).append("\n"); 
		query.append("                AND    A.FOML_NO = B.FOML_NO" ).append("\n"); 
		query.append("                AND    B.FOML_NO = BB.FOML_NO" ).append("\n"); 
		query.append("                AND    BB.OBJ_LIST_NO IS NOT NULL) P" ).append("\n"); 
		query.append("              ,(SELECT LEVEL RNUM FROM DUAL CONNECT BY LEVEL <= 2) Q" ).append("\n"); 
		query.append("        WHERE  DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("        FROM   (SELECT CC.OBJ_LIST_NO" ).append("\n"); 
		query.append("                      ,CC.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                FROM   (SELECT D.FOML_NO" ).append("\n"); 
		query.append("                              ,D.COND_NO" ).append("\n"); 
		query.append("                        FROM   PSO_YD_CHG      A" ).append("\n"); 
		query.append("                              ,PSO_YD_CHG_XPR  B" ).append("\n"); 
		query.append("                              ,PSO_CHG_XPR     C" ).append("\n"); 
		query.append("                              ,PSO_CHG_XPR_DTL D" ).append("\n"); 
		query.append("                        WHERE  A.YD_CHG_NO = B.YD_CHG_NO" ).append("\n"); 
		query.append("                        AND    A.YD_CHG_VER_SEQ = B.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                        AND    C.CHG_XPR_NO = B.CHG_XPR_NO" ).append("\n"); 
		query.append("                        AND    C.CHG_XPR_NO = D.CHG_XPR_NO" ).append("\n"); 
		query.append("                        AND    A.YD_CHG_NO = TO_NUMBER(@[yd_chg_no])" ).append("\n"); 
		query.append("                        AND    A.YD_CHG_VER_SEQ = TO_NUMBER(@[yd_chg_ver_seq])" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                      ,PSO_CONDITION C" ).append("\n"); 
		query.append("                      ,PSO_COND_DTL CC" ).append("\n"); 
		query.append("                WHERE  1 = 1" ).append("\n"); 
		query.append("                AND    A.COND_NO = C.COND_NO" ).append("\n"); 
		query.append("                AND    C.COND_NO = CC.COND_NO" ).append("\n"); 
		query.append("                AND    CC.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("                AND    CC.OBJ_LIST_NO != -1) P" ).append("\n"); 
		query.append("              ,(SELECT LEVEL RNUM FROM DUAL CONNECT BY LEVEL <= 2) Q" ).append("\n"); 
		query.append("        WHERE  DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL" ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append("      ,PSO_OBJ_LIST Y" ).append("\n"); 
		query.append("	  ,COM_INTG_CD_DTL YY" ).append("\n"); 
		query.append("      ,(SELECT OBJ_LIST_NO" ).append("\n"); 
		query.append("              ,DFLT_VAL" ).append("\n"); 
		query.append("        FROM   PSO_YD_CHG_OBJ_LIST" ).append("\n"); 
		query.append("        WHERE  YD_CHG_NO = TO_NUMBER(@[yd_chg_no])" ).append("\n"); 
		query.append("        AND    YD_CHG_VER_SEQ = TO_NUMBER(@[yd_chg_ver_seq])" ).append("\n"); 
		query.append("       ) Z" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    X.OBJ_LIST_NO = Y.OBJ_LIST_NO" ).append("\n"); 
		query.append("--AND    X.OBJ_LIST_NO NOT IN (18, 19, 20, 21, 22) --2015.01.30 NYK Add" ).append("\n"); 
		query.append("AND    X.OBJ_LIST_NO = Z.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("AND    Y.PSO_MEAS_UT_CD = YY.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND    YY.INTG_CD_ID = 'CD01848'" ).append("\n"); 
		query.append("AND    Y.PSO_OBJ_LIST_TP_CD IN ('A', 'M')" ).append("\n"); 
		query.append("ORDER  BY DECODE(Y.OBJ_LIST_NM, 'IN', '☆2', 'OUT', '☆3', Y.OBJ_LIST_NM)" ).append("\n"); 

	}
}