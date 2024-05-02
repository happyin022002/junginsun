/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeManageDBDAOSearchUSGuaranteeCntrListSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.21 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeManageDBDAOSearchUSGuaranteeCntrListSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container List Max Sequence Select
	  * </pre>
	  */
	public GuaranteeManageDBDAOSearchUSGuaranteeCntrListSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration").append("\n"); 
		query.append("FileName : GuaranteeManageDBDAOSearchUSGuaranteeCntrListSeqRSQL").append("\n"); 
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
		query.append("SELECT	NVL(MAX(TML_GNTE_CNTR_LIST_SEQ), 0) + 1 SEQ" ).append("\n"); 
		query.append("FROM	TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("WHERE	GL.GNTE_NO	= @[gnte_no]" ).append("\n"); 

	}
}