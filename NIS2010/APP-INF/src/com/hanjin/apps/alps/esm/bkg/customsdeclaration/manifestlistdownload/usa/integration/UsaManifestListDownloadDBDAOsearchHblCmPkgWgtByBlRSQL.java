/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchHblCmPkgWgtByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.06.14 이영헌
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

public class UsaManifestListDownloadDBDAOsearchHblCmPkgWgtByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHblCmPkgWgtByBl
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchHblCmPkgWgtByBlRSQL(){
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
		query.append("FileName : UsaManifestListDownloadDBDAOsearchHblCmPkgWgtByBlRSQL").append("\n"); 
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
		query.append("SELECT H.CNTR_MF_NO BL_NO,  " ).append("\n"); 
		query.append("	   '' AS CMDT_CD," ).append("\n"); 
		query.append("       M.CNTR_NO,    " ).append("\n"); 
		query.append("       M.CNTR_MF_SEQ AS CMDT_GDS_SEQ," ).append("\n"); 
		query.append("       --SUBSTR('0' || ROWNUM,-2) AS CMDT_GDS_SEQ," ).append("\n"); 
		query.append("       /* 20071010 JHP Tab 특수문자를 space로 치환 */" ).append("\n"); 
		query.append("       NVL(TRIM(REPLACE(REPLACE(UPPER(M.CNTR_MF_MK_DESC),CHR(13)||CHR(10),' '),CHR(9),' ')),'NO MARKS') AS MK_DESC," ).append("\n"); 
		query.append("       UPPER(decode(M.CNTR_MF_GDS_DESC,null,C.CMDT_NM,M.CNTR_MF_GDS_DESC)) AS CGO_DESC," ).append("\n"); 
		query.append("       M.PCK_QTY,  " ).append("\n"); 
		query.append("       NVL(P.USA_CSTMS_PCK_CD,'PKG') AS AMS_PCK_TP_CD," ).append("\n"); 
		query.append("       M.CNTR_MF_WGT AS GRS_WGT," ).append("\n"); 
		query.append("       decode(NVL(M.WGT_UT_CD,'KG'),'KGS','KG','LBS','LB') AS WGT_UT_CD," ).append("\n"); 
		query.append("       SUBSTR(TRIM(M.HAMO_TRF_CD),1,10) AS HAMO_CMDT_CD" ).append("\n"); 
		query.append("	   ,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	   ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_BOOKING B,  " ).append("\n"); 
		query.append("	   BKG_HBL H," ).append("\n"); 
		query.append("       BKG_CONTAINER T," ).append("\n"); 
		query.append("       BKG_CNTR_MF_DESC M, " ).append("\n"); 
		query.append("       BKG_BL_DOC D," ).append("\n"); 
		query.append("       MDM_COMMODITY C," ).append("\n"); 
		query.append("       MDM_PCK_TP P" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    H.BKG_NO > ' '" ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("		#if($velocityCount > 1)" ).append("\n"); 
		query.append("      	OR #end      H.CNTR_MF_NO IN ( $field_id )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND    B.BKG_NO  = H.BKG_NO" ).append("\n"); 
		query.append("AND    B.BKG_NO  = D.BKG_NO" ).append("\n"); 
		query.append("AND    D.BKG_NO  = T.BKG_NO" ).append("\n"); 
		query.append("AND    T.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("AND    B.BKG_NO  = M.BKG_NO" ).append("\n"); 
		query.append("AND    B.CMDT_CD = C.CMDT_CD" ).append("\n"); 
		query.append("AND    D.PCK_TP_CD = P.PCK_CD" ).append("\n"); 
		query.append("AND    H.CNTR_MF_NO = M.CNTR_MF_NO" ).append("\n"); 
		query.append("AND    B.BKG_STS_CD NOT IN ('X')" ).append("\n"); 

	}
}