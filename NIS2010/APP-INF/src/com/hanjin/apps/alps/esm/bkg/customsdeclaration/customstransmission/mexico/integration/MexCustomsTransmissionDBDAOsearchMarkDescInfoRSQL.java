/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchMarkDescInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.22 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchMarkDescInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0370, MxMndDescInfoVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchMarkDescInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mex.integration ").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchMarkDescInfoRSQL").append("\n"); 
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
		query.append("REPLACE(REPLACE(REPLACE(CMDT_DESC,'*','-'), chr(13)||chr(13),chr(13)), chr(10)||chr(10), chr(10)) CMDT_DESC" ).append("\n"); 
		query.append(",REPLACE(REPLACE(REPLACE(MK_DESC,'*','-'), chr(13)||chr(13),chr(13)), chr(10)||chr(10), chr(10)) MK_MARK" ).append("\n"); 
		query.append("FROM  BKG_BL_MK_DESC" ).append("\n"); 
		query.append("WHERE  BKG_NO         =   @[bkg_no]" ).append("\n"); 

	}
}