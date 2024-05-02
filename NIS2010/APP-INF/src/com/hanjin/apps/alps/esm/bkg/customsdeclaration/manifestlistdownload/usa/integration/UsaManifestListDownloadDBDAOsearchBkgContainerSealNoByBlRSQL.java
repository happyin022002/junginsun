/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchBkgContainerSealNoByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
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

public class UsaManifestListDownloadDBDAOsearchBkgContainerSealNoByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaBkgCntrSealNoVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchBkgContainerSealNoByBlRSQL(){
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
		query.append("FileName : UsaManifestListDownloadDBDAOsearchBkgContainerSealNoByBlRSQL").append("\n"); 
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
		query.append("SELECT 'US' CNT_CD," ).append("\n"); 
		query.append("	   B.BL_NO, " ).append("\n"); 
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
		query.append("       BKG_CNTR_SEAL_NO S" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("      	#if($velocityCount > 1)" ).append("\n"); 
		query.append("      	OR #end  B.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")	" ).append("\n"); 
		query.append("AND  B.BKG_NO  = C.BKG_NO" ).append("\n"); 
		query.append("AND  B.BKG_NO  = S.BKG_NO(+)" ).append("\n"); 
		query.append("AND  C.CNTR_NO = S.CNTR_NO" ).append("\n"); 
		query.append("AND TRIM(S.CNTR_SEAL_NO) != '-'  /*제외*/" ).append("\n"); 

	}
}