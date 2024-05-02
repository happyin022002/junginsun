/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchManifestInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.11.07 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchManifestInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Download전의 세관신고를 위한 B/L Information을 구한다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchManifestInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n"); 
		query.append("FileName : Kor24ManifestListDBDAOSearchManifestInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(B.BL_NO,' ') BL_NO" ).append("\n"); 
		query.append("		, NVL(B.BKG_NO,' ') BKG_NO" ).append("\n"); 
		query.append("		, NVL(B.BKG_NO,' ') A_BKG_NO" ).append("\n"); 
		query.append("--		, NVL(C.MF_SEQ_NO,' ') MSN" ).append("\n"); 
		query.append("		, TO_CHAR(ROWNUM, 'FM0000') AS MSN" ).append("\n"); 
		query.append("		, '' CORRECTION" ).append("\n"); 
		query.append("		, '' TP" ).append("\n"); 
		query.append("		, NVL(B.BKG_CGO_TP_CD,' ') FE" ).append("\n"); 
		query.append("		, NVL(A.POL_CD,' ') HIDDEN1" ).append("\n"); 
		query.append("		, NVL(A.POD_CD,' ') HIDDEN2" ).append("\n"); 
		query.append("		, NVL(B.POL_CD,' ') POL" ).append("\n"); 
		query.append("#if( ${in_bound} == 'I')" ).append("\n"); 
		query.append("	    , NVL(B.POD_CD,' ') POD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${sel_type} !='A')" ).append("\n"); 
		query.append("        , NVL(A.POD_CD,' ') POD" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		, NVL(B.POD_CD,' ') POD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, TO_CHAR(NVL(D.PCK_QTY ,0),'FM000000') PCK_QTY" ).append("\n"); 
		query.append("		, D.PCK_TP_CD PCK_TP_CD" ).append("\n"); 
		query.append("		, TO_CHAR(TRUNC(NVL(D.ACT_WGT,0),0),'FM00000000') ACT_WGT" ).append("\n"); 
		query.append("		, D.WGT_UT_CD WGT_UT_CD" ).append("\n"); 
		query.append("		, TO_CHAR(NVL(D.MEAS_QTY,0),'FM00000000.000') MEAS_QTY" ).append("\n"); 
		query.append("		, D.MEAS_UT_CD MEAS_UT_CD" ).append("\n"); 
		query.append("		, '' PKG_VALUE" ).append("\n"); 
		query.append("		, '' PKG_CODE" ).append("\n"); 
		query.append("		, '' WGT_VALUE" ).append("\n"); 
		query.append("		, '' WGT_CODE" ).append("\n"); 
		query.append("		, '' MATCH" ).append("\n"); 
		query.append("		, '' PRE_VVD" ).append("\n"); 
		query.append("		, '' SHPR_N" ).append("\n"); 
		query.append("		, '' SHPR_A" ).append("\n"); 
		query.append("		, '' CNEE_N" ).append("\n"); 
		query.append("		, '' CNEE_A" ).append("\n"); 
		query.append("		, '' NTFY_N" ).append("\n"); 
		query.append("		, '' NTFY_A" ).append("\n"); 
		query.append("		, '' CNTR" ).append("\n"); 
		query.append("		, DECODE(DECODE(TRIM(NVL(C.CSTMS_CLR_TP_CD,' ')||NVL(C.CSTMS_DCHG_LOC_WH_CD,' ')),'',0,LENGTH(TRIM(NVL(C.CSTMS_CLR_TP_CD,' ')||NVL(C.CSTMS_DCHG_LOC_WH_CD,' ')))),0,'N','Y') BAC" ).append("\n"); 
		query.append("		, DECODE(@[in_bound],'I',DECODE(DECODE(TRIM(NVL(C.BD_TP_CD,' ')),'',0,LENGTH(TRIM(NVL(C.BD_TP_CD,' ')))),0,'N'," ).append("\n"); 
		query.append("		DECODE(DECODE(TRIM(NVL(C.CSTMS_CLR_WH_CD,' ')),'',0,LENGTH(TRIM(NVL(C.CSTMS_CLR_WH_CD,' ')))),0,'N','Y')),' ') WH" ).append("\n"); 
		query.append("		, '' DESC_CODE" ).append("\n"); 
		query.append("		, '' TR" ).append("\n"); 
		query.append("		, DECODE(NVL(F.ATTR_CTNT2,' '), ' ', 'N', 'Y') CM" ).append("\n"); 
		query.append("		, '' BZ" ).append("\n"); 
		query.append("		, '' ELNO_A" ).append("\n"); 
		query.append("		, '' ELNO_B" ).append("\n"); 
		query.append("		, NVL(B.KR_CSTMS_CUST_TP_CD, 'N') SC" ).append("\n"); 
		query.append("		, '' CUST_NAME" ).append("\n"); 
		query.append("		, DECODE(NVL(B.BKG_CGO_TP_CD,' '),'B','Y','N')  HIDDEN3" ).append("\n"); 
		query.append("		, DECODE(@[in_bound],'I',DECODE(DECODE(TRIM(NVL(C.MF_SEQ_NO,' ')),' ',LENGTH(TRIM(NVL(C.MF_SEQ_NO,' ')))),' ','N','Y'),' ') HIDDEN5" ).append("\n"); 
		query.append("     FROM BKG_VVD A, BKG_BOOKING B, BKG_CSTMS_KR_MF_SEQ_NO C, BKG_BL_DOC D, BKG_CSTMS_CD_CONV_CTNT F" ).append("\n"); 
		query.append("	WHERE A.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("	  AND A.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("	  AND A.SKD_DIR_CD    = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("	  AND A.POL_CD LIKE @[in_pol]||'%'" ).append("\n"); 
		query.append("	  AND A.POD_CD LIKE @[in_pod]||'%'" ).append("\n"); 
		query.append("  	  AND DECODE(@[in_bound],'I',DECODE(LENGTH(@[in_pod_tmnl]),7,A.POD_YD_CD,' '),' ')" ).append("\n"); 
		query.append("	  	= DECODE(@[in_bound],'I',DECODE(LENGTH(@[in_pod_tmnl]),7,@[in_pod_tmnl],' '),' ')" ).append("\n"); 
		query.append("	  AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	  AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("	  AND B.BL_NO  > ' '" ).append("\n"); 
		query.append("	  AND B.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("	  AND B.BKG_STS_CD != 'S'" ).append("\n"); 
		query.append("	  AND B.BL_NO = NVL(@[in_blno],B.BL_NO)" ).append("\n"); 
		query.append("	  AND B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("#if(${mrn_no}!='')" ).append("\n"); 
		query.append("	  AND C.MF_REF_NO(+) = @[mrn_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	  AND F.CNT_CD(+) = 'KR'" ).append("\n"); 
		query.append("	  AND F.CSTMS_DIV_ID(+) = 'KOR_CSTM_CMDT'" ).append("\n"); 
		query.append("	  AND B.REP_CMDT_CD = F.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${sel_type} == 'A'||${sel_type} == 'B'||${sel_type} == 'C')" ).append("\n"); 
		query.append("	  -- AND B.BKG_CGO_TP_CD !='R'" ).append("\n"); 
		query.append("       AND B.BKG_CGO_TP_CD !='P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${sel_type} == 'M')" ).append("\n"); 
		query.append("	   AND B.BKG_CGO_TP_CD ='P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ORDER BY NVL(B.BL_NO,' '), NVL(A.POL_CD,' '), NVL(A.POD_CD,' ')" ).append("\n"); 

	}
}