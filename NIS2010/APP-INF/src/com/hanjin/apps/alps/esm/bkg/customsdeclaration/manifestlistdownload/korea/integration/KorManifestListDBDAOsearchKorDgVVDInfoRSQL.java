/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchKorDgVVDInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.26 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchKorDgVVDInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Korea VVD 기본정보 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchKorDgVVDInfoRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchKorDgVVDInfoRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(" ).append("\n"); 
		query.append("MAX(TO_CHAR(VVD_SEQ, '00')||" ).append("\n"); 
		query.append("MRN_NO||MRN_CHK_NO||CHR(9)|| /* MRN */" ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD||CHR(9)||" ).append("\n"); 
		query.append("VVD_SEQ||CHR(9)||" ).append("\n"); 
		query.append("PORT_CD||CHR(9)||" ).append("\n"); 
		query.append("IO_BND_CD||CHR(9)||" ).append("\n"); 
		query.append("VSL_NM||CHR(9)|| /* VSL FULL NAME  */" ).append("\n"); 
		query.append("KR_VSL_CALL_SGN_CD||CHR(9)|| /* CALL SIGN */" ).append("\n"); 
		query.append("TO_CHAR(MF_SND_DT, 'YYYY-MM-DD')||CHR(9)|| /*	SEND DATE	*/" ).append("\n"); 
		query.append("TO_CHAR(MF_SND_DT, 'HH24:MI')||CHR(9)|| /*	SEND DATE	*/" ).append("\n"); 
		query.append("INTER_CNG_CTRL_NO||CHR(9)|| /*	DOC	NO	*/" ).append("\n"); 
		query.append("KR_PORT_AUTH_CD||CHR(9)|| /* AUTHORITY */" ).append("\n"); 
		query.append("DECODE(IO_BND_CD,'I','01','02')||CHR(9)|| /* IO */" ).append("\n"); 
		query.append("CALL_KNT||CHR(9)|| /*	IN CNT	입항횟수	*/" ).append("\n"); 
		query.append("TO_CHAR(ARR_DT, 'YYYY-MM-DD HH24:MI')||CHR(9)|| /* ARRIVAL DATE */" ).append("\n"); 
		query.append("KR_CSTMS_DG_TRNS_CD||CHR(9)|| /*	TRANS CODE	*/" ).append("\n"); 
		query.append("KR_DCHG_CO_ID||CHR(9)|| /*	DISCHARGE  COMPANY CODE	*/" ).append("\n"); 
		query.append("DCHG_VNDR_NM||CHR(9)|| /*	DSCH COM	*/" ).append("\n"); 
		query.append("TTL_CNTR_KNT||CHR(9)|| /*	DSCH COM	*/" ).append("\n"); 
		query.append("DG_TTL_WGT||CHR(9)|| /*	TOTAL WEIGHT	*/" ).append("\n"); 
		query.append("KR_CSTMS_DCHG_N1ST_JB_CD||CHR(9)|| /*	JOB CODE 1	*/" ).append("\n"); 
		query.append("KR_CSTMS_DCHG_N2ND_JB_CD||CHR(9)|| /*	JOB CODE2	*/" ).append("\n"); 
		query.append("TO_CHAR(DCHG_FM_DT, 'YYYY-MM-DD HH24:MI')||CHR(9)|| /*	FROM DATE	*/" ).append("\n"); 
		query.append("TO_CHAR(DCHG_TO_DT, 'YYYY-MM-DD HH24:MI')||CHR(9)|| /*	TO DATE	*/" ).append("\n"); 
		query.append("PRE_CLPT_CD||CHR(9)|| /*	PREVIOUS PORT	*/" ).append("\n"); 
		query.append("PORT_AREA_N1ST_ID||CHR(9)|| /*	PORT AREA		*/" ).append("\n"); 
		query.append("PORT_AREA_N2ND_ID||CHR(9)|| /*	PORT ANCH		*/" ).append("\n"); 
		query.append("PORT_DESC||CHR(9)|| /*	PORT DESC	*/" ).append("\n"); 
		query.append("REP_SBST_CTNT||CHR(9)|| /*	SUBSTANCE	*/" ).append("\n"); 
		query.append("CNTC_PSON_DESC||CHR(9)|| /*	CONTACT	*/" ).append("\n"); 
		query.append("@[pol_cd]||CHR(9)||		/* ADD 시킬경우 INDICATOR로 사용 */" ).append("\n"); 
		query.append("@[pod_cd]||CHR(9)||		/* ADD 시킬경우 INDICATOR로 사용 */" ).append("\n"); 
		query.append("TO_CHAR(IO_BND_DT, 'YYYY-MM-DD HH24:MI')||CHR(9)||" ).append("\n"); 
		query.append("NVL(DCGO_SEQ, 0)||CHR(9)||" ).append("\n"); 
		query.append("NVL(TML_VSL_CD, ' ')||CHR(9)||" ).append("\n"); 
		query.append("NVL(TML_SKD_VOY_NO, ' ')||CHR(9)" ).append("\n"); 
		query.append("),	4) DATA" ).append("\n"); 
		query.append(", MAX(VVD_SEQ) MAX_VVD_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_DG_CGO_VVD" ).append("\n"); 
		query.append("WHERE IO_BND_CD	=	@[io_bnd_cd]" ).append("\n"); 
		query.append("AND PORT_CD		=	DECODE(@[io_bnd_cd], 'O', @[pol_cd], @[pod_cd])" ).append("\n"); 
		query.append("AND VSL_CD		=	SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO	=	SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD	=	SUBSTR(@[vvd], 9, 1)" ).append("\n"); 

	}
}