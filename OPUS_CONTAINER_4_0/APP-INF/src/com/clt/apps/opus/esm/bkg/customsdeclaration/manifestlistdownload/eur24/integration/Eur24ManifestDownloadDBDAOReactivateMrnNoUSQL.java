/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOReactivateMrnNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOReactivateMrnNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReactivateMrnNo
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOReactivateMrnNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOReactivateMrnNoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("SET MVMT_REF_NO = (SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_ADV_EUR_RCV" ).append("\n"); 
		query.append("                    WHERE MSG_RCV_NO = (SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("                                          FROM BKG_CSTMS_EUR_BL " ).append("\n"); 
		query.append("                                         WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("                      AND EUR_EDI_MSG_TP_ID = 'A'" ).append("\n"); 
		query.append("                      AND ROWNUM = 1)" ).append("\n"); 
		query.append("WHERE BL_NO = @[bl_no]" ).append("\n"); 

	}
}