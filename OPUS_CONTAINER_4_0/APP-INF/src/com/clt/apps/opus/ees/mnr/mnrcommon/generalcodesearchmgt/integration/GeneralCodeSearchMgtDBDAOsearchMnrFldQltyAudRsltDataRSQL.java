/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrFldQltyAudRsltDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.10.28 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 권영법
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchMnrFldQltyAudRsltDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FQA Audit History 정보를 조회 한다.
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchMnrFldQltyAudRsltDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchkey",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchMnrFldQltyAudRsltDataRSQL").append("\n"); 
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
		query.append("SELECT   DISTINCT" ).append("\n"); 
		query.append("A.YD_CD AS CD_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.FLD_AUD_DT,'YYYY-MM-DD') AS CD_DESC" ).append("\n"); 
		query.append("FROM MNR_FLD_QLTY_AUD_RSLT A" ).append("\n"); 
		query.append("#if (${searchcon} == 'COMMON')" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = TO_NUMBER(SUBSTR(@[searchkey], 1, 6))" ).append("\n"); 
		query.append("AND   A.OFC_CD   = SUBSTR(@[searchkey], 7)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TO_CHAR(A.FLD_AUD_DT,'YYYY-MM-DD') DESC" ).append("\n"); 

	}
}