/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchPolPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2015.08.04 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchPolPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPolPod(단건)
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchPolPodRSQL(){
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchPolPodRSQL").append("\n"); 
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
		query.append("SELECT  MAX(NVL(S1.POL_YD_CD,' ')) AS POL_CD" ).append("\n"); 
		query.append("       ,MAX(NVL(S1.POD_YD_CD,' ')) AS POD_CD" ).append("\n"); 
		query.append("       ,MAX(NVL(TO_CHAR(S3.VPS_ETD_DT,'YYYYMMDD'),' ')) AS VPS_ETD_DT" ).append("\n"); 
		query.append("       ,MAX(NVL(TO_CHAR(S4.VPS_ETA_DT,'YYYYMMDD'),' ')) AS VPS_ETA_DT" ).append("\n"); 
		query.append("       ,@[vsl_cd] VSL_CD" ).append("\n"); 
		query.append("       ,@[skd_voy_no] SKD_VOY_NO" ).append("\n"); 
		query.append("       ,@[skd_dir_cd] SKD_DIR_CD" ).append("\n"); 
		query.append("  FROM  BKG_VVD S1" ).append("\n"); 
		query.append("       ,VSK_VSL_PORT_SKD S3" ).append("\n"); 
		query.append("       ,VSK_VSL_PORT_SKD S4" ).append("\n"); 
		query.append(" WHERE  S1.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("   AND  S1.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND  S1.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND  S1.POD_CD         = @[pod_cd]" ).append("\n"); 
		query.append("   AND  S1.VSL_CD         = S3.vsl_cd" ).append("\n"); 
		query.append("   AND  S1.SKD_VOY_NO     = S3.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  S1.SKD_DIR_CD     = S3.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  S1.POL_CD         = S3.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND  S3.CLPT_IND_SEQ   =  '1'" ).append("\n"); 
		query.append("   AND  S1.VSL_CD         = S4.VSL_CD" ).append("\n"); 
		query.append("   AND  S1.SKD_VOY_NO     = S4.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  S1.SKD_DIR_CD     = S4.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  S4.CLPT_IND_SEQ   = '1'" ).append("\n"); 

	}
}