/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyTransStageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyTransStageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 갱신
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyTransStageUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("command",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyTransStageUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("	SET CSTMS_MF_TP_CD = @[command]," ).append("\n"); 
		query.append("		MF_SND_DT = DECODE(@[command], 'MI', GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', sysdate, 'USNYC'), MF_SND_DT)," ).append("\n"); 
		query.append("		AMDT_SND_DT = DECODE(@[command], 'AI', GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', sysdate, 'USNYC'), AMDT_SND_DT)" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	CNT_CD = 'US'" ).append("\n"); 
		query.append("	AND BL_NO      = @[bl_no]" ).append("\n"); 

	}
}