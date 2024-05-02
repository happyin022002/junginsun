/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KorManifestListDBDAOSearchBkgWhfRateListRSQL.java
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

public class KorManifestListDBDAOSearchBkgWhfRateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge Rate 의 WHF List 가져오기
	  * </pre>
	  */
	public KorManifestListDBDAOSearchBkgWhfRateListRSQL(){
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
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchBkgWhfRateListRSQL").append("\n"); 
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
		query.append("SELECT RT.BKG_NO" ).append("\n"); 
		query.append("       , RT.RT_SEQ" ).append("\n"); 
		query.append("FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("WHERE RT.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND RT.CHG_CD = 'WHF'" ).append("\n"); 
		query.append("AND RT.FRT_TERM_CD ='C'" ).append("\n"); 
		query.append("#if(${whf_tp} == 'BB')" ).append("\n"); 
		query.append("AND RT.CGO_CATE_CD = 'BB'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND RT.CGO_CATE_CD NOT IN ('BB')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rt_seq} != '')" ).append("\n"); 
		query.append("AND RT.RT_SEQ = @[rt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}