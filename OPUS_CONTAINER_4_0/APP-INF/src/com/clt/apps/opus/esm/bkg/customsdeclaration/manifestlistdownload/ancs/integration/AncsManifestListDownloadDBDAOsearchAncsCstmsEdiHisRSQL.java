/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsEdiHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.29 정재엽
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

public class AncsManifestListDownloadDBDAOsearchAncsCstmsEdiHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsCstmsEdiHisRSQL(){
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
		params.put("msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("anr_decl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration ").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsEdiHisRSQL").append("\n"); 
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
		query.append("SELECT EDI_SND_STS_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_EDI_HIS" ).append("\n"); 
		query.append("WHERE MSG_TP_CD   = @[msg_tp_cd]" ).append("\n"); 
		query.append("AND ANR_DECL_NO = @[anr_decl_no]" ).append("\n"); 
		query.append("AND REF_SEQ = @[ref_seq]" ).append("\n"); 

	}
}