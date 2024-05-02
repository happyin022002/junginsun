/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchDirectBillingInvoiceVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchDirectBillingInvoiceVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceCorrectionDBDAO::searchDirectBilling ( bilInputVo )
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchDirectBillingInvoiceVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchDirectBillingInvoiceVORSQL").append("\n"); 
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
		query.append("SELECT AR_OFC_CD" ).append("\n"); 
		query.append(",BL_SRC_NO" ).append("\n"); 
		query.append(",MN.INV_NO" ).append("\n"); 
		query.append(",MN.ISS_DT" ).append("\n"); 
		query.append(",TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",SAIL_ARR_DT" ).append("\n"); 
		query.append(",ACT_CUST_CNT_CD||TO_CHAR(ACT_CUST_SEQ, 'FM099999') CUST_CD" ).append("\n"); 
		query.append(",RFA_NO" ).append("\n"); 
		query.append(",SC_NO" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",CHG_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",TRF_RT_AMT" ).append("\n"); 
		query.append(",RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(",PER_TP_CD" ).append("\n"); 
		query.append(",CHG_AMT" ).append("\n"); 
		query.append(",INV_XCH_RT" ).append("\n"); 
		query.append(",CHG_AMT*INV_XCH_RT LOCL_AMT" ).append("\n"); 
		query.append(",BKG_REF_NO" ).append("\n"); 
		query.append(",INV_REF_NO" ).append("\n"); 
		query.append(",CGO_MEAS_QTY" ).append("\n"); 
		query.append(",CGO_WGT" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,1,CNTR_TPSZ_CD)) CNTR_TYP_1" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,1,  CNTR_NO))  CNTR_NO_1" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,2,CNTR_TPSZ_CD)) CNTR_TYP_2" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,2,  CNTR_NO))  CNTR_NO_2" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,3,CNTR_TPSZ_CD)) CNTR_TYP_3" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,3,  CNTR_NO))  CNTR_NO_3" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,4,CNTR_TPSZ_CD)) CNTR_TYP_4" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,4,  CNTR_NO))  CNTR_NO_4" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,5,CNTR_TPSZ_CD)) CNTR_TYP_5" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,5,  CNTR_NO))  CNTR_NO_5" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,6,CNTR_TPSZ_CD)) CNTR_TYP_6" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,6,  CNTR_NO))  CNTR_NO_6" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,7,CNTR_TPSZ_CD)) CNTR_TYP_7" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,7,  CNTR_NO))  CNTR_NO_7" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,8,CNTR_TPSZ_CD)) CNTR_TYP_8" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,8,  CNTR_NO))  CNTR_NO_8" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,9,CNTR_TPSZ_CD)) CNTR_TYP_9" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,9,  CNTR_NO))  CNTR_NO_9" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,10,CNTR_TPSZ_CD)) CNTR_TYP_10" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,10,  CNTR_NO))  CNTR_NO_10" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,11,CNTR_TPSZ_CD)) CNTR_TYP_11" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,11,  CNTR_NO))  CNTR_NO_11" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,12,CNTR_TPSZ_CD)) CNTR_TYP_12" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,12,  CNTR_NO))  CNTR_NO_12" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,13,CNTR_TPSZ_CD)) CNTR_TYP_13" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,13,  CNTR_NO))  CNTR_NO_13" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,14,CNTR_TPSZ_CD)) CNTR_TYP_14" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,14,  CNTR_NO))  CNTR_NO_14" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,15,CNTR_TPSZ_CD)) CNTR_TYP_15" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,15,  CNTR_NO))  CNTR_NO_15" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,16,CNTR_TPSZ_CD)) CNTR_TYP_16" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,16,  CNTR_NO))  CNTR_NO_16" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,17,CNTR_TPSZ_CD)) CNTR_TYP_17" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,17,  CNTR_NO))  CNTR_NO_17" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,18,CNTR_TPSZ_CD)) CNTR_TYP_18" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,18,  CNTR_NO))  CNTR_NO_18" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,19,CNTR_TPSZ_CD)) CNTR_TYP_19" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,19,  CNTR_NO))  CNTR_NO_19" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,20,CNTR_TPSZ_CD)) CNTR_TYP_20" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,20,  CNTR_NO))  CNTR_NO_20" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,21,CNTR_TPSZ_CD)) CNTR_TYP_21" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,21,  CNTR_NO))  CNTR_NO_21" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,22,CNTR_TPSZ_CD)) CNTR_TYP_22" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,22,  CNTR_NO))  CNTR_NO_22" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,23,CNTR_TPSZ_CD)) CNTR_TYP_23" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,23,  CNTR_NO))  CNTR_NO_23" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,24,CNTR_TPSZ_CD)) CNTR_TYP_24" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,24,  CNTR_NO))  CNTR_NO_24" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,25,CNTR_TPSZ_CD)) CNTR_TYP_25" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,25,  CNTR_NO))  CNTR_NO_25" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,26,CNTR_TPSZ_CD)) CNTR_TYP_26" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,26,  CNTR_NO))  CNTR_NO_26" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,27,CNTR_TPSZ_CD)) CNTR_TYP_27" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,27,  CNTR_NO))  CNTR_NO_27" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,28,CNTR_TPSZ_CD)) CNTR_TYP_28" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,28,  CNTR_NO))  CNTR_NO_28" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,29,CNTR_TPSZ_CD)) CNTR_TYP_29" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,29,  CNTR_NO))  CNTR_NO_29" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,30,SUBSTR(CNTR_TPSZ_CD_30,2))) CNTR_TYP_30" ).append("\n"); 
		query.append(",MIN(DECODE(CNTR_SEQ,30,SUBSTR(CNTR_NO_30,2)))  CNTR_NO_30" ).append("\n"); 
		query.append("FROM INV_AR_MN MN," ).append("\n"); 
		query.append("INV_AR_CHG CHG," ).append("\n"); 
		query.append("INV_AR_CNTR CNTR," ).append("\n"); 
		query.append("(SELECT A.AR_IF_NO" ).append("\n"); 
		query.append(",XMLAGG(XMLELEMENT(x,'/'||CNTR_TPSZ_CD||'') ORDER BY CNTR_SEQ).EXTRACT('//text()').GetStringVal() CNTR_TPSZ_CD_30" ).append("\n"); 
		query.append(",XMLAGG(XMLELEMENT(x,'/'||CNTR_NO||'') ORDER BY CNTR_SEQ).EXTRACT('//text()').GetStringVal() CNTR_NO_30" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("INV_AR_CNTR E" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = E.AR_IF_NO(+)" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("#if  (${ofc_cd} == 'ALL')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD IN (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#if (${dt_type} == 'I')" ).append("\n"); 
		query.append("AND A.ISS_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${dt_type} == 'G')" ).append("\n"); 
		query.append("AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.SAIL_ARR_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = SUBSTR(@[vvd_cd],0,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND A.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND A.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${iss_opt} != '')" ).append("\n"); 
		query.append("#if (${iss_opt} == 'I')" ).append("\n"); 
		query.append("AND NVL(A.INV_ISS_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NVL(A.INV_ISS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.INV_NO != 'SYS CLEAR'" ).append("\n"); 
		query.append("AND E.CNTR_SEQ > 29" ).append("\n"); 
		query.append("GROUP BY A.AR_IF_NO) CNTR30" ).append("\n"); 
		query.append("WHERE MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("AND MN.AR_IF_NO = CNTR.AR_IF_NO(+)" ).append("\n"); 
		query.append("AND MN.AR_IF_NO = CNTR30.AR_IF_NO(+)" ).append("\n"); 
		query.append("AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("#if  (${ofc_cd} == 'ALL')" ).append("\n"); 
		query.append("AND MN.AR_OFC_CD IN (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MN.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MN.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("AND MN.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#if (${dt_type} == 'I')" ).append("\n"); 
		query.append("AND MN.ISS_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${dt_type} == 'G')" ).append("\n"); 
		query.append("AND MN.BL_INV_CFM_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MN.SAIL_ARR_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND MN.VSL_CD = SUBSTR(@[vvd_cd],0,4)" ).append("\n"); 
		query.append("AND MN.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND MN.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("AND MN.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND MN.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND MN.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND MN.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND MN.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${iss_opt} != '')" ).append("\n"); 
		query.append("#if (${iss_opt} == 'I')" ).append("\n"); 
		query.append("AND NVL(MN.INV_ISS_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NVL(MN.INV_ISS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MN.INV_NO != 'SYS CLEAR'" ).append("\n"); 
		query.append("GROUP BY AR_OFC_CD" ).append("\n"); 
		query.append(",BL_SRC_NO" ).append("\n"); 
		query.append(",MN.INV_NO" ).append("\n"); 
		query.append(",MN.ISS_DT" ).append("\n"); 
		query.append(",TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",SVC_SCP_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",SAIL_ARR_DT" ).append("\n"); 
		query.append(",ACT_CUST_CNT_CD||TO_CHAR(ACT_CUST_SEQ, 'FM099999')" ).append("\n"); 
		query.append(",RFA_NO" ).append("\n"); 
		query.append(",SC_NO" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",CHG_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",TRF_RT_AMT" ).append("\n"); 
		query.append(",RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(",PER_TP_CD" ).append("\n"); 
		query.append(",CHG_AMT" ).append("\n"); 
		query.append(",INV_XCH_RT" ).append("\n"); 
		query.append(",CHG_AMT*INV_XCH_RT" ).append("\n"); 
		query.append(",BKG_REF_NO" ).append("\n"); 
		query.append(",INV_REF_NO" ).append("\n"); 
		query.append(",CGO_MEAS_QTY" ).append("\n"); 
		query.append(",CGO_WGT" ).append("\n"); 
		query.append(",MN.AR_IF_NO" ).append("\n"); 

	}
}