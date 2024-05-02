/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KorManifestListDBDAOSearchWhfPortRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchWhfPortRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KOREA WHF Port Rate 구하기
	  * </pre>
	  */
	public KorManifestListDBDAOSearchWhfPortRtRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchWhfPortRtRSQL").append("\n"); 
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
		query.append("SELECT PRT.FEU_PRC AS CHG_UT_AMT" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_PORT_RT PRT" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("WHERE SKD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND SKD.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("AND SKD.CLPT_IND_SEQ ='1'" ).append("\n"); 
		query.append("AND SKD.VPS_PORT_CD = PRT.PORT_CD" ).append("\n"); 
		query.append("AND PRT.CNTR_BLK_DIV_CD = 'B'" ).append("\n"); 
		query.append("AND PRT.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND SKD.VPS_ETA_DT >= PRT.EFF_FM_DT" ).append("\n"); 
		query.append("AND SKD.VPS_ETA_DT <= PRT.EFF_TO_DT" ).append("\n"); 

	}
}