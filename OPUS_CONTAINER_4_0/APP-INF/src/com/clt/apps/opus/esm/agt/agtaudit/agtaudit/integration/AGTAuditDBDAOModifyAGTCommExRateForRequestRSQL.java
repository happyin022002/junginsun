/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOModifyAGTCommExRateForRequestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.04.22 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOModifyAGTCommExRateForRequestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAGTCommExRateForRequest
	  * </pre>
	  */
	public AGTAuditDBDAOModifyAGTCommExRateForRequestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOModifyAGTCommExRateForRequestRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT A.BKG_NO            AS BKG_NO," ).append("\n"); 
		query.append("A.IO_BND_CD         AS IO_BND_CD," ).append("\n"); 
		query.append("A.AGN_CD            AS AGN_CD," ).append("\n"); 
		query.append("A.AC_SEQ            AS AC_SEQ," ).append("\n"); 
		query.append("A.COMM_VSL_CD       AS COMM_VSL_CD," ).append("\n"); 
		query.append("A.COMM_SKD_VOY_NO   AS COMM_SKD_VOY_NO," ).append("\n"); 
		query.append("A.COMM_SKD_DIR_CD   AS COMM_SKD_DIR_CD," ).append("\n"); 
		query.append("B.SVC_SCP_CD        AS SVC_SCP_CD," ).append("\n"); 
		query.append("A.COMM_OCCR_INFO_CD AS COMM_OCCR_INFO_CD," ).append("\n"); 
		query.append("A.CURR_CD           AS CURR_CD," ).append("\n"); 
		query.append("A.XCH_RT_APLY_LVL   AS XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("A.SAIL_ARR_DT       AS SAIL_ARR_DT," ).append("\n"); 
		query.append("A.COMM_PROC_STS_CD," ).append("\n"); 
		query.append("@[upd_usr_id]       AS UPD_USR_ID," ).append("\n"); 
		query.append("NVL((SELECT" ).append("\n"); 
		query.append("X.INV_XCH_RT" ).append("\n"); 
		query.append("FROM INV_VVD_XCH_RT X" ).append("\n"); 
		query.append("WHERE X.VSL_CD         = A.COMM_VSL_CD" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO     = A.COMM_SKD_VOY_NO" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD     = A.COMM_SKD_DIR_CD" ).append("\n"); 
		query.append("AND X.SVC_SCP_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( NVL(B.SVC_SCP_CD, 'OTH')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND X.IO_BND_CD      = A.IO_BND_CD" ).append("\n"); 
		query.append("AND X.PORT_CD        = A.COMM_OCCR_INFO_CD" ).append("\n"); 
		query.append("AND X.LOCL_CURR_CD     = A.CURR_CD" ).append("\n"); 
		query.append("AND X.CHG_CURR_CD        = 'USD'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("X.INV_XCH_RT" ).append("\n"); 
		query.append("FROM INV_VVD_XCH_RT X" ).append("\n"); 
		query.append("WHERE X.VSL_CD         = A.COMM_VSL_CD" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO     = A.COMM_SKD_VOY_NO" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD     = A.COMM_SKD_DIR_CD" ).append("\n"); 
		query.append("AND X.SVC_SCP_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("('OTH')" ).append("\n"); 
		query.append("AND X.IO_BND_CD      = A.IO_BND_CD" ).append("\n"); 
		query.append("AND X.PORT_CD        = A.COMM_OCCR_INFO_CD" ).append("\n"); 
		query.append("AND X.LOCL_CURR_CD     = A.CURR_CD" ).append("\n"); 
		query.append("AND X.CHG_CURR_CD        = 'USD'" ).append("\n"); 
		query.append(")) AS VVD_XCH_RT," ).append("\n"); 
		query.append("(     SELECT INV_XCH_RT" ).append("\n"); 
		query.append("FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD   = 'XX'" ).append("\n"); 
		query.append("AND CUST_SEQ      = 0" ).append("\n"); 
		query.append("AND IO_BND_CD     = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND FM_DT    >= SUBSTR (A.SAIL_ARR_DT, 0, 8)" ).append("\n"); 
		query.append("AND TO_DT    <= SUBSTR (A.SAIL_ARR_DT, 0, 8)" ).append("\n"); 
		query.append("AND CHG_CURR_CD       = 'USD'" ).append("\n"); 
		query.append("AND LOCL_CURR_CD  = A.CURR_CD" ).append("\n"); 
		query.append(")                                                         AS DLY_XCH_RT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM      A," ).append("\n"); 
		query.append("AGT_COMM_BKG_INFO B" ).append("\n"); 
		query.append("WHERE A.BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("AND A.AGN_CD             = @[agn_cd]" ).append("\n"); 
		query.append("AND A.IO_BND_CD          = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND A.AC_TP_CD          <> 'T'" ).append("\n"); 
		query.append("AND A.AC_SEQ             = @[ac_seq]" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD   = 'CS'" ).append("\n"); 
		query.append("AND A.CRE_USR_ID        != 'COST'" ).append("\n"); 
		query.append("AND A.BKG_NO             = B.BKG_NO" ).append("\n"); 

	}
}