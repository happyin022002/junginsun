/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCmdt2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.16 
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

public class AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCmdt2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * i
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCmdt2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCmdt2CSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ANR_CMDT (" ).append("\n"); 
		query.append("VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BKG_NO, CNTR_NO, CNTR_SEQ," ).append("\n"); 
		query.append("PCK_QTY, PCK_TP_CD, CNTR_MF_WGT, WGT_UT_CD," ).append("\n"); 
		query.append("CNTR_MF_DESC," ).append("\n"); 
		query.append("DECL_FLG," ).append("\n"); 
		query.append("RGST_USR_ID, CRE_OFC_CD, UPD_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, C.BKG_NO, C.CNTR_NO, C.CNTR_MF_SEQ" ).append("\n"); 
		query.append(", NVL(C.PCK_QTY,0), C.PCK_TP_CD, NVL(C.CNTR_MF_WGT,0), C.WGT_UT_CD" ).append("\n"); 
		query.append(", C.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(", 'Y'" ).append("\n"); 
		query.append(", '', @[cre_ofc_cd], @[upd_ofc_cd]" ).append("\n"); 
		query.append(", @[cre_usr_id], SYSDATE, @[upd_usr_id], SYSDATE" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_BL A, BKG_CSTMS_ANR_CNTR B, BKG_CNTR_MF_DESC C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND C.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_CSTMS_ANR_CMDT D " ).append("\n"); 
		query.append("                WHERE D.VSL_CD = B.VSL_CD " ).append("\n"); 
		query.append("				AND D.SKD_VOY_NO = B.SKD_VOY_NO " ).append("\n"); 
		query.append("				AND D.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND D.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                AND D.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                AND D.CNTR_SEQ = C.CNTR_MF_SEQ)" ).append("\n"); 

	}
}