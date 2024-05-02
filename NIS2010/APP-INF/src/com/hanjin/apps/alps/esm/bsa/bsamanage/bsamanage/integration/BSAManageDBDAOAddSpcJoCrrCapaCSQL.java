/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOAddSpcJoCrrCapaCSQL.java
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

public class BSAManageDBDAOAddSpcJoCrrCapaCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSpcJoCrrCapa Insert
	  * </pre>
	  */
	public BSAManageDBDAOAddSpcJoCrrCapaCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("bsa_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOAddSpcJoCrrCapaCSQL").append("\n"); 
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
		query.append("INSERT INTO BSA_JNT_OP_CRR_CAPA (" ).append("\n"); 
		query.append("BSA_SEQ," ).append("\n"); 
		query.append("TRD_CD," ).append("\n"); 
		query.append("RLANE_CD," ).append("\n"); 
		query.append("DIR_CD," ).append("\n"); 
		query.append("VOP_CD," ).append("\n"); 
		query.append("VSL_CAPA," ).append("\n"); 
		query.append("BSA_OP_CD," ).append("\n"); 
		query.append("BSA_OP_JB_CD," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("CRR_BSA_CAPA," ).append("\n"); 
		query.append("SPC_CTRL_SLT_CAPA," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.BSA_SEQ," ).append("\n"); 
		query.append("A.TRD_CD," ).append("\n"); 
		query.append("A.RLANE_CD," ).append("\n"); 
		query.append("A.DIR_CD," ).append("\n"); 
		query.append("A.VOP_CD," ).append("\n"); 
		query.append("A.VSL_CAPA," ).append("\n"); 
		query.append("B.BSA_OP_CD," ).append("\n"); 
		query.append("LPAD(C.NUM+5,3,'0') BSA_OP_JB_CD," ).append("\n"); 
		query.append("B.CRR_CD," ).append("\n"); 
		query.append("0 CRR_BSA_CAPA," ).append("\n"); 
		query.append("0 SPC_CTRL_SLT_CAPA," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM   BSA_JNT_OP_BZC  A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("BSA_OP_CD," ).append("\n"); 
		query.append("CRR_CD" ).append("\n"); 
		query.append("FROM BSA_CRR_RGST" ).append("\n"); 
		query.append("WHERE BSA_OP_CD    = @[bsa_op_cd]   /* Joint Operating */" ).append("\n"); 
		query.append("AND BSA_OP_JB_CD IN ('001','002','003','004','005')" ).append("\n"); 
		query.append("AND NVL(APLY_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("ORDER BY crr_cd" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(SELECT NUM" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT ROWNUM NUM" ).append("\n"); 
		query.append("FROM COM_CPY_NO" ).append("\n"); 
		query.append("WHERE ROWNUM<= 17)" ).append("\n"); 
		query.append("WHERE num NOT IN (15,16)" ).append("\n"); 
		query.append("-- SELECT ROWNUM NUM FROM COM_CPY_NO WHERE ROWNUM<= 14 BSA_OP_CD BETWEEN '006' AND '019'" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE  A.BSA_SEQ   = @[bsa_seq]" ).append("\n"); 
		query.append("AND    A.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("AND    A.DIR_CD    = @[dir_cd]" ).append("\n"); 
		query.append("AND    A.VOP_CD    = @[vop_cd]" ).append("\n"); 
		query.append("AND    A.VSL_CAPA  = @[vsl_capa]" ).append("\n"); 

	}
}