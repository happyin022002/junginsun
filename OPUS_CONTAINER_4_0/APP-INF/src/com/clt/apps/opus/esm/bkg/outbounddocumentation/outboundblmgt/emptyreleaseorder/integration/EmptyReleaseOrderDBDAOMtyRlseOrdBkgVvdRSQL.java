/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOMtyRlseOrdBkgVvdRSQL.java
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

public class EmptyReleaseOrderDBDAOMtyRlseOrdBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseOrderDBDAOMtyRlseOrdBkgVvdRSQL
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOMtyRlseOrdBkgVvdRSQL(){
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
		query.append("FileName : EmptyReleaseOrderDBDAOMtyRlseOrdBkgVvdRSQL").append("\n"); 
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
		query.append("       ,RANK() OVER (PARTITION BY BB.BKG_NO ORDER BY VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ) AS LEG_SEQ" ).append("\n"); 
		query.append("       ,VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("       ,VVD.SLAN_CD" ).append("\n"); 
		query.append("       ,VVD.VSL_CD" ).append("\n"); 
		query.append("       ,VSL.LLOYD_NO AS LLOYD_No" ).append("\n"); 
		query.append("       ,REPLACE(VSL.VSL_ENG_NM,',',' ') AS VSL_ENG_NM" ).append("\n"); 
		query.append("       ,VSL.CALL_SGN_NO AS CALLSIGN" ).append("\n"); 
		query.append("       ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,MLL.UN_LOC_CD" ).append("\n"); 
		query.append("       ,VVD.POL_YD_CD" ).append("\n"); 
		query.append("       ,VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       ,REPLACE(MLL.LOC_NM,',',' ') LOC_NM" ).append("\n"); 
		query.append("       ,TO_CHAR(VSKL.VPS_ETA_DT,'YYYYMMDDHH24MISS') AS VPS_ETA_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(VSKL.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS VPS_ETD_DT" ).append("\n"); 
		query.append("       ,MLD.UN_LOC_CD AS UN_LOC_CD1" ).append("\n"); 
		query.append("       ,VVD.POD_YD_CD" ).append("\n"); 
		query.append("       ,REPLACE(MLD.LOC_NM,',',' ') AS LOC_NM1" ).append("\n"); 
		query.append("       ,VSKL.IB_CSSM_VOY_NO AS CONS_VVD_ARR" ).append("\n"); 
		query.append("       ,NVL(VSKL.OB_CSSM_VOY_NO, ' ') AS CONS_VVD_DEP" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,BKG_VVD VVD" ).append("\n"); 
		query.append("     ,VSK_VSL_PORT_SKD VSKL" ).append("\n"); 
		query.append("     ,MDM_LOCATION MLL" ).append("\n"); 
		query.append("     ,MDM_LOCATION MLD" ).append("\n"); 
		query.append("     ,MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND NVL(BB.EDI_HLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("--AND BB.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("AND VVD.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("AND VVD.POL_CD = MLL.LOC_CD" ).append("\n"); 
		query.append("AND VVD.POD_CD = MLD.LOC_CD" ).append("\n"); 
		query.append("AND VVD.VSL_CD = VSKL.VSL_CD(+)" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = VSKL.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = VSKL.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND VVD.POL_CD = VSKL.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND VVD.POL_CLPT_IND_SEQ = VSKL.CLPT_IND_SEQ(+)" ).append("\n"); 
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
		query.append("       AND VVD.VSL_CD = UPPER(substr(@[vvd],0,4))" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO = UPPER(substr(@[vvd],5,4))" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD = UPPER(substr(@[vvd],9,1))" ).append("\n"); 
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
		query.append("ORDER BY BB.BKG_NO" ).append("\n"); 

	}
}