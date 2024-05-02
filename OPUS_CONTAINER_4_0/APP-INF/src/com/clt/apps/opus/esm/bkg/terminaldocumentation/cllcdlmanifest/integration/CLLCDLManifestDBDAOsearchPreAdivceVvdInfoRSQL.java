/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchPreAdivceVvdInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.14
*@LastModifier :
*@LastVersion : 1.0
* 2013.03.14
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

public class CLLCDLManifestDBDAOsearchPreAdivceVvdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 화면 ESM_BKG_1153 의 그리드 1 조회 하는 쿼리 searchPreAdivceVvdInfo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchPreAdivceVvdInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_full_rtn_yd_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchPreAdivceVvdInfoRSQL").append("\n");
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
		query.append("SELECT " ).append("\n");
		query.append("    B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD, " ).append("\n");
		query.append("    B.POL_CD AS POL_CD,   " ).append("\n");
		query.append("    COUNT(B.BKG_NO) SUBTOTAL" ).append("\n");
		query.append("  FROM BKG_VVD A, BKG_BOOKING B" ).append("\n");
		query.append(" WHERE 1=1 " ).append("\n");
		query.append("   AND A.BKG_NO = B.BKG_NO " ).append("\n");
		query.append("   AND B.BKG_STS_CD != 'X' " ).append("\n");
		query.append("   AND A.VSL_CD = SUBSTR(@[s_vvd],1,4)" ).append("\n");
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[s_vvd],5,4)" ).append("\n");
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[s_vvd],9,1)" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if(${s_full_rtn_yd_cd} != '')" ).append("\n");
		query.append("   AND B.FULL_RTN_YD_CD like NVL(@[s_full_rtn_yd_cd]||@[s_full_rtn_yd_nod_cd]||'%','%')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if(${s_pol_cd} != '')" ).append("\n");
		query.append("   AND A.POL_CD like NVL(@[s_pol_cd]||'%','%')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if(${s_por_cd} != '')" ).append("\n");
		query.append("   AND B.POR_CD like NVL(@[s_por_cd]||'%','%')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("   AND 'Y' = (  SELECT MAX(DECODE(CNMV_STS_CD,'OP','Y','N')) " ).append("\n");
		query.append("				FROM BKG_CONTAINER " ).append("\n");
		query.append("				WHERE BKG_NO = A.BKG_NO " ).append("\n");
		query.append("			#if(${op_fm_dt} != '' && ${op_to_dt} != '')" ).append("\n");
		query.append("				AND CNMV_EVNT_DT BETWEEN TO_DATE(@[op_fm_dt],'YYYY-MM-DD') AND TO_DATE(@[op_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n");
		query.append("			#end" ).append("\n");
		query.append("			 )" ).append("\n");
		query.append("GROUP BY B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, B.POL_CD" ).append("\n");

	}
}