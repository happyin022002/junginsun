/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchErpToFaDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchErpToFaDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090907 FNS026-0001
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchErpToFaDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acq_mth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchErpToFaDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    'FNS026-0001' LIFID" ).append("\n"); 
		query.append("   ,A.EAI_IF_NO SEQ" ).append("\n"); 
		query.append("   ,A.IF_TTL_ROW_KNT TOTAL_COUNT" ).append("\n"); 
		query.append("   ,A.IF_SEQ RNUM" ).append("\n"); 
		query.append("   ,'OWN_GAAP_BOOK' BOOK_TYPE_CODE" ).append("\n"); 
		query.append("   , A.EQ_TPSZ_CD ASSET_DESCRIPTION" ).append("\n"); 
		query.append("   ,'A' ASSET_TYPE" ).append("\n"); 
		query.append("   , (SELECT FA_CATE_CD " ).append("\n"); 
		query.append("      FROM MST_FA_CATE " ).append("\n"); 
		query.append("      WHERE EQ_TPSZ_CD = A.EQ_TPSZ_CD AND ROWNUM =1) CATEGORY_SEGMENT" ).append("\n"); 
		query.append("   ,A.EQ_AQZ_AMT COST" ).append("\n"); 
		query.append("   ,'CNTR' LOCATION_SEGMENT" ).append("\n"); 
		query.append("   ,A.EQ_NO TAG_NUMBER" ).append("\n"); 
		query.append("   ,A.EQ_CURR_CD ATTRIBUTE1" ).append("\n"); 
		query.append("   ,A.EQ_AQZ_AMT ATTRIBUTE2" ).append("\n"); 
		query.append("   ,A.EQ_INVST_NO ATTRIBUTE3" ).append("\n"); 
		query.append("   ,A.FA_IF_GRP_SEQ_NO ATTRIBUTE4" ).append("\n"); 
		query.append("   ,DECODE(A.EQ_KND_CD, 'Z', 'CHS', 'G', 'MGS', null) CREATED_BY" ).append("\n"); 
		query.append("   ,TO_CHAR(SYSDATE,'YYYYMMDD') CREATION_DATE" ).append("\n"); 
		query.append("   ,DECODE(A.EQ_KND_CD, 'Z', 'CHS', 'G', 'MGS', null) LAST_UPDATED_BY" ).append("\n"); 
		query.append("   ,TO_CHAR(SYSDATE,'YYYYMMDD') LAST_UPDATE_DATE" ).append("\n"); 
		query.append("   ,@[vndr_lgl_eng_nm] MANUFACTURER" ).append("\n"); 
		query.append("   ,TO_CHAR(A.MFT_DT, 'YYYYMMDD') ATTRIBUTE21" ).append("\n"); 
		query.append("   ,REPLACE(@[acq_mth], '-','') ACQ_MTH" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("   CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("   A.EQ_NO = @[eq_no]" ).append("\n"); 

	}
}