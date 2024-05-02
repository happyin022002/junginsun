/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterDBDAOSearchSavedJooLtrStlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.31
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.12.31 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOSearchSavedJooLtrStlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationLetterDBDAOSearchSavedJooLtrStlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOSearchSavedJooLtrStlRSQL").append("\n"); 
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
		query.append("SELECT   D.ACCT_YRMON" ).append("\n"); 
		query.append(",        D.VSL_SLAN_CD RLANE_CD" ).append("\n"); 
		query.append(",        SUM(D.JO_HJS_AMT)JO_HJS_AMT" ).append("\n"); 
		query.append(",        SUM(D.JO_PRNR_AMT)JO_PRNR_AMT" ).append("\n"); 
		query.append(",        SUM(D.JO_BAL_AMT)JO_BAL_AMT" ).append("\n"); 
		query.append(",        D.JO_CRR_CD" ).append("\n"); 
		query.append(",        D.STL_RMK" ).append("\n"); 
		query.append(",        CASE WHEN SUM(D.JO_HJS_AMT) < SUM(D.JO_PRNR_AMT) THEN" ).append("\n"); 
		query.append("'('||TO_CHAR(ABS(SUM(D.JO_BAL_AMT)),'fm999,999,999,999,990')||')'" ).append("\n"); 
		query.append("ELSE  TO_CHAR(SUM(D.JO_BAL_AMT),'fm999,999,999,999,990')" ).append("\n"); 
		query.append("END JO_BAL_AMT_LBL" ).append("\n"); 
		query.append(",       (SELECT  substr(xmlagg(xmlelement(a, '|' || S1.STL_CMB_SEQ) order by S1.STL_CMB_SEQ).extract('//text()').getStringVal(), 2)" ).append("\n"); 
		query.append("FROM JOO_LTR_STL S1 WHERE S1.JO_LTR_SEQ = M.JO_LTR_SEQ )STL_CMB_SEQ" ).append("\n"); 
		query.append("FROM    JOO_LETTER  M" ).append("\n"); 
		query.append(",       JOO_LTR_STL D" ).append("\n"); 
		query.append("WHERE   M.JO_LTR_SEQ=  D.JO_LTR_SEQ" ).append("\n"); 
		query.append("AND     M.JO_LTR_SEQ = @[jo_ltr_seq]" ).append("\n"); 
		query.append("GROUP BY  D.ACCT_YRMON" ).append("\n"); 
		query.append(",     D.VSL_SLAN_CD" ).append("\n"); 
		query.append(",D.JO_CRR_CD" ).append("\n"); 
		query.append(",D.STL_RMK" ).append("\n"); 
		query.append(", M.JO_LTR_SEQ" ).append("\n"); 
		query.append("ORDER BY D.VSL_SLAN_CD" ).append("\n"); 

	}
}