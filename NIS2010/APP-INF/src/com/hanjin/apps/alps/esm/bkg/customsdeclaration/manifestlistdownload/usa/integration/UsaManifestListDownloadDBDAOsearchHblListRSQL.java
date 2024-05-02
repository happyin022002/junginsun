/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchHblListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.15 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchHblListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaBlHblListVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchHblListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchHblListRSQL").append("\n"); 
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
		query.append("SELECT  B.BL_NO " ).append("\n"); 
		query.append("	   ,R.CSTMS_CLR_CD" ).append("\n"); 
		query.append("	   ,B.PCK_QTY" ).append("\n"); 
		query.append("       ,B.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("       ,I.IBD_TRSP_NO" ).append("\n"); 
		query.append("       ,B.HUB_LOC_CD" ).append("\n"); 
		query.append("       ,C.CUST_NM || CHR(13) || C.CUST_ADDR AS CNEE" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_IBD I" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_CUST C" ).append("\n"); 
		query.append("       ,BKG_CGO_RLSE R" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     B.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND     B.MF_NO = @[bl_no]" ).append("\n"); 
		query.append("AND     B.MF_NO = R.BL_NO(+)" ).append("\n"); 
		query.append("AND     B.CNT_CD = I.CNT_CD" ).append("\n"); 
		query.append("AND     B.MF_NO = I.BL_NO" ).append("\n"); 
		query.append("AND     B.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("AND     B.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("AND     C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 

	}
}