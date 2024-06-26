/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KorManifestListDBDAOSearchReManifestInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchReManifestInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 재 Down위해서 새로운 B/L Information구하기
	  * </pre>
	  */
	public KorManifestListDBDAOSearchReManifestInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_blno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_tmnl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchReManifestInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT TB.BL_NO BL_NO" ).append("\n"); 
		query.append("     , TB.A_BKG_NO A_BKG_NO" ).append("\n"); 
		query.append("     , TB.BKG_NO BKG_NO" ).append("\n"); 
		query.append("     , TB.MSN MSN" ).append("\n"); 
		query.append("     , TB.CORRECTION CORRECTION" ).append("\n"); 
		query.append("     , TB.TP TP" ).append("\n"); 
		query.append("     , TB.FE FE" ).append("\n"); 
		query.append("     , TB.HIDDEN1 HIDDEN1" ).append("\n"); 
		query.append("     , TB.HIDDEN2 HIDDEN2" ).append("\n"); 
		query.append("     , TB.POL POL" ).append("\n"); 
		query.append("     , TB.POD POD" ).append("\n"); 
		query.append("     , TB.PCK_QTY PCK_QTY" ).append("\n"); 
		query.append("     , TB.PCK_TP_CD PCK_TP_CD" ).append("\n"); 
		query.append("     , TB.ACT_WGT ACT_WGT" ).append("\n"); 
		query.append("     , TB.WGT_UT_CD WGT_UT_CD" ).append("\n"); 
		query.append("     , TB.MEAS_QTY MEAS_QTY" ).append("\n"); 
		query.append("     , TB.MEAS_UT_CD MEAS_UT_CD" ).append("\n"); 
		query.append("     , TB.PKG_VALUE PKG_VALUE" ).append("\n"); 
		query.append("     , TB.PKG_CODE PKG_CODE" ).append("\n"); 
		query.append("     , TB.WGT_VALUE WGT_VALUE" ).append("\n"); 
		query.append("     , TB.WGT_CODE WGT_CODE" ).append("\n"); 
		query.append("     , TB.MATCH MATCH" ).append("\n"); 
		query.append("     , TB.PRE_VVD PRE_VVD" ).append("\n"); 
		query.append("     , TB.SHPR_N SHPR_N" ).append("\n"); 
		query.append("     , TB.SHPR_A SHPR_A" ).append("\n"); 
		query.append("     , TB.CNEE_N CNEE_N" ).append("\n"); 
		query.append("     , TB.CNEE_A CNEE_A" ).append("\n"); 
		query.append("     , TB.NTFY_N NTFY_N" ).append("\n"); 
		query.append("     , TB.NTFY_A NTFY_A" ).append("\n"); 
		query.append("     , TB.CNTR CNTR" ).append("\n"); 
		query.append("     , TB.BAC BAC" ).append("\n"); 
		query.append("     , TB.DESC_CODE DESC_CODE" ).append("\n"); 
		query.append("     , TB.TR TR" ).append("\n"); 
		query.append("     , TB.CM CM" ).append("\n"); 
		query.append("     , TB.BZ BZ" ).append("\n"); 
		query.append("     , TB.ELNO_A ELNO_A" ).append("\n"); 
		query.append("     , TB.ELNO_B ELNO_B" ).append("\n"); 
		query.append("     , TB.SC SC" ).append("\n"); 
		query.append("     , TB.CUST_NAME CUST_NAME" ).append("\n"); 
		query.append("     , TB.BKSTS BKGSTS" ).append("\n"); 
		query.append("     , TB.MSN_BLTP MSN_BLTP" ).append("\n"); 
		query.append("     , TB.VVD_CD VVD_CD" ).append("\n"); 
		query.append("     , TB.CREATED_TYPE CREATED_TYPE" ).append("\n"); 
		query.append("     , TB.FFORD_CD FFORD_CD" ).append("\n"); 
		query.append("     , '' CNTR_NO" ).append("\n"); 
		query.append("     , TB.WHOUSE WHOUSE" ).append("\n"); 
		query.append("     , TB.WHOUSE_DESC WHOUSE_DESC" ).append("\n"); 
		query.append("     , TB.BKG_POR BKG_POR" ).append("\n"); 
		query.append("     , TB.BKG_DEL BKG_DEL" ).append("\n"); 
		query.append("     , TB.BL_NO C_BL_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT NVL(B.BL_NO,' ') BL_NO " ).append("\n"); 
		query.append(", NVL(B.BKG_NO,' ') BKG_NO " ).append("\n"); 
		query.append(", NVL(B.BKG_NO,' ') A_BKG_NO " ).append("\n"); 
		query.append(", NVL(C.MF_SEQ_NO,' ') MSN " ).append("\n"); 
		query.append(", '' CORRECTION " ).append("\n"); 
		query.append(", '' TP " ).append("\n"); 
		query.append(", NVL(B.BKG_CGO_TP_CD,' ') FE " ).append("\n"); 
		query.append(", NVL(A.POL_CD,' ') HIDDEN1 " ).append("\n"); 
		query.append(", NVL(A.POD_CD,' ') HIDDEN2 " ).append("\n"); 
		query.append(", NVL(B.POL_CD,' ') POL " ).append("\n"); 
		query.append("#if( ${in_bound} == 'I')" ).append("\n"); 
		query.append("	    , NVL(B.POD_CD,' ') POD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${sel_type} !='A')" ).append("\n"); 
		query.append("        , NVL(A.POD_CD,' ') POD" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		, NVL(B.POD_CD,' ') POD " ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", NVL(D.PCK_QTY ,0) PCK_QTY " ).append("\n"); 
		query.append(", D.PCK_TP_CD PCK_TP_CD " ).append("\n"); 
		query.append(", TRUNC(DECODE(NVL(D.WGT_UT_CD,'   '),'LBS',ROUND(NVL(D.ACT_WGT,0)*0.4536,3), NVL(D.ACT_WGT,0)),2) ACT_WGT " ).append("\n"); 
		query.append(", DECODE(NVL(D.WGT_UT_CD,'   '),'LBS','KGS',NVL(D.WGT_UT_CD,'   ')) WGT_UT_CD " ).append("\n"); 
		query.append(", ROUND(NVL(D.MEAS_QTY,0),3) MEAS_QTY " ).append("\n"); 
		query.append(", D.MEAS_UT_CD MEAS_UT_CD " ).append("\n"); 
		query.append(", '' PKG_VALUE " ).append("\n"); 
		query.append(", '' PKG_CODE " ).append("\n"); 
		query.append(", '' WGT_VALUE " ).append("\n"); 
		query.append(", '' WGT_CODE " ).append("\n"); 
		query.append(", '' MATCH " ).append("\n"); 
		query.append(", '' PRE_VVD " ).append("\n"); 
		query.append(", '' SHPR_N " ).append("\n"); 
		query.append(", '' SHPR_A " ).append("\n"); 
		query.append(", '' CNEE_N " ).append("\n"); 
		query.append(", '' CNEE_A " ).append("\n"); 
		query.append(", '' NTFY_N " ).append("\n"); 
		query.append(", '' NTFY_A " ).append("\n"); 
		query.append(", '' CNTR " ).append("\n"); 
		query.append(", SUBSTR(NVL(C.CSTMS_CLR_TP_CD,' ')||NVL(C.CSTMS_DCHG_LOC_WH_CD,' '),1,10) BAC /* 변경 */" ).append("\n"); 
		query.append(", ''  DESC_CODE " ).append("\n"); 
		query.append(", '' TR " ).append("\n"); 
		query.append(", NVL(F.ATTR_CTNT2,'630700') CM " ).append("\n"); 
		query.append(", '' BZ " ).append("\n"); 
		query.append(", '' ELNO_A " ).append("\n"); 
		query.append(", '' ELNO_B" ).append("\n"); 
		query.append(", DECODE(@[in_bound], 'O', NVL(B.KR_CSTMS_CUST_TP_CD,'N'), NVL(C.KR_CSTMS_BL_TP_CD,'N')) SC " ).append("\n"); 
		query.append(", '' CUST_NAME " ).append("\n"); 
		query.append(", DECODE(B.BKG_STS_CD,NULL,' ','X','X','S','X',B.BKG_STS_CD) BKSTS " ).append("\n"); 
		query.append(", SUBSTR(NVL(C.CSTMS_CLR_TP_CD,' ')||NVL(C.CSTMS_CLR_TP_CD,' '),1,10) MSN_BLTP " ).append("\n"); 
		query.append(", @[in_vvd] VVD_CD " ).append("\n"); 
		query.append(", '' CREATED_TYPE " ).append("\n"); 
		query.append(", ' ' FFORD_CD" ).append("\n"); 
		query.append(", DECODE(@[kt_port],'KRPUS',DECODE(B.BKG_CGO_TP_CD,'P',G.CNTR_NO,' '),' ') CNTR_NO /* 추가 */" ).append("\n"); 
		query.append(", NVL(C.BD_TP_CD,'') WHOUSE  " ).append("\n"); 
		query.append(", NVL(SUBSTR(C.CSTMS_CLR_WH_CD,1,8),' ') WHOUSE_DESC " ).append("\n"); 
		query.append(", NVL(B.POR_CD,' ') BKG_POR " ).append("\n"); 
		query.append(", NVL(B.DEL_CD,' ') BKG_DEL " ).append("\n"); 
		query.append("FROM BKG_VVD A, BKG_BOOKING B, BKG_CSTMS_KR_MF_SEQ_NO C, BKG_BL_DOC D, BKG_CSTMS_CD_CONV_CTNT F, BKG_CONTAINER G /* 추가 */" ).append("\n"); 
		query.append("WHERE B.BKG_NO = @[in_bkg_no] " ).append("\n"); 
		query.append("AND A.VSL_CD = SUBSTR(@[in_vvd],1,4) " ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4) " ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[in_vvd],9,1) " ).append("\n"); 
		query.append("AND A.POL_CD LIKE @[in_pol]||'%' " ).append("\n"); 
		query.append("AND A.POD_CD LIKE @[in_pod]||'%' " ).append("\n"); 
		query.append("AND DECODE(@[in_bound],'I',DECODE(LENGTH(@[in_pod_tmnl]),7,A.POD_YD_CD,' '),' ') = DECODE(@[in_bound],'I',DECODE(LENGTH(@[in_pod_tmnl]),7,@[in_pod_tmnl],' '),' ') " ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("AND B.BKG_NO = D.BKG_NO " ).append("\n"); 
		query.append("AND A.BKG_NO = G.BKG_NO /*추가 */" ).append("\n"); 
		query.append("AND B.BL_NO = NVL(@[in_blno],B.BL_NO) " ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO(+) " ).append("\n"); 
		query.append("#if(${mrn_no}!='')" ).append("\n"); 
		query.append("	  AND C.MF_REF_NO(+) = @[mrn_no] 		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.REP_CMDT_CD = F.ATTR_CTNT1(+)  " ).append("\n"); 
		query.append("AND F.CNT_CD(+) = 'KR'" ).append("\n"); 
		query.append("AND F.CSTMS_DIV_ID(+) = 'KOR_CSTM_CMDT'" ).append("\n"); 
		query.append("ORDER BY CNTR_NO, NVL(B.BL_NO,' '), NVL(A.POL_CD,' '), NVL(A.POD_CD,' ') ) TB" ).append("\n"); 

	}
}