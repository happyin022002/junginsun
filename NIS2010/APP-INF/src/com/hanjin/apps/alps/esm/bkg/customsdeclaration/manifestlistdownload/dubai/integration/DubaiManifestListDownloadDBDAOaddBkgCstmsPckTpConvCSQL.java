/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsPckTpConvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.02 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOaddBkgCstmsPckTpConvCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsPckTpConv
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOaddBkgCstmsPckTpConvCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_cd_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsPckTpConvCSQL").append("\n"); 
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
		query.append("INSERT  " ).append("\n"); 
		query.append("  INTO BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       CNT_CD" ).append("\n"); 
		query.append("      ,CSTMS_DIV_ID" ).append("\n"); 
		query.append("      ,CSTMS_DIV_ID_SEQ" ).append("\n"); 
		query.append("      ,ATTR_CTNT1" ).append("\n"); 
		query.append("      ,ATTR_CTNT2" ).append("\n"); 
		query.append("      ,ATTR_CTNT3" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       'AE'" ).append("\n"); 
		query.append("      ,'DUBAI_PCK_CD'" ).append("\n"); 
		query.append("      ,(SELECT NVL(MAX(CSTMS_DIV_ID_SEQ),0) + 1 FROM BKG_CSTMS_CD_CONV_CTNT WHERE CNT_CD = 'AE' AND CSTMS_DIV_ID = 'DUBAI_PCK_CD')" ).append("\n"); 
		query.append("      ,@[cstms_pck_tp_cd]" ).append("\n"); 
		query.append("      ,@[pck_cd_desc]" ).append("\n"); 
		query.append("      ,@[pck_tp_cd]" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}