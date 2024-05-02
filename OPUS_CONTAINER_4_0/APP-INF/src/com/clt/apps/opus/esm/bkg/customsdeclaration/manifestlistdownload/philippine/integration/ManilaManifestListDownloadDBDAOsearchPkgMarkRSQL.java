/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManilaManifestListDownloadDBDAOsearchPkgMarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManilaManifestListDownloadDBDAOsearchPkgMarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ManilaManifestListDownloadDBDAOsearchPkgMarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("reg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration").append("\n"); 
		query.append("FileName : ManilaManifestListDownloadDBDAOsearchPkgMarkRSQL").append("\n"); 
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
		query.append("SELECT	REG_NUMBER5," ).append("\n"); 
		query.append("		BL_NO4," ).append("\n"); 
		query.append("		DESC_GOOD2," ).append("\n"); 
		query.append("		MARK2," ).append("\n"); 
		query.append("		ROWNUM AS SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT @[reg_no] reg_number5," ).append("\n"); 
		query.append("		       COM_ConstantMgr_PKG.COM_getScacCode_FNC()||BKG.BL_NO bl_no4," ).append("\n"); 
		query.append("		       TO_CLOB(DBMS_LOB.SUBSTR( NVL(BMD.MK_DESC, ' '),  2000, 1)) desc_good2," ).append("\n"); 
		query.append("			   (CASE WHEN LENGTH( NVL(BMD.MK_DESC,' ')) > 15 THEN '1'" ).append("\n"); 
		query.append("		             WHEN LENGTH( NVL(BMD.MK_DESC,' ')) < 15 THEN '0' END) mark2" ).append("\n"); 
		query.append("		FROM  BKG_BOOKING BKG, " ).append("\n"); 
		query.append("		      BKG_BL_MK_DESC BMD, " ).append("\n"); 
		query.append("		      BKG_VVD BV" ).append("\n"); 
		query.append("		WHERE BKG.BKG_NO       = BMD.BKG_NO " ).append("\n"); 
		query.append("		  AND BKG.BKG_NO       = BV.BKG_NO " ).append("\n"); 
		query.append("		  AND BV.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("		  AND BV.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("		  AND BV.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("		#if (${pol_cd}!= '') " ).append("\n"); 
		query.append("		  AND BV.POL_CD       LIKE @[pol_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pod_cd}!= '') " ).append("\n"); 
		query.append("		  AND BV.POD_CD       LIKE @[pod_cd] " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		  AND BKG.BKG_STS_CD IN ('F','W') " ).append("\n"); 
		query.append("		  AND BKG.BL_NO > ' '  " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT @[reg_no] reg_no," ).append("\n"); 
		query.append("		       COM_ConstantMgr_PKG.COM_getScacCode_FNC()||BKG.BL_NO bl_no," ).append("\n"); 
		query.append("		       NVL(TO_CLOB(BMD.BL_MK_DESC),' ') desc_good," ).append("\n"); 
		query.append("			   (CASE WHEN LENGTH( NVL(BMD.BL_MK_DESC,' ')) > 15 THEN '1'" ).append("\n"); 
		query.append("		             WHEN LENGTH( NVL(BMD.BL_MK_DESC,' ')) < 15 THEN '0' END) mark" ).append("\n"); 
		query.append("		FROM  BKG_BOOKING BKG, " ).append("\n"); 
		query.append("		      BKG_HBL BMD, " ).append("\n"); 
		query.append("		      BKG_VVD BV" ).append("\n"); 
		query.append("		WHERE BKG.BKG_NO       = BMD.BKG_NO (+)" ).append("\n"); 
		query.append("		  AND BKG.BKG_NO       = BV.BKG_NO " ).append("\n"); 
		query.append("		  AND BV.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("		  AND BV.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("		  AND BV.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("		  AND LENGTH(TO_CLOB(BMD.BL_MK_DESC)) > 0" ).append("\n"); 
		query.append("		#if (${pol_cd}!= '') " ).append("\n"); 
		query.append("		  AND BV.POL_CD       LIKE @[pol_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pod_cd}!= '') " ).append("\n"); 
		query.append("		  AND BV.POD_CD       LIKE @[pod_cd] " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		  AND BKG.BKG_STS_CD IN ('F','W') " ).append("\n"); 
		query.append("		  AND BKG.BL_NO > ' '  " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}