/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchMdmLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.09 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchMdmLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMdmLoc
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchMdmLocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchMdmLocRSQL").append("\n"); 
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
		query.append("select conti_cd  v_chkconti" ).append("\n"); 
		query.append("from mdm_location" ).append("\n"); 
		query.append("where loc_cd = substr(@[in_nod_cd],1,5)" ).append("\n"); 

	}
}