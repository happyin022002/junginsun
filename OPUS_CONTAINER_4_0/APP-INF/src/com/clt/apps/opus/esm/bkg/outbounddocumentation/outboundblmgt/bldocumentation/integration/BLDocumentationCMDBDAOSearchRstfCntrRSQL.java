/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchRstfCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.30
*@LastModifier : taekyoung kim
*@LastVersion : 1.0
* 2014.07.30 taekyoung kim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author taekyoung kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchRstfCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationCMDBDAOSearchRstfCntrRSQL
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchRstfCntrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchRstfCntrRSQL").append("\n"); 
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
		query.append("SELECT XCH_CNTR_NO FROM CTM_MVMT_XCH" ).append("\n"); 
		query.append("WHERE XCH_CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'Y' FROM CTM_MOVEMENT A WHERE A.CNTR_NO = @[cntr_no] AND BKG_NO = @[bkg_no] AND ROWNUM = 1 )" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}