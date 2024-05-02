/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMP_getSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.09.14 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMP_getSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateTES_FILE_IMP_TMP_getSeq
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMP_getSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMP_getSeqRSQL").append("\n"); 
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
		query.append("SELECT	TO_NUMBER(NVL(MAX(TML_SO_TMP_SEQ),'0')) SEQ" ).append("\n"); 
		query.append("FROM 	TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("WHERE	TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 

	}
}