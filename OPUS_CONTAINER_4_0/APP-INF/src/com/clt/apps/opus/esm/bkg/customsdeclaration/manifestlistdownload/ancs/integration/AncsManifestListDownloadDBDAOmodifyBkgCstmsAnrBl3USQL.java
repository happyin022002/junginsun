/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrBl3USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.09 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrBl3USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * u
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrBl3USQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrBl3USQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ANR_BL X" ).append("\n"); 
		query.append("SET X.ANR_MSG_STS_CD = 'N'," ).append("\n"); 
		query.append("VVD_SEQ = (SELECT NVL(MAX(B.VVD_SEQ),0) + 1" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_VVD A, BKG_CSTMS_ANR_BL B" ).append("\n"); 
		query.append("WHERE A.SVC_RQST_NO = SUBSTR(@[anr_decl_no], 1, 6)" ).append("\n"); 
		query.append("AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = A.SKD_DIR_CD)" ).append("\n"); 
		query.append("WHERE (X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.BKG_NO) IN  (" ).append("\n"); 
		query.append("SELECT Z.VSL_CD, Z.SKD_VOY_NO, Z.SKD_DIR_CD, Z.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_BL_LOG Z" ).append("\n"); 
		query.append("WHERE Z.ANR_DECL_NO = @[anr_decl_no]" ).append("\n"); 
		query.append("AND Z.REF_SEQ = @[ref_seq]" ).append("\n"); 
		query.append("AND Z.EDI_RCV_STS_CD = 'A')" ).append("\n"); 

	}
}