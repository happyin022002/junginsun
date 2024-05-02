/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostManageDBDAOSearchStatusMonitorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandCostManageDBDAOSearchStatusMonitorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.06.08 변종건 [CHM-201217633] Cost & Guideline Tariff Status Monitoring 신규 개발
	  * </pre>
	  */
	public InlandCostManageDBDAOSearchStatusMonitorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itval",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trf_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration").append("\n"); 
		query.append("FileName : InlandCostManageDBDAOSearchStatusMonitorRSQL").append("\n"); 
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
		query.append("SELECT  AA.RHQ_CD" ).append("\n"); 
		query.append(", AA.TRF_TP" ).append("\n"); 
		query.append(", AA.CNT_CD" ).append("\n"); 
		query.append(", AA.IO_BND_CD" ).append("\n"); 
		query.append(", TRUNC(BB.P_CRE_DT - AA.EFF_FM_DT) ITVAL" ).append("\n"); 
		query.append(", AA.COST_TRF_NO" ).append("\n"); 
		query.append(", AA.COST_TRF_STS_CD" ).append("\n"); 
		query.append(", ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03047' AND INTG_CD_VAL_CTNT = AA.COST_TRF_STS_CD AND ROWNUM <= 1 ) COST_TRF_STS_NM" ).append("\n"); 
		query.append(", TO_CHAR(AA.EFF_FM_DT,'YYYYMMDD') EFF_FM_DT" ).append("\n"); 
		query.append(", DECODE(TO_CHAR(AA.EFF_TO_DT,'YYYYMMDD'),'29991231',NULL,TO_CHAR(AA.EFF_TO_DT,'YYYYMMDD')) EFF_TO_DT" ).append("\n"); 
		query.append(", TO_CHAR(AA.C_CRE_DT,'YYYYMMDD') C_CRE_DT" ).append("\n"); 
		query.append(", AA.C_CRE_USR_ID" ).append("\n"); 
		query.append(", ( SELECT CU.USR_NM FROM COM_USER CU WHERE CU.USR_ID = AA.C_CRE_USR_ID ) C_CRE_USR_NM" ).append("\n"); 
		query.append(", TO_CHAR(AA.C_UPD_DT,'YYYYMMDD') C_UPD_DT" ).append("\n"); 
		query.append(", AA.C_UPD_USR_ID" ).append("\n"); 
		query.append(", ( SELECT CU.USR_NM FROM COM_USER CU WHERE CU.USR_ID = AA.C_UPD_USR_ID ) C_UPD_USR_NM" ).append("\n"); 
		query.append(", BB.IHC_TRF_NO" ).append("\n"); 
		query.append(", BB.AMDT_SEQ" ).append("\n"); 
		query.append(", BB.FIC_PROP_STS_CD" ).append("\n"); 
		query.append(", ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03045' AND INTG_CD_VAL_CTNT = BB.FIC_PROP_STS_CD AND ROWNUM <= 1 ) FIC_PROP_STS_NM" ).append("\n"); 
		query.append(", TO_CHAR(BB.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(BB.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append(", TO_CHAR(BB.P_CRE_DT,'YYYYMMDD') P_CRE_DT" ).append("\n"); 
		query.append(", BB.P_CRE_USR_ID" ).append("\n"); 
		query.append(", ( SELECT CU.USR_NM FROM COM_USER CU WHERE CU.USR_ID = BB.P_CRE_USR_ID ) P_CRE_USR_NM" ).append("\n"); 
		query.append(", TO_CHAR(BB.P_UPD_DT,'YYYYMMDD') P_UPD_DT" ).append("\n"); 
		query.append(", BB.P_UPD_USR_ID" ).append("\n"); 
		query.append(", ( SELECT CU.USR_NM FROM COM_USER CU WHERE CU.USR_ID = BB.P_UPD_USR_ID ) P_UPD_USR_NM" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  B.RHQ_CD" ).append("\n"); 
		query.append(", 'Inland' TRF_TP" ).append("\n"); 
		query.append(", A.CNT_CD" ).append("\n"); 
		query.append(", A.IO_BND_CD" ).append("\n"); 
		query.append(", A.COST_TRF_NO" ).append("\n"); 
		query.append(", A.COST_TRF_STS_CD" ).append("\n"); 
		query.append(", A.EFF_FM_DT" ).append("\n"); 
		query.append(", A.EFF_TO_DT" ).append("\n"); 
		query.append(", A.CRE_DT     C_CRE_DT" ).append("\n"); 
		query.append(", A.CRE_USR_ID C_CRE_USR_ID" ).append("\n"); 
		query.append(", A.UPD_DT     C_UPD_DT" ).append("\n"); 
		query.append(", A.UPD_USR_ID C_UPD_USR_ID" ).append("\n"); 
		query.append("FROM    TRS_INLND_COST_TRF_HDR A" ).append("\n"); 
		query.append(", TRS_COST_TRF_CURR      B" ).append("\n"); 
		query.append("WHERE   A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND     A.COST_TRF_STS_CD IN ('B','U','C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${combo_rhq} != '')" ).append("\n"); 
		query.append("AND     B.RHQ_CD IN (${combo_rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trf_tp} != '')" ).append("\n"); 
		query.append("AND     'I' = @[trf_tp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("AND     A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${his_data} == '')" ).append("\n"); 
		query.append("AND     A.COST_TRF_NO IN (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  H.COST_TRF_NO" ).append("\n"); 
		query.append("FROM    TRS_INLND_COST_TRF_HDR H" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  A.IO_BND_CD" ).append("\n"); 
		query.append(", A.CNT_CD" ).append("\n"); 
		query.append(", NVL(MAX(B.COST_TRF_NO),MAX(C.COST_TRF_NO)) AS COST_TRF_NO_MIN" ).append("\n"); 
		query.append(", MAX(C.COST_TRF_NO) AS COST_TRF_NO_MAX" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  'I' IO_BND_CD" ).append("\n"); 
		query.append(", CNT_CD" ).append("\n"); 
		query.append("FROM    TRS_COST_TRF_CURR" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${combo_rhq} != '')" ).append("\n"); 
		query.append("AND     RHQ_CD IN (${combo_rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  'O' IO_BND_CD" ).append("\n"); 
		query.append(", CNT_CD" ).append("\n"); 
		query.append("FROM    TRS_COST_TRF_CURR" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${combo_rhq} != '')" ).append("\n"); 
		query.append("AND     RHQ_CD IN (${combo_rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", PRI_TRF_IHC_HDR B" ).append("\n"); 
		query.append(", TRS_INLND_COST_TRF_HDR C" ).append("\n"); 
		query.append("WHERE   A.IO_BND_CD = SUBSTR(B.COST_TRF_NO(+), 9,1)" ).append("\n"); 
		query.append("AND     A.CNT_CD = SUBSTR(B.COST_TRF_NO(+), 1,2)" ).append("\n"); 
		query.append("AND     A.IO_BND_CD = SUBSTR(C.COST_TRF_NO(+), 9,1)" ).append("\n"); 
		query.append("AND     A.CNT_CD = SUBSTR(C.COST_TRF_NO(+), 1,2)" ).append("\n"); 
		query.append("AND     NVL(B.COST_TRF_NO,C.COST_TRF_NO) IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY A.IO_BND_CD, A.CNT_CD" ).append("\n"); 
		query.append(") W" ).append("\n"); 
		query.append("WHERE   H.CNT_CD = W.CNT_CD" ).append("\n"); 
		query.append("AND     H.IO_BND_CD = W.IO_BND_CD" ).append("\n"); 
		query.append("AND     H.COST_TRF_NO >= W.COST_TRF_NO_MIN" ).append("\n"); 
		query.append("AND     H.COST_TRF_NO <= W.COST_TRF_NO_MAX" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("#if (${dt_tp} == 'E')" ).append("\n"); 
		query.append("AND     A.EFF_FM_DT   >= TO_DATE(@[fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     A.EFF_FM_DT   <  TO_DATE(@[to_dt],'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#elseif (${dt_tp} == 'C')" ).append("\n"); 
		query.append("AND     A.CRE_DT    >= TO_DATE(@[fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     A.CRE_DT    <  TO_DATE(@[to_dt],'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#elseif (${dt_tp} == 'U')" ).append("\n"); 
		query.append("AND     A.UPD_DT      >= TO_DATE(@[fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     A.UPD_DT      <  TO_DATE(@[to_dt],'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${combo_sts} != '')" ).append("\n"); 
		query.append("AND     A.COST_TRF_STS_CD IN (${combo_sts})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND     A.CNT_CD IN (${cnt_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_trf_no} != '')" ).append("\n"); 
		query.append("AND     A.COST_TRF_NO IN (${cost_trf_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT  X.COST_TRF_NO" ).append("\n"); 
		query.append(", Z.AMDT_SEQ" ).append("\n"); 
		query.append(", Y.FIC_PROP_STS_CD" ).append("\n"); 
		query.append(", Z.EFF_DT" ).append("\n"); 
		query.append(", Z.EXP_DT" ).append("\n"); 
		query.append(", Z.CRE_DT     P_CRE_DT" ).append("\n"); 
		query.append(", Z.CRE_USR_ID P_CRE_USR_ID" ).append("\n"); 
		query.append(", Z.UPD_DT     P_UPD_DT" ).append("\n"); 
		query.append(", Z.UPD_USR_ID P_UPD_USR_ID" ).append("\n"); 
		query.append(", X.IHC_TRF_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.IHC_TRF_NO" ).append("\n"); 
		query.append(", MAX(B.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append(", MAX(COST_TRF_NO) COST_TRF_NO" ).append("\n"); 
		query.append("FROM    ( SELECT  MAX(SVC_SCP_CD) SVC_SCP_CD" ).append("\n"); 
		query.append(", MAX(IHC_TRF_NO) IHC_TRF_NO" ).append("\n"); 
		query.append(", COST_TRF_NO" ).append("\n"); 
		query.append("FROM    PRI_TRF_IHC_HDR" ).append("\n"); 
		query.append("GROUP BY COST_TRF_NO" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", PRI_TRF_IHC_MN B" ).append("\n"); 
		query.append("WHERE   A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A.IHC_TRF_NO = B.IHC_TRF_NO" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.IHC_TRF_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(", PRI_TRF_IHC_MN  Y" ).append("\n"); 
		query.append(", PRI_TRF_IHC_DUR Z" ).append("\n"); 
		query.append("WHERE   X.SVC_SCP_CD = Y.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     X.IHC_TRF_NO = Y.IHC_TRF_NO" ).append("\n"); 
		query.append("AND     X.AMDT_SEQ   = Y.AMDT_SEQ" ).append("\n"); 
		query.append("AND     X.SVC_SCP_CD = Z.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     X.IHC_TRF_NO = Z.IHC_TRF_NO" ).append("\n"); 
		query.append("AND     X.AMDT_SEQ   = Z.AMDT_SEQ" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("WHERE   AA.COST_TRF_NO = BB.COST_TRF_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${itval} != '')" ).append("\n"); 
		query.append("AND     TRUNC(BB.P_CRE_DT - AA.EFF_FM_DT) >= @[itval]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ihc_trf_tp} == 'N')" ).append("\n"); 
		query.append("AND     BB.IHC_TRF_NO IS NULL" ).append("\n"); 
		query.append("#elseif (${ihc_trf_tp} == 'E')" ).append("\n"); 
		query.append("AND     BB.IHC_TRF_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ihc_trf_no} != '')" ).append("\n"); 
		query.append("AND     BB.IHC_TRF_NO IN (${ihc_trf_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  AA.RHQ_CD" ).append("\n"); 
		query.append(", AA.TRF_TP" ).append("\n"); 
		query.append(", AA.CNT_CD" ).append("\n"); 
		query.append(", AA.IO_BND_CD" ).append("\n"); 
		query.append(", TRUNC(BB.P_CRE_DT - AA.EFF_FM_DT) INTRVL" ).append("\n"); 
		query.append(", AA.COST_TRF_NO" ).append("\n"); 
		query.append(", AA.COST_TRF_STS_CD" ).append("\n"); 
		query.append(", ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03047' AND INTG_CD_VAL_CTNT = AA.COST_TRF_STS_CD AND ROWNUM <= 1 ) COST_TRF_STS_NM" ).append("\n"); 
		query.append(", TO_CHAR(AA.EFF_FM_DT,'YYYYMMDD') EFF_FM_DT" ).append("\n"); 
		query.append(", DECODE(TO_CHAR(AA.EFF_TO_DT,'YYYYMMDD'),'29991231',NULL,TO_CHAR(AA.EFF_TO_DT,'YYYYMMDD')) EFF_TO_DT" ).append("\n"); 
		query.append(", TO_CHAR(AA.C_CRE_DT,'YYYYMMDD') C_CRE_DT" ).append("\n"); 
		query.append(", AA.C_CRE_USR_ID" ).append("\n"); 
		query.append(", ( SELECT CU.USR_NM FROM COM_USER CU WHERE CU.USR_ID = AA.C_CRE_USR_ID ) C_CRE_USR_NM" ).append("\n"); 
		query.append(", TO_CHAR(AA.C_UPD_DT,'YYYYMMDD') C_UPD_DT" ).append("\n"); 
		query.append(", AA.C_UPD_USR_ID" ).append("\n"); 
		query.append(", ( SELECT CU.USR_NM FROM COM_USER CU WHERE CU.USR_ID = AA.C_UPD_USR_ID ) C_UPD_USR_NM" ).append("\n"); 
		query.append(", BB.FDR_TRF_NO" ).append("\n"); 
		query.append(", BB.AMDT_SEQ" ).append("\n"); 
		query.append(", BB.FIC_PROP_STS_CD" ).append("\n"); 
		query.append(", ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03045' AND INTG_CD_VAL_CTNT = BB.FIC_PROP_STS_CD AND ROWNUM <= 1 ) FIC_PROP_STS_NM" ).append("\n"); 
		query.append(", TO_CHAR(BB.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(BB.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append(", TO_CHAR(BB.P_CRE_DT,'YYYYMMDD') P_CRE_DT" ).append("\n"); 
		query.append(", BB.P_CRE_USR_ID" ).append("\n"); 
		query.append(", ( SELECT CU.USR_NM FROM COM_USER CU WHERE CU.USR_ID = BB.P_CRE_USR_ID ) P_CRE_USR_NM" ).append("\n"); 
		query.append(", TO_CHAR(BB.P_UPD_DT,'YYYYMMDD') P_UPD_DT" ).append("\n"); 
		query.append(", BB.P_UPD_USR_ID" ).append("\n"); 
		query.append(", ( SELECT CU.USR_NM FROM COM_USER CU WHERE CU.USR_ID = BB.P_UPD_USR_ID ) P_UPD_USR_NM" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  A.RHQ_CD" ).append("\n"); 
		query.append(", 'O.Feeder' TRF_TP" ).append("\n"); 
		query.append(", NULL CNT_CD" ).append("\n"); 
		query.append(", NULL IO_BND_CD" ).append("\n"); 
		query.append(", A.COST_TRF_NO" ).append("\n"); 
		query.append(", A.COST_TRF_STS_CD" ).append("\n"); 
		query.append(", A.EFF_FM_DT" ).append("\n"); 
		query.append(", A.EFF_TO_DT" ).append("\n"); 
		query.append(", A.CRE_DT     C_CRE_DT" ).append("\n"); 
		query.append(", A.CRE_USR_ID C_CRE_USR_ID" ).append("\n"); 
		query.append(", A.UPD_DT     C_UPD_DT" ).append("\n"); 
		query.append(", A.UPD_USR_ID C_UPD_USR_ID" ).append("\n"); 
		query.append("FROM    TRS_FDR_COST_TRF_HDR A" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     A.COST_TRF_STS_CD IN ('B','U','C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${combo_rhq} != '')" ).append("\n"); 
		query.append("AND     A.RHQ_CD IN (${combo_rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trf_tp} != '')" ).append("\n"); 
		query.append("AND     'O' = @[trf_tp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("AND     1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${his_data} == '')" ).append("\n"); 
		query.append("AND     A.COST_TRF_NO IN (" ).append("\n"); 
		query.append("SELECT  H.COST_TRF_NO" ).append("\n"); 
		query.append("FROM    TRS_FDR_COST_TRF_HDR H" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  A.RHQ_CD" ).append("\n"); 
		query.append(", NVL(MAX(B.FDR_COST_TRF_NO),MAX(C.COST_TRF_NO)) AS COST_TRF_NO_MIN" ).append("\n"); 
		query.append(", MAX(C.COST_TRF_NO) AS COST_TRF_NO_MAX" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  INTG_CD_VAL_DESC RHQ_CD" ).append("\n"); 
		query.append("FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE   INTG_CD_ID = 'CD00961'" ).append("\n"); 
		query.append("#if (${combo_rhq} != '')" ).append("\n"); 
		query.append("AND     INTG_CD_VAL_DESC IN (${combo_rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", PRI_TRF_FDR_COST_VER_MAPG B" ).append("\n"); 
		query.append(", TRS_FDR_COST_TRF_HDR C" ).append("\n"); 
		query.append("WHERE   A.RHQ_CD = B.RHQ_CD(+)" ).append("\n"); 
		query.append("AND     A.RHQ_CD = C.RHQ_CD(+)" ).append("\n"); 
		query.append("AND     NVL(B.FDR_COST_TRF_NO,C.COST_TRF_NO) IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY A.RHQ_CD" ).append("\n"); 
		query.append(") W" ).append("\n"); 
		query.append("WHERE   H.RHQ_CD = W.RHQ_CD" ).append("\n"); 
		query.append("AND     H.COST_TRF_NO >= W.COST_TRF_NO_MIN" ).append("\n"); 
		query.append("AND     H.COST_TRF_NO <= W.COST_TRF_NO_MAX" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("#if (${dt_tp} == 'E')" ).append("\n"); 
		query.append("AND     A.EFF_FM_DT   >= TO_DATE(@[fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     A.EFF_FM_DT   <  TO_DATE(@[to_dt],'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#elseif (${dt_tp} == 'C')" ).append("\n"); 
		query.append("AND     A.CRE_DT    >= TO_DATE(@[fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     A.CRE_DT    <  TO_DATE(@[to_dt],'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#elseif (${dt_tp} == 'U')" ).append("\n"); 
		query.append("AND     A.UPD_DT      >= TO_DATE(@[fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND     A.UPD_DT      <  TO_DATE(@[to_dt],'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${combo_sts} != '')" ).append("\n"); 
		query.append("AND     A.COST_TRF_STS_CD IN (${combo_sts})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND     1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_trf_no} != '')" ).append("\n"); 
		query.append("AND     A.COST_TRF_NO IN (${cost_trf_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT  X.COST_TRF_NO" ).append("\n"); 
		query.append(", Z.AMDT_SEQ" ).append("\n"); 
		query.append(", Y.FIC_PROP_STS_CD" ).append("\n"); 
		query.append(", Z.EFF_DT" ).append("\n"); 
		query.append(", Z.EXP_DT" ).append("\n"); 
		query.append(", Z.CRE_DT     P_CRE_DT" ).append("\n"); 
		query.append(", Z.CRE_USR_ID P_CRE_USR_ID" ).append("\n"); 
		query.append(", Z.UPD_DT     P_UPD_DT" ).append("\n"); 
		query.append(", Z.UPD_USR_ID P_UPD_USR_ID" ).append("\n"); 
		query.append(", X.FDR_TRF_NO" ).append("\n"); 
		query.append(", X.RHQ_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.FDR_TRF_NO" ).append("\n"); 
		query.append(", A.RHQ_CD" ).append("\n"); 
		query.append(", MAX(B.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append(", MAX(FDR_COST_TRF_NO) COST_TRF_NO" ).append("\n"); 
		query.append("FROM    ( SELECT  MAX(SVC_SCP_CD) SVC_SCP_CD" ).append("\n"); 
		query.append(", MAX(FDR_TRF_NO) FDR_TRF_NO" ).append("\n"); 
		query.append(", FDR_COST_TRF_NO" ).append("\n"); 
		query.append(", RHQ_CD" ).append("\n"); 
		query.append("FROM    PRI_TRF_FDR_COST_VER_MAPG" ).append("\n"); 
		query.append("GROUP BY FDR_COST_TRF_NO" ).append("\n"); 
		query.append(", RHQ_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", PRI_TRF_FDR_MN B" ).append("\n"); 
		query.append("WHERE   A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     A.FDR_TRF_NO = B.FDR_TRF_NO" ).append("\n"); 
		query.append("GROUP BY B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.FDR_TRF_NO" ).append("\n"); 
		query.append(", A.RHQ_CD" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(", PRI_TRF_FDR_MN  Y" ).append("\n"); 
		query.append(", PRI_TRF_FDR_DUR Z" ).append("\n"); 
		query.append("WHERE   X.SVC_SCP_CD = Y.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     X.FDR_TRF_NO = Y.FDR_TRF_NO" ).append("\n"); 
		query.append("AND     X.AMDT_SEQ   = Y.AMDT_SEQ" ).append("\n"); 
		query.append("AND     X.SVC_SCP_CD = Z.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     X.FDR_TRF_NO = Z.FDR_TRF_NO" ).append("\n"); 
		query.append("AND     X.AMDT_SEQ   = Z.AMDT_SEQ" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("WHERE   AA.COST_TRF_NO = BB.COST_TRF_NO(+)" ).append("\n"); 
		query.append("AND     AA.RHQ_CD      = BB.RHQ_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${itval} != '')" ).append("\n"); 
		query.append("AND     TRUNC(BB.P_CRE_DT - AA.EFF_FM_DT) >= @[itval]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ihc_trf_tp} == 'N')" ).append("\n"); 
		query.append("AND     BB.FDR_TRF_NO IS NULL" ).append("\n"); 
		query.append("#elseif (${ihc_trf_tp} == 'E')" ).append("\n"); 
		query.append("AND     BB.FDR_TRF_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ihc_trf_no} != '')" ).append("\n"); 
		query.append("AND     BB.FDR_TRF_NO IN (${ihc_trf_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY RHQ_CD" ).append("\n"); 
		query.append(", TRF_TP" ).append("\n"); 
		query.append(", CNT_CD" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", COST_TRF_NO DESC" ).append("\n"); 

	}
}