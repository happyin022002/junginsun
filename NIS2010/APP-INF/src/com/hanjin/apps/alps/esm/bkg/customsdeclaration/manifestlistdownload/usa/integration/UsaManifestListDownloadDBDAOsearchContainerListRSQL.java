/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaContainerListVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchContainerListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("		C.BL_NO" ).append("\n"); 
		query.append("       ,C.CNTR_NO" ).append("\n"); 
		query.append("       ,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,C.IBD_CNTR_STS_CD" ).append("\n"); 
		query.append("       ,S.SEAL_NO" ).append("\n"); 
		query.append("       ,DECODE(M.CMDT_GDS_SEQ, NULL, 'N', 'Y') AS CNTR_MF_FLAG" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CNTR_MF M" ).append("\n"); 
		query.append("       ,( SELECT BL_NO" ).append("\n"); 
		query.append("			   , CNTR_NO" ).append("\n"); 
		query.append("			   , BKG_JOIN_FNC((CURSOR(SELECT SEAL_NO " ).append("\n"); 
		query.append("										FROM BKG_CSTMS_SEAL_NO SEAL" ).append("\n"); 
		query.append("				                       WHERE SEAL.BL_NO = INNR.BL_NO" ).append("\n"); 
		query.append("				                         AND SEAL.CNTR_NO = INNR.CNTR_NO" ).append("\n"); 
		query.append("				                       ORDER BY SEAL.SEAL_NO_SEQ ) ) , '|') AS SEAL_NO" ).append("\n"); 
		query.append("		   FROM (" ).append("\n"); 
		query.append("				SELECT DISTINCT BL_NO" ).append("\n"); 
		query.append("				     , CNTR_NO" ).append("\n"); 
		query.append("				  FROM BKG_CSTMS_SEAL_NO" ).append("\n"); 
		query.append("				 WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("				   AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("				   AND CSTMS_DIV_ID = 'CTM'     " ).append("\n"); 
		query.append("		   ) INNR " ).append("\n"); 
		query.append("		) S" ).append("\n"); 
		query.append("WHERE    1=1" ).append("\n"); 
		query.append("AND      C.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND      C.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND     (C.IBD_CNTR_STS_CD IS NULL" ).append("\n"); 
		query.append("OR       C.IBD_CNTR_STS_CD = 'A')" ).append("\n"); 
		query.append("AND      C.BL_NO = S.BL_NO(+)" ).append("\n"); 
		query.append("AND      C.CNTR_NO = S.CNTR_NO(+)" ).append("\n"); 
		query.append("AND      C.CNT_CD = M.CNT_CD(+)" ).append("\n"); 
		query.append("AND      C.BL_NO = M.BL_NO(+)" ).append("\n"); 
		query.append("AND      C.CNTR_NO = M.CNTR_NO(+)" ).append("\n"); 
		query.append("ORDER BY C.CNTR_NO   " ).append("\n"); 

	}
}