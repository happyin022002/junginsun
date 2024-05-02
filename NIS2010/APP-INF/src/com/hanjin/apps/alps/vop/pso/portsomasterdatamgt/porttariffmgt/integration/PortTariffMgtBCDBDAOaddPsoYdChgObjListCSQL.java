/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOaddPsoYdChgObjListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOaddPsoYdChgObjListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * yard별 object list저장하기 위함.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOaddPsoYdChgObjListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOaddPsoYdChgObjListCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_YD_CHG_OBJ_LIST (YD_CHG_NO, YD_CHG_VER_SEQ,OBJ_LIST_NO,DFLT_VAL,DFLT_FLG,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT @[yd_chg_no], @[new_chg_seq] , X.OBJ_LIST_NO, Z.DFLT_VAL,'N',@[cre_usr_id], SYSDATE, @[cre_usr_id] , SYSDATE" ).append("\n"); 
		query.append("FROM (  SELECT P.OBJ_LIST_NO ,Q.OBJ_LIST_NM , R.INTG_CD_VAL_DP_DESC, PSO_MEAS_UT_CD " ).append("\n"); 
		query.append("         FROM  ( SELECT DISTINCT DECODE(Y.RNUM, 1, X.OBJ_LIST_NO, X.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("                   FROM   (   SELECT BB.OBJ_LIST_NO  ,BB.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                                FROM PSO_FORMULA B ,PSO_FOML_DTL BB" ).append("\n"); 
		query.append("                               WHERE B.FOML_NO = BB.FOML_NO" ).append("\n"); 
		query.append("                                 AND BB.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("                                 AND B.FOML_NO IN (  SELECT DISTINCT A.FOML_NO  " ).append("\n"); 
		query.append("                                                       FROM PSO_FOML_DTL A, PSO_CHG_XPR_DTL B, PSO_OBJ_LIST C, PSO_YD_CHG_XPR D" ).append("\n"); 
		query.append("                                                       WHERE B.CHG_XPR_NO   = D.CHG_XPR_NO " ).append("\n"); 
		query.append("                                                         AND A.FOML_NO      = B.FOML_NO" ).append("\n"); 
		query.append("                                                         AND A.PSO_FOML_DTL_TP_CD = 'O'" ).append("\n"); 
		query.append("                                                         AND C.OBJ_LIST_NO  = A.OBJ_LIST_NO " ).append("\n"); 
		query.append("                                                         AND D.YD_CHG_NO    = @[yd_chg_no]" ).append("\n"); 
		query.append("                                                         AND D.YD_CHG_VER_SEQ = @[new_chg_seq])" ).append("\n"); 
		query.append("                              UNION ALL" ).append("\n"); 
		query.append("                              SELECT BB.OBJ_LIST_NO ,BB.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                                FROM PSO_CONDITION B ,PSO_COND_DTL BB" ).append("\n"); 
		query.append("                               WHERE B.COND_NO      = BB.COND_NO" ).append("\n"); 
		query.append("                                 AND BB.OBJ_LIST_NO IS NOT NULL" ).append("\n"); 
		query.append("                                 AND B.COND_NO IN ( SELECT DISTINCT A.COND_NO  " ).append("\n"); 
		query.append("                                                      FROM PSO_COND_DTL A, PSO_CHG_XPR_DTL B, PSO_OBJ_LIST C, PSO_YD_CHG_XPR D" ).append("\n"); 
		query.append("                                                     WHERE B.CHG_XPR_NO = D.CHG_XPR_NO " ).append("\n"); 
		query.append("                                                       AND A.COND_NO    = B.COND_NO" ).append("\n"); 
		query.append("                                                       AND A.PSO_COND_DTL_TP_CD = 'O'" ).append("\n"); 
		query.append("                                                       AND C.OBJ_LIST_NO = A.OBJ_LIST_NO" ).append("\n"); 
		query.append("                                                       AND D.YD_CHG_NO   =  @[yd_chg_no]" ).append("\n"); 
		query.append("                                                       AND D.YD_CHG_VER_SEQ =  @[new_chg_seq]  ) ) X  ," ).append("\n"); 
		query.append("      (SELECT LEVEL RNUM" ).append("\n"); 
		query.append("         FROM   DUAL" ).append("\n"); 
		query.append("       CONNECT BY LEVEL <= 2 ) Y" ).append("\n"); 
		query.append("         WHERE  DECODE(Y.RNUM, 1, X.OBJ_LIST_NO, X.RT_OBJ_LIST_NO) IS NOT NULL ) P ,PSO_OBJ_LIST Q, COM_INTG_CD_DTL R" ).append("\n"); 
		query.append("     WHERE P.OBJ_LIST_NO = Q.OBJ_LIST_NO" ).append("\n"); 
		query.append("       AND R.INTG_CD_ID = 'CD01848'" ).append("\n"); 
		query.append("       AND R.INTG_CD_VAL_CTNT  = Q.PSO_MEAS_UT_CD" ).append("\n"); 
		query.append("       AND R.INTG_CD_VAL_CTNT NOT IN ('14','11','12') ) X,  PSO_YD_CHG_OBJ_LIST Z" ).append("\n"); 
		query.append(" WHERE X.OBJ_LIST_NO       = Z.OBJ_LIST_NO(+)" ).append("\n"); 
		query.append("   AND Z.YD_CHG_NO(+)      = @[yd_chg_no]" ).append("\n"); 
		query.append("   AND Z.YD_CHG_VER_SEQ(+) = @[old_chg_seq]" ).append("\n"); 

	}
}