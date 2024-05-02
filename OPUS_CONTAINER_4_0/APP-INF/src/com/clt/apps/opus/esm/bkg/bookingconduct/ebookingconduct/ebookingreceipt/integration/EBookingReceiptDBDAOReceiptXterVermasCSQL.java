/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOReceiptXterVermasCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.07.13 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOReceiptXterVermasCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EBookingReceiptDBDAOReceiptXterVermasCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNTR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VGM_CUST_STE_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VGM_CUST_ADDR",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("XTER_SNDR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VGM_CUST_PST_ADDR",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VGM_CUST_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VSL_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("XTER_VGM_DOC_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VGM_CUST_CTY_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("XTER_VGM_RQST_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VGM_CUST_CNTC_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EDI_PRNR_LOC_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EDI_PRNR_YD_NM",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOReceiptXterVermasCSQL").append("\n"); 
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
		query.append("INSERT INTO ${table_name} (" ).append("\n"); 
		query.append("CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("#if ($table_date_columns.size() > 0)" ).append("\n"); 
		query.append("     #foreach($tableDateColumns IN ${table_date_columns})" ).append("\n"); 
		query.append("        ,${tableDateColumns}" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($table_columns.size() > 0)" ).append("\n"); 
		query.append("     #foreach($tableColumn IN ${table_columns})" ).append("\n"); 
		query.append("		,${tableColumn}" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${table_name} == 'BKG_XTER_VGM_REF_NO' || ${table_name} == 'BKG_XTER_VGM_CUST') " ).append("\n"); 
		query.append("	, XTER_REF_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${table_name} == 'BKG_XTER_VGM_RQST') " ).append("\n"); 
		query.append("	, EDI_PRNR_YD_NM" ).append("\n"); 
		query.append("	, EDI_PRNR_LOC_NM" ).append("\n"); 
		query.append("	, VSL_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${table_name} == 'BKG_XTER_VGM_CUST') " ).append("\n"); 
		query.append("	, VGM_CUST_ADDR" ).append("\n"); 
		query.append("	, VGM_CUST_NM" ).append("\n"); 
		query.append("	, VGM_CUST_CNTC_NM" ).append("\n"); 
		query.append("	, VGM_CUST_CTY_NM" ).append("\n"); 
		query.append("	, VGM_CUST_STE_NM" ).append("\n"); 
		query.append("	, VGM_CUST_PST_ADDR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("#if ($table_date_values.size() > 0)" ).append("\n"); 
		query.append("     #foreach($tableDateValue IN ${table_date_values})" ).append("\n"); 
		query.append("        ,to_date('${tableDateValue}','yyyyMMddhh24miss')" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($table_values.size() > 0)" ).append("\n"); 
		query.append("     #foreach($tableValue IN ${table_values})" ).append("\n"); 
		query.append("         , REPLACE('${tableValue}','$^',CHR(39))" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${table_name} == 'BKG_XTER_VGM_REF_NO' || ${table_name} == 'BKG_XTER_VGM_CUST') " ).append("\n"); 
		query.append("	, (SELECT COUNT(*)+1 AS XTER_REF_SEQ " ).append("\n"); 
		query.append("		FROM ${table_name} " ).append("\n"); 
		query.append("		WHERE XTER_SNDR_ID = @[XTER_SNDR_ID] " ).append("\n"); 
		query.append("		AND XTER_VGM_DOC_ID = @[XTER_VGM_DOC_ID] " ).append("\n"); 
		query.append("		AND XTER_VGM_RQST_SEQ = @[XTER_VGM_RQST_SEQ] " ).append("\n"); 
		query.append("		AND CNTR_NO = @[CNTR_NO])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${table_name} == 'BKG_XTER_VGM_RQST') " ).append("\n"); 
		query.append("	, @[EDI_PRNR_YD_NM]" ).append("\n"); 
		query.append("	, @[EDI_PRNR_LOC_NM]" ).append("\n"); 
		query.append("	, @[VSL_NM]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${table_name} == 'BKG_XTER_VGM_CUST') " ).append("\n"); 
		query.append("	, @[VGM_CUST_ADDR]" ).append("\n"); 
		query.append("	, @[VGM_CUST_NM]" ).append("\n"); 
		query.append("	, @[VGM_CUST_CNTC_NM]" ).append("\n"); 
		query.append("	, @[VGM_CUST_CTY_NM]" ).append("\n"); 
		query.append("	, @[VGM_CUST_STE_NM]" ).append("\n"); 
		query.append("	, @[VGM_CUST_PST_ADDR]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}