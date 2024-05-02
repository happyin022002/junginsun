/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchContainerByBl2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.11 
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

public class UsaManifestListDownloadDBDAOsearchContainerByBl2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaCntrListRsltVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchContainerByBl2RSQL(){
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
		query.append("FileName : UsaManifestListDownloadDBDAOsearchContainerByBl2RSQL").append("\n"); 
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
		query.append("SELECT   C.BL_NO" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.CNTR_NO AS BAK_CNTR_NO" ).append("\n"); 
		query.append(",C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",C.FULL_MTY_CD" ).append("\n"); 
		query.append(",C.IBD_CNTR_STS_CD" ).append("\n"); 
		query.append(",(SELECT S.SEAL_NO FROM BKG_CSTMS_SEAL_NO S" ).append("\n"); 
		query.append("WHERE S.CSTMS_DIV_ID = 'CTM'" ).append("\n"); 
		query.append("AND	S.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("AND   S.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND   S.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("AND   S.SEAL_NO_SEQ = 1) SEAL_NO" ).append("\n"); 
		query.append(",(SELECT S.SEAL_NO FROM BKG_CSTMS_SEAL_NO S" ).append("\n"); 
		query.append("WHERE S.CSTMS_DIV_ID = 'CTM'" ).append("\n"); 
		query.append("AND	S.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("AND   S.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND   S.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("AND   S.SEAL_NO_SEQ = 2) SEAL_NO2" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("WHERE    1=1" ).append("\n"); 
		query.append("AND      C.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND      C.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND      (C.IBD_CNTR_STS_CD IS NULL" ).append("\n"); 
		query.append("OR       C.IBD_CNTR_STS_CD = 'A')" ).append("\n"); 
		query.append("ORDER BY C.CNTR_NO" ).append("\n"); 

	}
}