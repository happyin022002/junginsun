/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOaddBkgXterCntrMkDescCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 김영철
*@LastVersion : 1.0
* 2009.12.28 김영철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim YC
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOaddBkgXterCntrMkDescCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgXterCntrMkDesc
	  * </pre>
	  */
	public EBookingReceiptDBDAOaddBkgXterCntrMkDescCSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOaddBkgXterCntrMkDescCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_XTER_CNTR_MK_DESC" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("XTER_SNDR_ID" ).append("\n"); 
		query.append(",XTER_RQST_NO" ).append("\n"); 
		query.append(",XTER_RQST_SEQ" ).append("\n"); 
		query.append(",CNTR_SEQ" ).append("\n"); 
		query.append(",MK_DESC_SEQ" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("#if (${cntr_no_size} == '0')" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($table_date_columns.size() > 0)" ).append("\n"); 
		query.append("#foreach($tableColumn IN ${table_columns})" ).append("\n"); 
		query.append(",${tableColumn}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach($tableDateColumns IN ${table_date_columns})" ).append("\n"); 
		query.append("#if($velocityCount < $table_date_columns.size()) ,${tableDateColumns} #else ,${tableDateColumns} #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#foreach($tableColumn IN ${table_columns})" ).append("\n"); 
		query.append("#if($velocityCount < $table_columns.size()) ,${tableColumn} #else ,${tableColumn} #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[sender_id]" ).append("\n"); 
		query.append(",@[rqst_no]" ).append("\n"); 
		query.append(",@[rqst_seq]" ).append("\n"); 
		query.append(",NVL(" ).append("\n"); 
		query.append("(SELECT CNTR_SEQ" ).append("\n"); 
		query.append("FROM BKG_XTER_CNTR" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("#if (${cntr_no_size} != '0')" ).append("\n"); 
		query.append("AND CNTR_NO = #foreach($cntrNo IN ${cntr_no}) '${cntrNo}' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(CNTR_SEQ), 0) + 1" ).append("\n"); 
		query.append("FROM BKG_XTER_CNTR_MK_DESC" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID   = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO   = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ  = @[rqst_seq])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(MK_DESC_SEQ), 0) + 1" ).append("\n"); 
		query.append("FROM BKG_XTER_CNTR_MK_DESC" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID   = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO   = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ  = @[rqst_seq]" ).append("\n"); 
		query.append("#if (${cntr_no_size} != '0')" ).append("\n"); 
		query.append("AND CNTR_NO = #foreach($cntrNo IN ${cntr_no}) '${cntrNo}' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append("#if (${cntr_no_size} == '0')" ).append("\n"); 
		query.append(",'No Data'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($table_date_columns.size() > 0)" ).append("\n"); 
		query.append("#foreach($tableValue IN ${table_values})" ).append("\n"); 
		query.append(",'${tableValue}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach($tableDateValue IN ${table_date_values})" ).append("\n"); 
		query.append("#if($velocityCount < $table_date_values.size()) ,to_date('${tableDateValue}','yyyyMMddhh24miss') #else ,to_date('${tableDateValue}','yyyyMMddhh24miss') #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#foreach($tableValue IN ${table_values})" ).append("\n"); 
		query.append("#if($velocityCount < $table_values.size()) ,'${tableValue}' #else ,'${tableValue}' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}