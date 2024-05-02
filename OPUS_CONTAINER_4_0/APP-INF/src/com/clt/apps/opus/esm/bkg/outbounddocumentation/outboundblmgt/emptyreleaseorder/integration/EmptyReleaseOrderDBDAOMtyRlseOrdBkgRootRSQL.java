/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOMtyRlseOrdBkgRootRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.09 
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

public class EmptyReleaseOrderDBDAOMtyRlseOrdBkgRootRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseOrderDBDAOMtyRlseOrdBkgRootRSQL
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOMtyRlseOrdBkgRootRSQL(){
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
		query.append("FileName : EmptyReleaseOrderDBDAOMtyRlseOrdBkgRootRSQL").append("\n"); 
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
		query.append("SELECT    " ).append("\n"); 
		query.append("		BB.BKG_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(BB.BKG_CRE_DT,'YYYYMMDDHH24MISS') AS BKG_CRE_DT" ).append("\n"); 
		query.append("        ,DECODE(BB.BKG_STS_CD,'X','X',(SELECT DECODE(COUNT(*),0,'N','U') FROM BKG_HIS_MST BHM WHERE BHM.BKG_NO = BB.BKG_NO AND BHM.HIS_SEQ > 1)) AS Status" ).append("\n"); 
		query.append("        ,BB.SLAN_CD" ).append("\n"); 
		query.append("        ,VVD1.SLAN_CD AS SLAN_CD1" ).append("\n"); 
		query.append("        ,VVD1.VSL_CD" ).append("\n"); 
		query.append("        ,VSL.LLOYD_NO AS VVD_LLOYD_No" ).append("\n"); 
		query.append("        ,REPLACE(VSL.VSL_ENG_NM,',',' ') AS VSL_ENG_NM" ).append("\n"); 
		query.append("        ,VSL.CALL_SGN_NO AS VVD_Call_Sign" ).append("\n"); 
		query.append("        ,VVD1.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,VVD1.SKD_DIR_CD" ).append("\n"); 
		query.append("		,VSK_COMMON_PKG.GET_CSSM_VOY_NO_FNC(VVD1.VSL_CD,VVD1.SKD_VOY_NO,VVD1.SKD_DIR_CD,VVD1.POL_CD,'O') AS CONS_VOY" ).append("\n"); 
		query.append("        ,TO_CHAR(VSK1.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS VPS_ETD_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(VSK2.VPS_ETA_DT,'YYYYMMDDHH24MISS') AS VPS_ETA_DT" ).append("\n"); 
		query.append("        ,BB.VSL_CD AS VSL_CD1" ).append("\n"); 
		query.append("        ,TVSL.LLOYD_NO AS Trunk_Vessel_LLOYD_No" ).append("\n"); 
		query.append("        ,REPLACE(TVSL.VSL_ENG_NM,',',' ') AS VSL_ENG_NM1" ).append("\n"); 
		query.append("        ,TVSL.CALL_SGN_NO AS Trunk_Vessel_Call_Sign" ).append("\n"); 
		query.append("        ,BB.SKD_VOY_NO AS SKD_VOY_NO1" ).append("\n"); 
		query.append("        ,BB.SKD_DIR_CD AS SKD_DIR_CD_T" ).append("\n"); 
		query.append("        ,REPLACE(POR.LOC_NM,',',' ') AS LOC_NM" ).append("\n"); 
		query.append("        ,BB.POR_CD AS POR_OPSCODE" ).append("\n"); 
		query.append("        ,POR.UN_LOC_CD" ).append("\n"); 
		query.append("        ,BB.POR_NOD_CD" ).append("\n"); 
		query.append("        ,REPLACE(POL.LOC_NM,',',' ') AS LOC_NM1" ).append("\n"); 
		query.append("        ,POL.UN_LOC_CD AS UN_LOC_CD1" ).append("\n"); 
		query.append("        ,BB.POL_NOD_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(VSK1.VPS_ETA_DT,'YYYYMMDDHH24MISS') AS VPS_ETA_DT1" ).append("\n"); 
		query.append("        ,TO_CHAR(VSK2.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS VPS_ETD_DT1" ).append("\n"); 
		query.append("        ,(SELECT to_char(NVL(CLZ.MNL_SET_DT,CLZ.SYS_SET_DT) , 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                         FROM BKG_CLZ_TM CLZ " ).append("\n"); 
		query.append("                         WHERE CLZ.BKG_NO = BB.BKG_NO AND CLZ.CLZ_TP_CD = 'T' " ).append("\n"); 
		query.append("                         AND ROWNUM = 1) AS CUT_OFF_TIME_FIRST_POL" ).append("\n"); 
		query.append("        ,REPLACE(POD.LOC_NM,',',' ') AS LOC_NM2" ).append("\n"); 
		query.append("        ,POD.UN_LOC_CD AS UN_LOC_CD2" ).append("\n"); 
		query.append("        ,BB.DEL_CD AS DEL_OPUS_CODE" ).append("\n"); 
		query.append("        ,REPLACE(DEL.LOC_NM,',',' ') AS LOC_NM3" ).append("\n"); 
		query.append("        ,DEL.UN_LOC_CD AS UN_LOC_CD3" ).append("\n"); 
		query.append("        ,BB.RCV_TERM_CD||BB.DE_TERM_CD AS RCV_TERM_CD" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE(BB.XTER_RMK, CHR(10), ' '), CHR(13), ' '),',',' ') AS XTER_RMK" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE(BB.VNDR_RMK, CHR(10), ' '), CHR(13), ' '),',',' ') AS VNDR_RMK" ).append("\n"); 
		query.append("        ,BB.CMDT_CD" ).append("\n"); 
		query.append("        ,REPLACE(MC.CMDT_NM,',',' ') CMDT_NM" ).append("\n"); 
		query.append("        ,BB.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("        ,(SELECT REPLACE(REPLACE(REPLACE(MC.CUST_LGL_ENG_NM, CHR(10), ' '), CHR(13), ' '),',',' ') FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = BCS.CUST_CNT_CD AND MC.CUST_SEQ = BCS.CUST_SEQ) AS CUST_NM" ).append("\n"); 
		query.append("        ,(SELECT REPLACE(REPLACE(REPLACE(MC.CUST_LGL_ENG_NM, CHR(10), ' '), CHR(13), ' '),',',' ') FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = BCF.CUST_CNT_CD AND MC.CUST_SEQ = BCF.CUST_SEQ) AS CUST_NM1" ).append("\n"); 
		query.append("		,(SELECT REPLACE(REPLACE(REPLACE(MC.CUST_LGL_ENG_NM, CHR(10), ' '), CHR(13), ' '),',',' ') FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = BCC.CUST_CNT_CD AND MC.CUST_SEQ = BCC.CUST_SEQ) AS CUST_NM2" ).append("\n"); 
		query.append("        ,BCS.CUST_CNT_CD||BCS.CUST_SEQ AS CUST_CNT_CD1" ).append("\n"); 
		query.append("        ,BCF.CUST_CNT_CD||BCF.CUST_SEQ AS CUST_CNT_CD2" ).append("\n"); 
		query.append("        ,BCC.CUST_CNT_CD||BCC.CUST_SEQ AS CUST_CNT_CD3" ).append("\n"); 
		query.append("        ,BB.BKG_STS_CD" ).append("\n"); 
		query.append("        ,BB.RD_CGO_FLG " ).append("\n"); 
		query.append("        ,BB.RC_FLG" ).append("\n"); 
		query.append("        ,BB.AWK_CGO_FLG" ).append("\n"); 
		query.append("        ,BB.BB_CGO_FLG" ).append("\n"); 
		query.append("        ,BB.HNGR_FLG" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE(DECODE(LENGTH((SELECT trim(BSC.STWG_RMK) FROM BKG_STWG_CGO BSC WHERE BSC.BKG_NO = BB.BKG_NO AND ROWNUM = 1)),0,'N',null,'N','Y'), CHR(10), ' '), CHR(13), ' '),',',' ') AS STWG_RMK" ).append("\n"); 
		query.append("        ,(SELECT BSC.STWG_CD FROM BKG_STWG_CGO BSC WHERE BSC.BKG_NO = BB.BKG_NO AND ROWNUM = 1) AS STWG_CD" ).append("\n"); 
		query.append("        ,BB.BKG_OFC_CD" ).append("\n"); 
		query.append("        ,(SELECT REPLACE(BCP.CNTC_PSON_NM,',',' ') FROM BKG_CNTC_PSON BCP WHERE BB.BKG_NO = BCP.BKG_NO AND BCP.BKG_CNTC_PSON_TP_CD = 'BK' AND ROWNUM = 1) AS BKG_CONTACT_POINT" ).append("\n"); 
		query.append("        ,BB.TWN_SO_NO" ).append("\n"); 
		query.append("        ,BB.BLCK_STWG_CD" ).append("\n"); 
		query.append("        ,to_char(BB.MTY_PKUP_DT, 'YYYYMMDDHH24MISS') AS MTY_PKUP_DATE" ).append("\n"); 
		query.append("        ,(select to_char(COALESCE(mnl_set_dt, sys_set_dt, BB.mty_pkup_dt), 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("            from bkg_clz_tm clz" ).append("\n"); 
		query.append("           where clz.bkg_no = BB.bkg_no" ).append("\n"); 
		query.append("             and CLZ_TP_CD = 'R') AS MTY_PKUP_DATE1" ).append("\n"); 
		query.append("        ,SUBSTR(BB.MTY_PKUP_YD_CD,1,2) AS MTY_PKUP_YD_CD_T" ).append("\n"); 
		query.append("        ,(SELECT REPLACE(MY.YD_NM,',',' ') FROM MDM_YARD MY WHERE MY.YD_CD = BB.MTY_PKUP_YD_CD AND ROWNUM = 1) AS FULL_RETURN_YARD_COUNTRY" ).append("\n"); 
		query.append("        ,SUBSTR(BB.FULL_RTN_YD_CD,1,2) AS FULL_RTN_YD_CD" ).append("\n"); 
		query.append("        ,(SELECT REPLACE(MY.YD_NM,',',' ') FROM MDM_YARD MY WHERE MY.YD_CD = BB.FULL_RTN_YD_CD AND ROWNUM = 1) AS FULL_RETURN_YARD_NAME" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(REPLACE((SELECT BSC.STWG_RMK FROM BKG_STWG_CGO BSC WHERE BSC.BKG_NO = BB.BKG_NO AND ROWNUM = 1), CHR(10), ' '), CHR(13), ' '),',',' ') AS STOW_REMARK" ).append("\n"); 
		query.append("        ,(select REPLACE(cust_ref_no_ctnt,',',' ') from bkg_reference refNo where BB.bkg_no = refNo.bkg_no and bkg_ref_tp_cd = 'XMRN') AS cust_ref_no_ctnt" ).append("\n"); 
		query.append("        ,BB.SC_NO" ).append("\n"); 
		query.append("        ,BB.RFA_NO" ).append("\n"); 
		query.append("        ,NVL(BB.TAA_NO, ' ') AS TAA_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,BKG_VVD VVD1" ).append("\n"); 
		query.append("     ,MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("     ,MDM_VSL_CNTR TVSL" ).append("\n"); 
		query.append("     ,VSK_VSL_PORT_SKD VSK1" ).append("\n"); 
		query.append("     ,VSK_VSL_PORT_SKD VSK2" ).append("\n"); 
		query.append("     ,MDM_LOCATION POR" ).append("\n"); 
		query.append("     ,MDM_LOCATION POL" ).append("\n"); 
		query.append("     ,MDM_LOCATION POD" ).append("\n"); 
		query.append("     ,MDM_LOCATION DEL" ).append("\n"); 
		query.append("     ,MDM_COMMODITY MC" ).append("\n"); 
		query.append("     ,BKG_CUSTOMER BCS" ).append("\n"); 
		query.append("     ,BKG_CUSTOMER BCC" ).append("\n"); 
		query.append("     ,BKG_CUSTOMER BCF" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = VVD1.BKG_NO" ).append("\n"); 
		query.append("AND BB.POL_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("AND NVL(BB.EDI_HLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("--AND BB.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("AND VVD1.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("AND VVD1.VSL_CD = VSK1.VSL_CD(+)" ).append("\n"); 
		query.append("AND VVD1.SKD_VOY_NO = VSK1.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND VVD1.SKD_DIR_CD = VSK1.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND VVD1.POL_CD = VSK1.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND VVD1.POL_CLPT_IND_SEQ = VSK1.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("AND VVD1.VSL_CD = VSK2.VSL_CD(+)" ).append("\n"); 
		query.append("AND VVD1.SKD_VOY_NO = VSK2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND VVD1.SKD_DIR_CD = VSK2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND VVD1.POD_CD = VSK2.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND VVD1.POD_CLPT_IND_SEQ = VSK2.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("AND BB.VSL_CD = TVSL.VSL_CD(+)" ).append("\n"); 
		query.append("AND BB.POR_CD = POR.LOC_CD" ).append("\n"); 
		query.append("AND BB.POL_CD = POL.LOC_CD" ).append("\n"); 
		query.append("AND BB.POD_CD = POD.LOC_CD" ).append("\n"); 
		query.append("AND BB.DEL_CD = DEL.LOC_CD" ).append("\n"); 
		query.append("AND BB.CMDT_CD = MC.CMDT_CD" ).append("\n"); 
		query.append("AND BB.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND BB.BKG_NO = BCC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BCC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND BB.BKG_NO = BCF.BKG_NO(+)" ).append("\n"); 
		query.append("AND BCF.BKG_CUST_TP_CD(+) = 'F'" ).append("\n"); 
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
		query.append("    ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("ORDER BY BB.BKG_NO" ).append("\n"); 

	}
}