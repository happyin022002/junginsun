/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchDiffBkgForYRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.01.06 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchDiffBkgForYRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchDiffBkgForYRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_number",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchDiffBkgForYRSQL").append("\n"); 
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
		query.append("SELECT bkg.BKG_NO" ).append("\n"); 
		query.append("FROM   BKG_BOOKING bkg, BKG_VVD vvd,BKG_BL_DOC doc" ).append("\n"); 
		query.append("WHERE  vvd.SLAN_CD = @[lane_cd]" ).append("\n"); 
		query.append("AND vvd.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND vvd.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND vvd.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND vvd.BKG_NO = bkg.BKG_NO" ).append("\n"); 
		query.append("AND vvd.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND vvd.POD_CD = 'NLRTM'" ).append("\n"); 
		query.append("AND bkg.BKG_no =   doc.BKG_no" ).append("\n"); 
		query.append("AND BDR_FLG = DECODE(BKG_CGO_TP_CD,'F','Y','R','Y','B','Y',BDR_FLG)" ).append("\n"); 
		query.append("AND BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND BKG_CGO_TP_CD in ('F','P','R','B')" ).append("\n"); 
		query.append("AND bkg.BL_NO is not null" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("FROM	 BKG_CSTMS_RTM_BL" ).append("\n"); 
		query.append("WHERE	 VSL_CALL_REF_NO = @[crn_number]" ).append("\n"); 

	}
}