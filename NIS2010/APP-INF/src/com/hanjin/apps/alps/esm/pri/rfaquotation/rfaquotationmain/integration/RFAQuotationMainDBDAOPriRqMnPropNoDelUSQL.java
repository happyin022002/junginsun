/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAQuotationMainDBDAOPriRqMnPropNoDelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.14
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.03.14 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mood Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAQuotationMainDBDAOPriRqMnPropNoDelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal 삭제 시 해당하는 Quotation Main 의 Prop No 를 공백으로 업데이트 한다.
	  * </pre>
	  */
	public RFAQuotationMainDBDAOPriRqMnPropNoDelUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration ").append("\n"); 
		query.append("FileName : RFAQuotationMainDBDAOPriRqMnPropNoDelUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RQ_MN SET" ).append("\n"); 
		query.append("PROP_NO = NULL" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 

	}
}