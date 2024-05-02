/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOSdmsOptionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOSdmsOptionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.10.26 이윤정 [CHM-201006565-01] 0053화면 조회시 VSK_VSL_SKD 없는 VVDRK
	  * 			     AR_MST_REV_VVD 에 있다면 조회 되도록 쿼리 변경. 
	  * 
	  * 2011.02.10 김기종  [CHM-201108942-01]  화면 DISPLAY 칼럼 추가
	  * 				1. Quotation (USD / LCL)
	  * 				2.Repair Cost (USD / LCL)
	  * 				3.Settled amount (USD/ LCL)
	  * 				4.Claim Handling Office	
	  * 2012.02.03 김민아 [CHM-201215702-01] [VOP-OPF] SDMS No. 정의 및 칼럼 정리
	  *                            SDMS NO. 조건 추가
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOSdmsOptionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("stv_dmg_stl_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpn_cost_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_req_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("elapse_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_rpr_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_cmpn_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_evnt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_evnt_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOSdmsOptionVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     STV_DMG_NO" ).append("\n"); 
		query.append("    ,VVD_CD" ).append("\n"); 
		query.append("    ,VPS_PORT_CD" ).append("\n"); 
		query.append("    ,STV_DMG_EVNT_DT" ).append("\n"); 
		query.append("    ,STV_DMG_TP_CD" ).append("\n"); 
		query.append("    ,ELAPSE_DAY" ).append("\n"); 
		query.append("    ,DMG_AUTH_STS_CD" ).append("\n"); 
		query.append("    ,STV_DMG_REQ_CATE_CD" ).append("\n"); 
		query.append("    ,STV_DMG_RPR_PROC_STS_CD" ).append("\n"); 
		query.append("    ,STV_DMG_CMPN_PROC_STS_CD" ).append("\n"); 
		query.append("    ,STV_DMG_STL_PROC_STS_CD" ).append("\n"); 
		query.append("    ,REQ_PORT_CD" ).append("\n"); 
		query.append("    ,REQ_ETA_DT" ).append("\n"); 
		query.append("	,QTTN_COST_USD_AMT" ).append("\n"); 
		query.append("	,RPR_COST_USD_AMT" ).append("\n"); 
		query.append("	,PAY_USD_AMT" ).append("\n"); 
		query.append("	,CLM_HNDL_OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT H.STV_DMG_NO AS STV_DMG_NO," ).append("\n"); 
		query.append("           H.VSL_CD||H.SKD_VOY_NO||H.SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("           H.VPS_PORT_CD AS VPS_PORT_CD," ).append("\n"); 
		query.append("           TO_CHAR(H.STV_DMG_EVNT_DT,'YYYY-MM-DD') AS STV_DMG_EVNT_DT," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD01882'" ).append("\n"); 
		query.append("             AND    INTG_CD_VAL_CTNT = D.STV_DMG_PRT_CATE_CD ) AS STV_DMG_TP_CD," ).append("\n"); 
		query.append("           ROUND(SYSDATE - STV_DMG_EVNT_DT) AS ELAPSE_DAY," ).append("\n"); 
		query.append("           H.DMG_AUTH_STS_CD AS DMG_AUTH_STS_CD," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD01888'" ).append("\n"); 
		query.append("             AND    INTG_CD_VAL_CTNT = D.STV_DMG_REQ_CATE_CD ) AS STV_DMG_REQ_CATE_CD," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD01887'" ).append("\n"); 
		query.append("             AND    INTG_CD_VAL_CTNT = R.STV_DMG_RPR_PROC_STS_CD ) AS STV_DMG_RPR_PROC_STS_CD," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD01884'" ).append("\n"); 
		query.append("             AND    INTG_CD_VAL_CTNT = C.STV_DMG_CMPN_PROC_STS_CD ) AS STV_DMG_CMPN_PROC_STS_CD," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD01889'" ).append("\n"); 
		query.append("             AND    INTG_CD_VAL_CTNT = S.STV_DMG_STL_PROC_STS_CD ) AS STV_DMG_STL_PROC_STS_CD," ).append("\n"); 
		query.append("           D.REQ_PORT_CD AS REQ_PORT_CD," ).append("\n"); 
		query.append("           TO_CHAR(D.REQ_ETA_DT,'YYYY-MM-DD') AS REQ_ETA_DT" ).append("\n"); 
		query.append("			,R.QTTN_COST_USD_AMT" ).append("\n"); 
		query.append("            ,R.RPR_COST_USD_AMT" ).append("\n"); 
		query.append("            ,S.PAY_USD_AMT" ).append("\n"); 
		query.append("            ,H.CLM_HNDL_OFC_CD	" ).append("\n"); 
		query.append("    FROM   OPF_STV_DMG H,      OPF_STV_DMG_DTL D, OPF_STV_DMG_RPR R," ).append("\n"); 
		query.append("           OPF_STV_DMG_CMPN C, OPF_STV_DMG_STL S, VSK_VSL_SKD V" ).append("\n"); 
		query.append("    WHERE  H.VSL_CD      LIKE @[vvd_cd]||'%' " ).append("\n"); 
		query.append("    AND    H.STV_DMG_NO  = NVL(@[stv_dmg_no], H.STV_DMG_NO)" ).append("\n"); 
		query.append("    AND    H.STV_DMG_NO  = D.STV_DMG_NO(+)" ).append("\n"); 
		query.append("    AND    H.STV_DMG_NO  = R.STV_DMG_NO(+)" ).append("\n"); 
		query.append("    AND    NVL(R.STV_DMG_RPR_SEQ,0) = NVL(( SELECT MAX(STV_DMG_RPR_SEQ)" ).append("\n"); 
		query.append("                                            FROM   OPF_STV_DMG_RPR" ).append("\n"); 
		query.append("                                            WHERE  STV_DMG_NO = R.STV_DMG_NO ),0)" ).append("\n"); 
		query.append("    AND    H.STV_DMG_NO  = C.STV_DMG_NO(+)" ).append("\n"); 
		query.append("    AND    H.STV_DMG_NO  = S.STV_DMG_NO(+)" ).append("\n"); 
		query.append("    AND    H.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("    AND    H.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND    H.SKD_DIR_CD  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("    #if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("    AND    H.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${slan_cd} != '') " ).append("\n"); 
		query.append("    AND    V.VSL_SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_evnt_dt_from} != '') " ).append("\n"); 
		query.append("    AND    TO_CHAR(H.STV_DMG_EVNT_DT,'YYYYMMDD') BETWEEN REPLACE(@[stv_dmg_evnt_dt_from],'-')" ).append("\n"); 
		query.append("                                                 AND     REPLACE(@[stv_dmg_evnt_dt_to],'-')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${elapse_day} != '') " ).append("\n"); 
		query.append("    AND    TO_CHAR(H.STV_DMG_EVNT_DT,'YYYYMMDD') <=  TO_CHAR((SYSDATE - @[elapse_day]),'YYYYMMDD') " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_ref_no} != '') " ).append("\n"); 
		query.append("    AND    NVL(H.STV_DMG_REF_NO,' ')          = @[stv_dmg_ref_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_type_cd} != '' && ${vsl_type_cd} != 'All') " ).append("\n"); 
		query.append("    AND    NVL(H.VSL_OSHP_CNTR_BLK_TP_CD,' ') = @[vsl_type_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_req_cate_cd} != '' && ${stv_dmg_req_cate_cd} != 'All') " ).append("\n"); 
		query.append("    AND    NVL(D.STV_DMG_REQ_CATE_CD,' ')     = @[stv_dmg_req_cate_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_rpr_proc_sts_cd} != '' && ${stv_dmg_rpr_proc_sts_cd} != 'All')" ).append("\n"); 
		query.append("    AND    NVL(R.STV_DMG_RPR_PROC_STS_CD,'None') = @[stv_dmg_rpr_proc_sts_cd] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_cmpn_proc_sts_cd} != '' && ${stv_dmg_cmpn_proc_sts_cd} != 'All') " ).append("\n"); 
		query.append("    AND    NVL(C.STV_DMG_CMPN_PROC_STS_CD,'None')= @[stv_dmg_cmpn_proc_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_stl_proc_sts_cd} != '' && ${stv_dmg_stl_proc_sts_cd} != 'All') " ).append("\n"); 
		query.append("    AND    NVL(S.STV_DMG_STL_PROC_STS_CD,'None') = @[stv_dmg_stl_proc_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cmpn_cost_usd_amt} != '') " ).append("\n"); 
		query.append("    AND    (NVL(R.QTTN_COST_USD_AMT,0) >= @[cmpn_cost_usd_amt] OR NVL(R.RPR_COST_USD_AMT,0) >= @[cmpn_cost_usd_amt]) " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    --ORDER BY ELAPSE_DAY, STV_DMG_NO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT H.STV_DMG_NO AS STV_DMG_NO," ).append("\n"); 
		query.append("           H.VSL_CD||H.SKD_VOY_NO||H.SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("           H.VPS_PORT_CD AS VPS_PORT_CD," ).append("\n"); 
		query.append("           TO_CHAR(H.STV_DMG_EVNT_DT,'YYYY-MM-DD') AS STV_DMG_EVNT_DT," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD01882'" ).append("\n"); 
		query.append("             AND    INTG_CD_VAL_CTNT = D.STV_DMG_PRT_CATE_CD ) AS STV_DMG_TP_CD," ).append("\n"); 
		query.append("           ROUND(SYSDATE - STV_DMG_EVNT_DT) AS ELAPSE_DAY," ).append("\n"); 
		query.append("           H.DMG_AUTH_STS_CD AS DMG_AUTH_STS_CD," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD01888'" ).append("\n"); 
		query.append("             AND    INTG_CD_VAL_CTNT = D.STV_DMG_REQ_CATE_CD ) AS STV_DMG_REQ_CATE_CD," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD01887'" ).append("\n"); 
		query.append("             AND    INTG_CD_VAL_CTNT = R.STV_DMG_RPR_PROC_STS_CD ) AS STV_DMG_RPR_PROC_STS_CD," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD01884'" ).append("\n"); 
		query.append("             AND    INTG_CD_VAL_CTNT = C.STV_DMG_CMPN_PROC_STS_CD ) AS STV_DMG_CMPN_PROC_STS_CD," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD01889'" ).append("\n"); 
		query.append("             AND    INTG_CD_VAL_CTNT = S.STV_DMG_STL_PROC_STS_CD ) AS STV_DMG_STL_PROC_STS_CD," ).append("\n"); 
		query.append("           D.REQ_PORT_CD AS REQ_PORT_CD," ).append("\n"); 
		query.append("           TO_CHAR(D.REQ_ETA_DT,'YYYY-MM-DD') AS REQ_ETA_DT" ).append("\n"); 
		query.append("			,R.QTTN_COST_USD_AMT" ).append("\n"); 
		query.append("            ,R.RPR_COST_USD_AMT" ).append("\n"); 
		query.append("            ,S.PAY_USD_AMT" ).append("\n"); 
		query.append("            ,H.CLM_HNDL_OFC_CD	" ).append("\n"); 
		query.append("    FROM   OPF_STV_DMG H,      OPF_STV_DMG_DTL D, OPF_STV_DMG_RPR R," ).append("\n"); 
		query.append("           OPF_STV_DMG_CMPN C, OPF_STV_DMG_STL S, AR_MST_REV_VVD A" ).append("\n"); 
		query.append("    WHERE  H.VSL_CD      LIKE @[vvd_cd]||'%' " ).append("\n"); 
		query.append("    AND    H.STV_DMG_NO  = NVL(@[stv_dmg_no], H.STV_DMG_NO)" ).append("\n"); 
		query.append("    AND    H.STV_DMG_NO  = D.STV_DMG_NO(+)" ).append("\n"); 
		query.append("    AND    H.STV_DMG_NO  = R.STV_DMG_NO(+)" ).append("\n"); 
		query.append("    AND    NVL(R.STV_DMG_RPR_SEQ,0) = NVL(( SELECT MAX(STV_DMG_RPR_SEQ)" ).append("\n"); 
		query.append("                                            FROM   OPF_STV_DMG_RPR" ).append("\n"); 
		query.append("                                            WHERE  STV_DMG_NO = R.STV_DMG_NO ),0)" ).append("\n"); 
		query.append("    AND    H.STV_DMG_NO  = C.STV_DMG_NO(+)" ).append("\n"); 
		query.append("    AND    H.STV_DMG_NO  = S.STV_DMG_NO(+)" ).append("\n"); 
		query.append("    AND    H.VSL_CD      = A.VSL_CD" ).append("\n"); 
		query.append("    AND    H.SKD_VOY_NO  = A.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND    H.SKD_DIR_CD  = A.SKD_DIR_CD" ).append("\n"); 
		query.append("    #if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("    AND    H.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${slan_cd} != '') " ).append("\n"); 
		query.append("    AND    A.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_evnt_dt_from} != '') " ).append("\n"); 
		query.append("    AND    TO_CHAR(H.STV_DMG_EVNT_DT,'YYYYMMDD') BETWEEN REPLACE(@[stv_dmg_evnt_dt_from], '-')" ).append("\n"); 
		query.append("                                                 AND     REPLACE(@[stv_dmg_evnt_dt_to], '-')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${elapse_day} != '') " ).append("\n"); 
		query.append("    AND    TO_CHAR(H.STV_DMG_EVNT_DT,'YYYYMMDD') <=  TO_CHAR((SYSDATE - @[elapse_day]),'YYYYMMDD') " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_ref_no} != '') " ).append("\n"); 
		query.append("    AND    NVL(H.STV_DMG_REF_NO,' ')          = @[stv_dmg_ref_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_type_cd} != '' && ${vsl_type_cd} != 'All') " ).append("\n"); 
		query.append("    AND    NVL(H.VSL_OSHP_CNTR_BLK_TP_CD,' ') = @[vsl_type_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_req_cate_cd} != '' && ${stv_dmg_req_cate_cd} != 'All') " ).append("\n"); 
		query.append("    AND    NVL(D.STV_DMG_REQ_CATE_CD,' ')     = @[stv_dmg_req_cate_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_rpr_proc_sts_cd} != '' && ${stv_dmg_rpr_proc_sts_cd} != 'All')" ).append("\n"); 
		query.append("    AND    NVL(R.STV_DMG_RPR_PROC_STS_CD,'None') = @[stv_dmg_rpr_proc_sts_cd] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_cmpn_proc_sts_cd} != '' && ${stv_dmg_cmpn_proc_sts_cd} != 'All') " ).append("\n"); 
		query.append("    AND    NVL(C.STV_DMG_CMPN_PROC_STS_CD,'None')= @[stv_dmg_cmpn_proc_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stv_dmg_stl_proc_sts_cd} != '' && ${stv_dmg_stl_proc_sts_cd} != 'All') " ).append("\n"); 
		query.append("    AND    NVL(S.STV_DMG_STL_PROC_STS_CD,'None') = @[stv_dmg_stl_proc_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cmpn_cost_usd_amt} != '') " ).append("\n"); 
		query.append("    AND    (NVL(R.QTTN_COST_USD_AMT,0) >= @[cmpn_cost_usd_amt] OR NVL(R.RPR_COST_USD_AMT,0) >= @[cmpn_cost_usd_amt]) " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    --ORDER BY ELAPSE_DAY, STV_DMG_NO " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY ELAPSE_DAY, STV_DMG_NO" ).append("\n"); 

	}
}