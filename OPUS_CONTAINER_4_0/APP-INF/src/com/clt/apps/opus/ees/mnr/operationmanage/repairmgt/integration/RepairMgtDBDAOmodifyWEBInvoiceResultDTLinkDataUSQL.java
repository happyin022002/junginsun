/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RepairMgtDBDAOmodifyWEBInvoiceResultDTLinkDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.06
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.10.06 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOmodifyWEBInvoiceResultDTLinkDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RepairMgtDBDAOmodifyWEBInvoiceResultDTLinkDataUSQL
	  * </pre>
	  */
	public RepairMgtDBDAOmodifyWEBInvoiceResultDTLinkDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rslt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ord_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOmodifyWEBInvoiceResultDTLinkDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_ORD_DTL SET  " ).append("\n"); 
		query.append("  UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append(" ,RPR_RSLT_DT = TO_DATE(@[rpr_rslt_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(" ,UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE MNR_ORD_OFC_CTY_CD = @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   MNR_ORD_SEQ        = @[mnr_ord_seq]" ).append("\n"); 
		query.append("AND   ORD_DTL_SEQ        = @[ord_dtl_seq]" ).append("\n"); 

	}
}