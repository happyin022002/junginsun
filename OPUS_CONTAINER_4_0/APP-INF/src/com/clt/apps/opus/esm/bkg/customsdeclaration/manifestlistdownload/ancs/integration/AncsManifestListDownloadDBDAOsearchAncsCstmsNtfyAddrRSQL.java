/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsNtfyAddrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.11 정재엽
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

public class AncsManifestListDownloadDBDAOsearchAncsCstmsNtfyAddrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsCstmsNtfyAddrRSQL(){
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
		params.put("key_addr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsNtfyAddrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("ADDR_SEQ" ).append("\n"); 
		query.append(",KEY_ADDR" ).append("\n"); 
		query.append(",CUST_ADDR1" ).append("\n"); 
		query.append(",CUST_ADDR2" ).append("\n"); 
		query.append(",CUST_ADDR3" ).append("\n"); 
		query.append(",CUST_ADDR4" ).append("\n"); 
		query.append(",CUST_ADDR5" ).append("\n"); 
		query.append(",AR_CUST_REF_NO" ).append("\n"); 
		query.append(",NTFY_LTR_RMK" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_OFC_CD" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_NTFY_ADDR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND KEY_ADDR LIKE @[key_addr] || '%'" ).append("\n"); 
		query.append("AND UPD_OFC_CD = @[upd_ofc_cd]" ).append("\n"); 

	}
}