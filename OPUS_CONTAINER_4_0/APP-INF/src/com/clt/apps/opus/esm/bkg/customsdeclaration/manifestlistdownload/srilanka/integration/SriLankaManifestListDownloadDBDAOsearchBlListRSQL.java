/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOsearchBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.17 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' seq,bl_no," ).append("\n"); 
		query.append("pol_cd,  pod_cd, del_cd," ).append("\n"); 
		query.append("pck_qty, pck_tp_cd," ).append("\n"); 
		query.append("act_wgt, wgt_ut_cd," ).append("\n"); 
		query.append("meas_qty,  meas_ut_cd," ).append("\n"); 
		query.append("bkg_no," ).append("\n"); 
		query.append("COUNT(DISTINCT bl_no) OVER() BL_TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT NVL(B.BL_NO,' ') bl_no," ).append("\n"); 
		query.append("NVL(B.POL_CD,' ') pol_cd, NVL(B.POD_CD,' ') pod_cd, NVL(B.DEL_CD,' ') del_cd," ).append("\n"); 
		query.append("TO_CHAR(NVL(C.PCK_QTY,0),'FM00000000') pck_qty, NVL(C.PCK_TP_CD,' ') pck_tp_cd," ).append("\n"); 
		query.append("TO_CHAR(TRUNC(NVL(C.ACT_WGT,0),0),'FM00000000') act_wgt, NVL(C.WGT_UT_CD,' ') wgt_ut_cd," ).append("\n"); 
		query.append("TO_CHAR(NVL(C.MEAS_QTY,0),'FM00000000.000') meas_qty, NVL(C.MEAS_UT_CD,' ') meas_ut_cd," ).append("\n"); 
		query.append("NVL(B.BKG_NO,' ') bkg_no" ).append("\n"); 
		query.append("FROM   BKG_VVD A, BKG_BOOKING B, BKG_BL_DOC C" ).append("\n"); 
		query.append("WHERE  A.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("AND    B.POD_CD       LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("AND    B.DEL_CD       LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("AND    B.BL_NO         > ' '" ).append("\n"); 
		query.append("AND    B.BKG_STS_CD       != 'X'" ).append("\n"); 
		query.append("AND    B.BKG_STS_CD       != 'S'" ).append("\n"); 
		query.append("AND	   B.BKG_CGO_TP_CD    != 'P'" ).append("\n"); 
		query.append("AND    A.BKG_NO        = C.BKG_NO" ).append("\n"); 
		query.append("group by NVL(B.BL_NO,' ')," ).append("\n"); 
		query.append("NVL(B.POL_CD,' ') , NVL(B.POD_CD,' ') , NVL(B.DEL_CD,' ') ," ).append("\n"); 
		query.append("TO_CHAR(NVL(C.PCK_QTY,0),'FM00000000') , NVL(C.PCK_TP_CD,' ') ," ).append("\n"); 
		query.append("TO_CHAR(TRUNC(NVL(C.ACT_WGT,0),0),'FM00000000'), NVL(C.WGT_UT_CD,' ')," ).append("\n"); 
		query.append("TO_CHAR(NVL(C.MEAS_QTY,0),'FM00000000.000'), NVL(C.MEAS_UT_CD,' ')," ).append("\n"); 
		query.append("NVL(B.BKG_NO,' ')" ).append("\n"); 
		query.append("ORDER BY NVL(B.BL_NO,' '), NVL(B.POL_CD,' '), NVL(B.POD_CD,' '), NVL(B.DEL_CD,' '))" ).append("\n"); 

	}
}