/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchObjByYdChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.23
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.23 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchObjByYdChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * YD_CHG_NO, YD_CHG_VER_SEQ별로 Object를 조회한다.
	  * 
	  * -----------------------------------------------------------
	  * history
	  * 2011.11.23 진마리아 CHM-201114406-01 Tariff Value Management 화면 로직 변경(EDIT_ENBL_FLG 추가)
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchObjByYdChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchObjByYdChgRSQL").append("\n"); 
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
		query.append("      ,NVL2(Z.OBJ_LIST_NO, 'Y', 'N') FLAG" ).append("\n"); 
		query.append("      ,Z.DFLT_VAL REGULAR_VALUE" ).append("\n"); 
		query.append("      ,${yd_chg_no} YD_CHG_NO" ).append("\n"); 
		query.append("      ,${yd_chg_ver_seq} YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("      ,Y.EDIT_ENBL_FLG" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT DISTINCT DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("        FROM   (SELECT BB.OBJ_LIST_NO" ).append("\n"); 
		query.append("                      ,BB.RT_OBJ_LIST_NO    " ).append("\n"); 
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
		query.append("                        AND    A.YD_CHG_NO = ${yd_chg_no}" ).append("\n"); 
		query.append("                        AND    A.YD_CHG_VER_SEQ = ${yd_chg_ver_seq}) A" ).append("\n"); 
		query.append("                      ,PSO_FORMULA B" ).append("\n"); 
		query.append("                      ,PSO_FOML_DTL BB" ).append("\n"); 
		query.append("                WHERE  1 = 1" ).append("\n"); 
		query.append("                AND    A.FOML_NO = B.FOML_NO" ).append("\n"); 
		query.append("                AND    B.FOML_NO = BB.FOML_NO" ).append("\n"); 
		query.append("                AND    BB.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("               ) P" ).append("\n"); 
		query.append("              ,(SELECT LEVEL RNUM" ).append("\n"); 
		query.append("                FROM   DUAL" ).append("\n"); 
		query.append("                CONNECT BY LEVEL <= 2" ).append("\n"); 
		query.append("               ) Q  " ).append("\n"); 
		query.append("        WHERE  DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL    " ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("                        AND    A.YD_CHG_NO = ${yd_chg_no}" ).append("\n"); 
		query.append("                        AND    A.YD_CHG_VER_SEQ = ${yd_chg_ver_seq}) A" ).append("\n"); 
		query.append("                      ,PSO_CONDITION C" ).append("\n"); 
		query.append("                      ,PSO_COND_DTL CC" ).append("\n"); 
		query.append("                WHERE  1 = 1" ).append("\n"); 
		query.append("                AND    A.COND_NO = C.COND_NO" ).append("\n"); 
		query.append("                AND    C.COND_NO = CC.COND_NO" ).append("\n"); 
		query.append("                AND    CC.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("                AND    CC.OBJ_LIST_NO != -1) P" ).append("\n"); 
		query.append("              ,(SELECT LEVEL RNUM FROM DUAL CONNECT BY LEVEL <= 2) Q" ).append("\n"); 
		query.append("        WHERE  DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL                           " ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append("      ,PSO_OBJ_LIST Y" ).append("\n"); 
		query.append("      ,PSO_YD_CHG_OBJ_LIST Z" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    X.OBJ_LIST_NO = Y.OBJ_LIST_NO" ).append("\n"); 
		query.append("AND    X.OBJ_LIST_NO = Z.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("AND    Z.YD_CHG_NO(+) = ${yd_chg_no}" ).append("\n"); 
		query.append("AND    Z.YD_CHG_VER_SEQ(+) = ${yd_chg_ver_seq}" ).append("\n"); 
		query.append("AND    Y.PSO_OBJ_LIST_TP_CD IN ('A', 'M')" ).append("\n"); 
		query.append("ORDER  BY Y.OBJ_LIST_NM" ).append("\n"); 

	}
}