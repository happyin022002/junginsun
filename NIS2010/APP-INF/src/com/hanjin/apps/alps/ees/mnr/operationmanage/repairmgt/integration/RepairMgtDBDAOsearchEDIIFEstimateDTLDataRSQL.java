/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtDBDAOsearchEDIIFEstimateDTLDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.12.15 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchEDIIFEstimateDTLDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEDIIFEstimateDTLData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchEDIIFEstimateDTLDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchEDIIFEstimateDTLDataRSQL").append("\n"); 
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
		query.append("A.RQST_EQ_NO" ).append("\n"); 
		query.append(",A.RPR_RQST_TMP_SEQ AS RPR_RQST_SEQ" ).append("\n"); 
		query.append(",A.RPR_RQST_TMP_VER_NO AS RPR_RQST_VER_NO" ).append("\n"); 
		query.append(",A.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append(",A.EQ_LOC_CD" ).append("\n"); 
		query.append(",A.EQ_LOC_CD_CHK_FLG" ).append("\n"); 
		query.append(",A.EQ_CMPO_CD" ).append("\n"); 
		query.append(",A.EQ_CMPO_CD_CHK_FLG" ).append("\n"); 
		query.append(",A.EQ_DMG_CD" ).append("\n"); 
		query.append(",A.EQ_DMG_CD_CHK_FLG" ).append("\n"); 
		query.append(",A.EQ_RPR_CD" ).append("\n"); 
		query.append(",A.EQ_RPR_CD_CHK_FLG" ).append("\n"); 
		query.append(",A.TRF_DIV_CD" ).append("\n"); 
		query.append(",A.TRF_OPT_CD" ).append("\n"); 
		query.append(",A.VOL_TP_CD" ).append("\n"); 
		query.append(",A.RPR_QTY" ).append("\n"); 
		query.append(",A.RPR_SZ_NO" ).append("\n"); 
		query.append(",A.RPR_LEN_NO" ).append("\n"); 
		query.append(",A.RPR_WDT_NO" ).append("\n"); 
		query.append(",A.RPR_LBR_HRS" ).append("\n"); 
		query.append(",A.RPR_LBR_RT" ).append("\n"); 
		query.append(",A.RPR_LBR_BZC_HRS" ).append("\n"); 
		query.append(",A.RPR_LBR_BZC_RT" ).append("\n"); 
		query.append(",A.MNR_LBR_BZC_AMT" ).append("\n"); 
		query.append(",A.LBR_MTRL_BZC_AMT" ).append("\n"); 
		query.append(",A.LBR_COST_AMT" ).append("\n"); 
		query.append(",A.MTRL_COST_AMT" ).append("\n"); 
		query.append(",A.XCH_MTRL_COST_AMT" ).append("\n"); 
		query.append(",A.MTRL_RECO_AMT" ).append("\n"); 
		query.append(",A.MNR_LR_ACCT_FLG" ).append("\n"); 
		query.append(",A.N3PTY_FLG" ).append("\n"); 
		query.append(",A.N3PTY_BIL_LBR_HRS" ).append("\n"); 
		query.append(",A.N3PTY_BIL_LBR_RT" ).append("\n"); 
		query.append(",A.N3PTY_BIL_LBR_COST_AMT" ).append("\n"); 
		query.append(",A.N3PTY_BIL_MTRL_COST_AMT" ).append("\n"); 
		query.append(",A.MNR_AGMT_AMT" ).append("\n"); 
		query.append(",A.MNR_WRK_AMT" ).append("\n"); 
		query.append(",A.N3PTY_BIL_AMT" ).append("\n"); 
		query.append(",A.RPR_DTL_RMK" ).append("\n"); 
		query.append(",A.MNR_VRFY_TP_CD" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append(",A.COST_CD" ).append("\n"); 
		query.append(",'NR' AS COST_DTL_CD" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_TMP_DTL A" ).append("\n"); 
		query.append("WHERE A.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND   A.RPR_RQST_TMP_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND   A.RPR_RQST_TMP_VER_NO = @[rpr_rqst_ver_no]" ).append("\n"); 

	}
}