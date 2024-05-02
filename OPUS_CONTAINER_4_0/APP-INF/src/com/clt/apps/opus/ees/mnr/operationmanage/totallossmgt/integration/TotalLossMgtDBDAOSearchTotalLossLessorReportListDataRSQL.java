/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TotalLossMgtDBDAOSearchTotalLossLessorReportListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOSearchTotalLossLessorReportListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTotalLossLessorReportListData
	  * </pre>
	  */
	public TotalLossMgtDBDAOSearchTotalLossLessorReportListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lessor",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOSearchTotalLossLessorReportListDataRSQL").append("\n"); 
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
		query.append("SELECT  EV.LESSOR_CD LESSOR_CD, " ).append("\n"); 
		query.append("        EV.LESSOR_NM LESSOR_NM, " ).append("\n"); 
		query.append("        RD.EQ_KND_CD EQ_TYPE," ).append("\n"); 
		query.append("        RD.RQST_EQ_NO EQ_NO, " ).append("\n"); 
		query.append("        TO_CHAR(RH.TTL_LSS_DT, 'YYYY-MM-DD') TLL_DT," ).append("\n"); 
		query.append("#if(${curr_cd} != '')" ).append("\n"); 
		query.append("        MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.TTL_LSS_DT, 'YYYYMM'), RD.CURR_CD, @[curr_cd], RD.DPC_VAL_AMT) DV_VALUE," ).append("\n"); 
		query.append("        MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(RH.TTL_LSS_DT, 'YYYYMM'), RD.CURR_CD, @[curr_cd], PH.PAY_AMT) PAY_AMT," ).append("\n"); 
		query.append("#else       " ).append("\n"); 
		query.append("        RD.DPC_VAL_AMT DV_VALUE, " ).append("\n"); 
		query.append("        PH.PAY_AMT PAY_AMT, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        TO_CHAR(TO_DATE(PH.AP_PAY_DT, 'YYYYMMDD'), 'YYYY-MM-DD') PAY_DT," ).append("\n"); 
		query.append("        DECODE(PH.AP_PAY_FLG, 'Y', 'Paid', 'Not Paid') PAY_STS," ).append("\n"); 
		query.append("        PH.CSR_NO CR_NO, " ).append("\n"); 
		query.append("        TO_CHAR(TO_DATE(PH.AP_PAY_DT, 'YYYYMMDD'), 'YYYY-MM-DD') CR_END_DT," ).append("\n"); 
		query.append("#if(${curr_cd} != '')" ).append("\n"); 
		query.append("        @[curr_cd] AS CURR_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        RD.CURR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_HDR RH, MNR_TTL_LSS_RQST_DTL RD, MNR_EQ_STS_V EV," ).append("\n"); 
		query.append("     (SELECT DISTINCT A.INV_NO" ).append("\n"); 
		query.append("           , B.PAY_DT AS AP_PAY_DT" ).append("\n"); 
		query.append("           , DECODE(B.PAY_AMT, '', 'N', 'Y') AS AP_PAY_FLG" ).append("\n"); 
		query.append("           , A.CSR_NO" ).append("\n"); 
		query.append("           , DECODE(B.PAY_AMT, '', '', A.INV_TTL_AMT) AS PAY_AMT" ).append("\n"); 
		query.append("        FROM AP_PAY_INV A, AP_INV_HDR B" ).append("\n"); 
		query.append("       WHERE A.CSR_NO = B.CSR_NO) PH" ).append("\n"); 
		query.append("WHERE RH.TTL_LSS_NO = RD.TTL_LSS_NO" ).append("\n"); 
		query.append("AND   RD.RQST_EQ_NO = EV.EQ_NO" ).append("\n"); 
		query.append("AND   RD.INV_NO = PH.INV_NO(+)" ).append("\n"); 
		query.append("AND   EV.LSTM_CD <> 'OW'" ).append("\n"); 
		query.append("AND   RD.PAY_INV_SEQ IS NOT NULL" ).append("\n"); 
		query.append("AND   RH.TTL_LSS_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD')+0.9999  " ).append("\n"); 
		query.append("#if (${eq_type} != 'A') " ).append("\n"); 
		query.append("AND   RD.EQ_KND_CD = @[eq_type] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("	AND	RD.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("				'$user_eqNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_eqNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${total_loss_no} != '')" ).append("\n"); 
		query.append("	AND	RD.TTL_LSS_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_totalLossNos IN ${totalLossNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $totalLossNos.size())" ).append("\n"); 
		query.append("				'$user_totalLossNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_totalLossNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lessor} != '') " ).append("\n"); 
		query.append("AND   EV.LESSOR_CD = REPLACE(@[lessor],',')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ttl_lss_sts_cd} != '') " ).append("\n"); 
		query.append("AND   RH.TTL_LSS_STS_CD = @[ttl_lss_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}