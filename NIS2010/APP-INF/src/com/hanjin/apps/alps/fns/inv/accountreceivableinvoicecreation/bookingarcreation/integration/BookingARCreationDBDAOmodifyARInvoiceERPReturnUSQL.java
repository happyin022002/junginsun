/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOmodifyARInvoiceERPReturnUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.05.11 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOmodifyARInvoiceERPReturnUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOmodifyARInvoiceERPReturnUSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOmodifyARInvoiceERPReturnUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_result",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_ser",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("error_msg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOmodifyARInvoiceERPReturnUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_AMT A" ).append("\n"); 
		query.append("   SET A.INV_ERP_IF_STS_CD = @[if_result]" ).append("\n"); 
		query.append("     , A.ERR_DESC = @[error_msg]" ).append("\n"); 
		query.append("     , A.ERP_IF_DT = DECODE(A.ERP_IF_DT, '', TO_CHAR(SYSDATE,'YYYYMMDD'), A.ERP_IF_DT) " ).append("\n"); 
		query.append("     , A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("     , A.UPD_USR_ID = 'ERP'" ).append("\n"); 
		query.append(" WHERE A.AR_IF_NO = (SELECT CASE WHEN LENGTH(@[if_no]) = 11 THEN" ).append("\n"); 
		query.append("                                    @[if_no]" ).append("\n"); 
		query.append("                               ELSE " ).append("\n"); 
		query.append("                                    CASE WHEN SUBSTR(TRIM(@[if_no]), 4, 1) > '9' THEN" ).append("\n"); 
		query.append("                                              SUBSTR(TRIM(@[if_no]),1,4) " ).append("\n"); 
		query.append("                                              || DECODE(SUBSTR(TRIM(@[if_no]), 4, 1), 'M', DECODE(SUBSTR(TRIM(@[if_no]),5,1),'0','1','0'),'0')" ).append("\n"); 
		query.append("                                              || SUBSTR(TRIM(@[if_no]), 5, 10)" ).append("\n"); 
		query.append("                                         ELSE" ).append("\n"); 
		query.append("                                              SUBSTR(TRIM(@[if_no]),1,3) || '0' || SUBSTR(TRIM(@[if_no]), 4, 10)" ).append("\n"); 
		query.append("                                         END    " ).append("\n"); 
		query.append("                               END    " ).append("\n"); 
		query.append("                     FROM DUAL)" ).append("\n"); 
		query.append("   AND A.AR_IF_SER_NO = @[if_ser]" ).append("\n"); 

	}
}