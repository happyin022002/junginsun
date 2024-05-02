/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsCommonDBDAOMultiSOHistory2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.27 
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

public class TrsCommonDBDAOMultiSOHistory2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS CY/Door S/O와 관련된 각 이벤트 별로 S/O History를 입력 ( W/O Issue, W/O cancel)
	  * </pre>
	  */
	public TrsCommonDBDAOMultiSOHistory2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_his_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_src_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOMultiSOHistory2CSQL").append("\n"); 
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
		query.append("    ,WO_ISS_KNT" ).append("\n"); 
		query.append("    ,TRSP_RJCT_RSN_CD" ).append("\n"); 
		query.append("    ,AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("    ,NEGO_AMT" ).append("\n"); 
		query.append("    ,NEGO_RMK" ).append("\n"); 
		query.append("	,CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("	,TRSP_SP_CNG_RSN_CD" ).append("\n"); 
		query.append("	,TRSP_SP_CNG_RSN_RMK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	 T.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	,T.TRSP_SO_SEQ" ).append("\n"); 
		query.append("	,TRS_TRSP_SO_HIS_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("	,@[trsp_so_evnt_cd] TRSP_SO_EVNT_CD-- 각 EVENT에서 넘겨준 값" ).append("\n"); 
		query.append("	,T.EQ_NO" ).append("\n"); 
		query.append("	,T.INV_NO" ).append("\n"); 
		query.append("	,T.INV_VNDR_SEQ" ).append("\n"); 
		query.append("	,T.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("	,'('||T.TRSP_CRR_MOD_CD||') ' || T.FM_NOD_CD ||'-'|| T.VIA_NOD_CD ||'-'|| T.DOR_NOD_CD ||'-'|| T.TO_NOD_CD AS SO_ROUT_DESC" ).append("\n"); 
		query.append("	,T.COP_NO" ).append("\n"); 
		query.append("	,T.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("	,T.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("	,T.UPLN_SO_FLG" ).append("\n"); 
		query.append("	,T.RPLN_UMCH_FLG" ).append("\n"); 
		query.append("	,(SELECT TRSP_SO_STS_CD FROM SCE_PLN_SO_LIST S WHERE S.COP_NO = T.COP_NO AND S.COST_ACT_GRP_SEQ = T.COST_ACT_GRP_SEQ) COP_SO_STS_CD" ).append("\n"); 
		query.append("	,NVL(@[cop_pln_rout_desc],'---') COP_PLN_ROUT_DESC -- UI에서 ROUTE 변경전 TRANS MODE와 ROUTE" ).append("\n"); 
		query.append("	,NVL(@[rout_rpln_flg],'') ROUT_RPLN_FLG -- Replan 여부" ).append("\n"); 
		query.append("	,DECODE(@[rqst_src_sys_cd], 'SPP', 'SPP', 'TRS') RQST_SRC_SYS_CD" ).append("\n"); 
		query.append("--	,'TRS' RQST_SRC_SYS_CD" ).append("\n"); 
		query.append("#if(  ${trsp_so_evnt_cd} == 'WC' )" ).append("\n"); 
		query.append("	, COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00957',W.TRSP_RJCT_RSN_CD) TRSP_SO_HIS_DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	, decode(@[trsp_so_his_desc],null,'',@[trsp_so_his_desc]||', ')|| 'Vendor : '||T.VNDR_SEQ ||'/'||(select VNDR_ABBR_NM from MDM_VENDOR MV where MV.VNDR_SEQ = W.VNDR_SEQ) ||', Nominated Trucker:'||T.CUST_NOMI_TRKR_FLG||', Currency :'||T.CURR_CD ||', Basic:'||T.BZC_AMT ||', ETC Surcharge:'||T.ETC_ADD_AMT|| ', FUEL Surcharge:'||T.FUEL_SCG_AMT||', Nego:'||" ).append("\n"); 
		query.append("T.NEGO_AMT||', AGMT NO:'||T.TRSP_AGMT_OFC_CTY_CD|| T.TRSP_AGMT_SEQ || ', VGM FLG : ' || " ).append("\n"); 
		query.append("	   (CASE" ).append("\n"); 
		query.append("         WHEN( (SELECT VGM_WGT" ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER BKCN," ).append("\n"); 
		query.append("                       TRS_TRSP_SVC_ORD TRSO" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND BKCN.BKG_NO = TRSO.BKG_NO" ).append("\n"); 
		query.append("                   AND BKCN.CNTR_NO = TRSO.EQ_NO" ).append("\n"); 
		query.append("                   AND TRSO.TRSP_SO_OFC_CTY_CD = T.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND TRSO.TRSP_SO_SEQ = T.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                   AND BKCN.CNTR_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND TRSO.DELT_FLG = 'N') > 0) THEN 'Y'" ).append("\n"); 
		query.append("         ELSE 'N'" ).append("\n"); 
		query.append("       END)  TRSP_SO_HIS_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,T.BKG_NO" ).append("\n"); 
		query.append("	,T.EQ_TPSZ_CD" ).append("\n"); 
		query.append("#if(  ${trsp_so_evnt_cd} == 'WC' )" ).append("\n"); 
		query.append("    ,W.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("	,W.TRSP_WO_SEQ " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    ,NVL(T.TRSP_WO_OFC_CTY_CD, W.TRSP_WO_OFC_CTY_CD) TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("	,NVL(T.TRSP_WO_SEQ , W.TRSP_WO_SEQ) TRSP_WO_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, Sysdate" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, Sysdate" ).append("\n"); 
		query.append("    , @[cre_ofc_cd]" ).append("\n"); 
		query.append("    , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append("#if(  ${trsp_so_evnt_cd} == 'WC' )" ).append("\n"); 
		query.append("    , (SELECT MAX(WO_ISS_KNT) FROM TRS_TRSP_WRK_ORD_HIS WHERE 1=1 AND TRSP_WO_OFC_CTY_CD = W.TRSP_WO_OFC_CTY_CD AND TRSP_WO_SEQ = W.TRSP_WO_SEQ) WO_ISS_KNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    , (SELECT MAX(WO_ISS_KNT) FROM TRS_TRSP_WRK_ORD_HIS WHERE 1=1 AND TRSP_WO_OFC_CTY_CD = NVL(T.TRSP_WO_OFC_CTY_CD, W.TRSP_WO_OFC_CTY_CD) AND TRSP_WO_SEQ = NVL(T.TRSP_WO_SEQ , W.TRSP_WO_SEQ)) WO_ISS_KNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , W.TRSP_RJCT_RSN_CD" ).append("\n"); 
		query.append("    , W.AUTH_APRO_RQST_NO" ).append("\n"); 
		query.append("    , W.NEGO_AMT" ).append("\n"); 
		query.append("    , W.NEGO_RMK" ).append("\n"); 
		query.append("	, W.CUST_NOMI_TRKR_IND_CD" ).append("\n"); 
		query.append("	, W.TRSP_SP_CNG_RSN_CD" ).append("\n"); 
		query.append("    , W.TRSP_SP_CNG_RSN_RMK" ).append("\n"); 
		query.append("	  FROM TRS_TRSP_WRK_ORD_PRV_TMP W, TRS_TRSP_SVC_ORD T" ).append("\n"); 
		query.append("	 WHERE W.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("	   AND W.WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("	   AND W.TRSP_SO_OFC_CTY_CD = T.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	   and W.TRSP_SO_SEQ = T.TRSP_SO_SEQ" ).append("\n"); 
		query.append("       --AND T.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 

	}
}