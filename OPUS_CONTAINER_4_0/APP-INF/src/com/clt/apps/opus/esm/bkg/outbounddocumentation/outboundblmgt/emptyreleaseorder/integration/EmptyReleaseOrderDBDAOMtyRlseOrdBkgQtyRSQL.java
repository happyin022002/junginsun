/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOMtyRlseOrdBkgQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.05.19 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOMtyRlseOrdBkgQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseOrderDBDAOMtyRlseOrdBkgQtyRSQL
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOMtyRlseOrdBkgQtyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration").append("\n"); 
		query.append("FileName : EmptyReleaseOrderDBDAOMtyRlseOrdBkgQtyRSQL").append("\n"); 
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
		query.append("       ,CASE WHEN BB.SPLIT_FLG = 'Y' AND BB.BKG_CRE_TP_CD = 'S' THEN BB.FM_BKG_NO END MASTER_BKG" ).append("\n"); 
		query.append("       ,BQ.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,TS.CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("       ,BQ.OP_CNTR_QTY" ).append("\n"); 
		query.append("       ,DECODE(NVL(BQ.SOC_QTY,0),0,'N','Y') SOC_IND" ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,1,1)||SUBSTR(BQ.EQ_SUBST_CNTR_TPSZ_CD,1,1),'RD','Y','N') EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	   ,BQ.CRR_HNGR_SGL_BAR_QTY AS CHS_S" ).append("\n"); 
		query.append("       ,BQ.CRR_HNGR_DBL_BAR_QTY AS CHS_D" ).append("\n"); 
		query.append("       ,BQ.CRR_HNGR_TPL_BAR_QTY AS CHS_T" ).append("\n"); 
		query.append("       ,BQ.MER_HNGR_QTY AS MHG" ).append("\n"); 
		query.append("       ,(SELECT NVL(SUBSTR(BHD.HIS_CATE_NM,1,1), ' ')" ).append("\n"); 
		query.append("           FROM BKG_HIS_DTL BHD" ).append("\n"); 
		query.append("          WHERE BHD.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("            AND BHD.HIS_CATE_NM IN ('SPLIT','COMBINE')" ).append("\n"); 
		query.append("            AND BHD.HIS_SEQ||BHD.HIS_DTL_SEQ = (SELECT MAX(BHDM.HIS_SEQ||BHDM.HIS_DTL_SEQ) FROM BKG_HIS_DTL BHDM WHERE BHDM.BKG_NO = BHD.BKG_NO AND BHDM.HIS_CATE_NM IN ('SPLIT','COMBINE'))" ).append("\n"); 
		query.append("            AND ROWNUM = 1) AS SPILT_COMBINE" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,BKG_QUANTITY BQ" ).append("\n"); 
		query.append("     ,MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("AND   BQ.CNTR_TPSZ_CD = TS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND NVL(BB.EDI_HLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("--AND BB.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
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
		query.append("    " ).append("\n"); 
		query.append("ORDER BY BB.BKG_NO" ).append("\n"); 

	}
}