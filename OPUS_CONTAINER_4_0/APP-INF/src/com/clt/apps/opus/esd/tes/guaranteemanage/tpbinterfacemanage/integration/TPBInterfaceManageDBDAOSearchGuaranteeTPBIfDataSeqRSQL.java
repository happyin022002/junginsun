/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBInterfaceManageDBDAOSearchGuaranteeTPBIfDataSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.11.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBInterfaceManageDBDAOSearchGuaranteeTPBIfDataSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee TPB I/F Max Seq 조회
	  * </pre>
	  */
	public TPBInterfaceManageDBDAOSearchGuaranteeTPBIfDataSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.integration").append("\n"); 
		query.append("FileName : TPBInterfaceManageDBDAOSearchGuaranteeTPBIfDataSeqRSQL").append("\n"); 
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
		query.append("SELECT	TO_NUMBER(NVL(MAX(TML_IF_SEQ), '0')) + 1  MAX_SEQ" ).append("\n"); 
		query.append("FROM	TES_N3RD_PTY_IF" ).append("\n"); 
		query.append("WHERE	TML_IF_OFC_CD	= @[tml_if_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}