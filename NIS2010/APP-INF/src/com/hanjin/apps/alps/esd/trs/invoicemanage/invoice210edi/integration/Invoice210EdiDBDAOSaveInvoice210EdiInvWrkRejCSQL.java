/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * saveInvoice210Edi TRS_TRSP_INV_WRK TABLE INSERT
	  * </pre>
	  */
	public Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.integration").append("\n"); 
		query.append("FileName : Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_INV_WRK (" ).append("\n"); 
		query.append("INV_NO             ," ).append("\n"); 
		query.append("INV_VNDR_SEQ       ," ).append("\n"); 
		query.append("TRSP_INV_AUD_STS_CD," ).append("\n"); 
		query.append("WO_VNDR_SEQ        ," ).append("\n"); 
		query.append("INV_CURR_CD        ," ).append("\n"); 
		query.append("INV_BZC_AMT        ," ).append("\n"); 
		query.append("INV_TTL_AMT		   ," ).append("\n"); 
		query.append("INV_RJCT_FLG       ," ).append("\n"); 
		query.append("INV_RJCT_DT        ," ).append("\n"); 
		query.append("INV_RCV_DT         ," ).append("\n"); 
		query.append("INV_ISS_DT         ," ).append("\n"); 
		query.append("IF_SYS_KND_CD      ," ).append("\n"); 
		query.append("DELT_FLG           ," ).append("\n"); 
		query.append("CRE_OFC_CD         ," ).append("\n"); 
		query.append("CRE_USR_ID         ," ).append("\n"); 
		query.append("CRE_DT             ," ).append("\n"); 
		query.append("UPD_USR_ID         ," ).append("\n"); 
		query.append("UPD_DT			   ," ).append("\n"); 
		query.append("LOCL_CRE_DT        ," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[inv_no]          ," ).append("\n"); 
		query.append("@[inv_vndr_seq]    ," ).append("\n"); 
		query.append("'RJ'               ," ).append("\n"); 
		query.append("@[wo_vndr_seq]     ," ).append("\n"); 
		query.append("@[inv_curr_cd]     ," ).append("\n"); 
		query.append("@[inv_bzc_amt]	   ," ).append("\n"); 
		query.append("@[inv_ttl_amt]	   ," ).append("\n"); 
		query.append("'Y'                ," ).append("\n"); 
		query.append("SYSDATE            ," ).append("\n"); 
		query.append("SYSDATE            ," ).append("\n"); 
		query.append("SYSDATE            ," ).append("\n"); 
		query.append("'I'                ," ).append("\n"); 
		query.append("'N'                ," ).append("\n"); 
		query.append("@[cre_ofc_cd]      ," ).append("\n"); 
		query.append("@[cre_usr_id]      ," ).append("\n"); 
		query.append("SYSDATE            ," ).append("\n"); 
		query.append("@[upd_usr_id]      ," ).append("\n"); 
		query.append("SYSDATE			   ," ).append("\n"); 
		query.append("SYSDATE			   ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}