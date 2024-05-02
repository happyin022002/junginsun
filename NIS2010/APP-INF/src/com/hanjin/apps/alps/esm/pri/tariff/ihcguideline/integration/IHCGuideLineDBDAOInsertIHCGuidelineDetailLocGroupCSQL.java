/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IHCGuideLineDBDAOInsertIHCGuidelineDetailLocGroupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOInsertIHCGuidelineDetailLocGroupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.07.23 전윤주 [CHM-201325898] 화면(ESM_PRI_7001) 화면을 통한 PRI_TRF_IHC_RT 입력 후 
	  *                                                      입력한 Cost의 범위에 따라 비어있는 Location Group No를 할당해준다.
	  * 2013.09.23 전윤주 [CHM-201326761] local curr. 기준으로 하는 scope에 EAN, EAS 추가
	  * </pre>
	  */
	public IHCGuideLineDBDAOInsertIHCGuidelineDetailLocGroupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOInsertIHCGuidelineDetailLocGroupCSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_TRF_IHC_RT A1" ).append("\n"); 
		query.append("      USING (" ).append("\n"); 
		query.append("              SELECT SVC_SCP_CD " ).append("\n"); 
		query.append("                    ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                    ,IHC_TRF_NO  " ).append("\n"); 
		query.append("                    ,AMDT_SEQ  " ).append("\n"); 
		query.append("                    ,IHC_CGO_TP_CD" ).append("\n"); 
		query.append("                    ,RT_SEQ" ).append("\n"); 
		query.append("                    ,PNT_LOC_CD" ).append("\n"); 
		query.append("                    ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                    ,HUB_LOC_CD" ).append("\n"); 
		query.append("                    ,IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("                    ,GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                    ,SEL_LOC_GROUP" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                        SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                              ,IHC_TRF_NO" ).append("\n"); 
		query.append("                              ,AMDT_SEQ" ).append("\n"); 
		query.append("                              ,IHC_CGO_TP_CD" ).append("\n"); 
		query.append("                              ,RT_SEQ" ).append("\n"); 
		query.append("                              ,PNT_LOC_CD" ).append("\n"); 
		query.append("                              ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                              ,HUB_LOC_CD" ).append("\n"); 
		query.append("                              ,IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("                              ,GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                              ,CASE" ).append("\n"); 
		query.append("                            	 WHEN HIGH_DIFF< LOW_DIFF THEN COALESCE(HIGH_LOC_GROUP, LOW_LOC_GROUP) --입력받은 AMT가 큰 값과 가까운 값이면 그 AMT의 Loc.Group 할당" ).append("\n"); 
		query.append("                                 WHEN HIGH_DIFF > LOW_DIFF THEN COALESCE(LOW_LOC_GROUP, HIGH_LOC_GROUP) --입력받은 AMT가 작은 값과 가까운 값이면 그 AMT의 Loc.Group 할당" ).append("\n"); 
		query.append("                                 ELSE COALESCE(LOW_LOC_GROUP, HIGH_LOC_GROUP) -- 같으면 작은 쪽의 Loc.Group 할당" ).append("\n"); 
		query.append("                               END SEL_LOC_GROUP" ).append("\n"); 
		query.append("                         FROM (" ).append("\n"); 
		query.append("                               SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                                     ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                     ,IHC_TRF_NO" ).append("\n"); 
		query.append("                                     ,AMDT_SEQ" ).append("\n"); 
		query.append("                                     ,IHC_CGO_TP_CD" ).append("\n"); 
		query.append("                                     ,RT_SEQ" ).append("\n"); 
		query.append("                                     ,PNT_LOC_CD" ).append("\n"); 
		query.append("                                     ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                                     ,HUB_LOC_CD" ).append("\n"); 
		query.append("                                     ,IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("#if(${svc_scp_cd} == 'TAE' || ${svc_scp_cd} == 'TAW' || ${svc_scp_cd} == 'ASE' || ${svc_scp_cd} == 'ASW' || ${svc_scp_cd} == 'EAS' || ${svc_scp_cd} == 'EAN')" ).append("\n"); 
		query.append("                                     --특정 6개 scope의 경우에는 local Curr를 기준으로 계산함" ).append("\n"); 
		query.append("                                    ,GLINE_LOCL_CURR_40FT_AMT AS GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                                    ,NVL(LEAD(GLINE_LOCL_CURR_40FT_AMT) OVER(ORDER BY GLINE_LOCL_CURR_40FT_AMT), 99999999) AS HIGH_GLINE_40FT_FRT_RT_AMT -- 입력받은 AMT 다음으로 큰 금액" ).append("\n"); 
		query.append("                                    ,NVL(LAG(GLINE_LOCL_CURR_40FT_AMT)  OVER(ORDER BY GLINE_LOCL_CURR_40FT_AMT), 0) AS LOW_GLINE_40FT_FRT_RT_AMT -- 입력받은 AMT 바로 이전 작은 금액" ).append("\n"); 
		query.append("                                    ,NVL(LEAD(GLINE_LOCL_CURR_40FT_AMT) OVER(ORDER BY GLINE_LOCL_CURR_40FT_AMT), 99999999) - GLINE_LOCL_CURR_40FT_AMT AS HIGH_DIFF -- 큰 금액과의 차이" ).append("\n"); 
		query.append("                                    ,GLINE_LOCL_CURR_40FT_AMT - NVL(LAG(GLINE_LOCL_CURR_40FT_AMT) OVER(ORDER BY GLINE_LOCL_CURR_40FT_AMT), 0) AS LOW_DIFF -- 작은 금액과의 차이" ).append("\n"); 
		query.append("                                    ,LEAD(IHC_COST_LOC_GRP_NO) OVER(ORDER BY GLINE_LOCL_CURR_40FT_AMT) AS HIGH_LOC_GROUP --큰 쪽의 Loc.group" ).append("\n"); 
		query.append("                                    ,LAG(IHC_COST_LOC_GRP_NO) OVER(ORDER BY GLINE_LOCL_CURR_40FT_AMT) AS LOW_LOC_GROUP --작은 쪽의 Loc.group" ).append("\n"); 
		query.append("#else                " ).append("\n"); 
		query.append("                                    ,GLINE_40FT_FRT_RT_AMT   " ).append("\n"); 
		query.append("                                    ,NVL(LEAD(GLINE_40FT_FRT_RT_AMT) OVER(ORDER BY GLINE_40FT_FRT_RT_AMT), 99999999) AS HIGH_GLINE_40FT_FRT_RT_AMT -- 입력받은 AMT 다음으로 큰 금액" ).append("\n"); 
		query.append("                                    ,NVL(LAG(GLINE_40FT_FRT_RT_AMT)  OVER(ORDER BY GLINE_40FT_FRT_RT_AMT), 0) AS LOW_GLINE_40FT_FRT_RT_AMT -- 입력받은 AMT 바로 이전 작은 금액" ).append("\n"); 
		query.append("                                    ,NVL(LEAD(GLINE_40FT_FRT_RT_AMT) OVER(ORDER BY GLINE_40FT_FRT_RT_AMT), 99999999) - GLINE_40FT_FRT_RT_AMT AS HIGH_DIFF -- 큰 금액과의 차이" ).append("\n"); 
		query.append("                                    ,GLINE_40FT_FRT_RT_AMT - NVL(LAG(GLINE_40FT_FRT_RT_AMT) OVER(ORDER BY GLINE_40FT_FRT_RT_AMT), 0) AS LOW_DIFF -- 작은 금액과의 차이" ).append("\n"); 
		query.append("                                    ,LEAD(IHC_COST_LOC_GRP_NO) OVER(ORDER BY GLINE_40FT_FRT_RT_AMT) AS HIGH_LOC_GROUP --큰 쪽의 Loc.group" ).append("\n"); 
		query.append("                                    ,LAG(IHC_COST_LOC_GRP_NO) OVER(ORDER BY GLINE_40FT_FRT_RT_AMT) AS LOW_LOC_GROUP --작은 쪽의 Loc.group" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                               FROM PRI_TRF_IHC_RT" ).append("\n"); 
		query.append("                               WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                                 AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("                                 AND IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("                                 AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                                 AND IHC_CGO_TP_CD = @[ihc_cgo_tp_cd]" ).append("\n"); 
		query.append("                                 AND OPTM_TRSP_MOD_FLG = 'Y' -- Optimum인 Route만 Loc.group 들어가 있음" ).append("\n"); 
		query.append("#if(${svc_scp_cd} == 'TAE' || ${svc_scp_cd} == 'TAW' || ${svc_scp_cd} == 'ASE' || ${svc_scp_cd} == 'ASW' || ${svc_scp_cd} == 'EAN' || ${svc_scp_cd} == 'EAS')" ).append("\n"); 
		query.append("                               ORDER BY GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                               ORDER BY GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                         WHERE IHC_COST_LOC_GRP_NO IS NULL --insert 할 때 loc.group 할당 " ).append("\n"); 
		query.append("                         ORDER BY CASE" ).append("\n"); 
		query.append("                            	      WHEN HIGH_DIFF< LOW_DIFF THEN COALESCE(HIGH_LOC_GROUP, LOW_LOC_GROUP) --입력받은 AMT가 큰 값과 가까운 값이면 그 AMT의 Loc.Group 할당" ).append("\n"); 
		query.append("                                      WHEN HIGH_DIFF > LOW_DIFF THEN COALESCE(LOW_LOC_GROUP, HIGH_LOC_GROUP) --입력받은 AMT가 작은 값과 가까운 값이면 그 AMT의 Loc.Group 할당" ).append("\n"); 
		query.append("                                      ELSE COALESCE(LOW_LOC_GROUP, HIGH_LOC_GROUP) -- 같으면 작은 쪽의 Loc.Group 할당" ).append("\n"); 
		query.append("                                  END" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("              WHERE ROWNUM = 1 --먼저 입력된 것부터 순차적으로 넣는다." ).append("\n"); 
		query.append("            ) A2" ).append("\n"); 
		query.append("      ON (    A1.SVC_SCP_CD     = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("          AND A1.ORG_DEST_TP_CD = A2.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("          AND A1.IHC_TRF_NO     = A2.IHC_TRF_NO" ).append("\n"); 
		query.append("          AND A1.AMDT_SEQ       = A2.AMDT_SEQ" ).append("\n"); 
		query.append("          AND A1.IHC_CGO_TP_CD  = A2.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("          AND A1.RT_SEQ         = A2.RT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("      WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("            SET A1.IHC_COST_LOC_GRP_NO = A2.SEL_LOC_GROUP              " ).append("\n"); 
		query.append("               ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("               ,UPD_DT = SYSDATE" ).append("\n"); 

	}
}