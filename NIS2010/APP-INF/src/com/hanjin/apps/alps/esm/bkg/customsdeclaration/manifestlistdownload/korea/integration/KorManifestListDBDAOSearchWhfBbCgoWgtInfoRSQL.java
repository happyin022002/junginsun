/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KorManifestListDBDAOSearchWhfBbCgoWgtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
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

public class KorManifestListDBDAOSearchWhfBbCgoWgtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BB CGO정보를 가져와서 WHF에 필요한 WGT정보 구하기
	  * </pre>
	  */
	public KorManifestListDBDAOSearchWhfBbCgoWgtInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchWhfBbCgoWgtInfoRSQL").append("\n"); 
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
		query.append("SELECT CEIL(SUM(VOL)) CBM_AMT" ).append("\n"); 
		query.append("      , CEIL(SUM(TON_WGT)) TON_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT BKG_NO" ).append("\n"); 
		query.append("            , BB_CGO_SEQ" ).append("\n"); 
		query.append("            , DIM_LEN*DIM_WDT*DIM_HGT*0.883* POWER(0.01,3) AS VOL" ).append("\n"); 
		query.append("            , GRS_WGT * 0.001 AS TON_WGT " ).append("\n"); 
		query.append("      FROM BKG_BB_CGO" ).append("\n"); 
		query.append("      WHERE BKG_NO =@[bkg_no] " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}