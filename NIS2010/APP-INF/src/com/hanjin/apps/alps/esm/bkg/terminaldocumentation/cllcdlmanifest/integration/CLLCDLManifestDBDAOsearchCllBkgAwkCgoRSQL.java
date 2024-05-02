/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllBkgAwkCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllBkgAwkCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CLLCDLManifestDBDAOsearchCllBkgAwkCgo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllBkgAwkCgoRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllBkgAwkCgoRSQL").append("\n"); 
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
		query.append("SELECT AWK.AWK_CGO_SEQ" ).append("\n"); 
		query.append("     , AWK.OVR_FWRD_LEN OVR_FWRD_LEN" ).append("\n"); 
		query.append("	 , AWK.OVR_BKWD_LEN OVR_BKWD_LEN" ).append("\n"); 
		query.append("	 , AWK.OVR_HGT OVR_HGT" ).append("\n"); 
		query.append("	 , AWK.OVR_LF_LEN OVR_PORT_LEN" ).append("\n"); 
		query.append("	 , AWK.OVR_RT_LEN OVR_SD_LEN" ).append("\n"); 
		query.append("	 , AWK.WGT_UT_CD OVR_WGT_UT_CD" ).append("\n"); 
		query.append("	 , AWK.GRS_WGT OVR_CNTR_WGT" ).append("\n"); 
		query.append("FROM BKG_AWK_CGO AWK, BKG_CSTMS_TML_CLL CLL" ).append("\n"); 
		query.append("WHERE CLL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  AND CLL.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND CLL.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND CLL.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#if (${clpt_ind_seq} != '')" ).append("\n"); 
		query.append("  AND NVL(CLL.CLPT_IND_SEQ,'1') = @[clpt_ind_seq] -- Add. 2015.02.09" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND CLL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND CLL.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND AWK.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("  AND AWK.CNTR_TPSZ_CD = CLL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  AND AWK.CNTR_NO IS NULL" ).append("\n"); 
		query.append("  AND NVL(CLL.AWK_CGO_SEQ,0) = 0" ).append("\n"); 
		query.append("  AND AWK.AWK_CGO_SEQ = ( SELECT NVL(MIN(AWK_CGO_SEQ),0) FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("                                WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                  AND AWK_CGO_SEQ NOT IN (SELECT NVL(AWK_CGO_SEQ,0) FROM BKG_CSTMS_TML_CLL " ).append("\n"); 
		query.append("                       												   WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                                         AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                                         AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                                         AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                                                         #if (${clpt_ind_seq} != '')" ).append("\n"); 
		query.append("																		 AND NVL(CLL.CLPT_IND_SEQ,'1') = @[clpt_ind_seq] -- Add. 2015.02.09" ).append("\n"); 
		query.append("																		 #end" ).append("\n"); 
		query.append("																		 AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("																		 AND CRE_USR_ID = @[upd_usr_id] ))" ).append("\n"); 

	}
}