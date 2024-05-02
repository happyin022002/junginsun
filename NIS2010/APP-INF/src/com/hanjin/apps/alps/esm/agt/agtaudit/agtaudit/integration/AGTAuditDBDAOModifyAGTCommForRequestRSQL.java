/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOModifyAGTCommForRequestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.04.08 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOModifyAGTCommForRequestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAGTCommForRequestSelect
	  * </pre>
	  */
	public AGTAuditDBDAOModifyAGTCommForRequestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_rqst_usr_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOModifyAGTCommForRequestRSQL").append("\n"); 
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
		query.append("@[bkg_no]               AS BKG_NO," ).append("\n"); 
		query.append("@[ar_ofc_cd]            AS AR_OFC_CD," ).append("\n"); 
		query.append("@[agn_cd]               AS AGN_CD," ).append("\n"); 
		query.append("@[ac_seq]               AS AC_SEQ," ).append("\n"); 
		query.append("@[upd_usr_id]           AS UPD_USR_ID," ).append("\n"); 
		query.append("@[ac_rqst_usr_id]       AS AC_RQST_USR_ID," ).append("\n"); 
		query.append("@[ac_rqst_usr_eml]      AS AC_RQST_USR_EML," ).append("\n"); 
		query.append("ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("COMM_VSL_CD," ).append("\n"); 
		query.append("COMM_SKD_VOY_NO," ).append("\n"); 
		query.append("COMM_SKD_DIR_CD," ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("BKG_CRE_DT," ).append("\n"); 
		query.append("XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("NVL(X.INV_XCH_RT,0)" ).append("\n"); 
		query.append("FROM INV_VVD_XCH_RT X" ).append("\n"); 
		query.append("WHERE X.VSL_CD         = A.COMM_VSL_CD" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO     = A.COMM_SKD_VOY_NO" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD     = A.COMM_SKD_DIR_CD" ).append("\n"); 
		query.append("AND X.SVC_SCP_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("( nvl(A.SVC_SCP_CD,'OTH')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND X.IO_BND_CD      = A.IO_BND_CD" ).append("\n"); 
		query.append("AND X.PORT_CD        = A.PORT_CD" ).append("\n"); 
		query.append("AND X.LOCL_CURR_CD     = A.CURR_CD" ).append("\n"); 
		query.append("AND X.CHG_CURR_CD        = 'USD'" ).append("\n"); 
		query.append(")                                                         AS VVD_XCH_RT," ).append("\n"); 
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
		query.append("FROM" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("A.ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("A.COMM_VSL_CD," ).append("\n"); 
		query.append("A.COMM_SKD_VOY_NO," ).append("\n"); 
		query.append("A.COMM_SKD_DIR_CD," ).append("\n"); 
		query.append("B.SVC_SCP_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("CASE A.IO_BND_CD" ).append("\n"); 
		query.append("WHEN 'O'" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("CASE D.CONTI_CD" ).append("\n"); 
		query.append("WHEN 'E'" ).append("\n"); 
		query.append("THEN NVL(C.PRE_RLY_PORT_CD, C.POL_CD)" ).append("\n"); 
		query.append("ELSE C.POL_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE D.CONTI_CD" ).append("\n"); 
		query.append("WHEN 'E'" ).append("\n"); 
		query.append("THEN NVL(C.PST_RLY_PORT_CD, C.POD_CD)" ).append("\n"); 
		query.append("ELSE C.POD_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END                                    AS PORT_CD," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("TO_CHAR(C.BKG_CRE_DT, 'YYYYMMDD')  AS BKG_CRE_DT," ).append("\n"); 
		query.append("A.XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("A.SAIL_ARR_DT" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM        A," ).append("\n"); 
		query.append("AGT_COMM_BKG_INFO   B," ).append("\n"); 
		query.append("BKG_BOOKING         C," ).append("\n"); 
		query.append("MDM_LOCATION        D" ).append("\n"); 
		query.append("WHERE A.AGN_CD            = @[agn_cd]" ).append("\n"); 
		query.append("AND A.BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("AND A.IO_BND_CD         = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND A.AC_TP_CD         <> 'T'         --OTHER COMMISSION은 제외" ).append("\n"); 
		query.append("AND A.AC_SEQ            = @[ac_seq]" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD  = 'CS'" ).append("\n"); 
		query.append("AND A.CRE_USR_ID       != 'COST'" ).append("\n"); 
		query.append("AND A.BKG_NO            = B.BKG_NO" ).append("\n"); 
		query.append("AND A.COMM_OCCR_INFO_CD = D.LOC_CD(+)" ).append("\n"); 
		query.append("AND A.BKG_NO            = C.BKG_NO(+)" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}