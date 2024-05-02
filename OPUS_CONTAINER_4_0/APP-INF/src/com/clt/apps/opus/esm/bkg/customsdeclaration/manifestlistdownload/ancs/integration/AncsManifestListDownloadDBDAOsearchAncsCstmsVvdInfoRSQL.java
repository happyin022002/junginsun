/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsManiestListDownloadDBDAOsearchAncsCstmsVvdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.10 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOsearchAncsCstmsVvdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SE
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsCstmsVvdInfoRSQL(){
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
		params.put("ssr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT (A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) AS VVD" ).append("\n"); 
		query.append(",A.SVC_RQST_NO AS SSR_NO" ).append("\n"); 
		query.append(",A.VVD_NM AS VVD_NM" ).append("\n"); 
		query.append(",A.ANR_MSG_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR( A.ETA_DT, 'YYYY-MM-DD' ) AS ETA_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_VVD A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD        =  SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO    =  SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    =  SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ssr_no} != '')" ).append("\n"); 
		query.append("AND A.SVC_RQST_NO   = @[ssr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManiestListDownloadDBDAOsearchAncsCstmsVvdInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}