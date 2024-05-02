/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorManifestListDBDAOsearchIbTsMtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.27 
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

public class KorManifestListDBDAOsearchIbTsMtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2009/12/22일 이후 Outbound로 다운로드된 데이터중에서 Inbound B/L정보를 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchIbTsMtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchIbTsMtInfoRSQL").append("\n"); 
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
		query.append("SELECT	A.VSL_CD IN_VSL," ).append("\n"); 
		query.append("A.SKD_VOY_NO IN_VOY," ).append("\n"); 
		query.append("A.SKD_DIR_CD  IN_DIR," ).append("\n"); 
		query.append("TO_CHAR(A.ETA_DT,'YYYYMMDD hh24:mi')  IN_ETA," ).append("\n"); 
		query.append("A.TRNS_SEQ  IN_SEQ," ).append("\n"); 
		query.append("A.DMST_PORT_CD  IN_PORT," ).append("\n"); 
		query.append("A.CSTMS_DECL_TP_CD  IN_TP_CD," ).append("\n"); 
		query.append("A.CSTMS_BL_NO  IN_C_BL," ).append("\n"); 
		query.append("A.BKG_NO  IN_BKG," ).append("\n"); 
		query.append("A.MST_BL_SEQ_NO  IN_MSN," ).append("\n"); 
		query.append("A.BKG_CGO_TP_CD  IN_CGO_TP," ).append("\n"); 
		query.append("A.POR_CD," ).append("\n"); 
		query.append("A.POL_CD," ).append("\n"); 
		query.append("A.POD_CD," ).append("\n"); 
		query.append("A.DEL_CD" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_BL A" ).append("\n"); 
		query.append("WHERE  	A.CSTMS_BL_NO 			= @[c_bl_no]" ).append("\n"); 
		query.append("AND  	A.CSTMS_DECL_TP_CD    	IN ('I','T')" ).append("\n"); 
		query.append("AND 	TRIM(A.MF_SND_DT) 		IS NOT NULL" ).append("\n"); 
		query.append("AND 	NVL(A.DELT_FLG,'N')   	<> 'Y'" ).append("\n"); 
		query.append("ORDER BY A.MF_SND_DT DESC" ).append("\n"); 

	}
}