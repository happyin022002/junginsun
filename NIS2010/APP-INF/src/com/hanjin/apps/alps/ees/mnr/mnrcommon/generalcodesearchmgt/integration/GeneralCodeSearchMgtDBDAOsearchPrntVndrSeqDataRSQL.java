/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchPrntVndrSeqDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.02.11 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchPrntVndrSeqDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralCodeSearchMgtDBDAOsearchPrntVndrSeqDataRSQL
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchPrntVndrSeqDataRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchPrntVndrSeqDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.PRNT_VNDR_SEQ) AS CD_ID," ).append("\n"); 
		query.append("      (SELECT B.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("       FROM MDM_VENDOR  B" ).append("\n"); 
		query.append("       WHERE B.VNDR_SEQ = A.PRNT_VNDR_SEQ) AS CD_DESC" ).append("\n"); 
		query.append("FROM MDM_VENDOR A" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = @[searchkey]" ).append("\n"); 

	}
}