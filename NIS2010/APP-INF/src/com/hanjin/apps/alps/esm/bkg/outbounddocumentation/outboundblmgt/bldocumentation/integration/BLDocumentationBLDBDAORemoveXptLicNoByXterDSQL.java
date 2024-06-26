/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAORemoveXptLicNoByXterDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.27
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.05.27 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAORemoveXptLicNoByXterDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eBKG에서 Export Licens Number(US, CA, MX, KR)를 삭제한다.
	  * (CHM-201641586) Export/ Import information상의 other reference no. 관련 시스템 보완 요청
	  * </pre>
	  */
	public BLDocumentationBLDBDAORemoveXptLicNoByXterDSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAORemoveXptLicNoByXterDSQL").append("\n"); 
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
		query.append("DELETE BKG_XPT_IMP_LIC LIC" ).append("\n"); 
		query.append(" WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("--   AND IO_BND_CD    LIKE ( SELECT DECODE(SUBSTR(POD_CD,1,2),'MX','%',DECODE(SUBSTR(DEL_CD,1,2),'MX','%','O')) FROM BKG_BOOKING" ).append("\n"); 
		query.append("--                           WHERE LIC.BKG_NO = BKG_NO )" ).append("\n"); 
		query.append("   and ts_ref_no is null -- 수동 입력 된 것은 남김 (CHM-201641586)" ).append("\n"); 
		query.append("   AND CNT_CD IN ('US','CA','MX','KR','TR','PE','EC','CO','IL','LB','BR')" ).append("\n"); 

	}
}