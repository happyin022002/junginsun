/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateQuotationDBDAOLoadExcelCheckRepCmdtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.10.19 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAOLoadExcelCheckRepCmdtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LoadExcelCheckRepCmdt
	  * </pre>
	  */
	public RFARateQuotationDBDAOLoadExcelCheckRepCmdtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration ").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAOLoadExcelCheckRepCmdtRSQL").append("\n"); 
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
		query.append("SELECT REP_CMDT_CD AS CD" ).append("\n"); 
		query.append(",REP_CMDT_NM AS NM" ).append("\n"); 
		query.append("FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("WHERE REP_CMDT_CD = @[cd]" ).append("\n"); 
		query.append("AND   DELT_FLG ='N'" ).append("\n"); 

	}
}