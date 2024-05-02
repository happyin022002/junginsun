/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOaddBkgCstmsBlLodFctrLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.09
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.09.09 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOaddBkgCstmsBlLodFctrLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgCstmsBlLodFctrLog
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOaddBkgCstmsBlLodFctrLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOaddBkgCstmsBlLodFctrLogCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO BKG_CSTMS_BL_LOD_FCTR_LOG" ).append("\n"); 
		query.append("      (BKG_NO" ).append("\n"); 
		query.append("      ,BL_LDF_DL_DT" ).append("\n"); 
		query.append("      ,BAT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("      (@[bkg_no]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,NVL(@[bat_flg], 'N')" ).append("\n"); 
		query.append("      ,NVL(@[cre_usr_id], 'BATCH')" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,NVL(@[cre_usr_id], 'BATCH')" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}