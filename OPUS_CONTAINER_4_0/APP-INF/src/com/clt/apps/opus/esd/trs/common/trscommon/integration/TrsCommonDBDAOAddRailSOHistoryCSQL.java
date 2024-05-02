/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsCommonDBDAOAddRailSOHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.17
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.17 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOAddRailSOHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail SO 생성시 History 를 생성한다.
	  * </pre>
	  */
	public TrsCommonDBDAOAddRailSOHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_so_evnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_pln_rout_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_rpln_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOAddRailSOHistoryCSQL").append("\n"); 
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
		query.append("	TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	,TRSP_SO_SEQ" ).append("\n"); 
		query.append("	,TRSP_HIS_SEQ" ).append("\n"); 
		query.append("	,TRSP_SO_EVNT_CD" ).append("\n"); 
		query.append("	,EQ_NO" ).append("\n"); 
		query.append("	,INV_NO" ).append("\n"); 
		query.append("	,INV_VNDR_SEQ" ).append("\n"); 
		query.append("	,TRSP_SO_STS_CD" ).append("\n"); 
		query.append("	,SO_ROUT_DESC" ).append("\n"); 
		query.append("	,COP_NO" ).append("\n"); 
		query.append("	,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("	,COST_ACT_GRP_CD" ).append("\n"); 
		query.append("	,UPLN_SO_FLG" ).append("\n"); 
		query.append("	,RPLN_UMCH_FLG" ).append("\n"); 
		query.append("	,COP_SO_STS_CD" ).append("\n"); 
		query.append("	,COP_SO_ROUT_DESC" ).append("\n"); 
		query.append("	,ROUT_RPLN_FLG" ).append("\n"); 
		query.append("	,RQST_SRC_SYS_CD" ).append("\n"); 
		query.append("	,TRSP_SO_HIS_DESC" ).append("\n"); 
		query.append("	,BKG_NO" ).append("\n"); 
		query.append("	,EQ_TPSZ_CD" ).append("\n"); 
		query.append("    ,TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("	,TRSP_WO_SEQ " ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("    ,CRE_OFC_CD" ).append("\n"); 
		query.append("    ,LOCL_CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	 T.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	,T.TRSP_SO_SEQ" ).append("\n"); 
		query.append("	,TRS_TRSP_SO_HIS_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("	,@[trsp_so_evnt_cd] TRSP_SO_EVNT_CD-- 각 EVENT에서 넘겨준 값" ).append("\n"); 
		query.append("	,EQ_NO" ).append("\n"); 
		query.append("	,INV_NO" ).append("\n"); 
		query.append("	,INV_VNDR_SEQ" ).append("\n"); 
		query.append("	,TRSP_SO_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${rout_rpln_flg} == 'Y')" ).append("\n"); 
		query.append("--    ,(SELECT '('||T.TRSP_MOD_CD||') ' || T.FM_NOD_CD ||'-'|| T.TO_NOD_CD FROM SCE_PLN_SO_LIST WHERE COP_NO = B.COP_NO AND COST_ACT_GRP_SEQ = B.COST_ACT_GRP_SEQ)  || ' => ' || '('||T.TRSP_MOD_CD||') ' || T.FM_NOD_CD ||'-'|| T.TO_NOD_CD AS SO_ROUT_DESC" ).append("\n"); 
		query.append("	,@[cop_pln_rout_desc]  || ' => ' || '('||T.TRSP_MOD_CD||') ' || T.FM_NOD_CD ||'-'|| T.TO_NOD_CD AS SO_ROUT_DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    ,'('||T.TRSP_MOD_CD||') ' || T.FM_NOD_CD ||'-'|| T.TO_NOD_CD AS SO_ROUT_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,COP_NO" ).append("\n"); 
		query.append("	,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("	,COST_ACT_GRP_CD" ).append("\n"); 
		query.append("	,'' AS UPLN_SO_FLG" ).append("\n"); 
		query.append("	,'' AS RPLN_UMCH_FLG" ).append("\n"); 
		query.append("	,(SELECT TRSP_SO_STS_CD FROM SCE_PLN_SO_LIST S WHERE S.COP_NO = B.COP_NO AND S.COST_ACT_GRP_SEQ = B.COST_ACT_GRP_SEQ) COP_SO_STS_CD" ).append("\n"); 
		query.append("	,'' COP_PLN_ROUT_DESC -- UI에서 ROUTE 변경전 TRANS MODE와 ROUTE" ).append("\n"); 
		query.append("	,NVL(@[rout_rpln_flg],'') ROUT_RPLN_FLG -- Replan 여부" ).append("\n"); 
		query.append("	,'TRS' RQST_SRC_SYS_CD" ).append("\n"); 
		query.append("#if( ${trsp_so_evnt_cd} == 'SF' )" ).append("\n"); 
		query.append("	, 'Frustrate' TRSP_SO_HIS_DESC" ).append("\n"); 
		query.append("#elseif(  ${trsp_so_evnt_cd} == 'SD' )" ).append("\n"); 
		query.append("	, 'S/O Delete' TRSP_SO_HIS_DESC" ).append("\n"); 
		query.append("#elseif(  ${trsp_so_evnt_cd} == 'WC' )" ).append("\n"); 
		query.append("	CASE NVL(TRSP_RQST_BKG_FLG, 'N') WHEN 'Y' THEN 'RQST By BKG'" ).append("\n"); 
		query.append("							 WHEN 'O' THEN 'TRS Own Reason'" ).append("\n"); 
		query.append("							 ELSE ''" ).append("\n"); 
		query.append("		END AS TRSP_SO_HIS_DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	, '' TRSP_SO_HIS_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,B.BKG_NO" ).append("\n"); 
		query.append("	,B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("    ,'' AS TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("	,'' AS TRSP_WO_SEQ " ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, Sysdate" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, Sysdate" ).append("\n"); 
		query.append("    , @[cre_ofc_cd]" ).append("\n"); 
		query.append("    , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append("	  FROM TRS_TRSP_RAIL_BIL_VNDR_SET T, TRS_TRSP_RAIL_BIL_ORD B" ).append("\n"); 
		query.append("	 WHERE T.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	   AND T.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("	   AND T.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	   AND T.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 

	}
}