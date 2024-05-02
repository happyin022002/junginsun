/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOModifyBsaBudSltChtrCrrCapa5USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.25
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.25 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOModifyBsaBudSltChtrCrrCapa5USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOModifyBsaBudSltChtrCrrCapa5USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration ").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOModifyBsaBudSltChtrCrrCapa5USQL").append("\n"); 
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
		query.append("UPDATE BSA_BUD_SLT_CHTR_CRR_CAPA X" ).append("\n"); 
		query.append(" SET X.UPD_USR_ID   = @[upd_usr_id]," ).append("\n"); 
		query.append("     X.UPD_DT       = SYSDATE," ).append("\n"); 
		query.append("     X.CRR_BSA_CAPA = (" ).append("\n"); 
		query.append("                       SELECT --Y.BSA_SEQ, Y.RLANE_CD, Y.DIR_CD, Y.TRD_CD, Y.VSL_SEQ," ).append("\n"); 
		query.append("                              DECODE( SUM(DECODE(Y.BSA_OP_JB_CD,'007',NVL(Y.CRR_BSA_CAPA,0))), '0', '0'," ).append("\n"); 
		query.append("                                      SUM(DECODE(Y.BSA_OP_JB_CD,'009',NVL(Y.CRR_BSA_CAPA,0)))/" ).append("\n"); 
		query.append("                                      SUM(DECODE(Y.BSA_OP_JB_CD,'007',NVL(Y.CRR_BSA_CAPA,0))) ) CRR_BSA_CAPA" ).append("\n"); 
		query.append("                       FROM BSA_BUD_SLT_CHTR_CRR_CAPA Y" ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                         AND X.BSA_SEQ   = Y.BSA_SEQ" ).append("\n"); 
		query.append("                         AND X.RLANE_CD  = Y.RLANE_CD" ).append("\n"); 
		query.append("                         AND X.DIR_CD    = Y.DIR_CD" ).append("\n"); 
		query.append("                         AND X.TRD_CD    = Y.TRD_CD" ).append("\n"); 
		query.append("                         AND X.VSL_SEQ   = Y.VSL_SEQ" ).append("\n"); 
		query.append("                         AND X.BSA_OP_CD = Y.BSA_OP_CD" ).append("\n"); 
		query.append("                         AND X.CRR_CD    = Y.CRR_CD" ).append("\n"); 
		query.append("                         AND Y.BSA_OP_JB_CD IN ('007','009')" ).append("\n"); 
		query.append("                       --GROUP BY BSA_SEQ, RLANE_CD, DIR_CD, TRD_CD, VSL_SEQ" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND X.BSA_SEQ   = @[bsa_seq]" ).append("\n"); 
		query.append("   AND X.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("   AND X.DIR_CD    = @[dir_cd]" ).append("\n"); 
		query.append("   AND X.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("   and X.VSL_SEQ   = @[vsl_seq]" ).append("\n"); 
		query.append("   and X.BSA_OP_CD = @[bsa_op_cd]" ).append("\n"); 
		query.append("   AND X.BSA_OP_JB_CD = '008'" ).append("\n"); 

	}
}