/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchBkgContainerByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.01 
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

public class UsaManifestListDownloadDBDAOsearchBkgContainerByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaBkgCntrVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchBkgContainerByBlRSQL(){
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
		query.append("FileName : UsaManifestListDownloadDBDAOsearchBkgContainerByBlRSQL").append("\n"); 
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
		query.append("       C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       C.PCK_QTY, " ).append("\n"); 
		query.append("       NVL(C.PCK_TP_CD, D.PCK_TP_CD) AS PCK_TP_CD, " ).append("\n"); 
		query.append("       C.CNTR_WGT AS GRS_WGT," ).append("\n"); 
		query.append("       NVL(C.WGT_UT_CD, D.WGT_UT_CD) AS WGT_UT_CD," ).append("\n"); 
		query.append("       DECODE(NVL(B.BKG_CGO_TP_CD,'F'),'F','F','M') AS FULL_MTY_CD" ).append("\n"); 
		query.append("	  ,C.CNTR_PRT_FLG AS PRT_FLG" ).append("\n"); 
		query.append("	  ,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	  ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_BOOKING B, " ).append("\n"); 
		query.append("       BKG_BL_DOC D, " ).append("\n"); 
		query.append("       BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("      	#if($velocityCount > 1)" ).append("\n"); 
		query.append("      	OR #end      B.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND  B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND  B.BKG_NO = D.BKG_NO(+)" ).append("\n"); 

	}
}