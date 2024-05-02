/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FQAResultMgtDBDAOcheckFQAResultListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.01.07 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FQAResultMgtDBDAOcheckFQAResultListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FQAResultMgtDBDAOcheckFQAResultListDataRSQL
	  * </pre>
	  */
	public FQAResultMgtDBDAOcheckFQAResultListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fld_aud_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.integration").append("\n"); 
		query.append("FileName : FQAResultMgtDBDAOcheckFQAResultListDataRSQL").append("\n"); 
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
		query.append("SELECT COUNT(A.VNDR_SEQ) CNT" ).append("\n"); 
		query.append("FROM MNR_FLD_QLTY_AUD_RSLT A" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("AND A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND TO_CHAR(A.FLD_AUD_DT,'YYYY-MM-DD') = @[fld_aud_dt]" ).append("\n"); 

	}
}