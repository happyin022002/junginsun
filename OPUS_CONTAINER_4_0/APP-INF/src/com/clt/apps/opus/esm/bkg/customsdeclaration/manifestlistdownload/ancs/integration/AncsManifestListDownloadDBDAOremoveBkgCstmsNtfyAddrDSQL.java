/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsManiestListDownloadDBDAOremoveBkgCstmsNtfyAddrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.15 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOremoveBkgCstmsNtfyAddrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * de
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOremoveBkgCstmsNtfyAddrDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE BKG_CSTMS_NTFY_ADDR" ).append("\n"); 
		query.append("WHERE ADDR_SEQ = @[addr_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration ").append("\n"); 
		query.append("FileName : AncsManiestListDownloadDBDAOremoveBkgCstmsNtfyAddrDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}