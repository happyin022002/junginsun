/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualCostCSRManageDBDAOSearchRVVDChangeActualCostCSRListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.11.23 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCSRManageDBDAOSearchRVVDChangeActualCostCSRListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ActualCostCSRManageDBDAOSearchRVVDChangeActualCostCSRListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCSRManageDBDAOSearchRVVDChangeActualCostCSRListRSQL").append("\n"); 
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
		query.append("SELECT  CSR_NO," ).append("\n"); 
		query.append("INV_SYS_ID," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("OLD_VVD_CD," ).append("\n"); 
		query.append("NEW_VVD_CD," ).append("\n"); 
		query.append("OLD_REV_YRMON," ).append("\n"); 
		query.append("NEW_REV_YRMON," ).append("\n"); 
		query.append("MODI_CSR_CRE_FLG," ).append("\n"); 
		query.append("ERP_IF_FLG," ).append("\n"); 
		query.append("LEA_IF_FLG," ).append("\n"); 
		query.append("MODI_CSR_NO," ).append("\n"); 
		query.append("EXE_YRMON," ).append("\n"); 
		query.append("OLD_VSL_CD," ).append("\n"); 
		query.append("OLD_SKD_VOY_NO," ).append("\n"); 
		query.append("OLD_SKD_DIR_CD," ).append("\n"); 
		query.append("OLD_REV_DIR_CD," ).append("\n"); 
		query.append("NEW_VSL_CD," ).append("\n"); 
		query.append("NEW_SKD_VOY_NO," ).append("\n"); 
		query.append("NEW_SKD_DIR_CD," ).append("\n"); 
		query.append("NEW_REV_DIR_CD" ).append("\n"); 
		query.append("FROM    (SELECT ROW_NUMBER() OVER (ORDER BY L.CSR_NO ASC) NO," ).append("\n"); 
		query.append("L.CSR_NO," ).append("\n"); 
		query.append("L.INV_SYS_ID," ).append("\n"); 
		query.append("L.BKG_NO," ).append("\n"); 
		query.append("L.OLD_VSL_CD||L.OLD_SKD_VOY_NO||L.OLD_SKD_DIR_CD||L.OLD_REV_DIR_CD AS OLD_VVD_CD," ).append("\n"); 
		query.append("L.NEW_VSL_CD||L.NEW_SKD_VOY_NO||L.NEW_SKD_DIR_CD||L.NEW_REV_DIR_CD AS NEW_VVD_CD," ).append("\n"); 
		query.append("L.OLD_REV_YRMON," ).append("\n"); 
		query.append("L.NEW_REV_YRMON," ).append("\n"); 
		query.append("NVL(L.MODI_CSR_CRE_FLG, 'N') AS MODI_CSR_CRE_FLG," ).append("\n"); 
		query.append("NVL(H.IF_FLG, 'N') AS ERP_IF_FLG," ).append("\n"); 
		query.append("NVL(L.LEA_IF_FLG, 'N') AS LEA_IF_FLG," ).append("\n"); 
		query.append("L.MODI_CSR_NO," ).append("\n"); 
		query.append("L.EXE_YRMON," ).append("\n"); 
		query.append("L.OLD_VSL_CD," ).append("\n"); 
		query.append("L.OLD_SKD_VOY_NO," ).append("\n"); 
		query.append("L.OLD_SKD_DIR_CD," ).append("\n"); 
		query.append("L.OLD_REV_DIR_CD," ).append("\n"); 
		query.append("L.NEW_VSL_CD," ).append("\n"); 
		query.append("L.NEW_SKD_VOY_NO," ).append("\n"); 
		query.append("L.NEW_SKD_DIR_CD," ).append("\n"); 
		query.append("L.NEW_REV_DIR_CD" ).append("\n"); 
		query.append("FROM    LEA_REV_VVD_CNG L, AP_INV_HDR H" ).append("\n"); 
		query.append("WHERE   EXE_YRMON = REPLACE(@[frm_exe_yrmon],'-','')" ).append("\n"); 
		query.append("AND     H.CSR_NO(+) = L.MODI_CSR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--   DECODE(ERP_IF_FLG, 'Y', DECODE(SUBSTR(h.estm_err_rsn, 1, 3), 'LEA', 'N', 'Y'), 'N') as lea_if_flg" ).append("\n"); 
		query.append("--  : AP_INV_HDR.ESTM_ERR_RSN 컬럼에 TRS,TES시스템에서 LEA로 해당 CSR I/F 시 실패할 경우 LEA 문자열(처음3글자)을 남김" ).append("\n"); 
		query.append("--     LEA문자열이 존재하면 I/F 실패, 문자열이 없으면 I/F 성공!! => TES, TRS 에서 성공후 Y 로 UPDATE (2008225)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_csr_no} != '')" ).append("\n"); 
		query.append("AND L.CSR_NO = @[frm_csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_bkg_no} != '')" ).append("\n"); 
		query.append("AND L.BKG_NO = @[frm_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}