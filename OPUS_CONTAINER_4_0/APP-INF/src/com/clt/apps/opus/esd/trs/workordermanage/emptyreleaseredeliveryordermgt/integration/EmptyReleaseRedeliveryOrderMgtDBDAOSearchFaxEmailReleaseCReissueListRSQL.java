/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseCReissueListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.09
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.09 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseCReissueListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseCReissueListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_inst",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_p",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("email",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mode_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("job_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pd_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseCReissueListRSQL").append("\n"); 
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
		query.append("/* Release - C/H - Reissue */" ).append("\n"); 
		query.append("SELECT STK.SO_OFC_CTY_CD AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("       STK.SO_SEQ AS SO_SEQ," ).append("\n"); 
		query.append("       TRO.TRO_SEQ AS TRO_SEQ," ).append("\n"); 
		query.append("       ORD.EQ_NO AS EQ_NO," ).append("\n"); 
		query.append("       @[bd] AS BD," ).append("\n"); 
		query.append("       @[bkg_no] AS BKG_NO," ).append("\n"); 
		query.append("       @[bl_no] AS BL_NO," ).append("\n"); 
		query.append("       @[cntr_no] AS CNTR_NO," ).append("\n"); 
		query.append("       @[email] AS EMAIL," ).append("\n"); 
		query.append("       @[empty_cy] AS EMPTY_CY," ).append("\n"); 
		query.append("       @[fax_no] AS FAX_NO," ).append("\n"); 
		query.append("       @[issue_flag] AS ISSUE_FLAG," ).append("\n"); 
		query.append("       @[issue_type] AS ISSUE_TYPE," ).append("\n"); 
		query.append("       @[job_seq] AS JOB_SEQ," ).append("\n"); 
		query.append("       @[mode_cd] AS MODE_CD," ).append("\n"); 
		query.append("       @[pd_date] AS PD_DATE," ).append("\n"); 
		query.append("       @[pod] AS POD," ).append("\n"); 
		query.append("       @[pol] AS POL," ).append("\n"); 
		query.append("       @[spcl_inst] AS SPCL_INST," ).append("\n"); 
		query.append("       @[tp] AS TP," ).append("\n"); 
		query.append("       @[type] AS TYPE," ).append("\n"); 
		query.append("       @[type_cd] AS TYPE_CD," ).append("\n"); 
		query.append("       @[user_id] AS USER_ID," ).append("\n"); 
		query.append("       @[user_loc] AS USER_LOC," ).append("\n"); 
		query.append("       @[user_ofc] AS USER_OFC," ).append("\n"); 
		query.append("       @[vvd] AS VVD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("       MDM_LOCATION ML," ).append("\n"); 
		query.append("       TRS_TRSP_SVC_ORD ORD," ).append("\n"); 
		query.append("       CIM_CNTR_STK STK," ).append("\n"); 
		query.append("       MDM_VENDOR MV," ).append("\n"); 
		query.append("       BKG_EUR_TRO TRO" ).append("\n"); 
		query.append(" WHERE ORD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = TRO.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ORD.TRO_SEQ = TRO.TRO_SEQ(+)" ).append("\n"); 
		query.append("   AND ORD.TRSP_BND_CD = @[bd]" ).append("\n"); 
		query.append("   AND TRO.IO_BND_CD = @[bd]" ).append("\n"); 
		query.append("   AND TRO.TRO_PROC_CD = 'C'" ).append("\n"); 
		query.append("   AND TRO.HLG_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND TRO.CNTR_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("   AND TRO.CXL_FLG = 'N'" ).append("\n"); 
		query.append("   AND TRO.CNTR_TPSZ_CD = @[tp]" ).append("\n"); 
		query.append("   AND ORD.TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("   AND NVL (ORD.TRSP_SO_CMB_TP_CD, 'N') NOT IN ('FF', 'FM')" ).append("\n"); 
		query.append("   AND ORD.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("   AND ORD.CRE_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("   AND MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("   AND ML.CONTI_CD = 'E'" ).append("\n"); 
		query.append("   AND ORD.EQ_TPSZ_CD = @[tp]" ).append("\n"); 
		query.append("   AND FM_NOD_CD = @[empty_cy]" ).append("\n"); 
		query.append("   AND TO_CHAR (ORD.N1ST_NOD_PLN_DT, 'YYYY-MM-DD') = @[pd_date]" ).append("\n"); 
		query.append("   AND ORD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND (ORD.TRSP_WO_OFC_CTY_CD IS NOT NULL OR ORD.TRSP_WO_SEQ IS NOT NULL)" ).append("\n"); 
		query.append("   AND NVL2 (@[cntr_no], ORD.EQ_NO, '1') = NVL (@[cntr_no], '1')" ).append("\n"); 
		query.append("   AND MV.VNDR_SEQ = @[s_p]" ).append("\n"); 
		query.append("   AND ORD.VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("   AND ORD.TRSP_SO_OFC_CTY_CD = STK.SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND ORD.TRSP_SO_SEQ = STK.SO_SEQ" ).append("\n"); 
		query.append("   AND STK.STK_LOC_CD = SUBSTR (@[empty_cy], 1, 5)" ).append("\n"); 
		query.append("   AND STK.STK_YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("   AND STK.IO_BND_CD = @[bd]" ).append("\n"); 
		query.append("   AND STK.TRSP_SO_TP_CD = @[type_cd]" ).append("\n"); 
		query.append("   AND ROWNUM <= @[qty]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT STK.SO_OFC_CTY_CD AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("       STK.SO_SEQ AS SO_SEQ," ).append("\n"); 
		query.append("       TO_NUMBER('', '#') AS TRO_SEQ," ).append("\n"); 
		query.append("       ORD.EQ_NO AS EQ_NO," ).append("\n"); 
		query.append("       @[bd] AS BD," ).append("\n"); 
		query.append("       @[bkg_no] AS BKG_NO," ).append("\n"); 
		query.append("       @[bl_no] AS BL_NO," ).append("\n"); 
		query.append("       @[cntr_no] AS CNTR_NO," ).append("\n"); 
		query.append("       @[email] AS EMAIL," ).append("\n"); 
		query.append("       @[empty_cy] AS EMPTY_CY," ).append("\n"); 
		query.append("       @[fax_no] AS FAX_NO," ).append("\n"); 
		query.append("       @[issue_flag] AS ISSUE_FLAG," ).append("\n"); 
		query.append("       @[issue_type] AS ISSUE_TYPE," ).append("\n"); 
		query.append("       @[job_seq] AS JOB_SEQ," ).append("\n"); 
		query.append("       @[mode_cd] AS MODE_CD," ).append("\n"); 
		query.append("       @[pd_date] AS PD_DATE," ).append("\n"); 
		query.append("       @[pod] AS POD," ).append("\n"); 
		query.append("       @[pol] AS POL," ).append("\n"); 
		query.append("       @[spcl_inst] AS SPCL_INST," ).append("\n"); 
		query.append("       @[tp] AS TP," ).append("\n"); 
		query.append("       @[type] AS TYPE," ).append("\n"); 
		query.append("       @[type_cd] AS TYPE_CD," ).append("\n"); 
		query.append("       @[user_id] AS USER_ID," ).append("\n"); 
		query.append("       @[user_loc] AS USER_LOC," ).append("\n"); 
		query.append("       @[user_ofc] AS USER_OFC," ).append("\n"); 
		query.append("       @[vvd] AS VVD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("       MDM_LOCATION ML," ).append("\n"); 
		query.append("       TRS_TRSP_SVC_ORD ORD," ).append("\n"); 
		query.append("       CIM_CNTR_STK STK," ).append("\n"); 
		query.append("       MDM_VENDOR MV" ).append("\n"); 
		query.append(" WHERE ORD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND NVL (ORD.TRSP_SO_CMB_TP_CD, 'N') NOT IN ('FF', 'FM')" ).append("\n"); 
		query.append("   AND ORD.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("   AND ORD.CRE_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("   AND MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("   AND ML.CONTI_CD = 'E'" ).append("\n"); 
		query.append("   AND ORD.EQ_TPSZ_CD = @[tp]" ).append("\n"); 
		query.append("   AND FM_NOD_CD = @[empty_cy]" ).append("\n"); 
		query.append("   AND TO_CHAR (ORD.N1ST_NOD_PLN_DT, 'YYYY-MM-DD') = @[pd_date]" ).append("\n"); 
		query.append("   AND ORD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND ORD.TRSP_WO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND NVL2 (@[cntr_no], ORD.EQ_NO, '1') = NVL (@[cntr_no], '1')" ).append("\n"); 
		query.append("   AND MV.VNDR_SEQ = @[s_p]" ).append("\n"); 
		query.append("   AND ORD.VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("   AND ORD.TRSP_SO_OFC_CTY_CD = STK.SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND ORD.TRSP_SO_SEQ = STK.SO_SEQ" ).append("\n"); 
		query.append("   AND STK.STK_LOC_CD = SUBSTR (@[empty_cy], 1, 5)" ).append("\n"); 
		query.append("   AND STK.STK_YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("   AND STK.TRSP_SO_TP_CD = @[type_cd]" ).append("\n"); 
		query.append("   AND ROWNUM <= @[qty]" ).append("\n"); 

	}
}