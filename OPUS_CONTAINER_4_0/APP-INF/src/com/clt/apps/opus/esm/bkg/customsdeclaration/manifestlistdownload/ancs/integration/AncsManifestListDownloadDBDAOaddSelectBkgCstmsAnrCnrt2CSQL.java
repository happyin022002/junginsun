/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCnrt2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.25 
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

public class AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCnrt2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * i
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCnrt2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCnrt2CSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_ANR_CNTR (" ).append("\n"); 
		query.append("VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BKG_NO, CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD, ISO_CNTR_TPSZ_CD, PCK_QTY, PCK_TP_CD, CNTR_WGT, WGT_UT_CD," ).append("\n"); 
		query.append("ORG_RCV_TERM_CD, DEST_DE_TERM_CD, DECL_FLG," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_OFC_CD, CRE_DT, UPD_USR_ID, UPD_OFC_CD, UPD_DT)" ).append("\n"); 
		query.append("SELECT B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, C.BKG_NO, C.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD, D.CNTR_TPSZ_ISO_CD, NVL(C.PCK_QTY,0), C.PCK_TP_CD, NVL(C.CNTR_WGT,0), C.WGT_UT_CD," ).append("\n"); 
		query.append("DECODE(C.RCV_TERM_CD, 'S', 'LCL', 'FCL'), DECODE(C.DE_TERM_CD, 'S', 'LCL', 'FCL'), 'Y'," ).append("\n"); 
		query.append("@[cre_usr_id], @[cre_usr_cd], SYSDATE, @[upd_usr_id], @[upd_ofc_cd], SYSDATE" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_BL B, BKG_CONTAINER C, MDM_CNTR_TP_SZ D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND D.CNTR_TPSZ_CD(+) = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_CSTMS_ANR_CNTR E" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND E.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND E.CNTR_NO = C.CNTR_NO)" ).append("\n"); 

	}
}