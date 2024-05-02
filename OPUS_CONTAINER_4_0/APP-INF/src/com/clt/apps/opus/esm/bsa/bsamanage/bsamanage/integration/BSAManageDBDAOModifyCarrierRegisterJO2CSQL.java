/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAManageDBDAOModifyCarrierRegisterJO2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOModifyCarrierRegisterJO2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCarrierRegisterJO2 UPDATE
	  * </pre>
	  */
	public BSAManageDBDAOModifyCarrierRegisterJO2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOModifyCarrierRegisterJO2CSQL").append("\n"); 
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
		query.append("INSERT INTO BSA_JNT_OP_PORT_DWN (" ).append("\n"); 
		query.append("        BSA_SEQ, " ).append("\n"); 
		query.append("        TRD_CD, " ).append("\n"); 
		query.append("        RLANE_CD, " ).append("\n"); 
		query.append("        DIR_CD, " ).append("\n"); 
		query.append("        VOP_CD," ).append("\n"); 
		query.append("        VSL_CAPA, " ).append("\n"); 
		query.append("        BSA_OP_CD, " ).append("\n"); 
		query.append("        BSA_OP_JB_CD, " ).append("\n"); 
		query.append("        CRR_CD," ).append("\n"); 
		query.append("        PORT_SEQ, " ).append("\n"); 
		query.append("        PORT_CD, " ).append("\n"); 
		query.append("        PORT_BSA_CAPA," ).append("\n"); 
		query.append("        CRE_USR_ID, " ).append("\n"); 
		query.append("        CRE_DT, " ).append("\n"); 
		query.append("        UPD_USR_ID, " ).append("\n"); 
		query.append("        UPD_DT)" ).append("\n"); 
		query.append(" SELECT A.BSA_SEQ, " ).append("\n"); 
		query.append("        A.TRD_CD, " ).append("\n"); 
		query.append("        A.RLANE_CD, " ).append("\n"); 
		query.append("        A.DIR_CD, " ).append("\n"); 
		query.append("        A.VOP_CD, " ).append("\n"); 
		query.append("        A.VSL_CAPA," ).append("\n"); 
		query.append("        A.BSA_OP_CD," ).append("\n"); 
		query.append("        A.BSA_OP_JB_CD," ).append("\n"); 
		query.append("        @[crr_cd]," ).append("\n"); 
		query.append("        A.PORT_SEQ," ).append("\n"); 
		query.append("        A.PORT_CD," ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        @[cre_usr_id], " ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append(" FROM   BSA_JNT_OP_PORT_DWN A" ).append("\n"); 
		query.append(" WHERE  A.BSA_OP_CD    = @[bsa_op_cd]" ).append("\n"); 
		query.append(" AND    A.BSA_OP_JB_CD IN ('007','015','016')" ).append("\n"); 
		query.append(" AND    A.CRR_CD       = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC  /* 항상 존재하는 값 .. */" ).append("\n"); 
		query.append(" AND    NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                    FROM   BSA_JNT_OP_PORT_DWN D" ).append("\n"); 
		query.append("                    WHERE  BSA_SEQ      = A.BSA_SEQ" ).append("\n"); 
		query.append("                    AND    TRD_CD       = A.TRD_CD" ).append("\n"); 
		query.append("                    AND    RLANE_CD     = A.RLANE_CD" ).append("\n"); 
		query.append("                    AND    DIR_CD       = A.DIR_CD" ).append("\n"); 
		query.append("                    AND    VOP_CD       = A.VOP_CD" ).append("\n"); 
		query.append("                    AND    VSL_CAPA     = A.VSL_CAPA" ).append("\n"); 
		query.append("                    AND    BSA_OP_CD    = A.BSA_OP_CD" ).append("\n"); 
		query.append("                    AND    BSA_OP_JB_CD = A.BSA_OP_JB_CD" ).append("\n"); 
		query.append("                    AND    CRR_CD       = @[crr_cd]" ).append("\n"); 
		query.append("                    AND    PORT_SEQ     = A.PORT_SEQ" ).append("\n"); 
		query.append("                   )" ).append("\n"); 

	}
}