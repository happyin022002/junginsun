/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOmodifyT1IndForYUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOmodifyT1IndForYUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용 B/L Info의 T1 Indicator를 업데이트 한다. (B/L Creation Indicator = 'Y')
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOmodifyT1IndForYUSQL(){
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
		params.put("crn_number",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOmodifyT1IndForYUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_RTM_BL" ).append("\n"); 
		query.append("SET    T1_DOC_CD = 'D'" ).append("\n"); 
		query.append("WHERE  VSL_CALL_REF_NO = @[crn_number]" ).append("\n"); 
		query.append("AND	 BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_RTM_TRO TRO" ).append("\n"); 
		query.append("WHERE  BKG_CSTMS_RTM_BL.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("AND    TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND    DOC_CMPL_FLG = 'Y')" ).append("\n"); 

	}
}