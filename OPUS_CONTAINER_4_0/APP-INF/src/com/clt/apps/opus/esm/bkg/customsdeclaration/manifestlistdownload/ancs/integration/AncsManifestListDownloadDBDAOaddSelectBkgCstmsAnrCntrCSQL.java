/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.07.28 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ANR_CNTR (" ).append("\n"); 
		query.append("VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BKG_NO, CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD, ISO_CNTR_TPSZ_CD, PCK_QTY, PCK_TP_CD, CNTR_WGT, WGT_UT_CD," ).append("\n"); 
		query.append("ORG_RCV_TERM_CD, DEST_DE_TERM_CD, DECL_FLG," ).append("\n"); 
		query.append("CRE_OFC_CD, UPD_OFC_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, ANR_MSG_STS_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BKG_NO, A.CNTR_NO" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD, A.CNTR_TPSZ_ISO_CD, A.PCK_QTY, A.PCK_TP_CD, A.CNTR_WGT, A.WGT_UT_CD" ).append("\n"); 
		query.append(",A.ORG_RCV_TERM_CD ,A.DEST_DE_TERM_CD, A.DECL_FLG" ).append("\n"); 
		query.append(",A.CRE_OFC_CD ,A.UPD_OFC_CD, A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT" ).append("\n"); 
		query.append(",DECODE(B.EDI_SND_STS_CD||B.EDI_RCV_STS_CD, 'OA', 'A' ,'CA','N','TA','A','') AS ANR_MSG_STS_CD -- 세관에서 Accepeted를 받고나서 다시 다운로드 받으면 ANR_MSG_STS_CD값이 초기화되는 현재 로직 수정" ).append("\n"); 
		query.append("                                                                                               -- Original이나 Correction 전송에 대한 Accepet은 A로 Cancel 전송에 대한 Accepet은 N으로 표시" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, C.BKG_NO, C.CNTR_NO, " ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD, D.CNTR_TPSZ_ISO_CD, NVL(C.PCK_QTY,0) AS PCK_QTY, C.PCK_TP_CD, NVL(C.CNTR_WGT,0) AS CNTR_WGT, C.WGT_UT_CD," ).append("\n"); 
		query.append("DECODE(C.RCV_TERM_CD, 'S', 'LCL', 'FCL') AS ORG_RCV_TERM_CD, DECODE(C.DE_TERM_CD, 'S', 'LCL', 'FCL') AS DEST_DE_TERM_CD, 'Y' AS DECL_FLG" ).append("\n"); 
		query.append(", @[cre_ofc_cd] AS CRE_OFC_CD" ).append("\n"); 
		query.append(", @[upd_ofc_cd] AS UPD_OFC_CD" ).append("\n"); 
		query.append(", @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS UPD_DT" ).append("\n"); 
		query.append(", (SELECT MAX(REF_SEQ)" ).append("\n"); 
		query.append("   FROM BKG_CSTMS_ANR_CNTR_LOG" ).append("\n"); 
		query.append("   WHERE CNTR_NO = C.CNTR_NO) MAX_REF_SEQ ,(SELECT ANR_DECL_NO FROM BKG_CSTMS_ANR_CNTR_LOG WHERE C.CNTR_NO = CNTR_NO  AND ROWNUM =1 ) ANR_DECL_NO " ).append("\n"); 
		query.append("   ,(SELECT MSG_TP_CD FROM BKG_CSTMS_ANR_CNTR_LOG WHERE B.BKG_NO = BKG_NO  AND ROWNUM =1 ) AS MSG_TP_CD" ).append("\n"); 
		query.append("FROM BKG_VVD A, BKG_CSTMS_ANR_BL B, BKG_CONTAINER C, MDM_CNTR_TP_SZ D" ).append("\n"); 
		query.append("WHERE A.VSL_CD = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("AND A.POL_CD = @[pol]" ).append("\n"); 
		query.append("AND A.POD_CD = @[pod]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_clpt_ind_seq} != '') " ).append("\n"); 
		query.append("AND A.POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_clpt_ind_seq} != '') " ).append("\n"); 
		query.append("AND A.POD_CLPT_IND_SEQ = @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND D.CNTR_TPSZ_CD(+) = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${chk_down} == 'Y' || ${chk_down} == 'C') " ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_CSTMS_ANR_CNTR E WHERE E.VSL_CD = B.VSL_CD AND E.SKD_VOY_NO = B.SKD_VOY_NO AND E.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND E.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                   AND E.CNTR_NO = C.CNTR_NO)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_CSTMS_ANR_CNTR E WHERE E.VSL_CD = B.VSL_CD AND E.SKD_VOY_NO = B.SKD_VOY_NO AND E.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND E.BKG_NO = C.BKG_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A, BKG_CSTMS_ANR_EDI_HIS B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE A.MAX_REF_SEQ = B.REF_SEQ(+)" ).append("\n"); 
		query.append("AND  A.MSG_TP_CD = B.MSG_TP_CD(+)" ).append("\n"); 
		query.append("AND A.ANR_DECL_NO = B.ANR_DECL_NO(+)" ).append("\n"); 

	}
}