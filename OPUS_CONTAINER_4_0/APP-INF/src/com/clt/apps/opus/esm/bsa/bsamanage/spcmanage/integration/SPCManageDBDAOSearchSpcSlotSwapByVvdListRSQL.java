/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SPCManageDBDAOSearchSpcSlotSwapByVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOSearchSpcSlotSwapByVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Company Slot Swap Information By VVD 조회 쿼리
	  * </pre>
	  */
	public SPCManageDBDAOSearchSpcSlotSwapByVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ptrd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pdir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pskd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pvsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pport_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pbsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOSearchSpcSlotSwapByVvdListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		DECODE(A.CRR_CD, '', 'I', 'R') IBFLAG, " ).append("\n"); 
		query.append("		B.CRR_CD, " ).append("\n"); 
		query.append("		A.SLS_TEU_CAPA, " ).append("\n"); 
		query.append("		A.SLS_WGT, " ).append("\n"); 
		query.append("		A.PUR_TEU_CAPA, " ).append("\n"); 
		query.append("		A.PUR_WGT, " ).append("\n"); 
		query.append("      	A.SLT_SWAP_RLANE_CD, " ).append("\n"); 
		query.append("		A.SLT_SWAP_VVD_CD, " ).append("\n"); 
		query.append("		A.SLT_SWAP_TEU_CAPA, " ).append("\n"); 
		query.append("		A.SLT_SWAP_WGT, " ).append("\n"); 
		query.append("		C.SLT_PRC_CAPA, " ).append("\n"); 
		query.append("		C.CO_BFR_SUB_CAPA " ).append("\n"); 
		query.append("FROM BSA_VVD_SWAP_INFO A, " ).append("\n"); 
		query.append("   ( " ).append("\n"); 
		query.append("      SELECT DISTINCT CRR_CD " ).append("\n"); 
		query.append("       FROM BSA_CRR_RGST " ).append("\n"); 
		query.append("       WHERE BSA_OP_CD  = 'J' " ).append("\n"); 
		query.append("         AND APLY_FLG   = 'Y' " ).append("\n"); 
		query.append("         AND CRR_CD    != COM_ConstantMgr_PKG.COM_getCompanyCode_FNC" ).append("\n"); 
		query.append("         AND BSA_OP_JB_CD IN (SELECT BSA_OP_JB_CD " ).append("\n"); 
		query.append("                              FROM BSA_OP_JB " ).append("\n"); 
		query.append("                              WHERE BSA_OP_JB_CD IN ( '001','002' ,'003' ,'004' ,'005') " ).append("\n"); 
		query.append("                                AND BSA_OP_CD      = 'J') " ).append("\n"); 
		query.append("    ) B, " ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("      SELECT B.CRR_CD, A.CO_BFR_SUB_CAPA, B.SLT_PRC_CAPA " ).append("\n"); 
		query.append("      FROM BSA_SLT_PRC A, BSA_SLT_PRC_CRR B " ).append("\n"); 
		query.append("      WHERE A.SLT_PRC_SEQ        = B.SLT_PRC_SEQ " ).append("\n"); 
		query.append("        AND A.TRD_CD             = B.TRD_CD " ).append("\n"); 
		query.append("        AND A.RLANE_CD           = B.RLANE_CD " ).append("\n"); 
		query.append("        AND A.DIR_CD             = B.DIR_CD " ).append("\n"); 
		query.append("        AND A.BSA_SLT_COST_TP_CD = B.BSA_SLT_COST_TP_CD " ).append("\n"); 
		query.append("        AND B.BSA_OP_JB_CD       = '001' " ).append("\n"); 
		query.append("        AND B.BSA_SLT_COST_TP_CD = '017' " ).append("\n"); 
		query.append("        AND A.TRD_CD             = @[ptrd_cd] " ).append("\n"); 
		query.append("        AND A.RLANE_CD           = @[prlane_cd] " ).append("\n"); 
		query.append("        AND A.DIR_CD             = @[pdir_cd]" ).append("\n"); 
		query.append("        AND A.BSA_SLT_PRC_FM_DT <= @[pport_etd_dt] " ).append("\n"); 
		query.append("        AND A.BSA_SLT_PRC_TO_DT >= @[pport_etd_dt]" ).append("\n"); 
		query.append("    ) C " ).append("\n"); 
		query.append("WHERE B.CRR_CD        = A.CRR_CD(+) " ).append("\n"); 
		query.append(" AND B.CRR_CD        = C.CRR_CD(+) " ).append("\n"); 
		query.append(" AND A.TRD_CD(+)     = @[ptrd_cd]  " ).append("\n"); 
		query.append(" AND A.RLANE_CD(+)   = @[prlane_cd] " ).append("\n"); 
		query.append(" AND A.VSL_CD(+)     = @[pvsl_cd] " ).append("\n"); 
		query.append(" AND A.SKD_VOY_NO(+) = @[pskd_voy_no] " ).append("\n"); 
		query.append(" AND A.SKD_DIR_CD(+) = @[pdir_cd] " ).append("\n"); 
		query.append(" AND A.BSA_OP_JB_CD(+) = @[pbsa_op_jb_cd] " ).append("\n"); 
		query.append("ORDER BY CRR_CD" ).append("\n"); 

	}
}