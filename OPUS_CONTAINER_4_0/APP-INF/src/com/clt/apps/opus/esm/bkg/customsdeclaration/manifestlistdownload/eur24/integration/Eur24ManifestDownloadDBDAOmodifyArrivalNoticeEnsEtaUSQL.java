/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOmodifyArrivalNoticeEnsEtaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.04.24 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOmodifyArrivalNoticeEnsEtaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ENS ETA 수정 값으로 업데이트
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOmodifyArrivalNoticeEnsEtaUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("init_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOmodifyArrivalNoticeEnsEtaUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("   SET CSTMS_ESTM_ARR_DT = TO_DATE(@[init_eta_dt], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 

	}
}