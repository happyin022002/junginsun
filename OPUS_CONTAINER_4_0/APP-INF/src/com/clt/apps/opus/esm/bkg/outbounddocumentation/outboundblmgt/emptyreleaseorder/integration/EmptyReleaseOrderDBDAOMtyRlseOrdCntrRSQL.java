/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOMtyRlseOrdCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOMtyRlseOrdCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseOrderDBDAOMtyRlseOrdCntrRSQL
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOMtyRlseOrdCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration").append("\n"); 
		query.append("FileName : EmptyReleaseOrderDBDAOMtyRlseOrdCntrRSQL").append("\n"); 
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
		query.append("SELECT BB.BKG_NO" ).append("\n"); 
		query.append("       ,BC.CNTR_NO" ).append("\n"); 
		query.append("       ,BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,REPLACE(bkg_join_fnc(CURSOR(SELECT SEAL.CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO SEAL WHERE SEAL.BKG_NO = BC.BKG_NO AND SEAL.CNTR_NO = BC.CNTR_NO ORDER BY SEAL.CNTR_SEAL_SEQ DESC)),',',' ') SEAL_NO" ).append("\n"); 
		query.append("       ,BC.RC_FLG" ).append("\n"); 
		query.append("       ,BC.DCGO_FLG" ).append("\n"); 
		query.append("       ,BC.AWK_CGO_FLG" ).append("\n"); 
		query.append("       ,BC.BB_CGO_FLG" ).append("\n"); 
		query.append("       ,BC.SOC_FLG" ).append("\n"); 
		query.append("       ,BC.CNTR_WGT" ).append("\n"); 
		query.append("       ,BC.WGT_UT_CD" ).append("\n"); 
		query.append("       ,RF.CMDT_CD" ).append("\n"); 
		query.append("       ,REPLACE(RF.CMDT_DESC,',',' ') CMDT_DESC" ).append("\n"); 
		query.append("       ,RF.NET_WGT" ).append("\n"); 
		query.append("       ,RF.GRS_WGT" ).append("\n"); 
		query.append("       ,RF.WGT_UT_CD AS WGT_UT_CD1" ).append("\n"); 
		query.append("       ,'F' TEMP_UF" ).append("\n"); 
		query.append("       ,RF.FDO_TEMP" ).append("\n"); 
		query.append("       ,'C' TEMP_UC" ).append("\n"); 
		query.append("       ,RF.CDO_TEMP" ).append("\n"); 
		query.append("       ,RF.VLTG_NO" ).append("\n"); 
		query.append("       ,RF.CNTR_VENT_TP_CD" ).append("\n"); 
		query.append("       ,DECODE(RF.CNTR_VENT_TP_CD,'P',RF.VENT_RTO,NULL) AS VENT_RTO" ).append("\n"); 
		query.append("       ,DECODE(RF.CNTR_VENT_TP_CD,'C',CBM_PER_HR_QTY,NULL) AS VENT_CMH" ).append("\n"); 
		query.append("       ,RF.HUMID_NO" ).append("\n"); 
		query.append("       ,RF.PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append("       ,REPLACE(REPLACE(REPLACE(RF.DIFF_RMK, CHR(10), ' '), CHR(13), ' '),',',' ') AS DIFF_RMK" ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(BC.CNTR_TPSZ_CD,1,1)||BC.RC_FLG,'RN','Y','N') AS RF_DRY" ).append("\n"); 
		query.append("       ,RF.CNTR_DRN_CD AS RF_DRAIN" ).append("\n"); 
		query.append("       ,AWK.OVR_FWRD_LEN" ).append("\n"); 
		query.append("       ,AWK.OVR_BKWD_LEN" ).append("\n"); 
		query.append("       ,AWK.OVR_HGT" ).append("\n"); 
		query.append("       ,AWK.OVR_LF_LEN" ).append("\n"); 
		query.append("       ,AWK.OVR_RT_LEN" ).append("\n"); 
		query.append("	   ,BC.CNMV_STS_CD AS MOVE_STS" ).append("\n"); 
		query.append("       ,(SELECT CM.ORG_YD_CD FROM CTM_MOVEMENT CM WHERE CM.CNTR_NO = BC.CNTR_NO AND CM.CNMV_YR = BC.CNMV_YR AND CM.CNMV_ID_NO = BC.CNMV_ID_NO AND CM.CNMV_CYC_NO = BC.CNMV_CYC_NO) AS EVENT_YARD" ).append("\n"); 
		query.append("       ,TO_CHAR(BC.CNMV_EVNT_DT,'YYYYMMDDHH24MISS') AS EVENT_TIME" ).append("\n"); 
		query.append("	   ,BC.VGM_WGT" ).append("\n"); 
		query.append(" 	   ,NVL(BC.VGM_WGT_UT_CD, ' ') AS VGM_WGT_UT_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,BKG_CONTAINER BC" ).append("\n"); 
		query.append("     ,BKG_RF_CGO RF" ).append("\n"); 
		query.append("     ,BKG_AWK_CGO AWK" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND NVL(BB.EDI_HLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("--AND BB.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("AND BC.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND BC.BKG_NO = AWK.BKG_NO(+)" ).append("\n"); 
		query.append("AND BC.CNTR_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("AND BC.CNTR_NO = AWK.CNTR_NO(+)" ).append("\n"); 
		query.append("#if (${datetype} == 'FTP')" ).append("\n"); 
		query.append("    AND BB.BKG_CRE_DT > SYSDATE -61" ).append("\n"); 
		query.append("    AND BB.BKG_OFC_CD = UPPER(@[bkg_ofc_cd])" ).append("\n"); 
		query.append("    AND (EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("    			FROM BKG_HIS_MST BHM" ).append("\n"); 
		query.append("                WHERE BHM.CRE_DT BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi:ss') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi:ss')" ).append("\n"); 
		query.append("    			AND BHM.BKG_HIS_ISS_UI_ID IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'BKG_LDF_UI')" ).append("\n"); 
		query.append("                AND BB.BKG_NO = BHM.BKG_NO)" ).append("\n"); 
		query.append("      		OR EXISTS (SELECT 'X' FROM SCG_AUTHORIZATION SA WHERE SA.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                AND SA.SPCL_CGO_AUTH_CD = 'Y' " ).append("\n"); 
		query.append("                AND   SA.UPD_DT BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi:ss') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi:ss')) " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--	AND   BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("    #if (${from_dt} != '')" ).append("\n"); 
		query.append("      #if (${datetype} == 'BKG')" ).append("\n"); 
		query.append("         AND BB.BKG_CRE_DT  BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("      #elseif(${datetype} == 'PUP')" ).append("\n"); 
		query.append("         AND BB.MTY_PKUP_DT BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_ofc_cd}!='')" ).append("\n"); 
		query.append("       AND BB.BKG_OFC_CD = UPPER(@[bkg_ofc_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${doc_usr_id}!='')" ).append("\n"); 
		query.append("       AND UPPER(BB.DOC_USR_ID)  = UPPER(@[doc_usr_id])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_ctrl_ofc_cd}!='')" ).append("\n"); 
		query.append("       AND BB.EQ_CTRL_OFC_CD = UPPER(@[eq_ctrl_ofc_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd} !='')" ).append("\n"); 
		query.append("       AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM BKG_VVD VVD " ).append("\n"); 
		query.append("                   WHERE BB.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND   VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD = UPPER(substr(@[vvd],0,4))" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO = UPPER(substr(@[vvd],5,4))" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD = UPPER(substr(@[vvd],9,1))" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${por_cd} !='')" ).append("\n"); 
		query.append("       AND BB.POR_CD   = UPPER(@[por_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} !='')" ).append("\n"); 
		query.append("       AND BB.POL_CD   = UPPER(@[pol_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd}!='')" ).append("\n"); 
		query.append("       AND BB.POD_CD   = UPPER(@[pod_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${mty_pkup_yd_cd}!='')" ).append("\n"); 
		query.append("       AND BB.MTY_PKUP_YD_CD = UPPER(@[mty_pkup_yd_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${full_rtn_yd_cd}!='')" ).append("\n"); 
		query.append("       AND BB.FULL_RTN_YD_CD = UPPER(@[full_rtn_yd_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_no}!='')" ).append("\n"); 
		query.append("       AND BB.BKG_NO   = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_confirm}=='Y')" ).append("\n"); 
		query.append("       AND EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BB.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_confirm}=='N')" ).append("\n"); 
		query.append("       AND NOT EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BB.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BB.BKG_NO" ).append("\n"); 
		query.append("       ,'' CNTR_NO" ).append("\n"); 
		query.append("       ,'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,'' SEAL_NO" ).append("\n"); 
		query.append("       ,'Y' RC_FLG" ).append("\n"); 
		query.append("       ,'' DCGO_FLG" ).append("\n"); 
		query.append("       ,'' AWK_CGO_FLG" ).append("\n"); 
		query.append("       ,'' BB_CGO_FLG" ).append("\n"); 
		query.append("       ,'' SOC_FLG" ).append("\n"); 
		query.append("       ,RF.GRS_WGT CNTR_WGT" ).append("\n"); 
		query.append("       ,RF.WGT_UT_CD WGT_UT_CD" ).append("\n"); 
		query.append("       ,RF.CMDT_CD" ).append("\n"); 
		query.append("       ,REPLACE(RF.CMDT_DESC,',',' ') CMDT_DESC" ).append("\n"); 
		query.append("       ,RF.NET_WGT" ).append("\n"); 
		query.append("       ,RF.GRS_WGT" ).append("\n"); 
		query.append("       ,RF.WGT_UT_CD AS WGT_UT_CD1" ).append("\n"); 
		query.append("       ,'F' TEMP_UF" ).append("\n"); 
		query.append("       ,RF.FDO_TEMP" ).append("\n"); 
		query.append("       ,'C' TEMP_UC" ).append("\n"); 
		query.append("       ,RF.CDO_TEMP" ).append("\n"); 
		query.append("       ,RF.VLTG_NO" ).append("\n"); 
		query.append("       ,RF.CNTR_VENT_TP_CD" ).append("\n"); 
		query.append("       ,DECODE(RF.CNTR_VENT_TP_CD,'P',RF.VENT_RTO,NULL) AS VENT_RTO" ).append("\n"); 
		query.append("       ,DECODE(RF.CNTR_VENT_TP_CD,'C',CBM_PER_HR_QTY,NULL) AS VENT_CMH" ).append("\n"); 
		query.append("       ,RF.HUMID_NO" ).append("\n"); 
		query.append("       ,RF.PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append("       ,REPLACE(REPLACE(REPLACE(RF.DIFF_RMK, CHR(10), ' '), CHR(13), ' '),',',' ') AS DIFF_RMK" ).append("\n"); 
		query.append("       ,'N' AS RF_DRY" ).append("\n"); 
		query.append("       ,RF.CNTR_DRN_CD AS RF_DRAIN" ).append("\n"); 
		query.append("       ,null OVR_FWRD_LEN" ).append("\n"); 
		query.append("       ,null OVR_BKWD_LEN" ).append("\n"); 
		query.append("       ,null OVR_HGT" ).append("\n"); 
		query.append("       ,null OVR_LF_LEN" ).append("\n"); 
		query.append("       ,null OVR_RT_LEN" ).append("\n"); 
		query.append("	   ,'' AS MOVE_STS" ).append("\n"); 
		query.append("       ,'' AS EVENT_YARD" ).append("\n"); 
		query.append("       ,'' AS EVENT_TIME" ).append("\n"); 
		query.append("	   ,null AS VGM_WGT" ).append("\n"); 
		query.append(" 	   ,' ' AS VGM_WGT_UT_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,BKG_RF_CGO RF" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = RF.BKG_NO" ).append("\n"); 
		query.append("AND NVL(BB.EDI_HLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("--AND BB.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("AND RF.CNTR_NO IS NULL" ).append("\n"); 
		query.append("#if (${datetype} == 'FTP')" ).append("\n"); 
		query.append("    AND BB.BKG_CRE_DT > SYSDATE -61" ).append("\n"); 
		query.append("    AND BB.BKG_OFC_CD = UPPER(@[bkg_ofc_cd])" ).append("\n"); 
		query.append("    AND (EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("    			FROM BKG_HIS_MST BHM" ).append("\n"); 
		query.append("                WHERE BHM.CRE_DT BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi:ss') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi:ss')" ).append("\n"); 
		query.append("    			AND BHM.BKG_HIS_ISS_UI_ID IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'BKG_LDF_UI')" ).append("\n"); 
		query.append("                AND BB.BKG_NO = BHM.BKG_NO)" ).append("\n"); 
		query.append("      OR EXISTS (SELECT 'X' FROM SCG_AUTHORIZATION SA WHERE SA.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                AND   SA.CRE_DT BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi:ss') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi:ss'))" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--	AND   BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("    #if (${from_dt} != '')" ).append("\n"); 
		query.append("      #if (${datetype} == 'BKG')" ).append("\n"); 
		query.append("         AND BB.BKG_CRE_DT  BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("      #elseif(${datetype} == 'PUP')" ).append("\n"); 
		query.append("         AND BB.MTY_PKUP_DT BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_ofc_cd}!='')" ).append("\n"); 
		query.append("       AND BB.BKG_OFC_CD = UPPER(@[bkg_ofc_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${doc_usr_id}!='')" ).append("\n"); 
		query.append("       AND UPPER(BB.DOC_USR_ID)  = UPPER(@[doc_usr_id])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_ctrl_ofc_cd}!='')" ).append("\n"); 
		query.append("       AND BB.EQ_CTRL_OFC_CD = UPPER(@[eq_ctrl_ofc_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd} !='')" ).append("\n"); 
		query.append("       AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM BKG_VVD VVD " ).append("\n"); 
		query.append("                   WHERE BB.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND   VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD = UPPER(substr(@[vvd],0,4))" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO = UPPER(substr(@[vvd],5,4))" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD = UPPER(substr(@[vvd],9,1))" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${por_cd} !='')" ).append("\n"); 
		query.append("       AND BB.POR_CD   = UPPER(@[por_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} !='')" ).append("\n"); 
		query.append("       AND BB.POL_CD   = UPPER(@[pol_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd}!='')" ).append("\n"); 
		query.append("       AND BB.POD_CD   = UPPER(@[pod_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${mty_pkup_yd_cd}!='')" ).append("\n"); 
		query.append("       AND BB.MTY_PKUP_YD_CD = UPPER(@[mty_pkup_yd_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${full_rtn_yd_cd}!='')" ).append("\n"); 
		query.append("       AND BB.FULL_RTN_YD_CD = UPPER(@[full_rtn_yd_cd])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bkg_no}!='')" ).append("\n"); 
		query.append("       AND BB.BKG_NO   = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_confirm}=='Y')" ).append("\n"); 
		query.append("       AND EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BB.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_confirm}=='N')" ).append("\n"); 
		query.append("       AND NOT EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BB.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 

	}
}