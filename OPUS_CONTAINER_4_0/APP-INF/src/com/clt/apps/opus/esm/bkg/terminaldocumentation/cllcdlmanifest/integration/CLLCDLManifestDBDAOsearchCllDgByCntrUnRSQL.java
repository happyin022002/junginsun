/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllDgByCntrUnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllDgByCntrUnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllDgByCntrUn
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllDgByCntrUnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbx_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllDgByCntrUnRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("	NVL(DG.IMDG_UN_NO,' ') IMDG_UN_NO," ).append("\n"); 
		query.append("	NVL(DG.IMDG_CLSS_CD,' ') IMDG_CLSS_CD," ).append("\n"); 
		query.append("	NVL(DG.PRP_SHP_NM,' ') PRP_SHP_NM," ).append("\n"); 
		query.append("	NVL(DG.FLSH_PNT_CDO_TEMP,'') FLSH_PNT_CDO_TEMP," ).append("\n"); 
		query.append("	NVL(SUBSTR(DG.EMER_CNTC_PHN_NO_CTNT,1,50),' ') EMER_CNTC_PHN_NO_CTNT,--BKG_CSTMS_TML_CLL_DG_CGO INSERT LENGTH" ).append("\n"); 
		query.append("	NVL(DG.EMER_CNTC_PSON_NM,' ') EMER_CNTC_PSON_NM," ).append("\n"); 
		query.append("	' ' IMDG_PG_NO," ).append("\n"); 
		query.append("	--'' IMDG_PG_NO," ).append("\n"); 
		query.append("	REPLACE(NVL(DG.DIFF_RMK,' '),chr(10),' ') DIFF_RMK," ).append("\n"); 
		query.append("	NVL(DG.EMS_NO,' ') EMS_NO," ).append("\n"); 
		query.append("	NVL(DG.IMDG_PCK_GRP_CD,' ') IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("	NVL(DG.MRN_POLUT_FLG,' ') MRN_POLUT_FLG," ).append("\n"); 
		query.append("	NVL(DG.IMDG_SUBS_RSK_LBL_CD1,' ')||NVL(DG.IMDG_SUBS_RSK_LBL_CD2,' ')||NVL(DG.IMDG_SUBS_RSK_LBL_CD3,' ') IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("	NVL(DG.OUT_IMDG_PCK_QTY1,NULL) PCK_QTY," ).append("\n"); 
		query.append("	--'' PCK_QTY," ).append("\n"); 
		query.append("	NVL(DG.OUT_IMDG_PCK_CD1,' ') TML_PCK_UT_ID," ).append("\n"); 
		query.append("	--'' TML_PCK_UT_ID," ).append("\n"); 
		query.append("	NVL(DG.NET_WGT,NULL) NET_WGT," ).append("\n"); 
		query.append("	'KGS' NET_WGT_CD," ).append("\n"); 
		query.append("	DECODE(NVL(DG.WGT_UT_CD,' ')," ).append("\n"); 
		query.append("			'LBS', ROUND(NVL(DG.GRS_WGT,0)*0.4536,3)," ).append("\n"); 
		query.append("			NVL(DG.GRS_WGT,0)" ).append("\n"); 
		query.append("	) GRS_WGT," ).append("\n"); 
		query.append("	'KGS' GRS_WGT_CD," ).append("\n"); 
		query.append("	DECODE(NVL(DG.MEAS_UT_CD,' ')," ).append("\n"); 
		query.append("			'CBF', ROUND(NVL(DG.MEAS_QTY,0)*0.0283,3)," ).append("\n"); 
		query.append("			NVL(DG.MEAS_QTY,0)" ).append("\n"); 
		query.append("	) MEAS_QTY," ).append("\n"); 
		query.append("	'CBM' MEAS_QTY_CD," ).append("\n"); 
		query.append("	NVL(DG.HZD_DESC,' ') HZD_DESC," ).append("\n"); 
		query.append("	NVL(DG.SPCL_STWG_RQST_DESC,' ') SPCL_STWG_RQST_DESC," ).append("\n"); 
		query.append("	DG.DG_CNTR_SEQ," ).append("\n"); 
		query.append("	NVL(NVL(NVL(DG.APLY_NO, (SELECT /*+ INDEX_DESC(A XPKSCG_AUTHORIZATION) */ A.APRO_REF_NO " ).append("\n"); 
		query.append("                           FROM SCG_AUTHORIZATION A" ).append("\n"); 
		query.append("                          WHERE SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("                            AND A.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("                            AND A.DCGO_SEQ = DG.DCGO_SEQ" ).append("\n"); 
		query.append("                            AND A.VSL_PRE_PST_CD||A.VSL_SEQ IN ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD WHERE BKG_NO = A.BKG_NO )" ).append("\n"); 
		query.append("                            AND ROWNUM = 1))," ).append("\n"); 
		query.append("                            (SELECT /*+ INDEX_DESC(A XPKSCG_AUTHORIZATION) */ A.APRO_REF_NO " ).append("\n"); 
		query.append("                           FROM SCG_AUTHORIZATION A" ).append("\n"); 
		query.append("                          WHERE SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("                            AND A.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("                            AND A.VSL_PRE_PST_CD||A.VSL_SEQ IN ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD WHERE BKG_NO = A.BKG_NO )" ).append("\n"); 
		query.append("                            AND ROWNUM = 1)),' ') APLY_NO," ).append("\n"); 
		query.append("	DG.DCGO_REF_NO" ).append("\n"); 
		query.append("FROM	BKG_DG_CGO DG" ).append("\n"); 
		query.append("WHERE	DG.BKG_NO	= @[bkg_no]" ).append("\n"); 
		query.append("AND     NVL(DG.CNTR_NO,TO_CHAR(DG.DG_CNTR_SEQ))	= DECODE(NVL(DG.CNTR_NO,'Y'),'Y', (" ).append("\n"); 
		query.append("                                                                        SELECT TO_CHAR(MIN(DG_CNTR_SEQ))" ).append("\n"); 
		query.append("                                                                        FROM BKG_CSTMS_TML_CLL CLL, BKG_DG_CGO DG" ).append("\n"); 
		query.append("                                                                        WHERE CLL.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("                                                                          AND CLL.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("                                                                          AND CLL.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("                                                                          AND CLL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("																		  AND CLL.CNTR_NO = DECODE(SUBSTR(@[cntr_no],1,6),'T.B.N.',@[tbx_seq],@[cntr_no])" ).append("\n"); 
		query.append("																		  AND CLL.CNTR_LODG_NO = NVL(@[tbn_seq],CLL.CNTR_LODG_NO)" ).append("\n"); 
		query.append("                                                                          AND CLL.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("                                                                          AND CLL.CNTR_TPSZ_CD = DG.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                          AND DG.CNTR_NO IS NULL" ).append("\n"); 
		query.append("                                                                          AND DG.DG_CNTR_SEQ NOT IN ( SELECT NVL(DG_CNTR_SEQ,0) FROM BKG_CSTMS_TML_CLL_DG_CGO WHERE VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("                                                                                                                                                  AND SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("                                                                                                                                                  AND SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("                                                                                                                                                  AND BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("																																				  AND CRE_USR_ID = @[in_usr_id] )" ).append("\n"); 
		query.append("                                                                        ), @[cntr_no])" ).append("\n"); 

	}
}