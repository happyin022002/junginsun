/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiSndrByKlnettcsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiSndrByKlnettcsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiSndrByKlnettcsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiSndrByKlnettcsRSQL").append("\n"); 
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
		query.append("SELECT NVL(EDI_SND_ID, 'OPUSPL010')" ).append("\n"); 
		query.append("FROM   BKG_EDI_YD" ).append("\n"); 
		query.append("WHERE  EDI_RCV_ID = @[edi_receive_id]" ).append("\n"); 
		query.append("   AND PORT_CD = (SELECT POL_CD" ).append("\n"); 
		query.append("                  FROM   BKG_BOOKING" ).append("\n"); 
		query.append("                  WHERE  BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}