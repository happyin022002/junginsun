/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorManifestListDAOSearchListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.07
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.07 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDAOSearchListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 실제 보여지는 데이타 리스트
	  * </pre>
	  */
	public KorManifestListDAOSearchListRSQL(){
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
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_nbr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDAOSearchListRSQL").append("\n"); 
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
		query.append("SELECT NVL(B.BL_NO,' ')  || NVL(B.BL_NO_TP,' ') || NVL(B.BL_NO_CHK,' ')||NVL(B.BL_TP_CD,' ') BL_NO" ).append("\n"); 
		query.append("     , NVL(B.BKG_NO,' ') AS BKG_NO" ).append("\n"); 
		query.append("     , NVL(C.MF_SEQ,' ') MSN" ).append("\n"); 
		query.append("     , '' CORRECTION" ).append("\n"); 
		query.append("     , '' TP" ).append("\n"); 
		query.append("     , NVL(B.BKG_CGO_TP_CD,' ') FE" ).append("\n"); 
		query.append("     , NVL(A.POL_CD,' ') HIDDEN1" ).append("\n"); 
		query.append("     , NVL(A.POD_CD,' ') HIDDEN2" ).append("\n"); 
		query.append("     , NVL(B.POL_CD,' ') POL" ).append("\n"); 
		query.append("     , NVL(B.POD_CD,' ') POD" ).append("\n"); 
		query.append("     , TO_CHAR(NVL(D.PCK_QTY ,0),'FM00000') PKG_VALUE" ).append("\n"); 
		query.append("     , D.PCK_TP_CD PKG_CODE " ).append("\n"); 
		query.append("     , TO_CHAR(TRUNC(NVL(D.ACT_WGT,0),0),'FM00000000') WGT_VALUE" ).append("\n"); 
		query.append("     , D.WGT_UT_CD WGT_CODE" ).append("\n"); 
		query.append("     , TO_CHAR(NVL(D.MEAS_QTY,0),'FM00000000.000') MSR_VALUE" ).append("\n"); 
		query.append("     , D.MEAS_UT_CD MSR_CODE" ).append("\n"); 
		query.append("     , '' IB_PKG_VALUE     , '' IB_PKG_CODE" ).append("\n"); 
		query.append("     , '' IB_WGT_VALUE     , '' IB_WGT_CODE" ).append("\n"); 
		query.append("     , '' IB_MAT_VALUE     , '' IB_MAT_CODE" ).append("\n"); 
		query.append("     , '' SHPR_N     , ''  AS SHPR_A" ).append("\n"); 
		query.append("     , '' CNEE_N     , ''  AS CNEE_A" ).append("\n"); 
		query.append("     , '' NTFY_N     , ''  AS NTFY_A   " ).append("\n"); 
		query.append("     , '' CNTR" ).append("\n"); 
		query.append("     , DECODE(DECODE(TRIM(NVL(C.CSTMS_CLR_TP_CD,' ')||NVL(C.USA_YD_CD,' ')),'',0," ).append("\n"); 
		query.append("        LENGTH(TRIM(NVL(C.CSTMS_CLR_TP_CD,' ')||NVL(C.USA_YD_CD,' ')))),0,'N','Y') BAC" ).append("\n"); 
		query.append("	 , DECODE(@[in_bound],'I',DECODE(DECODE(TRIM(NVL(C.BD_TP_CD,' ')),'',0," ).append("\n"); 
		query.append("        LENGTH(TRIM(NVL(C.BD_TP_CD,' ')))),0,'N'," ).append("\n"); 
		query.append("        DECODE(DECODE(TRIM(NVL(C.CSTMS_CLR_WH_CD,' ')),'',0," ).append("\n"); 
		query.append("        LENGTH(TRIM(NVL(C.CSTMS_CLR_WH_CD,' ')))),0,'N','Y')),' ') WH" ).append("\n"); 
		query.append("     , DECODE(@[in_bound], 'O', NVL(E.KR_CSTMS_CUST_TP_CD,'N'), NVL(C.KR_CSTMS_BL_TP_CD,'N')) SC" ).append("\n"); 
		query.append("     , DECODE(@[in_bound],'I',DECODE(DECODE(TRIM(NVL(C.MF_REF_NO,' ')),0," ).append("\n"); 
		query.append("        LENGTH(TRIM(NVL(C.MF_SEQ,' ')))),0,'N','Y'),' ') HIDDEN5" ).append("\n"); 
		query.append("     , '' DESC_CODE" ).append("\n"); 
		query.append("     , '' TR" ).append("\n"); 
		query.append("     , DECODE(NVL(B.REP_CMDT_CD,' '), ' ', 'N', 'Y') CM" ).append("\n"); 
		query.append("     , '' BZ" ).append("\n"); 
		query.append("     , '' ELNO_1" ).append("\n"); 
		query.append("     , '' ELNO_2" ).append("\n"); 
		query.append("     , '' CUSTOMER_NAME                                            " ).append("\n"); 
		query.append("     , DECODE(NVL(B.BKG_CGO_TP_CD,' '),'B','Y','N') HIDDEN3" ).append("\n"); 
		query.append("     , DECODE(DECODE(TRIM(NVL(C.CSTMS_CLR_TP_CD,' ')||NVL(C.USA_YD_CD,' ')),'',0," ).append("\n"); 
		query.append("        LENGTH(TRIM(NVL(C.CSTMS_CLR_TP_CD,' ')||NVL(C.USA_YD_CD,' ')))),0,'N','Y') HIDDEN4" ).append("\n"); 
		query.append("  FROM BKG_VVD  A" ).append("\n"); 
		query.append("     , BKG_BOOKING  B" ).append("\n"); 
		query.append("     , BKG_CSTMS_KR_MF_SEQ_NO  C" ).append("\n"); 
		query.append("     , BKG_BL_DOC  D" ).append("\n"); 
		query.append("     , BKG_BKG_HIS E" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.VSL_CD     = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("   AND A.POL_CD LIKE @[in_pol]||'%'" ).append("\n"); 
		query.append("   AND A.POD_CD LIKE @[in_pod]||'%'" ).append("\n"); 
		query.append("   AND A.BKG_NO        = B.bkg_no" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.BKG_NO        = D.bkg_no" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.BKG_NO        = E.bkg_no" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("   AND B.BL_NO         > ' '" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD    != 'X'" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD    != 'S'" ).append("\n"); 
		query.append("   AND B.BL_NO         = NVL(SUBSTR(@[in_blno],1,10),B.BL_NO)" ).append("\n"); 
		query.append("   AND B.BL_NO_TP      = NVL(SUBSTR(@[in_blno],11,1),B.BL_NO_TP)" ).append("\n"); 
		query.append("   AND B.BL_NO_CHK     = NVL(SUBSTR(@[in_blno],12,1),B.BL_NO_CHK)" ).append("\n"); 
		query.append("   AND B.BKG_NO        = C.BKG_NO(+)" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("   AND C.MF_REF_NO(+)  = @[mrn_nbr]" ).append("\n"); 
		query.append(" ORDER BY NVL(A.POL_CD,' ')" ).append("\n"); 
		query.append("        , NVL(A.POD_CD,' ')" ).append("\n"); 
		query.append("        , NVL(B.BL_NO,' ') || NVL(B.BL_NO_TP,' ') || NVL(B.BL_NO_CHK,' ') || NVL(B.BL_TP_CD,' ')" ).append("\n"); 

	}
}