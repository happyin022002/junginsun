/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchHubLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchHubLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHubLoc
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchHubLocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchHubLocRSQL").append("\n"); 
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
		query.append("SELECT NVL(LOC_CD, (SELECT SCC_CD FROM BKG_CSTMS_ADV_BL B, MDM_LOCATION M WHERE B.DEL_CD = M.LOC_CD AND B.CNT_CD = 'US' AND BL_NO = @[bl_no]))" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MIN(M.PRIO_SEQ)," ).append("\n"); 
		query.append("MIN(M.ROUT_SEQ)," ).append("\n"); 
		query.append("MIN(M.INLND_ROUT_TMP_FLG)," ).append("\n"); 
		query.append("MAX(DECODE(M.TRSP_MOD_CD, 'WD', SUBSTR(M.ROUT_DEST_NOD_CD, 1, 5), SUBSTR(M.HUB_NOD_CD, 1, 5))) LOC_CD" ).append("\n"); 
		query.append("--, PRIO_SEQ, INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("from PRD_INLND_ROUT_MST M" ).append("\n"); 
		query.append(",PRD_INLND_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE M.INLND_ROUT_BKG_FLG = 'Y'" ).append("\n"); 
		query.append("AND M.PCTL_IO_BND_CD     = 'I'" ).append("\n"); 
		query.append("AND M.ROUT_ORG_NOD_CD  LIKE @[pod_nod_cd]||'%' --BKG_BOOKING.POD_NOD_CD" ).append("\n"); 
		query.append("AND M.ROUT_DEST_NOD_CD LIKE @[del_nod_cd]||'%' --BKG_BOOKING.DEL_NOD_CD" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG , 'N') = 'N'" ).append("\n"); 
		query.append("AND M.ROUT_ORG_NOD_CD  = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND M.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}