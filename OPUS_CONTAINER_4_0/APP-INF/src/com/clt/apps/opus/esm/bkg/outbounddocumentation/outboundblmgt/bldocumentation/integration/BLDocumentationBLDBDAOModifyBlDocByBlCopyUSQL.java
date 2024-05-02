/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOModifyBlDocByBlCopyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.09.07 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ilmin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOModifyBlDocByBlCopyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyBlDocByBlCopy
	  * </pre>
	  */
	public BLDocumentationBLDBDAOModifyBlDocByBlCopyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("copy_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOModifyBlDocByBlCopyUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BL_DOC SET" ).append("\n"); 
		query.append("UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("#if ('Y'==${custFlg})" ).append("\n"); 
		query.append(", ORG_CNT_NM = (" ).append("\n"); 
		query.append("SELECT ORG_CNT_NM" ).append("\n"); 
		query.append("FROM BKG_BL_DOC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ('Y'==${descFlg})" ).append("\n"); 
		query.append(", (PCK_CMDT_DESC, CNTR_CMDT_DESC) = (" ).append("\n"); 
		query.append("SELECT PCK_CMDT_DESC, CNTR_CMDT_DESC" ).append("\n"); 
		query.append("FROM BKG_BL_DOC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE BKG_NO = @[copy_bkg_no]" ).append("\n"); 

	}
}