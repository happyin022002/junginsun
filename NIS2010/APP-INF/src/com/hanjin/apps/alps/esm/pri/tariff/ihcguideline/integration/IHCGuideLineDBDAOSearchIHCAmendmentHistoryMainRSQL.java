/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
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

public class IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve IHC Tariff No. Main
	  * 2013.04.26 [CHM-201324375] 전윤주 Amend Type code 추가
	  * </pre>
	  */
	public IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainRSQL").append("\n"); 
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
		query.append("SELECT MN.AMDT_SEQ" ).append("\n"); 
		query.append("     , MN.IHC_TRF_AMDT_TP_CD" ).append("\n"); 
		query.append("     , SUBSTR(MN.IHC_TRF_NO,1,3)|| '-' ||SUBSTR(MN.IHC_TRF_NO,4,1)|| '-' ||SUBSTR(MN.IHC_TRF_NO,5,2)|| '-' ||SUBSTR(MN.IHC_TRF_NO,7,4) IHC_TRF_NO_FORMAT" ).append("\n"); 
		query.append("     , MN.IHC_TRF_NO" ).append("\n"); 
		query.append("     , TO_CHAR(MN.EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , DECODE(TO_CHAR(MN.EXP_DT,'YYYYMMDD'),'99991231', NULL, TO_CHAR(MN.EXP_DT,'YYYYMMDD')) AS EXP_DT" ).append("\n"); 
		query.append("     , TO_CHAR(MN.CRE_DT, 'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append("     , (SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CRE_USR_ID) || ' / ' || MN.CRE_OFC_CD AS CRE_USR  " ).append("\n"); 
		query.append("     , TO_CHAR(MN.CFM_DT, 'YYYYMMDD') AS CFM_DT" ).append("\n"); 
		query.append("     , DECODE((SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CFM_USR_ID) || ' / ' || MN.CFM_OFC_CD,' / ', ''" ).append("\n"); 
		query.append("             ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CFM_USR_ID) || ' / ' || MN.CFM_OFC_CD ) AS CFM_USR" ).append("\n"); 
		query.append("     , TO_CHAR(MN.CFM_DT, 'YYYYMMDD') AS PUB_DT" ).append("\n"); 
		query.append("     , DECODE((SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CFM_USR_ID) || ' / ' || MN.CFM_OFC_CD,' / ', ''" ).append("\n"); 
		query.append("             ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.CFM_USR_ID) || ' / ' || MN.CFM_OFC_CD ) AS PUB_USR" ).append("\n"); 
		query.append("     , MN.SVC_SCP_CD" ).append("\n"); 
		query.append("     , MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , HDR.COST_CNT_CD" ).append("\n"); 
		query.append("     , HDR.RHQ_CD" ).append("\n"); 
		query.append("	 , MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , '' AS DETAIL_TP" ).append("\n"); 
		query.append("FROM PRI_TRF_IHC_MN MN" ).append("\n"); 
		query.append("   , PRI_TRF_IHC_HDR HDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND MN.SVC_SCP_CD = HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND MN.ORG_DEST_TP_CD = HDR.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("AND MN.IHC_TRF_NO = HDR.IHC_TRF_NO" ).append("\n"); 
		query.append("AND MN.SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND MN.FIC_PROP_STS_CD ='C'  " ).append("\n"); 
		query.append("AND HDR.COST_CNT_CD = @[cost_cnt_cd]" ).append("\n"); 
		query.append("AND HDR.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("#if(${detail_tp} != '1')  " ).append("\n"); 
		query.append("AND MN.AMDT_SEQ <> 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rhq_cd} == 'NYCRA')  " ).append("\n"); 
		query.append("AND MN.IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MN.IHC_TRF_NO DESC, MN.AMDT_SEQ DESC" ).append("\n"); 

	}
}