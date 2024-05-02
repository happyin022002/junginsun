/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SCReportDBDAORsltMdmChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.14
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.06.14 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltMdmChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * charge 리스트 조회 - 콤보용
	  * </pre>
	  */
	public SCReportDBDAORsltMdmChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration ").append("\n"); 
		query.append("FileName : SCReportDBDAORsltMdmChargeListRSQL").append("\n"); 
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
		query.append("SELECT	CHG_CD" ).append("\n"); 
		query.append("       ,CHG_NM" ).append("\n"); 
		query.append("       ,REP_CHG_CD" ).append("\n"); 
		query.append("FROM	MDM_CHARGE" ).append("\n"); 
		query.append("WHERE 	DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${rep_chg_cd} != '') " ).append("\n"); 
		query.append("AND     REP_CHG_CD = @[rep_chg_cd]" ).append("\n"); 
		query.append("ORDER BY REP_CHG_CD, CHG_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY CHG_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}