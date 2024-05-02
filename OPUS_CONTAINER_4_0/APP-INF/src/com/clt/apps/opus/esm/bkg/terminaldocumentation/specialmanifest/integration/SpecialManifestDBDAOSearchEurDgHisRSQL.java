/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialManifestDBDAOSearchEurDgHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.05.06 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOSearchEurDgHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur DG 관련 Berth Port Setup 내용을 조회한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOSearchEurDgHisRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_dg_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOSearchEurDgHisRSQL").append("\n"); 
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
		query.append("SELECT	EUR_DG_DECL_TP_CD " ).append("\n"); 
		query.append("		,VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("		,PORT_CD" ).append("\n"); 
		query.append("		,BL_NO" ).append("\n"); 
		query.append("		,CNTR_NO" ).append("\n"); 
		query.append("		,CNTR_CGO_SEQ" ).append("\n"); 
		query.append("		,HIS_SEQ" ).append("\n"); 
		query.append("		,POL_CD" ).append("\n"); 
		query.append("		,POD_CD" ).append("\n"); 
		query.append("		,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,CELL_PSN_NO" ).append("\n"); 
		query.append("		,ANR_FWRD_ID" ).append("\n"); 
		query.append("		,DECODE(ANR_CRR_TP_CD, 'X','TBN','T','ROAD','R','RAIL','B','BARGE','V','MARINTIME',ANR_CRR_TP_CD) AS ANR_CRR_TP_CD" ).append("\n"); 
		query.append("		,TO_CHAR(CRR_DT, 'YYYY-MM-DD') AS CRR_DT" ).append("\n"); 
		query.append("		,FDR_SVC_RQST_NO" ).append("\n"); 
		query.append("		,DECODE(IMDG_PCK_GRP_CD, '1','I','2','II','3','III',IMDG_PCK_GRP_CD) AS IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("		,IMDG_CLSS_CD" ).append("\n"); 
		query.append("		,IMDG_UN_NO" ).append("\n"); 
		query.append("		,ANR_SPCL_TP_ID" ).append("\n"); 
		query.append("		,FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("		,NET_WGT" ).append("\n"); 
		query.append("		,GRS_WGT" ).append("\n"); 
		query.append("		,MFAG_NO" ).append("\n"); 
		query.append("		,PRP_SHP_NM" ).append("\n"); 
		query.append("		,HZD_DESC" ).append("\n"); 
		query.append("		,BRTH_YD_CD" ).append("\n"); 
		query.append("		,BRTH_YD_NM" ).append("\n"); 
		query.append("		,IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("		,EUR_PCK_DESC" ).append("\n"); 
		query.append("		,OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("		,OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("		,EUR_OUTR_PCK_DESC" ).append("\n"); 
		query.append("		,IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("		,IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("		,EUR_INR_PCK_DESC" ).append("\n"); 
		query.append("		,EMS_NO" ).append("\n"); 
		query.append("		,EUR_DCGO_MRN_POLUT_CD" ).append("\n"); 
		query.append("		,DIFF_RMK" ).append("\n"); 
		query.append("		,HCDG_FLG" ).append("\n"); 
		query.append("		,NET_EXPLO_WGT" ).append("\n"); 
		query.append("		,FDR_VVD_ID" ).append("\n"); 
		query.append("		,FDR_VSL_NM" ).append("\n"); 
		query.append("		,FDR_VSL_LLOYD_NO" ).append("\n"); 
		query.append("		,XTD_STAY_PRMT_NO" ).append("\n"); 
		query.append("		,CGO_OPR_CD" ).append("\n"); 
		query.append("		,APLY_NO" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_EUR_DG_HIS" ).append("\n"); 
		query.append("WHERE 	0=0" ).append("\n"); 
		query.append("AND		BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND		CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND		PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND		EUR_DG_DECL_TP_CD = @[eur_dg_decl_tp_cd]" ).append("\n"); 
		query.append("AND		VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND		SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND		SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("ORDER BY HIS_SEQ , CNTR_CGO_SEQ" ).append("\n"); 

	}
}