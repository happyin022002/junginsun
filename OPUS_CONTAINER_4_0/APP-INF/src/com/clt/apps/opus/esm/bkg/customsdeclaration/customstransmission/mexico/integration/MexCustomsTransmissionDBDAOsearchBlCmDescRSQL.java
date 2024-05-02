/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchBlCmDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.21 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchBlCmDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0370, outVO : MxCmDescVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchBlCmDescRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mex.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchBlCmDescRSQL").append("\n"); 
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
		query.append("-- '??'은 자료가 나오지 않는 문제가 발생 ( 2007.10.15 ) - Kim YC" ).append("\n"); 
		query.append("replace(replace(replace(CSTMS_DESC,'?','?'||'?'), CHR(39),'?'||CHR(39)), ':','?:') CSTMS_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BL_DOC" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}