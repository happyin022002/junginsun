/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOModifyemultiChgSlotSwapUSQL.java
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

public class BSAManageDBDAOModifyemultiChgSlotSwapUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BSA_0122화면의 BSA_JNT_OP_BZC UPDATE 쿼리
	  * </pre>
	  */
	public BSAManageDBDAOModifyemultiChgSlotSwapUSQL(){
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
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOModifyemultiChgSlotSwapUSQL").append("\n"); 
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
		query.append("UPDATE BSA_JNT_OP_BZC C" ).append("\n"); 
		query.append("SET SPC_OTR_SWAP_FLG = (" ).append("\n"); 
		query.append("SELECT --A.BSA_SEQ, A.TRD_CD, A.RLANE_CD, A.DIR_CD, A.VOP_CD, A.VSL_CAPA, A.BSA_OP_CD, A.BSA_OP_JB_CD," ).append("\n"); 
		query.append("DECODE(NVL(SUM(DECODE(A.CRR_CD, B.BSA_FM_CRR_CD, B.CRR_SWAP_CAPA, 0)),0)" ).append("\n"); 
		query.append("+ NVL(SUM(DECODE(A.CRR_CD, B.BSA_TO_CRR_CD, B.CRR_SWAP_CAPA, 0)),0), 0, '', 'Y') AS SWAP_CAPA" ).append("\n"); 
		query.append("FROM BSA_JNT_OP_CRR_CAPA A," ).append("\n"); 
		query.append("BSA_SPC_CTRL_SWAP B" ).append("\n"); 
		query.append("WHERE A.BSA_SEQ      = B.BSA_SEQ" ).append("\n"); 
		query.append("AND A.TRD_CD       = B.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.DIR_CD       = B.DIR_CD" ).append("\n"); 
		query.append("AND A.VOP_CD       = A.VOP_CD" ).append("\n"); 
		query.append("AND A.VSL_CAPA     = B.VSL_CAPA" ).append("\n"); 
		query.append("AND A.BSA_OP_CD    = B.BSA_OP_CD" ).append("\n"); 
		query.append("AND A.BSA_OP_JB_CD = B.BSA_OP_JB_CD" ).append("\n"); 
		query.append("AND A.BSA_SEQ      = C.BSA_SEQ" ).append("\n"); 
		query.append("AND A.TRD_CD       = C.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD     = C.RLANE_CD" ).append("\n"); 
		query.append("AND A.DIR_CD       = C.DIR_CD" ).append("\n"); 
		query.append("AND A.VOP_CD       = C.VOP_CD" ).append("\n"); 
		query.append("AND A.VSL_CAPA     = C.VSL_CAPA" ).append("\n"); 
		query.append("AND A.BSA_OP_CD    = 'J'" ).append("\n"); 
		query.append("AND A.BSA_OP_JB_CD = '007'" ).append("\n"); 
		query.append("--GROUP BY A.BSA_SEQ, A.TRD_CD, A.RLANE_CD, A.DIR_CD, A.VOP_CD, A.VSL_CAPA, A.BSA_OP_CD, A.BSA_OP_JB_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE C.BSA_SEQ    = @[bsa_seq]" ).append("\n"); 
		query.append("AND C.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("AND C.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("AND C.DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("AND C.VOP_CD       = @[vop_cd]" ).append("\n"); 
		query.append("AND C.VSL_CAPA     = @[vsl_capa]" ).append("\n"); 

	}
}