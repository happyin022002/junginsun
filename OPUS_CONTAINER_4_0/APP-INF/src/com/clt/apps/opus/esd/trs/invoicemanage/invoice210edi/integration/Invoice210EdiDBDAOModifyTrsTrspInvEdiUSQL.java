/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Invoice210EdiDBDAOModifyTrsTrspInvEdiUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.12.01 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiDBDAOModifyTrsTrspInvEdiUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyTrsTrspInvEdi UPDATE TRS_TRSP_INV_EDI TABLE
	  * </pre>
	  */
	public Invoice210EdiDBDAOModifyTrsTrspInvEdiUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_edi_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration").append("\n"); 
		query.append("FileName : Invoice210EdiDBDAOModifyTrsTrspInvEdiUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_INV_EDI" ).append("\n"); 
		query.append("SET    INV_RMK = @[inv_rmk]" ).append("\n"); 
		query.append("WHERE  TRSP_INV_EDI_SEQ = @[trsp_inv_edi_seq]" ).append("\n"); 

	}
}