/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchContainerSealNoByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.15
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.06.15 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchContainerSealNoByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchContainerSealNoByBl
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchContainerSealNoByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchContainerSealNoByBlRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       'US' CNT_CD," ).append("\n"); 
		query.append("	   H.CNTR_MF_NO AS BL_NO, " ).append("\n"); 
		query.append("       C.CNTR_NO, " ).append("\n"); 
		query.append("       S.CNTR_SEAL_SEQ AS SEAL_NO_SEQ," ).append("\n"); 
		query.append("       NVL(S.CNTR_SEAL_NO, '') AS SEAL_NO," ).append("\n"); 
		query.append("       S.SEAL_PTY_TP_CD," ).append("\n"); 
		query.append("       S.SEAL_PTY_NM," ).append("\n"); 
		query.append("       S.SEAL_KND_CD" ).append("\n"); 
		query.append("	  ,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	  ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_BOOKING B," ).append("\n"); 
		query.append("       BKG_CONTAINER C," ).append("\n"); 
		query.append("       BKG_HBL H," ).append("\n"); 
		query.append("       BKG_CNTR_SEAL_NO S" ).append("\n"); 
		query.append("      ,BKG_CNTR_MF_DESC D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND  H.BKG_NO > ' '" ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("      	#if($velocityCount > 1)" ).append("\n"); 
		query.append("      	OR #end  H.CNTR_MF_NO IN ( $field_id )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND  B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND	 B.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("AND  B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND  C.CNTR_NO = S.CNTR_NO" ).append("\n"); 
		query.append("AND  C.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND  C.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("AND  D.CNTR_MF_NO = H.CNTR_MF_NO" ).append("\n"); 
		query.append("AND  B.BKG_STS_CD NOT IN ('X')" ).append("\n"); 

	}
}