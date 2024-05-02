/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchInboundBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.04.21 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchInboundBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS system내에 I/B B/L File Form으로 출력할 대상 B/L List를 조회한다.
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchInboundBlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchInboundBlListRSQL").append("\n"); 
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
		query.append("SELECT VVD_NM, VVD_NUMBER, FRM_CRN_NUMBER, MAX(CNTR_TPSZ_DESC) CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("	SUBSTR(MAX(CNTR_NO_CD),0,11) CNTR_NO, SUBSTR(MAX(CNTR_NO_CD),12) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	MAX(CNTR_NO_CD) CNTR_NO_CD," ).append("\n"); 
		query.append("    MAX(PCK_DESC) PCK_DESC, CNTR_WGT_UT_CD, BL_NO||BL_TP_CD BL_NO, POL_CD, POD_CD," ).append("\n"); 
		query.append("    NTFY_ADDR, BKG_TTL_QTY, BKG_TTL_QTY_UT_CD, BKG_NO, MAX(CNTR_MF_DESC) CNTR_MF_DESC," ).append("\n"); 
		query.append("    IB_FILE_SEQ, MAX_BRB_IF_SEQ, DEM_FREE_DT, RCV_TERM_CD,DE_TERM_CD, PCK_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT VVD_NM, VVD_NUMBER, FRM_CRN_NUMBER, CNTR_TPSZ_DESC, CNTR_NO||CNTR_TPSZ_CD CNTR_NO_CD," ).append("\n"); 
		query.append("    PCK_DESC, CNTR_WGT_UT_CD, BL_NO, BL_TP_CD, POL_CD, POD_CD," ).append("\n"); 
		query.append("    NTFY_ADDR, BKG_TTL_QTY, BKG_TTL_QTY_UT_CD, BKG_NO, CNTR_MF_DESC," ).append("\n"); 
		query.append("    IB_FILE_SEQ, MAX_BRB_IF_SEQ, DEM_FREE_DT, RCV_TERM_CD, DE_TERM_CD," ).append("\n"); 
		query.append("    COUNT(DISTINCT CNTR_NO) OVER(PARTITION BY BL_NO) PCK_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT	A.VVD_NM," ).append("\n"); 
		query.append("	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_NUMBER," ).append("\n"); 
		query.append("	A.VSL_CALL_REF_NO FRM_CRN_NUMBER," ).append("\n"); 
		query.append("	C.CNTR_NO," ).append("\n"); 
		query.append("	C.CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("	C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	C.PCK_DESC," ).append("\n"); 
		query.append("	C.CNTR_WGT_UT_CD," ).append("\n"); 
		query.append("	B.BL_NO," ).append("\n"); 
		query.append("	B.BL_TP_CD," ).append("\n"); 
		query.append("	B.POL_CD," ).append("\n"); 
		query.append("	B.POD_CD," ).append("\n"); 
		query.append("	TRANSLATE(SUBSTR(B.NTFY_ADDR,1,INSTR(B.NTFY_ADDR,'@@')-1), CHR(13)||CHR(10), ' ') NTFY_ADDR," ).append("\n"); 
		query.append("	B.BKG_TTL_QTY," ).append("\n"); 
		query.append("	B.BKG_TTL_QTY_UT_CD," ).append("\n"); 
		query.append("	B.BKG_NO," ).append("\n"); 
		query.append("	D.CNTR_MF_DESC," ).append("\n"); 
		query.append("	NVL(B.IB_FILE_SEQ, 0) IB_FILE_SEQ," ).append("\n"); 
		query.append("	F.MAX_BRB_IF_SEQ," ).append("\n"); 
		query.append("	TO_CHAR(A.DEM_FREE_DT, 'YYYYMMDD' ) DEM_FREE_DT," ).append("\n"); 
		query.append("	NVL(BKG.RCV_TERM_CD,' ') RCV_TERM_CD," ).append("\n"); 
		query.append("	NVL(BKG.DE_TERM_CD,' ') DE_TERM_CD" ).append("\n"); 
		query.append("  FROM	BKG_CSTMS_RTM_VSL A," ).append("\n"); 
		query.append("	BKG_CSTMS_RTM_BL B," ).append("\n"); 
		query.append("	BKG_CONTAINER BKG," ).append("\n"); 
		query.append("	BKG_CSTMS_RTM_CNTR C," ).append("\n"); 
		query.append("	BKG_CSTMS_RTM_CGO_MF D," ).append("\n"); 
		query.append("	BKG_BL_MK_DESC E," ).append("\n"); 
		query.append("	( SELECT VSL_CALL_REF_NO," ).append("\n"); 
		query.append("		MAX ( NVL ( IB_FILE_SEQ, 0 ) ) MAX_BRB_IF_SEQ" ).append("\n"); 
		query.append("		 FROM BKG_CSTMS_RTM_BL" ).append("\n"); 
		query.append("		GROUP BY VSL_CALL_REF_NO" ).append("\n"); 
		query.append("	) F" ).append("\n"); 
		query.append(" WHERE	  A.VSL_CALL_REF_NO       = B.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("	AND   A.VSL_CALL_REF_NO       = C.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("	AND   B.VSL_CALL_REF_NO       = F.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("	AND   B.BKG_NO      = C.BKG_NO" ).append("\n"); 
		query.append("	AND   C.BKG_NO      = BKG.BKG_NO" ).append("\n"); 
		query.append("	AND   C.CNTR_NO 	= BKG.CNTR_NO" ).append("\n"); 
		query.append("	AND   A.VSL_CALL_REF_NO       = D.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("	AND   C.BKG_NO      = D.BKG_NO" ).append("\n"); 
		query.append("	AND   C.CNTR_NO		= D.CNTR_NO" ).append("\n"); 
		query.append("	AND   D.CNTR_MF_SEQ = 1" ).append("\n"); 
		query.append("	AND   C.BKG_NO      = E.BKG_NO" ).append("\n"); 
		query.append("	AND	  E.MK_SEQ = 1" ).append("\n"); 
		query.append("    AND   A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("    AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND   A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("#if (${frm_crn_number}!= '') 	" ).append("\n"); 
		query.append("    AND	  A.VSL_CALL_REF_NO		=	@[frm_crn_number]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '') " ).append("\n"); 
		query.append("    AND   A.VSL_CD        = @[vsl_cd]              " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no}!= '') " ).append("\n"); 
		query.append("    AND   A.SKD_VOY_no    = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd}!= '') " ).append("\n"); 
		query.append("    AND   A.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd}!= '') " ).append("\n"); 
		query.append("	AND   B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	GROUP BY VVD_NM," ).append("\n"); 
		query.append("	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD," ).append("\n"); 
		query.append("	A.VSL_CALL_REF_NO ," ).append("\n"); 
		query.append("	C.CNTR_NO," ).append("\n"); 
		query.append("	C.CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("	C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	C.PCK_DESC," ).append("\n"); 
		query.append("	C.CNTR_WGT_UT_CD," ).append("\n"); 
		query.append("	B.BL_NO," ).append("\n"); 
		query.append("	B.BL_TP_CD," ).append("\n"); 
		query.append("	B.POL_CD," ).append("\n"); 
		query.append("	B.POD_CD," ).append("\n"); 
		query.append("	TRANSLATE(SUBSTR(B.NTFY_ADDR,1,INSTR(B.NTFY_ADDR,'@@')-1), CHR(13)||CHR(10), ' ')," ).append("\n"); 
		query.append("	B.BKG_TTL_QTY," ).append("\n"); 
		query.append("	B.BKG_TTL_QTY_UT_CD," ).append("\n"); 
		query.append("	B.BKG_NO," ).append("\n"); 
		query.append("	D.CNTR_MF_DESC," ).append("\n"); 
		query.append("	NVL(B.IB_FILE_SEQ, 0)," ).append("\n"); 
		query.append("	F.MAX_BRB_IF_SEQ," ).append("\n"); 
		query.append("	TO_CHAR(A.DEM_FREE_DT, 'YYYYMMDD' ) ," ).append("\n"); 
		query.append("	NVL(BKG.RCV_TERM_CD,' ')," ).append("\n"); 
		query.append("	NVL(BKG.DE_TERM_CD,' ')" ).append("\n"); 
		query.append("    ORDER BY C.CNTR_NO))" ).append("\n"); 
		query.append("    GROUP BY  VVD_NM, VVD_NUMBER, FRM_CRN_NUMBER," ).append("\n"); 
		query.append("     CNTR_WGT_UT_CD, BL_NO, BL_TP_CD, POL_CD, POD_CD," ).append("\n"); 
		query.append("     NTFY_ADDR, BKG_TTL_QTY, BKG_TTL_QTY_UT_CD, BKG_NO, " ).append("\n"); 
		query.append("     IB_FILE_SEQ, MAX_BRB_IF_SEQ, DEM_FREE_DT, RCV_TERM_CD, DE_TERM_CD, PCK_QTY" ).append("\n"); 
		query.append("	ORDER BY IB_FILE_SEQ" ).append("\n"); 

	}
}