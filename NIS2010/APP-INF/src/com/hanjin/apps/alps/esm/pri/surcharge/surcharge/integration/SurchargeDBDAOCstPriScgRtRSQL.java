/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeDBDAOCstPriScgRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.12.21 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOCstPriScgRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Inquiry 조회조건
	  * </pre>
	  */
	public SurchargeDBDAOCstPriScgRtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOCstPriScgRtRSQL").append("\n"); 
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
		query.append("SVC_SCP_CD" ).append("\n"); 
		query.append(",	CHG_CD" ).append("\n"); 
		query.append(",	TO_CHAR(EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",	DECODE(TO_CHAR(EXP_DT, 'YYYYMMDD'), '99991231', NULL, TO_CHAR(EXP_DT, 'YYYY-MM-DD')) AS EXP_DT" ).append("\n"); 
		query.append(",	SUB_TRD_CD" ).append("\n"); 
		query.append(",	VSL_SLAN_CD" ).append("\n"); 
		query.append(",	POR_TP_CD" ).append("\n"); 
		query.append(",	POR_DEF_CD" ).append("\n"); 
		query.append(",	POL_TP_CD" ).append("\n"); 
		query.append(",	POL_DEF_CD" ).append("\n"); 
		query.append(",	POD_TP_CD" ).append("\n"); 
		query.append(",	POD_DEF_CD" ).append("\n"); 
		query.append(",	DEL_TP_CD" ).append("\n"); 
		query.append(",	DEL_DEF_CD" ).append("\n"); 
		query.append(",	TS_PORT_CD" ).append("\n"); 
		query.append(",	TML_CD" ).append("\n"); 
		query.append(",	ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",	PRC_RCV_TERM_CD" ).append("\n"); 
		query.append(",	PRC_DE_TERM_CD" ).append("\n"); 
		query.append(",	PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",	DIR_CALL_FLG" ).append("\n"); 
		query.append(",	MIN_CGO_WGT" ).append("\n"); 
		query.append(",	MAX_CGO_WGT" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append(",	PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	RAT_UT_CD" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	SCG_AMT" ).append("\n"); 
		query.append(",	PAY_TERM_CD" ).append("\n"); 
		query.append(",	WDR_FLG" ).append("\n"); 
		query.append(",   SOC_FLG" ).append("\n"); 
		query.append(",   IO_GA_CD" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	SCG_RMK" ).append("\n"); 
		query.append("FROM PRI_SCG_RT" ).append("\n"); 
		query.append("WHERE	DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '')" ).append("\n"); 
		query.append("AND	CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_def_cd} != '')" ).append("\n"); 
		query.append("AND	POR_DEF_CD LIKE '%'|| @[por_def_cd] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '')" ).append("\n"); 
		query.append("AND	POL_DEF_CD LIKE '%'|| @[pol_def_cd] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '')" ).append("\n"); 
		query.append("AND	POD_DEF_CD LIKE '%'|| @[pod_def_cd] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("AND	DEL_DEF_CD LIKE '%'|| @[del_def_cd] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_rcv_term_cd} != '')" ).append("\n"); 
		query.append("AND	PRC_RCV_TERM_CD = @[prc_rcv_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_de_term_cd} != '')" ).append("\n"); 
		query.append("AND	PRC_DE_TERM_CD = @[prc_de_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eff_dt} != '')" ).append("\n"); 
		query.append("AND	TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${upd_dt} != '')" ).append("\n"); 
		query.append("AND	A.UPD_DT BETWEEN TO_DATE(REPLACE(@[upd_dt],'-','')||'000000', 'YYYYMMDDHH24MISS') AND TO_DATE(REPLACE(@[upd_dt],'-','')||'235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("AND	PRC_CGO_TP_CD = @[prc_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_imdg_clss_cd} != '')" ).append("\n"); 
		query.append("AND SCG_IMDG_CLSS_CD = @[scg_imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rat_ut_cd} != '')" ).append("\n"); 
		query.append("AND RAT_UT_CD = @[rat_ut_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_sz_cd} != '')" ).append("\n"); 
		query.append("AND RAT_UT_CD = (SELECT CNTR_SZ_CD" ).append("\n"); 
		query.append("FROM PRI_RAT_UT" ).append("\n"); 
		query.append("WHERE CNTR_SZ_CD = @[cntr_sz_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY POR_DEF_CD, POL_DEF_CD, POD_DEF_CD, DEL_DEF_CD" ).append("\n"); 

	}
}