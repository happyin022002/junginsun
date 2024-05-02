/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOEmptyCODMasterVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.02.05 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOEmptyCODMasterVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    head 조회
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOEmptyCODMasterVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOEmptyCODMasterVORSQL").append("\n"); 
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
		query.append("SELECT	L2, L1, M0, R1, R2" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("			SELECT  " ).append("\n"); 
		query.append("					LAG(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)||TO_CHAR(TO_DATE(WK_ST_DT,'YYYYMMDD')-14,'MM-DD')||'~'||TO_CHAR(TO_DATE(WK_END_DT,'YYYYMMDD')-14,'MM-DD')	L2,                                             " ).append("\n"); 
		query.append("					LAG(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)||TO_CHAR(TO_DATE(WK_ST_DT,'YYYYMMDD')-7,'MM-DD')||'~'||TO_CHAR(TO_DATE(WK_END_DT,'YYYYMMDD')-7,'MM-DD')	L1,                                             " ).append("\n"); 
		query.append("					PLN_YR||PLN_WK||TO_CHAR(TO_DATE(WK_ST_DT,'YYYYMMDD'),'MM-DD')||'~'||TO_CHAR(TO_DATE(WK_END_DT,'YYYYMMDD'),'MM-DD')										        M0," ).append("\n"); 
		query.append("					LEAD(PLN_YR||PLN_WK,1)		OVER (ORDER BY PLN_YR,PLN_WK)||TO_CHAR(TO_DATE(WK_ST_DT,'YYYYMMDD')+7,'MM-DD')||'~'||TO_CHAR(TO_DATE(WK_END_DT,'YYYYMMDD')+7,'MM-DD')	R1,                                             " ).append("\n"); 
		query.append("					LEAD(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)||TO_CHAR(TO_DATE(WK_ST_DT,'YYYYMMDD')+14,'MM-DD')||'~'||TO_CHAR(TO_DATE(WK_END_DT,'YYYYMMDD')+14,'MM-DD')	R2                                          " ).append("\n"); 
		query.append("			FROM	EQR_WK_PRD    " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("WHERE	SUBSTR(M0,0,6)	=	@[week]" ).append("\n"); 

	}
}