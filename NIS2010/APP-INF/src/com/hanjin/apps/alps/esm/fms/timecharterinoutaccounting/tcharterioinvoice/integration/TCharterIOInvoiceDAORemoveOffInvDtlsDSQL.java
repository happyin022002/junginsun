/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAORemoveOffInvDtlsDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.11 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class TCharterIOInvoiceDAORemoveOffInvDtlsDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAORemoveOffInvDtlsDSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAORemoveOffInvDtlsDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("delete from fms_inv_dtl" ).append("\n"); 
		query.append("where flet_ctrt_no = @[flet_ctrt_no]" ).append("\n"); 
		query.append("and flet_iss_tp_cd = 'OFF'" ).append("\n"); 
		query.append("and inv_seq = @[inv_seq]" ).append("\n"); 
		query.append("and inv_dtl_seq = @[inv_dtl_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration ").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAORemoveOffInvDtlsDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}