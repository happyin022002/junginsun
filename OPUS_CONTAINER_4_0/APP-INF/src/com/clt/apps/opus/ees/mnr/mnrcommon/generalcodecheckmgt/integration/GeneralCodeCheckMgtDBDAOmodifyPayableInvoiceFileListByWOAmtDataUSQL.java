/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWOAmtDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.05.10 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWOAmtDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWOAmtDataUSQL
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWOAmtDataUSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWOAmtDataUSQL").append("\n"); 
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
		query.append("SET INP_MSG4 = (SELECT DECODE(A.INP_MSG3,B.MNR_WRK_AMT,'SS','UA')" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR B" ).append("\n"); 
		query.append("WHERE SUBSTR(A.INP_MSG1,1,3) = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND SUBSTR(A.INP_MSG1,4) = B.MNR_ORD_SEQ)" ).append("\n"); 
		query.append("WHERE TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND   A.INP_MSG4 = 'SS'" ).append("\n"); 

	}
}