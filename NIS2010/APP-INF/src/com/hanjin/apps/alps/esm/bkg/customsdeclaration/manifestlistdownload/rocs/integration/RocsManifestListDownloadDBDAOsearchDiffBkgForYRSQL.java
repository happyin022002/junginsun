/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchDiffBkgForYRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("       , BKG_VVD VVD" ).append("\n"); 
		query.append("       , BKG_BL_DOC DOC" ).append("\n"); 
		query.append(" WHERE VVD.SLAN_CD = @[lane_cd]" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND VVD.POD_CD = 'NLRTM'" ).append("\n"); 
		query.append("   AND VVD.POD_CLPT_IND_SEQ = @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("   AND BKG.BKG_NO =   DOC.BKG_NO" ).append("\n"); 
		query.append("   AND BDR_FLG = DECODE(BKG_CGO_TP_CD,'F','Y','R','Y','B','Y',BDR_FLG)" ).append("\n"); 
		query.append("   AND BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND BKG_CGO_TP_CD in ('F','P','R','B')" ).append("\n"); 
		query.append("   AND BKG.BL_NO is not null" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("SELECT RBL.BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_RTM_BL RBL" ).append("\n"); 
		query.append(" WHERE RBL.VSL_CALL_REF_NO = @[crn_number]" ).append("\n"); 
		query.append("   AND RBL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND RBL.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND RBL.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 

	}
}