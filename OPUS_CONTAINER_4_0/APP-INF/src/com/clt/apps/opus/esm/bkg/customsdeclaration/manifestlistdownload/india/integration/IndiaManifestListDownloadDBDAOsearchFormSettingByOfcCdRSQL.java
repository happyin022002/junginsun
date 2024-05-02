/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOsearchFormSettingByOfcCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.17 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOsearchFormSettingByOfcCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INDIA 에서 세관에 적하목록을 신고하기 위한 Cover Form Setting 하는 operation
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOsearchFormSettingByOfcCdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("OFC_CD" ).append("\n"); 
		query.append(",HDR_CTNT" ).append("\n"); 
		query.append(",FTR_CTNT" ).append("\n"); 
		query.append(",DECL_ADDR" ).append("\n"); 
		query.append(",BOD_CTNT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_IDA_PRN_FOM" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration ").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOsearchFormSettingByOfcCdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}