/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOTermQtyRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.22 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOTermQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * sql
	  * </pre>
	  */
	public BLDocumentationCMDBDAOTermQtyRSQL(){
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
		query.append("SELECT BKG_NO" ).append("\n");
		query.append(",      RCV_TERM_CD" ).append("\n");
		query.append(",      OP_CNTR_QTY RCV_CNTR_QTY" ).append("\n");
		query.append(",      DE_TERM_CD" ).append("\n");
		query.append(",      OP_CNTR_QTY DE_CNTR_QTY" ).append("\n");
		query.append("FROM   BKG_QTY_DTL" ).append("\n");
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n");
		query.append("FileName : BLDocumentationCMDBDAOTermQtyRSQL").append("\n");
		query.append("*/").append("\n");
	}
}