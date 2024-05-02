/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOsearchVesselVpsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.03.18 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaManifestListDownloadDBDAOsearchVesselVpsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Port Schedula
	  * </pre>
	  */
	public SriLankaManifestListDownloadDBDAOsearchVesselVpsRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaManifestListDownloadDBDAOsearchVesselVpsRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD') VPS_ETA_DT, TO_CHAR(VPS_ETA_DT,'HH24:MI:SS') VPS_ETA_DT_TIME, " ).append("\n"); 
		query.append("   	   BKG_GET_BKG_CTMS_CD_FNC('LK','MANI_PORT_CD',1,1)  arrival_port_cd, COM_ConstantMgr_PKG.COM_getCompanyName_FNC() shipping_agent, COM_ConstantMgr_PKG.COM_getCompanyName_FNC() local_agent" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD        =  @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    VPS_PORT_CD    = @[pod_cd]" ).append("\n"); 
		query.append("AND    NVL(SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("AND    CLPT_SEQ  = (SELECT  MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("			FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("			WHERE   VSL_CD        =  @[vsl_cd]" ).append("\n"); 
		query.append("			AND     SKD_VOY_NO    =  @[skd_voy_no]" ).append("\n"); 
		query.append("			AND     SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("			AND     VPS_PORT_CD    = @[pod_cd]" ).append("\n"); 
		query.append("			AND     NVL(SKD_CNG_STS_CD,' ') <> 'S')" ).append("\n"); 

	}
}