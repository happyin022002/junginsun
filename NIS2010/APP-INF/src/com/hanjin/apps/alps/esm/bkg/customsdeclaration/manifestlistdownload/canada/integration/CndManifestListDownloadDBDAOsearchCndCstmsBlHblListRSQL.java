/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchCndCstmsBlHblListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.06.18 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Min Jeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchCndCstmsBlHblListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndCstmsBlCstmsRslt
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchCndCstmsBlHblListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  A.BL_NO" ).append("\n"); 
		query.append(",DECODE(A.MF_NO, NULL, 'M', 'H') AS HM" ).append("\n"); 
		query.append(",A.PCK_QTY" ).append("\n"); 
		query.append(",A.AMS_PCK_TP_CD" ).append("\n"); 
		query.append(",A.HUB_LOC_CD" ).append("\n"); 
		query.append(",C.CUST_NM" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append(",BKG_CSTMS_ADV_CUST C" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND  A.CNT_CD = 'CA'" ).append("\n"); 
		query.append("AND  A.CNT_CD = C.CNT_CD(+)" ).append("\n"); 
		query.append("AND  A.BL_NO = C.BL_NO(+)" ).append("\n"); 
		query.append("AND  C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND  A.MF_NO = @[bl_no]" ).append("\n"); 
		query.append("--   AND  A.CSTMS_FILE_TP_CD <> '1' --HBL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchCndCstmsBlHblListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}