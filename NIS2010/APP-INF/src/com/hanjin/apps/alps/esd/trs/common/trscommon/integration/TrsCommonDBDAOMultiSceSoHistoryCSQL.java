/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TrsCommonDBDAOMultiSceSoHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOMultiSceSoHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Route Replan시 SCE에 History를 기록
	  * </pre>
	  */
	public TrsCommonDBDAOMultiSceSoHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOMultiSceSoHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_SO_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("    ,TRSP_HIS_SEQ" ).append("\n"); 
		query.append("    ,TRSP_SO_EVNT_CD" ).append("\n"); 
		query.append("    ,EQ_NO" ).append("\n"); 
		query.append("    ,TRSP_SO_STS_CD" ).append("\n"); 
		query.append("    ,SO_ROUT_DESC" ).append("\n"); 
		query.append("    ,COP_SO_STS_CD" ).append("\n"); 
		query.append("    ,COP_SO_ROUT_DESC" ).append("\n"); 
		query.append("    ,COP_NO" ).append("\n"); 
		query.append("    ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("    ,COST_ACT_GRP_CD" ).append("\n"); 
		query.append("    ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("    ,BKG_NO" ).append("\n"); 
		query.append("    ,ROUT_RPLN_FLG" ).append("\n"); 
		query.append("    ,UPLN_SO_FLG" ).append("\n"); 
		query.append("    ,RPLN_UMCH_FLG" ).append("\n"); 
		query.append("    ,RQST_SRC_SYS_CD" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,CRE_OFC_CD" ).append("\n"); 
		query.append("    ,LOCL_CRE_DT" ).append("\n"); 
		query.append("    ,TRSP_SO_HIS_DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  T.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("       ,T.TRSP_SO_SEQ" ).append("\n"); 
		query.append("       ,TRS_TRSP_SO_HIS_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("       ,'S'||@[trsp_so_sts_cd] TRSP_SO_EVNT_CD-- 각 EVENT에서 넘겨준 값" ).append("\n"); 
		query.append("       ,T.EQ_NO" ).append("\n"); 
		query.append("       ,T.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("       ,@[inter_rmk] || ' => ' ||'('||T.TRSP_CRR_MOD_CD||') ' || T.FM_NOD_CD ||'-'|| T.VIA_NOD_CD ||'-'|| T.DOR_NOD_CD ||'-'|| T.TO_NOD_CD AS SO_ROUT_DESC" ).append("\n"); 
		query.append("       ,S.TRSP_SO_STS_CD COP_SO_STS_CD" ).append("\n"); 
		query.append("       ,'('||S.TRSP_MOD_CD||') ' || S.N1ST_NOD_CD ||'-'|| S.N2ND_NOD_CD ||'-'|| S.N3RD_NOD_CD ||'-'|| S.N4TH_NOD_CD AS COP_SO_ROUT_DESC" ).append("\n"); 
		query.append("       ,T.COP_NO" ).append("\n"); 
		query.append("       ,T.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("       ,S.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("       ,T.EQ_TPSZ_CD" ).append("\n"); 
		query.append("       ,T.BKG_NO" ).append("\n"); 
		query.append("       ,'Y'" ).append("\n"); 
		query.append("       ,T.UPLN_SO_FLG" ).append("\n"); 
		query.append("       ,T.RPLN_UMCH_FLG" ).append("\n"); 
		query.append("       ,'SCE'" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("          ,Sysdate" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("       ,Sysdate" ).append("\n"); 
		query.append("       ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("       ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(NVL(@[cre_ofc_cd], 'SELCON'))" ).append("\n"); 
		query.append("       ,DECODE(S.COP_NO, NULL, 'Original IRG does not exist', '') TRSP_SO_HIS_DESC" ).append("\n"); 
		query.append("  FROM SCE_PLN_SO_LIST  S" ).append("\n"); 
		query.append("      ,TRS_TRSP_SVC_ORD T" ).append("\n"); 
		query.append(" WHERE T.COP_NO = S.COP_NO(+)" ).append("\n"); 
		query.append("   AND T.COST_ACT_GRP_SEQ = S.COST_ACT_GRP_SEQ(+)" ).append("\n"); 
		query.append("   AND T.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND T.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND T.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}