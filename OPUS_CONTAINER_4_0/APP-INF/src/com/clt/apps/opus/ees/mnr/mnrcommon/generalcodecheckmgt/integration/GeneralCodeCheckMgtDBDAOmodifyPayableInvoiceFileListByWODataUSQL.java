/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWODataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.12.15 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HamHyungSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWODataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWODataUSQL
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWODataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWODataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET INP_MSG4 = 'NW'" ).append("\n"); 
		query.append("WHERE TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND NOT EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR B" ).append("\n"); 
		query.append("WHERE SUBSTR(A.INP_MSG1,1,3) = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND SUBSTR(A.INP_MSG1,4) = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}