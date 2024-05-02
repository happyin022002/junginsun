/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOsearchBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaManifestListDownloadDBDAOsearchBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카세관 신고용 B/L List 를 조회한다.
	  * </pre>
	  */
	public SriLankaManifestListDownloadDBDAOsearchBlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaManifestListDownloadDBDAOsearchBlListRSQL").append("\n"); 
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
		query.append("SELECT * FROM " ).append("\n"); 
		query.append("	  (SELECT '' AS SEQ," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POD_CD, " ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       PCK_TP_CD," ).append("\n"); 
		query.append("       ACT_WGT," ).append("\n"); 
		query.append("       WGT_UT_CD," ).append("\n"); 
		query.append("       MEAS_QTY," ).append("\n"); 
		query.append("       MEAS_UT_CD," ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("	   VVD_POL," ).append("\n"); 
		query.append("	   VVD_POD," ).append("\n"); 
		query.append("       COUNT(DISTINCT BL_NO) OVER() AS BL_TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("       (SELECT NVL(B.BL_NO, ' ')||NVL(B.BL_TP_CD, ' ') AS BL_NO," ).append("\n"); 
		query.append("               NVL(B.POL_CD, ' ') AS POL_CD," ).append("\n"); 
		query.append("               NVL(B.POD_CD, ' ') AS POD_CD," ).append("\n"); 
		query.append("               NVL(B.DEL_CD, ' ') AS DEL_CD," ).append("\n"); 
		query.append("               TO_CHAR(NVL(C.PCK_QTY, 0), 'FM00000000') AS PCK_QTY," ).append("\n"); 
		query.append("               NVL(C.PCK_TP_CD, ' ') AS PCK_TP_CD," ).append("\n"); 
		query.append("               TO_CHAR(NVL(C.ACT_WGT, 0), 'FM00000000.000') AS ACT_WGT," ).append("\n"); 
		query.append("               NVL(C.WGT_UT_CD, ' ') AS WGT_UT_CD," ).append("\n"); 
		query.append("               TO_CHAR(NVL(C.MEAS_QTY, 0), 'FM00000000.000') AS MEAS_QTY," ).append("\n"); 
		query.append("               NVL(C.MEAS_UT_CD, ' ') AS MEAS_UT_CD," ).append("\n"); 
		query.append("               NVL(B.BKG_NO, ' ') AS BKG_NO," ).append("\n"); 
		query.append("			   NVL(A.POL_CD, ' ') AS VVD_POL," ).append("\n"); 
		query.append("               NVL(A.POD_CD, ' ') AS VVD_POD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_VVD A," ).append("\n"); 
		query.append("               BKG_BOOKING B," ).append("\n"); 
		query.append("               BKG_BL_DOC C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} == '')" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("           AND A.POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("           AND B.DEL_CD LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("		#if (${ts_tp_cd} == 'T')" ).append("\n"); 
		query.append("           AND A.POD_CD <> B.POD_CD" ).append("\n"); 
		query.append("		#elseif (${ts_tp_cd} == 'L')" ).append("\n"); 
		query.append("           AND A.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND A.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("           AND B.DEL_CD LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("		   	#if (${ts_tp_cd} == 'T')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A.POL_CD <> B.POL_CD" ).append("\n"); 
		query.append("		#elseif (${ts_tp_cd} == 'L')" ).append("\n"); 
		query.append("           AND A.POL_CD = B.POL_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND B.BL_NO > ' '" ).append("\n"); 
		query.append("           AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("#if (${cgo_tp_cd} == 'M')" ).append("\n"); 
		query.append("           AND B.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND B.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY NVL(B.BL_NO, ' ')||NVL(B.BL_TP_CD, ' ')," ).append("\n"); 
		query.append("          NVL(B.POL_CD, ' ')," ).append("\n"); 
		query.append("          NVL(B.POD_CD, ' ')," ).append("\n"); 
		query.append("          NVL(B.DEL_CD, ' ') ," ).append("\n"); 
		query.append("          TO_CHAR(NVL(C.PCK_QTY, 0), 'FM00000000')," ).append("\n"); 
		query.append("          NVL(C.PCK_TP_CD, ' ')," ).append("\n"); 
		query.append("          TO_CHAR(NVL(C.ACT_WGT, 0), 'FM00000000.000'), NVL(C.WGT_UT_CD, ' ')," ).append("\n"); 
		query.append("          TO_CHAR(NVL(C.MEAS_QTY, 0), 'FM00000000.000'), NVL(C.MEAS_UT_CD, ' ')," ).append("\n"); 
		query.append("          NVL(B.BKG_NO, ' ')," ).append("\n"); 
		query.append("          NVL(A.POL_CD, ' ') ," ).append("\n"); 
		query.append("          NVL(A.POD_CD, ' ') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY NVL(B.BL_NO, ' ')||NVL(B.BL_TP_CD, ' ')," ).append("\n"); 
		query.append("          NVL(B.POL_CD, ' ')," ).append("\n"); 
		query.append("          NVL(B.POD_CD, ' ')," ).append("\n"); 
		query.append("          NVL(B.DEL_CD, ' '))	" ).append("\n"); 
		query.append(") WHERE VVD_POL LIKE 'LK%' OR VVD_POD LIKE 'LK%'" ).append("\n"); 

	}
}