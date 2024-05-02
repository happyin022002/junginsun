/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateQuotationDBDAOPriRqScgAdjDeleteByQttnNoDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.10 이승준
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

public class RFARateQuotationDBDAOPriRqScgAdjDeleteByQttnNoDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteByQttnNo
	  * </pre>
	  */
	public RFARateQuotationDBDAOPriRqScgAdjDeleteByQttnNoDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration ").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAOPriRqScgAdjDeleteByQttnNoDSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_RQ_SCG_ADJ" ).append("\n"); 
		query.append("WHERE	QTTN_NO = @[qttn_no]" ).append("\n"); 

	}
}