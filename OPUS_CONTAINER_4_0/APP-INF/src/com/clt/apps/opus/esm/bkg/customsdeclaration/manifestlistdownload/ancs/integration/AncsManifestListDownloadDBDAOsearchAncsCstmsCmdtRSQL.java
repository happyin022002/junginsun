/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsManiestListDownloadDBDAOsearchAncsCstmsCmdtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.18 정재엽
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

public class AncsManifestListDownloadDBDAOsearchAncsCstmsCmdtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsCstmsCmdtRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("CMDT.VSL_CD || CMDT.SKD_VOY_NO || CMDT.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(",CMDT.VSL_CD" ).append("\n"); 
		query.append(",CMDT.SKD_VOY_NO" ).append("\n"); 
		query.append(",CMDT.SKD_DIR_CD" ).append("\n"); 
		query.append(",CMDT.BKG_NO" ).append("\n"); 
		query.append(",CMDT.CNTR_NO" ).append("\n"); 
		query.append(",CMDT.CNTR_SEQ" ).append("\n"); 
		query.append(",CMDT.DECL_FLG" ).append("\n"); 
		query.append(",CMDT.PCK_QTY" ).append("\n"); 
		query.append(",CMDT.PCK_TP_CD" ).append("\n"); 
		query.append(",CMDT.CNTR_MF_WGT" ).append("\n"); 
		query.append(",CMDT.WGT_UT_CD" ).append("\n"); 
		query.append(",CMDT.CNTR_MF_DESC" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_CMDT CMDT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD        =  SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND SKD_VOY_NO    =  SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND SKD_DIR_CD    =  SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("AND BKG_NO          =  @[bkg_no]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManiestListDownloadDBDAOsearchAncsCstmsCmdtRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}