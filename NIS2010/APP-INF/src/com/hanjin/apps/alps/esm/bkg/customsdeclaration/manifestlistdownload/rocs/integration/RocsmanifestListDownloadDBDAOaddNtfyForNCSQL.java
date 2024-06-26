/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsmanifestListDownloadDBDAOaddNtfyForNCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09 
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

public class RocsmanifestListDownloadDBDAOaddNtfyForNCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L Notify Info 생성
	  * </pre>
	  */
	public RocsmanifestListDownloadDBDAOaddNtfyForNCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsmanifestListDownloadDBDAOaddNtfyForNCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_RTM_NTFY" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            BKG_NO,  CSTMS_DECL_SEQ," ).append("\n"); 
		query.append("            BL_NO," ).append("\n"); 
		query.append("            SHPR_NM," ).append("\n"); 
		query.append("			CUST_ADDR," ).append("\n"); 
		query.append("			FAX_NO,            CSTMS_EML," ).append("\n"); 
		query.append("            CRE_USR_ID,         CRE_OFC_CD,UPD_OFC_CD,  UPD_USR_ID, UPD_DT,   CRE_DT," ).append("\n"); 
		query.append("            BKG_CNG_FLG" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("			BRB.BKG_NO,		1," ).append("\n"); 
		query.append("            BRB.BL_NO," ).append("\n"); 
		query.append("			SUBSTR( SUBSTR(BRB.NTFY_ADDR,1,	INSTR(BRB.NTFY_ADDR,'@@')-1), 1, 100 )," ).append("\n"); 
		query.append("			SUBSTR(" ).append("\n"); 
		query.append("            SUBSTR(BRB.NTFY_ADDR,	INSTR(BRB.NTFY_ADDR,'@@')	+2	," ).append("\n"); 
		query.append("                      LENGTH(BRB.NTFY_ADDR)-INSTR(BRB.NTFY_ADDR,'@@')+1), 1, 200 )," ).append("\n"); 
		query.append("			BRB.FAX_NO,		BRB.CUST_EML," ).append("\n"); 
		query.append("			BRB.CRE_USR_ID,	BRB.CRE_OFC_CD,BRB.CRE_OFC_CD,	BRB.UPD_USR_ID,	BRB.UPD_DT,BRB.BL_CRE_DT," ).append("\n"); 
		query.append("			'Y'" ).append("\n"); 
		query.append("	FROM	BKG_CSTMS_RTM_BL	BRB" ).append("\n"); 
		query.append("	WHERE	BRB.VSL_CALL_REF_NO	=	@[crn_number]" ).append("\n"); 
		query.append("	#if ( ${vsl_cd} != '')" ).append("\n"); 
		query.append("    AND BRB.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    AND BRB.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    AND BRB.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    AND	( BRB.BKG_NO ) NOT IN (	SELECT BRN.BKG_NO" ).append("\n"); 
		query.append("                                FROM BKG_CSTMS_RTM_NTFY	BRN" ).append("\n"); 
		query.append("                               WHERE BRN.BKG_NO			=	BRB.BKG_NO" ).append("\n"); 
		query.append("			                       )" ).append("\n"); 

	}
}