/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOGetCNRailInbondAndBillNbrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetCNRailInbondAndBillNbrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CANADIAN NATIONAL RAILROAD INBOND NBR and Rail Bill Nbr
	  * 2015.04.16 Modify WBL_NO > RAIL_CRR_REF_NO , TRS_TRSP_EDI_RAIL_ORD > TRS_TRSP_RAIL_BIL_ORD
	  * </pre>
	  */
	public Edi315SendDBDAOGetCNRailInbondAndBillNbrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetCNRailInbondAndBillNbrRSQL").append("\n"); 
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
		query.append("select IBD_NO, RAIL_CRR_REF_NO " ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("	TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("where bkg_no =@[bkg_no] and eq_no = @[cntr_no] and delt_flg = 'N'" ).append("\n"); 

	}
}