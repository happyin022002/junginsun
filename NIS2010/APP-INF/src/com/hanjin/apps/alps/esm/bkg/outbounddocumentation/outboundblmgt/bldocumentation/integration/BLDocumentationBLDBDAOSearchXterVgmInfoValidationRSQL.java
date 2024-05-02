/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchXterVgmInfoValidationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchXterVgmInfoValidationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Xter VGM 정보를 Upload 하기 전 validation 체크 한다.
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchXterVgmInfoValidationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchXterVgmInfoValidationRSQL").append("\n"); 
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
		query.append("SELECT @[bkg_no]  BKG_NO" ).append("\n"); 
		query.append("     , @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append("     , NVL((SELECT BKG_STS_CD " ).append("\n"); 
		query.append("              FROM BKG_BOOKING " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]),'N')  BKG_STS_CD " ).append("\n"); 
		query.append("     , NVL((SELECT CNMV_STS_CD " ).append("\n"); 
		query.append("              FROM MST_CONTAINER" ).append("\n"); 
		query.append("             WHERE CNTR_NO = @[cntr_no]),'N') CNMV_STS_CD" ).append("\n"); 
		query.append("     , NVL((SELECT 'Y' " ).append("\n"); 
		query.append("              FROM BKG_CONTAINER " ).append("\n"); 
		query.append("             WHERE BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("               AND CNTR_NO = @[cntr_no]),'N') BKG_CNTR_EXISTS " ).append("\n"); 
		query.append("     -- only for VO" ).append("\n"); 
		query.append("     , '' AS RJCT_RSN_RMK" ).append("\n"); 
		query.append("     , '' AS NEED_ATCH_CNTR" ).append("\n"); 
		query.append("     , (SELECT RCV_TERM_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]) RCV_TERM_CD" ).append("\n"); 
		query.append("     , (SELECT DE_TERM_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]) DE_TERM_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}