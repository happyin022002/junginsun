/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BSAManageDBDAOAddSpcScPortDwnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOAddSpcScPortDwnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSpcScPortDwn
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BSAManageDBDAOAddSpcScPortDwnCSQL(){
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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOAddSpcScPortDwnCSQL").append("\n"); 
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
		query.append("INSERT INTO BSA_SLT_CHTR_PORT_DWN (" ).append("\n"); 
		query.append("        BSA_SEQ" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , VSL_SEQ" ).append("\n"); 
		query.append("      , BSA_OP_CD" ).append("\n"); 
		query.append("      , BSA_OP_JB_CD" ).append("\n"); 
		query.append("      , CRR_CD" ).append("\n"); 
		query.append("      , PORT_SEQ" ).append("\n"); 
		query.append("      , PORT_CD" ).append("\n"); 
		query.append("      , PORT_BSA_CAPA" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("        A.BSA_SEQ" ).append("\n"); 
		query.append("       ,A.TRD_CD" ).append("\n"); 
		query.append("       ,A.RLANE_CD" ).append("\n"); 
		query.append("       ,A.DIR_CD" ).append("\n"); 
		query.append("       ,A.VSL_SEQ" ).append("\n"); 
		query.append("       ,B.BSA_OP_CD" ).append("\n"); 
		query.append("       ,B.BSA_OP_JB_CD" ).append("\n"); 
		query.append("       ,B.CRR_CD" ).append("\n"); 
		query.append("       ,ROW_NUMBER() OVER(PARTITION BY A.BSA_SEQ,A.TRD_CD,A.RLANE_CD,A.DIR_CD,A.VSL_SEQ," ).append("\n"); 
		query.append("                                       B.BSA_OP_CD,B.BSA_OP_JB_CD,B.CRR_CD" ).append("\n"); 
		query.append("                          ORDER BY C.LOC_CD) PORT_SEQ" ).append("\n"); 
		query.append("       ,C.LOC_CD AS PORT_CD" ).append("\n"); 
		query.append("       ,DECODE(B.BSA_OP_JB_CD, '007',DECODE(B.CRR_CD, 'SML',A.HJS_FNL_BSA_CAPA, 0), 0) AS PORT_BSA_CAPA" ).append("\n"); 
		query.append("       ,@[cre_usr_id] ," ).append("\n"); 
		query.append("       SYSDATE ," ).append("\n"); 
		query.append("       @[upd_usr_id] ," ).append("\n"); 
		query.append("       SYSDATE" ).append("\n"); 
		query.append(" FROM   BSA_SLT_CHTR_BZC      A" ).append("\n"); 
		query.append("       ,BSA_SLT_CHTR_CRR_CAPA B" ).append("\n"); 
		query.append("       ,(SELECT DISTINCT " ).append("\n"); 
		query.append("                Y.TRD_CD, " ).append("\n"); 
		query.append("                Y.RLANE_CD, " ).append("\n"); 
		query.append("                Y.DIR_CD, " ).append("\n"); 
		query.append("                Y.LOC_CD" ).append("\n"); 
		query.append("         FROM   MAS_MON_VVD             X" ).append("\n"); 
		query.append("               ,MAS_MON_VVD_PORT_OP_DYS Y" ).append("\n"); 
		query.append("         WHERE  X.TRD_CD     = Y.TRD_CD" ).append("\n"); 
		query.append("         AND    X.RLANE_CD   = Y.RLANE_CD" ).append("\n"); 
		query.append("         AND    X.IOC_CD     = Y.IOC_CD" ).append("\n"); 
		query.append("         AND    X.VSL_CD     = Y.VSL_CD" ).append("\n"); 
		query.append("         AND    X.SKD_VOY_NO = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND    X.DIR_CD     = Y.DIR_CD" ).append("\n"); 
		query.append("         AND    X.MON_TGT_FLG = 'N'" ).append("\n"); 
		query.append("         AND    NVL(X.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append(" WHERE  A.BSA_SEQ   = B.BSA_SEQ" ).append("\n"); 
		query.append(" AND    A.TRD_CD    = B.TRD_CD" ).append("\n"); 
		query.append(" AND    A.RLANE_CD  = B.RLANE_CD" ).append("\n"); 
		query.append(" AND    A.DIR_CD    = B.DIR_CD" ).append("\n"); 
		query.append(" AND    A.VSL_SEQ   = B.VSL_SEQ" ).append("\n"); 
		query.append(" AND    A.TRD_CD    = C.TRD_CD" ).append("\n"); 
		query.append(" AND    A.RLANE_CD  = C.RLANE_CD" ).append("\n"); 
		query.append(" AND    A.DIR_CD    = C.DIR_CD" ).append("\n"); 
		query.append(" AND    A.BSA_SEQ      = @[bsa_seq]" ).append("\n"); 
		query.append(" AND    A.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append(" AND    A.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append(" AND    A.DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append(" AND    A.VSL_SEQ      = @[vsl_seq]" ).append("\n"); 
		query.append(" AND    B.BSA_OP_CD    = @[bsa_op_cd]" ).append("\n"); 
		query.append(" AND    B.BSA_OP_JB_CD IN ('007','015','016')" ).append("\n"); 
		query.append(" AND    B.CRR_CD       IN (SELECT DISTINCT crr_cd" ).append("\n"); 
		query.append("                           FROM   BSA_CRR_RGST" ).append("\n"); 
		query.append("                           WHERE  BSA_OP_CD = @[bsa_op_cd]" ).append("\n"); 
		query.append("                           AND    BSA_OP_JB_CD IN ('001','002','003','004','005')" ).append("\n"); 
		query.append("                           AND    NVL(APLY_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("                          )" ).append("\n"); 

	}
}