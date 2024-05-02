/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllCntrSealInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllCntrSealInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllCntrSealInfo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllCntrSealInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllCntrSealInfoRSQL").append("\n"); 
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
		query.append("SELECT	'{CNTR_SEAL_NO'||CHR(10)||" ).append("\n"); 
		query.append("		'SEAL_TP:'||NVL(SEAL_PTY_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("		'SEAL_NO:'||NVL(CNTR_SEAL_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	    '}CNTR_SEAL_NO'||CHR(10) CNTR_SEAL_INFO" ).append("\n"); 
		query.append("FROM	BKG_CNTR_SEAL_NO S, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE   B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     B.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("AND		S.CNTR_NO(+) = @[cntr_no]" ).append("\n"); 
		query.append("AND 	S.CNTR_SEAL_SEQ(+) > 0" ).append("\n"); 

	}
}