/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KorManifestListDBDAOSearchWhfWaveInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
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

public class KorManifestListDBDAOSearchWhfWaveInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WHF Wave정보를 Manifest hard coding 테이블에서 찾아오기
	  * </pre>
	  */
	public KorManifestListDBDAOSearchWhfWaveInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_wave",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchWhfWaveInfoRSQL").append("\n"); 
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
		query.append("SELECT CTNT.ATTR_CTNT1 AS WHF_WAVE_ENG" ).append("\n"); 
		query.append("       , CTNT.ATTR_CTNT2 AS WHF_WAVE_KOR" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT CTNT" ).append("\n"); 
		query.append("WHERE CTNT.CNT_CD ='KR'" ).append("\n"); 
		query.append("AND CTNT.CSTMS_DIV_ID ='KR_WHF_EXEMPT_CD'" ).append("\n"); 
		query.append("AND CTNT.ATTR_CTNT3 = @[whf_wave]" ).append("\n"); 

	}
}