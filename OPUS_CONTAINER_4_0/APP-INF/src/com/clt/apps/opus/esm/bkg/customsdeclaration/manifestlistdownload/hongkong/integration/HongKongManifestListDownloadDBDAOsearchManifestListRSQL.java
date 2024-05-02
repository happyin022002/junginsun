/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : HongKongManifestListDownloadDBDAOsearchManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 이수진
*@LastVersion : 1.0
* 2011.02.22 이수진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Su Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HongKongManifestListDownloadDBDAOsearchManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 홍콩 세관에 적하목록을 신고하기 위해 BKG Manifest 정보를 조회한다.
	  * </pre>
	  */
	public HongKongManifestListDownloadDBDAOsearchManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.integration").append("\n"); 
		query.append("FileName : HongKongManifestListDownloadDBDAOsearchManifestListRSQL").append("\n"); 
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
		query.append("SELECT VVD_NUMBER, BKG_NO, BL_NO, MFSND_CODE, TERM_CD, CNHKG_CD, POR_CD," ).append("\n"); 
		query.append("BV_POL_CD, BV_POD_CD, DEL_CD, ACT_WGT, WGT_UT_CD, PCK_QTY, VSL_CD, SKD_VOY_NO, SKD_DIR_CD," ).append("\n"); 
		query.append("FRT_TERM_CD, HOT_DE_FLG, RC_FLG, MF_SND_DT, COUNT(DISTINCT BL_NO) OVER() total_bl" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NVL(BV.VSL_CD,' ')||NVL(BV.SKD_VOY_NO,' ')||NVL(BV.SKD_DIR_CD,' ') vvd_number," ).append("\n"); 
		query.append("BKG.BKG_NO ,BV.VSL_CD,BV.SKD_VOY_NO,BV.SKD_DIR_CD," ).append("\n"); 
		query.append("NVL(BKG.BL_NO||BKG.BL_TP_CD,' ') bl_no," ).append("\n"); 
		query.append("DECODE(HSL.MF_SND_DT, '', 'F', 'A') mfsnd_code," ).append("\n"); 
		query.append("NVL(BKG.RCV_TERM_CD||BKG.DE_TERM_CD,'  ') term_cd," ).append("\n"); 
		query.append("DECODE(BV.POL_CD, 'CNHKG', DECODE(BKG.POL_CD, 'CNHKG', BKG_GET_BKG_CTMS_CD_FNC('HK','MANI_PORT_CD_HKG','1',1), BKG_GET_BKG_CTMS_CD_FNC('HK','MANI_PORT_CD_HKG','2',1))," ).append("\n"); 
		query.append("DECODE(BV.POD_CD, 'CNHKG', DECODE(BKG.POD_CD,'CNHKG',BKG_GET_BKG_CTMS_CD_FNC('HK','MANI_PORT_CD_HKG','1',1),BKG_GET_BKG_CTMS_CD_FNC('HK','MANI_PORT_CD_HKG','2',1)), ' ')) CNHKG_CD," ).append("\n"); 
		query.append("BKG.POR_CD, BV.POL_CD BV_POL_CD, BV.POD_CD BV_POD_CD, BKG.DEL_CD," ).append("\n"); 
		query.append("DOC.ACT_WGT, DOC.WGT_UT_CD," ).append("\n"); 
		query.append("DOC.PCK_QTY," ).append("\n"); 
		query.append("NVL(BR.FRT_TERM_CD, ' ') FRT_TERM_CD," ).append("\n"); 
		query.append("DECODE(BKG.HOT_DE_FLG, 'Y', 'H', ' ') HOT_DE_FLG," ).append("\n"); 
		query.append("DECODE(BKG.RC_FLG, 'Y', 'R', ' ') RC_FLG," ).append("\n"); 
		query.append("MAX(TO_CHAR(HSL.MF_SND_DT,'YYYY-MM-DD')) MF_SND_DT" ).append("\n"); 
		query.append("FROM  BKG_BOOKING BKG, BKG_BL_DOC DOC, BKG_RATE BR, BKG_VVD BV, BKG_CSTMS_HKG_SND_LOG HSL" ).append("\n"); 
		query.append("WHERE BV.VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BKG.BKG_NO       = BV.BKG_NO" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("AND BV.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("AND BV.POd_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BV.VSL_CD       = HSL.VSL_CD(+)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO= HSL.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD   = HSL.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND (BKG.BKG_STS_CD ='F' OR BKG.BKG_STS_CD = 'W')" ).append("\n"); 
		query.append("AND BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("AND BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("AND BKG.BKG_NO       = DOC.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO       = BR.BKG_NO" ).append("\n"); 
		query.append("GROUP BY NVL(BV.VSL_CD,' ')||NVL(BV.SKD_VOY_NO,' ')||NVL(BV.SKD_DIR_CD,' ')," ).append("\n"); 
		query.append("BKG.BKG_NO ,BV.VSL_CD,BV.SKD_VOY_NO,BV.SKD_DIR_CD," ).append("\n"); 
		query.append("NVL(BKG.BL_NO||BKG.BL_TP_CD,' ')," ).append("\n"); 
		query.append("DECODE(HSL.MF_SND_DT, '', 'F', 'A')," ).append("\n"); 
		query.append("NVL(BKG.RCV_TERM_CD||BKG.DE_TERM_CD,'  ')," ).append("\n"); 
		query.append("DECODE(BV.POL_CD, 'CNHKG', DECODE(BKG.POL_CD, 'CNHKG', BKG_GET_BKG_CTMS_CD_FNC('HK','MANI_PORT_CD_HKG','1',1), BKG_GET_BKG_CTMS_CD_FNC('HK','MANI_PORT_CD_HKG','2',1))," ).append("\n"); 
		query.append("DECODE(BV.POD_CD, 'CNHKG', DECODE(BKG.POD_CD,'CNHKG',BKG_GET_BKG_CTMS_CD_FNC('HK','MANI_PORT_CD_HKG','1',1),BKG_GET_BKG_CTMS_CD_FNC('HK','MANI_PORT_CD_HKG','2',1)), ' '))," ).append("\n"); 
		query.append("BKG.POR_CD, BV.POL_CD , BV.POD_CD , BKG.DEL_CD," ).append("\n"); 
		query.append("DOC.ACT_WGT, DOC.WGT_UT_CD," ).append("\n"); 
		query.append("DOC.PCK_QTY," ).append("\n"); 
		query.append("NVL(BR.FRT_TERM_CD, ' ')," ).append("\n"); 
		query.append("DECODE(BKG.HOT_DE_FLG, 'Y', 'H', ' ')," ).append("\n"); 
		query.append("DECODE(BKG.RC_FLG, 'Y', 'R', ' ')" ).append("\n"); 
		query.append("ORDER BY BV.POL_CD, BV.POD_CD,NVL(BKG.BL_NO||BKG.BL_TP_CD,' '))" ).append("\n"); 

	}
}