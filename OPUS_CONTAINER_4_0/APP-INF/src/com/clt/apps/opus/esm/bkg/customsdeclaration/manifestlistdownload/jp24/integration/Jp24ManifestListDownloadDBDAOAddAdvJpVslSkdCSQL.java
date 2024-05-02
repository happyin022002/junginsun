/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOAddAdvJpVslSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOAddAdvJpVslSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOAddAdvJpVslSkdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_edi_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlx_div",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOAddAdvJpVslSkdCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ADV_JP_VSL_SKD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        POL_CD," ).append("\n"); 
		query.append("        YD_SEQ," ).append("\n"); 
		query.append("        ETA_DT," ).append("\n"); 
		query.append("        ETB_DT," ).append("\n"); 
		query.append("        ETD_DT," ).append("\n"); 
		query.append("        CALL_SGN_NO," ).append("\n"); 
		query.append("        JO_CD1," ).append("\n"); 
		query.append("        MF_SND_FLG," ).append("\n"); 
		query.append("        FNL_EDI_SND_FLG," ).append("\n"); 
		query.append("        IB_CSSM_VOY_NO," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       VPS_PORT_CD," ).append("\n"); 
		query.append("       @[pol_split_no]," ).append("\n"); 
		query.append("       VPS_ETA_DT," ).append("\n"); 
		query.append("       TO_DATE(@[vps_dt], 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("       VPS_ETD_DT," ).append("\n"); 
		query.append("       @[call_sgn_no]," ).append("\n"); 
		query.append("       DECODE(@[rlx_div], '1', 'Y', NULL)," ).append("\n"); 
		query.append("       DECODE(@[mf_snd_flg], 'Y', 'Y', 'N')," ).append("\n"); 
		query.append("       DECODE(@[fnl_edi_snd_flg], 'Y', 'Y', 'N')," ).append("\n"); 
		query.append("       NVL(@[ib_cssm_voy_no], '')," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND CLPT_IND_SEQ = " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT MIN(P.CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                 FROM VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                  AND P.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                  AND P.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                  AND P.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                  AND P.VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("                                  AND NVL(P.SKD_CNG_STS_CD, 'X') <> 'S') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}