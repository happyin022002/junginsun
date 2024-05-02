/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongManifestListDownloadDBDAOsearchVesselRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.14 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HongKongManifestListDownloadDBDAOsearchVesselRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 홍콩 세관에 적하목록을 신고하기 위해 Vessel 정보를 조회한다.
	  * </pre>
	  */
	public HongKongManifestListDownloadDBDAOsearchVesselRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.integration").append("\n"); 
		query.append("FileName : HongKongManifestListDownloadDBDAOsearchVesselRSQL").append("\n"); 
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
		query.append("SELECT NVL(VS.VSL_ENG_NM,' ') VSL_ENG_NM," ).append("\n"); 
		query.append("NVL(VS.CALL_SGN_NO,' ') CALL_SGN_NO" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append(",TO_CHAR(VP.VPS_ETA_DT,'YYYY-MM-DD') ETA_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append(",TO_CHAR(VP.VPS_ETD_DT,'YYYY-MM-DD') ETA_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  MDM_VSL_CNTR VS, VSK_VSL_PORT_SKD VP" ).append("\n"); 
		query.append("WHERE VP.VSL_CD       	= @[vsl_cd]" ).append("\n"); 
		query.append("AND VP.SKD_VOY_NO	   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND VP.SKD_DIR_CD   	= @[skd_dir_cd]" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("AND VP.VPS_PORT_CD	= @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("AND VP.VPS_PORT_CD	= @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND VS.VSL_CD 		= VP.VSL_CD" ).append("\n"); 

	}
}