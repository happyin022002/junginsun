/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseMIssuedListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.04.11 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseMIssuedListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseMIssuedListRSQL(){
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
		params.put("org_empty_cy",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseMIssuedListRSQL").append("\n"); 
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
		query.append("/* Release - M/H - Issued */" ).append("\n"); 
		query.append("SELECT SUBSTR (@[user_ofc], 1, 3) AS SO_OFC_CTY_CD," ).append("\n"); 
		query.append("BKG_EUR_SO_SEQ.NEXTVAL AS SO_SEQ," ).append("\n"); 
		query.append("TRO_SEQ AS TRO_SEQ," ).append("\n"); 
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
		query.append("FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[bd]" ).append("\n"); 
		query.append("AND TRO_PROC_CD = 'C'" ).append("\n"); 
		query.append("AND HLG_TP_CD = 'M'" ).append("\n"); 
		query.append("AND CNTR_CFM_FLG = 'N'" ).append("\n"); 
		query.append("AND CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[tp]" ).append("\n"); 
		query.append("AND CNTR_PKUP_YD_CD = @[org_empty_cy]" ).append("\n"); 
		query.append("AND TO_CHAR (CNTR_PKUP_DT, 'YYYY-MM-DD') = @[pd_date]" ).append("\n"); 
		query.append("AND NVL (CNTR_NO, 1) = NVL (@[cntr_no], 1)" ).append("\n"); 
		query.append("AND ROWNUM <= @[qty]" ).append("\n"); 

	}
}