/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllDgCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllDgCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllDgCntr
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllDgCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllDgCntrRSQL").append("\n"); 
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
		query.append("SELECT	'{CNTR_DANGER'||CHR(10)||" ).append("\n"); 
		query.append("	'UNNBR:'||NVL(D.IMDG_UN_NO,'')||CHR(10)||" ).append("\n"); 
		query.append("	'CLASS:'||NVL(D.IMDG_CLSS_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'DG_DESC:'||NVL(D.DG_DESC,'')||CHR(10)||" ).append("\n"); 
		query.append("	'PHONE:'||NVL(D.EMER_CNTC_PHN_NO,'')||CHR(10)||" ).append("\n"); 
		query.append("	'PAGE:'||NVL(D.IMDG_PG_NO,'')||CHR(10)||" ).append("\n"); 
		query.append("	'FLSH_TEMP:'||DECODE(NVL(D.FLSH_PNT_CDO_TEMP,''),'0','',NVL(D.FLSH_PNT_CDO_TEMP,''))||CHR(10)||" ).append("\n"); 
		query.append("	'FLSH_UNIT:C'||CHR(10)||" ).append("\n"); 
		query.append("	'DG_REMARK:'||NVL(D.DG_RMK,'')||CHR(10)||" ).append("\n"); 
		query.append("	'EMSNO:'||NVL(D.EMER_PRC_NO,'')||CHR(10)||" ).append("\n"); 
		query.append("	'PSACLS:'||''||CHR(10)||" ).append("\n"); 
		query.append("	'PKGGRP:'||NVL(D.DG_PCK_GRP_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'MFAG1:'||''||CHR(10)||" ).append("\n"); 
		query.append("	'MFAG2:'||''||CHR(10)||" ).append("\n"); 
		query.append("	'MAR_POLL:'||NVL(D.POLUT_FLG,'')||CHR(10)||" ).append("\n"); 
		query.append("	'LABEL_CD:'||NVL(D.DG_LBL_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'LABEL_DESC:'||NVL(D.DG_LBL_DESC,'')||CHR(10)||" ).append("\n"); 
		query.append("	'D_PKG:'||NVL(D.PCK_QTY,'')||CHR(10)||" ).append("\n"); 
		query.append("	'D_PKGUNIT:'||NVL(D.TML_PCK_UT_ID,'')||CHR(10)||" ).append("\n"); 
		query.append("	'NWGT:'||NVL(D.NET_WGT,'')||CHR(10)||" ).append("\n"); 
		query.append("	'NWGT_UNIT:'||NVL(D.NET_WGT_UT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'GWGT:'||NVL(D.GRS_CNTR_WGT,'')||CHR(10)||" ).append("\n"); 
		query.append("	'GWGT_UNIT:'||NVL(D.GRS_WGT_UT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'MEA:'||NVL(D.MEAS_QTY,'')||CHR(10)||" ).append("\n"); 
		query.append("	'MEA_UNIT:'||NVL(D.MEAS_UT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'HAZ_CONT:'||NVL(D.HZD_CTNT,'')||CHR(10)||" ).append("\n"); 
		query.append("	'STWG:'||NVL(D.STWG_DESC,'')||CHR(10)||" ).append("\n"); 
		query.append("	'LABEL:'||NVL(D.DG_LBL_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("    'DG_APPROVE_NO:'|| NVL(NVL((SELECT A.APLY_NO FROM BKG_DG_CGO A WHERE BKG_NO = D.BKG_NO AND DCGO_SEQ = D.DG_CNTR_SEQ ), " ).append("\n"); 
		query.append("                               (SELECT /*+ INDEX_DESC(A XPKSCG_AUTHORIZATION) */ A.APRO_REF_NO " ).append("\n"); 
		query.append("                                  FROM SCG_AUTHORIZATION A" ).append("\n"); 
		query.append("                                 WHERE SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("                                   AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("                                   AND A.VSL_PRE_PST_CD||A.VSL_SEQ IN ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD WHERE BKG_NO = A.BKG_NO )" ).append("\n"); 
		query.append("                                   AND ROWNUM = 1)), '')||CHR(10)||" ).append("\n"); 
		query.append("    '}CNTR_DANGER'||CHR(10) CNTR_DG_INFO" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_TML_CLL_DG_CGO D" ).append("\n"); 
		query.append("WHERE	D.VSL_CD		= SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND	D.SKD_VOY_NO		= SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND	D.SKD_DIR_CD		= SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND	D.PORT_CD		= @[in_pol_cd]" ).append("\n"); 
		query.append("#if (${in_pol_split_no} != '')" ).append("\n"); 
		query.append("AND NVL(D.CLPT_IND_SEQ, '1') = @[in_pol_split_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	D.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND	D.CNTR_NO(+)	= @[cntr_no]" ).append("\n"); 
		query.append("AND D.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 

	}
}