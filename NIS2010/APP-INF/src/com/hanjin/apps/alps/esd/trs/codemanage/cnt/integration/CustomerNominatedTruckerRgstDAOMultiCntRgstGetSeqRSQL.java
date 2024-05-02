/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerNominatedTruckerRgstDAOMultiCntRgstGetSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerNominatedTruckerRgstDAOMultiCntRgstGetSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval No 채번
	  * </pre>
	  */
	public CustomerNominatedTruckerRgstDAOMultiCntRgstGetSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration").append("\n"); 
		query.append("FileName : CustomerNominatedTruckerRgstDAOMultiCntRgstGetSeqRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(@[cre_ofc_cd],1,3) -- 세션 오피스 코드" ).append("\n"); 
		query.append("     ||TO_CHAR(SYSDATE, 'YYMMDD')" ).append("\n"); 
		query.append("     ||NVL((SELECT LPAD(MAX(SUBSTR(APRO_NO, 10))+1, 4, '0')" ).append("\n"); 
		query.append("              FROM TRS_CUST_NOMI_TRKR" ).append("\n"); 
		query.append("             WHERE APRO_NO LIKE SUBSTR(@[cre_ofc_cd],1, 3)||TO_CHAR(SYSDATE, 'YYMMDD') || '%'" ).append("\n"); 
		query.append("               AND LENGTH(APRO_NO) >= 12 -- 12자리에서 한자리증가." ).append("\n"); 
		query.append("     ), '0001') APRO_NO" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}