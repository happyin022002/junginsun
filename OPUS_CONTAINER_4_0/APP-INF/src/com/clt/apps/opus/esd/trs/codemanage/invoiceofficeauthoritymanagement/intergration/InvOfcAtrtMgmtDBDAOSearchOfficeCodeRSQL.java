/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvOfcAtrtMgmtDBDAOSearchOfficeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.18
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.11.18 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.intergration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvOfcAtrtMgmtDBDAOSearchOfficeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Office Code 입력시 Office  Code 의 이름을 가져오는 쿼리
	  * </pre>
	  */
	public InvOfcAtrtMgmtDBDAOSearchOfficeCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("row",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.intergration ").append("\n"); 
		query.append("FileName : InvOfcAtrtMgmtDBDAOSearchOfficeCodeRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("OFC_CD AS OFC_CD" ).append("\n"); 
		query.append(",OFC_ENG_NM AS OFC_ENG_NM" ).append("\n"); 
		query.append(",@[row] AS S_ROW" ).append("\n"); 
		query.append("FROM  MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD=@[inv_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}