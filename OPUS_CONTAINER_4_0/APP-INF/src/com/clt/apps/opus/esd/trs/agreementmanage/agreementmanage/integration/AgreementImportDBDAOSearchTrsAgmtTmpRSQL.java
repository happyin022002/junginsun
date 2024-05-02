/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementImportDBDAOSearchTrsAgmtTmpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOSearchTrsAgmtTmpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrsAgmtTmp
	  * </pre>
	  */
	public AgreementImportDBDAOSearchTrsAgmtTmpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOSearchTrsAgmtTmpRSQL").append("\n"); 
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
		query.append("SELECT TRSP_TMP_SEQ," ).append("\n"); 
		query.append("       TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("       TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("       EQ_KND_CD," ).append("\n"); 
		query.append("       TRSP_COST_MOD_CD," ).append("\n"); 
		query.append("       AGMT_TRSP_TP_CD," ).append("\n"); 
		query.append("       TRSP_BND_CD," ).append("\n"); 
		query.append("       CGO_TP_CD," ).append("\n"); 
		query.append("       SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("       CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("       CUST_CNT_CD," ).append("\n"); 
		query.append("       CUST_SEQ," ).append("\n"); 
		query.append("       CMDT_GRP_CD," ).append("\n"); 
		query.append("       RAIL_SVC_TP_CD," ).append("\n"); 
		query.append("       FM_NOD_CD," ).append("\n"); 
		query.append("       VIA_NOD_CD," ).append("\n"); 
		query.append("       DOR_NOD_CD," ).append("\n"); 
		query.append("       TO_NOD_CD," ).append("\n"); 
		query.append("       TRSP_AGMT_EQ_TP_CD," ).append("\n"); 
		query.append("       TRSP_AGMT_EQ_SZ_CD," ).append("\n"); 
		query.append("       TRSP_AGMT_EQ_TP_CD || TRSP_AGMT_EQ_SZ_CD AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("       EFF_FM_DT," ).append("\n"); 
		query.append("       EFF_TO_DT," ).append("\n"); 
		query.append("       WGT_MEAS_UT_CD," ).append("\n"); 
		query.append("       TO_WGT," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       TRSP_ONE_WY_RT," ).append("\n"); 
		query.append("       TRSP_RND_RT," ).append("\n"); 
		query.append("       TRSP_AGMT_RT_TP_CD," ).append("\n"); 
		query.append("       TRSP_AGMT_BDL_QTY," ).append("\n"); 
		query.append("       WTR_RCV_TERM_CD," ).append("\n"); 
		query.append("       WTR_DE_TERM_CD," ).append("\n"); 
		query.append("       TRSP_AGMT_DIST," ).append("\n"); 
		query.append("       DIST_MEAS_UT_CD," ).append("\n"); 
		query.append("       TRSP_DIST_TP_CD," ).append("\n"); 
		query.append("       TRSP_SCG_CD," ).append("\n"); 
		query.append("       TRSP_RVS_APLY_FLG," ).append("\n"); 
		query.append("       AGMT_RMK," ).append("\n"); 
		query.append("       ROW_NO," ).append("\n"); 
		query.append("       SUB_ROW_NO," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT," ).append("\n"); 
		query.append("       AGMT_ROUT_ALL_FLG," ).append("\n"); 
		query.append("       DELT_FLG," ).append("\n"); 
		query.append("       RT_UPD_STS_CD," ).append("\n"); 
		query.append("       AGMT_SCG_RT_DIV_CD," ).append("\n"); 
		query.append("       COM_SCG_APLY_FLG," ).append("\n"); 
		query.append("       WO_APLY_FLG," ).append("\n"); 
		query.append("       EDW_UPD_DT" ).append("\n"); 
		query.append("  FROM TRS_AGMT_TMP" ).append("\n"); 
		query.append(" WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 

	}
}