/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOEmptyModifySingleTrsCombineSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2009.08.18 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN DONG IL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOEmptyModifySingleTrsCombineSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * f_cmd : MODIFY
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOEmptyModifySingleTrsCombineSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration ").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOEmptyModifySingleTrsCombineSeqRSQL").append("\n"); 
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
		query.append("SELECT trs_trsp_svc_ord_seq2.NEXTVAL cmb_seq" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}