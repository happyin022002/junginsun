/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchDownloadCntrMFListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.05.27 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchDownloadCntrMFListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaManifestListDownloadDBDAOsearchDownloadCntrMFListRSQL
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchDownloadCntrMFListRSQL(){
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchDownloadCntrMFListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT  CNT.CNTR_NO" ).append("\n"); 
		query.append("		       ,BKG.BKG_NO" ).append("\n"); 
		query.append("		       ,BKG.BL_NO" ).append("\n"); 
		query.append("			   ,CM.CNTR_MF_WGT AS CNTR_MF_WGT " ).append("\n"); 
		query.append("		FROM    BKG_VVD VVD" ).append("\n"); 
		query.append("		       ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("		       ,BKG_CONTAINER CNT" ).append("\n"); 
		query.append("		       ,BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("		WHERE   1=1" ).append("\n"); 
		query.append("		AND     VVD.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("		AND     VVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("		AND     VVD.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("		#if (${all_pol} != 'Y' and ${pol_cd} != '')" ).append("\n"); 
		query.append("		AND     VVD.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND     VVD.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("		#if (${bkg_no} != '')" ).append("\n"); 
		query.append("		AND     VVD.BKG_NO 		= @[bkg_no] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${bkg_cgo_tp_cd} == 'F') " ).append("\n"); 
		query.append("		AND  	BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("		AND  	BKG.BKG_CGO_TP_CD IN ('P')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND     VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("		AND     BKG.BKG_NO = CNT.BKG_NO(+)" ).append("\n"); 
		query.append("		--AND     BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("		AND     NVL(BKG.BKG_STS_CD,' ') NOT IN ('X','A')" ).append("\n"); 
		query.append("		AND     BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("		AND     CNT.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("        AND     BKG.BKG_NO = CM.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY BL_NO" ).append("\n"); 

	}
}