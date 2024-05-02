/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa3USQL.java
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

public class BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa3USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History ----------------------------------------
	  * 2011.01.20 이행지 [CHM-201108497-01] [BSA]사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
	  *                                                        - BSA Creation/Update(Yearly Plan) - Joint Operating 수정시 HJS의 CRR_BSA_CAPA, SPC_CTRL_SLT_CAPA update
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa3USQL(){
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
		query.append("FileName : BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa3USQL").append("\n"); 
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
		query.append("UPDATE BSA_BUD_JNT_OP_CRR_CAPA A" ).append("\n"); 
		query.append(" SET    (A.CRR_BSA_CAPA) = (SELECT NVL(SUM(B.FNL_HJS_BSA_CAPA),0)" ).append("\n"); 
		query.append("                              FROM   BSA_JNT_OP_BZC B" ).append("\n"); 
		query.append("                             WHERE  B.BSA_SEQ  = A.BSA_SEQ" ).append("\n"); 
		query.append("                               AND  B.TRD_CD   = A.TRD_CD" ).append("\n"); 
		query.append("                               AND  B.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("                               AND  B.DIR_CD   = A.DIR_CD" ).append("\n"); 
		query.append("                               AND  B.VOP_CD   = A.VOP_CD" ).append("\n"); 
		query.append("                               AND  B.VSL_CAPA = A.VSL_CAPA" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("       ,A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("       ,A.UPD_DT 	 = SYSDATE" ).append("\n"); 
		query.append(" WHERE  A.BSA_SEQ      = @[bsa_seq]" ).append("\n"); 
		query.append(" AND    A.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append(" AND    A.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append(" AND    A.DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append(" AND    A.VOP_CD       = @[vop_cd]" ).append("\n"); 
		query.append(" AND    A.VSL_CAPA     = @[vsl_capa]" ).append("\n"); 
		query.append(" AND    A.BSA_OP_CD    = @[bsa_op_cd]" ).append("\n"); 
		query.append(" AND    A.BSA_OP_JB_CD = '007'" ).append("\n"); 
		query.append(" AND    A.CRR_CD       = 'SML'" ).append("\n"); 

	}
}