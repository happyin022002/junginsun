/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOModifyCarrierRegisterSCCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.04.13 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOModifyCarrierRegisterSCCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCarrierRegisterSC INSERT
	  * </pre>
	  */
	public BSAManageDBDAOModifyCarrierRegisterSCCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOModifyCarrierRegisterSCCSQL").append("\n"); 
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
		query.append("INSERT INTO BSA_SLT_CHTR_CRR_CAPA (" ).append("\n"); 
		query.append("        BSA_SEQ, " ).append("\n"); 
		query.append("        TRD_CD, " ).append("\n"); 
		query.append("        RLANE_CD, " ).append("\n"); 
		query.append("        DIR_CD, " ).append("\n"); 
		query.append("        VSL_SEQ," ).append("\n"); 
		query.append("        BSA_OP_CD, " ).append("\n"); 
		query.append("        BSA_OP_JB_CD, " ).append("\n"); 
		query.append("        CRR_CD, " ).append("\n"); 
		query.append("        CRR_BSA_CAPA," ).append("\n"); 
		query.append("        CRE_USR_ID, " ).append("\n"); 
		query.append("        CRE_DT, " ).append("\n"); 
		query.append("        UPD_USR_ID, " ).append("\n"); 
		query.append("        UPD_DT)" ).append("\n"); 
		query.append(" SELECT A.BSA_SEQ, " ).append("\n"); 
		query.append("        A.TRD_CD, " ).append("\n"); 
		query.append("        A.RLANE_CD, " ).append("\n"); 
		query.append("        A.DIR_CD, " ).append("\n"); 
		query.append("        A.VSL_SEQ," ).append("\n"); 
		query.append("        @[bsa_op_cd] ," ).append("\n"); 
		query.append("        A.BSA_OP_JB_CD, " ).append("\n"); 
		query.append("        @[crr_cd], " ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        @[upd_usr_id] ," ).append("\n"); 
		query.append("        SYSDATE ," ).append("\n"); 
		query.append("        @[upd_usr_id] ," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append(" FROM   (SELECT BSA_SEQ, " ).append("\n"); 
		query.append("                TRD_CD, " ).append("\n"); 
		query.append("                RLANE_CD, " ).append("\n"); 
		query.append("                DIR_CD, " ).append("\n"); 
		query.append("                VSL_SEQ, " ).append("\n"); 
		query.append("                BSA_OP_JB_CD" ).append("\n"); 
		query.append("         FROM   BSA_SLT_CHTR_CRR_CAPA" ).append("\n"); 
		query.append("         WHERE  BSA_OP_CD = @[bsa_op_cd]" ).append("\n"); 
		query.append("         AND   (BSA_OP_JB_CD = @[bsa_op_jb_cd] " ).append("\n"); 
		query.append("            OR (BSA_OP_JB_CD BETWEEN '006' AND '022'))" ).append("\n"); 
		query.append("         GROUP BY" ).append("\n"); 
		query.append("                BSA_SEQ, " ).append("\n"); 
		query.append("                TRD_CD, " ).append("\n"); 
		query.append("                RLANE_CD, " ).append("\n"); 
		query.append("                DIR_CD, " ).append("\n"); 
		query.append("                VSL_SEQ, " ).append("\n"); 
		query.append("                BSA_OP_JB_CD" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append(" WHERE  NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                    FROM   BSA_SLT_CHTR_CRR_CAPA B" ).append("\n"); 
		query.append("                    WHERE  BSA_SEQ      = A.BSA_SEQ" ).append("\n"); 
		query.append("                    AND    TRD_CD       = A.TRD_CD" ).append("\n"); 
		query.append("                    AND    RLANE_CD     = A.RLANE_CD" ).append("\n"); 
		query.append("                    AND    DIR_CD       = A.DIR_CD" ).append("\n"); 
		query.append("                    AND    VSL_SEQ      = A.VSL_SEQ" ).append("\n"); 
		query.append("                    AND    BSA_OP_CD    = @[bsa_op_cd]" ).append("\n"); 
		query.append("                    AND    BSA_OP_JB_CD = A.BSA_OP_JB_CD" ).append("\n"); 
		query.append("                    AND    CRR_CD       = @[crr_cd]" ).append("\n"); 
		query.append("                   )" ).append("\n"); 

	}
}