/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GuaranteeManageDBDAOSearchUSGuaranteeHdrSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.03.16 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeManageDBDAOSearchUSGuaranteeHdrSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee Header Max Seq 조회
	  * </pre>
	  */
	public GuaranteeManageDBDAOSearchUSGuaranteeHdrSeqRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration").append("\n"); 
		query.append("FileName : GuaranteeManageDBDAOSearchUSGuaranteeHdrSeqRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("(SUBSTR(@[ofc_cd], 1, 3) || TO_CHAR(SYSDATE, 'YYMM') ||" ).append("\n"); 
		query.append("(SELECT LPAD((NVL(MAX(CASE WHEN GNTE_NO IS NOT NULL AND LENGTH(GNTE_NO) > 7" ).append("\n"); 
		query.append("THEN SUBSTR(GNTE_NO, 8)" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END), 0) + 1), 5, 0)" ).append("\n"); 
		query.append("FROM	TES_GNTE_HDR GH2" ).append("\n"); 
		query.append("WHERE	GH2.OFC_CD LIKE SUBSTR(@[ofc_cd], 1, 3) || '%' ) ) GRN_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}