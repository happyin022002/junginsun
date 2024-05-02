/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * u
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("anr_decl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ANR_VVD X" ).append("\n"); 
		query.append("       SET X.ANR_MSG_STS_CD = (SELECT CASE WHEN Y.EDI_SND_STS_CD || Y.EDI_RCV_STS_CD = 'OA' THEN 'A'" ).append("\n"); 
		query.append("                                           WHEN Y.EDI_SND_STS_CD || Y.EDI_RCV_STS_CD = 'CA' THEN 'N'" ).append("\n"); 
		query.append("                                           ELSE X.ANR_MSG_STS_CD" ).append("\n"); 
		query.append("                                      END" ).append("\n"); 
		query.append("                                 FROM BKG_CSTMS_ANR_EDI_HIS Y" ).append("\n"); 
		query.append("                                WHERE Y.MSG_TP_CD = 'R'" ).append("\n"); 
		query.append("                                  AND Y.ANR_DECL_NO = @[anr_decl_no]" ).append("\n"); 
		query.append("                                  AND Y.REF_SEQ = @[ref_seq])," ).append("\n"); 
		query.append("           X.UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("           X.UPD_DT = SYSDATE," ).append("\n"); 
		query.append("           X.UPD_OFC_CD = DECODE(@[upd_ofc_cd], NULL, X.UPD_OFC_CD, @[upd_ofc_cd])" ).append("\n"); 
		query.append("     WHERE (X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD) IN (SELECT Z.VSL_CD, Z.SKD_VOY_NO, Z.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                        FROM BKG_CSTMS_ANR_EDI_HIS Z" ).append("\n"); 
		query.append("                                                       WHERE Z.MSG_TP_CD = 'R'  " ).append("\n"); 
		query.append("                                                         AND Z.ANR_DECL_NO = @[anr_decl_no]" ).append("\n"); 
		query.append("                                                         AND Z.REF_SEQ = @[ref_seq])" ).append("\n"); 

	}
}