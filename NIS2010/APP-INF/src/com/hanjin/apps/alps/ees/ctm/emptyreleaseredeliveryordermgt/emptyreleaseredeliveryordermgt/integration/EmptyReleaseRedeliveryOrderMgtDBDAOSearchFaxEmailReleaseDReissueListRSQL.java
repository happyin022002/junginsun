/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseDReissueListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.12.02 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseDReissueListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseDReissueListRSQL(){
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
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseDReissueListRSQL").append("\n"); 
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
		query.append("/* Release - D - Reissued */" ).append("\n"); 
		query.append("SELECT ORD.TRSP_SO_OFC_CTY_CD AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("ORD.TRSP_SO_SEQ AS SO_SEQ," ).append("\n"); 
		query.append("ORD.EQ_NO," ).append("\n"); 
		query.append("@[bd] AS BD," ).append("\n"); 
		query.append("@[bkg_no] AS BKG_NO," ).append("\n"); 
		query.append("@[bl_no] AS BL_NO," ).append("\n"); 
		query.append("@[cntr_no] AS CNTR_NO," ).append("\n"); 
		query.append("@[email] AS EMAIL," ).append("\n"); 
		query.append("@[empty_cy] AS EMPTY_CY," ).append("\n"); 
		query.append("@[fax_no] AS FAX_NO," ).append("\n"); 
		query.append("@[issue_flag] AS ISSUE_FLAG," ).append("\n"); 
		query.append("@[issue_type] AS ISSUE_TYPE," ).append("\n"); 
		query.append("@[job_seq] AS JOB_SEQ," ).append("\n"); 
		query.append("@[mode_cd] AS MODE_CD," ).append("\n"); 
		query.append("@[pd_date] AS PD_DATE," ).append("\n"); 
		query.append("@[pod] AS POD," ).append("\n"); 
		query.append("@[pol] AS POL," ).append("\n"); 
		query.append("@[spcl_inst] AS SPCL_INST," ).append("\n"); 
		query.append("@[tp] AS TP," ).append("\n"); 
		query.append("@[type] AS TYPE," ).append("\n"); 
		query.append("@[type_cd] AS TYPE_CD," ).append("\n"); 
		query.append("@[user_id] AS USER_ID," ).append("\n"); 
		query.append("@[user_loc] AS USER_LOC," ).append("\n"); 
		query.append("@[user_ofc] AS USER_OFC," ).append("\n"); 
		query.append("@[vvd] AS VVD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("MDM_LOCATION ML," ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD ORD" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("/*********************************/" ).append("\n"); 
		query.append("AND ORD.TRSP_COST_DTL_MOD_CD = 'DR'    /** Carriou **/" ).append("\n"); 
		query.append("AND NVL (ORD.TRSP_SO_CMB_TP_CD, 'N') NOT IN ('FF', 'FM')" ).append("\n"); 
		query.append("AND ORD.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("AND ORD.CRE_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND ML.CONTI_CD = 'E'" ).append("\n"); 
		query.append("/*********************************/" ).append("\n"); 
		query.append("AND ORD.HJL_NO IS NOT NULL    /** Domestic 구분자 **/" ).append("\n"); 
		query.append("--AND ORD.HJL_OWN_BIZ_FLG = 'Y'    /** Domestic 구분자 **/" ).append("\n"); 
		query.append("AND ORD.TRSP_CRR_MOD_CD = @[mode_cd]" ).append("\n"); 
		query.append("AND ORD.EQ_TPSZ_CD = @[tp]" ).append("\n"); 
		query.append("AND ORD.FM_NOD_CD = @[empty_cy]" ).append("\n"); 
		query.append("AND ORD.TRSP_WO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("AND ORD.INV_NO IS NULL" ).append("\n"); 
		query.append("AND ROWNUM <= @[qty]" ).append("\n"); 
		query.append("AND NVL (ORD.EQ_NO, '1') = NVL (@[cntr_no], '1')" ).append("\n"); 
		query.append("AND ORD.TRSP_WO_OFC_CTY_CD = SUBSTR(@[wo_no], 1, 3)" ).append("\n"); 
		query.append("AND ORD.TRSP_WO_SEQ = SUBSTR(@[wo_no], 4)" ).append("\n"); 

	}
}