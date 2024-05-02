/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MisUseApprovalDBDAOMisUseReqContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MisUseApprovalDBDAOMisUseReqContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택 Request No.에 대한 장비목록을 조회한다.
	  * </pre>
	  */
	public MisUseApprovalDBDAOMisUseReqContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration").append("\n"); 
		query.append("FileName : MisUseApprovalDBDAOMisUseReqContainerListRSQL").append("\n"); 
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
		query.append("SELECT  A.RQST_NO, A.CNTR_NO,  " ).append("\n"); 
		query.append("        A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("        A.AGMT_CTY_CD, A.AGMT_SEQ, A.CNTR_TPSZ_CD, A.LSTM_CD," ).append("\n"); 
		query.append("        TO_CHAR(A.MSS_USD_DT, 'YYYYMMDD') AS MSS_USD_DT, " ).append("\n"); 
		query.append("        A.MSS_USD_FM_NM, A.MSS_USE_PLC_NM, " ).append("\n"); 
		query.append("--		A.PD_CHG_RT_AMT," ).append("\n"); 
		query.append("		DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(" 				,'Y',A.PD_CHG_RT_AMT" ).append("\n"); 
		query.append(" 				,'N','') AS PD_CHG_RT_AMT," ).append("\n"); 
		query.append("        A.LFT_CHG_RT_AMT, A.LIBOR_PTY_NM, A.MVMT_STS_CD, A.POD_CD, A.POL_CD," ).append("\n"); 
		query.append("		B.FILE_SAV_ID AS RQST_FILE_SAV_ID, A.RQST_RSN_DESC," ).append("\n"); 
		query.append("		DECODE(B.DELT_FLG, 'N',B.FILE_UPLD_NM, NULL) AS RQST_FILE_SAV_NM" ).append("\n"); 
		query.append("FROM    LSE_MSS_USD_CNTR A," ).append("\n"); 
		query.append("		COM_UPLD_FILE B" ).append("\n"); 
		query.append("WHERE   A.MSS_USD_APRO_MOD_CD IS NULL" ).append("\n"); 
		query.append("AND     A.RQST_FILE_SAV_ID = B.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("#if (${rqst_no} != \"\")" ).append("\n"); 
		query.append("AND     A.RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != \"\")" ).append("\n"); 
		query.append("AND     A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}