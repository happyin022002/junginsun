/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchBlMdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchBlMdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlMdList
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchBlMdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchBlMdListRSQL").append("\n"); 
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
		query.append("SELECT  SUBSTR(" ).append("\n"); 
		query.append("            MAX(TO_CHAR(MD.MK_SEQ, '00')||" ).append("\n"); 
		query.append("            MD.BL_NO||CHR(9)||" ).append("\n"); 
		query.append("            MD.MK_SEQ||CHR(9)||" ).append("\n"); 
		query.append("            @[trans_mode])" ).append("\n"); 
		query.append("        ,4) BL_NO," ).append("\n"); 
		query.append("        SUBSTR(" ).append("\n"); 
		query.append("            MAX(TO_CHAR(MD.MK_SEQ, '00')||" ).append("\n"); 
		query.append("				--MD.CMDT_DESC||CHR(9)||" ).append("\n"); 
		query.append("                MD.MK_DESC)" ).append("\n"); 
		query.append("        ,4) BL_MK_DESC," ).append("\n"); 
		query.append("		@[usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("		@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("            SELECT  BB.BL_NO," ).append("\n"); 
		query.append("                    MK.MK_SEQ,					" ).append("\n"); 
		query.append("                    DBMS_LOB.substr( MK.MK_DESC, 3990,1 ) AS MK_DESC" ).append("\n"); 
		query.append("                    --DBMS_LOB.substr( MK.CMDT_DESC, DBMS_LOB.GetLength(MK.CMDT_DESC) ) AS CMDT_DESC" ).append("\n"); 
		query.append("            FROM    BKG_BL_MK_DESC MK, BKG_BOOKING BB" ).append("\n"); 
		query.append("            WHERE   1=1" ).append("\n"); 
		query.append("			AND ( #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("      				#if($velocityCount > 1)" ).append("\n"); 
		query.append("      				OR #end      MK.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("      			  #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("            AND     MK.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("			#if (${bkg_cgo_tp_cd} != '') " ).append("\n"); 
		query.append("			AND     DECODE(BB.BKG_CGO_TP_CD,'P','P','F') = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        ) MD" ).append("\n"); 
		query.append("GROUP BY MD.BL_NO" ).append("\n"); 

	}
}