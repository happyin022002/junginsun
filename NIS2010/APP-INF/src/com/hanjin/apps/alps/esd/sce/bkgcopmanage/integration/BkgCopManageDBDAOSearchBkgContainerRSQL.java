/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchBkgContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.30 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchBkgContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_container table 의 정보를 조회 한다. (booking, container 별)
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchBkgContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchBkgContainerRSQL").append("\n"); 
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
		query.append("BKG_NO," ).append("\n"); 
		query.append("TO_CHAR(CGO_RCV_GDT, 'YYYYMMDDHH24MISS') AS CGO_RCV_GDT," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_ID_NO," ).append("\n"); 
		query.append("CNMV_CYC_NO," ).append("\n"); 
		query.append("CNMV_STS_CD," ).append("\n"); 
		query.append("CNTR_DP_SEQ," ).append("\n"); 
		query.append("PCK_TP_CD," ).append("\n"); 
		query.append("PCK_QTY," ).append("\n"); 
		query.append("CNTR_WGT," ).append("\n"); 
		query.append("WGT_UT_CD," ).append("\n"); 
		query.append("MEAS_QTY," ).append("\n"); 
		query.append("MEAS_UT_CD," ).append("\n"); 
		query.append("RCV_TERM_CD," ).append("\n"); 
		query.append("DE_TERM_CD," ).append("\n"); 
		query.append("ORG_FM_LOC_CD," ).append("\n"); 
		query.append("ORG_TO_LOC_CD," ).append("\n"); 
		query.append("ORG_YD_CD," ).append("\n"); 
		query.append("DEST_FM_LOC_CD," ).append("\n"); 
		query.append("DEST_TO_YD_CD," ).append("\n"); 
		query.append("DEST_YD_CD," ).append("\n"); 
		query.append("POR_NOD_CD," ).append("\n"); 
		query.append("POL_YD_CD," ).append("\n"); 
		query.append("CNTR_PRT_FLG," ).append("\n"); 
		query.append("CNTR_PRT_SEQ," ).append("\n"); 
		query.append("CNTR_VOL_QTY," ).append("\n"); 
		query.append("ADV_SHTG_CD," ).append("\n"); 
		query.append("CNTR_WFG_EXPT_FLG," ).append("\n"); 
		query.append("CSTMS_PRN_FLG," ).append("\n"); 
		query.append("TO_CHAR(CSTMS_EXP_DT, 'YYYYMMDDHH24MISS') AS CSTMS_EXP_DT," ).append("\n"); 
		query.append("DCGO_FLG," ).append("\n"); 
		query.append("RC_FLG," ).append("\n"); 
		query.append("BB_CGO_FLG," ).append("\n"); 
		query.append("AWK_CGO_FLG," ).append("\n"); 
		query.append("RD_CGO_FLG," ).append("\n"); 
		query.append("HNGR_FLG," ).append("\n"); 
		query.append("SOC_FLG," ).append("\n"); 
		query.append("EQ_SUBST_FLG," ).append("\n"); 
		query.append("EQ_SUBST_TPSZ_CD," ).append("\n"); 
		query.append("TO_CHAR(CGO_RCV_DT, 'YYYYMMDDHH24MISS') AS CGO_RCV_DT," ).append("\n"); 
		query.append("CGO_RCV_YD_CD," ).append("\n"); 
		query.append("TO_CHAR(OB_CY_GEN_DT, 'YYYYMMDDHH24MISS') AS OB_CY_GEN_DT," ).append("\n"); 
		query.append("OB_CY_AUTO_GEN_FLG," ).append("\n"); 
		query.append("CNMV_FLG," ).append("\n"); 
		query.append("TO_CHAR(CNMV_EVNT_DT, 'YYYYMMDDHH24MISS') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("PO_NO," ).append("\n"); 
		query.append("DO_NO," ).append("\n"); 
		query.append("DO_NO_SPLIT," ).append("\n"); 
		query.append("DIFF_RMK," ).append("\n"); 
		query.append("CNTR_CFM_FLG," ).append("\n"); 
		query.append("MCNTR_BDL_NO," ).append("\n"); 
		query.append("MF_CFM_FLG," ).append("\n"); 
		query.append("CNTR_DELT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("bkg_container" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_cfm_flg} != '')" ).append("\n"); 
		query.append("and nvl(cntr_cfm_flg, 'N') = @[cntr_cfm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_delt_flg} != '')" ).append("\n"); 
		query.append("and nvl(cntr_delt_flg, 'N') = @[cntr_delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}