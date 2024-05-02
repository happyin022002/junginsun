/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ThailandManifestListDownloadDBDAOsearchVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ThailandManifestListDownloadDBDAOsearchVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ThailandManifestListDownloadDBDAOsearchVvdListRSQL 생성 쿼리
	  * </pre>
	  */
	public ThailandManifestListDownloadDBDAOsearchVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration").append("\n"); 
		query.append("FileName : ThailandManifestListDownloadDBDAOsearchVvdListRSQL").append("\n"); 
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
		query.append("B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS TRNK_VVD," ).append("\n"); 
		query.append("A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS FEEDER," ).append("\n"); 
		query.append("B.POL_CD," ).append("\n"); 
		query.append("B.POD_CD," ).append("\n"); 
		query.append("TO_CHAR(C.VPS_ETA_DT,'YYYY-MM-DD HH24:MM') AS ETA_DT," ).append("\n"); 
		query.append("COUNT(B.BKG_NO) SUBTOTAL" ).append("\n"); 
		query.append("FROM BKG_VVD A, BKG_BOOKING B, VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.POL_CD = C.VPS_PORT_CD" ).append("\n"); 
		query.append("AND A.POL_CLPT_IND_SEQ = C.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND B.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("AND A.VSL_CD = SUBSTR(@[s_vvd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[s_vvd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[s_vvd],9,1)" ).append("\n"); 
		query.append("AND B.DEL_CD = @[s_del_cd]" ).append("\n"); 
		query.append("AND B.DEL_NOD_CD like NVL(@[s_del_cd]||@[s_del_nod_cd]||'%','%')" ).append("\n"); 
		query.append("AND B.POL_CD like NVL(@[s_pol_cd]||'%','%')" ).append("\n"); 
		query.append("GROUP BY B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, B.POL_CD, B.POD_CD, C.VPS_ETA_DT" ).append("\n"); 

	}
}