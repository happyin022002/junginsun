/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQtaEditList0165RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQtaEditList0165RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMonthlyQtaEditList 조회
	  * History : 2011.02.16 김종준 [T-선사] Dry 이외의 GAMer 필드등 제거
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQtaEditList0165RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqtaRlseVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qtaTgtCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQtaEditList0165RSQL").append("\n"); 
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
		query.append("SELECT   LPAD(ROW_NUMBER() OVER(ORDER BY  QTA.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                            ,QTA.BSE_YR" ).append("\n"); 
		query.append("                                            ,QTA.BSE_QTR_CD" ).append("\n"); 
		query.append("                                            ,QTA.QTA_TGT_CD" ).append("\n"); 
		query.append("                                            ,QTA.TRD_CD" ).append("\n"); 
		query.append("                                            ,QTA.DIR_CD" ).append("\n"); 
		query.append("                                            ,QTA.RLANE_CD" ).append("\n"); 
		query.append("                                            ,VVD.SPRT_GRP_CD" ).append("\n"); 
		query.append("                                            ,VVD.BSA_GRP_CD" ).append("\n"); 
		query.append("                                            ,QTA.BSE_MON" ).append("\n"); 
		query.append("                                            ,VVD.BSE_WK" ).append("\n"); 
		query.append("                                            ,QTA.VSL_CD" ).append("\n"); 
		query.append("                                            ,QTA.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            ,QTA.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            ,QTA.RGN_OFC_CD),5,'0')  AS RN" ).append("\n"); 
		query.append("        ,QTA.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("        ,QTA.BSE_YR" ).append("\n"); 
		query.append("        ,QTA.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,QTA.QTA_TGT_CD" ).append("\n"); 
		query.append("        ,QTA.TRD_CD" ).append("\n"); 
		query.append("        ,QTA.DIR_CD" ).append("\n"); 
		query.append("        ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,QTA.RLANE_CD" ).append("\n"); 
		query.append("        ,QTA.VSL_CD||QTA.SKD_VOY_NO||QTA.SKD_DIR_CD                     AS VVD_CD" ).append("\n"); 
		query.append("        ,VVD.SPRT_GRP_CD||VVD.BSA_GRP_CD                                AS LANE_GRP" ).append("\n"); 
		query.append("        ,QTA.BSE_MON" ).append("\n"); 
		query.append("        ,VVD.BSE_WK" ).append("\n"); 
		query.append("        ,VVD.FNL_BSA_CAPA" ).append("\n"); 
		query.append(" 		--2010.04.26 2010-2Q 까지  데이터  Office Level 로 데이터 생성  (수정오류)" ).append("\n"); 
		query.append("        --,DECODE(QTA_TGT_CD,'G','',QTA.RGN_OFC_CD)                       AS RGN_OFC_CD" ).append("\n"); 
		query.append("		,QTA.RGN_OFC_CD" ).append("\n"); 
		query.append("        ,QTA.RHQ_CD" ).append("\n"); 
		query.append("        ,DECODE(QTA_TGT_CD,'G','',QTA.AQ_CD)                            AS AQ_CD" ).append("\n"); 
		query.append("		--,QTA.AQ_CD" ).append("\n"); 
		query.append("        ,'TEU'                                                          AS UNIT" ).append("\n"); 
		query.append("        ,QTA.LOD_QTY                                                    AS LOD_QTY" ).append("\n"); 
		query.append("        ,QTA.LOD_QTY * QTA.GRS_RPB_REV                                  AS GRS_REV" ).append("\n"); 
		query.append("        ,QTA.GRS_RPB_REV                                                AS GRS_RPB_REV" ).append("\n"); 
		query.append("        ,QTA.LOD_QTY * (QTA.GRS_RPB_REV - QTA.CM_UC_AMT      )          AS CM_AMT" ).append("\n"); 
		query.append("        ,QTA.CM_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.OPFIT_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.FULL_STVG_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.FULL_TRSP_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.MTY_STVG_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.MTY_TRSP_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.CNTR_FX_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.CHSS_FX_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.AGN_COMM_UT_AMT" ).append("\n"); 
		query.append("        ,QTA.BIZ_ACT_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.SLT_MGMT_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.OWN_VOL_ACT_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.STP_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.EQ_HLD_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.EQ_REPO_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.EQ_SIM_UC_AMT" ).append("\n"); 
		query.append("        ,QTA.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,QTA.SAQ_MISC_REV_AMT" ).append("\n"); 
		query.append("        ,QTA.CUST_GRP_ID" ).append("\n"); 
		query.append("        ,QTA.ADD_TP_CD" ).append("\n"); 
		query.append("FROM     SAQ_MON_CFM_TGT_VVD VVD" ).append("\n"); 
		query.append("        ,SAQ_MON_CFM_QTA     QTA" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     QTA.MQTA_RLSE_VER_NO    = @[mqtaRlseVerNo]" ).append("\n"); 
		query.append("AND     QTA.BSE_YR              = @[bse_yr]" ).append("\n"); 
		query.append("AND     QTA.BSE_QTR_CD          = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND     QTA.QTA_TGT_CD          = @[qtaTgtCd]" ).append("\n"); 
		query.append("AND     QTA.TRD_CD              = @[trd_cd]" ).append("\n"); 
		query.append("AND     QTA.DIR_CD              = @[dir_cd]" ).append("\n"); 
		query.append("AND     QTA.RLANE_CD            LIKE NVL(@[rlane_cd], '%')" ).append("\n"); 
		query.append("AND     VVD.MQTA_RLSE_VER_NO    = QTA.mqta_rlse_ver_no" ).append("\n"); 
		query.append("AND     VVD.BSE_YR              = QTA.bse_yr" ).append("\n"); 
		query.append("AND     VVD.BSE_QTR_CD          = QTA.bse_qtr_cd" ).append("\n"); 
		query.append("AND     VVD.BSE_MON             = QTA.bse_mon" ).append("\n"); 
		query.append("AND     VVD.TRD_CD              = QTA.trd_cd" ).append("\n"); 
		query.append("AND     VVD.RLANE_CD            = QTA.rlane_cd" ).append("\n"); 
		query.append("AND     VVD.DIR_CD              = QTA.dir_cd" ).append("\n"); 
		query.append("AND     VVD.VSL_CD              = QTA.vsl_cd" ).append("\n"); 
		query.append("AND     VVD.SKD_VOY_NO          = QTA.skd_voy_no" ).append("\n"); 
		query.append("AND     VVD.SKD_DIR_CD          = QTA.skd_dir_cd" ).append("\n"); 
		query.append("ORDER BY QTA.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("        ,QTA.BSE_YR" ).append("\n"); 
		query.append("        ,QTA.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,QTA.QTA_TGT_CD" ).append("\n"); 
		query.append("        ,QTA.TRD_CD" ).append("\n"); 
		query.append("        ,QTA.DIR_CD" ).append("\n"); 
		query.append("        ,QTA.RLANE_CD" ).append("\n"); 
		query.append("        ,VVD.SPRT_GRP_CD" ).append("\n"); 
		query.append("        ,VVD.BSA_GRP_CD" ).append("\n"); 
		query.append("        ,QTA.BSE_MON" ).append("\n"); 
		query.append("        ,VVD.BSE_WK" ).append("\n"); 
		query.append("        ,QTA.VSL_CD" ).append("\n"); 
		query.append("        ,QTA.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,QTA.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,QTA.RGN_OFC_CD" ).append("\n"); 

	}
}