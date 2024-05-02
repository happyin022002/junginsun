/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchBkgDgCgoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchBkgDgCgoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한국 지역 DG Cargo Manifest List조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchBkgDgCgoListRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchBkgDgCgoListRSQL").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO BKG_NO" ).append("\n"); 
		query.append("     , MAX(DECODE(@[io_bnd_cd],'I',DECODE(BKG.POD_CD, BV.POD_CD,'I','T'), DECODE(BKG.POL_CD, BV.POL_CD,'E','R'))) CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("     , (SELECT DECODE(LPAD(CGO_SEQ_NO,3,'0'),'000',NULL,LPAD(CGO_SEQ_NO,3,'0'))" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_KR_DG_CGO D" ).append("\n"); 
		query.append("        WHERE D.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("        AND D.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("        AND D.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("        AND D.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("        AND ((@[io_bnd_cd] = 'O' AND D.POL_CD = @[pol_cd]) OR " ).append("\n"); 
		query.append("             (@[io_bnd_cd] = 'I' AND D.POD_CD = @[pod_cd]))" ).append("\n"); 
		query.append("        AND D.CNTR_NO = DC.CNTR_NO" ).append("\n"); 
		query.append("        AND D.IMDG_UN_NO = DC.IMDG_UN_NO" ).append("\n"); 
		query.append("        AND NVL(D.IMDG_COMP_GRP_CD,'X') = NVL(DC.IMDG_COMP_GRP_CD,'X')" ).append("\n"); 
		query.append("        AND D.CNTR_SEQ = (SELECT MAX(CNTR_SEQ) " ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_KR_DG_CGO M " ).append("\n"); 
		query.append("                          WHERE M.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("                          AND M.CSTMS_DECL_TP_CD = D.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("                          AND M.CNTR_NO = D.CNTR_NO)) IB_SEQ" ).append("\n"); 
		query.append("     , '' io_Bnd_Cd" ).append("\n"); 
		query.append("     , '' mrn_No" ).append("\n"); 
		query.append("     , DC.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("     , DC.IMDG_UN_NO IMDG_UN_NO" ).append("\n"); 
		query.append("     , MAX(MSN.MF_SEQ_NO) MF_SEQ_NO" ).append("\n"); 
		query.append("     , MAX(BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD) VVD" ).append("\n"); 
		query.append("     , MAX(BV.POL_CD) POL_CD" ).append("\n"); 
		query.append("     , MAX(BV.POD_CD) POD_CD" ).append("\n"); 
		query.append("     , MAX(DC.IMDG_CLSS_CD) IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , DC.IMDG_COMP_GRP_CD IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("     , TRIM(MAX(@[mrn_no])) CERTI_NO" ).append("\n"); 
		query.append("     , MAX(DECODE(@[io_bnd_cd],'I',DECODE(BKG.POD_CD,BV.POD_CD,'1','3'), DECODE(BKG.POL_CD,BV.POL_CD,'2','4'))) JOB" ).append("\n"); 
		query.append("     , MAX(BKG.BL_NO) BL_NO" ).append("\n"); 
		query.append("     , MAX(SUBSTR(REPLACE(REPLACE(REPLACE(DC.PRP_SHP_NM, CHR(13)||CHR(10),' '), CHR(34),' '),CHR(9),' '), 1, 70)) SUBSTANCE" ).append("\n"); 
		query.append("     , SUM(ROUND(DC.NET_WGT,0)) NET_WEIGHT" ).append("\n"); 
		query.append("     , SUM(DECODE(NVL(DC.WGT_UT_CD,'   '),'LBS',ROUND(NVL(DC.NET_WGT,0)*0.4536,0),ROUND(NVL(DC.NET_WGT,0),0))) CALC_WEIGHT" ).append("\n"); 
		query.append("     , MAX(DECODE(@[io_bnd_cd], 'I',	DECODE(BKG.POD_CD, BV.POD_CD, '9', '3'), DECODE(BKG.POL_CD, BV.POL_CD, '9', '3'))) JC_IND" ).append("\n"); 
		query.append("     , SUBSTR(MAX(DC.PRP_SHP_NM), 1, 70) PRP_SHP_NM" ).append("\n"); 
		query.append("  FROM BKG_DG_CGO DC, BKG_BOOKING BKG, BKG_CSTMS_KR_MF_SEQ_NO MSN, BKG_VVD BV" ).append("\n"); 
		query.append(" WHERE BV.VSL_CD          = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND BV.SKD_VOY_NO      = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND BV.SKD_DIR_CD      = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD       NOT IN ('X','S')" ).append("\n"); 
		query.append("   AND BKG.BKG_NO         = DC.BKG_NO" ).append("\n"); 
		query.append("   AND DC.BKG_NO          = MSN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND DC.CNTR_NO        IS NOT NULL" ).append("\n"); 
		query.append("   AND BV.BKG_NO          = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND ((@[io_bnd_cd] = 'O' AND BV.POL_CD = @[pol_cd] AND BKG.POL_CD <> BV.POL_CD) OR " ).append("\n"); 
		query.append("        (@[io_bnd_cd] = 'I' AND BV.POD_CD = @[pod_cd]))" ).append("\n"); 
		query.append("   AND MSN.MF_REF_NO(+)   = SUBSTR(@[mrn_no],1,10)" ).append("\n"); 
		query.append("   AND MSN.MRN_CHK_NO(+)  = SUBSTR(@[mrn_no],11,1)" ).append("\n"); 
		query.append(" GROUP BY BKG.BKG_NO, DC.CNTR_NO, DC.IMDG_UN_NO, DC.IMDG_COMP_GRP_CD" ).append("\n"); 

	}
}