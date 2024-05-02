/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RestuffingContainerRegistrationDBDAOInsertCtmMvmtXchCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.30 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RestuffingContainerRegistrationDBDAOInsertCtmMvmtXchCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public RestuffingContainerRegistrationDBDAOInsertCtmMvmtXchCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_xch_ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_cntr_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_xch_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration").append("\n"); 
		query.append("FileName : RestuffingContainerRegistrationDBDAOInsertCtmMvmtXchCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_MVMT_XCH" ).append("\n"); 
		query.append("            (CNTR_NO," ).append("\n"); 
		query.append("             CNMV_YR," ).append("\n"); 
		query.append("             CNMV_ID_NO," ).append("\n"); 
		query.append("             CNTR_XCH_REF_SEQ," ).append("\n"); 
		query.append("             CNTR_XCH_SEQ," ).append("\n"); 
		query.append("             CNTR_TPSZ_CD," ).append("\n"); 
		query.append("             CNMV_CYC_NO," ).append("\n"); 
		query.append("             CNMV_STS_CD," ).append("\n"); 
		query.append("             XCH_CNTR_NO," ).append("\n"); 
		query.append("             XCH_CNTR_YR," ).append("\n"); 
		query.append("             XCH_CNMV_ID_NO," ).append("\n"); 
		query.append("             XCH_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("             XCH_CNTR_CYC_NO," ).append("\n"); 
		query.append("             PRE_CNMV_STS_CD," ).append("\n"); 
		query.append("             XCH_RMK," ).append("\n"); 
		query.append("             XCH_OFC_CD," ).append("\n"); 
		query.append("             CNTR_XCH_REF_YR," ).append("\n"); 
		query.append("             CNTR_XCH_REF_MON," ).append("\n"); 
		query.append("             ORG_YD_CD," ).append("\n"); 
		query.append("             CRE_LOCL_DT," ).append("\n"); 
		query.append("             CRE_DT," ).append("\n"); 
		query.append("             UPD_USR_ID," ).append("\n"); 
		query.append("             CRE_USR_ID," ).append("\n"); 
		query.append("             UPD_LOCL_DT," ).append("\n"); 
		query.append("             UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     VALUES (@[cntr_no]," ).append("\n"); 
		query.append("             @[cnmv_yr]," ).append("\n"); 
		query.append("             @[cnmv_id_no]," ).append("\n"); 
		query.append("             @[cntr_xch_ref_seq]," ).append("\n"); 
		query.append("             @[cntr_xch_seq]," ).append("\n"); 
		query.append("             @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("             @[cnmv_cyc_no]," ).append("\n"); 
		query.append("             @[cnmv_sts_cd]," ).append("\n"); 
		query.append("             @[xch_cntr_no]," ).append("\n"); 
		query.append("             @[xch_cntr_yr]," ).append("\n"); 
		query.append("             (SELECT NVL (MAX (CNMV_ID_NO), 0) + 1" ).append("\n"); 
		query.append("                FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("               WHERE CNTR_NO = @[xch_cntr_no]" ).append("\n"); 
		query.append("                 AND CNMV_YR = @[xch_cntr_yr])," ).append("\n"); 
		query.append("             @[xch_cntr_tpsz_cd]," ).append("\n"); 
		query.append("             DECODE (@[cntr_no], @[xch_cntr_no], @[cnmv_cyc_no], (SELECT NVL (MAX (CNMV_CYC_NO), 0) + 1 FROM CTM_MOVEMENT WHERE CNTR_NO = @[xch_cntr_no]))," ).append("\n"); 
		query.append("             @[pre_cnmv_sts_cd]," ).append("\n"); 
		query.append("             @[xch_rmk]," ).append("\n"); 
		query.append("             @[xch_ofc_cd]," ).append("\n"); 
		query.append("             TO_CHAR (SYSDATE, 'YYYY')," ).append("\n"); 
		query.append("             TO_CHAR (SYSDATE, 'MM')," ).append("\n"); 
		query.append("             @[org_yd_cd]," ).append("\n"); 
		query.append("             GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[org_yd_cd], 0, 5 ))," ).append("\n"); 
		query.append("             SYSDATE," ).append("\n"); 
		query.append("             @[upd_usr_id]," ).append("\n"); 
		query.append("             @[cre_usr_id]," ).append("\n"); 
		query.append("             GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[org_yd_cd], 0, 5 ))," ).append("\n"); 
		query.append("             SYSDATE" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}