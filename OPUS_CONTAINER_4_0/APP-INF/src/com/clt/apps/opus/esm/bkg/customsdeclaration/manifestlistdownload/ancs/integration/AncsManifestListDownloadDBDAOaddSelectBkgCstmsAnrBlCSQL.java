/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrBlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.12
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.09.12 이종길
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

public class AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * I
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrBlCSQL(){
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
		query.append("FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrBlCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ANR_BL (" ).append("\n"); 
		query.append("VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BKG_NO, " ).append("\n"); 
		query.append("VVD_SEQ," ).append("\n"); 
		query.append("BL_NO, BL_TP_CD," ).append("\n"); 
		query.append("POR_CD, POL_CD, POD_CD, DEL_CD, PRE_RLY_PORT_CD, PST_RLY_PORT_CD, BKG_CGO_TP_CD," ).append("\n"); 
		query.append("SHPR_ADDR, CNEE_ADDR," ).append("\n"); 
		query.append("ACT_WGT, ACT_WGT_UT_CD, PCK_QTY, PCK_TP_CD," ).append("\n"); 
		query.append("BDR_FLG, CSTMS_PRC_CD, " ).append("\n"); 
		query.append("CRE_OFC_CD, UPD_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, ANR_MSG_STS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BKG_NO" ).append("\n"); 
		query.append(",A.MAX_VVD_SEQ, A.BL_NO, A.BL_TP_CD, A.POR_CD, A.POL_CD, A.POD_CD, A.DEL_CD" ).append("\n"); 
		query.append(",A.PRE_RLY_PORT_CD, A.PST_RLY_PORT_CD, A.BKG_CGO_TP_CD, A.SHPR_ADDR, A.CNEE_ADDR" ).append("\n"); 
		query.append(",A.ACT_WGT, A.ACT_WGT_UT_CD, A.PCK_QTY, A.PCK_TP_CD, A.BDR_FLG, A.CSTMS_PRC_CD, A.CRE_OFC_CD" ).append("\n"); 
		query.append(",A.UPD_OFC_CD, A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT," ).append("\n"); 
		query.append("DECODE(B.EDI_SND_STS_CD||B.EDI_RCV_STS_CD, 'OA', 'A' ,'CA','N','TA','A','') AS ANR_MSG_STS_CD -- 세관에서 Accepeted를 받고나서 다시 다운로드 받으면 ANR_MSG_STS_CD값이 초기화되는 현재 로직 수정" ).append("\n"); 
		query.append("                                                                                              -- Original이나 Correction 전송에 대한 Accepet은 A로 Cancel 전송에 대한 Accepet은 N으로 표시" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BKG_NO" ).append("\n"); 
		query.append(",(SELECT MAX(VVD_SEQ) FROM BKG_CSTMS_ANR_BL_LOG WHERE 1=1 AND BKG_NO = B.BKG_NO) AS MAX_VVD_SEQ" ).append("\n"); 
		query.append(", B.BL_NO, B.BL_TP_CD" ).append("\n"); 
		query.append(", B.POR_CD, A.POL_CD, A.POD_CD, B.DEL_CD, DECODE(C.POL_CD, B.POL_CD, NULL, C.POL_CD) AS PRE_RLY_PORT_CD, DECODE(C.POD_CD, B.POD_CD, NULL, C.POD_CD) AS PST_RLY_PORT_CD, B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(", SUBSTR(D.CUST_NM || '@@' || D.CUST_ADDR, 1, 300) AS SHPR_ADDR" ).append("\n"); 
		query.append(", SUBSTR(E.CUST_NM || '@@' || E.CUST_ADDR, 1, 300) AS CNEE_ADDR" ).append("\n"); 
		query.append(", NVL(F.ACT_WGT,0) AS ACT_WGT, F.WGT_UT_CD AS ACT_WGT_UT_CD, NVL(F.PCK_QTY,0) AS PCK_QTY, F.PCK_TP_CD" ).append("\n"); 
		query.append(", F.BDR_FLG" ).append("\n"); 
		query.append(", DECODE(C.POD_CD, @[pod], DECODE(B.POD_CD, 'NLRTM', 'B', 'T'), 'D') AS CSTMS_PRC_CD -- T: Tranship, B: RTM Barge , D: Discharging" ).append("\n"); 
		query.append(", @[cre_ofc_cd] AS CRE_OFC_CD, @[upd_ofc_cd] AS UPD_OFC_CD" ).append("\n"); 
		query.append(", @[cre_usr_id] AS CRE_USR_ID, SYSDATE AS CRE_DT, @[upd_usr_id] AS UPD_USR_ID, SYSDATE AS UPD_DT" ).append("\n"); 
		query.append(", (SELECT MAX(REF_SEQ)" ).append("\n"); 
		query.append("   FROM BKG_CSTMS_ANR_BL_LOG" ).append("\n"); 
		query.append("   WHERE BKG_NO = B.BKG_NO) MAX_REF_SEQ ,(SELECT ANR_DECL_NO FROM BKG_CSTMS_ANR_BL_LOG WHERE B.BKG_NO = BKG_NO  AND ROWNUM =1 ) ANR_DECL_NO " ).append("\n"); 
		query.append("   ,(SELECT MSG_TP_CD FROM BKG_CSTMS_ANR_BL_LOG WHERE B.BKG_NO = BKG_NO  AND ROWNUM =1 ) AS MSG_TP_CD" ).append("\n"); 
		query.append("FROM BKG_VVD A, BKG_BOOKING B, BKG_VVD C, BKG_CUSTOMER D, BKG_CUSTOMER E, BKG_BL_DOC F" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.VSL_CD = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("AND A.POL_CD = @[pol]" ).append("\n"); 
		query.append("AND A.POD_CD = @[pod]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_clpt_ind_seq} != '') " ).append("\n"); 
		query.append("AND A.POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_clpt_ind_seq} != '') " ).append("\n"); 
		query.append("AND A.POD_CLPT_IND_SEQ = @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND B.BKG_CGO_TP_CD IN ('F', 'B')" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND C.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("AND C.VSL_SEQ = '0'" ).append("\n"); 
		query.append("AND D.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND D.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND E.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND E.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND F.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_CSTMS_ANR_BL G WHERE G.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                AND G.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND G.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append(") A, BKG_CSTMS_ANR_EDI_HIS B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE A.MAX_REF_SEQ = B.REF_SEQ(+)" ).append("\n"); 
		query.append("AND  A.MSG_TP_CD = B.MSG_TP_CD(+)" ).append("\n"); 
		query.append("AND A.ANR_DECL_NO = B.ANR_DECL_NO(+)" ).append("\n"); 

	}
}