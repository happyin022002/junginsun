/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceMgtDBDAOaddTempNewPortHDRDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOaddTempNewPortHDRDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addTempNewPortHDRData
	  * </pre>
	  */
	public InterfaceMgtDBDAOaddTempNewPortHDRDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_rcv_ord_inv_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_whld_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOaddTempNewPortHDRDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ORD_TMP_HDR(" ).append("\n"); 
		query.append("        MNR_RCV_ORD_INV_TMP_SEQ, " ).append("\n"); 
		query.append("        INV_NO, " ).append("\n"); 
		query.append("        VNDR_SEQ, " ).append("\n"); 
		query.append("        CURR_CD, " ).append("\n"); 
		query.append("        INV_AMT, " ).append("\n"); 
		query.append("        VAT_AMT, " ).append("\n"); 
		query.append("        INV_WHLD_TAX_AMT, " ).append("\n"); 
		query.append("        COST_OFC_CD, " ).append("\n"); 
		query.append("        RCV_DT, " ).append("\n"); 
		query.append("        INV_CFM_DT, " ).append("\n"); 
		query.append("        VRFY_RSLT_DESC, " ).append("\n"); 
		query.append("        CRE_USR_ID, " ).append("\n"); 
		query.append("        CRE_DT, " ).append("\n"); 
		query.append("        UPD_USR_ID, " ).append("\n"); 
		query.append("        UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("            @[mnr_rcv_ord_inv_tmp_seq]" ).append("\n"); 
		query.append("           ,@[inv_no]" ).append("\n"); 
		query.append("           ,@[vndr_seq]" ).append("\n"); 
		query.append("           ,@[curr_cd]" ).append("\n"); 
		query.append("           ,@[inv_amt]" ).append("\n"); 
		query.append("		   ,@[vat_amt]" ).append("\n"); 
		query.append("           ,@[inv_whld_tax_amt]" ).append("\n"); 
		query.append("           ,@[cost_ofc_cd]" ).append("\n"); 
		query.append("           ,TO_DATE(@[rcv_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,TO_DATE(@[inv_cfm_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,'UN'" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}