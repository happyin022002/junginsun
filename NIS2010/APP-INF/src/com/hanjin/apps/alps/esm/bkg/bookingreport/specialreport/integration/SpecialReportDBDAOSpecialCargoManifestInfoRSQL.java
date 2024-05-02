/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialReportDBDAOSpecialCargoManifestInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialReportDBDAOSpecialCargoManifestInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpecialCargoManifestInfo
	  * </pre>
	  */
	public SpecialReportDBDAOSpecialCargoManifestInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration").append("\n"); 
		query.append("FileName : SpecialReportDBDAOSpecialCargoManifestInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       @[pol_cd] AS POL_CD," ).append("\n"); 
		query.append("       @[pod_cd] AS POD_CD," ).append("\n"); 
		query.append("       @[vsl_cd] AS VSL_CD," ).append("\n"); 
		query.append("       @[skd_voy_no] AS SKD_VOY_NO," ).append("\n"); 
		query.append("       @[skd_dir_cd] AS SKD_DIR_CD," ).append("\n"); 
		query.append("       @[pol_yd_cd] AS POL_YD_CD," ).append("\n"); 
		query.append("       @[pod_yd_cd] AS POD_YD_CD," ).append("\n"); 
		query.append("       REPLACE(TRANSLATE(NVL(SP.VSL_ENG_NM,' '),CHR(13)||CHR(10),' '),CHR(34),' ') AS VESSEL_NAME," ).append("\n"); 
		query.append("       NVL((SELECT REPLACE(SUBSTR(NVL(CNT.CNT_NM,' '),1,20),CHR(34),' ') FROM MDM_COUNTRY CNT WHERE CNT.CNT_CD = SP.VSL_FLG),'') AS NATIONALITY," ).append("\n"); 
		query.append("       NVL(SP.VSL_OFFCL_NO,' ') AS OFFICIAL_NO," ).append("\n"); 
		query.append("       NVL(SP.VSL_CALL_SIGN,' ') AS CALL_SIGN," ).append("\n"); 
		query.append("       SP.SKD_VOY_NO||SP.SKD_DIR_CD AS VOYAGE_NO," ).append("\n"); 
		query.append("       'FULL CONTAINER SHIP' AS KIND_OF_SHIP," ).append("\n"); 
		query.append("       NVL2(@[pol_cd],REPLACE(TRANSLATE(NVL(SP.POL_DESC, ' '), CHR(13) || CHR(10), ' '), CHR(34), ' ')||'   '||" ).append("\n"); 
		query.append("       (SELECT NVL(YD.YD_NM, ' ') FROM MDM_YARD YD WHERE SP.VVD_POL || SUBSTR(SP.POL_YD_CD,6,2) = YD.YD_CD),NULL) AS POL_NAME," ).append("\n"); 
		query.append("       NVL2(@[pod_cd],REPLACE(TRANSLATE(NVL(SP.POD_DESC, ' '), CHR(13) || CHR(10), ' '), CHR(34), ' ')||'   '||" ).append("\n"); 
		query.append("       (SELECT NVL(YD.YD_NM, ' ') FROM MDM_YARD YD WHERE SP.VVD_POD || SUBSTR(SP.POD_YD_CD,6,2) = YD.YD_CD),NULL) AS POD_NAME" ).append("\n"); 
		query.append("FROM   BKG_SP_V SP" ).append("\n"); 
		query.append("WHERE  SP.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SP.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SP.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if (''!=${pol_cd})" ).append("\n"); 
		query.append("AND    SP.VVD_POL LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("AND    NVL(SUBSTR(SP.POL_YD_CD,6,2),' ') LIKE @[pol_yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${pod_cd})" ).append("\n"); 
		query.append("AND    SP.VVD_POD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("AND    NVL(SUBSTR(SP.POD_YD_CD,6,2),' ') LIKE @[pod_yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}