/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorManifestListDBDAOSearchMaxTransSeqKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.24 
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

public class KorManifestListDBDAOSearchMaxTransSeqKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전송된 데이터중에서 Max Seq를 구한다.
	  * (전송된 데이터를 삭제하면 안되므로 전송데이터의 Max seq를 구해서 max seq보다 큰 seq이면서 전송되지 않은 데이터를 삭제할 예정임)
	  * </pre>
	  */
	public KorManifestListDBDAOSearchMaxTransSeqKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchMaxTransSeqKorRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(TRNS_SEQ),0) MAX_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if(${kcd_tp} == 'I' || ${kcd_tp} == 'T')" ).append("\n"); 
		query.append("AND CSTMS_DECL_TP_CD IN ('I','T')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND CSTMS_DECL_TP_CD IN ('E','R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DMST_PORT_CD = @[kt_port]" ).append("\n"); 
		query.append("AND CSTMS_BL_NO = @[c_bl_no]" ).append("\n"); 
		query.append("AND MF_SND_DT IS NOT NULL" ).append("\n"); 

	}
}