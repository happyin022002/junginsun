/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyTransStage2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.11.30 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyTransStage2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyTransStage2
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyTransStage2USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cstms_mf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_trsm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyTransStage2USQL").append("\n"); 
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
		query.append("SET CSTMS_MF_TP_CD = @[cstms_mf_tp_cd]," ).append("\n"); 
		query.append("MF_SND_DT = DECODE(@[cstms_mf_tp_cd], 'MI', GLOBALDATE_PKG.TIME_CONV_FNC ('KRACY', sysdate, 'USNYC'), MF_SND_DT)," ).append("\n"); 
		query.append("AMDT_SND_DT = DECODE(@[cstms_mf_tp_cd], 'AI', GLOBALDATE_PKG.TIME_CONV_FNC ('KRACY', sysdate, 'USNYC'), AMDT_SND_DT)" ).append("\n"); 
		query.append(",CSTMS_TRSM_STS_CD = @[cstms_trsm_sts_cd]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CNT_CD = 'US'" ).append("\n"); 
		query.append("AND BL_NO      = @[bl_no]" ).append("\n"); 

	}
}