/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchLastDMTInvNoSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.02
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.11.02 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchLastDMTInvNoSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchLastDMTInvNoSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchLastDMTInvNoSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchLastDMTInvNoSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM INV_AR_MN A, INV_AR_STUP_OFC B" ).append("\n"); 
		query.append(" WHERE A.AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("   AND A.BL_SRC_NO = DECODE(B.DMDT_INV_APLY_BL_FLG, 'N', @[bl_src_no], @[inv_src_no])" ).append("\n"); 
		query.append("   AND A.INV_SRC_NO =  @[inv_src_no]" ).append("\n"); 
		query.append("   AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("   AND A.REV_SRC_CD IN ('DM','DT')" ).append("\n"); 

	}
}