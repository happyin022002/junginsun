/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa5USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa5USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History ----------------------------------------
	  * 2011.01.20 이행지 [CHM-201108497-01] [BSA]사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
	  *                                                        - BSA Creation/Update(Yearly Plan) - Joint Operating 수정시 HJS의 Weight Update 
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa5USQL(){
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
		params.put("vsl_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa5USQL").append("\n"); 
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
		query.append("UPDATE BSA_BUD_JNT_OP_CRR_CAPA X" ).append("\n"); 
		query.append(" SET X.UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("     X.UPD_DT     = SYSDATE," ).append("\n"); 
		query.append("     (X.CRR_BSA_CAPA, X.SPC_CTRL_SLT_CAPA) = (" ).append("\n"); 
		query.append("                                              SELECT --A.OWNR_VSL_WGT,SUM(NVL(B.SPC_CTRL_SLT_CAPA,0)) BASIC," ).append("\n"); 
		query.append("                                                     A.OWNR_VSL_WGT - SUM(NVL(B.SPC_CTRL_SLT_CAPA,0)) CRR_BSA_CAPA," ).append("\n"); 
		query.append("                                                     A.OWNR_VSL_WGT - SUM(NVL(B.SPC_CTRL_SLT_CAPA,0)) SPC_CTRL_SLT_CAPA" ).append("\n"); 
		query.append("                                              FROM BSA_BUD_JNT_OP_BZC A, " ).append("\n"); 
		query.append("                                                   BSA_BUD_JNT_OP_CRR_CAPA B" ).append("\n"); 
		query.append("                                              WHERE 1=1" ).append("\n"); 
		query.append("                                                AND B.BSA_SEQ      = X.BSA_SEQ" ).append("\n"); 
		query.append("                                                AND B.TRD_CD       = X.TRD_CD" ).append("\n"); 
		query.append("                                                AND B.RLANE_CD     = X.RLANE_CD" ).append("\n"); 
		query.append("                                                AND B.DIR_CD       = X.DIR_CD" ).append("\n"); 
		query.append("                                                AND B.VOP_CD       = X.VOP_CD" ).append("\n"); 
		query.append("                                                AND B.VSL_CAPA     = X.VSL_CAPA" ).append("\n"); 
		query.append("                                                AND B.BSA_OP_CD    = X.BSA_OP_CD" ).append("\n"); 
		query.append("                                                AND B.BSA_OP_JB_CD = X.BSA_OP_JB_CD" ).append("\n"); 
		query.append("                                                AND A.BSA_SEQ      = B.BSA_SEQ" ).append("\n"); 
		query.append("                                                AND A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("                                                AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("                                                AND A.DIR_CD       = B.DIR_CD" ).append("\n"); 
		query.append("                                                AND A.VSL_CAPA     = B.VSL_CAPA" ).append("\n"); 
		query.append("                                                AND A.VOP_CD       = B.VOP_CD" ).append("\n"); 
		query.append("                                                AND B.CRR_CD       <> 'SML'" ).append("\n"); 
		query.append("                                              GROUP BY A.OWNR_VSL_WGT" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND X.BSA_SEQ      = @[bsa_seq]" ).append("\n"); 
		query.append("   AND X.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("   AND X.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("   AND X.DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("   AND X.VOP_CD       = @[vop_cd]" ).append("\n"); 
		query.append("   AND X.VSL_CAPA     = @[vsl_capa]" ).append("\n"); 
		query.append("   AND X.BSA_OP_CD    = @[bsa_op_cd]" ).append("\n"); 
		query.append("   AND X.BSA_OP_JB_CD = '009'" ).append("\n"); 
		query.append("   AND X.CRR_CD       = 'SML'" ).append("\n"); 

	}
}