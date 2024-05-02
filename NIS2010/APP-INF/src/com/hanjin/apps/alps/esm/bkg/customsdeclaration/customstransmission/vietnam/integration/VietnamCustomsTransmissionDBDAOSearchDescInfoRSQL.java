/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOSearchDescInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamCustomsTransmissionDBDAOSearchDescInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDescInfo
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOSearchDescInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOSearchDescInfoRSQL").append("\n"); 
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
		query.append("SELECT CONCAT(TO_CLOB(BKG_SPCLCHAR_CONV_FNC(B.PCK_CMDT_DESC||B.CNTR_CMDT_DESC, 'Y')) ,BKG_SPCLCHAR_CONV_FNC(DBMS_LOB.SUBSTR(M.CMDT_DESC,4000), 'Y')) AS DESCRIPTION" ).append("\n"); 
		query.append("--BKG_SPCLCHAR_CONV_FNC(SUBSTR(B.PCK_CMDT_DESC||B.CNTR_CMDT_DESC||M.CMDT_DESC, 1, 349), 'Y') DESCRIPTION" ).append("\n"); 
		query.append("-- BKG_SPCLCHAR_CONV_FNC(dbms_lob.substr(m.cmdt_desc, 3999), 'Y') DESCRIPTION" ).append("\n"); 
		query.append("--BKG_SPCLCHAR_CONV_FNC(SUBSTR(M.CMDT_DESC, 1, 70),'Y') DESCRIPTION" ).append("\n"); 
		query.append("FROM BKG_BL_MK_DESC M, BKG_BL_DOC B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   M.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND   B.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}