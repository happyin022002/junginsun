/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOdeletePsoYdChgObjListDSQL.java
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

public class PortTariffMgtBCDBDAOdeletePsoYdChgObjListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tariff가 변경되면서 해당되지 않는 object 삭제
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOdeletePsoYdChgObjListDSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOdeletePsoYdChgObjListDSQL").append("\n"); 
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
		query.append("DELETE FROM PSO_YD_CHG_OBJ_LIST" ).append("\n"); 
		query.append(" WHERE YD_CHG_NO      = @[yd_chg_no]" ).append("\n"); 
		query.append("   AND YD_CHG_VER_SEQ = @[yd_chg_seq]" ).append("\n"); 
		query.append("   AND OBJ_LIST_NO NOT IN (  SELECT P.OBJ_LIST_NO" ).append("\n"); 
		query.append("                               FROM ( SELECT DISTINCT DECODE(Y.RNUM, 1, X.OBJ_LIST_NO, X.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("                                        FROM ( SELECT B.OBJ_LIST_NO ,B.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                                                 FROM PSO_FORMULA A ,PSO_FOML_DTL B" ).append("\n"); 
		query.append("                                                WHERE A.FOML_NO = B.FOML_NO" ).append("\n"); 
		query.append("                                                  AND B.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                  AND A.FOML_NO  IN ( SELECT DISTINCT AA.FOML_NO  " ).append("\n"); 
		query.append("                                                                       FROM PSO_FOML_DTL AA, PSO_CHG_XPR_DTL BB, PSO_OBJ_LIST CC, PSO_YD_CHG_XPR DD" ).append("\n"); 
		query.append("                                                                      WHERE BB.CHG_XPR_NO   = DD.CHG_XPR_NO" ).append("\n"); 
		query.append("                                                                        AND AA.FOML_NO      = BB.FOML_NO" ).append("\n"); 
		query.append("                                                                        AND AA.PSO_FOML_DTL_TP_CD = 'O'" ).append("\n"); 
		query.append("                                                                        AND CC.OBJ_LIST_NO = AA.OBJ_LIST_NO" ).append("\n"); 
		query.append("                                                                        AND DD.YD_CHG_NO   = @[yd_chg_no]" ).append("\n"); 
		query.append("                                                                        AND DD.YD_CHG_VER_SEQ = @[yd_chg_seq])" ).append("\n"); 
		query.append("                                               UNION" ).append("\n"); 
		query.append("                                               SELECT B.OBJ_LIST_NO,B.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                                                 FROM PSO_CONDITION  A ,PSO_COND_DTL B" ).append("\n"); 
		query.append("                                                WHERE A.COND_NO  = B.COND_NO" ).append("\n"); 
		query.append("                                                  AND B.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                  AND A.COND_NO IN ( SELECT DISTINCT AA.COND_NO  " ).append("\n"); 
		query.append("                                                                       FROM PSO_COND_DTL AA, PSO_CHG_XPR_DTL BB, PSO_OBJ_LIST CC, PSO_YD_CHG_XPR DD" ).append("\n"); 
		query.append("                                                                      WHERE BB.CHG_XPR_NO = DD.CHG_XPR_NO" ).append("\n"); 
		query.append("                                                                        AND AA.COND_NO    = BB.COND_NO" ).append("\n"); 
		query.append("                                                                        AND AA.PSO_COND_DTL_TP_CD = 'O'" ).append("\n"); 
		query.append("                                                                        AND CC.OBJ_LIST_NO = AA.OBJ_LIST_NO" ).append("\n"); 
		query.append("                                                                        AND DD.YD_CHG_NO   = @[yd_chg_no]" ).append("\n"); 
		query.append("                                                                        AND DD.YD_CHG_VER_SEQ = @[yd_chg_seq])  ) X" ).append("\n"); 
		query.append("                            ,(SELECT LEVEL RNUM" ).append("\n"); 
		query.append("                                FROM DUAL" ).append("\n"); 
		query.append("                              CONNECT BY LEVEL <= 2 ) Y" ).append("\n"); 
		query.append("                            WHERE  DECODE(Y.RNUM, 1, X.OBJ_LIST_NO, X.RT_OBJ_LIST_NO) IS NOT NULL ) P, PSO_OBJ_LIST Q, COM_INTG_CD_DTL R" ).append("\n"); 
		query.append("                  WHERE P.OBJ_LIST_NO = Q.OBJ_LIST_NO" ).append("\n"); 
		query.append("                    AND R.INTG_CD_ID = 'CD01848'" ).append("\n"); 
		query.append("                    AND R.INTG_CD_VAL_CTNT  = Q.PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("                  AND R.INTG_CD_VAL_CTNT NOT IN ('14','11','12') )" ).append("\n"); 
		query.append("                  " ).append("\n"); 

	}
}