/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOmodifyPsoYdChgObjListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOmodifyPsoYdChgObjListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tariff가 update만 되는 경우(VERSION UP, CREATE가 아닌 경우)
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOmodifyPsoYdChgObjListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOmodifyPsoYdChgObjListCSQL").append("\n"); 
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
		query.append("MERGE INTO PSO_YD_CHG_OBJ_LIST AA" ).append("\n"); 
		query.append("USING (   SELECT  X.OBJ_LIST_NO,  Y.DFLT_VAL" ).append("\n"); 
		query.append("            FROM (  SELECT P.OBJ_LIST_NO ,Q.OBJ_LIST_NM , R.INTG_CD_VAL_DP_DESC, PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("                      FROM   (  SELECT DISTINCT DECODE(Y.RNUM, 1, X.OBJ_LIST_NO, X.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("                                 FROM   (  SELECT BB.OBJ_LIST_NO ,BB.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                                             FROM PSO_FORMULA B, PSO_FOML_DTL  BB" ).append("\n"); 
		query.append("                                             WHERE B.FOML_NO = BB.FOML_NO" ).append("\n"); 
		query.append("                                               AND BB.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("                                               AND B.FOML_NO IN ( SELECT DISTINCT A.FOML_NO  " ).append("\n"); 
		query.append("                                                                    FROM PSO_FOML_DTL A, PSO_CHG_XPR_DTL B, PSO_OBJ_LIST C, PSO_YD_CHG_XPR D" ).append("\n"); 
		query.append("                                                                   WHERE B.CHG_XPR_NO = D.CHG_XPR_NO" ).append("\n"); 
		query.append("                                                                     AND A.FOML_NO    = B.FOML_NO" ).append("\n"); 
		query.append("                                                                     AND A.PSO_FOML_DTL_TP_CD = 'O'" ).append("\n"); 
		query.append("                                                                     AND C.OBJ_LIST_NO = A.OBJ_LIST_NO" ).append("\n"); 
		query.append("                                                                     AND D.YD_CHG_NO   = @[yd_chg_no]" ).append("\n"); 
		query.append("                                                                     AND D.YD_CHG_VER_SEQ = @[yd_chg_seq])" ).append("\n"); 
		query.append("                                            UNION " ).append("\n"); 
		query.append("                                             SELECT BB.OBJ_LIST_NO ,BB.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                                               FROM PSO_CONDITION B, PSO_COND_DTL  BB" ).append("\n"); 
		query.append("                                              WHERE B.COND_NO = BB.COND_NO" ).append("\n"); 
		query.append("                                                AND BB.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                AND B.COND_NO IN ( SELECT DISTINCT A.COND_NO  " ).append("\n"); 
		query.append("                                                                     FROM PSO_COND_DTL A, PSO_CHG_XPR_DTL B, PSO_OBJ_LIST C, PSO_YD_CHG_XPR D" ).append("\n"); 
		query.append("                                                                    WHERE B.CHG_XPR_NO = D.CHG_XPR_NO" ).append("\n"); 
		query.append("                                                                      AND A.COND_NO    = B.COND_NO" ).append("\n"); 
		query.append("                                                                      AND A.PSO_COND_DTL_TP_CD = 'O'" ).append("\n"); 
		query.append("                                                                      AND C.OBJ_LIST_NO    = A.OBJ_LIST_NO" ).append("\n"); 
		query.append("                                                                      AND D.YD_CHG_NO      = @[yd_chg_no]" ).append("\n"); 
		query.append("                                                                      AND D.YD_CHG_VER_SEQ = @[yd_chg_seq])  ) X" ).append("\n"); 
		query.append("                              ,(SELECT LEVEL RNUM" ).append("\n"); 
		query.append("                                  FROM DUAL" ).append("\n"); 
		query.append("                                CONNECT BY LEVEL <= 2 ) Y" ).append("\n"); 
		query.append("                          WHERE  DECODE(Y.RNUM, 1, X.OBJ_LIST_NO, X.RT_OBJ_LIST_NO) IS NOT NULL ) P ,PSO_OBJ_LIST Q, COM_INTG_CD_DTL R" ).append("\n"); 
		query.append("                WHERE P.OBJ_LIST_NO = Q.OBJ_LIST_NO" ).append("\n"); 
		query.append("                  AND R.INTG_CD_ID = 'CD01848'" ).append("\n"); 
		query.append("                  AND R.INTG_CD_VAL_CTNT  = Q.PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("                  AND R.INTG_CD_VAL_CTNT NOT IN ('14','11','12') ) X,  PSO_YD_CHG_OBJ_LIST Y" ).append("\n"); 
		query.append("           WHERE X.OBJ_LIST_NO       = Y.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("             AND Y.YD_CHG_NO(+)      = @[yd_chg_no]" ).append("\n"); 
		query.append("             AND Y.YD_CHG_VER_SEQ(+) = @[yd_chg_seq] ) BB" ).append("\n"); 
		query.append("ON (  AA.OBJ_LIST_NO = BB.OBJ_LIST_NO AND " ).append("\n"); 
		query.append("      AA.YD_CHG_NO   = @[yd_chg_no]  AND " ).append("\n"); 
		query.append("      AA.YD_CHG_VER_SEQ = @[yd_chg_seq] )" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append(" INSERT (AA.YD_CHG_NO, AA.YD_CHG_VER_SEQ , AA.OBJ_LIST_NO, AA.DFLT_VAL, AA.DFLT_FLG , AA.CRE_DT, AA.CRE_USR_ID , AA.UPD_USR_ID, AA.UPD_DT )" ).append("\n"); 
		query.append(" VALUES (@[yd_chg_no], @[yd_chg_seq],      BB.OBJ_LIST_NO, BB.DFLT_VAL,'N',           SYSDATE,   @[cre_usr_id],  @[cre_usr_id], SYSDATE) " ).append("\n"); 

	}
}