/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOaddBkgXterCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOaddBkgXterCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgXterCust
	  * 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청
	  * </pre>
	  */
	public EBookingReceiptDBDAOaddBkgXterCustCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOaddBkgXterCustCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_XTER_CUST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("XTER_SNDR_ID" ).append("\n"); 
		query.append(",XTER_RQST_NO" ).append("\n"); 
		query.append(",XTER_RQST_SEQ" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("#if ($table_date_columns.size() > 0)" ).append("\n"); 
		query.append("     #foreach($tableColumn IN ${table_columns})" ).append("\n"); 
		query.append("		,${tableColumn}" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #foreach($tableDateColumns IN ${table_date_columns})" ).append("\n"); 
		query.append("        ,${tableDateColumns}" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     #foreach($tableColumn IN ${table_columns})" ).append("\n"); 
		query.append("        ,${tableColumn}" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[sender_id]" ).append("\n"); 
		query.append(",@[rqst_no]" ).append("\n"); 
		query.append(",@[rqst_seq]" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append("#if ($table_date_columns.size() > 0)" ).append("\n"); 
		query.append("     #foreach($tableValue IN ${table_values})" ).append("\n"); 
		query.append("		,'${tableValue}'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #foreach($tableDateValue IN ${table_date_values})" ).append("\n"); 
		query.append("        ,to_date('${tableDateValue}','yyyyMMddhh24miss')" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     #foreach($tableValue IN ${table_values})" ).append("\n"); 
		query.append("        ,'${tableValue}'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}