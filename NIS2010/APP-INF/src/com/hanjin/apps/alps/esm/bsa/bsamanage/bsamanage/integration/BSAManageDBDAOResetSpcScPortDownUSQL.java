/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOResetSpcScPortDownUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOResetSpcScPortDownUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ResetSpcScPortDown UPDATE
	  * </pre>
	  */
	public BSAManageDBDAOResetSpcScPortDownUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOResetSpcScPortDownUSQL").append("\n"); 
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
		query.append("UPDATE BSA_SLT_CHTR_PORT_DWN X" ).append("\n"); 
		query.append("SET X.PORT_BSA_CAPA = NVL((" ).append("\n"); 
		query.append("SELECT NVL(CRR_BSA_CAPA,0) CRR_BSA_CAPA" ).append("\n"); 
		query.append("FROM BSA_SLT_CHTR_BZC A," ).append("\n"); 
		query.append("BSA_SLT_CHTR_CRR_CAPA B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.BSA_SEQ      = B.BSA_SEQ" ).append("\n"); 
		query.append("AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.DIR_CD       = B.DIR_CD" ).append("\n"); 
		query.append("AND A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("AND A.VSL_SEQ      = B.VSL_SEQ" ).append("\n"); 
		query.append("AND B.BSA_SEQ      = X.BSA_SEQ" ).append("\n"); 
		query.append("AND B.RLANE_CD     = X.RLANE_CD" ).append("\n"); 
		query.append("AND B.DIR_CD       = X.DIR_CD" ).append("\n"); 
		query.append("AND B.TRD_CD       = X.TRD_CD" ).append("\n"); 
		query.append("AND B.VSL_SEQ      = X.VSL_SEQ" ).append("\n"); 
		query.append("AND B.BSA_OP_CD    = X.BSA_OP_CD" ).append("\n"); 
		query.append("AND B.BSA_OP_JB_CD = X.BSA_OP_JB_CD" ).append("\n"); 
		query.append("AND B.CRR_CD       = X.CRR_CD" ).append("\n"); 
		query.append("#if (${bsa_fm_dt} != '')" ).append("\n"); 
		query.append("AND A.BSA_FM_DT >= @[bsa_fm_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bsa_to_dt} != '')" ).append("\n"); 
		query.append("AND A.BSA_TO_DT <= @[bsa_to_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("), X.PORT_BSA_CAPA)," ).append("\n"); 
		query.append("X.UPD_USR_ID    = @[upd_usr_id]," ).append("\n"); 
		query.append("X.UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND X.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND X.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("AND X.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND X.BSA_OP_CD    = @[bsa_op_cd]" ).append("\n"); 
		query.append("AND X.BSA_OP_JB_CD = @[bsa_op_jb_cd]" ).append("\n"); 
		query.append("AND X.CRR_CD       = @[crr_cd]" ).append("\n"); 

	}
}