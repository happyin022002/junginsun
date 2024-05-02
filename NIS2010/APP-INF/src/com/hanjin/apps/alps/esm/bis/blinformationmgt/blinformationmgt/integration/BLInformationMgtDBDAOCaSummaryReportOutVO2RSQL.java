/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLInformationMgtDBDAOCaSummaryReportOutVO2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.15 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLInformationMgtDBDAOCaSummaryReportOutVO2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public BLInformationMgtDBDAOCaSummaryReportOutVO2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contract_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_issue_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_issue_staff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration ").append("\n"); 
		query.append("FileName : BLInformationMgtDBDAOCaSummaryReportOutVO2RSQL").append("\n"); 
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
		query.append("SELECT BKG.BL_NO || BL_TP_CD                                AS BL_NO" ).append("\n"); 
		query.append(",BKG.BKG_NO                                           AS BKG_NO" ).append("\n"); 
		query.append(",BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD       AS VVD" ).append("\n"); 
		query.append(",TO_CHAR(DOC.BL_OBRD_DT,'YYYY-MM-DD')                 AS BL_OBRD_DT" ).append("\n"); 
		query.append(",BKG.BKG_OFC_CD                                       AS BKG_OFC_CD" ).append("\n"); 
		query.append(",BKG.SLS_RHQ_CD                                       AS SLS_RHQ_CD" ).append("\n"); 
		query.append(",BKG.CTRT_OFC_CD                                      AS CTRT_OFC_CD" ).append("\n"); 
		query.append(",BKG.POR_CD                                           AS POR_CD" ).append("\n"); 
		query.append(",BKG.POL_CD                                           AS POL_CD" ).append("\n"); 
		query.append(",BKG.POD_CD                                           AS POD_CD" ).append("\n"); 
		query.append(",BKG.DEL_CD                                           AS DEL_CD" ).append("\n"); 
		query.append(",COR.CORR_NO                                          AS CORR_NO" ).append("\n"); 
		query.append(",TO_CHAR(COR.CORR_DT,'YYYY-MM-DD')                    AS CORR_DT" ).append("\n"); 
		query.append(",COR.CORR_OFC_CD                                      AS CORR_OFC_CD" ).append("\n"); 
		query.append(",COR.CORR_USR_ID                                      AS CORR_USR_ID" ).append("\n"); 
		query.append(",COR.CA_RSN_CD                                        AS CA_RSN_CD" ).append("\n"); 
		query.append(",COR.RT_CORR_FLG                                      AS CNT_KIND_A" ).append("\n"); 
		query.append(",COR.CHG_TERM_CORR_FLG                                AS CNT_KIND_B" ).append("\n"); 
		query.append(",COR.RCVDE_TERM_CORR_FLG                              AS CNT_KIND_C" ).append("\n"); 
		query.append(",COR.ROUT_CORR_FLG                                    AS CNT_KIND_D" ).append("\n"); 
		query.append(",COR.CUST_CORR_FLG                                    AS CNT_KIND_E" ).append("\n"); 
		query.append(",COR.QTY_CORR_FLG                                     AS CNT_KIND_F" ).append("\n"); 
		query.append(",COR.MEAS_QTY_CORR_FLG                                AS CNT_KIND_G" ).append("\n"); 
		query.append(",COR.CMDT_CORR_FLG                                    AS CNT_KIND_H" ).append("\n"); 
		query.append(",COR.TRNK_VSL_CORR_FLG                                AS CNT_KIND_I" ).append("\n"); 
		query.append(",COR.PRPST_VSL_CORR_FLG                               AS CNT_KIND_J" ).append("\n"); 
		query.append(",COR.CA_OTR_RSN_CORR_FLG                              AS CNT_KIND_K" ).append("\n"); 
		query.append(",COR.BKG_SPLIT_MODI_FLG                               AS BKG_SPLIT_MODI_FLG" ).append("\n"); 
		query.append(",COR.CXL_MODI_FLG                                     AS CXL_MODI_FLG" ).append("\n"); 
		query.append(",TO_CHAR(COR.CRE_DT,'YYYY-MM-DD')                     AS CRE_DT" ).append("\n"); 
		query.append(",TO_CHAR(COR.UPD_DT,'YYYY-MM-DD')                     AS UPD_DT" ).append("\n"); 
		query.append(",RAT.UPD_USR_ID                                       AS UPD_USR_ID" ).append("\n"); 
		query.append(",REPLACE(CUS.CUST_NM,CHR(13) || CHR(10),' ')          AS CUST_NM" ).append("\n"); 
		query.append(",REPLACE(COR.DIFF_RMK,CHR(13) || CHR(10),' ')         AS DIFF_RMK" ).append("\n"); 
		query.append("FROM BIS_BOOKING      BKG" ).append("\n"); 
		query.append(",BIS_CORRECTION   COR" ).append("\n"); 
		query.append(",BIS_BL_DOC       DOC" ).append("\n"); 
		query.append(",BIS_RATE         RAT" ).append("\n"); 
		query.append(",BIS_CUSTOMER     CUS" ).append("\n"); 
		query.append("#if (${corr_from_dt} != '')" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = COR.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO = RAT.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUS.BKG_NO" ).append("\n"); 
		query.append("AND CUS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND COR.CORR_NO <> '0000000001'" ).append("\n"); 
		query.append("AND COR.CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND COR.CA_RSN_CD NOT IN ('F','E')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = COR.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = RAT.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUS.BKG_NO(+)" ).append("\n"); 
		query.append("AND CUS.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND COR.CORR_NO(+) <> '0000000001'" ).append("\n"); 
		query.append("AND COR.CORR_CXL_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND COR.CA_RSN_CD(+) NOT IN ('F','E')" ).append("\n"); 
		query.append("AND BKG.BKG_STS_CD IN ('F','W','A')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND BKG.VSL_CD = SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("AND BKG.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND BKG.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${corr_from_dt} != '')" ).append("\n"); 
		query.append("AND COR.CORR_DT BETWEEN TO_DATE(@[corr_from_dt] || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[corr_to_dt] || '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_from_dt} != '')" ).append("\n"); 
		query.append("AND BKG.BKG_CRE_DT BETWEEN TO_DATE(@[cre_from_dt] || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[cre_to_dt] || '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_reason} != '')" ).append("\n"); 
		query.append("AND ( ${ca_reason} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_class} != '')" ).append("\n"); 
		query.append("AND ( ${ca_class} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_kind} != '')" ).append("\n"); 
		query.append("AND ( ${ca_kind} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_issue_off} != '')" ).append("\n"); 
		query.append("AND COR.CORR_OFC_CD = @[ca_issue_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_off} != '')" ).append("\n"); 
		query.append("AND BKG.BKG_OFC_CD = @[bkg_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_off} != '')" ).append("\n"); 
		query.append("AND BKG.IB_SLS_OFC_CD = @[del_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${part} != '')" ).append("\n"); 
		query.append("--AND" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${contract_off} != '')" ).append("\n"); 
		query.append("AND BKG.CTRT_OFC_CD = @[contract_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_issue_staff} != '')" ).append("\n"); 
		query.append("AND COR.CRE_USR_ID = @[ca_issue_staff]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por} != '')" ).append("\n"); 
		query.append("AND BKG.POR_CD = @[por]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("AND BKG.POL_CD = @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("AND BKG.POD_CD = @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del} != '')" ).append("\n"); 
		query.append("AND BKG.DEL_CD = @[del]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${off_dis_op_5} != '')" ).append("\n"); 
		query.append("AND COR.CORR_OFC_CD IN (SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("FROM   DMT_OFC_LVL_V" ).append("\n"); 
		query.append("WHERE @[ca_issue_off] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${off_dis_op_6} != '')" ).append("\n"); 
		query.append("AND BKG.DEL_CD IN (SELECT LOC_CD FROM MDM_LOCATION WHERE SLS_OFC_CD = @[del_off])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG.POR_CD" ).append("\n"); 
		query.append(",BKG.POL_CD" ).append("\n"); 
		query.append(",BKG.POD_CD" ).append("\n"); 
		query.append(",BKG.DEL_CD" ).append("\n"); 

	}
}