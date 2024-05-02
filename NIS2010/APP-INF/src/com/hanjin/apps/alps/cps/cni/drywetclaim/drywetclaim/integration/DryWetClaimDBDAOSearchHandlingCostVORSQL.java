/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchHandlingCostVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.03.12 양정란
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yang jung ran
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchHandlingCostVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Case 관련 발생된 제 처리비용을 조회한다
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchHandlingCostVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchHandlingCostVORSQL").append("\n"); 
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
		query.append("	 DW_CLM_NO" ).append("\n"); 
		query.append("    , (SELECT CLM_MISC_NM FROM CNI_MISC_CD WHERE CLSS_CLM_MISC_CD = '18' AND CLM_MISC_CD = A.DW_CLM_TP_CD) DW_CLM_TP_NM" ).append("\n"); 
		query.append("    , (SELECT CLM_MISC_NM FROM CNI_MISC_CD WHERE CLSS_CLM_MISC_CD = '24' AND CLM_MISC_CD = A.DW_CO_CD) DW_CO_NM" ).append("\n"); 
		query.append("	,VSL_ENG_NM" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(INCI_OCCR_DT, 'YYYYMMDD'),'YYYY-MM-DD') INCI_OCCR_DT" ).append("\n"); 
		query.append("    ,CRE_OFC_CD" ).append("\n"); 
		query.append("    , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID) R_HANDLER" ).append("\n"); 
		query.append("    , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.HDLR_USR_ID) HDLR_USR_NM" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(TM_BAR_DT, 'YYYYMMDD'),'YYYY-MM-DD') TM_BAR_DT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(CS_CLZ_DT, 'YYYYMMDD'),'YYYY-MM-DD') CS_CLZ_DT" ).append("\n"); 
		query.append("    , (SELECT CLM_MISC_NM FROM CNI_MISC_CD WHERE CLSS_CLM_MISC_CD = '17' AND CLM_MISC_CD = A.DW_CLM_STS_CD) DW_CLM_STS_NM" ).append("\n"); 
		query.append("	,TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("    , (SELECT CLM_MISC_NM FROM CNI_MISC_CD WHERE CLSS_CLM_MISC_CD = '19' AND CLM_MISC_CD = A.DW_CLM_ATT_DEF_TP_CD) DW_CLM_ATT_DEF_TP_NM" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(LABL_PTY_TM_BAR_DT, 'YYYYMMDD'),'YYYY-MM-DD') LABL_PTY_TM_BAR_DT" ).append("\n"); 
		query.append("    ,HDLR_USR_ID" ).append("\n"); 
		query.append("FROM    CNI_DW_CLM A" ).append("\n"); 
		query.append("WHERE	DW_CLM_NO = @[dw_clm_no]" ).append("\n"); 

	}
}