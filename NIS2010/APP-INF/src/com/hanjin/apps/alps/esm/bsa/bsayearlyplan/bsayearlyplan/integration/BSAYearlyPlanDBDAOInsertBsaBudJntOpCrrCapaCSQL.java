/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOInsertBsaBudJntOpCrrCapaCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.15
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.04.15 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOInsertBsaBudJntOpCrrCapaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA_BUD_JNT_OP_CRR_CAPA 데이타를 입력한다.
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOInsertBsaBudJntOpCrrCapaCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOInsertBsaBudJntOpCrrCapaCSQL").append("\n"); 
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
		query.append("INSERT INTO BSA_BUD_JNT_OP_CRR_CAPA (" ).append("\n"); 
		query.append("    TRD_CD      ," ).append("\n"); 
		query.append("    RLANE_CD    ," ).append("\n"); 
		query.append("    DIR_CD      ," ).append("\n"); 
		query.append("    VOP_CD      ," ).append("\n"); 
		query.append("    VSL_CAPA    ," ).append("\n"); 
		query.append("    BSA_SEQ     ," ).append("\n"); 
		query.append("    BSA_OP_CD   ," ).append("\n"); 
		query.append("    BSA_OP_JB_CD," ).append("\n"); 
		query.append("    CRR_CD      ," ).append("\n"); 
		query.append("    CRR_BSA_CAPA," ).append("\n"); 
		query.append("    CRE_USR_ID  ," ).append("\n"); 
		query.append("    CRE_DT      ," ).append("\n"); 
		query.append("    UPD_USR_ID  ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT B.TRD_CD      ," ).append("\n"); 
		query.append("         B.RLANE_CD    ," ).append("\n"); 
		query.append("         B.DIR_CD      ," ).append("\n"); 
		query.append("         B.VOP_CD      ," ).append("\n"); 
		query.append("         B.VSL_CAPA    ," ).append("\n"); 
		query.append("         B.BSA_SEQ     ," ).append("\n"); 
		query.append("         B.BSA_OP_CD   ," ).append("\n"); 
		query.append("         B.BSA_OP_JB_CD," ).append("\n"); 
		query.append("         B.CRR_CD      ," ).append("\n"); 
		query.append("         B.CRR_BSA_CAPA," ).append("\n"); 
		query.append("         @[cre_usr_id] ," ).append("\n"); 
		query.append("         SYSDATE       ," ).append("\n"); 
		query.append("         @[upd_usr_id] ," ).append("\n"); 
		query.append("         SYSDATE" ).append("\n"); 
		query.append("    FROM BSA_BUD_JNT_OP_BZC  A," ).append("\n"); 
		query.append("         BSA_JNT_OP_CRR_CAPA B" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND A.TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("     AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("     AND A.DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("     AND A.VOP_CD   = B.VOP_CD" ).append("\n"); 
		query.append("     AND A.VSL_CAPA = B.VSL_CAPA" ).append("\n"); 
		query.append("     AND A.BSA_SEQ  = B.BSA_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND A.TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rlane_cd} != 'All')" ).append("\n"); 
		query.append("     AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}